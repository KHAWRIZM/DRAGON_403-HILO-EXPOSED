package retrofit2.adapter.rxjava3;

import ie.a;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import nd.c;
import od.b;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class CallExecuteObservable<T> extends z<Response<T>> {
    private final Call<T> originalCall;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    private static final class CallDisposable implements c {
        private final Call<?> call;
        private volatile boolean disposed;

        CallDisposable(Call<?> call) {
            this.call = call;
        }

        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    protected void subscribeActual(g0 g0Var) {
        boolean z;
        Call<T> clone = this.originalCall.clone();
        CallDisposable callDisposable = new CallDisposable(clone);
        g0Var.onSubscribe(callDisposable);
        if (callDisposable.isDisposed()) {
            return;
        }
        try {
            Response<T> execute = clone.execute();
            if (!callDisposable.isDisposed()) {
                g0Var.onNext(execute);
            }
            if (!callDisposable.isDisposed()) {
                try {
                    g0Var.onComplete();
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    b.b(th);
                    if (z) {
                        a.s(th);
                        return;
                    }
                    if (!callDisposable.isDisposed()) {
                        try {
                            g0Var.onError(th);
                        } catch (Throwable th2) {
                            b.b(th2);
                            a.s(new od.a(new Throwable[]{th, th2}));
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
