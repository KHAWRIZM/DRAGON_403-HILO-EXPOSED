package com.bumptech.glide.integration.webp.decoder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final q f٧٣٥٩c = new b().f().c();

    /* renamed from: d, reason: collision with root package name */
    public static final q f٧٣٦٠d = new b().e().c();

    /* renamed from: e, reason: collision with root package name */
    public static final q f٧٣٦١e = new b().d().c();

    /* renamed from: a, reason: collision with root package name */
    private c f٧٣٦٢a;

    /* renamed from: b, reason: collision with root package name */
    private int f٧٣٦٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private c f٧٣٦٤a;

        /* renamed from: b, reason: collision with root package name */
        private int f٧٣٦٥b;

        public q c() {
            return new q(this);
        }

        public b d() {
            this.f٧٣٦٤a = c.CACHE_ALL;
            return this;
        }

        public b e() {
            this.f٧٣٦٤a = c.CACHE_AUTO;
            return this;
        }

        public b f() {
            this.f٧٣٦٤a = c.CACHE_NONE;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum c {
        CACHE_NONE,
        CACHE_LIMITED,
        CACHE_AUTO,
        CACHE_ALL
    }

    public boolean a() {
        if (this.f٧٣٦٢a == c.CACHE_ALL) {
            return true;
        }
        return false;
    }

    public int b() {
        return this.f٧٣٦٣b;
    }

    public boolean c() {
        if (this.f٧٣٦٢a == c.CACHE_NONE) {
            return true;
        }
        return false;
    }

    private q(b bVar) {
        this.f٧٣٦٢a = bVar.f٧٣٦٤a;
        this.f٧٣٦٣b = bVar.f٧٣٦٥b;
    }
}
