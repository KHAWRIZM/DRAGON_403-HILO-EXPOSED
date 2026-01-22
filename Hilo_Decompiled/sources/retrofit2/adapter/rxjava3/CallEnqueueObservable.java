package retrofit2.adapter.rxjava3;

import ie.a;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import nd.c;
import od.b;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class CallEnqueueObservable<T> extends z<Response<T>> {
    private final Call<T> originalCall;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    private static final class CallCallback<T> implements c, Callback<T> {
        private final Call<?> call;
        private volatile boolean disposed;
        private final g0 observer;
        boolean terminated = false;

        CallCallback(Call<?> call, g0 g0Var) {
            this.call = call;
            this.observer = g0Var;
        }

        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(th);
            } catch (Throwable th2) {
                b.b(th2);
                a.s(new od.a(new Throwable[]{th, th2}));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (this.disposed) {
                return;
            }
            try {
                this.observer.onNext(response);
                if (!this.disposed) {
                    this.terminated = true;
                    this.observer.onComplete();
                }
            } catch (Throwable th) {
                b.b(th);
                if (this.terminated) {
                    a.s(th);
                    return;
                }
                if (!this.disposed) {
                    try {
                        this.observer.onError(th);
                    } catch (Throwable th2) {
                        b.b(th2);
                        a.s(new od.a(new Throwable[]{th, th2}));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    protected void subscribeActual(g0 g0Var) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, g0Var);
        g0Var.onSubscribe(callCallback);
        if (!callCallback.isDisposed()) {
            clone.enqueue(callCallback);
        }
    }
}
