package com.android.billingclient.api;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f٧١٠٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f٧١٠٨a;

        /* synthetic */ a(d3 d3Var) {
        }

        public l0 a() {
            if (this.f٧١٠٨a != null) {
                return new l0(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f٧١٠٨a = str;
            return this;
        }
    }

    /* synthetic */ l0(a aVar, e3 e3Var) {
        this.f٧١٠٧a = aVar.f٧١٠٨a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f٧١٠٧a;
    }
}
