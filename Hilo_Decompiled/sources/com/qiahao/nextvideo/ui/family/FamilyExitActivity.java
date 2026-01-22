package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.databinding.ActivityFamilyExitBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyExitActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyExitBinding;", "<init>", "()V", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyExitAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyExitAdapter;", "mMemberAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "startUser", SupportGiftRankActivity.EXTERNAL_ID, "", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyExitActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyExitActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyExitActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n61#2,9:93\n1#3:102\n*S KotlinDebug\n*F\n+ 1 FamilyExitActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyExitActivity\n*L\n45#1:93,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyExitActivity extends HiloBaseBindingActivity<ActivityFamilyExitBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.i1
        public final Object invoke() {
            FamilyExitAdapter mMemberAdapter_delegate$lambda$0;
            mMemberAdapter_delegate$lambda$0 = FamilyExitActivity.mMemberAdapter_delegate$lambda$0();
            return mMemberAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.j1
        public final Object invoke() {
            FamilyCenterViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = FamilyExitActivity.viewModel_delegate$lambda$1(FamilyExitActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyExitActivity$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) FamilyExitActivity.class));
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
    public static final void onInitialize$lambda$3(FamilyExitActivity familyExitActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyExitActivity.getViewModel().getFamilyExitListData().resetPage();
        familyExitActivity.getViewModel().familyExitList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(FamilyExitActivity familyExitActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyExitActivity.getViewModel().familyExitList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$6(FamilyExitActivity familyExitActivity, List list) {
        if (familyExitActivity.getViewModel().getFamilyExitListData().isOnePage()) {
            familyExitActivity.getMMemberAdapter().setList(list);
        } else if (list != null) {
            familyExitActivity.getMMemberAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$8(FamilyExitActivity familyExitActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = ((FamilyApplicationData) familyExitActivity.getMMemberAdapter().getData().get(i)).getUser();
        if (user != null && (externalId = user.getExternalId()) != null) {
            familyExitActivity.startUser(externalId);
        }
    }

    private final void startUser(String externalId) {
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterViewModel viewModel_delegate$lambda$1(FamilyExitActivity familyExitActivity) {
        return new ViewModelProvider(familyExitActivity).get(FamilyCenterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_exit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getFamilyExitListData().destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityFamilyExitBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        ((ActivityFamilyExitBinding) getBinding()).recyclerView.setAdapter(getMMemberAdapter());
        final AppCompatImageView appCompatImageView = ((ActivityFamilyExitBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyExitActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        ((ActivityFamilyExitBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getFamilyExitListData().registerStatusLayoutAndRefreshLayout(((ActivityFamilyExitBinding) getBinding()).refreshLayout, ((ActivityFamilyExitBinding) getBinding()).statusView);
        ((ActivityFamilyExitBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.k1
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FamilyExitActivity.onInitialize$lambda$3(FamilyExitActivity.this, fVar);
            }
        });
        ((ActivityFamilyExitBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.l1
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                FamilyExitActivity.onInitialize$lambda$4(FamilyExitActivity.this, fVar);
            }
        });
        ((ActivityFamilyExitBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyExitActivity$onInitialize$4
            public void onRetry(IStatusView statusView, Status status) {
                FamilyCenterViewModel viewModel;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = FamilyExitActivity.this.getViewModel();
                viewModel.familyExitList();
            }
        });
        getViewModel().getFamilyExitList().observe(this, new FamilyExitActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.m1
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$6;
                onInitialize$lambda$6 = FamilyExitActivity.onInitialize$lambda$6(FamilyExitActivity.this, (List) obj);
                return onInitialize$lambda$6;
            }
        }));
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.n1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyExitActivity.onInitialize$lambda$8(FamilyExitActivity.this, baseQuickAdapter, view, i);
            }
        });
        getViewModel().familyExitList();
    }
}
