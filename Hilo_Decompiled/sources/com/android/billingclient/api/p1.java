package com.android.billingclient.api;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zze;
import org.json.JSONException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class p1 extends zze {

    /* renamed from: a, reason: collision with root package name */
    final b0 f٧١٣٠a;

    /* renamed from: b, reason: collision with root package name */
    final d2 f٧١٣١b;

    /* renamed from: g, reason: collision with root package name */
    final int f٧١٣٢g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p1(b0 b0Var, d2 d2Var, int i10, o1 o1Var) {
        this.f٧١٣٠a = b0Var;
        this.f٧١٣١b = d2Var;
        this.f٧١٣٢g = i10;
    }

    @Override // com.google.android.gms.internal.play_billing.zzf
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            d2 d2Var = this.f٧١٣١b;
            w wVar = f2.f٧٠٢٨j;
            d2Var.d(c2.a(95, 24, wVar), this.f٧١٣٢g);
            this.f٧١٣٠a.a(wVar, null);
            return;
        }
        int zzb = zzb.zzb(bundle, "BillingClient");
        w a10 = f2.a(zzb, zzb.zzg(bundle, "BillingClient"));
        if (zzb != 0) {
            zzb.zzk("BillingClient", "createExternalOfferReportingDetailsAsync() failed. Response code: " + zzb);
            this.f٧١٣١b.d(c2.a(23, 24, a10), this.f٧١٣٢g);
            this.f٧١٣٠a.a(a10, null);
            return;
        }
        try {
            this.f٧١٣٠a.a(a10, new a0(bundle.getString("CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS")));
        } catch (JSONException e10) {
            zzb.zzl("BillingClient", "Error when parsing invalid external offer reporting details. \n Exception: ", e10);
            d2 d2Var2 = this.f٧١٣١b;
            w wVar2 = f2.f٧٠٢٨j;
            d2Var2.d(c2.a(104, 24, wVar2), this.f٧١٣٢g);
            this.f٧١٣٠a.a(wVar2, null);
        }
    }
}
