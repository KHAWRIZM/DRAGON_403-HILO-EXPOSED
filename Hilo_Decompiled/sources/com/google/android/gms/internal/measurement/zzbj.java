package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzbj extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbj() {
        this.zza.add(zzbk.ASSIGN);
        this.zza.add(zzbk.CONST);
        this.zza.add(zzbk.CREATE_ARRAY);
        this.zza.add(zzbk.CREATE_OBJECT);
        this.zza.add(zzbk.EXPRESSION_LIST);
        this.zza.add(zzbk.GET);
        this.zza.add(zzbk.GET_INDEX);
        this.zza.add(zzbk.GET_PROPERTY);
        this.zza.add(zzbk.NULL);
        this.zza.add(zzbk.SET_PROPERTY);
        this.zza.add(zzbk.TYPEOF);
        this.zza.add(zzbk.UNDEFINED);
        this.zza.add(zzbk.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzao zza;
        zzao zza2;
        String str2;
        int i10 = 0;
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 3) {
            if (ordinal == 14) {
                zzh.zzb(zzbk.CONST.name(), 2, list);
                if (list.size() % 2 == 0) {
                    for (int i11 = 0; i11 < list.size() - 1; i11 += 2) {
                        zzao zza3 = zzgVar.zza((zzao) list.get(i11));
                        if (zza3 instanceof zzas) {
                            zzgVar.zzg(zza3.zzc(), zzgVar.zza((zzao) list.get(i11 + 1)));
                        } else {
                            throw new IllegalArgumentException(String.format("Expected string for const name. got %s", zza3.getClass().getCanonicalName()));
                        }
                    }
                    return zzao.zzf;
                }
                throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            if (ordinal == 24) {
                zzh.zzb(zzbk.EXPRESSION_LIST.name(), 1, list);
                zzao zzaoVar = zzao.zzf;
                while (i10 < list.size()) {
                    zzaoVar = zzgVar.zza((zzao) list.get(i10));
                    if (zzaoVar instanceof zzag) {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                    i10++;
                }
                return zzaoVar;
            }
            if (ordinal == 33) {
                zzh.zza(zzbk.GET.name(), 1, list);
                zzao zza4 = zzgVar.zza((zzao) list.get(0));
                if (zza4 instanceof zzas) {
                    return zzgVar.zzh(zza4.zzc());
                }
                throw new IllegalArgumentException(String.format("Expected string for get var. got %s", zza4.getClass().getCanonicalName()));
            }
            if (ordinal == 49) {
                zzh.zza(zzbk.NULL.name(), 0, list);
                return zzao.zzg;
            }
            if (ordinal == 58) {
                zzh.zza(zzbk.SET_PROPERTY.name(), 3, list);
                zzao zza5 = zzgVar.zza((zzao) list.get(0));
                zzao zza6 = zzgVar.zza((zzao) list.get(1));
                zza2 = zzgVar.zza((zzao) list.get(2));
                if (zza5 != zzao.zzf && zza5 != zzao.zzg) {
                    if ((zza5 instanceof zzae) && (zza6 instanceof zzah)) {
                        ((zzae) zza5).zzn(zza6.zzd().intValue(), zza2);
                    } else if (zza5 instanceof zzak) {
                        ((zzak) zza5).zzm(zza6.zzc(), zza2);
                        return zza2;
                    }
                } else {
                    throw new IllegalStateException(String.format("Can't set property %s of %s", zza6.zzc(), zza5.zzc()));
                }
            } else {
                if (ordinal == 17) {
                    if (list.isEmpty()) {
                        return new zzae();
                    }
                    zzae zzaeVar = new zzae();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzao zza7 = zzgVar.zza((zzao) it.next());
                        if (!(zza7 instanceof zzag)) {
                            zzaeVar.zzn(i10, zza7);
                            i10++;
                        } else {
                            throw new IllegalStateException("Failed to evaluate array element");
                        }
                    }
                    return zzaeVar;
                }
                if (ordinal == 18) {
                    if (list.isEmpty()) {
                        return new zzal();
                    }
                    if (list.size() % 2 == 0) {
                        zzal zzalVar = new zzal();
                        while (i10 < list.size() - 1) {
                            zzao zza8 = zzgVar.zza((zzao) list.get(i10));
                            zzao zza9 = zzgVar.zza((zzao) list.get(i10 + 1));
                            if (!(zza8 instanceof zzag) && !(zza9 instanceof zzag)) {
                                zzalVar.zzm(zza8.zzc(), zza9);
                                i10 += 2;
                            } else {
                                throw new IllegalStateException("Failed to evaluate map entry");
                            }
                        }
                        return zzalVar;
                    }
                    throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
                }
                if (ordinal != 35 && ordinal != 36) {
                    switch (ordinal) {
                        case 62:
                            zzh.zza(zzbk.TYPEOF.name(), 1, list);
                            zzao zza10 = zzgVar.zza((zzao) list.get(0));
                            if (zza10 instanceof zzat) {
                                str2 = "undefined";
                            } else if (zza10 instanceof zzaf) {
                                str2 = "boolean";
                            } else if (zza10 instanceof zzah) {
                                str2 = "number";
                            } else if (zza10 instanceof zzas) {
                                str2 = "string";
                            } else if (zza10 instanceof zzan) {
                                str2 = "function";
                            } else {
                                if ((zza10 instanceof zzap) || (zza10 instanceof zzag)) {
                                    throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zza10));
                                }
                                str2 = "object";
                            }
                            zza2 = new zzas(str2);
                            break;
                        case 63:
                            zzh.zza(zzbk.UNDEFINED.name(), 0, list);
                            return zzao.zzf;
                        case 64:
                            zzh.zzb(zzbk.VAR.name(), 1, list);
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                zzao zza11 = zzgVar.zza((zzao) it2.next());
                                if (zza11 instanceof zzas) {
                                    zzgVar.zzf(zza11.zzc(), zzao.zzf);
                                } else {
                                    throw new IllegalArgumentException(String.format("Expected string for var name. got %s", zza11.getClass().getCanonicalName()));
                                }
                            }
                            return zzao.zzf;
                        default:
                            return super.zzb(str);
                    }
                } else {
                    zzh.zza(zzbk.GET_PROPERTY.name(), 2, list);
                    zzao zza12 = zzgVar.zza((zzao) list.get(0));
                    zzao zza13 = zzgVar.zza((zzao) list.get(1));
                    if ((zza12 instanceof zzae) && zzh.zzd(zza13)) {
                        return ((zzae) zza12).zzl(zza13.zzd().intValue());
                    }
                    if (zza12 instanceof zzak) {
                        return ((zzak) zza12).zzk(zza13.zzc());
                    }
                    if (zza12 instanceof zzas) {
                        if ("length".equals(zza13.zzc())) {
                            zza2 = new zzah(Double.valueOf(zza12.zzc().length()));
                        } else if (zzh.zzd(zza13) && zza13.zzd().doubleValue() < zza12.zzc().length()) {
                            zza = new zzas(String.valueOf(zza12.zzc().charAt(zza13.zzd().intValue())));
                        }
                    }
                    return zzao.zzf;
                }
            }
            return zza2;
        }
        zzh.zza(zzbk.ASSIGN.name(), 2, list);
        zzao zza14 = zzgVar.zza((zzao) list.get(0));
        if (zza14 instanceof zzas) {
            if (zzgVar.zzd(zza14.zzc())) {
                zza = zzgVar.zza((zzao) list.get(1));
                zzgVar.zze(zza14.zzc(), zza);
            } else {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", zza14.zzc()));
            }
        } else {
            throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", zza14.getClass().getCanonicalName()));
        }
        return zza;
    }
}
