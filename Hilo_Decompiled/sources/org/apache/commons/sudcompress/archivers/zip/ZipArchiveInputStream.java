package org.apache.commons.sudcompress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.apache.commons.sudcompress.archivers.ArchiveEntry;
import org.apache.commons.sudcompress.archivers.ArchiveInputStream;
import org.apache.commons.sudcompress.archivers.zip.UnsupportedZipFeatureException;
import org.apache.commons.sudcompress.archivers.zip.ZipArchiveEntry;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ZipArchiveInputStream extends ArchiveInputStream {
    private static final int CFH_LEN = 46;
    private static final int LFH_LEN = 30;
    private static final long TWO_EXP_32 = 4294967296L;
    private static final String USE_ZIPFILE_INSTEAD_OF_STREAM_DISCLAIMER = " while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile";
    private boolean allowStoredEntriesWithDataDescriptor;
    private final ByteBuffer buf;
    private boolean closed;
    private CurrentEntry current;
    final String encoding;
    private int entriesRead;
    private boolean hitCentralDirectory;
    private final InputStream in;
    private final Inflater inf;
    private ByteArrayInputStream lastStoredEntry;
    private final byte[] lfhBuf;
    private final byte[] shortBuf;
    private final byte[] skipBuf;
    private final boolean skipSplitSig;
    private final byte[] twoDwordBuf;
    private long uncompressedCount;
    private final boolean useUnicodeExtraFields;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;
    private static final byte[] LFH = ZipLong.LFH_SIG.getBytes();
    private static final byte[] CFH = ZipLong.CFH_SIG.getBytes();
    private static final byte[] DD = ZipLong.DD_SIG.getBytes();
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = {65, 80, 75, 32, 83, 105, 103, 32, 66, 108, 111, 99, 107, 32, 52, 50};
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);

    /* renamed from: org.apache.commons.sudcompress.archivers.zip.ZipArchiveInputStream$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod;

        static {
            int[] iArr = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod = iArr;
            try {
                iArr[ZipMethod.UNSHRINKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class CurrentEntry {
        private long bytesRead;
        private long bytesReadFromStream;
        private final CRC32 crc;
        private final ZipArchiveEntry entry;
        private boolean hasDataDescriptor;
        private InputStream in;
        private boolean usesZip64;

        private CurrentEntry() {
            this.entry = new ZipArchiveEntry();
            this.crc = new CRC32();
        }
    }

    public ZipArchiveInputStream(InputStream inputStream) {
        this(inputStream, "UTF8");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean bufferContainsSignature(ByteArrayOutputStream byteArrayOutputStream, int i, int i2, int i3) {
        int i4;
        boolean z = false;
        int i5 = 0;
        while (!z) {
            int i6 = i + i2;
            if (i5 >= i6 - 4) {
                break;
            }
            byte b = this.buf.array()[i5];
            byte[] bArr = LFH;
            if (b == bArr[0] && this.buf.array()[i5 + 1] == bArr[1]) {
                if (i5 < i3 || this.buf.array()[i5 + 2] != bArr[2] || this.buf.array()[i5 + 3] != bArr[3]) {
                    byte b2 = this.buf.array()[i5];
                    byte[] bArr2 = CFH;
                    if (b2 != bArr2[2] || this.buf.array()[i5 + 3] != bArr2[3]) {
                        byte b3 = this.buf.array()[i5 + 2];
                        byte[] bArr3 = DD;
                        if (b3 == bArr3[2] && this.buf.array()[i5 + 3] == bArr3[3]) {
                            i4 = i5;
                            z = true;
                            if (z) {
                            }
                        } else {
                            i4 = i5;
                            if (z) {
                                pushback(this.buf.array(), i4, i6 - i4);
                                byteArrayOutputStream.write(this.buf.array(), 0, i4);
                                readDataDescriptor();
                            }
                        }
                    }
                }
                i4 = i5 - i3;
                z = true;
                if (z) {
                }
            }
            i5++;
        }
        return z;
    }

    private int cacheBytesRead(ByteArrayOutputStream byteArrayOutputStream, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = (i4 - i3) - 3;
        if (i5 > 0) {
            byteArrayOutputStream.write(this.buf.array(), 0, i5);
            int i6 = i3 + 3;
            System.arraycopy(this.buf.array(), i5, this.buf.array(), 0, i6);
            return i6;
        }
        return i4;
    }

    private static boolean checksig(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void closeEntry() {
        long j;
        if (!this.closed) {
            if (this.current == null) {
                return;
            }
            if (currentEntryHasOutstandingBytes()) {
                drainCurrentEntryData();
            } else {
                skip(Long.MAX_VALUE);
                if (this.current.entry.getMethod() != 8) {
                    j = this.current.bytesRead;
                } else {
                    j = getBytesInflated();
                }
                int i = (int) (this.current.bytesReadFromStream - j);
                if (i > 0) {
                    pushback(this.buf.array(), this.buf.limit() - i, i);
                    this.current.bytesReadFromStream -= i;
                }
                if (currentEntryHasOutstandingBytes()) {
                    drainCurrentEntryData();
                }
            }
            if (this.lastStoredEntry == null && this.current.hasDataDescriptor) {
                readDataDescriptor();
            }
            this.inf.reset();
            this.buf.clear().flip();
            this.current = null;
            this.lastStoredEntry = null;
            return;
        }
        throw new IOException("The stream is closed");
    }

    private boolean currentEntryHasOutstandingBytes() {
        CurrentEntry currentEntry = this.current;
        if (currentEntry.bytesReadFromStream <= currentEntry.entry.getCompressedSize() && !this.current.hasDataDescriptor) {
            return true;
        }
        return false;
    }

    private void drainCurrentEntryData() {
        long compressedSize = this.current.entry.getCompressedSize() - this.current.bytesReadFromStream;
        while (compressedSize > 0) {
            long read = this.in.read(this.buf.array(), 0, (int) Math.min(this.buf.capacity(), compressedSize));
            if (read >= 0) {
                count(read);
                compressedSize -= read;
            } else {
                throw new EOFException("Truncated ZIP entry: " + k0.j.a(this.current.entry.getName()));
            }
        }
    }

    private int fill() {
        if (!this.closed) {
            int read = this.in.read(this.buf.array());
            if (read > 0) {
                this.buf.limit(read);
                count(this.buf.limit());
                this.inf.setInput(this.buf.array(), 0, this.buf.limit());
            }
            return read;
        }
        throw new IOException("The stream is closed");
    }

    private void findEocdRecord() {
        boolean z = false;
        int i = -1;
        while (true) {
            if (!z) {
                i = readOneByte();
                if (i <= -1) {
                    return;
                }
            }
            if (!isFirstByteOfEocdSig(i)) {
                z = false;
            } else {
                i = readOneByte();
                byte[] bArr = ZipArchiveOutputStream.EOCD_SIG;
                if (i != bArr[1]) {
                    if (i != -1) {
                        z = isFirstByteOfEocdSig(i);
                    } else {
                        return;
                    }
                } else {
                    i = readOneByte();
                    if (i != bArr[2]) {
                        if (i != -1) {
                            z = isFirstByteOfEocdSig(i);
                        } else {
                            return;
                        }
                    } else {
                        i = readOneByte();
                        if (i != -1 && i != bArr[3]) {
                            z = isFirstByteOfEocdSig(i);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private long getBytesInflated() {
        long bytesRead = this.inf.getBytesRead();
        if (this.current.bytesReadFromStream >= TWO_EXP_32) {
            while (true) {
                long j = bytesRead + TWO_EXP_32;
                if (j > this.current.bytesReadFromStream) {
                    break;
                }
                bytesRead = j;
            }
        }
        return bytesRead;
    }

    private boolean isApkSigningBlock(byte[] bArr) {
        BigInteger value = ZipEightByteInteger.getValue(bArr);
        long length = 8 - bArr.length;
        byte[] bArr2 = APK_SIGNING_BLOCK_MAGIC;
        BigInteger add = value.add(BigInteger.valueOf(length - bArr2.length));
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2];
        try {
            if (add.signum() < 0) {
                int length3 = bArr.length + add.intValue();
                if (length3 < 8) {
                    return false;
                }
                int abs = Math.abs(add.intValue());
                System.arraycopy(bArr, length3, bArr3, 0, Math.min(abs, length2));
                if (abs < length2) {
                    readFully(bArr3, abs);
                }
            } else {
                while (true) {
                    BigInteger bigInteger = LONG_MAX;
                    if (add.compareTo(bigInteger) <= 0) {
                        break;
                    }
                    realSkip(Long.MAX_VALUE);
                    add = add.add(bigInteger.negate());
                }
                realSkip(add.longValue());
                readFully(bArr3);
            }
            return Arrays.equals(bArr3, APK_SIGNING_BLOCK_MAGIC);
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean isFirstByteOfEocdSig(int i) {
        if (i != ZipArchiveOutputStream.EOCD_SIG[0]) {
            return false;
        }
        return true;
    }

    public static boolean matches(byte[] bArr, int i) {
        byte[] bArr2 = ZipArchiveOutputStream.LFH_SIG;
        if (i < bArr2.length) {
            return false;
        }
        if (!checksig(bArr, bArr2) && !checksig(bArr, ZipArchiveOutputStream.EOCD_SIG) && !checksig(bArr, ZipArchiveOutputStream.DD_SIG) && !checksig(bArr, ZipLong.SINGLE_SEGMENT_SPLIT_MARKER.getBytes())) {
            return false;
        }
        return true;
    }

    private void processZip64Extra(ZipLong zipLong, ZipLong zipLong2) {
        boolean z;
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) this.current.entry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        CurrentEntry currentEntry = this.current;
        if (zip64ExtendedInformationExtraField != null) {
            z = true;
        } else {
            z = false;
        }
        currentEntry.usesZip64 = z;
        if (!currentEntry.hasDataDescriptor) {
            if (zip64ExtendedInformationExtraField != null) {
                ZipLong zipLong3 = ZipLong.ZIP64_MAGIC;
                if (zipLong3.equals(zipLong2) || zipLong3.equals(zipLong)) {
                    this.current.entry.setCompressedSize(zip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
                    this.current.entry.setSize(zip64ExtendedInformationExtraField.getSize().getLongValue());
                    return;
                }
            }
            if (zipLong2 != null && zipLong != null) {
                this.current.entry.setCompressedSize(zipLong2.getValue());
                this.current.entry.setSize(zipLong.getValue());
            }
        }
    }

    private void pushback(byte[] bArr, int i, int i2) {
        ((PushbackInputStream) this.in).unread(bArr, i, i2);
        pushedBackBytes(i2);
    }

    private void readDataDescriptor() {
        readFully(this.wordBuf);
        ZipLong zipLong = new ZipLong(this.wordBuf);
        if (ZipLong.DD_SIG.equals(zipLong)) {
            readFully(this.wordBuf);
            zipLong = new ZipLong(this.wordBuf);
        }
        this.current.entry.setCrc(zipLong.getValue());
        readFully(this.twoDwordBuf);
        ZipLong zipLong2 = new ZipLong(this.twoDwordBuf, 8);
        if (!zipLong2.equals(ZipLong.CFH_SIG) && !zipLong2.equals(ZipLong.LFH_SIG)) {
            this.current.entry.setCompressedSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf));
            this.current.entry.setSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf, 8));
        } else {
            pushback(this.twoDwordBuf, 8, 8);
            this.current.entry.setCompressedSize(ZipLong.getValue(this.twoDwordBuf));
            this.current.entry.setSize(ZipLong.getValue(this.twoDwordBuf, 4));
        }
    }

    private int readDeflated(byte[] bArr, int i, int i2) {
        int readFromInflater = readFromInflater(bArr, i, i2);
        if (readFromInflater <= 0) {
            if (this.inf.finished()) {
                return -1;
            }
            if (!this.inf.needsDictionary()) {
                if (readFromInflater == -1) {
                    throw new IOException("Truncated ZIP file");
                }
            } else {
                throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
            }
        }
        return readFromInflater;
    }

    private void readFirstLocalFileHeader(byte[] bArr) {
        readFully(bArr);
        ZipLong zipLong = new ZipLong(bArr);
        if (!this.skipSplitSig && zipLong.equals(ZipLong.DD_SIG)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.SPLITTING);
        }
        if (!zipLong.equals(ZipLong.SINGLE_SEGMENT_SPLIT_MARKER) && !zipLong.equals(ZipLong.DD_SIG)) {
            return;
        }
        byte[] bArr2 = new byte[4];
        readFully(bArr2);
        System.arraycopy(bArr, 4, bArr, 0, 26);
        System.arraycopy(bArr2, 0, bArr, 26, 4);
    }

    private int readFromInflater(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            if (this.inf.needsInput()) {
                int fill = fill();
                if (fill > 0) {
                    this.current.bytesReadFromStream += this.buf.limit();
                } else {
                    if (fill == -1) {
                        return -1;
                    }
                    return i3;
                }
            }
            try {
                i3 = this.inf.inflate(bArr, i, i2);
                if (i3 != 0) {
                    break;
                }
            } catch (DataFormatException e) {
                throw ((IOException) new ZipException(e.getMessage()).initCause(e));
            }
        } while (this.inf.needsInput());
        return i3;
    }

    private void readFully(byte[] bArr) {
        readFully(bArr, 0);
    }

    private int readOneByte() {
        int read = this.in.read();
        if (read != -1) {
            count(1);
        }
        return read;
    }

    private int readStored(byte[] bArr, int i, int i2) {
        CurrentEntry currentEntry = this.current;
        if (currentEntry.hasDataDescriptor) {
            if (this.lastStoredEntry == null) {
                readStoredEntry();
            }
            return this.lastStoredEntry.read(bArr, i, i2);
        }
        long size = currentEntry.entry.getSize();
        if (this.current.bytesRead >= size) {
            return -1;
        }
        if (this.buf.position() >= this.buf.limit()) {
            this.buf.position(0);
            int read = this.in.read(this.buf.array());
            if (read != -1) {
                this.buf.limit(read);
                count(read);
                this.current.bytesReadFromStream += read;
            } else {
                this.buf.limit(0);
                throw new IOException("Truncated ZIP file");
            }
        }
        int min = Math.min(this.buf.remaining(), i2);
        long j = size - this.current.bytesRead;
        if (j < min) {
            min = (int) j;
        }
        this.buf.get(bArr, i, min);
        this.current.bytesRead += min;
        return min;
    }

    private void readStoredEntry() {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        if (this.current.usesZip64) {
            i = 20;
        } else {
            i = 12;
        }
        int i2 = 0;
        while (!z) {
            int read = this.in.read(this.buf.array(), i2, 512 - i2);
            if (read > 0) {
                int i3 = read + i2;
                if (i3 < 4) {
                    i2 = i3;
                } else {
                    z = bufferContainsSignature(byteArrayOutputStream, i2, read, i);
                    if (!z) {
                        i2 = cacheBytesRead(byteArrayOutputStream, i2, read, i);
                    }
                }
            } else {
                throw new IOException("Truncated ZIP file");
            }
        }
        if (this.current.entry.getCompressedSize() == this.current.entry.getSize()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length == this.current.entry.getSize()) {
                this.lastStoredEntry = new ByteArrayInputStream(byteArray);
                return;
            }
            throw new ZipException("actual and claimed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        throw new ZipException("compressed and uncompressed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
    }

    private void realSkip(long j) {
        long j2 = 0;
        if (j >= 0) {
            while (j2 < j) {
                long j3 = j - j2;
                InputStream inputStream = this.in;
                byte[] bArr = this.skipBuf;
                if (bArr.length <= j3) {
                    j3 = bArr.length;
                }
                int read = inputStream.read(bArr, 0, (int) j3);
                if (read != -1) {
                    count(read);
                    j2 += read;
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private void skipRemainderOfArchive() {
        realSkip((this.entriesRead * 46) - 30);
        findEocdRecord();
        realSkip(16L);
        readFully(this.shortBuf);
        realSkip(ZipShort.getValue(this.shortBuf));
    }

    private boolean supportsCompressedSizeFor(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getCompressedSize() == -1 && zipArchiveEntry.getMethod() != 8 && zipArchiveEntry.getMethod() != ZipMethod.ENHANCED_DEFLATED.getCode()) {
            if (!zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() || !this.allowStoredEntriesWithDataDescriptor || zipArchiveEntry.getMethod() != 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean supportsDataDescriptorFor(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor()) {
            if ((!this.allowStoredEntriesWithDataDescriptor || zipArchiveEntry.getMethod() != 0) && zipArchiveEntry.getMethod() != 8 && zipArchiveEntry.getMethod() != ZipMethod.ENHANCED_DEFLATED.getCode()) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // org.apache.commons.sudcompress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (archiveEntry instanceof ZipArchiveEntry) {
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
            if (ZipUtil.canHandleEntryData(zipArchiveEntry) && supportsDataDescriptorFor(zipArchiveEntry) && supportsCompressedSizeFor(zipArchiveEntry)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.closed = true;
            try {
                this.in.close();
            } finally {
                this.inf.end();
            }
        }
    }

    public long getCompressedCount() {
        if (this.current.entry.getMethod() == 0) {
            return this.current.bytesRead;
        }
        if (this.current.entry.getMethod() == 8) {
            return getBytesInflated();
        }
        if (this.current.entry.getMethod() == ZipMethod.UNSHRINKING.getCode()) {
            return ((UnshrinkingInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.IMPLODING.getCode()) {
            return ((ExplodingInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) {
            return this.current.in.c;
        }
        if (this.current.entry.getMethod() == ZipMethod.BZIP2.getCode()) {
            return this.current.in.g.getBytesRead();
        }
        return -1L;
    }

    @Override // org.apache.commons.sudcompress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() {
        return getNextZipEntry();
    }

    public ZipArchiveEntry getNextZipEntry() {
        boolean z;
        ZipLong zipLong;
        ZipLong zipLong2;
        this.uncompressedCount = 0L;
        if (!this.closed && !this.hitCentralDirectory) {
            if (this.current != null) {
                closeEntry();
                z = false;
            } else {
                z = true;
            }
            long bytesRead = getBytesRead();
            try {
                if (z) {
                    readFirstLocalFileHeader(this.lfhBuf);
                } else {
                    readFully(this.lfhBuf);
                }
                ZipLong zipLong3 = new ZipLong(this.lfhBuf);
                if (!zipLong3.equals(ZipLong.LFH_SIG)) {
                    if (!zipLong3.equals(ZipLong.CFH_SIG) && !zipLong3.equals(ZipLong.AED_SIG) && !isApkSigningBlock(this.lfhBuf)) {
                        throw new ZipException(String.format("Unexpected record signature: 0X%X", Long.valueOf(zipLong3.getValue())));
                    }
                    this.hitCentralDirectory = true;
                    skipRemainderOfArchive();
                    return null;
                }
                this.current = new CurrentEntry();
                this.current.entry.setPlatform((ZipShort.getValue(this.lfhBuf, 4) >> 8) & 15);
                GeneralPurposeBit parse = GeneralPurposeBit.parse(this.lfhBuf, 6);
                boolean usesUTF8ForNames = parse.usesUTF8ForNames();
                ZipEncoding zipEncoding = usesUTF8ForNames ? ZipEncodingHelper.UTF8_ZIP_ENCODING : this.zipEncoding;
                this.current.hasDataDescriptor = parse.usesDataDescriptor();
                this.current.entry.setGeneralPurposeBit(parse);
                this.current.entry.setMethod(ZipShort.getValue(this.lfhBuf, 8));
                this.current.entry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.lfhBuf, 10)));
                CurrentEntry currentEntry = this.current;
                if (currentEntry.hasDataDescriptor) {
                    zipLong = null;
                    zipLong2 = null;
                } else {
                    currentEntry.entry.setCrc(ZipLong.getValue(this.lfhBuf, 14));
                    zipLong = new ZipLong(this.lfhBuf, 18);
                    zipLong2 = new ZipLong(this.lfhBuf, 22);
                }
                int value = ZipShort.getValue(this.lfhBuf, 26);
                int value2 = ZipShort.getValue(this.lfhBuf, 28);
                byte[] bArr = new byte[value];
                readFully(bArr);
                this.current.entry.setName(zipEncoding.decode(bArr), bArr);
                if (usesUTF8ForNames) {
                    this.current.entry.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
                }
                byte[] bArr2 = new byte[value2];
                readFully(bArr2);
                this.current.entry.setExtra(bArr2);
                if (!usesUTF8ForNames && this.useUnicodeExtraFields) {
                    ZipUtil.setNameAndCommentFromExtraFields(this.current.entry, bArr, null);
                }
                processZip64Extra(zipLong2, zipLong);
                this.current.entry.setLocalHeaderOffset(bytesRead);
                this.current.entry.setDataOffset(getBytesRead());
                this.current.entry.setStreamContiguous(true);
                ZipMethod methodByCode = ZipMethod.getMethodByCode(this.current.entry.getMethod());
                if (this.current.entry.getCompressedSize() != -1) {
                    if (ZipUtil.canHandleEntryData(this.current.entry) && methodByCode != ZipMethod.STORED && methodByCode != ZipMethod.DEFLATED) {
                        BoundedInputStream boundedInputStream = new BoundedInputStream(this.in, this.current.entry.getCompressedSize());
                        int i = AnonymousClass1.$SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[methodByCode.ordinal()];
                        if (i == 1) {
                            this.current.in = new UnshrinkingInputStream(boundedInputStream);
                        } else if (i == 2) {
                            CurrentEntry currentEntry2 = this.current;
                            currentEntry2.in = new ExplodingInputStream(currentEntry2.entry.getGeneralPurposeBit().getSlidingDictionarySize(), this.current.entry.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), boundedInputStream);
                        } else if (i == 3) {
                            this.current.in = new a0.c(boundedInputStream);
                        } else if (i == 4) {
                            this.current.in = new b0.c(boundedInputStream);
                        }
                    }
                } else if (methodByCode == ZipMethod.ENHANCED_DEFLATED) {
                    this.current.in = new b0.c(this.in);
                }
                this.entriesRead++;
                return this.current.entry;
            } catch (EOFException unused) {
            }
        }
        return null;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read;
        if (i2 == 0) {
            return 0;
        }
        if (!this.closed) {
            CurrentEntry currentEntry = this.current;
            if (currentEntry == null) {
                return -1;
            }
            if (i <= bArr.length && i2 >= 0 && i >= 0 && bArr.length - i >= i2) {
                ZipUtil.checkRequestedFeatures(currentEntry.entry);
                if (supportsDataDescriptorFor(this.current.entry)) {
                    if (supportsCompressedSizeFor(this.current.entry)) {
                        if (this.current.entry.getMethod() == 0) {
                            read = readStored(bArr, i, i2);
                        } else if (this.current.entry.getMethod() == 8) {
                            read = readDeflated(bArr, i, i2);
                        } else {
                            if (this.current.entry.getMethod() != ZipMethod.UNSHRINKING.getCode() && this.current.entry.getMethod() != ZipMethod.IMPLODING.getCode() && this.current.entry.getMethod() != ZipMethod.ENHANCED_DEFLATED.getCode() && this.current.entry.getMethod() != ZipMethod.BZIP2.getCode()) {
                                throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(this.current.entry.getMethod()), this.current.entry);
                            }
                            read = this.current.in.read(bArr, i, i2);
                        }
                        if (read >= 0) {
                            this.current.crc.update(bArr, i, read);
                            this.uncompressedCount += read;
                        }
                        return read;
                    }
                    throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.UNKNOWN_COMPRESSED_SIZE, this.current.entry);
                }
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.DATA_DESCRIPTOR, this.current.entry);
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IOException("The stream is closed");
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        long j2 = 0;
        if (j >= 0) {
            while (j2 < j) {
                long j3 = j - j2;
                byte[] bArr = this.skipBuf;
                if (bArr.length <= j3) {
                    j3 = bArr.length;
                }
                int read = read(bArr, 0, (int) j3);
                if (read == -1) {
                    break;
                }
                j2 += read;
            }
            return j2;
        }
        throw new IllegalArgumentException();
    }

    public ZipArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, str, true);
    }

    private void readFully(byte[] bArr, int i) {
        int length = bArr.length - i;
        int a = k0.a.a(this.in, bArr, i, length);
        count(a);
        if (a < length) {
            throw new EOFException();
        }
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z) {
        this(inputStream, str, z, false);
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z, boolean z2) {
        this(inputStream, str, z, z2, false);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class BoundedInputStream extends InputStream {
        private final InputStream in;
        private final long max;
        private long pos = 0;

        public BoundedInputStream(InputStream inputStream, long j) {
            this.max = j;
            this.in = inputStream;
        }

        @Override // java.io.InputStream
        public int available() {
            long j = this.max;
            if (j >= 0 && this.pos >= j) {
                return 0;
            }
            return this.in.available();
        }

        @Override // java.io.InputStream
        public int read() {
            long j = this.max;
            if (j >= 0 && this.pos >= j) {
                return -1;
            }
            int read = this.in.read();
            this.pos++;
            ZipArchiveInputStream.this.count(1);
            ZipArchiveInputStream.this.current.bytesReadFromStream++;
            return read;
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            long j2 = this.max;
            if (j2 >= 0) {
                j = Math.min(j, j2 - this.pos);
            }
            long b = k0.a.b(this.in, j);
            this.pos += b;
            return b;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            long j = this.max;
            if (j >= 0 && this.pos >= j) {
                return -1;
            }
            int read = this.in.read(bArr, i, (int) (j >= 0 ? Math.min(i2, j - this.pos) : i2));
            if (read == -1) {
                return -1;
            }
            long j2 = read;
            this.pos += j2;
            ZipArchiveInputStream.this.count(read);
            ZipArchiveInputStream.this.current.bytesReadFromStream += j2;
            return read;
        }
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z, boolean z2, boolean z3) {
        this.inf = new Inflater(true);
        ByteBuffer allocate = ByteBuffer.allocate(512);
        this.buf = allocate;
        this.current = null;
        this.closed = false;
        this.hitCentralDirectory = false;
        this.lastStoredEntry = null;
        this.allowStoredEntriesWithDataDescriptor = false;
        this.uncompressedCount = 0L;
        this.lfhBuf = new byte[30];
        this.skipBuf = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
        this.shortBuf = new byte[2];
        this.wordBuf = new byte[4];
        this.twoDwordBuf = new byte[16];
        this.entriesRead = 0;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.useUnicodeExtraFields = z;
        this.in = new PushbackInputStream(inputStream, allocate.capacity());
        this.allowStoredEntriesWithDataDescriptor = z2;
        this.skipSplitSig = z3;
        allocate.limit(0);
    }
}
