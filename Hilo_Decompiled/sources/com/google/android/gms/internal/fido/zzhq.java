package com.google.android.gms.internal.fido;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzhp zza(InputStream inputStream, zzhs zzhsVar) throws zzhj {
        try {
            return zzb(inputStream, zzhsVar);
        } finally {
            try {
                zzhsVar.close();
            } catch (IOException unused) {
            }
        }
    }

    private static final zzhp zzb(InputStream inputStream, zzhs zzhsVar) throws zzhj {
        long j10;
        int i10 = 0;
        try {
            zzhr zzd = zzhsVar.zzd();
            if (zzd != null) {
                try {
                    byte zza = zzd.zza();
                    byte zzb = zzd.zzb();
                    if (zzb != Byte.MIN_VALUE) {
                        if (zzb != -96) {
                            if (zzb != -64) {
                                if (zzb != -32) {
                                    if (zzb != 0 && zzb != 32) {
                                        if (zzb != 64) {
                                            if (zzb == 96) {
                                                String zze = zzhsVar.zze();
                                                zzc(zza, zze.length(), inputStream, zzhsVar);
                                                return new zzhn(zze);
                                            }
                                            throw new zzhj("Unidentifiable major type: " + zzd.zzc());
                                        }
                                        byte[] zzg = zzhsVar.zzg();
                                        int length = zzg.length;
                                        zzc(zza, length, inputStream, zzhsVar);
                                        return new zzhi(zzgx.zzl(zzg, 0, length));
                                    }
                                    long zzb2 = zzhsVar.zzb();
                                    if (zzb2 > 0) {
                                        j10 = zzb2;
                                    } else {
                                        j10 = ~zzb2;
                                    }
                                    zzc(zza, j10, inputStream, zzhsVar);
                                    return new zzhk(zzb2);
                                }
                                return new zzhh(zzhsVar.zzf());
                            }
                            throw new zzhj("Tags are currently unsupported");
                        }
                        long zzc = zzhsVar.zzc();
                        if (zzc <= 1000) {
                            zzc(zza, zzc, inputStream, zzhsVar);
                            int i11 = (int) zzc;
                            zzhl[] zzhlVarArr = new zzhl[i11];
                            zzhp zzhpVar = null;
                            int i12 = 0;
                            while (i12 < zzc) {
                                zzhp zzb3 = zzb(inputStream, zzhsVar);
                                if (zzhpVar != null && zzb3.compareTo(zzhpVar) <= 0) {
                                    throw new zzhf(String.format("Keys in CBOR Map not in strictly ascending natural order:\nPrevious key: %s\nCurrent key: %s", zzhpVar.toString(), zzb3.toString()));
                                }
                                zzhlVarArr[i12] = new zzhl(zzb3, zzb(inputStream, zzhsVar));
                                i12++;
                                zzhpVar = zzb3;
                            }
                            TreeMap treeMap = new TreeMap();
                            while (i10 < i11) {
                                zzhl zzhlVar = zzhlVarArr[i10];
                                if (!treeMap.containsKey(zzhlVar.zza())) {
                                    treeMap.put(zzhlVar.zza(), zzhlVar.zzb());
                                    i10++;
                                } else {
                                    throw new zzhf("Attempted to add duplicate key to canonical CBOR Map.");
                                }
                            }
                            return new zzhm(zzcj.zzf(treeMap));
                        }
                        throw new zzhj("Parser being asked to read a large CBOR map");
                    }
                    long zza2 = zzhsVar.zza();
                    if (zza2 <= 1000) {
                        zzc(zza, zza2, inputStream, zzhsVar);
                        zzhp[] zzhpVarArr = new zzhp[(int) zza2];
                        while (i10 < zza2) {
                            zzhpVarArr[i10] = zzb(inputStream, zzhsVar);
                            i10++;
                        }
                        return new zzhg(zzcc.zzi(zzhpVarArr));
                    }
                    throw new zzhj("Parser being asked to read a large CBOR array");
                } catch (IOException e10) {
                    e = e10;
                    throw new zzhj("Error in decoding CborValue from bytes", e);
                } catch (RuntimeException e11) {
                    e = e11;
                    throw new zzhj("Error in decoding CborValue from bytes", e);
                }
            }
            throw new zzhj("Parser being asked to parse an empty input stream");
        } catch (IOException e12) {
            throw new zzhj("Error in decoding CborValue from bytes", e12);
        }
    }

    private static final void zzc(byte b10, long j10, InputStream inputStream, zzhs zzhsVar) throws IOException {
        switch (b10) {
            case 24:
                if (j10 >= 24) {
                    return;
                }
                throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0 additional bytes, but used 1");
            case 25:
                if (j10 < 256) {
                    throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0-1 additional bytes, but used 2");
                }
                return;
            case 26:
                if (j10 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0-2 additional bytes, but used 4");
                }
                return;
            case 27:
                if (j10 < 4294967296L) {
                    throw new zzhf("Integer value " + j10 + " after add info could have been represented in 0-4 additional bytes, but used 8");
                }
                return;
            default:
                return;
        }
    }
}
