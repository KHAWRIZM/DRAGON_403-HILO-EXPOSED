package com.qiahao.nextvideo.ui.task;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.HomePageEvent;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.EarnDiamondBean;
import com.qiahao.nextvideo.data.model.EarnDiamondDailyBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.task.RealCertificationResult;
import com.qiahao.nextvideo.databinding.FragmentRealTaskBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.home.earn.EarnDiamondAdapter;
import com.qiahao.nextvideo.ui.peopleCertification.PeopleCertificationActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/RealTaskFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRealTaskBinding;", "<init>", "()V", "mDailyAdapter", "Lcom/qiahao/nextvideo/ui/home/earn/EarnDiamondAdapter;", "getMDailyAdapter", "()Lcom/qiahao/nextvideo/ui/home/earn/EarnDiamondAdapter;", "mDailyAdapter$delegate", "Lkotlin/Lazy;", "mAdAdapter", "getMAdAdapter", "mAdAdapter$delegate", "viewModel", "Lcom/qiahao/nextvideo/ui/task/RealTaskViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/task/RealTaskViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onResume", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRealTaskFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealTaskFragment.kt\ncom/qiahao/nextvideo/ui/task/RealTaskFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,213:1\n61#2,9:214\n*S KotlinDebug\n*F\n+ 1 RealTaskFragment.kt\ncom/qiahao/nextvideo/ui/task/RealTaskFragment\n*L\n140#1:214,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RealTaskFragment extends BaseBindingFragment<FragmentRealTaskBinding> {

    /* renamed from: mDailyAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDailyAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.a0
        public final Object invoke() {
            EarnDiamondAdapter mDailyAdapter_delegate$lambda$0;
            mDailyAdapter_delegate$lambda$0 = RealTaskFragment.mDailyAdapter_delegate$lambda$0();
            return mDailyAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: mAdAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.b0
        public final Object invoke() {
            EarnDiamondAdapter mAdAdapter_delegate$lambda$1;
            mAdAdapter_delegate$lambda$1 = RealTaskFragment.mAdAdapter_delegate$lambda$1();
            return mAdAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.c0
        public final Object invoke() {
            RealTaskViewModel viewModel_delegate$lambda$2;
            viewModel_delegate$lambda$2 = RealTaskFragment.viewModel_delegate$lambda$2(RealTaskFragment.this);
            return viewModel_delegate$lambda$2;
        }
    });

    private final EarnDiamondAdapter getMAdAdapter() {
        return (EarnDiamondAdapter) this.mAdAdapter.getValue();
    }

    private final EarnDiamondAdapter getMDailyAdapter() {
        return (EarnDiamondAdapter) this.mDailyAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RealTaskViewModel getViewModel() {
        return (RealTaskViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getMException().observe(this, new RealTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.v
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = RealTaskFragment.initData$lambda$3(RealTaskFragment.this, (Pair) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getTaskList().observe(this, new RealTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.w
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = RealTaskFragment.initData$lambda$4(RealTaskFragment.this, (EarnDiamondBean) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getCreateRoom().observe(this, new RealTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.x
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = RealTaskFragment.initData$lambda$5((CreateGroupBean) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getRoom().observe(this, new RealTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.y
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = RealTaskFragment.initData$lambda$7((List) obj);
                return initData$lambda$7;
            }
        }));
        getViewModel().getRealStatus().observe(this, new RealTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.z
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = RealTaskFragment.initData$lambda$8(RealTaskFragment.this, (RealCertificationResult) obj);
                return initData$lambda$8;
            }
        }));
        getViewModel().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(RealTaskFragment realTaskFragment, Pair pair) {
        String str;
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = realTaskFragment.getContext();
        String localizedMessage = ((Throwable) pair.getSecond()).getLocalizedMessage();
        if (localizedMessage == null) {
            String string = realTaskFragment.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(RealTaskFragment realTaskFragment, EarnDiamondBean earnDiamondBean) {
        List<EarnDiamondDailyBean> list;
        EarnDiamondAdapter mDailyAdapter = realTaskFragment.getMDailyAdapter();
        List<EarnDiamondDailyBean> list2 = null;
        if (earnDiamondBean != null) {
            list = earnDiamondBean.getDailys();
        } else {
            list = null;
        }
        mDailyAdapter.setList(list);
        EarnDiamondAdapter mAdAdapter = realTaskFragment.getMAdAdapter();
        if (earnDiamondBean != null) {
            list2 = earnDiamondBean.getAdvanceds();
        }
        mAdAdapter.setList(list2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(CreateGroupBean createGroupBean) {
        String str;
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        if (createGroupBean == null || (str = createGroupBean.getImGroupId()) == null) {
            str = "";
        }
        StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(List list) {
        if (list != null) {
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((HotGroupBean) list.get(0)).getGroupId(), ((HotGroupBean) list.get(0)).getCode(), ((HotGroupBean) list.get(0)).getFaceUrl(), ((HotGroupBean) list.get(0)).getName(), Boolean.valueOf(((HotGroupBean) list.get(0)).getHasPassWord()), ((HotGroupBean) list.get(0)).getCountryIcon(), ((HotGroupBean) list.get(0)).getIntroduction(), ((HotGroupBean) list.get(0)).getNotification(), 0, 0, null, 0, false, 7936, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(RealTaskFragment realTaskFragment, RealCertificationResult realCertificationResult) {
        Integer num;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        TextView textView5;
        TextView textView6;
        ImageView imageView3;
        TextView textView7;
        TextView textView8;
        ImageView imageView4;
        if (realCertificationResult != null) {
            num = realCertificationResult.getStatus();
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 3) {
            FragmentRealTaskBinding fragmentRealTaskBinding = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding != null && (imageView4 = fragmentRealTaskBinding.arrow) != null) {
                imageView4.setVisibility(0);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding2 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding2 != null && (textView8 = fragmentRealTaskBinding2.goddess) != null) {
                textView8.setVisibility(8);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding3 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding3 != null && (textView7 = fragmentRealTaskBinding3.realText) != null) {
                textView7.setText(ResourcesKtxKt.getStringById(realTaskFragment, 2131954173));
            }
        } else if (num != null && num.intValue() == 0) {
            FragmentRealTaskBinding fragmentRealTaskBinding4 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding4 != null && (imageView3 = fragmentRealTaskBinding4.arrow) != null) {
                imageView3.setVisibility(0);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding5 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding5 != null && (textView6 = fragmentRealTaskBinding5.goddess) != null) {
                textView6.setVisibility(8);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding6 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding6 != null && (textView5 = fragmentRealTaskBinding6.realText) != null) {
                textView5.setText(ResourcesKtxKt.getStringById(realTaskFragment, 2131954550));
            }
        } else if (num != null && num.intValue() == 1) {
            FragmentRealTaskBinding fragmentRealTaskBinding7 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding7 != null && (imageView2 = fragmentRealTaskBinding7.arrow) != null) {
                imageView2.setVisibility(8);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding8 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding8 != null && (textView4 = fragmentRealTaskBinding8.goddess) != null) {
                textView4.setVisibility(0);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding9 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding9 != null && (textView3 = fragmentRealTaskBinding9.realText) != null) {
                textView3.setText(ResourcesKtxKt.getStringById(realTaskFragment, 2131954443));
            }
        } else if (num != null && num.intValue() == 2) {
            FragmentRealTaskBinding fragmentRealTaskBinding10 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding10 != null && (imageView = fragmentRealTaskBinding10.arrow) != null) {
                imageView.setVisibility(0);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding11 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding11 != null && (textView2 = fragmentRealTaskBinding11.goddess) != null) {
                textView2.setVisibility(8);
            }
            FragmentRealTaskBinding fragmentRealTaskBinding12 = (FragmentRealTaskBinding) realTaskFragment.getBinding();
            if (fragmentRealTaskBinding12 != null && (textView = fragmentRealTaskBinding12.realText) != null) {
                textView.setText(ResourcesKtxKt.getStringById(realTaskFragment, 2131954551));
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        final ConstraintLayout constraintLayout;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        TextView textView;
        ConstraintLayout constraintLayout2;
        NestedScrollView nestedScrollView;
        ConstraintLayout constraintLayout3;
        int i;
        FragmentRealTaskBinding fragmentRealTaskBinding = (FragmentRealTaskBinding) getBinding();
        if (fragmentRealTaskBinding != null && (constraintLayout3 = fragmentRealTaskBinding.realConstraint) != null) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && user.getSex() == 2) {
                i = 0;
            } else {
                i = 8;
            }
            constraintLayout3.setVisibility(i);
        }
        FragmentRealTaskBinding fragmentRealTaskBinding2 = (FragmentRealTaskBinding) getBinding();
        if (fragmentRealTaskBinding2 != null && (nestedScrollView = fragmentRealTaskBinding2.scrollView) != null) {
            nestedScrollView.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentRealTaskBinding fragmentRealTaskBinding3 = (FragmentRealTaskBinding) getBinding();
        if (fragmentRealTaskBinding3 != null && (constraintLayout2 = fragmentRealTaskBinding3.realConstraint) != null) {
            constraintLayout2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentRealTaskBinding fragmentRealTaskBinding4 = (FragmentRealTaskBinding) getBinding();
        if (fragmentRealTaskBinding4 != null && (textView = fragmentRealTaskBinding4.goddess) != null) {
            textView.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#FFDAB8", 8, 1.0f, false, "#EF2FE4", "#FA9756", (GradientDrawable.Orientation) null, 72, (Object) null));
        }
        FragmentRealTaskBinding fragmentRealTaskBinding5 = (FragmentRealTaskBinding) getBinding();
        if (fragmentRealTaskBinding5 != null && (recyclerView2 = fragmentRealTaskBinding5.dailyTasksRecycler) != null) {
            recyclerView2.setLayoutManager(new CustomLinearLayoutManager(recyclerView2.getContext()));
            recyclerView2.setAdapter(getMDailyAdapter());
        }
        FragmentRealTaskBinding fragmentRealTaskBinding6 = (FragmentRealTaskBinding) getBinding();
        if (fragmentRealTaskBinding6 != null && (recyclerView = fragmentRealTaskBinding6.growthTasksRecycler) != null) {
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(getMAdAdapter());
        }
        FragmentRealTaskBinding fragmentRealTaskBinding7 = (FragmentRealTaskBinding) getBinding();
        if (fragmentRealTaskBinding7 != null && (constraintLayout = fragmentRealTaskBinding7.realConstraint) != null) {
            final long j = 800;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.task.RealTaskFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RealTaskViewModel viewModel;
                    int i2;
                    Context context;
                    Integer status;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout4 = constraintLayout;
                        viewModel = this.getViewModel();
                        RealCertificationResult realCertificationResult = (RealCertificationResult) viewModel.getRealStatus().getValue();
                        if (realCertificationResult != null && (status = realCertificationResult.getStatus()) != null) {
                            i2 = status.intValue();
                        } else {
                            i2 = 3;
                        }
                        if (i2 != 0) {
                            if ((i2 == 2 || i2 == 3) && (context = this.getContext()) != null) {
                                PeopleCertificationActivity.Companion.start(context);
                                return;
                            }
                            return;
                        }
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131954550), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    }
                }
            });
        }
        getMDailyAdapter().addChildClickViewIds(new int[]{R.id.earn_take_button});
        getMDailyAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.task.t
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                RealTaskFragment.initView$lambda$13(RealTaskFragment.this, baseQuickAdapter, view, i2);
            }
        });
        getMAdAdapter().addChildClickViewIds(new int[]{R.id.earn_take_button});
        getMAdAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.task.u
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                RealTaskFragment.initView$lambda$14(RealTaskFragment.this, baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$13(RealTaskFragment realTaskFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EarnDiamondDailyBean");
        EarnDiamondDailyBean earnDiamondDailyBean = (EarnDiamondDailyBean) item;
        if (view.getId() == 2131362729 && FastClickOneUtils.INSTANCE.isFastClick()) {
            if (earnDiamondDailyBean.getHasFinish() == 2) {
                int type = earnDiamondDailyBean.getType();
                if (type == 12 || type == 13 || type == 15) {
                    cf.c.c().l(new HomePageEvent(0, 0, 2, (DefaultConstructorMarker) null));
                    return;
                }
                return;
            }
            if (earnDiamondDailyBean.getHasAward() == 2) {
                realTaskFragment.getViewModel().getReward(earnDiamondDailyBean.getTaskConfigId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$14(RealTaskFragment realTaskFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        AppService service;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EarnDiamondDailyBean");
        EarnDiamondDailyBean earnDiamondDailyBean = (EarnDiamondDailyBean) item;
        if (view.getId() == 2131362729 && FastClickOneUtils.INSTANCE.isFastClick()) {
            if (earnDiamondDailyBean.getHasFinish() == 2) {
                if (earnDiamondDailyBean.getType() == 14 && (service = AppController.INSTANCE.getService()) != null) {
                    service.openPeopleCertification();
                    return;
                }
                return;
            }
            if (earnDiamondDailyBean.getHasAward() == 2) {
                realTaskFragment.getViewModel().getReward(earnDiamondDailyBean.getTaskConfigId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarnDiamondAdapter mAdAdapter_delegate$lambda$1() {
        return new EarnDiamondAdapter(R.layout.item_daily_earn_diamond_task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarnDiamondAdapter mDailyAdapter_delegate$lambda$0() {
        return new EarnDiamondAdapter(R.layout.item_daily_earn_diamond_task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RealTaskViewModel viewModel_delegate$lambda$2(RealTaskFragment realTaskFragment) {
        return new ViewModelProvider(realTaskFragment).get(RealTaskViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_real_task;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && user.getSex() == 2) {
            getViewModel().realCertification();
        }
    }
}
