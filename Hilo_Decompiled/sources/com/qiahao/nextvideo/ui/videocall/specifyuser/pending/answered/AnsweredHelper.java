package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.AnsweredPreloadModel;
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
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimer;
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005*\u00010\u0018\u0000 32\u00020\u0001:\u00013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\nJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredHelper;", "", "Landroid/view/ViewGroup;", "parent", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "preloadModel", "<init>", "(Landroid/view/ViewGroup;Lcom/qiahao/nextvideo/data/model/VideoCallModel;)V", "", "refreshView", "()V", "hangupImageViewPressed", "setupObserver", "acceptImageViewPressed", "show", "hide", "hangUp", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "getPreloadModel", "()Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;)V", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;", "mListener", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;)V", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer$delegate", "Lkotlin/Lazy;", "getSoloSoloDownTimer", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer", "com/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredHelper$mViewListener$1", "mViewListener", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredHelper$mViewListener$1;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnsweredHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnsweredHelper.kt\ncom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredHelper\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n61#2,9:200\n61#2,9:209\n1#3:218\n*S KotlinDebug\n*F\n+ 1 AnsweredHelper.kt\ncom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredHelper\n*L\n88#1:200,9\n91#1:209,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnsweredHelper {

    @NotNull
    private static final String TAG = "AnsweredWrapper";

    @NotNull
    private ViewVideoCallBinding binding;

    @NotNull
    private final nd.a compositeDisposable;

    @Nullable
    private Context context;

    @Nullable
    private AnsweredListener mListener;

    @NotNull
    private final AnsweredHelper$mViewListener$1 mViewListener;

    @Nullable
    private final VideoCallModel preloadModel;

    /* renamed from: soloSoloDownTimer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy soloSoloDownTimer;

    /* JADX WARN: Type inference failed for: r2v4, types: [com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper$mViewListener$1] */
    public AnsweredHelper(@NotNull ViewGroup viewGroup, @Nullable VideoCallModel videoCallModel) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.preloadModel = videoCallModel;
        this.compositeDisposable = new nd.a();
        ViewVideoCallBinding inflate = ViewVideoCallBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.context = inflate.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        this.binding = inflate;
        this.soloSoloDownTimer = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.b
            public final Object invoke() {
                SoloDownTimer soloSoloDownTimer_delegate$lambda$2;
                soloSoloDownTimer_delegate$lambda$2 = AnsweredHelper.soloSoloDownTimer_delegate$lambda$2(AnsweredHelper.this);
                return soloSoloDownTimer_delegate$lambda$2;
            }
        });
        this.mViewListener = new View.OnAttachStateChangeListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper$mViewListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View p0) {
                SoloDownTimer soloSoloDownTimer;
                Intrinsics.checkNotNullParameter(p0, "p0");
                AnsweredHelper.this.getBinding().getRoot().removeOnAttachStateChangeListener(this);
                soloSoloDownTimer = AnsweredHelper.this.getSoloSoloDownTimer();
                soloSoloDownTimer.cancel();
                VoiceService.INSTANCE.getShared().stopAll();
                AnsweredHelper.this.getCompositeDisposable().dispose();
            }
        };
        refreshView();
        setupObserver();
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.accept(str), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.c
            public final Object invoke(Object obj) {
                Unit acceptImageViewPressed$lambda$7;
                acceptImageViewPressed$lambda$7 = AnsweredHelper.acceptImageViewPressed$lambda$7((ApiResponse) obj);
                return acceptImageViewPressed$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.d
            public final Object invoke(Object obj) {
                Unit acceptImageViewPressed$lambda$9;
                acceptImageViewPressed$lambda$9 = AnsweredHelper.acceptImageViewPressed$lambda$9(AnsweredHelper.this, (Throwable) obj);
                return acceptImageViewPressed$lambda$9;
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
        AnsweredListener answeredListener = this.mListener;
        if (answeredListener != null) {
            answeredListener.onAnswer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptImageViewPressed$lambda$7(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptImageViewPressed$lambda$9(AnsweredHelper answeredHelper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        Context context = answeredHelper.context;
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
        AnsweredListener answeredListener = answeredHelper.mListener;
        if (answeredListener != null) {
            answeredListener.onHangup();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoloDownTimer getSoloSoloDownTimer() {
        return (SoloDownTimer) this.soloSoloDownTimer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hangupImageViewPressed() {
        String str;
        getSoloSoloDownTimer().cancel();
        VideoCallService shared = VideoCallService.INSTANCE.getShared();
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel == null || (str = videoCallModel.getMatchUniqueID()) == null) {
            str = "";
        }
        shared.refuseVideoCall(str);
        AnsweredListener answeredListener = this.mListener;
        if (answeredListener != null) {
            answeredListener.onHangup();
        }
    }

    private final void refreshView() {
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String nickname;
        String nickname2;
        ImageUIModel countryIcon;
        ImageUIModel imageUIModel;
        this.binding.getRoot().addOnAttachStateChangeListener(this.mViewListener);
        ViewVideoCallBinding viewVideoCallBinding = this.binding;
        viewVideoCallBinding.pendingDescriptionTextView.setText(viewVideoCallBinding.getRoot().getContext().getString(2131953143));
        QMUIRadiusImageView qMUIRadiusImageView = this.binding.avatarImageView;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarImageView");
        VideoCallModel videoCallModel = this.preloadModel;
        String str5 = null;
        if (videoCallModel != null && (imageUIModel = videoCallModel.getImageUIModel()) != null) {
            str = imageUIModel.getImageUrl();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        AppCompatImageView appCompatImageView = this.binding.countryFlagImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryFlagImageView");
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 != null && (countryIcon = videoCallModel2.getCountryIcon()) != null) {
            str2 = countryIcon.getImageUrl();
        } else {
            str2 = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        AppCompatTextView appCompatTextView = this.binding.nicknameTextView;
        VideoCallModel videoCallModel3 = this.preloadModel;
        if (videoCallModel3 != null && (nickname2 = videoCallModel3.getNickname()) != null) {
            i = nickname2.length();
        } else {
            i = 0;
        }
        if (i > 9) {
            VideoCallModel videoCallModel4 = this.preloadModel;
            if (videoCallModel4 != null && (nickname = videoCallModel4.getNickname()) != null) {
                str4 = nickname.substring(0, 9);
                Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
            } else {
                str4 = null;
            }
            str3 = str4 + "…";
        } else {
            VideoCallModel videoCallModel5 = this.preloadModel;
            if (videoCallModel5 != null) {
                str3 = videoCallModel5.getNickname();
            } else {
                str3 = null;
            }
        }
        appCompatTextView.setText(str3);
        AppCompatTextView appCompatTextView2 = this.binding.countryProvinceTextView;
        VideoCallModel videoCallModel6 = this.preloadModel;
        if (videoCallModel6 != null) {
            str5 = videoCallModel6.getCountryName();
        }
        appCompatTextView2.setText(str5);
        final ImageView imageView = this.binding.hangupImageView;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper$refreshView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.hangupImageViewPressed();
                }
            }
        });
        final ImageView imageView2 = this.binding.acceptImageView;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper$refreshView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    if (meetingRoomManager.isRoomSmall()) {
                        MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
                        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
                    } else {
                        cf.c.c().l(new RoomEvent().setEventId(300));
                    }
                    this.getBinding().acceptImageView.setVisibility(8);
                    ImageView imageView3 = this.getBinding().acceptImageView;
                    final AnsweredHelper answeredHelper = this;
                    imageView3.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper$refreshView$2$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnsweredHelper.this.acceptImageViewPressed();
                        }
                    }, 1000L);
                }
            }
        });
    }

    private final void setupObserver() {
        final Function2 function2 = new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.a
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = AnsweredHelper.setupObserver$lambda$6(AnsweredHelper.this, (String) obj, (Throwable) obj2);
                return unit;
            }
        };
        nd.c subscribe = AgoraRtcService.INSTANCE.getRemoteVideoStatusRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new AnsweredHelper$setupObserver$1(this, function2), new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper$setupObserver$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "throwable");
                function2.invoke("wait call-ready in channel", th);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupObserver$lambda$6(AnsweredHelper answeredHelper, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(th, "throwable");
        Context context = answeredHelper.context;
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
        AnsweredListener answeredListener = answeredHelper.mListener;
        if (answeredListener != null) {
            answeredListener.onHangup();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SoloDownTimer soloSoloDownTimer_delegate$lambda$2(final AnsweredHelper answeredHelper) {
        SoloDownTimer soloDownTimer = new SoloDownTimer(0L, 1, null);
        soloDownTimer.setListener(new SoloDownTimerListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper$soloSoloDownTimer$2$1$1
            @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener
            public void onTimeout() {
                AnsweredListener mListener = AnsweredHelper.this.getMListener();
                if (mListener != null) {
                    mListener.onHangup();
                }
            }
        });
        return soloDownTimer;
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
    public final AnsweredListener getMListener() {
        return this.mListener;
    }

    @Nullable
    public final VideoCallModel getPreloadModel() {
        return this.preloadModel;
    }

    public final void hangUp() {
        getSoloSoloDownTimer().cancel();
        VoiceService.INSTANCE.getShared().stopAll();
        this.compositeDisposable.dispose();
    }

    public final void hide() {
        getSoloSoloDownTimer().cancel();
        this.compositeDisposable.dispose();
        VoiceService.INSTANCE.getShared().stopAll();
        this.binding.getRoot().setVisibility(8);
        this.binding.getRoot().removeOnAttachStateChangeListener(this.mViewListener);
    }

    public final void setBinding(@NotNull ViewVideoCallBinding viewVideoCallBinding) {
        Intrinsics.checkNotNullParameter(viewVideoCallBinding, "<set-?>");
        this.binding = viewVideoCallBinding;
    }

    public final void setMListener(@Nullable AnsweredListener answeredListener) {
        this.mListener = answeredListener;
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

    public /* synthetic */ AnsweredHelper(ViewGroup viewGroup, VideoCallModel videoCallModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : videoCallModel);
    }
}
