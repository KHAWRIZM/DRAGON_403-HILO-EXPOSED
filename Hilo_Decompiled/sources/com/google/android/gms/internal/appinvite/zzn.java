package com.google.android.gms.internal.appinvite;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzn extends zze {
    private final /* synthetic */ zzk zzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzk zzkVar) {
        this.zzq = zzkVar;
    }

    @Override // com.google.android.gms.internal.appinvite.zze, com.google.android.gms.internal.appinvite.zzo
    public final void zza(Status status, Intent intent) {
        boolean z10;
        WeakReference weakReference;
        WeakReference weakReference2;
        this.zzq.setResult((zzk) new zzp(status, intent));
        if (AppInviteReferral.hasReferral(intent)) {
            z10 = this.zzq.zzm;
            if (z10) {
                weakReference = this.zzq.zzl;
                if (weakReference != null) {
                    weakReference2 = this.zzq.zzl;
                    Activity activity = (Activity) weakReference2.get();
                    if (activity != null) {
                        activity.startActivity(intent);
                    }
                }
            }
        }
    }
}
