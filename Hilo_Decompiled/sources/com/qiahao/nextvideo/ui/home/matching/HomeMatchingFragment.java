package com.qiahao.nextvideo.ui.home.matching;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.baishun.HomeMatchGameData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.SuperLikeData;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.planets.HiloPlanetsData;
import com.qiahao.nextvideo.data.service.match.MatchConfigData;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.databinding.FragmentHomeMatchingBinding;
import com.qiahao.nextvideo.databinding.FragmentHomeMatchingHeadBinding;
import com.qiahao.nextvideo.databinding.IncludeMatchBigItemBinding;
import com.qiahao.nextvideo.databinding.IncludeMatchMinItemBinding;
import com.qiahao.nextvideo.databinding.ViewWrapperMatchingPendingBinding;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity;
import com.qiahao.nextvideo.ui.fillpersonaldata.safetiesreference.SafetiesReferenceDialog;
import com.qiahao.nextvideo.ui.gem.GemStoreDialog;
import com.qiahao.nextvideo.ui.home.GlobalBroadActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity;
import com.qiahao.nextvideo.ui.home.matching.view.MatchingPendingViewWrapper;
import com.qiahao.nextvideo.ui.paired.MatchingActionPendingUIModel;
import com.qiahao.nextvideo.ui.peopleCertification.SuperLikeDialog;
import com.qiahao.nextvideo.ui.reusable.views.MatchingFloatView;
import com.qiahao.nextvideo.ui.youtu.YouTuWatchActivity;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.PermissionUtils;
import com.qiahao.nextvideo.view.HiloPlanetsAdapter;
import com.qiahao.nextvideo.view.HomeMatchRecycleView;
import com.qiahao.nextvideo.view.planet.PlanetsView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;

