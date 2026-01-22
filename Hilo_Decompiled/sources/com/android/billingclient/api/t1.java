package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class t1 extends zzo {

    /* renamed from: a, reason: collision with root package name */
    final z f٧١٥٢a;

    /* renamed from: b, reason: collision with root package name */
    final d2 f٧١٥٣b;

    /* renamed from: g, reason: collision with root package name */
    final int f٧١٥٤g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t1(z zVar, d2 d2Var, int i10, s1 s1Var) {
        this.f٧١٥٢a = zVar;
        this.f٧١٥٣b = d2Var;
        this.f٧١٥٤g = i10;
    }

    @Override // com.google.android.gms.internal.play_billing.zzp
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            d2 d2Var = this.f٧١٥٣b;
            w wVar = f2.f٧٠٢٨j;
            d2Var.d(c2.a(92, 23, wVar), this.f٧١٥٤g);
            this.f٧١٥٢a.a(wVar);
            return;
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        w a10 = f2.a(zzb, zzb.zzg(bundle, "BillingClient"));
        if (zzb != 0) {
            zzb.zzk("BillingClient", "isExternalOfferAvailableAsync() failed. Response code: " + zzb);
            this.f٧١٥٣b.d(c2.a(23, 23, a10), this.f٧١٥٤g);
        }
        this.f٧١٥٢a.a(a10);
    }
}
