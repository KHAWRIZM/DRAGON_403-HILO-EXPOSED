package n3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import o3.a;
import s3.t;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e, reason: collision with root package name */
    private final j0 f١٦١٦٦e;

    /* renamed from: f, reason: collision with root package name */
    protected final t3.b f١٦١٦٧f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f١٦١٦٩h;

    /* renamed from: i, reason: collision with root package name */
    final Paint f١٦١٧٠i;

    /* renamed from: j, reason: collision with root package name */
    private final o3.a f١٦١٧١j;

    /* renamed from: k, reason: collision with root package name */
    private final o3.a f١٦١٧٢k;

    /* renamed from: l, reason: collision with root package name */
    private final List f١٦١٧٣l;

    /* renamed from: m, reason: collision with root package name */
    private final o3.a f١٦١٧٤m;

    /* renamed from: n, reason: collision with root package name */
    private o3.a f١٦١٧٥n;

    /* renamed from: o, reason: collision with root package name */
    private o3.a f١٦١٧٦o;

    /* renamed from: p, reason: collision with root package name */
    float f١٦١٧٧p;

    /* renamed from: q, reason: collision with root package name */
    private o3.c f١٦١٧٨q;

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f١٦١٦٢a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private final Path f١٦١٦٣b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f١٦١٦٤c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f١٦١٦٥d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List f١٦١٦٨g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List f١٦١٧٩a;

        /* renamed from: b, reason: collision with root package name */
        private final u f١٦١٨٠b;

        private b(u uVar) {
            this.f١٦١٧٩a = new ArrayList();
            this.f١٦١٨٠b = uVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j0 j0Var, t3.b bVar, Paint.Cap cap, Paint.Join join, float f10, r3.d dVar, r3.b bVar2, List list, r3.b bVar3) {
        m3.a aVar = new m3.a(1);
        this.f١٦١٧٠i = aVar;
        this.f١٦١٧٧p = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦١٦٦e = j0Var;
        this.f١٦١٦٧f = bVar;
        aVar.setStyle(Paint.Style.STROKE);
        aVar.setStrokeCap(cap);
        aVar.setStrokeJoin(join);
        aVar.setStrokeMiter(f10);
        this.f١٦١٧٢k = dVar.a();
        this.f١٦١٧١j = bVar2.a();
        if (bVar3 == null) {
            this.f١٦١٧٤m = null;
        } else {
            this.f١٦١٧٤m = bVar3.a();
        }
        this.f١٦١٧٣l = new ArrayList(list.size());
        this.f١٦١٦٩h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f١٦١٧٣l.add(((r3.b) list.get(i10)).a());
        }
        bVar.i(this.f١٦١٧٢k);
        bVar.i(this.f١٦١٧١j);
        for (int i11 = 0; i11 < this.f١٦١٧٣l.size(); i11++) {
            bVar.i((o3.a) this.f١٦١٧٣l.get(i11));
        }
        o3.a aVar2 = this.f١٦١٧٤m;
        if (aVar2 != null) {
            bVar.i(aVar2);
        }
        this.f١٦١٧٢k.a(this);
        this.f١٦١٧١j.a(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((o3.a) this.f١٦١٧٣l.get(i12)).a(this);
        }
        o3.a aVar3 = this.f١٦١٧٤m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
        if (bVar.w() != null) {
            o3.a a10 = bVar.w().a().a();
            this.f١٦١٧٦o = a10;
            a10.a(this);
            bVar.i(this.f١٦١٧٦o);
        }
        if (bVar.y() != null) {
            this.f١٦١٧٨q = new o3.c(this, bVar, bVar.y());
        }
    }

    private void g(Matrix matrix) {
        float floatValue;
        com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
        if (this.f١٦١٧٣l.isEmpty()) {
            com.airbnb.lottie.e.c("StrokeContent#applyDashPattern");
            return;
        }
        float g10 = x3.l.g(matrix);
        for (int i10 = 0; i10 < this.f١٦١٧٣l.size(); i10++) {
            this.f١٦١٦٩h[i10] = ((Float) ((o3.a) this.f١٦١٧٣l.get(i10)).h()).floatValue();
            if (i10 % 2 == 0) {
                float[] fArr = this.f١٦١٦٩h;
                if (fArr[i10] < 1.0f) {
                    fArr[i10] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f١٦١٦٩h;
                if (fArr2[i10] < 0.1f) {
                    fArr2[i10] = 0.1f;
                }
            }
            float[] fArr3 = this.f١٦١٦٩h;
            fArr3[i10] = fArr3[i10] * g10;
        }
        o3.a aVar = this.f١٦١٧٤m;
        if (aVar == null) {
            floatValue = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            floatValue = g10 * ((Float) aVar.h()).floatValue();
        }
        this.f١٦١٧٠i.setPathEffect(new DashPathEffect(this.f١٦١٦٩h, floatValue));
        com.airbnb.lottie.e.c("StrokeContent#applyDashPattern");
    }

    private void i(Canvas canvas, b bVar, Matrix matrix) {
        float f10;
        float f11;
        float f12;
        com.airbnb.lottie.e.b("StrokeContent#applyTrimPath");
        if (bVar.f١٦١٨٠b == null) {
            com.airbnb.lottie.e.c("StrokeContent#applyTrimPath");
            return;
        }
        this.f١٦١٦٣b.reset();
        for (int size = bVar.f١٦١٧٩a.size() - 1; size >= 0; size--) {
            this.f١٦١٦٣b.addPath(((m) bVar.f١٦١٧٩a.get(size)).getPath(), matrix);
        }
        float floatValue = ((Float) bVar.f١٦١٨٠b.i().h()).floatValue() / 100.0f;
        float floatValue2 = ((Float) bVar.f١٦١٨٠b.d().h()).floatValue() / 100.0f;
        float floatValue3 = ((Float) bVar.f١٦١٨٠b.g().h()).floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.f١٦١٦٣b, this.f١٦١٧٠i);
            com.airbnb.lottie.e.c("StrokeContent#applyTrimPath");
            return;
        }
        this.f١٦١٦٢a.setPath(this.f١٦١٦٣b, false);
        float length = this.f١٦١٦٢a.getLength();
        while (this.f١٦١٦٢a.nextContour()) {
            length += this.f١٦١٦٢a.getLength();
        }
        float f13 = floatValue3 * length;
        float f14 = (floatValue * length) + f13;
        float min = Math.min((floatValue2 * length) + f13, (f14 + length) - 1.0f);
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int size2 = bVar.f١٦١٧٩a.size() - 1; size2 >= 0; size2--) {
            this.f١٦١٦٤c.set(((m) bVar.f١٦١٧٩a.get(size2)).getPath());
            this.f١٦١٦٤c.transform(matrix);
            this.f١٦١٦٢a.setPath(this.f١٦١٦٤c, false);
            float length2 = this.f١٦١٦٢a.getLength();
            if (min > length) {
                float f16 = min - length;
                if (f16 < f15 + length2 && f15 < f16) {
                    if (f14 > length) {
                        f12 = (f14 - length) / length2;
                    } else {
                        f12 = DownloadProgress.UNKNOWN_PROGRESS;
                    }
                    x3.l.a(this.f١٦١٦٤c, f12, Math.min(f16 / length2, 1.0f), DownloadProgress.UNKNOWN_PROGRESS);
                    canvas.drawPath(this.f١٦١٦٤c, this.f١٦١٧٠i);
                    f15 += length2;
                }
            }
            float f17 = f15 + length2;
            if (f17 >= f14 && f15 <= min) {
                if (f17 <= min && f14 < f15) {
                    canvas.drawPath(this.f١٦١٦٤c, this.f١٦١٧٠i);
                } else {
                    if (f14 < f15) {
                        f10 = DownloadProgress.UNKNOWN_PROGRESS;
                    } else {
                        f10 = (f14 - f15) / length2;
                    }
                    if (min > f17) {
                        f11 = 1.0f;
                    } else {
                        f11 = (min - f15) / length2;
                    }
                    x3.l.a(this.f١٦١٦٤c, f10, f11, DownloadProgress.UNKNOWN_PROGRESS);
                    canvas.drawPath(this.f١٦١٦٤c, this.f١٦١٧٠i);
                }
            }
            f15 += length2;
        }
        com.airbnb.lottie.e.c("StrokeContent#applyTrimPath");
    }

    @Override // o3.a.b
    public void a() {
        this.f١٦١٦٦e.invalidateSelf();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        u uVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof u) {
                u uVar2 = (u) cVar;
                if (uVar2.j() == t.a.INDIVIDUALLY) {
                    uVar = uVar2;
                }
            }
        }
        if (uVar != null) {
            uVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = (c) list2.get(size2);
            if (cVar2 instanceof u) {
                u uVar3 = (u) cVar2;
                if (uVar3.j() == t.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f١٦١٦٨g.add(bVar);
                    }
                    bVar = new b(uVar3);
                    uVar3.c(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(uVar);
                }
                bVar.f١٦١٧٩a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f١٦١٦٨g.add(bVar);
        }
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        o3.c cVar2;
        o3.c cVar3;
        o3.c cVar4;
        o3.c cVar5;
        o3.c cVar6;
        if (obj == n0.f٦٢٤٨d) {
            this.f١٦١٧٢k.o(cVar);
            return;
        }
        if (obj == n0.f٦٢٦٣s) {
            this.f١٦١٧١j.o(cVar);
            return;
        }
        if (obj == n0.K) {
            o3.a aVar = this.f١٦١٧٥n;
            if (aVar != null) {
                this.f١٦١٦٧f.H(aVar);
            }
            if (cVar == null) {
                this.f١٦١٧٥n = null;
                return;
            }
            o3.q qVar = new o3.q(cVar);
            this.f١٦١٧٥n = qVar;
            qVar.a(this);
            this.f١٦١٦٧f.i(this.f١٦١٧٥n);
            return;
        }
        if (obj == n0.f٦٢٥٤j) {
            o3.a aVar2 = this.f١٦١٧٦o;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            o3.q qVar2 = new o3.q(cVar);
            this.f١٦١٧٦o = qVar2;
            qVar2.a(this);
            this.f١٦١٦٧f.i(this.f١٦١٧٦o);
            return;
        }
        if (obj == n0.f٦٢٤٩e && (cVar6 = this.f١٦١٧٨q) != null) {
            cVar6.c(cVar);
            return;
        }
        if (obj == n0.G && (cVar5 = this.f١٦١٧٨q) != null) {
            cVar5.f(cVar);
            return;
        }
        if (obj == n0.H && (cVar4 = this.f١٦١٧٨q) != null) {
            cVar4.d(cVar);
            return;
        }
        if (obj == n0.I && (cVar3 = this.f١٦١٧٨q) != null) {
            cVar3.e(cVar);
        } else if (obj == n0.J && (cVar2 = this.f١٦١٧٨q) != null) {
            cVar2.g(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
    }

    @Override // n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        com.airbnb.lottie.e.b("StrokeContent#getBounds");
        this.f١٦١٦٣b.reset();
        for (int i10 = 0; i10 < this.f١٦١٦٨g.size(); i10++) {
            b bVar = (b) this.f١٦١٦٨g.get(i10);
            for (int i11 = 0; i11 < bVar.f١٦١٧٩a.size(); i11++) {
                this.f١٦١٦٣b.addPath(((m) bVar.f١٦١٧٩a.get(i11)).getPath(), matrix);
            }
        }
        this.f١٦١٦٣b.computeBounds(this.f١٦١٦٥d, false);
        float q10 = ((o3.d) this.f١٦١٧١j).q();
        RectF rectF2 = this.f١٦١٦٥d;
        float f10 = q10 / 2.0f;
        rectF2.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.f١٦١٦٥d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.e.c("StrokeContent#getBounds");
    }

    @Override // n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        com.airbnb.lottie.e.b("StrokeContent#draw");
        if (x3.l.h(matrix)) {
            com.airbnb.lottie.e.c("StrokeContent#draw");
            return;
        }
        this.f١٦١٧٠i.setAlpha(x3.k.c((int) ((((i10 / 255.0f) * ((o3.f) this.f١٦١٧٢k).q()) / 100.0f) * 255.0f), 0, KotlinVersion.MAX_COMPONENT_VALUE));
        this.f١٦١٧٠i.setStrokeWidth(((o3.d) this.f١٦١٧١j).q() * x3.l.g(matrix));
        if (this.f١٦١٧٠i.getStrokeWidth() <= DownloadProgress.UNKNOWN_PROGRESS) {
            com.airbnb.lottie.e.c("StrokeContent#draw");
            return;
        }
        g(matrix);
        o3.a aVar = this.f١٦١٧٥n;
        if (aVar != null) {
            this.f١٦١٧٠i.setColorFilter((ColorFilter) aVar.h());
        }
        o3.a aVar2 = this.f١٦١٧٦o;
        if (aVar2 != null) {
            float floatValue = ((Float) aVar2.h()).floatValue();
            if (floatValue == DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٦١٧٠i.setMaskFilter(null);
            } else if (floatValue != this.f١٦١٧٧p) {
                this.f١٦١٧٠i.setMaskFilter(this.f١٦١٦٧f.x(floatValue));
            }
            this.f١٦١٧٧p = floatValue;
        }
        o3.c cVar = this.f١٦١٧٨q;
        if (cVar != null) {
            cVar.b(this.f١٦١٧٠i);
        }
        for (int i11 = 0; i11 < this.f١٦١٦٨g.size(); i11++) {
            b bVar = (b) this.f١٦١٦٨g.get(i11);
            if (bVar.f١٦١٨٠b != null) {
                i(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.e.b("StrokeContent#buildPath");
                this.f١٦١٦٣b.reset();
                for (int size = bVar.f١٦١٧٩a.size() - 1; size >= 0; size--) {
                    this.f١٦١٦٣b.addPath(((m) bVar.f١٦١٧٩a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.e.c("StrokeContent#buildPath");
                com.airbnb.lottie.e.b("StrokeContent#drawPath");
                canvas.drawPath(this.f١٦١٦٣b, this.f١٦١٧٠i);
                com.airbnb.lottie.e.c("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.e.c("StrokeContent#draw");
    }
}
