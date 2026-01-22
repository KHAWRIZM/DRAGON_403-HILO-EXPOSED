package n3;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;
import o3.a;
import s3.t;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o implements a.b, k, m {

    /* renamed from: c, reason: collision with root package name */
    private final String f١٦٢٧٣c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f١٦٢٧٤d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f١٦٢٧٥e;

    /* renamed from: f, reason: collision with root package name */
    private final o3.a f١٦٢٧٦f;

    /* renamed from: g, reason: collision with root package name */
    private final o3.a f١٦٢٧٧g;

    /* renamed from: h, reason: collision with root package name */
    private final o3.a f١٦٢٧٨h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٦٢٨١k;

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٦٢٧١a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f١٦٢٧٢b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private final b f١٦٢٧٩i = new b();

    /* renamed from: j, reason: collision with root package name */
    private o3.a f١٦٢٨٠j = null;

    public o(j0 j0Var, t3.b bVar, s3.l lVar) {
        this.f١٦٢٧٣c = lVar.c();
        this.f١٦٢٧٤d = lVar.f();
        this.f١٦٢٧٥e = j0Var;
        o3.a a10 = lVar.d().a();
        this.f١٦٢٧٦f = a10;
        o3.a a11 = lVar.e().a();
        this.f١٦٢٧٧g = a11;
        o3.a a12 = lVar.b().a();
        this.f١٦٢٧٨h = a12;
        bVar.i(a10);
        bVar.i(a11);
        bVar.i(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    private void g() {
        this.f١٦٢٨١k = false;
        this.f١٦٢٧٥e.invalidateSelf();
    }

    @Override // o3.a.b
    public void a() {
        g();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = (c) list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == t.a.SIMULTANEOUSLY) {
                    this.f١٦٢٧٩i.a(uVar);
                    uVar.c(this);
                }
            }
            if (cVar instanceof q) {
                this.f١٦٢٨٠j = ((q) cVar).g();
            }
        }
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        if (obj == n0.f٦٢٥٦l) {
            this.f١٦٢٧٧g.o(cVar);
        } else if (obj == n0.f٦٢٥٨n) {
            this.f١٦٢٧٦f.o(cVar);
        } else if (obj == n0.f٦٢٥٧m) {
            this.f١٦٢٧٨h.o(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٢٧٣c;
    }

    @Override // n3.m
    public Path getPath() {
        float q10;
        o3.a aVar;
        if (this.f١٦٢٨١k) {
            return this.f١٦٢٧١a;
        }
        this.f١٦٢٧١a.reset();
        if (this.f١٦٢٧٤d) {
            this.f١٦٢٨١k = true;
            return this.f١٦٢٧١a;
        }
        PointF pointF = (PointF) this.f١٦٢٧٧g.h();
        float f10 = pointF.x / 2.0f;
        float f11 = pointF.y / 2.0f;
        o3.a aVar2 = this.f١٦٢٧٨h;
        if (aVar2 == null) {
            q10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            q10 = ((o3.d) aVar2).q();
        }
        if (q10 == DownloadProgress.UNKNOWN_PROGRESS && (aVar = this.f١٦٢٨٠j) != null) {
            q10 = Math.min(((Float) aVar.h()).floatValue(), Math.min(f10, f11));
        }
        float min = Math.min(f10, f11);
        if (q10 > min) {
            q10 = min;
        }
        PointF pointF2 = (PointF) this.f١٦٢٧٦f.h();
        this.f١٦٢٧١a.moveTo(pointF2.x + f10, (pointF2.y - f11) + q10);
        this.f١٦٢٧١a.lineTo(pointF2.x + f10, (pointF2.y + f11) - q10);
        if (q10 > DownloadProgress.UNKNOWN_PROGRESS) {
            RectF rectF = this.f١٦٢٧٢b;
            float f12 = pointF2.x;
            float f13 = q10 * 2.0f;
            float f14 = pointF2.y;
            rectF.set((f12 + f10) - f13, (f14 + f11) - f13, f12 + f10, f14 + f11);
            this.f١٦٢٧١a.arcTo(this.f١٦٢٧٢b, DownloadProgress.UNKNOWN_PROGRESS, 90.0f, false);
        }
        this.f١٦٢٧١a.lineTo((pointF2.x - f10) + q10, pointF2.y + f11);
        if (q10 > DownloadProgress.UNKNOWN_PROGRESS) {
            RectF rectF2 = this.f١٦٢٧٢b;
            float f15 = pointF2.x;
            float f16 = pointF2.y;
            float f17 = q10 * 2.0f;
            rectF2.set(f15 - f10, (f16 + f11) - f17, (f15 - f10) + f17, f16 + f11);
            this.f١٦٢٧١a.arcTo(this.f١٦٢٧٢b, 90.0f, 90.0f, false);
        }
        this.f١٦٢٧١a.lineTo(pointF2.x - f10, (pointF2.y - f11) + q10);
        if (q10 > DownloadProgress.UNKNOWN_PROGRESS) {
            RectF rectF3 = this.f١٦٢٧٢b;
            float f18 = pointF2.x;
            float f19 = pointF2.y;
            float f20 = q10 * 2.0f;
            rectF3.set(f18 - f10, f19 - f11, (f18 - f10) + f20, (f19 - f11) + f20);
            this.f١٦٢٧١a.arcTo(this.f١٦٢٧٢b, 180.0f, 90.0f, false);
        }
        this.f١٦٢٧١a.lineTo((pointF2.x + f10) - q10, pointF2.y - f11);
        if (q10 > DownloadProgress.UNKNOWN_PROGRESS) {
            RectF rectF4 = this.f١٦٢٧٢b;
            float f21 = pointF2.x;
            float f22 = q10 * 2.0f;
            float f23 = pointF2.y;
            rectF4.set((f21 + f10) - f22, f23 - f11, f21 + f10, (f23 - f11) + f22);
            this.f١٦٢٧١a.arcTo(this.f١٦٢٧٢b, 270.0f, 90.0f, false);
        }
        this.f١٦٢٧١a.close();
        this.f١٦٢٧٩i.b(this.f١٦٢٧١a);
        this.f١٦٢٨١k = true;
        return this.f١٦٢٧١a;
    }
}
