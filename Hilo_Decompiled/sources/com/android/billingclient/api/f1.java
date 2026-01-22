package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzai;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٧٠١٥a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h0 f٧٠١٦b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f٧٠١٧c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1(h hVar, String str, h0 h0Var) {
        this.f٧٠١٥a = str;
        this.f٧٠١٦b = h0Var;
        this.f٧٠١٧c = hVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        w2 S = h.S(this.f٧٠١٧c, this.f٧٠١٥a, 9);
        if (S.b() != null) {
            this.f٧٠١٦b.a(S.a(), S.b());
            return null;
        }
        this.f٧٠١٦b.a(S.a(), zzai.zzk());
        return null;
    }
}
