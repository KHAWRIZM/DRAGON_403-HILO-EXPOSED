package org.apache.commons.sudcompress.archivers.zip;

import e0.m;
import java.util.zip.ZipException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ResourceAlignmentExtraField implements ZipExtraField {
    private static final int ALLOW_METHOD_MESSAGE_CHANGE_FLAG = 32768;
    public static final int BASE_SIZE = 2;
    public static final ZipShort ID = new ZipShort(41246);
    private short alignment;
    private boolean allowMethodChange;
    private int padding;

    public ResourceAlignmentExtraField() {
        this.padding = 0;
    }

    public boolean allowMethodChange() {
        return this.allowMethodChange;
    }

    public short getAlignment() {
        return this.alignment;
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        short s;
        short s2 = this.alignment;
        if (this.allowMethodChange) {
            s = 32768;
        } else {
            s = 0;
        }
        return ZipShort.getBytes(s2 | s);
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort(2);
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return ID;
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        short s;
        byte[] bArr = new byte[this.padding + 2];
        short s2 = this.alignment;
        if (this.allowMethodChange) {
            s = 32768;
        } else {
            s = 0;
        }
        ZipShort.putShort(s2 | s, bArr, 0);
        return bArr;
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.padding + 2);
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        boolean z;
        if (i2 >= 2) {
            int value = ZipShort.getValue(bArr, i);
            this.alignment = (short) (value & 32767);
            if ((value & 32768) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.allowMethodChange = z;
            return;
        }
        throw new ZipException(m.a(i2, "Too short content for ResourceAlignmentExtraField (0xa11e): "));
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        parseFromCentralDirectoryData(bArr, i, i2);
        this.padding = i2 - 2;
    }

    public ResourceAlignmentExtraField(int i) {
        this(i, false);
    }

    public ResourceAlignmentExtraField(int i, boolean z) {
        this(i, z, 0);
    }

    public ResourceAlignmentExtraField(int i, boolean z, int i2) {
        this.padding = 0;
        if (i < 0 || i > 32767) {
            throw new IllegalArgumentException(m.a(i, "Alignment must be between 0 and 0x7fff, was: "));
        }
        if (i2 >= 0) {
            this.alignment = (short) i;
            this.allowMethodChange = z;
            this.padding = i2;
            return;
        }
        throw new IllegalArgumentException(m.a(i2, "Padding must not be negative, was: "));
    }
}
