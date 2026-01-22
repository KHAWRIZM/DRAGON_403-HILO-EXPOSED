package com.qiahao.nextvideo.room.help;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
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
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.MaxDialogUtils;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.RoomTip;
import com.qiahao.hilo_message.databinding.RoomMessageViewBinding;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.hilo_message.utils.MessageProcessor;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.model.AutoInviteUserUpMicBean;
import com.qiahao.nextvideo.data.model.AwardDetailBean;
import com.qiahao.nextvideo.data.model.EnterEffectData;
import com.qiahao.nextvideo.data.model.EnterRoomData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.GroupMedalBean;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.data.model.LuckWheelInfo;
import com.qiahao.nextvideo.data.model.MeetingRoomReceiveGiftCustomContent;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MyAward;
import com.qiahao.nextvideo.data.model.RocketRoomSmallBean;
import com.qiahao.nextvideo.data.room.PKInviteCancel;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.AudioHiloGameBinding;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.databinding.ViewGameNoticeBinding;
import com.qiahao.nextvideo.databinding.ViewGiftNoticeBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity;
import com.qiahao.nextvideo.room.dialog.FirstRechargeDialog;
import com.qiahao.nextvideo.room.dialog.InviteTakeMicGetDiamondDialog;
import com.qiahao.nextvideo.room.dialog.JoinLockRoomBottomDialog;
import com.qiahao.nextvideo.room.dialog.LuckyWheelDialog;
import com.qiahao.nextvideo.room.dialog.LuckyWheelSelectDialog;
import com.qiahao.nextvideo.room.dialog.LuckyWheelSelectListener;
import com.qiahao.nextvideo.room.dialog.MicFaceDialog;
import com.qiahao.nextvideo.room.dialog.RoomGiftDialogFragment;
import com.qiahao.nextvideo.room.dialog.RoomInfoFragment;
import com.qiahao.nextvideo.room.dialog.RoomPKInviteDialog;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.game.GameMicAdapter;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.rocket.RoomRocketEnterView;
import com.qiahao.nextvideo.room.rocket.RoomRocketRewardDialog;
import com.qiahao.nextvideo.room.view.GroupBannerView;
import com.qiahao.nextvideo.room.view.GroupBannerViewLister;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayoutListener;
import com.qiahao.nextvideo.room.view.RocketSvgaCountdownView;
import com.qiahao.nextvideo.room.view.RocketSvgaCountdownViewListener;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.home.chat.dialog.ContactRoomDialog;
import com.qiahao.nextvideo.ui.im.MessageDataListener;
import com.qiahao.nextvideo.ui.im.MessageListInfo;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskViewModel;
import com.qiahao.nextvideo.ui.task.TasksActivity;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.ui.webview.H5DiamondGameDialog;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.qiahao.nextvideo.utilities.StorageUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.animation.AnimationQueueManager;
import com.qiahao.nextvideo.utilities.animation.GiftNoticeUIModel;
import com.qiahao.nextvideo.utilities.im.RoomMessageUtil;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qiahao.nextvideo.view.PKSearchView;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView;
import java.io.File;
import java.net.URL;
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

