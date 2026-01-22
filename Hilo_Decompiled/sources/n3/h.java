package n3;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h implements e, a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٦٢١٤a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٦٢١٥b;

    /* renamed from: c, reason: collision with root package name */
    private final t3.b f١٦٢١٦c;

    /* renamed from: d, reason: collision with root package name */
    private final LongSparseArray f١٦٢١٧d = new LongSparseArray();

    /* renamed from: e, reason: collision with root package name */
    private final LongSparseArray f١٦٢١٨e = new LongSparseArray();

    /* renamed from: f, reason: collision with root package name */
    private final Path f١٦٢١٩f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f١٦٢٢٠g;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f١٦٢٢١h;

    /* renamed from: i, reason: collision with root package name */
    private final List f١٦٢٢٢i;

    /* renamed from: j, reason: collision with root package name */
    private final s3.g f١٦٢٢٣j;

    /* renamed from: k, reason: collision with root package name */
    private final o3.a f١٦٢٢٤k;

    /* renamed from: l, reason: collision with root package name */
    private final o3.a f١٦٢٢٥l;

    /* renamed from: m, reason: collision with root package name */
    private final o3.a f١٦٢٢٦m;

    /* renamed from: n, reason: collision with root package name */
    private final o3.a f١٦٢٢٧n;

    /* renamed from: o, reason: collision with root package name */
    private o3.a f١٦٢٢٨o;

    /* renamed from: p, reason: collision with root package name */
    private o3.q f١٦٢٢٩p;

    /* renamed from: q, reason: collision with root package name */
    private final j0 f١٦٢٣٠q;

    /* renamed from: r, reason: collision with root package name */
    private final int f١٦٢٣١r;

    /* renamed from: s, reason: collision with root package name */
    private o3.a f١٦٢٣٢s;

    /* renamed from: t, reason: collision with root package name */
    float f١٦٢٣٣t;

    /* renamed from: u, reason: collision with root package name */
    private o3.c f١٦٢٣٤u;

    public h(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar, s3.e eVar) {
        Path path = new Path();
        this.f١٦٢١٩f = path;
        this.f١٦٢٢٠g = new m3.a(1);
        this.f١٦٢٢١h = new RectF();
        this.f١٦٢٢٢i = new ArrayList();
        this.f١٦٢٣٣t = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٢١٦c = bVar;
        this.f١٦٢١٤a = eVar.f();
        this.f١٦٢١٥b = eVar.i();
        this.f١٦٢٣٠q = j0Var;
        this.f١٦٢٢٣j = eVar.e();
        path.setFillType(eVar.c());
        this.f١٦٢٣١r = (int) (jVar.d() / 32.0f);
        o3.a a10 = eVar.d().a();
        this.f١٦٢٢٤k = a10;
        a10.a(this);
        bVar.i(a10);
        o3.a a11 = eVar.g().a();
        this.f١٦٢٢٥l = a11;
        a11.a(this);
        bVar.i(a11);
        o3.a a12 = eVar.h().a();
        this.f١٦٢٢٦m = a12;
        a12.a(this);
        bVar.i(a12);
        o3.a a13 = eVar.b().a();
        this.f١٦٢٢٧n = a13;
        a13.a(this);
        bVar.i(a13);
        if (bVar.w() != null) {
            o3.a a14 = bVar.w().a().a();
            this.f١٦٢٣٢s = a14;
            a14.a(this);
            bVar.i(this.f١٦٢٣٢s);
        }
        if (bVar.y() != null) {
            this.f١٦٢٣٤u = new o3.c(this, bVar, bVar.y());
        }
    }

    private int[] g(int[] iArr) {
        o3.q qVar = this.f١٦٢٢٩p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    private int i() {
        int i10;
        int round = Math.round(this.f١٦٢٢٦m.f() * this.f١٦٢٣١r);
        int round2 = Math.round(this.f١٦٢٢٧n.f() * this.f١٦٢٣١r);
        int round3 = Math.round(this.f١٦٢٢٤k.f() * this.f١٦٢٣١r);
        if (round != 0) {
            i10 = 527 * round;
        } else {
            i10 = 17;
        }
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        if (round3 != 0) {
            return i10 * 31 * round3;
        }
        return i10;
    }

    private LinearGradient j() {
        long i10 = i();
        LinearGradient linearGradient = (LinearGradient) this.f١٦٢١٧d.get(i10);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f١٦٢٢٦m.h();
        PointF pointF2 = (PointF) this.f١٦٢٢٧n.h();
        s3.d dVar = (s3.d) this.f١٦٢٢٤k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, g(dVar.d()), dVar.e(), Shader.TileMode.CLAMP);
        this.f١٦٢١٧d.put(i10, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient k() {
        float f10;
        long i10 = i();
        RadialGradient radialGradient = (RadialGradient) this.f١٦٢١٨e.get(i10);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f١٦٢٢٦m.h();
        PointF pointF2 = (PointF) this.f١٦٢٢٧n.h();
        s3.d dVar = (s3.d) this.f١٦٢٢٤k.h();
        int[] g10 = g(dVar.d());
        float[] e10 = dVar.e();
        float f11 = pointF.x;
        float f12 = pointF.y;
        float hypot = (float) Math.hypot(pointF2.x - f11, pointF2.y - f12);
        if (hypot <= DownloadProgress.UNKNOWN_PROGRESS) {
            f10 = 0.001f;
        } else {
            f10 = hypot;
        }
        RadialGradient radialGradient2 = new RadialGradient(f11, f12, f10, g10, e10, Shader.TileMode.CLAMP);
        this.f١٦٢١٨e.put(i10, radialGradient2);
        return radialGradient2;
    }

    @Override // o3.a.b
    public void a() {
        this.f١٦٢٣٠q.invalidateSelf();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = (c) list2.get(i10);
            if (cVar instanceof m) {
                this.f١٦٢٢٢i.add((m) cVar);
            }
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
            this.f١٦٢٢٥l.o(cVar);
            return;
        }
        if (obj == n0.K) {
            o3.a aVar = this.f١٦٢٢٨o;
            if (aVar != null) {
                this.f١٦٢١٦c.H(aVar);
            }
            if (cVar == null) {
                this.f١٦٢٢٨o = null;
                return;
            }
            o3.q qVar = new o3.q(cVar);
            this.f١٦٢٢٨o = qVar;
            qVar.a(this);
            this.f١٦٢١٦c.i(this.f١٦٢٢٨o);
            return;
        }
        if (obj == n0.L) {
            o3.q qVar2 = this.f١٦٢٢٩p;
            if (qVar2 != null) {
                this.f١٦٢١٦c.H(qVar2);
            }
            if (cVar == null) {
                this.f١٦٢٢٩p = null;
                return;
            }
            this.f١٦٢١٧d.clear();
            this.f١٦٢١٨e.clear();
            o3.q qVar3 = new o3.q(cVar);
            this.f١٦٢٢٩p = qVar3;
            qVar3.a(this);
            this.f١٦٢١٦c.i(this.f١٦٢٢٩p);
            return;
        }
        if (obj == n0.f٦٢٥٤j) {
            o3.a aVar2 = this.f١٦٢٣٢s;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            o3.q qVar4 = new o3.q(cVar);
            this.f١٦٢٣٢s = qVar4;
            qVar4.a(this);
            this.f١٦٢١٦c.i(this.f١٦٢٣٢s);
            return;
        }
        if (obj == n0.f٦٢٤٩e && (cVar6 = this.f١٦٢٣٤u) != null) {
            cVar6.c(cVar);
            return;
        }
        if (obj == n0.G && (cVar5 = this.f١٦٢٣٤u) != null) {
            cVar5.f(cVar);
            return;
        }
        if (obj == n0.H && (cVar4 = this.f١٦٢٣٤u) != null) {
            cVar4.d(cVar);
            return;
        }
        if (obj == n0.I && (cVar3 = this.f١٦٢٣٤u) != null) {
            cVar3.e(cVar);
        } else if (obj == n0.J && (cVar2 = this.f١٦٢٣٤u) != null) {
            cVar2.g(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
    }

    @Override // n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f١٦٢١٩f.reset();
        for (int i10 = 0; i10 < this.f١٦٢٢٢i.size(); i10++) {
            this.f١٦٢١٩f.addPath(((m) this.f١٦٢٢٢i.get(i10)).getPath(), matrix);
        }
        this.f١٦٢١٩f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٢١٤a;
    }

    @Override // n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        Shader k10;
        if (this.f١٦٢١٥b) {
            return;
        }
        com.airbnb.lottie.e.b("GradientFillContent#draw");
        this.f١٦٢١٩f.reset();
        for (int i11 = 0; i11 < this.f١٦٢٢٢i.size(); i11++) {
            this.f١٦٢١٩f.addPath(((m) this.f١٦٢٢٢i.get(i11)).getPath(), matrix);
        }
        this.f١٦٢١٩f.computeBounds(this.f١٦٢٢١h, false);
        if (this.f١٦٢٢٣j == s3.g.LINEAR) {
            k10 = j();
        } else {
            k10 = k();
        }
        k10.setLocalMatrix(matrix);
        this.f١٦٢٢٠g.setShader(k10);
        o3.a aVar = this.f١٦٢٢٨o;
        if (aVar != null) {
            this.f١٦٢٢٠g.setColorFilter((ColorFilter) aVar.h());
        }
        o3.a aVar2 = this.f١٦٢٣٢s;
        if (aVar2 != null) {
            float floatValue = ((Float) aVar2.h()).floatValue();
            if (floatValue == DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٦٢٢٠g.setMaskFilter(null);
            } else if (floatValue != this.f١٦٢٣٣t) {
                this.f١٦٢٢٠g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f١٦٢٣٣t = floatValue;
        }
        o3.c cVar = this.f١٦٢٣٤u;
        if (cVar != null) {
            cVar.b(this.f١٦٢٢٠g);
        }
        this.f١٦٢٢٠g.setAlpha(x3.k.c((int) ((((i10 / 255.0f) * ((Integer) this.f١٦٢٢٥l.h()).intValue()) / 100.0f) * 255.0f), 0, KotlinVersion.MAX_COMPONENT_VALUE));
        canvas.drawPath(this.f١٦٢١٩f, this.f١٦٢٢٠g);
        com.airbnb.lottie.e.c("GradientFillContent#draw");
    }
}
