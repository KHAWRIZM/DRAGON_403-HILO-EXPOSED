package e2;

import a2.k;
import a2.m;
import androidx.constraintlayout.motion.widget.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b extends n {

    /* renamed from: a, reason: collision with root package name */
    private a2.n f١٣٨٦٤a;

    /* renamed from: b, reason: collision with root package name */
    private k f١٣٨٦٥b;

    /* renamed from: c, reason: collision with root package name */
    private m f١٣٨٦٦c;

    public b() {
        a2.n nVar = new a2.n();
        this.f١٣٨٦٤a = nVar;
        this.f١٣٨٦٦c = nVar;
    }

    @Override // androidx.constraintlayout.motion.widget.n
    public float a() {
        return this.f١٣٨٦٦c.a();
    }

    public void b(float f10, float f11, float f12, float f13, float f14, float f15) {
        a2.n nVar = this.f١٣٨٦٤a;
        this.f١٣٨٦٦c = nVar;
        nVar.d(f10, f11, f12, f13, f14, f15);
    }

    public boolean c() {
        return this.f١٣٨٦٦c.b();
    }

    public void d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        if (this.f١٣٨٦٥b == null) {
            this.f١٣٨٦٥b = new k();
        }
        k kVar = this.f١٣٨٦٥b;
        this.f١٣٨٦٦c = kVar;
        kVar.d(f10, f11, f12, f13, f14, f15, f16, i10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return this.f١٣٨٦٦c.getInterpolation(f10);
    }
}
