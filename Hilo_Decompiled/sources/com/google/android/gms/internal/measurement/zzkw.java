package com.google.android.gms.internal.measurement;

import io.agora.rtc.Constants;
import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzkw {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i10, zzkv zzkvVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 >= 0) {
            zzkvVar.zza = b10;
            return i11;
        }
        return zzb(b10, bArr, i11, zzkvVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i10, byte[] bArr, int i11, zzkv zzkvVar) {
        byte b10 = bArr[i11];
        int i12 = i11 + 1;
        int i13 = i10 & Constants.ERR_WATERMARKR_INFO;
        if (b10 >= 0) {
            zzkvVar.zza = i13 | (b10 << 7);
            return i12;
        }
        int i14 = i13 | ((b10 & ByteCompanionObject.MAX_VALUE) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzkvVar.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & ByteCompanionObject.MAX_VALUE) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzkvVar.zza = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & ByteCompanionObject.MAX_VALUE) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzkvVar.zza = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                zzkvVar.zza = i20;
                return i21;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i10, zzkv zzkvVar) {
        long j10 = bArr[i10];
        int i11 = i10 + 1;
        if (j10 >= 0) {
            zzkvVar.zzb = j10;
            return i11;
        }
        int i12 = i10 + 2;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | ((b10 & ByteCompanionObject.MAX_VALUE) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            i13 += 7;
            j11 |= (r10 & ByteCompanionObject.MAX_VALUE) << i13;
            b10 = bArr[i12];
            i12 = i14;
        }
        zzkvVar.zzb = j11;
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i10) {
        int i11 = bArr[i10] & UByte.MAX_VALUE;
        int i12 = bArr[i10 + 1] & UByte.MAX_VALUE;
        int i13 = bArr[i10 + 2] & UByte.MAX_VALUE;
        return ((bArr[i10 + 3] & UByte.MAX_VALUE) << 24) | (i12 << 8) | i11 | (i13 << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zze(byte[] bArr, int i10) {
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48) | ((bArr[i10 + 7] & 255) << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i10, zzkv zzkvVar) throws zzmq {
        int i11;
        int zza2 = zza(bArr, i10, zzkvVar);
        int i12 = zzkvVar.zza;
        if (i12 >= 0) {
            if (i12 == 0) {
                zzkvVar.zzc = "";
                return zza2;
            }
            int i13 = zzor.zza;
            int length = bArr.length;
            if ((((length - zza2) - i12) | zza2 | i12) >= 0) {
                int i14 = zza2 + i12;
                char[] cArr = new char[i12];
                int i15 = 0;
                while (zza2 < i14) {
                    byte b10 = bArr[zza2];
                    if (!zzop.zza(b10)) {
                        break;
                    }
                    zza2++;
                    cArr[i15] = (char) b10;
                    i15++;
                }
                int i16 = i15;
                while (zza2 < i14) {
                    int i17 = zza2 + 1;
                    byte b11 = bArr[zza2];
                    if (zzop.zza(b11)) {
                        cArr[i16] = (char) b11;
                        i16++;
                        zza2 = i17;
                        while (zza2 < i14) {
                            byte b12 = bArr[zza2];
                            if (zzop.zza(b12)) {
                                zza2++;
                                cArr[i16] = (char) b12;
                                i16++;
                            }
                        }
                    } else {
                        if (b11 < -32) {
                            if (i17 < i14) {
                                i11 = i16 + 1;
                                zza2 += 2;
                                zzop.zzb(b11, bArr[i17], cArr, i16);
                            } else {
                                throw new zzmq("Protocol message had invalid UTF-8.");
                            }
                        } else if (b11 < -16) {
                            if (i17 < i14 - 1) {
                                i11 = i16 + 1;
                                int i18 = zza2 + 2;
                                zza2 += 3;
                                zzop.zzc(b11, bArr[i17], bArr[i18], cArr, i16);
                            } else {
                                throw new zzmq("Protocol message had invalid UTF-8.");
                            }
                        } else if (i17 < i14 - 2) {
                            byte b13 = bArr[i17];
                            int i19 = zza2 + 3;
                            byte b14 = bArr[zza2 + 2];
                            zza2 += 4;
                            zzop.zzd(b11, b13, b14, bArr[i19], cArr, i16);
                            i16 += 2;
                        } else {
                            throw new zzmq("Protocol message had invalid UTF-8.");
                        }
                        i16 = i11;
                    }
                }
                zzkvVar.zzc = new String(cArr, 0, i16);
                return i14;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zza2), Integer.valueOf(i12)));
        }
        throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i10, zzkv zzkvVar) throws zzmq {
        int zza2 = zza(bArr, i10, zzkvVar);
        int i11 = zzkvVar.zza;
        if (i11 >= 0) {
            if (i11 <= bArr.length - zza2) {
                if (i11 == 0) {
                    zzkvVar.zzc = zzlg.zzb;
                    return zza2;
                }
                zzkvVar.zzc = zzlg.zzh(bArr, zza2, i11);
                return zza2 + i11;
            }
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zznw zznwVar, byte[] bArr, int i10, int i11, zzkv zzkvVar) throws IOException {
        Object zza2 = zznwVar.zza();
        int zzj = zzj(zza2, zznwVar, bArr, i10, i11, zzkvVar);
        zznwVar.zzj(zza2);
        zzkvVar.zzc = zza2;
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(zznw zznwVar, byte[] bArr, int i10, int i11, int i12, zzkv zzkvVar) throws IOException {
        Object zza2 = zznwVar.zza();
        int zzk = zzk(zza2, zznwVar, bArr, i10, i11, i12, zzkvVar);
        zznwVar.zzj(zza2);
        zzkvVar.zzc = zza2;
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(Object obj, zznw zznwVar, byte[] bArr, int i10, int i11, zzkv zzkvVar) throws IOException {
        int i12 = i10 + 1;
        int i13 = bArr[i10];
        if (i13 < 0) {
            i12 = zzb(i13, bArr, i12, zzkvVar);
            i13 = zzkvVar.zza;
        }
        int i14 = i12;
        if (i13 >= 0 && i13 <= i11 - i14) {
            int i15 = zzkvVar.zze + 1;
            zzkvVar.zze = i15;
            zzq(i15);
            int i16 = i13 + i14;
            zznwVar.zzi(obj, bArr, i14, i16, zzkvVar);
            zzkvVar.zze--;
            zzkvVar.zzc = obj;
            return i16;
        }
        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(Object obj, zznw zznwVar, byte[] bArr, int i10, int i11, int i12, zzkv zzkvVar) throws IOException {
        zzno zznoVar = (zzno) zznwVar;
        int i13 = zzkvVar.zze + 1;
        zzkvVar.zze = i13;
        zzq(i13);
        int zzh = zznoVar.zzh(obj, bArr, i10, i11, i12, zzkvVar);
        zzkvVar.zze--;
        zzkvVar.zzc = obj;
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i10, byte[] bArr, int i11, int i12, zzmn zzmnVar, zzkv zzkvVar) {
        zzmf zzmfVar = (zzmf) zzmnVar;
        int zza2 = zza(bArr, i11, zzkvVar);
        zzmfVar.zzh(zzkvVar.zza);
        while (zza2 < i12) {
            int zza3 = zza(bArr, zza2, zzkvVar);
            if (i10 != zzkvVar.zza) {
                break;
            }
            zza2 = zza(bArr, zza3, zzkvVar);
            zzmfVar.zzh(zzkvVar.zza);
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i10, zzmn zzmnVar, zzkv zzkvVar) throws IOException {
        zzmf zzmfVar = (zzmf) zzmnVar;
        int zza2 = zza(bArr, i10, zzkvVar);
        int i11 = zzkvVar.zza + zza2;
        while (zza2 < i11) {
            zza2 = zza(bArr, zza2, zzkvVar);
            zzmfVar.zzh(zzkvVar.zza);
        }
        if (zza2 == i11) {
            return zza2;
        }
        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(zznw zznwVar, int i10, byte[] bArr, int i11, int i12, zzmn zzmnVar, zzkv zzkvVar) throws IOException {
        int zzh = zzh(zznwVar, bArr, i11, i12, zzkvVar);
        zzmnVar.add(zzkvVar.zzc);
        while (zzh < i12) {
            int zza2 = zza(bArr, zzh, zzkvVar);
            if (i10 != zzkvVar.zza) {
                break;
            }
            zzh = zzh(zznwVar, bArr, zza2, i12, zzkvVar);
            zzmnVar.add(zzkvVar.zzc);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i10, byte[] bArr, int i11, int i12, zzoi zzoiVar, zzkv zzkvVar) throws zzmq {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 == 5) {
                                zzoiVar.zzk(i10, Integer.valueOf(zzd(bArr, i11)));
                                return i11 + 4;
                            }
                            throw new zzmq("Protocol message contained an invalid tag (zero).");
                        }
                        int i14 = (i10 & (-8)) | 4;
                        zzoi zzb2 = zzoi.zzb();
                        int i15 = zzkvVar.zze + 1;
                        zzkvVar.zze = i15;
                        zzq(i15);
                        int i16 = 0;
                        while (true) {
                            if (i11 >= i12) {
                                break;
                            }
                            int zza2 = zza(bArr, i11, zzkvVar);
                            i16 = zzkvVar.zza;
                            if (i16 == i14) {
                                i11 = zza2;
                                break;
                            }
                            i11 = zzo(i16, bArr, zza2, i12, zzb2, zzkvVar);
                        }
                        zzkvVar.zze--;
                        if (i11 <= i12 && i16 == i14) {
                            zzoiVar.zzk(i10, zzb2);
                            return i11;
                        }
                        throw new zzmq("Failed to parse the message.");
                    }
                    int zza3 = zza(bArr, i11, zzkvVar);
                    int i17 = zzkvVar.zza;
                    if (i17 >= 0) {
                        if (i17 <= bArr.length - zza3) {
                            if (i17 == 0) {
                                zzoiVar.zzk(i10, zzlg.zzb);
                            } else {
                                zzoiVar.zzk(i10, zzlg.zzh(bArr, zza3, i17));
                            }
                            return zza3 + i17;
                        }
                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                zzoiVar.zzk(i10, Long.valueOf(zze(bArr, i11)));
                return i11 + 8;
            }
            int zzc = zzc(bArr, i11, zzkvVar);
            zzoiVar.zzk(i10, Long.valueOf(zzkvVar.zzb));
            return zzc;
        }
        throw new zzmq("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i10, byte[] bArr, int i11, int i12, zzkv zzkvVar) throws zzmq {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (i13 == 5) {
                                return i11 + 4;
                            }
                            throw new zzmq("Protocol message contained an invalid tag (zero).");
                        }
                        int i14 = (i10 & (-8)) | 4;
                        int i15 = 0;
                        while (i11 < i12) {
                            i11 = zza(bArr, i11, zzkvVar);
                            i15 = zzkvVar.zza;
                            if (i15 == i14) {
                                break;
                            }
                            i11 = zzp(i15, bArr, i11, i12, zzkvVar);
                        }
                        if (i11 <= i12 && i15 == i14) {
                            return i11;
                        }
                        throw new zzmq("Failed to parse the message.");
                    }
                    return zza(bArr, i11, zzkvVar) + zzkvVar.zza;
                }
                return i11 + 8;
            }
            return zzc(bArr, i11, zzkvVar);
        }
        throw new zzmq("Protocol message contained an invalid tag (zero).");
    }

    private static void zzq(int i10) throws zzmq {
        if (i10 < zzb) {
        } else {
            throw new zzmq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
