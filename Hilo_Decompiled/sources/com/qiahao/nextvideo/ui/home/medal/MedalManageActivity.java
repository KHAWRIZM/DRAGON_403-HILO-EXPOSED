package com.qiahao.nextvideo.ui.home.medal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.medal.MedalSort;
import com.qiahao.nextvideo.databinding.ActivityMedalManageBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0006H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/MedalManageActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityMedalManageBinding;", "<init>", "()V", "mSelectPosition", "", "getMSelectPosition", "()I", "setMSelectPosition", "(I)V", "viewModel", "Lcom/qiahao/nextvideo/ui/home/medal/MedalViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/medal/MedalViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/medal/MedalManageAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/medal/MedalManageAdapter;", "mAdapter$delegate", "getLayoutResId", "onInitialize", "", "initData", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMedalManageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MedalManageActivity.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalManageActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1878#2,3:113\n*S KotlinDebug\n*F\n+ 1 MedalManageActivity.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalManageActivity\n*L\n91#1:113,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MedalManageActivity extends HiloBaseBindingActivity<ActivityMedalManageBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int mSelectPosition = -1;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.r
        public final Object invoke() {
            MedalViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = MedalManageActivity.viewModel_delegate$lambda$0(MedalManageActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.s
        public final Object invoke() {
            MedalManageAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = MedalManageActivity.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/MedalManageActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) MedalManageActivity.class));
        }

        private Companion() {
        }
    }

    private final void initData() {
        getViewModel().getModelSortList().observe(this, new MedalManageActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.t
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = MedalManageActivity.initData$lambda$2(MedalManageActivity.this, (List) obj);
                return initData$lambda$2;
            }
        }));
        getViewModel().getError().observe(this, new MedalManageActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.u
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = MedalManageActivity.initData$lambda$3(MedalManageActivity.this, (Throwable) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getMedalSort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(MedalManageActivity medalManageActivity, List list) {
        medalManageActivity.getMAdapter().setList(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$3(MedalManageActivity medalManageActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(medalManageActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, medalManageActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityMedalManageBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.medal.v
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$4;
                initView$lambda$4 = MedalManageActivity.initView$lambda$4(MedalManageActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$4;
            }
        });
        ((ActivityMedalManageBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MedalManageActivity.this.finish();
            }
        });
        ConstraintLayout constraintLayout = ((ActivityMedalManageBinding) getBinding()).constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        constraintLayout.setBackground(shapeUtil.createShape("#211E2A", "#3C395A", 0, GradientDrawable.Orientation.BOTTOM_TOP));
        ((ActivityMedalManageBinding) getBinding()).topBg.setBackground(ShapeUtil.createShape$default(shapeUtil, "#232138", "#232138", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        ((ActivityMedalManageBinding) getBinding()).topTitle.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131099980, 2131099980, 10, 0, 10, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
        ((ActivityMedalManageBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.toStringRes(2131953365));
        ((ActivityMedalManageBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.x
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                MedalManageActivity.initView$lambda$9(MedalManageActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4(MedalManageActivity medalManageActivity, int i, int i2) {
        medalManageActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$9(final MedalManageActivity medalManageActivity, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        List list;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        medalManageActivity.mSelectPosition = i;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            list = user.getMedalInfo();
        } else {
            list = null;
        }
        WealthMedalDialog wealthMedalDialog = new WealthMedalDialog(medalManageActivity, list);
        wealthMedalDialog.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.q
            public final Object invoke(Object obj) {
                Unit initView$lambda$9$lambda$8$lambda$7;
                initView$lambda$9$lambda$8$lambda$7 = MedalManageActivity.initView$lambda$9$lambda$8$lambda$7(MedalManageActivity.this, i, (MedalInfo) obj);
                return initView$lambda$9$lambda$8$lambda$7;
            }
        });
        wealthMedalDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9$lambda$8$lambda$7(MedalManageActivity medalManageActivity, int i, MedalInfo medalInfo) {
        Intrinsics.checkNotNullParameter(medalInfo, "it");
        int i2 = 0;
        int i3 = -1;
        for (Object obj : medalManageActivity.getMAdapter().getData()) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Integer medalId = ((MedalSort) obj).getMedalId();
            int id2 = medalInfo.getId();
            if (medalId != null && medalId.intValue() == id2) {
                i3 = i2;
            }
            i2 = i4;
        }
        if (i3 == -1) {
            MedalViewModel.setMedalSort$default(medalManageActivity.getViewModel(), i, medalInfo.getId(), medalInfo, 0, 8, null);
        } else if (i3 != medalManageActivity.mSelectPosition) {
            medalManageActivity.getViewModel().setMedalSort(i, medalInfo.getId(), medalInfo, i3);
        } else {
            MedalViewModel.setMedalSort$default(medalManageActivity.getViewModel(), i, 0, medalInfo, 0, 10, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MedalManageAdapter mAdapter_delegate$lambda$1() {
        return new MedalManageAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MedalViewModel viewModel_delegate$lambda$0(MedalManageActivity medalManageActivity) {
        return new ViewModelProvider(medalManageActivity).get(MedalViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_medal_manage;
    }

    @NotNull
    public final MedalManageAdapter getMAdapter() {
        return (MedalManageAdapter) this.mAdapter.getValue();
    }

    public final int getMSelectPosition() {
        return this.mSelectPosition;
    }

    @NotNull
    public final MedalViewModel getViewModel() {
        return (MedalViewModel) this.viewModel.getValue();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public final void setMSelectPosition(int i) {
        this.mSelectPosition = i;
    }
}
