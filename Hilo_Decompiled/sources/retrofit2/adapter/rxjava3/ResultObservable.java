package retrofit2.adapter.rxjava3;

import ie.a;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import nd.c;
import od.b;
import retrofit2.Response;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class ResultObservable<T> extends z<Result<T>> {
    private final z<Response<T>> upstream;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    private static class ResultObserver<R> implements g0 {
        private final g0 observer;

        ResultObserver(g0 g0Var) {
            this.observer = g0Var;
        }

        public void onComplete() {
            this.observer.onComplete();
        }

        public void onError(Throwable th) {
            try {
                this.observer.onNext(Result.error(th));
                this.observer.onComplete();
            } catch (Throwable th2) {
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    b.b(th3);
                    a.s(new od.a(new Throwable[]{th2, th3}));
                }
            }
        }

        public void onSubscribe(c cVar) {
            this.observer.onSubscribe(cVar);
        }

        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultObservable(z<Response<T>> zVar) {
        this.upstream = zVar;
    }

    protected void subscribeActual(g0 g0Var) {
        this.upstream.subscribe(new ResultObserver(g0Var));
    }
}
