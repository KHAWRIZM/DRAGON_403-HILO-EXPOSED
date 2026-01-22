package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzc;
import org.json.JSONException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class n1 extends zzc {

    /* renamed from: a, reason: collision with root package name */
    final f f٧١٢١a;

    /* renamed from: b, reason: collision with root package name */
    final d2 f٧١٢٢b;

    /* renamed from: g, reason: collision with root package name */
    final int f٧١٢٣g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n1(f fVar, d2 d2Var, int i10, m1 m1Var) {
        this.f٧١٢١a = fVar;
        this.f٧١٢٢b = d2Var;
        this.f٧١٢٣g = i10;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            d2 d2Var = this.f٧١٢٢b;
            w wVar = f2.f٧٠٢٨j;
            d2Var.d(c2.a(71, 15, wVar), this.f٧١٢٣g);
            this.f٧١٢١a.a(wVar, null);
            return;
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        w a10 = f2.a(zzb, zzb.zzg(bundle, "BillingClient"));
        if (zzb != 0) {
            zzb.zzk("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + zzb);
            this.f٧١٢٢b.d(c2.a(23, 15, a10), this.f٧١٢٣g);
            this.f٧١٢١a.a(a10, null);
            return;
        }
        try {
            this.f٧١٢١a.a(a10, new e(bundle.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS")));
        } catch (JSONException e10) {
            zzb.zzl("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", e10);
            d2 d2Var2 = this.f٧١٢٢b;
            w wVar2 = f2.f٧٠٢٨j;
            d2Var2.d(c2.a(72, 15, wVar2), this.f٧١٢٣g);
            this.f٧١٢١a.a(wVar2, null);
        }
    }
}
