package s3;

import com.airbnb.lottie.j0;
import n3.u;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class t implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٨٥٣a;

    /* renamed from: b, reason: collision with root package name */
    private final a f١٧٨٥٤b;

    /* renamed from: c, reason: collision with root package name */
    private final r3.b f١٧٨٥٥c;

    /* renamed from: d, reason: collision with root package name */
    private final r3.b f١٧٨٥٦d;

    /* renamed from: e, reason: collision with root package name */
    private final r3.b f١٧٨٥٧e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f١٧٨٥٨f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a c(int i10) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i10);
            }
            return SIMULTANEOUSLY;
        }
    }

    public t(String str, a aVar, r3.b bVar, r3.b bVar2, r3.b bVar3, boolean z10) {
        this.f١٧٨٥٣a = str;
        this.f١٧٨٥٤b = aVar;
        this.f١٧٨٥٥c = bVar;
        this.f١٧٨٥٦d = bVar2;
        this.f١٧٨٥٧e = bVar3;
        this.f١٧٨٥٨f = z10;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        return new u(bVar, this);
    }

    public r3.b b() {
        return this.f١٧٨٥٦d;
    }

    public String c() {
        return this.f١٧٨٥٣a;
    }

    public r3.b d() {
        return this.f١٧٨٥٧e;
    }

    public r3.b e() {
        return this.f١٧٨٥٥c;
    }

    public a f() {
        return this.f١٧٨٥٤b;
    }

    public boolean g() {
        return this.f١٧٨٥٨f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f١٧٨٥٥c + ", end: " + this.f١٧٨٥٦d + ", offset: " + this.f١٧٨٥٧e + "}";
    }
}
