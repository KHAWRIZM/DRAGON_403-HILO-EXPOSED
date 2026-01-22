package ld;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.Callable;
import od.b;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile o f١٥٨٧٥a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile o f١٥٨٧٦b;

    static Object a(o oVar, Object obj) {
        try {
            return oVar.apply(obj);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    static h0 b(o oVar, Callable callable) {
        h0 h0Var = (h0) a(oVar, callable);
        if (h0Var != null) {
            return h0Var;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static h0 c(Callable callable) {
        try {
            h0 h0Var = (h0) callable.call();
            if (h0Var != null) {
                return h0Var;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static h0 d(Callable callable) {
        if (callable != null) {
            o oVar = f١٥٨٧٥a;
            if (oVar == null) {
                return c(callable);
            }
            return b(oVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static h0 e(h0 h0Var) {
        if (h0Var != null) {
            o oVar = f١٥٨٧٦b;
            if (oVar == null) {
                return h0Var;
            }
            return (h0) a(oVar, h0Var);
        }
        throw new NullPointerException("scheduler == null");
    }
}
