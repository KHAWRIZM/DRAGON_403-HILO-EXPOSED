package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.CallStatus;
import com.qiahao.base_common.model.im.Identifier;
import com.qiahao.base_common.model.im.VideoCallTipsMessage;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.DialedPreloadModel;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.data.service.VideoCallService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.databinding.ViewVideoCallBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimer;
import com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener;
import com.qiahao.nextvideo.utilities.im.ImMessageUtil;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import io.agora.rtc.RtcEngine;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005*\u00012\u0018\u0000 52\u00020\u0001:\u00015B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\nJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedHelper;", "", "Landroid/view/ViewGroup;", "parent", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "preloadModel", "<init>", "(Landroid/view/ViewGroup;Lcom/qiahao/nextvideo/data/model/VideoCallModel;)V", "", "refreshView", "()V", "hangupImageViewPressed", "setupObserver", "show", "hide", "hangUp", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "getPreloadModel", "()Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewVideoCallBinding;)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;", "listener", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;", "getListener", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;", "setListener", "(Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer$delegate", "Lkotlin/Lazy;", "getSoloSoloDownTimer", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "soloSoloDownTimer", "com/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedHelper$mViewListener$1", "mViewListener", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedHelper$mViewListener$1;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDialedHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialedHelper.kt\ncom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedHelper\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,180:1\n61#2,9:181\n*S KotlinDebug\n*F\n+ 1 DialedHelper.kt\ncom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedHelper\n*L\n101#1:181,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DialedHelper {

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
    private DialedListener listener;

    @NotNull
    private final DialedHelper$mViewListener$1 mViewListener;

    @NotNull
    private final ViewGroup parent;

    @Nullable
    private final VideoCallModel preloadModel;

    /* renamed from: soloSoloDownTimer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy soloSoloDownTimer;

    /* JADX WARN: Type inference failed for: r2v5, types: [com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedHelper$mViewListener$1] */
    public DialedHelper(@NotNull ViewGroup viewGroup, @Nullable VideoCallModel videoCallModel) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.parent = viewGroup;
        this.preloadModel = videoCallModel;
        ViewVideoCallBinding inflate = ViewVideoCallBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.context = inflate.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        this.binding = inflate;
        this.compositeDisposable = new nd.a();
        this.soloSoloDownTimer = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.a
            public final Object invoke() {
                SoloDownTimer soloSoloDownTimer_delegate$lambda$2;
                soloSoloDownTimer_delegate$lambda$2 = DialedHelper.soloSoloDownTimer_delegate$lambda$2(DialedHelper.this);
                return soloSoloDownTimer_delegate$lambda$2;
            }
        });
        this.mViewListener = new View.OnAttachStateChangeListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedHelper$mViewListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View p0) {
                SoloDownTimer soloSoloDownTimer;
                Intrinsics.checkNotNullParameter(p0, "p0");
                DialedHelper.this.getBinding().getRoot().removeOnAttachStateChangeListener(this);
                soloSoloDownTimer = DialedHelper.this.getSoloSoloDownTimer();
                soloSoloDownTimer.cancel();
                DialedHelper.this.getCompositeDisposable().dispose();
            }
        };
        refreshView();
        getSoloSoloDownTimer().start();
        setupObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoloDownTimer getSoloSoloDownTimer() {
        return (SoloDownTimer) this.soloSoloDownTimer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hangupImageViewPressed() {
        String str;
        String matchUniqueID;
        DialedPreloadModel dialedPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig;
        ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
        VideoCallModel videoCallModel = this.preloadModel;
        String str2 = "";
        if (videoCallModel == null || (dialedPreloadModel = videoCallModel.getDialedPreloadModel()) == null || (agoraVideoCallConfig = dialedPreloadModel.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig.getToUserUID()) == null) {
            str = "";
        }
        imMessageUtil.sendVideoMessage(str, VideoCallTipsMessage.Companion.init$default(VideoCallTipsMessage.Companion, CallStatus.CANCELED, 0, (Identifier) null, 4, (Object) null));
        getSoloSoloDownTimer().cancel();
        VideoCallService shared = VideoCallService.INSTANCE.getShared();
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 != null && (matchUniqueID = videoCallModel2.getMatchUniqueID()) != null) {
            str2 = matchUniqueID;
        }
        shared.refuseVideoCall(str2);
        DialedListener dialedListener = this.listener;
        if (dialedListener != null) {
            dialedListener.onDialedHangup();
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
        this.binding.acceptImageView.setVisibility(8);
        QMUIRadiusImageView qMUIRadiusImageView = this.binding.avatarImageView;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarImageView");
        VideoCallModel videoCallModel = this.preloadModel;
        String str5 = null;
        if (videoCallModel != null && (imageUIModel = videoCallModel.getImageUIModel()) != null) {
            str = imageUIModel.getImageUrl();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        AppCompatImageView appCompatImageView = this.binding.countryFlagImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryFlagImageView");
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 != null && (countryIcon = videoCallModel2.getCountryIcon()) != null) {
            str2 = countryIcon.getImageUrl();
        } else {
            str2 = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
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
        ViewVideoCallBinding viewVideoCallBinding = this.binding;
        viewVideoCallBinding.pendingDescriptionTextView.setText(viewVideoCallBinding.getRoot().getContext().getString(2131954470));
        final ImageView imageView = this.binding.hangupImageView;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedHelper$refreshView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.hangupImageViewPressed();
                }
            }
        });
    }

    private final void setupObserver() {
        String str;
        String str2;
        int i;
        DialedPreloadModel dialedPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig;
        DialedPreloadModel dialedPreloadModel2;
        AgoraVideoCallConfig agoraVideoCallConfig2;
        DialedPreloadModel dialedPreloadModel3;
        AgoraVideoCallConfig agoraVideoCallConfig3;
        final Function2 function2 = new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.b
            public final Object invoke(Object obj, Object obj2) {
                Unit unit;
                unit = DialedHelper.setupObserver$lambda$4(DialedHelper.this, (String) obj, (Throwable) obj2);
                return unit;
            }
        };
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        nd.c subscribe = agoraRtcService.getRemoteVideoStatusRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new DialedHelper$setupObserver$1(this, function2), new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedHelper$setupObserver$2
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
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel == null || (dialedPreloadModel3 = videoCallModel.getDialedPreloadModel()) == null || (agoraVideoCallConfig3 = dialedPreloadModel3.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig3.getToken()) == null) {
            str = "";
        }
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 == null || (dialedPreloadModel2 = videoCallModel2.getDialedPreloadModel()) == null || (agoraVideoCallConfig2 = dialedPreloadModel2.getAgoraVideoCallConfig()) == null || (str2 = agoraVideoCallConfig2.getChannelID()) == null) {
            str2 = "";
        }
        VideoCallModel videoCallModel3 = this.preloadModel;
        if (videoCallModel3 != null && (dialedPreloadModel = videoCallModel3.getDialedPreloadModel()) != null && (agoraVideoCallConfig = dialedPreloadModel.getAgoraVideoCallConfig()) != null) {
            i = agoraVideoCallConfig.getLocalAgoraId();
        } else {
            i = 0;
        }
        AgoraRtcService.joinChannel$default(agoraRtcService, str, str2, null, i, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit setupObserver$lambda$4(DialedHelper dialedHelper, String str, Throwable th) {
        String str2;
        Toast normal$default;
        VideoCallModel videoCallModel;
        DialedListener dialedListener;
        String matchUniqueID;
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(th, "throwable");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = dialedHelper.context;
        String localizedMessage = th.getLocalizedMessage();
        String str3 = "";
        if (localizedMessage == null) {
            Context context2 = dialedHelper.context;
            if (context2 != null) {
                localizedMessage = context2.getString(2131952667);
            } else {
                localizedMessage = null;
            }
            if (localizedMessage == null) {
                str2 = "";
                normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                VideoCallService shared = VideoCallService.INSTANCE.getShared();
                videoCallModel = dialedHelper.preloadModel;
                if (videoCallModel != null && (matchUniqueID = videoCallModel.getMatchUniqueID()) != null) {
                    str3 = matchUniqueID;
                }
                shared.refuseVideoCall(str3);
                dialedListener = dialedHelper.listener;
                if (dialedListener != null) {
                    dialedListener.onDialedHangup();
                }
                return Unit.INSTANCE;
            }
        }
        str2 = localizedMessage;
        normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
        if (normal$default != null) {
        }
        VideoCallService shared2 = VideoCallService.INSTANCE.getShared();
        videoCallModel = dialedHelper.preloadModel;
        if (videoCallModel != null) {
            str3 = matchUniqueID;
        }
        shared2.refuseVideoCall(str3);
        dialedListener = dialedHelper.listener;
        if (dialedListener != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SoloDownTimer soloSoloDownTimer_delegate$lambda$2(final DialedHelper dialedHelper) {
        SoloDownTimer soloDownTimer = new SoloDownTimer(0L, 1, null);
        soloDownTimer.setListener(new SoloDownTimerListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedHelper$soloSoloDownTimer$2$1$1
            @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.SoloDownTimerListener
            public void onTimeout() {
                String str;
                Context context;
                Context context2;
                String str2;
                String string;
                DialedPreloadModel dialedPreloadModel;
                AgoraVideoCallConfig agoraVideoCallConfig;
                ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
                VideoCallModel preloadModel = DialedHelper.this.getPreloadModel();
                if (preloadModel == null || (dialedPreloadModel = preloadModel.getDialedPreloadModel()) == null || (agoraVideoCallConfig = dialedPreloadModel.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig.getToUserUID()) == null) {
                    str = "";
                }
                imMessageUtil.sendVideoMessage(str, VideoCallTipsMessage.Companion.init$default(VideoCallTipsMessage.Companion, CallStatus.TIMEOUT_REFUSE, 0, (Identifier) null, 4, (Object) null));
                HiloToasty.Companion companion = HiloToasty.Companion;
                context = DialedHelper.this.context;
                context2 = DialedHelper.this.context;
                if (context2 == null || (string = context2.getString(2131954258)) == null) {
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
                DialedListener listener = DialedHelper.this.getListener();
                if (listener != null) {
                    listener.onDialedHangup();
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
    public final DialedListener getListener() {
        return this.listener;
    }

    @NotNull
    public final ViewGroup getParent() {
        return this.parent;
    }

    @Nullable
    public final VideoCallModel getPreloadModel() {
        return this.preloadModel;
    }

    public final void hangUp() {
        this.binding.getRoot().removeOnAttachStateChangeListener(this.mViewListener);
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.stopAudioMixing();
        }
        getSoloSoloDownTimer().cancel();
        this.compositeDisposable.dispose();
    }

    public final void hide() {
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.stopAudioMixing();
        }
        getSoloSoloDownTimer().cancel();
        this.binding.getRoot().setVisibility(8);
    }

    public final void setBinding(@NotNull ViewVideoCallBinding viewVideoCallBinding) {
        Intrinsics.checkNotNullParameter(viewVideoCallBinding, "<set-?>");
        this.binding = viewVideoCallBinding;
    }

    public final void setListener(@Nullable DialedListener dialedListener) {
        this.listener = dialedListener;
    }

    public final void show() {
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.startAudioMixing("/assets3/specify_video_call_tips_audio.mp3", true, false, -1);
        }
        this.binding.getRoot().setVisibility(0);
    }

    public /* synthetic */ DialedHelper(ViewGroup viewGroup, VideoCallModel videoCallModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : videoCallModel);
    }
}
