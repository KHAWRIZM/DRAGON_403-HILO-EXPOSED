package com.qiahao.nextvideo.utilities;

import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qhqc.lib.indicate.IndicateService;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.network.AppServer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.utilities.AppRequestUtils$serviceDeviceID$1", f = "AppRequestUtils.kt", i = {}, l = {504}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AppRequestUtils$serviceDeviceID$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppRequestUtils$serviceDeviceID$1(Continuation<? super AppRequestUtils$serviceDeviceID$1> continuation) {
        super(2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(ApiResponse apiResponse) {
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        String str = (String) apiResponse.getData();
        if (str == null) {
            str = "";
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "service_device_Id", str, (String) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppRequestUtils$serviceDeviceID$1 appRequestUtils$serviceDeviceID$1 = new AppRequestUtils$serviceDeviceID$1(continuation);
        appRequestUtils$serviceDeviceID$1.L$0 = obj;
        return appRequestUtils$serviceDeviceID$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IndicateService companion = IndicateService.Companion.getInstance();
            this.label = 1;
            obj = companion.getIndicateSync(coroutineScope, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().serviceDeviceID((String) obj), new Function1() { // from class: com.qiahao.nextvideo.utilities.e0
            public final Object invoke(Object obj2) {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = AppRequestUtils$serviceDeviceID$1.invokeSuspend$lambda$0((ApiResponse) obj2);
                return invokeSuspend$lambda$0;
            }
        }, (Function1) null, (Function0) null, false, 14, (Object) null), AppRequestUtils.INSTANCE.getMCompositeDisposable());
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
