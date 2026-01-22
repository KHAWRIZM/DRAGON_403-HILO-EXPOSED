package n3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class p implements e, m, j, a.b, k {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f١٦٢٨٢a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final Path f١٦٢٨٣b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final j0 f١٦٢٨٤c;

    /* renamed from: d, reason: collision with root package name */
    private final t3.b f١٦٢٨٥d;

    /* renamed from: e, reason: collision with root package name */
    private final String f١٦٢٨٦e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f١٦٢٨٧f;

    /* renamed from: g, reason: collision with root package name */
    private final o3.a f١٦٢٨٨g;

    /* renamed from: h, reason: collision with root package name */
    private final o3.a f١٦٢٨٩h;

    /* renamed from: i, reason: collision with root package name */
    private final o3.p f١٦٢٩٠i;

    /* renamed from: j, reason: collision with root package name */
    private d f١٦٢٩١j;

    public p(j0 j0Var, t3.b bVar, s3.m mVar) {
        this.f١٦٢٨٤c = j0Var;
        this.f١٦٢٨٥d = bVar;
        this.f١٦٢٨٦e = mVar.c();
        this.f١٦٢٨٧f = mVar.f();
        o3.a a10 = mVar.b().a();
        this.f١٦٢٨٨g = a10;
        bVar.i(a10);
        a10.a(this);
        o3.a a11 = mVar.d().a();
        this.f١٦٢٨٩h = a11;
        bVar.i(a11);
        a11.a(this);
        o3.p b10 = mVar.e().b();
        this.f١٦٢٩٠i = b10;
        b10.a(bVar);
        b10.b(this);
    }

    @Override // o3.a.b
    public void a() {
        this.f١٦٢٨٤c.invalidateSelf();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        this.f١٦٢٩١j.b(list, list2);
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        if (this.f١٦٢٩٠i.c(obj, cVar)) {
            return;
        }
        if (obj == n0.f٦٢٦٥u) {
            this.f١٦٢٨٨g.o(cVar);
        } else if (obj == n0.f٦٢٦٦v) {
            this.f١٦٢٨٩h.o(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
        for (int i11 = 0; i11 < this.f١٦٢٩١j.j().size(); i11++) {
            c cVar = (c) this.f١٦٢٩١j.j().get(i11);
            if (cVar instanceof k) {
                x3.k.k(eVar, i10, list, eVar2, (k) cVar);
            }
        }
    }

    @Override // n3.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f١٦٢٩١j.f(rectF, matrix, z10);
    }

    @Override // n3.j
    public void g(ListIterator listIterator) {
        if (this.f١٦٢٩١j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((c) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f١٦٢٩١j = new d(this.f١٦٢٨٤c, this.f١٦٢٨٥d, "Repeater", this.f١٦٢٨٧f, arrayList, null);
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٢٨٦e;
    }

    @Override // n3.m
    public Path getPath() {
        Path path = this.f١٦٢٩١j.getPath();
        this.f١٦٢٨٣b.reset();
        float floatValue = ((Float) this.f١٦٢٨٨g.h()).floatValue();
        float floatValue2 = ((Float) this.f١٦٢٨٩h.h()).floatValue();
        for (int i10 = ((int) floatValue) - 1; i10 >= 0; i10--) {
            this.f١٦٢٨٢a.set(this.f١٦٢٩٠i.g(i10 + floatValue2));
            this.f١٦٢٨٣b.addPath(path, this.f١٦٢٨٢a);
        }
        return this.f١٦٢٨٣b;
    }

    @Override // n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        float floatValue = ((Float) this.f١٦٢٨٨g.h()).floatValue();
        float floatValue2 = ((Float) this.f١٦٢٨٩h.h()).floatValue();
        float floatValue3 = ((Float) this.f١٦٢٩٠i.i().h()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.f١٦٢٩٠i.e().h()).floatValue() / 100.0f;
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.f١٦٢٨٢a.set(matrix);
            float f10 = i11;
            this.f١٦٢٨٢a.preConcat(this.f١٦٢٩٠i.g(f10 + floatValue2));
            this.f١٦٢٩١j.h(canvas, this.f١٦٢٨٢a, (int) (i10 * x3.k.i(floatValue3, floatValue4, f10 / floatValue)));
        }
    }
}
