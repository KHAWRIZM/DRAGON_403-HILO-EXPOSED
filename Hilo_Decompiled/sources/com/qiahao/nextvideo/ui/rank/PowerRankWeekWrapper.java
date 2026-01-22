package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.GroupPowerWeekBean;
import com.qiahao.nextvideo.data.model.PowerTop3Bean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.LayoutPowerRankWeekBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.power.PowerDetailViewController;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u00104\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00105\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\"\u001a\u0004\b6\u0010$\"\u0004\b7\u0010\u0013R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\"\u001a\u0004\b9\u0010$\"\u0004\b:\u0010\u0013¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/PowerRankWeekWrapper;", "Landroid/widget/FrameLayout;", "Lvc/g;", "Lvc/e;", "Landroid/content/Context;", "context", "", "mPowerType", "Lcom/qiahao/nextvideo/ui/rank/PowerRankViewController;", "viewController", "<init>", "(Landroid/content/Context;ILcom/qiahao/nextvideo/ui/rank/PowerRankViewController;)V", "", "initRecyclerView", "()V", "initDataFromCache", "refreshDate", "type", "getTop3PowerWeek", "(I)V", "", "Lcom/qiahao/nextvideo/data/model/PowerTop3Bean;", "it", "showTop3User", "(Ljava/util/List;)V", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "I", "getMPowerType", "()I", "Lcom/qiahao/nextvideo/ui/rank/PowerRankViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/rank/PowerRankViewController;", "Lcom/qiahao/nextvideo/databinding/LayoutPowerRankWeekBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/LayoutPowerRankWeekBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/LayoutPowerRankWeekBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/LayoutPowerRankWeekBinding;)V", "Lcom/qiahao/nextvideo/ui/rank/PowerRankAdapter;", "mPowerRankAdapter$delegate", "Lkotlin/Lazy;", "getMPowerRankAdapter", "()Lcom/qiahao/nextvideo/ui/rank/PowerRankAdapter;", "mPowerRankAdapter", "mPageIndex", "getMPageIndex", "setMPageIndex", "mPageSum", "getMPageSum", "setMPageSum", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPowerRankWeekWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PowerRankWeekWrapper.kt\ncom/qiahao/nextvideo/ui/rank/PowerRankWeekWrapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,459:1\n1#2:460\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerRankWeekWrapper extends FrameLayout implements vc.g, vc.e {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int LAST_WEEK = 2;

    @NotNull
    private static final String TAG = "PowerRankWeekWrapper";
    public static final int THIS_WEEK = 1;

    @NotNull
    private LayoutPowerRankWeekBinding mDataBinding;
    private int mPageIndex;
    private int mPageSum;

    /* renamed from: mPowerRankAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPowerRankAdapter;
    private final int mPowerType;

    @NotNull
    private final PowerRankViewController viewController;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/PowerRankWeekWrapper$Companion;", "", "<init>", "()V", "TAG", "", "THIS_WEEK", "", "LAST_WEEK", "init", "Lcom/qiahao/nextvideo/ui/rank/PowerRankWeekWrapper;", "type", "viewController", "Lcom/qiahao/nextvideo/ui/rank/PowerRankViewController;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PowerRankWeekWrapper init(int type, @NotNull PowerRankViewController viewController) {
            Intrinsics.checkNotNullParameter(viewController, "viewController");
            Log.d(PowerRankWeekWrapper.TAG, "init: ");
            return new PowerRankWeekWrapper(viewController.getRequireContext(), type, viewController);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PowerRankWeekWrapper(@NotNull Context context, int i, @NotNull PowerRankViewController powerRankViewController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(powerRankViewController, "viewController");
        this.mPowerType = i;
        this.viewController = powerRankViewController;
        this.mPowerRankAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.rank.t0
            public final Object invoke() {
                PowerRankAdapter mPowerRankAdapter_delegate$lambda$0;
                mPowerRankAdapter_delegate$lambda$0 = PowerRankWeekWrapper.mPowerRankAdapter_delegate$lambda$0();
                return mPowerRankAdapter_delegate$lambda$0;
            }
        });
        this.mPageIndex = 1;
        this.mPageSum = 10;
        this.mDataBinding = (LayoutPowerRankWeekBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.layout_power_rank_week, this, true);
        initRecyclerView();
    }

    private final void getTop3PowerWeek(int type) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getTop3PowerWeek(type), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.x0
            public final Object invoke(Object obj) {
                Unit top3PowerWeek$lambda$11;
                top3PowerWeek$lambda$11 = PowerRankWeekWrapper.getTop3PowerWeek$lambda$11(PowerRankWeekWrapper.this, (ApiResponse) obj);
                return top3PowerWeek$lambda$11;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.y0
            public final Object invoke(Object obj) {
                Unit top3PowerWeek$lambda$12;
                top3PowerWeek$lambda$12 = PowerRankWeekWrapper.getTop3PowerWeek$lambda$12((Throwable) obj);
                return top3PowerWeek$lambda$12;
            }
        }, (Function0) null, false, 12, (Object) null), this.viewController.getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop3PowerWeek$lambda$11(PowerRankWeekWrapper powerRankWeekWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<PowerTop3Bean> list = (List) apiResponse.getData();
        if (list != null) {
            powerRankWeekWrapper.showTop3User(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop3PowerWeek$lambda$12(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void initDataFromCache() {
        List<GroupPowerWeekBean> powerFromWeekRankCache = MMKVToLocalCache.INSTANCE.getPowerFromWeekRankCache(this.mPowerType);
        if (powerFromWeekRankCache != null && !powerFromWeekRankCache.isEmpty()) {
            getMPowerRankAdapter().setList(powerFromWeekRankCache);
        }
    }

    private final void initRecyclerView() {
        this.mDataBinding.smartRefreshLayout.setOnRefreshListener(this);
        this.mDataBinding.smartRefreshLayout.setOnLoadMoreListener(this);
        this.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        SmartRefreshLayout smartRefreshLayout = this.mDataBinding.smartRefreshLayout;
        FootLoading footLoading = new FootLoading(this.viewController.getRequireContext());
        footLoading.setBackground(footLoading.getContext().getDrawable(2131101214));
        smartRefreshLayout.setRefreshFooter(footLoading);
        RecyclerView recyclerView = this.mDataBinding.recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMPowerRankAdapter());
        getMPowerRankAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.rank.u0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PowerRankWeekWrapper.initRecyclerView$lambda$3(PowerRankWeekWrapper.this, baseQuickAdapter, view, i);
            }
        });
        initDataFromCache();
        refreshDate();
        getTop3PowerWeek(this.mPowerType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$3(PowerRankWeekWrapper powerRankWeekWrapper, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GroupPowerWeekBean");
        ViewController.present$default(powerRankWeekWrapper.viewController, new PowerDetailViewController(((GroupPowerWeekBean) item).getGroupPowerId(), false, 2, null), true, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerRankAdapter mPowerRankAdapter_delegate$lambda$0() {
        return new PowerRankAdapter(R.layout.item_power_rank);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$8(PowerRankWeekWrapper powerRankWeekWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            powerRankWeekWrapper.mDataBinding.smartRefreshLayout.finishLoadMore();
            powerRankWeekWrapper.mPageIndex++;
            if (!list.isEmpty()) {
                powerRankWeekWrapper.getMPowerRankAdapter().addData(list);
            }
            if (list.size() < powerRankWeekWrapper.mPageSum) {
                powerRankWeekWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
            } else {
                powerRankWeekWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(true);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$9(PowerRankWeekWrapper powerRankWeekWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        powerRankWeekWrapper.mDataBinding.smartRefreshLayout.finishLoadMore();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, powerRankWeekWrapper.getContext(), ResourcesKtxKt.getStringById(powerRankWeekWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void refreshDate() {
        this.mPageIndex = 1;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupPowerRankWeek(this.mPowerType, this.mPageIndex, this.mPageSum), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.v0
            public final Object invoke(Object obj) {
                Unit refreshDate$lambda$5;
                refreshDate$lambda$5 = PowerRankWeekWrapper.refreshDate$lambda$5(PowerRankWeekWrapper.this, (ApiResponse) obj);
                return refreshDate$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.w0
            public final Object invoke(Object obj) {
                Unit refreshDate$lambda$6;
                refreshDate$lambda$6 = PowerRankWeekWrapper.refreshDate$lambda$6(PowerRankWeekWrapper.this, (Throwable) obj);
                return refreshDate$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), this.viewController.getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$5(PowerRankWeekWrapper powerRankWeekWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<GroupPowerWeekBean> list = (List) apiResponse.getData();
        if (list != null) {
            powerRankWeekWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
            powerRankWeekWrapper.mPageIndex++;
            if (!list.isEmpty()) {
                powerRankWeekWrapper.mDataBinding.emptyTipTextView.setVisibility(8);
                powerRankWeekWrapper.getMPowerRankAdapter().setList(list);
                MMKVToLocalCache.INSTANCE.savePowerFromTypeWeekRankCache(list, powerRankWeekWrapper.mPowerType);
            } else if (powerRankWeekWrapper.getMPowerRankAdapter().getData().isEmpty()) {
                powerRankWeekWrapper.mDataBinding.emptyTipTextView.setVisibility(0);
            }
            if (list.size() < powerRankWeekWrapper.mPageSum) {
                powerRankWeekWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
            } else {
                powerRankWeekWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(true);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDate$lambda$6(PowerRankWeekWrapper powerRankWeekWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        powerRankWeekWrapper.mDataBinding.smartRefreshLayout.finishRefresh();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, powerRankWeekWrapper.getContext(), ResourcesKtxKt.getStringById(powerRankWeekWrapper, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        if (powerRankWeekWrapper.getMPowerRankAdapter().getData().isEmpty()) {
            powerRankWeekWrapper.mDataBinding.emptyTipTextView.setVisibility(0);
        }
        powerRankWeekWrapper.mDataBinding.smartRefreshLayout.setEnableLoadMore(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x06c5, code lost:
    
        if (r1.isRankStealth() == true) goto L١٥١;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showTop3User(List<PowerTop3Bean> it) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        Integer num;
        int i5;
        Integer level;
        Integer level2;
        int i6;
        int i7;
        int i8;
        boolean z2;
        Integer num2;
        int i9;
        Integer level3;
        Integer level4;
        int i10;
        int i11;
        int i12;
        boolean z3;
        Integer num3;
        int i13;
        Integer level5;
        Integer level6;
        if (!it.isEmpty()) {
            final PowerTop3Bean powerTop3Bean = it.get(0);
            this.mDataBinding.llDiamond1.setVisibility(0);
            this.mDataBinding.top1Diamond.setText("***");
            this.mDataBinding.top1Id.setText(getContext().getString(2131953102, String.valueOf(powerTop3Bean.getUser().getCode())));
            Boolean isPrettyCode = powerTop3Bean.getUser().isPrettyCode();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(isPrettyCode, bool)) {
                ShineTextView shineTextView = this.mDataBinding.top1Id;
                Intrinsics.checkNotNullExpressionValue(shineTextView, "top1Id");
                Resources resources = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                Dimens dimens = Dimens.INSTANCE;
                ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources, 2131232463, dimens.dpToPx(4)));
                this.mDataBinding.top1Id.setCompoundDrawablePadding(dimens.dpToPx(4));
            } else {
                ShineTextView shineTextView2 = this.mDataBinding.top1Id;
                Intrinsics.checkNotNullExpressionValue(shineTextView2, "top1Id");
                ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
            }
            this.mDataBinding.top1Name.setText(powerTop3Bean.getUser().getName());
            ImageView imageView = this.mDataBinding.iconVip1;
            if (Intrinsics.areEqual(powerTop3Bean.getUser().isVip(), bool)) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
            NobleInfo noble = powerTop3Bean.getUser().getNoble();
            if (noble != null && (level6 = noble.getLevel()) != null) {
                i11 = level6.intValue();
            } else {
                i11 = 0;
            }
            if (i11 > 0) {
                this.mDataBinding.iconVip1.setVisibility(8);
                this.mDataBinding.iconNoble1.setVisibility(0);
                ImageView imageView2 = this.mDataBinding.iconNoble1;
                Context context = getContext();
                UserService.Companion companion = UserService.INSTANCE;
                NobleInfo noble2 = powerTop3Bean.getUser().getNoble();
                if (noble2 != null && (level5 = noble2.getLevel()) != null) {
                    i13 = level5.intValue();
                } else {
                    i13 = 0;
                }
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i13)));
            } else {
                this.mDataBinding.iconNoble1.setVisibility(8);
            }
            SvipData svip = powerTop3Bean.getUser().getSvip();
            if (svip != null) {
                i12 = svip.getSvipLevel();
            } else {
                i12 = 0;
            }
            if (i12 > 0) {
                this.mDataBinding.iconVip1.setVisibility(8);
                this.mDataBinding.iconNoble1.setVisibility(8);
                this.mDataBinding.svip1.setVisibility(0);
                SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                SvipData svip2 = powerTop3Bean.getUser().getSvip();
                if (svip2 != null) {
                    num3 = Integer.valueOf(svip2.getSvipLevel());
                } else {
                    num3 = null;
                }
                Integer svipMedal = svipTypeUtils.getSvipMedal(num3);
                if (svipMedal != null) {
                    this.mDataBinding.svip1.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal.intValue()));
                }
            } else {
                this.mDataBinding.svip1.setVisibility(8);
            }
            CircleImageView circleImageView = this.mDataBinding.top1Avatar;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "top1Avatar");
            ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
            String avatar = powerTop3Bean.getUser().getAvatar();
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens2 = Dimens.INSTANCE;
            lfit.setWidth(dimens2.dpToPx(53));
            lfit.setHeight(dimens2.dpToPx(53));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView, companion2.displayUserAvatarImage(avatar, lfit), null, 2, null);
            this.mDataBinding.top1Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PowerRankWeekWrapper.showTop3User$lambda$15(PowerTop3Bean.this, this, view);
                }
            });
            if (powerTop3Bean.getUser().getMedalInfo() != null) {
                this.mDataBinding.top1Medal.setVisibility(0);
                MedalGridLayout medalGridLayout = this.mDataBinding.top1Medal;
                List<MedalInfo> medalInfo = powerTop3Bean.getUser().getMedalInfo();
                Intrinsics.checkNotNull(medalInfo);
                List mutableList = CollectionsKt.toMutableList(medalInfo);
                Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
                MedalGridLayout.setDataAndLayoutView$default(medalGridLayout, (ArrayList) mutableList, 0, 2, null);
            } else {
                this.mDataBinding.top1Medal.setVisibility(8);
            }
            SvipData svip3 = powerTop3Bean.getUser().getSvip();
            if (svip3 != null && svip3.isRankStealth()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                AppCompatImageView appCompatImageView = this.mDataBinding.top1Avatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "top1Avatar");
                ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.svip_hide_heard), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                this.mDataBinding.top1Id.setVisibility(8);
                this.mDataBinding.top1Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
                this.mDataBinding.iconVip1.setVisibility(8);
                this.mDataBinding.iconNoble1.setVisibility(8);
                this.mDataBinding.svip1.setVisibility(8);
                this.mDataBinding.top1Medal.setVisibility(8);
            } else {
                this.mDataBinding.top1Id.setVisibility(0);
            }
        }
        if (it.size() > 1) {
            final PowerTop3Bean powerTop3Bean2 = it.get(1);
            this.mDataBinding.llDiamond2.setVisibility(0);
            this.mDataBinding.top2Diamond.setText("***");
            this.mDataBinding.top2Id.setText(getContext().getString(2131953102, powerTop3Bean2.getUser().getCode()));
            Boolean isPrettyCode2 = powerTop3Bean2.getUser().isPrettyCode();
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual(isPrettyCode2, bool2)) {
                ShineTextView shineTextView3 = this.mDataBinding.top2Id;
                Intrinsics.checkNotNullExpressionValue(shineTextView3, "top2Id");
                Resources resources2 = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                Dimens dimens3 = Dimens.INSTANCE;
                ViewUtilitiesKt.setDrawableLeft(shineTextView3, ResourceUtilsKt.getDrawable(resources2, 2131232463, dimens3.dpToPx(4)));
                this.mDataBinding.top2Id.setCompoundDrawablePadding(dimens3.dpToPx(4));
            } else {
                ShineTextView shineTextView4 = this.mDataBinding.top2Id;
                Intrinsics.checkNotNullExpressionValue(shineTextView4, "top2Id");
                ViewUtilitiesKt.setDrawableLeft(shineTextView4, null);
            }
            this.mDataBinding.top2Name.setText(powerTop3Bean2.getUser().getName());
            ImageView imageView3 = this.mDataBinding.iconVip2;
            if (Intrinsics.areEqual(powerTop3Bean2.getUser().isVip(), bool2)) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            imageView3.setVisibility(i6);
            NobleInfo noble3 = powerTop3Bean2.getUser().getNoble();
            if (noble3 != null && (level4 = noble3.getLevel()) != null) {
                i7 = level4.intValue();
            } else {
                i7 = 0;
            }
            if (i7 > 0) {
                this.mDataBinding.iconVip2.setVisibility(8);
                this.mDataBinding.iconNoble2.setVisibility(0);
                ImageView imageView4 = this.mDataBinding.iconNoble2;
                Context context2 = getContext();
                UserService.Companion companion3 = UserService.INSTANCE;
                NobleInfo noble4 = powerTop3Bean2.getUser().getNoble();
                if (noble4 != null && (level3 = noble4.getLevel()) != null) {
                    i9 = level3.intValue();
                } else {
                    i9 = 0;
                }
                imageView4.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion3.getNobleDrawableRes(i9)));
                this.mDataBinding.iconNoble2.setVisibility(8);
            }
            SvipData svip4 = powerTop3Bean2.getUser().getSvip();
            if (svip4 != null) {
                i8 = svip4.getSvipLevel();
            } else {
                i8 = 0;
            }
            if (i8 > 0) {
                this.mDataBinding.iconVip2.setVisibility(8);
                this.mDataBinding.iconNoble2.setVisibility(8);
                this.mDataBinding.svip2.setVisibility(0);
                SvipTypeUtils svipTypeUtils2 = SvipTypeUtils.INSTANCE;
                SvipData svip5 = powerTop3Bean2.getUser().getSvip();
                if (svip5 != null) {
                    num2 = Integer.valueOf(svip5.getSvipLevel());
                } else {
                    num2 = null;
                }
                Integer svipMedal2 = svipTypeUtils2.getSvipMedal(num2);
                if (svipMedal2 != null) {
                    this.mDataBinding.svip2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal2.intValue()));
                }
            } else {
                this.mDataBinding.svip2.setVisibility(8);
            }
            CircleImageView circleImageView2 = this.mDataBinding.top2Avatar;
            Intrinsics.checkNotNullExpressionValue(circleImageView2, "top2Avatar");
            ImageUIModel.Companion companion4 = ImageUIModel.INSTANCE;
            String avatar2 = powerTop3Bean2.getUser().getAvatar();
            ResizeMode.LFIT lfit2 = ResizeMode.LFIT.INSTANCE;
            Dimens dimens4 = Dimens.INSTANCE;
            lfit2.setWidth(dimens4.dpToPx(53));
            lfit2.setHeight(dimens4.dpToPx(53));
            Unit unit2 = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView2, companion4.displayUserAvatarImage(avatar2, lfit2), null, 2, null);
            this.mDataBinding.top2Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PowerRankWeekWrapper.showTop3User$lambda$18(PowerTop3Bean.this, this, view);
                }
            });
            if (powerTop3Bean2.getUser().getMedalInfo() != null) {
                this.mDataBinding.top2Medal.setVisibility(0);
                MedalGridLayout medalGridLayout2 = this.mDataBinding.top2Medal;
                List<MedalInfo> medalInfo2 = powerTop3Bean2.getUser().getMedalInfo();
                Intrinsics.checkNotNull(medalInfo2);
                List mutableList2 = CollectionsKt.toMutableList(medalInfo2);
                Intrinsics.checkNotNull(mutableList2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
                MedalGridLayout.setDataAndLayoutView$default(medalGridLayout2, (ArrayList) mutableList2, 0, 2, null);
            } else {
                this.mDataBinding.top2Medal.setVisibility(8);
            }
            SvipData svip6 = powerTop3Bean2.getUser().getSvip();
            if (svip6 != null && svip6.isRankStealth()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                AppCompatImageView appCompatImageView2 = this.mDataBinding.top2Avatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "top2Avatar");
                ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.svip_hide_heard), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                this.mDataBinding.top2Id.setVisibility(8);
                this.mDataBinding.top2Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
                this.mDataBinding.iconVip2.setVisibility(8);
                this.mDataBinding.iconNoble2.setVisibility(8);
                this.mDataBinding.svip2.setVisibility(8);
                this.mDataBinding.top2Medal.setVisibility(8);
            } else {
                this.mDataBinding.top2Id.setVisibility(0);
            }
        }
        if (it.size() > 2) {
            final PowerTop3Bean powerTop3Bean3 = it.get(2);
            this.mDataBinding.llDiamond3.setVisibility(0);
            this.mDataBinding.top3Diamond.setText("***");
            this.mDataBinding.top3Id.setText(getContext().getString(2131953102, powerTop3Bean3.getUser().getCode()));
            Boolean isPrettyCode3 = powerTop3Bean3.getUser().isPrettyCode();
            Boolean bool3 = Boolean.TRUE;
            if (Intrinsics.areEqual(isPrettyCode3, bool3)) {
                ShineTextView shineTextView5 = this.mDataBinding.top3Id;
                Intrinsics.checkNotNullExpressionValue(shineTextView5, "top3Id");
                Resources resources3 = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources3, "getResources(...)");
                Dimens dimens5 = Dimens.INSTANCE;
                ViewUtilitiesKt.setDrawableLeft(shineTextView5, ResourceUtilsKt.getDrawable(resources3, 2131232463, dimens5.dpToPx(4)));
                this.mDataBinding.top3Id.setCompoundDrawablePadding(dimens5.dpToPx(4));
            } else {
                ShineTextView shineTextView6 = this.mDataBinding.top3Id;
                Intrinsics.checkNotNullExpressionValue(shineTextView6, "top3Id");
                ViewUtilitiesKt.setDrawableLeft(shineTextView6, null);
            }
            this.mDataBinding.top3Name.setText(powerTop3Bean3.getUser().getName());
            ImageView imageView5 = this.mDataBinding.iconVip3;
            if (Intrinsics.areEqual(powerTop3Bean3.getUser().isVip(), bool3)) {
                i = 0;
            } else {
                i = 8;
            }
            imageView5.setVisibility(i);
            NobleInfo noble5 = powerTop3Bean3.getUser().getNoble();
            if (noble5 != null && (level2 = noble5.getLevel()) != null) {
                i2 = level2.intValue();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                this.mDataBinding.iconVip3.setVisibility(8);
                this.mDataBinding.iconNoble3.setVisibility(0);
                ImageView imageView6 = this.mDataBinding.iconNoble3;
                Context context3 = getContext();
                UserService.Companion companion5 = UserService.INSTANCE;
                NobleInfo noble6 = powerTop3Bean3.getUser().getNoble();
                if (noble6 != null && (level = noble6.getLevel()) != null) {
                    i5 = level.intValue();
                } else {
                    i5 = 0;
                }
                imageView6.setImageDrawable(androidx.core.content.a.getDrawable(context3, companion5.getNobleDrawableRes(i5)));
                i3 = 8;
            } else {
                i3 = 8;
                this.mDataBinding.iconNoble3.setVisibility(8);
            }
            SvipData svip7 = powerTop3Bean3.getUser().getSvip();
            if (svip7 != null) {
                i4 = svip7.getSvipLevel();
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                this.mDataBinding.iconVip3.setVisibility(i3);
                this.mDataBinding.iconNoble3.setVisibility(i3);
                this.mDataBinding.svip3.setVisibility(0);
                SvipTypeUtils svipTypeUtils3 = SvipTypeUtils.INSTANCE;
                SvipData svip8 = powerTop3Bean3.getUser().getSvip();
                if (svip8 != null) {
                    num = Integer.valueOf(svip8.getSvipLevel());
                } else {
                    num = null;
                }
                Integer svipMedal3 = svipTypeUtils3.getSvipMedal(num);
                if (svipMedal3 != null) {
                    this.mDataBinding.svip3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal3.intValue()));
                }
            } else {
                this.mDataBinding.svip3.setVisibility(8);
            }
            CircleImageView circleImageView3 = this.mDataBinding.top3Avatar;
            Intrinsics.checkNotNullExpressionValue(circleImageView3, "top3Avatar");
            ImageUIModel.Companion companion6 = ImageUIModel.INSTANCE;
            String avatar3 = powerTop3Bean3.getUser().getAvatar();
            ResizeMode.LFIT lfit3 = ResizeMode.LFIT.INSTANCE;
            Dimens dimens6 = Dimens.INSTANCE;
            lfit3.setWidth(dimens6.dpToPx(53));
            lfit3.setHeight(dimens6.dpToPx(53));
            Unit unit3 = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView3, companion6.displayUserAvatarImage(avatar3, lfit3), null, 2, null);
            this.mDataBinding.top3Avatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PowerRankWeekWrapper.showTop3User$lambda$21(PowerTop3Bean.this, this, view);
                }
            });
            if (powerTop3Bean3.getUser().getMedalInfo() != null) {
                this.mDataBinding.top3Medal.setVisibility(0);
                MedalGridLayout medalGridLayout3 = this.mDataBinding.top3Medal;
                List<MedalInfo> medalInfo3 = powerTop3Bean3.getUser().getMedalInfo();
                Intrinsics.checkNotNull(medalInfo3);
                List mutableList3 = CollectionsKt.toMutableList(medalInfo3);
                Intrinsics.checkNotNull(mutableList3, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
                MedalGridLayout.setDataAndLayoutView$default(medalGridLayout3, (ArrayList) mutableList3, 0, 2, null);
            } else {
                this.mDataBinding.top3Medal.setVisibility(8);
            }
            SvipData svip9 = powerTop3Bean3.getUser().getSvip();
            if (svip9 != null) {
                z = true;
            }
            z = false;
            if (z) {
                AppCompatImageView appCompatImageView3 = this.mDataBinding.top3Avatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "top3Avatar");
                ImageKtxKt.loadImage$default(appCompatImageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.svip_hide_heard), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                this.mDataBinding.top3Id.setVisibility(8);
                this.mDataBinding.top3Name.setText(ResourcesKtxKt.getStringById(this, 2131954197));
                this.mDataBinding.iconVip3.setVisibility(8);
                this.mDataBinding.iconNoble3.setVisibility(8);
                this.mDataBinding.svip3.setVisibility(8);
                this.mDataBinding.top3Medal.setVisibility(8);
                return;
            }
            this.mDataBinding.top3Id.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTop3User$lambda$15(PowerTop3Bean powerTop3Bean, PowerRankWeekWrapper powerRankWeekWrapper, View view) {
        SvipData svip = powerTop3Bean.getUser().getSvip();
        if (svip != null && svip.isRankStealth() && powerTop3Bean.getUser().checkNotOfficialStaff()) {
            Context context = powerRankWeekWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(powerRankWeekWrapper, 2131954198)).show();
        } else {
            String externalId = powerTop3Bean.getUser().getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            powerRankWeekWrapper.onOpenUserProfile(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTop3User$lambda$18(PowerTop3Bean powerTop3Bean, PowerRankWeekWrapper powerRankWeekWrapper, View view) {
        SvipData svip = powerTop3Bean.getUser().getSvip();
        if (svip != null && svip.isRankStealth() && powerTop3Bean.getUser().checkNotOfficialStaff()) {
            Context context = powerRankWeekWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(powerRankWeekWrapper, 2131954198)).show();
        } else {
            String externalId = powerTop3Bean.getUser().getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            powerRankWeekWrapper.onOpenUserProfile(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTop3User$lambda$21(PowerTop3Bean powerTop3Bean, PowerRankWeekWrapper powerRankWeekWrapper, View view) {
        SvipData svip = powerTop3Bean.getUser().getSvip();
        if (svip != null && svip.isRankStealth() && powerTop3Bean.getUser().checkNotOfficialStaff()) {
            Context context = powerRankWeekWrapper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(powerRankWeekWrapper, 2131954198)).show();
        } else {
            String externalId = powerTop3Bean.getUser().getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            powerRankWeekWrapper.onOpenUserProfile(externalId);
        }
    }

    @NotNull
    public final LayoutPowerRankWeekBinding getMDataBinding() {
        return this.mDataBinding;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSum() {
        return this.mPageSum;
    }

    @NotNull
    public final PowerRankAdapter getMPowerRankAdapter() {
        return (PowerRankAdapter) this.mPowerRankAdapter.getValue();
    }

    public final int getMPowerType() {
        return this.mPowerType;
    }

    @NotNull
    public final PowerRankViewController getViewController() {
        return this.viewController;
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupPowerRankWeek(this.mPowerType, this.mPageIndex, this.mPageSum), new Function1() { // from class: com.qiahao.nextvideo.ui.rank.z0
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$8;
                onLoadMore$lambda$8 = PowerRankWeekWrapper.onLoadMore$lambda$8(PowerRankWeekWrapper.this, (ApiResponse) obj);
                return onLoadMore$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.rank.q0
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$9;
                onLoadMore$lambda$9 = PowerRankWeekWrapper.onLoadMore$lambda$9(PowerRankWeekWrapper.this, (Throwable) obj);
                return onLoadMore$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), this.viewController.getCompositeDisposable());
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(externalId);
        }
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        refreshDate();
        getTop3PowerWeek(this.mPowerType);
    }

    public final void setMDataBinding(@NotNull LayoutPowerRankWeekBinding layoutPowerRankWeekBinding) {
        Intrinsics.checkNotNullParameter(layoutPowerRankWeekBinding, "<set-?>");
        this.mDataBinding = layoutPowerRankWeekBinding;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSum(int i) {
        this.mPageSum = i;
    }
}
