package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class g1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٧٠٥٠a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ g0 f٧٠٥١b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f٧٠٥٢c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(h hVar, String str, g0 g0Var) {
        this.f٧٠٥٠a = str;
        this.f٧٠٥١b = g0Var;
        this.f٧٠٥٢c = hVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        u1 m02 = h.m0(this.f٧٠٥٢c, this.f٧٠٥٠a);
        this.f٧٠٥١b.a(m02.a(), m02.b());
        return null;
    }
}
