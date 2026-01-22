package com.qiahao.nextvideo.ui.videocall.specifyuser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.TimerTask;
import com.oudi.utils.date.DateUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.TimerKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.common.ChannelEventStartup;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.model.im.CallStatus;
import com.qiahao.base_common.model.im.Identifier;
import com.qiahao.base_common.model.im.VideoCallTipsMessage;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.AnsweredPreloadModel;
import com.qiahao.nextvideo.data.model.DialedPreloadModel;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.data.service.voice.VoiceService;
import com.qiahao.nextvideo.data.video.VideoIMEntity;
import com.qiahao.nextvideo.databinding.ActivityVideoCallBinding;
import com.qiahao.nextvideo.databinding.VideoTipBinding;
import com.qiahao.nextvideo.room.dialog.UserMenuDialog;
import com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import com.qiahao.nextvideo.ui.videocall.matchinguser.BalloonViewUtil;
import com.qiahao.nextvideo.ui.videocall.matchinguser.VideoViewModel;
import com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredHelper;
import com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredListener;
import com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedHelper;
import com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedListener;
import com.qiahao.nextvideo.ui.videocall.tips.LocalMaskCoverWrapper;
import com.qiahao.nextvideo.ui.videocall.tips.RemoteMaskCoverWrapper;
import com.qiahao.nextvideo.ui.videocall.tips.RemoteMaskCoverWrapperDelegate;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.ui.webview.TextureVideoViewOutlineProvider;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.FileManager;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.qiahao.nextvideo.utilities.animation.GiftDispatcher;
import com.qiahao.nextvideo.utilities.animation.GiftNoticeUIModel;
import com.qiahao.nextvideo.utilities.im.ImMessageUtil;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import com.skydoves.balloon.Balloon;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.video.VideoCanvas;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.j0;
import io.reactivex.rxjava3.core.l0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.android.agoo.message.MessageService;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 w2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020!H\u0002¢\u0006\u0004\b+\u0010&J\u000f\u0010,\u001a\u00020\u0015H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0004J\r\u0010/\u001a\u00020\u0005¢\u0006\u0004\b/\u0010\u0004J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u0005¢\u0006\u0004\b4\u0010\u0004J\u000f\u00105\u001a\u00020\u0005H\u0014¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u00020\u0005H\u0014¢\u0006\u0004\b6\u0010\u0004R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010@R\u0016\u0010E\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010H\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010@R\u0016\u0010I\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010@R\u0016\u0010J\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001d\u0010`\u001a\u0004\u0018\u00010\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010X\u001a\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010FR\u0016\u0010b\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010FR\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010X\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010X\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010X\u001a\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010X\u001a\u0004\bt\u0010u¨\u0006x"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityVideoCallBinding;", "<init>", "()V", "", "initView", "showGiftDialog", "initObserve", "startTimerTask", "checkMeCamMeera", "Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "data", "playGift", "(Lcom/qiahao/nextvideo/data/model/GiftDateItem;)V", "checkRemoteCamMeera", "reportImageViewPressed", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "agoraVideoCallConfig", "startVideo", "(Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;)V", "", "type", "", "content", "showTip", "(ILjava/lang/String;)V", "removeRemoteVideo", "removeLocalVideo", "showCountDownView", "position", "showVipDialog", "(I)V", "", "isShowFace", "localFace", "(Z)V", "checkCloseFaceTip", "()Z", "processFaceResult", "exitVideo", "showRemoteMaskCover", "showLocalTip", "checkVideoPermission", "getLayoutResId", "()I", "onInitialize", "shootRemoteScreen", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/VideoEvent;)V", "startLocalVideo", "onResume", "onPause", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "preloadModel", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "Landroid/view/TextureView;", "remoteVideoView", "Landroid/view/TextureView;", "localVideoView", "", "mRemainingTime", "J", "Lcom/oudi/utils/TimerTask;", "videoTimerTask", "Lcom/oudi/utils/TimerTask;", "videoCallTotalDurationInSecs", "remoteUserFace", "Z", "localUserFace", "remoteTipDelay", "localTipDelay", "isExitVideo", "Lnd/a;", "compositeDisposable", "Lnd/a;", "reportImageUrl", "Ljava/lang/String;", "Lcom/skydoves/balloon/Balloon;", "mVideoTip", "Lcom/skydoves/balloon/Balloon;", "Landroid/os/CountDownTimer;", "timerTask", "Landroid/os/CountDownTimer;", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoViewModel;", "viewModel", "Lcom/qiahao/nextvideo/utilities/animation/GiftDispatcher;", "giftDispatcher$delegate", "getGiftDispatcher", "()Lcom/qiahao/nextvideo/utilities/animation/GiftDispatcher;", "giftDispatcher", "markRemoteFace", "markLocalFace", "Lcom/qiahao/nextvideo/ui/videocall/tips/LocalMaskCoverWrapper;", "localWrapper$delegate", "getLocalWrapper", "()Lcom/qiahao/nextvideo/ui/videocall/tips/LocalMaskCoverWrapper;", "localWrapper", "Lcom/qiahao/nextvideo/ui/videocall/tips/RemoteMaskCoverWrapper;", "remoteWrapper$delegate", "getRemoteWrapper", "()Lcom/qiahao/nextvideo/ui/videocall/tips/RemoteMaskCoverWrapper;", "remoteWrapper", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedHelper;", "dialedWrapper$delegate", "getDialedWrapper", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedHelper;", "dialedWrapper", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredHelper;", "answeredWrapper$delegate", "getAnsweredWrapper", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredHelper;", "answeredWrapper", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoCallActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoCallActivity.kt\ncom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1031:1\n61#2,9:1032\n61#2,9:1041\n61#2,9:1050\n61#2,9:1059\n61#2,9:1068\n61#2,9:1077\n61#2,9:1086\n61#2,9:1095\n61#2,9:1104\n61#2,9:1113\n61#2,9:1122\n1#3:1131\n*S KotlinDebug\n*F\n+ 1 VideoCallActivity.kt\ncom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallActivity\n*L\n284#1:1032,9\n285#1:1041,9\n290#1:1050,9\n298#1:1059,9\n305#1:1068,9\n309#1:1077,9\n313#1:1086,9\n316#1:1095,9\n319#1:1104,9\n322#1:1113,9\n737#1:1122,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoCallActivity extends HiloBaseBindingActivity<ActivityVideoCallBinding> {

    @NotNull
    public static final String CALL_DATA = "videoCallData";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "VideoCallActivity";

    @NotNull
    public static final String comingDeadlineTipAudioFile = "/assets/video_end_tip.mp3";
    private boolean isExitVideo;
    private boolean localUserFace;

    @Nullable
    private TextureView localVideoView;
    private long mRemainingTime;

    @Nullable
    private Balloon mVideoTip;

    @Nullable
    private VideoCallModel preloadModel;
    private boolean remoteUserFace;

    @Nullable
    private TextureView remoteVideoView;

    @Nullable
    private CountDownTimer timerTask;
    private long videoCallTotalDurationInSecs;

    @Nullable
    private TimerTask videoTimerTask;
    private long remoteTipDelay = 1000;
    private long localTipDelay = 1000;

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    @NotNull
    private String reportImageUrl = "";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.l
        public final Object invoke() {
            VideoViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = VideoCallActivity.viewModel_delegate$lambda$0(VideoCallActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: giftDispatcher$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy giftDispatcher = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.m
        public final Object invoke() {
            GiftDispatcher giftDispatcher_delegate$lambda$2;
            giftDispatcher_delegate$lambda$2 = VideoCallActivity.giftDispatcher_delegate$lambda$2(VideoCallActivity.this);
            return giftDispatcher_delegate$lambda$2;
        }
    });
    private boolean markRemoteFace = true;
    private boolean markLocalFace = true;

    /* renamed from: localWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy localWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.n
        public final Object invoke() {
            LocalMaskCoverWrapper localWrapper_delegate$lambda$3;
            localWrapper_delegate$lambda$3 = VideoCallActivity.localWrapper_delegate$lambda$3(VideoCallActivity.this);
            return localWrapper_delegate$lambda$3;
        }
    });

    /* renamed from: remoteWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy remoteWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.o
        public final Object invoke() {
            RemoteMaskCoverWrapper remoteWrapper_delegate$lambda$5;
            remoteWrapper_delegate$lambda$5 = VideoCallActivity.remoteWrapper_delegate$lambda$5(VideoCallActivity.this);
            return remoteWrapper_delegate$lambda$5;
        }
    });

    /* renamed from: dialedWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dialedWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.p
        public final Object invoke() {
            DialedHelper dialedWrapper_delegate$lambda$6;
            dialedWrapper_delegate$lambda$6 = VideoCallActivity.dialedWrapper_delegate$lambda$6(VideoCallActivity.this);
            return dialedWrapper_delegate$lambda$6;
        }
    });

    /* renamed from: answeredWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy answeredWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.q
        public final Object invoke() {
            AnsweredHelper answeredWrapper_delegate$lambda$7;
            answeredWrapper_delegate$lambda$7 = VideoCallActivity.answeredWrapper_delegate$lambda$7(VideoCallActivity.this);
            return answeredWrapper_delegate$lambda$7;
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallActivity$Companion;", "", "<init>", "()V", "CALL_DATA", "", "TAG", "comingDeadlineTipAudioFile", "start", "", "context", "Landroid/content/Context;", "callModel", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull VideoCallModel callModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callModel, "callModel");
            Intent intent = new Intent(context, (Class<?>) VideoCallActivity.class);
            intent.putExtra(VideoCallActivity.CALL_DATA, callModel);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final AnsweredHelper answeredWrapper_delegate$lambda$7(final VideoCallActivity videoCallActivity) {
        FrameLayout frameLayout = ((ActivityVideoCallBinding) videoCallActivity.getBinding()).tipsViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "tipsViewContainer");
        AnsweredHelper answeredHelper = new AnsweredHelper(frameLayout, videoCallActivity.preloadModel);
        answeredHelper.setMListener(new AnsweredListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$answeredWrapper$2$1
            @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredListener
            public void onAnswer() {
                AnsweredListener.DefaultImpls.onAnswer(this);
            }

            @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredListener
            public void onHangup() {
                VideoCallActivity.this.exitVideo();
            }

            @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered.AnsweredListener
            public void onStartup(VideoCallPreloadModel videoCallPreloadModel) {
                AnsweredListener.DefaultImpls.onStartup(this, videoCallPreloadModel);
            }
        });
        AppUtilitiesKt.vibrator(videoCallActivity, 600000L);
        ((ActivityVideoCallBinding) videoCallActivity.getBinding()).tipsViewContainer.addView(answeredHelper.getBinding().getRoot());
        return answeredHelper;
    }

    private final boolean checkCloseFaceTip() {
        VideoCallModel videoCallModel;
        VideoCallModel videoCallModel2;
        VideoCallModel videoCallModel3;
        VideoSetting otherVideoSetting;
        VideoSetting otherVideoSetting2;
        VideoSetting videoSetting;
        VideoSetting videoSetting2;
        VideoCallModel videoCallModel4 = this.preloadModel;
        if ((videoCallModel4 != null && (videoSetting2 = videoCallModel4.getVideoSetting()) != null && !videoSetting2.isFrontCamera()) || (((videoCallModel = this.preloadModel) != null && (videoSetting = videoCallModel.getVideoSetting()) != null && !videoSetting.isOpenCamera()) || (((videoCallModel2 = this.preloadModel) != null && (otherVideoSetting2 = videoCallModel2.getOtherVideoSetting()) != null && !otherVideoSetting2.isFrontCamera()) || ((videoCallModel3 = this.preloadModel) != null && (otherVideoSetting = videoCallModel3.getOtherVideoSetting()) != null && !otherVideoSetting.isOpenCamera())))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkMeCamMeera() {
        VideoSetting videoSetting;
        String str;
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel != null && (videoSetting = videoCallModel.getVideoSetting()) != null && !videoSetting.isOpenCamera()) {
            ((ActivityVideoCallBinding) getBinding()).meVideoLayout.setVisibility(0);
            QMUIRadiusImageView2 qMUIRadiusImageView2 = ((ActivityVideoCallBinding) getBinding()).meAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "meAvatar");
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                str = user.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, ImageView.ScaleType.FIT_XY, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231654, (c5.g) null, 49118, (Object) null);
            ((ActivityVideoCallBinding) getBinding()).closeCamera.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.icon_video_close_camera));
            return;
        }
        ((ActivityVideoCallBinding) getBinding()).meVideoLayout.setVisibility(8);
        ((ActivityVideoCallBinding) getBinding()).closeCamera.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.icon_video_open));
    }

    private final void checkRemoteCamMeera() {
        VideoSetting otherVideoSetting;
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel != null && (otherVideoSetting = videoCallModel.getOtherVideoSetting()) != null && !otherVideoSetting.isOpenCamera()) {
            getBinding().remoteVideoLayout.setVisibility(0);
        } else {
            getBinding().remoteVideoLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean checkVideoPermission() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(fa.b.f());
        arrayList.add(fa.b.o());
        boolean n = w9.h.n(this, arrayList);
        if (!n) {
            w9.h.t(this).q(arrayList).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.k
                public final void onResult(List list, List list2) {
                    VideoCallActivity.checkVideoPermission$lambda$46(VideoCallActivity.this, list, list2);
                }
            });
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkVideoPermission$lambda$46(VideoCallActivity videoCallActivity, List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty()) {
            videoCallActivity.startLocalVideo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialedHelper dialedWrapper_delegate$lambda$6(final VideoCallActivity videoCallActivity) {
        FrameLayout frameLayout = videoCallActivity.getBinding().tipsViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "tipsViewContainer");
        DialedHelper dialedHelper = new DialedHelper(frameLayout, videoCallActivity.preloadModel);
        dialedHelper.setListener(new DialedListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$dialedWrapper$2$1
            @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedListener
            public void onDialedHangup() {
                VideoCallActivity.this.exitVideo();
            }

            @Override // com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed.DialedListener
            public void onDialedStartup(VideoCallPreloadModel videoCallPreloadModel) {
                DialedListener.DefaultImpls.onDialedStartup(this, videoCallPreloadModel);
            }
        });
        videoCallActivity.getBinding().tipsViewContainer.addView(dialedHelper.getBinding().getRoot());
        return dialedHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void exitVideo() {
        VideoCallType videoCallType;
        String str;
        String str2;
        String str3;
        String matchUniqueID;
        AnsweredPreloadModel answeredPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig;
        String str4;
        DialedPreloadModel dialedPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig2;
        if (!this.isExitVideo) {
            MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
            matchingProvide.setMatchStatue("default");
            this.compositeDisposable.d();
            ((ActivityVideoCallBinding) getBinding()).queuePlayer.onCleared();
            this.isExitVideo = true;
            Vibrator vibrator = AppUtilitiesKt.getVibrator();
            if (vibrator != null) {
                vibrator.cancel();
            }
            TimerTask timerTask = this.videoTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.videoTimerTask = null;
            VideoCallModel videoCallModel = this.preloadModel;
            if (videoCallModel != null) {
                videoCallType = videoCallModel.getCallSpecifyType();
            } else {
                videoCallType = null;
            }
            if (videoCallType == VideoCallType.DIALED) {
                getDialedWrapper().hangUp();
            } else {
                getAnsweredWrapper().hangUp();
            }
            VoiceService.INSTANCE.getShared().stopAll();
            VideoCallMessage videoCallMessage = VideoCallMessage.INSTANCE;
            if (videoCallMessage.getTotalActiveTimeInMills() > 1) {
                VideoCallTipsMessage init$default = VideoCallTipsMessage.Companion.init$default(VideoCallTipsMessage.Companion, CallStatus.NORMAL, videoCallMessage.getTotalActiveTimeInMills() / 1000, (Identifier) null, 4, (Object) null);
                ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
                VideoCallModel videoCallModel2 = this.preloadModel;
                if (videoCallModel2 == null || (dialedPreloadModel = videoCallModel2.getDialedPreloadModel()) == null || (agoraVideoCallConfig2 = dialedPreloadModel.getAgoraVideoCallConfig()) == null || (str4 = agoraVideoCallConfig2.getToUserUID()) == null) {
                    str4 = "";
                }
                imMessageUtil.sendVideoMessage(str4, init$default);
            }
            removeLocalVideo();
            removeRemoteVideo();
            ((ActivityVideoCallBinding) getBinding()).tipsViewContainer.removeAllViews();
            AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
            RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
            if (rtcEngine != null) {
                rtcEngine.stopAudioMixing();
            }
            agoraRtcService.enableLocalVideo(false);
            RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
            if (rtcEngine2 != null) {
                rtcEngine2.stopPreview();
            }
            VideoCallModel videoCallModel3 = this.preloadModel;
            if (videoCallModel3 == null || (answeredPreloadModel = videoCallModel3.getAnsweredPreloadModel()) == null || (agoraVideoCallConfig = answeredPreloadModel.getAgoraVideoCallConfig()) == null || (str = agoraVideoCallConfig.getVideoUID()) == null) {
                str = "";
            }
            agoraRtcService.leaveChannel(str);
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            VideoCallModel videoCallModel4 = this.preloadModel;
            if (videoCallModel4 == null || (str2 = videoCallModel4.getMatchUniqueID()) == null) {
                str2 = "";
            }
            appRequestUtils.videoEnd(str2);
            matchingProvide.setVideoID(null);
            WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
            VideoCallModel videoCallModel5 = this.preloadModel;
            if (videoCallModel5 == null || (matchUniqueID = videoCallModel5.getMatchUniqueID()) == null) {
                str3 = "";
            } else {
                str3 = matchUniqueID;
            }
            WebSocketProvide.roomWebSocket$default(webSocketProvide, 153, str3, null, null, 12, null);
            finish();
        }
    }

    private final AnsweredHelper getAnsweredWrapper() {
        return (AnsweredHelper) this.answeredWrapper.getValue();
    }

    private final DialedHelper getDialedWrapper() {
        return (DialedHelper) this.dialedWrapper.getValue();
    }

    private final GiftDispatcher getGiftDispatcher() {
        return (GiftDispatcher) this.giftDispatcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalMaskCoverWrapper getLocalWrapper() {
        return (LocalMaskCoverWrapper) this.localWrapper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteMaskCoverWrapper getRemoteWrapper() {
        return (RemoteMaskCoverWrapper) this.remoteWrapper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoViewModel getViewModel() {
        return (VideoViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GiftDispatcher giftDispatcher_delegate$lambda$2(VideoCallActivity videoCallActivity) {
        GiftDispatcher giftDispatcher = new GiftDispatcher(videoCallActivity, 5);
        giftDispatcher.bind(videoCallActivity, ((ActivityVideoCallBinding) videoCallActivity.getBinding()).giftContainer);
        return giftDispatcher;
    }

    private final void initObserve() {
        getViewModel().getMException().observe(this, new VideoCallActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.c
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$20;
                initObserve$lambda$20 = VideoCallActivity.initObserve$lambda$20(VideoCallActivity.this, (Pair) obj);
                return initObserve$lambda$20;
            }
        }));
        getViewModel().getVideoSetting().observe(this, new VideoCallActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.d
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$21;
                initObserve$lambda$21 = VideoCallActivity.initObserve$lambda$21(VideoCallActivity.this, (VideoSetting) obj);
                return initObserve$lambda$21;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initObserve$lambda$20(VideoCallActivity videoCallActivity, Pair pair) {
        HiloException hiloException;
        String stringById;
        if (pair.getSecond() instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Object second = pair.getSecond();
            if (second instanceof HiloException) {
                hiloException = (HiloException) second;
            } else {
                hiloException = null;
            }
            if (hiloException == null || (stringById = hiloException.getErrorMessage()) == null) {
                stringById = ResourcesKtxKt.getStringById(videoCallActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, videoCallActivity, stringById, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, videoCallActivity, ResourcesKtxKt.getStringById(videoCallActivity, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (r0 != r1.intValue()) goto L١٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initObserve$lambda$21(VideoCallActivity videoCallActivity, VideoSetting videoSetting) {
        int i;
        VideoSetting videoSetting2;
        Integer frontOrBack;
        if (videoSetting != null) {
            VideoCallModel videoCallModel = videoCallActivity.preloadModel;
            if (videoCallModel != null && (videoSetting2 = videoCallModel.getVideoSetting()) != null && (frontOrBack = videoSetting2.getFrontOrBack()) != null) {
                i = frontOrBack.intValue();
            } else {
                i = 1;
            }
            Integer frontOrBack2 = videoSetting.getFrontOrBack();
            if (frontOrBack2 != null) {
            }
        }
        RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.switchCamera();
        }
        VideoCallModel videoCallModel2 = videoCallActivity.preloadModel;
        if (videoCallModel2 != null) {
            videoCallModel2.setVideoSetting(videoSetting);
        }
        videoCallActivity.checkMeCamMeera();
        videoCallActivity.processFaceResult();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        String str2;
        UserSummaryInfo toUser;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        Country country;
        Country country2;
        UserSummaryInfo toUser2;
        VideoCallModel videoCallModel;
        getWindow().addFlags(128);
        Intent intent = getIntent();
        if (intent != null && (videoCallModel = (VideoCallModel) intent.getParcelableExtra(CALL_DATA)) != null) {
            this.preloadModel = videoCallModel;
            MatchingProvide.INSTANCE.setVideoID(videoCallModel.getMatchUniqueID());
        }
        Toolbar toolbar = ((ActivityVideoCallBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.b
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$9;
                initView$lambda$9 = VideoCallActivity.initView$lambda$9(VideoCallActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$9;
            }
        });
        setStatusBarIconColor(false);
        cf.c.c().l(new VideoEvent("SPECIFY_VIDEO_CALL_DIALED_PENDING", new Object()));
        VideoCallMessage.INSTANCE.setTotalActiveTimeInMills(0);
        User user = UserStore.INSTANCE.getShared().getUser();
        String str8 = null;
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 != null && (toUser2 = videoCallModel2.getToUser()) != null) {
            str2 = toUser2.getExternalId();
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            VideoCallModel videoCallModel3 = this.preloadModel;
            if (videoCallModel3 != null) {
                toUser = videoCallModel3.getFromUser();
            }
            toUser = null;
        } else {
            VideoCallModel videoCallModel4 = this.preloadModel;
            if (videoCallModel4 != null) {
                toUser = videoCallModel4.getToUser();
            }
            toUser = null;
        }
        QMUIRadiusImageView2 qMUIRadiusImageView2 = ((ActivityVideoCallBinding) getBinding()).remoteAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "remoteAvatar");
        if (toUser != null) {
            str3 = toUser.getAvatar();
        } else {
            str3 = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231654, (c5.g) null, 49150, (Object) null);
        AppCompatTextView appCompatTextView = ((ActivityVideoCallBinding) getBinding()).nickName;
        if (toUser == null || (str4 = toUser.getName()) == null) {
            str4 = "";
        }
        appCompatTextView.setText(str4);
        AppCompatImageView appCompatImageView = ((ActivityVideoCallBinding) getBinding()).userAvatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
        if (toUser != null) {
            str5 = toUser.getAvatar();
        } else {
            str5 = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, str5, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
        ImageView imageView = ((ActivityVideoCallBinding) getBinding()).iconCount;
        Intrinsics.checkNotNullExpressionValue(imageView, "iconCount");
        if (toUser != null && (country2 = toUser.getCountry()) != null) {
            str6 = country2.getIcon();
        } else {
            str6 = null;
        }
        ImageKtxKt.loadImage$default(imageView, str6, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        if (toUser != null && (country = toUser.getCountry()) != null) {
            str7 = country.getIcon();
        } else {
            str7 = null;
        }
        if (TextUtils.isEmpty(str7)) {
            ((ActivityVideoCallBinding) getBinding()).iconCount.setVisibility(4);
        } else {
            ((ActivityVideoCallBinding) getBinding()).iconCount.setVisibility(0);
        }
        TextView textView = ((ActivityVideoCallBinding) getBinding()).countryName;
        if (toUser != null) {
            str8 = toUser.getCountryName();
        }
        textView.setText(str8);
        if (toUser != null) {
            z = Intrinsics.areEqual(toUser.isVip(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            ((ActivityVideoCallBinding) getBinding()).vipImage.setVisibility(0);
        } else {
            ((ActivityVideoCallBinding) getBinding()).vipImage.setVisibility(8);
        }
        if (checkVideoPermission()) {
            startLocalVideo();
        }
        final ImageView imageView2 = ((ActivityVideoCallBinding) getBinding()).reportImageView;
        final long j = 800;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    this.reportImageViewPressed();
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = ((ActivityVideoCallBinding) getBinding()).exitVideoCallImageView;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long j2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    j2 = this.videoCallTotalDurationInSecs;
                    if (j2 > 3) {
                        this.exitVideo();
                    }
                }
            }
        });
        final ImageView imageView3 = ((ActivityVideoCallBinding) getBinding()).change;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                VideoCallModel videoCallModel5;
                int i;
                VideoCallModel videoCallModel6;
                int i2;
                VideoCallModel videoCallModel7;
                String str9;
                VideoSetting videoSetting;
                Integer cameraOnOff;
                VideoSetting videoSetting2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    User user2 = UserStore.INSTANCE.getShared().getUser();
                    if (user2 == null || user2.isVip()) {
                        viewModel = this.getViewModel();
                        videoCallModel5 = this.preloadModel;
                        if (videoCallModel5 != null && (videoSetting2 = videoCallModel5.getVideoSetting()) != null) {
                            i = videoSetting2.changeCameraFront();
                        } else {
                            i = 1;
                        }
                        videoCallModel6 = this.preloadModel;
                        if (videoCallModel6 != null && (videoSetting = videoCallModel6.getVideoSetting()) != null && (cameraOnOff = videoSetting.getCameraOnOff()) != null) {
                            i2 = cameraOnOff.intValue();
                        } else {
                            i2 = 1;
                        }
                        videoCallModel7 = this.preloadModel;
                        if (videoCallModel7 != null) {
                            str9 = videoCallModel7.getMatchUniqueID();
                        } else {
                            str9 = null;
                        }
                        VideoViewModel.videoSetting$default(viewModel, i, i2, str9, null, 8, null);
                        return;
                    }
                    this.showVipDialog(12);
                }
            }
        });
        final ImageView imageView4 = ((ActivityVideoCallBinding) getBinding()).closeCamera;
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                VideoCallModel videoCallModel5;
                int i;
                VideoCallModel videoCallModel6;
                int i2;
                VideoCallModel videoCallModel7;
                String str9;
                VideoSetting videoSetting;
                VideoSetting videoSetting2;
                Integer frontOrBack;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                    User user2 = UserStore.INSTANCE.getShared().getUser();
                    if (user2 == null || user2.isVip()) {
                        viewModel = this.getViewModel();
                        videoCallModel5 = this.preloadModel;
                        if (videoCallModel5 != null && (videoSetting2 = videoCallModel5.getVideoSetting()) != null && (frontOrBack = videoSetting2.getFrontOrBack()) != null) {
                            i = frontOrBack.intValue();
                        } else {
                            i = 1;
                        }
                        videoCallModel6 = this.preloadModel;
                        if (videoCallModel6 != null && (videoSetting = videoCallModel6.getVideoSetting()) != null) {
                            i2 = videoSetting.switchCameraOpen();
                        } else {
                            i2 = 1;
                        }
                        videoCallModel7 = this.preloadModel;
                        if (videoCallModel7 != null) {
                            str9 = videoCallModel7.getMatchUniqueID();
                        } else {
                            str9 = null;
                        }
                        VideoViewModel.videoSetting$default(viewModel, i, i2, str9, null, 8, null);
                        return;
                    }
                    this.showVipDialog(11);
                }
            }
        });
        final ImageView imageView5 = ((ActivityVideoCallBinding) getBinding()).sendGift;
        imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView5) > j || (imageView5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView5, currentTimeMillis);
                    this.showGiftDialog();
                }
            }
        });
        final FrameLayout frameLayout = ((ActivityVideoCallBinding) getBinding()).praise;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityVideoCallBinding binding;
                VideoViewModel viewModel;
                VideoCallModel videoCallModel5;
                String str9;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    binding = this.getBinding();
                    if (binding.circleProgress.getProgress() == 100) {
                        viewModel = this.getViewModel();
                        videoCallModel5 = this.preloadModel;
                        if (videoCallModel5 != null) {
                            str9 = videoCallModel5.getMatchUniqueID();
                        } else {
                            str9 = null;
                        }
                        VideoViewModel.videoInter$default(viewModel, 1, 0, str9, null, 10, null);
                    }
                }
            }
        });
        final ImageView imageView6 = ((ActivityVideoCallBinding) getBinding()).flower;
        imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                VideoCallModel videoCallModel5;
                String str9;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView6) > j || (imageView6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView6, currentTimeMillis);
                    viewModel = this.getViewModel();
                    videoCallModel5 = this.preloadModel;
                    if (videoCallModel5 != null) {
                        str9 = videoCallModel5.getMatchUniqueID();
                    } else {
                        str9 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 2, 0, str9, null, 10, null);
                }
            }
        });
        final ImageView imageView7 = ((ActivityVideoCallBinding) getBinding()).love;
        imageView7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                VideoCallModel videoCallModel5;
                String str9;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView7) > j || (imageView7 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView7, currentTimeMillis);
                    viewModel = this.getViewModel();
                    videoCallModel5 = this.preloadModel;
                    if (videoCallModel5 != null) {
                        str9 = videoCallModel5.getMatchUniqueID();
                    } else {
                        str9 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 3, 0, str9, null, 10, null);
                }
            }
        });
        final ImageView imageView8 = ((ActivityVideoCallBinding) getBinding()).call;
        imageView8.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                VideoCallModel videoCallModel5;
                String str9;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView8) > j || (imageView8 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView8, currentTimeMillis);
                    viewModel = this.getViewModel();
                    videoCallModel5 = this.preloadModel;
                    if (videoCallModel5 != null) {
                        str9 = videoCallModel5.getMatchUniqueID();
                    } else {
                        str9 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 4, 0, str9, null, 10, null);
                }
            }
        });
        final ImageView imageView9 = ((ActivityVideoCallBinding) getBinding()).kiss;
        imageView9.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$initView$$inlined$singleClick$default$10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                VideoCallModel videoCallModel5;
                String str9;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView9) > j || (imageView9 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView9, currentTimeMillis);
                    viewModel = this.getViewModel();
                    videoCallModel5 = this.preloadModel;
                    if (videoCallModel5 != null) {
                        str9 = videoCallModel5.getMatchUniqueID();
                    } else {
                        str9 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 5, 0, str9, null, 10, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9(VideoCallActivity videoCallActivity, int i, int i2) {
        ViewKtxKt.setMargin(videoCallActivity.getBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void localFace(boolean isShowFace) {
        byte[] bytes;
        if (this.markLocalFace == isShowFace) {
            return;
        }
        this.markLocalFace = isShowFace;
        processFaceResult();
        if (!this.remoteUserFace || !this.localUserFace) {
            AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
            if (isShowFace) {
                bytes = MessageService.MSG_DB_NOTIFY_REACHED.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            } else {
                bytes = MessageService.MSG_DB_READY_REPORT.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            }
            agoraRtcService.sendStreamMessage(bytes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalMaskCoverWrapper localWrapper_delegate$lambda$3(VideoCallActivity videoCallActivity) {
        FrameLayout frameLayout = videoCallActivity.getBinding().tipsViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "tipsViewContainer");
        LocalMaskCoverWrapper localMaskCoverWrapper = new LocalMaskCoverWrapper(frameLayout);
        videoCallActivity.getBinding().tipsViewContainer.addView(localMaskCoverWrapper.getBinding().getRoot());
        return localMaskCoverWrapper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void playGift(GiftDateItem data) {
        try {
            if (StringKtxKt.checkEndSVGA(data.getEffectSvga())) {
                ((ActivityVideoCallBinding) getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(data));
            } else if (StringKtxKt.checkEndMP4(data.getEffectSvga())) {
                GiftHelp.INSTANCE.getVAP2(data, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.a
                    public final Object invoke(Object obj) {
                        Unit playGift$lambda$22;
                        playGift$lambda$22 = VideoCallActivity.playGift$lambda$22(VideoCallActivity.this, (VapMediaSource) obj);
                        return playGift$lambda$22;
                    }
                }, this);
            } else if (StringKtxKt.checkDefaultMP4(data.getEffectSvga())) {
                ((ActivityVideoCallBinding) getBinding()).queuePlayer.addQueue(new VideoMediaSource(StringKtxKt.urlMP4(data.getEffectSvga())));
            }
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playGift$lambda$22(VideoCallActivity videoCallActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        videoCallActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processFaceResult() {
        if (checkCloseFaceTip()) {
            getLocalWrapper().hide();
            getRemoteWrapper().hide();
        } else {
            if (this.remoteUserFace && this.localUserFace) {
                this.markLocalFace = true;
                this.markRemoteFace = true;
                getLocalWrapper().hide();
                getRemoteWrapper().hide();
                return;
            }
            getBinding().getRoot().postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.f
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCallActivity.processFaceResult$lambda$41(VideoCallActivity.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processFaceResult$lambda$41(VideoCallActivity videoCallActivity) {
        boolean z = videoCallActivity.remoteUserFace;
        if (z && videoCallActivity.localUserFace) {
            videoCallActivity.getLocalWrapper().hide();
            videoCallActivity.getRemoteWrapper().hide();
            return;
        }
        if (z && !videoCallActivity.localUserFace) {
            videoCallActivity.getLocalWrapper().hide();
            if (videoCallActivity.markRemoteFace) {
                videoCallActivity.getRemoteWrapper().hide();
                return;
            } else {
                videoCallActivity.showRemoteMaskCover();
                return;
            }
        }
        if (!z && videoCallActivity.localUserFace) {
            videoCallActivity.getRemoteWrapper().hide();
            if (videoCallActivity.markLocalFace) {
                videoCallActivity.getLocalWrapper().hide();
                return;
            } else {
                videoCallActivity.showLocalTip();
                return;
            }
        }
        boolean z2 = videoCallActivity.markLocalFace;
        if (z2 && videoCallActivity.markRemoteFace) {
            videoCallActivity.getLocalWrapper().hide();
            videoCallActivity.getRemoteWrapper().hide();
            return;
        }
        if (z2 && !videoCallActivity.markRemoteFace) {
            videoCallActivity.getLocalWrapper().hide();
            videoCallActivity.showRemoteMaskCover();
        } else if (!z2 && videoCallActivity.markRemoteFace) {
            videoCallActivity.showLocalTip();
            videoCallActivity.getRemoteWrapper().hide();
        } else {
            videoCallActivity.showLocalTip();
            videoCallActivity.getRemoteWrapper().hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteMaskCoverWrapper remoteWrapper_delegate$lambda$5(final VideoCallActivity videoCallActivity) {
        FrameLayout frameLayout = videoCallActivity.getBinding().tipsViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "tipsViewContainer");
        RemoteMaskCoverWrapper remoteMaskCoverWrapper = new RemoteMaskCoverWrapper(frameLayout);
        remoteMaskCoverWrapper.setDelegate(new RemoteMaskCoverWrapperDelegate() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$remoteWrapper$2$wrapper$1$1
            @Override // com.qiahao.nextvideo.ui.videocall.tips.RemoteMaskCoverWrapperDelegate
            public void remoteMaskCoverWrapperDelegateDidRematch() {
                VideoCallActivity.this.exitVideo();
            }

            @Override // com.qiahao.nextvideo.ui.videocall.tips.RemoteMaskCoverWrapperDelegate
            public void remoteMaskCoverWrapperDelegateDidRemove() {
                boolean z;
                RemoteMaskCoverWrapper remoteWrapper;
                boolean z2;
                LocalMaskCoverWrapper localWrapper;
                boolean z3;
                z = VideoCallActivity.this.localUserFace;
                if (z) {
                    return;
                }
                AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
                byte[] bytes = MessageService.MSG_DB_NOTIFY_CLICK.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                if (agoraRtcService.sendStreamMessage(bytes)) {
                    DebugToolsKt.printf(AgoraRtcService.TAG, "face allow remote user not face");
                    VideoCallActivity.this.localUserFace = true;
                    VideoCallActivity.this.markRemoteFace = true;
                    remoteWrapper = VideoCallActivity.this.getRemoteWrapper();
                    remoteWrapper.hide();
                    z2 = VideoCallActivity.this.markLocalFace;
                    if (!z2) {
                        z3 = VideoCallActivity.this.remoteUserFace;
                        if (!z3) {
                            VideoCallActivity.this.showLocalTip();
                            return;
                        }
                    }
                    localWrapper = VideoCallActivity.this.getLocalWrapper();
                    localWrapper.hide();
                    return;
                }
                HiloToasty.Companion companion = HiloToasty.Companion;
                BaseActivity baseActivity = VideoCallActivity.this;
                String string = baseActivity.getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        });
        videoCallActivity.getBinding().tipsViewContainer.addView(remoteMaskCoverWrapper.getBinding().getRoot());
        return remoteMaskCoverWrapper;
    }

    private final void removeLocalVideo() {
        TextureView textureView = this.localVideoView;
        if (textureView != null) {
            getBinding().localVideoViewContainer.removeView(textureView);
            this.localVideoView = null;
        }
    }

    private final void removeRemoteVideo() {
        TextureView textureView = this.remoteVideoView;
        if (textureView != null) {
            getBinding().remoteVideoViewContainer.removeView(textureView);
            this.remoteVideoView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reportImageViewPressed() {
        String str;
        UserSummaryInfo toUser;
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel == null || (toUser = videoCallModel.getToUser()) == null || (str = toUser.getExternalId()) == null) {
            str = "";
        }
        final UserMenuDialog userMenuDialog = new UserMenuDialog(this, str);
        userMenuDialog.setHideProfile(true);
        userMenuDialog.setHideDelete(true);
        userMenuDialog.setListener(new UserMenuInterfaces() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$reportImageViewPressed$1$1
            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickBlock(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                FeedbackService.INSTANCE.getShared().getReportEventRelay().accept(uid);
                VideoCallActivity.this.exitVideo();
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickDelete() {
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickDeleteSvip10() {
                UserMenuInterfaces.DefaultImpls.onClickDeleteSvip10(this);
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickPinned() {
                UserMenuInterfaces.DefaultImpls.onClickPinned(this);
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickProfile(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
            }

            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickReport(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                VideoCallActivity.this.shootRemoteScreen();
                new ReportWhiteDialog(VideoCallActivity.this).setListener(new VideoCallActivity$reportImageViewPressed$1$1$onClickReport$1(VideoCallActivity.this, uid, userMenuDialog)).show();
            }
        });
        userMenuDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shootRemoteScreen$lambda$25(VideoCallActivity videoCallActivity, j0 j0Var) {
        Bitmap bitmap;
        Number valueOf;
        Number valueOf2;
        Intrinsics.checkNotNullParameter(j0Var, "singleEmitter");
        TextureView textureView = videoCallActivity.remoteVideoView;
        String str = null;
        if (textureView != null) {
            if (textureView != null) {
                valueOf = Integer.valueOf(textureView.getWidth());
            } else {
                valueOf = Float.valueOf(0.0f);
            }
            int intValue = valueOf.intValue();
            TextureView textureView2 = videoCallActivity.remoteVideoView;
            if (textureView2 != null) {
                valueOf2 = Integer.valueOf(textureView2.getHeight());
            } else {
                valueOf2 = Float.valueOf(0.0f);
            }
            bitmap = textureView.getBitmap(intValue, valueOf2.intValue());
        } else {
            bitmap = null;
        }
        FileManager fileManager = FileManager.INSTANCE;
        VideoCallModel videoCallModel = videoCallActivity.preloadModel;
        if (videoCallModel != null) {
            str = videoCallModel.getMatchUniqueID();
        }
        File tempSendImgFile = fileManager.getTempSendImgFile(str + "_screen_snatshot");
        if (bitmap != null) {
            fileManager.saveBitmap2SelfDirectroy(bitmap, tempSendImgFile);
        }
        Object c = AliCloudService.uploadFileToAWS$default(AliCloudService.INSTANCE.getShared(), AliCloudService.OSS_FOLDER_FEEDBACK, tempSendImgFile, null, 4, null).c();
        Intrinsics.checkNotNullExpressionValue(c, "blockingGet(...)");
        Pair pair = (Pair) c;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            videoCallActivity.reportImageUrl = (String) pair.getSecond();
        }
        j0Var.onSuccess(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shootRemoteScreen$lambda$26(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shootRemoteScreen$lambda$27(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void showCountDownView() {
        getBinding().videoCallCountdownTextView.setVisibility(0);
        TimerTask timerTask = this.videoTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.videoTimerTask = null;
        this.videoTimerTask = TimerKtxKt.countTask(this, false, true, this.mRemainingTime, 1000L, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.r
            public final Object invoke(Object obj) {
                Unit showCountDownView$lambda$39;
                showCountDownView$lambda$39 = VideoCallActivity.showCountDownView$lambda$39(VideoCallActivity.this, ((Long) obj).longValue());
                return showCountDownView$lambda$39;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.s
            public final Object invoke() {
                Unit showCountDownView$lambda$40;
                showCountDownView$lambda$40 = VideoCallActivity.showCountDownView$lambda$40(VideoCallActivity.this);
                return showCountDownView$lambda$40;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showCountDownView$lambda$39(VideoCallActivity videoCallActivity, long j) {
        if (videoCallActivity.videoCallTotalDurationInSecs >= 3) {
            ((ActivityVideoCallBinding) videoCallActivity.getBinding()).exitVideoCallImageView.setImageDrawable(androidx.core.content.a.getDrawable(videoCallActivity, R.drawable.icon_video_exit));
        } else {
            ((ActivityVideoCallBinding) videoCallActivity.getBinding()).exitVideoCallImageView.setImageDrawable(androidx.core.content.a.getDrawable(videoCallActivity, R.drawable.icon_video_exit_no));
        }
        if (videoCallActivity.videoCallTotalDurationInSecs == 10) {
            videoCallActivity.showTip(2, ResourcesKtxKt.getStringById(videoCallActivity, 2131953136));
        }
        videoCallActivity.videoCallTotalDurationInSecs++;
        ((ActivityVideoCallBinding) videoCallActivity.getBinding()).videoCallCountdownTextView.setText(DateUtils.INSTANCE.format123Time(videoCallActivity.videoCallTotalDurationInSecs));
        if (3 > videoCallActivity.mRemainingTime) {
            AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
            RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
            if (rtcEngine != null) {
                rtcEngine.stopAudioMixing();
            }
            RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
            if (rtcEngine2 != null) {
                rtcEngine2.startAudioMixing("/assets/video_end_tip.mp3", true, false, 1, 0);
            }
        }
        videoCallActivity.mRemainingTime--;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCountDownView$lambda$40(VideoCallActivity videoCallActivity) {
        videoCallActivity.exitVideo();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGiftDialog() {
        String str;
        UserSummaryInfo toUser;
        String name;
        UserSummaryInfo toUser2;
        VideoCallModel videoCallModel = this.preloadModel;
        String str2 = "";
        if (videoCallModel == null || (toUser2 = videoCallModel.getToUser()) == null || (str = toUser2.getExternalId()) == null) {
            str = "";
        }
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 != null && (toUser = videoCallModel2.getToUser()) != null && (name = toUser.getName()) != null) {
            str2 = name;
        }
        new VideoGiftDialogFragment(str, str2, false).setListener(new VideoCallActivity$showGiftDialog$1(this)).show(getSupportFragmentManager(), "OtherGiftDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLocalTip() {
        getBinding().getRoot().postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.t
            @Override // java.lang.Runnable
            public final void run() {
                VideoCallActivity.showLocalTip$lambda$45(VideoCallActivity.this);
            }
        }, this.localTipDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showLocalTip$lambda$45(VideoCallActivity videoCallActivity) {
        if (!videoCallActivity.getLocalWrapper().isShowing()) {
            TextureView textureView = videoCallActivity.remoteVideoView;
            if (textureView != null) {
                Dimens dimens = Dimens.INSTANCE;
                Bitmap bitmap = textureView.getBitmap(dimens.getScreenWidth() / 5, dimens.getScreenHeight() / 5);
                if (bitmap != null) {
                    oe.d.b(videoCallActivity).b(2).a(bitmap).b(videoCallActivity.getLocalWrapper().getBinding().backgroundImageView);
                }
            }
            videoCallActivity.getLocalWrapper().show();
        }
        videoCallActivity.localTipDelay = 100L;
        videoCallActivity.remoteTipDelay = 100L;
    }

    private final void showRemoteMaskCover() {
        getBinding().getRoot().postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.g
            @Override // java.lang.Runnable
            public final void run() {
                VideoCallActivity.showRemoteMaskCover$lambda$43(VideoCallActivity.this, this);
            }
        }, this.remoteTipDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showRemoteMaskCover$lambda$43(VideoCallActivity videoCallActivity, VideoCallActivity videoCallActivity2) {
        if (!videoCallActivity.getRemoteWrapper().isShowing()) {
            TextureView textureView = videoCallActivity.remoteVideoView;
            if (textureView != null) {
                Dimens dimens = Dimens.INSTANCE;
                Bitmap bitmap = textureView.getBitmap(dimens.getScreenWidth() / 5, dimens.getScreenHeight() / 5);
                if (bitmap != null) {
                    oe.d.b(videoCallActivity2).b(2).a(bitmap).b(videoCallActivity.getRemoteWrapper().getBinding().backgroundImageView);
                }
            }
            videoCallActivity.getRemoteWrapper().show();
        }
        videoCallActivity.remoteTipDelay = 100L;
        videoCallActivity.localTipDelay = 100L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showTip(int type, String content) {
        int i;
        Balloon balloon = this.mVideoTip;
        if (balloon != null) {
            balloon.dismiss();
        }
        VideoTipBinding inflate = VideoTipBinding.inflate(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.contentTextView.setText(content);
        final AppCompatButton appCompatButton = inflate.okButton;
        final long j = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$showTip$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Balloon balloon2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    balloon2 = this.mVideoTip;
                    if (balloon2 != null) {
                        balloon2.dismiss();
                    }
                    this.mVideoTip = null;
                }
            }
        });
        BalloonViewUtil balloonViewUtil = BalloonViewUtil.INSTANCE;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        if (type == 1) {
            i = 130;
        } else {
            i = 50;
        }
        Balloon createView$default = BalloonViewUtil.createView$default(balloonViewUtil, this, root, 0, i, 4, null);
        this.mVideoTip = createView$default;
        if (createView$default != null) {
            View view = ((ActivityVideoCallBinding) getBinding()).placeholder;
            Intrinsics.checkNotNullExpressionValue(view, ImageSelectActivity.PLACEHOLDER);
            createView$default.show(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showVipDialog(int position) {
        new VipViewDialog(position, this).show();
    }

    private final void startTimerTask() {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$startTimerTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(10000L, 100L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ActivityVideoCallBinding binding;
                binding = VideoCallActivity.this.getBinding();
                binding.circleProgress.setProgress(100);
                VideoCallActivity.this.timerTask = null;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                ActivityVideoCallBinding binding;
                binding = VideoCallActivity.this.getBinding();
                long j = 10000;
                binding.circleProgress.setProgress((int) (((j - millisUntilFinished) * 100) / j));
            }
        };
        this.timerTask = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startVideo(VideoCallPreloadModel agoraVideoCallConfig) {
        VideoCallType videoCallType;
        long j;
        nd.c subscribe;
        nd.c subscribe2;
        VideoSetting videoSetting;
        RtcEngine rtcEngine;
        int i;
        Vibrator vibrator = AppUtilitiesKt.getVibrator();
        if (vibrator != null) {
            vibrator.cancel();
        }
        int i2 = 0;
        ((ActivityVideoCallBinding) getBinding()).topContainer.setVisibility(0);
        ((ActivityVideoCallBinding) getBinding()).buttonLayout.setVisibility(0);
        ((ActivityVideoCallBinding) getBinding()).imGroup.setVisibility(0);
        VideoCallModel videoCallModel = this.preloadModel;
        TextureView textureView = null;
        if (videoCallModel != null) {
            videoCallType = videoCallModel.getCallSpecifyType();
        } else {
            videoCallType = null;
        }
        if (videoCallType == VideoCallType.DIALED) {
            getDialedWrapper().hide();
        } else {
            getAnsweredWrapper().hide();
        }
        removeRemoteVideo();
        removeLocalVideo();
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.enableFaceDetection(true);
        }
        TextureView CreateTextureView = RtcEngine.CreateTextureView(this);
        if (CreateTextureView != null) {
            CreateTextureView.setOutlineProvider(new TextureVideoViewOutlineProvider(UiKtxKt.toPX(10)));
            CreateTextureView.setClipToOutline(true);
            ((ActivityVideoCallBinding) getBinding()).localVideoViewContainer.addView(CreateTextureView);
            textureView = CreateTextureView;
        }
        this.localVideoView = textureView;
        RtcEngine rtcEngine3 = agoraRtcService.getRtcEngine();
        if (rtcEngine3 != null) {
            TextureView textureView2 = this.localVideoView;
            VideoCallModel videoCallModel2 = this.preloadModel;
            if (videoCallModel2 != null) {
                i = videoCallModel2.getLocalAgoraId();
            } else {
                i = 0;
            }
            rtcEngine3.setupLocalVideo(new VideoCanvas(textureView2, 1, i));
        }
        Long remainingTime = agoraVideoCallConfig.getRemainingTime();
        if (remainingTime != null) {
            j = remainingTime.longValue();
        } else {
            j = 0;
        }
        this.mRemainingTime = j;
        TextureView CreateTextureView2 = RtcEngine.CreateTextureView(this);
        CreateTextureView2.setFitsSystemWindows(true);
        ((ActivityVideoCallBinding) getBinding()).remoteVideoViewContainer.addView(CreateTextureView2);
        this.remoteVideoView = CreateTextureView2;
        RtcEngine rtcEngine4 = agoraRtcService.getRtcEngine();
        if (rtcEngine4 != null) {
            TextureView textureView3 = this.remoteVideoView;
            VideoCallModel videoCallModel3 = this.preloadModel;
            if (videoCallModel3 != null) {
                i2 = videoCallModel3.getRemoteAgoraId();
            }
            rtcEngine4.setupRemoteVideo(new VideoCanvas(textureView3, 1, i2));
        }
        checkMeCamMeera();
        checkRemoteCamMeera();
        VideoCallModel videoCallModel4 = this.preloadModel;
        if (videoCallModel4 != null && (videoSetting = videoCallModel4.getVideoSetting()) != null && !videoSetting.isFrontCamera() && (rtcEngine = agoraRtcService.getRtcEngine()) != null) {
            rtcEngine.switchCamera();
        }
        startTimerTask();
        ((ActivityVideoCallBinding) getBinding()).praiseImage.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.e
            @Override // java.lang.Runnable
            public final void run() {
                VideoCallActivity.startVideo$lambda$35(VideoCallActivity.this);
            }
        });
        showCountDownView();
        io.reactivex.rxjava3.core.z observeOn = agoraRtcService.getFaceDetectionStateRelay().observeOn(RxUtilsKt.getMainThread());
        if (observeOn != null && (subscribe2 = observeOn.subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$startVideo$4
            public final void accept(Boolean bool) {
                try {
                    VideoCallActivity videoCallActivity = VideoCallActivity.this;
                    Intrinsics.checkNotNull(bool);
                    videoCallActivity.localFace(bool.booleanValue());
                } catch (Exception unused) {
                }
            }
        })) != null) {
            RxUtilsKt.addTo(subscribe2, this.compositeDisposable);
        }
        io.reactivex.rxjava3.core.z observeOn2 = agoraRtcService.getRemoteFaceStatusRelay().observeOn(RxUtilsKt.getMainThread());
        if (observeOn2 != null && (subscribe = observeOn2.subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity$startVideo$5
            public final void accept(Pair<Integer, String> pair) {
                try {
                    String str = (String) pair.getSecond();
                    if (Intrinsics.areEqual(str, MessageService.MSG_DB_READY_REPORT)) {
                        VideoCallActivity.this.markRemoteFace = false;
                    } else if (Intrinsics.areEqual(str, MessageService.MSG_DB_NOTIFY_REACHED)) {
                        VideoCallActivity.this.markRemoteFace = true;
                    } else {
                        VideoCallActivity.this.remoteUserFace = true;
                    }
                    VideoCallActivity.this.processFaceResult();
                } catch (Exception unused) {
                }
            }
        })) != null) {
            RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVideo$lambda$35(VideoCallActivity videoCallActivity) {
        videoCallActivity.showTip(1, ResourcesKtxKt.getStringById(videoCallActivity, 2131954416));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoViewModel viewModel_delegate$lambda$0(VideoCallActivity videoCallActivity) {
        return new ViewModelProvider(videoCallActivity).get(VideoViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_video_call;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        setShowGiftTip(false);
        initView();
        initObserve();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        exitVideo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        String str;
        super.onResume();
        MatchingProvide.INSTANCE.setMatchStatue(MatchingProvide.IS_VIDEO);
        WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
        VideoCallModel videoCallModel = this.preloadModel;
        if (videoCallModel == null || (str = videoCallModel.getMatchUniqueID()) == null) {
            str = "";
        }
        WebSocketProvide.roomWebSocket$default(webSocketProvide, 152, str, null, null, 12, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
    
        if (r2 == r0.getFrontOrBack()) goto L٤٤;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onVideoEvent(@NotNull VideoEvent event) {
        AgoraVideoCallConfig agoraVideoCallConfig;
        UserSummaryInfo userSummaryInfo;
        User user;
        AnsweredPreloadModel answeredPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig2;
        UserSummaryInfo toUser;
        AnsweredPreloadModel answeredPreloadModel2;
        DialedPreloadModel dialedPreloadModel;
        AgoraVideoCallConfig agoraVideoCallConfig3;
        String toUserUID;
        UserProxy1.VideoInteractionAct videoInteractionAct;
        String str;
        String str2;
        int i;
        VideoSetting videoSetting;
        Integer frontOrBack;
        String externalId;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        String str3 = "";
        String str4 = null;
        UserProxy1.GroupPublicInterMessage groupPublicInterMessage = null;
        UserProxy1.VideoSettingChange videoSettingChange = null;
        UserProxy1.GroupPublicTextMessage groupPublicTextMessage = null;
        UserProxy1.GroupPublicGiftMessage groupPublicGiftMessage = null;
        String str5 = null;
        VideoCallType videoCallType = null;
        str4 = null;
        str4 = null;
        switch (type.hashCode()) {
            case -2139604827:
                if (type.equals("remote_first_frame")) {
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.common.ChannelEventStartup");
                    ChannelEventStartup channelEventStartup = (ChannelEventStartup) data;
                    long diffTimeInSecs = channelEventStartup.getDiffTimeInSecs();
                    VideoCallPreloadModel.Companion companion = VideoCallPreloadModel.INSTANCE;
                    VideoCallModel videoCallModel = this.preloadModel;
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
                        str4 = agoraVideoCallConfig2.getVideoUID();
                    }
                    startVideo(companion.init(agoraVideoCallConfig, userSummaryInfo, user, str4, channelEventStartup, Long.valueOf(diffTimeInSecs)));
                    return;
                }
                return;
            case -1651848463:
                if (type.equals("SPECIFY_VIDEO_CALL_REFUSED")) {
                    VideoCallModel videoCallModel5 = this.preloadModel;
                    if (videoCallModel5 != null) {
                        videoCallType = videoCallModel5.getCallSpecifyType();
                    }
                    if (videoCallType == VideoCallType.DIALED) {
                        ImMessageUtil imMessageUtil = ImMessageUtil.INSTANCE;
                        VideoCallModel videoCallModel6 = this.preloadModel;
                        if (videoCallModel6 != null && (dialedPreloadModel = videoCallModel6.getDialedPreloadModel()) != null && (agoraVideoCallConfig3 = dialedPreloadModel.getAgoraVideoCallConfig()) != null && (toUserUID = agoraVideoCallConfig3.getToUserUID()) != null) {
                            str3 = toUserUID;
                        }
                        imMessageUtil.sendVideoMessage(str3, VideoCallTipsMessage.Companion.init$default(VideoCallTipsMessage.Companion, CallStatus.TIMEOUT_REFUSE, 0, (Identifier) null, 4, (Object) null));
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this, ResourcesKtxKt.getStringById(this, 2131954556), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    }
                    exitVideo();
                    return;
                }
                return;
            case -897235412:
                if (type.equals("SPECIFY_VIDEO_CALL_HANGUP")) {
                    exitVideo();
                    return;
                }
                return;
            case -409423403:
                if (type.equals("video_effect")) {
                    Object data2 = event.getData();
                    if (data2 instanceof UserProxy1.VideoInteractionAct) {
                        videoInteractionAct = (UserProxy1.VideoInteractionAct) data2;
                    } else {
                        videoInteractionAct = null;
                    }
                    if (videoInteractionAct != null) {
                        String videoUid = videoInteractionAct.getVideoUid();
                        VideoCallModel videoCallModel7 = this.preloadModel;
                        if (videoCallModel7 != null) {
                            str5 = videoCallModel7.getMatchUniqueID();
                        }
                        if (Intrinsics.areEqual(videoUid, str5)) {
                            AppUtilitiesKt.vibrator(this, 1200L);
                            String effect = videoInteractionAct.getEffect();
                            Intrinsics.checkNotNullExpressionValue(effect, "getEffect(...)");
                            playGift(new GiftDateItem(effect, "", "", null, null, GiftDateItem.TYPE_GIFT, null, null, null, null, null, null, null, null, null, 32728, null));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case -358171737:
                if (type.equals("video_im_gift")) {
                    Object data3 = event.getData();
                    if (data3 instanceof UserProxy1.GroupPublicGiftMessage) {
                        groupPublicGiftMessage = (UserProxy1.GroupPublicGiftMessage) data3;
                    }
                    if (groupPublicGiftMessage != null) {
                        ((ActivityVideoCallBinding) getBinding()).videoIM.addMessage(new VideoIMEntity(null, null, null, null, 174, 15, null).analyzeData(groupPublicGiftMessage));
                        String effectSvga = groupPublicGiftMessage.getGiftInfo().getEffectSvga();
                        Intrinsics.checkNotNullExpressionValue(effectSvga, "getEffectSvga(...)");
                        String sendUserAvatar = groupPublicGiftMessage.getGiftInfo().getSendUserAvatar();
                        Intrinsics.checkNotNullExpressionValue(sendUserAvatar, "getSendUserAvatar(...)");
                        String receiverAvatar = groupPublicGiftMessage.getGiftInfo().getReceiverAvatar();
                        Intrinsics.checkNotNullExpressionValue(receiverAvatar, "getReceiverAvatar(...)");
                        String sendUserAvatar2 = groupPublicGiftMessage.getGiftInfo().getSendUserAvatar();
                        if (sendUserAvatar2 == null) {
                            str = "";
                        } else {
                            str = sendUserAvatar2;
                        }
                        String receiverAvatar2 = groupPublicGiftMessage.getGiftInfo().getReceiverAvatar();
                        if (receiverAvatar2 == null) {
                            str2 = "";
                        } else {
                            str2 = receiverAvatar2;
                        }
                        UserProxy.GiftInfo giftInfo = groupPublicGiftMessage.getGiftInfo();
                        Intrinsics.checkNotNullExpressionValue(giftInfo, "getGiftInfo(...)");
                        playGift(new GiftDateItem(effectSvga, sendUserAvatar, receiverAvatar, null, null, GiftDateItem.TYPE_GIFT, null, null, str, str2, null, DataExternalKt.toTextStyleList(giftInfo), groupPublicGiftMessage.getGiftInfo().getReceiveUserNick(), groupPublicGiftMessage.getGiftInfo().getSendUserNick(), groupPublicGiftMessage.getGiftInfo().getGiftText(), 1240, null));
                        GiftNoticeUIModel.Companion companion2 = GiftNoticeUIModel.INSTANCE;
                        long giftId = groupPublicGiftMessage.getGiftInfo().getGiftId();
                        String icon = groupPublicGiftMessage.getGiftInfo().getIcon();
                        Intrinsics.checkNotNullExpressionValue(icon, "getIcon(...)");
                        GiftNoticeUIModel init = companion2.init(giftId, icon, groupPublicGiftMessage.getUser(), groupPublicGiftMessage.getToUser(), groupPublicGiftMessage.getGiftInfo().getNum());
                        GiftDispatcher giftDispatcher = getGiftDispatcher();
                        if (giftDispatcher != null) {
                            giftDispatcher.offer(init);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case -357787740:
                if (type.equals("video_im_text")) {
                    Object data4 = event.getData();
                    if (data4 instanceof UserProxy1.GroupPublicTextMessage) {
                        groupPublicTextMessage = (UserProxy1.GroupPublicTextMessage) data4;
                    }
                    if (groupPublicTextMessage != null) {
                        ((ActivityVideoCallBinding) getBinding()).videoIM.addMessage(new VideoIMEntity(null, null, null, null, 173, 15, null).analyzeData(groupPublicTextMessage));
                        return;
                    }
                    return;
                }
                return;
            case -355824283:
                if (type.equals("videoSettingChange")) {
                    Object data5 = event.getData();
                    if (data5 instanceof UserProxy1.VideoSettingChange) {
                        videoSettingChange = (UserProxy1.VideoSettingChange) data5;
                    }
                    if (videoSettingChange != null) {
                        String externalId2 = videoSettingChange.getExternalId();
                        User user2 = UserStore.INSTANCE.getShared().getUser();
                        if (user2 != null && (externalId = user2.getExternalId()) != null) {
                            str3 = externalId;
                        }
                        if (Intrinsics.areEqual(externalId2, str3)) {
                            UserProxy.VideoSetting videoSetting2 = videoSettingChange.getVideoSetting();
                            if (videoSetting2 != null) {
                                VideoCallModel videoCallModel8 = this.preloadModel;
                                if (videoCallModel8 != null && (videoSetting = videoCallModel8.getVideoSetting()) != null && (frontOrBack = videoSetting.getFrontOrBack()) != null) {
                                    i = frontOrBack.intValue();
                                } else {
                                    i = 1;
                                }
                                break;
                            }
                            RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
                            if (rtcEngine != null) {
                                rtcEngine.switchCamera();
                            }
                            VideoCallModel videoCallModel9 = this.preloadModel;
                            if (videoCallModel9 != null) {
                                UserProxy.VideoSetting videoSetting3 = videoSettingChange.getVideoSetting();
                                Intrinsics.checkNotNullExpressionValue(videoSetting3, "getVideoSetting(...)");
                                videoCallModel9.setVideoSetting(DataExternalKt.toVideoSet(videoSetting3));
                            }
                            checkMeCamMeera();
                            return;
                        }
                        VideoCallModel videoCallModel10 = this.preloadModel;
                        if (videoCallModel10 != null) {
                            UserProxy.VideoSetting videoSetting4 = videoSettingChange.getVideoSetting();
                            Intrinsics.checkNotNullExpressionValue(videoSetting4, "getVideoSetting(...)");
                            videoCallModel10.setOtherVideoSetting(DataExternalKt.toVideoSet(videoSetting4));
                        }
                        checkRemoteCamMeera();
                        return;
                    }
                    return;
                }
                return;
            case 1556092859:
                if (type.equals("video_im_interaction")) {
                    Object data6 = event.getData();
                    if (data6 instanceof UserProxy1.GroupPublicInterMessage) {
                        groupPublicInterMessage = (UserProxy1.GroupPublicInterMessage) data6;
                    }
                    if (groupPublicInterMessage != null) {
                        ((ActivityVideoCallBinding) getBinding()).videoIM.addMessage(new VideoIMEntity(null, null, null, null, 175, 15, null).analyzeData(groupPublicInterMessage));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void shootRemoteScreen() {
        i0 d = i0.d(new l0() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.h
            public final void a(j0 j0Var) {
                VideoCallActivity.shootRemoteScreen$lambda$25(VideoCallActivity.this, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(d, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.i
            public final Object invoke(Object obj) {
                Unit shootRemoteScreen$lambda$26;
                shootRemoteScreen$lambda$26 = VideoCallActivity.shootRemoteScreen$lambda$26((Boolean) obj);
                return shootRemoteScreen$lambda$26;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.specifyuser.j
            public final Object invoke(Object obj) {
                Unit shootRemoteScreen$lambda$27;
                shootRemoteScreen$lambda$27 = VideoCallActivity.shootRemoteScreen$lambda$27((Throwable) obj);
                return shootRemoteScreen$lambda$27;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startLocalVideo() {
        VideoCallType videoCallType;
        int i;
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        agoraRtcService.enableVideo(true);
        agoraRtcService.enableLocalVideo(true);
        TextureView CreateTextureView = RtcEngine.CreateTextureView(this);
        CreateTextureView.setFitsSystemWindows(true);
        ((ActivityVideoCallBinding) getBinding()).remoteVideoViewContainer.addView(CreateTextureView);
        this.remoteVideoView = CreateTextureView;
        RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
        if (rtcEngine != null) {
            TextureView textureView = this.remoteVideoView;
            VideoCallModel videoCallModel = this.preloadModel;
            if (videoCallModel != null) {
                i = videoCallModel.getLocalAgoraId();
            } else {
                i = 0;
            }
            rtcEngine.setupLocalVideo(new VideoCanvas(textureView, 1, i));
        }
        RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.startPreview();
        }
        VideoCallModel videoCallModel2 = this.preloadModel;
        if (videoCallModel2 != null) {
            videoCallType = videoCallModel2.getCallSpecifyType();
        } else {
            videoCallType = null;
        }
        if (videoCallType == VideoCallType.DIALED) {
            getDialedWrapper().show();
        } else {
            getAnsweredWrapper().show();
        }
    }
}
