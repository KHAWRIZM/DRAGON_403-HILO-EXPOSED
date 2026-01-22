package m8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import k8.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b extends c {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Future f١٥٩٩٤a;

        /* renamed from: b, reason: collision with root package name */
        final m8.a f١٥٩٩٥b;

        a(Future future, m8.a aVar) {
            this.f١٥٩٩٤a = future;
            this.f١٥٩٩٥b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f١٥٩٩٥b.onSuccess(b.b(this.f١٥٩٩٤a));
            } catch (Error e10) {
                e = e10;
                this.f١٥٩٩٥b.onFailure(e);
            } catch (RuntimeException e11) {
                e = e11;
                this.f١٥٩٩٥b.onFailure(e);
            } catch (ExecutionException e12) {
                this.f١٥٩٩٥b.onFailure(e12.getCause());
            }
        }

        public String toString() {
            return k8.d.a(this).c(this.f١٥٩٩٥b).toString();
        }
    }

    public static void a(d dVar, m8.a aVar, Executor executor) {
        h.i(aVar);
        dVar.addListener(new a(dVar, aVar), executor);
    }

    public static Object b(Future future) {
        h.p(future.isDone(), "Future was expected to be done: %s", future);
        return e.a(future);
    }
}
