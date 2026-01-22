package s3;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final List f١٧٨١٧a;

    /* renamed from: b, reason: collision with root package name */
    private PointF f١٧٨١٨b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٧٨١٩c;

    public o(PointF pointF, boolean z10, List list) {
        this.f١٧٨١٨b = pointF;
        this.f١٧٨١٩c = z10;
        this.f١٧٨١٧a = new ArrayList(list);
    }

    public List a() {
        return this.f١٧٨١٧a;
    }

    public PointF b() {
        return this.f١٧٨١٨b;
    }

    public void c(o oVar, o oVar2, float f10) {
        boolean z10;
        if (this.f١٧٨١٨b == null) {
            this.f١٧٨١٨b = new PointF();
        }
        if (!oVar.d() && !oVar2.d()) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f١٧٨١٩c = z10;
        if (oVar.a().size() != oVar2.a().size()) {
            x3.f.c("Curves must have the same number of control points. Shape 1: " + oVar.a().size() + "\tShape 2: " + oVar2.a().size());
        }
        int min = Math.min(oVar.a().size(), oVar2.a().size());
        if (this.f١٧٨١٧a.size() < min) {
            for (int size = this.f١٧٨١٧a.size(); size < min; size++) {
                this.f١٧٨١٧a.add(new q3.a());
            }
        } else if (this.f١٧٨١٧a.size() > min) {
            for (int size2 = this.f١٧٨١٧a.size() - 1; size2 >= min; size2--) {
                List list = this.f١٧٨١٧a;
                list.remove(list.size() - 1);
            }
        }
        PointF b10 = oVar.b();
        PointF b11 = oVar2.b();
        f(x3.k.i(b10.x, b11.x, f10), x3.k.i(b10.y, b11.y, f10));
        for (int size3 = this.f١٧٨١٧a.size() - 1; size3 >= 0; size3--) {
            q3.a aVar = (q3.a) oVar.a().get(size3);
            q3.a aVar2 = (q3.a) oVar2.a().get(size3);
            PointF a10 = aVar.a();
            PointF b12 = aVar.b();
            PointF c10 = aVar.c();
            PointF a11 = aVar2.a();
            PointF b13 = aVar2.b();
            PointF c11 = aVar2.c();
            ((q3.a) this.f١٧٨١٧a.get(size3)).d(x3.k.i(a10.x, a11.x, f10), x3.k.i(a10.y, a11.y, f10));
            ((q3.a) this.f١٧٨١٧a.get(size3)).e(x3.k.i(b12.x, b13.x, f10), x3.k.i(b12.y, b13.y, f10));
            ((q3.a) this.f١٧٨١٧a.get(size3)).f(x3.k.i(c10.x, c11.x, f10), x3.k.i(c10.y, c11.y, f10));
        }
    }

    public boolean d() {
        return this.f١٧٨١٩c;
    }

    public void e(boolean z10) {
        this.f١٧٨١٩c = z10;
    }

    public void f(float f10, float f11) {
        if (this.f١٧٨١٨b == null) {
            this.f١٧٨١٨b = new PointF();
        }
        this.f١٧٨١٨b.set(f10, f11);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f١٧٨١٧a.size() + "closed=" + this.f١٧٨١٩c + '}';
    }

    public o() {
        this.f١٧٨١٧a = new ArrayList();
    }
}
