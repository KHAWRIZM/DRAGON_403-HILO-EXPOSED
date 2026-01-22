package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed;

import android.util.Log;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.DialedPreloadModel;
import com.qiahao.nextvideo.data.service.VideoCallService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DialedWrapper$setupObserver$1<T> implements pd.g {
    final /* synthetic */ Function2<String, Throwable, Unit> $disposalError;
    final /* synthetic */ DialedWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DialedWrapper$setupObserver$1(DialedWrapper dialedWrapper, Function2<? super String, ? super Throwable, Unit> function2) {
        this.this$0 = dialedWrapper;
        this.$disposalError = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$0(Function2 function2, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (!apiResponse.isOk()) {
            Log.d(AgoraRtcService.TAG, "setupObserver: 告诉服务器首帧收到失败" + apiResponse.getCode() + " " + apiResponse.getMessage() + " ");
            String message = apiResponse.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("post first-frame failed: ");
            sb2.append(message);
            function2.invoke(sb2.toString(), new RuntimeException(apiResponse.getMessage()));
        } else {
            Log.d(AgoraRtcService.TAG, "setupObserver: 告诉服务器首帧收到成功");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accept$lambda$1(Function2 function2, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(AgoraRtcService.TAG, "setupObserver: 告诉服务器首帧收到失败异常" + th.getLocalizedMessage() + " ");
        function2.invoke("post first-frame failed: " + th.getLocalizedMessage(), th);
        return Unit.INSTANCE;
    }

    public final void accept(Integer num) {
        DialedPreloadModel dialedPreloadModel;
        if (num == null) {
            return;
        }
        try {
            if (1048577 == num.intValue()) {
                Log.d(AgoraRtcService.TAG, "setupObserver: 准备告诉服务器首帧");
                VideoCallService shared = VideoCallService.INSTANCE.getShared();
                dialedPreloadModel = this.this$0.dialedPreloadModel;
                String videoUID = dialedPreloadModel.getAgoraVideoCallConfig().getVideoUID();
                if (videoUID == null) {
                    videoUID = "";
                }
                i0<ApiResponse<Object>> videoCallReady = shared.videoCallReady(videoUID);
                final Function2<String, Throwable, Unit> function2 = this.$disposalError;
                Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.h
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$0;
                        accept$lambda$0 = DialedWrapper$setupObserver$1.accept$lambda$0(function2, (ApiResponse) obj);
                        return accept$lambda$0;
                    }
                };
                final Function2<String, Throwable, Unit> function22 = this.$disposalError;
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(videoCallReady, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.i
                    public final Object invoke(Object obj) {
                        Unit accept$lambda$1;
                        accept$lambda$1 = DialedWrapper$setupObserver$1.accept$lambda$1(function22, (Throwable) obj);
                        return accept$lambda$1;
                    }
                }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
            }
        } catch (Exception e) {
            DebugToolsKt.printfE("DialedWrapper", "matchToggleStatusChangedEventRelay 内部try()catch{}" + e.getLocalizedMessage());
            this.$disposalError.invoke("wait call-ready in channel", e);
        }
    }
}
