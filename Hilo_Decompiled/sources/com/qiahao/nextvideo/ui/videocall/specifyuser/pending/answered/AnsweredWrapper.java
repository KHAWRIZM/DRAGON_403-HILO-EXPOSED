package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.model.common.ChannelEventStartup;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.AnsweredPreloadModel;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.data.service.VideoCallService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.voice.VoiceConfig;
import com.qiahao.nextvideo.data.service.voice.VoiceModel;
import com.qiahao.nextvideo.data.service.voice.VoiceService;
import com.qiahao.nextvideo.databinding.ViewVideoCallBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimer;
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import io.agora.rtc.RtcEngine;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u000bJ\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u000bJ\u000f\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredWrapper;", "Landroid/view/View$OnAttachStateChangeListener;", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimerListener;", "Landroid/view/ViewGroup;", "parent", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "preloadModel", "<init>", "(Landroid/view/ViewGroup;Lcom/qiahao/nextvideo/data/model/VideoCallModel;)V", "", "hangupImageViewPressed", "()V", "registerEventBus", "unRegisterEventBus", "setupObserver", "acceptImageViewPressed", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/VideoEvent;)V", "show", "hide", "Landroid/view/View;", "v", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "hangUp", "onTimeout", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "getPreloadModel", "()Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;)V", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;", "delegate", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;)V", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer$delegate", "Lkotlin/Lazy;", "getSoloSoloDownTimer", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnsweredWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnsweredWrapper.kt\ncom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredWrapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,260:1\n1#2:261\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnsweredWrapper implements View.OnAttachStateChangeListener, SoloDownTimerListener {

    @NotNull
    private static final String TAG = "AnsweredWrapper";

    @NotNull
    private ViewVideoCallBinding binding;

    @NotNull
    private final nd.a compositeDisposable;

    @Nullable
    private Context context;

    @Nullable
    private AnsweredListener delegate;

    @Nullable
    private final VideoCallModel preloadModel;

    /* renamed from: soloSoloDownTimer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy soloSoloDownTimer;

    public AnsweredWrapper(@NotNull ViewGroup viewGroup, @Nullable VideoCallModel videoCallModel) {
        String nickname;
        String str;
        String nickname2;
        String nickname3;
        ImageUIModel countryIcon;
        ImageUIModel imageUIModel;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.preloadModel = videoCallModel;
        this.compositeDisposable = new nd.a();
        ViewVideoCallBinding inflate = ViewVideoCallBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.context = inflate.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        this.binding = inflate;
        this.soloSoloDownTimer = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.i
            public final Object invoke() {
                SoloDownTimer soloSoloDownTimer_delegate$lambda$2;
                soloSoloDownTimer_delegate$lambda$2 = AnsweredWrapper.soloSoloDownTimer_delegate$lambda$2(AnsweredWrapper.this);
                return soloSoloDownTimer_delegate$lambda$2;
            }
        });
        this.binding.getRoot().addOnAttachStateChangeListener(this);
        ViewVideoCallBinding viewVideoCallBinding = this.binding;
        viewVideoCallBinding.pendingDescriptionTextView.setText(viewVideoCallBinding.getRoot().getContext().getString(2131953143));
        QMUIRadiusImageView qMUIRadiusImageView = this.binding.avatarImageView;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarImageView");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, (videoCallModel == null || (imageUIModel = videoCallModel.getImageUIModel()) == null) ? null : imageUIModel.getImageUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        AppCompatImageView appCompatImageView = this.binding.countryFlagImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryFlagImageView");
        ImageKtxKt.loadImage$default(appCompatImageView, (videoCallModel == null || (countryIcon = videoCallModel.getCountryIcon()) == null) ? null : countryIcon.getImageUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        AppCompatTextView appCompatTextView = this.binding.nicknameTextView;
        if (((videoCallModel == null || (nickname3 = videoCallModel.getNickname()) == null) ? 0 : nickname3.length()) > 9) {
            if (videoCallModel == null || (nickname2 = videoCallModel.getNickname()) == null) {
                str = null;
            } else {
                str = nickname2.substring(0, 9);
                Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
            }
            nickname = str + "…";
        } else {
            nickname = videoCallModel != null ? videoCallModel.getNickname() : null;
        }
        appCompatTextView.setText(nickname);
        this.binding.countryProvinceTextView.setText(videoCallModel != null ? videoCallModel.getCountryName() : null);
        this.binding.hangupImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnsweredWrapper._init_$lambda$3(AnsweredWrapper.this, view);
            }
        });
        this.binding.acceptImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnsweredWrapper._init_$lambda$5(AnsweredWrapper.this, view);
            }
        });
        setupObserver();
        registerEventBus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(AnsweredWrapper answeredWrapper, View view) {
        if (FastClickUtils.INSTANCE.isFastClick()) {
            answeredWrapper.hangupImageViewPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(final AnsweredWrapper answeredWrapper, View view) {
        if (FastClickUtils.INSTANCE.isFastClick()) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.isRoomSmall()) {
                n5.e.c("AnsweredWrapper acceptImageView 调用MeetingRoomManager的LeaveRoom()");
                MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
                meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
            } else {
                cf.c.c().l(new RoomEvent().setEventId(300));
            }
            answeredWrapper.binding.acceptImageView.setVisibility(8);
            answeredWrapper.binding.acceptImageView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.l
                @Override // java.lang.Runnable
                public final void run() {
                    AnsweredWrapper.this.acceptImageViewPressed();
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void acceptImageViewPressed() {
        CharSequence charSequence;
        String str;
        String str2;
        String str3;
        int i;
        AnsweredPreloadModel answeredPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig;
        AnsweredPreloadModel answeredPreloadModel2;
        AgoraVideoCallConfig agoraVideoCallConfig2;
        String channelID;
        AnsweredPreloadModel answeredPreloadModel3;
        AgoraVideoCallConfig agoraVideoCallConfig3;
        String token;
        AnsweredPreloadModel answeredPreloadModel4;
        AgoraVideoCallConfig agoraVideoCallConfig4;
        Vibrator vibrator = AppUtilitiesKt.getVibrator();
        if (vibrator != null) {
            vibrator.cancel();
        }
        this.binding.acceptImageView.setVisibility(8);
        AppCompatTextView appCompatTextView = this.binding.pendingDescriptionTextView;
        Context context = this.context;
        if (context != null) {
            charSequence = context.getText(2131954470);
        } else {
            charSequence = null;
        }
        appCompatTextView.setText(charSequence);
        VideoCallService shared = VideoCallService.INSTANCE.getShared();
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel == null || (answeredPreloadModel4 = videoCallModel.getAnsweredPreloadModel()) == null || (agoraVideoCallConfig4 = answeredPreloadModel4.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig4.getVideoUID()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.accept(str), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.g
            public final Object invoke(Object obj) {
                Unit acceptImageViewPressed$lambda$8;
                acceptImageViewPressed$lambda$8 = AnsweredWrapper.acceptImageViewPressed$lambda$8((ApiResponse) obj);
                return acceptImageViewPressed$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.h
            public final Object invoke(Object obj) {
                Unit acceptImageViewPressed$lambda$10;
                acceptImageViewPressed$lambda$10 = AnsweredWrapper.acceptImageViewPressed$lambda$10(AnsweredWrapper.this, (Throwable) obj);
                return acceptImageViewPressed$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.setChannelProfile(1);
        }
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 == null || (answeredPreloadModel3 = videoCallModel2.getAnsweredPreloadModel()) == null || (agoraVideoCallConfig3 = answeredPreloadModel3.getAgoraVideoCallConfig()) == null || (token = agoraVideoCallConfig3.getToken()) == null) {
            str2 = "";
        } else {
            str2 = token;
        }
        VideoCallModel videoCallModel3 = this.preloadModel;
        if (videoCallModel3 == null || (answeredPreloadModel2 = videoCallModel3.getAnsweredPreloadModel()) == null || (agoraVideoCallConfig2 = answeredPreloadModel2.getAgoraVideoCallConfig()) == null || (channelID = agoraVideoCallConfig2.getChannelID()) == null) {
            str3 = "";
        } else {
            str3 = channelID;
        }
        VideoCallModel videoCallModel4 = this.preloadModel;
        if (videoCallModel4 != null && (answeredPreloadModel = videoCallModel4.getAnsweredPreloadModel()) != null && (agoraVideoCallConfig = answeredPreloadModel.getAgoraVideoCallConfig()) != null) {
            i = agoraVideoCallConfig.getLocalAgoraId();
        } else {
            i = 0;
        }
        AgoraRtcService.joinChannel$default(agoraRtcService, str2, str3, null, i, 4, null);
        AnsweredListener answeredListener = this.delegate;
        if (answeredListener != null) {
            answeredListener.onAnswer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptImageViewPressed$lambda$10(AnsweredWrapper answeredWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        Context context = answeredWrapper.context;
        if (context != null) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = context.getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        AnsweredListener answeredListener = answeredWrapper.delegate;
        if (answeredListener != null) {
            answeredListener.onHangup();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptImageViewPressed$lambda$8(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    private final SoloDownTimer getSoloSoloDownTimer() {
        return (SoloDownTimer) this.soloSoloDownTimer.getValue();
    }

    private final void hangupImageViewPressed() {
        String str;
        unRegisterEventBus();
        getSoloSoloDownTimer().cancel();
        VideoCallService shared = VideoCallService.INSTANCE.getShared();
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel == null || (str = videoCallModel.getMatchUniqueID()) == null) {
            str = "";
        }
        shared.refuseVideoCall(str);
        AnsweredListener answeredListener = this.delegate;
        if (answeredListener != null) {
            answeredListener.onHangup();
        }
    }

    private final void registerEventBus() {
        if (!cf.c.c().j(this)) {
            cf.c.c().p(this);
        }
    }

    private final void setupObserver() {
        final Function2 function2 = new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.m
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = AnsweredWrapper.setupObserver$lambda$7(AnsweredWrapper.this, (String) obj, (Throwable) obj2);
                return unit;
            }
        };
        nd.c subscribe = AgoraRtcService.INSTANCE.getRemoteVideoStatusRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new AnsweredWrapper$setupObserver$1(this, function2), new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredWrapper$setupObserver$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "throwable");
                function2.invoke("wait call-ready in channel", th);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupObserver$lambda$7(AnsweredWrapper answeredWrapper, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(th, "throwable");
        Context context = answeredWrapper.context;
        if (context != null) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = context.getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        AnsweredListener answeredListener = answeredWrapper.delegate;
        if (answeredListener != null) {
            answeredListener.onHangup();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SoloDownTimer soloSoloDownTimer_delegate$lambda$2(AnsweredWrapper answeredWrapper) {
        SoloDownTimer soloDownTimer = new SoloDownTimer(0L, 1, null);
        soloDownTimer.setListener(answeredWrapper);
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
    public final AnsweredListener getDelegate() {
        return this.delegate;
    }

    @Nullable
    public final VideoCallModel getPreloadModel() {
        return this.preloadModel;
    }

    public final void hangUp() {
        getSoloSoloDownTimer().cancel();
        VoiceService.INSTANCE.getShared().stopAll();
        this.compositeDisposable.dispose();
        unRegisterEventBus();
    }

    public final void hide() {
        getSoloSoloDownTimer().cancel();
        this.compositeDisposable.dispose();
        VoiceService.INSTANCE.getShared().stopAll();
        this.binding.getRoot().setVisibility(8);
        this.binding.getRoot().removeOnAttachStateChangeListener(this);
        unRegisterEventBus();
    }

    @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener
    public void onTimeout() {
        AnsweredListener answeredListener = this.delegate;
        if (answeredListener != null) {
            answeredListener.onHangup();
        }
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull VideoEvent event) {
        AgoraVideoCallConfig agoraVideoCallConfig;
        UserSummaryInfo userSummaryInfo;
        User user;
        AnsweredPreloadModel answeredPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig2;
        UserSummaryInfo toUser;
        AnsweredPreloadModel answeredPreloadModel2;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        if (Intrinsics.areEqual(type, "SPECIFY_VIDEO_CALL_REFUSED")) {
            AnsweredListener answeredListener = this.delegate;
            if (answeredListener != null) {
                answeredListener.onHangup();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(type, "remote_first_frame")) {
            n5.e.c("AgoraRtcService:展开视频页面");
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.common.ChannelEventStartup");
            ChannelEventStartup channelEventStartup = (ChannelEventStartup) data;
            long diffTimeInSecs = channelEventStartup.getDiffTimeInSecs();
            AnsweredListener answeredListener2 = this.delegate;
            if (answeredListener2 != null) {
                VideoCallPreloadModel.Companion companion = VideoCallPreloadModel.INSTANCE;
                VideoCallModel videoCallModel = this.preloadModel;
                String str = null;
                if (videoCallModel != null && (answeredPreloadModel2 = videoCallModel.getAnsweredPreloadModel()) != null) {
                    agoraVideoCallConfig = answeredPreloadModel2.getAgoraVideoCallConfig();
                } else {
                    agoraVideoCallConfig = null;
                }
                VideoCallModel videoCallModel2 = this.preloadModel;
                if (videoCallModel2 != null) {
                    userSummaryInfo = videoCallModel2.getFromUser();
                } else {
                    userSummaryInfo = null;
                }
                VideoCallModel videoCallModel3 = this.preloadModel;
                if (videoCallModel3 != null && (toUser = videoCallModel3.getToUser()) != null) {
                    user = DataExternalKt.toUser(toUser);
                } else {
                    user = null;
                }
                VideoCallModel videoCallModel4 = this.preloadModel;
                if (videoCallModel4 != null && (answeredPreloadModel = videoCallModel4.getAnsweredPreloadModel()) != null && (agoraVideoCallConfig2 = answeredPreloadModel.getAgoraVideoCallConfig()) != null) {
                    str = agoraVideoCallConfig2.getVideoUID();
                }
                answeredListener2.onStartup(companion.init(agoraVideoCallConfig, userSummaryInfo, user, str, channelEventStartup, Long.valueOf(diffTimeInSecs)));
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
        getSoloSoloDownTimer().cancel();
        VoiceService.INSTANCE.getShared().stopAll();
        this.compositeDisposable.dispose();
    }

    public final void setBinding(@NotNull ViewVideoCallBinding viewVideoCallBinding) {
        Intrinsics.checkNotNullParameter(viewVideoCallBinding, "<set-?>");
        this.binding = viewVideoCallBinding;
    }

    public final void setDelegate(@Nullable AnsweredListener answeredListener) {
        this.delegate = answeredListener;
    }

    public final void show() {
        String str;
        getSoloSoloDownTimer().start();
        VoiceService.Companion companion = VoiceService.INSTANCE;
        companion.getShared().stopAll();
        VoiceService shared = companion.getShared();
        VoiceModel.Companion companion2 = VoiceModel.INSTANCE;
        long currentTimeMillis = System.currentTimeMillis();
        Context context = this.context;
        if (context != null) {
            str = context.getPackageName();
        } else {
            str = null;
        }
        Uri parse = Uri.parse("android.resource://" + str + "/2131886103");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        shared.playVoice(companion2.create(currentTimeMillis, parse, new VoiceConfig(true)));
        this.binding.getRoot().setVisibility(0);
    }

    public /* synthetic */ AnsweredWrapper(ViewGroup viewGroup, VideoCallModel videoCallModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : videoCallModel);
    }
}
