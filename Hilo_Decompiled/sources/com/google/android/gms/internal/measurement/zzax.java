package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzax extends zzav {
    public zzax() {
        this.zza.add(zzbk.EQUALS);
        this.zza.add(zzbk.GREATER_THAN);
        this.zza.add(zzbk.GREATER_THAN_EQUALS);
        this.zza.add(zzbk.IDENTITY_EQUALS);
        this.zza.add(zzbk.IDENTITY_NOT_EQUALS);
        this.zza.add(zzbk.LESS_THAN);
        this.zza.add(zzbk.LESS_THAN_EQUALS);
        this.zza.add(zzbk.NOT_EQUALS);
    }

    private static boolean zzc(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar instanceof zzak) {
            zzaoVar = new zzas(zzaoVar.zzc());
        }
        if (zzaoVar2 instanceof zzak) {
            zzaoVar2 = new zzas(zzaoVar2.zzc());
        }
        if ((zzaoVar instanceof zzas) && (zzaoVar2 instanceof zzas)) {
            if (zzaoVar.zzc().compareTo(zzaoVar2.zzc()) < 0) {
                return true;
            }
            return false;
        }
        double doubleValue = zzaoVar.zzd().doubleValue();
        double doubleValue2 = zzaoVar2.zzd().doubleValue();
        if (!Double.isNaN(doubleValue) && !Double.isNaN(doubleValue2) && ((doubleValue != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || doubleValue2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) && ((doubleValue != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || doubleValue2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) && Double.compare(doubleValue, doubleValue2) < 0))) {
            return true;
        }
        return false;
    }

    private static boolean zzd(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar.getClass().equals(zzaoVar2.getClass())) {
            if ((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) {
                return true;
            }
            if (zzaoVar instanceof zzah) {
                if (Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue()) || zzaoVar.zzd().doubleValue() != zzaoVar2.zzd().doubleValue()) {
                    return false;
                }
                return true;
            }
            if (zzaoVar instanceof zzas) {
                return zzaoVar.zzc().equals(zzaoVar2.zzc());
            }
            if (zzaoVar instanceof zzaf) {
                return zzaoVar.zze().equals(zzaoVar2.zze());
            }
            if (zzaoVar != zzaoVar2) {
                return false;
            }
            return true;
        }
        if (((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) && ((zzaoVar2 instanceof zzat) || (zzaoVar2 instanceof zzam))) {
            return true;
        }
        boolean z10 = zzaoVar instanceof zzah;
        if (z10 && (zzaoVar2 instanceof zzas)) {
            return zzd(zzaoVar, new zzah(zzaoVar2.zzd()));
        }
        boolean z11 = zzaoVar instanceof zzas;
        if (z11 && (zzaoVar2 instanceof zzah)) {
            return zzd(new zzah(zzaoVar.zzd()), zzaoVar2);
        }
        if (zzaoVar instanceof zzaf) {
            return zzd(new zzah(zzaoVar.zzd()), zzaoVar2);
        }
        if (zzaoVar2 instanceof zzaf) {
            return zzd(zzaoVar, new zzah(zzaoVar2.zzd()));
        }
        if ((!z11 && !z10) || !(zzaoVar2 instanceof zzak)) {
            if (!(zzaoVar instanceof zzak) || (!(zzaoVar2 instanceof zzas) && !(zzaoVar2 instanceof zzah))) {
                return false;
            }
            return zzd(new zzas(zzaoVar.zzc()), zzaoVar2);
        }
        return zzd(zzaoVar, new zzas(zzaoVar2.zzc()));
    }

    private static boolean zze(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar instanceof zzak) {
            zzaoVar = new zzas(zzaoVar.zzc());
        }
        if (zzaoVar2 instanceof zzak) {
            zzaoVar2 = new zzas(zzaoVar2.zzc());
        }
        if (((!(zzaoVar instanceof zzas) || !(zzaoVar2 instanceof zzas)) && (Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue()))) || zzc(zzaoVar2, zzaoVar)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x003a. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        boolean zzd;
        boolean zzd2;
        zzh.zza(zzh.zze(str).name(), 2, list);
        zzao zza = zzgVar.zza((zzao) list.get(0));
        zzao zza2 = zzgVar.zza((zzao) list.get(1));
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 23) {
            if (ordinal != 48) {
                if (ordinal != 42) {
                    if (ordinal != 43) {
                        switch (ordinal) {
                            case 37:
                                zzd = zzc(zza2, zza);
                                break;
                            case 38:
                                zzd = zze(zza2, zza);
                                break;
                            case 39:
                                zzd = zzh.zzf(zza, zza2);
                                break;
                            case 40:
                                zzd2 = zzh.zzf(zza, zza2);
                                break;
                            default:
                                return super.zzb(str);
                        }
                    } else {
                        zzd = zze(zza, zza2);
                    }
                } else {
                    zzd = zzc(zza, zza2);
                }
            } else {
                zzd2 = zzd(zza, zza2);
            }
            zzd = !zzd2;
        } else {
            zzd = zzd(zza, zza2);
        }
        if (zzd) {
            return zzao.zzk;
        }
        return zzao.zzl;
    }
}
