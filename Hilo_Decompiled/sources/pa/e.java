package pa;

import android.view.animation.Interpolator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class e implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    float f١٦٩٩٠a;

    /* renamed from: b, reason: collision with root package name */
    Class f١٦٩٩١b;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f١٦٩٩٢c = null;

    /* renamed from: d, reason: collision with root package name */
    boolean f١٦٩٩٣d = false;

    public static e e(float f10) {
        return new a(f10);
    }

    public static e f(float f10, float f11) {
        return new a(f10, f11);
    }

    /* renamed from: a */
    public abstract e clone();

    public float b() {
        return this.f١٦٩٩٠a;
    }

    public Interpolator c() {
        return this.f١٦٩٩٢c;
    }

    public abstract Object d();

    public void g(Interpolator interpolator) {
        this.f١٦٩٩٢c = interpolator;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a extends e {

        /* renamed from: e, reason: collision with root package name */
        float f١٦٩٩٤e;

        a(float f10, float f11) {
            this.f١٦٩٩٠a = f10;
            this.f١٦٩٩٤e = f11;
            this.f١٦٩٩١b = Float.TYPE;
            this.f١٦٩٩٣d = true;
        }

        @Override // pa.e
        public Object d() {
            return Float.valueOf(this.f١٦٩٩٤e);
        }

        @Override // pa.e
        /* renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a(b(), this.f١٦٩٩٤e);
            aVar.g(c());
            return aVar;
        }

        public float i() {
            return this.f١٦٩٩٤e;
        }

        a(float f10) {
            this.f١٦٩٩٠a = f10;
            this.f١٦٩٩١b = Float.TYPE;
        }
    }
}
