package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzor {
    public static final /* synthetic */ int zza = 0;

    static {
        if (zzoo.zza() && zzoo.zzb()) {
            int i10 = zzku.zza;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zza(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && bArr[i10] >= 0) {
            i10++;
        }
        if (i10 < i11) {
            while (i10 < i11) {
                int i12 = i10 + 1;
                int i13 = bArr[i10];
                if (i13 < 0) {
                    if (i13 < -32) {
                        if (i12 < i11) {
                            if (i13 >= -62) {
                                i10 += 2;
                                if (bArr[i12] > -65) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            if (i13 != 0) {
                                return false;
                            }
                            return true;
                        }
                    } else if (i13 < -16) {
                        if (i12 >= i11 - 1) {
                            i13 = zzd(bArr, i12, i11);
                            if (i13 != 0) {
                            }
                        } else {
                            int i14 = i10 + 2;
                            char c10 = bArr[i12];
                            if (c10 <= -65) {
                                if (i13 != -32 || c10 >= -96) {
                                    if (i13 != -19 || c10 < -96) {
                                        i10 += 3;
                                        if (bArr[i14] > -65) {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        }
                    } else if (i12 >= i11 - 2) {
                        i13 = zzd(bArr, i12, i11);
                        if (i13 != 0) {
                        }
                    } else {
                        int i15 = i10 + 2;
                        int i16 = bArr[i12];
                        if (i16 <= -65 && (((i13 << 28) + (i16 + 112)) >> 30) == 0) {
                            int i17 = i10 + 3;
                            if (bArr[i15] <= -65) {
                                i10 += 4;
                                if (bArr[i17] > -65) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    i10 = i12;
                }
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && str.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char charAt = str.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                int length2 = str.length();
                while (i11 < length2) {
                    char charAt2 = str.charAt(i11);
                    if (charAt2 < 2048) {
                        i10 += (127 - charAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i11) >= 65536) {
                                i11++;
                            } else {
                                throw new zzoq(i11, length2);
                            }
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        long j10 = i12 + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j10).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j10);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0114, code lost:
    
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzc(String str, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        char charAt;
        int length = str.length();
        int i15 = 0;
        while (true) {
            i12 = i10 + i11;
            if (i15 >= length || (i14 = i15 + i10) >= i12 || (charAt = str.charAt(i15)) >= 128) {
                break;
            }
            bArr[i14] = (byte) charAt;
            i15++;
        }
        int i16 = i10 + i15;
        while (i15 < length) {
            char charAt2 = str.charAt(i15);
            if (charAt2 < 128 && i16 < i12) {
                bArr[i16] = (byte) charAt2;
                i16++;
            } else if (charAt2 < 2048 && i16 <= i12 - 2) {
                bArr[i16] = (byte) ((charAt2 >>> 6) | 960);
                bArr[i16 + 1] = (byte) ((charAt2 & '?') | 128);
                i16 += 2;
            } else if ((charAt2 < 55296 || charAt2 > 57343) && i16 <= i12 - 3) {
                bArr[i16] = (byte) ((charAt2 >>> '\f') | 480);
                bArr[i16 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                bArr[i16 + 2] = (byte) ((charAt2 & '?') | 128);
                i16 += 3;
            } else {
                if (i16 <= i12 - 4) {
                    int i17 = i15 + 1;
                    if (i17 != str.length()) {
                        char charAt3 = str.charAt(i17);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int i18 = i16 + 3;
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i16 += 4;
                            bArr[i18] = (byte) ((codePoint & 63) | 128);
                            i15 = i17;
                        } else {
                            i15 = i17;
                        }
                    }
                    throw new zzoq(i15 - 1, length);
                }
                if (charAt2 >= 55296 && charAt2 <= 57343 && ((i13 = i15 + 1) == str.length() || !Character.isSurrogatePair(charAt2, str.charAt(i13)))) {
                    throw new zzoq(i15, length);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(charAt2).length() + 25 + String.valueOf(i16).length());
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i16);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            i15++;
        }
        return i16;
    }

    static /* synthetic */ int zzd(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        byte b10 = bArr[i10 - 1];
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    byte b11 = bArr[i10];
                    byte b12 = bArr[i10 + 1];
                    if (b10 <= -12 && b11 <= -65 && b12 <= -65) {
                        return (b12 << 16) ^ ((b11 << 8) ^ b10);
                    }
                    return -1;
                }
                throw new AssertionError();
            }
            byte b13 = bArr[i10];
            if (b10 <= -12 && b13 <= -65) {
                return (b13 << 8) ^ b10;
            }
            return -1;
        }
        if (b10 <= -12) {
            return b10;
        }
        return -1;
    }
}
