package i7;

import java.util.Iterator;
import java.util.concurrent.Executor;
import k7.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f١٤٦٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private final j7.d f١٤٦٧٩b;

    /* renamed from: c, reason: collision with root package name */
    private final x f١٤٦٨٠c;

    /* renamed from: d, reason: collision with root package name */
    private final k7.b f١٤٦٨١d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Executor executor, j7.d dVar, x xVar, k7.b bVar) {
        this.f١٤٦٧٨a = executor;
        this.f١٤٦٧٩b = dVar;
        this.f١٤٦٨٠c = xVar;
        this.f١٤٦٨١d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        Iterator it = this.f١٤٦٧٩b.l().iterator();
        while (it.hasNext()) {
            this.f١٤٦٨٠c.b((b7.p) it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f١٤٦٨١d.c(new b.a() { // from class: i7.u
            @Override // k7.b.a
            public final Object execute() {
                Object d10;
                d10 = v.this.d();
                return d10;
            }
        });
    }

    public void c() {
        this.f١٤٦٧٨a.execute(new Runnable() { // from class: i7.t
            @Override // java.lang.Runnable
            public final void run() {
                v.this.e();
            }
        });
    }
}
