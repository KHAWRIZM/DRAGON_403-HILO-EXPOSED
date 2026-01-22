package n3;

import android.graphics.Path;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;
import java.util.ArrayList;
import java.util.List;
import o3.a;
import s3.t;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class r implements m, a.b, k {

    /* renamed from: b, reason: collision with root package name */
    private final String f١٦٢٩٧b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f١٦٢٩٨c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f١٦٢٩٩d;

    /* renamed from: e, reason: collision with root package name */
    private final o3.m f١٦٣٠٠e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٦٣٠١f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٦٢٩٦a = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final b f١٦٣٠٢g = new b();

    public r(j0 j0Var, t3.b bVar, s3.r rVar) {
        this.f١٦٢٩٧b = rVar.b();
        this.f١٦٢٩٨c = rVar.d();
        this.f١٦٢٩٩d = j0Var;
        o3.m a10 = rVar.c().a();
        this.f١٦٣٠٠e = a10;
        bVar.i(a10);
        a10.a(this);
    }

    private void g() {
        this.f١٦٣٠١f = false;
        this.f١٦٢٩٩d.invalidateSelf();
    }

    @Override // o3.a.b
    public void a() {
        g();
    }

    @Override // n3.c
    public void b(List list, List list2) {
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = (c) list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == t.a.SIMULTANEOUSLY) {
                    this.f١٦٣٠٢g.a(uVar);
                    uVar.c(this);
                }
            }
            if (cVar instanceof s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((s) cVar);
            }
        }
        this.f١٦٣٠٠e.r(arrayList);
    }

    @Override // q3.f
    public void c(Object obj, y3.c cVar) {
        if (obj == n0.P) {
            this.f١٦٣٠٠e.o(cVar);
        }
    }

    @Override // q3.f
    public void d(q3.e eVar, int i10, List list, q3.e eVar2) {
        x3.k.k(eVar, i10, list, eVar2, this);
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٢٩٧b;
    }

    @Override // n3.m
    public Path getPath() {
        if (this.f١٦٣٠١f && !this.f١٦٣٠٠e.k()) {
            return this.f١٦٢٩٦a;
        }
        this.f١٦٢٩٦a.reset();
        if (this.f١٦٢٩٨c) {
            this.f١٦٣٠١f = true;
            return this.f١٦٢٩٦a;
        }
        Path path = (Path) this.f١٦٣٠٠e.h();
        if (path == null) {
            return this.f١٦٢٩٦a;
        }
        this.f١٦٢٩٦a.set(path);
        this.f١٦٢٩٦a.setFillType(Path.FillType.EVEN_ODD);
        this.f١٦٣٠٢g.b(this.f١٦٢٩٦a);
        this.f١٦٣٠١f = true;
        return this.f١٦٢٩٦a;
    }
}
