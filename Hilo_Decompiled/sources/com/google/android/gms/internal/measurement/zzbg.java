package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzbg extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbg() {
        this.zza.add(zzbk.FOR_IN);
        this.zza.add(zzbk.FOR_IN_CONST);
        this.zza.add(zzbk.FOR_IN_LET);
        this.zza.add(zzbk.FOR_LET);
        this.zza.add(zzbk.FOR_OF);
        this.zza.add(zzbk.FOR_OF_CONST);
        this.zza.add(zzbk.FOR_OF_LET);
        this.zza.add(zzbk.WHILE);
    }

    private static zzao zzc(zzbe zzbeVar, zzao zzaoVar, zzao zzaoVar2) {
        return zze(zzbeVar, zzaoVar.zzf(), zzaoVar2);
    }

    private static zzao zzd(zzbe zzbeVar, zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar instanceof Iterable) {
            return zze(zzbeVar, ((Iterable) zzaoVar).iterator(), zzaoVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    private static zzao zze(zzbe zzbeVar, Iterator it, zzao zzaoVar) {
        if (it != null) {
            while (it.hasNext()) {
                zzao zzb = zzbeVar.zza((zzao) it.next()).zzb((zzae) zzaoVar);
                if (zzb instanceof zzag) {
                    zzag zzagVar = (zzag) zzb;
                    if ("break".equals(zzagVar.zzg())) {
                        return zzao.zzf;
                    }
                    if ("return".equals(zzagVar.zzg())) {
                        return zzagVar;
                    }
                }
            }
        }
        return zzao.zzf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x02b0, code lost:
    
        if ("return".equals(r1.zzg()) != false) goto L٧٠;
     */
    @Override // com.google.android.gms.internal.measurement.zzav
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzag zzagVar;
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 65) {
            switch (ordinal) {
                case 26:
                    zzh.zza(zzbk.FOR_IN.name(), 3, list);
                    if (list.get(0) instanceof zzas) {
                        String zzc = ((zzao) list.get(0)).zzc();
                        return zzc(new zzbf(zzgVar, zzc), zzgVar.zza((zzao) list.get(1)), zzgVar.zza((zzao) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                case 27:
                    zzh.zza(zzbk.FOR_IN_CONST.name(), 3, list);
                    if (list.get(0) instanceof zzas) {
                        String zzc2 = ((zzao) list.get(0)).zzc();
                        return zzc(new zzbc(zzgVar, zzc2), zzgVar.zza((zzao) list.get(1)), zzgVar.zza((zzao) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                case 28:
                    zzh.zza(zzbk.FOR_IN_LET.name(), 3, list);
                    if (list.get(0) instanceof zzas) {
                        String zzc3 = ((zzao) list.get(0)).zzc();
                        return zzc(new zzbd(zzgVar, zzc3), zzgVar.zza((zzao) list.get(1)), zzgVar.zza((zzao) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                case 29:
                    zzh.zza(zzbk.FOR_LET.name(), 4, list);
                    zzao zza = zzgVar.zza((zzao) list.get(0));
                    if (zza instanceof zzae) {
                        zzae zzaeVar = (zzae) zza;
                        zzao zzaoVar = (zzao) list.get(1);
                        zzao zzaoVar2 = (zzao) list.get(2);
                        zzao zza2 = zzgVar.zza((zzao) list.get(3));
                        zzg zzc4 = zzgVar.zzc();
                        for (int i10 = 0; i10 < zzaeVar.zzh(); i10++) {
                            String zzc5 = zzaeVar.zzl(i10).zzc();
                            zzc4.zze(zzc5, zzgVar.zzh(zzc5));
                        }
                        while (zzgVar.zza(zzaoVar).zze().booleanValue()) {
                            zzao zzb = zzgVar.zzb((zzae) zza2);
                            if (zzb instanceof zzag) {
                                zzag zzagVar2 = (zzag) zzb;
                                if ("break".equals(zzagVar2.zzg())) {
                                    return zzao.zzf;
                                }
                                if ("return".equals(zzagVar2.zzg())) {
                                    return zzagVar2;
                                }
                            }
                            zzg zzc6 = zzgVar.zzc();
                            for (int i11 = 0; i11 < zzaeVar.zzh(); i11++) {
                                String zzc7 = zzaeVar.zzl(i11).zzc();
                                zzc6.zze(zzc7, zzc4.zzh(zzc7));
                            }
                            zzc6.zza(zzaoVar2);
                            zzc4 = zzc6;
                        }
                        return zzao.zzf;
                    }
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                case 30:
                    zzh.zza(zzbk.FOR_OF.name(), 3, list);
                    if (list.get(0) instanceof zzas) {
                        String zzc8 = ((zzao) list.get(0)).zzc();
                        return zzd(new zzbf(zzgVar, zzc8), zzgVar.zza((zzao) list.get(1)), zzgVar.zza((zzao) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                case 31:
                    zzh.zza(zzbk.FOR_OF_CONST.name(), 3, list);
                    if (list.get(0) instanceof zzas) {
                        String zzc9 = ((zzao) list.get(0)).zzc();
                        return zzd(new zzbc(zzgVar, zzc9), zzgVar.zza((zzao) list.get(1)), zzgVar.zza((zzao) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                case 32:
                    zzh.zza(zzbk.FOR_OF_LET.name(), 3, list);
                    if (list.get(0) instanceof zzas) {
                        String zzc10 = ((zzao) list.get(0)).zzc();
                        return zzd(new zzbd(zzgVar, zzc10), zzgVar.zza((zzao) list.get(1)), zzgVar.zza((zzao) list.get(2)));
                    }
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                default:
                    return super.zzb(str);
            }
        }
        zzh.zza(zzbk.WHILE.name(), 4, list);
        zzao zzaoVar3 = (zzao) list.get(0);
        zzao zzaoVar4 = (zzao) list.get(1);
        zzao zzaoVar5 = (zzao) list.get(2);
        zzao zza3 = zzgVar.zza((zzao) list.get(3));
        if (zzgVar.zza(zzaoVar5).zze().booleanValue()) {
            zzao zzb2 = zzgVar.zzb((zzae) zza3);
            if (zzb2 instanceof zzag) {
                zzagVar = (zzag) zzb2;
                if ("break".equals(zzagVar.zzg())) {
                    return zzao.zzf;
                }
            }
        }
        while (zzgVar.zza(zzaoVar3).zze().booleanValue()) {
            zzao zzb3 = zzgVar.zzb((zzae) zza3);
            if (zzb3 instanceof zzag) {
                zzagVar = (zzag) zzb3;
                if ("break".equals(zzagVar.zzg())) {
                    return zzao.zzf;
                }
                if ("return".equals(zzagVar.zzg())) {
                    return zzagVar;
                }
            }
            zzgVar.zza(zzaoVar4);
        }
        return zzao.zzf;
    }
}
