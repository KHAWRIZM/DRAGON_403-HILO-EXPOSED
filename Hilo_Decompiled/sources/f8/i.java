package f8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.p;
import f8.q;
import java.util.BitSet;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i extends Drawable implements h2.g, r {
    private static final String F = "i";
    static final o G = o.a().q(0, DownloadProgress.UNKNOWN_PROGRESS).m();
    private static final Paint H;
    private static final e[] I;
    private v2.m A;

    /* renamed from: B, reason: collision with root package name */
    v2.l[] f١٤٠٩٢B;
    private float[] C;
    private float[] D;
    private d E;

    /* renamed from: a, reason: collision with root package name */
    private final o.c f١٤٠٩٣a;

    /* renamed from: b, reason: collision with root package name */
    private c f١٤٠٩٤b;

    /* renamed from: c, reason: collision with root package name */
    private final q.g[] f١٤٠٩٥c;

    /* renamed from: d, reason: collision with root package name */
    private final q.g[] f١٤٠٩٦d;

    /* renamed from: e, reason: collision with root package name */
    private final BitSet f١٤٠٩٧e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٤٠٩٨f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٤٠٩٩g;

    /* renamed from: h, reason: collision with root package name */
    private final Matrix f١٤١٠٠h;

    /* renamed from: i, reason: collision with root package name */
    private final Path f١٤١٠١i;

    /* renamed from: j, reason: collision with root package name */
    private final Path f١٤١٠٢j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f١٤١٠٣k;

    /* renamed from: l, reason: collision with root package name */
    private final RectF f١٤١٠٤l;

    /* renamed from: m, reason: collision with root package name */
    private final Region f١٤١٠٥m;

    /* renamed from: n, reason: collision with root package name */
    private final Region f١٤١٠٦n;

    /* renamed from: o, reason: collision with root package name */
    private final Paint f١٤١٠٧o;

    /* renamed from: p, reason: collision with root package name */
    private final Paint f١٤١٠٨p;

    /* renamed from: q, reason: collision with root package name */
    private final e8.a f١٤١٠٩q;

    /* renamed from: r, reason: collision with root package name */
    private final p.b f١٤١١٠r;

    /* renamed from: s, reason: collision with root package name */
    private final p f١٤١١١s;

    /* renamed from: t, reason: collision with root package name */
    private PorterDuffColorFilter f١٤١١٢t;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuffColorFilter f١٤١١٣u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٤١١٤v;

    /* renamed from: w, reason: collision with root package name */
    private final RectF f١٤١١٥w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f١٤١١٦x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f١٤١١٧y;

    /* renamed from: z, reason: collision with root package name */
    private o f١٤١١٨z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements o.c {
        a() {
        }

        @Override // f8.o.c
        public f8.d a(f8.d dVar) {
            if (!(dVar instanceof m)) {
                return new f8.b(-i.this.L(), dVar);
            }
            return dVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements p.b {
        b() {
        }

        @Override // f8.p.b
        public void a(q qVar, Matrix matrix, int i10) {
            i.this.f١٤٠٩٧e.set(i10, qVar.e());
            i.this.f١٤٠٩٥c[i10] = qVar.f(matrix);
        }

        @Override // f8.p.b
        public void b(q qVar, Matrix matrix, int i10) {
            i.this.f١٤٠٩٧e.set(i10 + 4, qVar.e());
            i.this.f١٤٠٩٦d[i10] = qVar.f(matrix);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
        void a(float f10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class e extends v2.i {

        /* renamed from: b, reason: collision with root package name */
        private final int f١٤١٤٤b;

        e(int i10) {
            super("cornerSizeAtIndex" + i10);
            this.f١٤١٤٤b = i10;
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(i iVar) {
            if (iVar.C != null) {
                return iVar.C[this.f١٤١٤٤b];
            }
            return DownloadProgress.UNKNOWN_PROGRESS;
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(i iVar, float f10) {
            if (iVar.C != null && iVar.C[this.f١٤١٤٤b] != f10) {
                iVar.C[this.f١٤١٤٤b] = f10;
                if (iVar.E != null) {
                    iVar.E.a(iVar.B());
                }
                iVar.invalidateSelf();
            }
        }
    }

    static {
        int i10 = 0;
        Paint paint = new Paint(1);
        H = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        I = new e[4];
        while (true) {
            e[] eVarArr = I;
            if (i10 < eVarArr.length) {
                eVarArr[i10] = new e(i10);
                i10++;
            } else {
                return;
            }
        }
    }

    public i() {
        this(new o());
    }

    private RectF A() {
        this.f١٤١٠٤l.set(z());
        float L = L();
        this.f١٤١٠٤l.inset(L, L);
        return this.f١٤١٠٤l;
    }

    private void A0() {
        float R = R();
        this.f١٤٠٩٤b.f١٤١٣٩s = (int) Math.ceil(0.75f * R);
        this.f١٤٠٩٤b.f١٤١٤٠t = (int) Math.ceil(R * 0.25f);
        z0();
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float L() {
        if (U()) {
            return this.f١٤١٠٨p.getStrokeWidth() / 2.0f;
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private boolean S() {
        c cVar = this.f١٤٠٩٤b;
        int i10 = cVar.f١٤١٣٨r;
        if (i10 != 1 && cVar.f١٤١٣٩s > 0 && (i10 == 2 || c0())) {
            return true;
        }
        return false;
    }

    private boolean T() {
        Paint.Style style = this.f١٤٠٩٤b.f١٤١٤٣w;
        if (style != Paint.Style.FILL_AND_STROKE && style != Paint.Style.FILL) {
            return false;
        }
        return true;
    }

    private boolean U() {
        Paint.Style style = this.f١٤٠٩٤b.f١٤١٤٣w;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f١٤١٠٨p.getStrokeWidth() > DownloadProgress.UNKNOWN_PROGRESS) {
            return true;
        }
        return false;
    }

    private void W() {
        super.invalidateSelf();
    }

    private void Z(Canvas canvas) {
        if (!S()) {
            return;
        }
        canvas.save();
        b0(canvas);
        if (!this.f١٤١١٦x) {
            s(canvas);
            canvas.restore();
            return;
        }
        int width = (int) (this.f١٤١١٥w.width() - getBounds().width());
        int height = (int) (this.f١٤١١٥w.height() - getBounds().height());
        if (width >= 0 && height >= 0) {
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.f١٤١١٥w.width()) + (this.f١٤٠٩٤b.f١٤١٣٩s * 2) + width, ((int) this.f١٤١١٥w.height()) + (this.f١٤٠٩٤b.f١٤١٣٩s * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f10 = (getBounds().left - this.f١٤٠٩٤b.f١٤١٣٩s) - width;
            float f11 = (getBounds().top - this.f١٤٠٩٤b.f١٤١٣٩s) - height;
            canvas2.translate(-f10, -f11);
            s(canvas2);
            canvas.drawBitmap(createBitmap, f10, f11, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int a0(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    private void b0(Canvas canvas) {
        canvas.translate(H(), I());
    }

    private PorterDuffColorFilter j(Paint paint, boolean z10) {
        if (z10) {
            int color = paint.getColor();
            int q10 = q(color);
            this.f١٤١١٤v = q10;
            if (q10 != color) {
                return new PorterDuffColorFilter(q10, PorterDuff.Mode.SRC_IN);
            }
            return null;
        }
        return null;
    }

    private void k(RectF rectF, Path path) {
        l(rectF, path);
        if (this.f١٤٠٩٤b.f١٤١٣١k != 1.0f) {
            this.f١٤١٠٠h.reset();
            Matrix matrix = this.f١٤١٠٠h;
            float f10 = this.f١٤٠٩٤b.f١٤١٣١k;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f١٤١٠٠h);
        }
        path.computeBounds(this.f١٤١١٥w, true);
    }

    private float m(RectF rectF, o oVar, float[] fArr) {
        if (fArr == null) {
            if (oVar.v(rectF)) {
                return oVar.r().a(rectF);
            }
            return -1.0f;
        }
        if (z7.a.a(fArr) && oVar.u()) {
            return fArr[0];
        }
        return -1.0f;
    }

    private void n() {
        y0();
        this.f١٤١١١s.f(this.f١٤١١٨z, this.D, this.f١٤٠٩٤b.f١٤١٣٢l, A(), null, this.f١٤١٠٢j);
    }

    private PorterDuffColorFilter o(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = q(colorForState);
        }
        this.f١٤١١٤v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter p(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z10) {
        if (colorStateList != null && mode != null) {
            return o(colorStateList, mode, z10);
        }
        return j(paint, z10);
    }

    public static i r(Context context, float f10, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(v7.a.c(context, R.attr.colorSurface, i.class.getSimpleName()));
        }
        i iVar = new i();
        iVar.V(context);
        iVar.h0(colorStateList);
        iVar.g0(f10);
        return iVar;
    }

    private void s(Canvas canvas) {
        if (this.f١٤٠٩٧e.cardinality() > 0) {
            Log.w(F, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f١٤٠٩٤b.f١٤١٤٠t != 0) {
            canvas.drawPath(this.f١٤١٠١i, this.f١٤١٠٩q.c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f١٤٠٩٥c[i10].b(this.f١٤١٠٩q, this.f١٤٠٩٤b.f١٤١٣٩s, canvas);
            this.f١٤٠٩٦d[i10].b(this.f١٤١٠٩q, this.f١٤٠٩٤b.f١٤١٣٩s, canvas);
        }
        if (this.f١٤١١٦x) {
            int H2 = H();
            int I2 = I();
            canvas.translate(-H2, -I2);
            canvas.drawPath(this.f١٤١٠١i, H);
            canvas.translate(H2, I2);
        }
    }

    private void t(Canvas canvas) {
        v(canvas, this.f١٤١٠٧o, this.f١٤١٠١i, this.f١٤٠٩٤b.f١٤١٢١a, this.C, z());
    }

    private void v(Canvas canvas, Paint paint, Path path, o oVar, float[] fArr, RectF rectF) {
        float m10 = m(rectF, oVar, fArr);
        if (m10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            float f10 = m10 * this.f١٤٠٩٤b.f١٤١٣٢l;
            canvas.drawRoundRect(rectF, f10, f10, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    private boolean v0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f١٤٠٩٤b.f١٤١٢٥e != null && color2 != (colorForState2 = this.f١٤٠٩٤b.f١٤١٢٥e.getColorForState(iArr, (color2 = this.f١٤١٠٧o.getColor())))) {
            this.f١٤١٠٧o.setColor(colorForState2);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f١٤٠٩٤b.f١٤١٢٦f != null && color != (colorForState = this.f١٤٠٩٤b.f١٤١٢٦f.getColorForState(iArr, (color = this.f١٤١٠٨p.getColor())))) {
            this.f١٤١٠٨p.setColor(colorForState);
            return true;
        }
        return z10;
    }

    private void w0(int[] iArr) {
        x0(iArr, false);
    }

    private void x0(int[] iArr, boolean z10) {
        boolean z11;
        RectF z12 = z();
        if (this.f١٤٠٩٤b.f١٤١٢٢b != null && !z12.isEmpty()) {
            if (this.A == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z13 = z10 | z11;
            if (this.C == null) {
                this.C = new float[4];
            }
            o d10 = this.f١٤٠٩٤b.f١٤١٢٢b.d(iArr);
            for (int i10 = 0; i10 < 4; i10++) {
                float a10 = this.f١٤١١١s.h(i10, d10).a(z12);
                if (z13) {
                    this.C[i10] = a10;
                }
                v2.l lVar = this.f١٤٠٩٢B[i10];
                if (lVar != null) {
                    lVar.u(a10);
                    if (z13) {
                        this.f١٤٠٩٢B[i10].z();
                    }
                }
            }
            if (z13) {
                invalidateSelf();
            }
        }
    }

    private void y0() {
        this.f١٤١١٨z = getShapeAppearanceModel().z(this.f١٤٠٩٣a);
        float[] fArr = this.C;
        if (fArr == null) {
            this.D = null;
            return;
        }
        if (this.D == null) {
            this.D = new float[fArr.length];
        }
        float L = L();
        int i10 = 0;
        while (true) {
            float[] fArr2 = this.C;
            if (i10 < fArr2.length) {
                this.D[i10] = Math.max(DownloadProgress.UNKNOWN_PROGRESS, fArr2[i10] - L);
                i10++;
            } else {
                return;
            }
        }
    }

    private boolean z0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f١٤١١٢t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f١٤١١٣u;
        c cVar = this.f١٤٠٩٤b;
        this.f١٤١١٢t = p(cVar.f١٤١٢٨h, cVar.f١٤١٢٩i, this.f١٤١٠٧o, true);
        c cVar2 = this.f١٤٠٩٤b;
        this.f١٤١١٣u = p(cVar2.f١٤١٢٧g, cVar2.f١٤١٢٩i, this.f١٤١٠٨p, false);
        c cVar3 = this.f١٤٠٩٤b;
        if (cVar3.f١٤١٤٢v) {
            this.f١٤١٠٩q.d(cVar3.f١٤١٢٨h.getColorForState(getState(), 0));
        }
        if (!androidx.core.util.f.a(porterDuffColorFilter, this.f١٤١١٢t) || !androidx.core.util.f.a(porterDuffColorFilter2, this.f١٤١١٣u)) {
            return true;
        }
        return false;
    }

    public float B() {
        float a10;
        float a11;
        float[] fArr = this.C;
        if (fArr != null) {
            a10 = (fArr[3] + fArr[2]) - fArr[1];
            a11 = fArr[0];
        } else {
            RectF z10 = z();
            a10 = (this.f١٤١١١s.h(3, getShapeAppearanceModel()).a(z10) + this.f١٤١١١s.h(2, getShapeAppearanceModel()).a(z10)) - this.f١٤١١١s.h(1, getShapeAppearanceModel()).a(z10);
            a11 = this.f١٤١١١s.h(0, getShapeAppearanceModel()).a(z10);
        }
        return (a10 - a11) / 2.0f;
    }

    public float C() {
        return this.f١٤٠٩٤b.f١٤١٣٦p;
    }

    public ColorStateList D() {
        return this.f١٤٠٩٤b.f١٤١٢٥e;
    }

    public float E() {
        return this.f١٤٠٩٤b.f١٤١٣٢l;
    }

    public float F() {
        return this.f١٤٠٩٤b.f١٤١٣٥o;
    }

    public int G() {
        return this.f١٤١١٤v;
    }

    public int H() {
        c cVar = this.f١٤٠٩٤b;
        return (int) (cVar.f١٤١٤٠t * Math.sin(Math.toRadians(cVar.f١٤١٤١u)));
    }

    public int I() {
        c cVar = this.f١٤٠٩٤b;
        return (int) (cVar.f١٤١٤٠t * Math.cos(Math.toRadians(cVar.f١٤١٤١u)));
    }

    public int J() {
        return this.f١٤٠٩٤b.f١٤١٣٩s;
    }

    public ColorStateList K() {
        return this.f١٤٠٩٤b.f١٤١٢٦f;
    }

    public float M() {
        return this.f١٤٠٩٤b.f١٤١٣٣m;
    }

    public ColorStateList N() {
        return this.f١٤٠٩٤b.f١٤١٢٨h;
    }

    public float O() {
        float[] fArr = this.C;
        if (fArr != null) {
            return fArr[3];
        }
        return this.f١٤٠٩٤b.f١٤١٢١a.r().a(z());
    }

    public float P() {
        float[] fArr = this.C;
        if (fArr != null) {
            return fArr[0];
        }
        return this.f١٤٠٩٤b.f١٤١٢١a.t().a(z());
    }

    public float Q() {
        return this.f١٤٠٩٤b.f١٤١٣٧q;
    }

    public float R() {
        return C() + Q();
    }

    public void V(Context context) {
        this.f١٤٠٩٤b.f١٤١٢٣c = new x7.a(context);
        A0();
    }

    public boolean X() {
        x7.a aVar = this.f١٤٠٩٤b.f١٤١٢٣c;
        if (aVar != null && aVar.e()) {
            return true;
        }
        return false;
    }

    public boolean Y() {
        float[] fArr;
        if (!this.f١٤٠٩٤b.f١٤١٢١a.v(z()) && ((fArr = this.C) == null || !z7.a.a(fArr) || !this.f١٤٠٩٤b.f١٤١٢١a.u())) {
            return false;
        }
        return true;
    }

    public boolean c0() {
        if (!Y() && !this.f١٤١٠١i.isConvex() && Build.VERSION.SDK_INT < 29) {
            return true;
        }
        return false;
    }

    public void d0(float f10) {
        setShapeAppearanceModel(this.f١٤٠٩٤b.f١٤١٢١a.x(f10));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f١٤١٠٧o.setColorFilter(this.f١٤١١٢t);
        int alpha = this.f١٤١٠٧o.getAlpha();
        this.f١٤١٠٧o.setAlpha(a0(alpha, this.f١٤٠٩٤b.f١٤١٣٤n));
        this.f١٤١٠٨p.setColorFilter(this.f١٤١١٣u);
        this.f١٤١٠٨p.setStrokeWidth(this.f١٤٠٩٤b.f١٤١٣٣m);
        int alpha2 = this.f١٤١٠٨p.getAlpha();
        this.f١٤١٠٨p.setAlpha(a0(alpha2, this.f١٤٠٩٤b.f١٤١٣٤n));
        if (T()) {
            if (this.f١٤٠٩٨f) {
                k(z(), this.f١٤١٠١i);
                this.f١٤٠٩٨f = false;
            }
            Z(canvas);
            t(canvas);
        }
        if (U()) {
            if (this.f١٤٠٩٩g) {
                n();
                this.f١٤٠٩٩g = false;
            }
            w(canvas);
        }
        this.f١٤١٠٧o.setAlpha(alpha);
        this.f١٤١٠٨p.setAlpha(alpha2);
    }

    public void e0(f8.d dVar) {
        setShapeAppearanceModel(this.f١٤٠٩٤b.f١٤١٢١a.y(dVar));
    }

    public void f0(v2.m mVar) {
        if (this.A != mVar) {
            this.A = mVar;
            int i10 = 0;
            while (true) {
                v2.l[] lVarArr = this.f١٤٠٩٢B;
                if (i10 < lVarArr.length) {
                    if (lVarArr[i10] == null) {
                        lVarArr[i10] = new v2.l(this, I[i10]);
                    }
                    this.f١٤٠٩٢B[i10].y(new v2.m().f(mVar.a()).h(mVar.c()));
                    i10++;
                } else {
                    x0(getState(), true);
                    invalidateSelf();
                    return;
                }
            }
        }
    }

    public void g0(float f10) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٣٦p != f10) {
            cVar.f١٤١٣٦p = f10;
            A0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f١٤٠٩٤b.f١٤١٣٤n;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f١٤٠٩٤b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f١٤٠٩٤b.f١٤١٣٨r == 2) {
            return;
        }
        RectF z10 = z();
        if (z10.isEmpty()) {
            return;
        }
        float m10 = m(z10, this.f١٤٠٩٤b.f١٤١٢١a, this.C);
        if (m10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            outline.setRoundRect(getBounds(), m10 * this.f١٤٠٩٤b.f١٤١٣٢l);
            return;
        }
        if (this.f١٤٠٩٨f) {
            k(z10, this.f١٤١٠١i);
            this.f١٤٠٩٨f = false;
        }
        com.google.android.material.drawable.g.l(outline, this.f١٤١٠١i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f١٤٠٩٤b.f١٤١٣٠j;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // f8.r
    public o getShapeAppearanceModel() {
        return this.f١٤٠٩٤b.f١٤١٢١a;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f١٤١٠٥m.set(getBounds());
        k(z(), this.f١٤١٠١i);
        this.f١٤١٠٦n.setPath(this.f١٤١٠١i, this.f١٤١٠٥m);
        this.f١٤١٠٥m.op(this.f١٤١٠٦n, Region.Op.DIFFERENCE);
        return this.f١٤١٠٥m;
    }

    public void h0(ColorStateList colorStateList) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٢٥e != colorStateList) {
            cVar.f١٤١٢٥e = colorStateList;
            onStateChange(getState());
        }
    }

    public void i0(float f10) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٣٢l != f10) {
            cVar.f١٤١٣٢l = f10;
            this.f١٤٠٩٨f = true;
            this.f١٤٠٩٩g = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f١٤٠٩٨f = true;
        this.f١٤٠٩٩g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        w wVar;
        if (!super.isStateful() && (((colorStateList = this.f١٤٠٩٤b.f١٤١٢٨h) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.f١٤٠٩٤b.f١٤١٢٧g) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.f١٤٠٩٤b.f١٤١٢٦f) == null || !colorStateList3.isStateful()) && (((colorStateList4 = this.f١٤٠٩٤b.f١٤١٢٥e) == null || !colorStateList4.isStateful()) && ((wVar = this.f١٤٠٩٤b.f١٤١٢٢b) == null || !wVar.f())))))) {
            return false;
        }
        return true;
    }

    public void j0(int i10, int i11, int i12, int i13) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٣٠j == null) {
            cVar.f١٤١٣٠j = new Rect();
        }
        this.f١٤٠٩٤b.f١٤١٣٠j.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void k0(Paint.Style style) {
        this.f١٤٠٩٤b.f١٤١٤٣w = style;
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l(RectF rectF, Path path) {
        p pVar = this.f١٤١١١s;
        c cVar = this.f١٤٠٩٤b;
        pVar.f(cVar.f١٤١٢١a, this.C, cVar.f١٤١٣٢l, rectF, this.f١٤١١٠r, path);
    }

    public void l0(float f10) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٣٥o != f10) {
            cVar.f١٤١٣٥o = f10;
            A0();
        }
    }

    public void m0(boolean z10) {
        this.f١٤١١٦x = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f١٤٠٩٤b = new c(this.f١٤٠٩٤b);
        return this;
    }

    public void n0(int i10) {
        this.f١٤١٠٩q.d(i10);
        this.f١٤٠٩٤b.f١٤١٤٢v = false;
        W();
    }

    public void o0(int i10) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٣٨r != i10) {
            cVar.f١٤١٣٨r = i10;
            W();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f١٤٠٩٨f = true;
        this.f١٤٠٩٩g = true;
        super.onBoundsChange(rect);
        if (this.f١٤٠٩٤b.f١٤١٢٢b != null && !rect.isEmpty()) {
            x0(getState(), this.f١٤١١٧y);
        }
        this.f١٤١١٧y = rect.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.e0.b
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        if (this.f١٤٠٩٤b.f١٤١٢٢b != null) {
            w0(iArr);
        }
        boolean v02 = v0(iArr);
        boolean z02 = z0();
        if (!v02 && !z02) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public void p0(int i10) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٤٠t != i10) {
            cVar.f١٤١٤٠t = i10;
            W();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int q(int i10) {
        float R = R() + F();
        x7.a aVar = this.f١٤٠٩٤b.f١٤١٢٣c;
        if (aVar != null) {
            return aVar.c(i10, R);
        }
        return i10;
    }

    public void q0(w wVar) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٢٢b != wVar) {
            cVar.f١٤١٢٢b = wVar;
            x0(getState(), true);
            invalidateSelf();
        }
    }

    public void r0(float f10, int i10) {
        u0(f10);
        t0(ColorStateList.valueOf(i10));
    }

    public void s0(float f10, ColorStateList colorStateList) {
        u0(f10);
        t0(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٣٤n != i10) {
            cVar.f١٤١٣٤n = i10;
            W();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٤٠٩٤b.f١٤١٢٤d = colorFilter;
        W();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOnCornerSizeChangeListener(d dVar) {
        this.E = dVar;
    }

    @Override // f8.r
    public void setShapeAppearanceModel(o oVar) {
        c cVar = this.f١٤٠٩٤b;
        cVar.f١٤١٢١a = oVar;
        cVar.f١٤١٢٢b = null;
        this.C = null;
        this.D = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f١٤٠٩٤b.f١٤١٢٨h = colorStateList;
        z0();
        W();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٢٩i != mode) {
            cVar.f١٤١٢٩i = mode;
            z0();
            W();
        }
    }

    public void t0(ColorStateList colorStateList) {
        c cVar = this.f١٤٠٩٤b;
        if (cVar.f١٤١٢٦f != colorStateList) {
            cVar.f١٤١٢٦f = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(Canvas canvas, Paint paint, Path path, RectF rectF) {
        v(canvas, paint, path, this.f١٤٠٩٤b.f١٤١٢١a, this.C, rectF);
    }

    public void u0(float f10) {
        this.f١٤٠٩٤b.f١٤١٣٣m = f10;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(Canvas canvas) {
        v(canvas, this.f١٤١٠٨p, this.f١٤١٠٢j, this.f١٤١١٨z, this.D, A());
    }

    public float x() {
        float[] fArr = this.C;
        if (fArr != null) {
            return fArr[2];
        }
        return this.f١٤٠٩٤b.f١٤١٢١a.j().a(z());
    }

    public float y() {
        float[] fArr = this.C;
        if (fArr != null) {
            return fArr[1];
        }
        return this.f١٤٠٩٤b.f١٤١٢١a.l().a(z());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF z() {
        this.f١٤١٠٣k.set(getBounds());
        return this.f١٤١٠٣k;
    }

    public i(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(o.e(context, attributeSet, i10, i11).m());
    }

    public i(o oVar) {
        this(new c(oVar, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(c cVar) {
        p pVar;
        this.f١٤٠٩٣a = new a();
        this.f١٤٠٩٥c = new q.g[4];
        this.f١٤٠٩٦d = new q.g[4];
        this.f١٤٠٩٧e = new BitSet(8);
        this.f١٤١٠٠h = new Matrix();
        this.f١٤١٠١i = new Path();
        this.f١٤١٠٢j = new Path();
        this.f١٤١٠٣k = new RectF();
        this.f١٤١٠٤l = new RectF();
        this.f١٤١٠٥m = new Region();
        this.f١٤١٠٦n = new Region();
        Paint paint = new Paint(1);
        this.f١٤١٠٧o = paint;
        Paint paint2 = new Paint(1);
        this.f١٤١٠٨p = paint2;
        this.f١٤١٠٩q = new e8.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            pVar = p.l();
        } else {
            pVar = new p();
        }
        this.f١٤١١١s = pVar;
        this.f١٤١١٥w = new RectF();
        this.f١٤١١٦x = true;
        this.f١٤١١٧y = true;
        this.f١٤٠٩٢B = new v2.l[4];
        this.f١٤٠٩٤b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        z0();
        v0(getState());
        this.f١٤١١٠r = new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        o f١٤١٢١a;

        /* renamed from: b, reason: collision with root package name */
        w f١٤١٢٢b;

        /* renamed from: c, reason: collision with root package name */
        x7.a f١٤١٢٣c;

        /* renamed from: d, reason: collision with root package name */
        ColorFilter f١٤١٢٤d;

        /* renamed from: e, reason: collision with root package name */
        ColorStateList f١٤١٢٥e;

        /* renamed from: f, reason: collision with root package name */
        ColorStateList f١٤١٢٦f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f١٤١٢٧g;

        /* renamed from: h, reason: collision with root package name */
        ColorStateList f١٤١٢٨h;

        /* renamed from: i, reason: collision with root package name */
        PorterDuff.Mode f١٤١٢٩i;

        /* renamed from: j, reason: collision with root package name */
        Rect f١٤١٣٠j;

        /* renamed from: k, reason: collision with root package name */
        float f١٤١٣١k;

        /* renamed from: l, reason: collision with root package name */
        float f١٤١٣٢l;

        /* renamed from: m, reason: collision with root package name */
        float f١٤١٣٣m;

        /* renamed from: n, reason: collision with root package name */
        int f١٤١٣٤n;

        /* renamed from: o, reason: collision with root package name */
        float f١٤١٣٥o;

        /* renamed from: p, reason: collision with root package name */
        float f١٤١٣٦p;

        /* renamed from: q, reason: collision with root package name */
        float f١٤١٣٧q;

        /* renamed from: r, reason: collision with root package name */
        int f١٤١٣٨r;

        /* renamed from: s, reason: collision with root package name */
        int f١٤١٣٩s;

        /* renamed from: t, reason: collision with root package name */
        int f١٤١٤٠t;

        /* renamed from: u, reason: collision with root package name */
        int f١٤١٤١u;

        /* renamed from: v, reason: collision with root package name */
        boolean f١٤١٤٢v;

        /* renamed from: w, reason: collision with root package name */
        Paint.Style f١٤١٤٣w;

        public c(o oVar, x7.a aVar) {
            this.f١٤١٢٥e = null;
            this.f١٤١٢٦f = null;
            this.f١٤١٢٧g = null;
            this.f١٤١٢٨h = null;
            this.f١٤١٢٩i = PorterDuff.Mode.SRC_IN;
            this.f١٤١٣٠j = null;
            this.f١٤١٣١k = 1.0f;
            this.f١٤١٣٢l = 1.0f;
            this.f١٤١٣٤n = KotlinVersion.MAX_COMPONENT_VALUE;
            this.f١٤١٣٥o = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٤١٣٦p = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٤١٣٧q = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٤١٣٨r = 0;
            this.f١٤١٣٩s = 0;
            this.f١٤١٤٠t = 0;
            this.f١٤١٤١u = 0;
            this.f١٤١٤٢v = false;
            this.f١٤١٤٣w = Paint.Style.FILL_AND_STROKE;
            this.f١٤١٢١a = oVar;
            this.f١٤١٢٣c = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i(this);
            iVar.f١٤٠٩٨f = true;
            iVar.f١٤٠٩٩g = true;
            return iVar;
        }

        public c(c cVar) {
            this.f١٤١٢٥e = null;
            this.f١٤١٢٦f = null;
            this.f١٤١٢٧g = null;
            this.f١٤١٢٨h = null;
            this.f١٤١٢٩i = PorterDuff.Mode.SRC_IN;
            this.f١٤١٣٠j = null;
            this.f١٤١٣١k = 1.0f;
            this.f١٤١٣٢l = 1.0f;
            this.f١٤١٣٤n = KotlinVersion.MAX_COMPONENT_VALUE;
            this.f١٤١٣٥o = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٤١٣٦p = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٤١٣٧q = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٤١٣٨r = 0;
            this.f١٤١٣٩s = 0;
            this.f١٤١٤٠t = 0;
            this.f١٤١٤١u = 0;
            this.f١٤١٤٢v = false;
            this.f١٤١٤٣w = Paint.Style.FILL_AND_STROKE;
            this.f١٤١٢١a = cVar.f١٤١٢١a;
            this.f١٤١٢٢b = cVar.f١٤١٢٢b;
            this.f١٤١٢٣c = cVar.f١٤١٢٣c;
            this.f١٤١٣٣m = cVar.f١٤١٣٣m;
            this.f١٤١٢٤d = cVar.f١٤١٢٤d;
            this.f١٤١٢٥e = cVar.f١٤١٢٥e;
            this.f١٤١٢٦f = cVar.f١٤١٢٦f;
            this.f١٤١٢٩i = cVar.f١٤١٢٩i;
            this.f١٤١٢٨h = cVar.f١٤١٢٨h;
            this.f١٤١٣٤n = cVar.f١٤١٣٤n;
            this.f١٤١٣١k = cVar.f١٤١٣١k;
            this.f١٤١٤٠t = cVar.f١٤١٤٠t;
            this.f١٤١٣٨r = cVar.f١٤١٣٨r;
            this.f١٤١٤٢v = cVar.f١٤١٤٢v;
            this.f١٤١٣٢l = cVar.f١٤١٣٢l;
            this.f١٤١٣٥o = cVar.f١٤١٣٥o;
            this.f١٤١٣٦p = cVar.f١٤١٣٦p;
            this.f١٤١٣٧q = cVar.f١٤١٣٧q;
            this.f١٤١٣٩s = cVar.f١٤١٣٩s;
            this.f١٤١٤١u = cVar.f١٤١٤١u;
            this.f١٤١٢٧g = cVar.f١٤١٢٧g;
            this.f١٤١٤٣w = cVar.f١٤١٤٣w;
            if (cVar.f١٤١٣٠j != null) {
                this.f١٤١٣٠j = new Rect(cVar.f١٤١٣٠j);
            }
        }
    }
}
