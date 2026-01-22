package com.qiahao.nextvideo.ui.videocall.matchinguser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.data.video.VideoIMEntity;
import com.qiahao.nextvideo.databinding.ActivityMatchVideoBinding;
import com.qiahao.nextvideo.databinding.VideoTipBinding;
import com.qiahao.nextvideo.room.dialog.UserMenuDialog;
import com.qiahao.nextvideo.room.dialog.VideoGiftDialogFragment;
import com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloon;
import com.qiahao.nextvideo.ui.reusable.LocalMaskCoverWrapper;
import com.qiahao.nextvideo.ui.reusable.RemoteListener;
import com.qiahao.nextvideo.ui.reusable.RemoteMaskCoverWrapper;
import com.qiahao.nextvideo.ui.reusable.views.DrawableTextView;
import com.qiahao.nextvideo.ui.videocall.CountDownTimerPreloadModel;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.FileManager;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.animation.GiftDispatcher;
import com.qiahao.nextvideo.utilities.animation.GiftNoticeUIModel;
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
import java.util.Arrays;
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

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u001f\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010\u0017J\u000f\u0010&\u001a\u00020\u001aH\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0005¢\u0006\u0004\b1\u0010\u0004J\r\u00102\u001a\u00020\u0005¢\u0006\u0004\b2\u0010\u0004J\u0017\u00104\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\u001a¢\u0006\u0004\b4\u0010$J\u000f\u00105\u001a\u00020\u0005H\u0014¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u00020\u0005H\u0014¢\u0006\u0004\b6\u0010\u0004R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010BR\u0016\u0010K\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010BR\u0016\u0010L\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010IR\u0016\u0010M\u001a\u00020G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010IR\u0016\u0010N\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010BR\u0016\u0010Q\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010BR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001d\u0010b\u001a\u0004\u0018\u00010^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010Z\u001a\u0004\b`\u0010aR\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010Z\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010Z\u001a\u0004\bj\u0010k¨\u0006n"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/MatchVideoActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityMatchVideoBinding;", "<init>", "()V", "", "initView", "oppositeLikeYou", "initObserver", "refreshTopUI", "showGiftDialog", "startTimerTask", "checkMeCamMeera", "Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "data", "playGift", "(Lcom/qiahao/nextvideo/data/model/GiftDateItem;)V", "checkRemoteCamMeera", "", "isShowFace", "publishLocalFaceDetectionResult", "(Z)V", "checkCloseFaceTip", "()Z", "processFaceResult", "showRemoteMaskCover", "", "type", "", "content", "showTip", "(ILjava/lang/String;)V", "showNotFaceLocalTipMaskCover", "reportImageViewPressed", "position", "showVipDialog", "(I)V", "checkVideoPermission", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/VideoEvent;)V", "Landroid/graphics/Bitmap;", "pictureBitmap", "reportUnionUserPicture", "(Landroid/graphics/Bitmap;)V", "shootRemoteScreen", "startLocalVideo", "endType", "exitVideo", "onResume", "onPause", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "preloadModel", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "Landroid/view/TextureView;", "remoteVideoView", "Landroid/view/TextureView;", "localVideoView", "Lnd/a;", "compositeDisposable", "Lnd/a;", "markRemoteFace", "Z", "remoteShowFace", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoDownTimer;", "videoDownTimer", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoDownTimer;", "", "videoCallTotal", "J", "markLocalFace", "localShowFace", "remoteDelay", "localTipDelay", "reportImageUrl", "Ljava/lang/String;", "isExitVideo", "hasPicture", "Lcom/skydoves/balloon/Balloon;", "mVideoTip", "Lcom/skydoves/balloon/Balloon;", "Landroid/os/CountDownTimer;", "timerTask", "Landroid/os/CountDownTimer;", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoViewModel;", "viewModel", "Lcom/qiahao/nextvideo/utilities/animation/GiftDispatcher;", "giftDispatcher$delegate", "getGiftDispatcher", "()Lcom/qiahao/nextvideo/utilities/animation/GiftDispatcher;", "giftDispatcher", "Lcom/qiahao/nextvideo/ui/reusable/LocalMaskCoverWrapper;", "localFaceTipWrapper$delegate", "getLocalFaceTipWrapper", "()Lcom/qiahao/nextvideo/ui/reusable/LocalMaskCoverWrapper;", "localFaceTipWrapper", "Lcom/qiahao/nextvideo/ui/reusable/RemoteMaskCoverWrapper;", "remoteFaceTipWrapper$delegate", "getRemoteFaceTipWrapper", "()Lcom/qiahao/nextvideo/ui/reusable/RemoteMaskCoverWrapper;", "remoteFaceTipWrapper", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMatchVideoActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchVideoActivity.kt\ncom/qiahao/nextvideo/ui/videocall/matchinguser/MatchVideoActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 LikeEachOtherBalloon.kt\ncom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloonKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1022:1\n61#2,9:1023\n61#2,9:1032\n61#2,9:1042\n61#2,9:1051\n61#2,9:1060\n61#2,9:1069\n61#2,9:1078\n61#2,9:1087\n61#2,9:1096\n61#2,9:1105\n61#2,9:1114\n35#3:1041\n1#4:1123\n*S KotlinDebug\n*F\n+ 1 MatchVideoActivity.kt\ncom/qiahao/nextvideo/ui/videocall/matchinguser/MatchVideoActivity\n*L\n212#1:1023,9\n213#1:1032,9\n515#1:1042,9\n524#1:1051,9\n533#1:1060,9\n541#1:1069,9\n545#1:1078,9\n548#1:1087,9\n551#1:1096,9\n554#1:1105,9\n795#1:1114,9\n305#1:1041\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchVideoActivity extends HiloBaseBindingActivity<ActivityMatchVideoBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String MATCH_VIDEO_DATA = "match_video_data";

    @NotNull
    public static final String TAG = "MatchVideoActivity";

    @NotNull
    public static final String comingDeadlineTipAudioFile = "/assets/video_end_tip.mp3";
    private boolean hasPicture;
    private boolean isExitVideo;
    private boolean localShowFace;

    @Nullable
    private TextureView localVideoView;

    @Nullable
    private Balloon mVideoTip;

    @Nullable
    private VideoCallPreloadModel preloadModel;
    private boolean remoteShowFace;

    @Nullable
    private TextureView remoteVideoView;

    @Nullable
    private CountDownTimer timerTask;
    private long videoCallTotal;

    @Nullable
    private VideoDownTimer videoDownTimer;

    @NotNull
    private final nd.a compositeDisposable = new nd.a();
    private boolean markRemoteFace = true;
    private boolean markLocalFace = true;
    private long remoteDelay = 1000;
    private long localTipDelay = 1000;

    @NotNull
    private String reportImageUrl = "";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.o
        public final Object invoke() {
            VideoViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = MatchVideoActivity.viewModel_delegate$lambda$0(MatchVideoActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: giftDispatcher$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy giftDispatcher = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.p
        public final Object invoke() {
            GiftDispatcher giftDispatcher_delegate$lambda$2;
            giftDispatcher_delegate$lambda$2 = MatchVideoActivity.giftDispatcher_delegate$lambda$2(MatchVideoActivity.this);
            return giftDispatcher_delegate$lambda$2;
        }
    });

    /* renamed from: localFaceTipWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy localFaceTipWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.q
        public final Object invoke() {
            LocalMaskCoverWrapper localFaceTipWrapper_delegate$lambda$3;
            localFaceTipWrapper_delegate$lambda$3 = MatchVideoActivity.localFaceTipWrapper_delegate$lambda$3(MatchVideoActivity.this);
            return localFaceTipWrapper_delegate$lambda$3;
        }
    });

    /* renamed from: remoteFaceTipWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy remoteFaceTipWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.b
        public final Object invoke() {
            RemoteMaskCoverWrapper remoteFaceTipWrapper_delegate$lambda$5;
            remoteFaceTipWrapper_delegate$lambda$5 = MatchVideoActivity.remoteFaceTipWrapper_delegate$lambda$5(MatchVideoActivity.this);
            return remoteFaceTipWrapper_delegate$lambda$5;
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/MatchVideoActivity$Companion;", "", "<init>", "()V", "MATCH_VIDEO_DATA", "", "TAG", "comingDeadlineTipAudioFile", "start", "", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull VideoCallPreloadModel data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) MatchVideoActivity.class);
            intent.putExtra(MatchVideoActivity.MATCH_VIDEO_DATA, data);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final boolean checkCloseFaceTip() {
        VideoCallPreloadModel videoCallPreloadModel;
        VideoCallPreloadModel videoCallPreloadModel2;
        VideoCallPreloadModel videoCallPreloadModel3;
        VideoSetting otherVideoSetting;
        VideoSetting otherVideoSetting2;
        VideoSetting videoSetting;
        VideoSetting videoSetting2;
        VideoCallPreloadModel videoCallPreloadModel4 = this.preloadModel;
        if ((videoCallPreloadModel4 != null && (videoSetting2 = videoCallPreloadModel4.getVideoSetting()) != null && !videoSetting2.isFrontCamera()) || (((videoCallPreloadModel = this.preloadModel) != null && (videoSetting = videoCallPreloadModel.getVideoSetting()) != null && !videoSetting.isOpenCamera()) || (((videoCallPreloadModel2 = this.preloadModel) != null && (otherVideoSetting2 = videoCallPreloadModel2.getOtherVideoSetting()) != null && !otherVideoSetting2.isFrontCamera()) || ((videoCallPreloadModel3 = this.preloadModel) != null && (otherVideoSetting = videoCallPreloadModel3.getOtherVideoSetting()) != null && !otherVideoSetting.isOpenCamera())))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkMeCamMeera() {
        VideoSetting videoSetting;
        String str;
        VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
        if (videoCallPreloadModel != null && (videoSetting = videoCallPreloadModel.getVideoSetting()) != null && !videoSetting.isOpenCamera()) {
            ((ActivityMatchVideoBinding) getBinding()).meVideoLayout.setVisibility(0);
            QMUIRadiusImageView2 qMUIRadiusImageView2 = ((ActivityMatchVideoBinding) getBinding()).meAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "meAvatar");
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                str = user.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, ImageView.ScaleType.FIT_XY, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231654, (c5.g) null, 49118, (Object) null);
            ((ActivityMatchVideoBinding) getBinding()).closeCamera.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.icon_video_close_camera));
            return;
        }
        ((ActivityMatchVideoBinding) getBinding()).meVideoLayout.setVisibility(8);
        ((ActivityMatchVideoBinding) getBinding()).closeCamera.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.icon_video_open));
    }

    private final void checkRemoteCamMeera() {
        VideoSetting otherVideoSetting;
        VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
        if (videoCallPreloadModel != null && (otherVideoSetting = videoCallPreloadModel.getOtherVideoSetting()) != null && !otherVideoSetting.isOpenCamera()) {
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
            w9.h.t(this).q(arrayList).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.l
                public final void onResult(List list, List list2) {
                    MatchVideoActivity.checkVideoPermission$lambda$45(MatchVideoActivity.this, list, list2);
                }
            });
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkVideoPermission$lambda$45(MatchVideoActivity matchVideoActivity, List list, List list2) {
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty()) {
            matchVideoActivity.startLocalVideo();
        }
    }

    public static /* synthetic */ void exitVideo$default(MatchVideoActivity matchVideoActivity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        matchVideoActivity.exitVideo(i);
    }

    private final GiftDispatcher getGiftDispatcher() {
        return (GiftDispatcher) this.giftDispatcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalMaskCoverWrapper getLocalFaceTipWrapper() {
        return (LocalMaskCoverWrapper) this.localFaceTipWrapper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteMaskCoverWrapper getRemoteFaceTipWrapper() {
        return (RemoteMaskCoverWrapper) this.remoteFaceTipWrapper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoViewModel getViewModel() {
        return (VideoViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GiftDispatcher giftDispatcher_delegate$lambda$2(MatchVideoActivity matchVideoActivity) {
        GiftDispatcher giftDispatcher = new GiftDispatcher(matchVideoActivity, 5);
        giftDispatcher.bind(matchVideoActivity, ((ActivityMatchVideoBinding) matchVideoActivity.getBinding()).giftContainer);
        return giftDispatcher;
    }

    private final void initObserver() {
        long j;
        long j2;
        long j3;
        Long remainingTime;
        Long remainingTime2;
        Long remainingTime3;
        Long remainingTime4;
        getViewModel().getMException().observe(this, new MatchVideoActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.f
            public final Object invoke(Object obj) {
                Unit initObserver$lambda$15;
                initObserver$lambda$15 = MatchVideoActivity.initObserver$lambda$15(MatchVideoActivity.this, (Pair) obj);
                return initObserver$lambda$15;
            }
        }));
        getViewModel().getVideoSetting().observe(this, new MatchVideoActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.g
            public final Object invoke(Object obj) {
                Unit initObserver$lambda$16;
                initObserver$lambda$16 = MatchVideoActivity.initObserver$lambda$16(MatchVideoActivity.this, (VideoSetting) obj);
                return initObserver$lambda$16;
            }
        }));
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        nd.c subscribe = agoraRtcService.getRemoteVideoStateRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$initObserver$3
            public final void accept(Pair<Integer, Integer> pair) {
                try {
                    if (((Number) pair.getFirst()).intValue() == 4) {
                        MatchVideoActivity.exitVideo$default(MatchVideoActivity.this, 0, 1, null);
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        BaseActivity baseActivity = MatchVideoActivity.this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131954249), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    }
                    if (((Number) pair.getSecond()).intValue() == 7) {
                        MatchVideoActivity.exitVideo$default(MatchVideoActivity.this, 0, 1, null);
                    }
                } catch (Exception e) {
                    DebugToolsKt.printfE(MatchVideoActivity.TAG, "remoteVideoStateRelay内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        nd.c subscribe2 = agoraRtcService.getRemoteFaceStatusRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$initObserver$4
            public final void accept(Pair<Integer, String> pair) {
                try {
                    String str = (String) pair.getSecond();
                    if (Intrinsics.areEqual(str, MessageService.MSG_DB_READY_REPORT)) {
                        MatchVideoActivity.this.markRemoteFace = false;
                    } else if (Intrinsics.areEqual(str, MessageService.MSG_DB_NOTIFY_REACHED)) {
                        MatchVideoActivity.this.markRemoteFace = true;
                    } else {
                        MatchVideoActivity.this.remoteShowFace = true;
                    }
                    MatchVideoActivity.this.processFaceResult();
                } catch (Exception e) {
                    DebugToolsKt.printfE(MatchVideoActivity.TAG, "remoteFaceStatusRelay内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, this.compositeDisposable);
        VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
        long j4 = 0;
        if (videoCallPreloadModel != null && (remainingTime4 = videoCallPreloadModel.getRemainingTime()) != null) {
            j = remainingTime4.longValue();
        } else {
            j = 0;
        }
        long j5 = j * 1000;
        VideoCallPreloadModel videoCallPreloadModel2 = this.preloadModel;
        if (videoCallPreloadModel2 != null && (remainingTime3 = videoCallPreloadModel2.getRemainingTime()) != null) {
            j2 = remainingTime3.longValue();
        } else {
            j2 = 0;
        }
        long j6 = 1000;
        long j7 = j2 * j6;
        VideoCallPreloadModel videoCallPreloadModel3 = this.preloadModel;
        if (videoCallPreloadModel3 != null && (remainingTime2 = videoCallPreloadModel3.getRemainingTime()) != null) {
            j3 = remainingTime2.longValue();
        } else {
            j3 = 0;
        }
        VideoDownTimer videoDownTimer = new VideoDownTimer(new CountDownTimerPreloadModel(j5, j7, j6 * j3, 0L, 8, null));
        videoDownTimer.setMListener(new VideoDownTimerListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$initObserver$5$1
            @Override // com.qiahao.nextvideo.ui.videocall.matchinguser.VideoDownTimerListener
            public void onFinish() {
                ActivityMatchVideoBinding binding;
                binding = MatchVideoActivity.this.getBinding();
                binding.videoCallingCountingSquareProgressBar.setProgress(0.0f);
                MatchVideoActivity.exitVideo$default(MatchVideoActivity.this, 0, 1, null);
            }

            @Override // com.qiahao.nextvideo.ui.videocall.matchinguser.VideoDownTimerListener
            public void onTimerLine() {
                ActivityMatchVideoBinding binding;
                binding = MatchVideoActivity.this.getBinding();
                binding.videoCallCountdownTextView.startCountDownComingEndAnimation();
                RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
                if (rtcEngine != null) {
                    rtcEngine.startAudioMixing("/assets/video_end_tip.mp3", true, false, 1);
                }
            }

            @Override // com.qiahao.nextvideo.ui.videocall.matchinguser.VideoDownTimerListener
            @SuppressLint({"SetTextI18n"})
            public void timerTick(long millisUntilFinished, long totalMills) {
                ActivityMatchVideoBinding binding;
                ActivityMatchVideoBinding binding2;
                boolean z;
                long j8;
                ActivityMatchVideoBinding binding3;
                long j9;
                ActivityMatchVideoBinding binding4;
                ActivityMatchVideoBinding binding5;
                boolean z2;
                long j10;
                TextureView textureView;
                Bitmap bitmap;
                long j11 = millisUntilFinished / 1000;
                binding = MatchVideoActivity.this.getBinding();
                binding.videoCallCountdownTextView.setText(j11 + "s");
                binding2 = MatchVideoActivity.this.getBinding();
                binding2.videoCallingCountingSquareProgressBar.setProgress(((float) 100) - ((((float) millisUntilFinished) / ((float) totalMills)) * 100.0f));
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    z = Intrinsics.areEqual(user.isTradeUnion(), Boolean.TRUE);
                } else {
                    z = false;
                }
                if (z) {
                    z2 = MatchVideoActivity.this.hasPicture;
                    if (!z2) {
                        j10 = MatchVideoActivity.this.videoCallTotal;
                        if (j10 - j11 > ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "screenCapture", 5, (String) null, 4, (Object) null)).intValue()) {
                            MatchVideoActivity.this.hasPicture = true;
                            textureView = MatchVideoActivity.this.localVideoView;
                            if (textureView != null && (bitmap = textureView.getBitmap()) != null) {
                                MatchVideoActivity.this.reportUnionUserPicture(bitmap);
                            }
                        }
                    }
                }
                j8 = MatchVideoActivity.this.videoCallTotal;
                if (j8 - j11 < 4) {
                    binding5 = MatchVideoActivity.this.getBinding();
                    binding5.exitVideoCallImageView.setImageDrawable(androidx.core.content.a.getDrawable(MatchVideoActivity.this, R.drawable.icon_video_exit_no));
                } else {
                    binding3 = MatchVideoActivity.this.getBinding();
                    binding3.exitVideoCallImageView.setImageDrawable(androidx.core.content.a.getDrawable(MatchVideoActivity.this, R.drawable.icon_video_exit));
                }
                j9 = MatchVideoActivity.this.videoCallTotal;
                if (j9 - j11 == 10) {
                    MatchVideoActivity.this.showTip(2, ResourcesKtxKt.getStringById(this, 2131953136));
                }
                if (j11 > 3) {
                    binding4 = MatchVideoActivity.this.getBinding();
                    binding4.videoCallCountdownTextView.stopCountDownComingEndAnimation();
                    RtcEngine rtcEngine = AgoraRtcService.INSTANCE.getRtcEngine();
                    if (rtcEngine != null) {
                        rtcEngine.stopAudioMixing();
                    }
                }
            }
        });
        this.videoDownTimer = videoDownTimer;
        VideoCallPreloadModel videoCallPreloadModel4 = this.preloadModel;
        if (videoCallPreloadModel4 != null && (remainingTime = videoCallPreloadModel4.getRemainingTime()) != null) {
            j4 = remainingTime.longValue();
        }
        this.videoCallTotal = j4;
        VideoDownTimer videoDownTimer2 = this.videoDownTimer;
        if (videoDownTimer2 != null) {
            videoDownTimer2.start();
        }
        nd.c subscribe3 = agoraRtcService.getFaceDetectionStateRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$initObserver$6
            public final void accept(Boolean bool) {
                try {
                    MatchVideoActivity matchVideoActivity = MatchVideoActivity.this;
                    Intrinsics.checkNotNull(bool);
                    matchVideoActivity.publishLocalFaceDetectionResult(bool.booleanValue());
                } catch (Exception e) {
                    DebugToolsKt.printfE(MatchVideoActivity.TAG, "faceDetectionStateRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe3, "subscribe(...)");
        RxUtilsKt.addTo(subscribe3, this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initObserver$lambda$15(MatchVideoActivity matchVideoActivity, Pair pair) {
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
                stringById = ResourcesKtxKt.getStringById(matchVideoActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, matchVideoActivity, stringById, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, matchVideoActivity, ResourcesKtxKt.getStringById(matchVideoActivity, 2131952667), false, 4, (Object) null);
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
    public static final Unit initObserver$lambda$16(MatchVideoActivity matchVideoActivity, VideoSetting videoSetting) {
        int i;
        VideoSetting videoSetting2;
        Integer frontOrBack;
        if (videoSetting != null) {
            VideoCallPreloadModel videoCallPreloadModel = matchVideoActivity.preloadModel;
            if (videoCallPreloadModel != null && (videoSetting2 = videoCallPreloadModel.getVideoSetting()) != null && (frontOrBack = videoSetting2.getFrontOrBack()) != null) {
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
        VideoCallPreloadModel videoCallPreloadModel2 = matchVideoActivity.preloadModel;
        if (videoCallPreloadModel2 != null) {
            videoCallPreloadModel2.setVideoSetting(videoSetting);
        }
        matchVideoActivity.checkMeCamMeera();
        matchVideoActivity.processFaceResult();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        VideoCallPreloadModel videoCallPreloadModel;
        getWindow().addFlags(128);
        Intent intent = getIntent();
        if (intent != null && (videoCallPreloadModel = (VideoCallPreloadModel) intent.getParcelableExtra(MATCH_VIDEO_DATA)) != null) {
            this.preloadModel = videoCallPreloadModel;
            MatchingProvide.INSTANCE.setVideoID(videoCallPreloadModel.getMatchUniqueID());
        }
        if (checkVideoPermission()) {
            startLocalVideo();
        }
        refreshTopUI();
        initObserver();
        final ImageView imageView = ((ActivityMatchVideoBinding) getBinding()).reportImageView;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.reportImageViewPressed();
                }
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityMatchVideoBinding) getBinding()).exitVideoCallImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    MatchVideoActivity.exitVideo$default(this, 0, 1, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalMaskCoverWrapper localFaceTipWrapper_delegate$lambda$3(MatchVideoActivity matchVideoActivity) {
        FrameLayout frameLayout = matchVideoActivity.getBinding().tipsViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "tipsViewContainer");
        LocalMaskCoverWrapper localMaskCoverWrapper = new LocalMaskCoverWrapper(frameLayout);
        matchVideoActivity.getBinding().tipsViewContainer.addView(localMaskCoverWrapper.getBinding().getRoot());
        return localMaskCoverWrapper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void oppositeLikeYou() {
        String str;
        User user;
        User toUser;
        User toUser2;
        User toUser3;
        boolean z = false;
        VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
        if (videoCallPreloadModel != null && (toUser3 = videoCallPreloadModel.getToUser()) != null) {
            toUser3.setLikeMe(Boolean.TRUE);
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953042);
        VideoCallPreloadModel videoCallPreloadModel2 = this.preloadModel;
        User user2 = null;
        if (videoCallPreloadModel2 != null && (toUser2 = videoCallPreloadModel2.getToUser()) != null) {
            str = toUser2.getNick();
        } else {
            str = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, this, format, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        VideoCallPreloadModel videoCallPreloadModel3 = this.preloadModel;
        if (videoCallPreloadModel3 != null && (toUser = videoCallPreloadModel3.getToUser()) != null) {
            z = Intrinsics.areEqual(toUser.isLike(), Boolean.TRUE);
        }
        if (z) {
            UserStore.Companion companion2 = UserStore.INSTANCE;
            if (companion2.getShared().getUser() != null) {
                VideoCallPreloadModel videoCallPreloadModel4 = this.preloadModel;
                if (videoCallPreloadModel4 != null) {
                    user = videoCallPreloadModel4.getToUser();
                } else {
                    user = null;
                }
                if (user != null) {
                    LikeEachOtherBalloon.Builder builder = new LikeEachOtherBalloon.Builder(this);
                    VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                    if (videoCallPreloadModel5 != null) {
                        user2 = videoCallPreloadModel5.getToUser();
                    }
                    builder.setRemoteUser(user2);
                    builder.setLocalUser(companion2.getShared().getUser());
                    builder.build().show(this);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void playGift(GiftDateItem data) {
        try {
            if (StringKtxKt.checkEndSVGA(data.getEffectSvga())) {
                ((ActivityMatchVideoBinding) getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(data));
            } else if (StringKtxKt.checkEndMP4(data.getEffectSvga())) {
                GiftHelp.INSTANCE.getVAP2(data, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.h
                    public final Object invoke(Object obj) {
                        Unit playGift$lambda$28;
                        playGift$lambda$28 = MatchVideoActivity.playGift$lambda$28(MatchVideoActivity.this, (VapMediaSource) obj);
                        return playGift$lambda$28;
                    }
                }, this);
            } else if (StringKtxKt.checkDefaultMP4(data.getEffectSvga())) {
                ((ActivityMatchVideoBinding) getBinding()).queuePlayer.addQueue(new VideoMediaSource(StringKtxKt.urlMP4(data.getEffectSvga())));
            }
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playGift$lambda$28(MatchVideoActivity matchVideoActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        matchVideoActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processFaceResult() {
        if (checkCloseFaceTip()) {
            getLocalFaceTipWrapper().hide();
            getRemoteFaceTipWrapper().hide();
        } else {
            if (this.remoteShowFace && this.localShowFace) {
                this.markLocalFace = true;
                this.markRemoteFace = true;
                getLocalFaceTipWrapper().hide();
                getRemoteFaceTipWrapper().hide();
                return;
            }
            getBinding().getRoot().postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.c
                @Override // java.lang.Runnable
                public final void run() {
                    MatchVideoActivity.processFaceResult$lambda$33(MatchVideoActivity.this);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processFaceResult$lambda$33(MatchVideoActivity matchVideoActivity) {
        boolean z = matchVideoActivity.remoteShowFace;
        if (z && matchVideoActivity.localShowFace) {
            matchVideoActivity.getLocalFaceTipWrapper().hide();
            matchVideoActivity.getRemoteFaceTipWrapper().hide();
            return;
        }
        if (z && !matchVideoActivity.localShowFace) {
            matchVideoActivity.getLocalFaceTipWrapper().hide();
            if (matchVideoActivity.markRemoteFace) {
                matchVideoActivity.getRemoteFaceTipWrapper().hide();
                return;
            } else {
                matchVideoActivity.showRemoteMaskCover();
                return;
            }
        }
        if (!z && matchVideoActivity.localShowFace) {
            matchVideoActivity.getRemoteFaceTipWrapper().hide();
            if (matchVideoActivity.markLocalFace) {
                matchVideoActivity.getLocalFaceTipWrapper().hide();
                return;
            } else {
                matchVideoActivity.showNotFaceLocalTipMaskCover();
                return;
            }
        }
        boolean z2 = matchVideoActivity.markLocalFace;
        if (z2 && matchVideoActivity.markRemoteFace) {
            matchVideoActivity.getLocalFaceTipWrapper().hide();
            matchVideoActivity.getRemoteFaceTipWrapper().hide();
            return;
        }
        if (z2 && !matchVideoActivity.markRemoteFace) {
            matchVideoActivity.getLocalFaceTipWrapper().hide();
            matchVideoActivity.showRemoteMaskCover();
        } else if (!z2 && matchVideoActivity.markRemoteFace) {
            matchVideoActivity.showNotFaceLocalTipMaskCover();
            matchVideoActivity.getRemoteFaceTipWrapper().hide();
        } else {
            matchVideoActivity.showNotFaceLocalTipMaskCover();
            matchVideoActivity.getRemoteFaceTipWrapper().hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publishLocalFaceDetectionResult(boolean isShowFace) {
        byte[] bytes;
        if (this.markLocalFace == isShowFace) {
            return;
        }
        this.markLocalFace = isShowFace;
        processFaceResult();
        if (!this.remoteShowFace || !this.localShowFace) {
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

    private final void refreshTopUI() {
        String str;
        String str2;
        VideoCallPreloadModel videoCallPreloadModel;
        boolean z;
        User toUser;
        int i;
        int i2;
        User toUser2;
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.d
            public final Object invoke(Object obj, Object obj2) {
                Unit refreshTopUI$lambda$18;
                refreshTopUI$lambda$18 = MatchVideoActivity.refreshTopUI$lambda$18(MatchVideoActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return refreshTopUI$lambda$18;
            }
        });
        setStatusBarIconColor(false);
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        User user2 = null;
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        VideoCallPreloadModel videoCallPreloadModel2 = this.preloadModel;
        if (videoCallPreloadModel2 != null && (toUser2 = videoCallPreloadModel2.getToUser()) != null) {
            str2 = toUser2.getExternalId();
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            VideoCallPreloadModel videoCallPreloadModel3 = this.preloadModel;
            if (videoCallPreloadModel3 != null) {
                user2 = videoCallPreloadModel3.getFormUser();
            }
        } else {
            VideoCallPreloadModel videoCallPreloadModel4 = this.preloadModel;
            if (videoCallPreloadModel4 != null) {
                user2 = videoCallPreloadModel4.getToUser();
            }
        }
        if (user2 != null) {
            AppCompatTextView appCompatTextView = getBinding().nickName;
            String nick = user2.getNick();
            if (nick == null) {
                nick = "";
            }
            appCompatTextView.setText(nick);
            AppCompatImageView appCompatImageView = getBinding().userAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
            ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(user2.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
            QMUIRadiusImageView2 qMUIRadiusImageView2 = getBinding().remoteAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "remoteAvatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, user2.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, ImageView.ScaleType.FIT_XY, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231654, (c5.g) null, 49118, (Object) null);
            ImageView imageView = getBinding().iconCount;
            Intrinsics.checkNotNullExpressionValue(imageView, "iconCount");
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(user2.getCountryInfo().getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            if (TextUtils.isEmpty(user2.getCountryInfo().getIcon())) {
                getBinding().iconCount.setVisibility(4);
            } else {
                getBinding().iconCount.setVisibility(0);
            }
            getBinding().countryName.setText(user2.getCountryInfo().getShortName());
            if (user2.isVip()) {
                getBinding().vipImage.setVisibility(0);
            } else {
                getBinding().vipImage.setVisibility(8);
            }
        }
        User user3 = companion.getShared().getUser();
        if ((user3 != null && user3.isVip()) || ((videoCallPreloadModel = this.preloadModel) != null && (toUser = videoCallPreloadModel.getToUser()) != null && toUser.isVip())) {
            z = true;
        } else {
            z = false;
        }
        DrawableTextView drawableTextView = getBinding().videoCallCountdownTextView;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        if (z) {
            i = R.drawable.vip_icon_time;
        } else {
            i = R.drawable.icon_time;
        }
        Drawable drawable = ResourceUtilsKt.getDrawable(resources, i, 0);
        Dimens dimens = Dimens.INSTANCE;
        drawableTextView.setDrawable(0, drawable, dimens.dpToPx(20), dimens.dpToPx(20));
        DrawableTextView drawableTextView2 = getBinding().videoCallCountdownTextView;
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        if (z) {
            i2 = R.drawable.bg_pure_yellow_4_rounded_5dp;
        } else {
            i2 = R.drawable.bg_pure_black_4_rounded_5dp;
        }
        drawableTextView2.setBackgroundDrawable(ResourceUtilsKt.getDrawable(resources2, i2, 0));
        final ImageView imageView2 = getBinding().sendGift;
        final long j = 800;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    this.showGiftDialog();
                }
            }
        });
        getBinding().videoCallingCountingSquareProgressBar.setColor(Color.parseColor("#363535"));
        getBinding().videoCallingCountingSquareProgressBar.m(true, UiKtxKt.toPX(5));
        getBinding().videoCallingCountingSquareProgressBar.setWidthInDp(5);
        final ImageView imageView3 = getBinding().change;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                int i3;
                int i4;
                String str3;
                VideoSetting videoSetting;
                Integer cameraOnOff;
                VideoSetting videoSetting2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    User user4 = UserStore.INSTANCE.getShared().getUser();
                    if (user4 == null || user4.isVip()) {
                        viewModel = this.getViewModel();
                        VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                        if (videoCallPreloadModel5 != null && (videoSetting2 = videoCallPreloadModel5.getVideoSetting()) != null) {
                            i3 = videoSetting2.changeCameraFront();
                        } else {
                            i3 = 1;
                        }
                        VideoCallPreloadModel videoCallPreloadModel6 = this.preloadModel;
                        if (videoCallPreloadModel6 != null && (videoSetting = videoCallPreloadModel6.getVideoSetting()) != null && (cameraOnOff = videoSetting.getCameraOnOff()) != null) {
                            i4 = cameraOnOff.intValue();
                        } else {
                            i4 = 1;
                        }
                        VideoCallPreloadModel videoCallPreloadModel7 = this.preloadModel;
                        if (videoCallPreloadModel7 != null) {
                            str3 = videoCallPreloadModel7.getMatchUniqueID();
                        } else {
                            str3 = null;
                        }
                        VideoViewModel.videoSetting$default(viewModel, i3, i4, null, str3, 4, null);
                        return;
                    }
                    this.showVipDialog(12);
                }
            }
        });
        final ImageView imageView4 = getBinding().closeCamera;
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                int i3;
                int i4;
                String str3;
                VideoSetting videoSetting;
                VideoSetting videoSetting2;
                Integer frontOrBack;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                    User user4 = UserStore.INSTANCE.getShared().getUser();
                    if (user4 == null || user4.isVip()) {
                        viewModel = this.getViewModel();
                        VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                        if (videoCallPreloadModel5 != null && (videoSetting2 = videoCallPreloadModel5.getVideoSetting()) != null && (frontOrBack = videoSetting2.getFrontOrBack()) != null) {
                            i3 = frontOrBack.intValue();
                        } else {
                            i3 = 1;
                        }
                        VideoCallPreloadModel videoCallPreloadModel6 = this.preloadModel;
                        if (videoCallPreloadModel6 != null && (videoSetting = videoCallPreloadModel6.getVideoSetting()) != null) {
                            i4 = videoSetting.switchCameraOpen();
                        } else {
                            i4 = 1;
                        }
                        VideoCallPreloadModel videoCallPreloadModel7 = this.preloadModel;
                        if (videoCallPreloadModel7 != null) {
                            str3 = videoCallPreloadModel7.getMatchUniqueID();
                        } else {
                            str3 = null;
                        }
                        VideoViewModel.videoSetting$default(viewModel, i3, i4, null, str3, 4, null);
                        return;
                    }
                    this.showVipDialog(11);
                }
            }
        });
        final FrameLayout frameLayout = getBinding().praise;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityMatchVideoBinding binding;
                VideoViewModel viewModel;
                String str3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    binding = this.getBinding();
                    if (binding.circleProgress.getProgress() == 100) {
                        viewModel = this.getViewModel();
                        VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                        if (videoCallPreloadModel5 != null) {
                            str3 = videoCallPreloadModel5.getMatchUniqueID();
                        } else {
                            str3 = null;
                        }
                        VideoViewModel.videoInter$default(viewModel, 1, 0, null, str3, 6, null);
                    }
                }
            }
        });
        final ImageView imageView5 = getBinding().flower;
        imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                String str3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView5) > j || (imageView5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView5, currentTimeMillis);
                    viewModel = this.getViewModel();
                    VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                    if (videoCallPreloadModel5 != null) {
                        str3 = videoCallPreloadModel5.getMatchUniqueID();
                    } else {
                        str3 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 2, 0, null, str3, 6, null);
                }
            }
        });
        final ImageView imageView6 = getBinding().love;
        imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                String str3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView6) > j || (imageView6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView6, currentTimeMillis);
                    viewModel = this.getViewModel();
                    VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                    if (videoCallPreloadModel5 != null) {
                        str3 = videoCallPreloadModel5.getMatchUniqueID();
                    } else {
                        str3 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 3, 0, null, str3, 6, null);
                }
            }
        });
        final ImageView imageView7 = getBinding().call;
        imageView7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                String str3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView7) > j || (imageView7 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView7, currentTimeMillis);
                    viewModel = this.getViewModel();
                    VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                    if (videoCallPreloadModel5 != null) {
                        str3 = videoCallPreloadModel5.getMatchUniqueID();
                    } else {
                        str3 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 4, 0, null, str3, 6, null);
                }
            }
        });
        final ImageView imageView8 = getBinding().kiss;
        imageView8.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$refreshTopUI$$inlined$singleClick$default$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoViewModel viewModel;
                String str3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView8) > j || (imageView8 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView8, currentTimeMillis);
                    viewModel = this.getViewModel();
                    VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                    if (videoCallPreloadModel5 != null) {
                        str3 = videoCallPreloadModel5.getMatchUniqueID();
                    } else {
                        str3 = null;
                    }
                    VideoViewModel.videoInter$default(viewModel, 5, 0, null, str3, 6, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshTopUI$lambda$18(MatchVideoActivity matchVideoActivity, int i, int i2) {
        ViewKtxKt.setMargin(matchVideoActivity.getBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteMaskCoverWrapper remoteFaceTipWrapper_delegate$lambda$5(final MatchVideoActivity matchVideoActivity) {
        FrameLayout frameLayout = matchVideoActivity.getBinding().tipsViewContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "tipsViewContainer");
        RemoteMaskCoverWrapper remoteMaskCoverWrapper = new RemoteMaskCoverWrapper(frameLayout);
        remoteMaskCoverWrapper.setMListener(new RemoteListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$remoteFaceTipWrapper$2$wrapper$1$1
            @Override // com.qiahao.nextvideo.ui.reusable.RemoteListener
            public void remoteRematch() {
                MatchVideoActivity.exitVideo$default(MatchVideoActivity.this, 0, 1, null);
            }

            @Override // com.qiahao.nextvideo.ui.reusable.RemoteListener
            public void remoteRemove() {
                boolean z;
                RemoteMaskCoverWrapper remoteFaceTipWrapper;
                boolean z2;
                LocalMaskCoverWrapper localFaceTipWrapper;
                boolean z3;
                z = MatchVideoActivity.this.localShowFace;
                if (z) {
                    return;
                }
                AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
                byte[] bytes = MessageService.MSG_DB_NOTIFY_CLICK.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                if (agoraRtcService.sendStreamMessage(bytes)) {
                    MatchVideoActivity.this.localShowFace = true;
                    MatchVideoActivity.this.markRemoteFace = true;
                    remoteFaceTipWrapper = MatchVideoActivity.this.getRemoteFaceTipWrapper();
                    remoteFaceTipWrapper.hide();
                    z2 = MatchVideoActivity.this.markLocalFace;
                    if (!z2) {
                        z3 = MatchVideoActivity.this.remoteShowFace;
                        if (!z3) {
                            MatchVideoActivity.this.showNotFaceLocalTipMaskCover();
                            return;
                        }
                    }
                    localFaceTipWrapper = MatchVideoActivity.this.getLocalFaceTipWrapper();
                    localFaceTipWrapper.hide();
                    return;
                }
                HiloToasty.Companion companion = HiloToasty.Companion;
                BaseActivity baseActivity = MatchVideoActivity.this;
                String string = baseActivity.getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        });
        matchVideoActivity.getBinding().tipsViewContainer.addView(remoteMaskCoverWrapper.getBinding().getRoot());
        return remoteMaskCoverWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reportImageViewPressed() {
        String str;
        VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
        if (videoCallPreloadModel == null || (str = videoCallPreloadModel.getToUID()) == null) {
            str = "";
        }
        final UserMenuDialog userMenuDialog = new UserMenuDialog(this, str);
        userMenuDialog.setHideProfile(true);
        userMenuDialog.setHideDelete(true);
        userMenuDialog.setListener(new UserMenuInterfaces() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$reportImageViewPressed$1$1
            @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
            public void onClickBlock(String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                FeedbackService.INSTANCE.getShared().getReportEventRelay().accept(uid);
                MatchVideoActivity.exitVideo$default(MatchVideoActivity.this, 0, 1, null);
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
                MatchVideoActivity.this.shootRemoteScreen();
                new ReportWhiteDialog(MatchVideoActivity.this).setListener(new MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1(MatchVideoActivity.this, uid, userMenuDialog)).show();
            }
        });
        userMenuDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportUnionUserPicture$lambda$30(MatchVideoActivity matchVideoActivity, Bitmap bitmap, j0 j0Var) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(j0Var, "singleEmitter");
        FileManager fileManager = FileManager.INSTANCE;
        VideoCallPreloadModel videoCallPreloadModel = matchVideoActivity.preloadModel;
        if (videoCallPreloadModel != null) {
            str = videoCallPreloadModel.getMatchUniqueID();
        } else {
            str = null;
        }
        File tempSendImgFile = fileManager.getTempSendImgFile(str + "_screen_snatshot");
        fileManager.saveBitmap2SelfDirectroy(bitmap, tempSendImgFile);
        Object c = AliCloudService.uploadFileToAWS$default(AliCloudService.INSTANCE.getShared(), AliCloudService.OSS_FOLDER_TRADE_UNION, tempSendImgFile, null, 4, null).c();
        Intrinsics.checkNotNullExpressionValue(c, "blockingGet(...)");
        Pair pair = (Pair) c;
        if (pair != null) {
            if (((Boolean) pair.getFirst()).booleanValue()) {
                AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
                VideoCallPreloadModel videoCallPreloadModel2 = matchVideoActivity.preloadModel;
                if (videoCallPreloadModel2 == null || (str2 = videoCallPreloadModel2.getMatchUniqueID()) == null) {
                    str2 = "";
                }
                Object c2 = agoraRtcService.postUnionUserPicture(str2, (String) pair.getSecond()).c();
                Intrinsics.checkNotNullExpressionValue(c2, "blockingGet(...)");
                ApiResponse apiResponse = (ApiResponse) c2;
                if (apiResponse.isOk()) {
                    j0Var.onSuccess(Boolean.TRUE);
                    return;
                } else {
                    j0Var.onError(new Throwable(apiResponse.getMessage()));
                    return;
                }
            }
            j0Var.onError(new Throwable("upload file failed."));
            return;
        }
        j0Var.onError(new Throwable("upload file failed."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportUnionUserPicture$lambda$31(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportUnionUserPicture$lambda$32(MatchVideoActivity matchVideoActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, matchVideoActivity, ResourcesKtxKt.getStringById(matchVideoActivity, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shootRemoteScreen$lambda$41(MatchVideoActivity matchVideoActivity, j0 j0Var) {
        Bitmap bitmap;
        Number valueOf;
        Number valueOf2;
        Intrinsics.checkNotNullParameter(j0Var, "singleEmitter");
        TextureView textureView = matchVideoActivity.remoteVideoView;
        String str = null;
        if (textureView != null) {
            if (textureView != null) {
                valueOf = Integer.valueOf(textureView.getWidth());
            } else {
                valueOf = Float.valueOf(0.0f);
            }
            int intValue = valueOf.intValue();
            TextureView textureView2 = matchVideoActivity.remoteVideoView;
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
        VideoCallPreloadModel videoCallPreloadModel = matchVideoActivity.preloadModel;
        if (videoCallPreloadModel != null) {
            str = videoCallPreloadModel.getMatchUniqueID();
        }
        File tempSendImgFile = fileManager.getTempSendImgFile(str + "_screen_snatshot");
        if (bitmap != null) {
            fileManager.saveBitmap2SelfDirectroy(bitmap, tempSendImgFile);
        }
        Object c = AliCloudService.uploadFileToAWS$default(AliCloudService.INSTANCE.getShared(), AliCloudService.OSS_FOLDER_FEEDBACK, tempSendImgFile, null, 4, null).c();
        Intrinsics.checkNotNullExpressionValue(c, "blockingGet(...)");
        Pair pair = (Pair) c;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            matchVideoActivity.reportImageUrl = (String) pair.getSecond();
        }
        j0Var.onSuccess(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGiftDialog() {
        String str;
        String toNickname;
        VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
        String str2 = "";
        if (videoCallPreloadModel == null || (str = videoCallPreloadModel.getToUID()) == null) {
            str = "";
        }
        VideoCallPreloadModel videoCallPreloadModel2 = this.preloadModel;
        if (videoCallPreloadModel2 != null && (toNickname = videoCallPreloadModel2.getToNickname()) != null) {
            str2 = toNickname;
        }
        new VideoGiftDialogFragment(str, str2, false).setListener(new MatchVideoActivity$showGiftDialog$1(this)).show(getSupportFragmentManager(), "OtherGiftDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNotFaceLocalTipMaskCover() {
        getBinding().getRoot().postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.k
            @Override // java.lang.Runnable
            public final void run() {
                MatchVideoActivity.showNotFaceLocalTipMaskCover$lambda$38(MatchVideoActivity.this);
            }
        }, this.localTipDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showNotFaceLocalTipMaskCover$lambda$38(MatchVideoActivity matchVideoActivity) {
        if (!matchVideoActivity.getLocalFaceTipWrapper().isShowing()) {
            TextureView textureView = matchVideoActivity.remoteVideoView;
            if (textureView != null) {
                Dimens dimens = Dimens.INSTANCE;
                Bitmap bitmap = textureView.getBitmap(dimens.getScreenWidth() / 5, dimens.getScreenHeight() / 5);
                if (bitmap != null) {
                    oe.d.b(matchVideoActivity).b(2).a(bitmap).b(matchVideoActivity.getLocalFaceTipWrapper().getBinding().backgroundImageView);
                }
            }
            matchVideoActivity.getLocalFaceTipWrapper().show();
        }
        matchVideoActivity.localTipDelay = 100L;
        matchVideoActivity.remoteDelay = 100L;
    }

    private final void showRemoteMaskCover() {
        getBinding().getRoot().postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.n
            @Override // java.lang.Runnable
            public final void run() {
                MatchVideoActivity.showRemoteMaskCover$lambda$35(MatchVideoActivity.this);
            }
        }, this.remoteDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showRemoteMaskCover$lambda$35(MatchVideoActivity matchVideoActivity) {
        if (!matchVideoActivity.getRemoteFaceTipWrapper().isShowing()) {
            TextureView textureView = matchVideoActivity.remoteVideoView;
            if (textureView != null) {
                Dimens dimens = Dimens.INSTANCE;
                Bitmap bitmap = textureView.getBitmap(dimens.getScreenWidth() / 5, dimens.getScreenHeight() / 5);
                if (bitmap != null) {
                    oe.d.b(matchVideoActivity).b(2).a(bitmap).b(matchVideoActivity.getRemoteFaceTipWrapper().getBinding().backgroundImageView);
                }
            }
            matchVideoActivity.getRemoteFaceTipWrapper().show();
        }
        matchVideoActivity.remoteDelay = 100L;
        matchVideoActivity.localTipDelay = 100L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showTip(int type, String content) {
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
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$showTip$$inlined$singleClick$default$1
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
            View view = ((ActivityMatchVideoBinding) getBinding()).placeholder;
            Intrinsics.checkNotNullExpressionValue(view, ImageSelectActivity.PLACEHOLDER);
            createView$default.show(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showVipDialog(int position) {
        new VipViewDialog(position, this).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLocalVideo$lambda$44(MatchVideoActivity matchVideoActivity) {
        matchVideoActivity.showTip(1, ResourcesKtxKt.getStringById(matchVideoActivity, 2131954416));
    }

    private final void startTimerTask() {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$startTimerTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(10000L, 100L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ActivityMatchVideoBinding binding;
                binding = MatchVideoActivity.this.getBinding();
                binding.circleProgress.setProgress(100);
                MatchVideoActivity.this.timerTask = null;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                ActivityMatchVideoBinding binding;
                binding = MatchVideoActivity.this.getBinding();
                long j = 10000;
                binding.circleProgress.setProgress((int) (((j - millisUntilFinished) * 100) / j));
            }
        };
        this.timerTask = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoViewModel viewModel_delegate$lambda$0(MatchVideoActivity matchVideoActivity) {
        return new ViewModelProvider(matchVideoActivity).get(VideoViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void exitVideo(int endType) {
        String str;
        String str2;
        if (!this.isExitVideo) {
            MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
            matchingProvide.setMatchStatue("default");
            ((ActivityMatchVideoBinding) getBinding()).queuePlayer.onCleared();
            this.isExitVideo = true;
            VideoDownTimer videoDownTimer = this.videoDownTimer;
            if (videoDownTimer != null) {
                videoDownTimer.cancel();
            }
            Balloon balloon = this.mVideoTip;
            if (balloon != null) {
                balloon.dismiss();
            }
            TextureView textureView = this.remoteVideoView;
            String str3 = null;
            if (textureView != null) {
                ((ActivityMatchVideoBinding) getBinding()).remoteVideoViewContainer.removeView(textureView);
                this.remoteVideoView = null;
            }
            TextureView textureView2 = this.localVideoView;
            if (textureView2 != null) {
                ((ActivityMatchVideoBinding) getBinding()).localVideoViewContainer.removeView(textureView2);
                this.localVideoView = null;
            }
            cf.c.c().l(new VideoEvent("DEFAULT", new Object()));
            AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
            VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
            if (videoCallPreloadModel == null || (str = videoCallPreloadModel.getMatchUniqueID()) == null) {
                str = "";
            }
            appRequestUtils.endCallReport(str, endType);
            AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
            VideoCallPreloadModel videoCallPreloadModel2 = this.preloadModel;
            if (videoCallPreloadModel2 != null) {
                str2 = videoCallPreloadModel2.getChannelID();
            } else {
                str2 = null;
            }
            agoraRtcService.leaveChannel(str2);
            RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
            if (rtcEngine != null) {
                rtcEngine.stopAudioMixing();
            }
            agoraRtcService.enableLocalVideo(false);
            RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
            if (rtcEngine2 != null) {
                rtcEngine2.stopPreview();
            }
            matchingProvide.exitMatchingPool();
            matchingProvide.setVideoID(null);
            WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
            VideoCallPreloadModel videoCallPreloadModel3 = this.preloadModel;
            if (videoCallPreloadModel3 != null) {
                str3 = videoCallPreloadModel3.getMatchUniqueID();
            }
            WebSocketProvide.roomWebSocket$default(webSocketProvide, 153, str3, null, null, 12, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_match_video;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        setShowGiftTip(false);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        exitVideo$default(this, 0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        String str;
        super.onResume();
        MatchingProvide.INSTANCE.setMatchStatue(MatchingProvide.IS_VIDEO);
        WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
        VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
        if (videoCallPreloadModel != null) {
            str = videoCallPreloadModel.getMatchUniqueID();
        } else {
            str = null;
        }
        WebSocketProvide.roomWebSocket$default(webSocketProvide, 152, str, null, null, 12, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
    
        if (r3 == r1.getFrontOrBack()) goto L٤٤;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onVideoEvent(@NotNull VideoEvent event) {
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
        switch (type.hashCode()) {
            case -1896481924:
                if (type.equals("has_like_you")) {
                    VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
                    if (videoCallPreloadModel != null) {
                        str4 = videoCallPreloadModel.getChannelID();
                    }
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.String");
                    if (Intrinsics.areEqual(str4, (String) data)) {
                        oppositeLikeYou();
                        return;
                    }
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
                        String matchUid = videoInteractionAct.getMatchUid();
                        VideoCallPreloadModel videoCallPreloadModel2 = this.preloadModel;
                        if (videoCallPreloadModel2 != null) {
                            str5 = videoCallPreloadModel2.getMatchUniqueID();
                        }
                        if (Intrinsics.areEqual(matchUid, str5)) {
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
                        ((ActivityMatchVideoBinding) getBinding()).videoIM.addMessage(new VideoIMEntity(null, null, null, null, 174, 15, null).analyzeData(groupPublicGiftMessage));
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
                        GiftNoticeUIModel.Companion companion = GiftNoticeUIModel.INSTANCE;
                        long giftId = groupPublicGiftMessage.getGiftInfo().getGiftId();
                        String icon = groupPublicGiftMessage.getGiftInfo().getIcon();
                        Intrinsics.checkNotNullExpressionValue(icon, "getIcon(...)");
                        GiftNoticeUIModel init = companion.init(giftId, icon, groupPublicGiftMessage.getUser(), groupPublicGiftMessage.getToUser(), groupPublicGiftMessage.getGiftInfo().getNum());
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
                        ((ActivityMatchVideoBinding) getBinding()).videoIM.addMessage(new VideoIMEntity(null, null, null, null, 173, 15, null).analyzeData(groupPublicTextMessage));
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
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null && (externalId = user.getExternalId()) != null) {
                            str3 = externalId;
                        }
                        if (Intrinsics.areEqual(externalId2, str3)) {
                            UserProxy.VideoSetting videoSetting2 = videoSettingChange.getVideoSetting();
                            if (videoSetting2 != null) {
                                VideoCallPreloadModel videoCallPreloadModel3 = this.preloadModel;
                                if (videoCallPreloadModel3 != null && (videoSetting = videoCallPreloadModel3.getVideoSetting()) != null && (frontOrBack = videoSetting.getFrontOrBack()) != null) {
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
                            VideoCallPreloadModel videoCallPreloadModel4 = this.preloadModel;
                            if (videoCallPreloadModel4 != null) {
                                UserProxy.VideoSetting videoSetting3 = videoSettingChange.getVideoSetting();
                                Intrinsics.checkNotNullExpressionValue(videoSetting3, "getVideoSetting(...)");
                                videoCallPreloadModel4.setVideoSetting(DataExternalKt.toVideoSet(videoSetting3));
                            }
                            checkMeCamMeera();
                        } else {
                            VideoCallPreloadModel videoCallPreloadModel5 = this.preloadModel;
                            if (videoCallPreloadModel5 != null) {
                                UserProxy.VideoSetting videoSetting4 = videoSettingChange.getVideoSetting();
                                Intrinsics.checkNotNullExpressionValue(videoSetting4, "getVideoSetting(...)");
                                videoCallPreloadModel5.setOtherVideoSetting(DataExternalKt.toVideoSet(videoSetting4));
                            }
                            checkRemoteCamMeera();
                        }
                        processFaceResult();
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
                        ((ActivityMatchVideoBinding) getBinding()).videoIM.addMessage(new VideoIMEntity(null, null, null, null, 175, 15, null).analyzeData(groupPublicInterMessage));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void reportUnionUserPicture(@NotNull final Bitmap pictureBitmap) {
        Intrinsics.checkNotNullParameter(pictureBitmap, "pictureBitmap");
        i0 d = i0.d(new l0() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.a
            public final void a(j0 j0Var) {
                MatchVideoActivity.reportUnionUserPicture$lambda$30(MatchVideoActivity.this, pictureBitmap, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(d, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.i
            public final Object invoke(Object obj) {
                Unit reportUnionUserPicture$lambda$31;
                reportUnionUserPicture$lambda$31 = MatchVideoActivity.reportUnionUserPicture$lambda$31((Boolean) obj);
                return reportUnionUserPicture$lambda$31;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.j
            public final Object invoke(Object obj) {
                Unit reportUnionUserPicture$lambda$32;
                reportUnionUserPicture$lambda$32 = MatchVideoActivity.reportUnionUserPicture$lambda$32(MatchVideoActivity.this, (Throwable) obj);
                return reportUnionUserPicture$lambda$32;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    public final void shootRemoteScreen() {
        i0 d = i0.d(new l0() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.e
            public final void a(j0 j0Var) {
                MatchVideoActivity.shootRemoteScreen$lambda$41(MatchVideoActivity.this, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(d, (Function1) null, (Function1) null, (Function0) null, false, 15, (Object) null), this.compositeDisposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startLocalVideo() {
        VideoSetting videoSetting;
        RtcEngine rtcEngine;
        Integer remoteAgoraId;
        int i;
        Integer localAgoraId;
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.enableFaceDetection(true);
        }
        TextureView CreateTextureView = RtcEngine.CreateTextureView(this);
        ((ActivityMatchVideoBinding) getBinding()).localVideoViewContainer.addView(CreateTextureView);
        this.localVideoView = CreateTextureView;
        RtcEngine rtcEngine3 = agoraRtcService.getRtcEngine();
        int i2 = 0;
        if (rtcEngine3 != null) {
            TextureView textureView = this.localVideoView;
            VideoCallPreloadModel videoCallPreloadModel = this.preloadModel;
            if (videoCallPreloadModel != null && (localAgoraId = videoCallPreloadModel.getLocalAgoraId()) != null) {
                i = localAgoraId.intValue();
            } else {
                i = 0;
            }
            rtcEngine3.setupLocalVideo(new VideoCanvas(textureView, 1, i));
        }
        TextureView CreateTextureView2 = RtcEngine.CreateTextureView(this);
        CreateTextureView2.setFitsSystemWindows(true);
        ((ActivityMatchVideoBinding) getBinding()).remoteVideoViewContainer.addView(CreateTextureView2);
        this.remoteVideoView = CreateTextureView2;
        RtcEngine rtcEngine4 = agoraRtcService.getRtcEngine();
        if (rtcEngine4 != null) {
            TextureView textureView2 = this.remoteVideoView;
            VideoCallPreloadModel videoCallPreloadModel2 = this.preloadModel;
            if (videoCallPreloadModel2 != null && (remoteAgoraId = videoCallPreloadModel2.getRemoteAgoraId()) != null) {
                i2 = remoteAgoraId.intValue();
            }
            rtcEngine4.setupRemoteVideo(new VideoCanvas(textureView2, 1, i2));
        }
        checkMeCamMeera();
        checkRemoteCamMeera();
        VideoCallPreloadModel videoCallPreloadModel3 = this.preloadModel;
        if (videoCallPreloadModel3 != null && (videoSetting = videoCallPreloadModel3.getVideoSetting()) != null && !videoSetting.isFrontCamera() && (rtcEngine = agoraRtcService.getRtcEngine()) != null) {
            rtcEngine.switchCamera();
        }
        startTimerTask();
        ((ActivityMatchVideoBinding) getBinding()).praiseImage.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.m
            @Override // java.lang.Runnable
            public final void run() {
                MatchVideoActivity.startLocalVideo$lambda$44(MatchVideoActivity.this);
            }
        });
    }
}
