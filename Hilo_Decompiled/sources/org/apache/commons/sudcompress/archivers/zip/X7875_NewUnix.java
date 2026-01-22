package org.apache.commons.sudcompress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.ZipException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class X7875_NewUnix implements ZipExtraField, Cloneable, Serializable {
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version = 1;
    private static final ZipShort HEADER_ID = new ZipShort(30837);
    private static final ZipShort ZERO = new ZipShort(0);
    private static final BigInteger ONE_THOUSAND = BigInteger.valueOf(1000);

    public X7875_NewUnix() {
        reset();
    }

    private void reset() {
        BigInteger bigInteger = ONE_THOUSAND;
        this.uid = bigInteger;
        this.gid = bigInteger;
    }

    public static byte[] trimLeadingZeroesForceMinLength(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length && bArr[i2] == 0; i2++) {
            i++;
        }
        int max = Math.max(1, bArr.length - i);
        byte[] bArr2 = new byte[max];
        int length2 = max - (bArr.length - i);
        System.arraycopy(bArr, i, bArr2, length2, max - length2);
        return bArr2;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj instanceof X7875_NewUnix) {
            X7875_NewUnix x7875_NewUnix = (X7875_NewUnix) obj;
            if (this.version == x7875_NewUnix.version && this.uid.equals(x7875_NewUnix.uid) && this.gid.equals(x7875_NewUnix.gid)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return new byte[0];
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        int i;
        int i2;
        byte[] byteArray = this.uid.toByteArray();
        byte[] byteArray2 = this.gid.toByteArray();
        byte[] trimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(byteArray);
        if (trimLeadingZeroesForceMinLength != null) {
            i = trimLeadingZeroesForceMinLength.length;
        } else {
            i = 0;
        }
        byte[] trimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(byteArray2);
        if (trimLeadingZeroesForceMinLength2 != null) {
            i2 = trimLeadingZeroesForceMinLength2.length;
        } else {
            i2 = 0;
        }
        int i3 = i + 3;
        byte[] bArr = new byte[i3 + i2];
        if (trimLeadingZeroesForceMinLength != null) {
            ZipUtil.reverse(trimLeadingZeroesForceMinLength);
        }
        if (trimLeadingZeroesForceMinLength2 != null) {
            ZipUtil.reverse(trimLeadingZeroesForceMinLength2);
        }
        bArr[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        bArr[1] = ZipUtil.unsignedIntToSignedByte(i);
        if (trimLeadingZeroesForceMinLength != null) {
            System.arraycopy(trimLeadingZeroesForceMinLength, 0, bArr, 2, i);
        }
        bArr[2 + i] = ZipUtil.unsignedIntToSignedByte(i2);
        if (trimLeadingZeroesForceMinLength2 != null) {
            System.arraycopy(trimLeadingZeroesForceMinLength2, 0, bArr, i3, i2);
        }
        return bArr;
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        int length;
        byte[] trimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(this.uid.toByteArray());
        int i = 0;
        if (trimLeadingZeroesForceMinLength == null) {
            length = 0;
        } else {
            length = trimLeadingZeroesForceMinLength.length;
        }
        byte[] trimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(this.gid.toByteArray());
        if (trimLeadingZeroesForceMinLength2 != null) {
            i = trimLeadingZeroesForceMinLength2.length;
        }
        return new ZipShort(length + 3 + i);
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public int hashCode() {
        return ((this.version * (-1234567)) ^ Integer.rotateLeft(this.uid.hashCode(), 16)) ^ this.gid.hashCode();
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
    }

    @Override // org.apache.commons.sudcompress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        reset();
        if (i2 >= 3) {
            int i3 = i + 1;
            this.version = ZipUtil.signedByteToUnsignedInt(bArr[i]);
            int i4 = i + 2;
            int signedByteToUnsignedInt = ZipUtil.signedByteToUnsignedInt(bArr[i3]);
            int i5 = signedByteToUnsignedInt + 3;
            if (i5 <= i2) {
                int i6 = signedByteToUnsignedInt + i4;
                this.uid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i4, i6)));
                int i7 = i6 + 1;
                int signedByteToUnsignedInt2 = ZipUtil.signedByteToUnsignedInt(bArr[i6]);
                if (i5 + signedByteToUnsignedInt2 <= i2) {
                    this.gid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i7, signedByteToUnsignedInt2 + i7)));
                    return;
                }
                throw new ZipException("X7875_NewUnix invalid: gidSize " + signedByteToUnsignedInt2 + " doesn't fit into " + i2 + " bytes");
            }
            throw new ZipException("X7875_NewUnix invalid: uidSize " + signedByteToUnsignedInt + " doesn't fit into " + i2 + " bytes");
        }
        throw new ZipException("X7875_NewUnix length is too short, only " + i2 + " bytes");
    }

    public void setGID(long j) {
        this.gid = ZipUtil.longToBig(j);
    }

    public void setUID(long j) {
        this.uid = ZipUtil.longToBig(j);
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }
}
