package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.databinding.FragmentFamilyApplicationBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyApplicationFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFamilyApplicationBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyApplicationAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyApplicationAdapter;", "mMemberAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "startUser", SupportGiftRankActivity.EXTERNAL_ID, "", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyApplicationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyApplicationFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilyApplicationFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,115:1\n1#2:116\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyApplicationFragment extends BaseBindingFragment<FragmentFamilyApplicationBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.w
        public final Object invoke() {
            FamilyCenterViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FamilyApplicationFragment.viewModel_delegate$lambda$0(FamilyApplicationFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.x
        public final Object invoke() {
            FamilyApplicationAdapter mMemberAdapter_delegate$lambda$1;
            mMemberAdapter_delegate$lambda$1 = FamilyApplicationFragment.mMemberAdapter_delegate$lambda$1();
            return mMemberAdapter_delegate$lambda$1;
        }
    });

    private final FamilyApplicationAdapter getMMemberAdapter() {
        return (FamilyApplicationAdapter) this.mMemberAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyCenterViewModel getViewModel() {
        return (FamilyCenterViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyApplicationAdapter mMemberAdapter_delegate$lambda$1() {
        return new FamilyApplicationAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$10(FamilyApplicationFragment familyApplicationFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        String externalId2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        FamilyApplicationData familyApplicationData = (FamilyApplicationData) familyApplicationFragment.getMMemberAdapter().getData().get(i);
        int id2 = view.getId();
        String str = "";
        if (id2 != 2131361945) {
            if (id2 == 2131364548) {
                FamilyCenterViewModel viewModel = familyApplicationFragment.getViewModel();
                User user = familyApplicationData.getUser();
                if (user != null && (externalId2 = user.getExternalId()) != null) {
                    str = externalId2;
                }
                viewModel.applyFamily(str, 2, i);
                return;
            }
            return;
        }
        FamilyCenterViewModel viewModel2 = familyApplicationFragment.getViewModel();
        User user2 = familyApplicationData.getUser();
        if (user2 != null && (externalId = user2.getExternalId()) != null) {
            str = externalId;
        }
        viewModel2.applyFamily(str, 1, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$12(FamilyApplicationFragment familyApplicationFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = ((FamilyApplicationData) familyApplicationFragment.getMMemberAdapter().getData().get(i)).getUser();
        if (user != null && (externalId = user.getExternalId()) != null) {
            familyApplicationFragment.startUser(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(FamilyApplicationFragment familyApplicationFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyApplicationFragment.getViewModel().getFamilyApplyListData().resetPage();
        familyApplicationFragment.getViewModel().familyApplyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(FamilyApplicationFragment familyApplicationFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyApplicationFragment.getViewModel().familyApplyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(FamilyApplicationFragment familyApplicationFragment, List list) {
        if (familyApplicationFragment.getViewModel().getFamilyApplyListData().isOnePage()) {
            familyApplicationFragment.getMMemberAdapter().setList(list);
        } else if (list != null) {
            familyApplicationFragment.getMMemberAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$8(FamilyApplicationFragment familyApplicationFragment, Pair pair) {
        String str;
        if (pair.getSecond() instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = familyApplicationFragment.getContext();
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(familyApplicationFragment, 2131952667);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$9(FamilyApplicationFragment familyApplicationFragment, Pair pair) {
        String nick;
        String nick2;
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) second).intValue();
        FamilyApplicationData familyApplicationData = (FamilyApplicationData) familyApplicationFragment.getMMemberAdapter().getData().get(intValue);
        String str = "";
        if (Intrinsics.areEqual(pair.getFirst(), FamilyCenterViewModel.AGREE)) {
            familyApplicationData.setStatus(1);
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && (nick2 = user.getNick()) != null) {
                str = nick2;
            }
            familyApplicationData.setMgrName(str);
        } else if (Intrinsics.areEqual(pair.getFirst(), FamilyCenterViewModel.REFUSE)) {
            familyApplicationData.setStatus(2);
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null && (nick = user2.getNick()) != null) {
                str = nick;
            }
            familyApplicationData.setMgrName(str);
        }
        familyApplicationFragment.getMMemberAdapter().getData().set(intValue, familyApplicationData);
        familyApplicationFragment.getMMemberAdapter().notifyItemChanged(intValue);
        return Unit.INSTANCE;
    }

    private final void startUser(String externalId) {
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterViewModel viewModel_delegate$lambda$0(FamilyApplicationFragment familyApplicationFragment) {
        return new ViewModelProvider(familyApplicationFragment).get(FamilyCenterViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_family_application;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getViewModel().getFamilyApplyListData().destroy();
    }

    public void onInitialize() {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentFamilyApplicationBinding fragmentFamilyApplicationBinding = (FragmentFamilyApplicationBinding) getBinding();
        if (fragmentFamilyApplicationBinding != null && (recyclerView = fragmentFamilyApplicationBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMMemberAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentFamilyApplicationBinding fragmentFamilyApplicationBinding2 = (FragmentFamilyApplicationBinding) getBinding();
            if (fragmentFamilyApplicationBinding2 != null && (smartRefreshLayout4 = fragmentFamilyApplicationBinding2.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        BaseListData familyApplyListData = getViewModel().getFamilyApplyListData();
        FragmentFamilyApplicationBinding fragmentFamilyApplicationBinding3 = (FragmentFamilyApplicationBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentFamilyApplicationBinding3 != null) {
            smartRefreshLayout = fragmentFamilyApplicationBinding3.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentFamilyApplicationBinding fragmentFamilyApplicationBinding4 = (FragmentFamilyApplicationBinding) getBinding();
        if (fragmentFamilyApplicationBinding4 != null) {
            superStatusView2 = fragmentFamilyApplicationBinding4.statusView;
        }
        familyApplyListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentFamilyApplicationBinding fragmentFamilyApplicationBinding5 = (FragmentFamilyApplicationBinding) getBinding();
        if (fragmentFamilyApplicationBinding5 != null && (smartRefreshLayout3 = fragmentFamilyApplicationBinding5.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.p
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    FamilyApplicationFragment.onInitialize$lambda$4(FamilyApplicationFragment.this, fVar);
                }
            });
        }
        FragmentFamilyApplicationBinding fragmentFamilyApplicationBinding6 = (FragmentFamilyApplicationBinding) getBinding();
        if (fragmentFamilyApplicationBinding6 != null && (smartRefreshLayout2 = fragmentFamilyApplicationBinding6.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.q
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    FamilyApplicationFragment.onInitialize$lambda$5(FamilyApplicationFragment.this, fVar);
                }
            });
        }
        FragmentFamilyApplicationBinding fragmentFamilyApplicationBinding7 = (FragmentFamilyApplicationBinding) getBinding();
        if (fragmentFamilyApplicationBinding7 != null && (superStatusView = fragmentFamilyApplicationBinding7.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyApplicationFragment$onInitialize$5
                public void onRetry(IStatusView statusView, Status status) {
                    FamilyCenterViewModel viewModel;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel = FamilyApplicationFragment.this.getViewModel();
                    viewModel.familyApplyList();
                }
            });
        }
        getViewModel().getFamilyApplyList().observe(this, new FamilyApplicationFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.r
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = FamilyApplicationFragment.onInitialize$lambda$7(FamilyApplicationFragment.this, (List) obj);
                return onInitialize$lambda$7;
            }
        }));
        getViewModel().getMException().observe(this, new FamilyApplicationFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.s
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$8;
                onInitialize$lambda$8 = FamilyApplicationFragment.onInitialize$lambda$8(FamilyApplicationFragment.this, (Pair) obj);
                return onInitialize$lambda$8;
            }
        }));
        getViewModel().getMSuccess().observe(this, new FamilyApplicationFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.t
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$9;
                onInitialize$lambda$9 = FamilyApplicationFragment.onInitialize$lambda$9(FamilyApplicationFragment.this, (Pair) obj);
                return onInitialize$lambda$9;
            }
        }));
        getMMemberAdapter().addChildClickViewIds(new int[]{R.id.agree, R.id.refuse});
        getMMemberAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.family.u
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyApplicationFragment.onInitialize$lambda$10(FamilyApplicationFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.v
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyApplicationFragment.onInitialize$lambda$12(FamilyApplicationFragment.this, baseQuickAdapter, view, i);
            }
        });
        getViewModel().familyApplyList();
    }
}
