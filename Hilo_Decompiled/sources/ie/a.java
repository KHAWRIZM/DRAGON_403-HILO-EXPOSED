package ie;

import fe.j;
import io.reactivex.rxjava3.core.b;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.h0;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.l;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import od.d;
import od.f;
import pd.c;
import pd.g;
import pd.o;
import pd.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile g f١٤٩٢٠a;

    /* renamed from: b, reason: collision with root package name */
    static volatile o f١٤٩٢١b;

    /* renamed from: c, reason: collision with root package name */
    static volatile o f١٤٩٢٢c;

    /* renamed from: d, reason: collision with root package name */
    static volatile o f١٤٩٢٣d;

    /* renamed from: e, reason: collision with root package name */
    static volatile o f١٤٩٢٤e;

    /* renamed from: f, reason: collision with root package name */
    static volatile o f١٤٩٢٥f;

    /* renamed from: g, reason: collision with root package name */
    static volatile o f١٤٩٢٦g;

    /* renamed from: h, reason: collision with root package name */
    static volatile o f١٤٩٢٧h;

    /* renamed from: i, reason: collision with root package name */
    static volatile o f١٤٩٢٨i;

    /* renamed from: j, reason: collision with root package name */
    static volatile o f١٤٩٢٩j;

    /* renamed from: k, reason: collision with root package name */
    static volatile o f١٤٩٣٠k;

    /* renamed from: l, reason: collision with root package name */
    static volatile o f١٤٩٣١l;

    /* renamed from: m, reason: collision with root package name */
    static volatile o f١٤٩٣٢m;

    /* renamed from: n, reason: collision with root package name */
    static volatile o f١٤٩٣٣n;

    /* renamed from: o, reason: collision with root package name */
    static volatile c f١٤٩٣٤o;

    /* renamed from: p, reason: collision with root package name */
    static volatile c f١٤٩٣٥p;

    /* renamed from: q, reason: collision with root package name */
    static volatile c f١٤٩٣٦q;

    /* renamed from: r, reason: collision with root package name */
    static volatile c f١٤٩٣٧r;

    /* renamed from: s, reason: collision with root package name */
    static volatile c f١٤٩٣٨s;

    /* renamed from: t, reason: collision with root package name */
    static volatile boolean f١٤٩٣٩t;

    /* renamed from: u, reason: collision with root package name */
    static volatile boolean f١٤٩٤٠u;

    public static void A(g gVar) {
        if (!f١٤٩٣٩t) {
            f١٤٩٢٠a = gVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void B(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static Object a(c cVar, Object obj, Object obj2) {
        try {
            return cVar.apply(obj, obj2);
        } catch (Throwable th) {
            throw j.g(th);
        }
    }

    static Object b(o oVar, Object obj) {
        try {
            return oVar.apply(obj);
        } catch (Throwable th) {
            throw j.g(th);
        }
    }

    static h0 c(o oVar, r rVar) {
        Object b10 = b(oVar, rVar);
        Objects.requireNonNull(b10, "Scheduler Supplier result can't be null");
        return (h0) b10;
    }

    static h0 d(r rVar) {
        try {
            Object obj = rVar.get();
            Objects.requireNonNull(obj, "Scheduler Supplier result can't be null");
            return (h0) obj;
        } catch (Throwable th) {
            throw j.g(th);
        }
    }

    public static h0 e(r rVar) {
        Objects.requireNonNull(rVar, "Scheduler Supplier can't be null");
        o oVar = f١٤٩٢٢c;
        if (oVar == null) {
            return d(rVar);
        }
        return c(oVar, rVar);
    }

    public static h0 f(r rVar) {
        Objects.requireNonNull(rVar, "Scheduler Supplier can't be null");
        o oVar = f١٤٩٢٤e;
        if (oVar == null) {
            return d(rVar);
        }
        return c(oVar, rVar);
    }

    public static h0 g(r rVar) {
        Objects.requireNonNull(rVar, "Scheduler Supplier can't be null");
        o oVar = f١٤٩٢٥f;
        if (oVar == null) {
            return d(rVar);
        }
        return c(oVar, rVar);
    }

    public static h0 h(r rVar) {
        Objects.requireNonNull(rVar, "Scheduler Supplier can't be null");
        o oVar = f١٤٩٢٣d;
        if (oVar == null) {
            return d(rVar);
        }
        return c(oVar, rVar);
    }

    static boolean i(Throwable th) {
        if ((th instanceof d) || (th instanceof od.c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof od.a)) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        return f١٤٩٤٠u;
    }

    public static ge.a k(ge.a aVar) {
        o oVar = f١٤٩٣٠k;
        if (oVar != null) {
            return (ge.a) b(oVar, aVar);
        }
        return aVar;
    }

    public static b l(b bVar) {
        o oVar = f١٤٩٣٣n;
        if (oVar != null) {
            return (b) b(oVar, bVar);
        }
        return bVar;
    }

    public static h m(h hVar) {
        o oVar = f١٤٩٢٨i;
        if (oVar != null) {
            return (h) b(oVar, hVar);
        }
        return hVar;
    }

    public static io.reactivex.rxjava3.core.j n(io.reactivex.rxjava3.core.j jVar) {
        o oVar = f١٤٩٣١l;
        if (oVar != null) {
            return (io.reactivex.rxjava3.core.j) b(oVar, jVar);
        }
        return jVar;
    }

    public static z o(z zVar) {
        o oVar = f١٤٩٢٩j;
        if (oVar != null) {
            return (z) b(oVar, zVar);
        }
        return zVar;
    }

    public static i0 p(i0 i0Var) {
        o oVar = f١٤٩٣٢m;
        if (oVar != null) {
            return (i0) b(oVar, i0Var);
        }
        return i0Var;
    }

    public static boolean q() {
        return false;
    }

    public static h0 r(h0 h0Var) {
        o oVar = f١٤٩٢٦g;
        if (oVar == null) {
            return h0Var;
        }
        return (h0) b(oVar, h0Var);
    }

    public static void s(Throwable th) {
        g gVar = f١٤٩٢٠a;
        if (th == null) {
            th = j.b("onError called with a null Throwable.");
        } else if (!i(th)) {
            th = new f(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                B(th2);
            }
        }
        th.printStackTrace();
        B(th);
    }

    public static h0 t(h0 h0Var) {
        o oVar = f١٤٩٢٧h;
        if (oVar == null) {
            return h0Var;
        }
        return (h0) b(oVar, h0Var);
    }

    public static Runnable u(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        o oVar = f١٤٩٢١b;
        if (oVar == null) {
            return runnable;
        }
        return (Runnable) b(oVar, runnable);
    }

    public static io.reactivex.rxjava3.core.d v(b bVar, io.reactivex.rxjava3.core.d dVar) {
        c cVar = f١٤٩٣٨s;
        if (cVar != null) {
            return (io.reactivex.rxjava3.core.d) a(cVar, bVar, dVar);
        }
        return dVar;
    }

    public static l w(io.reactivex.rxjava3.core.j jVar, l lVar) {
        c cVar = f١٤٩٣٥p;
        if (cVar != null) {
            return (l) a(cVar, jVar, lVar);
        }
        return lVar;
    }

    public static g0 x(z zVar, g0 g0Var) {
        c cVar = f١٤٩٣٦q;
        if (cVar != null) {
            return (g0) a(cVar, zVar, g0Var);
        }
        return g0Var;
    }

    public static k0 y(i0 i0Var, k0 k0Var) {
        c cVar = f١٤٩٣٧r;
        if (cVar != null) {
            return (k0) a(cVar, i0Var, k0Var);
        }
        return k0Var;
    }

    public static kf.b z(h hVar, kf.b bVar) {
        c cVar = f١٤٩٣٤o;
        if (cVar != null) {
            return (kf.b) a(cVar, hVar, bVar);
        }
        return bVar;
    }
}
