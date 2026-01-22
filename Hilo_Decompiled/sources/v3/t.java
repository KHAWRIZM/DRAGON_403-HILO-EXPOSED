package v3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;
import w3.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class t {

    /* renamed from: b, reason: collision with root package name */
    private static SparseArrayCompat f١٨٤٥٣b;

    /* renamed from: a, reason: collision with root package name */
    private static final Interpolator f١٨٤٥٢a = new LinearInterpolator();

    /* renamed from: c, reason: collision with root package name */
    static c.a f١٨٤٥٤c = c.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* renamed from: d, reason: collision with root package name */
    static c.a f١٨٤٥٥d = c.a.a("x", "y");

    private static WeakReference a(int i10) {
        WeakReference weakReference;
        synchronized (t.class) {
            weakReference = (WeakReference) g().get(i10);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        WeakReference a10;
        Interpolator linearInterpolator;
        pointF.x = x3.k.b(pointF.x, -1.0f, 1.0f);
        pointF.y = x3.k.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = x3.k.b(pointF2.x, -1.0f, 1.0f);
        float b10 = x3.k.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b10;
        int i10 = x3.l.i(pointF.x, pointF.y, pointF2.x, b10);
        Interpolator interpolator = null;
        if (com.airbnb.lottie.e.e()) {
            a10 = null;
        } else {
            a10 = a(i10);
        }
        if (a10 != null) {
            interpolator = (Interpolator) a10.get();
        }
        if (a10 == null || interpolator == null) {
            try {
                linearInterpolator = n2.a.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e10) {
                if ("The Path cannot loop back on itself.".equals(e10.getMessage())) {
                    linearInterpolator = n2.a.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, DownloadProgress.UNKNOWN_PROGRESS), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.airbnb.lottie.e.e()) {
                try {
                    h(i10, new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y3.a c(w3.c cVar, com.airbnb.lottie.j jVar, float f10, n0 n0Var, boolean z10, boolean z11) {
        if (z10 && z11) {
            return e(jVar, cVar, f10, n0Var);
        }
        if (z10) {
            return d(jVar, cVar, f10, n0Var);
        }
        return f(cVar, f10, n0Var);
    }

    private static y3.a d(com.airbnb.lottie.j jVar, w3.c cVar, float f10, n0 n0Var) {
        Interpolator interpolator;
        Interpolator interpolator2;
        Object obj;
        cVar.c();
        PointF pointF = null;
        PointF pointF2 = null;
        Object obj2 = null;
        Object obj3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z10 = false;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٥٤c)) {
                case 0:
                    f11 = (float) cVar.m();
                    break;
                case 1:
                    obj3 = n0Var.a(cVar, f10);
                    break;
                case 2:
                    obj2 = n0Var.a(cVar, f10);
                    break;
                case 3:
                    pointF = s.e(cVar, 1.0f);
                    break;
                case 4:
                    pointF2 = s.e(cVar, 1.0f);
                    break;
                case 5:
                    if (cVar.o() == 1) {
                        z10 = true;
                        break;
                    } else {
                        z10 = false;
                        break;
                    }
                case 6:
                    pointF3 = s.e(cVar, f10);
                    break;
                case 7:
                    pointF4 = s.e(cVar, f10);
                    break;
                default:
                    cVar.A();
                    break;
            }
        }
        cVar.h();
        if (z10) {
            interpolator2 = f١٨٤٥٢a;
            obj = obj3;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = b(pointF, pointF2);
            } else {
                interpolator = f١٨٤٥٢a;
            }
            interpolator2 = interpolator;
            obj = obj2;
        }
        y3.a aVar = new y3.a(jVar, obj3, obj, interpolator2, f11, null);
        aVar.f١٩١٣٠o = pointF3;
        aVar.f١٩١٣١p = pointF4;
        return aVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    private static y3.a e(com.airbnb.lottie.j jVar, w3.c cVar, float f10, n0 n0Var) {
        Interpolator interpolator;
        Interpolator b10;
        Interpolator b11;
        Object obj;
        PointF pointF;
        y3.a aVar;
        PointF pointF2;
        float f11;
        PointF pointF3;
        float f12;
        cVar.c();
        PointF pointF4 = null;
        boolean z10 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        Object obj2 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        PointF pointF11 = null;
        Object obj3 = null;
        while (cVar.j()) {
            switch (cVar.x(f١٨٤٥٤c)) {
                case 0:
                    pointF2 = pointF4;
                    f13 = (float) cVar.m();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    obj2 = n0Var.a(cVar, f10);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    obj3 = n0Var.a(cVar, f10);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f11 = f13;
                    PointF pointF12 = pointF11;
                    if (cVar.u() == c.b.BEGIN_OBJECT) {
                        cVar.c();
                        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
                        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
                        float f16 = DownloadProgress.UNKNOWN_PROGRESS;
                        float f17 = DownloadProgress.UNKNOWN_PROGRESS;
                        while (cVar.j()) {
                            int x10 = cVar.x(f١٨٤٥٥d);
                            if (x10 != 0) {
                                if (x10 != 1) {
                                    cVar.A();
                                } else {
                                    c.b u10 = cVar.u();
                                    c.b bVar = c.b.NUMBER;
                                    if (u10 == bVar) {
                                        f17 = (float) cVar.m();
                                        f15 = f17;
                                    } else {
                                        cVar.b();
                                        f15 = (float) cVar.m();
                                        if (cVar.u() == bVar) {
                                            f17 = (float) cVar.m();
                                        } else {
                                            f17 = f15;
                                        }
                                        cVar.g();
                                    }
                                }
                            } else {
                                c.b u11 = cVar.u();
                                c.b bVar2 = c.b.NUMBER;
                                if (u11 == bVar2) {
                                    f16 = (float) cVar.m();
                                    f14 = f16;
                                } else {
                                    cVar.b();
                                    f14 = (float) cVar.m();
                                    if (cVar.u() == bVar2) {
                                        f16 = (float) cVar.m();
                                    } else {
                                        f16 = f14;
                                    }
                                    cVar.g();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f14, f15);
                        PointF pointF14 = new PointF(f16, f17);
                        cVar.h();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f13 = f11;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = s.e(cVar, f10);
                        f13 = f11;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (cVar.u() == c.b.BEGIN_OBJECT) {
                        cVar.c();
                        float f18 = DownloadProgress.UNKNOWN_PROGRESS;
                        float f19 = DownloadProgress.UNKNOWN_PROGRESS;
                        float f20 = DownloadProgress.UNKNOWN_PROGRESS;
                        float f21 = DownloadProgress.UNKNOWN_PROGRESS;
                        while (cVar.j()) {
                            PointF pointF15 = pointF11;
                            int x11 = cVar.x(f١٨٤٥٥d);
                            if (x11 != 0) {
                                pointF3 = pointF4;
                                if (x11 != 1) {
                                    cVar.A();
                                } else {
                                    c.b u12 = cVar.u();
                                    c.b bVar3 = c.b.NUMBER;
                                    if (u12 == bVar3) {
                                        f21 = (float) cVar.m();
                                        f13 = f13;
                                        f19 = f21;
                                    } else {
                                        float f22 = f13;
                                        cVar.b();
                                        float m10 = (float) cVar.m();
                                        if (cVar.u() == bVar3) {
                                            f12 = (float) cVar.m();
                                        } else {
                                            f12 = m10;
                                        }
                                        cVar.g();
                                        f13 = f22;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f21 = f12;
                                        f19 = m10;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f23 = f13;
                                c.b u13 = cVar.u();
                                c.b bVar4 = c.b.NUMBER;
                                if (u13 == bVar4) {
                                    f20 = (float) cVar.m();
                                    f13 = f23;
                                    f18 = f20;
                                } else {
                                    cVar.b();
                                    f18 = (float) cVar.m();
                                    if (cVar.u() == bVar4) {
                                        f20 = (float) cVar.m();
                                    } else {
                                        f20 = f18;
                                    }
                                    cVar.g();
                                    f13 = f23;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f11 = f13;
                        PointF pointF16 = new PointF(f18, f19);
                        PointF pointF17 = new PointF(f20, f21);
                        cVar.h();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f13 = f11;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = s.e(cVar, f10);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (cVar.o() == 1) {
                        z10 = true;
                        break;
                    } else {
                        z10 = false;
                        break;
                    }
                case 6:
                    pointF11 = s.e(cVar, f10);
                    break;
                case 7:
                    pointF4 = s.e(cVar, f10);
                    break;
                default:
                    cVar.A();
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f24 = f13;
        PointF pointF19 = pointF11;
        cVar.h();
        if (z10) {
            interpolator = f١٨٤٥٢a;
            obj = obj2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    b10 = b(pointF7, pointF9);
                    b11 = b(pointF8, pointF10);
                    obj = obj3;
                    interpolator = null;
                    if (b10 == null && b11 != null) {
                        pointF = pointF19;
                        aVar = new y3.a(jVar, obj2, obj, b10, b11, f24, null);
                    } else {
                        pointF = pointF19;
                        aVar = new y3.a(jVar, obj2, obj, interpolator, f24, null);
                    }
                    aVar.f١٩١٣٠o = pointF;
                    aVar.f١٩١٣١p = pointF18;
                    return aVar;
                }
                interpolator = f١٨٤٥٢a;
            }
            obj = obj3;
        }
        b10 = null;
        b11 = null;
        if (b10 == null) {
        }
        pointF = pointF19;
        aVar = new y3.a(jVar, obj2, obj, interpolator, f24, null);
        aVar.f١٩١٣٠o = pointF;
        aVar.f١٩١٣١p = pointF18;
        return aVar;
    }

    private static y3.a f(w3.c cVar, float f10, n0 n0Var) {
        return new y3.a(n0Var.a(cVar, f10));
    }

    private static SparseArrayCompat g() {
        if (f١٨٤٥٣b == null) {
            f١٨٤٥٣b = new SparseArrayCompat();
        }
        return f١٨٤٥٣b;
    }

    private static void h(int i10, WeakReference weakReference) {
        synchronized (t.class) {
            f١٨٤٥٣b.put(i10, weakReference);
        }
    }
}
