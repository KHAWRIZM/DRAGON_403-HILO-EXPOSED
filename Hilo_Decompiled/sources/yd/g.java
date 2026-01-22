package yd;

import ae.k;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.m0;
import io.reactivex.rxjava3.core.n;
import java.util.Objects;
import pd.o;
import pd.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
abstract class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Object obj, o oVar, io.reactivex.rxjava3.core.d dVar) {
        io.reactivex.rxjava3.core.f fVar;
        if (obj instanceof r) {
            try {
                Object obj2 = ((r) obj).get();
                if (obj2 != null) {
                    Object apply = oVar.apply(obj2);
                    Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                    fVar = (io.reactivex.rxjava3.core.f) apply;
                } else {
                    fVar = null;
                }
                if (fVar == null) {
                    qd.d.c(dVar);
                } else {
                    fVar.a(dVar);
                }
                return true;
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.e(th, dVar);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Object obj, o oVar, g0 g0Var) {
        n nVar;
        if (obj instanceof r) {
            try {
                Object obj2 = ((r) obj).get();
                if (obj2 != null) {
                    Object apply = oVar.apply(obj2);
                    Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                    nVar = (n) apply;
                } else {
                    nVar = null;
                }
                if (nVar == null) {
                    qd.d.d(g0Var);
                } else {
                    nVar.a(xd.c.d(g0Var));
                }
                return true;
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.f(th, g0Var);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Object obj, o oVar, g0 g0Var) {
        m0 m0Var;
        if (obj instanceof r) {
            try {
                Object obj2 = ((r) obj).get();
                if (obj2 != null) {
                    Object apply = oVar.apply(obj2);
                    Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                    m0Var = (m0) apply;
                } else {
                    m0Var = null;
                }
                if (m0Var == null) {
                    qd.d.d(g0Var);
                } else {
                    m0Var.a(k.d(g0Var));
                }
                return true;
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.f(th, g0Var);
                return true;
            }
        }
        return false;
    }
}
