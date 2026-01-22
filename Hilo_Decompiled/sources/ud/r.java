package ud;

import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class r extends t implements g0, fe.n {

    /* renamed from: b, reason: collision with root package name */
    protected final g0 f١٨٣٢١b;

    /* renamed from: c, reason: collision with root package name */
    protected final sd.i f١٨٣٢٢c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile boolean f١٨٣٢٣d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile boolean f١٨٣٢٤e;

    /* renamed from: f, reason: collision with root package name */
    protected Throwable f١٨٣٢٥f;

    public r(g0 g0Var, sd.i iVar) {
        this.f١٨٣٢١b = g0Var;
        this.f١٨٣٢٢c = iVar;
    }

    public final boolean a() {
        if (this.f١٨٣٢٦a.getAndIncrement() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(Object obj, boolean z10, nd.c cVar) {
        g0 g0Var = this.f١٨٣٢١b;
        sd.i iVar = this.f١٨٣٢٢c;
        if (this.f١٨٣٢٦a.get() == 0 && this.f١٨٣٢٦a.compareAndSet(0, 1)) {
            e(g0Var, obj);
            if (f(-1) == 0) {
                return;
            }
        } else {
            iVar.offer(obj);
            if (!a()) {
                return;
            }
        }
        fe.q.c(iVar, g0Var, z10, cVar, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Object obj, boolean z10, nd.c cVar) {
        g0 g0Var = this.f١٨٣٢١b;
        sd.i iVar = this.f١٨٣٢٢c;
        if (this.f١٨٣٢٦a.get() == 0 && this.f١٨٣٢٦a.compareAndSet(0, 1)) {
            if (iVar.isEmpty()) {
                e(g0Var, obj);
                if (f(-1) == 0) {
                    return;
                }
            } else {
                iVar.offer(obj);
            }
        } else {
            iVar.offer(obj);
            if (!a()) {
                return;
            }
        }
        fe.q.c(iVar, g0Var, z10, cVar, this);
    }

    @Override // fe.n
    public final Throwable d() {
        return this.f١٨٣٢٥f;
    }

    @Override // fe.n
    public abstract void e(g0 g0Var, Object obj);

    @Override // fe.n
    public final int f(int i10) {
        return this.f١٨٣٢٦a.addAndGet(i10);
    }

    @Override // fe.n
    public final boolean g() {
        return this.f١٨٣٢٤e;
    }

    @Override // fe.n
    public final boolean h() {
        return this.f١٨٣٢٣d;
    }
}
