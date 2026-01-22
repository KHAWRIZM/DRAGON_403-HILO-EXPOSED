package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhj {
    final zzib zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhj(zzpf zzpfVar) {
        this.zza = zzpfVar.zzaf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zza() {
        try {
            zzib zzibVar = this.zza;
            PackageManagerWrapper packageManager = Wrappers.packageManager(zzibVar.zzaY());
            if (packageManager == null) {
                zzibVar.zzaV().zzk().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            }
            if (packageManager.getPackageInfo("com.android.vending", 128).versionCode < 80837300) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            this.zza.zzaV().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
