package q3;

import android.graphics.PointF;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f١٧٠٨٤a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f١٧٠٨٥b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f١٧٠٨٦c;

    public a() {
        this.f١٧٠٨٤a = new PointF();
        this.f١٧٠٨٥b = new PointF();
        this.f١٧٠٨٦c = new PointF();
    }

    public PointF a() {
        return this.f١٧٠٨٤a;
    }

    public PointF b() {
        return this.f١٧٠٨٥b;
    }

    public PointF c() {
        return this.f١٧٠٨٦c;
    }

    public void d(float f10, float f11) {
        this.f١٧٠٨٤a.set(f10, f11);
    }

    public void e(float f10, float f11) {
        this.f١٧٠٨٥b.set(f10, f11);
    }

    public void f(float f10, float f11) {
        this.f١٧٠٨٦c.set(f10, f11);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f١٧٠٨٦c.x), Float.valueOf(this.f١٧٠٨٦c.y), Float.valueOf(this.f١٧٠٨٤a.x), Float.valueOf(this.f١٧٠٨٤a.y), Float.valueOf(this.f١٧٠٨٥b.x), Float.valueOf(this.f١٧٠٨٥b.y));
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f١٧٠٨٤a = pointF;
        this.f١٧٠٨٥b = pointF2;
        this.f١٧٠٨٦c = pointF3;
    }
}
