package td;

import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class p extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final CompletionStage f١٨١٩٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements BiConsumer {
        private static final long serialVersionUID = 45838553147237545L;

        a() {
        }

        @Override // java.util.function.BiConsumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Object obj, Throwable th) {
            BiConsumer a10 = o.a(get());
            if (a10 != null) {
                a10.accept(obj, th);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends ud.j implements BiConsumer {
        private static final long serialVersionUID = 4665335664328839859L;

        /* renamed from: c, reason: collision with root package name */
        final a f١٨١٩٨c;

        b(g0 g0Var, a aVar) {
            super(g0Var);
            this.f١٨١٩٨c = aVar;
        }

        @Override // ud.j, nd.c
        public void dispose() {
            super.dispose();
            this.f١٨١٩٨c.set(null);
        }

        @Override // java.util.function.BiConsumer
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void accept(Object obj, Throwable th) {
            if (th != null) {
                this.f١٨٢٩٩a.onError(th);
            } else if (obj != null) {
                c(obj);
            } else {
                this.f١٨٢٩٩a.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }
    }

    public p(CompletionStage completionStage) {
        this.f١٨١٩٧a = completionStage;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        a aVar = new a();
        b bVar = new b(g0Var, aVar);
        aVar.lazySet(bVar);
        g0Var.onSubscribe(bVar);
        this.f١٨١٩٧a.whenComplete(aVar);
    }
}
