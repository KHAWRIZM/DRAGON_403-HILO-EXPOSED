package g5;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final g f١٤٤٢٥a = new C٠١٦٤a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements d {
        b() {
        }

        @Override // g5.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements g {
        c() {
        }

        @Override // g5.a.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            list.clear();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface d {
        Object a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e implements Pools.Pool {

        /* renamed from: a, reason: collision with root package name */
        private final d f١٤٤٢٦a;

        /* renamed from: b, reason: collision with root package name */
        private final g f١٤٤٢٧b;

        /* renamed from: c, reason: collision with root package name */
        private final Pools.Pool f١٤٤٢٨c;

        e(Pools.Pool pool, d dVar, g gVar) {
            this.f١٤٤٢٨c = pool;
            this.f١٤٤٢٦a = dVar;
            this.f١٤٤٢٧b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public Object acquire() {
            Object acquire = this.f١٤٤٢٨c.acquire();
            if (acquire == null) {
                acquire = this.f١٤٤٢٦a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof f) {
                ((f) acquire).a().b(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(Object obj) {
            if (obj instanceof f) {
                ((f) obj).a().b(true);
            }
            this.f١٤٤٢٧b.a(obj);
            return this.f١٤٤٢٨c.release(obj);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface f {
        g5.c a();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface g {
        void a(Object obj);
    }

    private static Pools.Pool a(Pools.Pool pool, d dVar) {
        return b(pool, dVar, c());
    }

    private static Pools.Pool b(Pools.Pool pool, d dVar, g gVar) {
        return new e(pool, dVar, gVar);
    }

    private static g c() {
        return f١٤٤٢٥a;
    }

    public static Pools.Pool d(int i10, d dVar) {
        return a(new Pools.SynchronizedPool(i10), dVar);
    }

    public static Pools.Pool e() {
        return f(20);
    }

    public static Pools.Pool f(int i10) {
        return b(new Pools.SynchronizedPool(i10), new b(), new c());
    }

    /* renamed from: g5.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١٦٤a implements g {
        C٠١٦٤a() {
        }

        @Override // g5.a.g
        public void a(Object obj) {
        }
    }
}
