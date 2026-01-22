package s3;

import com.airbnb.lottie.j0;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class q implements c {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٧٨٢٦a;

    /* renamed from: b, reason: collision with root package name */
    private final List f١٧٨٢٧b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f١٧٨٢٨c;

    public q(String str, List list, boolean z10) {
        this.f١٧٨٢٦a = str;
        this.f١٧٨٢٧b = list;
        this.f١٧٨٢٨c = z10;
    }

    @Override // s3.c
    public n3.c a(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar) {
        return new n3.d(j0Var, bVar, this, jVar);
    }

    public List b() {
        return this.f١٧٨٢٧b;
    }

    public String c() {
        return this.f١٧٨٢٦a;
    }

    public boolean d() {
        return this.f١٧٨٢٨c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f١٧٨٢٦a + "' Shapes: " + Arrays.toString(this.f١٧٨٢٧b.toArray()) + '}';
    }
}
