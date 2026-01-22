package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.w;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzgj;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class zzay extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f٧٢١٥a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i10, Bundle bundle) {
        int i11;
        w.a c10 = w.c();
        c10.c(i10);
        if (i10 != 0) {
            if (bundle == null) {
                this.f٧٢١٥a.b0(c2.a(97, 25, f2.f٧٠٢٨j));
                throw null;
            }
            c10.b(zzb.zzg(bundle, "BillingClient"));
            int i12 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            h hVar = this.f٧٢١٥a;
            if (i12 != 0) {
                i11 = zzgj.zza(i12);
            } else {
                i11 = 23;
            }
            hVar.b0(c2.b(i11, 25, c10.a(), bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS")));
        }
        c10.a();
        throw null;
    }
}
