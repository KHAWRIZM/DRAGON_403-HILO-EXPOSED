package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzal;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract /* synthetic */ class c2 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f٦٩٥٨a = 0;

    static {
        zzal zzalVar = d2.f٦٩٦٩a;
    }

    public static zzga a(int i10, int i11, w wVar) {
        try {
            zzfz zzy = zzga.zzy();
            zzgg zzy2 = zzgk.zzy();
            zzy2.zzn(wVar.b());
            zzy2.zzm(wVar.a());
            zzy2.zzo(i10);
            zzy.zzl(zzy2);
            zzy.zzn(i11);
            return (zzga) zzy.zzf();
        } catch (Exception e10) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e10);
            return null;
        }
    }

    public static zzga b(int i10, int i11, w wVar, String str) {
        try {
            zzgg zzy = zzgk.zzy();
            zzy.zzn(wVar.b());
            zzy.zzm(wVar.a());
            zzy.zzo(i10);
            if (str != null) {
                zzy.zzl(str);
            }
            zzfz zzy2 = zzga.zzy();
            zzy2.zzl(zzy);
            zzy2.zzn(i11);
            return (zzga) zzy2.zzf();
        } catch (Exception e10) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e10);
            return null;
        }
    }

    public static zzge c(int i10) {
        try {
            zzgd zzy = zzge.zzy();
            zzy.zzm(i10);
            return (zzge) zzy.zzf();
        } catch (Exception e10) {
            zzb.zzl("BillingLogger", "Unable to create logging payload", e10);
            return null;
        }
    }
}
