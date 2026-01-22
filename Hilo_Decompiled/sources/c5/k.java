package c5;

import c5.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k implements e, d {

    /* renamed from: a, reason: collision with root package name */
    private final e f٥٩٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f٥٩٢١b;

    /* renamed from: c, reason: collision with root package name */
    private volatile d f٥٩٢٢c;

    /* renamed from: d, reason: collision with root package name */
    private volatile d f٥٩٢٣d;

    /* renamed from: e, reason: collision with root package name */
    private e.a f٥٩٢٤e;

    /* renamed from: f, reason: collision with root package name */
    private e.a f٥٩٢٥f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٥٩٢٦g;

    public k(Object obj, e eVar) {
        e.a aVar = e.a.CLEARED;
        this.f٥٩٢٤e = aVar;
        this.f٥٩٢٥f = aVar;
        this.f٥٩٢١b = obj;
        this.f٥٩٢٠a = eVar;
    }

    private boolean k() {
        e eVar = this.f٥٩٢٠a;
        if (eVar != null && !eVar.c(this)) {
            return false;
        }
        return true;
    }

    private boolean l() {
        e eVar = this.f٥٩٢٠a;
        if (eVar != null && !eVar.i(this)) {
            return false;
        }
        return true;
    }

    private boolean m() {
        e eVar = this.f٥٩٢٠a;
        if (eVar != null && !eVar.b(this)) {
            return false;
        }
        return true;
    }

    @Override // c5.e, c5.d
    public boolean a() {
        boolean z10;
        synchronized (this.f٥٩٢١b) {
            try {
                if (!this.f٥٩٢٣d.a() && !this.f٥٩٢٢c.a()) {
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
        boolean z10;
        synchronized (this.f٥٩٢١b) {
            try {
                if (!m() || (!dVar.equals(this.f٥٩٢٢c) && this.f٥٩٢٤e == e.a.SUCCESS)) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // c5.e
    public boolean c(d dVar) {
        boolean z10;
        synchronized (this.f٥٩٢١b) {
            try {
                if (k() && dVar.equals(this.f٥٩٢٢c) && this.f٥٩٢٤e != e.a.PAUSED) {
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
        synchronized (this.f٥٩٢١b) {
            this.f٥٩٢٦g = false;
            e.a aVar = e.a.CLEARED;
            this.f٥٩٢٤e = aVar;
            this.f٥٩٢٥f = aVar;
            this.f٥٩٢٣d.clear();
            this.f٥٩٢٢c.clear();
        }
    }

    @Override // c5.e
    public void d(d dVar) {
        synchronized (this.f٥٩٢١b) {
            try {
                if (dVar.equals(this.f٥٩٢٣d)) {
                    this.f٥٩٢٥f = e.a.SUCCESS;
                    return;
                }
                this.f٥٩٢٤e = e.a.SUCCESS;
                e eVar = this.f٥٩٢٠a;
                if (eVar != null) {
                    eVar.d(this);
                }
                if (!this.f٥٩٢٥f.c()) {
                    this.f٥٩٢٣d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // c5.d
    public boolean e() {
        boolean z10;
        synchronized (this.f٥٩٢١b) {
            if (this.f٥٩٢٤e == e.a.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // c5.d
    public boolean f(d dVar) {
        if (!(dVar instanceof k)) {
            return false;
        }
        k kVar = (k) dVar;
        if (this.f٥٩٢٢c == null) {
            if (kVar.f٥٩٢٢c != null) {
                return false;
            }
        } else if (!this.f٥٩٢٢c.f(kVar.f٥٩٢٢c)) {
            return false;
        }
        if (this.f٥٩٢٣d == null) {
            if (kVar.f٥٩٢٣d != null) {
                return false;
            }
        } else if (!this.f٥٩٢٣d.f(kVar.f٥٩٢٣d)) {
            return false;
        }
        return true;
    }

    @Override // c5.d
    public boolean g() {
        boolean z10;
        synchronized (this.f٥٩٢١b) {
            if (this.f٥٩٢٤e == e.a.SUCCESS) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // c5.e
    public e getRoot() {
        e eVar;
        synchronized (this.f٥٩٢١b) {
            try {
                e eVar2 = this.f٥٩٢٠a;
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
        synchronized (this.f٥٩٢١b) {
            try {
                if (!dVar.equals(this.f٥٩٢٢c)) {
                    this.f٥٩٢٥f = e.a.FAILED;
                    return;
                }
                this.f٥٩٢٤e = e.a.FAILED;
                e eVar = this.f٥٩٢٠a;
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
        synchronized (this.f٥٩٢١b) {
            try {
                if (l() && dVar.equals(this.f٥٩٢٢c) && !a()) {
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
        synchronized (this.f٥٩٢١b) {
            if (this.f٥٩٢٤e == e.a.RUNNING) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // c5.d
    public void j() {
        synchronized (this.f٥٩٢١b) {
            try {
                this.f٥٩٢٦g = true;
                try {
                    if (this.f٥٩٢٤e != e.a.SUCCESS) {
                        e.a aVar = this.f٥٩٢٥f;
                        e.a aVar2 = e.a.RUNNING;
                        if (aVar != aVar2) {
                            this.f٥٩٢٥f = aVar2;
                            this.f٥٩٢٣d.j();
                        }
                    }
                    if (this.f٥٩٢٦g) {
                        e.a aVar3 = this.f٥٩٢٤e;
                        e.a aVar4 = e.a.RUNNING;
                        if (aVar3 != aVar4) {
                            this.f٥٩٢٤e = aVar4;
                            this.f٥٩٢٢c.j();
                        }
                    }
                    this.f٥٩٢٦g = false;
                } catch (Throwable th) {
                    this.f٥٩٢٦g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void n(d dVar, d dVar2) {
        this.f٥٩٢٢c = dVar;
        this.f٥٩٢٣d = dVar2;
    }

    @Override // c5.d
    public void pause() {
        synchronized (this.f٥٩٢١b) {
            try {
                if (!this.f٥٩٢٥f.c()) {
                    this.f٥٩٢٥f = e.a.PAUSED;
                    this.f٥٩٢٣d.pause();
                }
                if (!this.f٥٩٢٤e.c()) {
                    this.f٥٩٢٤e = e.a.PAUSED;
                    this.f٥٩٢٢c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
