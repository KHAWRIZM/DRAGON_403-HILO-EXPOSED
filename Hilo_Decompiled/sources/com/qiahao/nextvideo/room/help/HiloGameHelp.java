package com.qiahao.nextvideo.room.help;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.ViewExpansionKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBean;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.databinding.AudioHiloGameBetItemBinding;
import com.qiahao.nextvideo.databinding.AudioHiloGameBinding;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity;
import com.qiahao.nextvideo.room.adapter.HiloGameMicAdapter;
import com.qiahao.nextvideo.room.downloadGame.GameListener;
import com.qiahao.nextvideo.room.downloadGame.HiloRoomGameMessage;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener;
import com.qiahao.nextvideo.ui.webview.BaseWebView;
import com.qiahao.nextvideo.utilities.ArcMotionAnimator;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010P\u001a\u0004\u0018\u00010Q2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010SJ\u0018\u0010T\u001a\u00020U2\b\u0010\b\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020\u0016J\u000e\u0010X\u001a\u00020U2\u0006\u0010Y\u001a\u00020ZJ\"\u0010[\u001a\u00020U2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\b\b\u0002\u0010`\u001a\u00020-H\u0002J\u0010\u0010a\u001a\u00020U2\b\u0010Y\u001a\u0004\u0018\u00010bJ\u000e\u0010c\u001a\u00020U2\u0006\u0010d\u001a\u00020-J\u0006\u0010e\u001a\u00020UJ.\u0010f\u001a\u00020U2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u00162\u0006\u0010i\u001a\u00020\u00162\u0006\u0010j\u001a\u00020\u00162\u0006\u0010W\u001a\u00020\u0016J\u0016\u0010k\u001a\u00020U2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010lJ\u0010\u0010m\u001a\u00020U2\b\u0010n\u001a\u0004\u0018\u00010oJ\u0010\u0010p\u001a\u00020U2\b\u0010Y\u001a\u0004\u0018\u00010bJ\u0014\u0010q\u001a\u00020U2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00170lJ.\u0010s\u001a\u00020U2\b\u0010t\u001a\u0004\u0018\u00010V2\b\u0010Y\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010u\u001a\u00020-2\b\b\u0002\u0010d\u001a\u00020-J\u000e\u0010v\u001a\u00020U2\u0006\u0010Y\u001a\u00020ZJ\u000e\u0010w\u001a\u00020U2\u0006\u0010x\u001a\u00020\u0016J\u0006\u0010y\u001a\u00020UJ\u0016\u0010z\u001a\u00020U2\u0006\u0010{\u001a\u00020\u00162\u0006\u0010|\u001a\u00020_J\u0014\u0010}\u001a\u00020U2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00160lR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&0\u001ej\b\u0012\u0004\u0012\u00020&` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R*\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010.\"\u0004\bC\u00100R\u001b\u0010D\u001a\u00020E8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bF\u0010GR\u001a\u0010J\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010?\"\u0004\bL\u0010AR\u001a\u0010M\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010?\"\u0004\bO\u0010A¨\u0006~"}, d2 = {"Lcom/qiahao/nextvideo/room/help/HiloGameHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "binding", "Lcom/qiahao/nextvideo/databinding/AudioHiloGameBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/AudioHiloGameBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/AudioHiloGameBinding;)V", "mGameMusicHelper", "Lcom/qiahao/nextvideo/room/help/GameMusicHelper;", "getMGameMusicHelper", "()Lcom/qiahao/nextvideo/room/help/GameMusicHelper;", "setMGameMusicHelper", "(Lcom/qiahao/nextvideo/room/help/GameMusicHelper;)V", "mMicroBeanListData", "Ljava/util/HashMap;", "", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "Lkotlin/collections/HashMap;", "getMMicroBeanListData", "()Ljava/util/HashMap;", "setMMicroBeanListData", "(Ljava/util/HashMap;)V", "onlineUserList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBean;", "Lkotlin/collections/ArrayList;", "getOnlineUserList", "()Ljava/util/ArrayList;", "setOnlineUserList", "(Ljava/util/ArrayList;)V", "mBetList", "LuserProxy/UserProxy$NoticeBetGameBetTopNBase;", "getMBetList", "setMBetList", "mOriginal", "getMOriginal", "setMOriginal", "isShowWin", "", "()Z", "setShowWin", "(Z)V", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "arcAnimator", "Lcom/qiahao/nextvideo/utilities/ArcMotionAnimator;", "getArcAnimator", "()Lcom/qiahao/nextvideo/utilities/ArcMotionAnimator;", "setArcAnimator", "(Lcom/qiahao/nextvideo/utilities/ArcMotionAnimator;)V", "mScrollY", "getMScrollY", "()I", "setMScrollY", "(I)V", "isScroll", "setScroll", "mHiloGameMicAdapter", "Lcom/qiahao/nextvideo/room/adapter/HiloGameMicAdapter;", "getMHiloGameMicAdapter", "()Lcom/qiahao/nextvideo/room/adapter/HiloGameMicAdapter;", "mHiloGameMicAdapter$delegate", "Lkotlin/Lazy;", "mDefaultViewHeight", "getMDefaultViewHeight", "setMDefaultViewHeight", "mViewChangeHeight", "getMViewChangeHeight", "setMViewChangeHeight", "addHiloGameView", "Landroid/view/View;", "gameConfiguration", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "setBetBg", "", "Lcom/qiahao/nextvideo/databinding/AudioHiloGameBetItemBinding;", "position", "winFlip", "data", "LuserProxy/UserProxy1$NoticeBetGameWinTopN;", "playSvga", "svgaView", "Lcom/opensource/svgaplayer/SVGAImageView;", "svgaUrl", "", "isLocal", "betFlip", "LuserProxy/UserProxy1$NoticeBetGameBetTopN;", "refreshButtonView", "isWin", "notificationMicChange", "startDiamondAnimation", "startX", "startY", "endX", "endY", "refreshOnlineNumber", "", "refreshBet", "eventData", "LuserProxy/UserProxy1$NoticeBetGame;", "refreshButtonRank", "changeGameMic", "list", "refreshBetView", "viewBinding", "isOnePosition", "winRank", "startNewRound", AgooConstants.MESSAGE_TIME, "removeHiloGameView", "showFace", "index", "faceSVGAUrl", "showMicSpeakWaveAnim", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloGameHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloGameHelp.kt\ncom/qiahao/nextvideo/room/help/HiloGameHelp\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 4 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 5 Color.kt\nandroidx/core/graphics/ColorKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,593:1\n1#2:594\n51#3:595\n48#3:596\n61#4,9:597\n61#4,9:606\n61#4,9:615\n439#5:624\n439#5:625\n439#5:626\n439#5:627\n1869#6:628\n1870#6:631\n1869#6,2:632\n1869#6,2:634\n1878#6,3:636\n216#7,2:629\n*S KotlinDebug\n*F\n+ 1 HiloGameHelp.kt\ncom/qiahao/nextvideo/room/help/HiloGameHelp\n*L\n92#1:595\n98#1:596\n154#1:597,9\n157#1:606,9\n250#1:615,9\n363#1:624\n365#1:625\n370#1:626\n372#1:627\n422#1:628\n422#1:631\n461#1:632,2\n467#1:634,2\n503#1:636,3\n424#1:629,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloGameHelp {

    @Nullable
    private ArcMotionAnimator arcAnimator;

    @Nullable
    private AudioHiloGameBinding binding;

    @NotNull
    private final AudioRoomFragment fragment;
    private boolean isScroll;
    private boolean isShowWin;

    @NotNull
    private ArrayList<UserProxy.NoticeBetGameBetTopNBase> mBetList;
    private int mDefaultViewHeight;

    @Nullable
    private GameMusicHelper mGameMusicHelper;

    /* renamed from: mHiloGameMicAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHiloGameMicAdapter;

    @NotNull
    private HashMap<Integer, MicroBean> mMicroBeanListData;

    @NotNull
    private ArrayList<CurrentRoomOnlineBean> mOriginal;
    private int mScrollY;
    private int mViewChangeHeight;

    @NotNull
    private ArrayList<CurrentRoomOnlineBean> onlineUserList;

    @Nullable
    private CountDownTimer timerTask;

    public HiloGameHelp(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        this.mMicroBeanListData = new HashMap<>();
        this.onlineUserList = new ArrayList<>();
        this.mBetList = new ArrayList<>();
        this.mOriginal = new ArrayList<>();
        this.mHiloGameMicAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.n6
            public final Object invoke() {
                HiloGameMicAdapter mHiloGameMicAdapter_delegate$lambda$0;
                mHiloGameMicAdapter_delegate$lambda$0 = HiloGameHelp.mHiloGameMicAdapter_delegate$lambda$0();
                return mHiloGameMicAdapter_delegate$lambda$0;
            }
        });
    }

    public static /* synthetic */ View addHiloGameView$default(HiloGameHelp hiloGameHelp, GameConfiguration gameConfiguration, int i, Object obj) {
        if ((i & 1) != 0) {
            gameConfiguration = null;
        }
        return hiloGameHelp.addHiloGameView(gameConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addHiloGameView$lambda$10(HiloGameHelp hiloGameHelp, boolean z, int i, int i2) {
        hiloGameHelp.mScrollY = i2;
        hiloGameHelp.isScroll = z;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHiloGameView$lambda$8(final HiloGameHelp hiloGameHelp, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        AudioRoomDialogHelp mDialogHelp;
        Integer touristMic;
        String externalId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        final MicroBean microBean = (MicroBean) hiloGameHelp.getMHiloGameMicAdapter().getData().get(i);
        int i2 = 1;
        final int i3 = i + 1;
        String str = "";
        switch (view.getId()) {
            case R.id.base_micro /* 2131362072 */:
                MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null && (externalId = user.getExternalId()) != null) {
                    str = externalId;
                }
                if (meetingRoomManager.getRoomUserRole(str) > 1) {
                    AudioRoomDialogHelp mDialogHelp2 = hiloGameHelp.fragment.getMDialogHelp();
                    if (mDialogHelp2 != null) {
                        mDialogHelp2.showMicOperateBottomDialog(i3, microBean, true);
                        return;
                    }
                    return;
                }
                if (FastClickUtils.INSTANCE.isFastClick() && !meetingRoomManager.isMySelfOnMic() && (mDialogHelp = hiloGameHelp.fragment.getMDialogHelp()) != null) {
                    GroupDetailBean groupDetailBean = (GroupDetailBean) hiloGameHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean != null && (touristMic = groupDetailBean.getTouristMic()) != null) {
                        i2 = touristMic.intValue();
                    }
                    mDialogHelp.checkTouristRole(i2, new Function0() { // from class: com.qiahao.nextvideo.room.help.m6
                        public final Object invoke() {
                            Unit addHiloGameView$lambda$8$lambda$7;
                            addHiloGameView$lambda$8$lambda$7 = HiloGameHelp.addHiloGameView$lambda$8$lambda$7(HiloGameHelp.this, i3, microBean);
                            return addHiloGameView$lambda$8$lambda$7;
                        }
                    });
                    return;
                }
                return;
            case R.id.lock_micro /* 2131363625 */:
                AudioRoomDialogHelp mDialogHelp3 = hiloGameHelp.fragment.getMDialogHelp();
                if (mDialogHelp3 != null) {
                    mDialogHelp3.showMicOperateBottomDialog(i3, microBean, false);
                    return;
                }
                return;
            case R.id.mic_user_head_img /* 2131363866 */:
            case R.id.mic_user_head_svga /* 2131363868 */:
            case 2131365536:
            case R.id.user_mute /* 2131365556 */:
                AudioRoomDialogHelp mDialogHelp4 = hiloGameHelp.fragment.getMDialogHelp();
                if (mDialogHelp4 != null) {
                    String externalId2 = microBean.getExternalId();
                    if (externalId2 != null) {
                        str = externalId2;
                    }
                    mDialogHelp4.showUserInfoDialog(str, i3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addHiloGameView$lambda$8$lambda$7(final HiloGameHelp hiloGameHelp, final int i, final MicroBean microBean) {
        hiloGameHelp.fragment.checkMicrophonePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.r6
            public final Object invoke() {
                Unit addHiloGameView$lambda$8$lambda$7$lambda$6;
                addHiloGameView$lambda$8$lambda$7$lambda$6 = HiloGameHelp.addHiloGameView$lambda$8$lambda$7$lambda$6(HiloGameHelp.this, i, microBean);
                return addHiloGameView$lambda$8$lambda$7$lambda$6;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addHiloGameView$lambda$8$lambda$7$lambda$6(HiloGameHelp hiloGameHelp, int i, MicroBean microBean) {
        RoomViewModel.upMic$default(hiloGameHelp.fragment.getMViewModel(), Integer.valueOf(i), null, microBean.getMicForbid(), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHiloGameView$lambda$9(HiloGameHelp hiloGameHelp, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MicroBean microBean = (MicroBean) hiloGameHelp.getMHiloGameMicAdapter().getData().get(i);
        int i2 = i + 1;
        AudioRoomDialogHelp mDialogHelp = hiloGameHelp.fragment.getMDialogHelp();
        if (mDialogHelp != null) {
            String externalId = microBean.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            mDialogHelp.showUserInfoDialog(externalId, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiloGameMicAdapter mHiloGameMicAdapter_delegate$lambda$0() {
        return new HiloGameMicAdapter();
    }

    private final void playSvga(final SVGAImageView svgaView, String svgaUrl, final boolean isLocal) {
        if (TextUtils.isEmpty(svgaUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromAssets(svgaUrl, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    int i = 1;
                    svgaView.stopAnimation(true);
                    svgaView.setImageDrawable(new SVGADrawable(videoItem));
                    SVGAImageView sVGAImageView = svgaView;
                    if (isLocal) {
                        i = -1;
                    }
                    sVGAImageView.setLoops(i);
                    svgaView.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void playSvga$default(HiloGameHelp hiloGameHelp, SVGAImageView sVGAImageView, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        hiloGameHelp.playSvga(sVGAImageView, str, z);
    }

    public static /* synthetic */ void refreshBetView$default(HiloGameHelp hiloGameHelp, AudioHiloGameBetItemBinding audioHiloGameBetItemBinding, UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        hiloGameHelp.refreshBetView(audioHiloGameBetItemBinding, noticeBetGameBetTopNBase, z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View addHiloGameView(@Nullable GameConfiguration gameConfiguration) {
        GameMusicHelper gameMusicHelper;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding2;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding3;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding4;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding5;
        int i;
        String str;
        int i2;
        Integer gameId;
        AudioHiloGameBinding audioHiloGameBinding;
        final long j;
        AudioHiloGameBinding audioHiloGameBinding2;
        AudioHiloGameBinding audioHiloGameBinding3;
        int currentMicSize;
        AudioHiloGameBinding audioHiloGameBinding4;
        FragmentAudioRoomBinding binding;
        List<CurrentRoomOnlineBean> list;
        AudioHiloGameBinding audioHiloGameBinding5;
        MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        final ConstraintLayout constraintLayout;
        final ConstraintLayout constraintLayout2;
        String str2;
        BaseWebView baseWebView;
        ConstraintLayout constraintLayout3;
        Integer gameId2;
        ConstraintLayout constraintLayout4;
        ConstraintLayout constraintLayout5;
        RecyclerView recyclerView3;
        View view;
        ConstraintLayout constraintLayout6;
        FrameLayout frameLayout;
        Context context;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        View view2;
        View view3;
        FragmentAudioRoomBinding binding2;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        meetingRoomManager.setMHiloGameConfiguration(gameConfiguration);
        Context context2 = this.fragment.getContext();
        if (context2 != null) {
            gameMusicHelper = new GameMusicHelper(context2);
        } else {
            gameMusicHelper = null;
        }
        this.mGameMusicHelper = gameMusicHelper;
        FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
        if (binding3 != null && (frameLayout4 = binding3.gameLayout) != null && frameLayout4.getChildCount() != 0) {
            FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
            if (binding4 != null && (frameLayout6 = binding4.gameLayout) != null) {
                view2 = frameLayout6.getChildAt(0);
            } else {
                view2 = null;
            }
            AudioHiloGameBinding audioHiloGameBinding6 = this.binding;
            if (audioHiloGameBinding6 != null) {
                view3 = audioHiloGameBinding6.getRoot();
            } else {
                view3 = null;
            }
            if (!Intrinsics.areEqual(view2, view3) && (binding2 = this.fragment.getBinding()) != null && (frameLayout5 = binding2.gameLayout) != null) {
                frameLayout5.removeAllViews();
            }
        }
        FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
        if (binding5 != null && (frameLayout = binding5.gameLayout) != null && frameLayout.getChildCount() == 0 && this.binding == null && (context = this.fragment.getContext()) != null) {
            FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
            if (binding6 != null && (frameLayout3 = binding6.gameLayout) != null) {
                frameLayout3.removeAllViews();
            }
            LayoutInflater from = LayoutInflater.from(context);
            FragmentAudioRoomBinding binding7 = this.fragment.getBinding();
            if (binding7 != null) {
                frameLayout2 = binding7.gameLayout;
            } else {
                frameLayout2 = null;
            }
            this.binding = (AudioHiloGameBinding) androidx.databinding.g.h(from, R.layout.audio_hilo_game, frameLayout2, true);
        }
        AudioHiloGameBinding audioHiloGameBinding7 = this.binding;
        if (audioHiloGameBinding7 != null && (constraintLayout6 = audioHiloGameBinding7.downloadLayout) != null) {
            constraintLayout6.setVisibility(0);
        }
        AudioHiloGameBinding audioHiloGameBinding8 = this.binding;
        if (audioHiloGameBinding8 != null && (view = audioHiloGameBinding8.bg) != null) {
            view.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33ffffff", "#33ffffff", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        AudioHiloGameBinding audioHiloGameBinding9 = this.binding;
        if (audioHiloGameBinding9 != null && (recyclerView3 = audioHiloGameBinding9.micRecyclerView) != null) {
            recyclerView3.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33ffffff", "#33ffffff", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        AudioHiloGameBinding audioHiloGameBinding10 = this.binding;
        if (audioHiloGameBinding10 != null && (constraintLayout5 = audioHiloGameBinding10.onLineLayout) != null) {
            constraintLayout5.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33ffffff", "#33ffffff", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        AudioHiloGameBinding audioHiloGameBinding11 = this.binding;
        if (audioHiloGameBinding11 != null && (constraintLayout4 = audioHiloGameBinding11.onLineCount) != null) {
            constraintLayout4.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33000000", "#33000000", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        AudioHiloGameBinding audioHiloGameBinding12 = this.binding;
        if (audioHiloGameBinding12 != null) {
            audioHiloGameBetItemBinding = audioHiloGameBinding12.bet1;
        } else {
            audioHiloGameBetItemBinding = null;
        }
        setBetBg(audioHiloGameBetItemBinding, 0);
        AudioHiloGameBinding audioHiloGameBinding13 = this.binding;
        if (audioHiloGameBinding13 != null) {
            audioHiloGameBetItemBinding2 = audioHiloGameBinding13.bet2;
        } else {
            audioHiloGameBetItemBinding2 = null;
        }
        setBetBg(audioHiloGameBetItemBinding2, 1);
        AudioHiloGameBinding audioHiloGameBinding14 = this.binding;
        if (audioHiloGameBinding14 != null) {
            audioHiloGameBetItemBinding3 = audioHiloGameBinding14.bet3;
        } else {
            audioHiloGameBetItemBinding3 = null;
        }
        setBetBg(audioHiloGameBetItemBinding3, 2);
        AudioHiloGameBinding audioHiloGameBinding15 = this.binding;
        if (audioHiloGameBinding15 != null) {
            audioHiloGameBetItemBinding4 = audioHiloGameBinding15.bet4;
        } else {
            audioHiloGameBetItemBinding4 = null;
        }
        setBetBg(audioHiloGameBetItemBinding4, 3);
        AudioHiloGameBinding audioHiloGameBinding16 = this.binding;
        if (audioHiloGameBinding16 != null) {
            audioHiloGameBetItemBinding5 = audioHiloGameBinding16.bet5;
        } else {
            audioHiloGameBetItemBinding5 = null;
        }
        setBetBg(audioHiloGameBetItemBinding5, 4);
        HiloRoomGameMessage hiloRoomGameMessage = HiloRoomGameMessage.INSTANCE;
        if (gameConfiguration != null && (gameId2 = gameConfiguration.getGameId()) != null) {
            i = gameId2.intValue();
        } else {
            i = 0;
        }
        File gameFile = hiloRoomGameMessage.getGameFile(i);
        if (gameFile != null && gameFile.exists()) {
            String parentFile = StringKtxKt.parentFile(gameFile.getAbsolutePath());
            if (gameConfiguration != null) {
                str2 = gameConfiguration.getUrl();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(parentFile, StringKtxKt.urlName(str2))) {
                AudioHiloGameBinding audioHiloGameBinding17 = this.binding;
                if (audioHiloGameBinding17 != null && (constraintLayout3 = audioHiloGameBinding17.downloadLayout) != null) {
                    constraintLayout3.setVisibility(8);
                }
                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                String addGroupStatus = navigationHelper.addGroupStatus(navigationHelper.addUserStatus("file://" + gameFile.getAbsolutePath()), meetingRoomManager.getMGroupId());
                AudioHiloGameBinding audioHiloGameBinding18 = this.binding;
                if (audioHiloGameBinding18 != null && (baseWebView = audioHiloGameBinding18.webView) != null) {
                    baseWebView.loadUrl(addGroupStatus);
                }
                audioHiloGameBinding = this.binding;
                j = 800;
                if (audioHiloGameBinding != null && (constraintLayout2 = audioHiloGameBinding.betLayout) != null) {
                    constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$addHiloGameView$$inlined$singleClick$default$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                                ConstraintLayout constraintLayout7 = constraintLayout2;
                            }
                        }
                    });
                }
                audioHiloGameBinding2 = this.binding;
                if (audioHiloGameBinding2 != null && (constraintLayout = audioHiloGameBinding2.onLineLayout) != null) {
                    constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$addHiloGameView$$inlined$singleClick$default$2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            String str3;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                                ConstraintLayout constraintLayout7 = constraintLayout;
                                Context context3 = this.getFragment().getContext();
                                if (context3 != null) {
                                    RoomMemberOnlineActivity.Companion companion = RoomMemberOnlineActivity.INSTANCE;
                                    GroupDetailBean mGroupDetailBean = MeetingRoomManager.INSTANCE.getMGroupDetailBean();
                                    if (mGroupDetailBean == null || (str3 = mGroupDetailBean.getGroupId()) == null) {
                                        str3 = "";
                                    }
                                    companion.start(context3, str3, true);
                                }
                            }
                        }
                    });
                }
                audioHiloGameBinding3 = this.binding;
                if (audioHiloGameBinding3 != null && (recyclerView2 = audioHiloGameBinding3.micRecyclerView) != null) {
                    recyclerView2.setAdapter(getMHiloGameMicAdapter());
                }
                ArrayList arrayList = new ArrayList();
                currentMicSize = meetingRoomManager.getCurrentMicSize() - 1;
                if (currentMicSize >= 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i4));
                        if (microBean == null) {
                            microBean = MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i4, false, 2, null);
                        }
                        this.mMicroBeanListData.put(Integer.valueOf(i4), microBean);
                        arrayList.add(microBean);
                        if (i3 == currentMicSize) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                getMHiloGameMicAdapter().setList(arrayList);
                getMHiloGameMicAdapter().addChildClickViewIds(new int[]{R.id.base_micro, R.id.lock_micro, R.id.user_mute, 2131365536, R.id.mic_user_head_img, R.id.mic_user_head_svga});
                getMHiloGameMicAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.help.o6
                    public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view4, int i5) {
                        HiloGameHelp.addHiloGameView$lambda$8(HiloGameHelp.this, baseQuickAdapter, view4, i5);
                    }
                });
                getMHiloGameMicAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.help.p6
                    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view4, int i5) {
                        HiloGameHelp.addHiloGameView$lambda$9(HiloGameHelp.this, baseQuickAdapter, view4, i5);
                    }
                });
                audioHiloGameBinding4 = this.binding;
                if (audioHiloGameBinding4 != null && (recyclerView = audioHiloGameBinding4.micRecyclerView) != null) {
                    ViewExpansionKt.addScrollDistanceListener(recyclerView, new Function3() { // from class: com.qiahao.nextvideo.room.help.q6
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit addHiloGameView$lambda$10;
                            addHiloGameView$lambda$10 = HiloGameHelp.addHiloGameView$lambda$10(HiloGameHelp.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                            return addHiloGameView$lambda$10;
                        }
                    });
                }
                binding = this.fragment.getBinding();
                if (binding == null && (meetingRoomOnlineMemberLayout = binding.meetingRoomOnlineMember) != null) {
                    list = meetingRoomOnlineMemberLayout.getOnLineData();
                } else {
                    list = null;
                }
                refreshOnlineNumber(list);
                audioHiloGameBinding5 = this.binding;
                if (audioHiloGameBinding5 != null) {
                    return null;
                }
                return audioHiloGameBinding5.getRoot();
            }
        }
        if (gameConfiguration == null || (str = gameConfiguration.getUrl()) == null) {
            str = "";
        }
        if (gameConfiguration != null && (gameId = gameConfiguration.getGameId()) != null) {
            i2 = gameId.intValue();
        } else {
            i2 = 0;
        }
        hiloRoomGameMessage.downloadGame(str, i2, new GameListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$addHiloGameView$3
            @Override // com.qiahao.nextvideo.room.downloadGame.GameListener
            public void onDownloadFailed(Throwable throwable) {
                TextView textView;
                AudioHiloGameBinding binding8 = HiloGameHelp.this.getBinding();
                if (binding8 != null && (textView = binding8.downloadText) != null) {
                    textView.setText(ResourcesKtxKt.getStringById(this, 2131953242));
                }
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, HiloGameHelp.this.getFragment().getContext(), ResourcesKtxKt.getStringById(this, 2131953242), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }

            @Override // com.qiahao.nextvideo.room.downloadGame.GameListener
            public void onDownloadProgress(int progress) {
            }

            @Override // com.qiahao.nextvideo.room.downloadGame.GameListener
            public void onDownloadSuccess(String filePath) {
                BaseWebView baseWebView2;
                ConstraintLayout constraintLayout7;
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                AudioHiloGameBinding binding8 = HiloGameHelp.this.getBinding();
                if (binding8 != null && (constraintLayout7 = binding8.downloadLayout) != null) {
                    constraintLayout7.setVisibility(8);
                }
                NavigationHelper navigationHelper2 = NavigationHelper.INSTANCE;
                String addGroupStatus2 = navigationHelper2.addGroupStatus(navigationHelper2.addUserStatus("file://" + filePath), MeetingRoomManager.INSTANCE.getMGroupId());
                AudioHiloGameBinding binding9 = HiloGameHelp.this.getBinding();
                if (binding9 != null && (baseWebView2 = binding9.webView) != null) {
                    baseWebView2.loadUrl(addGroupStatus2);
                }
            }
        });
        audioHiloGameBinding = this.binding;
        j = 800;
        if (audioHiloGameBinding != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$addHiloGameView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                        ConstraintLayout constraintLayout7 = constraintLayout2;
                    }
                }
            });
        }
        audioHiloGameBinding2 = this.binding;
        if (audioHiloGameBinding2 != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$addHiloGameView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    String str3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout7 = constraintLayout;
                        Context context3 = this.getFragment().getContext();
                        if (context3 != null) {
                            RoomMemberOnlineActivity.Companion companion = RoomMemberOnlineActivity.INSTANCE;
                            GroupDetailBean mGroupDetailBean = MeetingRoomManager.INSTANCE.getMGroupDetailBean();
                            if (mGroupDetailBean == null || (str3 = mGroupDetailBean.getGroupId()) == null) {
                                str3 = "";
                            }
                            companion.start(context3, str3, true);
                        }
                    }
                }
            });
        }
        audioHiloGameBinding3 = this.binding;
        if (audioHiloGameBinding3 != null) {
            recyclerView2.setAdapter(getMHiloGameMicAdapter());
        }
        ArrayList arrayList2 = new ArrayList();
        currentMicSize = meetingRoomManager.getCurrentMicSize() - 1;
        if (currentMicSize >= 0) {
        }
        getMHiloGameMicAdapter().setList(arrayList2);
        getMHiloGameMicAdapter().addChildClickViewIds(new int[]{R.id.base_micro, R.id.lock_micro, R.id.user_mute, 2131365536, R.id.mic_user_head_img, R.id.mic_user_head_svga});
        getMHiloGameMicAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.help.o6
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view4, int i5) {
                HiloGameHelp.addHiloGameView$lambda$8(HiloGameHelp.this, baseQuickAdapter, view4, i5);
            }
        });
        getMHiloGameMicAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.help.p6
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view4, int i5) {
                HiloGameHelp.addHiloGameView$lambda$9(HiloGameHelp.this, baseQuickAdapter, view4, i5);
            }
        });
        audioHiloGameBinding4 = this.binding;
        if (audioHiloGameBinding4 != null) {
            ViewExpansionKt.addScrollDistanceListener(recyclerView, new Function3() { // from class: com.qiahao.nextvideo.room.help.q6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit addHiloGameView$lambda$10;
                    addHiloGameView$lambda$10 = HiloGameHelp.addHiloGameView$lambda$10(HiloGameHelp.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                    return addHiloGameView$lambda$10;
                }
            });
        }
        binding = this.fragment.getBinding();
        if (binding == null) {
        }
        list = null;
        refreshOnlineNumber(list);
        audioHiloGameBinding5 = this.binding;
        if (audioHiloGameBinding5 != null) {
        }
    }

    public final void betFlip(@Nullable final UserProxy1.NoticeBetGameBetTopN data) {
        View view;
        AudioHiloGameBinding audioHiloGameBinding = this.binding;
        if (audioHiloGameBinding != null && (view = audioHiloGameBinding.buttonLayout) != null) {
            ObjectAnimator rotationX = AnimationUtility.INSTANCE.rotationX(view, 0.0f, 360.0f);
            rotationX.setDuration(300L);
            rotationX.addListener(new AnimationListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$betFlip$1$1
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding2;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase2;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding3;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase3;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding4;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase4;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding5;
                    TextView textView;
                    long j;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    HiloGameHelp.this.refreshButtonView(false);
                    AudioHiloGameBinding binding = HiloGameHelp.this.getBinding();
                    if (binding != null && (textView = binding.betDiamond) != null) {
                        UserProxy1.NoticeBetGameBetTopN noticeBetGameBetTopN = data;
                        if (noticeBetGameBetTopN != null) {
                            j = noticeBetGameBetTopN.getTotalBetNum();
                        } else {
                            j = 0;
                        }
                        textView.setText(NumberUtilsKt.rankNumberFormat(j));
                    }
                    HiloGameHelp hiloGameHelp = HiloGameHelp.this;
                    AudioHiloGameBinding binding2 = hiloGameHelp.getBinding();
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase5 = null;
                    if (binding2 != null) {
                        audioHiloGameBetItemBinding = binding2.bet1;
                    } else {
                        audioHiloGameBetItemBinding = null;
                    }
                    if (!HiloGameHelp.this.getMBetList().isEmpty()) {
                        noticeBetGameBetTopNBase = HiloGameHelp.this.getMBetList().get(0);
                    } else {
                        noticeBetGameBetTopNBase = null;
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp, audioHiloGameBetItemBinding, noticeBetGameBetTopNBase, true, false, 8, null);
                    HiloGameHelp hiloGameHelp2 = HiloGameHelp.this;
                    AudioHiloGameBinding binding3 = hiloGameHelp2.getBinding();
                    if (binding3 != null) {
                        audioHiloGameBetItemBinding2 = binding3.bet2;
                    } else {
                        audioHiloGameBetItemBinding2 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 1) {
                        noticeBetGameBetTopNBase2 = HiloGameHelp.this.getMBetList().get(1);
                    } else {
                        noticeBetGameBetTopNBase2 = null;
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp2, audioHiloGameBetItemBinding2, noticeBetGameBetTopNBase2, false, false, 12, null);
                    HiloGameHelp hiloGameHelp3 = HiloGameHelp.this;
                    AudioHiloGameBinding binding4 = hiloGameHelp3.getBinding();
                    if (binding4 != null) {
                        audioHiloGameBetItemBinding3 = binding4.bet3;
                    } else {
                        audioHiloGameBetItemBinding3 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 2) {
                        noticeBetGameBetTopNBase3 = HiloGameHelp.this.getMBetList().get(2);
                    } else {
                        noticeBetGameBetTopNBase3 = null;
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp3, audioHiloGameBetItemBinding3, noticeBetGameBetTopNBase3, false, false, 12, null);
                    HiloGameHelp hiloGameHelp4 = HiloGameHelp.this;
                    AudioHiloGameBinding binding5 = hiloGameHelp4.getBinding();
                    if (binding5 != null) {
                        audioHiloGameBetItemBinding4 = binding5.bet4;
                    } else {
                        audioHiloGameBetItemBinding4 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 3) {
                        noticeBetGameBetTopNBase4 = HiloGameHelp.this.getMBetList().get(3);
                    } else {
                        noticeBetGameBetTopNBase4 = null;
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp4, audioHiloGameBetItemBinding4, noticeBetGameBetTopNBase4, false, false, 12, null);
                    HiloGameHelp hiloGameHelp5 = HiloGameHelp.this;
                    AudioHiloGameBinding binding6 = hiloGameHelp5.getBinding();
                    if (binding6 != null) {
                        audioHiloGameBetItemBinding5 = binding6.bet5;
                    } else {
                        audioHiloGameBetItemBinding5 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 4) {
                        noticeBetGameBetTopNBase5 = HiloGameHelp.this.getMBetList().get(4);
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp5, audioHiloGameBetItemBinding5, noticeBetGameBetTopNBase5, false, false, 12, null);
                }

                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    GameMusicHelper mGameMusicHelper = HiloGameHelp.this.getMGameMusicHelper();
                    if (mGameMusicHelper != null) {
                        GameMusicHelper.playMusic$default(mGameMusicHelper, R.raw.hilo_game_layout_filp, false, false, 0.8f, 4, null);
                    }
                }
            });
            rotationX.start();
        }
    }

    public final void changeGameMic(@NotNull List<MicroBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (this.binding == null) {
            return;
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.mMicroBeanListData.put(Integer.valueOf(i2), (MicroBean) obj);
            i = i2;
        }
        getMHiloGameMicAdapter().setList(list);
    }

    @Nullable
    public final ArcMotionAnimator getArcAnimator() {
        return this.arcAnimator;
    }

    @Nullable
    public final AudioHiloGameBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    @NotNull
    public final ArrayList<UserProxy.NoticeBetGameBetTopNBase> getMBetList() {
        return this.mBetList;
    }

    public final int getMDefaultViewHeight() {
        return this.mDefaultViewHeight;
    }

    @Nullable
    public final GameMusicHelper getMGameMusicHelper() {
        return this.mGameMusicHelper;
    }

    @NotNull
    public final HiloGameMicAdapter getMHiloGameMicAdapter() {
        return (HiloGameMicAdapter) this.mHiloGameMicAdapter.getValue();
    }

    @NotNull
    public final HashMap<Integer, MicroBean> getMMicroBeanListData() {
        return this.mMicroBeanListData;
    }

    @NotNull
    public final ArrayList<CurrentRoomOnlineBean> getMOriginal() {
        return this.mOriginal;
    }

    public final int getMScrollY() {
        return this.mScrollY;
    }

    public final int getMViewChangeHeight() {
        return this.mViewChangeHeight;
    }

    @NotNull
    public final ArrayList<CurrentRoomOnlineBean> getOnlineUserList() {
        return this.onlineUserList;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    /* renamed from: isScroll, reason: from getter */
    public final boolean getIsScroll() {
        return this.isScroll;
    }

    /* renamed from: isShowWin, reason: from getter */
    public final boolean getIsShowWin() {
        return this.isShowWin;
    }

    public final void notificationMicChange() {
        int currentMicSize = MeetingRoomManager.INSTANCE.getCurrentMicSize() - 1;
        if (currentMicSize >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i2));
                if (microBean == null) {
                    microBean = MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i2, false, 2, null);
                }
                MicroBean microBean2 = this.mMicroBeanListData.get(Integer.valueOf(i2));
                this.mMicroBeanListData.put(Integer.valueOf(i2), microBean);
                if (microBean2 != null && (!microBean2.checkDataIsEqual(microBean)) && i < getMHiloGameMicAdapter().getData().size()) {
                    getMHiloGameMicAdapter().getData().set(i, microBean);
                    getMHiloGameMicAdapter().notifyItemChanged(i, microBean);
                }
                if (i == currentMicSize) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        refreshOnlineNumber(null);
    }

    public final void refreshBet(@Nullable UserProxy1.NoticeBetGame eventData) {
        Integer num;
        Integer num2;
        RecyclerView.LayoutManager layoutManager;
        LinearLayoutManager linearLayoutManager;
        int i;
        int i2;
        int i3;
        String str;
        int px;
        int i4;
        int px2;
        int i5;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        String str2;
        int px3;
        int px4;
        int intValue;
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView;
        if (this.binding == null) {
            return;
        }
        GameConfiguration mHiloGameConfiguration = MeetingRoomManager.INSTANCE.getMHiloGameConfiguration();
        if (mHiloGameConfiguration != null) {
            num = mHiloGameConfiguration.getGameId();
        } else {
            num = null;
        }
        if (eventData != null) {
            num2 = Integer.valueOf(eventData.getGameId());
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            return;
        }
        if (this.isShowWin) {
            refreshButtonRank(null);
        }
        if (this.isScroll) {
            return;
        }
        AudioHiloGameBinding audioHiloGameBinding = this.binding;
        if (audioHiloGameBinding != null && (recyclerView = audioHiloGameBinding.micRecyclerView) != null) {
            layoutManager = recyclerView.getLayoutManager();
        } else {
            layoutManager = null;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            i = linearLayoutManager.findFirstVisibleItemPosition();
        } else {
            i = 0;
        }
        int i6 = i + 1;
        if (linearLayoutManager != null) {
            i2 = linearLayoutManager.findLastVisibleItemPosition();
        } else {
            i2 = 0;
        }
        int i7 = i2 + 1;
        AudioHiloGameBinding audioHiloGameBinding2 = this.binding;
        if (audioHiloGameBinding2 != null && (constraintLayout = audioHiloGameBinding2.gameLayout) != null) {
            i3 = constraintLayout.getWidth();
        } else {
            i3 = 0;
        }
        int i8 = i3 / 2;
        Set<Map.Entry<Integer, MicroBean>> entrySet = this.mMicroBeanListData.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String externalId = ((MicroBean) entry.getValue()).getExternalId();
            if (eventData != null) {
                str2 = eventData.getExternalId();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(externalId, str2)) {
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                int intValue2 = ((Number) key).intValue();
                if (i6 <= intValue2 && intValue2 <= i7) {
                    HiloUtils hiloUtils = HiloUtils.INSTANCE;
                    if (hiloUtils.getRightToLeftDirection()) {
                        px3 = UiKtxKt.toPX(50);
                    } else {
                        px3 = (i8 * 2) + UiKtxKt.toPX(40);
                    }
                    int intValue3 = (((((Number) entry.getKey()).intValue() - 1) * UiKtxKt.toPX(45)) + UiKtxKt.toPX(18)) - this.mScrollY;
                    if (hiloUtils.getRightToLeftDirection()) {
                        px4 = UiKtxKt.toPX(UserProxyUtility.exitRoom);
                    } else {
                        px4 = i8 + UiKtxKt.toPX(80);
                    }
                    if (((Number) entry.getKey()).intValue() < 6) {
                        intValue = ((Number) entry.getKey()).intValue();
                    } else {
                        intValue = ((Number) entry.getKey()).intValue() - 2;
                    }
                    int px5 = ((intValue * UiKtxKt.toPX(45)) + UiKtxKt.toPX(18)) - this.mScrollY;
                    Object key2 = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                    startDiamondAnimation(px3, intValue3, px4, px5, ((Number) key2).intValue());
                    return;
                }
            }
        }
        Iterator<T> it2 = this.onlineUserList.iterator();
        while (it2.hasNext()) {
            String externalId2 = ((CurrentRoomOnlineBean) it2.next()).getExternalId();
            if (eventData != null) {
                str = eventData.getExternalId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(externalId2, str)) {
                HiloUtils hiloUtils2 = HiloUtils.INSTANCE;
                if (hiloUtils2.getRightToLeftDirection()) {
                    px = UiKtxKt.toPX(50);
                } else {
                    px = (i8 * 2) + UiKtxKt.toPX(40);
                }
                AudioHiloGameBinding audioHiloGameBinding3 = this.binding;
                if (audioHiloGameBinding3 != null && (linearLayout2 = audioHiloGameBinding3.micLayout) != null) {
                    i4 = linearLayout2.getHeight();
                } else {
                    i4 = 0;
                }
                int px6 = i4 + UiKtxKt.toPX(25);
                if (hiloUtils2.getRightToLeftDirection()) {
                    px2 = UiKtxKt.toPX(UserProxyUtility.exitRoom);
                } else {
                    px2 = UiKtxKt.toPX(80) + i8;
                }
                int i9 = px2;
                AudioHiloGameBinding audioHiloGameBinding4 = this.binding;
                if (audioHiloGameBinding4 != null && (linearLayout = audioHiloGameBinding4.micLayout) != null) {
                    i5 = linearLayout.getHeight();
                } else {
                    i5 = 0;
                }
                startDiamondAnimation(px, px6, i9, i5 - UiKtxKt.toPX(50), 21);
            }
        }
    }

    public final void refreshBetView(@Nullable AudioHiloGameBetItemBinding viewBinding, @Nullable UserProxy.NoticeBetGameBetTopNBase data, boolean isOnePosition, boolean isWin) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        QMUIRadiusImageView qMUIRadiusImageView;
        ImageView imageView3;
        TextView textView2;
        QMUIRadiusImageView qMUIRadiusImageView2;
        if (data == null) {
            if (viewBinding != null && (qMUIRadiusImageView2 = viewBinding.image) != null) {
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.hilo_game_default_avatar), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
            if (viewBinding != null && (textView2 = viewBinding.diamond) != null) {
                textView2.setText(MessageService.MSG_DB_READY_REPORT);
            }
            if (isOnePosition && viewBinding != null && (imageView3 = viewBinding.oneHead) != null) {
                imageView3.setVisibility(8);
                return;
            }
            return;
        }
        if (viewBinding != null && (qMUIRadiusImageView = viewBinding.image) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, data.getUser().getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        if (viewBinding != null && (textView = viewBinding.diamond) != null) {
            textView.setText(NumberUtilsKt.rankNumberFormat(data.getNum()));
        }
        if (isOnePosition && isWin) {
            if (viewBinding != null && (imageView2 = viewBinding.oneHead) != null) {
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        if (viewBinding != null && (imageView = viewBinding.oneHead) != null) {
            imageView.setVisibility(8);
        }
    }

    public final void refreshButtonRank(@Nullable UserProxy1.NoticeBetGameBetTopN data) {
        List<UserProxy.NoticeBetGameBetTopNBase> arrayList;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding;
        UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding2;
        UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase2;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding3;
        UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase3;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding4;
        UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase4;
        AudioHiloGameBetItemBinding audioHiloGameBetItemBinding5;
        TextView textView;
        long j;
        if (data != null) {
            GameConfiguration mHiloGameConfiguration = MeetingRoomManager.INSTANCE.getMHiloGameConfiguration();
            if (mHiloGameConfiguration != null) {
                Integer gameId = mHiloGameConfiguration.getGameId();
                int gameId2 = data.getGameId();
                if (gameId == null || gameId.intValue() != gameId2) {
                    return;
                }
            } else {
                return;
            }
        }
        this.mBetList.clear();
        ArrayList<UserProxy.NoticeBetGameBetTopNBase> arrayList2 = this.mBetList;
        if (data == null || (arrayList = data.getListList()) == null) {
            arrayList = new ArrayList<>();
        }
        arrayList2.addAll(arrayList);
        if (this.isShowWin) {
            betFlip(data);
        } else {
            refreshButtonView(false);
            AudioHiloGameBinding audioHiloGameBinding = this.binding;
            if (audioHiloGameBinding != null && (textView = audioHiloGameBinding.betDiamond) != null) {
                if (data != null) {
                    j = data.getTotalBetNum();
                } else {
                    j = 0;
                }
                textView.setText(NumberUtilsKt.rankNumberFormat(j));
            }
            AudioHiloGameBinding audioHiloGameBinding2 = this.binding;
            UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase5 = null;
            if (audioHiloGameBinding2 != null) {
                audioHiloGameBetItemBinding = audioHiloGameBinding2.bet1;
            } else {
                audioHiloGameBetItemBinding = null;
            }
            if (!this.mBetList.isEmpty()) {
                noticeBetGameBetTopNBase = this.mBetList.get(0);
            } else {
                noticeBetGameBetTopNBase = null;
            }
            refreshBetView$default(this, audioHiloGameBetItemBinding, noticeBetGameBetTopNBase, true, false, 8, null);
            AudioHiloGameBinding audioHiloGameBinding3 = this.binding;
            if (audioHiloGameBinding3 != null) {
                audioHiloGameBetItemBinding2 = audioHiloGameBinding3.bet2;
            } else {
                audioHiloGameBetItemBinding2 = null;
            }
            if (this.mBetList.size() > 1) {
                noticeBetGameBetTopNBase2 = this.mBetList.get(1);
            } else {
                noticeBetGameBetTopNBase2 = null;
            }
            refreshBetView$default(this, audioHiloGameBetItemBinding2, noticeBetGameBetTopNBase2, false, false, 12, null);
            AudioHiloGameBinding audioHiloGameBinding4 = this.binding;
            if (audioHiloGameBinding4 != null) {
                audioHiloGameBetItemBinding3 = audioHiloGameBinding4.bet3;
            } else {
                audioHiloGameBetItemBinding3 = null;
            }
            if (this.mBetList.size() > 2) {
                noticeBetGameBetTopNBase3 = this.mBetList.get(2);
            } else {
                noticeBetGameBetTopNBase3 = null;
            }
            refreshBetView$default(this, audioHiloGameBetItemBinding3, noticeBetGameBetTopNBase3, false, false, 12, null);
            AudioHiloGameBinding audioHiloGameBinding5 = this.binding;
            if (audioHiloGameBinding5 != null) {
                audioHiloGameBetItemBinding4 = audioHiloGameBinding5.bet4;
            } else {
                audioHiloGameBetItemBinding4 = null;
            }
            if (this.mBetList.size() > 3) {
                noticeBetGameBetTopNBase4 = this.mBetList.get(3);
            } else {
                noticeBetGameBetTopNBase4 = null;
            }
            refreshBetView$default(this, audioHiloGameBetItemBinding4, noticeBetGameBetTopNBase4, false, false, 12, null);
            AudioHiloGameBinding audioHiloGameBinding6 = this.binding;
            if (audioHiloGameBinding6 != null) {
                audioHiloGameBetItemBinding5 = audioHiloGameBinding6.bet5;
            } else {
                audioHiloGameBetItemBinding5 = null;
            }
            if (this.mBetList.size() > 4) {
                noticeBetGameBetTopNBase5 = this.mBetList.get(4);
            }
            refreshBetView$default(this, audioHiloGameBetItemBinding5, noticeBetGameBetTopNBase5, false, false, 12, null);
        }
        this.isShowWin = false;
    }

    public final void refreshButtonView(boolean isWin) {
        TextView textView;
        TextView textView2;
        View view;
        Context context;
        AudioHiloGameBinding audioHiloGameBinding;
        View view2;
        TextView textView3;
        TextView textView4;
        View view3;
        Context context2;
        AudioHiloGameBinding audioHiloGameBinding2;
        View view4;
        if (isWin) {
            AudioHiloGameBinding audioHiloGameBinding3 = this.binding;
            if (audioHiloGameBinding3 != null && (view3 = audioHiloGameBinding3.betBg) != null && (context2 = view3.getContext()) != null && (audioHiloGameBinding2 = this.binding) != null && (view4 = audioHiloGameBinding2.betBg) != null) {
                view4.setBackground(androidx.core.content.a.getDrawable(context2, R.drawable.hilo_game_win_bg));
            }
            AudioHiloGameBinding audioHiloGameBinding4 = this.binding;
            if (audioHiloGameBinding4 != null && (textView4 = audioHiloGameBinding4.betTitle) != null) {
                textView4.setText(ResourcesKtxKt.getStringById(textView4, 2131954504));
                textView4.setTextColor(Color.parseColor("#8C3712"));
            }
            AudioHiloGameBinding audioHiloGameBinding5 = this.binding;
            if (audioHiloGameBinding5 != null && (textView3 = audioHiloGameBinding5.betDiamond) != null) {
                textView3.setTextColor(Color.parseColor("#8C3712"));
                return;
            }
            return;
        }
        AudioHiloGameBinding audioHiloGameBinding6 = this.binding;
        if (audioHiloGameBinding6 != null && (view = audioHiloGameBinding6.betBg) != null && (context = view.getContext()) != null && (audioHiloGameBinding = this.binding) != null && (view2 = audioHiloGameBinding.betBg) != null) {
            view2.setBackground(androidx.core.content.a.getDrawable(context, R.drawable.hilo_game_bet_bg));
        }
        AudioHiloGameBinding audioHiloGameBinding7 = this.binding;
        if (audioHiloGameBinding7 != null && (textView2 = audioHiloGameBinding7.betTitle) != null) {
            textView2.setText(ResourcesKtxKt.getStringById(textView2, 2131952106));
            textView2.setTextColor(Color.parseColor("#0A5426"));
        }
        AudioHiloGameBinding audioHiloGameBinding8 = this.binding;
        if (audioHiloGameBinding8 != null && (textView = audioHiloGameBinding8.betDiamond) != null) {
            textView.setTextColor(Color.parseColor("#0A5426"));
        }
    }

    public final void refreshOnlineNumber(@Nullable List<CurrentRoomOnlineBean> data) {
        QMUIRadiusImageView qMUIRadiusImageView;
        QMUIRadiusImageView qMUIRadiusImageView2;
        QMUIRadiusImageView qMUIRadiusImageView3;
        String str;
        QMUIRadiusImageView qMUIRadiusImageView4;
        String str2;
        TextView textView;
        if (data != null) {
            this.mOriginal.clear();
            this.mOriginal.addAll(data);
        }
        this.onlineUserList.clear();
        AudioHiloGameBinding audioHiloGameBinding = this.binding;
        if (audioHiloGameBinding != null && (textView = audioHiloGameBinding.count) != null) {
            textView.setText(String.valueOf(this.mOriginal.size()));
        }
        Iterator<T> it = this.mOriginal.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            CurrentRoomOnlineBean currentRoomOnlineBean = (CurrentRoomOnlineBean) it.next();
            Iterator<Map.Entry<Integer, MicroBean>> it2 = this.mMicroBeanListData.entrySet().iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(currentRoomOnlineBean.getExternalId(), it2.next().getValue().getExternalId())) {
                    z = true;
                }
            }
            if (!z) {
                this.onlineUserList.add(currentRoomOnlineBean);
            }
        }
        if (!this.onlineUserList.isEmpty()) {
            AudioHiloGameBinding audioHiloGameBinding2 = this.binding;
            if (audioHiloGameBinding2 != null && (qMUIRadiusImageView4 = audioHiloGameBinding2.leftAvatar) != null) {
                String avatar = this.onlineUserList.get(0).getAvatar();
                if (avatar == null) {
                    str2 = "";
                } else {
                    str2 = avatar;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView4, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        } else {
            AudioHiloGameBinding audioHiloGameBinding3 = this.binding;
            if (audioHiloGameBinding3 != null && (qMUIRadiusImageView = audioHiloGameBinding3.leftAvatar) != null) {
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.hilo_game_default_avatar), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
        }
        if (this.onlineUserList.size() > 1) {
            AudioHiloGameBinding audioHiloGameBinding4 = this.binding;
            if (audioHiloGameBinding4 != null && (qMUIRadiusImageView3 = audioHiloGameBinding4.rightAvatar) != null) {
                String avatar2 = this.onlineUserList.get(1).getAvatar();
                if (avatar2 == null) {
                    str = "";
                } else {
                    str = avatar2;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView3, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                return;
            }
            return;
        }
        AudioHiloGameBinding audioHiloGameBinding5 = this.binding;
        if (audioHiloGameBinding5 != null && (qMUIRadiusImageView2 = audioHiloGameBinding5.rightAvatar) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.hilo_game_default_avatar), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
    }

    public final void removeHiloGameView() {
        FrameLayout frameLayout;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        AudioHiloGameBinding audioHiloGameBinding = this.binding;
        if (audioHiloGameBinding != null && (sVGAImageView2 = audioHiloGameBinding.winSvga) != null) {
            sVGAImageView2.stopAnimation(true);
        }
        AudioHiloGameBinding audioHiloGameBinding2 = this.binding;
        if (audioHiloGameBinding2 != null && (sVGAImageView = audioHiloGameBinding2.downloadSvga) != null) {
            sVGAImageView.stopAnimation(true);
        }
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout = binding.gameLayout) != null) {
            frameLayout.removeAllViews();
        }
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        this.binding = null;
        ArcMotionAnimator arcMotionAnimator = this.arcAnimator;
        if (arcMotionAnimator != null) {
            arcMotionAnimator.stop();
        }
        this.arcAnimator = null;
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "hilo_game_open", Boolean.FALSE, (String) null, 4, (Object) null);
    }

    public final void setArcAnimator(@Nullable ArcMotionAnimator arcMotionAnimator) {
        this.arcAnimator = arcMotionAnimator;
    }

    public final void setBetBg(@Nullable AudioHiloGameBetItemBinding binding, final int position) {
        final View root;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        if (binding != null && (constraintLayout2 = binding.constraint) != null) {
            constraintLayout2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33ffffff", "#33ffffff", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (binding != null && (constraintLayout = binding.buttonConstraint) != null) {
            constraintLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33000000", "#33000000", 0, 0, 8, 8, (GradientDrawable.Orientation) null, 64, (Object) null));
        }
        if (binding != null && (root = binding.getRoot()) != null) {
            final long j = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$setBetBg$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioRoomDialogHelp mDialogHelp;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        if (this.getMBetList().size() > position && (mDialogHelp = this.getFragment().getMDialogHelp()) != null) {
                            String externalId = this.getMBetList().get(position).getUser().getExternalId();
                            String str = "";
                            if (externalId == null) {
                                externalId = "";
                            }
                            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                            String externalId2 = this.getMBetList().get(position).getUser().getExternalId();
                            if (externalId2 != null) {
                                str = externalId2;
                            }
                            mDialogHelp.showUserInfoDialog(externalId, meetingRoomManager.findMicPositionFromExtraId(str));
                        }
                    }
                }
            });
        }
    }

    public final void setBinding(@Nullable AudioHiloGameBinding audioHiloGameBinding) {
        this.binding = audioHiloGameBinding;
    }

    public final void setMBetList(@NotNull ArrayList<UserProxy.NoticeBetGameBetTopNBase> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mBetList = arrayList;
    }

    public final void setMDefaultViewHeight(int i) {
        this.mDefaultViewHeight = i;
    }

    public final void setMGameMusicHelper(@Nullable GameMusicHelper gameMusicHelper) {
        this.mGameMusicHelper = gameMusicHelper;
    }

    public final void setMMicroBeanListData(@NotNull HashMap<Integer, MicroBean> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.mMicroBeanListData = hashMap;
    }

    public final void setMOriginal(@NotNull ArrayList<CurrentRoomOnlineBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mOriginal = arrayList;
    }

    public final void setMScrollY(int i) {
        this.mScrollY = i;
    }

    public final void setMViewChangeHeight(int i) {
        this.mViewChangeHeight = i;
    }

    public final void setOnlineUserList(@NotNull ArrayList<CurrentRoomOnlineBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.onlineUserList = arrayList;
    }

    public final void setScroll(boolean z) {
        this.isScroll = z;
    }

    public final void setShowWin(boolean z) {
        this.isShowWin = z;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public final void showFace(int index, @NotNull String faceSVGAUrl) {
        Intrinsics.checkNotNullParameter(faceSVGAUrl, "faceSVGAUrl");
        if (index < 0 || index > getMHiloGameMicAdapter().getData().size() || faceSVGAUrl.length() == 0) {
            return;
        }
        getMHiloGameMicAdapter().notifyItemChanged(index, faceSVGAUrl);
    }

    public final void showMicSpeakWaveAnim(@NotNull List<Integer> list) {
        MicroUserBean microUserBean;
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int intValue = list.get(i).intValue();
            int i2 = intValue - 1;
            if (i2 < this.mMicroBeanListData.size() && intValue >= 0 && intValue <= getMHiloGameMicAdapter().getData().size()) {
                MicroBean microBean = this.mMicroBeanListData.get(Integer.valueOf(intValue));
                if (microBean != null) {
                    microUserBean = microBean.getUser();
                } else {
                    microUserBean = null;
                }
                if (microUserBean != null) {
                    getMHiloGameMicAdapter().notifyItemChanged(i2, 100);
                }
            }
        }
    }

    public final void startDiamondAnimation(int startX, int startY, int endX, int endY, int position) {
        AudioHiloGameBinding audioHiloGameBinding;
        GameMusicHelper gameMusicHelper = this.mGameMusicHelper;
        if (gameMusicHelper != null) {
            gameMusicHelper.playMusic(R.raw.hilo_game_add_diamond, false, true, 0.8f);
        }
        if (this.arcAnimator == null && (audioHiloGameBinding = this.binding) != null) {
            ConstraintLayout constraintLayout = audioHiloGameBinding.gameConstraint;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "gameConstraint");
            ArcMotionAnimator arcMotionAnimator = new ArcMotionAnimator(constraintLayout);
            this.arcAnimator = arcMotionAnimator;
            Lifecycle lifecycle = this.fragment.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            arcMotionAnimator.bindLifecycle(lifecycle);
        }
        ArcMotionAnimator arcMotionAnimator2 = this.arcAnimator;
        if (arcMotionAnimator2 != null) {
            arcMotionAnimator2.addAnimation(startX, startY, endX, endY, position);
        }
    }

    public final void startNewRound(int time) {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = time * 1000;
        CountDownTimer countDownTimer2 = new CountDownTimer(j) { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$startNewRound$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (HiloGameHelp.this.getIsShowWin()) {
                    HiloGameHelp.this.refreshButtonRank(null);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }
        };
        this.timerTask = countDownTimer2;
        countDownTimer2.start();
    }

    public final void winFlip(@NotNull final UserProxy1.NoticeBetGameWinTopN data) {
        View view;
        Intrinsics.checkNotNullParameter(data, "data");
        AudioHiloGameBinding audioHiloGameBinding = this.binding;
        if (audioHiloGameBinding != null && (view = audioHiloGameBinding.betLayout) != null) {
            ObjectAnimator rotationY = AnimationUtility.INSTANCE.rotationY(view, 0.0f, 1080.0f);
            rotationY.setDuration(500L);
            rotationY.addListener(new AnimationListener() { // from class: com.qiahao.nextvideo.room.help.HiloGameHelp$winFlip$1$1
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding2;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase2;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding3;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase3;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding4;
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase4;
                    AudioHiloGameBetItemBinding audioHiloGameBetItemBinding5;
                    SVGAImageView sVGAImageView;
                    TextView textView;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    HiloGameHelp.this.refreshButtonView(true);
                    AudioHiloGameBinding binding = HiloGameHelp.this.getBinding();
                    if (binding != null && (textView = binding.betDiamond) != null) {
                        textView.setText(NumberUtilsKt.rankNumberFormat(data.getTotalWinNum()));
                    }
                    HiloGameHelp hiloGameHelp = HiloGameHelp.this;
                    AudioHiloGameBinding binding2 = hiloGameHelp.getBinding();
                    UserProxy.NoticeBetGameBetTopNBase noticeBetGameBetTopNBase5 = null;
                    if (binding2 != null) {
                        audioHiloGameBetItemBinding = binding2.bet1;
                    } else {
                        audioHiloGameBetItemBinding = null;
                    }
                    if (!HiloGameHelp.this.getMBetList().isEmpty()) {
                        noticeBetGameBetTopNBase = HiloGameHelp.this.getMBetList().get(0);
                    } else {
                        noticeBetGameBetTopNBase = null;
                    }
                    hiloGameHelp.refreshBetView(audioHiloGameBetItemBinding, noticeBetGameBetTopNBase, true, true);
                    HiloGameHelp hiloGameHelp2 = HiloGameHelp.this;
                    AudioHiloGameBinding binding3 = hiloGameHelp2.getBinding();
                    if (binding3 != null) {
                        audioHiloGameBetItemBinding2 = binding3.bet2;
                    } else {
                        audioHiloGameBetItemBinding2 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 1) {
                        noticeBetGameBetTopNBase2 = HiloGameHelp.this.getMBetList().get(1);
                    } else {
                        noticeBetGameBetTopNBase2 = null;
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp2, audioHiloGameBetItemBinding2, noticeBetGameBetTopNBase2, false, false, 12, null);
                    HiloGameHelp hiloGameHelp3 = HiloGameHelp.this;
                    AudioHiloGameBinding binding4 = hiloGameHelp3.getBinding();
                    if (binding4 != null) {
                        audioHiloGameBetItemBinding3 = binding4.bet3;
                    } else {
                        audioHiloGameBetItemBinding3 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 2) {
                        noticeBetGameBetTopNBase3 = HiloGameHelp.this.getMBetList().get(2);
                    } else {
                        noticeBetGameBetTopNBase3 = null;
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp3, audioHiloGameBetItemBinding3, noticeBetGameBetTopNBase3, false, false, 12, null);
                    HiloGameHelp hiloGameHelp4 = HiloGameHelp.this;
                    AudioHiloGameBinding binding5 = hiloGameHelp4.getBinding();
                    if (binding5 != null) {
                        audioHiloGameBetItemBinding4 = binding5.bet4;
                    } else {
                        audioHiloGameBetItemBinding4 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 3) {
                        noticeBetGameBetTopNBase4 = HiloGameHelp.this.getMBetList().get(3);
                    } else {
                        noticeBetGameBetTopNBase4 = null;
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp4, audioHiloGameBetItemBinding4, noticeBetGameBetTopNBase4, false, false, 12, null);
                    HiloGameHelp hiloGameHelp5 = HiloGameHelp.this;
                    AudioHiloGameBinding binding6 = hiloGameHelp5.getBinding();
                    if (binding6 != null) {
                        audioHiloGameBetItemBinding5 = binding6.bet5;
                    } else {
                        audioHiloGameBetItemBinding5 = null;
                    }
                    if (HiloGameHelp.this.getMBetList().size() > 4) {
                        noticeBetGameBetTopNBase5 = HiloGameHelp.this.getMBetList().get(4);
                    }
                    HiloGameHelp.refreshBetView$default(hiloGameHelp5, audioHiloGameBetItemBinding5, noticeBetGameBetTopNBase5, false, false, 12, null);
                    AudioHiloGameBinding binding7 = HiloGameHelp.this.getBinding();
                    if (binding7 != null && (sVGAImageView = binding7.winSvga) != null) {
                        sVGAImageView.startAnimation();
                    }
                }

                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    GameMusicHelper mGameMusicHelper = HiloGameHelp.this.getMGameMusicHelper();
                    if (mGameMusicHelper != null) {
                        GameMusicHelper.playMusic$default(mGameMusicHelper, R.raw.hilo_game_win_flip, false, false, 0.8f, 4, null);
                    }
                }
            });
            rotationY.start();
        }
    }

    public final void winRank(@NotNull UserProxy1.NoticeBetGameWinTopN data) {
        Intrinsics.checkNotNullParameter(data, "data");
        GameConfiguration mHiloGameConfiguration = MeetingRoomManager.INSTANCE.getMHiloGameConfiguration();
        if (mHiloGameConfiguration != null) {
            Integer gameId = mHiloGameConfiguration.getGameId();
            int gameId2 = data.getGameId();
            if (gameId != null && gameId.intValue() == gameId2) {
                this.isShowWin = true;
                this.mBetList.clear();
                this.mBetList.addAll(data.getListList());
                winFlip(data);
                startNewRound(data.getRemainSeconds());
            }
        }
    }
}
