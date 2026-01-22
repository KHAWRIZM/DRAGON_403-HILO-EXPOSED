package com.qiahao.nextvideo.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.material.tabs.TabLayout;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.oudi.widget.CustomTabLayout;
import com.oudi.widget.NoScrollViewPager;
import com.oudi.widget.ViewKtxKt;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.UserAuth;
import com.qhqc.core.feature.community.CommunityManager;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.CommunityDoubleTabEvent;
import com.qiahao.base_common.model.eventBus.HomePageEvent;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.player.svga.SVGAMediaSource;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.utils.language.LanguageHelper;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.MainActivity;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeData;
import com.qiahao.nextvideo.data.firstCharge.ListData;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.MatchingFloatData;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.TIMService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.databinding.FragmentHomeBinding;
import com.qiahao.nextvideo.databinding.ViewControllerHomeDrawerHeadLayoutBinding;
import com.qiahao.nextvideo.flowingdrawer.ElasticDrawer;
import com.qiahao.nextvideo.flowingdrawer.FlowingDrawer;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.register.CommunityRegister;
import com.qiahao.nextvideo.room.SkinMessage;
import com.qiahao.nextvideo.room.adapter.ViewPagerFragmentAdapter;
import com.qiahao.nextvideo.ui.aristocracy.BuyAristocracyActivity;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.InteractiveTrackingType;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.FriendStatusListActivity;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.ui.family.FamilyRankActivity;
import com.qiahao.nextvideo.ui.gameLevel.GameLevelActivity;
import com.qiahao.nextvideo.ui.giftRecords.GiftRecordActivity;
import com.qiahao.nextvideo.ui.home.chat.HomeChatFragment;
import com.qiahao.nextvideo.ui.home.community.HomeCommunityFragment;
import com.qiahao.nextvideo.ui.home.game.HomeGameFragment;
import com.qiahao.nextvideo.ui.home.group.HomeRoomFragment;
import com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment;
import com.qiahao.nextvideo.ui.home.medal.MedalActivity;
import com.qiahao.nextvideo.ui.home.tab.MainTabLayoutAdapter;
import com.qiahao.nextvideo.ui.home.tab.MainTabView;
import com.qiahao.nextvideo.ui.im.MessageDataListener;
import com.qiahao.nextvideo.ui.im.MessageListInfo;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.setting.SettingActivity;
import com.qiahao.nextvideo.ui.store.StoreActivity;
import com.qiahao.nextvideo.ui.svip.SvipActivity;
import com.qiahao.nextvideo.ui.task.TasksActivity;
import com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallActivity;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.NotificationKt;
import com.qiahao.nextvideo.utilities.PermissionUtils;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.video.CameraCapturerConfiguration;
import io.agora.rtc.video.VideoCanvas;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
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
import userProxy.UserProxy;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u0015\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0004J\r\u0010$\u001a\u00020\u0005¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R&\u00100\u001a\u0012\u0012\u0004\u0012\u00020.0-j\b\u0012\u0004\u0012\u00020.`/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/HomeFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentHomeBinding;", "<init>", "()V", "", "initView", "showSVGA", "setupObserver", "refreshSkin", "Lcom/qiahao/base_common/model/common/User;", "user", "updateIMUserNameAndAvatar", "(Lcom/qiahao/base_common/model/common/User;)V", "startCameraPreview", "closeCameraPreview", "", "getLayoutResId", "()I", "onInitialize", "position", "setPositionBg", "(I)V", "selectPosition", "", "onBackPressedIntercept", "()Z", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/VideoEvent;)V", "Lcom/qiahao/base_common/model/eventBus/HomePageEvent;", "onHomePageEvent", "(Lcom/qiahao/base_common/model/eventBus/HomePageEvent;)V", "onResume", "onStop", "checkFistCharge", "onDestroy", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mFragments", "Ljava/util/ArrayList;", "Landroid/view/TextureView;", "localRendererView", "Landroid/view/TextureView;", "Lcom/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment;", "matchFragment", "Lcom/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment;", "", "lastClickTime", "J", "notificationsEnabled", "Z", "Landroid/view/GestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "Landroid/view/View$OnTouchListener;", "tabOnTouchListener", "Landroid/view/View$OnTouchListener;", "Lcom/google/android/material/tabs/TabLayout$d;", "mTabSelectListener", "Lcom/google/android/material/tabs/TabLayout$d;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeFragment.kt\ncom/qiahao/nextvideo/ui/home/HomeFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,857:1\n61#2,9:858\n61#2,9:867\n61#2,9:876\n61#2,9:885\n61#2,9:894\n61#2,9:903\n61#2,9:912\n61#2,9:921\n61#2,9:930\n61#2,9:939\n61#2,9:948\n61#2,9:957\n61#2,9:966\n61#2,9:975\n61#2,9:984\n61#2,9:993\n61#2,9:1002\n1#3:1011\n1869#4,2:1012\n*S KotlinDebug\n*F\n+ 1 HomeFragment.kt\ncom/qiahao/nextvideo/ui/home/HomeFragment\n*L\n281#1:858,9\n284#1:867,9\n289#1:876,9\n294#1:885,9\n299#1:894,9\n304#1:903,9\n309#1:912,9\n314#1:921,9\n319#1:930,9\n324#1:939,9\n329#1:948,9\n334#1:957,9\n339#1:966,9\n356#1:975,9\n361#1:984,9\n367#1:993,9\n382#1:1002,9\n824#1:1012,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeFragment extends BaseBindingFragment<FragmentHomeBinding> {

    @NotNull
    public static final String TAG = "HomeFragment";

    @Nullable
    private GestureDetector gestureDetector;
    private long lastClickTime;

    @Nullable
    private TextureView localRendererView;

    @Nullable
    private TabLayout.d mTabSelectListener;

    @Nullable
    private HomeMatchingFragment matchFragment;
    private boolean notificationsEnabled;
    private static final int CLICK_TIME = HonorResultCode.ADVANCED_RECORD_SUCCESS;

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener tabOnTouchListener = new View.OnTouchListener() { // from class: com.qiahao.nextvideo.ui.home.d0
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean tabOnTouchListener$lambda$1;
            tabOnTouchListener$lambda$1 = HomeFragment.tabOnTouchListener$lambda$1(HomeFragment.this, view, motionEvent);
            return tabOnTouchListener$lambda$1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkFistCharge$lambda$59(HomeFragment homeFragment, ApiResponse apiResponse) {
        boolean z;
        TextView textView;
        ArrayList list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ListData listData = (ListData) apiResponse.getData();
        int i = 0;
        if (listData != null && (list = listData.getList()) != null) {
            Iterator it = list.iterator();
            z = false;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((FirstChargeData) it.next()).getHasGetReward(), Boolean.FALSE)) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) homeFragment.getBinding();
        if (fragmentHomeBinding != null && (textView = fragmentHomeBinding.recharge) != null) {
            if (!z) {
                i = 8;
            }
            textView.setVisibility(i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkFistCharge$lambda$60(HomeFragment homeFragment, Throwable th) {
        TextView textView;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) homeFragment.getBinding();
        if (fragmentHomeBinding != null && (textView = fragmentHomeBinding.recharge) != null) {
            textView.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    private final void closeCameraPreview() {
        ImageView imageView;
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        agoraRtcService.enableLocalVideo(false);
        RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.stopPreview();
        }
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (imageView = fragmentHomeBinding.backGround) != null) {
            imageView.setVisibility(0);
        }
        TextureView textureView = this.localRendererView;
        if (textureView != null) {
            textureView.setVisibility(8);
        }
    }

    private final void initView() {
        CustomTabLayout customTabLayout;
        TabLayout.f tabAt;
        TabLayout.TabView tabView;
        final FrameLayout frameLayout;
        final HiloImageView hiloImageView;
        final FrameLayout frameLayout2;
        final FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        final FrameLayout frameLayout5;
        final FrameLayout frameLayout6;
        final FrameLayout frameLayout7;
        final FrameLayout frameLayout8;
        final FrameLayout frameLayout9;
        final FrameLayout frameLayout10;
        final FrameLayout frameLayout11;
        final ConstraintLayout constraintLayout;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding;
        final LinearLayout linearLayout;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding2;
        final LinearLayoutCompat linearLayoutCompat;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding3;
        final LinearLayoutCompat linearLayoutCompat2;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding4;
        final LinearLayoutCompat linearLayoutCompat3;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding5;
        final HiloImageView hiloImageView2;
        FlowingDrawer flowingDrawer;
        CustomTabLayout customTabLayout2;
        CustomTabLayout customTabLayout3;
        CustomTabLayout customTabLayout4;
        NoScrollViewPager noScrollViewPager;
        CustomTabLayout customTabLayout5;
        NoScrollViewPager noScrollViewPager2;
        String str;
        this.gestureDetector = new GestureDetector((Context) getActivity(), (GestureDetector.OnGestureListener) new GestureDetector.SimpleOnGestureListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                cf.c.c().l(new CommunityDoubleTabEvent("doubleTab"));
                return true;
            }
        });
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            long id2 = user.getId();
            BasicModuleApp basicModuleApp = BasicModuleApp.INSTANCE;
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            String str2 = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "keyAuthToken", "", (String) null, 4, (Object) null);
            String str3 = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "service_device_Id", "", (String) null, 4, (Object) null);
            String language = LanguageHelper.INSTANCE.getSystemLanguage().getLanguage();
            BaseApplication companion2 = BaseApplication.Companion.getInstance();
            if (companion2 == null || (str = companion2.getVersionName()) == null) {
                str = "";
            }
            basicModuleApp.initUserAuth(new UserAuth(id2, str2, str3, language, NotificationKt.NOTIFICATION_CHANNEL_ID, str, (String) null, 64, (DefaultConstructorMarker) null));
        }
        User user2 = companion.getShared().getUser();
        if (user2 != null) {
            CommunityManager companion3 = CommunityManager.Companion.getInstance();
            CommunityRegister communityRegister = new CommunityRegister(user2, this.compositeDisposable);
            companion3.registerUserInfoProvider(communityRegister);
            companion3.registerUserEventsImpl(communityRegister);
            companion3.setNoticeCountListener(communityRegister);
        }
        if (this.mFragments.isEmpty()) {
            FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
            Fragment findFragment = fragmentUtils.findFragment(getChildFragmentManager(), HomeMatchingFragment.class);
            if (findFragment == null) {
                Fragment homeMatchingFragment = new HomeMatchingFragment();
                homeMatchingFragment.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.home.y
                    public final Object invoke(Object obj) {
                        Unit initView$lambda$6$lambda$5;
                        initView$lambda$6$lambda$5 = HomeFragment.initView$lambda$6$lambda$5(HomeFragment.this, ((Boolean) obj).booleanValue());
                        return initView$lambda$6$lambda$5;
                    }
                });
                this.mFragments.add(homeMatchingFragment);
                this.matchFragment = homeMatchingFragment;
            } else {
                this.matchFragment = (HomeMatchingFragment) findFragment;
                this.mFragments.add(findFragment);
            }
            Fragment findFragment2 = fragmentUtils.findFragment(getChildFragmentManager(), HomeRoomFragment.class);
            if (findFragment2 == null) {
                this.mFragments.add(new HomeRoomFragment());
            } else {
                this.mFragments.add(findFragment2);
            }
            Fragment findFragment3 = fragmentUtils.findFragment(getChildFragmentManager(), HomeGameFragment.class);
            if (findFragment3 == null) {
                this.mFragments.add(new HomeGameFragment());
            } else {
                this.mFragments.add(findFragment3);
            }
            Fragment findFragment4 = fragmentUtils.findFragment(getChildFragmentManager(), HomeCommunityFragment.class);
            if (findFragment4 == null) {
                this.mFragments.add(new HomeCommunityFragment());
            } else {
                this.mFragments.add(findFragment4);
            }
            Fragment findFragment5 = fragmentUtils.findFragment(getChildFragmentManager(), HomeChatFragment.class);
            if (findFragment5 == null) {
                this.mFragments.add(new HomeChatFragment());
            } else {
                this.mFragments.add(findFragment5);
            }
        }
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (noScrollViewPager2 = fragmentHomeBinding.viewPager) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            noScrollViewPager2.setAdapter(new ViewPagerFragmentAdapter(childFragmentManager, this.mFragments));
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding2 != null && (customTabLayout5 = fragmentHomeBinding2.tabLayout) != null) {
            customTabLayout5.setReSetTab(true);
        }
        FragmentHomeBinding fragmentHomeBinding3 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding3 != null && (customTabLayout4 = fragmentHomeBinding3.tabLayout) != null) {
            FragmentHomeBinding fragmentHomeBinding4 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding4 != null) {
                noScrollViewPager = fragmentHomeBinding4.viewPager;
            } else {
                noScrollViewPager = null;
            }
            customTabLayout4.setupWithViewPager(noScrollViewPager, new MainTabLayoutAdapter());
        }
        FragmentHomeBinding fragmentHomeBinding5 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding5 != null && (customTabLayout3 = fragmentHomeBinding5.tabLayout) != null) {
            ViewKtxKt.disableTooltipText(customTabLayout3);
        }
        this.mTabSelectListener = new TabLayout.d() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$5
            public void onTabReselected(TabLayout.f tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }

            public void onTabSelected(TabLayout.f tab) {
                int i;
                boolean z = false;
                if (tab != null) {
                    i = tab.g();
                } else {
                    i = 0;
                }
                UserService.INSTANCE.setOldHomeViewControllerTap(i);
                MatchingFloatData matchingFloatData = MatchingProvide.INSTANCE.getMatchingFloatData();
                if (matchingFloatData != null) {
                    cf.c.c().l(matchingFloatData);
                }
                HomeFragment.this.setPositionBg(i);
                HomeFragment homeFragment = HomeFragment.this;
                if (i == 2) {
                    z = true;
                }
                homeFragment.setStatusBarIconColor(z);
            }

            public void onTabUnselected(TabLayout.f tab) {
            }
        };
        FragmentHomeBinding fragmentHomeBinding6 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding6 != null && (customTabLayout2 = fragmentHomeBinding6.tabLayout) != null) {
            customTabLayout2.addOnTabSelectedListener(this.mTabSelectListener);
        }
        FragmentHomeBinding fragmentHomeBinding7 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding7 != null && (flowingDrawer = fragmentHomeBinding7.drawerlayout) != null) {
            flowingDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.f() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$6
                @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer.f
                public void onDrawerSlide(float openRatio, int offsetPixels) {
                }

                @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer.f
                public void onDrawerStateChange(int oldState, int newState) {
                    FrameLayout frameLayout12;
                    NoScrollViewPager noScrollViewPager3;
                    FrameLayout frameLayout13;
                    boolean z = true;
                    if (newState == 0) {
                        FragmentHomeBinding fragmentHomeBinding8 = (FragmentHomeBinding) HomeFragment.this.getBinding();
                        if (fragmentHomeBinding8 != null && (frameLayout13 = fragmentHomeBinding8.backGroup) != null) {
                            frameLayout13.setVisibility(8);
                        }
                        MatchingProvide.INSTANCE.setOpenDrawer(false);
                        if (HomeFragment.this.isAdded()) {
                            HomeFragment homeFragment = HomeFragment.this;
                            FragmentHomeBinding fragmentHomeBinding9 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding9 == null || (noScrollViewPager3 = fragmentHomeBinding9.viewPager) == null || noScrollViewPager3.getCurrentItem() != 2) {
                                z = false;
                            }
                            homeFragment.setStatusBarIconColor(z);
                        }
                    } else {
                        FragmentHomeBinding fragmentHomeBinding10 = (FragmentHomeBinding) HomeFragment.this.getBinding();
                        if (fragmentHomeBinding10 != null && (frameLayout12 = fragmentHomeBinding10.backGroup) != null) {
                            frameLayout12.setVisibility(0);
                        }
                        MatchingProvide.INSTANCE.setOpenDrawer(true);
                        if (HomeFragment.this.isAdded()) {
                            HomeFragment.this.setStatusBarIconColor(false);
                        }
                    }
                    MatchingFloatData matchingFloatData = MatchingProvide.INSTANCE.getMatchingFloatData();
                    if (matchingFloatData != null) {
                        cf.c.c().l(matchingFloatData);
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding8 = (FragmentHomeBinding) getBinding();
        final long j = 800;
        if (fragmentHomeBinding8 != null && (viewControllerHomeDrawerHeadLayoutBinding5 = fragmentHomeBinding8.drawerHeadLayout) != null && (hiloImageView2 = viewControllerHomeDrawerHeadLayoutBinding5.userHeadIconImageView) != null) {
            hiloImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str4;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(hiloImageView2) > j || (hiloImageView2 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(hiloImageView2, currentTimeMillis);
                        HiloImageView hiloImageView3 = hiloImageView2;
                        AppService service = AppController.INSTANCE.getService();
                        if (service != null) {
                            User user3 = UserStore.INSTANCE.getShared().getUser();
                            if (user3 == null || (str4 = user3.getExternalId()) == null) {
                                str4 = "";
                            }
                            service.openPersonPage(str4);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding9 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding9 != null && (viewControllerHomeDrawerHeadLayoutBinding4 = fragmentHomeBinding9.drawerHeadLayout) != null && (linearLayoutCompat3 = viewControllerHomeDrawerHeadLayoutBinding4.likeCountContainer) != null) {
            linearLayoutCompat3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(linearLayoutCompat3) > j || (linearLayoutCompat3 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(linearLayoutCompat3, currentTimeMillis);
                        LinearLayoutCompat linearLayoutCompat4 = linearLayoutCompat3;
                        Context context = this.getContext();
                        if (context != null) {
                            FriendStatusListActivity.Companion.start$default(FriendStatusListActivity.INSTANCE, context, null, 2, null);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding10 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding10 != null && (viewControllerHomeDrawerHeadLayoutBinding3 = fragmentHomeBinding10.drawerHeadLayout) != null && (linearLayoutCompat2 = viewControllerHomeDrawerHeadLayoutBinding3.visitorsCountContainer) != null) {
            linearLayoutCompat2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(linearLayoutCompat2) > j || (linearLayoutCompat2 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(linearLayoutCompat2, currentTimeMillis);
                        LinearLayoutCompat linearLayoutCompat4 = linearLayoutCompat2;
                        Context context = this.getContext();
                        if (context != null) {
                            FriendStatusListActivity.INSTANCE.start(context, InteractiveTrackingType.Visitor);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding11 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding11 != null && (viewControllerHomeDrawerHeadLayoutBinding2 = fragmentHomeBinding11.drawerHeadLayout) != null && (linearLayoutCompat = viewControllerHomeDrawerHeadLayoutBinding2.praiseCountContainer) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(linearLayoutCompat) > j || (linearLayoutCompat instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(linearLayoutCompat, currentTimeMillis);
                        LinearLayoutCompat linearLayoutCompat4 = linearLayoutCompat;
                        Context context = this.getContext();
                        if (context != null) {
                            FriendStatusListActivity.INSTANCE.start(context, InteractiveTrackingType.Praise);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding12 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding12 != null && (viewControllerHomeDrawerHeadLayoutBinding = fragmentHomeBinding12.drawerHeadLayout) != null && (linearLayout = viewControllerHomeDrawerHeadLayoutBinding.llLevel) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, context, GroupService.INSTANCE.getInstance().getLevelH5(), null, 4, null);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding13 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding13 != null && (constraintLayout = fragmentHomeBinding13.purchaseDiamondContainer) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        Context context = this.getContext();
                        if (context != null) {
                            WalletActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding14 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding14 != null && (frameLayout11 = fragmentHomeBinding14.vipContainer) != null) {
            frameLayout11.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout11) > j || (frameLayout11 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout11, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            new VipViewDialog(0, context, 1, null).show();
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding15 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding15 != null && (frameLayout10 = fragmentHomeBinding15.gameLayout) != null) {
            frameLayout10.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout10) > j || (frameLayout10 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout10, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            GameLevelActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding16 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding16 != null && (frameLayout9 = fragmentHomeBinding16.storeContent) != null) {
            frameLayout9.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout9) > j || (frameLayout9 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout9, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            StoreActivity.Companion.start$default(StoreActivity.INSTANCE, context, 0, 2, null);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding17 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding17 != null && (frameLayout8 = fragmentHomeBinding17.medalContent) != null) {
            frameLayout8.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout8) > j || (frameLayout8 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout8, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            this.startActivity(new Intent(context, (Class<?>) MedalActivity.class));
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding18 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding18 != null && (frameLayout7 = fragmentHomeBinding18.earnDiamond) != null) {
            frameLayout7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout7) > j || (frameLayout7 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout7, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            TasksActivity.Companion.start$default(TasksActivity.INSTANCE, context, 0, 2, null);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding19 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding19 != null && (frameLayout6 = fragmentHomeBinding19.svip) != null) {
            frameLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout6) > j || (frameLayout6 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout6, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            this.startActivity(new Intent(context, (Class<?>) SvipActivity.class));
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding20 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding20 != null && (frameLayout5 = fragmentHomeBinding20.nobilityContainer) != null) {
            frameLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout5) > j || (frameLayout5 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout5, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            BuyAristocracyActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding21 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding21 != null && (frameLayout4 = fragmentHomeBinding21.powerContent) != null) {
            frameLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.initView$lambda$34(HomeFragment.this, view);
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding22 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding22 != null && (frameLayout3 = fragmentHomeBinding22.settingContainer) != null) {
            frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout3) > j || (frameLayout3 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout3, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            SettingActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding23 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding23 != null && (frameLayout2 = fragmentHomeBinding23.levelContent) != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout2) > j || (frameLayout2 instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout2, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, context, GroupService.INSTANCE.getInstance().getLevelH5(), null, 4, null);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding24 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding24 != null && (hiloImageView = fragmentHomeBinding24.avatar) != null) {
            hiloImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FlowingDrawer flowingDrawer2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(hiloImageView) > j || (hiloImageView instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(hiloImageView, currentTimeMillis);
                        HiloImageView hiloImageView3 = hiloImageView;
                        FragmentHomeBinding fragmentHomeBinding25 = (FragmentHomeBinding) this.getBinding();
                        if (fragmentHomeBinding25 != null && (flowingDrawer2 = fragmentHomeBinding25.drawerlayout) != null) {
                            flowingDrawer2.p();
                        }
                        this.checkFistCharge();
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding25 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding25 != null && (frameLayout = fragmentHomeBinding25.giftRecord) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$initView$$inlined$singleClick$default$17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - com.oudi.utils.ktx.ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                        com.oudi.utils.ktx.ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            GiftRecordActivity.Companion.start$default(GiftRecordActivity.INSTANCE, context, 0, 2, null);
                        }
                    }
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding26 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding26 != null && (customTabLayout = fragmentHomeBinding26.tabLayout) != null && (tabAt = customTabLayout.getTabAt(3)) != null && (tabView = tabAt.i) != null) {
            tabView.setOnTouchListener(this.tabOnTouchListener);
        }
        if (companion.getShared().isAuthenticated()) {
            WebSocketProvide.INSTANCE.reconnect();
            selectPosition(UserService.INSTANCE.getOldHomeViewControllerTap());
        }
        showSVGA();
        refreshSkin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$34(HomeFragment homeFragment, View view) {
        Context context;
        Long l;
        Long id2;
        Long id3;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (context = homeFragment.getContext()) != null) {
            FamilyInfo groupPower = user.getGroupPower();
            if (groupPower != null) {
                l = groupPower.getId();
            } else {
                l = null;
            }
            if (l != null) {
                FamilyInfo groupPower2 = user.getGroupPower();
                long j = 0;
                if (groupPower2 == null || (id3 = groupPower2.getId()) == null || id3.longValue() != 0) {
                    FamilyCenterActivity.Companion companion = FamilyCenterActivity.INSTANCE;
                    FamilyInfo groupPower3 = user.getGroupPower();
                    if (groupPower3 != null && (id2 = groupPower3.getId()) != null) {
                        j = id2.longValue();
                    }
                    companion.startActivity(context, j);
                    return;
                }
            }
            FamilyRankActivity.INSTANCE.startActivity(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$6$lambda$5(HomeFragment homeFragment, boolean z) {
        if (z && MatchingProvide.INSTANCE.isStartMatching()) {
            homeFragment.startCameraPreview();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$52(final HomeFragment homeFragment) {
        HiloImageView hiloImageView;
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) homeFragment.getBinding();
        if (fragmentHomeBinding != null && (hiloImageView = fragmentHomeBinding.avatar) != null) {
            homeFragment.getStatusBarTopOrBottom(hiloImageView, new Function2() { // from class: com.qiahao.nextvideo.ui.home.x
                public final Object invoke(Object obj, Object obj2) {
                    Unit onResume$lambda$52$lambda$51$lambda$50;
                    onResume$lambda$52$lambda$51$lambda$50 = HomeFragment.onResume$lambda$52$lambda$51$lambda$50(HomeFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return onResume$lambda$52$lambda$51$lambda$50;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$52$lambda$51$lambda$50(HomeFragment homeFragment, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        int px;
        int i3;
        HiloImageView hiloImageView;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding;
        LinearLayoutCompat linearLayoutCompat;
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) homeFragment.getBinding();
        if (fragmentHomeBinding != null && (viewControllerHomeDrawerHeadLayoutBinding = fragmentHomeBinding.drawerHeadLayout) != null && (linearLayoutCompat = viewControllerHomeDrawerHeadLayoutBinding.topLinearLayout) != null) {
            linearLayoutCompat.setPadding(0, i, 0, 0);
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) homeFragment.getBinding();
        if (fragmentHomeBinding2 != null && (hiloImageView = fragmentHomeBinding2.avatar) != null) {
            layoutParams = hiloImageView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        if (hiloUtils.getRightToLeftDirection()) {
            px = 0;
        } else {
            px = UiKtxKt.toPX(12);
        }
        int px2 = i + UiKtxKt.toPX(5);
        if (hiloUtils.getRightToLeftDirection()) {
            i3 = UiKtxKt.toPX(12);
        } else {
            i3 = 0;
        }
        layoutParams2.setMargins(px, px2, i3, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onVideoEvent$lambda$47(HomeFragment homeFragment, UserProxy.Video video, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "<unused var>");
        Context context = homeFragment.getContext();
        if (context != null) {
            VideoCallActivity.INSTANCE.start(context, VideoCallModel.Companion.initInAnswered$default(VideoCallModel.INSTANCE, null, AgoraVideoCallConfig.INSTANCE.init(video), video, 1, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onVideoEvent$lambda$48(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void refreshSkin() {
        String str;
        FragmentHomeBinding fragmentHomeBinding;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding;
        ImageView imageView;
        String str2;
        ImageView imageView2;
        Drawable drawable;
        ImageView imageView3;
        ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding2;
        ImageView imageView4;
        SkinMessage skinMessage = SkinMessage.INSTANCE;
        SkinData skinData = skinMessage.skinData();
        if (skinData == null || (str = skinData.getSidebar()) == null) {
            str = "";
        }
        File file = new File(str);
        if (skinMessage.checkSkin() && file.exists() && file.isFile()) {
            FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding2 != null && (viewControllerHomeDrawerHeadLayoutBinding2 = fragmentHomeBinding2.drawerHeadLayout) != null && (imageView4 = viewControllerHomeDrawerHeadLayoutBinding2.topBg) != null) {
                ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, ImageView.ScaleType.CENTER_INSIDE, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65499, (Object) null);
            }
        } else {
            Context context = getContext();
            if (context != null && (fragmentHomeBinding = (FragmentHomeBinding) getBinding()) != null && (viewControllerHomeDrawerHeadLayoutBinding = fragmentHomeBinding.drawerHeadLayout) != null && (imageView = viewControllerHomeDrawerHeadLayoutBinding.topBg) != null) {
                imageView.setBackground(androidx.core.content.a.getDrawable(context, R.drawable.home_drawer_head_bg));
            }
        }
        SkinData skinData2 = skinMessage.skinData();
        if (skinData2 == null || (str2 = skinData2.getTabButtonBg()) == null) {
            str2 = "";
        }
        File file2 = new File(str2);
        if (skinMessage.checkSkin() && file2.exists() && file2.isFile()) {
            FragmentHomeBinding fragmentHomeBinding3 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding3 != null && (imageView3 = fragmentHomeBinding3.tabBg) != null) {
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, file2, (Integer) null, (Bitmap) null, ImageView.ScaleType.FIT_XY, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65499, (Object) null);
                return;
            }
            return;
        }
        FragmentHomeBinding fragmentHomeBinding4 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding4 != null && (imageView2 = fragmentHomeBinding4.tabBg) != null) {
            Context context2 = getContext();
            if (context2 != null) {
                drawable = androidx.core.content.a.getDrawable(context2, 2131101214);
            } else {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
        }
    }

    @SuppressLint({"SetTextI18n", "CheckResult"})
    private final void setupObserver() {
        this.compositeDisposable.d();
        nd.c subscribe = AgoraRtcService.INSTANCE.getLocalVideoStateRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$setupObserver$1
            public final void accept(Pair<Integer, Integer> pair) {
                AppCompatImageView appCompatImageView;
                FragmentHomeBinding fragmentHomeBinding;
                AppCompatImageView appCompatImageView2;
                try {
                    int intValue = ((Number) pair.getFirst()).intValue();
                    if (intValue != 0) {
                        if ((intValue != 1 && intValue != 3) || (fragmentHomeBinding = (FragmentHomeBinding) HomeFragment.this.getBinding()) == null || (appCompatImageView2 = fragmentHomeBinding.coverImageView) == null) {
                            return;
                        }
                        appCompatImageView2.setTranslationZ(-1.0f);
                        return;
                    }
                    FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) HomeFragment.this.getBinding();
                    if (fragmentHomeBinding2 != null && (appCompatImageView = fragmentHomeBinding2.coverImageView) != null) {
                        appCompatImageView.setTranslationZ(1.0f);
                    }
                    if (ProcessLifecycleOwner.Companion.get().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                        if (MatchingProvide.INSTANCE.isStartMatching()) {
                            HomeFragment.this.startCameraPreview();
                        }
                        Log.d(HomeFragment.TAG, "onAppForegrounded: 开启相机");
                    }
                } catch (Exception e) {
                    DebugToolsKt.printfE(HomeFragment.TAG, "localVideoStateRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = HomeFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.registerListener(name, new MessageDataListener() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$setupObserver$2
            @Override // com.qiahao.nextvideo.ui.im.MessageDataListener
            public void messageDataListener(ArrayList<MessageListInfo> listMessageDate, int unReadMessage, boolean isFinished) {
                View view;
                MainTabView mainTabView;
                CustomTabLayout customTabLayout;
                TabLayout.f tabAt;
                KeyEvent.Callback callback;
                CustomTabLayout customTabLayout2;
                TabLayout.f tabAt2;
                Intrinsics.checkNotNullParameter(listMessageDate, "listMessageDate");
                MainTabView mainTabView2 = null;
                if (unReadMessage > 0) {
                    FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) HomeFragment.this.getBinding();
                    if (fragmentHomeBinding != null && (customTabLayout2 = fragmentHomeBinding.tabLayout) != null && (tabAt2 = customTabLayout2.getTabAt(4)) != null) {
                        callback = tabAt2.e();
                    } else {
                        callback = null;
                    }
                    if (callback instanceof MainTabView) {
                        mainTabView2 = (MainTabView) callback;
                    }
                    if (mainTabView2 != null) {
                        mainTabView2.setRedPoints(String.valueOf(unReadMessage));
                        return;
                    }
                    return;
                }
                FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) HomeFragment.this.getBinding();
                if (fragmentHomeBinding2 != null && (customTabLayout = fragmentHomeBinding2.tabLayout) != null && (tabAt = customTabLayout.getTabAt(4)) != null) {
                    view = tabAt.e();
                } else {
                    view = null;
                }
                if (view instanceof MainTabView) {
                    mainTabView = (MainTabView) view;
                } else {
                    mainTabView = null;
                }
                if (mainTabView != null) {
                    mainTabView.setRedPoints(null);
                }
            }
        });
        nd.c subscribe2 = UserStore.INSTANCE.getShared().getUserObjectRelay().map(new pd.o() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$setupObserver$3
            public final UserObjectEvent apply(UserObjectEvent userObjectEvent) {
                return userObjectEvent;
            }
        }).observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).filter(new pd.q() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$setupObserver$4
            public final boolean test(UserObjectEvent userObjectEvent) {
                return userObjectEvent.isAuthenticated();
            }
        }).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$setupObserver$5
            public final void accept(UserObjectEvent userObjectEvent) {
                FlowingDrawer flowingDrawer;
                HiloImageView hiloImageView;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding;
                ImageView imageView;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding2;
                HiloGradeView hiloGradeView;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding3;
                HiloGradeView hiloGradeView2;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding4;
                HiloGradeView hiloGradeView3;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding5;
                AppCompatTextView appCompatTextView;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding6;
                AppCompatTextView appCompatTextView2;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding7;
                AppCompatTextView appCompatTextView3;
                FragmentHomeBinding fragmentHomeBinding;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding8;
                CountryIDView countryIDView;
                Integer level;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding9;
                NickTextView nickTextView;
                NobleInfo noble;
                Integer level2;
                SvipData svip;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding10;
                NickTextView nickTextView2;
                FragmentHomeBinding fragmentHomeBinding2;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding11;
                ImageView imageView2;
                NobleInfo noble2;
                Integer level3;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding12;
                ImageView imageView3;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding13;
                ImageView imageView4;
                NobleInfo noble3;
                Integer level4;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding14;
                ImageView imageView5;
                ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding15;
                HiloImageView hiloImageView2;
                try {
                    UserObjectEventType type = userObjectEvent.getType();
                    UserObjectEventType userObjectEventType = UserObjectEventType.REFRESH_MONEY;
                    if (type != userObjectEventType) {
                        PurchaseService.INSTANCE.getShared().syncPurchaseFeeDetails();
                        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
                        matchingProvide.fetchConfigurationParam();
                        matchingProvide.getSensitiveWord();
                    }
                    User user = userObjectEvent.getUser();
                    if (user != null) {
                        HomeFragment homeFragment = HomeFragment.this;
                        homeFragment.updateIMUserNameAndAvatar(user);
                        if (userObjectEvent.getType() != userObjectEventType) {
                            AliCloudService.INSTANCE.getShared().bindPushAccount(user.getExternalId());
                            if (!TUILogin.isUserLogined()) {
                                TIMService.INSTANCE.loginTIM();
                            }
                            FragmentHomeBinding fragmentHomeBinding3 = (FragmentHomeBinding) homeFragment.getBinding();
                            String str = "";
                            if (fragmentHomeBinding3 != null && (viewControllerHomeDrawerHeadLayoutBinding15 = fragmentHomeBinding3.drawerHeadLayout) != null && (hiloImageView2 = viewControllerHomeDrawerHeadLayoutBinding15.userHeadIconImageView) != null) {
                                String avatar = user.getAvatar();
                                HiloImageView.loadImage$default(hiloImageView2, avatar == null ? "" : avatar, 0, 0, 6, (Object) null);
                            }
                            FragmentHomeBinding fragmentHomeBinding4 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding4 != null && (viewControllerHomeDrawerHeadLayoutBinding14 = fragmentHomeBinding4.drawerHeadLayout) != null && (imageView5 = viewControllerHomeDrawerHeadLayoutBinding14.iconVip) != null) {
                                User user2 = UserStore.INSTANCE.getShared().getUser();
                                imageView5.setVisibility((user2 == null || !user2.isVip()) ? 8 : 0);
                            }
                            UserStore.Companion companion = UserStore.INSTANCE;
                            User user3 = companion.getShared().getUser();
                            if (((user3 == null || (noble3 = user3.getNoble()) == null || (level4 = noble3.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
                                FragmentHomeBinding fragmentHomeBinding5 = (FragmentHomeBinding) homeFragment.getBinding();
                                if (fragmentHomeBinding5 != null && (viewControllerHomeDrawerHeadLayoutBinding13 = fragmentHomeBinding5.drawerHeadLayout) != null && (imageView4 = viewControllerHomeDrawerHeadLayoutBinding13.iconVip) != null) {
                                    imageView4.setVisibility(8);
                                }
                                FragmentHomeBinding fragmentHomeBinding6 = (FragmentHomeBinding) homeFragment.getBinding();
                                if (fragmentHomeBinding6 != null && (viewControllerHomeDrawerHeadLayoutBinding12 = fragmentHomeBinding6.drawerHeadLayout) != null && (imageView3 = viewControllerHomeDrawerHeadLayoutBinding12.iconNoble) != null) {
                                    imageView3.setVisibility(0);
                                }
                                Context context = homeFragment.getContext();
                                if (context != null && (fragmentHomeBinding2 = (FragmentHomeBinding) homeFragment.getBinding()) != null && (viewControllerHomeDrawerHeadLayoutBinding11 = fragmentHomeBinding2.drawerHeadLayout) != null && (imageView2 = viewControllerHomeDrawerHeadLayoutBinding11.iconNoble) != null) {
                                    UserService.Companion companion2 = UserService.INSTANCE;
                                    User user4 = companion.getShared().getUser();
                                    imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion2.getNobleDrawableRes((user4 == null || (noble2 = user4.getNoble()) == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue())));
                                }
                            } else {
                                FragmentHomeBinding fragmentHomeBinding7 = (FragmentHomeBinding) homeFragment.getBinding();
                                if (fragmentHomeBinding7 != null && (viewControllerHomeDrawerHeadLayoutBinding = fragmentHomeBinding7.drawerHeadLayout) != null && (imageView = viewControllerHomeDrawerHeadLayoutBinding.iconNoble) != null) {
                                    imageView.setVisibility(8);
                                }
                            }
                            FragmentHomeBinding fragmentHomeBinding8 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding8 != null && (viewControllerHomeDrawerHeadLayoutBinding10 = fragmentHomeBinding8.drawerHeadLayout) != null && (nickTextView2 = viewControllerHomeDrawerHeadLayoutBinding10.nicknameTextView) != null) {
                                String nick = user.getNick();
                                if (nick != null) {
                                    str = nick;
                                }
                                nickTextView2.setText(str);
                            }
                            FragmentHomeBinding fragmentHomeBinding9 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding9 != null && (viewControllerHomeDrawerHeadLayoutBinding9 = fragmentHomeBinding9.drawerHeadLayout) != null && (nickTextView = viewControllerHomeDrawerHeadLayoutBinding9.nicknameTextView) != null) {
                                User user5 = companion.getShared().getUser();
                                String nick2 = user5 != null ? user5.getNick() : null;
                                User user6 = companion.getShared().getUser();
                                int svipLevel = (user6 == null || (svip = user6.getSvip()) == null) ? 0 : svip.getSvipLevel();
                                User user7 = companion.getShared().getUser();
                                nickTextView.setSVipAndNoble(nick2, svipLevel, (user7 == null || (noble = user7.getNoble()) == null || (level2 = noble.getLevel()) == null) ? 0 : level2.intValue());
                            }
                            Context context2 = homeFragment.getContext();
                            if (context2 != null && (fragmentHomeBinding = (FragmentHomeBinding) homeFragment.getBinding()) != null && (viewControllerHomeDrawerHeadLayoutBinding8 = fragmentHomeBinding.drawerHeadLayout) != null && (countryIDView = viewControllerHomeDrawerHeadLayoutBinding8.countryID) != null) {
                                String format = String.format(ResourcesKtxKt.getStringById(homeFragment, 2131953102), Arrays.copyOf(new Object[]{user.getCode()}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                                Integer idFrameType = user.getIdFrameType();
                                int intValue = idFrameType != null ? idFrameType.intValue() : 0;
                                NobleInfo noble4 = user.getNoble();
                                int color = androidx.core.content.a.getColor(context2, ((noble4 == null || (level = noble4.getLevel()) == null) ? 0 : level.intValue()) > 0 ? 2131101214 : 2131099901);
                                Boolean isPrettyCode = user.isPrettyCode();
                                countryIDView.refreshText(format, intValue, color, isPrettyCode != null ? isPrettyCode.booleanValue() : false);
                            }
                            FragmentHomeBinding fragmentHomeBinding10 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding10 != null && (viewControllerHomeDrawerHeadLayoutBinding7 = fragmentHomeBinding10.drawerHeadLayout) != null && (appCompatTextView3 = viewControllerHomeDrawerHeadLayoutBinding7.likeCountTextView) != null) {
                                appCompatTextView3.setText(String.valueOf(user.getLikeCount()));
                            }
                            FragmentHomeBinding fragmentHomeBinding11 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding11 != null && (viewControllerHomeDrawerHeadLayoutBinding6 = fragmentHomeBinding11.drawerHeadLayout) != null && (appCompatTextView2 = viewControllerHomeDrawerHeadLayoutBinding6.visitorsCountTextView) != null) {
                                appCompatTextView2.setText(String.valueOf(user.getVisitCount()));
                            }
                            FragmentHomeBinding fragmentHomeBinding12 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding12 != null && (viewControllerHomeDrawerHeadLayoutBinding5 = fragmentHomeBinding12.drawerHeadLayout) != null && (appCompatTextView = viewControllerHomeDrawerHeadLayoutBinding5.praiseCountTextView) != null) {
                                appCompatTextView.setText(String.valueOf(user.getVideoLikeCount()));
                            }
                            FragmentHomeBinding fragmentHomeBinding13 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding13 != null && (viewControllerHomeDrawerHeadLayoutBinding4 = fragmentHomeBinding13.drawerHeadLayout) != null && (hiloGradeView3 = viewControllerHomeDrawerHeadLayoutBinding4.wealthLevel) != null) {
                                HiloGradeView.setLevelBg$default(hiloGradeView3, user.getWealthUserGrade(), false, true, false, 10, (Object) null);
                            }
                            FragmentHomeBinding fragmentHomeBinding14 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding14 != null && (viewControllerHomeDrawerHeadLayoutBinding3 = fragmentHomeBinding14.drawerHeadLayout) != null && (hiloGradeView2 = viewControllerHomeDrawerHeadLayoutBinding3.charmLevel) != null) {
                                HiloGradeView.setLevelBg$default(hiloGradeView2, user.getCharmUserGrade(), true, false, false, 12, (Object) null);
                            }
                            FragmentHomeBinding fragmentHomeBinding15 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding15 != null && (viewControllerHomeDrawerHeadLayoutBinding2 = fragmentHomeBinding15.drawerHeadLayout) != null && (hiloGradeView = viewControllerHomeDrawerHeadLayoutBinding2.activityLevel) != null) {
                                HiloGradeView.setLevelBg$default(hiloGradeView, user.getActivityUserGrade(), false, false, true, 6, (Object) null);
                            }
                        }
                        if (userObjectEvent.getType() == UserObjectEventType.FILLUESRINFO || userObjectEvent.getType() == UserObjectEventType.LOGIN) {
                            FragmentHomeBinding fragmentHomeBinding16 = (FragmentHomeBinding) homeFragment.getBinding();
                            if (fragmentHomeBinding16 != null && (flowingDrawer = fragmentHomeBinding16.drawerlayout) != null) {
                                flowingDrawer.f(false);
                            }
                            PurchaseService.INSTANCE.getShared().syncPurchaseFeeDetails();
                            WebSocketProvide.INSTANCE.reconnect();
                            MMKVStore mMKVStore = MMKVStore.INSTANCE;
                            if (((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "FirstOpenAppAndLogin", Boolean.TRUE, (String) null, 4, (Object) null)).booleanValue()) {
                                IStore.DefaultImpls.setValue$default(mMKVStore, "FirstOpenAppAndLogin", Boolean.FALSE, (String) null, 4, (Object) null);
                                homeFragment.selectPosition(1);
                            } else {
                                homeFragment.selectPosition(UserService.INSTANCE.getOldHomeViewControllerTap());
                            }
                        }
                        FragmentHomeBinding fragmentHomeBinding17 = (FragmentHomeBinding) homeFragment.getBinding();
                        if (fragmentHomeBinding17 == null || (hiloImageView = fragmentHomeBinding17.avatar) == null) {
                            return;
                        }
                        HiloImageView.loadImage$default(hiloImageView, ImageSizeKt.image100(user.getSmallAvatar()), 0, 0, 6, (Object) null);
                    }
                } catch (Exception e) {
                    DebugToolsKt.printfE(HomeFragment.TAG, "用户登录等事件的监听userObjectRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$setupObserver$6
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                DebugToolsKt.printfE(HomeFragment.TAG, th.getLocalizedMessage());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, this.compositeDisposable);
    }

    private final void showSVGA() {
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        LightQueueCombinationPlayer lightQueueCombinationPlayer2;
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (lightQueueCombinationPlayer2 = fragmentHomeBinding.queuePlayer) != null) {
            lightQueueCombinationPlayer2.bindingLifeCycle(this);
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding2 != null && (lightQueueCombinationPlayer = fragmentHomeBinding2.queuePlayer) != null) {
            lightQueueCombinationPlayer.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.a0
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.showSVGA$lambda$42(HomeFragment.this);
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSVGA$lambda$42(HomeFragment homeFragment) {
        String str;
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        String homeSvga;
        SkinMessage skinMessage = SkinMessage.INSTANCE;
        SkinData skinData = skinMessage.skinData();
        String str2 = "";
        if (skinData == null || (str = skinData.getHomeSvga()) == null) {
            str = "";
        }
        File file = new File(str);
        if (skinMessage.checkSkin() && file.exists() && file.isFile()) {
            SVGAMediaSource sVGAMediaSource = new SVGAMediaSource();
            SkinData skinData2 = skinMessage.skinData();
            if (skinData2 != null && (homeSvga = skinData2.getHomeSvga()) != null) {
                str2 = homeSvga;
            }
            sVGAMediaSource.setFilePath(str2);
            FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) homeFragment.getBinding();
            if (fragmentHomeBinding != null && (lightQueueCombinationPlayer = fragmentHomeBinding.queuePlayer) != null) {
                lightQueueCombinationPlayer.addQueue(sVGAMediaSource);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCameraPreview() {
        FrameLayout frameLayout;
        AppCompatImageView appCompatImageView;
        ImageView imageView;
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        agoraRtcService.enableVideo(true);
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (imageView = fragmentHomeBinding.backGround) != null) {
            imageView.setVisibility(8);
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding2 != null && (appCompatImageView = fragmentHomeBinding2.coverImageView) != null) {
            appCompatImageView.setTranslationZ(-1.0f);
        }
        if (this.localRendererView == null) {
            TextureView CreateTextureView = RtcEngine.CreateTextureView(getContext());
            CreateTextureView.setFitsSystemWindows(true);
            FragmentHomeBinding fragmentHomeBinding3 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding3 != null && (frameLayout = fragmentHomeBinding3.videoPreviewContainer) != null) {
                frameLayout.addView(CreateTextureView);
            }
            this.localRendererView = CreateTextureView;
        }
        TextureView textureView = this.localRendererView;
        if (textureView != null) {
            textureView.setVisibility(0);
        }
        RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.setCameraCapturerConfiguration(new CameraCapturerConfiguration(CameraCapturerConfiguration.CD_1920x1080, CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_FRONT));
        }
        RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.setupLocalVideo(new VideoCanvas(this.localRendererView, 1, 0));
        }
        agoraRtcService.enableLocalVideo(true);
        RtcEngine rtcEngine3 = agoraRtcService.getRtcEngine();
        if (rtcEngine3 != null) {
            rtcEngine3.startPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean tabOnTouchListener$lambda$1(HomeFragment homeFragment, View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        if (motionEvent == null || (gestureDetector = homeFragment.gestureDetector) == null) {
            return false;
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIMUserNameAndAvatar(User user) {
        String str;
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        String avatar = user.getAvatar();
        if (avatar != null && avatar.length() != 0) {
            String avatar2 = user.getAvatar();
            if (avatar2 != null) {
                str = ImageKtxKt.splicingAvatarUrl(avatar2);
            } else {
                str = null;
            }
            v2TIMUserFullInfo.setFaceUrl(str);
        } else {
            UserStore.Companion companion = UserStore.INSTANCE;
            User user2 = companion.getShared().getUser();
            if (user2 != null && user2.getSex() == 1) {
                v2TIMUserFullInfo.setFaceUrl(ImageKtxKt.splicingAvatarUrl(companion.getShared().getMNormalManAvatarUrl()));
            } else {
                v2TIMUserFullInfo.setFaceUrl(ImageKtxKt.splicingAvatarUrl(companion.getShared().getMNormalWomanAvatarUrl()));
            }
        }
        v2TIMUserFullInfo.setNickname(user.getNick());
        V2TIMManager.getInstance().setSelfInfo(v2TIMUserFullInfo, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.HomeFragment$updateIMUserNameAndAvatar$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
            }
        });
    }

    public final void checkFistCharge() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().firstRechargeCard(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.u
            public final Object invoke(Object obj) {
                Unit checkFistCharge$lambda$59;
                checkFistCharge$lambda$59 = HomeFragment.checkFistCharge$lambda$59(HomeFragment.this, (ApiResponse) obj);
                return checkFistCharge$lambda$59;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.v
            public final Object invoke(Object obj) {
                Unit checkFistCharge$lambda$60;
                checkFistCharge$lambda$60 = HomeFragment.checkFistCharge$lambda$60(HomeFragment.this, (Throwable) obj);
                return checkFistCharge$lambda$60;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    public boolean onBackPressedIntercept() {
        Integer num;
        FlowingDrawer flowingDrawer;
        FlowingDrawer flowingDrawer2;
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (flowingDrawer2 = fragmentHomeBinding.drawerlayout) != null) {
            num = Integer.valueOf(flowingDrawer2.getDrawerState());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 8) {
            FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding2 != null && (flowingDrawer = fragmentHomeBinding2.drawerlayout) != null) {
                flowingDrawer.e();
            }
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= CLICK_TIME) {
            this.lastClickTime = currentTimeMillis;
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131954329), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            return true;
        }
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public void onDestroy() {
        int i;
        LightQueueCombinationPlayer lightQueueCombinationPlayer;
        CustomTabLayout customTabLayout;
        CustomTabLayout customTabLayout2;
        TabLayout.f tabAt;
        CustomTabLayout customTabLayout3;
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        String name = HomeFragment.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        messageProvide.removeListener(name);
        CommunityManager companion = CommunityManager.Companion.getInstance();
        companion.removeUnReadListener();
        companion.clearUserInfoProvider();
        companion.clearUserEventsImpl();
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (customTabLayout3 = fragmentHomeBinding.tabLayout) != null) {
            i = customTabLayout3.getTabCount();
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding2 != null && (customTabLayout2 = fragmentHomeBinding2.tabLayout) != null && (tabAt = customTabLayout2.getTabAt(i2)) != null) {
                tabAt.o((View) null);
            }
        }
        FragmentHomeBinding fragmentHomeBinding3 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding3 != null && (customTabLayout = fragmentHomeBinding3.tabLayout) != null) {
            customTabLayout.removeOnTabSelectedListener(this.mTabSelectListener);
        }
        HomeMatchingFragment homeMatchingFragment = this.matchFragment;
        if (homeMatchingFragment != null) {
            homeMatchingFragment.setMListener(null);
        }
        this.matchFragment = null;
        FragmentHomeBinding fragmentHomeBinding4 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding4 != null && (lightQueueCombinationPlayer = fragmentHomeBinding4.queuePlayer) != null) {
            lightQueueCombinationPlayer.onCleared();
        }
        this.compositeDisposable.d();
        this.gestureDetector = null;
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onHomePageEvent(@NotNull HomePageEvent event) {
        FragmentHomeBinding fragmentHomeBinding;
        NoScrollViewPager noScrollViewPager;
        FlowingDrawer flowingDrawer;
        Intrinsics.checkNotNullParameter(event, "event");
        for (int i = 0; i < 6; i++) {
            ActivityLifecycleManager activityLifecycleManager = ActivityLifecycleManager.INSTANCE;
            if (!(activityLifecycleManager.currentActivity() instanceof MainActivity)) {
                activityLifecycleManager.finishLastActivity();
            }
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding2 != null && (flowingDrawer = fragmentHomeBinding2.drawerlayout) != null) {
            flowingDrawer.e();
        }
        if (event.getOnePosition() > -1 && event.getOnePosition() < this.mFragments.size() && (fragmentHomeBinding = (FragmentHomeBinding) getBinding()) != null && (noScrollViewPager = fragmentHomeBinding.viewPager) != null) {
            noScrollViewPager.setCurrentItem(event.getOnePosition());
        }
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        setupObserver();
    }

    public void onResume() {
        boolean z;
        Boolean bool;
        View root;
        Context context;
        HiloImageView hiloImageView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (hiloImageView = fragmentHomeBinding.avatar) != null) {
            hiloImageView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.w
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.onResume$lambda$52(HomeFragment.this);
                }
            });
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding2 != null && (root = fragmentHomeBinding2.getRoot()) != null && (context = root.getContext()) != null) {
            z = androidx.core.app.r.d(context).a();
        } else {
            z = false;
        }
        if (z != this.notificationsEnabled) {
            this.notificationsEnabled = z;
            UserService.INSTANCE.getShared().userMsgPush(this.notificationsEnabled);
        }
        Context context2 = getContext();
        if (context2 != null) {
            androidx.core.app.r.d(context2).b();
        }
        Context context3 = getContext();
        if (context3 != null) {
            bool = Boolean.valueOf(PermissionUtils.INSTANCE.checkPermission(context3));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE) && MatchingProvide.INSTANCE.isStartMatching()) {
            startCameraPreview();
        }
    }

    public void onStop() {
        boolean z;
        AppCompatImageView appCompatImageView;
        View root;
        Context context;
        androidx.core.app.r d;
        super/*androidx.fragment.app.Fragment*/.onStop();
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (root = fragmentHomeBinding.getRoot()) != null && (context = root.getContext()) != null && (d = androidx.core.app.r.d(context)) != null) {
            z = d.a();
        } else {
            z = false;
        }
        if (z != this.notificationsEnabled) {
            this.notificationsEnabled = z;
            UserService.INSTANCE.getShared().userMsgPush(this.notificationsEnabled);
        }
        TextureView textureView = this.localRendererView;
        if (textureView != null) {
            Bitmap bitmap = textureView.getBitmap((int) (textureView.getWidth() * 0.5f), (int) (textureView.getHeight() * 0.5f));
            FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding2 != null && (appCompatImageView = fragmentHomeBinding2.coverImageView) != null) {
                appCompatImageView.setImageBitmap(bitmap);
            }
        }
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull VideoEvent event) {
        NoScrollViewPager noScrollViewPager;
        FlowingDrawer flowingDrawer;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        switch (type.hashCode()) {
            case -2032180703:
                if (type.equals("DEFAULT")) {
                    closeCameraPreview();
                    return;
                }
                return;
            case -1096994987:
                if (!type.equals("HOME_PAGE_MATCH")) {
                    return;
                }
                break;
            case 2555906:
                if (type.equals("STOP")) {
                    closeCameraPreview();
                    return;
                }
                return;
            case 939694897:
                if (!type.equals("CLICK_MATCHING_FLOAT")) {
                    return;
                }
                break;
            case 1539528552:
                if (type.equals("START_MATCH") && MatchingProvide.INSTANCE.isStartMatching()) {
                    startCameraPreview();
                    return;
                }
                return;
            case 1987375348:
                if (type.equals("SPECIFY_VIDEO_CALL_ANSWERED_PENDING")) {
                    MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
                    if (!Intrinsics.areEqual(matchingProvide.getMatchStatue(), MatchingProvide.MATCH_PENDING) && !Intrinsics.areEqual(matchingProvide.getMatchStatue(), MatchingProvide.IS_VIDEO)) {
                        Object data = event.getData();
                        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy.Video");
                        final UserProxy.Video video = (UserProxy.Video) data;
                        AgoraVideoCallConfig.INSTANCE.init(video);
                        UserService shared = UserService.INSTANCE.getShared();
                        String sendUserId = video.getSendUserId();
                        Intrinsics.checkNotNullExpressionValue(sendUserId, "getSendUserId(...)");
                        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(shared, sendUserId, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.b0
                            public final Object invoke(Object obj) {
                                Unit onVideoEvent$lambda$47;
                                onVideoEvent$lambda$47 = HomeFragment.onVideoEvent$lambda$47(HomeFragment.this, video, (ApiResponse) obj);
                                return onVideoEvent$lambda$47;
                            }
                        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.c0
                            public final Object invoke(Object obj) {
                                Unit onVideoEvent$lambda$48;
                                onVideoEvent$lambda$48 = HomeFragment.onVideoEvent$lambda$48((Throwable) obj);
                                return onVideoEvent$lambda$48;
                            }
                        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
        for (int i = 0; i < 6; i++) {
            ActivityLifecycleManager activityLifecycleManager = ActivityLifecycleManager.INSTANCE;
            if (!(activityLifecycleManager.currentActivity() instanceof MainActivity)) {
                activityLifecycleManager.finishLastActivity();
            }
        }
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (flowingDrawer = fragmentHomeBinding.drawerlayout) != null) {
            flowingDrawer.e();
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding2 != null && (noScrollViewPager = fragmentHomeBinding2.viewPager) != null) {
            noScrollViewPager.setCurrentItem(0);
        }
    }

    public final void selectPosition(int position) {
        int i;
        NoScrollViewPager noScrollViewPager;
        NoScrollViewPager noScrollViewPager2;
        androidx.viewpager.widget.a adapter;
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding != null && (noScrollViewPager2 = fragmentHomeBinding.viewPager) != null && (adapter = noScrollViewPager2.getAdapter()) != null) {
            i = adapter.getCount();
        } else {
            i = 0;
        }
        if (position < i) {
            UserService.INSTANCE.setOldHomeViewControllerTap(position);
            FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding2 != null && (noScrollViewPager = fragmentHomeBinding2.viewPager) != null) {
                noScrollViewPager.setCurrentItem(position);
            }
        }
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setPositionBg(int position) {
        MainActivity mainActivity;
        ImageView imageView;
        ImageView imageView2;
        boolean z;
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity instanceof MainActivity) {
            mainActivity = (MainActivity) activity;
        } else {
            mainActivity = null;
        }
        int i = 0;
        if (mainActivity != null) {
            if (position != 0) {
                z = true;
            } else {
                z = false;
            }
            mainActivity.setMCanShowGlobalDialog(z);
        }
        if (SkinMessage.INSTANCE.checkSkin()) {
            FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
            if (fragmentHomeBinding != null && (imageView2 = fragmentHomeBinding.tabBg) != null) {
                if (position == 0) {
                    i = 8;
                }
                imageView2.setVisibility(i);
                return;
            }
            return;
        }
        FragmentHomeBinding fragmentHomeBinding2 = (FragmentHomeBinding) getBinding();
        if (fragmentHomeBinding2 != null && (imageView = fragmentHomeBinding2.tabBg) != null) {
            if (position == 0) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }
}
