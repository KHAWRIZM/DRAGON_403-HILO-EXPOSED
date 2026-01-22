package com.qiahao.nextvideo.ui.transfer;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityTransferSearchBinding;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferSearchActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityTransferSearchBinding;", "<init>", "()V", "mMemberAdapter", "Lcom/qiahao/nextvideo/ui/transfer/TransferSearchAdapter;", "getMMemberAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/TransferSearchAdapter;", "mMemberAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/transfer/TransferViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/TransferViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferSearchActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferSearchActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,142:1\n61#2,9:143\n*S KotlinDebug\n*F\n+ 1 TransferSearchActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferSearchActivity\n*L\n59#1:143,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferSearchActivity extends HiloBaseBindingActivity<ActivityTransferSearchBinding> {

    /* renamed from: mMemberAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMemberAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.z1
        public final Object invoke() {
            TransferSearchAdapter mMemberAdapter_delegate$lambda$0;
            mMemberAdapter_delegate$lambda$0 = TransferSearchActivity.mMemberAdapter_delegate$lambda$0();
            return mMemberAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.a2
        public final Object invoke() {
            TransferViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = TransferSearchActivity.viewModel_delegate$lambda$1(TransferSearchActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    private final TransferSearchAdapter getMMemberAdapter() {
        return (TransferSearchAdapter) this.mMemberAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransferViewModel getViewModel() {
        return (TransferViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferSearchAdapter mMemberAdapter_delegate$lambda$0() {
        return new TransferSearchAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(TransferSearchActivity transferSearchActivity, int i, int i2) {
        transferSearchActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onInitialize$lambda$4(TransferSearchActivity transferSearchActivity, TextView textView, int i, KeyEvent keyEvent) {
        if ((i == 3 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) && FastClickOneUtils.INSTANCE.isFastClick() && !TextUtils.isEmpty(transferSearchActivity.getBinding().searchEditText.getText().toString())) {
            transferSearchActivity.getViewModel().transferSearchUser(transferSearchActivity.getBinding().searchEditText.getText().toString());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(TransferSearchActivity transferSearchActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (TextUtils.isEmpty(transferSearchActivity.getBinding().searchEditText.getText().toString())) {
            transferSearchActivity.getViewModel().transferUserList();
        } else {
            transferSearchActivity.getViewModel().transferSearchUser(transferSearchActivity.getBinding().searchEditText.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$6(TransferSearchActivity transferSearchActivity, List list) {
        transferSearchActivity.getBinding().refreshLayout.finishRefresh();
        transferSearchActivity.getBinding().refreshLayout.finishLoadMore();
        transferSearchActivity.getBinding().refreshLayout.setEnableLoadMore(false);
        if (list.isEmpty()) {
            transferSearchActivity.getBinding().statusView.showEmpty();
        } else {
            transferSearchActivity.getBinding().statusView.showContent();
        }
        transferSearchActivity.getMMemberAdapter().setList(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onInitialize$lambda$7(TransferSearchActivity transferSearchActivity, Throwable th) {
        ((ActivityTransferSearchBinding) transferSearchActivity.getBinding()).refreshLayout.finishRefresh();
        ((ActivityTransferSearchBinding) transferSearchActivity.getBinding()).refreshLayout.finishLoadMore();
        ((ActivityTransferSearchBinding) transferSearchActivity.getBinding()).statusView.showEmpty();
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(transferSearchActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, transferSearchActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$8(TransferSearchActivity transferSearchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, ((User) transferSearchActivity.getMMemberAdapter().getData().get(i)).getExternalId(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onInitialize$lambda$9(TransferSearchActivity transferSearchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        cf.c.c().l(new EventBusKey("transfer_user", (User) transferSearchActivity.getMMemberAdapter().getData().get(i)));
        transferSearchActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferViewModel viewModel_delegate$lambda$1(TransferSearchActivity transferSearchActivity) {
        return new ViewModelProvider(transferSearchActivity).get(TransferViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_transfer_search;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = ((ActivityTransferSearchBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.transfer.b2
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = TransferSearchActivity.onInitialize$lambda$2(TransferSearchActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityTransferSearchBinding) getBinding()).recyclerView.setAdapter(getMMemberAdapter());
        ((ActivityTransferSearchBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        final AppCompatImageView appCompatImageView = ((ActivityTransferSearchBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferSearchActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        ((ActivityTransferSearchBinding) getBinding()).searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.ui.transfer.c2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean onInitialize$lambda$4;
                onInitialize$lambda$4 = TransferSearchActivity.onInitialize$lambda$4(TransferSearchActivity.this, textView, i, keyEvent);
                return onInitialize$lambda$4;
            }
        });
        ((ActivityTransferSearchBinding) getBinding()).searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.transfer.TransferSearchActivity$onInitialize$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                TransferViewModel viewModel;
                if (TextUtils.isEmpty(s) && HiloUtils.INSTANCE.notFastClick()) {
                    viewModel = TransferSearchActivity.this.getViewModel();
                    viewModel.transferUserList();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivityTransferSearchBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.transfer.d2
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                TransferSearchActivity.onInitialize$lambda$5(TransferSearchActivity.this, fVar);
            }
        });
        ((ActivityTransferSearchBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferSearchActivity$onInitialize$6
            public void onRetry(IStatusView statusView, Status status) {
                ActivityTransferSearchBinding binding;
                TransferViewModel viewModel;
                ActivityTransferSearchBinding binding2;
                TransferViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                binding = TransferSearchActivity.this.getBinding();
                if (TextUtils.isEmpty(binding.searchEditText.getText().toString())) {
                    viewModel2 = TransferSearchActivity.this.getViewModel();
                    viewModel2.transferUserList();
                } else {
                    viewModel = TransferSearchActivity.this.getViewModel();
                    binding2 = TransferSearchActivity.this.getBinding();
                    viewModel.transferSearchUser(binding2.searchEditText.getText().toString());
                }
            }
        });
        getViewModel().getTransferUser().observe(this, new TransferSearchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.e2
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$6;
                onInitialize$lambda$6 = TransferSearchActivity.onInitialize$lambda$6(TransferSearchActivity.this, (List) obj);
                return onInitialize$lambda$6;
            }
        }));
        getViewModel().getError().observe(this, new TransferSearchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.f2
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = TransferSearchActivity.onInitialize$lambda$7(TransferSearchActivity.this, (Throwable) obj);
                return onInitialize$lambda$7;
            }
        }));
        getMMemberAdapter().addChildClickViewIds(new int[]{2131362013});
        getMMemberAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.g2
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                TransferSearchActivity.onInitialize$lambda$8(TransferSearchActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getMMemberAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.h2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                TransferSearchActivity.onInitialize$lambda$9(TransferSearchActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getViewModel().transferUserList();
    }
}
