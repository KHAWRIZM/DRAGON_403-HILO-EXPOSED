package nd;

import fe.j;
import fe.o;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a implements c, d {

    /* renamed from: a, reason: collision with root package name */
    o f١٦٤٠٦a;

    /* renamed from: b, reason: collision with root package name */
    volatile boolean f١٦٤٠٧b;

    @Override // nd.d
    public boolean a(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (!this.f١٦٤٠٧b) {
            synchronized (this) {
                try {
                    if (!this.f١٦٤٠٧b) {
                        o oVar = this.f١٦٤٠٦a;
                        if (oVar == null) {
                            oVar = new o();
                            this.f١٦٤٠٦a = oVar;
                        }
                        oVar.a(cVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cVar.dispose();
        return false;
    }

    @Override // nd.d
    public boolean b(c cVar) {
        if (c(cVar)) {
            cVar.dispose();
            return true;
        }
        return false;
    }

    @Override // nd.d
    public boolean c(c cVar) {
        Objects.requireNonNull(cVar, "disposable is null");
        if (this.f١٦٤٠٧b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f١٦٤٠٧b) {
                    return false;
                }
                o oVar = this.f١٦٤٠٦a;
                if (oVar != null && oVar.e(cVar)) {
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void d() {
        if (this.f١٦٤٠٧b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٦٤٠٧b) {
                    return;
                }
                o oVar = this.f١٦٤٠٦a;
                this.f١٦٤٠٦a = null;
                e(oVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // nd.c
    public void dispose() {
        if (this.f١٦٤٠٧b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f١٦٤٠٧b) {
                    return;
                }
                this.f١٦٤٠٧b = true;
                o oVar = this.f١٦٤٠٦a;
                this.f١٦٤٠٦a = null;
                e(oVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void e(o oVar) {
        if (oVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : oVar.b()) {
            if (obj instanceof c) {
                try {
                    ((c) obj).dispose();
                } catch (Throwable th) {
                    od.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                throw j.g((Throwable) arrayList.get(0));
            }
            throw new od.a(arrayList);
        }
    }

    public int f() {
        int i10 = 0;
        if (this.f١٦٤٠٧b) {
            return 0;
        }
        synchronized (this) {
            try {
                if (this.f١٦٤٠٧b) {
                    return 0;
                }
                o oVar = this.f١٦٤٠٦a;
                if (oVar != null) {
                    i10 = oVar.g();
                }
                return i10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f١٦٤٠٧b;
    }
}
