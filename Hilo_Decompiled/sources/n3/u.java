package n3;

import java.util.ArrayList;
import java.util.List;
import o3.a;
import s3.t;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class u implements c, a.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f١٦٣٠٨a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٦٣٠٩b;

    /* renamed from: c, reason: collision with root package name */
    private final List f١٦٣١٠c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final t.a f١٦٣١١d;

    /* renamed from: e, reason: collision with root package name */
    private final o3.a f١٦٣١٢e;

    /* renamed from: f, reason: collision with root package name */
    private final o3.a f١٦٣١٣f;

    /* renamed from: g, reason: collision with root package name */
    private final o3.a f١٦٣١٤g;

    public u(t3.b bVar, s3.t tVar) {
        this.f١٦٣٠٨a = tVar.c();
        this.f١٦٣٠٩b = tVar.g();
        this.f١٦٣١١d = tVar.f();
        o3.a a10 = tVar.e().a();
        this.f١٦٣١٢e = a10;
        o3.a a11 = tVar.b().a();
        this.f١٦٣١٣f = a11;
        o3.a a12 = tVar.d().a();
        this.f١٦٣١٤g = a12;
        bVar.i(a10);
        bVar.i(a11);
        bVar.i(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    @Override // o3.a.b
    public void a() {
        for (int i10 = 0; i10 < this.f١٦٣١٠c.size(); i10++) {
            ((a.b) this.f١٦٣١٠c.get(i10)).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a.b bVar) {
        this.f١٦٣١٠c.add(bVar);
    }

    public o3.a d() {
        return this.f١٦٣١٣f;
    }

    public o3.a g() {
        return this.f١٦٣١٤g;
    }

    public o3.a i() {
        return this.f١٦٣١٢e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t.a j() {
        return this.f١٦٣١١d;
    }

    public boolean k() {
        return this.f١٦٣٠٩b;
    }

    @Override // n3.c
    public void b(List list, List list2) {
    }
}
