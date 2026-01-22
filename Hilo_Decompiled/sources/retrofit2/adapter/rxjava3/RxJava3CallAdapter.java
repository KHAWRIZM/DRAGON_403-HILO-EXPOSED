package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.core.a;
import io.reactivex.rxjava3.core.h0;
import io.reactivex.rxjava3.core.z;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
final class RxJava3CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final h0 scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxJava3CallAdapter(Type type, h0 h0Var, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.responseType = type;
        this.scheduler = h0Var;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isFlowable = z4;
        this.isSingle = z5;
        this.isMaybe = z6;
        this.isCompletable = z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // retrofit2.CallAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object adapt(Call<R> call) {
        z callExecuteObservable;
        z bodyObservable;
        h0 h0Var;
        if (this.isAsync) {
            callExecuteObservable = new CallEnqueueObservable(call);
        } else {
            callExecuteObservable = new CallExecuteObservable(call);
        }
        if (this.isResult) {
            bodyObservable = new ResultObservable(callExecuteObservable);
        } else {
            if (this.isBody) {
                bodyObservable = new BodyObservable(callExecuteObservable);
            }
            h0Var = this.scheduler;
            if (h0Var != null) {
                callExecuteObservable = callExecuteObservable.subscribeOn(h0Var);
            }
            if (!this.isFlowable) {
                return callExecuteObservable.toFlowable(a.e);
            }
            if (this.isSingle) {
                return callExecuteObservable.singleOrError();
            }
            if (this.isMaybe) {
                return callExecuteObservable.singleElement();
            }
            if (this.isCompletable) {
                return callExecuteObservable.ignoreElements();
            }
            return ie.a.o(callExecuteObservable);
        }
        callExecuteObservable = bodyObservable;
        h0Var = this.scheduler;
        if (h0Var != null) {
        }
        if (!this.isFlowable) {
        }
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
