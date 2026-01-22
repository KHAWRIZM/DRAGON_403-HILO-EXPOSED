package retrofit2.adapter.rxjava3;

import ie.a;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import nd.c;
import od.b;
import retrofit2.Response;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class BodyObservable<T> extends z<T> {
    private final z<Response<T>> upstream;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    private static class BodyObserver<R> implements g0 {
        private final g0 observer;
        private boolean terminated;

        BodyObserver(g0 g0Var) {
            this.observer = g0Var;
        }

        public void onComplete() {
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.terminated) {
                this.observer.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            a.s(assertionError);
        }

        public void onSubscribe(c cVar) {
            this.observer.onSubscribe(cVar);
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th) {
                b.b(th);
                a.s(new od.a(new Throwable[]{httpException, th}));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BodyObservable(z<Response<T>> zVar) {
        this.upstream = zVar;
    }

    protected void subscribeActual(g0 g0Var) {
        this.upstream.subscribe(new BodyObserver(g0Var));
    }
}
