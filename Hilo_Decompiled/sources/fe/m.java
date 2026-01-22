package fe;

import io.reactivex.rxjava3.core.g0;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public enum m {
    COMPLETE;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: a, reason: collision with root package name */
        final nd.c f١٤٣١١a;

        a(nd.c cVar) {
            this.f١٤٣١١a = cVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f١٤٣١١a + "]";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: a, reason: collision with root package name */
        final Throwable f١٤٣١٢a;

        b(Throwable th) {
            this.f١٤٣١٢a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return Objects.equals(this.f١٤٣١٢a, ((b) obj).f١٤٣١٢a);
            }
            return false;
        }

        public int hashCode() {
            return this.f١٤٣١٢a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f١٤٣١٢a + "]";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;

        /* renamed from: a, reason: collision with root package name */
        final kf.c f١٤٣١٣a;

        c(kf.c cVar) {
            this.f١٤٣١٣a = cVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f١٤٣١٣a + "]";
        }
    }

    public static boolean a(Object obj, g0 g0Var) {
        if (obj == COMPLETE) {
            g0Var.onComplete();
            return true;
        }
        if (obj instanceof b) {
            g0Var.onError(((b) obj).f١٤٣١٢a);
            return true;
        }
        g0Var.onNext(obj);
        return false;
    }

    public static boolean c(Object obj, g0 g0Var) {
        if (obj == COMPLETE) {
            g0Var.onComplete();
            return true;
        }
        if (obj instanceof b) {
            g0Var.onError(((b) obj).f١٤٣١٢a);
            return true;
        }
        if (obj instanceof a) {
            g0Var.onSubscribe(((a) obj).f١٤٣١١a);
            return false;
        }
        g0Var.onNext(obj);
        return false;
    }

    public static boolean d(Object obj, kf.b bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            bVar.onError(((b) obj).f١٤٣١٢a);
            return true;
        }
        if (obj instanceof c) {
            bVar.onSubscribe(((c) obj).f١٤٣١٣a);
            return false;
        }
        bVar.onNext(obj);
        return false;
    }

    public static Object e() {
        return COMPLETE;
    }

    public static Object f(nd.c cVar) {
        return new a(cVar);
    }

    public static Object g(Throwable th) {
        return new b(th);
    }

    public static Throwable h(Object obj) {
        return ((b) obj).f١٤٣١٢a;
    }

    public static boolean j(Object obj) {
        if (obj == COMPLETE) {
            return true;
        }
        return false;
    }

    public static boolean k(Object obj) {
        return obj instanceof b;
    }

    public static Object m(kf.c cVar) {
        return new c(cVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object i(Object obj) {
        return obj;
    }

    public static Object l(Object obj) {
        return obj;
    }
}
