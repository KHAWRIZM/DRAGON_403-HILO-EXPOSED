package b7;

import android.content.Context;
import b7.i;
import java.util.Collections;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class u implements t {

    /* renamed from: e, reason: collision with root package name */
    private static volatile v f٥٥٣٥e;

    /* renamed from: a, reason: collision with root package name */
    private final l7.a f٥٥٣٦a;

    /* renamed from: b, reason: collision with root package name */
    private final l7.a f٥٥٣٧b;

    /* renamed from: c, reason: collision with root package name */
    private final h7.e f٥٥٣٨c;

    /* renamed from: d, reason: collision with root package name */
    private final i7.r f٥٥٣٩d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(l7.a aVar, l7.a aVar2, h7.e eVar, i7.r rVar, i7.v vVar) {
        this.f٥٥٣٦a = aVar;
        this.f٥٥٣٧b = aVar2;
        this.f٥٥٣٨c = eVar;
        this.f٥٥٣٩d = rVar;
        vVar.c();
    }

    private i b(o oVar) {
        i.a g10 = i.a().i(this.f٥٥٣٦a.a()).o(this.f٥٥٣٧b.a()).n(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a());
        if (oVar.c().e() != null && oVar.c().e().a() != null) {
            g10.l(oVar.c().e().a());
        }
        oVar.c().b();
        return g10.d();
    }

    public static u c() {
        v vVar = f٥٥٣٥e;
        if (vVar != null) {
            return vVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set d(f fVar) {
        if (fVar instanceof g) {
            return Collections.unmodifiableSet(((g) fVar).a());
        }
        return Collections.singleton(z6.c.b("proto"));
    }

    public static void f(Context context) {
        if (f٥٥٣٥e == null) {
            synchronized (u.class) {
                try {
                    if (f٥٥٣٥e == null) {
                        f٥٥٣٥e = e.a().a(context).build();
                    }
                } finally {
                }
            }
        }
    }

    @Override // b7.t
    public void a(o oVar, z6.k kVar) {
        this.f٥٥٣٨c.a(oVar.f().f(oVar.c().d()), b(oVar), kVar);
    }

    public i7.r e() {
        return this.f٥٥٣٩d;
    }

    public z6.j g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
