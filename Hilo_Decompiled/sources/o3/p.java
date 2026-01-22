package o3;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Collections;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f١٦٥٢٢a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f١٦٥٢٣b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f١٦٥٢٤c;

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f١٦٥٢٥d;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f١٦٥٢٦e;

    /* renamed from: f, reason: collision with root package name */
    private a f١٦٥٢٧f;

    /* renamed from: g, reason: collision with root package name */
    private a f١٦٥٢٨g;

    /* renamed from: h, reason: collision with root package name */
    private a f١٦٥٢٩h;

    /* renamed from: i, reason: collision with root package name */
    private a f١٦٥٣٠i;

    /* renamed from: j, reason: collision with root package name */
    private a f١٦٥٣١j;

    /* renamed from: k, reason: collision with root package name */
    private d f١٦٥٣٢k;

    /* renamed from: l, reason: collision with root package name */
    private d f١٦٥٣٣l;

    /* renamed from: m, reason: collision with root package name */
    private a f١٦٥٣٤m;

    /* renamed from: n, reason: collision with root package name */
    private a f١٦٥٣٥n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f١٦٥٣٦o;

    public p(r3.l lVar) {
        a a10;
        a a11;
        a a12;
        a a13;
        d dVar;
        d dVar2;
        if (lVar.c() == null) {
            a10 = null;
        } else {
            a10 = lVar.c().a();
        }
        this.f١٦٥٢٧f = a10;
        if (lVar.f() == null) {
            a11 = null;
        } else {
            a11 = lVar.f().a();
        }
        this.f١٦٥٢٨g = a11;
        if (lVar.h() == null) {
            a12 = null;
        } else {
            a12 = lVar.h().a();
        }
        this.f١٦٥٢٩h = a12;
        if (lVar.g() == null) {
            a13 = null;
        } else {
            a13 = lVar.g().a();
        }
        this.f١٦٥٣٠i = a13;
        if (lVar.i() == null) {
            dVar = null;
        } else {
            dVar = (d) lVar.i().a();
        }
        this.f١٦٥٣٢k = dVar;
        this.f١٦٥٣٦o = lVar.l();
        if (this.f١٦٥٣٢k != null) {
            this.f١٦٥٢٣b = new Matrix();
            this.f١٦٥٢٤c = new Matrix();
            this.f١٦٥٢٥d = new Matrix();
            this.f١٦٥٢٦e = new float[9];
        } else {
            this.f١٦٥٢٣b = null;
            this.f١٦٥٢٤c = null;
            this.f١٦٥٢٥d = null;
            this.f١٦٥٢٦e = null;
        }
        if (lVar.j() == null) {
            dVar2 = null;
        } else {
            dVar2 = (d) lVar.j().a();
        }
        this.f١٦٥٣٣l = dVar2;
        if (lVar.e() != null) {
            this.f١٦٥٣١j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f١٦٥٣٤m = lVar.k().a();
        } else {
            this.f١٦٥٣٤m = null;
        }
        if (lVar.d() != null) {
            this.f١٦٥٣٥n = lVar.d().a();
        } else {
            this.f١٦٥٣٥n = null;
        }
    }

    private void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f١٦٥٢٦e[i10] = 0.0f;
        }
    }

    public void a(t3.b bVar) {
        bVar.i(this.f١٦٥٣١j);
        bVar.i(this.f١٦٥٣٤m);
        bVar.i(this.f١٦٥٣٥n);
        bVar.i(this.f١٦٥٢٧f);
        bVar.i(this.f١٦٥٢٨g);
        bVar.i(this.f١٦٥٢٩h);
        bVar.i(this.f١٦٥٣٠i);
        bVar.i(this.f١٦٥٣٢k);
        bVar.i(this.f١٦٥٣٣l);
    }

    public void b(a.b bVar) {
        a aVar = this.f١٦٥٣١j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a aVar2 = this.f١٦٥٣٤m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a aVar3 = this.f١٦٥٣٥n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a aVar4 = this.f١٦٥٢٧f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a aVar5 = this.f١٦٥٢٨g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a aVar6 = this.f١٦٥٢٩h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a aVar7 = this.f١٦٥٣٠i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        d dVar = this.f١٦٥٣٢k;
        if (dVar != null) {
            dVar.a(bVar);
        }
        d dVar2 = this.f١٦٥٣٣l;
        if (dVar2 != null) {
            dVar2.a(bVar);
        }
    }

    public boolean c(Object obj, y3.c cVar) {
        if (obj == n0.f٦٢٥٠f) {
            a aVar = this.f١٦٥٢٧f;
            if (aVar == null) {
                this.f١٦٥٢٧f = new q(cVar, new PointF());
                return true;
            }
            aVar.o(cVar);
            return true;
        }
        if (obj == n0.f٦٢٥١g) {
            a aVar2 = this.f١٦٥٢٨g;
            if (aVar2 == null) {
                this.f١٦٥٢٨g = new q(cVar, new PointF());
                return true;
            }
            aVar2.o(cVar);
            return true;
        }
        if (obj == n0.f٦٢٥٢h) {
            a aVar3 = this.f١٦٥٢٨g;
            if (aVar3 instanceof n) {
                ((n) aVar3).s(cVar);
                return true;
            }
        }
        if (obj == n0.f٦٢٥٣i) {
            a aVar4 = this.f١٦٥٢٨g;
            if (aVar4 instanceof n) {
                ((n) aVar4).t(cVar);
                return true;
            }
        }
        if (obj == n0.f٦٢٥٩o) {
            a aVar5 = this.f١٦٥٢٩h;
            if (aVar5 == null) {
                this.f١٦٥٢٩h = new q(cVar, new y3.d());
                return true;
            }
            aVar5.o(cVar);
            return true;
        }
        if (obj == n0.f٦٢٦٠p) {
            a aVar6 = this.f١٦٥٣٠i;
            if (aVar6 == null) {
                this.f١٦٥٣٠i = new q(cVar, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
                return true;
            }
            aVar6.o(cVar);
            return true;
        }
        if (obj == n0.f٦٢٤٧c) {
            a aVar7 = this.f١٦٥٣١j;
            if (aVar7 == null) {
                this.f١٦٥٣١j = new q(cVar, 100);
                return true;
            }
            aVar7.o(cVar);
            return true;
        }
        if (obj == n0.C) {
            a aVar8 = this.f١٦٥٣٤m;
            if (aVar8 == null) {
                this.f١٦٥٣٤m = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar8.o(cVar);
            return true;
        }
        if (obj == n0.D) {
            a aVar9 = this.f١٦٥٣٥n;
            if (aVar9 == null) {
                this.f١٦٥٣٥n = new q(cVar, Float.valueOf(100.0f));
                return true;
            }
            aVar9.o(cVar);
            return true;
        }
        if (obj == n0.f٦٢٦١q) {
            if (this.f١٦٥٣٢k == null) {
                this.f١٦٥٣٢k = new d(Collections.singletonList(new y3.a(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS))));
            }
            this.f١٦٥٣٢k.o(cVar);
            return true;
        }
        if (obj == n0.f٦٢٦٢r) {
            if (this.f١٦٥٣٣l == null) {
                this.f١٦٥٣٣l = new d(Collections.singletonList(new y3.a(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS))));
            }
            this.f١٦٥٣٣l.o(cVar);
            return true;
        }
        return false;
    }

    public a e() {
        return this.f١٦٥٣٥n;
    }

    public Matrix f() {
        float q10;
        PointF pointF;
        y3.d dVar;
        float cos;
        float sin;
        PointF pointF2;
        this.f١٦٥٢٢a.reset();
        a aVar = this.f١٦٥٢٨g;
        if (aVar != null && (pointF2 = (PointF) aVar.h()) != null) {
            float f10 = pointF2.x;
            if (f10 != DownloadProgress.UNKNOWN_PROGRESS || pointF2.y != DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٦٥٢٢a.preTranslate(f10, pointF2.y);
            }
        }
        if (this.f١٦٥٣٦o) {
            if (aVar != null) {
                float f11 = aVar.f();
                PointF pointF3 = (PointF) aVar.h();
                float f12 = pointF3.x;
                float f13 = pointF3.y;
                aVar.n(1.0E-4f + f11);
                PointF pointF4 = (PointF) aVar.h();
                aVar.n(f11);
                this.f١٦٥٢٢a.preRotate((float) Math.toDegrees(Math.atan2(pointF4.y - f13, pointF4.x - f12)));
            }
        } else {
            a aVar2 = this.f١٦٥٣٠i;
            if (aVar2 != null) {
                if (aVar2 instanceof q) {
                    q10 = ((Float) aVar2.h()).floatValue();
                } else {
                    q10 = ((d) aVar2).q();
                }
                if (q10 != DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f١٦٥٢٢a.preRotate(q10);
                }
            }
        }
        if (this.f١٦٥٣٢k != null) {
            if (this.f١٦٥٣٣l == null) {
                cos = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                cos = (float) Math.cos(Math.toRadians((-r3.q()) + 90.0f));
            }
            if (this.f١٦٥٣٣l == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-r5.q()) + 90.0f));
            }
            float tan = (float) Math.tan(Math.toRadians(r0.q()));
            d();
            float[] fArr = this.f١٦٥٢٦e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f14 = -sin;
            fArr[3] = f14;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f١٦٥٢٣b.setValues(fArr);
            d();
            float[] fArr2 = this.f١٦٥٢٦e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f١٦٥٢٤c.setValues(fArr2);
            d();
            float[] fArr3 = this.f١٦٥٢٦e;
            fArr3[0] = cos;
            fArr3[1] = f14;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f١٦٥٢٥d.setValues(fArr3);
            this.f١٦٥٢٤c.preConcat(this.f١٦٥٢٣b);
            this.f١٦٥٢٥d.preConcat(this.f١٦٥٢٤c);
            this.f١٦٥٢٢a.preConcat(this.f١٦٥٢٥d);
        }
        a aVar3 = this.f١٦٥٢٩h;
        if (aVar3 != null && (dVar = (y3.d) aVar3.h()) != null && (dVar.b() != 1.0f || dVar.c() != 1.0f)) {
            this.f١٦٥٢٢a.preScale(dVar.b(), dVar.c());
        }
        a aVar4 = this.f١٦٥٢٧f;
        if (aVar4 != null && (pointF = (PointF) aVar4.h()) != null) {
            float f15 = pointF.x;
            if (f15 != DownloadProgress.UNKNOWN_PROGRESS || pointF.y != DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٦٥٢٢a.preTranslate(-f15, -pointF.y);
            }
        }
        return this.f١٦٥٢٢a;
    }

    public Matrix g(float f10) {
        PointF pointF;
        y3.d dVar;
        float f11;
        a aVar = this.f١٦٥٢٨g;
        PointF pointF2 = null;
        if (aVar == null) {
            pointF = null;
        } else {
            pointF = (PointF) aVar.h();
        }
        a aVar2 = this.f١٦٥٢٩h;
        if (aVar2 == null) {
            dVar = null;
        } else {
            dVar = (y3.d) aVar2.h();
        }
        this.f١٦٥٢٢a.reset();
        if (pointF != null) {
            this.f١٦٥٢٢a.preTranslate(pointF.x * f10, pointF.y * f10);
        }
        if (dVar != null) {
            double d10 = f10;
            this.f١٦٥٢٢a.preScale((float) Math.pow(dVar.b(), d10), (float) Math.pow(dVar.c(), d10));
        }
        a aVar3 = this.f١٦٥٣٠i;
        if (aVar3 != null) {
            float floatValue = ((Float) aVar3.h()).floatValue();
            a aVar4 = this.f١٦٥٢٧f;
            if (aVar4 != null) {
                pointF2 = (PointF) aVar4.h();
            }
            Matrix matrix = this.f١٦٥٢٢a;
            float f12 = floatValue * f10;
            float f13 = DownloadProgress.UNKNOWN_PROGRESS;
            if (pointF2 == null) {
                f11 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                f11 = pointF2.x;
            }
            if (pointF2 != null) {
                f13 = pointF2.y;
            }
            matrix.preRotate(f12, f11, f13);
        }
        return this.f١٦٥٢٢a;
    }

    public a h() {
        return this.f١٦٥٣١j;
    }

    public a i() {
        return this.f١٦٥٣٤m;
    }

    public void j(float f10) {
        a aVar = this.f١٦٥٣١j;
        if (aVar != null) {
            aVar.n(f10);
        }
        a aVar2 = this.f١٦٥٣٤m;
        if (aVar2 != null) {
            aVar2.n(f10);
        }
        a aVar3 = this.f١٦٥٣٥n;
        if (aVar3 != null) {
            aVar3.n(f10);
        }
        a aVar4 = this.f١٦٥٢٧f;
        if (aVar4 != null) {
            aVar4.n(f10);
        }
        a aVar5 = this.f١٦٥٢٨g;
        if (aVar5 != null) {
            aVar5.n(f10);
        }
        a aVar6 = this.f١٦٥٢٩h;
        if (aVar6 != null) {
            aVar6.n(f10);
        }
        a aVar7 = this.f١٦٥٣٠i;
        if (aVar7 != null) {
            aVar7.n(f10);
        }
        d dVar = this.f١٦٥٣٢k;
        if (dVar != null) {
            dVar.n(f10);
        }
        d dVar2 = this.f١٦٥٣٣l;
        if (dVar2 != null) {
            dVar2.n(f10);
        }
    }
}
