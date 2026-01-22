package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzm;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class r1 extends zzm {

    /* renamed from: a, reason: collision with root package name */
    final c f٧١٤١a;

    /* renamed from: b, reason: collision with root package name */
    final d2 f٧١٤٢b;

    /* renamed from: g, reason: collision with root package name */
    final int f٧١٤٣g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r1(c cVar, d2 d2Var, int i10, q1 q1Var) {
        this.f٧١٤١a = cVar;
        this.f٧١٤٢b = d2Var;
        this.f٧١٤٣g = i10;
    }

    @Override // com.google.android.gms.internal.play_billing.zzn
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            d2 d2Var = this.f٧١٤٢b;
            w wVar = f2.f٧٠٢٨j;
            d2Var.d(c2.a(67, 14, wVar), this.f٧١٤٣g);
            this.f٧١٤١a.a(wVar);
            return;
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        w a10 = f2.a(zzb, zzb.zzg(bundle, "BillingClient"));
        if (zzb != 0) {
            zzb.zzk("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + zzb);
            this.f٧١٤٢b.d(c2.a(23, 14, a10), this.f٧١٤٣g);
        }
        this.f٧١٤١a.a(a10);
    }
}
