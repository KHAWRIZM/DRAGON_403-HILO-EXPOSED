package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzc {
    final zzf zza;
    zzg zzb;
    final zzab zzc;
    private final zzz zzd;

    public zzc() {
        zzf zzfVar = new zzf();
        this.zza = zzfVar;
        this.zzb = zzfVar.zzb.zzc();
        this.zzc = new zzab();
        this.zzd = new zzz();
        zzfVar.zzd.zza("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.zzb
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzc.this.zzg();
            }
        });
        zzfVar.zzd.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzk(zzc.this.zzc);
            }
        });
    }

    public final void zza(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zzb(zzaa zzaaVar) throws zzd {
        try {
            zzab zzabVar = this.zzc;
            zzabVar.zzb(zzaaVar);
            this.zza.zzc.zze("runtime.counter", new zzah(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
            this.zzd.zzb(this.zzb.zzc(), zzabVar);
            if (!zzc()) {
                if (!zzd()) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzc() {
        zzab zzabVar = this.zzc;
        if (!zzabVar.zzc().equals(zzabVar.zza())) {
            return true;
        }
        return false;
    }

    public final boolean zzd() {
        if (!this.zzc.zzf().isEmpty()) {
            return true;
        }
        return false;
    }

    public final zzab zze() {
        return this.zzc;
    }

    public final void zzf(zzja zzjaVar) throws zzd {
        zzai zzaiVar;
        try {
            zzf zzfVar = this.zza;
            this.zzb = zzfVar.zzb.zzc();
            if (!(zzfVar.zza(this.zzb, (zzje[]) zzjaVar.zza().toArray(new zzje[0])) instanceof zzag)) {
                for (zziy zziyVar : zzjaVar.zzb().zza()) {
                    List zzb = zziyVar.zzb();
                    String zza = zziyVar.zza();
                    Iterator it = zzb.iterator();
                    while (it.hasNext()) {
                        zzao zza2 = zzfVar.zza(this.zzb, (zzje) it.next());
                        if (zza2 instanceof zzal) {
                            zzg zzgVar = this.zzb;
                            if (!zzgVar.zzd(zza)) {
                                zzaiVar = null;
                            } else {
                                zzao zzh = zzgVar.zzh(zza);
                                if (zzh instanceof zzai) {
                                    zzaiVar = (zzai) zzh;
                                } else {
                                    throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zza)));
                                }
                            }
                            if (zzaiVar != null) {
                                zzaiVar.zza(this.zzb, Collections.singletonList(zza2));
                            } else {
                                throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zza)));
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid rule definition");
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzai zzg() {
        return new zzv(this.zzd);
    }
}
