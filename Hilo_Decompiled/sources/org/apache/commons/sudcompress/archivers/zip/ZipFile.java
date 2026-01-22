package org.apache.commons.sudcompress.archivers.zip;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import k0.o;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.sudcompress.archivers.zip.ZipArchiveEntry;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ZipFile implements Closeable {
    static final int BYTE_SHIFT = 8;
    private static final int CFD_DISK_OFFSET = 6;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFD_LOCATOR_RELATIVE_OFFSET = 8;
    private static final int CFH_LEN = 42;
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MAX_EOCD_SIZE = 65557;
    static final int MIN_EOCD_SIZE = 22;
    static final int NIBLET_MASK = 15;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int ZIP64_EOCDL_LENGTH = 20;
    private static final int ZIP64_EOCDL_LOCATOR_OFFSET = 8;
    private static final int ZIP64_EOCD_CFD_DISK_OFFSET = 20;
    private static final int ZIP64_EOCD_CFD_LOCATOR_OFFSET = 48;
    private static final int ZIP64_EOCD_CFD_LOCATOR_RELATIVE_OFFSET = 24;
    private final SeekableByteChannel archive;
    private final String archiveName;
    private final ByteBuffer cfhBbuf;
    private final byte[] cfhBuf;
    private volatile boolean closed;
    private final ByteBuffer dwordBbuf;
    private final byte[] dwordBuf;
    private final String encoding;
    private final List<ZipArchiveEntry> entries;
    private final boolean isSplitZipArchive;
    private final Map<String, LinkedList<ZipArchiveEntry>> nameMap;
    private final Comparator<ZipArchiveEntry> offsetComparator;
    private final ByteBuffer shortBbuf;
    private final byte[] shortBuf;
    private final boolean useUnicodeExtraFields;
    private final ByteBuffer wordBbuf;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;
    private static final byte[] ONE_ZERO_BYTE = new byte[1];
    private static final long CFH_SIG = ZipLong.getValue(ZipArchiveOutputStream.CFH_SIG);

    /* renamed from: org.apache.commons.sudcompress.archivers.zip.ZipFile$3, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod;

        static {
            int[] iArr = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod = iArr;
            try {
                iArr[ZipMethod.STORED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.UNSHRINKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.DEFLATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.AES_ENCRYPTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_1.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_2.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_3.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_4.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.JPEG.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.LZMA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.PKWARE_IMPLODING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.PPMD.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.TOKENIZATION.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.UNKNOWN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.WAVPACK.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.XZ.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class BoundedFileChannelInputStream extends BoundedInputStream {
        private final FileChannel archive;

        public BoundedFileChannelInputStream(long j, long j2) {
            super(j, j2);
            this.archive = (FileChannel) ZipFile.this.archive;
        }

        @Override // org.apache.commons.sudcompress.archivers.zip.ZipFile.BoundedInputStream
        public int read(long j, ByteBuffer byteBuffer) {
            int read = this.archive.read(byteBuffer, j);
            byteBuffer.flip();
            return read;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class Entry extends ZipArchiveEntry {
        @Override // org.apache.commons.sudcompress.archivers.zip.ZipArchiveEntry
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                Entry entry = (Entry) obj;
                if (getLocalHeaderOffset() == entry.getLocalHeaderOffset() && super.getDataOffset() == entry.getDataOffset() && super.getDiskNumberStart() == entry.getDiskNumberStart()) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.apache.commons.sudcompress.archivers.zip.ZipArchiveEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return (super.hashCode() * 3) + ((int) getLocalHeaderOffset()) + ((int) (getLocalHeaderOffset() >> 32));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class NameAndComment {
        private final byte[] comment;
        private final byte[] name;

        private NameAndComment(byte[] bArr, byte[] bArr2) {
            this.name = bArr;
            this.comment = bArr2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class StoredStatisticsStream extends o {
        public StoredStatisticsStream(InputStream inputStream) {
            super(inputStream);
        }

        public long getCompressedCount() {
            return super.getBytesRead();
        }

        public long getUncompressedCount() {
            return getCompressedCount();
        }
    }

    public ZipFile(File file) {
        this(file, "UTF8");
    }

    public static void closeQuietly(ZipFile zipFile) {
        k0.a.c(zipFile);
    }

    private BoundedInputStream createBoundedInputStream(long j, long j2) {
        if (this.archive instanceof FileChannel) {
            return new BoundedFileChannelInputStream(j, j2);
        }
        return new BoundedInputStream(j, j2);
    }

    private void fillNameMap() {
        for (ZipArchiveEntry zipArchiveEntry : this.entries) {
            String name = zipArchiveEntry.getName();
            LinkedList<ZipArchiveEntry> linkedList = this.nameMap.get(name);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.nameMap.put(name, linkedList);
            }
            linkedList.addLast(zipArchiveEntry);
        }
    }

    private long getDataOffset(ZipArchiveEntry zipArchiveEntry) {
        long dataOffset = zipArchiveEntry.getDataOffset();
        if (dataOffset == -1) {
            setDataOffset(zipArchiveEntry);
            return zipArchiveEntry.getDataOffset();
        }
        return dataOffset;
    }

    private Map<ZipArchiveEntry, NameAndComment> populateFromCentralDirectory() {
        HashMap hashMap = new HashMap();
        positionAtCentralDirectory();
        this.wordBbuf.rewind();
        k0.a.d(this.archive, this.wordBbuf);
        long value = ZipLong.getValue(this.wordBuf);
        if (value != CFH_SIG && startsWithLocalFileHeader()) {
            throw new IOException("Central directory is empty, can't expand corrupt archive.");
        }
        while (value == CFH_SIG) {
            readCentralDirectoryEntry(hashMap);
            this.wordBbuf.rewind();
            k0.a.d(this.archive, this.wordBbuf);
            value = ZipLong.getValue(this.wordBuf);
        }
        return hashMap;
    }

    private void positionAtCentralDirectory() {
        boolean z;
        positionAtEndOfCentralDirectoryRecord();
        boolean z2 = false;
        if (k0.f.a(this.archive) > 20) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            SeekableByteChannel seekableByteChannel = this.archive;
            k0.g.a(seekableByteChannel, k0.f.a(seekableByteChannel) - 20);
            this.wordBbuf.rewind();
            k0.a.d(this.archive, this.wordBbuf);
            z2 = Arrays.equals(ZipArchiveOutputStream.ZIP64_EOCD_LOC_SIG, this.wordBuf);
        }
        if (!z2) {
            if (z) {
                skipBytes(16);
            }
            positionAtCentralDirectory32();
            return;
        }
        positionAtCentralDirectory64();
    }

    private void positionAtCentralDirectory32() {
        if (this.isSplitZipArchive) {
            skipBytes(6);
            this.shortBbuf.rewind();
            k0.a.d(this.archive, this.shortBbuf);
            int value = ZipShort.getValue(this.shortBuf);
            skipBytes(8);
            this.wordBbuf.rewind();
            k0.a.d(this.archive, this.wordBbuf);
            ((ZipSplitReadOnlySeekableByteChannel) this.archive).position(value, ZipLong.getValue(this.wordBuf));
            return;
        }
        skipBytes(16);
        this.wordBbuf.rewind();
        k0.a.d(this.archive, this.wordBbuf);
        k0.g.a(this.archive, ZipLong.getValue(this.wordBuf));
    }

    private void positionAtCentralDirectory64() {
        if (this.isSplitZipArchive) {
            this.wordBbuf.rewind();
            k0.a.d(this.archive, this.wordBbuf);
            long value = ZipLong.getValue(this.wordBuf);
            this.dwordBbuf.rewind();
            k0.a.d(this.archive, this.dwordBbuf);
            ((ZipSplitReadOnlySeekableByteChannel) this.archive).position(value, ZipEightByteInteger.getLongValue(this.dwordBuf));
        } else {
            skipBytes(4);
            this.dwordBbuf.rewind();
            k0.a.d(this.archive, this.dwordBbuf);
            k0.g.a(this.archive, ZipEightByteInteger.getLongValue(this.dwordBuf));
        }
        this.wordBbuf.rewind();
        k0.a.d(this.archive, this.wordBbuf);
        if (Arrays.equals(this.wordBuf, ZipArchiveOutputStream.ZIP64_EOCD_SIG)) {
            if (this.isSplitZipArchive) {
                skipBytes(16);
                this.wordBbuf.rewind();
                k0.a.d(this.archive, this.wordBbuf);
                long value2 = ZipLong.getValue(this.wordBuf);
                skipBytes(24);
                this.dwordBbuf.rewind();
                k0.a.d(this.archive, this.dwordBbuf);
                ((ZipSplitReadOnlySeekableByteChannel) this.archive).position(value2, ZipEightByteInteger.getLongValue(this.dwordBuf));
                return;
            }
            skipBytes(44);
            this.dwordBbuf.rewind();
            k0.a.d(this.archive, this.dwordBbuf);
            k0.g.a(this.archive, ZipEightByteInteger.getLongValue(this.dwordBuf));
            return;
        }
        throw new ZipException("Archive's ZIP64 end of central directory locator is corrupt.");
    }

    private void positionAtEndOfCentralDirectoryRecord() {
        if (tryToLocateSignature(22L, 65557L, ZipArchiveOutputStream.EOCD_SIG)) {
        } else {
            throw new ZipException("Archive is not a ZIP archive");
        }
    }

    private void readCentralDirectoryEntry(Map<ZipArchiveEntry, NameAndComment> map) {
        ZipEncoding zipEncoding;
        this.cfhBbuf.rewind();
        k0.a.d(this.archive, this.cfhBbuf);
        Entry entry = new Entry();
        int value = ZipShort.getValue(this.cfhBuf, 0);
        entry.setVersionMadeBy(value);
        entry.setPlatform((value >> 8) & 15);
        entry.setVersionRequired(ZipShort.getValue(this.cfhBuf, 2));
        GeneralPurposeBit parse = GeneralPurposeBit.parse(this.cfhBuf, 4);
        boolean usesUTF8ForNames = parse.usesUTF8ForNames();
        if (usesUTF8ForNames) {
            zipEncoding = ZipEncodingHelper.UTF8_ZIP_ENCODING;
        } else {
            zipEncoding = this.zipEncoding;
        }
        if (usesUTF8ForNames) {
            entry.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
        }
        entry.setGeneralPurposeBit(parse);
        entry.setRawFlag(ZipShort.getValue(this.cfhBuf, 4));
        entry.setMethod(ZipShort.getValue(this.cfhBuf, 6));
        entry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.cfhBuf, 8)));
        entry.setCrc(ZipLong.getValue(this.cfhBuf, 12));
        entry.setCompressedSize(ZipLong.getValue(this.cfhBuf, 16));
        entry.setSize(ZipLong.getValue(this.cfhBuf, 20));
        int value2 = ZipShort.getValue(this.cfhBuf, 24);
        int value3 = ZipShort.getValue(this.cfhBuf, 26);
        int value4 = ZipShort.getValue(this.cfhBuf, 28);
        entry.setDiskNumberStart(ZipShort.getValue(this.cfhBuf, 30));
        entry.setInternalAttributes(ZipShort.getValue(this.cfhBuf, 32));
        entry.setExternalAttributes(ZipLong.getValue(this.cfhBuf, 34));
        byte[] bArr = new byte[value2];
        k0.a.d(this.archive, ByteBuffer.wrap(bArr));
        entry.setName(zipEncoding.decode(bArr), bArr);
        entry.setLocalHeaderOffset(ZipLong.getValue(this.cfhBuf, 38));
        this.entries.add(entry);
        byte[] bArr2 = new byte[value3];
        k0.a.d(this.archive, ByteBuffer.wrap(bArr2));
        entry.setCentralDirectoryExtra(bArr2);
        setSizesAndOffsetFromZip64Extra(entry);
        byte[] bArr3 = new byte[value4];
        k0.a.d(this.archive, ByteBuffer.wrap(bArr3));
        entry.setComment(zipEncoding.decode(bArr3));
        if (!usesUTF8ForNames && this.useUnicodeExtraFields) {
            map.put(entry, new NameAndComment(bArr, bArr3));
        }
        entry.setStreamContiguous(true);
    }

    private void resolveLocalFileHeaderData(Map<ZipArchiveEntry, NameAndComment> map) {
        Iterator<ZipArchiveEntry> it = this.entries.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int[] dataOffset = setDataOffset(entry);
            int i = dataOffset[0];
            int i2 = dataOffset[1];
            skipBytes(i);
            byte[] bArr = new byte[i2];
            k0.a.d(this.archive, ByteBuffer.wrap(bArr));
            entry.setExtra(bArr);
            if (map.containsKey(entry)) {
                NameAndComment nameAndComment = map.get(entry);
                ZipUtil.setNameAndCommentFromExtraFields(entry, nameAndComment.name, nameAndComment.comment);
            }
        }
    }

    private int[] setDataOffset(ZipArchiveEntry zipArchiveEntry) {
        long localHeaderOffset = zipArchiveEntry.getLocalHeaderOffset();
        if (this.isSplitZipArchive) {
            ((ZipSplitReadOnlySeekableByteChannel) this.archive).position(zipArchiveEntry.getDiskNumberStart(), localHeaderOffset + LFH_OFFSET_FOR_FILENAME_LENGTH);
            localHeaderOffset = k0.f.a(this.archive) - LFH_OFFSET_FOR_FILENAME_LENGTH;
        } else {
            k0.g.a(this.archive, LFH_OFFSET_FOR_FILENAME_LENGTH + localHeaderOffset);
        }
        this.wordBbuf.rewind();
        k0.a.d(this.archive, this.wordBbuf);
        this.wordBbuf.flip();
        this.wordBbuf.get(this.shortBuf);
        int value = ZipShort.getValue(this.shortBuf);
        this.wordBbuf.get(this.shortBuf);
        int value2 = ZipShort.getValue(this.shortBuf);
        zipArchiveEntry.setDataOffset(localHeaderOffset + 30 + value + value2);
        return new int[]{value, value2};
    }

    private void setSizesAndOffsetFromZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        boolean z;
        boolean z2;
        boolean z3;
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (zip64ExtendedInformationExtraField != null) {
            boolean z4 = false;
            if (zipArchiveEntry.getSize() == 4294967295L) {
                z = true;
            } else {
                z = false;
            }
            if (zipArchiveEntry.getCompressedSize() == 4294967295L) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (zipArchiveEntry.getLocalHeaderOffset() == 4294967295L) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (zipArchiveEntry.getDiskNumberStart() == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                z4 = true;
            }
            zip64ExtendedInformationExtraField.reparseCentralDirectoryData(z, z2, z3, z4);
            if (z) {
                zipArchiveEntry.setSize(zip64ExtendedInformationExtraField.getSize().getLongValue());
            } else if (z2) {
                zip64ExtendedInformationExtraField.setSize(new ZipEightByteInteger(zipArchiveEntry.getSize()));
            }
            if (z2) {
                zipArchiveEntry.setCompressedSize(zip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
            } else if (z) {
                zip64ExtendedInformationExtraField.setCompressedSize(new ZipEightByteInteger(zipArchiveEntry.getCompressedSize()));
            }
            if (z3) {
                zipArchiveEntry.setLocalHeaderOffset(zip64ExtendedInformationExtraField.getRelativeHeaderOffset().getLongValue());
            }
            if (z4) {
                zipArchiveEntry.setDiskNumberStart(zip64ExtendedInformationExtraField.getDiskStartNumber().getValue());
            }
        }
    }

    private void skipBytes(int i) {
        long a = k0.f.a(this.archive) + i;
        if (a <= k0.d.a(this.archive)) {
            k0.g.a(this.archive, a);
            return;
        }
        throw new EOFException();
    }

    private boolean startsWithLocalFileHeader() {
        k0.g.a(this.archive, 0L);
        this.wordBbuf.rewind();
        k0.a.d(this.archive, this.wordBbuf);
        return Arrays.equals(this.wordBuf, ZipArchiveOutputStream.LFH_SIG);
    }

    private boolean tryToLocateSignature(long j, long j2, byte[] bArr) {
        long a = k0.d.a(this.archive) - j;
        long max = Math.max(0L, k0.d.a(this.archive) - j2);
        boolean z = false;
        if (a >= 0) {
            while (true) {
                if (a < max) {
                    break;
                }
                k0.g.a(this.archive, a);
                try {
                    this.wordBbuf.rewind();
                    k0.a.d(this.archive, this.wordBbuf);
                    this.wordBbuf.flip();
                    if (this.wordBbuf.get() == bArr[0] && this.wordBbuf.get() == bArr[1] && this.wordBbuf.get() == bArr[2] && this.wordBbuf.get() == bArr[3]) {
                        z = true;
                        break;
                    }
                    a--;
                } catch (EOFException unused) {
                }
            }
        }
        if (z) {
            k0.g.a(this.archive, a);
        }
        return z;
    }

    public boolean canReadEntryData(ZipArchiveEntry zipArchiveEntry) {
        return ZipUtil.canHandleEntryData(zipArchiveEntry);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        k0.h.a(this.archive);
    }

    public void copyRawEntries(ZipArchiveOutputStream zipArchiveOutputStream, ZipArchiveEntryPredicate zipArchiveEntryPredicate) {
        Enumeration<ZipArchiveEntry> entriesInPhysicalOrder = getEntriesInPhysicalOrder();
        while (entriesInPhysicalOrder.hasMoreElements()) {
            ZipArchiveEntry nextElement = entriesInPhysicalOrder.nextElement();
            if (zipArchiveEntryPredicate.test(nextElement)) {
                zipArchiveOutputStream.addRawArchiveEntry(nextElement, getRawInputStream(nextElement));
            }
        }
    }

    public void finalize() {
        try {
            if (!this.closed) {
                System.err.println("Cleaning up unclosed ZipFile for archive " + this.archiveName);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Enumeration<ZipArchiveEntry> getEntries() {
        return Collections.enumeration(this.entries);
    }

    public Enumeration<ZipArchiveEntry> getEntriesInPhysicalOrder() {
        List<ZipArchiveEntry> list = this.entries;
        ZipArchiveEntry[] zipArchiveEntryArr = (ZipArchiveEntry[]) list.toArray(new ZipArchiveEntry[list.size()]);
        Arrays.sort(zipArchiveEntryArr, this.offsetComparator);
        return Collections.enumeration(Arrays.asList(zipArchiveEntryArr));
    }

    public ZipArchiveEntry getEntry(String str) {
        LinkedList<ZipArchiveEntry> linkedList = this.nameMap.get(str);
        if (linkedList != null) {
            return linkedList.getFirst();
        }
        return null;
    }

    public InputStream getInputStream(ZipArchiveEntry zipArchiveEntry) {
        if (!(zipArchiveEntry instanceof Entry)) {
            return null;
        }
        ZipUtil.checkRequestedFeatures(zipArchiveEntry);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(createBoundedInputStream(getDataOffset(zipArchiveEntry), zipArchiveEntry.getCompressedSize()));
        switch (AnonymousClass3.$SwitchMap$org$apache$commons$sudcompress$archivers$zip$ZipMethod[ZipMethod.getMethodByCode(zipArchiveEntry.getMethod()).ordinal()]) {
            case 1:
                return new StoredStatisticsStream(bufferedInputStream);
            case 2:
                return new UnshrinkingInputStream(bufferedInputStream);
            case 3:
                return new ExplodingInputStream(zipArchiveEntry.getGeneralPurposeBit().getSlidingDictionarySize(), zipArchiveEntry.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), bufferedInputStream);
            case 4:
                final Inflater inflater = new Inflater(true);
                return new InflaterInputStreamWithStatistics(new SequenceInputStream(bufferedInputStream, new ByteArrayInputStream(ONE_ZERO_BYTE)), inflater) { // from class: org.apache.commons.sudcompress.archivers.zip.ZipFile.1
                    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        try {
                            super.close();
                        } finally {
                            inflater.end();
                        }
                    }
                };
            case 5:
                return new a0.c(bufferedInputStream);
            case 6:
                return new b0.c(bufferedInputStream);
            default:
                throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(zipArchiveEntry.getMethod()), zipArchiveEntry);
        }
    }

    public InputStream getRawInputStream(ZipArchiveEntry zipArchiveEntry) {
        if (!(zipArchiveEntry instanceof Entry)) {
            return null;
        }
        long dataOffset = zipArchiveEntry.getDataOffset();
        if (dataOffset == -1) {
            return null;
        }
        return createBoundedInputStream(dataOffset, zipArchiveEntry.getCompressedSize());
    }

    public String getUnixSymlink(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry != null && zipArchiveEntry.isUnixSymlink()) {
            InputStream inputStream = getInputStream(zipArchiveEntry);
            try {
                ZipEncoding zipEncoding = this.zipEncoding;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 != read) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String decode = zipEncoding.decode(byteArrayOutputStream.toByteArray());
                        inputStream.close();
                        return decode;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } else {
            return null;
        }
    }

    public ZipFile(String str) {
        this(new File(str), "UTF8");
    }

    public Iterable<ZipArchiveEntry> getEntries(String str) {
        LinkedList<ZipArchiveEntry> linkedList = this.nameMap.get(str);
        return linkedList != null ? linkedList : Collections.EMPTY_LIST;
    }

    public ZipFile(String str, String str2) {
        this(new File(str), str2, true);
    }

    public ZipFile(File file, String str) {
        this(file, str, true);
    }

    public Iterable<ZipArchiveEntry> getEntriesInPhysicalOrder(String str) {
        ZipArchiveEntry[] zipArchiveEntryArr = new ZipArchiveEntry[0];
        if (this.nameMap.containsKey(str)) {
            zipArchiveEntryArr = (ZipArchiveEntry[]) this.nameMap.get(str).toArray(zipArchiveEntryArr);
            Arrays.sort(zipArchiveEntryArr, this.offsetComparator);
        }
        return Arrays.asList(zipArchiveEntryArr);
    }

    public ZipFile(File file, String str, boolean z) {
        this(file, str, z, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ZipFile(File file, String str, boolean z, boolean z2) {
        this(r4, file.getAbsolutePath(), str, z, true, z2);
        SeekableByteChannel newByteChannel;
        newByteChannel = Files.newByteChannel(i0.a.a(file), EnumSet.of(okio.c.a()), new FileAttribute[0]);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class BoundedInputStream extends InputStream {
        private final long end;
        private long loc;
        private ByteBuffer singleByteBuffer;

        public BoundedInputStream(long j, long j2) {
            long j3 = j + j2;
            this.end = j3;
            if (j3 >= j) {
                this.loc = j;
                return;
            }
            throw new IllegalArgumentException("Invalid length of stream at offset=" + j + ", length=" + j2);
        }

        @Override // java.io.InputStream
        public synchronized int read() {
            try {
                if (this.loc >= this.end) {
                    return -1;
                }
                ByteBuffer byteBuffer = this.singleByteBuffer;
                if (byteBuffer == null) {
                    this.singleByteBuffer = ByteBuffer.allocate(1);
                } else {
                    byteBuffer.rewind();
                }
                int read = read(this.loc, this.singleByteBuffer);
                if (read < 0) {
                    return read;
                }
                this.loc++;
                return this.singleByteBuffer.get() & 255;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr, int i, int i2) {
            if (i2 <= 0) {
                return 0;
            }
            long j = i2;
            long j2 = this.end;
            long j3 = this.loc;
            long j4 = j2 - j3;
            if (j > j4) {
                if (j3 >= j2) {
                    return -1;
                }
                i2 = (int) j4;
            }
            int read = read(this.loc, ByteBuffer.wrap(bArr, i, i2));
            if (read <= 0) {
                return read;
            }
            this.loc += read;
            return read;
        }

        public int read(long j, ByteBuffer byteBuffer) {
            int a;
            synchronized (ZipFile.this.archive) {
                k0.g.a(ZipFile.this.archive, j);
                a = k0.e.a(ZipFile.this.archive, byteBuffer);
            }
            byteBuffer.flip();
            return a;
        }
    }

    public ZipFile(SeekableByteChannel seekableByteChannel) {
        this(seekableByteChannel, "unknown archive", "UTF8", true);
    }

    public ZipFile(SeekableByteChannel seekableByteChannel, String str) {
        this(seekableByteChannel, "unknown archive", str, true);
    }

    public ZipFile(SeekableByteChannel seekableByteChannel, String str, String str2, boolean z) {
        this(seekableByteChannel, str, str2, z, false, false);
    }

    public ZipFile(SeekableByteChannel seekableByteChannel, String str, String str2, boolean z, boolean z2) {
        this(seekableByteChannel, str, str2, z, false, z2);
    }

    private ZipFile(SeekableByteChannel seekableByteChannel, String str, String str2, boolean z, boolean z2, boolean z3) {
        this.entries = new LinkedList();
        this.nameMap = new HashMap(HASH_SIZE);
        this.closed = true;
        byte[] bArr = new byte[8];
        this.dwordBuf = bArr;
        byte[] bArr2 = new byte[4];
        this.wordBuf = bArr2;
        byte[] bArr3 = new byte[42];
        this.cfhBuf = bArr3;
        byte[] bArr4 = new byte[2];
        this.shortBuf = bArr4;
        this.dwordBbuf = ByteBuffer.wrap(bArr);
        this.wordBbuf = ByteBuffer.wrap(bArr2);
        this.cfhBbuf = ByteBuffer.wrap(bArr3);
        this.shortBbuf = ByteBuffer.wrap(bArr4);
        this.offsetComparator = new Comparator<ZipArchiveEntry>() { // from class: org.apache.commons.sudcompress.archivers.zip.ZipFile.2
            @Override // java.util.Comparator
            public int compare(ZipArchiveEntry zipArchiveEntry, ZipArchiveEntry zipArchiveEntry2) {
                if (zipArchiveEntry == zipArchiveEntry2) {
                    return 0;
                }
                Entry entry = zipArchiveEntry instanceof Entry ? (Entry) zipArchiveEntry : null;
                Entry entry2 = zipArchiveEntry2 instanceof Entry ? (Entry) zipArchiveEntry2 : null;
                if (entry == null) {
                    return 1;
                }
                if (entry2 == null) {
                    return -1;
                }
                long diskNumberStart = entry.getDiskNumberStart() - entry2.getDiskNumberStart();
                if (diskNumberStart != 0) {
                    return diskNumberStart < 0 ? -1 : 1;
                }
                long localHeaderOffset = entry.getLocalHeaderOffset() - entry2.getLocalHeaderOffset();
                if (localHeaderOffset == 0) {
                    return 0;
                }
                return localHeaderOffset < 0 ? -1 : 1;
            }
        };
        this.isSplitZipArchive = seekableByteChannel instanceof ZipSplitReadOnlySeekableByteChannel;
        this.archiveName = str;
        this.encoding = str2;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str2);
        this.useUnicodeExtraFields = z;
        this.archive = seekableByteChannel;
        try {
            Map<ZipArchiveEntry, NameAndComment> populateFromCentralDirectory = populateFromCentralDirectory();
            if (!z3) {
                resolveLocalFileHeaderData(populateFromCentralDirectory);
            }
            fillNameMap();
            this.closed = false;
        } catch (Throwable th) {
            this.closed = true;
            if (z2) {
                k0.a.c(this.archive);
            }
            throw th;
        }
    }
}
