package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i3 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f٧٠٨٧a;

    /* renamed from: b, reason: collision with root package name */
    private final i0 f٧٠٨٨b;

    /* renamed from: c, reason: collision with root package name */
    private final d2 f٧٠٨٩c;

    /* renamed from: d, reason: collision with root package name */
    private final h3 f٧٠٩٠d = new h3(this, true);

    /* renamed from: e, reason: collision with root package name */
    private final h3 f٧٠٩١e = new h3(this, false);

    /* renamed from: f, reason: collision with root package name */
    private boolean f٧٠٩٢f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i3(Context context, i0 i0Var, l2 l2Var, a2 a2Var, o0 o0Var, d2 d2Var) {
        this.f٧٠٨٧a = context;
        this.f٧٠٨٨b = i0Var;
        this.f٧٠٨٩c = d2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ a2 a(i3 i3Var) {
        i3Var.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ o0 e(i3 i3Var) {
        i3Var.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final i0 d() {
        return this.f٧٠٨٨b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() {
        this.f٧٠٩٠d.c(this.f٧٠٨٧a);
        this.f٧٠٩١e.c(this.f٧٠٨٧a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(boolean z10) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f٧٠٩٢f = z10;
        this.f٧٠٩١e.a(this.f٧٠٨٧a, intentFilter2);
        if (this.f٧٠٩٢f) {
            this.f٧٠٩٠d.b(this.f٧٠٨٧a, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            this.f٧٠٩٠d.a(this.f٧٠٨٧a, intentFilter);
        }
    }
}
