package de;

import io.reactivex.rxjava3.core.i;
import sd.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class b implements i, g {

    /* renamed from: a, reason: collision with root package name */
    protected final kf.b f١٣٦٩٨a;

    /* renamed from: b, reason: collision with root package name */
    protected kf.c f١٣٦٩٩b;

    /* renamed from: c, reason: collision with root package name */
    protected g f١٣٧٠٠c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f١٣٧٠١d;

    /* renamed from: e, reason: collision with root package name */
    protected int f١٣٧٠٢e;

    public b(kf.b bVar) {
        this.f١٣٦٩٨a = bVar;
    }

    public void cancel() {
        this.f١٣٦٩٩b.cancel();
    }

    @Override // sd.j
    public void clear() {
        this.f١٣٧٠٠c.clear();
    }

    protected boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(Throwable th) {
        od.b.b(th);
        this.f١٣٦٩٩b.cancel();
        onError(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f(int i10) {
        g gVar = this.f١٣٧٠٠c;
        if (gVar != null && (i10 & 4) == 0) {
            int a10 = gVar.a(i10);
            if (a10 != 0) {
                this.f١٣٧٠٢e = a10;
            }
            return a10;
        }
        return 0;
    }

    @Override // sd.j
    public boolean isEmpty() {
        return this.f١٣٧٠٠c.isEmpty();
    }

    @Override // sd.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (this.f١٣٧٠١d) {
            return;
        }
        this.f١٣٧٠١d = true;
        this.f١٣٦٩٨a.onComplete();
    }

    public void onError(Throwable th) {
        if (this.f١٣٧٠١d) {
            ie.a.s(th);
        } else {
            this.f١٣٧٠١d = true;
            this.f١٣٦٩٨a.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.i
    public final void onSubscribe(kf.c cVar) {
        if (ee.c.h(this.f١٣٦٩٩b, cVar)) {
            this.f١٣٦٩٩b = cVar;
            if (cVar instanceof g) {
                this.f١٣٧٠٠c = (g) cVar;
            }
            if (d()) {
                this.f١٣٦٩٨a.onSubscribe(this);
                b();
            }
        }
    }

    public void request(long j10) {
        this.f١٣٦٩٩b.request(j10);
    }

    protected void b() {
    }
}
