package com.android.billingclient.api;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f٦٩٥٩a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f٦٩٦٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f٦٩٦١a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٦٩٦٢b;

        private a() {
        }

        public d0 a() {
            if (this.f٦٩٦١a) {
                return new d0(true, this.f٦٩٦٢b);
            }
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }

        public a b() {
            this.f٦٩٦١a = true;
            return this;
        }
    }

    private d0(boolean z10, boolean z11) {
        this.f٦٩٥٩a = z10;
        this.f٦٩٦٠b = z11;
    }

    public static a c() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f٦٩٥٩a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f٦٩٦٠b;
    }
}
