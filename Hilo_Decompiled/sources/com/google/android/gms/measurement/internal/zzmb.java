package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzmb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zze;
    final /* synthetic */ zznk zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmb(zznk zznkVar, String str, String str2, zzr zzrVar, boolean z10, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzrVar;
        this.zzd = z10;
        this.zze = zzcuVar;
        Objects.requireNonNull(zznkVar);
        this.zzf = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e10;
        Bundle bundle2 = new Bundle();
        try {
            zznk zznkVar = this.zzf;
            zzga zzZ = zznkVar.zzZ();
            if (zzZ == null) {
                zzib zzibVar = zznkVar.zzu;
                zzibVar.zzaV().zzb().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                zzibVar.zzk().zzaq(this.zze, bundle2);
                return;
            }
            zzr zzrVar = this.zzc;
            Preconditions.checkNotNull(zzrVar);
            List<zzpk> zzp = zzZ.zzp(this.zza, this.zzb, this.zzd, zzrVar);
            int i10 = zzpo.zza;
            bundle = new Bundle();
            if (zzp != null) {
                for (zzpk zzpkVar : zzp) {
                    String str = zzpkVar.zze;
                    if (str != null) {
                        bundle.putString(zzpkVar.zzb, str);
                    } else {
                        Long l10 = zzpkVar.zzd;
                        if (l10 != null) {
                            bundle.putLong(zzpkVar.zzb, l10.longValue());
                        } else {
                            Double d10 = zzpkVar.zzg;
                            if (d10 != null) {
                                bundle.putDouble(zzpkVar.zzb, d10.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    zznkVar.zzV();
                    zzib zzibVar2 = zznkVar.zzu;
                    zzibVar2.zzk().zzaq(this.zze, bundle);
                } catch (RemoteException e11) {
                    e10 = e11;
                    this.zzf.zzu.zzaV().zzb().zzc("Failed to get user properties; remote exception", this.zza, e10);
                    zznk zznkVar2 = this.zzf;
                    zznkVar2.zzu.zzk().zzaq(this.zze, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                zznk zznkVar3 = this.zzf;
                zznkVar3.zzu.zzk().zzaq(this.zze, bundle2);
                throw th;
            }
        } catch (RemoteException e12) {
            bundle = bundle2;
            e10 = e12;
        } catch (Throwable th2) {
            th = th2;
            zznk zznkVar32 = this.zzf;
            zznkVar32.zzu.zzk().zzaq(this.zze, bundle2);
            throw th;
        }
    }
}
