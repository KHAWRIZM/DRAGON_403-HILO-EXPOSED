package androidx.concurrent.futures;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        Object f١٧٧٢a;

        /* renamed from: b, reason: collision with root package name */
        d f١٧٧٣b;

        /* renamed from: c, reason: collision with root package name */
        private e f١٧٧٤c = e.j();

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٧٧٥d;

        a() {
        }

        private void d() {
            this.f١٧٧٢a = null;
            this.f١٧٧٣b = null;
            this.f١٧٧٤c = null;
        }

        void a() {
            this.f١٧٧٢a = null;
            this.f١٧٧٣b = null;
            this.f١٧٧٤c.set(null);
        }

        public boolean b(Object obj) {
            boolean z10 = true;
            this.f١٧٧٥d = true;
            d dVar = this.f١٧٧٣b;
            if (dVar == null || !dVar.b(obj)) {
                z10 = false;
            }
            if (z10) {
                d();
            }
            return z10;
        }

        public boolean c() {
            boolean z10 = true;
            this.f١٧٧٥d = true;
            d dVar = this.f١٧٧٣b;
            if (dVar == null || !dVar.a(true)) {
                z10 = false;
            }
            if (z10) {
                d();
            }
            return z10;
        }

        public boolean e(Throwable th) {
            boolean z10 = true;
            this.f١٧٧٥d = true;
            d dVar = this.f١٧٧٣b;
            if (dVar == null || !dVar.c(th)) {
                z10 = false;
            }
            if (z10) {
                d();
            }
            return z10;
        }

        protected void finalize() {
            e eVar;
            d dVar = this.f١٧٧٣b;
            if (dVar != null && !dVar.isDone()) {
                dVar.c(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f١٧٧٢a));
            }
            if (!this.f١٧٧٥d && (eVar = this.f١٧٧٤c) != null) {
                eVar.set(null);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static final class b extends Throwable {
        b(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: androidx.concurrent.futures.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface InterfaceC٠٠١٥c {
        Object a(a aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class d implements m8.d {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference f١٧٧٦a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.concurrent.futures.a f١٧٧٧b = new a();

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a extends androidx.concurrent.futures.a {
            a() {
            }

            @Override // androidx.concurrent.futures.a
            protected String pendingToString() {
                a aVar = (a) d.this.f١٧٧٦a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f١٧٧٢a + "]";
            }
        }

        d(a aVar) {
            this.f١٧٧٦a = new WeakReference(aVar);
        }

        boolean a(boolean z10) {
            return this.f١٧٧٧b.cancel(z10);
        }

        @Override // m8.d
        public void addListener(Runnable runnable, Executor executor) {
            this.f١٧٧٧b.addListener(runnable, executor);
        }

        boolean b(Object obj) {
            return this.f١٧٧٧b.set(obj);
        }

        boolean c(Throwable th) {
            return this.f١٧٧٧b.setException(th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            a aVar = (a) this.f١٧٧٦a.get();
            boolean cancel = this.f١٧٧٧b.cancel(z10);
            if (cancel && aVar != null) {
                aVar.a();
            }
            return cancel;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.f١٧٧٧b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f١٧٧٧b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f١٧٧٧b.isDone();
        }

        public String toString() {
            return this.f١٧٧٧b.toString();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j10, TimeUnit timeUnit) {
            return this.f١٧٧٧b.get(j10, timeUnit);
        }
    }

    public static m8.d a(InterfaceC٠٠١٥c r32) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.f١٧٧٣b = dVar;
        aVar.f١٧٧٢a = r32.getClass();
        try {
            Object a10 = r32.a(aVar);
            if (a10 != null) {
                aVar.f١٧٧٢a = a10;
            }
        } catch (Exception e10) {
            dVar.c(e10);
        }
        return dVar;
    }
}
