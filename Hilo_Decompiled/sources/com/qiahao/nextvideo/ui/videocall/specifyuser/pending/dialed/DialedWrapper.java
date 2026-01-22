package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import cf.m;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.ChannelEventStartup;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.model.im.CallStatus;
import com.qiahao.base_common.model.im.Identifier;
import com.qiahao.base_common.model.im.VideoCallTipsMessage;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.DialedPreloadModel;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.data.service.VideoCallService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.databinding.ViewVideoCallBinding;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimer;
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.im.ImMessageUtil;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import io.agora.rtc.RtcEngine;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u000bJ\r\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedWrapper;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimerListener;", "Landroid/view/ViewGroup;", "parent", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "preloadModel", "<init>", "(Landroid/view/ViewGroup;Lcom/qiahao/nextvideo/data/model/VideoCallModel;)V", "", "hangupImageViewPressed", "()V", "registerEventBus", "unRegisterEventBus", "setupObserver", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/VideoEvent;)V", "show", "hide", "onTimeout", "Landroid/view/View;", "v", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "hangUp", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "getPreloadModel", "()Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer$delegate", "Lkotlin/Lazy;", "getSoloSoloDownTimer", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;)V", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;", "delegate", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/qiahao/nextvideo/data/model/DialedPreloadModel;", "dialedPreloadModel", "Lcom/qiahao/nextvideo/data/model/DialedPreloadModel;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DialedWrapper implements View.OnAttachStateChangeListener, SoloDownTimerListener {

    @NotNull
    private static final String TAG = "DialedWrapper";

    @NotNull
    public static final String comingDeadlineTipAudioFile = "/assets3/specify_video_call_tips_audio.mp3";

    @NotNull
    private ViewVideoCallBinding binding;

    @NotNull
    private final nd.a compositeDisposable;

    @Nullable
    private Context context;

    @Nullable
    private DialedListener delegate;

    @NotNull
    private final DialedPreloadModel dialedPreloadModel;

    @NotNull
    private final ViewGroup parent;

    @NotNull
    private final VideoCallModel preloadModel;

    /* renamed from: soloSoloDownTimer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy soloSoloDownTimer;

    public DialedWrapper(@NotNull ViewGroup viewGroup, @NotNull VideoCallModel videoCallModel) {
        String nickname;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(videoCallModel, "preloadModel");
        this.parent = viewGroup;
        this.preloadModel = videoCallModel;
        this.compositeDisposable = new nd.a();
        this.soloSoloDownTimer = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.e
            public final Object invoke() {
                SoloDownTimer soloSoloDownTimer_delegate$lambda$1;
                soloSoloDownTimer_delegate$lambda$1 = DialedWrapper.soloSoloDownTimer_delegate$lambda$1(DialedWrapper.this);
                return soloSoloDownTimer_delegate$lambda$1;
            }
        });
        ViewVideoCallBinding inflate = ViewVideoCallBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.context = inflate.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        this.binding = inflate;
        DialedPreloadModel dialedPreloadModel = videoCallModel.getDialedPreloadModel();
        Intrinsics.checkNotNull(dialedPreloadModel);
        this.dialedPreloadModel = dialedPreloadModel;
        this.binding.getRoot().addOnAttachStateChangeListener(this);
        this.binding.acceptImageView.setVisibility(8);
        QMUIRadiusImageView qMUIRadiusImageView = this.binding.avatarImageView;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarImageView");
        ViewUtilitiesKt.bind$default(qMUIRadiusImageView, videoCallModel.getImageUIModel(), null, 2, null);
        AppCompatImageView appCompatImageView = this.binding.countryFlagImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryFlagImageView");
        ViewUtilitiesKt.bind$default(appCompatImageView, videoCallModel.getCountryIcon(), null, 2, null);
        AppCompatTextView appCompatTextView = this.binding.nicknameTextView;
        if (videoCallModel.getNickname().length() > 9) {
            String substring = videoCallModel.getNickname().substring(0, 9);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            nickname = substring + "…";
        } else {
            nickname = videoCallModel.getNickname();
        }
        appCompatTextView.setText(nickname);
        this.binding.countryProvinceTextView.setText(videoCallModel.getCountryName());
        ViewVideoCallBinding viewVideoCallBinding = this.binding;
        viewVideoCallBinding.pendingDescriptionTextView.setText(viewVideoCallBinding.getRoot().getContext().getString(2131954470));
        this.binding.hangupImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialedWrapper.this.hangupImageViewPressed();
            }
        });
        getSoloSoloDownTimer().start();
        setupObserver();
        registerEventBus();
    }

    private final SoloDownTimer getSoloSoloDownTimer() {
        return (SoloDownTimer) this.soloSoloDownTimer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hangupImageViewPressed() {
        String str;
        AgoraVideoCallConfig agoraVideoCallConfig;
        ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
        DialedPreloadModel dialedPreloadModel = this.preloadModel.getDialedPreloadModel();
        if (dialedPreloadModel == null || (agoraVideoCallConfig = dialedPreloadModel.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig.getToUserUID()) == null) {
            str = "";
        }
        imMessageUtil.sendVideoMessage(str, VideoCallTipsMessage.Companion.init$default(VideoCallTipsMessage.Companion, CallStatus.CANCELED, 0, (Identifier) null, 4, (Object) null));
        getSoloSoloDownTimer().cancel();
        VideoCallService.INSTANCE.getShared().refuseVideoCall(this.preloadModel.getMatchUniqueID());
        DialedListener dialedListener = this.delegate;
        if (dialedListener != null) {
            dialedListener.onDialedHangup();
        }
    }

    private final void registerEventBus() {
        if (!cf.c.c().j(this)) {
            cf.c.c().p(this);
        }
    }

    private final void setupObserver() {
        final Function2 function2 = new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.g
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = DialedWrapper.setupObserver$lambda$4(DialedWrapper.this, (String) obj, (Throwable) obj2);
                return unit;
            }
        };
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        nd.c subscribe = agoraRtcService.getRemoteVideoStatusRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new DialedWrapper$setupObserver$1(this, function2), new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedWrapper$setupObserver$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "throwable");
                function2.invoke("wait call-ready in channel", th);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.setChannelProfile(1);
        }
        AgoraRtcService.joinChannel$default(agoraRtcService, this.dialedPreloadModel.getAgoraVideoCallConfig().getToken(), this.dialedPreloadModel.getAgoraVideoCallConfig().getChannelID(), null, this.dialedPreloadModel.getAgoraVideoCallConfig().getLocalAgoraId(), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupObserver$lambda$4(DialedWrapper dialedWrapper, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(th, "throwable");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = dialedWrapper.context;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            Context context2 = dialedWrapper.context;
            if (context2 != null) {
                localizedMessage = context2.getString(2131952667);
            } else {
                localizedMessage = null;
            }
            if (localizedMessage == null) {
                localizedMessage = "";
            }
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        VideoCallService.INSTANCE.getShared().refuseVideoCall(dialedWrapper.preloadModel.getMatchUniqueID());
        DialedListener dialedListener = dialedWrapper.delegate;
        if (dialedListener != null) {
            dialedListener.onDialedHangup();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SoloDownTimer soloSoloDownTimer_delegate$lambda$1(DialedWrapper dialedWrapper) {
        SoloDownTimer soloDownTimer = new SoloDownTimer(0L, 1, null);
        soloDownTimer.setListener(dialedWrapper);
        return soloDownTimer;
    }

    private final void unRegisterEventBus() {
        if (cf.c.c().j(this)) {
            cf.c.c().r(this);
        }
    }

    @NotNull
    public final ViewVideoCallBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @Nullable
    public final DialedListener getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final ViewGroup getParent() {
        return this.parent;
    }

    @NotNull
    public final VideoCallModel getPreloadModel() {
        return this.preloadModel;
    }

    public final void hangUp() {
        this.binding.getRoot().removeOnAttachStateChangeListener(this);
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.stopAudioMixing();
        }
        getSoloSoloDownTimer().cancel();
        this.compositeDisposable.dispose();
        unRegisterEventBus();
    }

    public final void hide() {
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.stopAudioMixing();
        }
        getSoloSoloDownTimer().cancel();
        this.binding.getRoot().setVisibility(8);
        unRegisterEventBus();
    }

    @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener
    public void onTimeout() {
        String str;
        String str2;
        String string;
        AgoraVideoCallConfig agoraVideoCallConfig;
        ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
        DialedPreloadModel dialedPreloadModel = this.preloadModel.getDialedPreloadModel();
        if (dialedPreloadModel == null || (agoraVideoCallConfig = dialedPreloadModel.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig.getToUserUID()) == null) {
            str = "";
        }
        imMessageUtil.sendVideoMessage(str, VideoCallTipsMessage.Companion.init$default(VideoCallTipsMessage.Companion, CallStatus.TIMEOUT_REFUSE, 0, (Identifier) null, 4, (Object) null));
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = this.context;
        if (context == null || (string = context.getString(2131954258)) == null) {
            str2 = "";
        } else {
            str2 = string;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.stopAudioMixing();
        }
        DialedListener dialedListener = this.delegate;
        if (dialedListener != null) {
            dialedListener.onDialedHangup();
        }
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull VideoEvent event) {
        String str;
        AgoraVideoCallConfig agoraVideoCallConfig;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        if (Intrinsics.areEqual(type, "SPECIFY_VIDEO_CALL_REFUSED")) {
            ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
            DialedPreloadModel dialedPreloadModel = this.preloadModel.getDialedPreloadModel();
            if (dialedPreloadModel == null || (agoraVideoCallConfig = dialedPreloadModel.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig.getToUserUID()) == null) {
                str = "";
            }
            imMessageUtil.sendVideoMessage(str, VideoCallTipsMessage.Companion.init$default(VideoCallTipsMessage.Companion, CallStatus.TIMEOUT_REFUSE, 0, (Identifier) null, 4, (Object) null));
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.context, ResourcesKtxKt.getStringById(this, 2131954556), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            DialedListener dialedListener = this.delegate;
            if (dialedListener != null) {
                dialedListener.onDialedHangup();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(type, "remote_first_frame")) {
            Log.d(AgoraRtcService.TAG, "AgoraRtcService:展开视频页面");
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.common.ChannelEventStartup");
            ChannelEventStartup channelEventStartup = (ChannelEventStartup) data;
            long diffTimeInSecs = channelEventStartup.getDiffTimeInSecs();
            DialedListener dialedListener2 = this.delegate;
            if (dialedListener2 != null) {
                VideoCallPreloadModel.Companion companion = VideoCallPreloadModel.INSTANCE;
                AgoraVideoCallConfig agoraVideoCallConfig2 = this.dialedPreloadModel.getAgoraVideoCallConfig();
                UserSummaryInfo fromUser = this.preloadModel.getFromUser();
                User user = DataExternalKt.toUser(this.preloadModel.getToUser());
                String videoUID = this.dialedPreloadModel.getAgoraVideoCallConfig().getVideoUID();
                Intrinsics.checkNotNull(videoUID);
                dialedListener2.onDialedStartup(companion.init(agoraVideoCallConfig2, fromUser, user, videoUID, channelEventStartup, Long.valueOf(diffTimeInSecs)));
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.binding.getRoot().removeOnAttachStateChangeListener(this);
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.stopAudioMixing();
        }
        getSoloSoloDownTimer().cancel();
        this.compositeDisposable.dispose();
    }

    public final void setBinding(@NotNull ViewVideoCallBinding viewVideoCallBinding) {
        Intrinsics.checkNotNullParameter(viewVideoCallBinding, "<set-?>");
        this.binding = viewVideoCallBinding;
    }

    public final void setDelegate(@Nullable DialedListener dialedListener) {
        this.delegate = dialedListener;
    }

    public final void show() {
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.startAudioMixing("/assets3/specify_video_call_tips_audio.mp3", true, false, -1);
        }
        this.binding.getRoot().setVisibility(0);
    }
}
