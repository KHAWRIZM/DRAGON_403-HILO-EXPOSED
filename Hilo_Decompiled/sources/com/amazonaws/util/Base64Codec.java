package com.amazonaws.util;

import okio.Utf8;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Base64Codec implements Codec {
    private static final int BITS_3 = 3;
    private static final int BITS_4 = 4;
    private static final int BITS_6 = 6;
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private static final int OFFSET_0_VALUE = 52;
    private static final int OFFSET_OF_0 = -4;
    private static final int OFFSET_OF_PLUS = -19;
    private static final int OFFSET_OF_SLASH = -16;
    private static final int OFFSET_OF_a = 71;
    private static final int OFFSET_PLUS_VALUE = 62;
    private static final int OFFSET_SLASH_VALUE = 63;
    private static final int OFFSET_a_VALUE = 26;
    private static final byte PAD = 61;
    private final byte[] alpahbets;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class LazyHolder {
        private static final byte[] DECODED = decodeTable();

        private LazyHolder() {
        }

        private static byte[] decodeTable() {
            byte[] bArr = new byte[123];
            for (int i10 = 0; i10 <= 122; i10++) {
                if (i10 >= 65 && i10 <= 90) {
                    bArr[i10] = (byte) (i10 - 65);
                } else if (i10 >= 48 && i10 <= 57) {
                    bArr[i10] = (byte) (i10 + 4);
                } else if (i10 == 43) {
                    bArr[i10] = (byte) (i10 + 19);
                } else if (i10 == 47) {
                    bArr[i10] = (byte) (i10 + 16);
                } else if (i10 >= 97 && i10 <= 122) {
                    bArr[i10] = (byte) (i10 - 71);
                } else {
                    bArr[i10] = -1;
                }
            }
            return bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Base64Codec() {
        this.alpahbets = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    }

    @Override // com.amazonaws.util.Codec
    public byte[] decode(byte[] bArr, int i10) {
        int i11;
        if (i10 % 4 == 0) {
            int i12 = i10 - 1;
            int i13 = 0;
            while (true) {
                i11 = 2;
                if (i13 >= 2 || i12 <= -1 || bArr[i12] != 61) {
                    break;
                }
                i12--;
                i13++;
            }
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 == 2) {
                        i11 = 1;
                    } else {
                        throw new Error("Impossible");
                    }
                }
            } else {
                i11 = 3;
            }
            int i14 = ((i10 / 4) * 3) - (3 - i11);
            byte[] bArr2 = new byte[i14];
            int i15 = 0;
            int i16 = 0;
            while (i16 < i14 - (i11 % 3)) {
                decode4bytes(bArr, i15, bArr2, i16);
                i15 += 4;
                i16 += 3;
            }
            if (i11 < 3) {
                decode1to3bytes(i11, bArr, i15, bArr2, i16);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 4 bytes but found: " + i10);
    }

    void decode1to3bytes(int i10, byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        int pos = pos(bArr[i11]) << 2;
        int i14 = i11 + 2;
        int pos2 = pos(bArr[i11 + 1]);
        bArr2[i12] = (byte) (pos | ((pos2 >>> 4) & 3));
        if (i10 == 1) {
            CodecUtils.sanityCheckLastPos(pos2, 15);
            return;
        }
        int i15 = i12 + 2;
        int i16 = i11 + 3;
        int pos3 = pos(bArr[i14]);
        bArr2[i13] = (byte) (((pos2 & 15) << 4) | (15 & (pos3 >>> 2)));
        if (i10 == 2) {
            CodecUtils.sanityCheckLastPos(pos3, 3);
        } else {
            bArr2[i15] = (byte) (((pos3 & 3) << 6) | pos(bArr[i16]));
        }
    }

    void decode4bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int pos = pos(bArr[i10]) << 2;
        int pos2 = pos(bArr[i10 + 1]);
        bArr2[i11] = (byte) (pos | ((pos2 >>> 4) & 3));
        int pos3 = pos(bArr[i10 + 2]);
        bArr2[i11 + 1] = (byte) (((pos2 & 15) << 4) | ((pos3 >>> 2) & 15));
        bArr2[i11 + 2] = (byte) (pos(bArr[i10 + 3]) | ((pos3 & 3) << 6));
    }

    @Override // com.amazonaws.util.Codec
    public byte[] encode(byte[] bArr) {
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int i10 = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 4];
            int i11 = 0;
            while (i10 < bArr.length) {
                encode3bytes(bArr, i10, bArr2, i11);
                i10 += 3;
                i11 += 4;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 4];
        int i12 = 0;
        while (i10 < bArr.length - length2) {
            encode3bytes(bArr, i10, bArr3, i12);
            i10 += 3;
            i12 += 4;
        }
        if (length2 != 1) {
            if (length2 == 2) {
                encode2bytes(bArr, i10, bArr3, i12);
            }
        } else {
            encode1byte(bArr, i10, bArr3, i12);
        }
        return bArr3;
    }

    void encode1byte(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = this.alpahbets;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 2) & 63];
        bArr2[i11 + 1] = bArr3[(b10 & 3) << 4];
        bArr2[i11 + 2] = 61;
        bArr2[i11 + 3] = 61;
    }

    void encode2bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = this.alpahbets;
        int i12 = i10 + 1;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 2) & 63];
        byte b11 = bArr[i12];
        bArr2[i11 + 1] = bArr3[((b10 & 3) << 4) | ((b11 >>> 4) & 15)];
        bArr2[i11 + 2] = bArr3[(b11 & 15) << 2];
        bArr2[i11 + 3] = 61;
    }

    void encode3bytes(byte[] bArr, int i10, byte[] bArr2, int i11) {
        byte[] bArr3 = this.alpahbets;
        byte b10 = bArr[i10];
        bArr2[i11] = bArr3[(b10 >>> 2) & 63];
        byte b11 = bArr[i10 + 1];
        bArr2[i11 + 1] = bArr3[((b10 & 3) << 4) | ((b11 >>> 4) & 15)];
        byte b12 = bArr[i10 + 2];
        bArr2[i11 + 2] = bArr3[((b12 >>> 6) & 3) | ((b11 & 15) << 2)];
        bArr2[i11 + 3] = bArr3[b12 & Utf8.REPLACEMENT_BYTE];
    }

    protected int pos(byte b10) {
        byte b11 = LazyHolder.DECODED[b10];
        if (b11 > -1) {
            return b11;
        }
        throw new IllegalArgumentException("Invalid base 64 character: '" + ((char) b10) + "'");
    }

    protected Base64Codec(byte[] bArr) {
        this.alpahbets = bArr;
    }
}
