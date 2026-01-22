package s3;

import android.graphics.Path;
import com.airbnb.lottie.j0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class p implements c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f١٧٨٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private final Path.FillType f١٧٨٢١b;

    /* renamed from: c, reason: collision with root package name */
    private final String f١٧٨٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private final r3.a f١٧٨٢٣d;

    /* renamed from: e, reason: collision with root package name */
    private final r3.d f١٧٨٢٤e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f١٧٨٢٥f;

    public p(String str, boolean z10, Path.FillType fillType, r3.a aVar, r3.d dVar, boolean z11) {
        this.f١٧٨٢٢c = str;
        this.f١٧٨٢٠a = z10;
        this.f١٧٨٢١b = fillType;
        this.f١٧٨٢٣d = aVar;
        this.f١٧٨٢٤e = dVar;
        this.f١٧٨٢٥f = z11;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        return new n3.g(j0Var, bVar, this);
    }

    public r3.a b() {
        return this.f١٧٨٢٣d;
    }

    public Path.FillType c() {
        return this.f١٧٨٢١b;
    }

    public String d() {
        return this.f١٧٨٢٢c;
    }

    public r3.d e() {
        return this.f١٧٨٢٤e;
    }

    public boolean f() {
        return this.f١٧٨٢٥f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f١٧٨٢٠a + '}';
    }
}
