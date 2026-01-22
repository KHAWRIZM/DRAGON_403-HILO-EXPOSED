package com.amazonaws.util;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class AbstractBase32Codec implements Codec {
    private static final int BITS_3 = 3;
    private static final int BITS_4 = 4;
    private static final int BITS_5 = 5;
    private static final int BIT_MULTIPLIER = 8;
    private static final int MASK_2BITS = 3;
    private static final int MASK_3BITS = 7;
    private static final int MASK_4BITS = 15;
    private static final int MASK_5BITS = 31;
    private static final byte PAD = 61;
    private final byte[] alpahbets;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBase32Codec(byte[] bArr) {
        this.alpahbets = bArr;
    }

    private final void decode1to4bytes(int i10, byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        int pos = pos(bArr[i11]) << 3;
        int i14 = i11 + 2;
        int pos2 = pos(bArr[i11 + 1]);
        bArr2[i12] = (byte) (pos | ((pos2 >>> 2) & 7));
        if (i10 == 1) {
            CodecUtils.sanityCheckLastPos(pos2, 3);
            return;
        }
        int i15 = i12 + 2;
        int pos3 = ((pos2 & 3) << 6) | (pos(bArr[i14]) << 1);
        int i16 = i11 + 4;
        int pos4 = pos(bArr[i11 + 3]);
        bArr2[i13] = (byte) (pos3 | ((pos4 >>> 4) & 1));
        if (i10 == 2) {
            CodecUtils.sanityCheckLastPos(pos4, 15);
            return;
        }
        int i17 = i12 + 3;
        int i18 = i11 + 5;
        int pos5 = pos(bArr[i16]);
        bArr2[i15] = (byte) ((15 & (pos5 >>> 1)) | ((pos4 & 15) << 4));
        if (i10 == 3) {
            CodecUtils.sanityCheckLastPos(pos5, 1);
            return;
        }
        int pos6 = ((pos5 & 1) << 7) | (pos(bArr[i18]) << 2);
        int pos7 = pos(bArr[i11 + 6]);
        bArr2[i17] = (byte) (pos6 | ((pos7 >>> 3) & 3));
        CodecUtils.sanityCheckLastPos(pos7, 7);
    }

    private final void decode5bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int pos = pos(bArr[i10]) << 3;
        int pos2 = pos(bArr[i10 + 1]);
        bArr2[i11] = (byte) (pos | ((pos2 >>> 2) & 7));
        int pos3 = ((pos2 & 3) << 6) | (pos(bArr[i10 + 2]) << 1);
        int pos4 = pos(bArr[i10 + 3]);
        bArr2[i11 + 1] = (byte) (pos3 | ((pos4 >>> 4) & 1));
        int pos5 = pos(bArr[i10 + 4]);
        bArr2[i11 + 2] = (byte) (((pos4 & 15) << 4) | ((pos5 >>> 1) & 15));
        int pos6 = ((pos5 & 1) << 7) | (pos(bArr[i10 + 5]) << 2);
        int pos7 = pos(bArr[i10 + 6]);
        bArr2[i11 + 3] = (byte) (pos6 | ((pos7 >>> 3) & 3));
        bArr2[i11 + 4] = (byte) (pos(bArr[i10 + 7]) | ((pos7 & 7) << 5));
    }

    private final void encode1byte(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12 = i11 + 1;
        byte[] bArr3 = this.alpahbets;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 3) & 31];
        int i13 = i11 + 2;
        bArr2[i12] = bArr3[(b10 & 7) << 2];
        int i14 = 0;
        while (i14 < 6) {
            bArr2[i13] = 61;
            i14++;
            i13++;
        }
    }

    private final void encode2bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = this.alpahbets;
        int i12 = i10 + 1;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 3) & 31];
        byte b11 = bArr[i12];
        bArr2[i11 + 1] = bArr3[((b10 & 7) << 2) | ((b11 >>> 6) & 3)];
        int i13 = i11 + 3;
        bArr2[i11 + 2] = bArr3[(b11 >>> 1) & 31];
        int i14 = i11 + 4;
        bArr2[i13] = bArr3[(b11 & 1) << 4];
        int i15 = 0;
        while (i15 < 4) {
            bArr2[i14] = 61;
            i15++;
            i14++;
        }
    }

    private final void encode3bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = this.alpahbets;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 3) & 31];
        byte b11 = bArr[i10 + 1];
        bArr2[i11 + 1] = bArr3[((b10 & 7) << 2) | ((b11 >>> 6) & 3)];
        bArr2[i11 + 2] = bArr3[(b11 >>> 1) & 31];
        int i12 = i11 + 4;
        byte b12 = bArr[i10 + 2];
        bArr2[i11 + 3] = bArr3[((b12 >>> 4) & 15) | ((b11 & 1) << 4)];
        int i13 = i11 + 5;
        bArr2[i12] = bArr3[(b12 & 15) << 1];
        int i14 = 0;
        while (i14 < 3) {
            bArr2[i13] = 61;
            i14++;
            i13++;
        }
    }

    private final void encode4bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = this.alpahbets;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 3) & 31];
        byte b11 = bArr[i10 + 1];
        bArr2[i11 + 1] = bArr3[((b10 & 7) << 2) | ((b11 >>> 6) & 3)];
        bArr2[i11 + 2] = bArr3[(b11 >>> 1) & 31];
        byte b12 = bArr[i10 + 2];
        bArr2[i11 + 3] = bArr3[((b11 & 1) << 4) | ((b12 >>> 4) & 15)];
        byte b13 = bArr[i10 + 3];
        bArr2[i11 + 4] = bArr3[((b13 >>> 7) & 1) | ((b12 & 15) << 1)];
        bArr2[i11 + 5] = bArr3[(b13 >>> 2) & 31];
        bArr2[i11 + 6] = bArr3[(b13 & 3) << 3];
        bArr2[i11 + 7] = 61;
    }

    private final void encode5bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = this.alpahbets;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 3) & 31];
        byte b11 = bArr[i10 + 1];
        bArr2[i11 + 1] = bArr3[((b10 & 7) << 2) | ((b11 >>> 6) & 3)];
        bArr2[i11 + 2] = bArr3[(b11 >>> 1) & 31];
        byte b12 = bArr[i10 + 2];
        bArr2[i11 + 3] = bArr3[((b11 & 1) << 4) | ((b12 >>> 4) & 15)];
        byte b13 = bArr[i10 + 3];
        bArr2[i11 + 4] = bArr3[((b12 & 15) << 1) | ((b13 >>> 7) & 1)];
        bArr2[i11 + 5] = bArr3[(b13 >>> 2) & 31];
        byte b14 = bArr[i10 + 4];
        bArr2[i11 + 6] = bArr3[((b14 >>> 5) & 7) | ((b13 & 3) << 3)];
        bArr2[i11 + 7] = bArr3[b14 & 31];
    }

    @Override // com.amazonaws.util.Codec
    public final byte[] decode(byte[] bArr, int i10) {
        int i11;
        if (i10 % 8 == 0) {
            int i12 = i10 - 1;
            int i13 = 0;
            while (i13 < 6 && i12 > -1 && bArr[i12] == 61) {
                i12--;
                i13++;
            }
            if (i13 != 0) {
                if (i13 != 1) {
                    i11 = 3;
                    if (i13 != 3) {
                        if (i13 != 4) {
                            if (i13 == 6) {
                                i11 = 1;
                            } else {
                                throw new IllegalArgumentException("Invalid number of paddings " + i13);
                            }
                        } else {
                            i11 = 2;
                        }
                    }
                } else {
                    i11 = 4;
                }
            } else {
                i11 = 5;
            }
            int i14 = ((i10 / 8) * 5) - (5 - i11);
            byte[] bArr2 = new byte[i14];
            int i15 = 0;
            int i16 = 0;
            while (i16 < i14 - (i11 % 5)) {
                decode5bytes(bArr, i15, bArr2, i16);
                i15 += 8;
                i16 += 5;
            }
            if (i11 < 5) {
                decode1to4bytes(i11, bArr, i15, bArr2, i16);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 8 bytes but found: " + i10);
    }

    @Override // com.amazonaws.util.Codec
    public final byte[] encode(byte[] bArr) {
        int length = bArr.length / 5;
        int length2 = bArr.length % 5;
        int i10 = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 8];
            int i11 = 0;
            while (i10 < bArr.length) {
                encode5bytes(bArr, i10, bArr2, i11);
                i10 += 5;
                i11 += 8;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 8];
        int i12 = 0;
        while (i10 < bArr.length - length2) {
            encode5bytes(bArr, i10, bArr3, i12);
            i10 += 5;
            i12 += 8;
        }
        if (length2 != 1) {
            if (length2 != 2) {
                if (length2 != 3) {
                    if (length2 == 4) {
                        encode4bytes(bArr, i10, bArr3, i12);
                    }
                } else {
                    encode3bytes(bArr, i10, bArr3, i12);
                }
            } else {
                encode2bytes(bArr, i10, bArr3, i12);
            }
        } else {
            encode1byte(bArr, i10, bArr3, i12);
        }
        return bArr3;
    }

    protected abstract int pos(byte b10);
}
