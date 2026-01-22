package n3;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;
import o3.a;
import s3.k;
import s3.t;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class n implements m, a.b, k {

    /* renamed from: e, reason: collision with root package name */
    private final String f١٦٢٥٦e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f١٦٢٥٧f;

    /* renamed from: g, reason: collision with root package name */
    private final k.a f١٦٢٥٨g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f١٦٢٥٩h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f١٦٢٦٠i;

    /* renamed from: j, reason: collision with root package name */
    private final o3.a f١٦٢٦١j;

    /* renamed from: k, reason: collision with root package name */
    private final o3.a f١٦٢٦٢k;

    /* renamed from: l, reason: collision with root package name */
    private final o3.a f١٦٢٦٣l;

    /* renamed from: m, reason: collision with root package name */
    private final o3.a f١٦٢٦٤m;

    /* renamed from: n, reason: collision with root package name */
    private final o3.a f١٦٢٦٥n;

    /* renamed from: o, reason: collision with root package name */
    private final o3.a f١٦٢٦٦o;

    /* renamed from: p, reason: collision with root package name */
    private final o3.a f١٦٢٦٧p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١٦٢٦٩r;

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٦٢٥٢a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f١٦٢٥٣b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final PathMeasure f١٦٢٥٤c = new PathMeasure();

    /* renamed from: d, reason: collision with root package name */
    private final float[] f١٦٢٥٥d = new float[2];

    /* renamed from: q, reason: collision with root package name */
    private final b f١٦٢٦٨q = new b();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٢٧٠a;

        static {
            int[] iArr = new int[k.a.values().length];
            f١٦٢٧٠a = iArr;
            try {
                iArr[k.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٦٢٧٠a[k.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(j0 j0Var, t3.b bVar, s3.k kVar) {
        this.f١٦٢٥٧f = j0Var;
        this.f١٦٢٥٦e = kVar.d();
        k.a j10 = kVar.j();
        this.f١٦٢٥٨g = j10;
        this.f١٦٢٥٩h = kVar.k();
        this.f١٦٢٦٠i = kVar.l();
        o3.a a10 = kVar.g().a();
        this.f١٦٢٦١j = a10;
        o3.a a11 = kVar.h().a();
        this.f١٦٢٦٢k = a11;
        o3.a a12 = kVar.i().a();
        this.f١٦٢٦٣l = a12;
        o3.a a13 = kVar.e().a();
        this.f١٦٢٦٥n = a13;
        o3.a a14 = kVar.f().a();
        this.f١٦٢٦٧p = a14;
        k.a aVar = k.a.STAR;
        if (j10 == aVar) {
            this.f١٦٢٦٤m = kVar.b().a();
            this.f١٦٢٦٦o = kVar.c().a();
        } else {
            this.f١٦٢٦٤m = null;
            this.f١٦٢٦٦o = null;
        }
        bVar.i(a10);
        bVar.i(a11);
        bVar.i(a12);
        bVar.i(a13);
        bVar.i(a14);
        if (j10 == aVar) {
            bVar.i(this.f١٦٢٦٤m);
            bVar.i(this.f١٦٢٦٦o);
        }
        a10.a(this);
        a11.a(this);
        a12.a(this);
        a13.a(this);
        a14.a(this);
        if (j10 == aVar) {
            this.f١٦٢٦٤m.a(this);
            this.f١٦٢٦٦o.a(this);
        }
    }

    private void g() {
        double floatValue;
        double d10;
        float f10;
        n nVar;
        n nVar2 = this;
        int floor = (int) Math.floor(((Float) nVar2.f١٦٢٦١j.h()).floatValue());
        o3.a aVar = nVar2.f١٦٢٦٣l;
        if (aVar == null) {
            floatValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            floatValue = ((Float) aVar.h()).floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d11 = floor;
        float floatValue2 = ((Float) nVar2.f١٦٢٦٧p.h()).floatValue() / 100.0f;
        float floatValue3 = ((Float) nVar2.f١٦٢٦٥n.h()).floatValue();
        double d12 = floatValue3;
        float cos = (float) (Math.cos(radians) * d12);
        float sin = (float) (Math.sin(radians) * d12);
        nVar2.f١٦٢٥٢a.moveTo(cos, sin);
        double d13 = (float) (6.283185307179586d / d11);
        double ceil = Math.ceil(d11);
        double d14 = radians + d13;
        int i10 = 0;
        while (true) {
            double d15 = i10;
            if (d15 < ceil) {
                int i11 = i10;
                float cos2 = (float) (d12 * Math.cos(d14));
                double d16 = d13;
                float sin2 = (float) (d12 * Math.sin(d14));
                if (floatValue2 != DownloadProgress.UNKNOWN_PROGRESS) {
                    d10 = d12;
                    double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f10 = sin2;
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float f11 = floatValue3 * floatValue2 * 0.25f;
                    float f12 = cos3 * f11;
                    float f13 = sin3 * f11;
                    float cos4 = ((float) Math.cos(atan22)) * f11;
                    float sin4 = f11 * ((float) Math.sin(atan22));
                    if (d15 == ceil - 1.0d) {
                        nVar = this;
                        nVar.f١٦٢٥٣b.reset();
                        nVar.f١٦٢٥٣b.moveTo(cos, sin);
                        float f14 = cos - f12;
                        float f15 = sin - f13;
                        float f16 = cos2 + cos4;
                        float f17 = sin4 + f10;
                        nVar.f١٦٢٥٣b.cubicTo(f14, f15, f16, f17, cos2, f10);
                        nVar.f١٦٢٥٤c.setPath(nVar.f١٦٢٥٣b, false);
                        PathMeasure pathMeasure = nVar.f١٦٢٥٤c;
                        pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, nVar.f١٦٢٥٥d, null);
                        Path path = nVar.f١٦٢٥٢a;
                        float[] fArr = nVar.f١٦٢٥٥d;
                        path.cubicTo(f14, f15, f16, f17, fArr[0], fArr[1]);
                    } else {
                        nVar = this;
                        nVar.f١٦٢٥٢a.cubicTo(cos - f12, sin - f13, cos2 + cos4, f10 + sin4, cos2, f10);
                    }
                } else {
                    d10 = d12;
                    f10 = sin2;
                    nVar = nVar2;
                    if (d15 != ceil - 1.0d) {
                        nVar.f١٦٢٥٢a.lineTo(cos2, f10);
                    } else {
                        sin = f10;
                        cos = cos2;
                        d13 = d16;
                        i10 = i11 + 1;
                        nVar2 = nVar;
                        d12 = d10;
                    }
                }
                d14 += d16;
                sin = f10;
                cos = cos2;
                d13 = d16;
                i10 = i11 + 1;
                nVar2 = nVar;
                d12 = d10;
            } else {
                n nVar3 = nVar2;
                PointF pointF = (PointF) nVar3.f١٦٢٦٢k.h();
                nVar3.f١٦٢٥٢a.offset(pointF.x, pointF.y);
                nVar3.f١٦٢٥٢a.close();
                return;
            }
        }
    }

    private void i() {
        double floatValue;
        float f10;
        float f11;
        int i10;
        float f12;
        float f13;
        double d10;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        double d11;
        float f19;
        float f20;
        float f21;
        double d12;
        float f22;
        float f23;
        float f24;
        float f25;
        float floatValue2 = ((Float) this.f١٦٢٦١j.h()).floatValue();
        o3.a aVar = this.f١٦٢٦٣l;
        if (aVar == null) {
            floatValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            floatValue = ((Float) aVar.h()).floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d13 = floatValue2;
        float f26 = (float) (6.283185307179586d / d13);
        if (this.f١٦٢٦٠i) {
            f26 *= -1.0f;
        }
        float f27 = f26 / 2.0f;
        float f28 = floatValue2 - ((int) floatValue2);
        int i11 = (f28 > DownloadProgress.UNKNOWN_PROGRESS ? 1 : (f28 == DownloadProgress.UNKNOWN_PROGRESS ? 0 : -1));
        if (i11 != 0) {
            radians += (1.0f - f28) * f27;
        }
        float floatValue3 = ((Float) this.f١٦٢٦٥n.h()).floatValue();
        float floatValue4 = ((Float) this.f١٦٢٦٤m.h()).floatValue();
        o3.a aVar2 = this.f١٦٢٦٦o;
        if (aVar2 != null) {
            f10 = ((Float) aVar2.h()).floatValue() / 100.0f;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        o3.a aVar3 = this.f١٦٢٦٧p;
        if (aVar3 != null) {
            f11 = ((Float) aVar3.h()).floatValue() / 100.0f;
        } else {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (i11 != 0) {
            f15 = ((floatValue3 - floatValue4) * f28) + floatValue4;
            i10 = i11;
            double d14 = f15;
            float cos = (float) (d14 * Math.cos(radians));
            f14 = (float) (d14 * Math.sin(radians));
            this.f١٦٢٥٢a.moveTo(cos, f14);
            d10 = radians + ((f26 * f28) / 2.0f);
            f12 = cos;
            f13 = f27;
        } else {
            i10 = i11;
            double d15 = floatValue3;
            float cos2 = (float) (Math.cos(radians) * d15);
            float sin = (float) (d15 * Math.sin(radians));
            this.f١٦٢٥٢a.moveTo(cos2, sin);
            f12 = cos2;
            f13 = f27;
            d10 = radians + f13;
            f14 = sin;
            f15 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        double ceil = Math.ceil(d13) * 2.0d;
        int i12 = 0;
        float f29 = f13;
        float f30 = f12;
        boolean z10 = false;
        while (true) {
            double d16 = i12;
            if (d16 < ceil) {
                if (z10) {
                    f16 = floatValue3;
                } else {
                    f16 = floatValue4;
                }
                if (f15 != DownloadProgress.UNKNOWN_PROGRESS && d16 == ceil - 2.0d) {
                    f17 = f26;
                    f18 = (f26 * f28) / 2.0f;
                } else {
                    f17 = f26;
                    f18 = f29;
                }
                if (f15 != DownloadProgress.UNKNOWN_PROGRESS && d16 == ceil - 1.0d) {
                    d11 = d16;
                    f19 = f15;
                } else {
                    d11 = d16;
                    f19 = f15;
                    f15 = f16;
                }
                double d17 = f15;
                double d18 = ceil;
                float cos3 = (float) (d17 * Math.cos(d10));
                float sin2 = (float) (d17 * Math.sin(d10));
                if (f10 == DownloadProgress.UNKNOWN_PROGRESS && f11 == DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f١٦٢٥٢a.lineTo(cos3, sin2);
                    d12 = d10;
                    f20 = f10;
                    f21 = f11;
                } else {
                    f20 = f10;
                    double atan2 = (float) (Math.atan2(f14, f30) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f21 = f11;
                    d12 = d10;
                    double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z10) {
                        f22 = f20;
                    } else {
                        f22 = f21;
                    }
                    if (z10) {
                        f23 = f21;
                    } else {
                        f23 = f20;
                    }
                    if (z10) {
                        f24 = floatValue4;
                    } else {
                        f24 = floatValue3;
                    }
                    if (z10) {
                        f25 = floatValue3;
                    } else {
                        f25 = floatValue4;
                    }
                    float f31 = f24 * f22 * 0.47829f;
                    float f32 = cos4 * f31;
                    float f33 = f31 * sin3;
                    float f34 = f25 * f23 * 0.47829f;
                    float f35 = cos5 * f34;
                    float f36 = f34 * sin4;
                    if (i10 != 0) {
                        if (i12 == 0) {
                            f32 *= f28;
                            f33 *= f28;
                        } else if (d11 == d18 - 1.0d) {
                            f35 *= f28;
                            f36 *= f28;
                        }
                    }
                    this.f١٦٢٥٢a.cubicTo(f30 - f32, f14 - f33, cos3 + f35, sin2 + f36, cos3, sin2);
                }
                d10 = d12 + f18;
                z10 = !z10;
                i12++;
                f30 = cos3;
                f14 = sin2;
                f11 = f21;
                f10 = f20;
                f15 = f19;
                f26 = f17;
                ceil = d18;
            } else {
                PointF pointF = (PointF) this.f١٦٢٦٢k.h();
                this.f١٦٢٥٢a.offset(pointF.x, pointF.y);
                this.f١٦٢٥٢a.close();
                return;
            }
        }
    }

    private void j() {
        this.f١٦٢٦٩r = false;
        this.f١٦٢٥٧f.invalidateSelf();
    }

    @Override // o3.a.b
    public void a() {
        j();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = (c) list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == t.a.SIMULTANEOUSLY) {
                    this.f١٦٢٦٨q.a(uVar);
                    uVar.c(this);
                }
            }
        }
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        o3.a aVar;
        o3.a aVar2;
        if (obj == n0.f٦٢٦٧w) {
            this.f١٦٢٦١j.o(cVar);
            return;
        }
        if (obj == n0.f٦٢٦٨x) {
            this.f١٦٢٦٣l.o(cVar);
            return;
        }
        if (obj == n0.f٦٢٥٨n) {
            this.f١٦٢٦٢k.o(cVar);
            return;
        }
        if (obj == n0.f٦٢٦٩y && (aVar2 = this.f١٦٢٦٤m) != null) {
            aVar2.o(cVar);
            return;
        }
        if (obj == n0.f٦٢٧٠z) {
            this.f١٦٢٦٥n.o(cVar);
            return;
        }
        if (obj == n0.A && (aVar = this.f١٦٢٦٦o) != null) {
            aVar.o(cVar);
        } else if (obj == n0.f٦٢٤٤B) {
            this.f١٦٢٦٧p.o(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٢٥٦e;
    }

    @Override // n3.m
    public Path getPath() {
        if (this.f١٦٢٦٩r) {
            return this.f١٦٢٥٢a;
        }
        this.f١٦٢٥٢a.reset();
        if (this.f١٦٢٥٩h) {
            this.f١٦٢٦٩r = true;
            return this.f١٦٢٥٢a;
        }
        int i10 = a.f١٦٢٧٠a[this.f١٦٢٥٨g.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                g();
            }
        } else {
            i();
        }
        this.f١٦٢٥٢a.close();
        this.f١٦٢٦٨q.b(this.f١٦٢٥٢a);
        this.f١٦٢٦٩r = true;
        return this.f١٦٢٥٢a;
    }
}
