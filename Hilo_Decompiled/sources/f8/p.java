package f8;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final q[] f١٤٢٠٣a = new q[4];

    /* renamed from: b, reason: collision with root package name */
    private final Matrix[] f١٤٢٠٤b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix[] f١٤٢٠٥c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    private final PointF f١٤٢٠٦d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final Path f١٤٢٠٧e = new Path();

    /* renamed from: f, reason: collision with root package name */
    private final Path f١٤٢٠٨f = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final q f١٤٢٠٩g = new q();

    /* renamed from: h, reason: collision with root package name */
    private final float[] f١٤٢١٠h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private final float[] f١٤٢١١i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private final Path f١٤٢١٢j = new Path();

    /* renamed from: k, reason: collision with root package name */
    private final Path f١٤٢١٣k = new Path();

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٤٢١٤l = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final p f١٤٢١٥a = new p();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a(q qVar, Matrix matrix, int i10);

        void b(q qVar, Matrix matrix, int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final o f١٤٢١٦a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f١٤٢١٧b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f١٤٢١٨c;

        /* renamed from: d, reason: collision with root package name */
        public final b f١٤٢١٩d;

        /* renamed from: e, reason: collision with root package name */
        public final float f١٤٢٢٠e;

        c(o oVar, float f10, RectF rectF, b bVar, Path path) {
            this.f١٤٢١٩d = bVar;
            this.f١٤٢١٦a = oVar;
            this.f١٤٢٢٠e = f10;
            this.f١٤٢١٨c = rectF;
            this.f١٤٢١٧b = path;
        }
    }

    public p() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f١٤٢٠٣a[i10] = new q();
            this.f١٤٢٠٤b[i10] = new Matrix();
            this.f١٤٢٠٥c[i10] = new Matrix();
        }
    }

    private float a(int i10) {
        return ((i10 + 1) % 4) * 90;
    }

    private void b(c cVar, int i10) {
        this.f١٤٢١٠h[0] = this.f١٤٢٠٣a[i10].k();
        this.f١٤٢١٠h[1] = this.f١٤٢٠٣a[i10].l();
        this.f١٤٢٠٤b[i10].mapPoints(this.f١٤٢١٠h);
        if (i10 == 0) {
            Path path = cVar.f١٤٢١٧b;
            float[] fArr = this.f١٤٢١٠h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f١٤٢١٧b;
            float[] fArr2 = this.f١٤٢١٠h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f١٤٢٠٣a[i10].d(this.f١٤٢٠٤b[i10], cVar.f١٤٢١٧b);
        b bVar = cVar.f١٤٢١٩d;
        if (bVar != null) {
            bVar.a(this.f١٤٢٠٣a[i10], this.f١٤٢٠٤b[i10], i10);
        }
    }

    private void c(c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f١٤٢١٠h[0] = this.f١٤٢٠٣a[i10].i();
        this.f١٤٢١٠h[1] = this.f١٤٢٠٣a[i10].j();
        this.f١٤٢٠٤b[i10].mapPoints(this.f١٤٢١٠h);
        this.f١٤٢١١i[0] = this.f١٤٢٠٣a[i11].k();
        this.f١٤٢١١i[1] = this.f١٤٢٠٣a[i11].l();
        this.f١٤٢٠٤b[i11].mapPoints(this.f١٤٢١١i);
        float f10 = this.f١٤٢١٠h[0];
        float[] fArr = this.f١٤٢١١i;
        float max = Math.max(((float) Math.hypot(f10 - fArr[0], r1[1] - fArr[1])) - 0.001f, DownloadProgress.UNKNOWN_PROGRESS);
        float j10 = j(cVar.f١٤٢١٨c, i10);
        this.f١٤٢٠٩g.n(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        g k10 = k(i10, cVar.f١٤٢١٦a);
        k10.b(max, j10, cVar.f١٤٢٢٠e, this.f١٤٢٠٩g);
        this.f١٤٢١٢j.reset();
        this.f١٤٢٠٩g.d(this.f١٤٢٠٥c[i10], this.f١٤٢١٢j);
        if (this.f١٤٢١٤l && (k10.a() || m(this.f١٤٢١٢j, i10) || m(this.f١٤٢١٢j, i11))) {
            Path path = this.f١٤٢١٢j;
            path.op(path, this.f١٤٢٠٨f, Path.Op.DIFFERENCE);
            this.f١٤٢١٠h[0] = this.f١٤٢٠٩g.k();
            this.f١٤٢١٠h[1] = this.f١٤٢٠٩g.l();
            this.f١٤٢٠٥c[i10].mapPoints(this.f١٤٢١٠h);
            Path path2 = this.f١٤٢٠٧e;
            float[] fArr2 = this.f١٤٢١٠h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f١٤٢٠٩g.d(this.f١٤٢٠٥c[i10], this.f١٤٢٠٧e);
        } else {
            this.f١٤٢٠٩g.d(this.f١٤٢٠٥c[i10], cVar.f١٤٢١٧b);
        }
        b bVar = cVar.f١٤٢١٩d;
        if (bVar != null) {
            bVar.b(this.f١٤٢٠٩g, this.f١٤٢٠٥c[i10], i10);
        }
    }

    private void g(int i10, RectF rectF, PointF pointF) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    pointF.set(rectF.right, rectF.top);
                    return;
                } else {
                    pointF.set(rectF.left, rectF.top);
                    return;
                }
            }
            pointF.set(rectF.left, rectF.bottom);
            return;
        }
        pointF.set(rectF.right, rectF.bottom);
    }

    private e i(int i10, o oVar) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return oVar.s();
                }
                return oVar.q();
            }
            return oVar.i();
        }
        return oVar.k();
    }

    private float j(RectF rectF, int i10) {
        float[] fArr = this.f١٤٢١٠h;
        q qVar = this.f١٤٢٠٣a[i10];
        fArr[0] = qVar.f١٤٢٢٣c;
        fArr[1] = qVar.f١٤٢٢٤d;
        this.f١٤٢٠٤b[i10].mapPoints(fArr);
        if (i10 != 1 && i10 != 3) {
            return Math.abs(rectF.centerY() - this.f١٤٢١٠h[1]);
        }
        return Math.abs(rectF.centerX() - this.f١٤٢١٠h[0]);
    }

    private g k(int i10, o oVar) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return oVar.o();
                }
                return oVar.p();
            }
            return oVar.n();
        }
        return oVar.h();
    }

    public static p l() {
        return a.f١٤٢١٥a;
    }

    private boolean m(Path path, int i10) {
        this.f١٤٢١٣k.reset();
        this.f١٤٢٠٣a[i10].d(this.f١٤٢٠٤b[i10], this.f١٤٢١٣k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f١٤٢١٣k.computeBounds(rectF, true);
        path.op(this.f١٤٢١٣k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }

    private void n(c cVar, int i10, float[] fArr) {
        d cVar2;
        if (fArr == null) {
            cVar2 = h(i10, cVar.f١٤٢١٦a);
        } else {
            cVar2 = new f8.c(fArr[i10]);
        }
        i(i10, cVar.f١٤٢١٦a).b(this.f١٤٢٠٣a[i10], 90.0f, cVar.f١٤٢٢٠e, cVar.f١٤٢١٨c, cVar2);
        float a10 = a(i10);
        this.f١٤٢٠٤b[i10].reset();
        g(i10, cVar.f١٤٢١٨c, this.f١٤٢٠٦d);
        Matrix matrix = this.f١٤٢٠٤b[i10];
        PointF pointF = this.f١٤٢٠٦d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f١٤٢٠٤b[i10].preRotate(a10);
    }

    private void o(int i10) {
        this.f١٤٢١٠h[0] = this.f١٤٢٠٣a[i10].i();
        this.f١٤٢١٠h[1] = this.f١٤٢٠٣a[i10].j();
        this.f١٤٢٠٤b[i10].mapPoints(this.f١٤٢١٠h);
        float a10 = a(i10);
        this.f١٤٢٠٥c[i10].reset();
        Matrix matrix = this.f١٤٢٠٥c[i10];
        float[] fArr = this.f١٤٢١٠h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f١٤٢٠٥c[i10].preRotate(a10);
    }

    public void d(o oVar, float f10, RectF rectF, Path path) {
        e(oVar, f10, rectF, null, path);
    }

    public void e(o oVar, float f10, RectF rectF, b bVar, Path path) {
        f(oVar, null, f10, rectF, bVar, path);
    }

    public void f(o oVar, float[] fArr, float f10, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f١٤٢٠٧e.rewind();
        this.f١٤٢٠٨f.rewind();
        this.f١٤٢٠٨f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(oVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            n(cVar, i10, fArr);
            o(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f١٤٢٠٧e.close();
        if (!this.f١٤٢٠٧e.isEmpty()) {
            path.op(this.f١٤٢٠٧e, Path.Op.UNION);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d h(int i10, o oVar) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return oVar.t();
                }
                return oVar.r();
            }
            return oVar.j();
        }
        return oVar.l();
    }
}
