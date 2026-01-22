package de;

import sd.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a implements sd.c, g {

    /* renamed from: a, reason: collision with root package name */
    protected final sd.c f١٣٦٩٣a;

    /* renamed from: b, reason: collision with root package name */
    protected kf.c f١٣٦٩٤b;

    /* renamed from: c, reason: collision with root package name */
    protected g f١٣٦٩٥c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f١٣٦٩٦d;

    /* renamed from: e, reason: collision with root package name */
    protected int f١٣٦٩٧e;

    public a(sd.c cVar) {
        this.f١٣٦٩٣a = cVar;
    }

    public void cancel() {
        this.f١٣٦٩٤b.cancel();
    }

    @Override // sd.j
    public void clear() {
        this.f١٣٦٩٥c.clear();
    }

    protected boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(Throwable th) {
        od.b.b(th);
        this.f١٣٦٩٤b.cancel();
        onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f(int i10) {
        g gVar = this.f١٣٦٩٥c;
        if (gVar != null && (i10 & 4) == 0) {
            int a10 = gVar.a(i10);
            if (a10 != 0) {
                this.f١٣٦٩٧e = a10;
            }
            return a10;
        }
        return 0;
    }

    @Override // sd.j
    public boolean isEmpty() {
        return this.f١٣٦٩٥c.isEmpty();
    }

    @Override // sd.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (this.f١٣٦٩٦d) {
            return;
        }
        this.f١٣٦٩٦d = true;
        this.f١٣٦٩٣a.onComplete();
    }

    public void onError(Throwable th) {
        if (this.f١٣٦٩٦d) {
            ie.a.s(th);
        } else {
            this.f١٣٦٩٦d = true;
            this.f١٣٦٩٣a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.i
    public final void onSubscribe(kf.c cVar) {
        if (ee.c.h(this.f١٣٦٩٤b, cVar)) {
            this.f١٣٦٩٤b = cVar;
            if (cVar instanceof g) {
                this.f١٣٦٩٥c = (g) cVar;
            }
            if (d()) {
                this.f١٣٦٩٣a.onSubscribe(this);
                b();
            }
        }
    }

    public void request(long j10) {
        this.f١٣٦٩٤b.request(j10);
    }

    protected void b() {
    }
}
