package y3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.j;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final j f١٩١١٦a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f١٩١١٧b;

    /* renamed from: c, reason: collision with root package name */
    public Object f١٩١١٨c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f١٩١١٩d;

    /* renamed from: e, reason: collision with root package name */
    public final Interpolator f١٩١٢٠e;

    /* renamed from: f, reason: collision with root package name */
    public final Interpolator f١٩١٢١f;

    /* renamed from: g, reason: collision with root package name */
    public final float f١٩١٢٢g;

    /* renamed from: h, reason: collision with root package name */
    public Float f١٩١٢٣h;

    /* renamed from: i, reason: collision with root package name */
    private float f١٩١٢٤i;

    /* renamed from: j, reason: collision with root package name */
    private float f١٩١٢٥j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٩١٢٦k;

    /* renamed from: l, reason: collision with root package name */
    private int f١٩١٢٧l;

    /* renamed from: m, reason: collision with root package name */
    private float f١٩١٢٨m;

    /* renamed from: n, reason: collision with root package name */
    private float f١٩١٢٩n;

    /* renamed from: o, reason: collision with root package name */
    public PointF f١٩١٣٠o;

    /* renamed from: p, reason: collision with root package name */
    public PointF f١٩١٣١p;

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, float f10, Float f11) {
        this.f١٩١٢٤i = -3987645.8f;
        this.f١٩١٢٥j = -3987645.8f;
        this.f١٩١٢٦k = 784923401;
        this.f١٩١٢٧l = 784923401;
        this.f١٩١٢٨m = Float.MIN_VALUE;
        this.f١٩١٢٩n = Float.MIN_VALUE;
        this.f١٩١٣٠o = null;
        this.f١٩١٣١p = null;
        this.f١٩١١٦a = jVar;
        this.f١٩١١٧b = obj;
        this.f١٩١١٨c = obj2;
        this.f١٩١١٩d = interpolator;
        this.f١٩١٢٠e = null;
        this.f١٩١٢١f = null;
        this.f١٩١٢٢g = f10;
        this.f١٩١٢٣h = f11;
    }

    public boolean a(float f10) {
        if (f10 >= f() && f10 < c()) {
            return true;
        }
        return false;
    }

    public a b(Object obj, Object obj2) {
        return new a(obj, obj2);
    }

    public float c() {
        if (this.f١٩١١٦a == null) {
            return 1.0f;
        }
        if (this.f١٩١٢٩n == Float.MIN_VALUE) {
            if (this.f١٩١٢٣h == null) {
                this.f١٩١٢٩n = 1.0f;
            } else {
                this.f١٩١٢٩n = f() + ((this.f١٩١٢٣h.floatValue() - this.f١٩١٢٢g) / this.f١٩١١٦a.e());
            }
        }
        return this.f١٩١٢٩n;
    }

    public float d() {
        if (this.f١٩١٢٥j == -3987645.8f) {
            this.f١٩١٢٥j = ((Float) this.f١٩١١٨c).floatValue();
        }
        return this.f١٩١٢٥j;
    }

    public int e() {
        if (this.f١٩١٢٧l == 784923401) {
            this.f١٩١٢٧l = ((Integer) this.f١٩١١٨c).intValue();
        }
        return this.f١٩١٢٧l;
    }

    public float f() {
        j jVar = this.f١٩١١٦a;
        if (jVar == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (this.f١٩١٢٨m == Float.MIN_VALUE) {
            this.f١٩١٢٨m = (this.f١٩١٢٢g - jVar.p()) / this.f١٩١١٦a.e();
        }
        return this.f١٩١٢٨m;
    }

    public float g() {
        if (this.f١٩١٢٤i == -3987645.8f) {
            this.f١٩١٢٤i = ((Float) this.f١٩١١٧b).floatValue();
        }
        return this.f١٩١٢٤i;
    }

    public int h() {
        if (this.f١٩١٢٦k == 784923401) {
            this.f١٩١٢٦k = ((Integer) this.f١٩١١٧b).intValue();
        }
        return this.f١٩١٢٦k;
    }

    public boolean i() {
        if (this.f١٩١١٩d == null && this.f١٩١٢٠e == null && this.f١٩١٢١f == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f١٩١١٧b + ", endValue=" + this.f١٩١١٨c + ", startFrame=" + this.f١٩١٢٢g + ", endFrame=" + this.f١٩١٢٣h + ", interpolator=" + this.f١٩١١٩d + '}';
    }

    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f10, Float f11) {
        this.f١٩١٢٤i = -3987645.8f;
        this.f١٩١٢٥j = -3987645.8f;
        this.f١٩١٢٦k = 784923401;
        this.f١٩١٢٧l = 784923401;
        this.f١٩١٢٨m = Float.MIN_VALUE;
        this.f١٩١٢٩n = Float.MIN_VALUE;
        this.f١٩١٣٠o = null;
        this.f١٩١٣١p = null;
        this.f١٩١١٦a = jVar;
        this.f١٩١١٧b = obj;
        this.f١٩١١٨c = obj2;
        this.f١٩١١٩d = null;
        this.f١٩١٢٠e = interpolator;
        this.f١٩١٢١f = interpolator2;
        this.f١٩١٢٢g = f10;
        this.f١٩١٢٣h = f11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(j jVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f10, Float f11) {
        this.f١٩١٢٤i = -3987645.8f;
        this.f١٩١٢٥j = -3987645.8f;
        this.f١٩١٢٦k = 784923401;
        this.f١٩١٢٧l = 784923401;
        this.f١٩١٢٨m = Float.MIN_VALUE;
        this.f١٩١٢٩n = Float.MIN_VALUE;
        this.f١٩١٣٠o = null;
        this.f١٩١٣١p = null;
        this.f١٩١١٦a = jVar;
        this.f١٩١١٧b = obj;
        this.f١٩١١٨c = obj2;
        this.f١٩١١٩d = interpolator;
        this.f١٩١٢٠e = interpolator2;
        this.f١٩١٢١f = interpolator3;
        this.f١٩١٢٢g = f10;
        this.f١٩١٢٣h = f11;
    }

    public a(Object obj) {
        this.f١٩١٢٤i = -3987645.8f;
        this.f١٩١٢٥j = -3987645.8f;
        this.f١٩١٢٦k = 784923401;
        this.f١٩١٢٧l = 784923401;
        this.f١٩١٢٨m = Float.MIN_VALUE;
        this.f١٩١٢٩n = Float.MIN_VALUE;
        this.f١٩١٣٠o = null;
        this.f١٩١٣١p = null;
        this.f١٩١١٦a = null;
        this.f١٩١١٧b = obj;
        this.f١٩١١٨c = obj;
        this.f١٩١١٩d = null;
        this.f١٩١٢٠e = null;
        this.f١٩١٢١f = null;
        this.f١٩١٢٢g = Float.MIN_VALUE;
        this.f١٩١٢٣h = Float.valueOf(Float.MAX_VALUE);
    }

    private a(Object obj, Object obj2) {
        this.f١٩١٢٤i = -3987645.8f;
        this.f١٩١٢٥j = -3987645.8f;
        this.f١٩١٢٦k = 784923401;
        this.f١٩١٢٧l = 784923401;
        this.f١٩١٢٨m = Float.MIN_VALUE;
        this.f١٩١٢٩n = Float.MIN_VALUE;
        this.f١٩١٣٠o = null;
        this.f١٩١٣١p = null;
        this.f١٩١١٦a = null;
        this.f١٩١١٧b = obj;
        this.f١٩١١٨c = obj2;
        this.f١٩١١٩d = null;
        this.f١٩١٢٠e = null;
        this.f١٩١٢١f = null;
        this.f١٩١٢٢g = Float.MIN_VALUE;
        this.f١٩١٢٣h = Float.valueOf(Float.MAX_VALUE);
    }
}
