package org.apache.commons.sudcompress.archivers.zip;

import e0.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.sudcompress.archivers.ArchiveEntry;
import org.apache.commons.sudcompress.archivers.Suddo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ZipArchiveOutputStream extends Suddo {
    static final int BUFFER_SIZE = 512;
    private static final int CFH_COMMENT_LENGTH_OFFSET = 32;
    private static final int CFH_COMPRESSED_SIZE_OFFSET = 20;
    private static final int CFH_CRC_OFFSET = 16;
    private static final int CFH_DISK_NUMBER_OFFSET = 34;
    private static final int CFH_EXTERNAL_ATTRIBUTES_OFFSET = 38;
    private static final int CFH_EXTRA_LENGTH_OFFSET = 30;
    private static final int CFH_FILENAME_LENGTH_OFFSET = 28;
    private static final int CFH_FILENAME_OFFSET = 46;
    private static final int CFH_GPB_OFFSET = 8;
    private static final int CFH_INTERNAL_ATTRIBUTES_OFFSET = 36;
    private static final int CFH_LFH_OFFSET = 42;
    private static final int CFH_METHOD_OFFSET = 10;
    private static final int CFH_ORIGINAL_SIZE_OFFSET = 24;
    private static final int CFH_SIG_OFFSET = 0;
    private static final int CFH_TIME_OFFSET = 12;
    private static final int CFH_VERSION_MADE_BY_OFFSET = 4;
    private static final int CFH_VERSION_NEEDED_OFFSET = 6;
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = "UTF8";
    public static final int DEFLATED = 8;

    @Deprecated
    public static final int EFS_FLAG = 2048;
    private static final int LFH_COMPRESSED_SIZE_OFFSET = 18;
    private static final int LFH_CRC_OFFSET = 14;
    private static final int LFH_EXTRA_LENGTH_OFFSET = 28;
    private static final int LFH_FILENAME_LENGTH_OFFSET = 26;
    private static final int LFH_FILENAME_OFFSET = 30;
    private static final int LFH_GPB_OFFSET = 6;
    private static final int LFH_METHOD_OFFSET = 8;
    private static final int LFH_ORIGINAL_SIZE_OFFSET = 22;
    private static final int LFH_SIG_OFFSET = 0;
    private static final int LFH_TIME_OFFSET = 10;
    private static final int LFH_VERSION_NEEDED_OFFSET = 4;
    public static final int STORED = 0;
    private final Calendar calendarInstance;
    private long cdDiskNumberStart;
    private long cdLength;
    private long cdOffset;
    private final SeekableByteChannel channel;
    private String comment;
    private final byte[] copyBuffer;
    private UnicodeExtraFieldPolicy createUnicodeExtraFields;
    protected final Deflater def;
    private String encoding;
    private final List<ZipArchiveEntry> entries;
    private CurrentEntry entry;
    private long eocdLength;
    private boolean fallbackToUTF8;
    protected boolean finished;
    private boolean hasCompressionLevelChanged;
    private boolean hasUsedZip64;
    private final boolean isSplitZip;
    private int level;
    private final Map<ZipArchiveEntry, EntryMetaData> metaData;
    private int method;
    private final Map<Integer, Integer> numberOfCDInDiskData;
    private final OutputStream out;
    private final StreamCompressor streamCompressor;
    private boolean useUTF8Flag;
    private Zip64Mode zip64Mode;
    private ZipEncoding zipEncoding;
    private static final byte[] EMPTY = new byte[0];
    private static final byte[] ZERO = {0, 0};
    private static final byte[] LZERO = {0, 0, 0, 0};
    private static final byte[] ONE = ZipLong.getBytes(1);
    static final byte[] LFH_SIG = ZipLong.LFH_SIG.getBytes();
    static final byte[] DD_SIG = ZipLong.DD_SIG.getBytes();
    static final byte[] CFH_SIG = ZipLong.CFH_SIG.getBytes();
    static final byte[] EOCD_SIG = ZipLong.getBytes(101010256);
    static final byte[] ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
    static final byte[] ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class CurrentEntry {
        private long bytesRead;
        private boolean causedUseOfZip64;
        private long dataStart;
        private final ZipArchiveEntry entry;
        private boolean hasWritten;
        private long localDataStart;

        private CurrentEntry(ZipArchiveEntry zipArchiveEntry) {
            this.localDataStart = 0L;
            this.dataStart = 0L;
            this.bytesRead = 0L;
            this.causedUseOfZip64 = false;
            this.entry = zipArchiveEntry;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class EntryMetaData {
        private final long offset;
        private final boolean usesDataDescriptor;

        private EntryMetaData(long j, boolean z) {
            this.offset = j;
            this.usesDataDescriptor = z;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = new UnicodeExtraFieldPolicy("always");
        public static final UnicodeExtraFieldPolicy NEVER = new UnicodeExtraFieldPolicy("never");
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        private final String name;

        private UnicodeExtraFieldPolicy(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public ZipArchiveOutputStream(OutputStream outputStream) {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.cdDiskNumberStart = 0L;
        this.eocdLength = 0L;
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        this.out = outputStream;
        this.channel = null;
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        this.streamCompressor = StreamCompressor.create(outputStream, deflater);
        this.isSplitZip = false;
    }

    private void addUnicodeExtraFields(ZipArchiveEntry zipArchiveEntry, boolean z, ByteBuffer byteBuffer) {
        UnicodeExtraFieldPolicy unicodeExtraFieldPolicy = this.createUnicodeExtraFields;
        UnicodeExtraFieldPolicy unicodeExtraFieldPolicy2 = UnicodeExtraFieldPolicy.ALWAYS;
        if (unicodeExtraFieldPolicy == unicodeExtraFieldPolicy2 || !z) {
            zipArchiveEntry.addExtraField(new UnicodePathExtraField(zipArchiveEntry.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment = zipArchiveEntry.getComment();
        if (comment != null && !"".equals(comment)) {
            boolean canEncode = this.zipEncoding.canEncode(comment);
            if (this.createUnicodeExtraFields == unicodeExtraFieldPolicy2 || !canEncode) {
                ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment);
                zipArchiveEntry.addExtraField(new UnicodeCommentExtraField(comment, encode.array(), encode.arrayOffset(), encode.limit() - encode.position()));
            }
        }
    }

    private boolean checkIfNeedsZip64(Zip64Mode zip64Mode) {
        boolean isZip64Required = isZip64Required(this.entry.entry, zip64Mode);
        if (isZip64Required && zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
        return isZip64Required;
    }

    private void closeCopiedEntry(boolean z) {
        preClose();
        CurrentEntry currentEntry = this.entry;
        currentEntry.bytesRead = currentEntry.entry.getSize();
        closeEntry(checkIfNeedsZip64(getEffectiveZip64Mode(this.entry.entry)), z);
    }

    private void closeEntry(boolean z, boolean z2) {
        if (!z2 && this.channel != null) {
            rewriteSizesAndCrc(z);
        }
        if (!z2) {
            writeDataDescriptor(this.entry.entry);
        }
        this.entry = null;
    }

    private void copyFromZipInputStream(InputStream inputStream) {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            this.entry.hasWritten = true;
            while (true) {
                int read = inputStream.read(this.copyBuffer);
                if (read >= 0) {
                    this.streamCompressor.writeCounted(this.copyBuffer, 0, read);
                    count(read);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("No current entry");
        }
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry zipArchiveEntry) {
        EntryMetaData entryMetaData = this.metaData.get(zipArchiveEntry);
        boolean z = hasZip64Extra(zipArchiveEntry) || zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L || entryMetaData.offset >= 4294967295L || zipArchiveEntry.getDiskNumberStart() >= WebSocketProtocol.PAYLOAD_SHORT_MAX || this.zip64Mode == Zip64Mode.Always;
        if (!z || this.zip64Mode != Zip64Mode.Never) {
            handleZip64Extra(zipArchiveEntry, entryMetaData.offset, z);
            return createCentralFileHeader(zipArchiveEntry, getName(zipArchiveEntry), entryMetaData, z);
        }
        throw new Zip64RequiredException("Archive's size exceeds the limit of 4GByte.");
    }

    private byte[] createLocalFileHeader(ZipArchiveEntry zipArchiveEntry, ByteBuffer byteBuffer, boolean z, boolean z2, long j) {
        boolean z3;
        ZipShort zipShort = ResourceAlignmentExtraField.ID;
        ResourceAlignmentExtraField resourceAlignmentExtraField = (ResourceAlignmentExtraField) zipArchiveEntry.getExtraField(zipShort);
        if (resourceAlignmentExtraField != null) {
            zipArchiveEntry.removeExtraField(zipShort);
        }
        int alignment = zipArchiveEntry.getAlignment();
        if (alignment <= 0 && resourceAlignmentExtraField != null) {
            alignment = resourceAlignmentExtraField.getAlignment();
        }
        boolean z4 = true;
        if (alignment > 1 || (resourceAlignmentExtraField != null && !resourceAlignmentExtraField.allowMethodChange())) {
            int limit = (int) ((((-j) - (((byteBuffer.limit() + 30) - byteBuffer.position()) + zipArchiveEntry.getLocalFileDataExtra().length)) - 6) & (alignment - 1));
            if (resourceAlignmentExtraField != null && resourceAlignmentExtraField.allowMethodChange()) {
                z3 = true;
            } else {
                z3 = false;
            }
            zipArchiveEntry.addExtraField(new ResourceAlignmentExtraField(alignment, z3, limit));
        }
        byte[] localFileDataExtra = zipArchiveEntry.getLocalFileDataExtra();
        int limit2 = byteBuffer.limit() - byteBuffer.position();
        int i = limit2 + 30;
        byte[] bArr = new byte[localFileDataExtra.length + i];
        System.arraycopy(LFH_SIG, 0, bArr, 0, 4);
        int method = zipArchiveEntry.getMethod();
        boolean usesDataDescriptor = usesDataDescriptor(method, z2);
        ZipShort.putShort(versionNeededToExtract(method, hasZip64Extra(zipArchiveEntry), usesDataDescriptor), bArr, 4);
        if (z || !this.fallbackToUTF8) {
            z4 = false;
        }
        getGeneralPurposeBits(z4, usesDataDescriptor).encode(bArr, 6);
        ZipShort.putShort(method, bArr, 8);
        ZipUtil.toDosTime(this.calendarInstance, zipArchiveEntry.getTime(), bArr, 10);
        if (z2) {
            ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 14);
        } else if (method != 8 && this.channel == null) {
            ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 14);
        } else {
            System.arraycopy(LZERO, 0, bArr, 14, 4);
        }
        if (hasZip64Extra(this.entry.entry)) {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            zipLong.putLong(bArr, 18);
            zipLong.putLong(bArr, 22);
        } else if (z2) {
            ZipLong.putLong(zipArchiveEntry.getCompressedSize(), bArr, 18);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 22);
        } else if (method != 8 && this.channel == null) {
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 18);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 22);
        } else {
            byte[] bArr2 = LZERO;
            System.arraycopy(bArr2, 0, bArr, 18, 4);
            System.arraycopy(bArr2, 0, bArr, 22, 4);
        }
        ZipShort.putShort(limit2, bArr, 26);
        ZipShort.putShort(localFileDataExtra.length, bArr, 28);
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 30, limit2);
        System.arraycopy(localFileDataExtra, 0, bArr, i, localFileDataExtra.length);
        return bArr;
    }

    private void flushDeflater() {
        if (this.entry.entry.getMethod() == 8) {
            this.streamCompressor.flushDeflater();
        }
    }

    private Zip64Mode getEffectiveZip64Mode(ZipArchiveEntry zipArchiveEntry) {
        if (this.zip64Mode == Zip64Mode.AsNeeded && this.channel == null && zipArchiveEntry.getMethod() == 8 && zipArchiveEntry.getSize() == -1) {
            return Zip64Mode.Never;
        }
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipArchiveEntry zipArchiveEntry) {
        if (!this.zipEncoding.canEncode(zipArchiveEntry.getName()) && this.fallbackToUTF8) {
            return ZipEncodingHelper.UTF8_ZIP_ENCODING;
        }
        return this.zipEncoding;
    }

    private GeneralPurposeBit getGeneralPurposeBits(boolean z, boolean z2) {
        boolean z3;
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        if (!this.useUTF8Flag && !z) {
            z3 = false;
        } else {
            z3 = true;
        }
        generalPurposeBit.useUTF8ForNames(z3);
        if (z2) {
            generalPurposeBit.useDataDescriptor(true);
        }
        return generalPurposeBit;
    }

    private ByteBuffer getName(ZipArchiveEntry zipArchiveEntry) {
        return getEntryEncoding(zipArchiveEntry).encode(zipArchiveEntry.getName());
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            currentEntry.causedUseOfZip64 = !this.hasUsedZip64;
        }
        this.hasUsedZip64 = true;
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (zip64ExtendedInformationExtraField == null) {
            zip64ExtendedInformationExtraField = new Zip64ExtendedInformationExtraField();
        }
        zipArchiveEntry.addAsFirstExtraField(zip64ExtendedInformationExtraField);
        return zip64ExtendedInformationExtraField;
    }

    private boolean handleSizesAndCrc(long j, long j2, Zip64Mode zip64Mode) {
        if (this.entry.entry.getMethod() == 8) {
            CurrentEntry currentEntry = this.entry;
            currentEntry.entry.setSize(currentEntry.bytesRead);
            this.entry.entry.setCompressedSize(j);
            this.entry.entry.setCrc(j2);
        } else if (this.channel == null) {
            if (this.entry.entry.getCrc() == j2) {
                if (this.entry.entry.getSize() != j) {
                    throw new ZipException("Bad size for entry " + this.entry.entry.getName() + ": " + this.entry.entry.getSize() + " instead of " + j);
                }
            } else {
                throw new ZipException("Bad CRC checksum for entry " + this.entry.entry.getName() + ": " + Long.toHexString(this.entry.entry.getCrc()) + " instead of " + Long.toHexString(j2));
            }
        } else {
            this.entry.entry.setSize(j);
            this.entry.entry.setCompressedSize(j);
            this.entry.entry.setCrc(j2);
        }
        return checkIfNeedsZip64(zip64Mode);
    }

    private void handleZip64Extra(ZipArchiveEntry zipArchiveEntry, long j, boolean z) {
        if (z) {
            Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(zipArchiveEntry);
            if (zipArchiveEntry.getCompressedSize() < 4294967295L && zipArchiveEntry.getSize() < 4294967295L && this.zip64Mode != Zip64Mode.Always) {
                zip64Extra.setCompressedSize(null);
                zip64Extra.setSize(null);
            } else {
                zip64Extra.setCompressedSize(new ZipEightByteInteger(zipArchiveEntry.getCompressedSize()));
                zip64Extra.setSize(new ZipEightByteInteger(zipArchiveEntry.getSize()));
            }
            if (j >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
                zip64Extra.setRelativeHeaderOffset(new ZipEightByteInteger(j));
            }
            if (zipArchiveEntry.getDiskNumberStart() >= WebSocketProtocol.PAYLOAD_SHORT_MAX || this.zip64Mode == Zip64Mode.Always) {
                zip64Extra.setDiskStartNumber(new ZipLong(zipArchiveEntry.getDiskNumberStart()));
            }
            zipArchiveEntry.setExtra();
        }
    }

    private boolean hasZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) != null) {
            return true;
        }
        return false;
    }

    private boolean isTooLageForZip32(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getSize() < 4294967295L && zipArchiveEntry.getCompressedSize() < 4294967295L) {
            return false;
        }
        return true;
    }

    private boolean isZip64Required(ZipArchiveEntry zipArchiveEntry, Zip64Mode zip64Mode) {
        if (zip64Mode != Zip64Mode.Always && !isTooLageForZip32(zipArchiveEntry)) {
            return false;
        }
        return true;
    }

    private void preClose() {
        if (!this.finished) {
            CurrentEntry currentEntry = this.entry;
            if (currentEntry != null) {
                if (!currentEntry.hasWritten) {
                    write(EMPTY, 0, 0);
                    return;
                }
                return;
            }
            throw new IOException("No current entry to close");
        }
        throw new IOException("Stream has already been finished");
    }

    private void rewriteSizesAndCrc(boolean z) {
        long a = k0.f.a(this.channel);
        k0.g.a(this.channel, this.entry.localDataStart);
        writeOut(ZipLong.getBytes(this.entry.entry.getCrc()));
        if (hasZip64Extra(this.entry.entry) && z) {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            writeOut(zipLong.getBytes());
            writeOut(zipLong.getBytes());
        } else {
            writeOut(ZipLong.getBytes(this.entry.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.entry.getSize()));
        }
        if (hasZip64Extra(this.entry.entry)) {
            ByteBuffer name = getName(this.entry.entry);
            k0.g.a(this.channel, this.entry.localDataStart + 16 + (name.limit() - name.position()) + 4);
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getSize()));
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getCompressedSize()));
            if (!z) {
                k0.g.a(this.channel, this.entry.localDataStart - 10);
                writeOut(ZipShort.getBytes(versionNeededToExtract(this.entry.entry.getMethod(), false, false)));
                this.entry.entry.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
                this.entry.entry.setExtra();
                if (this.entry.causedUseOfZip64) {
                    this.hasUsedZip64 = false;
                }
            }
        }
        k0.g.a(this.channel, a);
    }

    private void setDefaults(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getMethod() == -1) {
            zipArchiveEntry.setMethod(this.method);
        }
        if (zipArchiveEntry.getTime() == -1) {
            zipArchiveEntry.setTime(System.currentTimeMillis());
        }
    }

    private boolean shouldAddZip64Extra(ZipArchiveEntry zipArchiveEntry, Zip64Mode zip64Mode) {
        if (zip64Mode != Zip64Mode.Always && zipArchiveEntry.getSize() < 4294967295L && zipArchiveEntry.getCompressedSize() < 4294967295L) {
            if (zipArchiveEntry.getSize() != -1 || this.channel == null || zip64Mode == Zip64Mode.Never) {
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean shouldUseZip64EOCD() {
        int i;
        int intValue;
        if (this.isSplitZip) {
            i = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
        } else {
            i = 0;
        }
        if (this.numberOfCDInDiskData.get(Integer.valueOf(i)) == null) {
            intValue = 0;
        } else {
            intValue = this.numberOfCDInDiskData.get(Integer.valueOf(i)).intValue();
        }
        if (i < 65535 && this.cdDiskNumberStart < WebSocketProtocol.PAYLOAD_SHORT_MAX && intValue < 65535 && this.entries.size() < 65535 && this.cdLength < 4294967295L && this.cdOffset < 4294967295L) {
            return false;
        }
        return true;
    }

    private boolean usesDataDescriptor(int i, boolean z) {
        if (!z && i == 8 && this.channel == null) {
            return true;
        }
        return false;
    }

    private void validateIfZip64IsNeededInEOCD() {
        int i;
        if (this.zip64Mode == Zip64Mode.Never) {
            int i2 = 0;
            if (this.isSplitZip) {
                i = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
            } else {
                i = 0;
            }
            if (i < 65535) {
                if (this.cdDiskNumberStart < WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    if (this.numberOfCDInDiskData.get(Integer.valueOf(i)) != null) {
                        i2 = this.numberOfCDInDiskData.get(Integer.valueOf(i)).intValue();
                    }
                    if (i2 < 65535) {
                        if (this.entries.size() < 65535) {
                            if (this.cdLength < 4294967295L) {
                                if (this.cdOffset < 4294967295L) {
                                    return;
                                } else {
                                    throw new Zip64RequiredException("Archive's size exceeds the limit of 4GByte.");
                                }
                            }
                            throw new Zip64RequiredException("The size of the entire central directory exceeds the limit of 4GByte.");
                        }
                        throw new Zip64RequiredException("Archive contains more than 65535 entries.");
                    }
                    throw new Zip64RequiredException("Number of entries on this disk exceeds the limmit of 65535.");
                }
                throw new Zip64RequiredException("Number of the disk with the start of Central Directory exceeds the limmit of 65535.");
            }
            throw new Zip64RequiredException("Number of the disk of End Of Central Directory exceeds the limmit of 65535.");
        }
    }

    private void validateSizeInformation(Zip64Mode zip64Mode) {
        if (this.entry.entry.getMethod() == 0 && this.channel == null) {
            if (this.entry.entry.getSize() != -1) {
                if (this.entry.entry.getCrc() != -1) {
                    ZipArchiveEntry zipArchiveEntry = this.entry.entry;
                    zipArchiveEntry.setCompressedSize(zipArchiveEntry.getSize());
                } else {
                    throw new ZipException("CRC checksum is required for STORED method when not writing to a file");
                }
            } else {
                throw new ZipException("Uncompressed size is required for STORED method when not writing to a file");
            }
        }
        if ((this.entry.entry.getSize() < 4294967295L && this.entry.entry.getCompressedSize() < 4294967295L) || zip64Mode != Zip64Mode.Never) {
        } else {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
    }

    private int versionNeededToExtract(int i, boolean z, boolean z2) {
        if (z) {
            return 45;
        }
        if (z2) {
            return 20;
        }
        return versionNeededToExtractMethod(i);
    }

    private int versionNeededToExtractMethod(int i) {
        return i == 8 ? 20 : 10;
    }

    private void writeCentralDirectoryInChunks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(70000);
        Iterator<ZipArchiveEntry> it = this.entries.iterator();
        while (true) {
            int i = 0;
            while (it.hasNext()) {
                byteArrayOutputStream.write(createCentralFileHeader(it.next()));
                i++;
                if (i > 1000) {
                    break;
                }
            }
            writeCounted(byteArrayOutputStream.toByteArray());
            return;
            writeCounted(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.reset();
        }
    }

    private void writeCounted(byte[] bArr) {
        this.streamCompressor.writeCounted(bArr);
    }

    public void addRawArchiveEntry(ZipArchiveEntry zipArchiveEntry, InputStream inputStream) {
        boolean z;
        ZipArchiveEntry zipArchiveEntry2 = new ZipArchiveEntry(zipArchiveEntry);
        if (hasZip64Extra(zipArchiveEntry2)) {
            zipArchiveEntry2.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        }
        if (zipArchiveEntry2.getCrc() != -1 && zipArchiveEntry2.getSize() != -1 && zipArchiveEntry2.getCompressedSize() != -1) {
            z = true;
        } else {
            z = false;
        }
        putArchiveEntry(zipArchiveEntry2, z);
        copyFromZipInputStream(inputStream);
        closeCopiedEntry(z);
    }

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        if (archiveEntry instanceof ZipArchiveEntry) {
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
            if (zipArchiveEntry.getMethod() != ZipMethod.IMPLODING.getCode() && zipArchiveEntry.getMethod() != ZipMethod.UNSHRINKING.getCode() && ZipUtil.canHandleEntryData(zipArchiveEntry)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (!this.finished) {
                finish();
            }
        } finally {
            destroy();
        }
    }

    public void closeArchiveEntry() {
        preClose();
        flushDeflater();
        long totalBytesWritten = this.streamCompressor.getTotalBytesWritten() - this.entry.dataStart;
        long crc32 = this.streamCompressor.getCrc32();
        this.entry.bytesRead = this.streamCompressor.getBytesRead();
        closeEntry(handleSizesAndCrc(totalBytesWritten, crc32, getEffectiveZip64Mode(this.entry.entry)), false);
        this.streamCompressor.reset();
    }

    public ArchiveEntry createArchiveEntry(File file, String str) {
        if (!this.finished) {
            return new ZipArchiveEntry(file, str);
        }
        throw new IOException("Stream has already been finished");
    }

    public final void deflate() {
        this.streamCompressor.deflate();
    }

    public void destroy() {
        try {
            SeekableByteChannel seekableByteChannel = this.channel;
            if (seekableByteChannel != null) {
                k0.h.a(seekableByteChannel);
            }
        } finally {
            OutputStream outputStream = this.out;
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void finish() {
        if (!this.finished) {
            if (this.entry == null) {
                long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
                this.cdOffset = totalBytesWritten;
                if (this.isSplitZip) {
                    this.cdOffset = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentBytesWritten();
                    this.cdDiskNumberStart = r2.getCurrentSplitSegmentIndex();
                }
                writeCentralDirectoryInChunks();
                this.cdLength = this.streamCompressor.getTotalBytesWritten() - totalBytesWritten;
                ByteBuffer encode = this.zipEncoding.encode(this.comment);
                this.eocdLength = (encode.limit() - encode.position()) + 22;
                writeZip64CentralDirectory();
                writeCentralDirectoryEnd();
                this.metaData.clear();
                this.entries.clear();
                this.streamCompressor.close();
                if (this.isSplitZip) {
                    this.out.close();
                }
                this.finished = true;
                return;
            }
            throw new IOException("This archive contains unclosed entries.");
        }
        throw new IOException("This archive has already been finished");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public boolean isSeekable() {
        if (this.channel != null) {
            return true;
        }
        return false;
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) {
        putArchiveEntry(archiveEntry, false);
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy unicodeExtraFieldPolicy) {
        this.createUnicodeExtraFields = unicodeExtraFieldPolicy;
    }

    public void setEncoding(String str) {
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        if (this.useUTF8Flag && !ZipEncodingHelper.isUTF8(str)) {
            this.useUTF8Flag = false;
        }
    }

    public void setFallbackToUTF8(boolean z) {
        this.fallbackToUTF8 = z;
    }

    public void setLevel(int i) {
        if (i >= -1 && i <= 9) {
            if (this.level == i) {
                return;
            }
            this.hasCompressionLevelChanged = true;
            this.level = i;
            return;
        }
        throw new IllegalArgumentException(m.a(i, "Invalid compression level: "));
    }

    public void setMethod(int i) {
        this.method = i;
    }

    public void setUseLanguageEncodingFlag(boolean z) {
        boolean z2;
        if (z && ZipEncodingHelper.isUTF8(this.encoding)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.useUTF8Flag = z2;
    }

    public void setUseZip64(Zip64Mode zip64Mode) {
        this.zip64Mode = zip64Mode;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            count(this.streamCompressor.write(bArr, i, i2, this.entry.entry.getMethod()));
            return;
        }
        throw new IllegalStateException("No current entry");
    }

    public void writeCentralDirectoryEnd() {
        int i;
        if (!this.hasUsedZip64 && this.isSplitZip) {
            ((ZipSplitOutputStream) this.out).prepareToWriteUnsplittableContent(this.eocdLength);
        }
        validateIfZip64IsNeededInEOCD();
        writeCounted(EOCD_SIG);
        int i2 = 0;
        if (this.isSplitZip) {
            i = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
        } else {
            i = 0;
        }
        writeCounted(ZipShort.getBytes(i));
        writeCounted(ZipShort.getBytes((int) this.cdDiskNumberStart));
        int size = this.entries.size();
        if (this.isSplitZip) {
            if (this.numberOfCDInDiskData.get(Integer.valueOf(i)) != null) {
                i2 = this.numberOfCDInDiskData.get(Integer.valueOf(i)).intValue();
            }
        } else {
            i2 = size;
        }
        writeCounted(ZipShort.getBytes(Math.min(i2, Settings.DEFAULT_INITIAL_WINDOW_SIZE)));
        writeCounted(ZipShort.getBytes(Math.min(size, Settings.DEFAULT_INITIAL_WINDOW_SIZE)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
        ByteBuffer encode = this.zipEncoding.encode(this.comment);
        int limit = encode.limit() - encode.position();
        writeCounted(ZipShort.getBytes(limit));
        this.streamCompressor.writeCounted(encode.array(), encode.arrayOffset(), limit);
    }

    public void writeCentralFileHeader(ZipArchiveEntry zipArchiveEntry) {
        writeCounted(createCentralFileHeader(zipArchiveEntry));
    }

    public void writeDataDescriptor(ZipArchiveEntry zipArchiveEntry) {
        if (!usesDataDescriptor(zipArchiveEntry.getMethod(), false)) {
            return;
        }
        writeCounted(DD_SIG);
        writeCounted(ZipLong.getBytes(zipArchiveEntry.getCrc()));
        if (!hasZip64Extra(zipArchiveEntry)) {
            writeCounted(ZipLong.getBytes(zipArchiveEntry.getCompressedSize()));
            writeCounted(ZipLong.getBytes(zipArchiveEntry.getSize()));
        } else {
            writeCounted(ZipEightByteInteger.getBytes(zipArchiveEntry.getCompressedSize()));
            writeCounted(ZipEightByteInteger.getBytes(zipArchiveEntry.getSize()));
        }
    }

    public void writeLocalFileHeader(ZipArchiveEntry zipArchiveEntry) {
        writeLocalFileHeader(zipArchiveEntry, false);
    }

    public final void writeOut(byte[] bArr) {
        this.streamCompressor.writeOut(bArr, 0, bArr.length);
    }

    public void writeZip64CentralDirectory() {
        long j;
        int i;
        if (this.zip64Mode != Zip64Mode.Never) {
            if (!this.hasUsedZip64 && shouldUseZip64EOCD()) {
                this.hasUsedZip64 = true;
            }
            if (!this.hasUsedZip64) {
                return;
            }
            long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
            if (this.isSplitZip) {
                ZipSplitOutputStream zipSplitOutputStream = (ZipSplitOutputStream) this.out;
                totalBytesWritten = zipSplitOutputStream.getCurrentSplitSegmentBytesWritten();
                j = zipSplitOutputStream.getCurrentSplitSegmentIndex();
            } else {
                j = 0;
            }
            writeOut(ZIP64_EOCD_SIG);
            writeOut(ZipEightByteInteger.getBytes(44L));
            writeOut(ZipShort.getBytes(45));
            writeOut(ZipShort.getBytes(45));
            int i2 = 0;
            if (this.isSplitZip) {
                i = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
            } else {
                i = 0;
            }
            writeOut(ZipLong.getBytes(i));
            writeOut(ZipLong.getBytes(this.cdDiskNumberStart));
            if (this.isSplitZip) {
                if (this.numberOfCDInDiskData.get(Integer.valueOf(i)) != null) {
                    i2 = this.numberOfCDInDiskData.get(Integer.valueOf(i)).intValue();
                }
            } else {
                i2 = this.entries.size();
            }
            writeOut(ZipEightByteInteger.getBytes(i2));
            writeOut(ZipEightByteInteger.getBytes(this.entries.size()));
            writeOut(ZipEightByteInteger.getBytes(this.cdLength));
            writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
            if (this.isSplitZip) {
                ((ZipSplitOutputStream) this.out).prepareToWriteUnsplittableContent(this.eocdLength + 20);
            }
            writeOut(ZIP64_EOCD_LOC_SIG);
            writeOut(ZipLong.getBytes(j));
            writeOut(ZipEightByteInteger.getBytes(totalBytesWritten));
            if (this.isSplitZip) {
                writeOut(ZipLong.getBytes(((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex() + 1));
            } else {
                writeOut(ONE);
            }
        }
    }

    private void putArchiveEntry(ArchiveEntry archiveEntry, boolean z) {
        ZipEightByteInteger zipEightByteInteger;
        ZipEightByteInteger zipEightByteInteger2;
        if (!this.finished) {
            if (this.entry != null) {
                closeArchiveEntry();
            }
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
            CurrentEntry currentEntry = new CurrentEntry(zipArchiveEntry);
            this.entry = currentEntry;
            this.entries.add(currentEntry.entry);
            setDefaults(this.entry.entry);
            Zip64Mode effectiveZip64Mode = getEffectiveZip64Mode(this.entry.entry);
            validateSizeInformation(effectiveZip64Mode);
            if (shouldAddZip64Extra(this.entry.entry, effectiveZip64Mode)) {
                Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(this.entry.entry);
                if (!z) {
                    if (this.entry.entry.getMethod() == 0 && this.entry.entry.getSize() != -1) {
                        zipEightByteInteger = new ZipEightByteInteger(this.entry.entry.getSize());
                    } else {
                        zipEightByteInteger = ZipEightByteInteger.ZERO;
                    }
                    zipEightByteInteger2 = zipEightByteInteger;
                } else {
                    zipEightByteInteger = new ZipEightByteInteger(this.entry.entry.getSize());
                    zipEightByteInteger2 = new ZipEightByteInteger(this.entry.entry.getCompressedSize());
                }
                zip64Extra.setSize(zipEightByteInteger);
                zip64Extra.setCompressedSize(zipEightByteInteger2);
                this.entry.entry.setExtra();
            }
            if (this.entry.entry.getMethod() == 8 && this.hasCompressionLevelChanged) {
                this.def.setLevel(this.level);
                this.hasCompressionLevelChanged = false;
            }
            writeLocalFileHeader(zipArchiveEntry, z);
            return;
        }
        throw new IOException("Stream has already been finished");
    }

    private void writeLocalFileHeader(ZipArchiveEntry zipArchiveEntry, boolean z) {
        boolean canEncode = this.zipEncoding.canEncode(zipArchiveEntry.getName());
        ByteBuffer name = getName(zipArchiveEntry);
        if (this.createUnicodeExtraFields != UnicodeExtraFieldPolicy.NEVER) {
            addUnicodeExtraFields(zipArchiveEntry, canEncode, name);
        }
        long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
        if (this.isSplitZip) {
            ZipSplitOutputStream zipSplitOutputStream = (ZipSplitOutputStream) this.out;
            zipArchiveEntry.setDiskNumberStart(zipSplitOutputStream.getCurrentSplitSegmentIndex());
            totalBytesWritten = zipSplitOutputStream.getCurrentSplitSegmentBytesWritten();
        }
        byte[] createLocalFileHeader = createLocalFileHeader(zipArchiveEntry, name, canEncode, z, totalBytesWritten);
        this.metaData.put(zipArchiveEntry, new EntryMetaData(totalBytesWritten, usesDataDescriptor(zipArchiveEntry.getMethod(), z)));
        this.entry.localDataStart = totalBytesWritten + 14;
        writeCounted(createLocalFileHeader);
        this.entry.dataStart = this.streamCompressor.getTotalBytesWritten();
    }

    public final void writeOut(byte[] bArr, int i, int i2) {
        this.streamCompressor.writeOut(bArr, i, i2);
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry zipArchiveEntry, ByteBuffer byteBuffer, EntryMetaData entryMetaData, boolean z) {
        if (this.isSplitZip) {
            int currentSplitSegmentIndex = ((ZipSplitOutputStream) this.out).getCurrentSplitSegmentIndex();
            if (this.numberOfCDInDiskData.get(Integer.valueOf(currentSplitSegmentIndex)) == null) {
                this.numberOfCDInDiskData.put(Integer.valueOf(currentSplitSegmentIndex), 1);
            } else {
                this.numberOfCDInDiskData.put(Integer.valueOf(currentSplitSegmentIndex), Integer.valueOf(this.numberOfCDInDiskData.get(Integer.valueOf(currentSplitSegmentIndex)).intValue() + 1));
            }
        }
        byte[] centralDirectoryExtra = zipArchiveEntry.getCentralDirectoryExtra();
        String comment = zipArchiveEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment);
        int limit = byteBuffer.limit() - byteBuffer.position();
        int limit2 = encode.limit() - encode.position();
        int i = limit + 46;
        byte[] bArr = new byte[centralDirectoryExtra.length + i + limit2];
        System.arraycopy(CFH_SIG, 0, bArr, 0, 4);
        ZipShort.putShort((zipArchiveEntry.getPlatform() << 8) | (!this.hasUsedZip64 ? 20 : 45), bArr, 4);
        int method = zipArchiveEntry.getMethod();
        boolean canEncode = this.zipEncoding.canEncode(zipArchiveEntry.getName());
        ZipShort.putShort(versionNeededToExtract(method, z, entryMetaData.usesDataDescriptor), bArr, 6);
        getGeneralPurposeBits(!canEncode && this.fallbackToUTF8, entryMetaData.usesDataDescriptor).encode(bArr, 8);
        ZipShort.putShort(method, bArr, 10);
        ZipUtil.toDosTime(this.calendarInstance, zipArchiveEntry.getTime(), bArr, 12);
        ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 16);
        if (zipArchiveEntry.getCompressedSize() < 4294967295L && zipArchiveEntry.getSize() < 4294967295L && this.zip64Mode != Zip64Mode.Always) {
            ZipLong.putLong(zipArchiveEntry.getCompressedSize(), bArr, 20);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 24);
        } else {
            ZipLong zipLong = ZipLong.ZIP64_MAGIC;
            zipLong.putLong(bArr, 20);
            zipLong.putLong(bArr, 24);
        }
        ZipShort.putShort(limit, bArr, 28);
        ZipShort.putShort(centralDirectoryExtra.length, bArr, 30);
        ZipShort.putShort(limit2, bArr, 32);
        if (!this.isSplitZip) {
            System.arraycopy(ZERO, 0, bArr, 34, 2);
        } else if (zipArchiveEntry.getDiskNumberStart() < WebSocketProtocol.PAYLOAD_SHORT_MAX && this.zip64Mode != Zip64Mode.Always) {
            ZipShort.putShort((int) zipArchiveEntry.getDiskNumberStart(), bArr, 34);
        } else {
            ZipShort.putShort(Settings.DEFAULT_INITIAL_WINDOW_SIZE, bArr, 34);
        }
        ZipShort.putShort(zipArchiveEntry.getInternalAttributes(), bArr, 36);
        ZipLong.putLong(zipArchiveEntry.getExternalAttributes(), bArr, 38);
        long j = entryMetaData.offset;
        if (j < 4294967295L && this.zip64Mode != Zip64Mode.Always) {
            ZipLong.putLong(Math.min(j, 4294967295L), bArr, 42);
        } else {
            ZipLong.putLong(4294967295L, bArr, 42);
        }
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 46, limit);
        System.arraycopy(centralDirectoryExtra, 0, bArr, i, centralDirectoryExtra.length);
        System.arraycopy(encode.array(), encode.arrayOffset(), bArr, i + centralDirectoryExtra.length, limit2);
        return bArr;
    }

    public ZipArchiveOutputStream(File file) {
        SeekableByteChannel seekableByteChannel;
        StreamCompressor create;
        StandardOpenOption standardOpenOption;
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.cdDiskNumberStart = 0L;
        this.eocdLength = 0L;
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        FileOutputStream fileOutputStream = null;
        try {
            Path a = i0.a.a(file);
            StandardOpenOption a2 = okio.f.a();
            StandardOpenOption a3 = okio.d.a();
            StandardOpenOption a4 = okio.c.a();
            standardOpenOption = StandardOpenOption.TRUNCATE_EXISTING;
            seekableByteChannel = Files.newByteChannel(a, EnumSet.of(a2, a3, a4, standardOpenOption), new FileAttribute[0]);
        } catch (IOException unused) {
            seekableByteChannel = null;
        }
        try {
            create = StreamCompressor.create(seekableByteChannel, deflater);
        } catch (IOException unused2) {
            k0.a.c(seekableByteChannel);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            create = StreamCompressor.create(fileOutputStream2, this.def);
            seekableByteChannel = null;
            fileOutputStream = fileOutputStream2;
            this.out = fileOutputStream;
            this.channel = seekableByteChannel;
            this.streamCompressor = create;
            this.isSplitZip = false;
        }
        this.out = fileOutputStream;
        this.channel = seekableByteChannel;
        this.streamCompressor = create;
        this.isSplitZip = false;
    }

    public ZipArchiveOutputStream(File file, long j) {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.cdDiskNumberStart = 0L;
        this.eocdLength = 0L;
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        ZipSplitOutputStream zipSplitOutputStream = new ZipSplitOutputStream(file, j);
        this.out = zipSplitOutputStream;
        this.streamCompressor = StreamCompressor.create(zipSplitOutputStream, deflater);
        this.channel = null;
        this.isSplitZip = true;
    }

    public ZipArchiveOutputStream(SeekableByteChannel seekableByteChannel) {
        this.finished = false;
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new LinkedList();
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.cdDiskNumberStart = 0L;
        this.eocdLength = 0L;
        this.metaData = new HashMap();
        this.encoding = DEFAULT_ENCODING;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);
        this.useUTF8Flag = true;
        this.fallbackToUTF8 = false;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.hasUsedZip64 = false;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        this.channel = seekableByteChannel;
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        this.streamCompressor = StreamCompressor.create(seekableByteChannel, deflater);
        this.out = null;
        this.isSplitZip = false;
    }
}
