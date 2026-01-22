package n3;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;
import o3.a;
import s3.t;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f implements m, a.b, k {

    /* renamed from: b, reason: collision with root package name */
    private final String f١٦١٩٤b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f١٦١٩٥c;

    /* renamed from: d, reason: collision with root package name */
    private final o3.a f١٦١٩٦d;

    /* renamed from: e, reason: collision with root package name */
    private final o3.a f١٦١٩٧e;

    /* renamed from: f, reason: collision with root package name */
    private final s3.b f١٦١٩٨f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١٦٢٠٠h;

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٦١٩٣a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final b f١٦١٩٩g = new b();

    public f(j0 j0Var, t3.b bVar, s3.b bVar2) {
        this.f١٦١٩٤b = bVar2.b();
        this.f١٦١٩٥c = j0Var;
        o3.a a10 = bVar2.d().a();
        this.f١٦١٩٦d = a10;
        o3.a a11 = bVar2.c().a();
        this.f١٦١٩٧e = a11;
        this.f١٦١٩٨f = bVar2;
        bVar.i(a10);
        bVar.i(a11);
        a10.a(this);
        a11.a(this);
    }

    private void g() {
        this.f١٦٢٠٠h = false;
        this.f١٦١٩٥c.invalidateSelf();
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
                    this.f١٦١٩٩g.a(uVar);
                    uVar.c(this);
                }
            }
        }
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        if (obj == n0.f٦٢٥٥k) {
            this.f١٦١٩٦d.o(cVar);
        } else if (obj == n0.f٦٢٥٨n) {
            this.f١٦١٩٧e.o(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦١٩٤b;
    }

    @Override // n3.m
    public Path getPath() {
        if (this.f١٦٢٠٠h) {
            return this.f١٦١٩٣a;
        }
        this.f١٦١٩٣a.reset();
        if (this.f١٦١٩٨f.e()) {
            this.f١٦٢٠٠h = true;
            return this.f١٦١٩٣a;
        }
        PointF pointF = (PointF) this.f١٦١٩٦d.h();
        float f10 = pointF.x / 2.0f;
        float f11 = pointF.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = 0.55228f * f11;
        this.f١٦١٩٣a.reset();
        if (this.f١٦١٩٨f.f()) {
            float f14 = -f11;
            this.f١٦١٩٣a.moveTo(DownloadProgress.UNKNOWN_PROGRESS, f14);
            Path path = this.f١٦١٩٣a;
            float f15 = DownloadProgress.UNKNOWN_PROGRESS - f12;
            float f16 = -f10;
            float f17 = DownloadProgress.UNKNOWN_PROGRESS - f13;
            path.cubicTo(f15, f14, f16, f17, f16, DownloadProgress.UNKNOWN_PROGRESS);
            Path path2 = this.f١٦١٩٣a;
            float f18 = f13 + DownloadProgress.UNKNOWN_PROGRESS;
            path2.cubicTo(f16, f18, f15, f11, DownloadProgress.UNKNOWN_PROGRESS, f11);
            Path path3 = this.f١٦١٩٣a;
            float f19 = f12 + DownloadProgress.UNKNOWN_PROGRESS;
            path3.cubicTo(f19, f11, f10, f18, f10, DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٦١٩٣a.cubicTo(f10, f17, f19, f14, DownloadProgress.UNKNOWN_PROGRESS, f14);
        } else {
            float f20 = -f11;
            this.f١٦١٩٣a.moveTo(DownloadProgress.UNKNOWN_PROGRESS, f20);
            Path path4 = this.f١٦١٩٣a;
            float f21 = f12 + DownloadProgress.UNKNOWN_PROGRESS;
            float f22 = DownloadProgress.UNKNOWN_PROGRESS - f13;
            path4.cubicTo(f21, f20, f10, f22, f10, DownloadProgress.UNKNOWN_PROGRESS);
            Path path5 = this.f١٦١٩٣a;
            float f23 = f13 + DownloadProgress.UNKNOWN_PROGRESS;
            path5.cubicTo(f10, f23, f21, f11, DownloadProgress.UNKNOWN_PROGRESS, f11);
            Path path6 = this.f١٦١٩٣a;
            float f24 = DownloadProgress.UNKNOWN_PROGRESS - f12;
            float f25 = -f10;
            path6.cubicTo(f24, f11, f25, f23, f25, DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٦١٩٣a.cubicTo(f25, f22, f24, f20, DownloadProgress.UNKNOWN_PROGRESS, f20);
        }
        PointF pointF2 = (PointF) this.f١٦١٩٧e.h();
        this.f١٦١٩٣a.offset(pointF2.x, pointF2.y);
        this.f١٦١٩٣a.close();
        this.f١٦١٩٩g.b(this.f١٦١٩٣a);
        this.f١٦٢٠٠h = true;
        return this.f١٦١٩٣a;
    }
}
