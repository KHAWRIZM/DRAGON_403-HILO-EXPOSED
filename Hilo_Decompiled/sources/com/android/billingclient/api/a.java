package com.android.billingclient.api;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f٦٩٤٧a;

    /* renamed from: com.android.billingclient.api.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class C٠١٠١a {

        /* renamed from: a, reason: collision with root package name */
        private String f٦٩٤٨a;

        /* synthetic */ C٠١٠١a(p0 p0Var) {
        }

        public a a() {
            String str = this.f٦٩٤٨a;
            if (str != null) {
                a aVar = new a(null);
                aVar.f٦٩٤٧a = str;
                return aVar;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        public C٠١٠١a b(String str) {
            this.f٦٩٤٨a = str;
            return this;
        }
    }

    /* synthetic */ a(i1 i1Var) {
    }

    public static C٠١٠١a b() {
        return new C٠١٠١a(null);
    }

    public String a() {
        return this.f٦٩٤٧a;
    }
}
