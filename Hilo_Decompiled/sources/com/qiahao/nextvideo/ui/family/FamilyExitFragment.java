package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.databinding.FragmentFamilyExitBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyExitFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFamilyExitBinding;", "<init>", "()V", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyExitAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyExitAdapter;", "mMemberAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "startUser", SupportGiftRankActivity.EXTERNAL_ID, "", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyExitFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyExitFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilyExitFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1#2:88\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyExitFragment extends BaseBindingFragment<FragmentFamilyExitBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.s1
        public final Object invoke() {
            FamilyExitAdapter mMemberAdapter_delegate$lambda$0;
            mMemberAdapter_delegate$lambda$0 = FamilyExitFragment.mMemberAdapter_delegate$lambda$0();
            return mMemberAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.t1
        public final Object invoke() {
            FamilyCenterViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = FamilyExitFragment.viewModel_delegate$lambda$1(FamilyExitFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyExitFragment$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) FamilyExitFragment.class));
        }

        private Companion() {
        }
    }

    private final FamilyExitAdapter getMMemberAdapter() {
        return (FamilyExitAdapter) this.mMemberAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyCenterViewModel getViewModel() {
        return (FamilyCenterViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyExitAdapter mMemberAdapter_delegate$lambda$0() {
        return new FamilyExitAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(FamilyExitFragment familyExitFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyExitFragment.getViewModel().getFamilyExitListData().resetPage();
        familyExitFragment.getViewModel().familyExitList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(FamilyExitFragment familyExitFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyExitFragment.getViewModel().familyExitList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(FamilyExitFragment familyExitFragment, List list) {
        if (familyExitFragment.getViewModel().getFamilyExitListData().isOnePage()) {
            familyExitFragment.getMMemberAdapter().setList(list);
        } else if (list != null) {
            familyExitFragment.getMMemberAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(FamilyExitFragment familyExitFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = ((FamilyApplicationData) familyExitFragment.getMMemberAdapter().getData().get(i)).getUser();
        if (user != null && (externalId = user.getExternalId()) != null) {
            familyExitFragment.startUser(externalId);
        }
    }

    private final void startUser(String externalId) {
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterViewModel viewModel_delegate$lambda$1(FamilyExitFragment familyExitFragment) {
        return new ViewModelProvider(familyExitFragment).get(FamilyCenterViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_family_exit;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getViewModel().getFamilyExitListData().destroy();
    }

    public void onInitialize() {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentFamilyExitBinding fragmentFamilyExitBinding = (FragmentFamilyExitBinding) getBinding();
        if (fragmentFamilyExitBinding != null && (recyclerView = fragmentFamilyExitBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMMemberAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentFamilyExitBinding fragmentFamilyExitBinding2 = (FragmentFamilyExitBinding) getBinding();
            if (fragmentFamilyExitBinding2 != null && (smartRefreshLayout4 = fragmentFamilyExitBinding2.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        BaseListData familyExitListData = getViewModel().getFamilyExitListData();
        FragmentFamilyExitBinding fragmentFamilyExitBinding3 = (FragmentFamilyExitBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentFamilyExitBinding3 != null) {
            smartRefreshLayout = fragmentFamilyExitBinding3.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentFamilyExitBinding fragmentFamilyExitBinding4 = (FragmentFamilyExitBinding) getBinding();
        if (fragmentFamilyExitBinding4 != null) {
            superStatusView2 = fragmentFamilyExitBinding4.statusView;
        }
        familyExitListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentFamilyExitBinding fragmentFamilyExitBinding5 = (FragmentFamilyExitBinding) getBinding();
        if (fragmentFamilyExitBinding5 != null && (smartRefreshLayout3 = fragmentFamilyExitBinding5.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.o1
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    FamilyExitFragment.onInitialize$lambda$4(FamilyExitFragment.this, fVar);
                }
            });
        }
        FragmentFamilyExitBinding fragmentFamilyExitBinding6 = (FragmentFamilyExitBinding) getBinding();
        if (fragmentFamilyExitBinding6 != null && (smartRefreshLayout2 = fragmentFamilyExitBinding6.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.p1
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    FamilyExitFragment.onInitialize$lambda$5(FamilyExitFragment.this, fVar);
                }
            });
        }
        FragmentFamilyExitBinding fragmentFamilyExitBinding7 = (FragmentFamilyExitBinding) getBinding();
        if (fragmentFamilyExitBinding7 != null && (superStatusView = fragmentFamilyExitBinding7.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyExitFragment$onInitialize$5
                public void onRetry(IStatusView statusView, Status status) {
                    FamilyCenterViewModel viewModel;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel = FamilyExitFragment.this.getViewModel();
                    viewModel.familyExitList();
                }
            });
        }
        getViewModel().getFamilyExitList().observe(this, new FamilyExitFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.q1
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = FamilyExitFragment.onInitialize$lambda$7(FamilyExitFragment.this, (List) obj);
                return onInitialize$lambda$7;
            }
        }));
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.r1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyExitFragment.onInitialize$lambda$9(FamilyExitFragment.this, baseQuickAdapter, view, i);
            }
        });
        getViewModel().familyExitList();
    }
}
