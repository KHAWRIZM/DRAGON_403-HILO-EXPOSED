package com.android.billingclient.api;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private String f٧٢٠٣a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f٧٢٠٤a;

        /* synthetic */ a(g2 g2Var) {
        }

        public x a() {
            String str = this.f٧٢٠٤a;
            if (str != null) {
                x xVar = new x(null);
                xVar.f٧٢٠٣a = str;
                return xVar;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        public a b(String str) {
            this.f٧٢٠٤a = str;
            return this;
        }
    }

    /* synthetic */ x(h2 h2Var) {
    }

    public static a b() {
        return new a(null);
    }

    public String a() {
        return this.f٧٢٠٣a;
    }
}
