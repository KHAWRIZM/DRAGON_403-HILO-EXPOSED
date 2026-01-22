package s3;

import com.airbnb.lottie.j0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class r implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٨٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٧٨٣٠b;

    /* renamed from: c, reason: collision with root package name */
    private final r3.h f١٧٨٣١c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f١٧٨٣٢d;

    public r(String str, int i10, r3.h hVar, boolean z10) {
        this.f١٧٨٢٩a = str;
        this.f١٧٨٣٠b = i10;
        this.f١٧٨٣١c = hVar;
        this.f١٧٨٣٢d = z10;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        return new n3.r(j0Var, bVar, this);
    }

    public String b() {
        return this.f١٧٨٢٩a;
    }

    public r3.h c() {
        return this.f١٧٨٣١c;
    }

    public boolean d() {
        return this.f١٧٨٣٢d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f١٧٨٢٩a + ", index=" + this.f١٧٨٣٠b + '}';
    }
}
