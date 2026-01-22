package com.qiahao.nextvideo.room.help;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qhqc.core.basic.aws.AwsS3Repository;
import com.qhqc.core.basic.aws.RequestListener;
import com.qhqc.core.basic.aws.Result;
import com.qhqc.core.basic.aws.S3Configs;
import com.qhqc.core.basic.aws.S3UploadRequest;
import com.qiahao.base_common.interfaceing.BaseDialogInterface;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.GroupGiftDetail;
import com.qiahao.base_common.model.RoomRuleBean;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.RoomTip;
import com.qiahao.hilo_message.databinding.RoomMessageViewBinding;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.hilo_message.utils.MessageProcessor;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.AwardDetailBean;
import com.qiahao.nextvideo.data.model.EnterEffectData;
import com.qiahao.nextvideo.data.model.EnterRoomData;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.LuckWheelInfo;
import com.qiahao.nextvideo.data.model.MeetingRoomReceiveGiftCustomContent;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentGameRoomBinding;
import com.qiahao.nextvideo.databinding.ViewGameNoticeBinding;
import com.qiahao.nextvideo.databinding.ViewGiftNoticeBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity;
import com.qiahao.nextvideo.room.dialog.FirstRechargeDialog;
import com.qiahao.nextvideo.room.dialog.MicFaceDialog;
import com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment;
import com.qiahao.nextvideo.room.fragment.GameRoomFragment;
import com.qiahao.nextvideo.room.game.GameMicAdapter;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener;
import com.qiahao.nextvideo.room.view.micro.GameMicroView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog;
import com.qiahao.nextvideo.ui.im.MessageDataListener;
import com.qiahao.nextvideo.ui.im.MessageListInfo;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskViewModel;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.qiahao.nextvideo.utilities.StorageUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.animation.AnimationQueueManager;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import com.qiahao.nextvideo.utilities.animation.GiftNoticeUIModel;
import com.qiahao.nextvideo.utilities.im.RoomMessageUtil;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001?\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020BH\u0002J\b\u0010D\u001a\u00020BH\u0002J\b\u0010E\u001a\u00020BH\u0002J\u0006\u0010F\u001a\u00020BJ\b\u0010G\u001a\u00020BH\u0002J\b\u0010H\u001a\u00020BH\u0002J\b\u0010K\u001a\u00020BH\u0002J\b\u0010L\u001a\u00020BH\u0002J\u0006\u0010M\u001a\u00020BJ\u0006\u0010N\u001a\u00020BJ\u0006\u0010O\u001a\u00020BJ\u0006\u0010P\u001a\u00020BJ\u0006\u0010Q\u001a\u00020BJ\u0006\u0010R\u001a\u00020BJ\u0006\u0010S\u001a\u00020BJ\u0006\u0010T\u001a\u00020BJ$\u0010U\u001a\u00020B2\b\b\u0002\u0010V\u001a\u00020W2\b\b\u0002\u0010X\u001a\u00020W2\b\b\u0002\u0010Y\u001a\u00020\u000fJ\u0010\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020\\H\u0002J\u0006\u0010]\u001a\u00020BJ\u0010\u0010^\u001a\u00020B2\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010a\u001a\u00020B2\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010b\u001a\u00020B2\u0006\u0010c\u001a\u00020dH\u0002J\"\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020h2\b\b\u0002\u0010i\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020BH\u0002J\b\u0010l\u001a\u00020BH\u0002J\b\u0010m\u001a\u00020BH\u0003J\u0010\u0010n\u001a\u00020B2\u0006\u0010c\u001a\u00020oH\u0002J\u0018\u0010p\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0002J\u0006\u0010q\u001a\u00020BJ\u001e\u0010r\u001a\u00020B2\u0006\u0010s\u001a\u00020W2\u0006\u0010t\u001a\u00020W2\u0006\u0010u\u001a\u00020\u000fJ\u0006\u0010v\u001a\u00020BJ\u0016\u0010w\u001a\u00020B2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020`0yH\u0003J\b\u0010z\u001a\u00020BH\u0002J\u0006\u0010{\u001a\u00020BR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001b\u0010-\u001a\u00020.8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b/\u00100R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020403¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020803¢\u0006\b\n\u0000\u001a\u0004\b9\u00106R*\u0010:\u001a\u0012\u0012\u0004\u0012\u0002080\u0018j\b\u0012\u0004\u0012\u000208`\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010=R\u0010\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u001a\u0010I\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013¨\u0006|"}, d2 = {"Lcom/qiahao/nextvideo/room/help/GameRoomFragmentHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/GameRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/GameRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/GameRoomFragment;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mCurrentEnter", "", "getMCurrentEnter", "()Z", "setMCurrentEnter", "(Z)V", "mEnterRoomFromSmall", "getMEnterRoomFromSmall", "setMEnterRoomFromSmall", "mGiftSourceBeanList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/MeetingRoomReceiveGiftCustomContent;", "Lkotlin/collections/ArrayList;", "getMGiftSourceBeanList", "()Ljava/util/ArrayList;", "mIsGiftTraverseing", "getMIsGiftTraverseing", "setMIsGiftTraverseing", "mIMIsInit", "getMIMIsInit", "setMIMIsInit", "fragmentScope", "Lkotlinx/coroutines/CoroutineScope;", "getFragmentScope", "()Lkotlinx/coroutines/CoroutineScope;", "gameMicAdapter", "Lcom/qiahao/nextvideo/room/game/GameMicAdapter;", "getGameMicAdapter", "()Lcom/qiahao/nextvideo/room/game/GameMicAdapter;", "gameMicAdapter$delegate", "Lkotlin/Lazy;", "fullGiftHelper", "Lcom/qiahao/nextvideo/room/help/FullGiftHelper;", "getFullGiftHelper", "()Lcom/qiahao/nextvideo/room/help/FullGiftHelper;", "fullGiftHelper$delegate", "manager", "Lcom/qiahao/nextvideo/utilities/animation/AnimationQueueManager;", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "getManager", "()Lcom/qiahao/nextvideo/utilities/animation/AnimationQueueManager;", "gameManager", "LuserProxy/UserProxy1$GlobalGameBanner;", "getGameManager", "gameBannerList", "getGameBannerList", "setGameBannerList", "(Ljava/util/ArrayList;)V", "mJoinGroupCallBack", "com/qiahao/nextvideo/room/help/GameRoomFragmentHelp$mJoinGroupCallBack$1", "Lcom/qiahao/nextvideo/room/help/GameRoomFragmentHelp$mJoinGroupCallBack$1;", "initHelp", "", "initFromSamllOrEnterLogic", "checkChatMic", "initClickListener", "showLeaveRoomDialog", "showFloatChat", "initData", "isShow", "setShow", "initChatUI", "initObserve", "showLudoGameView", "showUnoGameView", "showDominoGameView", "showCrushGameView", "showBalootGameView", "showCarromGameView", "showJackaroGameView", "showBackgammonGameView", "showToastOrLog", "toastText", "", "logText", "writeIn", "initView", "groupDetailBean", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "clearMessage", "sendImage", "media", "Lcom/luck/picture/lib/entity/LocalMedia;", "sendVideo", "playGift", "data", "Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "uploadImage", "Lcom/qhqc/core/basic/aws/Result;", "file", "Ljava/io/File;", "isImage", "(Ljava/io/File;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addUserEnterRoomAnimator", "showContactWrapper", "addGameLayout", "addEnterUserLayout", "Lcom/qiahao/nextvideo/data/model/EnterEffectData;", "cuttingGiftList", "dispatchGiftShow", "showSendGiftPanel", "extraId", "userName", "isAllMic", "goToPurchase", "choosePicture", "listener", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "showMicFaceDialog", "release", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameRoomFragmentHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/GameRoomFragmentHelp\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2102:1\n176#2,2:2103\n61#3,9:2105\n51#4:2114\n1#5:2115\n1563#6:2116\n1634#6,3:2117\n1563#6:2120\n1634#6,3:2121\n1869#6,2:2124\n*S KotlinDebug\n*F\n+ 1 GameRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/GameRoomFragmentHelp\n*L\n434#1:2103,2\n436#1:2105,9\n1733#1:2114\n1937#1:2116\n1937#1:2117,3\n1942#1:2120\n1942#1:2121,3\n1944#1:2124,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameRoomFragmentHelp {

    @NotNull
    private final GameRoomFragment fragment;

    @NotNull
    private final CoroutineScope fragmentScope;

    /* renamed from: fullGiftHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fullGiftHelper;

    @NotNull
    private ArrayList<UserProxy1.GlobalGameBanner> gameBannerList;

    @NotNull
    private final AnimationQueueManager<UserProxy1.GlobalGameBanner> gameManager;

    /* renamed from: gameMicAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameMicAdapter;
    private boolean isShow;
    private boolean mCurrentEnter;
    private boolean mEnterRoomFromSmall;

    @NotNull
    private final ArrayList<MeetingRoomReceiveGiftCustomContent> mGiftSourceBeanList;

    @Nullable
    private Handler mHandler;
    private boolean mIMIsInit;
    private boolean mIsGiftTraverseing;

    @NotNull
    private final GameRoomFragmentHelp$mJoinGroupCallBack$1 mJoinGroupCallBack;

    @NotNull
    private final AnimationQueueManager<GiftNoticeUIModel> manager;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qiahao/nextvideo/room/help/GameRoomFragmentHelp$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$1 */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (GameRoomFragmentHelp.this.getFragment().getActivity() == null) {
                return;
            }
            int i = msg.what;
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        if (i == 7) {
                            if (GameRoomFragmentHelp.this.getMGiftSourceBeanList().isEmpty()) {
                                GameRoomFragmentHelp.this.setMIsGiftTraverseing(false);
                                GameRoomFragmentHelp gameRoomFragmentHelp = GameRoomFragmentHelp.this;
                                GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "礼物播放svga:--handler轮训结束 --" + gameRoomFragmentHelp.getMGiftSourceBeanList().size() + "-", false, 5, null);
                                return;
                            }
                            GameRoomFragmentHelp.this.setMIsGiftTraverseing(true);
                            GameRoomFragmentHelp gameRoomFragmentHelp2 = GameRoomFragmentHelp.this;
                            GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp2, null, "礼物播放svga:--handler轮训取头条处理 --" + gameRoomFragmentHelp2.getMGiftSourceBeanList().size() + "-", false, 5, null);
                            GameRoomFragmentHelp.this.dispatchGiftShow();
                            sendEmptyMessageDelayed(7, 500L);
                            return;
                        }
                        return;
                    }
                    GameRoomFragmentHelp.showToastOrLog$default(GameRoomFragmentHelp.this, null, "进群获取群信息后--3秒弹出邀请handler执行上麦网络请求", true, 1, null);
                    GameRoomFragmentHelp.this.getFragment().getMViewModel().enterRoomCheckAutoInviteUpMicDialog();
                    return;
                }
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                if (TextUtils.isEmpty(meetingRoomManager.getMCurrentAgoraChannelId())) {
                    GameRoomFragmentHelp.showToastOrLog$default(GameRoomFragmentHelp.this, null, "handleMessage: 未加入通道！！！ 调用加入通道！！！！", false, 5, null);
                    EnterRoomData enterRoomData = GameRoomFragmentHelp.this.getFragment().getEnterRoomData();
                    if (enterRoomData != null) {
                        GameRoomFragmentHelp.this.getFragment().getMViewModel().joinChannel(enterRoomData.getAgoraToken(), enterRoomData.getAgoraChannel(), enterRoomData.getAgoraId(), enterRoomData.getProvider());
                    }
                    sendEmptyMessageDelayed(5, 5000L);
                    return;
                }
                if (Intrinsics.areEqual(meetingRoomManager.getMCurrentAgoraChannelId(), meetingRoomManager.getMRoomChannelId())) {
                    GameRoomFragmentHelp.showToastOrLog$default(GameRoomFragmentHelp.this, null, " handleMessage: 是同一条通道--不用管", false, 5, null);
                    return;
                }
                return;
            }
            MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
            if (!TextUtils.isEmpty(meetingRoomManager2.getMAgoraToken())) {
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) obj).booleanValue()) {
                    if (meetingRoomManager2.getLocalRoomMicStatus()) {
                        GameRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(false);
                        return;
                    } else {
                        GameRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
                        return;
                    }
                }
                GameRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
                return;
            }
            Object obj2 = msg.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) obj2;
            bool.booleanValue();
            sendMessageDelayed(Message.obtain(this, 4, bool), 200L);
        }
    }

    /* JADX WARN: Type inference failed for: r12v3, types: [com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$mJoinGroupCallBack$1] */
    public GameRoomFragmentHelp(@NotNull GameRoomFragment gameRoomFragment) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(gameRoomFragment, "fragment");
        this.fragment = gameRoomFragment;
        this.mCurrentEnter = true;
        this.mGiftSourceBeanList = new ArrayList<>();
        this.fragmentScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.gameMicAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.e6
            public final Object invoke() {
                GameMicAdapter gameMicAdapter_delegate$lambda$0;
                gameMicAdapter_delegate$lambda$0 = GameRoomFragmentHelp.gameMicAdapter_delegate$lambda$0();
                return gameMicAdapter_delegate$lambda$0;
            }
        });
        this.fullGiftHelper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.f6
            public final Object invoke() {
                FullGiftHelper fullGiftHelper_delegate$lambda$1;
                fullGiftHelper_delegate$lambda$1 = GameRoomFragmentHelp.fullGiftHelper_delegate$lambda$1(GameRoomFragmentHelp.this);
                return fullGiftHelper_delegate$lambda$1;
            }
        });
        FragmentGameRoomBinding binding = gameRoomFragment.getBinding();
        if (binding != null) {
            viewGroup = binding.giftNoticesContainer;
        } else {
            viewGroup = null;
        }
        AnimationQueueManager<GiftNoticeUIModel> animationQueueManager = new AnimationQueueManager<>(viewGroup, new Function1() { // from class: com.qiahao.nextvideo.room.help.g6
            public final Object invoke(Object obj) {
                ViewDataBinding manager$lambda$2;
                manager$lambda$2 = GameRoomFragmentHelp.manager$lambda$2(GameRoomFragmentHelp.this, (GiftNoticeUIModel) obj);
                return manager$lambda$2;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.f5
            public final Object invoke(Object obj, Object obj2) {
                Unit manager$lambda$3;
                manager$lambda$3 = GameRoomFragmentHelp.manager$lambda$3(GameRoomFragmentHelp.this, (ViewDataBinding) obj, (GiftNoticeUIModel) obj2);
                return manager$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.g5
            public final Object invoke(Object obj) {
                String manager$lambda$4;
                manager$lambda$4 = GameRoomFragmentHelp.manager$lambda$4((GiftNoticeUIModel) obj);
                return manager$lambda$4;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.h5
            public final Object invoke(Object obj, Object obj2) {
                GiftNoticeUIModel manager$lambda$5;
                manager$lambda$5 = GameRoomFragmentHelp.manager$lambda$5((GiftNoticeUIModel) obj, (GiftNoticeUIModel) obj2);
                return manager$lambda$5;
            }
        }, 0, 32, null);
        LifecycleOwner viewLifecycleOwner = gameRoomFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        animationQueueManager.bindToLifecycle(viewLifecycleOwner);
        this.manager = animationQueueManager;
        FragmentGameRoomBinding binding2 = gameRoomFragment.getBinding();
        AnimationQueueManager<UserProxy1.GlobalGameBanner> animationQueueManager2 = new AnimationQueueManager<>(binding2 != null ? binding2.roomGameNotice : null, new Function1() { // from class: com.qiahao.nextvideo.room.help.i5
            public final Object invoke(Object obj) {
                ViewDataBinding gameManager$lambda$7;
                gameManager$lambda$7 = GameRoomFragmentHelp.gameManager$lambda$7(GameRoomFragmentHelp.this, (UserProxy1.GlobalGameBanner) obj);
                return gameManager$lambda$7;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.j5
            public final Object invoke(Object obj, Object obj2) {
                Unit gameManager$lambda$8;
                gameManager$lambda$8 = GameRoomFragmentHelp.gameManager$lambda$8(GameRoomFragmentHelp.this, (ViewDataBinding) obj, (UserProxy1.GlobalGameBanner) obj2);
                return gameManager$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.k5
            public final Object invoke(Object obj) {
                String gameManager$lambda$9;
                gameManager$lambda$9 = GameRoomFragmentHelp.gameManager$lambda$9((UserProxy1.GlobalGameBanner) obj);
                return gameManager$lambda$9;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.l5
            public final Object invoke(Object obj, Object obj2) {
                UserProxy1.GlobalGameBanner gameManager$lambda$10;
                gameManager$lambda$10 = GameRoomFragmentHelp.gameManager$lambda$10((UserProxy1.GlobalGameBanner) obj, (UserProxy1.GlobalGameBanner) obj2);
                return gameManager$lambda$10;
            }
        }, 1);
        LifecycleOwner viewLifecycleOwner2 = gameRoomFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        animationQueueManager2.bindToLifecycle(viewLifecycleOwner2);
        this.gameManager = animationQueueManager2;
        this.gameBannerList = new ArrayList<>();
        this.mJoinGroupCallBack = new V2TIMCallback() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$mJoinGroupCallBack$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
                GameRoomFragmentHelp.this.setMIMIsInit(false);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                GameRoomFragmentHelp.this.setMIMIsInit(true);
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                if (GameRoomFragmentHelp.this.getFragment().getActivity() == null) {
                    return;
                }
                int i = msg.what;
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i == 7) {
                                if (GameRoomFragmentHelp.this.getMGiftSourceBeanList().isEmpty()) {
                                    GameRoomFragmentHelp.this.setMIsGiftTraverseing(false);
                                    GameRoomFragmentHelp gameRoomFragmentHelp = GameRoomFragmentHelp.this;
                                    GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp, null, "礼物播放svga:--handler轮训结束 --" + gameRoomFragmentHelp.getMGiftSourceBeanList().size() + "-", false, 5, null);
                                    return;
                                }
                                GameRoomFragmentHelp.this.setMIsGiftTraverseing(true);
                                GameRoomFragmentHelp gameRoomFragmentHelp2 = GameRoomFragmentHelp.this;
                                GameRoomFragmentHelp.showToastOrLog$default(gameRoomFragmentHelp2, null, "礼物播放svga:--handler轮训取头条处理 --" + gameRoomFragmentHelp2.getMGiftSourceBeanList().size() + "-", false, 5, null);
                                GameRoomFragmentHelp.this.dispatchGiftShow();
                                sendEmptyMessageDelayed(7, 500L);
                                return;
                            }
                            return;
                        }
                        GameRoomFragmentHelp.showToastOrLog$default(GameRoomFragmentHelp.this, null, "进群获取群信息后--3秒弹出邀请handler执行上麦网络请求", true, 1, null);
                        GameRoomFragmentHelp.this.getFragment().getMViewModel().enterRoomCheckAutoInviteUpMicDialog();
                        return;
                    }
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    if (TextUtils.isEmpty(meetingRoomManager.getMCurrentAgoraChannelId())) {
                        GameRoomFragmentHelp.showToastOrLog$default(GameRoomFragmentHelp.this, null, "handleMessage: 未加入通道！！！ 调用加入通道！！！！", false, 5, null);
                        EnterRoomData enterRoomData = GameRoomFragmentHelp.this.getFragment().getEnterRoomData();
                        if (enterRoomData != null) {
                            GameRoomFragmentHelp.this.getFragment().getMViewModel().joinChannel(enterRoomData.getAgoraToken(), enterRoomData.getAgoraChannel(), enterRoomData.getAgoraId(), enterRoomData.getProvider());
                        }
                        sendEmptyMessageDelayed(5, 5000L);
                        return;
                    }
                    if (Intrinsics.areEqual(meetingRoomManager.getMCurrentAgoraChannelId(), meetingRoomManager.getMRoomChannelId())) {
                        GameRoomFragmentHelp.showToastOrLog$default(GameRoomFragmentHelp.this, null, " handleMessage: 是同一条通道--不用管", false, 5, null);
                        return;
                    }
                    return;
                }
                MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                if (!TextUtils.isEmpty(meetingRoomManager2.getMAgoraToken())) {
                    Object obj = msg.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) obj).booleanValue()) {
                        if (meetingRoomManager2.getLocalRoomMicStatus()) {
                            GameRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(false);
                            return;
                        } else {
                            GameRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
                            return;
                        }
                    }
                    GameRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
                    return;
                }
                Object obj2 = msg.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                Boolean bool = (Boolean) obj2;
                bool.booleanValue();
                sendMessageDelayed(Message.obtain(this, 4, bool), 200L);
            }
        };
    }

    public final void addEnterUserLayout(EnterEffectData data) {
        int i;
        LinearLayoutCompat linearLayoutCompat;
        int i2;
        String userName;
        String str;
        float f;
        LinearLayoutCompat linearLayoutCompat2;
        String str2;
        Drawable drawable;
        Integer num;
        CharSequence charSequence;
        if (MeetingRoomManager.INSTANCE.checkGameMadel()) {
            return;
        }
        Integer entryEffectType = data.getEntryEffectType();
        if (entryEffectType != null && entryEffectType.intValue() == 1) {
            i = R.layout.layout_cp_user_enter_group_room;
        } else if (entryEffectType != null && entryEffectType.intValue() == 2) {
            i = R.layout.layout_mystery_user_enter_group_room;
        } else if (entryEffectType != null && entryEffectType.intValue() == 3) {
            i = R.layout.layout_nobility_user_enter_group_room;
        } else if (entryEffectType != null && entryEffectType.intValue() == 4) {
            i = R.layout.layout_vip_user_enter_group_room;
        } else {
            i = R.layout.layout_user_enter_group_room;
        }
        LayoutInflater from = LayoutInflater.from(this.fragment.getContext());
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        if (binding != null) {
            linearLayoutCompat = binding.userEnterRoomContent;
        } else {
            linearLayoutCompat = null;
        }
        final View inflate = from.inflate(i, (ViewGroup) linearLayoutCompat, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(ScreenUtil.getScreenWidth(this.fragment.getContext()));
        inflate.setLayoutParams(layoutParams2);
        TextView textView = (TextView) inflate.findViewById(R.id.user_enter_room);
        String userName2 = data.getUserName();
        if (userName2 != null) {
            i2 = userName2.length();
        } else {
            i2 = 0;
        }
        if (i2 > 8) {
            String userName3 = data.getUserName();
            if (userName3 != null) {
                charSequence = userName3.subSequence(0, 7);
            } else {
                charSequence = null;
            }
            userName = ((Object) charSequence) + "...";
        } else {
            userName = data.getUserName();
        }
        View findViewById = inflate.findViewById(R.id.back_group);
        Integer entryEffectType2 = data.getEntryEffectType();
        if (entryEffectType2 != null && entryEffectType2.intValue() == 1) {
            HiloImageView findViewById2 = inflate.findViewById(R.id.leftAvatar);
            HiloImageView findViewById3 = inflate.findViewById(R.id.rightAvatar);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.model);
            String userAvatar = data.getUserAvatar();
            if (userAvatar == null) {
                userAvatar = "";
            }
            HiloImageView.loadImage$default(findViewById2, userAvatar, 2131231655, 0, 4, (Object) null);
            String cpUserAvatar = data.getCpUserAvatar();
            if (cpUserAvatar == null) {
                str2 = "";
            } else {
                str2 = cpUserAvatar;
            }
            HiloImageView.loadImage$default(findViewById3, str2, 2131231655, 0, 4, (Object) null);
            Integer relationMedal$default = RelationTypeUtils.getRelationMedal$default(RelationTypeUtils.INSTANCE, data.getCpLevel(), false, 0, 6, (Object) null);
            if (relationMedal$default != null) {
                drawable = androidx.core.content.a.getDrawable(imageView.getContext(), relationMedal$default.intValue());
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            Integer cpLevel = data.getCpLevel();
            if (cpLevel != null && cpLevel.intValue() == 2) {
                num = 2131231582;
            } else if (cpLevel != null && cpLevel.intValue() == 3) {
                num = 2131231583;
            } else if (cpLevel != null && cpLevel.intValue() == 4) {
                num = 2131231584;
            } else if (cpLevel != null && cpLevel.intValue() == 5) {
                num = 2131231585;
            } else {
                num = null;
            }
            if (num != null) {
                int intValue = num.intValue();
                Intrinsics.checkNotNull(findViewById);
                ImageKtxKt.toHorizontalMirror(findViewById, intValue);
            }
        } else if (entryEffectType2 != null && entryEffectType2.intValue() == 2) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131954385);
            String stringById2 = ResourcesKtxKt.getStringById(this, 2131953504);
            SvipData svip = data.getSvip();
            if (svip != null) {
                str = svip.mysteryNumber();
            } else {
                str = null;
            }
            String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            String format3 = String.format(stringById, Arrays.copyOf(new Object[]{format2}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textView.setText(format3);
            Intrinsics.checkNotNull(findViewById);
            ImageKtxKt.toHorizontalMirror(findViewById, R.drawable.mystery_enter_room);
        } else if (entryEffectType2 != null && entryEffectType2.intValue() == 3) {
            String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            textView.setText(format4);
            Integer nobleEnterRoomBackRes = UserService.INSTANCE.getNobleEnterRoomBackRes(data.getNobleLevel());
            if (nobleEnterRoomBackRes != null) {
                int intValue2 = nobleEnterRoomBackRes.intValue();
                Intrinsics.checkNotNull(findViewById);
                ImageKtxKt.toHorizontalMirror(findViewById, intValue2);
            }
            if (data.getNobleLevel() == 5) {
                textView.setTextColor(Color.parseColor("#fa5200"));
            }
        } else if (entryEffectType2 != null && entryEffectType2.intValue() == 4) {
            String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
            textView.setText(format5);
            Intrinsics.checkNotNull(findViewById);
            ImageKtxKt.toHorizontalMirror(findViewById, R.drawable.vip_enter_room);
        } else {
            String format6 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
            Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
            textView.setText(format6);
        }
        inflate.setTag(Long.valueOf(System.currentTimeMillis()));
        FragmentGameRoomBinding binding2 = this.fragment.getBinding();
        if (binding2 != null && (linearLayoutCompat2 = binding2.userEnterRoomContent) != null) {
            linearLayoutCompat2.addView(inflate);
        }
        ViewPropertyAnimator animate = inflate.animate();
        if (ViewUtilitiesKt.getRightToLeftDirection()) {
            f = ScreenUtil.getScreenWidth(this.fragment.getContext()) - Dimens.INSTANCE.dpToPx(14);
        } else {
            f = -(ScreenUtil.getScreenWidth(this.fragment.getContext()) - Dimens.INSTANCE.dpToPx(14));
        }
        animate.translationX(f);
        animate.setDuration(500L);
        animate.start();
        showToastOrLog$default(this, null, "addEnterUserLayout: view " + inflate, false, 5, null);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.help.n5
                @Override // java.lang.Runnable
                public final void run() {
                    GameRoomFragmentHelp.addEnterUserLayout$lambda$60(GameRoomFragmentHelp.this, inflate);
                }
            }, 4000L);
        }
    }

    public static final void addEnterUserLayout$lambda$60(GameRoomFragmentHelp gameRoomFragmentHelp, View view) {
        LinearLayoutCompat linearLayoutCompat;
        FragmentGameRoomBinding binding;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        FragmentGameRoomBinding binding2 = gameRoomFragmentHelp.fragment.getBinding();
        if (binding2 != null && (linearLayoutCompat3 = binding2.userEnterRoomContent) != null) {
            linearLayoutCompat3.removeView(view);
        }
        showToastOrLog$default(gameRoomFragmentHelp, null, "addEnterUserLayout: remove  view " + view, false, 5, null);
        FragmentGameRoomBinding binding3 = gameRoomFragmentHelp.fragment.getBinding();
        if (binding3 != null && (linearLayoutCompat = binding3.userEnterRoomContent) != null && linearLayoutCompat.getChildCount() == 0 && (binding = gameRoomFragmentHelp.fragment.getBinding()) != null && (linearLayoutCompat2 = binding.userEnterRoomContent) != null) {
            linearLayoutCompat2.setVisibility(0);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void addGameLayout() {
        LinearLayoutCompat linearLayoutCompat;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        if (!MeetingRoomManager.INSTANCE.checkGameMadel() && this.fragment.getContext() != null && !this.gameBannerList.isEmpty()) {
            FragmentGameRoomBinding binding = this.fragment.getBinding();
            if (binding == null || (linearLayoutCompat3 = binding.roomGameNotice) == null || linearLayoutCompat3.getChildCount() == 0) {
                int i = 0;
                UserProxy1.GlobalGameBanner globalGameBanner = this.gameBannerList.get(0);
                Intrinsics.checkNotNullExpressionValue(globalGameBanner, "get(...)");
                UserProxy1.GlobalGameBanner globalGameBanner2 = globalGameBanner;
                this.gameBannerList.remove(0);
                LayoutInflater from = LayoutInflater.from(this.fragment.getContext());
                FragmentGameRoomBinding binding2 = this.fragment.getBinding();
                if (binding2 != null) {
                    linearLayoutCompat = binding2.roomGameNotice;
                } else {
                    linearLayoutCompat = null;
                }
                final ViewGameNoticeBinding viewGameNoticeBinding = (ViewGameNoticeBinding) androidx.databinding.g.h(from, R.layout.view_game_notice, linearLayoutCompat, false);
                ImageView imageView = viewGameNoticeBinding.topImage;
                if (TextUtils.isEmpty(globalGameBanner2.getBannerUrl())) {
                    i = 8;
                }
                imageView.setVisibility(i);
                ImageView imageView2 = viewGameNoticeBinding.topImage;
                Intrinsics.checkNotNullExpressionValue(imageView2, "topImage");
                ImageKtxKt.loadImage$default(imageView2, globalGameBanner2.getBannerUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                QMUIRadiusImageView qMUIRadiusImageView = viewGameNoticeBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, globalGameBanner2.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                viewGameNoticeBinding.diamond.setText("x" + globalGameBanner2.getDiamond());
                viewGameNoticeBinding.getRoot().setTag(Long.valueOf(System.currentTimeMillis()));
                FragmentGameRoomBinding binding3 = this.fragment.getBinding();
                if (binding3 != null && (linearLayoutCompat2 = binding3.roomGameNotice) != null) {
                    linearLayoutCompat2.addView(viewGameNoticeBinding.getRoot());
                }
                if (ViewUtilitiesKt.getRightToLeftDirection()) {
                    AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                    View root = viewGameNoticeBinding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                    animationUtility.translationX(root, -ScreenUtil.getScreenWidth(this.fragment.getContext()), -Dimens.INSTANCE.dpToPx(14)).start();
                } else {
                    AnimationUtility animationUtility2 = AnimationUtility.INSTANCE;
                    View root2 = viewGameNoticeBinding.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                    animationUtility2.translationX(root2, ScreenUtil.getScreenWidth(this.fragment.getContext()), Dimens.INSTANCE.dpToPx(14)).start();
                }
                showToastOrLog$default(this, null, "addEnterUserLayout: view " + viewGameNoticeBinding.getRoot(), false, 5, null);
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.help.c6
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameRoomFragmentHelp.addGameLayout$lambda$55(GameRoomFragmentHelp.this, viewGameNoticeBinding);
                        }
                    }, 4000L);
                }
            }
        }
    }

    public static final void addGameLayout$lambda$55(GameRoomFragmentHelp gameRoomFragmentHelp, ViewGameNoticeBinding viewGameNoticeBinding) {
        LinearLayoutCompat linearLayoutCompat;
        FragmentGameRoomBinding binding;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        FragmentGameRoomBinding binding2 = gameRoomFragmentHelp.fragment.getBinding();
        if (binding2 != null && (linearLayoutCompat3 = binding2.roomGameNotice) != null) {
            linearLayoutCompat3.removeView(viewGameNoticeBinding.getRoot());
        }
        gameRoomFragmentHelp.addGameLayout();
        showToastOrLog$default(gameRoomFragmentHelp, null, "addEnterUserLayout: remove  view " + viewGameNoticeBinding.getRoot(), false, 5, null);
        FragmentGameRoomBinding binding3 = gameRoomFragmentHelp.fragment.getBinding();
        if (binding3 != null && (linearLayoutCompat = binding3.roomGameNotice) != null && linearLayoutCompat.getChildCount() == 0 && (binding = gameRoomFragmentHelp.fragment.getBinding()) != null && (linearLayoutCompat2 = binding.roomGameNotice) != null) {
            linearLayoutCompat2.setVisibility(0);
        }
    }

    private final void addUserEnterRoomAnimator() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.help.y5
                @Override // java.lang.Runnable
                public final void run() {
                    GameRoomFragmentHelp.addUserEnterRoomAnimator$lambda$53(GameRoomFragmentHelp.this);
                }
            }, 100L);
        }
    }

    public static final void addUserEnterRoomAnimator$lambda$53(GameRoomFragmentHelp gameRoomFragmentHelp) {
        String str;
        User user;
        SvipData svip;
        String str2;
        String str3;
        String str4;
        String str5;
        List list;
        String str6;
        RideBean ride;
        RideBean ride2;
        RideBean ride3;
        RideBean ride4;
        String receiverAvatar;
        RideBean ride5;
        String senderAvatar;
        String avatar;
        RideBean ride6;
        String effectUrl;
        RideBean ride7;
        EnterEffectData enterEffectData;
        GroupDetailBean groupDetailBean = (GroupDetailBean) gameRoomFragmentHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
        String str7 = null;
        if (groupDetailBean != null) {
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null) {
                enterEffectData = DataExternalKt.userToEnterEffectData(user2, groupDetailBean);
            } else {
                enterEffectData = null;
            }
            if (enterEffectData != null) {
                gameRoomFragmentHelp.addEnterUserLayout(enterEffectData);
            }
        }
        UserStore.Companion companion = UserStore.INSTANCE;
        User user3 = companion.getShared().getUser();
        if (user3 != null && (ride7 = user3.getRide()) != null) {
            str = ride7.getEffectUrl();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0 && (user = companion.getShared().getUser()) != null && (svip = user.getSvip()) != null && !svip.isMystery()) {
            showToastOrLog$default(gameRoomFragmentHelp, null, "礼物播放svga:---进房间----", false, 5, null);
            if (MeetingRoomManager.INSTANCE.isShowEnterEffect()) {
                User user4 = companion.getShared().getUser();
                if (user4 == null || (ride6 = user4.getRide()) == null || (effectUrl = ride6.getEffectUrl()) == null) {
                    str2 = "";
                } else {
                    str2 = effectUrl;
                }
                User user5 = companion.getShared().getUser();
                if (user5 == null || (avatar = user5.getAvatar()) == null) {
                    str3 = "";
                } else {
                    str3 = avatar;
                }
                User user6 = companion.getShared().getUser();
                if (user6 == null || (ride5 = user6.getRide()) == null || (senderAvatar = ride5.getSenderAvatar()) == null) {
                    str4 = "";
                } else {
                    str4 = senderAvatar;
                }
                User user7 = companion.getShared().getUser();
                if (user7 == null || (ride4 = user7.getRide()) == null || (receiverAvatar = ride4.getReceiverAvatar()) == null) {
                    str5 = "";
                } else {
                    str5 = receiverAvatar;
                }
                User user8 = companion.getShared().getUser();
                if (user8 != null && (ride3 = user8.getRide()) != null) {
                    list = ride3.getTextStyleList();
                } else {
                    list = null;
                }
                User user9 = companion.getShared().getUser();
                if (user9 != null && (ride2 = user9.getRide()) != null) {
                    str6 = ride2.getSenderNick();
                } else {
                    str6 = null;
                }
                User user10 = companion.getShared().getUser();
                if (user10 != null && (ride = user10.getRide()) != null) {
                    str7 = ride.getReceiverNick();
                }
                gameRoomFragmentHelp.playGift(new GiftDateItem(str2, str3, "", null, null, GiftDateItem.TYPE_ENTER_ANIMATION, null, null, str4, str5, null, list, str7, str6, null, 17624, null));
            }
        }
    }

    public final void checkChatMic() {
        String str;
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        int i;
        Boolean forbid;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        MicroBean checkUserMic = meetingRoomManager.checkUserMic(str);
        RoomMessageView mChatLayout = this.fragment.getMChatLayout();
        if (mChatLayout != null && (messageBinding = mChatLayout.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
            boolean z = false;
            if (checkUserMic == null) {
                i = 8;
            } else {
                i = 0;
            }
            if (checkUserMic != null && (forbid = checkUserMic.getForbid()) != null) {
                z = forbid.booleanValue();
            }
            roomInputView.changeRoomMicStatus(i, z);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void choosePicture(OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(false).isMEnableCrop(false).build(), listener);
    }

    private final ArrayList<MeetingRoomReceiveGiftCustomContent> cuttingGiftList() {
        ArrayList<MeetingRoomReceiveGiftCustomContent> arrayList = new ArrayList<>();
        if (this.mGiftSourceBeanList.size() > 20) {
            Iterator<MeetingRoomReceiveGiftCustomContent> it = this.mGiftSourceBeanList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MeetingRoomReceiveGiftCustomContent next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent = next;
                if (arrayList.size() < 20) {
                    arrayList.add(meetingRoomReceiveGiftCustomContent);
                    it.remove();
                }
            }
        } else {
            arrayList.addAll(this.mGiftSourceBeanList);
            this.mGiftSourceBeanList.clear();
        }
        return arrayList;
    }

    public static final FullGiftHelper fullGiftHelper_delegate$lambda$1(GameRoomFragmentHelp gameRoomFragmentHelp) {
        FrameLayout frameLayout;
        FragmentGameRoomBinding binding = gameRoomFragmentHelp.fragment.getBinding();
        if (binding != null) {
            frameLayout = binding.frameLayout;
        } else {
            frameLayout = null;
        }
        return new FullGiftHelper(frameLayout);
    }

    public static final UserProxy1.GlobalGameBanner gameManager$lambda$10(UserProxy1.GlobalGameBanner globalGameBanner, UserProxy1.GlobalGameBanner globalGameBanner2) {
        Intrinsics.checkNotNullParameter(globalGameBanner, "newData");
        Intrinsics.checkNotNullParameter(globalGameBanner2, "oldData");
        return globalGameBanner;
    }

    public static final ViewDataBinding gameManager$lambda$7(GameRoomFragmentHelp gameRoomFragmentHelp, UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(globalGameBanner, "data");
        ViewGameNoticeBinding inflate = ViewGameNoticeBinding.inflate(LayoutInflater.from(gameRoomFragmentHelp.fragment.getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public static final Unit gameManager$lambda$8(GameRoomFragmentHelp gameRoomFragmentHelp, ViewDataBinding viewDataBinding, UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(viewDataBinding, "gameBinding");
        Intrinsics.checkNotNullParameter(globalGameBanner, "newData");
        if (viewDataBinding instanceof ViewGameNoticeBinding) {
            AudioRoomExtraDataKt.refreshGameView(gameRoomFragmentHelp, (ViewGameNoticeBinding) viewDataBinding, globalGameBanner);
        }
        return Unit.INSTANCE;
    }

    public static final String gameManager$lambda$9(UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(globalGameBanner, "it");
        return DataExternalKt.checkData(globalGameBanner);
    }

    public static final GameMicAdapter gameMicAdapter_delegate$lambda$0() {
        return new GameMicAdapter();
    }

    public static final Unit goToPurchase$lambda$67(GameRoomFragmentHelp gameRoomFragmentHelp, ApiResponse apiResponse) {
        boolean z;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        final Context activity = gameRoomFragmentHelp.fragment.getActivity();
        if (activity != null) {
            AwardDetailBean awardDetailBean = (AwardDetailBean) apiResponse.getData();
            if (awardDetailBean != null) {
                z = Intrinsics.areEqual(awardDetailBean.getHasGetReward(), Boolean.FALSE);
            } else {
                z = false;
            }
            if (z) {
                FirstRechargeDialog firstRechargeDialog = new FirstRechargeDialog(activity);
                firstRechargeDialog.setListener(new BaseDialogInterface() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$goToPurchase$1$1$1$1
                    public void clickConfirm() {
                        WalletActivity.INSTANCE.start(activity);
                    }
                });
                firstRechargeDialog.show();
            } else {
                WalletActivity.INSTANCE.start(activity);
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit goToPurchase$lambda$68(GameRoomFragmentHelp gameRoomFragmentHelp, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        showToastOrLog$default(gameRoomFragmentHelp, null, "第一次充值请求失败", false, 5, null);
        return Unit.INSTANCE;
    }

    private final void initChatUI() {
        GroupInputLayoutView groupInputLayoutView;
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        RoomMessageViewBinding messageBinding2;
        RoomInputView roomInputView2;
        RoomMessageViewBinding messageBinding3;
        RoomInputView roomInputView3;
        boolean z;
        GameMicroView gameMicroView;
        if (this.fragment.getActivity() == null) {
            return;
        }
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (gameMicroView = binding.gameMic) != null) {
            gameMicroView.setOnMeetingRoomMicroItemClickListener(new GameRoomFragmentHelp$initChatUI$1(this));
        }
        RoomMessageView mChatLayout = this.fragment.getMChatLayout();
        if (mChatLayout != null && (messageBinding3 = mChatLayout.messageBinding()) != null && (roomInputView3 = messageBinding3.chatInputLayout) != null) {
            if (MessageProvide.INSTANCE.getUnReadMessage() > 0) {
                z = true;
            } else {
                z = false;
            }
            roomInputView3.hasNewMessage(z);
        }
        RoomMessageView mChatLayout2 = this.fragment.getMChatLayout();
        if (mChatLayout2 != null && (messageBinding2 = mChatLayout2.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
            roomInputView2.hideGame(true);
        }
        RoomMessageView mChatLayout3 = this.fragment.getMChatLayout();
        if (mChatLayout3 != null) {
            mChatLayout3.setMessageItemListener(new GameRoomFragmentHelp$initChatUI$2(this));
        }
        RoomMessageView mChatLayout4 = this.fragment.getMChatLayout();
        if (mChatLayout4 != null && (messageBinding = mChatLayout4.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
            roomInputView.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.r5
                public final Object invoke(Object obj) {
                    Unit initChatUI$lambda$26;
                    initChatUI$lambda$26 = GameRoomFragmentHelp.initChatUI$lambda$26(GameRoomFragmentHelp.this, ((Integer) obj).intValue());
                    return initChatUI$lambda$26;
                }
            });
        }
        FragmentGameRoomBinding binding2 = this.fragment.getBinding();
        if (binding2 != null && (groupInputLayoutView = binding2.groupInput) != null) {
            groupInputLayoutView.setOnGroupInputLayoutListener(new OnGroupInputLayoutListener() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initChatUI$4
                @Override // com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener
                public void onStartGroupMemberSelectActivity() {
                    GameRoomFragmentHelp.showToastOrLog$default(GameRoomFragmentHelp.this, null, "onStartGroupMemberSelectActivity: ", false, 5, null);
                    Intent intent = new Intent(GameRoomFragmentHelp.this.getFragment().getContext(), (Class<?>) RoomMemberOnlineActivity.class);
                    intent.putExtra("group_id", GameRoomFragmentHelp.this.getFragment().getMViewModel().getMGroupId());
                    intent.putExtra(RoomMemberOnlineActivity.IS_AT_USER, true);
                    intent.putExtra(RoomMemberOnlineActivity.VISITOR_USER, false);
                    FragmentActivity activity = GameRoomFragmentHelp.this.getFragment().getActivity();
                    if (activity != null) {
                        activity.startActivityForResult(intent, 3);
                    }
                }

                @Override // com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener
                public void sendMessage(String msg, List<RoomMessage.TextElemContentAt> mentionUsers) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    if (FastClickOneUtils.INSTANCE.isFastClick()) {
                        try {
                            RoomMessageUtil.sendMessage$default(RoomMessageUtil.INSTANCE, GameRoomFragmentHelp.this.getFragment().getMChatLayout(), BuildMessageUtilsKt.roomMessageText(MeetingRoomManager.INSTANCE.getMGroupId(), msg, mentionUsers), false, 4, null);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, GameRoomFragmentHelp.this.getFragment().getContext(), ResourcesKtxKt.getStringById(this, 2131954113), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }

                @Override // com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener
                public void setShowSelectPicVideo() {
                    final GameRoomFragmentHelp gameRoomFragmentHelp = GameRoomFragmentHelp.this;
                    gameRoomFragmentHelp.choosePicture(new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initChatUI$4$setShowSelectPicVideo$1
                        public void onCancel() {
                        }

                        public void onResult(ArrayList<LocalMedia> result) {
                            if (result != null && (!result.isEmpty())) {
                                LocalMedia localMedia = result.get(0);
                                Intrinsics.checkNotNullExpressionValue(localMedia, "get(...)");
                                LocalMedia localMedia2 = localMedia;
                                if (localMedia2.getMimeType() != null) {
                                    String mimeType = localMedia2.getMimeType();
                                    Intrinsics.checkNotNullExpressionValue(mimeType, "getMimeType(...)");
                                    if (StringsKt.contains$default(mimeType, "video", false, 2, (Object) null)) {
                                        GameRoomFragmentHelp.this.sendVideo(localMedia2);
                                        return;
                                    }
                                }
                                if (localMedia2.getMimeType() != null) {
                                    String mimeType2 = localMedia2.getMimeType();
                                    Intrinsics.checkNotNullExpressionValue(mimeType2, "getMimeType(...)");
                                    if (StringsKt.contains$default(mimeType2, "image", false, 2, (Object) null)) {
                                        GameRoomFragmentHelp.this.sendImage(localMedia2);
                                    }
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    public static final Unit initChatUI$lambda$26(GameRoomFragmentHelp gameRoomFragmentHelp, int i) {
        GroupInputLayoutView groupInputLayoutView;
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        RoomMessageViewBinding messageBinding2;
        RoomInputView roomInputView2;
        String str;
        String externalId;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    String str2 = "";
                    if (i != 5) {
                        if (i != 6) {
                            if (i == 7) {
                                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                                UserStore.Companion companion = UserStore.INSTANCE;
                                User user = companion.getShared().getUser();
                                if (user == null || (str = user.getExternalId()) == null) {
                                    str = "";
                                }
                                MicroBean checkUserMic = meetingRoomManager.checkUserMic(str);
                                if (checkUserMic == null) {
                                    return Unit.INSTANCE;
                                }
                                User user2 = companion.getShared().getUser();
                                if (user2 != null && (externalId = user2.getExternalId()) != null) {
                                    str2 = externalId;
                                }
                                int findMicPositionFromExtraId = meetingRoomManager.findMicPositionFromExtraId(str2);
                                if (Intrinsics.areEqual(checkUserMic.getForbid(), Boolean.TRUE)) {
                                    gameRoomFragmentHelp.fragment.getMViewModel().unMuteMic(findMicPositionFromExtraId);
                                } else {
                                    gameRoomFragmentHelp.fragment.getMViewModel().muteMic(findMicPositionFromExtraId);
                                }
                            }
                        } else {
                            gameRoomFragmentHelp.showMicFaceDialog();
                        }
                    } else {
                        gameRoomFragmentHelp.showSendGiftPanel("", "", true);
                    }
                } else {
                    gameRoomFragmentHelp.showContactWrapper();
                }
            } else {
                showToastOrLog$default(gameRoomFragmentHelp, null, "onClick: setRoomSoundHandler", false, 5, null);
                GroupDetailBean groupDetailBean = (GroupDetailBean) gameRoomFragmentHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
                if (groupDetailBean != null && groupDetailBean.getMicOn()) {
                    MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                    if (meetingRoomManager2.getLocalRoomMicStatus()) {
                        meetingRoomManager2.setLocalRoomMicStatus(false);
                        RoomMessageView mChatLayout = gameRoomFragmentHelp.fragment.getMChatLayout();
                        if (mChatLayout != null && (messageBinding2 = mChatLayout.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
                            roomInputView2.changeRoomSoundStatus(false);
                        }
                        gameRoomFragmentHelp.fragment.getMViewModel().setRemoteAllMute(true);
                    } else {
                        RoomMessageView mChatLayout2 = gameRoomFragmentHelp.fragment.getMChatLayout();
                        if (mChatLayout2 != null && (messageBinding = mChatLayout2.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
                            roomInputView.changeRoomSoundStatus(true);
                        }
                        meetingRoomManager2.setLocalRoomMicStatus(true);
                        gameRoomFragmentHelp.fragment.getMViewModel().setRemoteAllMute(false);
                    }
                } else {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, gameRoomFragmentHelp.fragment.getContext(), ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131953000), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        } else {
            FragmentGameRoomBinding binding = gameRoomFragmentHelp.fragment.getBinding();
            if (binding != null && (groupInputLayoutView = binding.groupInput) != null) {
                groupInputLayoutView.showSoftInput();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initClickListener() {
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        if (binding != null) {
            binding.setClick(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.t5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameRoomFragmentHelp.initClickListener$lambda$13(GameRoomFragmentHelp.this, view);
                }
            });
        }
    }

    public static final void initClickListener$lambda$13(GameRoomFragmentHelp gameRoomFragmentHelp, View view) {
        GroupInputLayoutView groupInputLayoutView;
        int id2 = view.getId();
        if (id2 != 2131362802) {
            if (id2 != 2131363084) {
                if (id2 == 2131364825) {
                    gameRoomFragmentHelp.showFloatChat();
                    return;
                }
                return;
            } else {
                FragmentGameRoomBinding binding = gameRoomFragmentHelp.fragment.getBinding();
                if (binding != null && (groupInputLayoutView = binding.groupInput) != null) {
                    groupInputLayoutView.hideSoftInput();
                    return;
                }
                return;
            }
        }
        showToastOrLog$default(gameRoomFragmentHelp, null, "onClick: back_image_view", false, 5, null);
        gameRoomFragmentHelp.showLeaveRoomDialog();
    }

    private final void initData() {
        GameRoomFragmentHelp mAudioHelp;
        GameRoomFragmentHelp mAudioHelp2;
        GameRoomFragmentHelp mAudioHelp3;
        GameRoomFragmentHelp mAudioHelp4;
        GameRoomFragmentHelp mAudioHelp5;
        GameRoomFragmentHelp mAudioHelp6;
        GameRoomFragmentHelp mAudioHelp7;
        RoomViewModel mViewModel = this.fragment.getMViewModel();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        mViewModel.getGameList(meetingRoomManager.getMGroupId());
        if (this.mEnterRoomFromSmall) {
            if (meetingRoomManager.getGroupDetailBean() != null) {
                this.fragment.getMViewModel().getMGroupDetailBean().setValue(meetingRoomManager.getGroupDetailBean());
            } else {
                this.fragment.getMViewModel().getRoomInfo();
            }
            this.fragment.getMViewModel().setMGroupId(meetingRoomManager.getMGroupId());
            if (meetingRoomManager.getMLudoGameData() != null && (mAudioHelp7 = this.fragment.getMAudioHelp()) != null) {
                mAudioHelp7.showLudoGameView();
            }
            if (meetingRoomManager.getMUnoGameData() != null && (mAudioHelp6 = this.fragment.getMAudioHelp()) != null) {
                mAudioHelp6.showUnoGameView();
            }
            if (meetingRoomManager.getMDominoGameData() != null && (mAudioHelp5 = this.fragment.getMAudioHelp()) != null) {
                mAudioHelp5.showDominoGameView();
            }
            if (meetingRoomManager.getMCrushGameData() != null && (mAudioHelp4 = this.fragment.getMAudioHelp()) != null) {
                mAudioHelp4.showCrushGameView();
            }
            if (meetingRoomManager.getMCarromGameData() != null && (mAudioHelp3 = this.fragment.getMAudioHelp()) != null) {
                mAudioHelp3.showCarromGameView();
            }
            if (meetingRoomManager.getMJackaroGameData() != null && (mAudioHelp2 = this.fragment.getMAudioHelp()) != null) {
                mAudioHelp2.showJackaroGameView();
            }
            if (meetingRoomManager.getMBackgammonGameData() != null && (mAudioHelp = this.fragment.getMAudioHelp()) != null) {
                mAudioHelp.showBackgammonGameView();
                return;
            }
            return;
        }
        EnterRoomData enterRoomData = this.fragment.getEnterRoomData();
        if (enterRoomData != null) {
            this.fragment.getMViewModel().initRoomBaseKeyValue(enterRoomData);
            this.fragment.getMViewModel().joinChannel(this.mJoinGroupCallBack, enterRoomData);
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(5, 5000L);
            }
        }
    }

    private final void initFromSamllOrEnterLogic() {
        GameMicroView gameMicroView;
        if (this.mEnterRoomFromSmall) {
            FragmentGameRoomBinding binding = this.fragment.getBinding();
            if (binding != null && (gameMicroView = binding.gameMic) != null) {
                gameMicroView.refreshMic();
            }
            checkChatMic();
            if (MeetingRoomManager.INSTANCE.getMRoomLuckWheelInfo() != null) {
                RoomViewModel.refreshLuckLyDialog$default(this.fragment.getMViewModel(), false, 1, null);
            }
        }
    }

    private final void initObserve() {
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (lightQueueCombinationPlayer = binding.queuePlayer) != null) {
            lightQueueCombinationPlayer.bindingLifeCycle(this.fragment);
        }
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = GameRoomFragmentHelp.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.registerListener(name, new MessageDataListener() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$1
            @Override // com.qiahao.nextvideo.ui.im.MessageDataListener
            public void messageDataListener(ArrayList<MessageListInfo> listMessageDate, int unReadMessage, boolean isFinished) {
                RoomMessageViewBinding messageBinding;
                RoomInputView roomInputView;
                RoomMessageViewBinding messageBinding2;
                RoomInputView roomInputView2;
                Intrinsics.checkNotNullParameter(listMessageDate, "listMessageDate");
                if (unReadMessage > 0) {
                    RoomMessageView mChatLayout = GameRoomFragmentHelp.this.getFragment().getMChatLayout();
                    if (mChatLayout != null && (messageBinding2 = mChatLayout.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
                        roomInputView2.hasNewMessage(true);
                        return;
                    }
                    return;
                }
                RoomMessageView mChatLayout2 = GameRoomFragmentHelp.this.getFragment().getMChatLayout();
                if (mChatLayout2 != null && (messageBinding = mChatLayout2.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
                    roomInputView.hasNewMessage(false);
                }
            }
        });
        BuildersKt.launch$default(this.fragmentScope, Dispatchers.getMain(), (CoroutineStart) null, new GameRoomFragmentHelp$initObserve$2(this, null), 2, (Object) null);
        BuildersKt.launch$default(this.fragmentScope, Dispatchers.getMain(), (CoroutineStart) null, new GameRoomFragmentHelp$initObserve$3(this, null), 2, (Object) null);
        this.fragment.getMViewModel().getMGroupDetailBean().observe(this.fragment, new GameRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.a6
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$30;
                initObserve$lambda$30 = GameRoomFragmentHelp.initObserve$lambda$30(GameRoomFragmentHelp.this, (GroupDetailBean) obj);
                return initObserve$lambda$30;
            }
        }));
        this.fragment.getMViewModel().getMException().observe(this.fragment, new GameRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.b6
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$34;
                initObserve$lambda$34 = GameRoomFragmentHelp.initObserve$lambda$34(GameRoomFragmentHelp.this, (Pair) obj);
                return initObserve$lambda$34;
            }
        }));
    }

    public static final Unit initObserve$lambda$30(GameRoomFragmentHelp gameRoomFragmentHelp, GroupDetailBean groupDetailBean) {
        if (gameRoomFragmentHelp.fragment.checkMicPermission()) {
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.m5
                @Override // java.lang.Runnable
                public final void run() {
                    GameRoomFragmentHelp.initObserve$lambda$30$lambda$27();
                }
            }, 1000L);
        }
        try {
            if (gameRoomFragmentHelp.mCurrentEnter && !gameRoomFragmentHelp.mEnterRoomFromSmall) {
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                if (meetingRoomManager.getLocalRoomMicStatus() && groupDetailBean.getMicOn()) {
                    showToastOrLog$default(gameRoomFragmentHelp, null, "进群获取群信息后--3秒弹出邀请上麦", false, 5, null);
                    Handler handler = gameRoomFragmentHelp.mHandler;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(6, FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
                    }
                    LuckWheelInfo luckyWheel = groupDetailBean.getLuckyWheel();
                    if (luckyWheel != null) {
                        RoomViewModel.updateLuckyWheelInfo$default(gameRoomFragmentHelp.fragment.getMViewModel(), luckyWheel, false, 2, null);
                    }
                    List<RoomRuleBean> roleMembers = groupDetailBean.getRoleMembers();
                    if (roleMembers != null) {
                        meetingRoomManager.setMRoomUserRoleList((ArrayList) roleMembers);
                    }
                }
                gameRoomFragmentHelp.addUserEnterRoomAnimator();
            }
            Intrinsics.checkNotNull(groupDetailBean);
            gameRoomFragmentHelp.initView(groupDetailBean);
            gameRoomFragmentHelp.mCurrentEnter = false;
        } catch (Exception unused) {
            showToastOrLog$default(gameRoomFragmentHelp, null, "fragment.mViewModel.mGroupDetailBean.observe异常", false, 5, null);
        }
        return Unit.INSTANCE;
    }

    public static final void initObserve$lambda$30$lambda$27() {
        cf.c.c().l(new ChatRoomStatusEvent("start_service", (Object) null, 2, (DefaultConstructorMarker) null));
    }

    /* JADX WARN: Type inference failed for: r14v14, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final Unit initObserve$lambda$34(GameRoomFragmentHelp gameRoomFragmentHelp, Pair pair) {
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -838984029:
                if (str.equals(RoomViewModel.INTERFACE_UP_MIC)) {
                    showToastOrLog$default(gameRoomFragmentHelp, ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667), "initObserve: 失败" + ((Throwable) pair.getSecond()).getLocalizedMessage(), false, 4, null);
                    break;
                }
                break;
            case -818431518:
                if (str.equals(RoomViewModel.INTERFACE_ENTER_ROOM)) {
                    showToastOrLog$default(gameRoomFragmentHelp, null, "MeetingRoofragment.mViewModel.INTERFACE_ENTER_ROOM 调用MeetingRoomManager的LeaveRoom()", false, 5, null);
                    GameRoomFragment.leaveRoom$default(gameRoomFragmentHelp.fragment, false, 1, null);
                    FragmentActivity activity = gameRoomFragmentHelp.fragment.getActivity();
                    if (activity != null) {
                        activity.finish();
                        break;
                    }
                }
                break;
            case -494139696:
                if (str.equals(RoomViewModel.INTERFACE_JOIN_ROOM) && (pair.getSecond() instanceof HiloException)) {
                    Object second = pair.getSecond();
                    Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                    HiloException hiloException = (HiloException) second;
                    int code = hiloException.getCode();
                    if (code != 14003) {
                        if (code != 14005) {
                            if (code != 14012) {
                                if (code != 14015) {
                                    HiloToasty.Companion companion = HiloToasty.Companion;
                                    Context context = gameRoomFragmentHelp.fragment.getContext();
                                    String message = hiloException.getMessage();
                                    if (message == null) {
                                        message = ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667);
                                    }
                                    Toast normal = companion.normal(context, message, false);
                                    if (normal != null) {
                                        normal.show();
                                        break;
                                    }
                                } else {
                                    Context context2 = gameRoomFragmentHelp.fragment.getContext();
                                    if (context2 != null) {
                                        new VipViewDialog(4, context2).show();
                                        break;
                                    }
                                }
                            } else {
                                Context context3 = gameRoomFragmentHelp.fragment.getContext();
                                if (context3 != null) {
                                    ?? commonTextDialog = new CommonTextDialog(context3, 0.0f, 2, null);
                                    String string = commonTextDialog.getMContext().getString(2131953025);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                    commonTextDialog.setContentText(string, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$initObserve$5$1$1$1
                                        public void cancel() {
                                        }

                                        public void confirm() {
                                        }
                                    });
                                    commonTextDialog.show();
                                    break;
                                }
                            }
                        } else {
                            Toast normal2 = HiloToasty.Companion.normal(gameRoomFragmentHelp.fragment.getContext(), ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952092), false);
                            if (normal2 != null) {
                                normal2.show();
                                break;
                            }
                        }
                    } else {
                        HiloToasty.Companion companion2 = HiloToasty.Companion;
                        Context context4 = gameRoomFragmentHelp.fragment.getContext();
                        String message2 = hiloException.getMessage();
                        if (message2 == null) {
                            message2 = ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131953606);
                        }
                        Toast normal3 = companion2.normal(context4, message2, false);
                        if (normal3 != null) {
                            normal3.show();
                            break;
                        }
                    }
                }
                break;
            case 26331015:
                if (str.equals(RoomViewModel.INTERFACE_SEND_GIFT) && (pair.getSecond() instanceof HiloException)) {
                    Object second2 = pair.getSecond();
                    Intrinsics.checkNotNull(second2, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                    String errorMessage = ((HiloException) second2).getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667);
                    }
                    showToastOrLog$default(gameRoomFragmentHelp, errorMessage, "initObserve: 送礼失败", false, 4, null);
                    break;
                }
                break;
            case 868709153:
                if (str.equals(RoomViewModel.INTERFACE_MUTE_MIC)) {
                    showToastOrLog$default(gameRoomFragmentHelp, ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667), "initObserve: 静音失败", false, 4, null);
                    break;
                }
                break;
            case 1027666439:
                if (str.equals(RoomViewModel.INTERFACE_UN_MUTE_MIC)) {
                    showToastOrLog$default(gameRoomFragmentHelp, ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667), "initObserve: 开音失败", false, 4, null);
                    break;
                }
                break;
            case 1184836679:
                if (str.equals(RoomAndPersonalTaskViewModel.COMMON_TIP)) {
                    showToastOrLog$default(gameRoomFragmentHelp, ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667), null, false, 6, null);
                    break;
                }
                break;
            case 1195528563:
                if (str.equals(RoomViewModel.INTERFACE_DELETE_MESSAGE)) {
                    showToastOrLog$default(gameRoomFragmentHelp, ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667), "initObserve: 删除消息失败", false, 4, null);
                    break;
                }
                break;
            case 1427429674:
                if (str.equals(RoomViewModel.INTERFACE_DOWN_MIC) && (pair.getSecond() instanceof HiloException)) {
                    Object second3 = pair.getSecond();
                    Intrinsics.checkNotNull(second3, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                    String errorMessage2 = ((HiloException) second3).getErrorMessage();
                    if (errorMessage2 == null) {
                        errorMessage2 = ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667);
                    }
                    showToastOrLog$default(gameRoomFragmentHelp, errorMessage2, "initObserve: 下麦失败", false, 4, null);
                    break;
                }
                break;
            case 1909656883:
                if (str.equals(RoomViewModel.INTERFACE_LOCK_MIC)) {
                    showToastOrLog$default(gameRoomFragmentHelp, ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667), "initObserve: 锁麦失败", false, 4, null);
                    break;
                }
                break;
            case 2068614169:
                if (str.equals(RoomViewModel.INTERFACE_UN_LOCK_MIC)) {
                    showToastOrLog$default(gameRoomFragmentHelp, ResourcesKtxKt.getStringById(gameRoomFragmentHelp, 2131952667), "initObserve: 解麦失败", false, 4, null);
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
    
        if (r1 == true) goto L١١٣;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView(GroupDetailBean groupDetailBean) {
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        int i;
        ImageView imageView;
        FragmentGameRoomBinding binding;
        ImageView imageView2;
        ImageView imageView3;
        boolean z;
        RoomMessageViewBinding messageBinding2;
        RoomInputView roomInputView2;
        RoomMessageViewBinding messageBinding3;
        RoomInputView roomInputView3;
        boolean z2 = true;
        if (groupDetailBean.getMicOn()) {
            if (MeetingRoomManager.INSTANCE.getLocalRoomMicStatus()) {
                RoomMessageView mChatLayout = this.fragment.getMChatLayout();
                if (mChatLayout != null && (messageBinding3 = mChatLayout.messageBinding()) != null && (roomInputView3 = messageBinding3.chatInputLayout) != null) {
                    roomInputView3.changeRoomSoundStatus(true);
                }
            } else {
                RoomMessageView mChatLayout2 = this.fragment.getMChatLayout();
                if (mChatLayout2 != null && (messageBinding2 = mChatLayout2.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
                    roomInputView2.changeRoomSoundStatus(false);
                }
            }
        } else {
            RoomMessageView mChatLayout3 = this.fragment.getMChatLayout();
            if (mChatLayout3 != null && (messageBinding = mChatLayout3.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
                roomInputView.changeRoomSoundStatus(false);
            }
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null && !mGameHelp.isPlayGame()) {
            Integer themeId = groupDetailBean.getThemeId();
            if (themeId != null) {
                i = themeId.intValue();
            } else {
                i = 0;
            }
            if (i > 0) {
                String themeUrl = groupDetailBean.getThemeUrl();
                if (themeUrl != null) {
                    if (themeUrl.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                z2 = false;
                if (z2) {
                    FragmentGameRoomBinding binding2 = this.fragment.getBinding();
                    if (binding2 != null && (imageView3 = binding2.meetingRoomThemBackGroup) != null) {
                        ViewUtilitiesKt.bind(imageView3, ImageUIModel.INSTANCE.roomBackGroupFull(groupDetailBean.getThemeUrl(), R.drawable.bg_meeting_room1));
                    }
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                    alphaAnimation.setDuration(3L);
                    binding = this.fragment.getBinding();
                    if (binding == null && (imageView2 = binding.meetingRoomThemBackGroup) != null) {
                        imageView2.startAnimation(alphaAnimation);
                        return;
                    }
                }
            }
            FragmentGameRoomBinding binding3 = this.fragment.getBinding();
            if (binding3 != null && (imageView = binding3.meetingRoomThemBackGroup) != null) {
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.bg_meeting_room1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.1f, 1.0f);
            alphaAnimation2.setDuration(3L);
            binding = this.fragment.getBinding();
            if (binding == null) {
            }
        }
    }

    public static final ViewDataBinding manager$lambda$2(GameRoomFragmentHelp gameRoomFragmentHelp, GiftNoticeUIModel giftNoticeUIModel) {
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "data");
        ViewGiftNoticeBinding inflate = ViewGiftNoticeBinding.inflate(LayoutInflater.from(gameRoomFragmentHelp.fragment.getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public static final Unit manager$lambda$3(GameRoomFragmentHelp gameRoomFragmentHelp, ViewDataBinding viewDataBinding, GiftNoticeUIModel giftNoticeUIModel) {
        Intrinsics.checkNotNullParameter(viewDataBinding, "giftBinding");
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "newData");
        if (viewDataBinding instanceof ViewGiftNoticeBinding) {
            AudioRoomExtraDataKt.refreshGiftView(gameRoomFragmentHelp, (ViewGiftNoticeBinding) viewDataBinding, giftNoticeUIModel);
        }
        return Unit.INSTANCE;
    }

    public static final String manager$lambda$4(GiftNoticeUIModel giftNoticeUIModel) {
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "it");
        return giftNoticeUIModel.getDataId();
    }

    public static final GiftNoticeUIModel manager$lambda$5(GiftNoticeUIModel giftNoticeUIModel, GiftNoticeUIModel giftNoticeUIModel2) {
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "newData");
        Intrinsics.checkNotNullParameter(giftNoticeUIModel2, "oldData");
        giftNoticeUIModel.setCount(giftNoticeUIModel.getCount() + giftNoticeUIModel2.getCount());
        giftNoticeUIModel.setSame(true);
        return giftNoticeUIModel;
    }

    public final void playGift(GiftDateItem data) {
        FragmentGameRoomBinding binding;
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        LightQueueCombinationPlayer lightQueueCombinationPlayer2;
        try {
            if (!MeetingRoomManager.INSTANCE.checkGameMadel() && !getFullGiftHelper().isPlayAnimation()) {
                if (StringKtxKt.checkEndSVGA(data.getEffectSvga())) {
                    FragmentGameRoomBinding binding2 = this.fragment.getBinding();
                    if (binding2 != null && (lightQueueCombinationPlayer2 = binding2.queuePlayer) != null) {
                        lightQueueCombinationPlayer2.addQueue(GiftHelp.INSTANCE.getSVGAData(data));
                        return;
                    }
                    return;
                }
                if (StringKtxKt.checkEndMP4(data.getEffectSvga())) {
                    Context context = this.fragment.getContext();
                    if (context != null) {
                        GiftHelp.INSTANCE.getVAP2(data, LifecycleOwnerKt.getLifecycleScope(this.fragment), new Function1() { // from class: com.qiahao.nextvideo.room.help.s5
                            public final Object invoke(Object obj) {
                                Unit playGift$lambda$48$lambda$47;
                                playGift$lambda$48$lambda$47 = GameRoomFragmentHelp.playGift$lambda$48$lambda$47(GameRoomFragmentHelp.this, (VapMediaSource) obj);
                                return playGift$lambda$48$lambda$47;
                            }
                        }, context);
                        return;
                    }
                    return;
                }
                if (StringKtxKt.checkDefaultMP4(data.getEffectSvga()) && this.fragment.getContext() != null && (binding = this.fragment.getBinding()) != null && (lightQueueCombinationPlayer = binding.queuePlayer) != null) {
                    lightQueueCombinationPlayer.addQueue(new VideoMediaSource(StringKtxKt.urlMP4(data.getEffectSvga())));
                    return;
                }
                return;
            }
            showToastOrLog$default(this, null, "打开了游戏模式，不播放svga 礼物", false, 5, null);
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
        }
    }

    public static final Unit playGift$lambda$48$lambda$47(GameRoomFragmentHelp gameRoomFragmentHelp, VapMediaSource vapMediaSource) {
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        FragmentGameRoomBinding binding = gameRoomFragmentHelp.fragment.getBinding();
        if (binding != null && (lightQueueCombinationPlayer = binding.queuePlayer) != null) {
            lightQueueCombinationPlayer.addQueue(vapMediaSource);
        }
        return Unit.INSTANCE;
    }

    public final void sendImage(LocalMedia media) {
        String compressPath;
        if (media.isCut() && !media.isCompressed()) {
            compressPath = media.getCutPath();
        } else if (!media.isCompressed() && (!media.isCut() || !media.isCompressed())) {
            if (!TextUtils.isEmpty(media.getRealPath())) {
                compressPath = media.getRealPath();
            } else {
                compressPath = media.getPath();
            }
        } else {
            compressPath = media.getCompressPath();
        }
        File fileCompat = StorageUtils.INSTANCE.getFileCompat(compressPath);
        if (fileCompat != null && fileCompat.exists()) {
            VideoUploadManager.INSTANCE.uploadImage(media, fileCompat, new VideoUploadManager.UploadCallback() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$sendImage$2
                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object addMessageLocal(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                    return BuildersKt.withContext(Dispatchers.getMain(), new GameRoomFragmentHelp$sendImage$2$addMessageLocal$2(GameRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadFailed(Exception exc, Continuation<? super Unit> continuation) {
                    return VideoUploadManager.UploadCallback.DefaultImpls.onUploadFailed(this, exc, continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public void onUploadProgress(String str, int i) {
                    VideoUploadManager.UploadCallback.DefaultImpls.onUploadProgress(this, str, i);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadSuccess(String str, String str2, Continuation<? super Unit> continuation) {
                    return VideoUploadManager.UploadCallback.DefaultImpls.onUploadSuccess(this, str, str2, continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object refreshLocalMessage(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                    return VideoUploadManager.UploadCallback.DefaultImpls.refreshLocalMessage(this, roomMessageMulti, continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadFailed(RoomMessageMulti roomMessageMulti, Exception exc, Continuation<? super Unit> continuation) {
                    return BuildersKt.withContext(Dispatchers.getMain(), new GameRoomFragmentHelp$sendImage$2$onUploadFailed$2(GameRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadSuccess(RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super Unit> continuation) {
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new GameRoomFragmentHelp$sendImage$2$onUploadSuccess$2(GameRoomFragmentHelp.this, groupMessageSend, z, null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                }
            });
        }
    }

    public final void sendVideo(LocalMedia media) {
        String compressPath;
        if (media.isCut() && !media.isCompressed()) {
            compressPath = media.getCutPath();
        } else if (!media.isCompressed() && (!media.isCut() || !media.isCompressed())) {
            if (!TextUtils.isEmpty(media.getRealPath())) {
                compressPath = media.getRealPath();
            } else {
                compressPath = media.getPath();
            }
        } else {
            compressPath = media.getCompressPath();
        }
        File fileCompat = StorageUtils.INSTANCE.getFileCompat(compressPath);
        if (fileCompat != null && fileCompat.exists()) {
            VideoUploadManager videoUploadManager = VideoUploadManager.INSTANCE;
            Context requireContext = this.fragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            videoUploadManager.uploadVideo(media, fileCompat, requireContext, new VideoUploadManager.UploadCallback() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$sendVideo$2
                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object addMessageLocal(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                    return BuildersKt.withContext(Dispatchers.getMain(), new GameRoomFragmentHelp$sendVideo$2$addMessageLocal$2(GameRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadFailed(Exception exc, Continuation<? super Unit> continuation) {
                    return VideoUploadManager.UploadCallback.DefaultImpls.onUploadFailed(this, exc, continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public void onUploadProgress(String str, int i) {
                    VideoUploadManager.UploadCallback.DefaultImpls.onUploadProgress(this, str, i);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadSuccess(String str, String str2, Continuation<? super Unit> continuation) {
                    return VideoUploadManager.UploadCallback.DefaultImpls.onUploadSuccess(this, str, str2, continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object refreshLocalMessage(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                    return VideoUploadManager.UploadCallback.DefaultImpls.refreshLocalMessage(this, roomMessageMulti, continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadFailed(RoomMessageMulti roomMessageMulti, Exception exc, Continuation<? super Unit> continuation) {
                    return BuildersKt.withContext(Dispatchers.getMain(), new GameRoomFragmentHelp$sendVideo$2$onUploadFailed$2(GameRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadSuccess(RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super Unit> continuation) {
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new GameRoomFragmentHelp$sendVideo$2$onUploadSuccess$2(GameRoomFragmentHelp.this, groupMessageSend, z, null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                }
            });
        }
    }

    public static final Unit showBackgammonGameView$lambda$42(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(23);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showBalootGameView$lambda$39(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(14);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showCarromGameView$lambda$40(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(18);
        }
        return Unit.INSTANCE;
    }

    private final void showContactWrapper() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            new ContactRoomDialog(activity).show();
        }
    }

    public static final Unit showCrushGameView$lambda$38(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(11);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showDominoGameView$lambda$37(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(10);
        }
        return Unit.INSTANCE;
    }

    private final void showFloatChat() {
        FrameLayout frameLayout;
        Drawable drawable;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        FrameLayout frameLayout5;
        FragmentGameRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout5 = binding.chatBack) != null) {
            frameLayout5.removeAllViews();
        }
        FragmentGameRoomBinding binding2 = this.fragment.getBinding();
        if (binding2 != null && (frameLayout4 = binding2.gameChatLayout) != null) {
            frameLayout4.removeAllViews();
        }
        FragmentGameRoomBinding binding3 = this.fragment.getBinding();
        if (binding3 != null && (frameLayout = binding3.gameChatLayout) != null && frameLayout.getChildCount() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            RoomMessageView mChatLayout = this.fragment.getMChatLayout();
            if (mChatLayout != null) {
                mChatLayout.setPaddingRelative(0, UiKtxKt.toPX(15), 0, 0);
            }
            FragmentGameRoomBinding binding4 = this.fragment.getBinding();
            if (binding4 != null && (frameLayout3 = binding4.gameChatLayout) != null) {
                frameLayout3.addView((View) this.fragment.getMChatLayout(), (ViewGroup.LayoutParams) layoutParams);
            }
            final ImageView imageView = new ImageView(this.fragment.getContext());
            Context context = this.fragment.getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.room_hide_chat);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            int px = UiKtxKt.toPX(6);
            imageView.setPadding(px, px, px, px);
            ViewKtxKt.setMargin(imageView, 0, Integer.valueOf(UiKtxKt.toPX(6)), Integer.valueOf(UiKtxKt.toPX(15)), 0);
            final long j = 800;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$showFloatChat$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        MatchGameHelp mGameHelp = this.getFragment().getMGameHelp();
                        if (mGameHelp != null) {
                            mGameHelp.hideGameChat();
                        }
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UiKtxKt.toPX(40), UiKtxKt.toPX(40));
            layoutParams2.gravity = 8388661;
            FragmentGameRoomBinding binding5 = this.fragment.getBinding();
            if (binding5 != null && (frameLayout2 = binding5.gameChatLayout) != null) {
                frameLayout2.addView(imageView, layoutParams2);
            }
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameChat();
        }
    }

    public static final Unit showJackaroGameView$lambda$41(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(21);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showLudoGameView$lambda$35(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(1);
        }
        return Unit.INSTANCE;
    }

    private final void showMicFaceDialog() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            new MicFaceDialog(activity, this.fragment.getMViewModel().getMGroupId(), new GameRoomFragmentHelp$showMicFaceDialog$1$1(this)).show();
        }
    }

    public static /* synthetic */ void showToastOrLog$default(GameRoomFragmentHelp gameRoomFragmentHelp, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        gameRoomFragmentHelp.showToastOrLog(str, str2, z);
    }

    public static final Unit showUnoGameView$lambda$36(GameRoomFragmentHelp gameRoomFragmentHelp) {
        MatchGameHelp mGameHelp = gameRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(2);
        }
        return Unit.INSTANCE;
    }

    public final Object uploadImage(File file, boolean z, Continuation<? super Result> continuation) {
        S3Configs.Type type;
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        S3UploadRequest.Builder uploadPath = new S3UploadRequest.Builder().setUploadPath(AliCloudService.OSS_MESSAGES);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        S3UploadRequest.Builder availablePath = uploadPath.setAvailablePath(absolutePath);
        S3Configs.Builder builder = new S3Configs.Builder();
        if (z) {
            type = S3Configs.Type.IMAGE;
        } else {
            type = S3Configs.Type.VIDEO;
        }
        availablePath.setS3Config(builder.build(type)).setUploadListener(new RequestListener() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$uploadImage$2$1
            public void onComplete(Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                RequestListener.DefaultImpls.onComplete(this, result);
                safeContinuation.resumeWith(kotlin.Result.constructor-impl(result));
            }

            public void onFailed(Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                RequestListener.DefaultImpls.onFailed(this, result);
                safeContinuation.resumeWith(kotlin.Result.constructor-impl(result));
            }

            public void onProgress(Result result) {
                RequestListener.DefaultImpls.onProgress(this, result);
            }
        }).build(this).start(LifecycleOwnerKt.getLifecycleScope(this.fragment));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    static /* synthetic */ Object uploadImage$default(GameRoomFragmentHelp gameRoomFragmentHelp, File file, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return gameRoomFragmentHelp.uploadImage(file, z, continuation);
    }

    public final void clearMessage() {
        RoomMessageView mChatLayout = this.fragment.getMChatLayout();
        if (mChatLayout != null) {
            mChatLayout.clearAllData();
        }
        RoomTip clearMessage = RoomMessageUtil.INSTANCE.clearMessage();
        RoomMessageView mChatLayout2 = this.fragment.getMChatLayout();
        if (mChatLayout2 != null) {
            RoomMessageView.addData$default(mChatLayout2, BuildMessageUtilsKt.createCustomMessage$default(MeetingRoomManager.INSTANCE.getMGroupId(), "108", clearMessage, (User) null, 0, 24, (Object) null), false, 2, (Object) null);
        }
    }

    public final void dispatchGiftShow() {
        String sendUserNick;
        String receiveUserNick;
        String str;
        String str2;
        String senderAvatar;
        GroupGiftDetail giftDetail;
        String str3;
        SvipData svip;
        boolean z;
        String iconUrl;
        String str4;
        String str5;
        String svgaUrl;
        boolean z2;
        String str6;
        String str7;
        String str8;
        String receiverAvatar;
        String senderAvatar2;
        String svgaUrl2;
        String sendUserNick2;
        String receiveUserNick2;
        String str9;
        String str10;
        String senderAvatar3;
        GroupGiftDetail giftDetail2;
        String str11;
        SvipData svip2;
        boolean z3;
        String iconUrl2;
        String str12;
        String str13;
        MessageProcessor mMessageProcessor;
        MessageProcessor mMessageProcessor2;
        ArrayList<MeetingRoomReceiveGiftCustomContent> cuttingGiftList = cuttingGiftList();
        if (!MeetingRoomManager.INSTANCE.checkShowEffect()) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(cuttingGiftList, 10));
            Iterator<T> it = cuttingGiftList.iterator();
            while (it.hasNext()) {
                arrayList.add(DataExternalKt.toMessageMulti((MeetingRoomReceiveGiftCustomContent) it.next()));
            }
            RoomMessageView mChatLayout = this.fragment.getMChatLayout();
            if (mChatLayout != null && (mMessageProcessor2 = mChatLayout.getMMessageProcessor()) != null) {
                mMessageProcessor2.addMessageList(arrayList);
                return;
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(cuttingGiftList, 10));
        Iterator<T> it2 = cuttingGiftList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(DataExternalKt.toMessageMulti((MeetingRoomReceiveGiftCustomContent) it2.next()));
        }
        RoomMessageView mChatLayout2 = this.fragment.getMChatLayout();
        if (mChatLayout2 != null && (mMessageProcessor = mChatLayout2.getMMessageProcessor()) != null) {
            mMessageProcessor.addMessageList(arrayList2);
        }
        for (MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent : cuttingGiftList) {
            if (meetingRoomReceiveGiftCustomContent.getGiftGroupBroadcast()) {
                if (Intrinsics.areEqual(meetingRoomReceiveGiftCustomContent.getSourceGroupId(), this.fragment.getMViewModel().getMGroupId())) {
                    long resGiftId = meetingRoomReceiveGiftCustomContent.getResGiftId();
                    SvipData svip3 = meetingRoomReceiveGiftCustomContent.getSvip();
                    if (svip3 != null && svip3.isMystery()) {
                        String stringById = ResourcesKtxKt.getStringById(this, 2131953504);
                        SvipData svip4 = meetingRoomReceiveGiftCustomContent.getSvip();
                        if (svip4 != null) {
                            str13 = svip4.mysteryNumber();
                        } else {
                            str13 = null;
                        }
                        sendUserNick2 = String.format(stringById, Arrays.copyOf(new Object[]{str13}, 1));
                        Intrinsics.checkNotNullExpressionValue(sendUserNick2, "format(...)");
                    } else {
                        sendUserNick2 = meetingRoomReceiveGiftCustomContent.getSendUserNick();
                    }
                    String str14 = sendUserNick2;
                    SvipData receiveSvip = meetingRoomReceiveGiftCustomContent.getReceiveSvip();
                    if (receiveSvip != null && receiveSvip.isMystery()) {
                        String stringById2 = ResourcesKtxKt.getStringById(this, 2131953504);
                        SvipData receiveSvip2 = meetingRoomReceiveGiftCustomContent.getReceiveSvip();
                        if (receiveSvip2 != null) {
                            str12 = receiveSvip2.mysteryNumber();
                        } else {
                            str12 = null;
                        }
                        String format = String.format(stringById2, Arrays.copyOf(new Object[]{str12}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        receiveUserNick2 = format;
                    } else {
                        receiveUserNick2 = meetingRoomReceiveGiftCustomContent.getReceiveUserNick();
                    }
                    long resGiftNum = meetingRoomReceiveGiftCustomContent.getResGiftNum();
                    GroupGiftDetail giftDetail3 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                    if (giftDetail3 != null) {
                        str9 = giftDetail3.getSenderAvatar();
                    } else {
                        str9 = null;
                    }
                    if (TextUtils.isEmpty(str9)) {
                        senderAvatar3 = meetingRoomReceiveGiftCustomContent.getSendUserAvatar();
                    } else {
                        GroupGiftDetail giftDetail4 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                        if (giftDetail4 != null) {
                            senderAvatar3 = giftDetail4.getSenderAvatar();
                        } else {
                            str10 = null;
                            giftDetail2 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                            if (giftDetail2 != null || (iconUrl2 = giftDetail2.getIconUrl()) == null) {
                                str11 = "";
                            } else {
                                str11 = iconUrl2;
                            }
                            svip2 = meetingRoomReceiveGiftCustomContent.getSvip();
                            if (svip2 == null && svip2.isMystery()) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new GameRoomFragmentHelp$dispatchGiftShow$1$1(this, new GiftNoticeUIModel(resGiftId, str14, receiveUserNick2, resGiftNum, str10, str11, z3, 0, false, 384, null), null), 3, (Object) null);
                        }
                    }
                    str10 = senderAvatar3;
                    giftDetail2 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                    if (giftDetail2 != null) {
                    }
                    str11 = "";
                    svip2 = meetingRoomReceiveGiftCustomContent.getSvip();
                    if (svip2 == null) {
                    }
                    z3 = false;
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new GameRoomFragmentHelp$dispatchGiftShow$1$1(this, new GiftNoticeUIModel(resGiftId, str14, receiveUserNick2, resGiftNum, str10, str11, z3, 0, false, 384, null), null), 3, (Object) null);
                }
            } else {
                long resGiftId2 = meetingRoomReceiveGiftCustomContent.getResGiftId();
                SvipData svip5 = meetingRoomReceiveGiftCustomContent.getSvip();
                if (svip5 != null && svip5.isMystery()) {
                    String stringById3 = ResourcesKtxKt.getStringById(this, 2131953504);
                    SvipData svip6 = meetingRoomReceiveGiftCustomContent.getSvip();
                    if (svip6 != null) {
                        str5 = svip6.mysteryNumber();
                    } else {
                        str5 = null;
                    }
                    sendUserNick = String.format(stringById3, Arrays.copyOf(new Object[]{str5}, 1));
                    Intrinsics.checkNotNullExpressionValue(sendUserNick, "format(...)");
                } else {
                    sendUserNick = meetingRoomReceiveGiftCustomContent.getSendUserNick();
                }
                String str15 = sendUserNick;
                SvipData receiveSvip3 = meetingRoomReceiveGiftCustomContent.getReceiveSvip();
                if (receiveSvip3 != null && receiveSvip3.isMystery()) {
                    String stringById4 = ResourcesKtxKt.getStringById(this, 2131953504);
                    SvipData receiveSvip4 = meetingRoomReceiveGiftCustomContent.getReceiveSvip();
                    if (receiveSvip4 != null) {
                        str4 = receiveSvip4.mysteryNumber();
                    } else {
                        str4 = null;
                    }
                    String format2 = String.format(stringById4, Arrays.copyOf(new Object[]{str4}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    receiveUserNick = format2;
                } else {
                    receiveUserNick = meetingRoomReceiveGiftCustomContent.getReceiveUserNick();
                }
                long resGiftNum2 = meetingRoomReceiveGiftCustomContent.getResGiftNum();
                GroupGiftDetail giftDetail5 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                if (giftDetail5 != null) {
                    str = giftDetail5.getSenderAvatar();
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    senderAvatar = meetingRoomReceiveGiftCustomContent.getSendUserAvatar();
                } else {
                    GroupGiftDetail giftDetail6 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                    if (giftDetail6 != null) {
                        senderAvatar = giftDetail6.getSenderAvatar();
                    } else {
                        str2 = null;
                        giftDetail = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                        if (giftDetail != null || (iconUrl = giftDetail.getIconUrl()) == null) {
                            str3 = "";
                        } else {
                            str3 = iconUrl;
                        }
                        svip = meetingRoomReceiveGiftCustomContent.getSvip();
                        if (svip == null && svip.isMystery()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new GameRoomFragmentHelp$dispatchGiftShow$1$2(this, new GiftNoticeUIModel(resGiftId2, str15, receiveUserNick, resGiftNum2, str2, str3, z, 0, false, 384, null), null), 3, (Object) null);
                    }
                }
                str2 = senderAvatar;
                giftDetail = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                if (giftDetail != null) {
                }
                str3 = "";
                svip = meetingRoomReceiveGiftCustomContent.getSvip();
                if (svip == null) {
                }
                z = false;
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new GameRoomFragmentHelp$dispatchGiftShow$1$2(this, new GiftNoticeUIModel(resGiftId2, str15, receiveUserNick, resGiftNum2, str2, str3, z, 0, false, 384, null), null), 3, (Object) null);
            }
            showToastOrLog$default(this, null, "礼物播放svga: dispatchGiftShow----", false, 5, null);
            GroupGiftDetail giftDetail7 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
            if (giftDetail7 != null && (svgaUrl = giftDetail7.getSvgaUrl()) != null) {
                if (svgaUrl.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    showToastOrLog$default(this, null, "礼物播放svga: dispatchGiftShow-添加到giftSvgaList---", false, 5, null);
                    if (MeetingRoomManager.INSTANCE.isShowGiftEffect()) {
                        GroupGiftDetail giftDetail8 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                        if (giftDetail8 == null || (svgaUrl2 = giftDetail8.getSvgaUrl()) == null) {
                            str6 = "";
                        } else {
                            str6 = svgaUrl2;
                        }
                        String sendUserAvatar = meetingRoomReceiveGiftCustomContent.getSendUserAvatar();
                        String receiveUserAvatar = meetingRoomReceiveGiftCustomContent.getReceiveUserAvatar();
                        GroupGiftDetail giftDetail9 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                        if (giftDetail9 == null || (senderAvatar2 = giftDetail9.getSenderAvatar()) == null) {
                            str7 = "";
                        } else {
                            str7 = senderAvatar2;
                        }
                        GroupGiftDetail giftDetail10 = meetingRoomReceiveGiftCustomContent.getGiftDetail();
                        if (giftDetail10 == null || (receiverAvatar = giftDetail10.getReceiverAvatar()) == null) {
                            str8 = "";
                        } else {
                            str8 = receiverAvatar;
                        }
                        playGift(new GiftDateItem(str6, sendUserAvatar, receiveUserAvatar, null, null, GiftDateItem.TYPE_GIFT, meetingRoomReceiveGiftCustomContent.getSvip(), meetingRoomReceiveGiftCustomContent.getReceiveSvip(), str7, str8, meetingRoomReceiveGiftCustomContent.getGiftType(), meetingRoomReceiveGiftCustomContent.getTextStyleList(), meetingRoomReceiveGiftCustomContent.getReceiveUserNick(), meetingRoomReceiveGiftCustomContent.getSendUserNick(), meetingRoomReceiveGiftCustomContent.getGiftText(), 24, null));
                    }
                }
            }
        }
    }

    @NotNull
    public final GameRoomFragment getFragment() {
        return this.fragment;
    }

    @NotNull
    public final CoroutineScope getFragmentScope() {
        return this.fragmentScope;
    }

    @NotNull
    public final FullGiftHelper getFullGiftHelper() {
        return (FullGiftHelper) this.fullGiftHelper.getValue();
    }

    @NotNull
    public final ArrayList<UserProxy1.GlobalGameBanner> getGameBannerList() {
        return this.gameBannerList;
    }

    @NotNull
    public final AnimationQueueManager<UserProxy1.GlobalGameBanner> getGameManager() {
        return this.gameManager;
    }

    @NotNull
    public final GameMicAdapter getGameMicAdapter() {
        return (GameMicAdapter) this.gameMicAdapter.getValue();
    }

    public final boolean getMCurrentEnter() {
        return this.mCurrentEnter;
    }

    public final boolean getMEnterRoomFromSmall() {
        return this.mEnterRoomFromSmall;
    }

    @NotNull
    public final ArrayList<MeetingRoomReceiveGiftCustomContent> getMGiftSourceBeanList() {
        return this.mGiftSourceBeanList;
    }

    @Nullable
    public final Handler getMHandler() {
        return this.mHandler;
    }

    public final boolean getMIMIsInit() {
        return this.mIMIsInit;
    }

    public final boolean getMIsGiftTraverseing() {
        return this.mIsGiftTraverseing;
    }

    @NotNull
    public final AnimationQueueManager<GiftNoticeUIModel> getManager() {
        return this.manager;
    }

    public final void goToPurchase() {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkFirstRecharge(), new Function1() { // from class: com.qiahao.nextvideo.room.help.o5
            public final Object invoke(Object obj) {
                Unit goToPurchase$lambda$67;
                goToPurchase$lambda$67 = GameRoomFragmentHelp.goToPurchase$lambda$67(GameRoomFragmentHelp.this, (ApiResponse) obj);
                return goToPurchase$lambda$67;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.q5
            public final Object invoke(Object obj) {
                Unit goToPurchase$lambda$68;
                goToPurchase$lambda$68 = GameRoomFragmentHelp.goToPurchase$lambda$68(GameRoomFragmentHelp.this, (Throwable) obj);
                return goToPurchase$lambda$68;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void initHelp() {
        boolean z;
        EnterRoomData enterRoomData = this.fragment.getEnterRoomData();
        if (enterRoomData != null) {
            z = enterRoomData.isForSmallRoom();
        } else {
            z = false;
        }
        this.mEnterRoomFromSmall = z;
        initObserve();
        initChatUI();
        initData();
        initClickListener();
        initFromSamllOrEnterLogic();
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public final void release() {
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = GameRoomFragmentHelp.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.removeListener(name);
        this.mGiftSourceBeanList.clear();
        getFullGiftHelper().destroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        AwsS3Repository.Companion.getInstance().clear(this);
        this.mHandler = null;
    }

    public final void setGameBannerList(@NotNull ArrayList<UserProxy1.GlobalGameBanner> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.gameBannerList = arrayList;
    }

    public final void setMCurrentEnter(boolean z) {
        this.mCurrentEnter = z;
    }

    public final void setMEnterRoomFromSmall(boolean z) {
        this.mEnterRoomFromSmall = z;
    }

    public final void setMHandler(@Nullable Handler handler) {
        this.mHandler = handler;
    }

    public final void setMIMIsInit(boolean z) {
        this.mIMIsInit = z;
    }

    public final void setMIsGiftTraverseing(boolean z) {
        this.mIsGiftTraverseing = z;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void showBackgammonGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.x5
                public final Object invoke() {
                    Unit showBackgammonGameView$lambda$42;
                    showBackgammonGameView$lambda$42 = GameRoomFragmentHelp.showBackgammonGameView$lambda$42(GameRoomFragmentHelp.this);
                    return showBackgammonGameView$lambda$42;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(23);
        }
    }

    public final void showBalootGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.u5
                public final Object invoke() {
                    Unit showBalootGameView$lambda$39;
                    showBalootGameView$lambda$39 = GameRoomFragmentHelp.showBalootGameView$lambda$39(GameRoomFragmentHelp.this);
                    return showBalootGameView$lambda$39;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(14);
        }
    }

    public final void showCarromGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.z5
                public final Object invoke() {
                    Unit showCarromGameView$lambda$40;
                    showCarromGameView$lambda$40 = GameRoomFragmentHelp.showCarromGameView$lambda$40(GameRoomFragmentHelp.this);
                    return showCarromGameView$lambda$40;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(18);
        }
    }

    public final void showCrushGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.d6
                public final Object invoke() {
                    Unit showCrushGameView$lambda$38;
                    showCrushGameView$lambda$38 = GameRoomFragmentHelp.showCrushGameView$lambda$38(GameRoomFragmentHelp.this);
                    return showCrushGameView$lambda$38;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(11);
        }
    }

    public final void showDominoGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.e5
                public final Object invoke() {
                    Unit showDominoGameView$lambda$37;
                    showDominoGameView$lambda$37 = GameRoomFragmentHelp.showDominoGameView$lambda$37(GameRoomFragmentHelp.this);
                    return showDominoGameView$lambda$37;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(10);
        }
    }

    public final void showJackaroGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.v5
                public final Object invoke() {
                    Unit showJackaroGameView$lambda$41;
                    showJackaroGameView$lambda$41 = GameRoomFragmentHelp.showJackaroGameView$lambda$41(GameRoomFragmentHelp.this);
                    return showJackaroGameView$lambda$41;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(21);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public final void showLeaveRoomDialog() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            ?? commonTextDialog = new CommonTextDialog(activity, 0.0f, 2, null);
            commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131952642), true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$showLeaveRoomDialog$1$1$1
                public void cancel() {
                }

                public void confirm() {
                    GameRoomFragment.leaveRoom$default(GameRoomFragmentHelp.this.getFragment(), false, 1, null);
                    FragmentActivity activity2 = GameRoomFragmentHelp.this.getFragment().getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }
            });
            commonTextDialog.show();
        }
    }

    public final void showLudoGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.w5
                public final Object invoke() {
                    Unit showLudoGameView$lambda$35;
                    showLudoGameView$lambda$35 = GameRoomFragmentHelp.showLudoGameView$lambda$35(GameRoomFragmentHelp.this);
                    return showLudoGameView$lambda$35;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(1);
        }
    }

    public final void showSendGiftPanel(@NotNull String extraId, @NotNull String userName, boolean isAllMic) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            new RoomGiftDialogFragment(extraId, userName, this.fragment.getMViewModel().getMGroupId(), isAllMic).setListener(new SendGiftListener() { // from class: com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$showSendGiftPanel$1$1
                public void begGift(GiftData giftData, int i) {
                    SendGiftListener.DefaultImpls.begGift(this, giftData, i);
                }

                public void giftsChoose(GiftData giftData, int i, ArrayList<String> arrayList, boolean z) {
                    SendGiftListener.DefaultImpls.giftsChoose(this, giftData, i, arrayList, z);
                }

                public void roomGiftsChoose(GiftData selectedGiftItem, int number, ArrayList<String> extraIdList, int sendType) {
                    Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
                    Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
                    GameRoomFragmentHelp.this.getFragment().getMViewModel().sendGift(sendType, selectedGiftItem, number, extraIdList);
                }

                public void showRechargeView() {
                    GameRoomFragmentHelp.this.goToPurchase();
                }
            }).show(supportFragmentManager, "RoomGiftDialog");
        }
    }

    public final void showToastOrLog(@NotNull String toastText, @NotNull String logText, boolean writeIn) {
        Context context;
        Toast normal$default;
        Intrinsics.checkNotNullParameter(toastText, "toastText");
        Intrinsics.checkNotNullParameter(logText, "logText");
        if (!TextUtils.isEmpty(toastText) && (context = this.fragment.getContext()) != null && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, toastText, false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        if (!TextUtils.isEmpty(logText)) {
            if (writeIn) {
                n5.e.c("AudioRoomFragment : " + logText);
                return;
            }
            Log.i("AudioRoomFragment", logText);
        }
    }

    public final void showUnoGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.p5
                public final Object invoke() {
                    Unit showUnoGameView$lambda$36;
                    showUnoGameView$lambda$36 = GameRoomFragmentHelp.showUnoGameView$lambda$36(GameRoomFragmentHelp.this);
                    return showUnoGameView$lambda$36;
                }
            }, null, 2, null);
            return;
        }
        MatchGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            mGameHelp.showGameView(2);
        }
    }
}
