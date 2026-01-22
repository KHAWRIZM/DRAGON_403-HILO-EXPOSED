package v4;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f١٨٥٣٤a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final o f١٨٥٣٥b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final o f١٨٥٣٦c = new e();

    /* renamed from: d, reason: collision with root package name */
    public static final o f١٨٥٣٧d = new c();

    /* renamed from: e, reason: collision with root package name */
    public static final o f١٨٥٣٨e;

    /* renamed from: f, reason: collision with root package name */
    public static final o f١٨٥٣٩f;

    /* renamed from: g, reason: collision with root package name */
    public static final o f١٨٥٤٠g;

    /* renamed from: h, reason: collision with root package name */
    public static final m4.h f١٨٥٤١h;

    /* renamed from: i, reason: collision with root package name */
    static final boolean f١٨٥٤٢i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class a extends o {
        a() {
        }

        @Override // v4.o
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // v4.o
        public float b(int i10, int i11, int i12, int i13) {
            if (Math.min(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class b extends o {
        b() {
        }

        @Override // v4.o
        public g a(int i10, int i11, int i12, int i13) {
            return g.MEMORY;
        }

        @Override // v4.o
        public float b(int i10, int i11, int i12, int i13) {
            int ceil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            int i14 = 1;
            if (Math.max(1, Integer.highestOneBit(ceil)) >= ceil) {
                i14 = 0;
            }
            return 1.0f / (r2 << i14);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class c extends o {
        c() {
        }

        @Override // v4.o
        public g a(int i10, int i11, int i12, int i13) {
            if (b(i10, i11, i12, i13) == 1.0f) {
                return g.QUALITY;
            }
            return o.f١٨٥٣٦c.a(i10, i11, i12, i13);
        }

        @Override // v4.o
        public float b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, o.f١٨٥٣٦c.b(i10, i11, i12, i13));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class d extends o {
        d() {
        }

        @Override // v4.o
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // v4.o
        public float b(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class e extends o {
        e() {
        }

        @Override // v4.o
        public g a(int i10, int i11, int i12, int i13) {
            if (o.f١٨٥٤٢i) {
                return g.QUALITY;
            }
            return g.MEMORY;
        }

        @Override // v4.o
        public float b(int i10, int i11, int i12, int i13) {
            if (o.f١٨٥٤٢i) {
                return Math.min(i12 / i10, i13 / i11);
            }
            if (Math.max(i11 / i13, i10 / i12) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class f extends o {
        f() {
        }

        @Override // v4.o
        public g a(int i10, int i11, int i12, int i13) {
            return g.QUALITY;
        }

        @Override // v4.o
        public float b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        f١٨٥٣٨e = dVar;
        f١٨٥٣٩f = new f();
        f١٨٥٤٠g = dVar;
        f١٨٥٤١h = m4.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f١٨٥٤٢i = true;
    }

    public abstract g a(int i10, int i11, int i12, int i13);

    public abstract float b(int i10, int i11, int i12, int i13);
}
