package c5;

import c5.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b implements e, d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f٥٨٦١a;

    /* renamed from: b, reason: collision with root package name */
    private final e f٥٨٦٢b;

    /* renamed from: c, reason: collision with root package name */
    private volatile d f٥٨٦٣c;

    /* renamed from: d, reason: collision with root package name */
    private volatile d f٥٨٦٤d;

    /* renamed from: e, reason: collision with root package name */
    private e.a f٥٨٦٥e;

    /* renamed from: f, reason: collision with root package name */
    private e.a f٥٨٦٦f;

    public b(Object obj, e eVar) {
        e.a aVar = e.a.CLEARED;
        this.f٥٨٦٥e = aVar;
        this.f٥٨٦٦f = aVar;
        this.f٥٨٦١a = obj;
        this.f٥٨٦٢b = eVar;
    }

    private boolean k(d dVar) {
        e.a aVar;
        e.a aVar2 = this.f٥٨٦٥e;
        e.a aVar3 = e.a.FAILED;
        if (aVar2 != aVar3) {
            return dVar.equals(this.f٥٨٦٣c);
        }
        if (dVar.equals(this.f٥٨٦٤d) && ((aVar = this.f٥٨٦٦f) == e.a.SUCCESS || aVar == aVar3)) {
            return true;
        }
        return false;
    }

    private boolean l() {
        e eVar = this.f٥٨٦٢b;
        if (eVar != null && !eVar.c(this)) {
            return false;
        }
        return true;
    }

    private boolean m() {
        e eVar = this.f٥٨٦٢b;
        if (eVar != null && !eVar.i(this)) {
            return false;
        }
        return true;
    }

    private boolean n() {
        e eVar = this.f٥٨٦٢b;
        if (eVar != null && !eVar.b(this)) {
            return false;
        }
        return true;
    }

    @Override // c5.e, c5.d
    public boolean a() {
        boolean z10;
        synchronized (this.f٥٨٦١a) {
            try {
                if (!this.f٥٨٦٣c.a() && !this.f٥٨٦٤d.a()) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.e
    public boolean b(d dVar) {
        boolean n10;
        synchronized (this.f٥٨٦١a) {
            n10 = n();
        }
        return n10;
    }

    @Override // c5.e
    public boolean c(d dVar) {
        boolean z10;
        synchronized (this.f٥٨٦١a) {
            try {
                if (l() && dVar.equals(this.f٥٨٦٣c)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.d
    public void clear() {
        synchronized (this.f٥٨٦١a) {
            try {
                e.a aVar = e.a.CLEARED;
                this.f٥٨٦٥e = aVar;
                this.f٥٨٦٣c.clear();
                if (this.f٥٨٦٦f != aVar) {
                    this.f٥٨٦٦f = aVar;
                    this.f٥٨٦٤d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // c5.e
    public void d(d dVar) {
        synchronized (this.f٥٨٦١a) {
            try {
                if (dVar.equals(this.f٥٨٦٣c)) {
                    this.f٥٨٦٥e = e.a.SUCCESS;
                } else if (dVar.equals(this.f٥٨٦٤d)) {
                    this.f٥٨٦٦f = e.a.SUCCESS;
                }
                e eVar = this.f٥٨٦٢b;
                if (eVar != null) {
                    eVar.d(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // c5.d
    public boolean e() {
        boolean z10;
        synchronized (this.f٥٨٦١a) {
            try {
                e.a aVar = this.f٥٨٦٥e;
                e.a aVar2 = e.a.CLEARED;
                if (aVar == aVar2 && this.f٥٨٦٦f == aVar2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.d
    public boolean f(d dVar) {
        if (!(dVar instanceof b)) {
            return false;
        }
        b bVar = (b) dVar;
        if (!this.f٥٨٦٣c.f(bVar.f٥٨٦٣c) || !this.f٥٨٦٤d.f(bVar.f٥٨٦٤d)) {
            return false;
        }
        return true;
    }

    @Override // c5.d
    public boolean g() {
        boolean z10;
        synchronized (this.f٥٨٦١a) {
            try {
                e.a aVar = this.f٥٨٦٥e;
                e.a aVar2 = e.a.SUCCESS;
                if (aVar != aVar2 && this.f٥٨٦٦f != aVar2) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.e
    public e getRoot() {
        e eVar;
        synchronized (this.f٥٨٦١a) {
            try {
                e eVar2 = this.f٥٨٦٢b;
                if (eVar2 != null) {
                    eVar = eVar2.getRoot();
                } else {
                    eVar = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // c5.e
    public void h(d dVar) {
        synchronized (this.f٥٨٦١a) {
            try {
                if (!dVar.equals(this.f٥٨٦٤d)) {
                    this.f٥٨٦٥e = e.a.FAILED;
                    e.a aVar = this.f٥٨٦٦f;
                    e.a aVar2 = e.a.RUNNING;
                    if (aVar != aVar2) {
                        this.f٥٨٦٦f = aVar2;
                        this.f٥٨٦٤d.j();
                    }
                    return;
                }
                this.f٥٨٦٦f = e.a.FAILED;
                e eVar = this.f٥٨٦٢b;
                if (eVar != null) {
                    eVar.h(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // c5.e
    public boolean i(d dVar) {
        boolean z10;
        synchronized (this.f٥٨٦١a) {
            try {
                if (m() && k(dVar)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.d
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f٥٨٦١a) {
            try {
                e.a aVar = this.f٥٨٦٥e;
                e.a aVar2 = e.a.RUNNING;
                if (aVar != aVar2 && this.f٥٨٦٦f != aVar2) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.d
    public void j() {
        synchronized (this.f٥٨٦١a) {
            try {
                e.a aVar = this.f٥٨٦٥e;
                e.a aVar2 = e.a.RUNNING;
                if (aVar != aVar2) {
                    this.f٥٨٦٥e = aVar2;
                    this.f٥٨٦٣c.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(d dVar, d dVar2) {
        this.f٥٨٦٣c = dVar;
        this.f٥٨٦٤d = dVar2;
    }

    @Override // c5.d
    public void pause() {
        synchronized (this.f٥٨٦١a) {
            try {
                e.a aVar = this.f٥٨٦٥e;
                e.a aVar2 = e.a.RUNNING;
                if (aVar == aVar2) {
                    this.f٥٨٦٥e = e.a.PAUSED;
                    this.f٥٨٦٣c.pause();
                }
                if (this.f٥٨٦٦f == aVar2) {
                    this.f٥٨٦٦f = e.a.PAUSED;
                    this.f٥٨٦٤d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
