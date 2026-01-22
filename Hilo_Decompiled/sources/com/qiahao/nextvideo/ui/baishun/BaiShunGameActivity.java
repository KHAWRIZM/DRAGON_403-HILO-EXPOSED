package com.qiahao.nextvideo.ui.baishun;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.base_common.model.common.MyGameLevel;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.baishun.BaiShunActivityData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.ActivityBaiShunBinding;
import com.qiahao.nextvideo.databinding.BaiShunHeadBinding;
import com.qiahao.nextvideo.ui.gameLevel.GameLevelActivity;
import com.qiahao.nextvideo.ui.gem.GemStoreDialog;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/baishun/BaiShunGameActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityBaiShunBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/baishun/BaiShunViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/baishun/BaiShunViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "headBinding", "Lcom/qiahao/nextvideo/databinding/BaiShunHeadBinding;", "gameAdapter", "Lcom/qiahao/nextvideo/ui/baishun/BaiShunGameAdapter;", "getGameAdapter", "()Lcom/qiahao/nextvideo/ui/baishun/BaiShunGameAdapter;", "gameAdapter$delegate", "activityAdapter", "Lcom/qiahao/nextvideo/ui/baishun/BaiShunActivityAdapter;", "getActivityAdapter", "()Lcom/qiahao/nextvideo/ui/baishun/BaiShunActivityAdapter;", "activityAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initView", "initData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaiShunGameActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaiShunGameActivity.kt\ncom/qiahao/nextvideo/ui/baishun/BaiShunGameActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,195:1\n61#2,9:196\n61#2,9:205\n61#2,9:214\n61#2,9:223\n61#2,9:233\n1#3:232\n*S KotlinDebug\n*F\n+ 1 BaiShunGameActivity.kt\ncom/qiahao/nextvideo/ui/baishun/BaiShunGameActivity\n*L\n83#1:196,9\n93#1:205,9\n96#1:214,9\n99#1:223,9\n141#1:233,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BaiShunGameActivity extends HiloBaseBindingActivity<ActivityBaiShunBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private BaiShunHeadBinding headBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.baishun.g
        public final Object invoke() {
            BaiShunViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = BaiShunGameActivity.viewModel_delegate$lambda$0(BaiShunGameActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: gameAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.baishun.h
        public final Object invoke() {
            BaiShunGameAdapter gameAdapter_delegate$lambda$1;
            gameAdapter_delegate$lambda$1 = BaiShunGameActivity.gameAdapter_delegate$lambda$1();
            return gameAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: activityAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy activityAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.baishun.i
        public final Object invoke() {
            BaiShunActivityAdapter activityAdapter_delegate$lambda$2;
            activityAdapter_delegate$lambda$2 = BaiShunGameActivity.activityAdapter_delegate$lambda$2();
            return activityAdapter_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/baishun/BaiShunGameActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) BaiShunGameActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaiShunActivityAdapter activityAdapter_delegate$lambda$2() {
        return new BaiShunActivityAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaiShunGameAdapter gameAdapter_delegate$lambda$1() {
        return new BaiShunGameAdapter();
    }

    private final BaiShunActivityAdapter getActivityAdapter() {
        return (BaiShunActivityAdapter) this.activityAdapter.getValue();
    }

    private final BaiShunGameAdapter getGameAdapter() {
        return (BaiShunGameAdapter) this.gameAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaiShunViewModel getViewModel() {
        return (BaiShunViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity$initData$1
            public final void accept(UserObjectEvent userObjectEvent) {
                ActivityBaiShunBinding binding;
                Double pinkDiamondNum;
                if (userObjectEvent != null) {
                    BaiShunGameActivity baiShunGameActivity = BaiShunGameActivity.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        binding = baiShunGameActivity.getBinding();
                        TextView textView = binding.gemText;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        textView.setText(String.valueOf((user == null || (pinkDiamondNum = user.getPinkDiamondNum()) == null) ? null : Long.valueOf(MathKt.roundToLong(pinkDiamondNum.doubleValue()))));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getViewModel().getMCompositeDisposable());
        getViewModel().getGameList().observe(this, new BaiShunGameActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.baishun.j
            public final Object invoke(Object obj) {
                Unit initData$lambda$14;
                initData$lambda$14 = BaiShunGameActivity.initData$lambda$14(BaiShunGameActivity.this, (ArrayList) obj);
                return initData$lambda$14;
            }
        }));
        getViewModel().getBaiShunList().observe(this, new BaiShunGameActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.baishun.k
            public final Object invoke(Object obj) {
                Unit initData$lambda$15;
                initData$lambda$15 = BaiShunGameActivity.initData$lambda$15(BaiShunGameActivity.this, (List) obj);
                return initData$lambda$15;
            }
        }));
        getViewModel().getMException().observe(this, new BaiShunGameActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.baishun.b
            public final Object invoke(Object obj) {
                Unit initData$lambda$16;
                initData$lambda$16 = BaiShunGameActivity.initData$lambda$16(BaiShunGameActivity.this, (Pair) obj);
                return initData$lambda$16;
            }
        }));
        getViewModel().getGameActivity();
        getViewModel().m٦٤getGameList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$14(BaiShunGameActivity baiShunGameActivity, ArrayList arrayList) {
        baiShunGameActivity.getGameAdapter().setList(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$15(BaiShunGameActivity baiShunGameActivity, List list) {
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        BaseStatusEmptyBinding baseStatusEmptyBinding2;
        ConstraintLayout root2;
        baiShunGameActivity.getBinding().refreshLayout.finishRefresh();
        baiShunGameActivity.getBinding().refreshLayout.finishLoadMore();
        baiShunGameActivity.getBinding().statusView.showContent();
        BaiShunHeadBinding baiShunHeadBinding = baiShunGameActivity.headBinding;
        if (baiShunHeadBinding != null && (baseStatusEmptyBinding2 = baiShunHeadBinding.empty) != null && (root2 = baseStatusEmptyBinding2.getRoot()) != null) {
            root2.setVisibility(8);
        }
        if (baiShunGameActivity.getViewModel().getBaiShunBaseData().isOnePage()) {
            if (list.isEmpty()) {
                baiShunGameActivity.getActivityAdapter().setList((Collection) null);
                BaiShunHeadBinding baiShunHeadBinding2 = baiShunGameActivity.headBinding;
                if (baiShunHeadBinding2 != null && (baseStatusEmptyBinding = baiShunHeadBinding2.empty) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
                    root.setVisibility(0);
                }
            } else {
                baiShunGameActivity.getActivityAdapter().setList(list);
            }
        } else {
            BaiShunActivityAdapter activityAdapter = baiShunGameActivity.getActivityAdapter();
            Intrinsics.checkNotNull(list);
            activityAdapter.addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$16(BaiShunGameActivity baiShunGameActivity, Pair pair) {
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        ConstraintLayout root;
        if (Intrinsics.areEqual(pair.getFirst(), BaiShunViewModel.GAME_ACTIVITY)) {
            ((ActivityBaiShunBinding) baiShunGameActivity.getBinding()).refreshLayout.finishRefresh();
            ((ActivityBaiShunBinding) baiShunGameActivity.getBinding()).refreshLayout.finishLoadMore();
            ((ActivityBaiShunBinding) baiShunGameActivity.getBinding()).statusView.showContent();
            if (baiShunGameActivity.getViewModel().getBaiShunBaseData().isOnePage()) {
                baiShunGameActivity.getActivityAdapter().setList((Collection) null);
                BaiShunHeadBinding baiShunHeadBinding = baiShunGameActivity.headBinding;
                if (baiShunHeadBinding != null && (baseStatusEmptyBinding = baiShunHeadBinding.empty) != null && (root = baseStatusEmptyBinding.getRoot()) != null) {
                    root.setVisibility(0);
                }
            }
            if (pair.getSecond() instanceof HiloException) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Object second = pair.getSecond();
                Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                String errorMessage = ((HiloException) second).getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(baiShunGameActivity, 2131952667);
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, baiShunGameActivity, errorMessage, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Long l;
        BaseStatusEmptyBinding baseStatusEmptyBinding;
        final ImageView imageView;
        View root;
        RecyclerView recyclerView;
        Double pinkDiamondNum;
        String str;
        String str2;
        MyGameLevel gameLevel;
        MyGameLevel gameLevel2;
        MyGameLevel gameLevel3;
        Integer level;
        String str3 = null;
        int i = 0;
        this.headBinding = (BaiShunHeadBinding) androidx.databinding.g.h(LayoutInflater.from(this), R.layout.bai_shun_head, (ViewGroup) null, false);
        ViewGroup.LayoutParams layoutParams = ((ActivityBaiShunBinding) getBinding()).backImageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        final ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
        AppCompatImageView appCompatImageView = ((ActivityBaiShunBinding) getBinding()).backImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "backImageView");
        getStatusBarTopOrBottom(appCompatImageView, new Function2() { // from class: com.qiahao.nextvideo.ui.baishun.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$3;
                initView$lambda$3 = BaiShunGameActivity.initView$lambda$3(layoutParams2, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$3;
            }
        });
        ((ActivityBaiShunBinding) getBinding()).backImageView.setLayoutParams(layoutParams2);
        final AppCompatImageView appCompatImageView2 = ((ActivityBaiShunBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.finish();
                }
            }
        });
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null && (gameLevel3 = user.getGameLevel()) != null && (level = gameLevel3.getLevel()) != null) {
            i = level.intValue();
        }
        if (i > 0) {
            ImageView imageView2 = ((ActivityBaiShunBinding) getBinding()).gameLevelImg;
            Intrinsics.checkNotNullExpressionValue(imageView2, "gameLevelImg");
            User user2 = companion.getShared().getUser();
            if (user2 != null && (gameLevel2 = user2.getGameLevel()) != null) {
                str = gameLevel2.getMedalUrl();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(imageView2, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            TextView textView = ((ActivityBaiShunBinding) getBinding()).gameText;
            User user3 = companion.getShared().getUser();
            if (user3 != null && (gameLevel = user3.getGameLevel()) != null) {
                str2 = gameLevel.getTitle();
            } else {
                str2 = null;
            }
            textView.setText(str2);
        }
        TextView textView2 = ((ActivityBaiShunBinding) getBinding()).gemText;
        User user4 = companion.getShared().getUser();
        if (user4 != null && (pinkDiamondNum = user4.getPinkDiamondNum()) != null) {
            l = Long.valueOf(MathKt.roundToLong(pinkDiamondNum.doubleValue()));
        } else {
            l = null;
        }
        textView2.setText(String.valueOf(l));
        QMUIRadiusImageView qMUIRadiusImageView = ((ActivityBaiShunBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User user5 = companion.getShared().getUser();
        if (user5 != null) {
            str3 = user5.getAvatar();
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        ((ActivityBaiShunBinding) getBinding()).moneyLayout.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#DDDDDD", 14, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        final QMUIRadiusImageView qMUIRadiusImageView2 = ((ActivityBaiShunBinding) getBinding()).avatar;
        qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j || (qMUIRadiusImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView3 = qMUIRadiusImageView2;
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        User user6 = UserStore.INSTANCE.getShared().getUser();
                        if (user6 == null || (str4 = user6.getExternalId()) == null) {
                            str4 = "";
                        }
                        service.openPersonPage(str4);
                    }
                }
            }
        });
        final ConstraintLayout constraintLayout = ((ActivityBaiShunBinding) getBinding()).moneyLayout;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    new GemStoreDialog().show(this.getSupportFragmentManager(), "other");
                }
            }
        });
        final ConstraintLayout constraintLayout2 = ((ActivityBaiShunBinding) getBinding()).gameLayout;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                    ConstraintLayout constraintLayout3 = constraintLayout2;
                    GameLevelActivity.INSTANCE.start(this);
                }
            }
        });
        BaiShunHeadBinding baiShunHeadBinding = this.headBinding;
        if (baiShunHeadBinding != null && (recyclerView = baiShunHeadBinding.gameRecyclerView) != null) {
            recyclerView.setAdapter(getGameAdapter());
        }
        getGameAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.baishun.c
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                BaiShunGameActivity.initView$lambda$8(BaiShunGameActivity.this, baseQuickAdapter, view, i2);
            }
        });
        ((ActivityBaiShunBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        BaiShunHeadBinding baiShunHeadBinding2 = this.headBinding;
        if (baiShunHeadBinding2 != null && (root = baiShunHeadBinding2.getRoot()) != null) {
            BaseQuickAdapter.setHeaderView$default(getActivityAdapter(), root, 0, 0, 6, (Object) null);
        }
        ((ActivityBaiShunBinding) getBinding()).recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity$initView$8
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                if (parent.getChildLayoutPosition(view) == state.getItemCount() - 1) {
                    outRect.bottom = UiKtxKt.toPX(10);
                } else {
                    outRect.bottom = 0;
                }
            }
        });
        ((ActivityBaiShunBinding) getBinding()).recyclerView.setAdapter(getActivityAdapter());
        getActivityAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.baishun.d
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                BaiShunGameActivity.initView$lambda$10(BaiShunGameActivity.this, baseQuickAdapter, view, i2);
            }
        });
        ((ActivityBaiShunBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.baishun.e
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                BaiShunGameActivity.initView$lambda$11(BaiShunGameActivity.this, fVar);
            }
        });
        ((ActivityBaiShunBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.baishun.f
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                BaiShunGameActivity.initView$lambda$12(BaiShunGameActivity.this, fVar);
            }
        });
        BaiShunHeadBinding baiShunHeadBinding3 = this.headBinding;
        if (baiShunHeadBinding3 != null && (baseStatusEmptyBinding = baiShunHeadBinding3.empty) != null && (imageView = baseStatusEmptyBinding.ivIcon) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity$initView$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaiShunViewModel viewModel;
                    BaiShunViewModel viewModel2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        viewModel = this.getViewModel();
                        viewModel.getBaiShunBaseData().resetPage();
                        viewModel2 = this.getViewModel();
                        viewModel2.getGameActivity();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(BaiShunGameActivity baiShunGameActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        NavigationHelper.jump$default(NavigationHelper.INSTANCE, ((BaiShunActivityData) baiShunGameActivity.getActivityAdapter().getData().get(i)).getActionUrl(), (SuperCallBack) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(BaiShunGameActivity baiShunGameActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        baiShunGameActivity.getViewModel().getBaiShunBaseData().resetPage();
        baiShunGameActivity.getViewModel().getGameActivity();
        baiShunGameActivity.getViewModel().m٦٤getGameList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(BaiShunGameActivity baiShunGameActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        baiShunGameActivity.getViewModel().getGameActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$3(ConstraintLayout.b bVar, int i, int i2) {
        bVar.setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(BaiShunGameActivity baiShunGameActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        NavigationHelper.jump$default(NavigationHelper.INSTANCE, ((GameConfiguration) baiShunGameActivity.getGameAdapter().getData().get(i)).getUrl(), (SuperCallBack) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaiShunViewModel viewModel_delegate$lambda$0(BaiShunGameActivity baiShunGameActivity) {
        return new ViewModelProvider(baiShunGameActivity).get(BaiShunViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_bai_shun;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
