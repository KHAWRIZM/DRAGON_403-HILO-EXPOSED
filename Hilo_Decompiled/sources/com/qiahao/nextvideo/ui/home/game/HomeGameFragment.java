package com.qiahao.nextvideo.ui.home.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.GameQuickMatch;
import com.qiahao.nextvideo.data.game.HomeGameUser;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.FragmentHomeGameBinding;
import com.qiahao.nextvideo.databinding.FragmentHomeGameHeadBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.SkinMessage;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import com.zhpan.bannerview.BannerViewPager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0006\u0010\u001e\u001a\u00020\u001cJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J$\u0010#\u001a\u00020\u001c2\b\u0010$\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020\u001cH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/game/HomeGameFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentHomeGameBinding;", "<init>", "()V", "getLayoutResId", "", "viewModel", "Lcom/qiahao/nextvideo/ui/home/game/GameLobbyViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/game/GameLobbyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "headBinding", "Lcom/qiahao/nextvideo/databinding/FragmentHomeGameHeadBinding;", "gameUserAdapter", "Lcom/qiahao/nextvideo/ui/home/game/HomeGameUserAdapter;", "getGameUserAdapter", "()Lcom/qiahao/nextvideo/ui/home/game/HomeGameUserAdapter;", "gameUserAdapter$delegate", "gameAdapter", "Lcom/qiahao/nextvideo/ui/home/game/HomeGameAdapter;", "getGameAdapter", "()Lcom/qiahao/nextvideo/ui/home/game/HomeGameAdapter;", "gameAdapter$delegate", "broadcastAdapter", "Lcom/qiahao/nextvideo/ui/home/game/GameBroadcastAdapter;", "onInitialize", "", "initData", "initView", "checkQuickGame", "gameType", "refreshSkin", "setStatusBar", "checkClick", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "onResume", "onPause", "onDestroyView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeGameFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeGameFragment.kt\ncom/qiahao/nextvideo/ui/home/game/HomeGameFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,343:1\n1#2:344\n61#3,9:345\n61#3,9:354\n61#3,9:363\n61#3,9:372\n61#3,9:381\n*S KotlinDebug\n*F\n+ 1 HomeGameFragment.kt\ncom/qiahao/nextvideo/ui/home/game/HomeGameFragment\n*L\n172#1:345,9\n177#1:354,9\n209#1:363,9\n217#1:372,9\n221#1:381,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeGameFragment extends BaseBindingFragment<FragmentHomeGameBinding> {

    @Nullable
    private GameBroadcastAdapter broadcastAdapter;

    @Nullable
    private FragmentHomeGameHeadBinding headBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.game.q
        public final Object invoke() {
            GameLobbyViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = HomeGameFragment.viewModel_delegate$lambda$0(HomeGameFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: gameUserAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameUserAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.game.r
        public final Object invoke() {
            HomeGameUserAdapter gameUserAdapter_delegate$lambda$1;
            gameUserAdapter_delegate$lambda$1 = HomeGameFragment.gameUserAdapter_delegate$lambda$1();
            return gameUserAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: gameAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.game.s
        public final Object invoke() {
            HomeGameAdapter gameAdapter_delegate$lambda$2;
            gameAdapter_delegate$lambda$2 = HomeGameFragment.gameAdapter_delegate$lambda$2();
            return gameAdapter_delegate$lambda$2;
        }
    });

    private final void checkClick(Context context, Function0<Unit> listener) {
        if (MeetingRoomManager.INSTANCE.checkMatchGame()) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, ResourcesKtxKt.getStringById(this, 2131953693), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        if (listener != null) {
            listener.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void checkClick$default(HomeGameFragment homeGameFragment, Context context, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        homeGameFragment.checkClick(context, function0);
    }

    private final void checkQuickGame(final int gameType) {
        Object context = getContext();
        if (context != null) {
            HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) context, (String) null, false, (Function0) null, 7, (Object) null);
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getQuickID(gameType), new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.x
            public final Object invoke(Object obj) {
                Unit checkQuickGame$lambda$28;
                checkQuickGame$lambda$28 = HomeGameFragment.checkQuickGame$lambda$28(HomeGameFragment.this, gameType, (ApiResponse) obj);
                return checkQuickGame$lambda$28;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.y
            public final Object invoke(Object obj) {
                Unit checkQuickGame$lambda$30;
                checkQuickGame$lambda$30 = HomeGameFragment.checkQuickGame$lambda$30(HomeGameFragment.this, (Throwable) obj);
                return checkQuickGame$lambda$30;
            }
        }, (Function0) null, false, 12, (Object) null), getViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkQuickGame$lambda$28(HomeGameFragment homeGameFragment, int i, ApiResponse apiResponse) {
        String str;
        String str2;
        String gameCode;
        String groupId;
        Intrinsics.checkNotNullParameter(apiResponse, "data");
        Object context = homeGameFragment.getContext();
        if (context != null) {
            HiloBaseActivity.dismissProgressDialog$default((HiloBaseActivity) context, false, null, 3, null);
            StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
            GameQuickMatch gameQuickMatch = (GameQuickMatch) apiResponse.getData();
            if (gameQuickMatch == null || (groupId = gameQuickMatch.getGroupId()) == null) {
                str = "";
            } else {
                str = groupId;
            }
            GameQuickMatch gameQuickMatch2 = (GameQuickMatch) apiResponse.getData();
            if (gameQuickMatch2 == null || (gameCode = gameQuickMatch2.getGameCode()) == null) {
                str2 = "";
            } else {
                str2 = gameCode;
            }
            StartRoomUtils.start$default(startRoomUtils, str, false, 0, null, null, null, null, 0, 0, i, str2, null, false, 0, false, 0, 63998, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkQuickGame$lambda$30(HomeGameFragment homeGameFragment, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        Object context = homeGameFragment.getContext();
        if (context != null) {
            HiloBaseActivity.dismissProgressDialog$default((HiloBaseActivity) context, false, null, 3, null);
        }
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context2 = homeGameFragment.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(homeGameFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context2, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeGameAdapter gameAdapter_delegate$lambda$2() {
        return new HomeGameAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeGameUserAdapter gameUserAdapter_delegate$lambda$1() {
        return new HomeGameUserAdapter();
    }

    private final HomeGameAdapter getGameAdapter() {
        return (HomeGameAdapter) this.gameAdapter.getValue();
    }

    private final HomeGameUserAdapter getGameUserAdapter() {
        return (HomeGameUserAdapter) this.gameUserAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameLobbyViewModel getViewModel() {
        return (GameLobbyViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getGameBroadcast().observe(this, new HomeGameFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.z
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = HomeGameFragment.initData$lambda$3(HomeGameFragment.this, (ArrayList) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getHomeGameList().observe(this, new HomeGameFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.a0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = HomeGameFragment.initData$lambda$4(HomeGameFragment.this, (ArrayList) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getHomeGameUserList().observe(this, new HomeGameFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.b0
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = HomeGameFragment.initData$lambda$5(HomeGameFragment.this, (List) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getCreateRoom().observe(this, new HomeGameFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.n
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = HomeGameFragment.initData$lambda$6((CreateGroupBean) obj);
                return initData$lambda$6;
            }
        }));
        getViewModel().getMException().observe(this, new HomeGameFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.o
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = HomeGameFragment.initData$lambda$7(HomeGameFragment.this, (Pair) obj);
                return initData$lambda$7;
            }
        }));
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.game.HomeGameFragment$initData$6
            public final void accept(UserObjectEvent userObjectEvent) {
                FragmentHomeGameBinding fragmentHomeGameBinding;
                TextView textView;
                if (userObjectEvent != null) {
                    HomeGameFragment homeGameFragment = HomeGameFragment.this;
                    if ((userObjectEvent.getType() != UserObjectEventType.REFRESH_MONEY && userObjectEvent.getType() != UserObjectEventType.REFRESH) || (fragmentHomeGameBinding = (FragmentHomeGameBinding) homeGameFragment.getBinding()) == null || (textView = fragmentHomeGameBinding.diamondText) == null) {
                        return;
                    }
                    User user = UserStore.INSTANCE.getShared().getUser();
                    textView.setText(String.valueOf(user != null ? Long.valueOf(MathKt.roundToLong(user.getDiamondNum())) : null));
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getViewModel().getMCompositeDisposable());
        getViewModel().getHomeUserBaseData().resetPage();
        getViewModel().homeGameList();
        getViewModel().homeGameUserList();
        getViewModel().m٧٤getGameBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(HomeGameFragment homeGameFragment, ArrayList arrayList) {
        BannerViewPager bannerViewPager;
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) homeGameFragment.getBinding();
        if (fragmentHomeGameBinding != null && (bannerViewPager = fragmentHomeGameBinding.bannerBroadcast) != null) {
            bannerViewPager.C(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(HomeGameFragment homeGameFragment, ArrayList arrayList) {
        homeGameFragment.getGameAdapter().setList(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(HomeGameFragment homeGameFragment, List list) {
        SmartRefreshLayout smartRefreshLayout;
        int i;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        BaseStatusEmptyBinding baseStatusEmptyBinding2;
        ConstraintLayout root2;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout4;
        SmartRefreshLayout smartRefreshLayout5;
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) homeGameFragment.getBinding();
        if (fragmentHomeGameBinding != null && (smartRefreshLayout5 = fragmentHomeGameBinding.refreshLayout) != null) {
            smartRefreshLayout5.finishRefresh();
        }
        FragmentHomeGameBinding fragmentHomeGameBinding2 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
        if (fragmentHomeGameBinding2 != null && (smartRefreshLayout4 = fragmentHomeGameBinding2.refreshLayout) != null) {
            smartRefreshLayout4.finishLoadMore();
        }
        FragmentHomeGameBinding fragmentHomeGameBinding3 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
        if (fragmentHomeGameBinding3 != null && (superStatusView = fragmentHomeGameBinding3.statusView) != null) {
            superStatusView.showContent();
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding = homeGameFragment.headBinding;
        if (fragmentHomeGameHeadBinding != null && (baseStatusEmptyBinding2 = fragmentHomeGameHeadBinding.empty) != null && (root2 = baseStatusEmptyBinding2.getRoot()) != null) {
            root2.setVisibility(8);
        }
        boolean z = true;
        if (homeGameFragment.getViewModel().getHomeUserBaseData().isOnePage()) {
            if (list.isEmpty()) {
                homeGameFragment.getGameUserAdapter().setList((Collection) null);
                FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding2 = homeGameFragment.headBinding;
                if (fragmentHomeGameHeadBinding2 != null && (baseStatusEmptyBinding = fragmentHomeGameHeadBinding2.empty) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
                    root.setVisibility(0);
                }
                FragmentHomeGameBinding fragmentHomeGameBinding4 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
                if (fragmentHomeGameBinding4 != null && (smartRefreshLayout3 = fragmentHomeGameBinding4.refreshLayout) != null) {
                    smartRefreshLayout3.setNoMoreData(true);
                }
            } else {
                FragmentHomeGameBinding fragmentHomeGameBinding5 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
                if (fragmentHomeGameBinding5 != null && (smartRefreshLayout2 = fragmentHomeGameBinding5.refreshLayout) != null) {
                    if (list.size() >= homeGameFragment.getViewModel().getHomeUserBaseData().getPageSize()) {
                        z = false;
                    }
                    smartRefreshLayout2.setNoMoreData(z);
                }
                homeGameFragment.getGameUserAdapter().setList(list);
            }
        } else {
            FragmentHomeGameBinding fragmentHomeGameBinding6 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
            if (fragmentHomeGameBinding6 != null && (smartRefreshLayout = fragmentHomeGameBinding6.refreshLayout) != null) {
                if (list != null) {
                    i = list.size();
                } else {
                    i = 0;
                }
                if (i >= homeGameFragment.getViewModel().getHomeUserBaseData().getPageSize()) {
                    z = false;
                }
                smartRefreshLayout.setNoMoreData(z);
            }
            HomeGameUserAdapter gameUserAdapter = homeGameFragment.getGameUserAdapter();
            Intrinsics.checkNotNull(list);
            gameUserAdapter.addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(CreateGroupBean createGroupBean) {
        String str;
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        if (createGroupBean == null || (str = createGroupBean.getImGroupId()) == null) {
            str = "";
        }
        StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(HomeGameFragment homeGameFragment, Pair pair) {
        String str;
        String str2;
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        if (Intrinsics.areEqual(pair.getFirst(), GameLobbyViewModel.GAME_USER_LIST)) {
            FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) homeGameFragment.getBinding();
            if (fragmentHomeGameBinding != null && (smartRefreshLayout2 = fragmentHomeGameBinding.refreshLayout) != null) {
                smartRefreshLayout2.finishRefresh();
            }
            FragmentHomeGameBinding fragmentHomeGameBinding2 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
            if (fragmentHomeGameBinding2 != null && (smartRefreshLayout = fragmentHomeGameBinding2.refreshLayout) != null) {
                smartRefreshLayout.finishLoadMore();
            }
            FragmentHomeGameBinding fragmentHomeGameBinding3 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
            if (fragmentHomeGameBinding3 != null && (superStatusView = fragmentHomeGameBinding3.statusView) != null) {
                superStatusView.showContent();
            }
            if (homeGameFragment.getViewModel().getHomeUserBaseData().isOnePage()) {
                homeGameFragment.getGameUserAdapter().setList((Collection) null);
                FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding = homeGameFragment.headBinding;
                if (fragmentHomeGameHeadBinding != null && (baseStatusEmptyBinding = fragmentHomeGameHeadBinding.empty) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
                    root.setVisibility(0);
                }
            }
            if (pair.getSecond() instanceof HiloException) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = homeGameFragment.getContext();
                Object second = pair.getSecond();
                Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                String errorMessage = ((HiloException) second).getErrorMessage();
                if (errorMessage == null) {
                    str2 = ResourcesKtxKt.getStringById(homeGameFragment, 2131952667);
                } else {
                    str2 = errorMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str2, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        } else if (Intrinsics.areEqual(pair.getFirst(), "CREATE_ROOM") && (pair.getSecond() instanceof HiloException)) {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            Context context2 = homeGameFragment.getContext();
            Object second2 = pair.getSecond();
            Intrinsics.checkNotNull(second2, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage2 = ((HiloException) second2).getErrorMessage();
            if (errorMessage2 == null) {
                str = ResourcesKtxKt.getStringById(homeGameFragment, 2131952667);
            } else {
                str = errorMessage2;
            }
            Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, context2, str, false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$15(HomeGameFragment homeGameFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        boolean z;
        Boolean is1V1;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        HomeGameUser homeGameUser = (HomeGameUser) homeGameFragment.getGameUserAdapter().getData().get(i);
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        GameConfiguration game = homeGameUser.getGame();
        if (game == null || (str = game.getGroupId()) == null) {
            str = "";
        }
        GameConfiguration game2 = homeGameUser.getGame();
        if (game2 != null && (is1V1 = game2.is1V1()) != null) {
            z = is1V1.booleanValue();
        } else {
            z = false;
        }
        StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 0, null, 0, z, 4094, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$18(HomeGameFragment homeGameFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GameConfiguration gameConfiguration = (GameConfiguration) homeGameFragment.getGameAdapter().getData().get(i);
        Integer gameId = gameConfiguration.getGameId();
        if ((gameId == null || gameId.intValue() != 1) && ((gameId == null || gameId.intValue() != 2) && ((gameId == null || gameId.intValue() != 16) && ((gameId == null || gameId.intValue() != 21) && ((gameId == null || gameId.intValue() != 9) && ((gameId == null || gameId.intValue() != 15) && (gameId == null || gameId.intValue() != 41))))))) {
            if (gameId != null && gameId.intValue() == 29) {
                homeGameFragment.checkQuickGame(14);
                return;
            }
            Context context = homeGameFragment.getContext();
            if (context != null) {
                GameJum.INSTANCE.showGame(context, gameConfiguration);
                return;
            }
            return;
        }
        if (homeGameFragment.getContext() != null) {
            GameJum gameJum = GameJum.INSTANCE;
            Integer gameId2 = gameConfiguration.getGameId();
            if (gameId2 != null) {
                i2 = gameId2.intValue();
            } else {
                i2 = 0;
            }
            Integer gameType = gameConfiguration.getGameType();
            if (gameType != null) {
                i3 = gameType.intValue();
            } else {
                i3 = 0;
            }
            GameJum.matchGame$default(gameJum, 0, i2, 0, i3, null, 21, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$24(HomeGameFragment homeGameFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        homeGameFragment.getViewModel().getHomeUserBaseData().resetPage();
        homeGameFragment.getViewModel().homeGameList();
        homeGameFragment.getViewModel().homeGameUserList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$25(HomeGameFragment homeGameFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        homeGameFragment.getViewModel().homeGameUserList();
    }

    private final void refreshSkin() {
        String str;
        TextView textView;
        ImageView imageView;
        Drawable drawable;
        TextView textView2;
        ImageView imageView2;
        SkinMessage skinMessage = SkinMessage.INSTANCE;
        SkinData skinData = skinMessage.skinData();
        if (skinData == null || (str = skinData.getTopBg2()) == null) {
            str = "";
        }
        File file = new File(str);
        if (skinMessage.checkSkin() && file.exists() && file.isFile()) {
            FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) getBinding();
            if (fragmentHomeGameBinding != null && (imageView2 = fragmentHomeGameBinding.topBg) != null) {
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65531, (Object) null);
            }
            FragmentHomeGameBinding fragmentHomeGameBinding2 = (FragmentHomeGameBinding) getBinding();
            if (fragmentHomeGameBinding2 != null && (textView2 = fragmentHomeGameBinding2.diamondText) != null) {
                textView2.setTextColor(Color.parseColor("#ffffff"));
                return;
            }
            return;
        }
        FragmentHomeGameBinding fragmentHomeGameBinding3 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding3 != null && (imageView = fragmentHomeGameBinding3.topBg) != null) {
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.game_bg);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
        }
        FragmentHomeGameBinding fragmentHomeGameBinding4 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding4 != null && (textView = fragmentHomeGameBinding4.diamondText) != null) {
            textView.setTextColor(Color.parseColor("#0B5927"));
        }
    }

    private final void setStatusBar() {
        ConstraintLayout constraintLayout;
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding != null && (constraintLayout = fragmentHomeGameBinding.moneyLayout) != null) {
            constraintLayout.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.game.p
                @Override // java.lang.Runnable
                public final void run() {
                    HomeGameFragment.setStatusBar$lambda$33(HomeGameFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStatusBar$lambda$33(final HomeGameFragment homeGameFragment) {
        ConstraintLayout constraintLayout;
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) homeGameFragment.getBinding();
        if (fragmentHomeGameBinding != null) {
            constraintLayout = fragmentHomeGameBinding.moneyLayout;
        } else {
            constraintLayout = null;
        }
        homeGameFragment.getStatusBarTopOrBottom(constraintLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.home.game.w
            public final Object invoke(Object obj, Object obj2) {
                Unit statusBar$lambda$33$lambda$32;
                statusBar$lambda$33$lambda$32 = HomeGameFragment.setStatusBar$lambda$33$lambda$32(HomeGameFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return statusBar$lambda$33$lambda$32;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setStatusBar$lambda$33$lambda$32(HomeGameFragment homeGameFragment, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout constraintLayout;
        int px;
        int i3;
        ConstraintLayout constraintLayout2;
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) homeGameFragment.getBinding();
        ConstraintLayout.b bVar = null;
        if (fragmentHomeGameBinding != null && (constraintLayout2 = fragmentHomeGameBinding.moneyLayout) != null) {
            layoutParams = constraintLayout2.getLayoutParams();
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
                px = UiKtxKt.toPX(55);
            }
            int px2 = i + UiKtxKt.toPX(10);
            if (hiloUtils.getRightToLeftDirection()) {
                i3 = UiKtxKt.toPX(55);
            } else {
                i3 = 0;
            }
            bVar.setMargins(px, px2, i3, 0);
        }
        FragmentHomeGameBinding fragmentHomeGameBinding2 = (FragmentHomeGameBinding) homeGameFragment.getBinding();
        if (fragmentHomeGameBinding2 != null && (constraintLayout = fragmentHomeGameBinding2.moneyLayout) != null) {
            constraintLayout.setLayoutParams(bVar);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameLobbyViewModel viewModel_delegate$lambda$0(HomeGameFragment homeGameFragment) {
        return new ViewModelProvider(homeGameFragment).get(GameLobbyViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_home_game;
    }

    public final void initView() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        final ImageView imageView;
        final ConstraintLayout constraintLayout;
        final ImageView imageView2;
        RecyclerView recyclerView;
        final ImageView imageView3;
        final ImageView imageView4;
        TextView textView;
        TextView textView2;
        View root;
        RecyclerView recyclerView2;
        SmartRefreshLayout smartRefreshLayout3;
        this.broadcastAdapter = new GameBroadcastAdapter();
        BannerViewPager bannerViewPager = null;
        this.headBinding = (FragmentHomeGameHeadBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.fragment_home_game_head, (ViewGroup) null, false);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) getBinding();
            if (fragmentHomeGameBinding != null && (smartRefreshLayout3 = fragmentHomeGameBinding.refreshLayout) != null) {
                smartRefreshLayout3.setRefreshFooter(footLoading);
            }
        }
        FragmentHomeGameBinding fragmentHomeGameBinding2 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding2 != null && (recyclerView2 = fragmentHomeGameBinding2.recyclerView) != null) {
            recyclerView2.setAdapter(getGameUserAdapter());
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding = this.headBinding;
        if (fragmentHomeGameHeadBinding != null && (root = fragmentHomeGameHeadBinding.getRoot()) != null) {
            BaseQuickAdapter.setHeaderView$default(getGameUserAdapter(), root, 0, 0, 6, (Object) null);
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding2 = this.headBinding;
        if (fragmentHomeGameHeadBinding2 != null && (textView2 = fragmentHomeGameHeadBinding2.ludoText) != null) {
            textView2.setText(String.valueOf(RangesKt.random(new IntRange(70000, 80000), Random.Default)));
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding3 = this.headBinding;
        if (fragmentHomeGameHeadBinding3 != null && (textView = fragmentHomeGameHeadBinding3.unoText) != null) {
            textView.setText(String.valueOf(RangesKt.random(new IntRange(70000, 80000), Random.Default)));
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding4 = this.headBinding;
        final long j = 800;
        if (fragmentHomeGameHeadBinding4 != null && (imageView4 = fragmentHomeGameHeadBinding4.ludo) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.HomeGameFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                        if (this.getContext() != null) {
                            GameJum.matchGame$default(GameJum.INSTANCE, 0, 1, 1, 1, null, 17, null);
                        }
                    }
                }
            });
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding5 = this.headBinding;
        if (fragmentHomeGameHeadBinding5 != null && (imageView3 = fragmentHomeGameHeadBinding5.uno) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.HomeGameFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                        if (this.getContext() != null) {
                            GameJum.matchGame$default(GameJum.INSTANCE, 0, 2, 0, 2, null, 21, null);
                        }
                    }
                }
            });
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding6 = this.headBinding;
        if (fragmentHomeGameHeadBinding6 != null && (recyclerView = fragmentHomeGameHeadBinding6.gameRecyclerView) != null) {
            recyclerView.setAdapter(getGameAdapter());
        }
        getGameUserAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.m
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HomeGameFragment.initView$lambda$15(HomeGameFragment.this, baseQuickAdapter, view, i);
            }
        });
        getGameAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.t
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HomeGameFragment.initView$lambda$18(HomeGameFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentHomeGameBinding fragmentHomeGameBinding3 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding3 != null && (imageView2 = fragmentHomeGameBinding3.chest) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.HomeGameFragment$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                        Context context2 = this.getContext();
                        if (context2 != null) {
                            DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, context2, (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_activity_url", "", (String) null, 4, (Object) null), null, 4, null);
                        }
                    }
                }
            });
        }
        FragmentHomeGameBinding fragmentHomeGameBinding4 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding4 != null && (constraintLayout = fragmentHomeGameBinding4.moneyLayout) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.HomeGameFragment$initView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        Context context2 = this.getContext();
                        if (context2 != null) {
                            WalletActivity.INSTANCE.start(context2);
                        }
                    }
                }
            });
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding7 = this.headBinding;
        if (fragmentHomeGameHeadBinding7 != null && (baseStatusEmptyBinding = fragmentHomeGameHeadBinding7.empty) != null && (imageView = baseStatusEmptyBinding.ivIcon) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.HomeGameFragment$initView$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameLobbyViewModel viewModel;
                    GameLobbyViewModel viewModel2;
                    GameLobbyViewModel viewModel3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        viewModel = this.getViewModel();
                        viewModel.getHomeUserBaseData().resetPage();
                        viewModel2 = this.getViewModel();
                        viewModel2.homeGameList();
                        viewModel3 = this.getViewModel();
                        viewModel3.homeGameUserList();
                    }
                }
            });
        }
        FragmentHomeGameBinding fragmentHomeGameBinding5 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding5 != null && (smartRefreshLayout2 = fragmentHomeGameBinding5.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.game.u
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    HomeGameFragment.initView$lambda$24(HomeGameFragment.this, fVar);
                }
            });
        }
        FragmentHomeGameBinding fragmentHomeGameBinding6 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding6 != null && (smartRefreshLayout = fragmentHomeGameBinding6.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.game.v
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    HomeGameFragment.initView$lambda$25(HomeGameFragment.this, fVar);
                }
            });
        }
        FragmentHomeGameBinding fragmentHomeGameBinding7 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding7 != null) {
            bannerViewPager = fragmentHomeGameBinding7.bannerBroadcast;
        }
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.game.GameBroadcast>");
        bannerViewPager.G(this.broadcastAdapter);
        bannerViewPager.I(true);
        bannerViewPager.S(HonorResultCode.ADVANCED_RECORD_SUCCESS);
        bannerViewPager.c0(500);
        bannerViewPager.V(1);
        bannerViewPager.g();
    }

    public void onDestroyView() {
        BannerViewPager bannerViewPager;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        View root;
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding != null) {
            bannerViewPager = fragmentHomeGameBinding.bannerBroadcast;
        } else {
            bannerViewPager = null;
        }
        if (!(bannerViewPager instanceof BannerViewPager)) {
            bannerViewPager = null;
        }
        if (bannerViewPager != null) {
            bannerViewPager.G(null);
        }
        this.broadcastAdapter = null;
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding = this.headBinding;
        if (fragmentHomeGameHeadBinding != null && (root = fragmentHomeGameHeadBinding.getRoot()) != null) {
            getGameUserAdapter().removeHeaderView(root);
        }
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding2 = this.headBinding;
        if (fragmentHomeGameHeadBinding2 != null) {
            fragmentHomeGameHeadBinding2.unbind();
        }
        this.headBinding = null;
        FragmentHomeGameBinding fragmentHomeGameBinding2 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding2 != null && (smartRefreshLayout2 = fragmentHomeGameBinding2.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(null);
        }
        FragmentHomeGameBinding fragmentHomeGameBinding3 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding3 != null && (smartRefreshLayout = fragmentHomeGameBinding3.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(null);
        }
        getGameAdapter().setOnItemClickListener((OnItemClickListener) null);
        getGameUserAdapter().setOnItemClickListener((OnItemClickListener) null);
        FragmentHomeGameBinding fragmentHomeGameBinding4 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding4 != null && (recyclerView = fragmentHomeGameBinding4.recyclerView) != null) {
            recyclerView.setAdapter((RecyclerView.Adapter) null);
        }
        getViewModel().getHomeUserBaseData().destroy();
        super.onDestroyView();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
        setStatusBar();
    }

    public void onPause() {
        BannerViewPager bannerViewPager;
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding != null && (bannerViewPager = fragmentHomeGameBinding.bannerBroadcast) != null) {
            bannerViewPager.e0();
        }
    }

    public void onResume() {
        TextView textView;
        Long l;
        ImageView imageView;
        BannerViewPager bannerViewPager;
        Group group;
        int i;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        boolean booleanValue = ((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "SHOW_lUDO_UNO", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
        FragmentHomeGameHeadBinding fragmentHomeGameHeadBinding = this.headBinding;
        int i2 = 8;
        if (fragmentHomeGameHeadBinding != null && (group = fragmentHomeGameHeadBinding.group) != null) {
            if (booleanValue) {
                i = 0;
            } else {
                i = 8;
            }
            group.setVisibility(i);
        }
        FragmentHomeGameBinding fragmentHomeGameBinding = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding != null && (bannerViewPager = fragmentHomeGameBinding.bannerBroadcast) != null) {
            bannerViewPager.d0();
        }
        String str = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "game_activity_url", "", (String) null, 4, (Object) null);
        FragmentHomeGameBinding fragmentHomeGameBinding2 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding2 != null && (imageView = fragmentHomeGameBinding2.chest) != null) {
            if (!TextUtils.isEmpty(str)) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
        }
        FragmentHomeGameBinding fragmentHomeGameBinding3 = (FragmentHomeGameBinding) getBinding();
        if (fragmentHomeGameBinding3 != null && (textView = fragmentHomeGameBinding3.diamondText) != null) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                l = Long.valueOf(MathKt.roundToLong(user.getDiamondNum()));
            } else {
                l = null;
            }
            textView.setText(String.valueOf(l));
        }
        setStatusBar();
    }
}
