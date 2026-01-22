package kotlin.reflect.jvm.internal.impl.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class Utf8 {
    private static int incompleteStateFor(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r7[r8] > (-65)) goto L١٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        if (r7[r8] > (-65)) goto L٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
    
        if (r7[r6] > (-65)) goto L٥٣;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int partialIsValidUtf8(int i10, byte[] bArr, int i11, int i12) {
        byte b10;
        int i13;
        int i14;
        if (i10 != 0) {
            if (i11 >= i12) {
                return i10;
            }
            byte b11 = (byte) i10;
            if (b11 < -32) {
                if (b11 >= -62) {
                    i14 = i11 + 1;
                }
                return -1;
            }
            if (b11 < -16) {
                byte b12 = (byte) (~(i10 >> 8));
                if (b12 == 0) {
                    int i15 = i11 + 1;
                    byte b13 = bArr[i11];
                    if (i15 >= i12) {
                        return incompleteStateFor(b11, b13);
                    }
                    i11 = i15;
                    b12 = b13;
                }
                if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                    i14 = i11 + 1;
                }
                return -1;
            }
            byte b14 = (byte) (~(i10 >> 8));
            if (b14 == 0) {
                i13 = i11 + 1;
                b14 = bArr[i11];
                if (i13 >= i12) {
                    return incompleteStateFor(b11, b14);
                }
                b10 = 0;
            } else {
                b10 = (byte) (i10 >> 16);
                i13 = i11;
            }
            if (b10 == 0) {
                int i16 = i13 + 1;
                byte b15 = bArr[i13];
                if (i16 >= i12) {
                    return incompleteStateFor(b11, b14, b15);
                }
                b10 = b15;
                i13 = i16;
            }
            if (b14 <= -65 && (((b11 << 28) + (b14 + 112)) >> 30) == 0 && b10 <= -65) {
                i11 = i13 + 1;
            }
            return -1;
            i11 = i14;
        }
        return partialIsValidUtf8(bArr, i11, i12);
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i10, int i11) {
        while (i10 < i11) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 < 0) {
                if (b10 < -32) {
                    if (i12 >= i11) {
                        return b10;
                    }
                    if (b10 >= -62) {
                        i10 += 2;
                        if (bArr[i12] > -65) {
                        }
                    }
                    return -1;
                }
                if (b10 < -16) {
                    if (i12 >= i11 - 1) {
                        return incompleteStateFor(bArr, i12, i11);
                    }
                    int i13 = i10 + 2;
                    byte b11 = bArr[i12];
                    if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                        i10 += 3;
                        if (bArr[i13] > -65) {
                        }
                    }
                    return -1;
                }
                if (i12 >= i11 - 2) {
                    return incompleteStateFor(bArr, i12, i11);
                }
                int i14 = i10 + 2;
                byte b12 = bArr[i12];
                if (b12 <= -65 && (((b10 << 28) + (b12 + 112)) >> 30) == 0) {
                    int i15 = i10 + 3;
                    if (bArr[i14] <= -65) {
                        i10 += 4;
                        if (bArr[i15] > -65) {
                        }
                    }
                }
                return -1;
            }
            i10 = i12;
        }
        return 0;
    }

    private static int incompleteStateFor(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i10, int i11) {
        return partialIsValidUtf8(bArr, i10, i11) == 0;
    }

    private static int incompleteStateFor(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    private static int incompleteStateFor(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return incompleteStateFor(b10);
        }
        if (i12 == 1) {
            return incompleteStateFor(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return incompleteStateFor(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    public static int partialIsValidUtf8(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && bArr[i10] >= 0) {
            i10++;
        }
        if (i10 >= i11) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i10, i11);
    }
}
