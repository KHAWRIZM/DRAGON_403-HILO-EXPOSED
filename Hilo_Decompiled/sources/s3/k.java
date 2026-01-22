package s3;

import com.airbnb.lottie.j0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٧٩٠a;

    /* renamed from: b, reason: collision with root package name */
    private final a f١٧٧٩١b;

    /* renamed from: c, reason: collision with root package name */
    private final r3.b f١٧٧٩٢c;

    /* renamed from: d, reason: collision with root package name */
    private final r3.m f١٧٧٩٣d;

    /* renamed from: e, reason: collision with root package name */
    private final r3.b f١٧٧٩٤e;

    /* renamed from: f, reason: collision with root package name */
    private final r3.b f١٧٧٩٥f;

    /* renamed from: g, reason: collision with root package name */
    private final r3.b f١٧٧٩٦g;

    /* renamed from: h, reason: collision with root package name */
    private final r3.b f١٧٧٩٧h;

    /* renamed from: i, reason: collision with root package name */
    private final r3.b f١٧٧٩٨i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f١٧٧٩٩j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f١٧٨٠٠k;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum a {
        STAR(1),
        POLYGON(2);


        /* renamed from: a, reason: collision with root package name */
        private final int f١٧٨٠٤a;

        a(int i10) {
            this.f١٧٨٠٤a = i10;
        }

        public static a c(int i10) {
            for (a aVar : values()) {
                if (aVar.f١٧٨٠٤a == i10) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public k(String str, a aVar, r3.b bVar, r3.m mVar, r3.b bVar2, r3.b bVar3, r3.b bVar4, r3.b bVar5, r3.b bVar6, boolean z10, boolean z11) {
        this.f١٧٧٩٠a = str;
        this.f١٧٧٩١b = aVar;
        this.f١٧٧٩٢c = bVar;
        this.f١٧٧٩٣d = mVar;
        this.f١٧٧٩٤e = bVar2;
        this.f١٧٧٩٥f = bVar3;
        this.f١٧٧٩٦g = bVar4;
        this.f١٧٧٩٧h = bVar5;
        this.f١٧٧٩٨i = bVar6;
        this.f١٧٧٩٩j = z10;
        this.f١٧٨٠٠k = z11;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        return new n3.n(j0Var, bVar, this);
    }

    public r3.b b() {
        return this.f١٧٧٩٥f;
    }

    public r3.b c() {
        return this.f١٧٧٩٧h;
    }

    public String d() {
        return this.f١٧٧٩٠a;
    }

    public r3.b e() {
        return this.f١٧٧٩٦g;
    }

    public r3.b f() {
        return this.f١٧٧٩٨i;
    }

    public r3.b g() {
        return this.f١٧٧٩٢c;
    }

    public r3.m h() {
        return this.f١٧٧٩٣d;
    }

    public r3.b i() {
        return this.f١٧٧٩٤e;
    }

    public a j() {
        return this.f١٧٧٩١b;
    }

    public boolean k() {
        return this.f١٧٧٩٩j;
    }

    public boolean l() {
        return this.f١٧٨٠٠k;
    }
}
