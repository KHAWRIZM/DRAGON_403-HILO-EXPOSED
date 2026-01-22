package com.qiahao.nextvideo.data.service;

import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.AgoraVideoCallParams;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.data.model.VideoFreeCheck;
import com.qiahao.nextvideo.data.model.VideoResultData;
import com.qiahao.nextvideo.network.AppServer;
import io.reactivex.rxjava3.core.i0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\rJ!\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0011J/\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00050\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001f0\u00050\u00042\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/service/VideoCallService;", "", "<init>", "()V", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "Lcom/qiahao/nextvideo/data/model/VideoFreeCheck;", "videoFreeCheck", "()Lio/reactivex/rxjava3/core/i0;", "", "specifyUserExternalId", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallParams;", "sendMinuteVideo", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "videoCallUid", "", "refuseVideoCall", "(Ljava/lang/String;)V", "matchUniqueId", "videoCallReady", "accept", "videoUid", "videoEnd", "", "pageSize", "pageIndex", "Lcom/qiahao/base_common/model/ApiList;", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "videoGoddessList", "(II)Lio/reactivex/rxjava3/core/i0;", "type", "", "videoMatchingHistory", "(Ljava/lang/String;II)Lio/reactivex/rxjava3/core/i0;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoCallService {

    @NotNull
    public static final String TAG = "VideoCallService";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<VideoCallService> shared$delegate = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.data.service.v
        public final Object invoke() {
            VideoCallService shared_delegate$lambda$2;
            shared_delegate$lambda$2 = VideoCallService.shared_delegate$lambda$2();
            return shared_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/data/service/VideoCallService$Companion;", "", "<init>", "()V", "TAG", "", "shared", "Lcom/qiahao/nextvideo/data/service/VideoCallService;", "getShared", "()Lcom/qiahao/nextvideo/data/service/VideoCallService;", "shared$delegate", "Lkotlin/Lazy;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoCallService getShared() {
            return (VideoCallService) VideoCallService.shared$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refuseVideoCall$lambda$0(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refuseVideoCall$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoCallService shared_delegate$lambda$2() {
        return new VideoCallService();
    }

    @NotNull
    public final i0<ApiResponse<Object>> accept(@NotNull String matchUniqueId) {
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        return AppServer.INSTANCE.getApis().videoReceive(matchUniqueId);
    }

    public final void refuseVideoCall(@NotNull String videoCallUid) {
        Intrinsics.checkNotNullParameter(videoCallUid, "videoCallUid");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().videoRefuse(videoCallUid), new Function1() { // from class: com.qiahao.nextvideo.data.service.w
            public final Object invoke(Object obj) {
                Unit refuseVideoCall$lambda$0;
                refuseVideoCall$lambda$0 = VideoCallService.refuseVideoCall$lambda$0((ApiResponse) obj);
                return refuseVideoCall$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.x
            public final Object invoke(Object obj) {
                Unit refuseVideoCall$lambda$1;
                refuseVideoCall$lambda$1 = VideoCallService.refuseVideoCall$lambda$1((Throwable) obj);
                return refuseVideoCall$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), new nd.a());
    }

    @NotNull
    public final i0<ApiResponse<AgoraVideoCallParams>> sendMinuteVideo(@NotNull String specifyUserExternalId) {
        Intrinsics.checkNotNullParameter(specifyUserExternalId, "specifyUserExternalId");
        return AppServer.INSTANCE.getApis().videoMinuteSend(specifyUserExternalId);
    }

    @NotNull
    public final i0<ApiResponse<Object>> videoCallReady(@NotNull String matchUniqueId) {
        Intrinsics.checkNotNullParameter(matchUniqueId, "matchUniqueId");
        return AppServer.INSTANCE.getApis().videoCallReady(matchUniqueId);
    }

    public final void videoEnd(@NotNull String videoUid) {
        Intrinsics.checkNotNullParameter(videoUid, "videoUid");
        UserStore.INSTANCE.getShared().fetchUserDetailInfo(false);
        nd.c n = AppServer.INSTANCE.getApis().videoEnd(videoUid).k(ke.a.b()).p(ke.a.b()).n(new pd.g() { // from class: com.qiahao.nextvideo.data.service.VideoCallService$videoEnd$1
            public final void accept(ApiResponse<VideoResultData> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "1v1通话结束请求成功", false, 4, (Object) null);
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.VideoCallService$videoEnd$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "1v1通话结束请求失败", false, 4, (Object) null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(n, "subscribe(...)");
        RxUtilsKt.addTo(n, new nd.a());
    }

    @NotNull
    public final i0<ApiResponse<VideoFreeCheck>> videoFreeCheck() {
        return AppServer.INSTANCE.getApis().videoFreeCheck();
    }

    @NotNull
    public final i0<ApiResponse<ApiList<VideoBaseData>>> videoGoddessList(int pageSize, int pageIndex) {
        return AppServer.INSTANCE.getApis().videoGoddessList(pageSize, pageIndex);
    }

    @NotNull
    public final i0<ApiResponse<List<VideoBaseData>>> videoMatchingHistory(@NotNull String type, int pageSize, int pageIndex) {
        Intrinsics.checkNotNullParameter(type, "type");
        return AppServer.INSTANCE.getApis().videoMatchingHistory(type, pageSize, pageIndex);
    }
}
