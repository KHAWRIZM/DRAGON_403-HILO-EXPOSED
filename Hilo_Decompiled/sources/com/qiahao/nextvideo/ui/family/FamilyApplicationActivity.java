package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.databinding.ActivityFamilyApplicationBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyApplicationActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyApplicationBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyApplicationAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyApplicationAdapter;", "mMemberAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "startUser", SupportGiftRankActivity.EXTERNAL_ID, "", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyApplicationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyApplicationActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyApplicationActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n61#2,9:129\n1#3:138\n*S KotlinDebug\n*F\n+ 1 FamilyApplicationActivity.kt\ncom/qiahao/nextvideo/ui/family/FamilyApplicationActivity\n*L\n49#1:129,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyApplicationActivity extends HiloBaseBindingActivity<ActivityFamilyApplicationBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.n
        public final Object invoke() {
            FamilyCenterViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FamilyApplicationActivity.viewModel_delegate$lambda$0(FamilyApplicationActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.o
        public final Object invoke() {
            FamilyApplicationAdapter mMemberAdapter_delegate$lambda$1;
            mMemberAdapter_delegate$lambda$1 = FamilyApplicationActivity.mMemberAdapter_delegate$lambda$1();
            return mMemberAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyApplicationActivity$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) FamilyApplicationActivity.class));
        }

        private Companion() {
        }
    }

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
    public static final void onInitialize$lambda$11(FamilyApplicationActivity familyApplicationActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = ((FamilyApplicationData) familyApplicationActivity.getMMemberAdapter().getData().get(i)).getUser();
        if (user != null && (externalId = user.getExternalId()) != null) {
            familyApplicationActivity.startUser(externalId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$3(FamilyApplicationActivity familyApplicationActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyApplicationActivity.getViewModel().getFamilyApplyListData().resetPage();
        familyApplicationActivity.getViewModel().familyApplyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(FamilyApplicationActivity familyApplicationActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyApplicationActivity.getViewModel().familyApplyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$6(FamilyApplicationActivity familyApplicationActivity, List list) {
        if (familyApplicationActivity.getViewModel().getFamilyApplyListData().isOnePage()) {
            familyApplicationActivity.getMMemberAdapter().setList(list);
        } else if (list != null) {
            familyApplicationActivity.getMMemberAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onInitialize$lambda$7(FamilyApplicationActivity familyApplicationActivity, Pair pair) {
        if (pair.getSecond() instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(familyApplicationActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, familyApplicationActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$8(FamilyApplicationActivity familyApplicationActivity, Pair pair) {
        String nick;
        String nick2;
        Object second = pair.getSecond();
        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) second).intValue();
        FamilyApplicationData familyApplicationData = (FamilyApplicationData) familyApplicationActivity.getMMemberAdapter().getData().get(intValue);
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
        familyApplicationActivity.getMMemberAdapter().getData().set(intValue, familyApplicationData);
        familyApplicationActivity.getMMemberAdapter().notifyItemChanged(intValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(FamilyApplicationActivity familyApplicationActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        String externalId2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        FamilyApplicationData familyApplicationData = (FamilyApplicationData) familyApplicationActivity.getMMemberAdapter().getData().get(i);
        int id2 = view.getId();
        String str = "";
        if (id2 != 2131361945) {
            if (id2 == 2131364548) {
                FamilyCenterViewModel viewModel = familyApplicationActivity.getViewModel();
                User user = familyApplicationData.getUser();
                if (user != null && (externalId2 = user.getExternalId()) != null) {
                    str = externalId2;
                }
                viewModel.applyFamily(str, 2, i);
                return;
            }
            return;
        }
        FamilyCenterViewModel viewModel2 = familyApplicationActivity.getViewModel();
        User user2 = familyApplicationData.getUser();
        if (user2 != null && (externalId = user2.getExternalId()) != null) {
            str = externalId;
        }
        viewModel2.applyFamily(str, 1, i);
    }

    private final void startUser(String externalId) {
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyCenterViewModel viewModel_delegate$lambda$0(FamilyApplicationActivity familyApplicationActivity) {
        return new ViewModelProvider(familyApplicationActivity).get(FamilyCenterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_application;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getFamilyApplyListData().destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityFamilyApplicationBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        ((ActivityFamilyApplicationBinding) getBinding()).recyclerView.setAdapter(getMMemberAdapter());
        final AppCompatImageView appCompatImageView = ((ActivityFamilyApplicationBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyApplicationActivity$onInitialize$$inlined$singleClick$default$1
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
        ((ActivityFamilyApplicationBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getFamilyApplyListData().registerStatusLayoutAndRefreshLayout(((ActivityFamilyApplicationBinding) getBinding()).refreshLayout, ((ActivityFamilyApplicationBinding) getBinding()).statusView);
        ((ActivityFamilyApplicationBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.g
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FamilyApplicationActivity.onInitialize$lambda$3(FamilyApplicationActivity.this, fVar);
            }
        });
        ((ActivityFamilyApplicationBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.h
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                FamilyApplicationActivity.onInitialize$lambda$4(FamilyApplicationActivity.this, fVar);
            }
        });
        ((ActivityFamilyApplicationBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyApplicationActivity$onInitialize$4
            public void onRetry(IStatusView statusView, Status status) {
                FamilyCenterViewModel viewModel;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = FamilyApplicationActivity.this.getViewModel();
                viewModel.familyApplyList();
            }
        });
        getViewModel().getFamilyApplyList().observe(this, new FamilyApplicationActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.i
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$6;
                onInitialize$lambda$6 = FamilyApplicationActivity.onInitialize$lambda$6(FamilyApplicationActivity.this, (List) obj);
                return onInitialize$lambda$6;
            }
        }));
        getViewModel().getMException().observe(this, new FamilyApplicationActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.j
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = FamilyApplicationActivity.onInitialize$lambda$7(FamilyApplicationActivity.this, (Pair) obj);
                return onInitialize$lambda$7;
            }
        }));
        getViewModel().getMSuccess().observe(this, new FamilyApplicationActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.k
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$8;
                onInitialize$lambda$8 = FamilyApplicationActivity.onInitialize$lambda$8(FamilyApplicationActivity.this, (Pair) obj);
                return onInitialize$lambda$8;
            }
        }));
        getMMemberAdapter().addChildClickViewIds(new int[]{R.id.agree, R.id.refuse});
        getMMemberAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.family.l
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyApplicationActivity.onInitialize$lambda$9(FamilyApplicationActivity.this, baseQuickAdapter, view, i);
            }
        });
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.m
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyApplicationActivity.onInitialize$lambda$11(FamilyApplicationActivity.this, baseQuickAdapter, view, i);
            }
        });
        getViewModel().familyApplyList();
    }
}
