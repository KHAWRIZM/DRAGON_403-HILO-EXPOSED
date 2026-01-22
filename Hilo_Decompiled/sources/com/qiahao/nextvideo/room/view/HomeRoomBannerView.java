package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.mainActivity.HomeRoomBannerData;
import com.qiahao.nextvideo.data.mainActivity.MainActivityData;
import com.qiahao.nextvideo.databinding.ViewHomeRoomBannerBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.ui.mainActivity.MainActivityDialog;
import com.qiahao.nextvideo.ui.mainActivity.MainBannerPagerAdapter;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.IndicatorView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J\r\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/room/view/HomeRoomBannerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "initView", "requestMainActivityData", "()V", "refreshData", "", "isStart", "startOrStopAnimation", "(Z)V", "onDetachedFromWindow", "Lcom/qiahao/nextvideo/databinding/ViewHomeRoomBannerBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewHomeRoomBannerBinding;", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/data/mainActivity/HomeRoomBannerData;", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;", "mMainData", "Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/mainActivity/MainBannerPagerAdapter;", "groupBannerPagerAdapter$delegate", "Lkotlin/Lazy;", "getGroupBannerPagerAdapter", "()Lcom/qiahao/nextvideo/ui/mainActivity/MainBannerPagerAdapter;", "groupBannerPagerAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeRoomBannerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeRoomBannerView.kt\ncom/qiahao/nextvideo/room/view/HomeRoomBannerView\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,126:1\n439#2:127\n*S KotlinDebug\n*F\n+ 1 HomeRoomBannerView.kt\ncom/qiahao/nextvideo/room/view/HomeRoomBannerView\n*L\n105#1:127\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeRoomBannerView extends FrameLayout {

    @Nullable
    private ViewHomeRoomBannerBinding binding;

    /* renamed from: groupBannerPagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupBannerPagerAdapter;

    @NotNull
    private nd.a mCompositeDisposable;

    @Nullable
    private MainActivityData mMainData;

    @Nullable
    private BannerViewPager<HomeRoomBannerData> mViewPager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRoomBannerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCompositeDisposable = new nd.a();
        this.groupBannerPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.view.o
            public final Object invoke() {
                MainBannerPagerAdapter groupBannerPagerAdapter_delegate$lambda$2;
                groupBannerPagerAdapter_delegate$lambda$2 = HomeRoomBannerView.groupBannerPagerAdapter_delegate$lambda$2(HomeRoomBannerView.this);
                return groupBannerPagerAdapter_delegate$lambda$2;
            }
        });
        initView(context);
    }

    private final MainBannerPagerAdapter getGroupBannerPagerAdapter() {
        return (MainBannerPagerAdapter) this.groupBannerPagerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MainBannerPagerAdapter groupBannerPagerAdapter_delegate$lambda$2(final HomeRoomBannerView homeRoomBannerView) {
        MainBannerPagerAdapter mainBannerPagerAdapter = new MainBannerPagerAdapter();
        mainBannerPagerAdapter.setMListener(new Function0() { // from class: com.qiahao.nextvideo.room.view.r
            public final Object invoke() {
                Unit groupBannerPagerAdapter_delegate$lambda$2$lambda$1$lambda$0;
                groupBannerPagerAdapter_delegate$lambda$2$lambda$1$lambda$0 = HomeRoomBannerView.groupBannerPagerAdapter_delegate$lambda$2$lambda$1$lambda$0(HomeRoomBannerView.this);
                return groupBannerPagerAdapter_delegate$lambda$2$lambda$1$lambda$0;
            }
        });
        return mainBannerPagerAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit groupBannerPagerAdapter_delegate$lambda$2$lambda$1$lambda$0(HomeRoomBannerView homeRoomBannerView) {
        homeRoomBannerView.requestMainActivityData();
        return Unit.INSTANCE;
    }

    private final void initView(Context context) {
        BannerViewPager<HomeRoomBannerData> bannerViewPager;
        ViewHomeRoomBannerBinding viewHomeRoomBannerBinding = (ViewHomeRoomBannerBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_home_room_banner, this, true);
        this.binding = viewHomeRoomBannerBinding;
        if (viewHomeRoomBannerBinding != null) {
            bannerViewPager = viewHomeRoomBannerBinding.bannerView;
        } else {
            bannerViewPager = null;
        }
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.mainActivity.HomeRoomBannerData>");
        this.mViewPager = bannerViewPager;
        if (bannerViewPager != null) {
            bannerViewPager.G(getGroupBannerPagerAdapter());
        }
        BannerViewPager<HomeRoomBannerData> bannerViewPager2 = this.mViewPager;
        if (bannerViewPager2 != null) {
            bannerViewPager2.g();
        }
        refreshData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestMainActivityData$lambda$4(HomeRoomBannerView homeRoomBannerView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MainActivityData mainActivityData = (MainActivityData) apiResponse.getData();
        if (mainActivityData != null) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "main_activity_data", BaseApplication.Companion.getGSON().s(mainActivityData), (String) null, 4, (Object) null);
            homeRoomBannerView.refreshData();
            Context context = homeRoomBannerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new MainActivityDialog(context, mainActivityData).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestMainActivityData$lambda$5(HomeRoomBannerView homeRoomBannerView, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = homeRoomBannerView.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(homeRoomBannerView, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCompositeDisposable.d();
        getGroupBannerPagerAdapter().setMListener(null);
        getGroupBannerPagerAdapter().setStart(false);
        getGroupBannerPagerAdapter().release();
    }

    public final void refreshData() {
        BannerViewPager L;
        BannerViewPager P;
        BannerViewPager N;
        BannerViewPager K;
        BannerViewPager M;
        long j;
        long j2;
        long j3;
        Long activityPopupId;
        Long deadlineTimestamp;
        ArrayList arrayList = new ArrayList();
        IndicatorView indicatorView = null;
        arrayList.add(new HomeRoomBannerData(1, null));
        MainActivityData mainActivityData = (MainActivityData) BaseApplication.Companion.getGSON().j((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "main_activity_data", "", (String) null, 4, (Object) null), MainActivityData.class);
        this.mMainData = mainActivityData;
        if (mainActivityData != null) {
            if (mainActivityData != null && (deadlineTimestamp = mainActivityData.getDeadlineTimestamp()) != null) {
                j = deadlineTimestamp.longValue();
            } else {
                j = 0;
            }
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                j2 = service.getServerTime();
            } else {
                j2 = 0;
            }
            if (j > j2 * 1000) {
                MainActivityData mainActivityData2 = this.mMainData;
                if (mainActivityData2 != null && (activityPopupId = mainActivityData2.getActivityPopupId()) != null) {
                    j3 = activityPopupId.longValue();
                } else {
                    j3 = 0;
                }
                if (j3 > 0) {
                    arrayList.add(new HomeRoomBannerData(2, this.mMainData));
                }
            }
        }
        BannerViewPager<HomeRoomBannerData> bannerViewPager = this.mViewPager;
        if (bannerViewPager != null && (L = bannerViewPager.L(4)) != null && (P = L.P(4)) != null && (N = P.N(UiKtxKt.toPX(6))) != null && (K = N.K(UiKtxKt.toPX(3))) != null && (M = K.M(Color.parseColor("#D9D9D9"), Color.parseColor("#8833FF"))) != null) {
            ViewHomeRoomBannerBinding viewHomeRoomBannerBinding = this.binding;
            if (viewHomeRoomBannerBinding != null) {
                indicatorView = viewHomeRoomBannerBinding.indicatorView;
            }
            BannerViewPager Q = M.Q(indicatorView);
            if (Q != null) {
                Q.O(UiKtxKt.toPX(6), UiKtxKt.toPX(7));
            }
        }
        BannerViewPager<HomeRoomBannerData> bannerViewPager2 = this.mViewPager;
        if (bannerViewPager2 != null) {
            bannerViewPager2.C(arrayList);
        }
    }

    public final void requestMainActivityData() {
        long j;
        Long activityPopupId;
        ServerApi apis = AppServer.INSTANCE.getApis();
        MainActivityData mainActivityData = this.mMainData;
        if (mainActivityData != null && (activityPopupId = mainActivityData.getActivityPopupId()) != null) {
            j = activityPopupId.longValue();
        } else {
            j = 0;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.mainActivityData(Long.valueOf(j)), new Function1() { // from class: com.qiahao.nextvideo.room.view.p
            public final Object invoke(Object obj) {
                Unit requestMainActivityData$lambda$4;
                requestMainActivityData$lambda$4 = HomeRoomBannerView.requestMainActivityData$lambda$4(HomeRoomBannerView.this, (ApiResponse) obj);
                return requestMainActivityData$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.view.q
            public final Object invoke(Object obj) {
                Unit requestMainActivityData$lambda$5;
                requestMainActivityData$lambda$5 = HomeRoomBannerView.requestMainActivityData$lambda$5(HomeRoomBannerView.this, (Throwable) obj);
                return requestMainActivityData$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void startOrStopAnimation(boolean isStart) {
        getGroupBannerPagerAdapter().setStart(isStart);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRoomBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCompositeDisposable = new nd.a();
        this.groupBannerPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.view.o
            public final Object invoke() {
                MainBannerPagerAdapter groupBannerPagerAdapter_delegate$lambda$2;
                groupBannerPagerAdapter_delegate$lambda$2 = HomeRoomBannerView.groupBannerPagerAdapter_delegate$lambda$2(HomeRoomBannerView.this);
                return groupBannerPagerAdapter_delegate$lambda$2;
            }
        });
        initView(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRoomBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCompositeDisposable = new nd.a();
        this.groupBannerPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.view.o
            public final Object invoke() {
                MainBannerPagerAdapter groupBannerPagerAdapter_delegate$lambda$2;
                groupBannerPagerAdapter_delegate$lambda$2 = HomeRoomBannerView.groupBannerPagerAdapter_delegate$lambda$2(HomeRoomBannerView.this);
                return groupBannerPagerAdapter_delegate$lambda$2;
            }
        });
        initView(context);
    }
}
