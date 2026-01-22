package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered;

import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.AnsweredPreloadModel;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.data.service.VideoCallService;
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
final class AnsweredHelper$setupObserver$1<T> implements pd.g {
    final /* synthetic */ Function2<String, Throwable, Unit> $disposalError;
    final /* synthetic */ AnsweredHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AnsweredHelper$setupObserver$1(AnsweredHelper answeredHelper, Function2<? super String, ? super Throwable, Unit> function2) {
        this.this$0 = answeredHelper;
        this.$disposalError = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$0(Function2 function2, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (!apiResponse.isOk()) {
            function2.invoke("post first-frame failed: " + apiResponse.getMessage(), new RuntimeException(apiResponse.getMessage()));
            n5.e.c("setupObserver: 告诉服务器首帧收到失败" + apiResponse.getCode() + " " + apiResponse.getMessage() + " ");
        } else {
            n5.e.c("setupObserver: 告诉服务器首帧收到成功");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$1(Function2 function2, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        n5.e.c("setupObserver: 告诉服务器首帧收到异常失败" + th.getLocalizedMessage() + " ");
        function2.invoke("post first-frame failed: " + th.getLocalizedMessage(), th);
        return Unit.INSTANCE;
    }

    public final void accept(Integer num) {
        String str;
        if (num == null) {
            return;
        }
        try {
            if (1048577 == num.intValue()) {
                n5.e.c("setupObserver: 准备告诉服务器首帧");
                VideoCallService shared = VideoCallService.INSTANCE.getShared();
                VideoCallModel preloadModel = this.this$0.getPreloadModel();
                if (preloadModel != null) {
                    AnsweredPreloadModel answeredPreloadModel = preloadModel.getAnsweredPreloadModel();
                    if (answeredPreloadModel != null) {
                        AgoraVideoCallConfig agoraVideoCallConfig = answeredPreloadModel.getAgoraVideoCallConfig();
                        if (agoraVideoCallConfig != null) {
                            str = agoraVideoCallConfig.getVideoUID();
                            if (str == null) {
                            }
                            i0<ApiResponse<Object>> videoCallReady = shared.videoCallReady(str);
                            final Function2<String, Throwable, Unit> function2 = this.$disposalError;
                            Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.e
                                public final Object invoke(Object obj) {
                                    Unit accept$lambda$0;
                                    accept$lambda$0 = AnsweredHelper$setupObserver$1.accept$lambda$0(function2, (ApiResponse) obj);
                                    return accept$lambda$0;
                                }
                            };
                            final Function2<String, Throwable, Unit> function22 = this.$disposalError;
                            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(videoCallReady, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.f
                                public final Object invoke(Object obj) {
                                    Unit accept$lambda$1;
                                    accept$lambda$1 = AnsweredHelper$setupObserver$1.accept$lambda$1(function22, (Throwable) obj);
                                    return accept$lambda$1;
                                }
                            }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
                        }
                    }
                }
                str = "";
                i0<ApiResponse<Object>> videoCallReady2 = shared.videoCallReady(str);
                final Function2 function23 = this.$disposalError;
                Function1 function12 = new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.e
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$0;
                        accept$lambda$0 = AnsweredHelper$setupObserver$1.accept$lambda$0(function23, (ApiResponse) obj);
                        return accept$lambda$0;
                    }
                };
                final Function2 function222 = this.$disposalError;
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(videoCallReady2, function12, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.f
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$1;
                        accept$lambda$1 = AnsweredHelper$setupObserver$1.accept$lambda$1(function222, (Throwable) obj);
                        return accept$lambda$1;
                    }
                }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
            }
        } catch (Exception e) {
            DebugToolsKt.printfE("AnsweredWrapper", "remoteVideoStatusRelay 内部try()catch{}" + e.getLocalizedMessage());
            this.$disposalError.invoke("wait call-ready in channel", e);
        }
    }
}
