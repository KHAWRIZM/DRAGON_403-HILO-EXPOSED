package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhe;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class k2 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٧١٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private z6.i f٧١٠٣b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k2(Context context) {
        try {
            b7.u.f(context);
            this.f٧١٠٣b = b7.u.c().g(com.google.android.datatransport.cct.a.f٨١٠٣g).a("PLAY_BILLING_LIBRARY", zzhe.class, z6.c.b("proto"), new z6.h() { // from class: com.android.billingclient.api.j2
                @Override // z6.h
                public final Object apply(Object obj) {
                    return ((zzhe) obj).zzc();
                }
            });
        } catch (Throwable unused) {
            this.f٧١٠٢a = true;
        }
    }

    public final void a(zzhe zzheVar) {
        if (this.f٧١٠٢a) {
            zzb.zzk("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.f٧١٠٣b.b(z6.d.f(zzheVar));
        } catch (Throwable unused) {
            zzb.zzk("BillingLogger", "logging failed.");
        }
    }
}
