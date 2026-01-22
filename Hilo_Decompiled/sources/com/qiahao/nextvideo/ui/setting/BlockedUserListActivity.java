package com.qiahao.nextvideo.ui.setting;

import android.content.Context;
import android.content.Intent;
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
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.BlockedInfo;
import com.qiahao.nextvideo.databinding.ActivityBlockedUserListBinding;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/BlockedUserListActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityBlockedUserListBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/setting/UserBlockListViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/setting/UserBlockListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "mAdapter", "Lcom/qiahao/nextvideo/ui/setting/UserListBlockAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/setting/UserListBlockAdapter;", "mAdapter$delegate", "onInitialize", "", "initView", "initData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBlockedUserListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockedUserListActivity.kt\ncom/qiahao/nextvideo/ui/setting/BlockedUserListActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,178:1\n61#2,9:179\n*S KotlinDebug\n*F\n+ 1 BlockedUserListActivity.kt\ncom/qiahao/nextvideo/ui/setting/BlockedUserListActivity\n*L\n69#1:179,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BlockedUserListActivity extends HiloBaseBindingActivity<ActivityBlockedUserListBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";

    @NotNull
    public static final String TAG = "BlockedListActivity";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.setting.j
        public final Object invoke() {
            UserBlockListViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = BlockedUserListActivity.viewModel_delegate$lambda$0(BlockedUserListActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.setting.k
        public final Object invoke() {
            UserListBlockAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = BlockedUserListActivity.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/BlockedUserListActivity$Companion;", "", "<init>", "()V", "TAG", "", "GROUP_ID", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) BlockedUserListActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserBlockListViewModel getViewModel() {
        return (UserBlockListViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getBlockedList().observe(this, new BlockedUserListActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.setting.l
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = BlockedUserListActivity.initData$lambda$8(BlockedUserListActivity.this, (List) obj);
                return initData$lambda$8;
            }
        }));
        getViewModel().getMSuccess().observe(this, new BlockedUserListActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.setting.m
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = BlockedUserListActivity.initData$lambda$9(BlockedUserListActivity.this, (Pair) obj);
                return initData$lambda$9;
            }
        }));
        getViewModel().getMException().observe(this, new BlockedUserListActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.setting.n
            public final Object invoke(Object obj) {
                Unit initData$lambda$10;
                initData$lambda$10 = BlockedUserListActivity.initData$lambda$10(BlockedUserListActivity.this, (Pair) obj);
                return initData$lambda$10;
            }
        }));
        UserBlockListViewModel.blockList$default(getViewModel(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$10(BlockedUserListActivity blockedUserListActivity, Pair pair) {
        if (Intrinsics.areEqual((String) pair.getFirst(), "取消拉黑") && (pair.getSecond() instanceof Exception)) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(blockedUserListActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, blockedUserListActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(BlockedUserListActivity blockedUserListActivity, List list) {
        if (blockedUserListActivity.getViewModel().getBlockedListData().isOnePage()) {
            blockedUserListActivity.getMAdapter().setList(list);
        } else {
            UserListBlockAdapter mAdapter = blockedUserListActivity.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter.addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$9(BlockedUserListActivity blockedUserListActivity, Pair pair) {
        if (Intrinsics.areEqual((String) pair.getFirst(), "取消拉黑") && (pair.getSecond() instanceof Integer)) {
            UserListBlockAdapter mAdapter = blockedUserListActivity.getMAdapter();
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.Int");
            mAdapter.removeAt(((Integer) second).intValue());
            if (blockedUserListActivity.getMAdapter().getData().isEmpty()) {
                blockedUserListActivity.getBinding().statusView.showEmpty();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityBlockedUserListBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.setting.o
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$2;
                initView$lambda$2 = BlockedUserListActivity.initView$lambda$2(BlockedUserListActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$2;
            }
        });
        ((ActivityBlockedUserListBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        final AppCompatImageView appCompatImageView = ((ActivityBlockedUserListBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.BlockedUserListActivity$initView$$inlined$singleClick$default$1
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
        getViewModel().getBlockedListData().registerStatusLayoutAndRefreshLayout(((ActivityBlockedUserListBinding) getBinding()).refreshLayout, ((ActivityBlockedUserListBinding) getBinding()).statusView);
        ((ActivityBlockedUserListBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ActivityBlockedUserListBinding) getBinding()).searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.ui.setting.p
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initView$lambda$4;
                initView$lambda$4 = BlockedUserListActivity.initView$lambda$4(BlockedUserListActivity.this, textView, i, keyEvent);
                return initView$lambda$4;
            }
        });
        ((ActivityBlockedUserListBinding) getBinding()).searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.setting.BlockedUserListActivity$initView$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                UserBlockListViewModel viewModel;
                UserBlockListViewModel viewModel2;
                if (TextUtils.isEmpty(s) && HiloUtils.INSTANCE.notFastClick()) {
                    viewModel = BlockedUserListActivity.this.getViewModel();
                    viewModel.getBlockedListData().resetPage();
                    viewModel2 = BlockedUserListActivity.this.getViewModel();
                    UserBlockListViewModel.blockList$default(viewModel2, null, 1, null);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivityBlockedUserListBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.setting.q
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                BlockedUserListActivity.initView$lambda$5(BlockedUserListActivity.this, fVar);
            }
        });
        ((ActivityBlockedUserListBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.setting.r
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                BlockedUserListActivity.initView$lambda$6(BlockedUserListActivity.this, fVar);
            }
        });
        ((ActivityBlockedUserListBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.setting.BlockedUserListActivity$initView$7
            public void onRetry(IStatusView statusView, Status status) {
                ActivityBlockedUserListBinding binding;
                UserBlockListViewModel viewModel;
                UserBlockListViewModel viewModel2;
                ActivityBlockedUserListBinding binding2;
                UserBlockListViewModel viewModel3;
                UserBlockListViewModel viewModel4;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                binding = BlockedUserListActivity.this.getBinding();
                if (TextUtils.isEmpty(binding.searchEditText.getText().toString())) {
                    viewModel3 = BlockedUserListActivity.this.getViewModel();
                    viewModel3.getBlockedListData().resetPage();
                    viewModel4 = BlockedUserListActivity.this.getViewModel();
                    UserBlockListViewModel.blockList$default(viewModel4, null, 1, null);
                    return;
                }
                viewModel = BlockedUserListActivity.this.getViewModel();
                viewModel.getBlockedListData().resetPage();
                viewModel2 = BlockedUserListActivity.this.getViewModel();
                binding2 = BlockedUserListActivity.this.getBinding();
                viewModel2.blockList(StringsKt.trim(binding2.searchEditText.getText().toString()).toString());
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.remove_user});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.setting.s
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                BlockedUserListActivity.initView$lambda$7(BlockedUserListActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2(BlockedUserListActivity blockedUserListActivity, int i, int i2) {
        blockedUserListActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$4(BlockedUserListActivity blockedUserListActivity, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3 && FastClickOneUtils.INSTANCE.isFastClick() && !TextUtils.isEmpty(blockedUserListActivity.getBinding().searchEditText.getText().toString())) {
            blockedUserListActivity.getViewModel().getBlockedListData().resetPage();
            blockedUserListActivity.getViewModel().blockList(blockedUserListActivity.getBinding().searchEditText.getText().toString());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(BlockedUserListActivity blockedUserListActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (TextUtils.isEmpty(blockedUserListActivity.getBinding().searchEditText.getText().toString())) {
            blockedUserListActivity.getViewModel().getBlockedListData().resetPage();
            UserBlockListViewModel.blockList$default(blockedUserListActivity.getViewModel(), null, 1, null);
        } else {
            blockedUserListActivity.getViewModel().getBlockedListData().resetPage();
            blockedUserListActivity.getViewModel().blockList(StringsKt.trim(blockedUserListActivity.getBinding().searchEditText.getText().toString()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(BlockedUserListActivity blockedUserListActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (TextUtils.isEmpty(blockedUserListActivity.getBinding().searchEditText.getText().toString())) {
            blockedUserListActivity.getViewModel().getBlockedListData().resetPage();
            UserBlockListViewModel.blockList$default(blockedUserListActivity.getViewModel(), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(BlockedUserListActivity blockedUserListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        BlockedInfo blockedInfo = (BlockedInfo) blockedUserListActivity.getMAdapter().getItem(i);
        UserBlockListViewModel viewModel = blockedUserListActivity.getViewModel();
        String externalId = blockedInfo.getUser().getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        viewModel.unmaskUser(i, externalId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserListBlockAdapter mAdapter_delegate$lambda$1() {
        return new UserListBlockAdapter();
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserBlockListViewModel viewModel_delegate$lambda$0(BlockedUserListActivity blockedUserListActivity) {
        return new ViewModelProvider(blockedUserListActivity).get(UserBlockListViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_blocked_user_list;
    }

    @NotNull
    public final UserListBlockAdapter getMAdapter() {
        return (UserListBlockAdapter) this.mAdapter.getValue();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
