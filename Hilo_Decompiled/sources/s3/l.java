package s3;

import com.airbnb.lottie.j0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٨٠٥a;

    /* renamed from: b, reason: collision with root package name */
    private final r3.m f١٧٨٠٦b;

    /* renamed from: c, reason: collision with root package name */
    private final r3.m f١٧٨٠٧c;

    /* renamed from: d, reason: collision with root package name */
    private final r3.b f١٧٨٠٨d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f١٧٨٠٩e;

    public l(String str, r3.m mVar, r3.m mVar2, r3.b bVar, boolean z10) {
        this.f١٧٨٠٥a = str;
        this.f١٧٨٠٦b = mVar;
        this.f١٧٨٠٧c = mVar2;
        this.f١٧٨٠٨d = bVar;
        this.f١٧٨٠٩e = z10;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        return new n3.o(j0Var, bVar, this);
    }

    public r3.b b() {
        return this.f١٧٨٠٨d;
    }

    public String c() {
        return this.f١٧٨٠٥a;
    }

    public r3.m d() {
        return this.f١٧٨٠٦b;
    }

    public r3.m e() {
        return this.f١٧٨٠٧c;
    }

    public boolean f() {
        return this.f١٧٨٠٩e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f١٧٨٠٦b + ", size=" + this.f١٧٨٠٧c + '}';
    }
}
