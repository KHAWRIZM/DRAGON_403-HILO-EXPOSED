package t3;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.j;
import com.airbnb.lottie.j0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinVersion;
import o3.a;
import o3.p;
import s3.i;
import t3.e;
import x3.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b implements n3.e, a.b, q3.f {
    private Paint A;

    /* renamed from: B, reason: collision with root package name */
    float f١٧٩٤٩B;
    BlurMaskFilter C;

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٧٩٥٠a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f١٧٩٥١b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f١٧٩٥٢c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    private final Paint f١٧٩٥٣d = new m3.a(1);

    /* renamed from: e, reason: collision with root package name */
    private final Paint f١٧٩٥٤e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f١٧٩٥٥f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f١٧٩٥٦g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f١٧٩٥٧h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f١٧٩٥٨i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f١٧٩٥٩j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f١٧٩٦٠k;

    /* renamed from: l, reason: collision with root package name */
    private final RectF f١٧٩٦١l;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f١٧٩٦٢m;

    /* renamed from: n, reason: collision with root package name */
    private final String f١٧٩٦٣n;

    /* renamed from: o, reason: collision with root package name */
    final Matrix f١٧٩٦٤o;

    /* renamed from: p, reason: collision with root package name */
    final j0 f١٧٩٦٥p;

    /* renamed from: q, reason: collision with root package name */
    final e f١٧٩٦٦q;

    /* renamed from: r, reason: collision with root package name */
    private o3.h f١٧٩٦٧r;

    /* renamed from: s, reason: collision with root package name */
    private o3.d f١٧٩٦٨s;

    /* renamed from: t, reason: collision with root package name */
    private b f١٧٩٦٩t;

    /* renamed from: u, reason: collision with root package name */
    private b f١٧٩٧٠u;

    /* renamed from: v, reason: collision with root package name */
    private List f١٧٩٧١v;

    /* renamed from: w, reason: collision with root package name */
    private final List f١٧٩٧٢w;

    /* renamed from: x, reason: collision with root package name */
    final p f١٧٩٧٣x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f١٧٩٧٤y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f١٧٩٧٥z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٩٧٦a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f١٧٩٧٧b;

        static {
            int[] iArr = new int[i.a.values().length];
            f١٧٩٧٧b = iArr;
            try {
                iArr[i.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٧٩٧٧b[i.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٧٩٧٧b[i.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٧٩٧٧b[i.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[e.a.values().length];
            f١٧٩٧٦a = iArr2;
            try {
                iArr2[e.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٧٩٧٦a[e.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٧٩٧٦a[e.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f١٧٩٧٦a[e.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١٧٩٧٦a[e.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١٧٩٧٦a[e.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f١٧٩٧٦a[e.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(j0 j0Var, e eVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f١٧٩٥٤e = new m3.a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f١٧٩٥٥f = new m3.a(1, mode2);
        m3.a aVar = new m3.a(1);
        this.f١٧٩٥٦g = aVar;
        this.f١٧٩٥٧h = new m3.a(PorterDuff.Mode.CLEAR);
        this.f١٧٩٥٨i = new RectF();
        this.f١٧٩٥٩j = new RectF();
        this.f١٧٩٦٠k = new RectF();
        this.f١٧٩٦١l = new RectF();
        this.f١٧٩٦٢m = new RectF();
        this.f١٧٩٦٤o = new Matrix();
        this.f١٧٩٧٢w = new ArrayList();
        this.f١٧٩٧٤y = true;
        this.f١٧٩٤٩B = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٧٩٦٥p = j0Var;
        this.f١٧٩٦٦q = eVar;
        this.f١٧٩٦٣n = eVar.j() + "#draw";
        if (eVar.i() == e.b.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        p b10 = eVar.x().b();
        this.f١٧٩٧٣x = b10;
        b10.b(this);
        if (eVar.h() != null && !eVar.h().isEmpty()) {
            o3.h hVar = new o3.h(eVar.h());
            this.f١٧٩٦٧r = hVar;
            Iterator it = hVar.a().iterator();
            while (it.hasNext()) {
                ((o3.a) it.next()).a(this);
            }
            for (o3.a aVar2 : this.f١٧٩٦٧r.c()) {
                i(aVar2);
                aVar2.a(this);
            }
        }
        O();
    }

    private void C(RectF rectF, Matrix matrix) {
        this.f١٧٩٦٠k.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        if (!A()) {
            return;
        }
        int size = this.f١٧٩٦٧r.b().size();
        for (int i10 = 0; i10 < size; i10++) {
            s3.i iVar = (s3.i) this.f١٧٩٦٧r.b().get(i10);
            Path path = (Path) ((o3.a) this.f١٧٩٦٧r.a().get(i10)).h();
            if (path != null) {
                this.f١٧٩٥٠a.set(path);
                this.f١٧٩٥٠a.transform(matrix);
                int i11 = a.f١٧٩٧٧b[iVar.a().ordinal()];
                if (i11 != 1 && i11 != 2) {
                    if ((i11 == 3 || i11 == 4) && iVar.d()) {
                        return;
                    }
                    this.f١٧٩٥٠a.computeBounds(this.f١٧٩٦٢m, false);
                    if (i10 == 0) {
                        this.f١٧٩٦٠k.set(this.f١٧٩٦٢m);
                    } else {
                        RectF rectF2 = this.f١٧٩٦٠k;
                        rectF2.set(Math.min(rectF2.left, this.f١٧٩٦٢m.left), Math.min(this.f١٧٩٦٠k.top, this.f١٧٩٦٢m.top), Math.max(this.f١٧٩٦٠k.right, this.f١٧٩٦٢m.right), Math.max(this.f١٧٩٦٠k.bottom, this.f١٧٩٦٢m.bottom));
                    }
                } else {
                    return;
                }
            }
        }
        if (!rectF.intersect(this.f١٧٩٦٠k)) {
            rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        }
    }

    private void D(RectF rectF, Matrix matrix) {
        if (!B() || this.f١٧٩٦٦q.i() == e.b.INVERT) {
            return;
        }
        this.f١٧٩٦١l.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٧٩٦٩t.f(this.f١٧٩٦١l, matrix, true);
        if (!rectF.intersect(this.f١٧٩٦١l)) {
            rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        }
    }

    private void E() {
        this.f١٧٩٦٥p.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        boolean z10;
        if (this.f١٧٩٦٨s.q() == 1.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        N(z10);
    }

    private void G(float f10) {
        this.f١٧٩٦٥p.J().n().a(this.f١٧٩٦٦q.j(), f10);
    }

    private void N(boolean z10) {
        if (z10 != this.f١٧٩٧٤y) {
            this.f١٧٩٧٤y = z10;
            E();
        }
    }

    private void O() {
        boolean z10 = true;
        if (!this.f١٧٩٦٦q.f().isEmpty()) {
            o3.d dVar = new o3.d(this.f١٧٩٦٦q.f());
            this.f١٧٩٦٨s = dVar;
            dVar.m();
            this.f١٧٩٦٨s.a(new a.b() { // from class: t3.a
                @Override // o3.a.b
                public final void a() {
                    b.this.F();
                }
            });
            if (((Float) this.f١٧٩٦٨s.h()).floatValue() != 1.0f) {
                z10 = false;
            }
            N(z10);
            i(this.f١٧٩٦٨s);
            return;
        }
        N(true);
    }

    private void j(Canvas canvas, Matrix matrix, o3.a aVar, o3.a aVar2) {
        this.f١٧٩٥٠a.set((Path) aVar.h());
        this.f١٧٩٥٠a.transform(matrix);
        this.f١٧٩٥٣d.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f١٧٩٥٠a, this.f١٧٩٥٣d);
    }

    private void k(Canvas canvas, Matrix matrix, o3.a aVar, o3.a aVar2) {
        l.m(canvas, this.f١٧٩٥٨i, this.f١٧٩٥٤e);
        this.f١٧٩٥٠a.set((Path) aVar.h());
        this.f١٧٩٥٠a.transform(matrix);
        this.f١٧٩٥٣d.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f١٧٩٥٠a, this.f١٧٩٥٣d);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, o3.a aVar, o3.a aVar2) {
        l.m(canvas, this.f١٧٩٥٨i, this.f١٧٩٥٣d);
        canvas.drawRect(this.f١٧٩٥٨i, this.f١٧٩٥٣d);
        this.f١٧٩٥٠a.set((Path) aVar.h());
        this.f١٧٩٥٠a.transform(matrix);
        this.f١٧٩٥٣d.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f١٧٩٥٠a, this.f١٧٩٥٥f);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, o3.a aVar, o3.a aVar2) {
        l.m(canvas, this.f١٧٩٥٨i, this.f١٧٩٥٤e);
        canvas.drawRect(this.f١٧٩٥٨i, this.f١٧٩٥٣d);
        this.f١٧٩٥٥f.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        this.f١٧٩٥٠a.set((Path) aVar.h());
        this.f١٧٩٥٠a.transform(matrix);
        canvas.drawPath(this.f١٧٩٥٠a, this.f١٧٩٥٥f);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, o3.a aVar, o3.a aVar2) {
        l.m(canvas, this.f١٧٩٥٨i, this.f١٧٩٥٥f);
        canvas.drawRect(this.f١٧٩٥٨i, this.f١٧٩٥٣d);
        this.f١٧٩٥٥f.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        this.f١٧٩٥٠a.set((Path) aVar.h());
        this.f١٧٩٥٠a.transform(matrix);
        canvas.drawPath(this.f١٧٩٥٠a, this.f١٧٩٥٥f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.e.b("Layer#saveLayer");
        l.n(canvas, this.f١٧٩٥٨i, this.f١٧٩٥٤e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        com.airbnb.lottie.e.c("Layer#saveLayer");
        for (int i10 = 0; i10 < this.f١٧٩٦٧r.b().size(); i10++) {
            s3.i iVar = (s3.i) this.f١٧٩٦٧r.b().get(i10);
            o3.a aVar = (o3.a) this.f١٧٩٦٧r.a().get(i10);
            o3.a aVar2 = (o3.a) this.f١٧٩٦٧r.c().get(i10);
            int i11 = a.f١٧٩٧٧b[iVar.a().ordinal()];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 == 4) {
                            if (iVar.d()) {
                                l(canvas, matrix, aVar, aVar2);
                            } else {
                                j(canvas, matrix, aVar, aVar2);
                            }
                        }
                    } else if (iVar.d()) {
                        m(canvas, matrix, aVar, aVar2);
                    } else {
                        k(canvas, matrix, aVar, aVar2);
                    }
                } else {
                    if (i10 == 0) {
                        this.f١٧٩٥٣d.setColor(-16777216);
                        this.f١٧٩٥٣d.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                        canvas.drawRect(this.f١٧٩٥٨i, this.f١٧٩٥٣d);
                    }
                    if (iVar.d()) {
                        n(canvas, matrix, aVar, aVar2);
                    } else {
                        p(canvas, matrix, aVar);
                    }
                }
            } else if (q()) {
                this.f١٧٩٥٣d.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                canvas.drawRect(this.f١٧٩٥٨i, this.f١٧٩٥٣d);
            }
        }
        com.airbnb.lottie.e.b("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.e.c("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, o3.a aVar) {
        this.f١٧٩٥٠a.set((Path) aVar.h());
        this.f١٧٩٥٠a.transform(matrix);
        canvas.drawPath(this.f١٧٩٥٠a, this.f١٧٩٥٥f);
    }

    private boolean q() {
        if (this.f١٧٩٦٧r.a().isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f١٧٩٦٧r.b().size(); i10++) {
            if (((s3.i) this.f١٧٩٦٧r.b().get(i10)).a() != i.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.f١٧٩٧١v != null) {
            return;
        }
        if (this.f١٧٩٧٠u == null) {
            this.f١٧٩٧١v = Collections.emptyList();
            return;
        }
        this.f١٧٩٧١v = new ArrayList();
        for (b bVar = this.f١٧٩٧٠u; bVar != null; bVar = bVar.f١٧٩٧٠u) {
            this.f١٧٩٧١v.add(bVar);
        }
    }

    private void s(Canvas canvas) {
        com.airbnb.lottie.e.b("Layer#clearLayer");
        RectF rectF = this.f١٧٩٥٨i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f١٧٩٥٧h);
        com.airbnb.lottie.e.c("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b u(c cVar, e eVar, j0 j0Var, j jVar) {
        switch (a.f١٧٩٧٦a[eVar.g().ordinal()]) {
            case 1:
                return new g(j0Var, eVar, cVar, jVar);
            case 2:
                return new c(j0Var, eVar, jVar.o(eVar.n()), jVar);
            case 3:
                return new h(j0Var, eVar);
            case 4:
                return new d(j0Var, eVar);
            case 5:
                return new f(j0Var, eVar);
            case 6:
                return new i(j0Var, eVar);
            default:
                x3.f.c("Unknown layer type " + eVar.g());
                return null;
        }
    }

    boolean A() {
        o3.h hVar = this.f١٧٩٦٧r;
        if (hVar != null && !hVar.a().isEmpty()) {
            return true;
        }
        return false;
    }

    boolean B() {
        if (this.f١٧٩٦٩t != null) {
            return true;
        }
        return false;
    }

    public void H(o3.a aVar) {
        this.f١٧٩٧٢w.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(b bVar) {
        this.f١٧٩٦٩t = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(boolean z10) {
        if (z10 && this.A == null) {
            this.A = new m3.a();
        }
        this.f١٧٩٧٥z = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(b bVar) {
        this.f١٧٩٧٠u = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(float f10) {
        com.airbnb.lottie.e.b("BaseLayer#setProgress");
        com.airbnb.lottie.e.b("BaseLayer#setProgress.transform");
        this.f١٧٩٧٣x.j(f10);
        com.airbnb.lottie.e.c("BaseLayer#setProgress.transform");
        if (this.f١٧٩٦٧r != null) {
            com.airbnb.lottie.e.b("BaseLayer#setProgress.mask");
            for (int i10 = 0; i10 < this.f١٧٩٦٧r.a().size(); i10++) {
                ((o3.a) this.f١٧٩٦٧r.a().get(i10)).n(f10);
            }
            com.airbnb.lottie.e.c("BaseLayer#setProgress.mask");
        }
        if (this.f١٧٩٦٨s != null) {
            com.airbnb.lottie.e.b("BaseLayer#setProgress.inout");
            this.f١٧٩٦٨s.n(f10);
            com.airbnb.lottie.e.c("BaseLayer#setProgress.inout");
        }
        if (this.f١٧٩٦٩t != null) {
            com.airbnb.lottie.e.b("BaseLayer#setProgress.matte");
            this.f١٧٩٦٩t.M(f10);
            com.airbnb.lottie.e.c("BaseLayer#setProgress.matte");
        }
        com.airbnb.lottie.e.b("BaseLayer#setProgress.animations." + this.f١٧٩٧٢w.size());
        for (int i11 = 0; i11 < this.f١٧٩٧٢w.size(); i11++) {
            ((o3.a) this.f١٧٩٧٢w.get(i11)).n(f10);
        }
        com.airbnb.lottie.e.c("BaseLayer#setProgress.animations." + this.f١٧٩٧٢w.size());
        com.airbnb.lottie.e.c("BaseLayer#setProgress");
    }

    @Override // o3.a.b
    public void a() {
        E();
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        this.f١٧٩٧٣x.c(obj, cVar);
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        b bVar = this.f١٧٩٦٩t;
        if (bVar != null) {
            q3.e a10 = eVar2.a(bVar.getName());
            if (eVar.c(this.f١٧٩٦٩t.getName(), i10)) {
                list.add(a10.i(this.f١٧٩٦٩t));
            }
            if (eVar.h(getName(), i10)) {
                this.f١٧٩٦٩t.I(eVar, eVar.e(this.f١٧٩٦٩t.getName(), i10) + i10, list, a10);
            }
        }
        if (!eVar.g(getName(), i10)) {
            return;
        }
        if (!"__container".equals(getName())) {
            eVar2 = eVar2.a(getName());
            if (eVar.c(getName(), i10)) {
                list.add(eVar2.i(this));
            }
        }
        if (eVar.h(getName(), i10)) {
            I(eVar, i10 + eVar.e(getName(), i10), list, eVar2);
        }
    }

    @Override // n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f١٧٩٥٨i.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        r();
        this.f١٧٩٦٤o.set(matrix);
        if (z10) {
            List list = this.f١٧٩٧١v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f١٧٩٦٤o.preConcat(((b) this.f١٧٩٧١v.get(size)).f١٧٩٧٣x.f());
                }
            } else {
                b bVar = this.f١٧٩٧٠u;
                if (bVar != null) {
                    this.f١٧٩٦٤o.preConcat(bVar.f١٧٩٧٣x.f());
                }
            }
        }
        this.f١٧٩٦٤o.preConcat(this.f١٧٩٧٣x.f());
    }

    @Override // n3.c
    public String getName() {
        return this.f١٧٩٦٦q.j();
    }

    @Override // n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        int i11;
        Paint paint;
        Integer num;
        com.airbnb.lottie.e.b(this.f١٧٩٦٣n);
        if (this.f١٧٩٧٤y && !this.f١٧٩٦٦q.y()) {
            r();
            com.airbnb.lottie.e.b("Layer#parentMatrix");
            this.f١٧٩٥١b.reset();
            this.f١٧٩٥١b.set(matrix);
            for (int size = this.f١٧٩٧١v.size() - 1; size >= 0; size--) {
                this.f١٧٩٥١b.preConcat(((b) this.f١٧٩٧١v.get(size)).f١٧٩٧٣x.f());
            }
            com.airbnb.lottie.e.c("Layer#parentMatrix");
            o3.a h10 = this.f١٧٩٧٣x.h();
            if (h10 != null && (num = (Integer) h10.h()) != null) {
                i11 = num.intValue();
            } else {
                i11 = 100;
            }
            int i12 = (int) ((((i10 / 255.0f) * i11) / 100.0f) * 255.0f);
            if (!B() && !A()) {
                this.f١٧٩٥١b.preConcat(this.f١٧٩٧٣x.f());
                com.airbnb.lottie.e.b("Layer#drawLayer");
                t(canvas, this.f١٧٩٥١b, i12);
                com.airbnb.lottie.e.c("Layer#drawLayer");
                G(com.airbnb.lottie.e.c(this.f١٧٩٦٣n));
                return;
            }
            com.airbnb.lottie.e.b("Layer#computeBounds");
            f(this.f١٧٩٥٨i, this.f١٧٩٥١b, false);
            D(this.f١٧٩٥٨i, matrix);
            this.f١٧٩٥١b.preConcat(this.f١٧٩٧٣x.f());
            C(this.f١٧٩٥٨i, this.f١٧٩٥١b);
            this.f١٧٩٥٩j.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.f١٧٩٥٢c);
            if (!this.f١٧٩٥٢c.isIdentity()) {
                Matrix matrix2 = this.f١٧٩٥٢c;
                matrix2.invert(matrix2);
                this.f١٧٩٥٢c.mapRect(this.f١٧٩٥٩j);
            }
            if (!this.f١٧٩٥٨i.intersect(this.f١٧٩٥٩j)) {
                this.f١٧٩٥٨i.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
            }
            com.airbnb.lottie.e.c("Layer#computeBounds");
            if (this.f١٧٩٥٨i.width() >= 1.0f && this.f١٧٩٥٨i.height() >= 1.0f) {
                com.airbnb.lottie.e.b("Layer#saveLayer");
                this.f١٧٩٥٣d.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                l.m(canvas, this.f١٧٩٥٨i, this.f١٧٩٥٣d);
                com.airbnb.lottie.e.c("Layer#saveLayer");
                s(canvas);
                com.airbnb.lottie.e.b("Layer#drawLayer");
                t(canvas, this.f١٧٩٥١b, i12);
                com.airbnb.lottie.e.c("Layer#drawLayer");
                if (A()) {
                    o(canvas, this.f١٧٩٥١b);
                }
                if (B()) {
                    com.airbnb.lottie.e.b("Layer#drawMatte");
                    com.airbnb.lottie.e.b("Layer#saveLayer");
                    l.n(canvas, this.f١٧٩٥٨i, this.f١٧٩٥٦g, 19);
                    com.airbnb.lottie.e.c("Layer#saveLayer");
                    s(canvas);
                    this.f١٧٩٦٩t.h(canvas, matrix, i12);
                    com.airbnb.lottie.e.b("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.e.c("Layer#restoreLayer");
                    com.airbnb.lottie.e.c("Layer#drawMatte");
                }
                com.airbnb.lottie.e.b("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.e.c("Layer#restoreLayer");
            }
            if (this.f١٧٩٧٥z && (paint = this.A) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.A.setColor(-251901);
                this.A.setStrokeWidth(4.0f);
                canvas.drawRect(this.f١٧٩٥٨i, this.A);
                this.A.setStyle(Paint.Style.FILL);
                this.A.setColor(1357638635);
                canvas.drawRect(this.f١٧٩٥٨i, this.A);
            }
            G(com.airbnb.lottie.e.c(this.f١٧٩٦٣n));
            return;
        }
        com.airbnb.lottie.e.c(this.f١٧٩٦٣n);
    }

    public void i(o3.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f١٧٩٧٢w.add(aVar);
    }

    abstract void t(Canvas canvas, Matrix matrix, int i10);

    public s3.h v() {
        return this.f١٧٩٦٦q.a();
    }

    public s3.a w() {
        return this.f١٧٩٦٦q.b();
    }

    public BlurMaskFilter x(float f10) {
        if (this.f١٧٩٤٩B == f10) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f10 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.f١٧٩٤٩B = f10;
        return blurMaskFilter;
    }

    public v3.j y() {
        return this.f١٧٩٦٦q.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e z() {
        return this.f١٧٩٦٦q;
    }

    @Override // n3.c
    public void b(List list, List list2) {
    }

    void I(q3.e eVar, int i10, List list, q3.e eVar2) {
    }
}
