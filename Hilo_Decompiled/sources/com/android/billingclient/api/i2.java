package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgt;
import com.google.android.gms.internal.play_billing.zzgu;
import com.google.android.gms.internal.play_billing.zzhd;
import com.google.android.gms.internal.play_billing.zzhe;
import com.google.android.gms.internal.play_billing.zzhl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i2 implements d2 {

    /* renamed from: b, reason: collision with root package name */
    private zzgu f٧٠٨٥b;

    /* renamed from: c, reason: collision with root package name */
    private final k2 f٧٠٨٦c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i2(Context context, zzgu zzguVar) {
        this.f٧٠٨٦c = new k2(context);
        this.f٧٠٨٥b = zzguVar;
    }

    @Override // com.android.billingclient.api.d2
    public final void a(zzge zzgeVar, int i10) {
        try {
            zzgt zzgtVar = (zzgt) this.f٧٠٨٥b.zzi();
            zzgtVar.zzl(i10);
            this.f٧٠٨٥b = (zzgu) zzgtVar.zzf();
            b(zzgeVar);
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.d2
    public final void b(zzge zzgeVar) {
        if (zzgeVar == null) {
            return;
        }
        try {
            zzhd zzy = zzhe.zzy();
            zzy.zzn(this.f٧٠٨٥b);
            zzy.zzm(zzgeVar);
            this.f٧٠٨٦c.a((zzhe) zzy.zzf());
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.d2
    public final void c(zzhl zzhlVar) {
        if (zzhlVar == null) {
            return;
        }
        try {
            zzhd zzy = zzhe.zzy();
            zzy.zzn(this.f٧٠٨٥b);
            zzy.zzo(zzhlVar);
            this.f٧٠٨٦c.a((zzhe) zzy.zzf());
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.d2
    public final void d(zzga zzgaVar, int i10) {
        try {
            zzgt zzgtVar = (zzgt) this.f٧٠٨٥b.zzi();
            zzgtVar.zzl(i10);
            this.f٧٠٨٥b = (zzgu) zzgtVar.zzf();
            e(zzgaVar);
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.d2
    public final void e(zzga zzgaVar) {
        if (zzgaVar == null) {
            return;
        }
        try {
            zzhd zzy = zzhe.zzy();
            zzy.zzn(this.f٧٠٨٥b);
            zzy.zzl(zzgaVar);
            this.f٧٠٨٦c.a((zzhe) zzy.zzf());
        } catch (Throwable th) {
            zzb.zzl("BillingLogger", "Unable to log.", th);
        }
    }
}
