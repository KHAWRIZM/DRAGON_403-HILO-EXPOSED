package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzmh implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zznk zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmh(zznk zznkVar, AtomicReference atomicReference, zzr zzrVar) {
        this.zza = atomicReference;
        this.zzb = zzrVar;
        Objects.requireNonNull(zznkVar);
        this.zzc = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznk zznkVar;
        zzib zzibVar;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                try {
                    zznkVar = this.zzc;
                    zzibVar = zznkVar.zzu;
                } catch (RemoteException e10) {
                    this.zzc.zzu.zzaV().zzb().zzb("Failed to get app instance id", e10);
                    atomicReference = this.zza;
                }
                if (!zzibVar.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
                    zzibVar.zzaV().zzh().zza("Analytics storage consent denied; will not get app instance id");
                    zznkVar.zzu.zzj().zzR(null);
                    zzibVar.zzd().zze.zzb(null);
                    atomicReference2.set(null);
                    atomicReference2.notify();
                    return;
                }
                zzga zzZ = zznkVar.zzZ();
                if (zzZ == null) {
                    zzibVar.zzaV().zzb().zza("Failed to get app instance id");
                    atomicReference2.notify();
                    return;
                }
                zzr zzrVar = this.zzb;
                Preconditions.checkNotNull(zzrVar);
                atomicReference2.set(zzZ.zzm(zzrVar));
                String str = (String) atomicReference2.get();
                if (str != null) {
                    zznkVar.zzu.zzj().zzR(str);
                    zzibVar.zzd().zze.zzb(str);
                }
                zznkVar.zzV();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
