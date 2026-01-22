package n3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.j0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d implements e, m, a.b, q3.f {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f١٦١٨٢a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f١٦١٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f١٦١٨٤c;

    /* renamed from: d, reason: collision with root package name */
    private final Path f١٦١٨٥d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f١٦١٨٦e;

    /* renamed from: f, reason: collision with root package name */
    private final String f١٦١٨٧f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f١٦١٨٨g;

    /* renamed from: h, reason: collision with root package name */
    private final List f١٦١٨٩h;

    /* renamed from: i, reason: collision with root package name */
    private final j0 f١٦١٩٠i;

    /* renamed from: j, reason: collision with root package name */
    private List f١٦١٩١j;

    /* renamed from: k, reason: collision with root package name */
    private o3.p f١٦١٩٢k;

    public d(j0 j0Var, t3.b bVar, s3.q qVar, com.airbnb.lottie.j jVar) {
        this(j0Var, bVar, qVar.c(), qVar.d(), g(j0Var, jVar, bVar, qVar.b()), i(qVar.b()));
    }

    private static List g(j0 j0Var, com.airbnb.lottie.j jVar, t3.b bVar, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            c a10 = ((s3.c) list.get(i10)).a(j0Var, jVar, bVar);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    static r3.l i(List list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            s3.c cVar = (s3.c) list.get(i10);
            if (cVar instanceof r3.l) {
                return (r3.l) cVar;
            }
        }
        return null;
    }

    private boolean m() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f١٦١٨٩h.size(); i11++) {
            if ((this.f١٦١٨٩h.get(i11) instanceof e) && (i10 = i10 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // o3.a.b
    public void a() {
        this.f١٦١٩٠i.invalidateSelf();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f١٦١٨٩h.size());
        arrayList.addAll(list);
        for (int size = this.f١٦١٨٩h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f١٦١٨٩h.get(size);
            cVar.b(arrayList, this.f١٦١٨٩h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        o3.p pVar = this.f١٦١٩٢k;
        if (pVar != null) {
            pVar.c(obj, cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        if (!eVar.g(getName(), i10) && !"__container".equals(getName())) {
            return;
        }
        if (!"__container".equals(getName())) {
            eVar2 = eVar2.a(getName());
            if (eVar.c(getName(), i10)) {
                list.add(eVar2.i(this));
            }
        }
        if (eVar.h(getName(), i10)) {
            int e10 = i10 + eVar.e(getName(), i10);
            for (int i11 = 0; i11 < this.f١٦١٨٩h.size(); i11++) {
                c cVar = (c) this.f١٦١٨٩h.get(i11);
                if (cVar instanceof q3.f) {
                    ((q3.f) cVar).d(eVar, e10, list, eVar2);
                }
            }
        }
    }

    @Override // n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f١٦١٨٤c.set(matrix);
        o3.p pVar = this.f١٦١٩٢k;
        if (pVar != null) {
            this.f١٦١٨٤c.preConcat(pVar.f());
        }
        this.f١٦١٨٦e.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        for (int size = this.f١٦١٨٩h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f١٦١٨٩h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).f(this.f١٦١٨٦e, this.f١٦١٨٤c, z10);
                rectF.union(this.f١٦١٨٦e);
            }
        }
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦١٨٧f;
    }

    @Override // n3.m
    public Path getPath() {
        this.f١٦١٨٤c.reset();
        o3.p pVar = this.f١٦١٩٢k;
        if (pVar != null) {
            this.f١٦١٨٤c.set(pVar.f());
        }
        this.f١٦١٨٥d.reset();
        if (this.f١٦١٨٨g) {
            return this.f١٦١٨٥d;
        }
        for (int size = this.f١٦١٨٩h.size() - 1; size >= 0; size--) {
            c cVar = (c) this.f١٦١٨٩h.get(size);
            if (cVar instanceof m) {
                this.f١٦١٨٥d.addPath(((m) cVar).getPath(), this.f١٦١٨٤c);
            }
        }
        return this.f١٦١٨٥d;
    }

    @Override // n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        int intValue;
        if (this.f١٦١٨٨g) {
            return;
        }
        this.f١٦١٨٤c.set(matrix);
        o3.p pVar = this.f١٦١٩٢k;
        if (pVar != null) {
            this.f١٦١٨٤c.preConcat(pVar.f());
            if (this.f١٦١٩٢k.h() == null) {
                intValue = 100;
            } else {
                intValue = ((Integer) this.f١٦١٩٢k.h().h()).intValue();
            }
            i10 = (int) ((((intValue / 100.0f) * i10) / 255.0f) * 255.0f);
        }
        if (this.f١٦١٩٠i.f0() && m() && i10 != 255) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f١٦١٨٣b.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
            f(this.f١٦١٨٣b, this.f١٦١٨٤c, true);
            this.f١٦١٨٢a.setAlpha(i10);
            x3.l.m(canvas, this.f١٦١٨٣b, this.f١٦١٨٢a);
        }
        if (z10) {
            i10 = KotlinVersion.MAX_COMPONENT_VALUE;
        }
        for (int size = this.f١٦١٨٩h.size() - 1; size >= 0; size--) {
            Object obj = this.f١٦١٨٩h.get(size);
            if (obj instanceof e) {
                ((e) obj).h(canvas, this.f١٦١٨٤c, i10);
            }
        }
        if (z10) {
            canvas.restore();
        }
    }

    public List j() {
        return this.f١٦١٨٩h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List k() {
        if (this.f١٦١٩١j == null) {
            this.f١٦١٩١j = new ArrayList();
            for (int i10 = 0; i10 < this.f١٦١٨٩h.size(); i10++) {
                c cVar = (c) this.f١٦١٨٩h.get(i10);
                if (cVar instanceof m) {
                    this.f١٦١٩١j.add((m) cVar);
                }
            }
        }
        return this.f١٦١٩١j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix l() {
        o3.p pVar = this.f١٦١٩٢k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f١٦١٨٤c.reset();
        return this.f١٦١٨٤c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(j0 j0Var, t3.b bVar, String str, boolean z10, List list, r3.l lVar) {
        this.f١٦١٨٢a = new m3.a();
        this.f١٦١٨٣b = new RectF();
        this.f١٦١٨٤c = new Matrix();
        this.f١٦١٨٥d = new Path();
        this.f١٦١٨٦e = new RectF();
        this.f١٦١٨٧f = str;
        this.f١٦١٩٠i = j0Var;
        this.f١٦١٨٨g = z10;
        this.f١٦١٨٩h = list;
        if (lVar != null) {
            o3.p b10 = lVar.b();
            this.f١٦١٩٢k = b10;
            b10.a(bVar);
            this.f١٦١٩٢k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).g(list.listIterator(list.size()));
        }
    }
}
