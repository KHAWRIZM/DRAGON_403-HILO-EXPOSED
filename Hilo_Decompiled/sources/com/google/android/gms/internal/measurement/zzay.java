package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzay extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzay() {
        this.zza.add(zzbk.APPLY);
        this.zza.add(zzbk.BLOCK);
        this.zza.add(zzbk.BREAK);
        this.zza.add(zzbk.CASE);
        this.zza.add(zzbk.DEFAULT);
        this.zza.add(zzbk.CONTINUE);
        this.zza.add(zzbk.DEFINE_FUNCTION);
        this.zza.add(zzbk.FN);
        this.zza.add(zzbk.IF);
        this.zza.add(zzbk.QUOTE);
        this.zza.add(zzbk.RETURN);
        this.zza.add(zzbk.SWITCH);
        this.zza.add(zzbk.TERNARY);
    }

    private static zzao zzc(zzg zzgVar, List list) {
        zzh.zzb(zzbk.FN.name(), 2, list);
        zzao zza = zzgVar.zza((zzao) list.get(0));
        zzao zza2 = zzgVar.zza((zzao) list.get(1));
        if (zza2 instanceof zzae) {
            List zzb = ((zzae) zza2).zzb();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new zzan(zza.zzc(), zzb, arrayList, zzgVar);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", zza2.getClass().getCanonicalName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzao zzaoVar;
        zzao zzaoVar2;
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 2) {
            if (ordinal != 15) {
                if (ordinal != 25) {
                    if (ordinal != 41) {
                        if (ordinal != 54) {
                            if (ordinal != 57) {
                                if (ordinal != 19) {
                                    if (ordinal != 20) {
                                        if (ordinal != 60) {
                                            if (ordinal != 61) {
                                                switch (ordinal) {
                                                    case 11:
                                                        return zzgVar.zzc().zzb(new zzae(list));
                                                    case 12:
                                                        zzh.zza(zzbk.BREAK.name(), 0, list);
                                                        return zzao.zzi;
                                                    case 13:
                                                        break;
                                                    default:
                                                        return super.zzb(str);
                                                }
                                            } else {
                                                zzh.zza(zzbk.TERNARY.name(), 3, list);
                                                if (zzgVar.zza((zzao) list.get(0)).zze().booleanValue()) {
                                                    return zzgVar.zza((zzao) list.get(1));
                                                }
                                                return zzgVar.zza((zzao) list.get(2));
                                            }
                                        } else {
                                            zzh.zza(zzbk.SWITCH.name(), 3, list);
                                            zzao zza = zzgVar.zza((zzao) list.get(0));
                                            zzao zza2 = zzgVar.zza((zzao) list.get(1));
                                            zzao zza3 = zzgVar.zza((zzao) list.get(2));
                                            if (zza2 instanceof zzae) {
                                                if (zza3 instanceof zzae) {
                                                    zzae zzaeVar = (zzae) zza2;
                                                    zzae zzaeVar2 = (zzae) zza3;
                                                    boolean z10 = false;
                                                    for (int i10 = 0; i10 < zzaeVar.zzh(); i10++) {
                                                        if (!z10 && !zza.equals(zzgVar.zza(zzaeVar.zzl(i10)))) {
                                                            z10 = false;
                                                        } else {
                                                            zzao zza4 = zzgVar.zza(zzaeVar2.zzl(i10));
                                                            if (zza4 instanceof zzag) {
                                                                if (((zzag) zza4).zzg().equals("break")) {
                                                                    return zzao.zzf;
                                                                }
                                                                return zza4;
                                                            }
                                                            z10 = true;
                                                        }
                                                    }
                                                    if (zzaeVar.zzh() + 1 == zzaeVar2.zzh()) {
                                                        zzao zza5 = zzgVar.zza(zzaeVar2.zzl(zzaeVar.zzh()));
                                                        if (zza5 instanceof zzag) {
                                                            String zzg = ((zzag) zza5).zzg();
                                                            if (zzg.equals("return") || zzg.equals("continue")) {
                                                                return zza5;
                                                            }
                                                        }
                                                    }
                                                    return zzao.zzf;
                                                }
                                                throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                                            }
                                            throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                                        }
                                    } else {
                                        zzh.zzb(zzbk.DEFINE_FUNCTION.name(), 2, list);
                                        zzan zzanVar = (zzan) zzc(zzgVar, list);
                                        if (zzanVar.zzg() == null) {
                                            zzgVar.zze("", zzanVar);
                                            return zzanVar;
                                        }
                                        zzgVar.zze(zzanVar.zzg(), zzanVar);
                                        return zzanVar;
                                    }
                                }
                                if (list.isEmpty()) {
                                    return zzao.zzf;
                                }
                                zzao zza6 = zzgVar.zza((zzao) list.get(0));
                                if (zza6 instanceof zzae) {
                                    return zzgVar.zzb((zzae) zza6);
                                }
                                return zzao.zzf;
                            }
                            if (list.isEmpty()) {
                                return zzao.zzj;
                            }
                            zzh.zza(zzbk.RETURN.name(), 1, list);
                            return new zzag("return", zzgVar.zza((zzao) list.get(0)));
                        }
                        return new zzae(list);
                    }
                    zzh.zzb(zzbk.IF.name(), 2, list);
                    zzao zza7 = zzgVar.zza((zzao) list.get(0));
                    zzao zza8 = zzgVar.zza((zzao) list.get(1));
                    if (list.size() > 2) {
                        zzaoVar = zzgVar.zza((zzao) list.get(2));
                    } else {
                        zzaoVar = null;
                    }
                    zzao zzaoVar3 = zzao.zzf;
                    if (zza7.zze().booleanValue()) {
                        zzaoVar2 = zzgVar.zzb((zzae) zza8);
                    } else if (zzaoVar != null) {
                        zzaoVar2 = zzgVar.zzb((zzae) zzaoVar);
                    } else {
                        zzaoVar2 = zzaoVar3;
                    }
                    if (true != (zzaoVar2 instanceof zzag)) {
                        return zzaoVar3;
                    }
                    return zzaoVar2;
                }
                return zzc(zzgVar, list);
            }
            zzh.zza(zzbk.BREAK.name(), 0, list);
            return zzao.zzh;
        }
        zzh.zza(zzbk.APPLY.name(), 3, list);
        zzao zza9 = zzgVar.zza((zzao) list.get(0));
        String zzc = zzgVar.zza((zzao) list.get(1)).zzc();
        zzao zza10 = zzgVar.zza((zzao) list.get(2));
        if (zza10 instanceof zzae) {
            if (!zzc.isEmpty()) {
                return zza9.zzcA(zzc, zzgVar, ((zzae) zza10).zzb());
            }
            throw new IllegalArgumentException("Function name for apply is undefined");
        }
        throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", zza10.getClass().getCanonicalName()));
    }
}