@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001m\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u001d\u0010+\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050)H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010\u0004J\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020&H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0013H\u0014¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0005H\u0016¢\u0006\u0004\b3\u0010\u0004J\u0017\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u000204H\u0007¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\u0004J\u000f\u00109\u001a\u00020\u0005H\u0016¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010:\u001a\u00020\u0005H\u0016¢\u0006\u0004\b:\u0010\u0004R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR?\u0010F\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020\u0005\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010Q\u001a\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020f8\u0002X\u0082D¢\u0006\u0006\n\u0004\bi\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006p"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentHomeMatchingBinding;", "<init>", "()V", "", "initData", "initView", "setupHeaderView", "setupRecyclerView", "setupAdapterClickListeners", "setupRefreshLayout", "setupClickListeners", "setupPlanetView", "setupTopBar", "setupMatchingFloatView", "updateWealthDisplay", "showGemDialog", "handleMatchButtonClick", "", "index", "navigateToGame", "(I)V", "getUserWealthLevelChangeUI", "setupGameMatchMode", "setupVideoMatchMode", "refreshAllView", "refreshAllData", "Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "uiModel", "matchUser", "(Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;)V", "LuserProxy/UserProxy$MatchSuccess;", "inAppMatchEvent", "processRandomPairPending", "(LuserProxy/UserProxy$MatchSuccess;)V", "clearMatchingView", "showFoundGuysAnimation", "", "checkMatchPermission", "()Z", "Lkotlin/Function0;", "notFirstOpen", "checkFirstOpenMatch", "(Lkotlin/jvm/functions/Function0;)V", "setStatusBar", "isStart", "startOrStopAnimation", "(Z)V", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/VideoEvent;)V", "onResume", "onPause", "onDestroyView", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAllow", "mListener", "Lkotlin/jvm/functions/Function1;", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/qiahao/nextvideo/databinding/FragmentHomeMatchingHeadBinding;", "headBinding", "Lcom/qiahao/nextvideo/databinding/FragmentHomeMatchingHeadBinding;", "Lcom/qiahao/nextvideo/ui/home/matching/HomeMatchUserAdapter;", "matchUserAdapter$delegate", "Lkotlin/Lazy;", "getMatchUserAdapter", "()Lcom/qiahao/nextvideo/ui/home/matching/HomeMatchUserAdapter;", "matchUserAdapter", "Lcom/qiahao/base_common/model/common/User;", "currentUser", "Lcom/qiahao/base_common/model/common/User;", "Lcom/qiahao/nextvideo/ui/home/matching/MatchPermissionDialog;", "mPermissionDialog", "Lcom/qiahao/nextvideo/ui/home/matching/MatchPermissionDialog;", "Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingPendingViewWrapper;", "matchingPendingViewWrapper", "Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingPendingViewWrapper;", "Lcom/qiahao/nextvideo/ui/home/matching/MatchViewModel;", "viewModel", "Lcom/qiahao/nextvideo/ui/home/matching/MatchViewModel;", "Lcom/qiahao/nextvideo/view/HiloPlanetsAdapter;", "mPlanetsAdapter$delegate", "getMPlanetsAdapter", "()Lcom/qiahao/nextvideo/view/HiloPlanetsAdapter;", "mPlanetsAdapter", "", "lastAnimationTriggerTime", "J", "animationTriggerDelay", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "com/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment$mMatchListener$1", "mMatchListener", "Lcom/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment$mMatchListener$1;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeMatchingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeMatchingFragment.kt\ncom/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,819:1\n1#2:820\n61#3,9:821\n61#3,9:830\n61#3,9:839\n61#3,9:848\n61#3,9:857\n61#3,9:866\n61#3,9:875\n61#3,9:884\n61#3,9:893\n61#3,9:902\n61#3,9:911\n1878#4,3:920\n*S KotlinDebug\n*F\n+ 1 HomeMatchingFragment.kt\ncom/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment\n*L\n366#1:821,9\n371#1:830,9\n377#1:839,9\n382#1:848,9\n387#1:857,9\n392#1:866,9\n397#1:875,9\n402#1:884,9\n407#1:893,9\n510#1:902,9\n521#1:911,9\n220#1:920,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeMatchingFragment extends BaseBindingFragment<FragmentHomeMatchingBinding> {

    @Nullable
    private User currentUser;

    @Nullable
    private FragmentHomeMatchingHeadBinding headBinding;
    private long lastAnimationTriggerTime;

    @Nullable
    private Function1<? super Boolean, Unit> mListener;

    @Nullable
    private MatchPermissionDialog mPermissionDialog;

    @Nullable
    private MatchingPendingViewWrapper matchingPendingViewWrapper;

    @Nullable
    private MatchViewModel viewModel;

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    /* renamed from: matchUserAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy matchUserAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.m
        public final Object invoke() {
            HomeMatchUserAdapter matchUserAdapter_delegate$lambda$0;
            matchUserAdapter_delegate$lambda$0 = HomeMatchingFragment.matchUserAdapter_delegate$lambda$0();
            return matchUserAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: mPlanetsAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPlanetsAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.n
        public final Object invoke() {
            HiloPlanetsAdapter mPlanetsAdapter_delegate$lambda$1;
            mPlanetsAdapter_delegate$lambda$1 = HomeMatchingFragment.mPlanetsAdapter_delegate$lambda$1();
            return mPlanetsAdapter_delegate$lambda$1;
        }
    });
    private final long animationTriggerDelay = 100;

    @Nullable
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$mScrollListener$1
        private float scrollPosition;

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            boolean z;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            this.scrollPosition += dy;
            int measuredWidth = recyclerView.getMeasuredWidth();
            HomeMatchingFragment homeMatchingFragment = HomeMatchingFragment.this;
            if (this.scrollPosition < measuredWidth) {
                z = true;
            } else {
                z = false;
            }
            homeMatchingFragment.startOrStopAnimation(z);
        }
    };

    @NotNull
    private final HomeMatchingFragment$mMatchListener$1 mMatchListener = new HomeMatchingFragment$mMatchListener$1(this);

    private final void checkFirstOpenMatch(Function0<Unit> notFirstOpen) {
        if (((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "FirstOpenMatch", Boolean.TRUE, (String) null, 4, (Object) null)).booleanValue()) {
            Context context = getContext();
            if (context != null) {
                BaseBindingDialog safetiesReferenceDialog = new SafetiesReferenceDialog(context);
                safetiesReferenceDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.home.matching.c
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        HomeMatchingFragment.checkFirstOpenMatch$lambda$53$lambda$52(HomeMatchingFragment.this, dialogInterface);
                    }
                });
                safetiesReferenceDialog.show();
                return;
            }
            return;
        }
        notFirstOpen.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkFirstOpenMatch$lambda$53$lambda$52(HomeMatchingFragment homeMatchingFragment, DialogInterface dialogInterface) {
        int i;
        int i2;
        boolean z;
        int i3;
        Integer remainCard;
        Integer minuteDiamond;
        Double pinkDiamondNum;
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "FirstOpenMatch", Boolean.FALSE, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "MatchingFloatViewX", -1, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "MatchingFloatViewY", -1, (String) null, 4, (Object) null);
        User user = UserStore.INSTANCE.getShared().getUser();
        boolean z2 = false;
        if (user != null && (pinkDiamondNum = user.getPinkDiamondNum()) != null) {
            i = (int) pinkDiamondNum.doubleValue();
        } else {
            i = 0;
        }
        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
        MatchConfigData matchConfigData = matchingProvide.getMatchConfigData();
        if (matchConfigData != null && (minuteDiamond = matchConfigData.getMinuteDiamond()) != null) {
            i2 = minuteDiamond.intValue();
        } else {
            i2 = 0;
        }
        if (i >= i2) {
            z = true;
        } else {
            z = false;
        }
        MatchConfigData matchConfigData2 = matchingProvide.getMatchConfigData();
        if (matchConfigData2 != null && (remainCard = matchConfigData2.getRemainCard()) != null) {
            i3 = remainCard.intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            z2 = true;
        }
        if (!z && !z2) {
            homeMatchingFragment.showGemDialog();
        } else {
            matchingProvide.sendEventAndEnterMatchPool();
        }
    }

    private final boolean checkMatchPermission() {
        boolean z;
        if (!UserStore.INSTANCE.getShared().isAuthenticated()) {
            return false;
        }
        Context context = getContext();
        if (context != null) {
            if (!PermissionUtils.INSTANCE.checkPermission(context)) {
                MatchPermissionDialog matchPermissionDialog = this.mPermissionDialog;
                if (matchPermissionDialog != null) {
                    matchPermissionDialog.dismiss();
                }
                MatchPermissionDialog matchPermissionDialog2 = new MatchPermissionDialog(context);
                matchPermissionDialog2.setMListener(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.b
                    public final Object invoke() {
                        Unit checkMatchPermission$lambda$49$lambda$48$lambda$47;
                        checkMatchPermission$lambda$49$lambda$48$lambda$47 = HomeMatchingFragment.checkMatchPermission$lambda$49$lambda$48$lambda$47(HomeMatchingFragment.this);
                        return checkMatchPermission$lambda$49$lambda$48$lambda$47;
                    }
                });
                this.mPermissionDialog = matchPermissionDialog2;
                matchPermissionDialog2.show();
                return false;
            }
            MatchPermissionDialog matchPermissionDialog3 = this.mPermissionDialog;
            if (matchPermissionDialog3 != null) {
                matchPermissionDialog3.dismiss();
            }
            this.mPermissionDialog = null;
            return true;
        }
        Function1<? super Boolean, Unit> function1 = this.mListener;
        if (function1 != null) {
            Context context2 = getContext();
            if (context2 != null) {
                z = PermissionUtils.INSTANCE.checkPermission(context2);
            } else {
                z = false;
            }
            function1.invoke(Boolean.valueOf(z));
        }
        Context context3 = getContext();
        if (context3 == null) {
            return false;
        }
        return PermissionUtils.INSTANCE.checkPermission(context3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkMatchPermission$lambda$49$lambda$48$lambda$47(HomeMatchingFragment homeMatchingFragment) {
        if (homeMatchingFragment.checkMatchPermission()) {
            homeMatchingFragment.checkFirstOpenMatch(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.f
                public final Object invoke() {
                    Unit checkMatchPermission$lambda$49$lambda$48$lambda$47$lambda$46;
                    checkMatchPermission$lambda$49$lambda$48$lambda$47$lambda$46 = HomeMatchingFragment.checkMatchPermission$lambda$49$lambda$48$lambda$47$lambda$46();
                    return checkMatchPermission$lambda$49$lambda$48$lambda$47$lambda$46;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkMatchPermission$lambda$49$lambda$48$lambda$47$lambda$46() {
        MatchingProvide.INSTANCE.sendEventAndEnterMatchPool();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearMatchingView() {
        FrameLayout frameLayout;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding != null && (frameLayout = fragmentHomeMatchingBinding.matchingPendingViewWrapperContainer) != null) {
            frameLayout.removeAllViews();
        }
        this.matchingPendingViewWrapper = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HiloPlanetsAdapter getMPlanetsAdapter() {
        return (HiloPlanetsAdapter) this.mPlanetsAdapter.getValue();
    }

    private final HomeMatchUserAdapter getMatchUserAdapter() {
        return (HomeMatchUserAdapter) this.matchUserAdapter.getValue();
    }

    private final void getUserWealthLevelChangeUI() {
        IncludeMatchBigItemBinding includeMatchBigItemBinding;
        View root;
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (includeMatchBigItemBinding = fragmentHomeMatchingHeadBinding.matchLayout) != null && (root = includeMatchBigItemBinding.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.matching.k
                @Override // java.lang.Runnable
                public final void run() {
                    HomeMatchingFragment.getUserWealthLevelChangeUI$lambda$39(HomeMatchingFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUserWealthLevelChangeUI$lambda$39(HomeMatchingFragment homeMatchingFragment) {
        User user = homeMatchingFragment.currentUser;
        if (user != null) {
            if (user.getWealthUserGrade() <= 5) {
                homeMatchingFragment.setupGameMatchMode();
            } else {
                homeMatchingFragment.setupVideoMatchMode();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMatchButtonClick() {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.isRoomSmall()) {
            MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
            meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
        }
        refreshAllView();
        if (checkMatchPermission()) {
            checkFirstOpenMatch(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.a
                public final Object invoke() {
                    Unit handleMatchButtonClick$lambda$36;
                    handleMatchButtonClick$lambda$36 = HomeMatchingFragment.handleMatchButtonClick$lambda$36();
                    return handleMatchButtonClick$lambda$36;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleMatchButtonClick$lambda$36() {
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "MatchingFloatViewX", -1, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "MatchingFloatViewY", -1, (String) null, 4, (Object) null);
        MatchingProvide.INSTANCE.sendEventAndEnterMatchPool();
        return Unit.INSTANCE;
    }

    private final void initData() {
        LiveData<User> userInfo;
        ma.b mException;
        LiveData<List<SuperLikeData>> superLike;
        LiveData<HomeMatchGameData> matchGameList;
        LiveData<ArrayList<HiloPlanetsData>> recommendList;
        LiveData<Integer> missNum;
        MatchViewModel matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        this.viewModel = matchViewModel;
        if (matchViewModel != null && (missNum = matchViewModel.getMissNum()) != null) {
            missNum.observe(this, new HomeMatchingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.l
                public final Object invoke(Object obj) {
                    Unit initData$lambda$2;
                    initData$lambda$2 = HomeMatchingFragment.initData$lambda$2(HomeMatchingFragment.this, (Integer) obj);
                    return initData$lambda$2;
                }
            }));
        }
        MatchViewModel matchViewModel2 = this.viewModel;
        if (matchViewModel2 != null && (recommendList = matchViewModel2.getRecommendList()) != null) {
            recommendList.observe(this, new HomeMatchingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.o
                public final Object invoke(Object obj) {
                    Unit initData$lambda$3;
                    initData$lambda$3 = HomeMatchingFragment.initData$lambda$3(HomeMatchingFragment.this, (ArrayList) obj);
                    return initData$lambda$3;
                }
            }));
        }
        MatchViewModel matchViewModel3 = this.viewModel;
        if (matchViewModel3 != null && (matchGameList = matchViewModel3.getMatchGameList()) != null) {
            matchGameList.observe(this, new HomeMatchingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.p
                public final Object invoke(Object obj) {
                    Unit initData$lambda$5;
                    initData$lambda$5 = HomeMatchingFragment.initData$lambda$5(HomeMatchingFragment.this, (HomeMatchGameData) obj);
                    return initData$lambda$5;
                }
            }));
        }
        MatchViewModel matchViewModel4 = this.viewModel;
        if (matchViewModel4 != null && (superLike = matchViewModel4.getSuperLike()) != null) {
            superLike.observe(this, new HomeMatchingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.q
                public final Object invoke(Object obj) {
                    Unit initData$lambda$7;
                    initData$lambda$7 = HomeMatchingFragment.initData$lambda$7(HomeMatchingFragment.this, (List) obj);
                    return initData$lambda$7;
                }
            }));
        }
        MatchViewModel matchViewModel5 = this.viewModel;
        if (matchViewModel5 != null && (mException = matchViewModel5.getMException()) != null) {
            mException.observe(this, new HomeMatchingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.r
                public final Object invoke(Object obj) {
                    Unit initData$lambda$8;
                    initData$lambda$8 = HomeMatchingFragment.initData$lambda$8(HomeMatchingFragment.this, (Pair) obj);
                    return initData$lambda$8;
                }
            }));
        }
        MatchViewModel matchViewModel6 = this.viewModel;
        if (matchViewModel6 != null && (userInfo = matchViewModel6.getUserInfo()) != null) {
            userInfo.observe(this, new HomeMatchingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.s
                public final Object invoke(Object obj) {
                    Unit initData$lambda$9;
                    initData$lambda$9 = HomeMatchingFragment.initData$lambda$9(HomeMatchingFragment.this, (User) obj);
                    return initData$lambda$9;
                }
            }));
        }
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$initData$7
            public final void accept(UserObjectEvent userObjectEvent) {
                if (userObjectEvent != null) {
                    HomeMatchingFragment homeMatchingFragment = HomeMatchingFragment.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        homeMatchingFragment.updateWealthDisplay();
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(HomeMatchingFragment homeMatchingFragment, Integer num) {
        homeMatchingFragment.refreshAllView();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(HomeMatchingFragment homeMatchingFragment, ArrayList arrayList) {
        PlanetsView planetsView;
        homeMatchingFragment.getMPlanetsAdapter().refreshData(arrayList);
        Animation loadAnimation = AnimationUtils.loadAnimation(homeMatchingFragment.getContext(), R.anim.planet_anim_in);
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = homeMatchingFragment.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (planetsView = fragmentHomeMatchingHeadBinding.planetView) != null) {
            planetsView.startAnimation(loadAnimation);
        }
        homeMatchingFragment.startOrStopAnimation(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(HomeMatchingFragment homeMatchingFragment, HomeMatchGameData homeMatchGameData) {
        ArrayList<GameConfiguration> list;
        IncludeMatchMinItemBinding includeMatchMinItemBinding;
        View root;
        IncludeMatchMinItemBinding includeMatchMinItemBinding2;
        TextView textView;
        IncludeMatchMinItemBinding includeMatchMinItemBinding3;
        ImageView imageView;
        IncludeMatchMinItemBinding includeMatchMinItemBinding4;
        View root2;
        IncludeMatchMinItemBinding includeMatchMinItemBinding5;
        View root3;
        IncludeMatchMinItemBinding includeMatchMinItemBinding6;
        TextView textView2;
        IncludeMatchMinItemBinding includeMatchMinItemBinding7;
        ImageView imageView2;
        IncludeMatchMinItemBinding includeMatchMinItemBinding8;
        View root4;
        IncludeMatchMinItemBinding includeMatchMinItemBinding9;
        View root5;
        IncludeMatchMinItemBinding includeMatchMinItemBinding10;
        View root6;
        IncludeMatchBigItemBinding includeMatchBigItemBinding;
        View root7;
        boolean z;
        int i;
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = homeMatchingFragment.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (includeMatchBigItemBinding = fragmentHomeMatchingHeadBinding.baiShun) != null && (root7 = includeMatchBigItemBinding.getRoot()) != null) {
            if (homeMatchGameData != null) {
                z = Intrinsics.areEqual(homeMatchGameData.isOk(), Boolean.TRUE);
            } else {
                z = false;
            }
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            root7.setVisibility(i);
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding2 = homeMatchingFragment.headBinding;
        if (fragmentHomeMatchingHeadBinding2 != null && (includeMatchMinItemBinding10 = fragmentHomeMatchingHeadBinding2.slotsLayout) != null && (root6 = includeMatchMinItemBinding10.getRoot()) != null) {
            root6.setVisibility(8);
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding3 = homeMatchingFragment.headBinding;
        if (fragmentHomeMatchingHeadBinding3 != null && (includeMatchMinItemBinding9 = fragmentHomeMatchingHeadBinding3.fishingLayout) != null && (root5 = includeMatchMinItemBinding9.getRoot()) != null) {
            root5.setVisibility(8);
        }
        if (homeMatchGameData != null && (list = homeMatchGameData.getList()) != null) {
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                GameConfiguration gameConfiguration = (GameConfiguration) obj;
                if (i2 != 0) {
                    if (i2 == 1) {
                        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding4 = homeMatchingFragment.headBinding;
                        if (fragmentHomeMatchingHeadBinding4 != null && (includeMatchMinItemBinding8 = fragmentHomeMatchingHeadBinding4.fishingLayout) != null && (root4 = includeMatchMinItemBinding8.getRoot()) != null) {
                            root4.setVisibility(0);
                        }
                        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding5 = homeMatchingFragment.headBinding;
                        if (fragmentHomeMatchingHeadBinding5 != null && (includeMatchMinItemBinding7 = fragmentHomeMatchingHeadBinding5.fishingLayout) != null && (imageView2 = includeMatchMinItemBinding7.image) != null) {
                            ImageKtxKt.loadImage$default(imageView2, gameConfiguration.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                        }
                        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding6 = homeMatchingFragment.headBinding;
                        if (fragmentHomeMatchingHeadBinding6 != null && (includeMatchMinItemBinding6 = fragmentHomeMatchingHeadBinding6.fishingLayout) != null && (textView2 = includeMatchMinItemBinding6.title) != null) {
                            textView2.setText(gameConfiguration.getTitle());
                        }
                        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding7 = homeMatchingFragment.headBinding;
                        if (fragmentHomeMatchingHeadBinding7 != null && (includeMatchMinItemBinding5 = fragmentHomeMatchingHeadBinding7.fishingLayout) != null && (root3 = includeMatchMinItemBinding5.getRoot()) != null) {
                            ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
                            String startColor = gameConfiguration.getStartColor();
                            if (startColor == null) {
                                startColor = "#43B3DE";
                            }
                            String endColor = gameConfiguration.getEndColor();
                            if (endColor == null) {
                                endColor = "#6FEBE4";
                            }
                            root3.setBackground(ShapeUtil.createShape$default(shapeUtil, startColor, endColor, 12, (GradientDrawable.Orientation) null, 8, (Object) null));
                        }
                    }
                } else {
                    FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding8 = homeMatchingFragment.headBinding;
                    if (fragmentHomeMatchingHeadBinding8 != null && (includeMatchMinItemBinding4 = fragmentHomeMatchingHeadBinding8.slotsLayout) != null && (root2 = includeMatchMinItemBinding4.getRoot()) != null) {
                        root2.setVisibility(0);
                    }
                    FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding9 = homeMatchingFragment.headBinding;
                    if (fragmentHomeMatchingHeadBinding9 != null && (includeMatchMinItemBinding3 = fragmentHomeMatchingHeadBinding9.slotsLayout) != null && (imageView = includeMatchMinItemBinding3.image) != null) {
                        ImageKtxKt.loadImage$default(imageView, gameConfiguration.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                    }
                    FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding10 = homeMatchingFragment.headBinding;
                    if (fragmentHomeMatchingHeadBinding10 != null && (includeMatchMinItemBinding2 = fragmentHomeMatchingHeadBinding10.slotsLayout) != null && (textView = includeMatchMinItemBinding2.title) != null) {
                        textView.setText(gameConfiguration.getTitle());
                    }
                    FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding11 = homeMatchingFragment.headBinding;
                    if (fragmentHomeMatchingHeadBinding11 != null && (includeMatchMinItemBinding = fragmentHomeMatchingHeadBinding11.slotsLayout) != null && (root = includeMatchMinItemBinding.getRoot()) != null) {
                        ShapeUtil shapeUtil2 = ShapeUtil.INSTANCE;
                        String startColor2 = gameConfiguration.getStartColor();
                        if (startColor2 == null) {
                            startColor2 = "#B574FF";
                        }
                        String endColor2 = gameConfiguration.getEndColor();
                        if (endColor2 == null) {
                            endColor2 = "#F866FF";
                        }
                        root.setBackground(ShapeUtil.createShape$default(shapeUtil2, startColor2, endColor2, 12, (GradientDrawable.Orientation) null, 8, (Object) null));
                    }
                }
                i2 = i3;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(HomeMatchingFragment homeMatchingFragment, List list) {
        BaseListData baseListData;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding != null && (smartRefreshLayout2 = fragmentHomeMatchingBinding.refreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding2 != null && (smartRefreshLayout = fragmentHomeMatchingBinding2.refreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding3 = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding3 != null && (superStatusView = fragmentHomeMatchingBinding3.statusView) != null) {
            superStatusView.showContent();
        }
        MatchViewModel matchViewModel = homeMatchingFragment.viewModel;
        if (matchViewModel != null && (baseListData = matchViewModel.getBaseListData()) != null && baseListData.isOnePage()) {
            homeMatchingFragment.getMatchUserAdapter().setList(list);
            homeMatchingFragment.startOrStopAnimation(true);
        } else if (list != null) {
            homeMatchingFragment.getMatchUserAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(HomeMatchingFragment homeMatchingFragment, Pair pair) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        if (Intrinsics.areEqual(pair.getFirst(), MatchViewModel.SUPER_LIKE)) {
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
            if (fragmentHomeMatchingBinding != null && (smartRefreshLayout2 = fragmentHomeMatchingBinding.refreshLayout) != null) {
                smartRefreshLayout2.finishRefresh();
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
            if (fragmentHomeMatchingBinding2 != null && (smartRefreshLayout = fragmentHomeMatchingBinding2.refreshLayout) != null) {
                smartRefreshLayout.finishLoadMore();
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding3 = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
            if (fragmentHomeMatchingBinding3 != null && (superStatusView = fragmentHomeMatchingBinding3.statusView) != null) {
                superStatusView.showContent();
            }
            homeMatchingFragment.getMatchUserAdapter().setList((Collection) null);
            homeMatchingFragment.startOrStopAnimation(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$9(HomeMatchingFragment homeMatchingFragment, User user) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding != null && (smartRefreshLayout2 = fragmentHomeMatchingBinding.refreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding2 != null && (smartRefreshLayout = fragmentHomeMatchingBinding2.refreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        homeMatchingFragment.currentUser = user;
        homeMatchingFragment.getUserWealthLevelChangeUI();
        return Unit.INSTANCE;
    }

    private final void initView() {
        setupHeaderView();
        setupRecyclerView();
        setupRefreshLayout();
        setupClickListeners();
        setupPlanetView();
        setupTopBar();
        setupMatchingFloatView();
        updateWealthDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiloPlanetsAdapter mPlanetsAdapter_delegate$lambda$1() {
        return new HiloPlanetsAdapter();
    }

    private final void matchUser(MatchingActionPendingUIModel uiModel) {
        ViewWrapperMatchingPendingBinding binding;
        AppCompatButton appCompatButton;
        MatchingPendingViewWrapper matchingPendingViewWrapper;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        Context context = getContext();
        if (context != null) {
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding != null && (frameLayout = fragmentHomeMatchingBinding.matchingPendingViewWrapperContainer) != null) {
                matchingPendingViewWrapper = new MatchingPendingViewWrapper(context, frameLayout, uiModel);
                matchingPendingViewWrapper.setDelegate(this.mMatchListener);
                FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
                if (fragmentHomeMatchingBinding2 != null && (frameLayout2 = fragmentHomeMatchingBinding2.matchingPendingViewWrapperContainer) != null) {
                    frameLayout2.addView(matchingPendingViewWrapper.getBinding().getRoot());
                }
            } else {
                matchingPendingViewWrapper = null;
            }
            this.matchingPendingViewWrapper = matchingPendingViewWrapper;
        }
        if (((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "matching_view", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue()) {
            MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
            String avatar = uiModel.getToUser().getAvatar();
            if (avatar == null) {
                avatar = "";
            }
            MatchingProvide.refreshMatchingFloatView$default(matchingProvide, avatar, MatchingFloatView.Mode.WAITING, null, 4, null);
            MatchingPendingViewWrapper matchingPendingViewWrapper2 = this.matchingPendingViewWrapper;
            if (matchingPendingViewWrapper2 != null && (binding = matchingPendingViewWrapper2.getBinding()) != null && (appCompatButton = binding.acceptInviteButton) != null) {
                appCompatButton.performClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeMatchUserAdapter matchUserAdapter_delegate$lambda$0() {
        return new HomeMatchUserAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToGame(int index) {
        LiveData<HomeMatchGameData> matchGameList;
        HomeMatchGameData homeMatchGameData;
        ArrayList<GameConfiguration> list;
        GameConfiguration gameConfiguration;
        MatchViewModel matchViewModel = this.viewModel;
        if (matchViewModel != null && (matchGameList = matchViewModel.getMatchGameList()) != null && (homeMatchGameData = (HomeMatchGameData) matchGameList.getValue()) != null && (list = homeMatchGameData.getList()) != null && (gameConfiguration = (GameConfiguration) CollectionsKt.getOrNull(list, index)) != null) {
            NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
            String url = gameConfiguration.getUrl();
            if (url == null) {
                url = "";
            }
            NavigationHelper.jump$default(navigationHelper, url, (SuperCallBack) null, 2, (Object) null);
        }
    }

    private final void processRandomPairPending(UserProxy.MatchSuccess inAppMatchEvent) {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null) {
            return;
        }
        if (!TextUtils.isEmpty(inAppMatchEvent.getRemoteUserId()) && inAppMatchEvent.getStatus()) {
            clearMatchingView();
            matchUser(MatchingActionPendingUIModel.INSTANCE.init(DataExternalKt.toUser(inAppMatchEvent), UserSummaryInfo.INSTANCE.init(user), inAppMatchEvent));
        } else {
            MatchingProvide.INSTANCE.enterMatchPool();
        }
    }

    private final void refreshAllData() {
        BaseListData baseListData;
        MatchingProvide.INSTANCE.getMatchConfigSendEvent();
        MatchViewModel matchViewModel = this.viewModel;
        if (matchViewModel != null) {
            matchViewModel.m٧٥getGoddessList();
        }
        MatchViewModel matchViewModel2 = this.viewModel;
        if (matchViewModel2 != null) {
            matchViewModel2.m٧٦getMissNum();
        }
        MatchViewModel matchViewModel3 = this.viewModel;
        if (matchViewModel3 != null) {
            matchViewModel3.recommendList();
        }
        MatchViewModel matchViewModel4 = this.viewModel;
        if (matchViewModel4 != null) {
            matchViewModel4.matchGameList();
        }
        MatchViewModel matchViewModel5 = this.viewModel;
        if (matchViewModel5 != null && (baseListData = matchViewModel5.getBaseListData()) != null) {
            baseListData.resetPage();
        }
        MatchViewModel matchViewModel6 = this.viewModel;
        if (matchViewModel6 != null) {
            matchViewModel6.superLikeList();
        }
        MatchViewModel matchViewModel7 = this.viewModel;
        if (matchViewModel7 != null) {
            matchViewModel7.getUserInfoForCharge();
        }
    }

    private final void refreshAllView() {
        SVGAImageView sVGAImageView;
        ConstraintLayout constraintLayout;
        Group group;
        SVGAImageView sVGAImageView2;
        ConstraintLayout constraintLayout2;
        Group group2;
        TextView textView;
        SVGAImageView sVGAImageView3;
        ConstraintLayout constraintLayout3;
        Group group3;
        String matchStatue = MatchingProvide.INSTANCE.getMatchStatue();
        if (Intrinsics.areEqual(matchStatue, MatchingProvide.MATCH_START_MATCH)) {
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding != null && (group3 = fragmentHomeMatchingBinding.matchGroup) != null) {
                group3.setVisibility(8);
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding2 != null && (constraintLayout3 = fragmentHomeMatchingBinding2.foundGuysSvgaContainer) != null) {
                constraintLayout3.setVisibility(0);
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding3 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding3 != null && (sVGAImageView3 = fragmentHomeMatchingBinding3.foundGuysSvgaImageView) != null) {
                sVGAImageView3.startAnimation();
            }
        } else if (Intrinsics.areEqual(matchStatue, MatchingProvide.MATCH_PENDING)) {
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding4 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding4 != null && (group2 = fragmentHomeMatchingBinding4.matchGroup) != null) {
                group2.setVisibility(8);
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding5 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding5 != null && (constraintLayout2 = fragmentHomeMatchingBinding5.foundGuysSvgaContainer) != null) {
                constraintLayout2.setVisibility(8);
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding6 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding6 != null && (sVGAImageView2 = fragmentHomeMatchingBinding6.foundGuysSvgaImageView) != null) {
                sVGAImageView2.pauseAnimation();
            }
        } else {
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding7 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding7 != null && (group = fragmentHomeMatchingBinding7.matchGroup) != null) {
                group.setVisibility(0);
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding8 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding8 != null && (constraintLayout = fragmentHomeMatchingBinding8.foundGuysSvgaContainer) != null) {
                constraintLayout.setVisibility(8);
            }
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding9 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding9 != null && (sVGAImageView = fragmentHomeMatchingBinding9.foundGuysSvgaImageView) != null) {
                sVGAImageView.pauseAnimation();
            }
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (textView = fragmentHomeMatchingHeadBinding.number) != null) {
            textView.setText(NumberFormat.getNumberInstance().format(Integer.valueOf(RangesKt.random(new IntRange(170000, 190000), Random.Default))).toString());
        }
        updateWealthDisplay();
    }

    private final void setStatusBar() {
        LinearLayout linearLayout;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding != null && (linearLayout = fragmentHomeMatchingBinding.topLinearLayout) != null) {
            linearLayout.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.matching.e
                @Override // java.lang.Runnable
                public final void run() {
                    HomeMatchingFragment.setStatusBar$lambda$55(HomeMatchingFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStatusBar$lambda$55(final HomeMatchingFragment homeMatchingFragment) {
        LinearLayout linearLayout;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding != null) {
            linearLayout = fragmentHomeMatchingBinding.topLinearLayout;
        } else {
            linearLayout = null;
        }
        homeMatchingFragment.getStatusBarTopOrBottom(linearLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.home.matching.j
            public final Object invoke(Object obj, Object obj2) {
                Unit statusBar$lambda$55$lambda$54;
                statusBar$lambda$55$lambda$54 = HomeMatchingFragment.setStatusBar$lambda$55$lambda$54(HomeMatchingFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return statusBar$lambda$55$lambda$54;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setStatusBar$lambda$55$lambda$54(HomeMatchingFragment homeMatchingFragment, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        LinearLayout linearLayout;
        int px;
        int i3;
        LinearLayout linearLayout2;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        ConstraintLayout.b bVar = null;
        if (fragmentHomeMatchingBinding != null && (linearLayout2 = fragmentHomeMatchingBinding.topLinearLayout) != null) {
            layoutParams = linearLayout2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.b) {
            bVar = (ConstraintLayout.b) layoutParams;
        }
        if (bVar != null) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            if (hiloUtils.getRightToLeftDirection()) {
                px = 0;
            } else {
                px = UiKtxKt.toPX(60);
            }
            int px2 = i + UiKtxKt.toPX(10);
            if (hiloUtils.getRightToLeftDirection()) {
                i3 = UiKtxKt.toPX(60);
            } else {
                i3 = 0;
            }
            bVar.setMargins(px, px2, i3, 0);
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding2 != null && (linearLayout = fragmentHomeMatchingBinding2.topLinearLayout) != null) {
            linearLayout.setLayoutParams(bVar);
        }
        return Unit.INSTANCE;
    }

    private final void setupAdapterClickListeners() {
        final Context context = getContext();
        if (context != null) {
            getMatchUserAdapter().addChildClickViewIds(new int[]{R.id.supperBtn});
            getMatchUserAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.u
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    HomeMatchingFragment.setupAdapterClickListeners$lambda$16$lambda$14(HomeMatchingFragment.this, context, baseQuickAdapter, view, i);
                }
            });
            getMatchUserAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.v
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    HomeMatchingFragment.setupAdapterClickListeners$lambda$16$lambda$15(HomeMatchingFragment.this, baseQuickAdapter, view, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAdapterClickListeners$lambda$16$lambda$14(final HomeMatchingFragment homeMatchingFragment, Context context, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        SuperLikeData superLikeData = (SuperLikeData) homeMatchingFragment.getMatchUserAdapter().getData().get(i);
        String externalId = superLikeData.getExternalId();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(externalId, str)) {
            return;
        }
        if (Intrinsics.areEqual(superLikeData.isMyLike(), Boolean.TRUE)) {
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                String externalId2 = superLikeData.getExternalId();
                if (externalId2 == null) {
                    externalId2 = "";
                }
                service.toChat(externalId2);
                return;
            }
            return;
        }
        SuperLikeDialog superLikeDialog = new SuperLikeDialog(context, superLikeData);
        superLikeDialog.setMListener(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.d
            public final Object invoke() {
                Unit unit;
                unit = HomeMatchingFragment.setupAdapterClickListeners$lambda$16$lambda$14$lambda$13$lambda$12(HomeMatchingFragment.this);
                return unit;
            }
        });
        superLikeDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupAdapterClickListeners$lambda$16$lambda$14$lambda$13$lambda$12(HomeMatchingFragment homeMatchingFragment) {
        BaseListData baseListData;
        MatchViewModel matchViewModel = homeMatchingFragment.viewModel;
        if (matchViewModel != null && (baseListData = matchViewModel.getBaseListData()) != null) {
            baseListData.resetPage();
        }
        MatchViewModel matchViewModel2 = homeMatchingFragment.viewModel;
        if (matchViewModel2 != null) {
            matchViewModel2.superLikeList();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAdapterClickListeners$lambda$16$lambda$15(HomeMatchingFragment homeMatchingFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        SuperLikeData superLikeData = (SuperLikeData) homeMatchingFragment.getMatchUserAdapter().getData().get(i);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            String externalId = superLikeData.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            service.openPersonPage(externalId);
        }
    }

    private final void setupClickListeners() {
        AppCompatTextView appCompatTextView;
        IncludeMatchMinItemBinding includeMatchMinItemBinding;
        final View root;
        IncludeMatchMinItemBinding includeMatchMinItemBinding2;
        final View root2;
        IncludeMatchBigItemBinding includeMatchBigItemBinding;
        final View root3;
        IncludeMatchBigItemBinding includeMatchBigItemBinding2;
        final View root4;
        IncludeMatchBigItemBinding includeMatchBigItemBinding3;
        final View root5;
        IncludeMatchBigItemBinding includeMatchBigItemBinding4;
        final View root6;
        IncludeMatchBigItemBinding includeMatchBigItemBinding5;
        final View root7;
        final ImageView imageView;
        final LinearLayout linearLayout;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
        final long j = 800;
        if (fragmentHomeMatchingBinding != null && (linearLayout = fragmentHomeMatchingBinding.topLinearLayout) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                        this.showGemDialog();
                    }
                }
            });
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding2 != null && (imageView = fragmentHomeMatchingBinding2.chest) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        NavigationHelper.jump$default(NavigationHelper.INSTANCE, (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "task_activity_url", "", (String) null, 4, (Object) null), (SuperCallBack) null, 2, (Object) null);
                    }
                }
            });
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (includeMatchBigItemBinding5 = fragmentHomeMatchingHeadBinding.matchLayout) != null && (root7 = includeMatchBigItemBinding5.getRoot()) != null) {
            root7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root7) > j || (root7 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root7, currentTimeMillis);
                        this.handleMatchButtonClick();
                    }
                }
            });
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding2 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding2 != null && (includeMatchBigItemBinding4 = fragmentHomeMatchingHeadBinding2.chatLayout) != null && (root6 = includeMatchBigItemBinding4.getRoot()) != null) {
            root6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root6) > j || (root6 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root6, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            StrangeMatchActivity.Companion.startActivity$default(StrangeMatchActivity.INSTANCE, context, false, 2, null);
                        }
                    }
                }
            });
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding3 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding3 != null && (includeMatchBigItemBinding3 = fragmentHomeMatchingHeadBinding3.videoLayout) != null && (root5 = includeMatchBigItemBinding3.getRoot()) != null) {
            root5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root5) > j || (root5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root5, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            YouTuWatchActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding4 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding4 != null && (includeMatchBigItemBinding2 = fragmentHomeMatchingHeadBinding4.broadcastLayout) != null && (root4 = includeMatchBigItemBinding2.getRoot()) != null) {
            root4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root4) > j || (root4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root4, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            GlobalBroadActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding5 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding5 != null && (includeMatchBigItemBinding = fragmentHomeMatchingHeadBinding5.baiShun) != null && (root3 = includeMatchBigItemBinding.getRoot()) != null) {
            root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            BaiShunGameActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding6 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding6 != null && (includeMatchMinItemBinding2 = fragmentHomeMatchingHeadBinding6.slotsLayout) != null && (root2 = includeMatchMinItemBinding2.getRoot()) != null) {
            root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                        this.navigateToGame(0);
                    }
                }
            });
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding7 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding7 != null && (includeMatchMinItemBinding = fragmentHomeMatchingHeadBinding7.fishingLayout) != null && (root = includeMatchMinItemBinding.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupClickListeners$$inlined$singleClick$default$9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        this.navigateToGame(1);
                    }
                }
            });
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding3 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding3 != null && (appCompatTextView = fragmentHomeMatchingBinding3.endTextView) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeMatchingFragment.setupClickListeners$lambda$34(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$34(View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            MatchingProvide.INSTANCE.exitMatchingPool();
        }
    }

    private final void setupGameMatchMode() {
        IncludeMatchBigItemBinding includeMatchBigItemBinding;
        final View root;
        IncludeMatchBigItemBinding includeMatchBigItemBinding2;
        ImageView imageView;
        IncludeMatchBigItemBinding includeMatchBigItemBinding3;
        TextView textView;
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (includeMatchBigItemBinding3 = fragmentHomeMatchingHeadBinding.matchLayout) != null && (textView = includeMatchBigItemBinding3.title) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, 2131952849));
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding2 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding2 != null && (includeMatchBigItemBinding2 = fragmentHomeMatchingHeadBinding2.matchLayout) != null && (imageView = includeMatchBigItemBinding2.image) != null) {
            imageView.setImageResource(R.drawable.home_game_match_icon);
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding3 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding3 != null && (includeMatchBigItemBinding = fragmentHomeMatchingHeadBinding3.matchLayout) != null && (root = includeMatchBigItemBinding.getRoot()) != null) {
            final long j = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupGameMatchMode$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        GameJum.matchGame$default(GameJum.INSTANCE, 0, 41, 0, 18, null, 21, null);
                    }
                }
            });
        }
    }

    private final void setupHeaderView() {
        View root;
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = (FragmentHomeMatchingHeadBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.fragment_home_matching_head, (ViewGroup) null, false);
        this.headBinding = fragmentHomeMatchingHeadBinding;
        if (fragmentHomeMatchingHeadBinding != null && (root = fragmentHomeMatchingHeadBinding.getRoot()) != null) {
            BaseQuickAdapter.setHeaderView$default(getMatchUserAdapter(), root, 0, 0, 6, (Object) null);
        }
    }

    private final void setupMatchingFloatView() {
        String str;
        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getAvatar()) == null) {
            str = "";
        }
        MatchingProvide.refreshMatchingFloatView$default(matchingProvide, str, MatchingFloatView.Mode.NORMAL, null, 4, null);
    }

    private final void setupPlanetView() {
        PlanetsView planetsView;
        PlanetsView planetsView2;
        LinearLayout linearLayout;
        IncludeMatchBigItemBinding includeMatchBigItemBinding;
        View root;
        IncludeMatchBigItemBinding includeMatchBigItemBinding2;
        View root2;
        IncludeMatchBigItemBinding includeMatchBigItemBinding3;
        View root3;
        IncludeMatchBigItemBinding includeMatchBigItemBinding4;
        View root4;
        IncludeMatchBigItemBinding includeMatchBigItemBinding5;
        View root5;
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (includeMatchBigItemBinding5 = fragmentHomeMatchingHeadBinding.matchLayout) != null && (root5 = includeMatchBigItemBinding5.getRoot()) != null) {
            root5.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#15A5EC", "#01E3E1", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding2 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding2 != null && (includeMatchBigItemBinding4 = fragmentHomeMatchingHeadBinding2.chatLayout) != null && (root4 = includeMatchBigItemBinding4.getRoot()) != null) {
            root4.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#FB6AB7", "#FEBEA5", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding3 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding3 != null && (includeMatchBigItemBinding3 = fragmentHomeMatchingHeadBinding3.videoLayout) != null && (root3 = includeMatchBigItemBinding3.getRoot()) != null) {
            root3.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#3E97FF", "#8ECCFF", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding4 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding4 != null && (includeMatchBigItemBinding2 = fragmentHomeMatchingHeadBinding4.broadcastLayout) != null && (root2 = includeMatchBigItemBinding2.getRoot()) != null) {
            root2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#986CFF", "#E497FD", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding5 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding5 != null && (includeMatchBigItemBinding = fragmentHomeMatchingHeadBinding5.baiShun) != null && (root = includeMatchBigItemBinding.getRoot()) != null) {
            root.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#FE6666", "#FDB55F", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding != null && (linearLayout = fragmentHomeMatchingBinding.topLinearLayout) != null) {
            linearLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33000000", "#33000000", 15, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding6 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding6 != null && (planetsView2 = fragmentHomeMatchingHeadBinding6.planetView) != null) {
            planetsView2.setAdapter(getMPlanetsAdapter());
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding7 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding7 != null && (planetsView = fragmentHomeMatchingHeadBinding7.planetView) != null) {
            planetsView.setOnTagClickListener(new PlanetsView.OnTagClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupPlanetView$1
                @Override // com.qiahao.nextvideo.view.planet.PlanetsView.OnTagClickListener
                public void onItemClick(ViewGroup parent, View view, int position) {
                    HiloPlanetsAdapter mPlanetsAdapter;
                    String externalId;
                    mPlanetsAdapter = HomeMatchingFragment.this.getMPlanetsAdapter();
                    HiloPlanetsData hiloPlanetsData = (HiloPlanetsData) CollectionsKt.getOrNull(mPlanetsAdapter.getMList(), position);
                    if (hiloPlanetsData != null) {
                        String str = "";
                        if (TextUtils.isEmpty(hiloPlanetsData.getCurrentRoom())) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            User user = hiloPlanetsData.getUser();
                            if (user != null && (externalId = user.getExternalId()) != null) {
                                str = externalId;
                            }
                            baseControlUtils.openPersonPage(str);
                            return;
                        }
                        BaseControlUtils baseControlUtils2 = BaseControlUtils.INSTANCE;
                        String currentRoom = hiloPlanetsData.getCurrentRoom();
                        if (currentRoom != null) {
                            str = currentRoom;
                        }
                        baseControlUtils2.openRoom(str);
                    }
                }
            });
        }
    }

    private final void setupRecyclerView() {
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding;
        HomeMatchRecycleView homeMatchRecycleView;
        HomeMatchRecycleView homeMatchRecycleView2;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding2 != null && (homeMatchRecycleView2 = fragmentHomeMatchingBinding2.recyclerView) != null) {
            homeMatchRecycleView2.setAdapter(getMatchUserAdapter());
        }
        RecyclerView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null && (fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding()) != null && (homeMatchRecycleView = fragmentHomeMatchingBinding.recyclerView) != null) {
            homeMatchRecycleView.addOnScrollListener(onScrollListener);
        }
        setupAdapterClickListeners();
    }

    private final void setupRefreshLayout() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding != null && (smartRefreshLayout3 = fragmentHomeMatchingBinding.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.matching.g
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    HomeMatchingFragment.setupRefreshLayout$lambda$17(HomeMatchingFragment.this, fVar);
                }
            });
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding2 != null && (smartRefreshLayout2 = fragmentHomeMatchingBinding2.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.matching.h
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    HomeMatchingFragment.setupRefreshLayout$lambda$18(HomeMatchingFragment.this, fVar);
                }
            });
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding3 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding3 != null && (smartRefreshLayout = fragmentHomeMatchingBinding3.refreshLayout) != null) {
                smartRefreshLayout.setRefreshFooter(footLoading);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRefreshLayout$lambda$17(HomeMatchingFragment homeMatchingFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (HiloUtils.INSTANCE.isFastClick()) {
            return;
        }
        homeMatchingFragment.refreshAllData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRefreshLayout$lambda$18(HomeMatchingFragment homeMatchingFragment, tc.f fVar) {
        SmartRefreshLayout smartRefreshLayout;
        BaseListData baseListData;
        Intrinsics.checkNotNullParameter(fVar, "it");
        MatchViewModel matchViewModel = homeMatchingFragment.viewModel;
        if (matchViewModel != null && (baseListData = matchViewModel.getBaseListData()) != null && baseListData.hashNextPage()) {
            MatchViewModel matchViewModel2 = homeMatchingFragment.viewModel;
            if (matchViewModel2 != null) {
                matchViewModel2.superLikeList();
                return;
            }
            return;
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) homeMatchingFragment.getBinding();
        if (fragmentHomeMatchingBinding != null && (smartRefreshLayout = fragmentHomeMatchingBinding.refreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
    }

    private final void setupTopBar() {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            this.currentUser = user;
            getUserWealthLevelChangeUI();
        }
    }

    private final void setupVideoMatchMode() {
        IncludeMatchBigItemBinding includeMatchBigItemBinding;
        final View root;
        IncludeMatchBigItemBinding includeMatchBigItemBinding2;
        ImageView imageView;
        IncludeMatchBigItemBinding includeMatchBigItemBinding3;
        TextView textView;
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (includeMatchBigItemBinding3 = fragmentHomeMatchingHeadBinding.matchLayout) != null && (textView = includeMatchBigItemBinding3.title) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, 2131954432));
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding2 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding2 != null && (includeMatchBigItemBinding2 = fragmentHomeMatchingHeadBinding2.matchLayout) != null && (imageView = includeMatchBigItemBinding2.image) != null) {
            imageView.setImageResource(R.drawable.home_video_icon);
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding3 = this.headBinding;
        if (fragmentHomeMatchingHeadBinding3 != null && (includeMatchBigItemBinding = fragmentHomeMatchingHeadBinding3.matchLayout) != null && (root = includeMatchBigItemBinding.getRoot()) != null) {
            final long j = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.HomeMatchingFragment$setupVideoMatchMode$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        this.handleMatchButtonClick();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFoundGuysAnimation() {
        ConstraintLayout constraintLayout;
        SVGAImageView sVGAImageView;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding != null && (constraintLayout = fragmentHomeMatchingBinding.foundGuysSvgaContainer) != null) {
            constraintLayout.setVisibility(0);
            FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
            if (fragmentHomeMatchingBinding2 != null && (sVGAImageView = fragmentHomeMatchingBinding2.foundGuysSvgaImageView) != null) {
                sVGAImageView.startAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGemDialog() {
        new GemStoreDialog().show(getChildFragmentManager(), "other");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startOrStopAnimation(final boolean isStart) {
        PlanetsView planetsView;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastAnimationTriggerTime > this.animationTriggerDelay) {
            this.lastAnimationTriggerTime = currentTimeMillis;
            FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
            if (fragmentHomeMatchingHeadBinding != null && (planetsView = fragmentHomeMatchingHeadBinding.planetView) != null) {
                planetsView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.matching.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeMatchingFragment.startOrStopAnimation$lambda$56(HomeMatchingFragment.this, isStart);
                    }
                }, 700L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startOrStopAnimation$lambda$56(HomeMatchingFragment homeMatchingFragment, boolean z) {
        PlanetsView planetsView;
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = homeMatchingFragment.headBinding;
        if (fragmentHomeMatchingHeadBinding != null && (planetsView = fragmentHomeMatchingHeadBinding.planetView) != null) {
            planetsView.startOrStop(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWealthDisplay() {
        TextView textView;
        Double pinkDiamondNum;
        TextView textView2;
        Long l;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding();
        Long l2 = null;
        if (fragmentHomeMatchingBinding != null && (textView2 = fragmentHomeMatchingBinding.diamondTextView) != null) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                l = Long.valueOf(MathKt.roundToLong(user.getDiamondNum()));
            } else {
                l = null;
            }
            textView2.setText(String.valueOf(l));
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding2 != null && (textView = fragmentHomeMatchingBinding2.gemTextView) != null) {
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null && (pinkDiamondNum = user2.getPinkDiamondNum()) != null) {
                l2 = Long.valueOf(MathKt.roundToLong(pinkDiamondNum.doubleValue()));
            }
            textView.setText(String.valueOf(l2));
        }
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_home_matching;
    }

    @Nullable
    public final Function1<Boolean, Unit> getMListener() {
        return this.mListener;
    }

    public void onDestroyView() {
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding;
        HomeMatchRecycleView homeMatchRecycleView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        HomeMatchRecycleView homeMatchRecycleView2;
        super.onDestroyView();
        this.compositeDisposable.d();
        getMatchUserAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMatchUserAdapter().setOnItemChildClickListener((OnItemChildClickListener) null);
        getMatchUserAdapter().removeAllHeaderView();
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding2 != null && (homeMatchRecycleView2 = fragmentHomeMatchingBinding2.recyclerView) != null) {
            homeMatchRecycleView2.setAdapter((RecyclerView.Adapter) null);
        }
        FragmentHomeMatchingHeadBinding fragmentHomeMatchingHeadBinding = this.headBinding;
        if (fragmentHomeMatchingHeadBinding != null) {
            fragmentHomeMatchingHeadBinding.unbind();
        }
        this.headBinding = null;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding3 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding3 != null && (smartRefreshLayout2 = fragmentHomeMatchingBinding3.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(null);
        }
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding4 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding4 != null && (smartRefreshLayout = fragmentHomeMatchingBinding4.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(null);
        }
        RecyclerView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null && (fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding()) != null && (homeMatchRecycleView = fragmentHomeMatchingBinding.recyclerView) != null) {
            homeMatchRecycleView.removeOnScrollListener(onScrollListener);
        }
        this.mScrollListener = null;
        clearMatchingView();
        MatchPermissionDialog matchPermissionDialog = this.mPermissionDialog;
        if (matchPermissionDialog != null) {
            matchPermissionDialog.dismiss();
        }
        this.mPermissionDialog = null;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        setStatusBar();
        initView();
        initData();
    }

    public void onPause() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        startOrStopAnimation(false);
    }

    public void onResume() {
        ArrayList arrayList;
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding;
        SmartRefreshLayout smartRefreshLayout;
        LiveData<ArrayList<HiloPlanetsData>> recommendList;
        ImageView imageView;
        int i;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "task_activity_url", "", (String) null, 4, (Object) null);
        FragmentHomeMatchingBinding fragmentHomeMatchingBinding2 = (FragmentHomeMatchingBinding) getBinding();
        if (fragmentHomeMatchingBinding2 != null && (imageView = fragmentHomeMatchingBinding2.chest) != null) {
            if (TextUtils.isEmpty(str)) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
        }
        setStatusBar();
        startOrStopAnimation(true);
        MatchViewModel matchViewModel = this.viewModel;
        if (matchViewModel != null && (recommendList = matchViewModel.getRecommendList()) != null) {
            arrayList = (ArrayList) recommendList.getValue();
        } else {
            arrayList = null;
        }
        if ((arrayList == null || arrayList.isEmpty()) && (fragmentHomeMatchingBinding = (FragmentHomeMatchingBinding) getBinding()) != null && (smartRefreshLayout = fragmentHomeMatchingBinding.refreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        switch (type.hashCode()) {
            case -2032180703:
                if (type.equals("DEFAULT")) {
                    MatchingProvide.INSTANCE.setMatchStatue("default");
                    clearMatchingView();
                    refreshAllView();
                    return;
                }
                return;
            case -1251662226:
                if (type.equals("MATCH_REFRESH_CARD")) {
                    refreshAllView();
                    return;
                }
                return;
            case -684767089:
                if (type.equals("MATCH_SHOW_RECHARGE")) {
                    showGemDialog();
                    return;
                }
                return;
            case 2555906:
                if (type.equals("STOP")) {
                    MatchingProvide.INSTANCE.setMatchStatue("default");
                    clearMatchingView();
                    refreshAllView();
                    return;
                }
                return;
            case 35394935:
                if (type.equals("PENDING")) {
                    MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
                    if (Intrinsics.areEqual(matchingProvide.getMatchStatue(), MatchingProvide.MATCH_START_MATCH)) {
                        matchingProvide.setMatchStatue(MatchingProvide.MATCH_PENDING);
                        Object data = event.getData();
                        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy.MatchSuccess");
                        processRandomPairPending((UserProxy.MatchSuccess) data);
                    }
                    refreshAllView();
                    return;
                }
                return;
            case 1539528552:
                if (type.equals("START_MATCH")) {
                    refreshAllView();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setMListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.mListener = function1;
    }
}
