package h7;

import b7.p;
import b7.u;
import c7.m;
import i7.x;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import k7.b;
import z6.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c implements e {

    /* renamed from: f, reason: collision with root package name */
    private static final Logger f١٤٥١٩f = Logger.getLogger(u.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final x f١٤٥٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f١٤٥٢١b;

    /* renamed from: c, reason: collision with root package name */
    private final c7.e f١٤٥٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private final j7.d f١٤٥٢٣d;

    /* renamed from: e, reason: collision with root package name */
    private final k7.b f١٤٥٢٤e;

    public c(Executor executor, c7.e eVar, x xVar, j7.d dVar, k7.b bVar) {
        this.f١٤٥٢١b = executor;
        this.f١٤٥٢٢c = eVar;
        this.f١٤٥٢٠a = xVar;
        this.f١٤٥٢٣d = dVar;
        this.f١٤٥٢٤e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(p pVar, b7.i iVar) {
        this.f١٤٥٢٣d.J(pVar, iVar);
        this.f١٤٥٢٠a.b(pVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final p pVar, k kVar, b7.i iVar) {
        try {
            m mVar = this.f١٤٥٢٢c.get(pVar.b());
            if (mVar == null) {
                String format = String.format("Transport backend '%s' is not registered", pVar.b());
                f١٤٥١٩f.warning(format);
                kVar.a(new IllegalArgumentException(format));
            } else {
                final b7.i b10 = mVar.b(iVar);
                this.f١٤٥٢٤e.c(new b.a() { // from class: h7.b
                    @Override // k7.b.a
                    public final Object execute() {
                        Object d10;
                        d10 = c.this.d(pVar, b10);
                        return d10;
                    }
                });
                kVar.a(null);
            }
        } catch (Exception e10) {
            f١٤٥١٩f.warning("Error scheduling event " + e10.getMessage());
            kVar.a(e10);
        }
    }

    @Override // h7.e
    public void a(final p pVar, final b7.i iVar, final k kVar) {
        this.f١٤٥٢١b.execute(new Runnable() { // from class: h7.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.e(pVar, kVar, iVar);
            }
        });
    }
}
