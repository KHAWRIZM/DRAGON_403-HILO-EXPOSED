package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzaa extends zzab {
    final /* synthetic */ zzad zza;
    private final com.google.android.gms.internal.measurement.zzff zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(zzad zzadVar, String str, int i10, com.google.android.gms.internal.measurement.zzff zzffVar) {
        super(str, i10);
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzh = zzffVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return this.zzh.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x035f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0357  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzd(Long l10, Long l11, com.google.android.gms.internal.measurement.zzhs zzhsVar, long j10, zzbc zzbcVar, boolean z10) {
        long j11;
        boolean z11;
        boolean z12;
        Boolean zzi;
        Long l12;
        Double d10;
        Object obj;
        Integer num;
        zzpq.zza();
        zzad zzadVar = this.zza;
        zzib zzibVar = zzadVar.zzu;
        zzal zzc = zzibVar.zzc();
        String str = this.zzb;
        boolean zzp = zzc.zzp(str, zzfx.zzaF);
        com.google.android.gms.internal.measurement.zzff zzffVar = this.zzh;
        if (zzffVar.zzm()) {
            j11 = zzbcVar.zze;
        } else {
            j11 = j10;
        }
        Integer num2 = null;
        Integer num3 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        Boolean bool = null;
        if (Log.isLoggable(zzibVar.zzaV().zzn(), 2)) {
            zzgr zzk = zzibVar.zzaV().zzk();
            Integer valueOf = Integer.valueOf(this.zzc);
            if (zzffVar.zza()) {
                num = Integer.valueOf(zzffVar.zzb());
            } else {
                num = null;
            }
            zzk.zzd("Evaluating filter. audience, filter, event", valueOf, num, zzibVar.zzl().zza(zzffVar.zzc()));
            zzibVar.zzaV().zzk().zzb("Filter definition", zzadVar.zzg.zzp().zzj(zzffVar));
        }
        if (zzffVar.zza() && zzffVar.zzb() <= 256) {
            boolean zzi2 = zzffVar.zzi();
            boolean zzj = zzffVar.zzj();
            boolean zzm = zzffVar.zzm();
            if (zzi2 || zzj || zzm) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 && !z11) {
                zzgr zzk2 = zzibVar.zzaV().zzk();
                Integer valueOf2 = Integer.valueOf(this.zzc);
                if (zzffVar.zza()) {
                    num3 = Integer.valueOf(zzffVar.zzb());
                }
                zzk2.zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf2, num3);
                return true;
            }
            String zzd = zzhsVar.zzd();
            if (zzffVar.zzg()) {
                Boolean zzg = zzab.zzg(j11, zzffVar.zzh());
                if (zzg != null) {
                    if (!zzg.booleanValue()) {
                        bool = Boolean.FALSE;
                    }
                }
                zzgr zzk3 = zzibVar.zzaV().zzk();
                if (bool != null) {
                    obj = Constants.NULL_VERSION_ID;
                } else {
                    obj = bool;
                }
                zzk3.zzb("Event filter result", obj);
                if (bool != null) {
                    return false;
                }
                Boolean bool2 = Boolean.TRUE;
                this.zzd = bool2;
                if (!bool.booleanValue()) {
                    return true;
                }
                this.zze = bool2;
                if (z11 && zzhsVar.zze()) {
                    Long valueOf3 = Long.valueOf(zzhsVar.zzf());
                    if (zzffVar.zzj()) {
                        if (zzp && zzffVar.zzg()) {
                            valueOf3 = l10;
                        }
                        this.zzg = valueOf3;
                    } else {
                        if (zzp && zzffVar.zzg()) {
                            valueOf3 = l11;
                        }
                        this.zzf = valueOf3;
                    }
                }
                return true;
            }
            HashSet hashSet = new HashSet();
            Iterator it = zzffVar.zzd().iterator();
            while (true) {
                if (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzfh zzfhVar = (com.google.android.gms.internal.measurement.zzfh) it.next();
                    if (zzfhVar.zzh().isEmpty()) {
                        zzibVar.zzaV().zze().zzb("null or empty param name in filter. event", zzibVar.zzl().zza(zzd));
                        break;
                    }
                    hashSet.add(zzfhVar.zzh());
                } else {
                    androidx.collection.a aVar = new androidx.collection.a();
                    Iterator it2 = zzhsVar.zza().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it2.next();
                            if (hashSet.contains(zzhwVar.zzb())) {
                                if (zzhwVar.zze()) {
                                    String zzb = zzhwVar.zzb();
                                    if (zzhwVar.zze()) {
                                        l12 = Long.valueOf(zzhwVar.zzf());
                                    } else {
                                        l12 = null;
                                    }
                                    aVar.put(zzb, l12);
                                } else if (zzhwVar.zzi()) {
                                    String zzb2 = zzhwVar.zzb();
                                    if (zzhwVar.zzi()) {
                                        d10 = Double.valueOf(zzhwVar.zzj());
                                    } else {
                                        d10 = null;
                                    }
                                    aVar.put(zzb2, d10);
                                } else if (zzhwVar.zzc()) {
                                    aVar.put(zzhwVar.zzb(), zzhwVar.zzd());
                                } else {
                                    zzibVar.zzaV().zze().zzc("Unknown value for param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzhwVar.zzb()));
                                    break;
                                }
                            }
                        } else {
                            Iterator it3 = zzffVar.zzd().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzfh zzfhVar2 = (com.google.android.gms.internal.measurement.zzfh) it3.next();
                                    if (zzfhVar2.zze() && zzfhVar2.zzf()) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    String zzh = zzfhVar2.zzh();
                                    if (zzh.isEmpty()) {
                                        zzibVar.zzaV().zze().zzb("Event has empty param name. event", zzibVar.zzl().zza(zzd));
                                        break;
                                    }
                                    Object obj2 = aVar.get(zzh);
                                    if (obj2 instanceof Long) {
                                        if (!zzfhVar2.zzc()) {
                                            zzibVar.zzaV().zze().zzc("No number filter for long param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                            break;
                                        }
                                        Boolean zzg2 = zzab.zzg(((Long) obj2).longValue(), zzfhVar2.zzd());
                                        if (zzg2 == null) {
                                            break;
                                        }
                                        if (zzg2.booleanValue() == z12) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (obj2 instanceof Double) {
                                        if (!zzfhVar2.zzc()) {
                                            zzibVar.zzaV().zze().zzc("No number filter for double param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                            break;
                                        }
                                        Boolean zzh2 = zzab.zzh(((Double) obj2).doubleValue(), zzfhVar2.zzd());
                                        if (zzh2 == null) {
                                            break;
                                        }
                                        if (zzh2.booleanValue() == z12) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (obj2 instanceof String) {
                                        if (zzfhVar2.zza()) {
                                            zzi = zzab.zzf((String) obj2, zzfhVar2.zzb(), zzibVar.zzaV());
                                        } else if (zzfhVar2.zzc()) {
                                            String str2 = (String) obj2;
                                            if (zzpj.zzm(str2)) {
                                                zzi = zzab.zzi(str2, zzfhVar2.zzd());
                                            } else {
                                                zzibVar.zzaV().zze().zzc("Invalid param value for number filter. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                                break;
                                            }
                                        } else {
                                            zzibVar.zzaV().zze().zzc("No filter for String param. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                            break;
                                        }
                                        if (zzi == null) {
                                            break;
                                        }
                                        if (zzi.booleanValue() == z12) {
                                            bool = Boolean.FALSE;
                                            break;
                                        }
                                    } else if (obj2 == null) {
                                        zzibVar.zzaV().zzk().zzc("Missing param for filter. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                        bool = Boolean.FALSE;
                                    } else {
                                        zzibVar.zzaV().zze().zzc("Unknown param type. event, param", zzibVar.zzl().zza(zzd), zzibVar.zzl().zzb(zzh));
                                    }
                                } else {
                                    bool = Boolean.TRUE;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            zzgr zzk32 = zzibVar.zzaV().zzk();
            if (bool != null) {
            }
            zzk32.zzb("Event filter result", obj);
            if (bool != null) {
            }
        } else {
            zzgr zze = zzibVar.zzaV().zze();
            Object zzl = zzgt.zzl(str);
            if (zzffVar.zza()) {
                num2 = Integer.valueOf(zzffVar.zzb());
            }
            zze.zzc("Invalid event filter ID. appId, id", zzl, String.valueOf(num2));
            return false;
        }
    }
}
