package com.qiahao.nextvideo.data.service;

import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.nextvideo.network.AppServer;
import io.reactivex.rxjava3.core.i0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00060\u00060\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/service/FeedbackService;", "", "<init>", "()V", "", "reportFrom", "", "toUID", "reasonType", "reason", "image", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "reportUser", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "blockUser", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lla/c;", "kotlin.jvm.PlatformType", "reportEventRelay", "Lla/c;", "getReportEventRelay", "()Lla/c;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FeedbackService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<FeedbackService> shared$delegate = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.data.service.e
        public final Object invoke() {
            FeedbackService shared_delegate$lambda$0;
            shared_delegate$lambda$0 = FeedbackService.shared_delegate$lambda$0();
            return shared_delegate$lambda$0;
        }
    });

    @NotNull
    private final la.c reportEventRelay;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/data/service/FeedbackService$Companion;", "", "<init>", "()V", "shared", "Lcom/qiahao/nextvideo/data/service/FeedbackService;", "getShared", "()Lcom/qiahao/nextvideo/data/service/FeedbackService;", "shared$delegate", "Lkotlin/Lazy;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedbackService getShared() {
            return (FeedbackService) FeedbackService.shared$delegate.getValue();
        }

        private Companion() {
        }
    }

    public FeedbackService() {
        la.c e = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.reportEventRelay = e;
    }

    public static /* synthetic */ i0 reportUser$default(FeedbackService feedbackService, int i, String str, int i2, String str2, String str3, int i3, Object obj) {
        String str4;
        String str5;
        if ((i3 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i3 & 16) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        return feedbackService.reportUser(i, str, i2, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackService shared_delegate$lambda$0() {
        return new FeedbackService();
    }

    @NotNull
    public final i0<ApiResponse<Object>> blockUser(@NotNull String toUID) {
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        return AppServer.INSTANCE.getApis().blockUser(toUID);
    }

    @NotNull
    public final la.c getReportEventRelay() {
        return this.reportEventRelay;
    }

    @NotNull
    public final i0<ApiResponse<Object>> reportUser(int reportFrom, @NotNull String toUID, int reasonType, @Nullable String reason, @Nullable String image) {
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        return AppServer.INSTANCE.getApis().reportUser(toUID, reportFrom, reasonType, reason, image);
    }
}
