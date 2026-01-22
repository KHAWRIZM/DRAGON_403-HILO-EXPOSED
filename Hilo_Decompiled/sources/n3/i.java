package n3;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i extends a {
    private final o3.a A;

    /* renamed from: B, reason: collision with root package name */
    private o3.q f١٦٢٣٥B;

    /* renamed from: r, reason: collision with root package name */
    private final String f١٦٢٣٦r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f١٦٢٣٧s;

    /* renamed from: t, reason: collision with root package name */
    private final LongSparseArray f١٦٢٣٨t;

    /* renamed from: u, reason: collision with root package name */
    private final LongSparseArray f١٦٢٣٩u;

    /* renamed from: v, reason: collision with root package name */
    private final RectF f١٦٢٤٠v;

    /* renamed from: w, reason: collision with root package name */
    private final s3.g f١٦٢٤١w;

    /* renamed from: x, reason: collision with root package name */
    private final int f١٦٢٤٢x;

    /* renamed from: y, reason: collision with root package name */
    private final o3.a f١٦٢٤٣y;

    /* renamed from: z, reason: collision with root package name */
    private final o3.a f١٦٢٤٤z;

    public i(j0 j0Var, t3.b bVar, s3.f fVar) {
        super(j0Var, bVar, fVar.b().c(), fVar.g().c(), fVar.i(), fVar.k(), fVar.m(), fVar.h(), fVar.c());
        this.f١٦٢٣٨t = new LongSparseArray();
        this.f١٦٢٣٩u = new LongSparseArray();
        this.f١٦٢٤٠v = new RectF();
        this.f١٦٢٣٦r = fVar.j();
        this.f١٦٢٤١w = fVar.f();
        this.f١٦٢٣٧s = fVar.n();
        this.f١٦٢٤٢x = (int) (j0Var.J().d() / 32.0f);
        o3.a a10 = fVar.e().a();
        this.f١٦٢٤٣y = a10;
        a10.a(this);
        bVar.i(a10);
        o3.a a11 = fVar.l().a();
        this.f١٦٢٤٤z = a11;
        a11.a(this);
        bVar.i(a11);
        o3.a a12 = fVar.d().a();
        this.A = a12;
        a12.a(this);
        bVar.i(a12);
    }

    private int[] j(int[] iArr) {
        o3.q qVar = this.f١٦٢٣٥B;
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

    private int k() {
        int i10;
        int round = Math.round(this.f١٦٢٤٤z.f() * this.f١٦٢٤٢x);
        int round2 = Math.round(this.A.f() * this.f١٦٢٤٢x);
        int round3 = Math.round(this.f١٦٢٤٣y.f() * this.f١٦٢٤٢x);
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

    private LinearGradient l() {
        long k10 = k();
        LinearGradient linearGradient = (LinearGradient) this.f١٦٢٣٨t.get(k10);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f١٦٢٤٤z.h();
        PointF pointF2 = (PointF) this.A.h();
        s3.d dVar = (s3.d) this.f١٦٢٤٣y.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, j(dVar.d()), dVar.e(), Shader.TileMode.CLAMP);
        this.f١٦٢٣٨t.put(k10, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient m() {
        long k10 = k();
        RadialGradient radialGradient = (RadialGradient) this.f١٦٢٣٩u.get(k10);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f١٦٢٤٤z.h();
        PointF pointF2 = (PointF) this.A.h();
        s3.d dVar = (s3.d) this.f١٦٢٤٣y.h();
        int[] j10 = j(dVar.d());
        float[] e10 = dVar.e();
        RadialGradient radialGradient2 = new RadialGradient(pointF.x, pointF.y, (float) Math.hypot(pointF2.x - r7, pointF2.y - r8), j10, e10, Shader.TileMode.CLAMP);
        this.f١٦٢٣٩u.put(k10, radialGradient2);
        return radialGradient2;
    }

    @Override // n3.a, q3.f
    public void c(Object obj, y3.c cVar) {
        super.c(obj, cVar);
        if (obj == n0.L) {
            o3.q qVar = this.f١٦٢٣٥B;
            if (qVar != null) {
                this.f١٦١٦٧f.H(qVar);
            }
            if (cVar == null) {
                this.f١٦٢٣٥B = null;
                return;
            }
            o3.q qVar2 = new o3.q(cVar);
            this.f١٦٢٣٥B = qVar2;
            qVar2.a(this);
            this.f١٦١٦٧f.i(this.f١٦٢٣٥B);
        }
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٢٣٦r;
    }

    @Override // n3.a, n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        Shader m10;
        if (this.f١٦٢٣٧s) {
            return;
        }
        f(this.f١٦٢٤٠v, matrix, false);
        if (this.f١٦٢٤١w == s3.g.LINEAR) {
            m10 = l();
        } else {
            m10 = m();
        }
        m10.setLocalMatrix(matrix);
        this.f١٦١٧٠i.setShader(m10);
        super.h(canvas, matrix, i10);
    }
}