@Metadata(d1 = {"\u0000Í\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001C\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020FH\u0002J\b\u0010H\u001a\u00020FH\u0002J\b\u0010I\u001a\u00020FH\u0002J\b\u0010J\u001a\u00020FH\u0002J\b\u0010K\u001a\u00020FH\u0002J\b\u0010L\u001a\u00020FH\u0002J\b\u0010M\u001a\u00020FH\u0002J\b\u0010P\u001a\u00020FH\u0002J\b\u0010Q\u001a\u00020FH\u0002J\u0006\u0010R\u001a\u00020FJ\u0006\u0010S\u001a\u00020FJ\u0006\u0010T\u001a\u00020FJ\u0006\u0010U\u001a\u00020FJ\u0006\u0010V\u001a\u00020FJ\u0006\u0010W\u001a\u00020FJ\u0006\u0010X\u001a\u00020FJ$\u0010Y\u001a\u00020F2\b\b\u0002\u0010Z\u001a\u00020[2\b\b\u0002\u0010\\\u001a\u00020[2\b\b\u0002\u0010]\u001a\u00020\u000fJ\u0010\u0010^\u001a\u00020F2\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010a\u001a\u00020F2\u0006\u0010_\u001a\u00020`H\u0002J\u0006\u0010b\u001a\u00020FJ\u0006\u0010c\u001a\u00020FJ\u0006\u0010d\u001a\u00020FJ\u0012\u0010e\u001a\u00020F2\b\u0010f\u001a\u0004\u0018\u00010gH\u0002J\u0010\u0010h\u001a\u00020F2\u0006\u0010_\u001a\u00020`H\u0002J\u0016\u0010i\u001a\u00020F2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020l0kH\u0002J\b\u0010m\u001a\u00020FH\u0002J\u0006\u0010n\u001a\u00020FJ\u0010\u0010o\u001a\u00020F2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020F2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010s\u001a\u00020F2\u0006\u0010f\u001a\u00020tH\u0002J\b\u0010u\u001a\u00020FH\u0002J\b\u0010v\u001a\u00020FH\u0002J\b\u0010w\u001a\u00020FH\u0002J\u0010\u0010x\u001a\u00020F2\u0006\u0010y\u001a\u00020zH\u0002J\u0010\u0010{\u001a\u00020F2\u0006\u0010f\u001a\u00020|H\u0002J\u0018\u0010}\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0002J\u0006\u0010~\u001a\u00020FJ!\u0010\u007f\u001a\u00020F2\u0007\u0010\u0080\u0001\u001a\u00020[2\u0007\u0010\u0081\u0001\u001a\u00020[2\u0007\u0010\u0082\u0001\u001a\u00020\u000fJ\u0007\u0010\u0083\u0001\u001a\u00020FJ\u0019\u0010\u0084\u0001\u001a\u00020F2\u000e\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020q0\u0086\u0001H\u0003J\t\u0010\u0087\u0001\u001a\u00020FH\u0002J(\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u000fH\u0082@¢\u0006\u0003\u0010\u008d\u0001J\u0007\u0010\u008e\u0001\u001a\u00020FR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b.\u0010/R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020706¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;06¢\u0006\b\n\u0000\u001a\u0004\b<\u00109R\u001b\u0010=\u001a\u00020>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010+\u001a\u0004\b?\u0010@R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u001a\u0010N\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013¨\u0006\u008f\u0001"}, d2 = {"Lcom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mCurrentEnter", "", "getMCurrentEnter", "()Z", "setMCurrentEnter", "(Z)V", "mEnterRoomFromSmall", "getMEnterRoomFromSmall", "setMEnterRoomFromSmall", "mGiftSourceBeanList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/MeetingRoomReceiveGiftCustomContent;", "Lkotlin/collections/ArrayList;", "getMGiftSourceBeanList", "()Ljava/util/ArrayList;", "mIsGiftTraverseing", "getMIsGiftTraverseing", "setMIsGiftTraverseing", "mInsertWelcome", "getMInsertWelcome", "setMInsertWelcome", "mIMIsInit", "getMIMIsInit", "setMIMIsInit", "voteHelper", "Lcom/qiahao/nextvideo/room/help/VoteHelper;", "getVoteHelper", "()Lcom/qiahao/nextvideo/room/help/VoteHelper;", "voteHelper$delegate", "Lkotlin/Lazy;", "gameMicAdapter", "Lcom/qiahao/nextvideo/room/game/GameMicAdapter;", "getGameMicAdapter", "()Lcom/qiahao/nextvideo/room/game/GameMicAdapter;", "gameMicAdapter$delegate", "fragmentScope", "Lkotlinx/coroutines/CoroutineScope;", "getFragmentScope", "()Lkotlinx/coroutines/CoroutineScope;", "manager", "Lcom/qiahao/nextvideo/utilities/animation/AnimationQueueManager;", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "getManager", "()Lcom/qiahao/nextvideo/utilities/animation/AnimationQueueManager;", "gameManager", "LuserProxy/UserProxy1$GlobalGameBanner;", "getGameManager", "fullGiftHelper", "Lcom/qiahao/nextvideo/room/help/FullGiftHelper;", "getFullGiftHelper", "()Lcom/qiahao/nextvideo/room/help/FullGiftHelper;", "fullGiftHelper$delegate", "mJoinGroupCallBack", "com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$mJoinGroupCallBack$1", "Lcom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$mJoinGroupCallBack$1;", "initHelp", "", "initGemRecycleView", "initRocket", "initFromSamllOrEnterLogic", "checkChatMic", "initClickListener", "showFloatChat", "initData", "isShow", "setShow", "initChatUI", "initObserve", "showLudoGameView", "showUnoGameView", "showDominoGameView", "showCrushGameView", "showBalootGameView", "showCarromGameView", "showJackaroGameView", "showToastOrLog", "toastText", "", "logText", "writeIn", "initView", "groupDetailBean", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "refreshGoldView", "checkPlayLayout", "showBackgammonGameView", "checkPK", "checkOtherPK", "data", "Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "supportLevelShow", "showGroupMedalView", "it", "", "Lcom/qiahao/nextvideo/data/model/GroupMedalBean;", "initBannerView", "clearMessage", "sendImage", "media", "Lcom/luck/picture/lib/entity/LocalMedia;", "sendVideo", "playGift", "Lcom/qiahao/nextvideo/data/model/GiftDateItem;", "showUserCompleteUpMicTask", "addUserEnterRoomAnimator", "showContactWrapper", "inviteUserUpMicToCompeleReward", ExchangeDetailActivity.TYPE_DIAMOND, "", "addEnterUserLayout", "Lcom/qiahao/nextvideo/data/model/EnterEffectData;", "cuttingGiftList", "dispatchGiftShow", "showSendGiftPanel", "extraId", "userName", "isAllMic", "goToPurchase", "choosePicture", "listener", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "showMicFaceDialog", "uploadImage", "Lcom/qhqc/core/basic/aws/Result;", "file", "Ljava/io/File;", "isImage", "(Ljava/io/File;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAudioRoomFragmentHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,3693:1\n176#2,2:3694\n255#2:3731\n61#3,9:3696\n61#3,9:3705\n1869#4,2:3714\n1563#4:3721\n1634#4,3:3722\n1563#4:3725\n1634#4,3:3726\n1869#4,2:3729\n1869#4,2:3733\n48#5:3716\n48#5:3732\n51#5:3735\n48#5:3736\n1#6:3717\n439#7:3718\n439#7:3719\n439#7:3720\n*S KotlinDebug\n*F\n+ 1 AudioRoomFragmentHelp.kt\ncom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp\n*L\n825#1:3694,2\n1073#1:3731\n827#1:3696,9\n2807#1:3705,9\n2868#1:3714,2\n3499#1:3721\n3499#1:3722,3\n3504#1:3725\n3504#1:3726,3\n3506#1:3729,2\n2574#1:3733,2\n2891#1:3716\n2383#1:3732\n3462#1:3735\n3465#1:3736\n3388#1:3718\n3397#1:3719\n3399#1:3720\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp {

    @NotNull
    private final AudioRoomFragment fragment;

    @NotNull
    private final CoroutineScope fragmentScope;

    /* renamed from: fullGiftHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fullGiftHelper;

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
    private boolean mInsertWelcome;
    private boolean mIsGiftTraverseing;

    @NotNull
    private final AudioRoomFragmentHelp$mJoinGroupCallBack$1 mJoinGroupCallBack;

    @NotNull
    private final AnimationQueueManager<GiftNoticeUIModel> manager;

    /* renamed from: voteHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy voteHelper;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$1 */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (AudioRoomFragmentHelp.this.getFragment().getActivity() == null) {
                return;
            }
            int i = msg.what;
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        if (i == 7) {
                            if (AudioRoomFragmentHelp.this.getMGiftSourceBeanList().isEmpty()) {
                                AudioRoomFragmentHelp.this.setMIsGiftTraverseing(false);
                                AudioRoomFragmentHelp audioRoomFragmentHelp = AudioRoomFragmentHelp.this;
                                AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, null, "礼物播放svga:--handler轮训结束 --" + audioRoomFragmentHelp.getMGiftSourceBeanList().size() + "-", false, 5, null);
                                return;
                            }
                            AudioRoomFragmentHelp.this.setMIsGiftTraverseing(true);
                            AudioRoomFragmentHelp audioRoomFragmentHelp2 = AudioRoomFragmentHelp.this;
                            AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp2, null, "礼物播放svga:--handler轮训取头条处理 --" + audioRoomFragmentHelp2.getMGiftSourceBeanList().size() + "-", false, 5, null);
                            AudioRoomFragmentHelp.this.dispatchGiftShow();
                            sendEmptyMessageDelayed(7, 400L);
                            return;
                        }
                        return;
                    }
                    AudioRoomFragmentHelp.showToastOrLog$default(AudioRoomFragmentHelp.this, null, "进群获取群信息后--3秒弹出邀请handler执行上麦网络请求", true, 1, null);
                    AudioRoomFragmentHelp.this.getFragment().getMViewModel().enterRoomCheckAutoInviteUpMicDialog();
                    return;
                }
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                if (TextUtils.isEmpty(meetingRoomManager.getMCurrentAgoraChannelId())) {
                    AudioRoomFragmentHelp.showToastOrLog$default(AudioRoomFragmentHelp.this, null, "handleMessage: 未加入通道！！！ 调用加入通道！！！！", false, 5, null);
                    EnterRoomData enterRoomData = AudioRoomFragmentHelp.this.getFragment().getEnterRoomData();
                    if (enterRoomData != null) {
                        AudioRoomFragmentHelp.this.getFragment().getMViewModel().joinChannel(enterRoomData.getAgoraToken(), enterRoomData.getAgoraChannel(), enterRoomData.getAgoraId(), enterRoomData.getProvider());
                    }
                    sendEmptyMessageDelayed(5, 5000L);
                    return;
                }
                if (Intrinsics.areEqual(meetingRoomManager.getMCurrentAgoraChannelId(), meetingRoomManager.getMRoomChannelId())) {
                    AudioRoomFragmentHelp.showToastOrLog$default(AudioRoomFragmentHelp.this, null, " handleMessage: 是同一条通道--不用管", false, 5, null);
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
                        AudioRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(false);
                        return;
                    } else {
                        AudioRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
                        return;
                    }
                }
                AudioRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
                return;
            }
            Object obj2 = msg.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            Boolean bool = (Boolean) obj2;
            bool.booleanValue();
            sendMessageDelayed(Message.obtain(this, 4, bool), 200L);
        }
    }

    public AudioRoomFragmentHelp(@NotNull AudioRoomFragment audioRoomFragment) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        this.mCurrentEnter = true;
        this.mGiftSourceBeanList = new ArrayList<>();
        this.voteHelper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.u1
            public final Object invoke() {
                VoteHelper voteHelper_delegate$lambda$0;
                voteHelper_delegate$lambda$0 = AudioRoomFragmentHelp.voteHelper_delegate$lambda$0(AudioRoomFragmentHelp.this);
                return voteHelper_delegate$lambda$0;
            }
        });
        this.gameMicAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.w1
            public final Object invoke() {
                GameMicAdapter gameMicAdapter_delegate$lambda$1;
                gameMicAdapter_delegate$lambda$1 = AudioRoomFragmentHelp.gameMicAdapter_delegate$lambda$1();
                return gameMicAdapter_delegate$lambda$1;
            }
        });
        this.fragmentScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        FragmentAudioRoomBinding binding = audioRoomFragment.getBinding();
        if (binding != null) {
            viewGroup = binding.giftNoticesContainer;
        } else {
            viewGroup = null;
        }
        AnimationQueueManager<GiftNoticeUIModel> animationQueueManager = new AnimationQueueManager<>(viewGroup, new Function1() { // from class: com.qiahao.nextvideo.room.help.x1
            public final Object invoke(Object obj) {
                ViewDataBinding manager$lambda$2;
                manager$lambda$2 = AudioRoomFragmentHelp.manager$lambda$2(AudioRoomFragmentHelp.this, (GiftNoticeUIModel) obj);
                return manager$lambda$2;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.y1
            public final Object invoke(Object obj, Object obj2) {
                Unit manager$lambda$3;
                manager$lambda$3 = AudioRoomFragmentHelp.manager$lambda$3(AudioRoomFragmentHelp.this, (ViewDataBinding) obj, (GiftNoticeUIModel) obj2);
                return manager$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.z1
            public final Object invoke(Object obj) {
                String manager$lambda$4;
                manager$lambda$4 = AudioRoomFragmentHelp.manager$lambda$4((GiftNoticeUIModel) obj);
                return manager$lambda$4;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.a2
            public final Object invoke(Object obj, Object obj2) {
                GiftNoticeUIModel manager$lambda$5;
                manager$lambda$5 = AudioRoomFragmentHelp.manager$lambda$5((GiftNoticeUIModel) obj, (GiftNoticeUIModel) obj2);
                return manager$lambda$5;
            }
        }, 0, 32, null);
        LifecycleOwner viewLifecycleOwner = audioRoomFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        animationQueueManager.bindToLifecycle(viewLifecycleOwner);
        this.manager = animationQueueManager;
        FragmentAudioRoomBinding binding2 = audioRoomFragment.getBinding();
        AnimationQueueManager<UserProxy1.GlobalGameBanner> animationQueueManager2 = new AnimationQueueManager<>(binding2 != null ? binding2.roomGameNotice : null, new Function1() { // from class: com.qiahao.nextvideo.room.help.b2
            public final Object invoke(Object obj) {
                ViewDataBinding gameManager$lambda$7;
                gameManager$lambda$7 = AudioRoomFragmentHelp.gameManager$lambda$7(AudioRoomFragmentHelp.this, (UserProxy1.GlobalGameBanner) obj);
                return gameManager$lambda$7;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.c2
            public final Object invoke(Object obj, Object obj2) {
                Unit gameManager$lambda$8;
                gameManager$lambda$8 = AudioRoomFragmentHelp.gameManager$lambda$8(AudioRoomFragmentHelp.this, (ViewDataBinding) obj, (UserProxy1.GlobalGameBanner) obj2);
                return gameManager$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.d2
            public final Object invoke(Object obj) {
                String gameManager$lambda$9;
                gameManager$lambda$9 = AudioRoomFragmentHelp.gameManager$lambda$9((UserProxy1.GlobalGameBanner) obj);
                return gameManager$lambda$9;
            }
        }, new Function2() { // from class: com.qiahao.nextvideo.room.help.f2
            public final Object invoke(Object obj, Object obj2) {
                UserProxy1.GlobalGameBanner gameManager$lambda$10;
                gameManager$lambda$10 = AudioRoomFragmentHelp.gameManager$lambda$10((UserProxy1.GlobalGameBanner) obj, (UserProxy1.GlobalGameBanner) obj2);
                return gameManager$lambda$10;
            }
        }, 1);
        LifecycleOwner viewLifecycleOwner2 = audioRoomFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        animationQueueManager2.bindToLifecycle(viewLifecycleOwner2);
        this.gameManager = animationQueueManager2;
        this.fullGiftHelper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.v1
            public final Object invoke() {
                FullGiftHelper fullGiftHelper_delegate$lambda$12;
                fullGiftHelper_delegate$lambda$12 = AudioRoomFragmentHelp.fullGiftHelper_delegate$lambda$12(AudioRoomFragmentHelp.this);
                return fullGiftHelper_delegate$lambda$12;
            }
        });
        this.mJoinGroupCallBack = new AudioRoomFragmentHelp$mJoinGroupCallBack$1(this);
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                if (AudioRoomFragmentHelp.this.getFragment().getActivity() == null) {
                    return;
                }
                int i = msg.what;
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i == 7) {
                                if (AudioRoomFragmentHelp.this.getMGiftSourceBeanList().isEmpty()) {
                                    AudioRoomFragmentHelp.this.setMIsGiftTraverseing(false);
                                    AudioRoomFragmentHelp audioRoomFragmentHelp = AudioRoomFragmentHelp.this;
                                    AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp, null, "礼物播放svga:--handler轮训结束 --" + audioRoomFragmentHelp.getMGiftSourceBeanList().size() + "-", false, 5, null);
                                    return;
                                }
                                AudioRoomFragmentHelp.this.setMIsGiftTraverseing(true);
                                AudioRoomFragmentHelp audioRoomFragmentHelp2 = AudioRoomFragmentHelp.this;
                                AudioRoomFragmentHelp.showToastOrLog$default(audioRoomFragmentHelp2, null, "礼物播放svga:--handler轮训取头条处理 --" + audioRoomFragmentHelp2.getMGiftSourceBeanList().size() + "-", false, 5, null);
                                AudioRoomFragmentHelp.this.dispatchGiftShow();
                                sendEmptyMessageDelayed(7, 400L);
                                return;
                            }
                            return;
                        }
                        AudioRoomFragmentHelp.showToastOrLog$default(AudioRoomFragmentHelp.this, null, "进群获取群信息后--3秒弹出邀请handler执行上麦网络请求", true, 1, null);
                        AudioRoomFragmentHelp.this.getFragment().getMViewModel().enterRoomCheckAutoInviteUpMicDialog();
                        return;
                    }
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    if (TextUtils.isEmpty(meetingRoomManager.getMCurrentAgoraChannelId())) {
                        AudioRoomFragmentHelp.showToastOrLog$default(AudioRoomFragmentHelp.this, null, "handleMessage: 未加入通道！！！ 调用加入通道！！！！", false, 5, null);
                        EnterRoomData enterRoomData = AudioRoomFragmentHelp.this.getFragment().getEnterRoomData();
                        if (enterRoomData != null) {
                            AudioRoomFragmentHelp.this.getFragment().getMViewModel().joinChannel(enterRoomData.getAgoraToken(), enterRoomData.getAgoraChannel(), enterRoomData.getAgoraId(), enterRoomData.getProvider());
                        }
                        sendEmptyMessageDelayed(5, 5000L);
                        return;
                    }
                    if (Intrinsics.areEqual(meetingRoomManager.getMCurrentAgoraChannelId(), meetingRoomManager.getMRoomChannelId())) {
                        AudioRoomFragmentHelp.showToastOrLog$default(AudioRoomFragmentHelp.this, null, " handleMessage: 是同一条通道--不用管", false, 5, null);
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
                            AudioRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(false);
                            return;
                        } else {
                            AudioRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
                            return;
                        }
                    }
                    AudioRoomFragmentHelp.this.getFragment().getMViewModel().setRemoteAllMute(true);
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

    /* JADX WARN: Removed duplicated region for block: B:37:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void addEnterUserLayout(EnterEffectData data) {
        int i;
        LinearLayoutCompat linearLayoutCompat;
        int i2;
        String userName;
        CharSequence charSequence;
        String str;
        String str2;
        String str3;
        long j;
        String str4;
        FragmentAudioRoomBinding binding;
        float f;
        FragmentAudioRoomBinding binding2;
        int i3;
        Handler handler;
        FragmentAudioRoomBinding binding3;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        LinearLayoutCompat linearLayoutCompat4;
        String str5;
        String str6;
        Integer relationMedal$default;
        Drawable drawable;
        Integer cpLevel;
        int i4;
        Integer userEnter;
        if (this.fragment.isDetached() || this.fragment.getContext() == null || !MeetingRoomManager.INSTANCE.checkShowEffect()) {
            return;
        }
        Integer entryEffectType = data.getEntryEffectType();
        int i5 = 2;
        if ((entryEffectType == null || entryEffectType.intValue() != 1) && ((entryEffectType == null || entryEffectType.intValue() != 5) && ((entryEffectType == null || entryEffectType.intValue() != 6) && (entryEffectType == null || entryEffectType.intValue() != 7)))) {
            if (entryEffectType != null && entryEffectType.intValue() == 2) {
                i = R.layout.layout_mystery_user_enter_group_room;
            } else if (entryEffectType != null && entryEffectType.intValue() == 3) {
                if (data.getNobleLevel() >= 10) {
                    i = R.layout.layout_nobility_user_enter_group_room10;
                } else {
                    i = R.layout.layout_nobility_user_enter_group_room;
                }
            } else if (entryEffectType != null && entryEffectType.intValue() == 4) {
                i = R.layout.layout_vip_user_enter_group_room;
            } else if (entryEffectType != null && entryEffectType.intValue() == 8) {
                i = R.layout.layout_svip_user_enter_group_room;
            } else {
                i = R.layout.layout_user_enter_group_room;
            }
        } else {
            i = R.layout.layout_cp_user_enter_group_room;
        }
        LayoutInflater from = LayoutInflater.from(this.fragment.getContext());
        FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
        if (binding4 != null) {
            linearLayoutCompat = binding4.userEnterRoomContent;
        } else {
            linearLayoutCompat = null;
        }
        View inflate = from.inflate(i, (ViewGroup) linearLayoutCompat, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(ScreenUtil.getScreenWidth(this.fragment.getContext()));
        inflate.setLayoutParams(layoutParams2);
        TextView textView = (TextView) inflate.findViewById(R.id.user_enter_room);
        if (data.getUserName() == null) {
            userName = "";
        } else {
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
        }
        View findViewById = inflate.findViewById(R.id.back_group);
        Integer entryEffectType2 = data.getEntryEffectType();
        if ((entryEffectType2 == null || entryEffectType2.intValue() != 1) && ((entryEffectType2 == null || entryEffectType2.intValue() != 5) && ((entryEffectType2 == null || entryEffectType2.intValue() != 6) && (entryEffectType2 == null || entryEffectType2.intValue() != 7)))) {
            if (entryEffectType2 != null && entryEffectType2.intValue() == 2) {
                String stringById = ResourcesKtxKt.getStringById(this, 2131954385);
                String stringById2 = ResourcesKtxKt.getStringById(this, 2131953504);
                SvipData svip = data.getSvip();
                if (svip != null) {
                    str4 = svip.mysteryNumber();
                } else {
                    str4 = null;
                }
                String format = String.format(stringById2, Arrays.copyOf(new Object[]{str4}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                String format2 = String.format(stringById, Arrays.copyOf(new Object[]{format}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView.setText(format2);
                Intrinsics.checkNotNull(findViewById);
                ImageKtxKt.toHorizontalMirror(findViewById, R.drawable.mystery_enter_room);
            } else if (entryEffectType2 != null && entryEffectType2.intValue() == 3) {
                if (data.getNobleLevel() >= 10) {
                    LightQueueCombinationPlayer findViewById2 = inflate.findViewById(R.id.queuePlayer);
                    Intrinsics.checkNotNull(inflate);
                    LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(inflate);
                    if (lifecycleOwner != null) {
                        findViewById2.bindingLifeCycle(lifecycleOwner);
                    }
                    VapMediaSource vapMediaSource = new VapMediaSource();
                    if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                        str3 = "mp4/noble_right10.mp4";
                    } else {
                        str3 = "mp4/noble10.mp4";
                    }
                    vapMediaSource.setFilePath(str3);
                    findViewById2.addQueue(vapMediaSource);
                    String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                    textView.setText(format3);
                    textView.setTextColor(Color.parseColor("#FFFF00"));
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                    j = 4000;
                    inflate.setTag(Long.valueOf(System.currentTimeMillis()));
                    binding = this.fragment.getBinding();
                    if (binding != null && (linearLayoutCompat4 = binding.userEnterRoomContent) != null) {
                        linearLayoutCompat4.addView(inflate);
                    }
                    ViewPropertyAnimator animate = inflate.animate();
                    if (!ViewUtilitiesKt.getRightToLeftDirection()) {
                        f = ScreenUtil.getScreenWidth(this.fragment.getContext()) - Dimens.INSTANCE.dpToPx(14);
                    } else {
                        f = -(ScreenUtil.getScreenWidth(this.fragment.getContext()) - Dimens.INSTANCE.dpToPx(14));
                    }
                    animate.translationX(f);
                    animate.setDuration(500L);
                    animate.start();
                    binding2 = this.fragment.getBinding();
                    if (binding2 == null && (linearLayoutCompat3 = binding2.userEnterRoomContent) != null) {
                        i3 = linearLayoutCompat3.getChildCount();
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 5 && (binding3 = this.fragment.getBinding()) != null && (linearLayoutCompat2 = binding3.userEnterRoomContent) != null) {
                        linearLayoutCompat2.removeViewAt(0);
                    }
                    handler = this.mHandler;
                    if (handler == null) {
                        handler.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.help.k2
                            @Override // java.lang.Runnable
                            public final void run() {
                                AudioRoomFragmentHelp.addEnterUserLayout$lambda$108(AudioRoomFragmentHelp.this);
                            }
                        }, j);
                        return;
                    }
                    return;
                }
                String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                textView.setText(format4);
                Integer nobleEnterRoomBackRes = UserService.INSTANCE.getNobleEnterRoomBackRes(data.getNobleLevel());
                if (nobleEnterRoomBackRes != null) {
                    int intValue = nobleEnterRoomBackRes.intValue();
                    Intrinsics.checkNotNull(findViewById);
                    ImageKtxKt.toHorizontalMirror(findViewById, intValue);
                }
                textView.setTypeface(Typeface.DEFAULT);
                if (data.getNobleLevel() == 5) {
                    textView.setTextColor(Color.parseColor("#fa5200"));
                } else if (data.getNobleLevel() == 7) {
                    textView.setTextColor(Color.parseColor("#FFFF00"));
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                }
            } else if (entryEffectType2 != null && entryEffectType2.intValue() == 4) {
                String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
                Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                textView.setText(format5);
                Intrinsics.checkNotNull(findViewById);
                ImageKtxKt.toHorizontalMirror(findViewById, R.drawable.vip_enter_room);
            } else if (entryEffectType2 != null && entryEffectType2.intValue() == 8) {
                textView.setText(userName);
                HiloImageView findViewById3 = inflate.findViewById(2131362013);
                String image100 = ImageSizeKt.image100(data.getUserAvatar());
                if (image100 == null) {
                    str = "";
                } else {
                    str = image100;
                }
                HiloImageView.loadImage$default(findViewById3, str, 2131231655, 0, 4, (Object) null);
                TextView textView2 = (TextView) inflate.findViewById(R.id.f١١id);
                String format6 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{data.getCode()}, 1));
                Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
                textView2.setText(format6);
                textView2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#000000", "#000000", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
                ((TextView) inflate.findViewById(R.id.subContent)).setText(data.getContent());
                final SVGAImageView findViewById4 = inflate.findViewById(2131364958);
                try {
                    SVGAParser shareParser = SVGAParser.Companion.shareParser();
                    if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                        str2 = "svga/svip10_online_reverse.svga";
                    } else {
                        str2 = "svga/svip10_online.svga";
                    }
                    shareParser.decodeFromAssets(str2, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$addEnterUserLayout$6
                        public void onComplete(SVGAVideoEntity videoItem) {
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            findViewById4.setVideoItem(videoItem);
                            findViewById4.startAnimation();
                        }

                        public void onError() {
                        }
                    });
                } catch (Exception unused) {
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放麦位皮肤失败", false, 4, (Object) null);
                }
            } else {
                String format7 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
                Intrinsics.checkNotNullExpressionValue(format7, "format(...)");
                textView.setText(format7);
            }
        } else {
            HiloImageView findViewById5 = inflate.findViewById(R.id.leftAvatar);
            HiloImageView findViewById6 = inflate.findViewById(R.id.rightAvatar);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.model);
            String image1002 = ImageSizeKt.image100(data.getUserAvatar());
            if (image1002 == null) {
                str5 = "";
            } else {
                str5 = image1002;
            }
            HiloImageView.loadImage$default(findViewById5, str5, 2131231655, 0, 4, (Object) null);
            String image1003 = ImageSizeKt.image100(data.getCpUserAvatar());
            if (image1003 == null) {
                str6 = "";
            } else {
                str6 = image1003;
            }
            HiloImageView.loadImage$default(findViewById6, str6, 2131231655, 0, 4, (Object) null);
            Integer entryEffectType3 = data.getEntryEffectType();
            if (entryEffectType3 == null || entryEffectType3.intValue() != 1) {
                if (entryEffectType3 == null || entryEffectType3.intValue() != 5) {
                    if (entryEffectType3 != null && entryEffectType3.intValue() == 6) {
                        i5 = 3;
                    } else if (entryEffectType3 != null && entryEffectType3.intValue() == 7) {
                        i5 = 4;
                    }
                }
                RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
                relationMedal$default = RelationTypeUtils.getRelationMedal$default(relationTypeUtils, data.getCpLevel(), false, i5, 2, (Object) null);
                if (relationMedal$default == null) {
                    drawable = androidx.core.content.a.getDrawable(imageView.getContext(), relationMedal$default.intValue());
                } else {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                String format8 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
                Intrinsics.checkNotNullExpressionValue(format8, "format(...)");
                textView.setText(format8);
                cpLevel = data.getCpLevel();
                if (cpLevel == null) {
                    i4 = cpLevel.intValue();
                } else {
                    i4 = 0;
                }
                userEnter = relationTypeUtils.getUserEnter(i5, i4);
                if (userEnter != null) {
                    int intValue2 = userEnter.intValue();
                    Intrinsics.checkNotNull(findViewById);
                    ImageKtxKt.toHorizontalMirror(findViewById, intValue2);
                }
            }
            i5 = 1;
            RelationTypeUtils relationTypeUtils2 = RelationTypeUtils.INSTANCE;
            relationMedal$default = RelationTypeUtils.getRelationMedal$default(relationTypeUtils2, data.getCpLevel(), false, i5, 2, (Object) null);
            if (relationMedal$default == null) {
            }
            imageView.setImageDrawable(drawable);
            String format82 = String.format(ResourcesKtxKt.getStringById(this, 2131954385), Arrays.copyOf(new Object[]{userName}, 1));
            Intrinsics.checkNotNullExpressionValue(format82, "format(...)");
            textView.setText(format82);
            cpLevel = data.getCpLevel();
            if (cpLevel == null) {
            }
            userEnter = relationTypeUtils2.getUserEnter(i5, i4);
            if (userEnter != null) {
            }
        }
        j = FadeViewHelper.DEFAULT_FADE_OUT_DELAY;
        inflate.setTag(Long.valueOf(System.currentTimeMillis()));
        binding = this.fragment.getBinding();
        if (binding != null) {
            linearLayoutCompat4.addView(inflate);
        }
        ViewPropertyAnimator animate2 = inflate.animate();
        if (!ViewUtilitiesKt.getRightToLeftDirection()) {
        }
        animate2.translationX(f);
        animate2.setDuration(500L);
        animate2.start();
        binding2 = this.fragment.getBinding();
        if (binding2 == null) {
        }
        i3 = 0;
        if (i3 > 5) {
            linearLayoutCompat2.removeViewAt(0);
        }
        handler = this.mHandler;
        if (handler == null) {
        }
    }

    public static final void addEnterUserLayout$lambda$108(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        LinearLayoutCompat linearLayoutCompat;
        FragmentAudioRoomBinding binding;
        LinearLayoutCompat linearLayoutCompat2;
        LinearLayoutCompat linearLayoutCompat3;
        FragmentAudioRoomBinding binding2;
        LinearLayoutCompat linearLayoutCompat4;
        FragmentAudioRoomBinding binding3 = audioRoomFragmentHelp.fragment.getBinding();
        if (binding3 != null && (linearLayoutCompat3 = binding3.userEnterRoomContent) != null && linearLayoutCompat3.getChildCount() != 0 && (binding2 = audioRoomFragmentHelp.fragment.getBinding()) != null && (linearLayoutCompat4 = binding2.userEnterRoomContent) != null) {
            linearLayoutCompat4.removeViewAt(0);
        }
        FragmentAudioRoomBinding binding4 = audioRoomFragmentHelp.fragment.getBinding();
        if (binding4 != null && (linearLayoutCompat = binding4.userEnterRoomContent) != null && linearLayoutCompat.getChildCount() == 0 && (binding = audioRoomFragmentHelp.fragment.getBinding()) != null && (linearLayoutCompat2 = binding.userEnterRoomContent) != null) {
            linearLayoutCompat2.setVisibility(0);
        }
    }

    private final void addUserEnterRoomAnimator() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.help.q1
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRoomFragmentHelp.addUserEnterRoomAnimator$lambda$99(AudioRoomFragmentHelp.this);
                }
            }, 100L);
        }
    }

    public static final void addUserEnterRoomAnimator$lambda$99(AudioRoomFragmentHelp audioRoomFragmentHelp) {
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
        GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomFragmentHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
        String str7 = null;
        if (groupDetailBean != null) {
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null) {
                enterEffectData = DataExternalKt.userToEnterEffectData(user2, groupDetailBean);
            } else {
                enterEffectData = null;
            }
            if (enterEffectData != null) {
                audioRoomFragmentHelp.addEnterUserLayout(enterEffectData);
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
            showToastOrLog$default(audioRoomFragmentHelp, null, "礼物播放svga:---进房间----", false, 5, null);
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
                audioRoomFragmentHelp.playGift(new GiftDateItem(str2, str3, "", null, null, GiftDateItem.TYPE_ENTER_ANIMATION, null, null, str4, str5, null, list, str7, str6, null, 17624, null));
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

    public final void checkOtherPK(PKInviteCancel data) {
        PKSearchView pKSearchView;
        ConstraintLayout constraintLayout;
        RoomPK mpk;
        Integer type;
        int i;
        PKSearchView pKSearchView2;
        ImageView imageView;
        QMUIRadiusImageView qMUIRadiusImageView;
        ConstraintLayout constraintLayout2;
        if (data != null && (type = data.getType()) != null && type.intValue() == 1) {
            FragmentAudioRoomBinding binding = this.fragment.getBinding();
            int i2 = 0;
            if (binding != null && (constraintLayout2 = binding.pkLayout) != null) {
                constraintLayout2.setVisibility(0);
            }
            FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
            if (binding2 != null && (qMUIRadiusImageView = binding2.leftAvatar) != null) {
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(data.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            Integer gameId = data.getGameId();
            if (gameId != null) {
                i = gameId.intValue();
            } else {
                i = 0;
            }
            meetingRoomManager.setMOldPKGameID(i);
            Integer gameId2 = data.getGameId();
            if (gameId2 != null) {
                i2 = gameId2.intValue();
            }
            Integer roomPKGameIcon = meetingRoomManager.getRoomPKGameIcon(i2);
            FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
            if (binding3 != null && (imageView = binding3.gameTypeImage) != null) {
                Context context = this.fragment.getContext();
                Drawable drawable = null;
                if (context != null && roomPKGameIcon != null) {
                    drawable = androidx.core.content.a.getDrawable(context, roomPKGameIcon.intValue());
                }
                imageView.setImageDrawable(drawable);
            }
            FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
            if (binding4 != null && (pKSearchView2 = binding4.pkSearch) != null) {
                pKSearchView2.startAnimation();
                return;
            }
            return;
        }
        MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
        RoomPK mpk2 = meetingRoomManager2.getMPK();
        if ((mpk2 == null || mpk2.getStatus() != 0 || (mpk = meetingRoomManager2.getMPK()) == null || !mpk.checkIsInvite()) && data != null) {
            Integer gameId3 = data.getGameId();
            int mOldPKGameID = meetingRoomManager2.getMOldPKGameID();
            if (gameId3 != null && gameId3.intValue() == mOldPKGameID) {
                FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
                if (binding5 != null && (constraintLayout = binding5.pkLayout) != null) {
                    constraintLayout.setVisibility(8);
                }
                FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
                if (binding6 != null && (pKSearchView = binding6.pkSearch) != null) {
                    pKSearchView.stopAnimation();
                }
                meetingRoomManager2.setMOldPKGameID(-1);
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void choosePicture(OnResultCallbackListener<LocalMedia> listener) {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().setMShowType(SelectMimeType.ofAll()).isEnablePreviewImage(true).setWithCamera(true).setMVideoMaxSecond(10).setFileMaxSize(10240L).setMMaxSelect(9).isMEnableCrop(false).build(), listener);
    }

    private final ArrayList<MeetingRoomReceiveGiftCustomContent> cuttingGiftList() {
        ArrayList<MeetingRoomReceiveGiftCustomContent> arrayList = new ArrayList<>();
        if (this.mGiftSourceBeanList.size() > 50) {
            Iterator<MeetingRoomReceiveGiftCustomContent> it = this.mGiftSourceBeanList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MeetingRoomReceiveGiftCustomContent next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent = next;
                if (arrayList.size() < 50) {
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

    public static final FullGiftHelper fullGiftHelper_delegate$lambda$12(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        FrameLayout frameLayout;
        FragmentAudioRoomBinding binding = audioRoomFragmentHelp.fragment.getBinding();
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

    public static final ViewDataBinding gameManager$lambda$7(AudioRoomFragmentHelp audioRoomFragmentHelp, UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(globalGameBanner, "data");
        ViewGameNoticeBinding inflate = ViewGameNoticeBinding.inflate(LayoutInflater.from(audioRoomFragmentHelp.fragment.getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public static final Unit gameManager$lambda$8(AudioRoomFragmentHelp audioRoomFragmentHelp, ViewDataBinding viewDataBinding, UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(viewDataBinding, "gameBinding");
        Intrinsics.checkNotNullParameter(globalGameBanner, "newData");
        if (viewDataBinding instanceof ViewGameNoticeBinding) {
            AudioRoomExtraDataKt.refreshGameView(audioRoomFragmentHelp, (ViewGameNoticeBinding) viewDataBinding, globalGameBanner);
        }
        return Unit.INSTANCE;
    }

    public static final String gameManager$lambda$9(UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(globalGameBanner, "it");
        return DataExternalKt.checkData(globalGameBanner);
    }

    public static final GameMicAdapter gameMicAdapter_delegate$lambda$1() {
        return new GameMicAdapter();
    }

    public static final Unit goToPurchase$lambda$115(AudioRoomFragmentHelp audioRoomFragmentHelp, ApiResponse apiResponse) {
        boolean z;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        final Context activity = audioRoomFragmentHelp.fragment.getActivity();
        if (activity != null) {
            AwardDetailBean awardDetailBean = (AwardDetailBean) apiResponse.getData();
            if (awardDetailBean != null) {
                z = Intrinsics.areEqual(awardDetailBean.getHasGetReward(), Boolean.FALSE);
            } else {
                z = false;
            }
            if (z) {
                FirstRechargeDialog firstRechargeDialog = new FirstRechargeDialog(activity);
                firstRechargeDialog.setListener(new BaseDialogInterface() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$goToPurchase$1$1$1$1
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

    public static final Unit goToPurchase$lambda$116(AudioRoomFragmentHelp audioRoomFragmentHelp, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        showToastOrLog$default(audioRoomFragmentHelp, null, "第一次充值请求失败", false, 5, null);
        return Unit.INSTANCE;
    }

    private final void initBannerView() {
        GroupBannerView groupBannerView;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (groupBannerView = binding.groupBanner) != null) {
            groupBannerView.setGroupBannerViewLister(new GroupBannerViewLister() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initBannerView$1
                @Override // com.qiahao.nextvideo.room.view.GroupBannerViewLister
                public void openWebView(String url) {
                    Intrinsics.checkNotNullParameter(url, "url");
                    NavigationHelper.jump$default(NavigationHelper.INSTANCE, url, (SuperCallBack) null, 2, (Object) null);
                }
            });
        }
    }

    private final void initChatUI() {
        GroupInputLayoutView groupInputLayoutView;
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        RoomMessageViewBinding messageBinding2;
        RoomInputView roomInputView2;
        boolean z;
        if (this.fragment.getActivity() == null) {
            return;
        }
        RoomMessageView mChatLayout = this.fragment.getMChatLayout();
        if (mChatLayout != null && (messageBinding2 = mChatLayout.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
            if (MessageProvide.INSTANCE.getUnReadMessage() > 0) {
                z = true;
            } else {
                z = false;
            }
            roomInputView2.hasNewMessage(z);
        }
        RoomMessageView mChatLayout2 = this.fragment.getMChatLayout();
        if (mChatLayout2 != null) {
            mChatLayout2.setMessageItemListener(new AudioRoomFragmentHelp$initChatUI$1(this));
        }
        RoomMessageView mChatLayout3 = this.fragment.getMChatLayout();
        if (mChatLayout3 != null && (messageBinding = mChatLayout3.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
            roomInputView.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.z0
                public final Object invoke(Object obj) {
                    Unit initChatUI$lambda$36;
                    initChatUI$lambda$36 = AudioRoomFragmentHelp.initChatUI$lambda$36(AudioRoomFragmentHelp.this, ((Integer) obj).intValue());
                    return initChatUI$lambda$36;
                }
            });
        }
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (groupInputLayoutView = binding.groupInput) != null) {
            groupInputLayoutView.setOnGroupInputLayoutListener(new AudioRoomFragmentHelp$initChatUI$3(this));
        }
    }

    public static final Unit initChatUI$lambda$36(AudioRoomFragmentHelp audioRoomFragmentHelp, int i) {
        GroupInputLayoutView groupInputLayoutView;
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        ImageView imageView;
        ImageView imageView2;
        RoomMessageViewBinding messageBinding2;
        RoomInputView roomInputView2;
        ImageView imageView3;
        String str;
        String externalId;
        String str2 = "";
        switch (i) {
            case 1:
                FragmentAudioRoomBinding binding = audioRoomFragmentHelp.fragment.getBinding();
                if (binding != null && (groupInputLayoutView = binding.groupInput) != null) {
                    groupInputLayoutView.showSoftInput();
                    break;
                }
                break;
            case 2:
                showToastOrLog$default(audioRoomFragmentHelp, null, "onClick: setRoomSoundHandler", false, 5, null);
                GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomFragmentHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
                if (groupDetailBean != null && groupDetailBean.getMicOn()) {
                    FragmentAudioRoomBinding binding2 = audioRoomFragmentHelp.fragment.getBinding();
                    if (binding2 != null && (imageView2 = binding2.closeMicTip) != null && imageView2.getVisibility() == 0) {
                        FragmentAudioRoomBinding binding3 = audioRoomFragmentHelp.fragment.getBinding();
                        if (binding3 != null && (imageView3 = binding3.closeMicTip) != null) {
                            imageView3.setVisibility(8);
                        }
                        RoomMessageView mChatLayout = audioRoomFragmentHelp.fragment.getMChatLayout();
                        if (mChatLayout != null && (messageBinding2 = mChatLayout.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
                            roomInputView2.changeRoomSoundStatus(true);
                        }
                        MeetingRoomManager.INSTANCE.setLocalRoomMicStatus(true);
                        audioRoomFragmentHelp.fragment.getMViewModel().setRemoteAllMute(false);
                        break;
                    } else {
                        FragmentAudioRoomBinding binding4 = audioRoomFragmentHelp.fragment.getBinding();
                        if (binding4 != null && (imageView = binding4.closeMicTip) != null) {
                            imageView.setVisibility(0);
                        }
                        MeetingRoomManager.INSTANCE.setLocalRoomMicStatus(false);
                        RoomMessageView mChatLayout2 = audioRoomFragmentHelp.fragment.getMChatLayout();
                        if (mChatLayout2 != null && (messageBinding = mChatLayout2.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
                            roomInputView.changeRoomSoundStatus(false);
                        }
                        audioRoomFragmentHelp.fragment.getMViewModel().setRemoteAllMute(true);
                        break;
                    }
                } else {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, audioRoomFragmentHelp.fragment.getContext(), ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131953000), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                        break;
                    }
                }
                break;
            case 3:
                audioRoomFragmentHelp.showContactWrapper();
                break;
            case 4:
                AudioRoomDialogHelp mDialogHelp = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp != null) {
                    mDialogHelp.showGameDialog();
                    break;
                }
                break;
            case 5:
                audioRoomFragmentHelp.showSendGiftPanel("", "", true);
                break;
            case 6:
                audioRoomFragmentHelp.showMicFaceDialog();
                break;
            case 7:
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
                    audioRoomFragmentHelp.fragment.getMViewModel().unMuteMic(findMicPositionFromExtraId);
                    break;
                } else {
                    audioRoomFragmentHelp.fragment.getMViewModel().muteMic(findMicPositionFromExtraId);
                    break;
                }
                break;
            case 8:
                AudioRoomDialogHelp mDialogHelp2 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp2 != null) {
                    mDialogHelp2.showToolDialog();
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    private final void initClickListener() {
        MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
        NewMicroView newMicroView;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null) {
            binding.setClick(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.n2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioRoomFragmentHelp.initClickListener$lambda$22(AudioRoomFragmentHelp.this, view);
                }
            });
        }
        FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
        if (binding2 != null && (newMicroView = binding2.microView) != null) {
            newMicroView.setOnMeetingRoomMicroItemClickListener(new AudioRoomFragmentHelp$initClickListener$2(this));
        }
        FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
        if (binding3 != null && (meetingRoomOnlineMemberLayout = binding3.meetingRoomOnlineMember) != null) {
            meetingRoomOnlineMemberLayout.setMMeetingRoomOnlineMemberLayoutListener(new MeetingRoomOnlineMemberLayoutListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initClickListener$3
                @Override // com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayoutListener
                public void meetingRoomOnlineMemberClickUserAvatar(String externalId) {
                    Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
                    int findMicPositionFromExtraId = MeetingRoomManager.INSTANCE.findMicPositionFromExtraId(externalId);
                    AudioRoomDialogHelp mDialogHelp = AudioRoomFragmentHelp.this.getFragment().getMDialogHelp();
                    if (mDialogHelp != null) {
                        mDialogHelp.showUserInfoDialog(externalId, findMicPositionFromExtraId);
                    }
                }
            });
        }
    }

    public static final void initClickListener$lambda$22(AudioRoomFragmentHelp audioRoomFragmentHelp, View view) {
        Context context;
        EnvelopeHelper mEnvelopeHelper;
        GroupInputLayoutView groupInputLayoutView;
        Integer type;
        int i;
        boolean z;
        Integer role;
        YouTuGameData mYouTuBe;
        Integer type2;
        LuckyWheelDialog mLuckyWheelDialog;
        RoomInfoFragment roomInfoFragment = null;
        boolean z2 = true;
        switch (view.getId()) {
            case R.id.backgammonGame /* 2131362041 */:
                audioRoomFragmentHelp.showBackgammonGameView();
                return;
            case R.id.balootGame /* 2131362058 */:
                audioRoomFragmentHelp.showBalootGameView();
                return;
            case R.id.carromGame /* 2131362233 */:
                audioRoomFragmentHelp.showCarromGameView();
                return;
            case R.id.changeGameModel /* 2131362264 */:
                if (!HiloUtils.INSTANCE.isFastClick() && (context = audioRoomFragmentHelp.fragment.getContext()) != null) {
                    new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952645)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initClickListener$1$2$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            AudioRoomFragmentHelp.this.getFragment().getMViewModel().exitHiloGameModel();
                        }
                    }).show();
                    return;
                }
                return;
            case R.id.close_room_image_view /* 2131362378 */:
                showToastOrLog$default(audioRoomFragmentHelp, null, "onClick: back_image_view", false, 5, null);
                AudioRoomDialogHelp mDialogHelp = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp != null) {
                    mDialogHelp.showLeaveRoomDialog();
                    return;
                }
                return;
            case R.id.crushGame /* 2131362567 */:
                audioRoomFragmentHelp.showCrushGameView();
                return;
            case R.id.diamondGame /* 2131362657 */:
                int intValue = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "LAST_DIAMOND_GAME", 7, (String) null, 4, (Object) null)).intValue();
                FragmentActivity activity = audioRoomFragmentHelp.fragment.getActivity();
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    new H5DiamondGameDialog(activity, intValue).show();
                    return;
                }
                return;
            case R.id.dominoGame /* 2131362704 */:
                audioRoomFragmentHelp.showDominoGameView();
                return;
            case R.id.envelopeLayout /* 2131362788 */:
                AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
                if (mGameHelp != null && (mEnvelopeHelper = mGameHelp.getMEnvelopeHelper()) != null) {
                    EnvelopeHelper.checkEnvelope$default(mEnvelopeHelper, false, 1, null);
                    return;
                }
                return;
            case R.id.group_id /* 2131363082 */:
            case R.id.group_name /* 2131363096 */:
            case R.id.meeting_avatar /* 2131363809 */:
                RoomInfoFragment findFragment = FragmentUtils.INSTANCE.findFragment(audioRoomFragmentHelp.fragment.getParentFragmentManager(), RoomInfoFragment.class);
                Bundle bundle = new Bundle();
                bundle.putString("groupId", audioRoomFragmentHelp.fragment.getMViewModel().getMGroupId());
                if (findFragment == null) {
                    findFragment = new RoomInfoFragment();
                }
                findFragment.setArguments(bundle);
                if (!findFragment.isAdded()) {
                    if (findFragment instanceof RoomInfoFragment) {
                        roomInfoFragment = findFragment;
                    }
                    if (roomInfoFragment != null) {
                        roomInfoFragment.show(audioRoomFragmentHelp.fragment.getParentFragmentManager(), "RoomInfoFragment");
                        return;
                    }
                    return;
                }
                return;
            case R.id.group_input_back /* 2131363084 */:
                FragmentAudioRoomBinding binding = audioRoomFragmentHelp.fragment.getBinding();
                if (binding != null && (groupInputLayoutView = binding.groupInput) != null) {
                    groupInputLayoutView.hideSoftInput();
                    return;
                }
                return;
            case R.id.jackaroGame /* 2131363384 */:
                audioRoomFragmentHelp.showJackaroGameView();
                return;
            case R.id.ludoGame /* 2131363650 */:
                audioRoomFragmentHelp.showLudoGameView();
                return;
            case R.id.pkLayout /* 2131364262 */:
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                if (meetingRoomManager.getMYouTuBe() != null && ((mYouTuBe = meetingRoomManager.getMYouTuBe()) == null || (type2 = mYouTuBe.getType()) == null || type2.intValue() != 4)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954549), null, false, 6, null);
                    return;
                }
                PKInviteCancel mPKGame = meetingRoomManager.getMPKGame();
                if (mPKGame != null && (type = mPKGame.getType()) != null && type.intValue() == 1) {
                    Integer gameId = mPKGame.getGameId();
                    if (gameId != null && gameId.intValue() == 22) {
                        GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomFragmentHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
                        if (groupDetailBean != null && (role = groupDetailBean.getRole()) != null) {
                            i = role.intValue();
                        } else {
                            i = 0;
                        }
                        if (i <= 1) {
                            showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131953290), null, false, 6, null);
                            return;
                        }
                        RoomPK mpk = meetingRoomManager.getMPK();
                        if (mpk != null && !mpk.checkIsInvite()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            RoomPK mpk2 = meetingRoomManager.getMPK();
                            if (mpk2 == null || mpk2.getStatus() != 0) {
                                z2 = false;
                            }
                            if (z2) {
                                new RoomPKInviteDialog(meetingRoomManager.getMPK(), null, 2, null).show(audioRoomFragmentHelp.fragment.getChildFragmentManager(), "RoomPKInviteDialog");
                                return;
                            }
                        }
                        AudioRoomDialogHelp mDialogHelp2 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                        if (mDialogHelp2 != null) {
                            mDialogHelp2.createPKDialog();
                            return;
                        }
                        return;
                    }
                    new RoomPKInviteDialog(null, mPKGame, 1, null).show(audioRoomFragmentHelp.fragment.getChildFragmentManager(), "RoomPKInviteDialog");
                    return;
                }
                return;
            case R.id.room_rocket_enter /* 2131364673 */:
                AudioRoomDialogHelp mDialogHelp3 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp3 != null) {
                    mDialogHelp3.showRocketDialog();
                    return;
                }
                return;
            case R.id.showChat /* 2131364825 */:
                audioRoomFragmentHelp.showFloatChat();
                return;
            case R.id.small_lucky_fruit /* 2131364845 */:
                AudioRoomDialogHelp mDialogHelp4 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp4 != null) {
                    mDialogHelp4.showLuckyFruitDialog();
                    return;
                }
                return;
            case R.id.small_roulette /* 2131364854 */:
                AudioRoomDialogHelp mDialogHelp5 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp5 != null) {
                    mDialogHelp5.setMSmallLuckWheelDialog(false);
                }
                AudioRoomDialogHelp mDialogHelp6 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp6 != null && (mLuckyWheelDialog = mDialogHelp6.getMLuckyWheelDialog()) != null) {
                    mLuckyWheelDialog.show();
                    return;
                }
                return;
            case R.id.taskBtn /* 2131365010 */:
                Context context2 = audioRoomFragmentHelp.fragment.getContext();
                if (context2 != null) {
                    TasksActivity.INSTANCE.start(context2, 0);
                    return;
                }
                return;
            case R.id.unoGame /* 2131365495 */:
                audioRoomFragmentHelp.showUnoGameView();
                return;
            default:
                return;
        }
    }

    private final void initData() {
        int i;
        EnvelopeHelper mEnvelopeHelper;
        ImageView imageView;
        ImageView imageView2;
        AudioGameHelp mGameHelp;
        Pk1v1Help mPk1v1Help;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
        AudioGameHelp mGameHelp2;
        int i2;
        Integer gameType;
        RoomViewModel mViewModel = this.fragment.getMViewModel();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        mViewModel.getGameList(meetingRoomManager.getMGroupId());
        this.fragment.getMViewModel().getDiamondGameList(meetingRoomManager.getMGroupId());
        if (this.mEnterRoomFromSmall) {
            if (meetingRoomManager.getGroupDetailBean() != null) {
                this.fragment.getMViewModel().getMGroupDetailBean().setValue(meetingRoomManager.getGroupDetailBean());
            } else {
                this.fragment.getMViewModel().getRoomInfo();
            }
            RoomPK mpk = meetingRoomManager.getMPK();
            if (mpk != null) {
                i = mpk.getStatus();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.fragment.getMViewModel().requestNewToken(new Function0() { // from class: com.qiahao.nextvideo.room.help.g2
                    public final Object invoke() {
                        Unit initData$lambda$25;
                        initData$lambda$25 = AudioRoomFragmentHelp.initData$lambda$25(AudioRoomFragmentHelp.this);
                        return initData$lambda$25;
                    }
                }, Boolean.TRUE);
            } else {
                checkOtherPK(meetingRoomManager.getMPKGame());
            }
            if (meetingRoomManager.getMHiloGameConfiguration() != null && (mGameHelp2 = this.fragment.getMGameHelp()) != null) {
                GameConfiguration mHiloGameConfiguration = meetingRoomManager.getMHiloGameConfiguration();
                if (mHiloGameConfiguration != null && (gameType = mHiloGameConfiguration.getGameType()) != null) {
                    i2 = gameType.intValue();
                } else {
                    i2 = 0;
                }
                mGameHelp2.showGameView(i2, meetingRoomManager.getMHiloGameConfiguration());
            }
            this.fragment.getMViewModel().setMGroupId(meetingRoomManager.getMGroupId());
            FragmentAudioRoomBinding binding = this.fragment.getBinding();
            if (binding != null && (meetingRoomOnlineMemberLayout = binding.meetingRoomOnlineMember) != null) {
                meetingRoomOnlineMemberLayout.refreshData();
            }
            if (meetingRoomManager.getMLudoGameData() != null) {
                FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                if (binding2 != null && (imageView8 = binding2.ludoGame) != null) {
                    imageView8.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp = this.fragment.getMAudioHelp();
                if (mAudioHelp != null) {
                    mAudioHelp.showLudoGameView();
                }
            }
            if (meetingRoomManager.getMUnoGameData() != null) {
                FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                if (binding3 != null && (imageView7 = binding3.unoGame) != null) {
                    imageView7.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
                if (mAudioHelp2 != null) {
                    mAudioHelp2.showUnoGameView();
                }
            }
            if (meetingRoomManager.getMDominoGameData() != null) {
                FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
                if (binding4 != null && (imageView6 = binding4.dominoGame) != null) {
                    imageView6.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp3 = this.fragment.getMAudioHelp();
                if (mAudioHelp3 != null) {
                    mAudioHelp3.showDominoGameView();
                }
            }
            if (meetingRoomManager.getMCrushGameData() != null) {
                FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
                if (binding5 != null && (imageView5 = binding5.crushGame) != null) {
                    imageView5.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp4 = this.fragment.getMAudioHelp();
                if (mAudioHelp4 != null) {
                    mAudioHelp4.showCrushGameView();
                }
            }
            if (meetingRoomManager.getMBalootGameData() != null) {
                FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
                if (binding6 != null && (imageView4 = binding6.balootGame) != null) {
                    imageView4.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp5 = this.fragment.getMAudioHelp();
                if (mAudioHelp5 != null) {
                    mAudioHelp5.showBalootGameView();
                }
            }
            if (meetingRoomManager.getMCarromGameData() != null) {
                FragmentAudioRoomBinding binding7 = this.fragment.getBinding();
                if (binding7 != null && (imageView3 = binding7.carromGame) != null) {
                    imageView3.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp6 = this.fragment.getMAudioHelp();
                if (mAudioHelp6 != null) {
                    mAudioHelp6.showCarromGameView();
                }
            }
            if (meetingRoomManager.getMPK1v1() != null && (mGameHelp = this.fragment.getMGameHelp()) != null && (mPk1v1Help = mGameHelp.getMPk1v1Help()) != null) {
                mPk1v1Help.showPk1v1();
            }
            if (meetingRoomManager.getMJackaroGameData() != null) {
                FragmentAudioRoomBinding binding8 = this.fragment.getBinding();
                if (binding8 != null && (imageView2 = binding8.jackaroGame) != null) {
                    imageView2.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp7 = this.fragment.getMAudioHelp();
                if (mAudioHelp7 != null) {
                    mAudioHelp7.showJackaroGameView();
                }
            }
            if (meetingRoomManager.getMBackgammonGameData() != null) {
                FragmentAudioRoomBinding binding9 = this.fragment.getBinding();
                if (binding9 != null && (imageView = binding9.backgammonGame) != null) {
                    imageView.setVisibility(0);
                }
                AudioRoomFragmentHelp mAudioHelp8 = this.fragment.getMAudioHelp();
                if (mAudioHelp8 != null) {
                    mAudioHelp8.showBackgammonGameView();
                }
            }
            AudioGameHelp mGameHelp3 = this.fragment.getMGameHelp();
            if (mGameHelp3 != null && (mEnvelopeHelper = mGameHelp3.getMEnvelopeHelper()) != null) {
                mEnvelopeHelper.checkEnvelope(true);
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

    public static final Unit initData$lambda$25(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        audioRoomFragmentHelp.checkPK();
        MeetingRoomManager.INSTANCE.setMicMemberAllRemoteMute(false);
        return Unit.INSTANCE;
    }

    private final void initFromSamllOrEnterLogic() {
        NewMicroView newMicroView;
        if (this.mEnterRoomFromSmall) {
            FragmentAudioRoomBinding binding = this.fragment.getBinding();
            if (binding != null && (newMicroView = binding.microView) != null) {
                newMicroView.notificationMicChange();
            }
            checkChatMic();
            showUserCompleteUpMicTask();
            if (MeetingRoomManager.INSTANCE.getMRoomLuckWheelInfo() != null) {
                RoomViewModel.refreshLuckLyDialog$default(this.fragment.getMViewModel(), false, 1, null);
            }
        }
    }

    private final void initGemRecycleView() {
        RecyclerView recyclerView;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (recyclerView = binding.gameRecycleView) != null) {
            recyclerView.setAdapter(getGameMicAdapter());
        }
        getGameMicAdapter().addChildClickViewIds(new int[]{R.id.base_micro, R.id.lock_micro, R.id.user_mute, 2131365536, R.id.mic_user_head_img, R.id.mic_user_head_svga});
        getGameMicAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.help.x0
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AudioRoomFragmentHelp.initGemRecycleView$lambda$15(AudioRoomFragmentHelp.this, baseQuickAdapter, view, i);
            }
        });
        getGameMicAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.help.i1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AudioRoomFragmentHelp.initGemRecycleView$lambda$16(AudioRoomFragmentHelp.this, baseQuickAdapter, view, i);
            }
        });
    }

    public static final void initGemRecycleView$lambda$15(AudioRoomFragmentHelp audioRoomFragmentHelp, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        AudioRoomDialogHelp mDialogHelp;
        Integer touristMic;
        String externalId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        final MicroBean microBean = (MicroBean) audioRoomFragmentHelp.getGameMicAdapter().getData().get(i);
        final int i2 = i + 1;
        String str = "";
        switch (view.getId()) {
            case R.id.base_micro /* 2131362072 */:
                showToastOrLog$default(audioRoomFragmentHelp, null, "initGemRecycleView: " + i + " 麦位点击", false, 5, null);
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null && (externalId = user.getExternalId()) != null) {
                    str = externalId;
                }
                int roomUserRole = meetingRoomManager.getRoomUserRole(str);
                int i3 = 1;
                if (roomUserRole > 1) {
                    AudioRoomDialogHelp mDialogHelp2 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                    if (mDialogHelp2 != null) {
                        mDialogHelp2.showMicOperateBottomDialog(i2, microBean, true);
                        return;
                    }
                    return;
                }
                if (FastClickUtils.INSTANCE.isFastClick() && !meetingRoomManager.isMySelfOnMic() && (mDialogHelp = audioRoomFragmentHelp.fragment.getMDialogHelp()) != null) {
                    GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomFragmentHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean != null && (touristMic = groupDetailBean.getTouristMic()) != null) {
                        i3 = touristMic.intValue();
                    }
                    mDialogHelp.checkTouristRole(i3, new Function0() { // from class: com.qiahao.nextvideo.room.help.p2
                        public final Object invoke() {
                            Unit initGemRecycleView$lambda$15$lambda$14;
                            initGemRecycleView$lambda$15$lambda$14 = AudioRoomFragmentHelp.initGemRecycleView$lambda$15$lambda$14(AudioRoomFragmentHelp.this, i2, microBean);
                            return initGemRecycleView$lambda$15$lambda$14;
                        }
                    });
                    return;
                }
                return;
            case R.id.lock_micro /* 2131363625 */:
                AudioRoomDialogHelp mDialogHelp3 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp3 != null) {
                    mDialogHelp3.showMicOperateBottomDialog(i2, microBean, false);
                    return;
                }
                return;
            case R.id.mic_user_head_img /* 2131363866 */:
            case R.id.mic_user_head_svga /* 2131363868 */:
            case 2131365536:
            case R.id.user_mute /* 2131365556 */:
                showToastOrLog$default(audioRoomFragmentHelp, null, "initGemRecycleView: " + i + " 用户头像点击", false, 5, null);
                AudioRoomDialogHelp mDialogHelp4 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp4 != null) {
                    String externalId2 = microBean.getExternalId();
                    if (externalId2 != null) {
                        str = externalId2;
                    }
                    mDialogHelp4.showUserInfoDialog(str, i2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static final Unit initGemRecycleView$lambda$15$lambda$14(AudioRoomFragmentHelp audioRoomFragmentHelp, final int i, final MicroBean microBean) {
        audioRoomFragmentHelp.fragment.checkMicrophonePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.a1
            public final Object invoke() {
                Unit initGemRecycleView$lambda$15$lambda$14$lambda$13;
                initGemRecycleView$lambda$15$lambda$14$lambda$13 = AudioRoomFragmentHelp.initGemRecycleView$lambda$15$lambda$14$lambda$13(AudioRoomFragmentHelp.this, i, microBean);
                return initGemRecycleView$lambda$15$lambda$14$lambda$13;
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit initGemRecycleView$lambda$15$lambda$14$lambda$13(AudioRoomFragmentHelp audioRoomFragmentHelp, int i, MicroBean microBean) {
        RoomViewModel.upMic$default(audioRoomFragmentHelp.fragment.getMViewModel(), Integer.valueOf(i), null, microBean.getMicForbid(), 2, null);
        return Unit.INSTANCE;
    }

    public static final void initGemRecycleView$lambda$16(AudioRoomFragmentHelp audioRoomFragmentHelp, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MicroBean microBean = (MicroBean) audioRoomFragmentHelp.getGameMicAdapter().getData().get(i);
        int i2 = i + 1;
        showToastOrLog$default(audioRoomFragmentHelp, null, "initGemRecycleView: " + i + " 用户头像点击", false, 5, null);
        AudioRoomDialogHelp mDialogHelp = audioRoomFragmentHelp.fragment.getMDialogHelp();
        if (mDialogHelp != null) {
            String externalId = microBean.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            mDialogHelp.showUserInfoDialog(externalId, i2);
        }
    }

    private final void initObserve() {
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (lightQueueCombinationPlayer = binding.queuePlayer) != null) {
            lightQueueCombinationPlayer.bindingLifeCycle(this.fragment);
        }
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = AudioRoomFragmentHelp.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.registerListener(name, new MessageDataListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$1
            @Override // com.qiahao.nextvideo.ui.im.MessageDataListener
            public void messageDataListener(ArrayList<MessageListInfo> listMessageDate, int unReadMessage, boolean isFinished) {
                RoomMessageViewBinding messageBinding;
                RoomInputView roomInputView;
                RoomMessageViewBinding messageBinding2;
                RoomInputView roomInputView2;
                Intrinsics.checkNotNullParameter(listMessageDate, "listMessageDate");
                if (unReadMessage > 0) {
                    RoomMessageView mChatLayout = AudioRoomFragmentHelp.this.getFragment().getMChatLayout();
                    if (mChatLayout != null && (messageBinding2 = mChatLayout.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
                        roomInputView2.hasNewMessage(true);
                        return;
                    }
                    return;
                }
                RoomMessageView mChatLayout2 = AudioRoomFragmentHelp.this.getFragment().getMChatLayout();
                if (mChatLayout2 != null && (messageBinding = mChatLayout2.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
                    roomInputView.hasNewMessage(false);
                }
            }
        });
        BuildersKt.launch$default(this.fragmentScope, Dispatchers.getMain(), (CoroutineStart) null, new AudioRoomFragmentHelp$initObserve$2(this, null), 2, (Object) null);
        BuildersKt.launch$default(this.fragmentScope, Dispatchers.getMain(), (CoroutineStart) null, new AudioRoomFragmentHelp$initObserve$3(this, null), 2, (Object) null);
        this.fragment.getMViewModel().getMGroupDetailBean().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.c1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$40;
                initObserve$lambda$40 = AudioRoomFragmentHelp.initObserve$lambda$40(AudioRoomFragmentHelp.this, (GroupDetailBean) obj);
                return initObserve$lambda$40;
            }
        }));
        this.fragment.getMViewModel().getMRoomLuckWheelInfo().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.f1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$41;
                initObserve$lambda$41 = AudioRoomFragmentHelp.initObserve$lambda$41(AudioRoomFragmentHelp.this, (LuckWheelInfo) obj);
                return initObserve$lambda$41;
            }
        }));
        this.fragment.getMViewModel().getMGetRoomMicType().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.g1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$42;
                initObserve$lambda$42 = AudioRoomFragmentHelp.initObserve$lambda$42(AudioRoomFragmentHelp.this, (Integer) obj);
                return initObserve$lambda$42;
            }
        }));
        this.fragment.getMViewModel().getMMicOperationResponse().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.h1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$43;
                initObserve$lambda$43 = AudioRoomFragmentHelp.initObserve$lambda$43(AudioRoomFragmentHelp.this, (Pair) obj);
                return initObserve$lambda$43;
            }
        }));
        this.fragment.getMViewModel().getMEnterRoomAutoUpMicBean().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.j1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$44;
                initObserve$lambda$44 = AudioRoomFragmentHelp.initObserve$lambda$44(AudioRoomFragmentHelp.this, (AutoInviteUserUpMicBean) obj);
                return initObserve$lambda$44;
            }
        }));
        this.fragment.getMViewModel().getMBannerList().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.k1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$45;
                initObserve$lambda$45 = AudioRoomFragmentHelp.initObserve$lambda$45(AudioRoomFragmentHelp.this, (List) obj);
                return initObserve$lambda$45;
            }
        }));
        this.fragment.getMViewModel().getMRoomShowSelectLuckWheelDialog().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.l1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$48;
                initObserve$lambda$48 = AudioRoomFragmentHelp.initObserve$lambda$48(AudioRoomFragmentHelp.this, (Boolean) obj);
                return initObserve$lambda$48;
            }
        }));
        this.fragment.getMViewModel().getMRoomPasswordError().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.m1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$50;
                initObserve$lambda$50 = AudioRoomFragmentHelp.initObserve$lambda$50(AudioRoomFragmentHelp.this, (Boolean) obj);
                return initObserve$lambda$50;
            }
        }));
        this.fragment.getMViewModel().getMException().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.n1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$54;
                initObserve$lambda$54 = AudioRoomFragmentHelp.initObserve$lambda$54(AudioRoomFragmentHelp.this, (Pair) obj);
                return initObserve$lambda$54;
            }
        }));
        this.fragment.getMViewModel().getMRocketRoomSmallBean().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.o1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$55;
                initObserve$lambda$55 = AudioRoomFragmentHelp.initObserve$lambda$55(AudioRoomFragmentHelp.this, (RocketRoomSmallBean) obj);
                return initObserve$lambda$55;
            }
        }));
        this.fragment.getMViewModel().getMRocketResultSvgaBean().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.d1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$56;
                initObserve$lambda$56 = AudioRoomFragmentHelp.initObserve$lambda$56(AudioRoomFragmentHelp.this, (Pair) obj);
                return initObserve$lambda$56;
            }
        }));
        this.fragment.getMViewModel().getMDiamondGameList().observe(this.fragment, new AudioRoomFragmentHelp$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.help.e1
            public final Object invoke(Object obj) {
                Unit initObserve$lambda$58;
                initObserve$lambda$58 = AudioRoomFragmentHelp.initObserve$lambda$58(AudioRoomFragmentHelp.this, (ArrayList) obj);
                return initObserve$lambda$58;
            }
        }));
    }

    public static final Unit initObserve$lambda$40(AudioRoomFragmentHelp audioRoomFragmentHelp, GroupDetailBean groupDetailBean) {
        if (audioRoomFragmentHelp.fragment.checkMicPermission()) {
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.p1
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRoomFragmentHelp.initObserve$lambda$40$lambda$37();
                }
            }, 1000L);
        }
        try {
            if (audioRoomFragmentHelp.mCurrentEnter && !audioRoomFragmentHelp.mEnterRoomFromSmall) {
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                if (meetingRoomManager.getLocalRoomMicStatus() && groupDetailBean.getMicOn()) {
                    showToastOrLog$default(audioRoomFragmentHelp, null, "进群获取群信息后--3秒弹出邀请上麦", false, 5, null);
                    Handler handler = audioRoomFragmentHelp.mHandler;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(6, FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
                    }
                    LuckWheelInfo luckyWheel = groupDetailBean.getLuckyWheel();
                    if (luckyWheel != null) {
                        RoomViewModel.updateLuckyWheelInfo$default(audioRoomFragmentHelp.fragment.getMViewModel(), luckyWheel, false, 2, null);
                    }
                    List<RoomRuleBean> roleMembers = groupDetailBean.getRoleMembers();
                    if (roleMembers != null) {
                        meetingRoomManager.setMRoomUserRoleList((ArrayList) roleMembers);
                    }
                }
                audioRoomFragmentHelp.addUserEnterRoomAnimator();
            }
            Intrinsics.checkNotNull(groupDetailBean);
            audioRoomFragmentHelp.initView(groupDetailBean);
            audioRoomFragmentHelp.mCurrentEnter = false;
        } catch (Exception unused) {
            showToastOrLog$default(audioRoomFragmentHelp, null, "fragment.mViewModel.mGroupDetailBean.observe异常", false, 5, null);
        }
        return Unit.INSTANCE;
    }

    public static final void initObserve$lambda$40$lambda$37() {
        cf.c.c().l(new ChatRoomStatusEvent("start_service", (Object) null, 2, (DefaultConstructorMarker) null));
    }

    public static final Unit initObserve$lambda$41(AudioRoomFragmentHelp audioRoomFragmentHelp, LuckWheelInfo luckWheelInfo) {
        AudioRoomDialogHelp mDialogHelp = audioRoomFragmentHelp.fragment.getMDialogHelp();
        if (mDialogHelp != null) {
            mDialogHelp.showLuckyDialog(luckWheelInfo);
        }
        return Unit.INSTANCE;
    }

    public static final Unit initObserve$lambda$42(AudioRoomFragmentHelp audioRoomFragmentHelp, Integer num) {
        Integer num2;
        NewMicroView newMicroView;
        NewMicroView newMicroView2;
        FragmentAudioRoomBinding binding = audioRoomFragmentHelp.fragment.getBinding();
        if (binding != null && (newMicroView2 = binding.microView) != null) {
            num2 = Integer.valueOf(newMicroView2.getMMicType());
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num2, num)) {
            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 修改麦位类型", true, 1, null);
            FragmentAudioRoomBinding binding2 = audioRoomFragmentHelp.fragment.getBinding();
            if (binding2 != null && (newMicroView = binding2.microView) != null) {
                Intrinsics.checkNotNull(num);
                newMicroView.changeMicType(num.intValue());
            }
            AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
            if (mGameHelp != null) {
                mGameHelp.changeGameMicType();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final Unit initObserve$lambda$43(AudioRoomFragmentHelp audioRoomFragmentHelp, Pair pair) {
        UnoGameHelp mUnoHelp;
        CrushGameHelp mCrushHelp;
        LudoGameHelp mLudoHelp;
        BackgammonGameHelp mBackgammonGameHelp;
        BalootGameHelp mBalootHelp;
        JackaroGameHelp mJackaroGameHelp;
        CarromGameHelp mCarromGameHelp;
        DominoGameHelp mDominoHelp;
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -838984029:
                if (str.equals(RoomViewModel.INTERFACE_UP_MIC)) {
                    String str2 = (String) pair.getSecond();
                    switch (str2.hashCode()) {
                        case -2102077607:
                            if (str2.equals(RoomViewModel.MIC_JOIN_UNO)) {
                                AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp != null && (mUnoHelp = mGameHelp.getMUnoHelp()) != null) {
                                    mUnoHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -1956674517:
                            if (str2.equals(RoomViewModel.MIC_CREATE_UNO)) {
                                AudioRoomDialogHelp mDialogHelp = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp != null) {
                                    mDialogHelp.callCreate(2);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -1815909845:
                            if (str2.equals(RoomViewModel.MIC_CREATE_BACKGAMMON)) {
                                AudioRoomDialogHelp mDialogHelp2 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp2 != null) {
                                    mDialogHelp2.callCreate(23);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -1478445986:
                            if (str2.equals(RoomViewModel.MIC_JOIN_CRUSH)) {
                                AudioGameHelp mGameHelp2 = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp2 != null && (mCrushHelp = mGameHelp2.getMCrushHelp()) != null) {
                                    mCrushHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -740157999:
                            if (str2.equals(RoomViewModel.MIC_JOIN_LUDO)) {
                                AudioGameHelp mGameHelp3 = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp3 != null && (mLudoHelp = mGameHelp3.getMLudoHelp()) != null) {
                                    mLudoHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -550333422:
                            if (str2.equals(RoomViewModel.MIC_CREATE_BALOOT)) {
                                AudioRoomDialogHelp mDialogHelp3 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp3 != null) {
                                    mDialogHelp3.callCreate(14);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -527629505:
                            if (str2.equals(RoomViewModel.MIC_CREATE_LUDO)) {
                                AudioRoomDialogHelp mDialogHelp4 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp4 != null) {
                                    mDialogHelp4.callCreate(1);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -521522649:
                            if (str2.equals(RoomViewModel.MIC_CREATE_CARROM)) {
                                AudioRoomDialogHelp mDialogHelp5 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp5 != null) {
                                    mDialogHelp5.callCreate(18);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case -480121837:
                            if (str2.equals(RoomViewModel.MIC_CREATE_DOMINO)) {
                                AudioRoomDialogHelp mDialogHelp6 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp6 != null) {
                                    mDialogHelp6.callCreate(10);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case 206367771:
                            if (str2.equals(RoomViewModel.MIC_CREATE_JACKAROO)) {
                                AudioRoomDialogHelp mDialogHelp7 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp7 != null) {
                                    mDialogHelp7.callCreate(21);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case 814970032:
                            if (str2.equals(RoomViewModel.MIC_CREATE_CRUSH)) {
                                AudioRoomDialogHelp mDialogHelp8 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                                if (mDialogHelp8 != null) {
                                    mDialogHelp8.callCreate(11);
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case 1322305341:
                            if (str2.equals(RoomViewModel.MIC_JOIN_BACKGAMMON)) {
                                AudioGameHelp mGameHelp4 = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp4 != null && (mBackgammonGameHelp = mGameHelp4.getMBackgammonGameHelp()) != null) {
                                    mBackgammonGameHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case 1368214052:
                            if (str2.equals(RoomViewModel.MIC_JOIN_BALOOT)) {
                                AudioGameHelp mGameHelp5 = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp5 != null && (mBalootHelp = mGameHelp5.getMBalootHelp()) != null) {
                                    mBalootHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case 1389520301:
                            if (str2.equals(RoomViewModel.MIC_JOIN_JACKAROO)) {
                                AudioGameHelp mGameHelp6 = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp6 != null && (mJackaroGameHelp = mGameHelp6.getMJackaroGameHelp()) != null) {
                                    mJackaroGameHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case 1397024825:
                            if (str2.equals(RoomViewModel.MIC_JOIN_CARROM)) {
                                AudioGameHelp mGameHelp7 = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp7 != null && (mCarromGameHelp = mGameHelp7.getMCarromGameHelp()) != null) {
                                    mCarromGameHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        case 1438425637:
                            if (str2.equals(RoomViewModel.MIC_JOIN_DOMINO)) {
                                AudioGameHelp mGameHelp8 = audioRoomFragmentHelp.fragment.getMGameHelp();
                                if (mGameHelp8 != null && (mDominoHelp = mGameHelp8.getMDominoHelp()) != null) {
                                    mDominoHelp.playerJoin();
                                    break;
                                }
                            }
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                        default:
                            showToastOrLog$default(audioRoomFragmentHelp, null, "initObserve: 上麦成功", true, 1, null);
                            break;
                    }
                }
                break;
            case 868709153:
                if (str.equals(RoomViewModel.INTERFACE_MUTE_MIC)) {
                    audioRoomFragmentHelp.showToastOrLog(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954177), "initObserve: 静音成功", true);
                    break;
                }
                break;
            case 1027666439:
                if (str.equals(RoomViewModel.INTERFACE_UN_MUTE_MIC)) {
                    audioRoomFragmentHelp.showToastOrLog(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954177), "initObserve: 开音成功", true);
                    break;
                }
                break;
            case 1184836679:
                if (str.equals(RoomAndPersonalTaskViewModel.COMMON_TIP)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954177), null, false, 6, null);
                    break;
                }
                break;
            case 1195528563:
                if (str.equals(RoomViewModel.INTERFACE_DELETE_MESSAGE)) {
                    audioRoomFragmentHelp.showToastOrLog(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954177), "initObserve: 删除消息成功", true);
                    break;
                }
                break;
            case 1427429674:
                if (str.equals(RoomViewModel.INTERFACE_DOWN_MIC)) {
                    audioRoomFragmentHelp.showToastOrLog(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954177), "initObserve: 下麦成功", true);
                    break;
                }
                break;
            case 1909656883:
                if (str.equals(RoomViewModel.INTERFACE_LOCK_MIC)) {
                    audioRoomFragmentHelp.showToastOrLog(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954177), "initObserve: 锁麦成功", true);
                    break;
                }
                break;
            case 2068614169:
                if (str.equals(RoomViewModel.INTERFACE_UN_LOCK_MIC)) {
                    audioRoomFragmentHelp.showToastOrLog(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954177), "initObserve: 解麦成功", true);
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public static final Unit initObserve$lambda$44(AudioRoomFragmentHelp audioRoomFragmentHelp, AutoInviteUserUpMicBean autoInviteUserUpMicBean) {
        String str;
        if (autoInviteUserUpMicBean.getFlag()) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomFragmentHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean == null || (str = groupDetailBean.getName()) == null) {
                str = "";
            }
            int type = autoInviteUserUpMicBean.getType();
            if (type != 1) {
                if (type != 2) {
                    AudioRoomDialogHelp mDialogHelp = audioRoomFragmentHelp.fragment.getMDialogHelp();
                    if (mDialogHelp != null) {
                        String format = String.format(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954389), Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        mDialogHelp.showInviteUserUpDialog(format);
                    }
                } else {
                    audioRoomFragmentHelp.inviteUserUpMicToCompeleReward(autoInviteUserUpMicBean.getDiamondNum());
                }
            } else {
                AudioRoomDialogHelp mDialogHelp2 = audioRoomFragmentHelp.fragment.getMDialogHelp();
                if (mDialogHelp2 != null) {
                    String format2 = String.format(ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131954389), Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    mDialogHelp2.showInviteUserUpDialog(format2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit initObserve$lambda$45(AudioRoomFragmentHelp audioRoomFragmentHelp, List list) {
        LinearLayoutCompat linearLayoutCompat;
        FragmentAudioRoomBinding binding;
        FrameLayout frameLayout;
        GroupBannerView groupBannerView;
        LinearLayoutCompat linearLayoutCompat2;
        Intrinsics.checkNotNull(list);
        if (!list.isEmpty() && (binding = audioRoomFragmentHelp.fragment.getBinding()) != null && (frameLayout = binding.pk1v1) != null && frameLayout.getChildCount() == 0) {
            FragmentAudioRoomBinding binding2 = audioRoomFragmentHelp.fragment.getBinding();
            if (binding2 != null && (linearLayoutCompat2 = binding2.groupBanner) != null) {
                linearLayoutCompat2.setVisibility(0);
            }
            FragmentAudioRoomBinding binding3 = audioRoomFragmentHelp.fragment.getBinding();
            if (binding3 != null && (groupBannerView = binding3.groupBanner) != null) {
                groupBannerView.setData(list);
            }
        } else {
            FragmentAudioRoomBinding binding4 = audioRoomFragmentHelp.fragment.getBinding();
            if (binding4 != null && (linearLayoutCompat = binding4.groupBanner) != null) {
                linearLayoutCompat.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.qiahao.nextvideo.room.dialog.LuckyWheelSelectDialog, android.app.Dialog] */
    public static final Unit initObserve$lambda$48(AudioRoomFragmentHelp audioRoomFragmentHelp, Boolean bool) {
        if (bool.booleanValue()) {
            showToastOrLog$default(audioRoomFragmentHelp, null, "LucklyWheel observe 展示选择创建的游戏框", false, 5, null);
            final FragmentActivity activity = audioRoomFragmentHelp.fragment.getActivity();
            if (activity != null) {
                ?? luckyWheelSelectDialog = new LuckyWheelSelectDialog(activity, audioRoomFragmentHelp.fragment.getMViewModel().getMGroupId());
                luckyWheelSelectDialog.setMLuckyWheelSelectListener(new LuckyWheelSelectListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$10$1$luckyWheelSelectDialog$1$1
                    @Override // com.qiahao.nextvideo.room.dialog.LuckyWheelSelectListener
                    public void createLuckyWheel(boolean autoRestart, boolean selfJoin, int lastId, int diamond) {
                        double d;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null) {
                            d = user.getDiamondNum();
                        } else {
                            d = 0.0d;
                        }
                        if (d >= diamond) {
                            AudioRoomFragmentHelp.this.getFragment().getMViewModel().createLuckyWheel(autoRestart, selfJoin, lastId);
                        } else {
                            WalletActivity.INSTANCE.start(activity);
                        }
                    }
                });
                AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
                if (mGameHelp != null && !mGameHelp.checkGameIsShow()) {
                    luckyWheelSelectDialog.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit initObserve$lambda$50(AudioRoomFragmentHelp audioRoomFragmentHelp, Boolean bool) {
        String mGroupId = audioRoomFragmentHelp.fragment.getMViewModel().getMGroupId();
        audioRoomFragmentHelp.fragment.getMViewModel().setMGroupId("");
        MeetingRoomManager.leaveRoom$default(MeetingRoomManager.INSTANCE, false, 1, null);
        FragmentActivity activity = audioRoomFragmentHelp.fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            new JoinLockRoomBottomDialog(activity, mGroupId, null, 0, null, null, null, null, null, null, 0, true, 2040, null).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r14v15, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final Unit initObserve$lambda$54(AudioRoomFragmentHelp audioRoomFragmentHelp, Pair pair) {
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -838984029:
                if (str.equals(RoomViewModel.INTERFACE_UP_MIC)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667), "initObserve: 失败" + ((Throwable) pair.getSecond()).getLocalizedMessage(), false, 4, null);
                    break;
                }
                break;
            case -818431518:
                if (str.equals(RoomViewModel.INTERFACE_ENTER_ROOM)) {
                    showToastOrLog$default(audioRoomFragmentHelp, null, "MeetingRoofragment.mViewModel.INTERFACE_ENTER_ROOM 调用MeetingRoomManager的LeaveRoom()", false, 5, null);
                    AudioRoomFragment.leaveRoom$default(audioRoomFragmentHelp.fragment, false, 1, null);
                    break;
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
                                    Context context = audioRoomFragmentHelp.fragment.getContext();
                                    String message = hiloException.getMessage();
                                    if (message == null) {
                                        message = ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667);
                                    }
                                    Toast normal = companion.normal(context, message, false);
                                    if (normal != null) {
                                        normal.show();
                                        break;
                                    }
                                } else {
                                    FragmentActivity activity = audioRoomFragmentHelp.fragment.getActivity();
                                    if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                                        new VipViewDialog(4, activity).show();
                                        break;
                                    }
                                }
                            } else {
                                FragmentActivity activity2 = audioRoomFragmentHelp.fragment.getActivity();
                                if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
                                    ?? commonTextDialog = new CommonTextDialog(activity2, 0.0f, 2, null);
                                    commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953025), true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$12$1$1$1
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
                            Toast normal2 = HiloToasty.Companion.normal(audioRoomFragmentHelp.fragment.getContext(), ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952092), false);
                            if (normal2 != null) {
                                normal2.show();
                                break;
                            }
                        }
                    } else {
                        HiloToasty.Companion companion2 = HiloToasty.Companion;
                        Context context2 = audioRoomFragmentHelp.fragment.getContext();
                        String message2 = hiloException.getMessage();
                        if (message2 == null) {
                            message2 = ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131953606);
                        }
                        Toast normal3 = companion2.normal(context2, message2, false);
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
                        errorMessage = ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667);
                    }
                    showToastOrLog$default(audioRoomFragmentHelp, errorMessage, "initObserve: 送礼失败", false, 4, null);
                    break;
                }
                break;
            case 868709153:
                if (str.equals(RoomViewModel.INTERFACE_MUTE_MIC)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667), "initObserve: 静音失败", false, 4, null);
                    break;
                }
                break;
            case 1027666439:
                if (str.equals(RoomViewModel.INTERFACE_UN_MUTE_MIC)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667), "initObserve: 开音失败", false, 4, null);
                    break;
                }
                break;
            case 1184836679:
                if (str.equals(RoomAndPersonalTaskViewModel.COMMON_TIP)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667), null, false, 6, null);
                    break;
                }
                break;
            case 1195528563:
                if (str.equals(RoomViewModel.INTERFACE_DELETE_MESSAGE)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667), "initObserve: 删除消息失败", false, 4, null);
                    break;
                }
                break;
            case 1427429674:
                if (str.equals(RoomViewModel.INTERFACE_DOWN_MIC) && (pair.getSecond() instanceof HiloException)) {
                    Object second3 = pair.getSecond();
                    Intrinsics.checkNotNull(second3, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                    String errorMessage2 = ((HiloException) second3).getErrorMessage();
                    if (errorMessage2 == null) {
                        errorMessage2 = ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667);
                    }
                    showToastOrLog$default(audioRoomFragmentHelp, errorMessage2, "initObserve: 下麦失败", false, 4, null);
                    break;
                }
                break;
            case 1909656883:
                if (str.equals(RoomViewModel.INTERFACE_LOCK_MIC)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667), "initObserve: 锁麦失败", false, 4, null);
                    break;
                }
                break;
            case 2068614169:
                if (str.equals(RoomViewModel.INTERFACE_UN_LOCK_MIC)) {
                    showToastOrLog$default(audioRoomFragmentHelp, ResourcesKtxKt.getStringById(audioRoomFragmentHelp, 2131952667), "initObserve: 解麦失败", false, 4, null);
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public static final Unit initObserve$lambda$55(AudioRoomFragmentHelp audioRoomFragmentHelp, RocketRoomSmallBean rocketRoomSmallBean) {
        RoomRocketEnterView roomRocketEnterView;
        FragmentAudioRoomBinding binding = audioRoomFragmentHelp.fragment.getBinding();
        if (binding != null && (roomRocketEnterView = binding.roomRocketEnter) != null) {
            Intrinsics.checkNotNull(rocketRoomSmallBean);
            roomRocketEnterView.setData(rocketRoomSmallBean);
        }
        return Unit.INSTANCE;
    }

    public static final Unit initObserve$lambda$56(AudioRoomFragmentHelp audioRoomFragmentHelp, Pair pair) {
        FragmentAudioRoomBinding binding;
        RocketSvgaCountdownView rocketSvgaCountdownView;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.checkShowEffect() && meetingRoomManager.isShowRocketEffect() && (binding = audioRoomFragmentHelp.fragment.getBinding()) != null && (rocketSvgaCountdownView = binding.rocketSvga) != null) {
            rocketSvgaCountdownView.setData((List) pair.getSecond(), ((Boolean) pair.getFirst()).booleanValue());
        }
        return Unit.INSTANCE;
    }

    public static final Unit initObserve$lambda$58(AudioRoomFragmentHelp audioRoomFragmentHelp, ArrayList arrayList) {
        ImageView imageView;
        ImageView imageView2;
        if (MeetingRoomManager.INSTANCE.isCanShowSmallLuckyRouletteOrBox()) {
            int intValue = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "LAST_DIAMOND_GAME", 7, (String) null, 4, (Object) null)).intValue();
            Intrinsics.checkNotNull(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GameConfiguration gameConfiguration = (GameConfiguration) it.next();
                Integer gameId = gameConfiguration.getGameId();
                if (gameId != null && gameId.intValue() == intValue && MeetingRoomManager.INSTANCE.isLuckyGame(intValue)) {
                    FragmentAudioRoomBinding binding = audioRoomFragmentHelp.fragment.getBinding();
                    if (binding != null && (imageView2 = binding.diamondGame) != null) {
                        imageView2.setVisibility(0);
                    }
                    FragmentAudioRoomBinding binding2 = audioRoomFragmentHelp.fragment.getBinding();
                    if (binding2 != null && (imageView = binding2.diamondGame) != null) {
                        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(gameConfiguration.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void initRocket() {
        RocketSvgaCountdownView rocketSvgaCountdownView;
        this.fragment.getMViewModel().getRocketEnterData();
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (rocketSvgaCountdownView = binding.rocketSvga) != null) {
            rocketSvgaCountdownView.setListener(new RocketSvgaCountdownViewListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initRocket$1
                @Override // com.qiahao.nextvideo.room.view.RocketSvgaCountdownViewListener
                public void rocketViewSvgaOrCountdown(MyAward myAward) {
                    Context context;
                    if (myAward != null && (context = AudioRoomFragmentHelp.this.getFragment().getContext()) != null) {
                        FragmentActivity activity = AudioRoomFragmentHelp.this.getFragment().getActivity();
                        if ((activity == null || !activity.isFinishing()) && MeetingRoomManager.INSTANCE.isShowRocketEffect()) {
                            MaxDialogUtils.INSTANCE.showDialog(new RoomRocketRewardDialog(context, myAward));
                        }
                    }
                }
            });
        }
        this.fragment.getMViewModel().getRocketSvgaCountDown(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x017f, code lost:
    
        if (r6 != null) goto L٣٥٥;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView(GroupDetailBean groupDetailBean) {
        ImageView imageView;
        ImageView imageView2;
        int i;
        ImageView imageView3;
        TextView textView;
        FragmentAudioRoomBinding binding;
        FragmentAudioRoomBinding binding2;
        AudioGameHelp mGameHelp;
        FragmentAudioRoomBinding binding3;
        FragmentAudioRoomBinding binding4;
        FragmentAudioRoomBinding binding5;
        ImageView imageView4;
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        ImageView imageView5;
        AudioGameHelp mGameHelp2;
        boolean z;
        FragmentAudioRoomBinding binding6;
        final FrameLayout frameLayout;
        int i2;
        ImageView imageView6;
        AlphaAnimation alphaAnimation;
        FragmentAudioRoomBinding binding7;
        ImageView imageView7;
        ImageView imageView8;
        boolean z2;
        RoomMessageViewBinding messageBinding2;
        RoomInputView roomInputView2;
        ImageView imageView9;
        NewMicroView newMicroView;
        int i3;
        NewMicroView newMicroView2;
        RoomMessageViewBinding messageBinding3;
        RoomInputView roomInputView3;
        ImageView imageView10;
        ImageView imageView11;
        MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
        Long totalConsume;
        long j;
        ShineTextView shineTextView;
        NickTextView nickTextView;
        User owner;
        int i4;
        SvipData svip;
        int i5;
        SvipData svip2;
        NewMicroView newMicroView3;
        User owner2;
        int i6;
        SvipData svip3;
        ImageView imageView12;
        TextView textView2;
        TextView textView3;
        Integer num;
        ImageView imageView13;
        ImageView imageView14;
        Drawable drawable;
        SvipData svip4;
        SvipData svip5;
        RoundedImageView roundedImageView;
        boolean z3 = false;
        refreshGoldView(groupDetailBean);
        checkPlayLayout();
        List<GroupTopBannerBean> banners = groupDetailBean.getBanners();
        if (banners != null && !banners.isEmpty()) {
            this.fragment.getMViewModel().getMBannerList().postValue(banners);
        }
        List<GroupMedalBean> groupMedals = groupDetailBean.getGroupMedals();
        if (groupMedals != null && !groupMedals.isEmpty()) {
            showGroupMedalView(groupMedals);
        }
        FragmentAudioRoomBinding binding8 = this.fragment.getBinding();
        if (binding8 != null && (roundedImageView = binding8.meetingAvatar) != null) {
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String faceUrl = groupDetailBean.getFaceUrl();
            ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            fill.setWidth(dimens.dpToPx(30));
            fill.setHeight(dimens.dpToPx(30));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind(roundedImageView, companion.displayImage(faceUrl, fill));
        }
        String groupHeadwear = groupDetailBean.getGroupHeadwear();
        if (groupHeadwear != null && StringKtxKt.checkEndSVGA(groupHeadwear)) {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(groupDetailBean.getGroupHeadwear()), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initView$4
                public void onComplete(SVGAVideoEntity videoItem) {
                    SVGAImageView sVGAImageView;
                    SVGAImageView sVGAImageView2;
                    SVGAImageView sVGAImageView3;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    FragmentAudioRoomBinding binding9 = AudioRoomFragmentHelp.this.getFragment().getBinding();
                    if (binding9 != null && (sVGAImageView3 = binding9.roomSvga) != null) {
                        sVGAImageView3.stopAnimation(true);
                    }
                    FragmentAudioRoomBinding binding10 = AudioRoomFragmentHelp.this.getFragment().getBinding();
                    if (binding10 != null && (sVGAImageView2 = binding10.roomSvga) != null) {
                        sVGAImageView2.setImageDrawable(new SVGADrawable(videoItem));
                    }
                    FragmentAudioRoomBinding binding11 = AudioRoomFragmentHelp.this.getFragment().getBinding();
                    if (binding11 != null && (sVGAImageView = binding11.roomSvga) != null) {
                        sVGAImageView.startAnimation();
                    }
                }

                public void onError() {
                }
            });
        } else {
            String groupHeadwear2 = groupDetailBean.getGroupHeadwear();
            if (groupHeadwear2 != null && groupHeadwear2.length() > 0) {
                FragmentAudioRoomBinding binding9 = this.fragment.getBinding();
                if (binding9 != null && (imageView2 = binding9.roomImageHead) != null) {
                    String groupHeadwear3 = groupDetailBean.getGroupHeadwear();
                    if (groupHeadwear3 == null) {
                        groupHeadwear3 = "";
                    }
                    ImageKtxKt.loadImage$default(imageView2, groupHeadwear3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                }
                FragmentAudioRoomBinding binding10 = this.fragment.getBinding();
                if (binding10 != null && (imageView = binding10.roomImageHead) != null) {
                    imageView.setVisibility(0);
                }
            }
        }
        supportLevelShow(groupDetailBean);
        User owner3 = groupDetailBean.getOwner();
        if (owner3 != null && (svip5 = owner3.getSvip()) != null) {
            i = svip5.getSvipLevel();
        } else {
            i = 0;
        }
        Integer num2 = null;
        if (i > 0) {
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            User owner4 = groupDetailBean.getOwner();
            if (owner4 != null && (svip4 = owner4.getSvip()) != null) {
                num = Integer.valueOf(svip4.getSvipLevel());
            } else {
                num = null;
            }
            Integer svipType = svipTypeUtils.getSvipType(num);
            if (svipType != null) {
                int intValue = svipType.intValue();
                FragmentAudioRoomBinding binding11 = this.fragment.getBinding();
                if (binding11 != null && (imageView14 = binding11.svipType) != null) {
                    Context context = this.fragment.getContext();
                    if (context != null) {
                        drawable = androidx.core.content.a.getDrawable(context, intValue);
                    } else {
                        drawable = null;
                    }
                    imageView14.setImageDrawable(drawable);
                }
                FragmentAudioRoomBinding binding12 = this.fragment.getBinding();
                if (binding12 != null && (imageView13 = binding12.svipType) != null) {
                    imageView13.setVisibility(0);
                }
            }
        } else {
            FragmentAudioRoomBinding binding13 = this.fragment.getBinding();
            if (binding13 != null && (imageView3 = binding13.svipType) != null) {
                imageView3.setVisibility(8);
            }
        }
        Integer taskAwardCnt = groupDetailBean.getTaskAwardCnt();
        if (taskAwardCnt != null) {
            int intValue2 = taskAwardCnt.intValue();
            if (intValue2 > 0) {
                FragmentAudioRoomBinding binding14 = this.fragment.getBinding();
                if (binding14 != null && (textView3 = binding14.redNumber) != null) {
                    ViewKtxKt.visibleOrGone(textView3, true);
                    textView3.setText(String.valueOf(intValue2));
                }
                textView3 = null;
            } else {
                FragmentAudioRoomBinding binding15 = this.fragment.getBinding();
                if (binding15 != null && (textView2 = binding15.redNumber) != null) {
                    ViewKtxKt.visibleOrGone(textView2, false);
                    textView3 = Unit.INSTANCE;
                }
                textView3 = null;
            }
            binding = this.fragment.getBinding();
            if (binding != null && (imageView12 = binding.pkBg) != null) {
                ImageKtxKt.toHorizontalMirror(imageView12, R.drawable.room_pk_button_icon);
            }
            binding2 = this.fragment.getBinding();
            if (binding2 != null && (newMicroView3 = binding2.microView) != null) {
                owner2 = groupDetailBean.getOwner();
                if (owner2 == null && (svip3 = owner2.getSvip()) != null) {
                    i6 = svip3.getSvipLevel();
                } else {
                    i6 = 0;
                }
                newMicroView3.refreshSVIP(i6);
            }
            mGameHelp = this.fragment.getMGameHelp();
            if (mGameHelp != null) {
                User owner5 = groupDetailBean.getOwner();
                if (owner5 != null && (svip2 = owner5.getSvip()) != null) {
                    i5 = svip2.getSvipLevel();
                } else {
                    i5 = 0;
                }
                mGameHelp.refreshSVIP(i5);
            }
            binding3 = this.fragment.getBinding();
            if (binding3 != null && (nickTextView = binding3.groupName) != null) {
                String name = groupDetailBean.getName();
                owner = groupDetailBean.getOwner();
                if (owner == null && (svip = owner.getSvip()) != null) {
                    i4 = svip.getSvipLevel();
                } else {
                    i4 = 0;
                }
                nickTextView.setTextAndVipLevel(name, i4);
            }
            binding4 = this.fragment.getBinding();
            if (binding4 != null && (shineTextView = binding4.groupId) != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{groupDetailBean.getCode()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                shineTextView.setText(format);
            }
            binding5 = this.fragment.getBinding();
            if (binding5 != null && (meetingRoomOnlineMemberLayout = binding5.meetingRoomOnlineMember) != null) {
                totalConsume = groupDetailBean.getTotalConsume();
                if (totalConsume == null) {
                    j = totalConsume.longValue();
                } else {
                    j = 0;
                }
                meetingRoomOnlineMemberLayout.updateRankSum(NumberUtilsKt.rankNumberFormat(j));
            }
            if (groupDetailBean.getPassword() != null) {
                FragmentAudioRoomBinding binding16 = this.fragment.getBinding();
                if (binding16 != null && (imageView11 = binding16.groupLock) != null) {
                    imageView11.setVisibility(8);
                }
            } else {
                FragmentAudioRoomBinding binding17 = this.fragment.getBinding();
                if (binding17 != null && (imageView4 = binding17.groupLock) != null) {
                    imageView4.setVisibility(0);
                }
            }
            if (!groupDetailBean.getMicOn()) {
                if (MeetingRoomManager.INSTANCE.getLocalRoomMicStatus()) {
                    FragmentAudioRoomBinding binding18 = this.fragment.getBinding();
                    if (binding18 != null && (imageView10 = binding18.closeMicTip) != null) {
                        imageView10.setVisibility(8);
                    }
                    RoomMessageView mChatLayout = this.fragment.getMChatLayout();
                    if (mChatLayout != null && (messageBinding3 = mChatLayout.messageBinding()) != null && (roomInputView3 = messageBinding3.chatInputLayout) != null) {
                        roomInputView3.changeRoomSoundStatus(true);
                    }
                } else {
                    FragmentAudioRoomBinding binding19 = this.fragment.getBinding();
                    if (binding19 != null && (imageView9 = binding19.closeMicTip) != null) {
                        imageView9.setVisibility(0);
                    }
                    RoomMessageView mChatLayout2 = this.fragment.getMChatLayout();
                    if (mChatLayout2 != null && (messageBinding2 = mChatLayout2.messageBinding()) != null && (roomInputView2 = messageBinding2.chatInputLayout) != null) {
                        roomInputView2.changeRoomSoundStatus(false);
                    }
                }
                FragmentAudioRoomBinding binding20 = this.fragment.getBinding();
                if (binding20 != null && (newMicroView2 = binding20.microView) != null) {
                    num2 = Integer.valueOf(newMicroView2.getMMicType());
                }
                if (!Intrinsics.areEqual(num2, groupDetailBean.getMicNumType())) {
                    FragmentAudioRoomBinding binding21 = this.fragment.getBinding();
                    if (binding21 != null && (newMicroView = binding21.microView) != null) {
                        Integer micNumType = groupDetailBean.getMicNumType();
                        if (micNumType != null) {
                            i3 = micNumType.intValue();
                        } else {
                            i3 = 0;
                        }
                        newMicroView.changeMicType(i3);
                    }
                    AudioGameHelp mGameHelp3 = this.fragment.getMGameHelp();
                    if (mGameHelp3 != null) {
                        mGameHelp3.changeGameMicType();
                    }
                }
            } else {
                FragmentAudioRoomBinding binding22 = this.fragment.getBinding();
                if (binding22 != null && (imageView5 = binding22.closeMicTip) != null) {
                    imageView5.setVisibility(8);
                }
                RoomMessageView mChatLayout3 = this.fragment.getMChatLayout();
                if (mChatLayout3 != null && (messageBinding = mChatLayout3.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
                    roomInputView.changeRoomSoundStatus(false);
                }
            }
            mGameHelp2 = this.fragment.getMGameHelp();
            if (mGameHelp2 == null && !mGameHelp2.isPlayGame()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Integer themeId = groupDetailBean.getThemeId();
                if (themeId != null) {
                    i2 = themeId.intValue();
                } else {
                    i2 = 0;
                }
                if (i2 > 0) {
                    String themeUrl = groupDetailBean.getThemeUrl();
                    if (themeUrl != null) {
                        if (themeUrl.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            z3 = true;
                        }
                    }
                    if (z3) {
                        FragmentAudioRoomBinding binding23 = this.fragment.getBinding();
                        if (binding23 != null && (imageView8 = binding23.meetingRoomThemBackGroup) != null) {
                            ImageKtxKt.loadImage$default(imageView8, ImageSizeKt.imageSize(groupDetailBean.getThemeUrl(), UiKtxKt.toPX(375)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.bg_meeting_room1), (c5.g) null, 49150, (Object) null);
                        }
                        alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                        alphaAnimation.setDuration(3L);
                        binding7 = this.fragment.getBinding();
                        if (binding7 != null && (imageView7 = binding7.meetingRoomThemBackGroup) != null) {
                            imageView7.startAnimation(alphaAnimation);
                        }
                    }
                }
                FragmentAudioRoomBinding binding24 = this.fragment.getBinding();
                if (binding24 != null && (imageView6 = binding24.meetingRoomThemBackGroup) != null) {
                    ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.bg_meeting_room1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(3L);
                binding7 = this.fragment.getBinding();
                if (binding7 != null) {
                    imageView7.startAnimation(alphaAnimation);
                }
            }
            binding6 = this.fragment.getBinding();
            if (binding6 != null && (frameLayout = binding6.onLineLayout) != null) {
                final long j2 = 800;
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initView$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j2 || (frameLayout instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                            Context activity = this.getFragment().getActivity();
                            if (activity != null) {
                                RoomMemberOnlineActivity.INSTANCE.start(activity, MeetingRoomManager.INSTANCE.getMGroupId(), true);
                            }
                        }
                    }
                });
            }
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.l2
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRoomFragmentHelp.this.checkPK();
                }
            }, 500L);
        }
        FragmentAudioRoomBinding binding25 = this.fragment.getBinding();
        if (binding25 != null && (textView = binding25.redNumber) != null) {
            ViewKtxKt.visibleOrGone(textView, false);
            Unit unit2 = Unit.INSTANCE;
        }
        binding = this.fragment.getBinding();
        if (binding != null) {
            ImageKtxKt.toHorizontalMirror(imageView12, R.drawable.room_pk_button_icon);
        }
        binding2 = this.fragment.getBinding();
        if (binding2 != null) {
            owner2 = groupDetailBean.getOwner();
            if (owner2 == null) {
            }
            i6 = 0;
            newMicroView3.refreshSVIP(i6);
        }
        mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
        }
        binding3 = this.fragment.getBinding();
        if (binding3 != null) {
            String name2 = groupDetailBean.getName();
            owner = groupDetailBean.getOwner();
            if (owner == null) {
            }
            i4 = 0;
            nickTextView.setTextAndVipLevel(name2, i4);
        }
        binding4 = this.fragment.getBinding();
        if (binding4 != null) {
            String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{groupDetailBean.getCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            shineTextView.setText(format2);
        }
        binding5 = this.fragment.getBinding();
        if (binding5 != null) {
            totalConsume = groupDetailBean.getTotalConsume();
            if (totalConsume == null) {
            }
            meetingRoomOnlineMemberLayout.updateRankSum(NumberUtilsKt.rankNumberFormat(j));
        }
        if (groupDetailBean.getPassword() != null) {
        }
        if (!groupDetailBean.getMicOn()) {
        }
        mGameHelp2 = this.fragment.getMGameHelp();
        if (mGameHelp2 == null) {
        }
        z = false;
        if (z) {
        }
        binding6 = this.fragment.getBinding();
        if (binding6 != null) {
            final long j22 = 800;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j22 || (frameLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                        Context activity = this.getFragment().getActivity();
                        if (activity != null) {
                            RoomMemberOnlineActivity.INSTANCE.start(activity, MeetingRoomManager.INSTANCE.getMGroupId(), true);
                        }
                    }
                }
            });
        }
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.l2
            @Override // java.lang.Runnable
            public final void run() {
                AudioRoomFragmentHelp.this.checkPK();
            }
        }, 500L);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.app.Dialog, com.qiahao.nextvideo.room.dialog.InviteTakeMicGetDiamondDialog] */
    private final void inviteUserUpMicToCompeleReward(int r3) {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            ?? inviteTakeMicGetDiamondDialog = new InviteTakeMicGetDiamondDialog(activity, r3);
            inviteTakeMicGetDiamondDialog.setMInviteTakeMicGetDiamondDialogListener(new AudioRoomFragmentHelp$inviteUserUpMicToCompeleReward$1$1(this));
            inviteTakeMicGetDiamondDialog.show();
        }
    }

    public static final ViewDataBinding manager$lambda$2(AudioRoomFragmentHelp audioRoomFragmentHelp, GiftNoticeUIModel giftNoticeUIModel) {
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "data");
        ViewGiftNoticeBinding inflate = ViewGiftNoticeBinding.inflate(LayoutInflater.from(audioRoomFragmentHelp.fragment.getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public static final Unit manager$lambda$3(AudioRoomFragmentHelp audioRoomFragmentHelp, ViewDataBinding viewDataBinding, GiftNoticeUIModel giftNoticeUIModel) {
        Intrinsics.checkNotNullParameter(viewDataBinding, "giftBinding");
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "newData");
        if (viewDataBinding instanceof ViewGiftNoticeBinding) {
            AudioRoomExtraDataKt.refreshGiftView(audioRoomFragmentHelp, (ViewGiftNoticeBinding) viewDataBinding, giftNoticeUIModel);
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
        FragmentAudioRoomBinding binding;
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        LightQueueCombinationPlayer lightQueueCombinationPlayer2;
        try {
            if (MeetingRoomManager.INSTANCE.checkShowEffect() && !getFullGiftHelper().isPlayAnimation()) {
                if (StringKtxKt.checkEndSVGA(data.getEffectSvga())) {
                    FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                    if (binding2 != null && (lightQueueCombinationPlayer2 = binding2.queuePlayer) != null) {
                        lightQueueCombinationPlayer2.addQueue(GiftHelp.INSTANCE.getSVGAData(data));
                        return;
                    }
                    return;
                }
                if (StringKtxKt.checkEndMP4(data.getEffectSvga())) {
                    Context context = this.fragment.getContext();
                    if (context != null) {
                        GiftHelp.INSTANCE.getVAP2(data, LifecycleOwnerKt.getLifecycleScope(this.fragment), new Function1() { // from class: com.qiahao.nextvideo.room.help.m2
                            public final Object invoke(Object obj) {
                                Unit playGift$lambda$95$lambda$94;
                                playGift$lambda$95$lambda$94 = AudioRoomFragmentHelp.playGift$lambda$95$lambda$94(AudioRoomFragmentHelp.this, (VapMediaSource) obj);
                                return playGift$lambda$95$lambda$94;
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

    public static final Unit playGift$lambda$95$lambda$94(AudioRoomFragmentHelp audioRoomFragmentHelp, VapMediaSource vapMediaSource) {
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        FragmentAudioRoomBinding binding = audioRoomFragmentHelp.fragment.getBinding();
        if (binding != null && (lightQueueCombinationPlayer = binding.queuePlayer) != null) {
            lightQueueCombinationPlayer.addQueue(vapMediaSource);
        }
        return Unit.INSTANCE;
    }

    private final void refreshGoldView(GroupDetailBean groupDetailBean) {
        int i;
        int i2;
        int i3;
        AudioHiloGameBinding audioHiloGameBinding;
        FragmentAudioRoomBinding binding;
        AppCompatImageView appCompatImageView;
        HiloGameHelp mHiloGameHelp;
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        int i4;
        NobleInfo noble;
        Integer level;
        FragmentAudioRoomBinding binding2;
        AppCompatImageView appCompatImageView2;
        FragmentAudioRoomBinding binding3;
        AppCompatImageView appCompatImageView3;
        NobleInfo noble2;
        Integer level2;
        MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
        int i5;
        NobleInfo noble3;
        Integer level3;
        FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
        if (binding4 != null && (meetingRoomOnlineMemberLayout = binding4.meetingRoomOnlineMember) != null) {
            User owner = groupDetailBean.getOwner();
            if (owner != null && (noble3 = owner.getNoble()) != null && (level3 = noble3.getLevel()) != null) {
                i5 = level3.intValue();
            } else {
                i5 = 0;
            }
            meetingRoomOnlineMemberLayout.refreshGoldView(i5);
        }
        User owner2 = groupDetailBean.getOwner();
        if (owner2 != null && (noble2 = owner2.getNoble()) != null && (level2 = noble2.getLevel()) != null) {
            i = level2.intValue();
        } else {
            i = 0;
        }
        Context context = this.fragment.getContext();
        if (i == 9) {
            i2 = 2131232358;
        } else if (i >= 10) {
            i2 = 2131232359;
        } else {
            i2 = R.drawable.ic_room_operation;
        }
        if (context != null && (binding3 = this.fragment.getBinding()) != null && (appCompatImageView3 = binding3.closeRoomImageView) != null) {
            appCompatImageView3.setImageDrawable(androidx.core.content.a.getDrawable(context, i2));
        }
        if (i == 9) {
            i3 = R.drawable.hilo_game_model_change_gold;
        } else if (i >= 10) {
            i3 = 2131231943;
        } else {
            i3 = R.drawable.hilo_game_model_change;
        }
        if (context != null && (binding2 = this.fragment.getBinding()) != null && (appCompatImageView2 = binding2.changeGameModel) != null) {
            appCompatImageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, i3));
        }
        RoomMessageView mChatLayout = this.fragment.getMChatLayout();
        if (mChatLayout != null && (messageBinding = mChatLayout.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
            User owner3 = groupDetailBean.getOwner();
            if (owner3 != null && (noble = owner3.getNoble()) != null && (level = noble.getLevel()) != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            roomInputView.refreshGoldView(i4);
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null && (mHiloGameHelp = mGameHelp.getMHiloGameHelp()) != null) {
            audioHiloGameBinding = mHiloGameHelp.getBinding();
        } else {
            audioHiloGameBinding = null;
        }
        if (audioHiloGameBinding != null && (binding = this.fragment.getBinding()) != null && (appCompatImageView = binding.changeGameModel) != null) {
            appCompatImageView.setVisibility(0);
        }
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
            VideoUploadManager.INSTANCE.uploadImage(media, fileCompat, new VideoUploadManager.UploadCallback() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$sendImage$2
                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object addMessageLocal(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                    return BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$sendImage$2$addMessageLocal$2(AudioRoomFragmentHelp.this, roomMessageMulti, null), continuation);
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
                    return BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$sendImage$2$onUploadFailed$2(AudioRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadSuccess(RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super Unit> continuation) {
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$sendImage$2$onUploadSuccess$2(AudioRoomFragmentHelp.this, groupMessageSend, z, null), continuation);
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
            videoUploadManager.uploadVideo(media, fileCompat, requireContext, new VideoUploadManager.UploadCallback() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$sendVideo$2
                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object addMessageLocal(RoomMessageMulti roomMessageMulti, Continuation<? super Unit> continuation) {
                    return BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$sendVideo$2$addMessageLocal$2(AudioRoomFragmentHelp.this, roomMessageMulti, null), continuation);
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
                    return BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$sendVideo$2$onUploadFailed$2(AudioRoomFragmentHelp.this, roomMessageMulti, null), continuation);
                }

                @Override // com.qiahao.nextvideo.room.help.VideoUploadManager.UploadCallback
                public Object onUploadSuccess(RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super Unit> continuation) {
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AudioRoomFragmentHelp$sendVideo$2$onUploadSuccess$2(AudioRoomFragmentHelp.this, groupMessageSend, z, null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                }
            });
        }
    }

    public static final Unit showBackgammonGameView$lambda$82(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 23, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showBalootGameView$lambda$63(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 14, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showCarromGameView$lambda$64(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 18, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    private final void showContactWrapper() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            new ContactRoomDialog(activity).show();
        }
    }

    public static final Unit showCrushGameView$lambda$62(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 11, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showDominoGameView$lambda$61(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 10, null, 2, null);
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
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout5 = binding.chatBack) != null) {
            frameLayout5.removeAllViews();
        }
        FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
        if (binding2 != null && (frameLayout4 = binding2.gameChatLayout) != null) {
            frameLayout4.removeAllViews();
        }
        FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
        if (binding3 != null && (frameLayout = binding3.gameChatLayout) != null && frameLayout.getChildCount() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            RoomMessageView mChatLayout = this.fragment.getMChatLayout();
            if (mChatLayout != null) {
                mChatLayout.setPaddingRelative(0, UiKtxKt.toPX(15), 0, 0);
            }
            FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
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
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$showFloatChat$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        AudioGameHelp mGameHelp = this.getFragment().getMGameHelp();
                        if (mGameHelp != null) {
                            RoomGameAnimationKt.hideGameChat(mGameHelp);
                        }
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UiKtxKt.toPX(40), UiKtxKt.toPX(40));
            layoutParams2.gravity = 8388661;
            FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
            if (binding5 != null && (frameLayout2 = binding5.gameChatLayout) != null) {
                frameLayout2.addView(imageView, layoutParams2);
            }
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            RoomGameAnimationKt.showGameChat(mGameHelp);
        }
    }

    private final void showGroupMedalView(List<GroupMedalBean> it) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (linearLayout2 = binding.llGroupMedal) != null) {
            linearLayout2.removeAllViews();
        }
        int i = 10;
        if (it.size() <= 10) {
            i = it.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            Context context = this.fragment.getContext();
            if (context != null) {
                ImageView imageView = new ImageView(context);
                FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                if (binding2 != null && (linearLayout = binding2.llGroupMedal) != null) {
                    linearLayout.addView(imageView);
                }
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                Dimens dimens = Dimens.INSTANCE;
                layoutParams2.height = dimens.dpToPx(17);
                layoutParams2.width = dimens.dpToPx(19);
                layoutParams2.setMarginEnd(dimens.dpToPx(5));
                ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                String picUrl = it.get(i2).getPicUrl();
                ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
                lfit.setWidth(dimens.dpToPx(19));
                lfit.setHeight(dimens.dpToPx(17));
                Unit unit = Unit.INSTANCE;
                ImageUIModel displayImage = companion.displayImage(picUrl, lfit);
                displayImage.setPlaceholder(null);
                ViewUtilitiesKt.bind(imageView, displayImage);
            }
        }
    }

    public static final Unit showJackaroGameView$lambda$65(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 21, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit showLudoGameView$lambda$59(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 1, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    private final void showMicFaceDialog() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            new MicFaceDialog(activity, this.fragment.getMViewModel().getMGroupId(), new AudioRoomFragmentHelp$showMicFaceDialog$1$1(this)).show();
        }
    }

    public static /* synthetic */ void showToastOrLog$default(AudioRoomFragmentHelp audioRoomFragmentHelp, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        audioRoomFragmentHelp.showToastOrLog(str, str2, z);
    }

    public static final Unit showUnoGameView$lambda$60(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        AudioGameHelp mGameHelp = audioRoomFragmentHelp.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 2, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    public final void showUserCompleteUpMicTask() {
        AudioGameHelp mGameHelp;
        AudioRoomDialogHelp mDialogHelp;
        if (MeetingRoomManager.INSTANCE.getMTaskMicCompletePairs() != null && (mGameHelp = this.fragment.getMGameHelp()) != null && !mGameHelp.checkGameIsShow() && (mDialogHelp = this.fragment.getMDialogHelp()) != null) {
            mDialogHelp.showTakeMicTaskCompleteDialog();
        }
    }

    private final void supportLevelShow(GroupDetailBean groupDetailBean) {
        int i;
        ImageView imageView;
        int i2;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        Integer supportLevel = groupDetailBean.getSupportLevel();
        if (supportLevel != null) {
            i = supportLevel.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            Integer supportLevel2 = groupDetailBean.getSupportLevel();
            if (supportLevel2 != null) {
                i2 = supportLevel2.intValue();
            } else {
                i2 = 0;
            }
            int supportMedal = meetingRoomManager.getSupportMedal(i2);
            if (supportMedal == 0) {
                FragmentAudioRoomBinding binding = this.fragment.getBinding();
                if (binding != null && (imageView4 = binding.groupSupportMedal) != null) {
                    imageView4.setVisibility(8);
                    return;
                }
                return;
            }
            FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
            if (binding2 != null && (imageView3 = binding2.groupSupportMedal) != null) {
                imageView3.setVisibility(0);
            }
            FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
            if (binding3 != null && (imageView2 = binding3.groupSupportMedal) != null) {
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(supportMedal), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            }
            return;
        }
        FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
        if (binding4 != null && (imageView = binding4.groupSupportMedal) != null) {
            imageView.setVisibility(8);
        }
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
        availablePath.setS3Config(builder.build(type)).setUploadListener(new RequestListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$uploadImage$2$1
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

    static /* synthetic */ Object uploadImage$default(AudioRoomFragmentHelp audioRoomFragmentHelp, File file, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return audioRoomFragmentHelp.uploadImage(file, z, continuation);
    }

    public static final VoteHelper voteHelper_delegate$lambda$0(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        return new VoteHelper(audioRoomFragmentHelp.fragment);
    }

    public final void checkPK() {
        QMUIRadiusImageView qMUIRadiusImageView;
        ImageView imageView;
        Drawable drawable;
        ImageView imageView2;
        Context context;
        PKSearchView pKSearchView;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        PKSearchView pKSearchView2;
        PKGameHelp mPKGameHelp;
        PKGameHelp mPKGameHelp2;
        PKSearchView pKSearchView3;
        ConstraintLayout constraintLayout3;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        String str = null;
        if (meetingRoomManager.getMPK() == null) {
            FragmentAudioRoomBinding binding = this.fragment.getBinding();
            if (binding != null && (constraintLayout3 = binding.pkLayout) != null) {
                constraintLayout3.setVisibility(8);
            }
            if (meetingRoomManager.checkPKMadel()) {
                FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                if (binding2 != null && (pKSearchView3 = binding2.pkSearch) != null) {
                    pKSearchView3.stopAnimation();
                }
                AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
                if (mGameHelp != null) {
                    AudioGameHelp.hideGameView$default(mGameHelp, null, 1, null);
                }
            }
        }
        RoomPK mpk = meetingRoomManager.getMPK();
        if (mpk != null) {
            int status = mpk.getStatus();
            if (status != 0) {
                if (status == 1) {
                    AudioGameHelp mGameHelp2 = this.fragment.getMGameHelp();
                    if (mGameHelp2 != null) {
                        AudioGameHelp.showGameView$default(mGameHelp2, 12, null, 2, null);
                    }
                    AudioGameHelp mGameHelp3 = this.fragment.getMGameHelp();
                    if (mGameHelp3 != null && (mPKGameHelp2 = mGameHelp3.getMPKGameHelp()) != null) {
                        mPKGameHelp2.refreshPro();
                    }
                    AudioGameHelp mGameHelp4 = this.fragment.getMGameHelp();
                    if (mGameHelp4 != null && (mPKGameHelp = mGameHelp4.getMPKGameHelp()) != null) {
                        mPKGameHelp.pkCountDown(Boolean.FALSE);
                    }
                    FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                    if (binding3 != null && (pKSearchView2 = binding3.pkSearch) != null) {
                        pKSearchView2.stopAnimation();
                    }
                    FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
                    if (binding4 != null && (constraintLayout2 = binding4.pkLayout) != null) {
                        constraintLayout2.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
            if (binding5 != null && (constraintLayout = binding5.pkLayout) != null) {
                constraintLayout.setVisibility(0);
            }
            FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
            if (binding6 != null && (pKSearchView = binding6.pkSearch) != null) {
                pKSearchView.startAnimation();
            }
            FragmentAudioRoomBinding binding7 = this.fragment.getBinding();
            if (binding7 != null && (imageView = binding7.gameTypeImage) != null) {
                Integer roomPKGameIcon = meetingRoomManager.getRoomPKGameIcon(22);
                if (roomPKGameIcon != null) {
                    int intValue = roomPKGameIcon.intValue();
                    FragmentAudioRoomBinding binding8 = this.fragment.getBinding();
                    if (binding8 != null && (imageView2 = binding8.gameTypeImage) != null && (context = imageView2.getContext()) != null) {
                        drawable = androidx.core.content.a.getDrawable(context, intValue);
                        imageView.setImageDrawable(drawable);
                    }
                }
                drawable = null;
                imageView.setImageDrawable(drawable);
            }
            FragmentAudioRoomBinding binding9 = this.fragment.getBinding();
            if (binding9 != null && (qMUIRadiusImageView = binding9.leftAvatar) != null) {
                GroupDetailBean inviteGroup = mpk.getInviteGroup();
                if (inviteGroup != null) {
                    str = inviteGroup.getFaceUrl();
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0159, code lost:
    
        if (r1 == true) goto L١٩٦;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkPlayLayout() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        int i;
        LinearLayoutCompat linearLayoutCompat;
        boolean z;
        LinearLayoutCompat linearLayoutCompat2;
        FrameLayout frameLayout;
        boolean z2;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        if (MeetingRoomManager.INSTANCE.isCanShowSmallLuckyRouletteOrBox()) {
            FragmentAudioRoomBinding binding = this.fragment.getBinding();
            if (binding != null && (imageView9 = binding.diamondGame) != null) {
                imageView9.setVisibility(8);
            }
            int intValue = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "LAST_DIAMOND_GAME", 7, (String) null, 4, (Object) null)).intValue();
            ArrayList<GameConfiguration> arrayList = (ArrayList) this.fragment.getMViewModel().getMDiamondGameList().getValue();
            if (arrayList != null) {
                for (GameConfiguration gameConfiguration : arrayList) {
                    Integer gameId = gameConfiguration.getGameId();
                    if (gameId != null && gameId.intValue() == intValue && MeetingRoomManager.INSTANCE.isLuckyGame(intValue)) {
                        FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                        if (binding2 != null && (imageView8 = binding2.diamondGame) != null) {
                            imageView8.setVisibility(0);
                        }
                        FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                        if (binding3 != null && (imageView7 = binding3.diamondGame) != null) {
                            ImageKtxKt.loadImage$default(imageView7, ImageSizeKt.image100(gameConfiguration.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                        }
                    }
                }
            }
            LuckWheelInfo luckWheelInfo = (LuckWheelInfo) this.fragment.getMViewModel().getMRoomLuckWheelInfo().getValue();
            if (luckWheelInfo != null) {
                if (luckWheelInfo.getStatus() != 0) {
                    FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
                    if (binding4 != null && (imageView6 = binding4.smallRoulette) != null) {
                        imageView6.setVisibility(0);
                    }
                } else {
                    FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
                    if (binding5 != null && (imageView5 = binding5.smallRoulette) != null) {
                        imageView5.setVisibility(8);
                    }
                }
            }
        } else {
            FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
            if (binding6 != null && (imageView2 = binding6.diamondGame) != null) {
                imageView2.setVisibility(8);
            }
            FragmentAudioRoomBinding binding7 = this.fragment.getBinding();
            if (binding7 != null && (imageView = binding7.smallRoulette) != null) {
                imageView.setVisibility(8);
            }
        }
        if (MeetingRoomManager.INSTANCE.isCanShowSmallLuckyFruit()) {
            FragmentAudioRoomBinding binding8 = this.fragment.getBinding();
            if (binding8 != null && (imageView4 = binding8.smallLuckyFruit) != null) {
                imageView4.setVisibility(0);
            }
        } else {
            FragmentAudioRoomBinding binding9 = this.fragment.getBinding();
            if (binding9 != null && (imageView3 = binding9.smallLuckyFruit) != null) {
                imageView3.setVisibility(8);
            }
        }
        List list = (List) this.fragment.getMViewModel().getMBannerList().getValue();
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        if (i > 0) {
            FragmentAudioRoomBinding binding10 = this.fragment.getBinding();
            if (binding10 != null && (frameLayout = binding10.pk1v1) != null) {
                z = true;
                if (frameLayout.getChildCount() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            z = false;
            if (z) {
                FragmentAudioRoomBinding binding11 = this.fragment.getBinding();
                if (binding11 != null && (linearLayoutCompat2 = binding11.groupBanner) != null) {
                    linearLayoutCompat2.setVisibility(0);
                    return;
                }
                return;
            }
        }
        FragmentAudioRoomBinding binding12 = this.fragment.getBinding();
        if (binding12 != null && (linearLayoutCompat = binding12.groupBanner) != null) {
            linearLayoutCompat.setVisibility(8);
        }
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
                            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new AudioRoomFragmentHelp$dispatchGiftShow$1$1(this, new GiftNoticeUIModel(resGiftId, str14, receiveUserNick2, resGiftNum, str10, str11, z3, meetingRoomReceiveGiftCustomContent.getSenderNobleLevel(), false, 256, null), null), 3, (Object) null);
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
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new AudioRoomFragmentHelp$dispatchGiftShow$1$1(this, new GiftNoticeUIModel(resGiftId, str14, receiveUserNick2, resGiftNum, str10, str11, z3, meetingRoomReceiveGiftCustomContent.getSenderNobleLevel(), false, 256, null), null), 3, (Object) null);
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
                        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new AudioRoomFragmentHelp$dispatchGiftShow$1$2(this, new GiftNoticeUIModel(resGiftId2, str15, receiveUserNick, resGiftNum2, str2, str3, z, meetingRoomReceiveGiftCustomContent.getSenderNobleLevel(), false, 256, null), null), 3, (Object) null);
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
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.fragment), (CoroutineContext) null, (CoroutineStart) null, new AudioRoomFragmentHelp$dispatchGiftShow$1$2(this, new GiftNoticeUIModel(resGiftId2, str15, receiveUserNick, resGiftNum2, str2, str3, z, meetingRoomReceiveGiftCustomContent.getSenderNobleLevel(), false, 256, null), null), 3, (Object) null);
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
    public final AudioRoomFragment getFragment() {
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

    public final boolean getMInsertWelcome() {
        return this.mInsertWelcome;
    }

    public final boolean getMIsGiftTraverseing() {
        return this.mIsGiftTraverseing;
    }

    @NotNull
    public final AnimationQueueManager<GiftNoticeUIModel> getManager() {
        return this.manager;
    }

    @NotNull
    public final VoteHelper getVoteHelper() {
        return (VoteHelper) this.voteHelper.getValue();
    }

    public final void goToPurchase() {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkFirstRecharge(), new Function1() { // from class: com.qiahao.nextvideo.room.help.i2
            public final Object invoke(Object obj) {
                Unit goToPurchase$lambda$115;
                goToPurchase$lambda$115 = AudioRoomFragmentHelp.goToPurchase$lambda$115(AudioRoomFragmentHelp.this, (ApiResponse) obj);
                return goToPurchase$lambda$115;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.j2
            public final Object invoke(Object obj) {
                Unit goToPurchase$lambda$116;
                goToPurchase$lambda$116 = AudioRoomFragmentHelp.goToPurchase$lambda$116(AudioRoomFragmentHelp.this, (Throwable) obj);
                return goToPurchase$lambda$116;
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
        initBannerView();
        initObserve();
        initGemRecycleView();
        initChatUI();
        initData();
        initClickListener();
        initFromSamllOrEnterLogic();
        initRocket();
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public final void release() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler = null;
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = AudioRoomFragmentHelp.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.removeListener(name);
        MaxDialogUtils.INSTANCE.releaseAllDialog();
        this.mGiftSourceBeanList.clear();
        getFullGiftHelper().destroy();
        AwsS3Repository.Companion.getInstance().clear(this);
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

    public final void setMInsertWelcome(boolean z) {
        this.mInsertWelcome = z;
    }

    public final void setMIsGiftTraverseing(boolean z) {
        this.mIsGiftTraverseing = z;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void showBackgammonGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.b1
                public final Object invoke() {
                    Unit showBackgammonGameView$lambda$82;
                    showBackgammonGameView$lambda$82 = AudioRoomFragmentHelp.showBackgammonGameView$lambda$82(AudioRoomFragmentHelp.this);
                    return showBackgammonGameView$lambda$82;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 23, null, 2, null);
        }
    }

    public final void showBalootGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.s1
                public final Object invoke() {
                    Unit showBalootGameView$lambda$63;
                    showBalootGameView$lambda$63 = AudioRoomFragmentHelp.showBalootGameView$lambda$63(AudioRoomFragmentHelp.this);
                    return showBalootGameView$lambda$63;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 14, null, 2, null);
        }
    }

    public final void showCarromGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.h2
                public final Object invoke() {
                    Unit showCarromGameView$lambda$64;
                    showCarromGameView$lambda$64 = AudioRoomFragmentHelp.showCarromGameView$lambda$64(AudioRoomFragmentHelp.this);
                    return showCarromGameView$lambda$64;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 18, null, 2, null);
        }
    }

    public final void showCrushGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.r1
                public final Object invoke() {
                    Unit showCrushGameView$lambda$62;
                    showCrushGameView$lambda$62 = AudioRoomFragmentHelp.showCrushGameView$lambda$62(AudioRoomFragmentHelp.this);
                    return showCrushGameView$lambda$62;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 11, null, 2, null);
        }
    }

    public final void showDominoGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.e2
                public final Object invoke() {
                    Unit showDominoGameView$lambda$61;
                    showDominoGameView$lambda$61 = AudioRoomFragmentHelp.showDominoGameView$lambda$61(AudioRoomFragmentHelp.this);
                    return showDominoGameView$lambda$61;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 10, null, 2, null);
        }
    }

    public final void showJackaroGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.t1
                public final Object invoke() {
                    Unit showJackaroGameView$lambda$65;
                    showJackaroGameView$lambda$65 = AudioRoomFragmentHelp.showJackaroGameView$lambda$65(AudioRoomFragmentHelp.this);
                    return showJackaroGameView$lambda$65;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 21, null, 2, null);
        }
    }

    public final void showLudoGameView() {
        if (TextUtils.isEmpty(this.fragment.getMViewModel().getMGameCode())) {
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.y0
                public final Object invoke() {
                    Unit showLudoGameView$lambda$59;
                    showLudoGameView$lambda$59 = AudioRoomFragmentHelp.showLudoGameView$lambda$59(AudioRoomFragmentHelp.this);
                    return showLudoGameView$lambda$59;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 1, null, 2, null);
        }
    }

    public final void showSendGiftPanel(@NotNull String extraId, @NotNull String userName, boolean isAllMic) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            new RoomGiftDialogFragment(extraId, userName, this.fragment.getMViewModel().getMGroupId(), isAllMic).setListener(new SendGiftListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$showSendGiftPanel$1$1
                public void begGift(GiftData giftData, int i) {
                    SendGiftListener.DefaultImpls.begGift(this, giftData, i);
                }

                public void giftsChoose(GiftData giftData, int i, ArrayList<String> arrayList, boolean z) {
                    SendGiftListener.DefaultImpls.giftsChoose(this, giftData, i, arrayList, z);
                }

                public void roomGiftsChoose(GiftData selectedGiftItem, int number, ArrayList<String> extraIdList, int sendType) {
                    Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
                    Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
                    AudioRoomFragmentHelp.this.getFragment().getMViewModel().sendGift(sendType, selectedGiftItem, number, extraIdList);
                }

                public void showRechargeView() {
                    AudioRoomFragmentHelp.this.goToPurchase();
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
            RoomViewModel.getSudCode$default(this.fragment.getMViewModel(), new Function0() { // from class: com.qiahao.nextvideo.room.help.o2
                public final Object invoke() {
                    Unit showUnoGameView$lambda$60;
                    showUnoGameView$lambda$60 = AudioRoomFragmentHelp.showUnoGameView$lambda$60(AudioRoomFragmentHelp.this);
                    return showUnoGameView$lambda$60;
                }
            }, null, 2, null);
            return;
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null) {
            AudioGameHelp.showGameView$default(mGameHelp, 2, null, 2, null);
        }
    }
}
