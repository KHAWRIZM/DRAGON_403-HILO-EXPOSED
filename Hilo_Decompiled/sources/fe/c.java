package fe;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c extends AtomicReference {
    private static final long serialVersionUID = 3949248817947090603L;

    public Throwable a() {
        return j.e(this);
    }

    public boolean b(Throwable th) {
        return j.a(this, th);
    }

    public boolean c(Throwable th) {
        if (b(th)) {
            return true;
        }
        ie.a.s(th);
        return false;
    }

    public void d() {
        Throwable a10 = a();
        if (a10 != null && a10 != j.f١٤٣٠٦a) {
            ie.a.s(a10);
        }
    }

    public void e(io.reactivex.rxjava3.core.d dVar) {
        Throwable a10 = a();
        if (a10 == null) {
            dVar.onComplete();
        } else if (a10 != j.f١٤٣٠٦a) {
            dVar.onError(a10);
        }
    }

    public void f(g0 g0Var) {
        Throwable a10 = a();
        if (a10 == null) {
            g0Var.onComplete();
        } else if (a10 != j.f١٤٣٠٦a) {
            g0Var.onError(a10);
        }
    }

    public void g(kf.b bVar) {
        Throwable a10 = a();
        if (a10 == null) {
            bVar.onComplete();
        } else if (a10 != j.f١٤٣٠٦a) {
            bVar.onError(a10);
        }
    }
}
