package f8;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class o {

    /* renamed from: m, reason: collision with root package name */
    public static final d f١٤١٧٨m = new m(0.5f);

    /* renamed from: a, reason: collision with root package name */
    e f١٤١٧٩a;

    /* renamed from: b, reason: collision with root package name */
    e f١٤١٨٠b;

    /* renamed from: c, reason: collision with root package name */
    e f١٤١٨١c;

    /* renamed from: d, reason: collision with root package name */
    e f١٤١٨٢d;

    /* renamed from: e, reason: collision with root package name */
    d f١٤١٨٣e;

    /* renamed from: f, reason: collision with root package name */
    d f١٤١٨٤f;

    /* renamed from: g, reason: collision with root package name */
    d f١٤١٨٥g;

    /* renamed from: h, reason: collision with root package name */
    d f١٤١٨٦h;

    /* renamed from: i, reason: collision with root package name */
    g f١٤١٨٧i;

    /* renamed from: j, reason: collision with root package name */
    g f١٤١٨٨j;

    /* renamed from: k, reason: collision with root package name */
    g f١٤١٨٩k;

    /* renamed from: l, reason: collision with root package name */
    g f١٤١٩٠l;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        d a(d dVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i10, int i11) {
        return c(context, i10, i11, 0);
    }

    private static b c(Context context, int i10, int i11, int i12) {
        return d(context, i10, i11, new f8.a(i12));
    }

    private static b d(Context context, int i10, int i11, d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i11, true);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.ShapeAppearance);
        try {
            int i12 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i13 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i12);
            int i14 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i12);
            int i15 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i12);
            int i16 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i12);
            d m10 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, dVar);
            d m11 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, m10);
            d m12 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, m10);
            d m13 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, m10);
            return new b().C(i13, m11).G(i14, m12).x(i15, m13).t(i16, m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, m10));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i10, int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return g(context, attributeSet, i10, i11, new f8.a(i12));
    }

    public static b g(Context context, AttributeSet attributeSet, int i10, int i11, d dVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    public static d m(TypedArray typedArray, int i10, d dVar) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue == null) {
            return dVar;
        }
        int i11 = peekValue.type;
        if (i11 == 5) {
            return new f8.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i11 == 6) {
            return new m(peekValue.getFraction(1.0f, 1.0f));
        }
        return dVar;
    }

    public g h() {
        return this.f١٤١٨٩k;
    }

    public e i() {
        return this.f١٤١٨٢d;
    }

    public d j() {
        return this.f١٤١٨٦h;
    }

    public e k() {
        return this.f١٤١٨١c;
    }

    public d l() {
        return this.f١٤١٨٥g;
    }

    public g n() {
        return this.f١٤١٩٠l;
    }

    public g o() {
        return this.f١٤١٨٨j;
    }

    public g p() {
        return this.f١٤١٨٧i;
    }

    public e q() {
        return this.f١٤١٧٩a;
    }

    public d r() {
        return this.f١٤١٨٣e;
    }

    public e s() {
        return this.f١٤١٨٠b;
    }

    public d t() {
        return this.f١٤١٨٤f;
    }

    public String toString() {
        return "[" + r() + ", " + t() + ", " + l() + ", " + j() + "]";
    }

    public boolean u() {
        if ((this.f١٤١٨٠b instanceof n) && (this.f١٤١٧٩a instanceof n) && (this.f١٤١٨١c instanceof n) && (this.f١٤١٨٢d instanceof n)) {
            return true;
        }
        return false;
    }

    public boolean v(RectF rectF) {
        boolean z10;
        boolean z11;
        if (this.f١٤١٩٠l.getClass().equals(g.class) && this.f١٤١٨٨j.getClass().equals(g.class) && this.f١٤١٨٧i.getClass().equals(g.class) && this.f١٤١٨٩k.getClass().equals(g.class)) {
            z10 = true;
        } else {
            z10 = false;
        }
        float a10 = this.f١٤١٨٣e.a(rectF);
        if (this.f١٤١٨٤f.a(rectF) == a10 && this.f١٤١٨٦h.a(rectF) == a10 && this.f١٤١٨٥g.a(rectF) == a10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 || !z11 || !u()) {
            return false;
        }
        return true;
    }

    public b w() {
        return new b(this);
    }

    public o x(float f10) {
        return w().o(f10).m();
    }

    public o y(d dVar) {
        return w().p(dVar).m();
    }

    public o z(c cVar) {
        return w().F(cVar.a(r())).J(cVar.a(t())).w(cVar.a(j())).A(cVar.a(l())).m();
    }

    private o(b bVar) {
        this.f١٤١٧٩a = bVar.f١٤١٩١a;
        this.f١٤١٨٠b = bVar.f١٤١٩٢b;
        this.f١٤١٨١c = bVar.f١٤١٩٣c;
        this.f١٤١٨٢d = bVar.f١٤١٩٤d;
        this.f١٤١٨٣e = bVar.f١٤١٩٥e;
        this.f١٤١٨٤f = bVar.f١٤١٩٦f;
        this.f١٤١٨٥g = bVar.f١٤١٩٧g;
        this.f١٤١٨٦h = bVar.f١٤١٩٨h;
        this.f١٤١٨٧i = bVar.f١٤١٩٩i;
        this.f١٤١٨٨j = bVar.f١٤٢٠٠j;
        this.f١٤١٨٩k = bVar.f١٤٢٠١k;
        this.f١٤١٩٠l = bVar.f١٤٢٠٢l;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private e f١٤١٩١a;

        /* renamed from: b, reason: collision with root package name */
        private e f١٤١٩٢b;

        /* renamed from: c, reason: collision with root package name */
        private e f١٤١٩٣c;

        /* renamed from: d, reason: collision with root package name */
        private e f١٤١٩٤d;

        /* renamed from: e, reason: collision with root package name */
        private d f١٤١٩٥e;

        /* renamed from: f, reason: collision with root package name */
        private d f١٤١٩٦f;

        /* renamed from: g, reason: collision with root package name */
        private d f١٤١٩٧g;

        /* renamed from: h, reason: collision with root package name */
        private d f١٤١٩٨h;

        /* renamed from: i, reason: collision with root package name */
        private g f١٤١٩٩i;

        /* renamed from: j, reason: collision with root package name */
        private g f١٤٢٠٠j;

        /* renamed from: k, reason: collision with root package name */
        private g f١٤٢٠١k;

        /* renamed from: l, reason: collision with root package name */
        private g f١٤٢٠٢l;

        public b() {
            this.f١٤١٩١a = j.b();
            this.f١٤١٩٢b = j.b();
            this.f١٤١٩٣c = j.b();
            this.f١٤١٩٤d = j.b();
            this.f١٤١٩٥e = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٦f = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٧g = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٨h = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٩i = j.c();
            this.f١٤٢٠٠j = j.c();
            this.f١٤٢٠١k = j.c();
            this.f١٤٢٠٢l = j.c();
        }

        private static float n(e eVar) {
            if (eVar instanceof n) {
                return ((n) eVar).f١٤١٧٧a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f١٤٠٩٠a;
            }
            return -1.0f;
        }

        public b A(d dVar) {
            this.f١٤١٩٧g = dVar;
            return this;
        }

        public b B(g gVar) {
            this.f١٤١٩٩i = gVar;
            return this;
        }

        public b C(int i10, d dVar) {
            return D(j.a(i10)).F(dVar);
        }

        public b D(e eVar) {
            this.f١٤١٩١a = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                E(n10);
            }
            return this;
        }

        public b E(float f10) {
            this.f١٤١٩٥e = new f8.a(f10);
            return this;
        }

        public b F(d dVar) {
            this.f١٤١٩٥e = dVar;
            return this;
        }

        public b G(int i10, d dVar) {
            return H(j.a(i10)).J(dVar);
        }

        public b H(e eVar) {
            this.f١٤١٩٢b = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                I(n10);
            }
            return this;
        }

        public b I(float f10) {
            this.f١٤١٩٦f = new f8.a(f10);
            return this;
        }

        public b J(d dVar) {
            this.f١٤١٩٦f = dVar;
            return this;
        }

        public o m() {
            return new o(this);
        }

        public b o(float f10) {
            return E(f10).I(f10).z(f10).v(f10);
        }

        public b p(d dVar) {
            return F(dVar).J(dVar).A(dVar).w(dVar);
        }

        public b q(int i10, float f10) {
            return r(j.a(i10)).o(f10);
        }

        public b r(e eVar) {
            return D(eVar).H(eVar).y(eVar).u(eVar);
        }

        public b s(g gVar) {
            this.f١٤٢٠١k = gVar;
            return this;
        }

        public b t(int i10, d dVar) {
            return u(j.a(i10)).w(dVar);
        }

        public b u(e eVar) {
            this.f١٤١٩٤d = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                v(n10);
            }
            return this;
        }

        public b v(float f10) {
            this.f١٤١٩٨h = new f8.a(f10);
            return this;
        }

        public b w(d dVar) {
            this.f١٤١٩٨h = dVar;
            return this;
        }

        public b x(int i10, d dVar) {
            return y(j.a(i10)).A(dVar);
        }

        public b y(e eVar) {
            this.f١٤١٩٣c = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                z(n10);
            }
            return this;
        }

        public b z(float f10) {
            this.f١٤١٩٧g = new f8.a(f10);
            return this;
        }

        public b(o oVar) {
            this.f١٤١٩١a = j.b();
            this.f١٤١٩٢b = j.b();
            this.f١٤١٩٣c = j.b();
            this.f١٤١٩٤d = j.b();
            this.f١٤١٩٥e = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٦f = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٧g = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٨h = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤١٩٩i = j.c();
            this.f١٤٢٠٠j = j.c();
            this.f١٤٢٠١k = j.c();
            this.f١٤٢٠٢l = j.c();
            this.f١٤١٩١a = oVar.f١٤١٧٩a;
            this.f١٤١٩٢b = oVar.f١٤١٨٠b;
            this.f١٤١٩٣c = oVar.f١٤١٨١c;
            this.f١٤١٩٤d = oVar.f١٤١٨٢d;
            this.f١٤١٩٥e = oVar.f١٤١٨٣e;
            this.f١٤١٩٦f = oVar.f١٤١٨٤f;
            this.f١٤١٩٧g = oVar.f١٤١٨٥g;
            this.f١٤١٩٨h = oVar.f١٤١٨٦h;
            this.f١٤١٩٩i = oVar.f١٤١٨٧i;
            this.f١٤٢٠٠j = oVar.f١٤١٨٨j;
            this.f١٤٢٠١k = oVar.f١٤١٨٩k;
            this.f١٤٢٠٢l = oVar.f١٤١٩٠l;
        }
    }

    public o() {
        this.f١٤١٧٩a = j.b();
        this.f١٤١٨٠b = j.b();
        this.f١٤١٨١c = j.b();
        this.f١٤١٨٢d = j.b();
        this.f١٤١٨٣e = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٤١٨٤f = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٤١٨٥g = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٤١٨٦h = new f8.a(DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٤١٨٧i = j.c();
        this.f١٤١٨٨j = j.c();
        this.f١٤١٨٩k = j.c();
        this.f١٤١٩٠l = j.c();
    }
}
