package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzl extends zzal {
    private final zzab zzb;

    public zzl(zzab zzabVar) {
        this.zzb = zzabVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzal, com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        char c10;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        if (c10 != 0) {
            if (c10 != 1) {
                if (c10 != 2) {
                    if (c10 != 3) {
                        if (c10 != 4) {
                            if (c10 != 5) {
                                return super.zzcA(str, zzgVar, list);
                            }
                            zzh.zza("setParamValue", 2, list);
                            String zzc = zzgVar.zza((zzao) list.get(0)).zzc();
                            zzao zza = zzgVar.zza((zzao) list.get(1));
                            this.zzb.zzc().zzd(zzc, zzh.zzj(zza));
                            return zza;
                        }
                        zzh.zza("setEventName", 1, list);
                        zzao zza2 = zzgVar.zza((zzao) list.get(0));
                        if (!zzao.zzf.equals(zza2) && !zzao.zzg.equals(zza2)) {
                            this.zzb.zzc().zzc(zza2.zzc());
                            return new zzas(zza2.zzc());
                        }
                        throw new IllegalArgumentException("Illegal event name");
                    }
                    zzh.zza("getTimestamp", 0, list);
                    return new zzah(Double.valueOf(this.zzb.zzc().zza()));
                }
                zzh.zza("getParams", 0, list);
                Map zzf = this.zzb.zzc().zzf();
                zzal zzalVar = new zzal();
                for (String str2 : zzf.keySet()) {
                    zzalVar.zzm(str2, zzi.zza(zzf.get(str2)));
                }
                return zzalVar;
            }
            zzh.zza("getParamValue", 1, list);
            return zzi.zza(this.zzb.zzc().zze(zzgVar.zza((zzao) list.get(0)).zzc()));
        }
        zzh.zza("getEventName", 0, list);
        return new zzas(this.zzb.zzc().zzb());
    }
}
