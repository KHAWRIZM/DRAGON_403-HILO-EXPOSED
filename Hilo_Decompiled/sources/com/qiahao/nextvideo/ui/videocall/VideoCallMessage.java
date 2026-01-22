package com.qiahao.nextvideo.ui.videocall;

import android.content.Context;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.ui.loading.HiloLoadingDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.AgoraVideoCallParams;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.data.service.VideoCallService;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003Jk\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2:\b\u0002\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoCallMessage;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "showLoadingDialog", "(Landroid/content/Context;)V", "hideLoadingDialog", "", SupportGiftRankActivity.EXTERNAL_ID, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "isLike", "likeListener", "Lkotlin/Function0;", "startVideo", "newStartVideo", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;", "loadingDialog", "Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;", "getLoadingDialog", "()Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;", "setLoadingDialog", "(Lcom/qiahao/base_common/ui/loading/HiloLoadingDialog;)V", "", "totalActiveTimeInMills", "I", "getTotalActiveTimeInMills", "()I", "setTotalActiveTimeInMills", "(I)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoCallMessage {

    @Nullable
    private static HiloLoadingDialog loadingDialog;
    private static int totalActiveTimeInMills;

    @NotNull
    public static final VideoCallMessage INSTANCE = new VideoCallMessage();

    @NotNull
    private static nd.a mCompositeDisposable = new nd.a();

    private VideoCallMessage() {
    }

    private final void hideLoadingDialog() {
        HiloLoadingDialog hiloLoadingDialog = loadingDialog;
        if (hiloLoadingDialog != null) {
            hiloLoadingDialog.dismiss();
        }
        loadingDialog = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void newStartVideo$default(VideoCallMessage videoCallMessage, Context context, String str, Function2 function2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        videoCallMessage.newStartVideo(context, str, function2, function0);
    }

    public static final void newStartVideo$lambda$0(Context context) {
        INSTANCE.showLoadingDialog(context);
    }

    public static final Unit newStartVideo$lambda$2(Function0 function0, Context context, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        INSTANCE.hideLoadingDialog();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomSmall()) {
            n5.e.c("videoCallButtonPressed 调用MeetingRoomManager的LeaveRoom()");
            MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
            meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
        } else {
            cf.c.c().l(new RoomEvent().setEventId(RoomEvent.ROOM_WHEN_CALL_OUT));
        }
        AgoraVideoCallParams agoraVideoCallParams = (AgoraVideoCallParams) apiResponse.getData();
        if (agoraVideoCallParams != null) {
            VideoCallActivity.Companion companion = VideoCallActivity.INSTANCE;
            VideoCallModel.Companion companion2 = VideoCallModel.INSTANCE;
            AgoraVideoCallConfig.Companion companion3 = AgoraVideoCallConfig.INSTANCE;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            companion.start(context, VideoCallModel.Companion.initInDialed$default(companion2, null, companion3.init(agoraVideoCallParams, str, agoraVideoCallParams.getRemoteUser().getExternalId()), agoraVideoCallParams.getRemoteUser(), agoraVideoCallParams.getDiamondNum(), 1, null));
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final Unit newStartVideo$lambda$3(Context context, final Function2 function2, final String str, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        VideoCallMessage videoCallMessage = INSTANCE;
        videoCallMessage.hideLoadingDialog();
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9016) {
                if (code != 10006) {
                    if (code != 10007) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        String localizedMessage = hiloException.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = ResourcesKtxKt.getStringById(videoCallMessage, 2131952667);
                        }
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    } else {
                        Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, ResourcesKtxKt.getStringById(videoCallMessage, 2131953223), false, 4, (Object) null);
                        if (normal$default2 != null) {
                            normal$default2.show();
                        }
                    }
                } else {
                    new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(videoCallMessage, 2131953223)).setConfirmContent(ResourcesKtxKt.getStringById(videoCallMessage, 2131953219)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.videocall.VideoCallMessage$newStartVideo$3$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            Function2<String, Boolean, Unit> function22 = function2;
                            if (function22 != null) {
                                function22.invoke(str, Boolean.FALSE);
                            }
                        }
                    }).show();
                }
            } else {
                Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, ResourcesKtxKt.getStringById(videoCallMessage, 2131953029), false, 4, (Object) null);
                if (normal$default3 != null) {
                    normal$default3.show();
                }
            }
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                localizedMessage2 = ResourcesKtxKt.getStringById(videoCallMessage, 2131952667);
            }
            Toast normal$default4 = HiloToasty.Companion.normal$default(companion2, context, localizedMessage2, false, 4, (Object) null);
            if (normal$default4 != null) {
                normal$default4.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void showLoadingDialog(Context context) {
        if (loadingDialog == null) {
            loadingDialog = new HiloLoadingDialog(context, false);
        }
        HiloLoadingDialog hiloLoadingDialog = loadingDialog;
        if (hiloLoadingDialog != null) {
            hiloLoadingDialog.show();
        }
    }

    @Nullable
    public final HiloLoadingDialog getLoadingDialog() {
        return loadingDialog;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return mCompositeDisposable;
    }

    public final int getTotalActiveTimeInMills() {
        return totalActiveTimeInMills;
    }

    public final void newStartVideo(@NotNull final Context context, @NotNull final String r10, @Nullable final Function2<? super String, ? super Boolean, Unit> likeListener, @Nullable final Function0<Unit> startVideo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(r10, SupportGiftRankActivity.EXTERNAL_ID);
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoCallMessage.newStartVideo$lambda$0(context);
            }
        });
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(VideoCallService.INSTANCE.getShared().sendMinuteVideo(r10), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.d
            public final Object invoke(Object obj) {
                Unit newStartVideo$lambda$2;
                newStartVideo$lambda$2 = VideoCallMessage.newStartVideo$lambda$2(startVideo, context, (ApiResponse) obj);
                return newStartVideo$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.e
            public final Object invoke(Object obj) {
                Unit newStartVideo$lambda$3;
                newStartVideo$lambda$3 = VideoCallMessage.newStartVideo$lambda$3(context, likeListener, r10, (Throwable) obj);
                return newStartVideo$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void setLoadingDialog(@Nullable HiloLoadingDialog hiloLoadingDialog) {
        loadingDialog = hiloLoadingDialog;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        mCompositeDisposable = aVar;
    }

    public final void setTotalActiveTimeInMills(int i) {
        totalActiveTimeInMills = i;
    }
}
