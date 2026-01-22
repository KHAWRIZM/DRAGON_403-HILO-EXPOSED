package com.amazonaws.util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class Base16Codec implements Codec {
    private static final int BITS_4 = 4;
    private static final int MASK_4BITS = 15;
    private static final int OFFSET_OF_A = 55;
    private static final int OFFSET_OF_a = 87;
    private static final int OFFSET_VALUE = 10;
    private final byte[] alpahbets = CodecUtils.toBytesDirect("0123456789ABCDEF");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class LazyHolder {
        private static final byte[] DECODED = decodeTable();

        private LazyHolder() {
        }

        private static byte[] decodeTable() {
            byte[] bArr = new byte[103];
            for (int i10 = 0; i10 <= 102; i10++) {
                if (i10 >= 48 && i10 <= 57) {
                    bArr[i10] = (byte) (i10 - 48);
                } else if (i10 >= 65 && i10 <= 70) {
                    bArr[i10] = (byte) (i10 - 55);
                } else if (i10 >= 97 && i10 <= 102) {
                    bArr[i10] = (byte) (i10 - 87);
                } else {
                    bArr[i10] = -1;
                }
            }
            return bArr;
        }
    }

    @Override // com.amazonaws.util.Codec
    public byte[] decode(byte[] bArr, int i10) {
        if (i10 % 2 == 0) {
            int i11 = i10 / 2;
            byte[] bArr2 = new byte[i11];
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = i12 + 1;
                int pos = pos(bArr[i12]) << 4;
                i12 += 2;
                bArr2[i13] = (byte) (pos(bArr[i14]) | pos);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 2 bytes but found: " + i10);
    }

    @Override // com.amazonaws.util.Codec
    public byte[] encode(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            byte[] bArr3 = this.alpahbets;
            bArr2[i10] = bArr3[(b10 >>> 4) & 15];
            i10 += 2;
            bArr2[i11] = bArr3[b10 & 15];
        }
        return bArr2;
    }

    protected int pos(byte b10) {
        byte b11 = LazyHolder.DECODED[b10];
        if (b11 > -1) {
            return b11;
        }
        throw new IllegalArgumentException("Invalid base 16 character: '" + ((char) b10) + "'");
    }
}
