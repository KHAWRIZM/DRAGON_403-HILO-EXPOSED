package ud;

import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a implements g0, sd.e {

    /* renamed from: a, reason: collision with root package name */
    protected final g0 f١٨٢٨٢a;

    /* renamed from: b, reason: collision with root package name */
    protected nd.c f١٨٢٨٣b;

    /* renamed from: c, reason: collision with root package name */
    protected sd.e f١٨٢٨٤c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f١٨٢٨٥d;

    /* renamed from: e, reason: collision with root package name */
    protected int f١٨٢٨٦e;

    public a(g0 g0Var) {
        this.f١٨٢٨٢a = g0Var;
    }

    protected boolean c() {
        return true;
    }

    @Override // sd.j
    public void clear() {
        this.f١٨٢٨٤c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(Throwable th) {
        od.b.b(th);
        this.f١٨٢٨٣b.dispose();
        onError(th);
    }

    @Override // nd.c
    public void dispose() {
        this.f١٨٢٨٣b.dispose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e(int i10) {
        sd.e eVar = this.f١٨٢٨٤c;
        if (eVar != null && (i10 & 4) == 0) {
            int a10 = eVar.a(i10);
            if (a10 != 0) {
                this.f١٨٢٨٦e = a10;
            }
            return a10;
        }
        return 0;
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f١٨٢٨٣b.isDisposed();
    }

    @Override // sd.j
    public boolean isEmpty() {
        return this.f١٨٢٨٤c.isEmpty();
    }

    @Override // sd.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (this.f١٨٢٨٥d) {
            return;
        }
        this.f١٨٢٨٥d = true;
        this.f١٨٢٨٢a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (this.f١٨٢٨٥d) {
            ie.a.s(th);
        } else {
            this.f١٨٢٨٥d = true;
            this.f١٨٢٨٢a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public final void onSubscribe(nd.c cVar) {
        if (qd.c.i(this.f١٨٢٨٣b, cVar)) {
            this.f١٨٢٨٣b = cVar;
            if (cVar instanceof sd.e) {
                this.f١٨٢٨٤c = (sd.e) cVar;
            }
            if (c()) {
                this.f١٨٢٨٢a.onSubscribe(this);
                b();
            }
        }
    }

    protected void b() {
    }
}
