package com.qiahao.nextvideo.ui.home.matching.view;

import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.paired.MatchingActionPendingUIModel;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class MatchingPendingViewWrapper$subscribeRemoteVideoFirstFrame$1<T> implements pd.g {
    final /* synthetic */ Function2<String, Throwable, Unit> $disposalError;
    final /* synthetic */ MatchingActionPendingUIModel $uiModel;
    final /* synthetic */ MatchingPendingViewWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public MatchingPendingViewWrapper$subscribeRemoteVideoFirstFrame$1(MatchingActionPendingUIModel matchingActionPendingUIModel, MatchingPendingViewWrapper matchingPendingViewWrapper, Function2<? super String, ? super Throwable, Unit> function2) {
        this.$uiModel = matchingActionPendingUIModel;
        this.this$0 = matchingPendingViewWrapper;
        this.$disposalError = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$0(Function2 function2, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (!apiResponse.isOk()) {
            function2.invoke("匹配后发送第一帧给后端失败post first-frame failed: " + apiResponse.getMessage(), new RuntimeException(apiResponse.getMessage()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$1(Function2 function2, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        function2.invoke("匹配后发送第一帧后端失败post first-frame failed: " + th.getLocalizedMessage(), th);
        return Unit.INSTANCE;
    }

    public final void accept(Integer num) {
        if (num == null) {
            return;
        }
        try {
            if (1048577 == num.intValue()) {
                i0<ApiResponse<Object>> dispatchEventInRoomName = UserService.INSTANCE.getShared().dispatchEventInRoomName(this.$uiModel.getMatchUniqueID());
                final Function2<String, Throwable, Unit> function2 = this.$disposalError;
                Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.view.i
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$0;
                        accept$lambda$0 = MatchingPendingViewWrapper$subscribeRemoteVideoFirstFrame$1.accept$lambda$0(function2, (ApiResponse) obj);
                        return accept$lambda$0;
                    }
                };
                final Function2<String, Throwable, Unit> function22 = this.$disposalError;
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(dispatchEventInRoomName, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.view.j
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$1;
                        accept$lambda$1 = MatchingPendingViewWrapper$subscribeRemoteVideoFirstFrame$1.accept$lambda$1(function22, (Throwable) obj);
                        return accept$lambda$1;
                    }
                }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
            }
        } catch (Exception e) {
            DebugToolsKt.printfE(MatchingPendingViewWrapper.INSTANCE.getTAG(), "remoteVideoStatusRelay内部try()catch{}" + e.getLocalizedMessage());
            this.$disposalError.invoke("匹配后等待频道中的通话准备 wait call-ready in channel", e);
        }
    }
}
