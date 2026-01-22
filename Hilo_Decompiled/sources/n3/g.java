package n3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.graphics.c0;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g implements e, a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٦٢٠١a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f١٦٢٠٢b;

    /* renamed from: c, reason: collision with root package name */
    private final t3.b f١٦٢٠٣c;

    /* renamed from: d, reason: collision with root package name */
    private final String f١٦٢٠٤d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f١٦٢٠٥e;

    /* renamed from: f, reason: collision with root package name */
    private final List f١٦٢٠٦f;

    /* renamed from: g, reason: collision with root package name */
    private final o3.a f١٦٢٠٧g;

    /* renamed from: h, reason: collision with root package name */
    private final o3.a f١٦٢٠٨h;

    /* renamed from: i, reason: collision with root package name */
    private o3.a f١٦٢٠٩i;

    /* renamed from: j, reason: collision with root package name */
    private final j0 f١٦٢١٠j;

    /* renamed from: k, reason: collision with root package name */
    private o3.a f١٦٢١١k;

    /* renamed from: l, reason: collision with root package name */
    float f١٦٢١٢l;

    /* renamed from: m, reason: collision with root package name */
    private o3.c f١٦٢١٣m;

    public g(j0 j0Var, t3.b bVar, s3.p pVar) {
        Path path = new Path();
        this.f١٦٢٠١a = path;
        m3.a aVar = new m3.a(1);
        this.f١٦٢٠٢b = aVar;
        this.f١٦٢٠٦f = new ArrayList();
        this.f١٦٢٠٣c = bVar;
        this.f١٦٢٠٤d = pVar.d();
        this.f١٦٢٠٥e = pVar.f();
        this.f١٦٢١٠j = j0Var;
        if (bVar.w() != null) {
            o3.a a10 = bVar.w().a().a();
            this.f١٦٢١١k = a10;
            a10.a(this);
            bVar.i(this.f١٦٢١١k);
        }
        if (bVar.y() != null) {
            this.f١٦٢١٣m = new o3.c(this, bVar, bVar.y());
        }
        if (pVar.b() != null && pVar.e() != null) {
            c0.c(aVar, bVar.v().c());
            path.setFillType(pVar.c());
            o3.a a11 = pVar.b().a();
            this.f١٦٢٠٧g = a11;
            a11.a(this);
            bVar.i(a11);
            o3.a a12 = pVar.e().a();
            this.f١٦٢٠٨h = a12;
            a12.a(this);
            bVar.i(a12);
            return;
        }
        this.f١٦٢٠٧g = null;
        this.f١٦٢٠٨h = null;
    }

    @Override // o3.a.b
    public void a() {
        this.f١٦٢١٠j.invalidateSelf();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = (c) list2.get(i10);
            if (cVar instanceof m) {
                this.f١٦٢٠٦f.add((m) cVar);
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
        if (obj == n0.f٦٢٤٥a) {
            this.f١٦٢٠٧g.o(cVar);
            return;
        }
        if (obj == n0.f٦٢٤٨d) {
            this.f١٦٢٠٨h.o(cVar);
            return;
        }
        if (obj == n0.K) {
            o3.a aVar = this.f١٦٢٠٩i;
            if (aVar != null) {
                this.f١٦٢٠٣c.H(aVar);
            }
            if (cVar == null) {
                this.f١٦٢٠٩i = null;
                return;
            }
            o3.q qVar = new o3.q(cVar);
            this.f١٦٢٠٩i = qVar;
            qVar.a(this);
            this.f١٦٢٠٣c.i(this.f١٦٢٠٩i);
            return;
        }
        if (obj == n0.f٦٢٥٤j) {
            o3.a aVar2 = this.f١٦٢١١k;
            if (aVar2 != null) {
                aVar2.o(cVar);
                return;
            }
            o3.q qVar2 = new o3.q(cVar);
            this.f١٦٢١١k = qVar2;
            qVar2.a(this);
            this.f١٦٢٠٣c.i(this.f١٦٢١١k);
            return;
        }
        if (obj == n0.f٦٢٤٩e && (cVar6 = this.f١٦٢١٣m) != null) {
            cVar6.c(cVar);
            return;
        }
        if (obj == n0.G && (cVar5 = this.f١٦٢١٣m) != null) {
            cVar5.f(cVar);
            return;
        }
        if (obj == n0.H && (cVar4 = this.f١٦٢١٣m) != null) {
            cVar4.d(cVar);
            return;
        }
        if (obj == n0.I && (cVar3 = this.f١٦٢١٣m) != null) {
            cVar3.e(cVar);
        } else if (obj == n0.J && (cVar2 = this.f١٦٢١٣m) != null) {
            cVar2.g(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
    }

    @Override // n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f١٦٢٠١a.reset();
        for (int i10 = 0; i10 < this.f١٦٢٠٦f.size(); i10++) {
            this.f١٦٢٠١a.addPath(((m) this.f١٦٢٠٦f.get(i10)).getPath(), matrix);
        }
        this.f١٦٢٠١a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٢٠٤d;
    }

    @Override // n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        if (this.f١٦٢٠٥e) {
            return;
        }
        com.airbnb.lottie.e.b("FillContent#draw");
        this.f١٦٢٠٢b.setColor((x3.k.c((int) ((((i10 / 255.0f) * ((Integer) this.f١٦٢٠٨h.h()).intValue()) / 100.0f) * 255.0f), 0, KotlinVersion.MAX_COMPONENT_VALUE) << 24) | (((o3.b) this.f١٦٢٠٧g).q() & 16777215));
        o3.a aVar = this.f١٦٢٠٩i;
        if (aVar != null) {
            this.f١٦٢٠٢b.setColorFilter((ColorFilter) aVar.h());
        }
        o3.a aVar2 = this.f١٦٢١١k;
        if (aVar2 != null) {
            float floatValue = ((Float) aVar2.h()).floatValue();
            if (floatValue == DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٦٢٠٢b.setMaskFilter(null);
            } else if (floatValue != this.f١٦٢١٢l) {
                this.f١٦٢٠٢b.setMaskFilter(this.f١٦٢٠٣c.x(floatValue));
            }
            this.f١٦٢١٢l = floatValue;
        }
        o3.c cVar = this.f١٦٢١٣m;
        if (cVar != null) {
            cVar.b(this.f١٦٢٠٢b);
        }
        this.f١٦٢٠١a.reset();
        for (int i11 = 0; i11 < this.f١٦٢٠٦f.size(); i11++) {
            this.f١٦٢٠١a.addPath(((m) this.f١٦٢٠٦f.get(i11)).getPath(), matrix);
        }
        canvas.drawPath(this.f١٦٢٠١a, this.f١٦٢٠٢b);
        com.airbnb.lottie.e.c("FillContent#draw");
    }
}
