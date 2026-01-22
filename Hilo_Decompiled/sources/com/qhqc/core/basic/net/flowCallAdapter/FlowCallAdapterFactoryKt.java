package com.qhqc.core.basic.net.flowCallAdapter;

import com.qhqc.core.basic.net.flowCallAdapter.async.AsyncBodyFlowCallAdapter;
import com.qhqc.core.basic.net.flowCallAdapter.async.AsyncResponseFlowCallAdapter;
import com.qhqc.core.basic.net.flowCallAdapter.sync.BodyFlowCallAdapter;
import com.qhqc.core.basic.net.flowCallAdapter.sync.ResponseFlowCallAdapter;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import retrofit2.CallAdapter;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a0\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\t"}, d2 = {"createBodyFlowCallAdapter", "Lretrofit2/CallAdapter;", "Ljava/lang/reflect/Type;", "Lkotlinx/coroutines/flow/Flow;", "async", "", "responseBodyType", "createResponseFlowCallAdapter", "Lretrofit2/Response;", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FlowCallAdapterFactoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CallAdapter<Type, ? extends Flow<?>> createBodyFlowCallAdapter(boolean z10, Type type) {
        if (z10) {
            return new AsyncBodyFlowCallAdapter(type);
        }
        return new BodyFlowCallAdapter(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallAdapter<Type, Flow<Response<Type>>> createResponseFlowCallAdapter(boolean z10, Type type) {
        if (z10) {
            return new AsyncResponseFlowCallAdapter(type);
        }
        return new ResponseFlowCallAdapter(type);
    }
}
