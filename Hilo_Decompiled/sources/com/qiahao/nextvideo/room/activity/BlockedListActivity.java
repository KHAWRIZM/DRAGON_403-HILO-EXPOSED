package com.qiahao.nextvideo.room.activity;

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
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.BlockBean;
import com.qiahao.nextvideo.databinding.ActivityRoomBlockedListBinding;
import com.qiahao.nextvideo.room.adapter.GroupMemberBlockAdapter;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.viewmodel.RoomBlockListViewModel;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
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
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u0019H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/room/activity/BlockedListActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRoomBlockedListBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomBlockListViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomBlockListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "mAdapter", "Lcom/qiahao/nextvideo/room/adapter/GroupMemberBlockAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupMemberBlockAdapter;", "mAdapter$delegate", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "onInitialize", "", "initView", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "initData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBlockedListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BlockedListActivity.kt\ncom/qiahao/nextvideo/room/activity/BlockedListActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,206:1\n61#2,9:207\n*S KotlinDebug\n*F\n+ 1 BlockedListActivity.kt\ncom/qiahao/nextvideo/room/activity/BlockedListActivity\n*L\n98#1:207,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BlockedListActivity extends HiloBaseBindingActivity<ActivityRoomBlockedListBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";

    @NotNull
    public static final String TAG = "BlockedListActivity";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.i
        public final Object invoke() {
            RoomBlockListViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = BlockedListActivity.viewModel_delegate$lambda$0(BlockedListActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.j
        public final Object invoke() {
            GroupMemberBlockAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = BlockedListActivity.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    @NotNull
    private String mGroupId = "";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/BlockedListActivity$Companion;", "", "<init>", "()V", "TAG", "", "GROUP_ID", "start", "", "context", "Landroid/content/Context;", "groupId", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent intent = new Intent(context, (Class<?>) BlockedListActivity.class);
            intent.putExtra("group_id", groupId);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomBlockListViewModel getViewModel() {
        return (RoomBlockListViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getBlockedList().observe(this, new BlockedListActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.k
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = BlockedListActivity.initData$lambda$7(BlockedListActivity.this, (List) obj);
                return initData$lambda$7;
            }
        }));
        getViewModel().getMSuccess().observe(this, new BlockedListActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.l
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = BlockedListActivity.initData$lambda$8(BlockedListActivity.this, (Pair) obj);
                return initData$lambda$8;
            }
        }));
        getViewModel().getMException().observe(this, new BlockedListActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.m
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = BlockedListActivity.initData$lambda$9(BlockedListActivity.this, (Pair) obj);
                return initData$lambda$9;
            }
        }));
        RoomBlockListViewModel.blockList$default(getViewModel(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(BlockedListActivity blockedListActivity, List list) {
        blockedListActivity.getMAdapter().setList(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(BlockedListActivity blockedListActivity, Pair pair) {
        if (Intrinsics.areEqual((String) pair.getFirst(), "取消拉黑") && (pair.getSecond() instanceof Integer)) {
            GroupMemberBlockAdapter mAdapter = blockedListActivity.getMAdapter();
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.Int");
            mAdapter.removeAt(((Integer) second).intValue());
            if (blockedListActivity.getMAdapter().getData().isEmpty()) {
                blockedListActivity.getBinding().statusView.showEmpty();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$9(BlockedListActivity blockedListActivity, Pair pair) {
        if (Intrinsics.areEqual((String) pair.getFirst(), "取消拉黑") && (pair.getSecond() instanceof Exception)) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(blockedListActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, blockedListActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityRoomBlockedListBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.room.activity.e
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$2;
                initView$lambda$2 = BlockedListActivity.initView$lambda$2(BlockedListActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$2;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityRoomBlockedListBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        SmartRefreshLayout smartRefreshLayout = ((ActivityRoomBlockedListBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "refreshLayout");
        TextView textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout, Status.Empty.INSTANCE, 2131362075);
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
        }
        RoomBlockListViewModel viewModel = getViewModel();
        String stringExtra = getIntent().getStringExtra("group_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        viewModel.setMGroupId(stringExtra);
        final AppCompatImageView appCompatImageView = ((ActivityRoomBlockedListBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.activity.BlockedListActivity$initView$$inlined$singleClick$default$1
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
        getViewModel().getBlockedListData().registerStatusLayoutAndRefreshLayout(((ActivityRoomBlockedListBinding) getBinding()).refreshLayout, ((ActivityRoomBlockedListBinding) getBinding()).statusView);
        ((ActivityRoomBlockedListBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ActivityRoomBlockedListBinding) getBinding()).searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.room.activity.f
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                boolean initView$lambda$4;
                initView$lambda$4 = BlockedListActivity.initView$lambda$4(BlockedListActivity.this, textView2, i, keyEvent);
                return initView$lambda$4;
            }
        });
        ((ActivityRoomBlockedListBinding) getBinding()).searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.room.activity.BlockedListActivity$initView$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                RoomBlockListViewModel viewModel2;
                if (TextUtils.isEmpty(s) && HiloUtils.INSTANCE.notFastClick()) {
                    viewModel2 = BlockedListActivity.this.getViewModel();
                    RoomBlockListViewModel.blockList$default(viewModel2, null, 1, null);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivityRoomBlockedListBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.activity.g
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                BlockedListActivity.initView$lambda$5(BlockedListActivity.this, fVar);
            }
        });
        ((ActivityRoomBlockedListBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.activity.BlockedListActivity$initView$6
            public void onRetry(IStatusView statusView, Status status) {
                ActivityRoomBlockedListBinding binding;
                RoomBlockListViewModel viewModel2;
                ActivityRoomBlockedListBinding binding2;
                RoomBlockListViewModel viewModel3;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                binding = BlockedListActivity.this.getBinding();
                if (TextUtils.isEmpty(binding.searchEditText.getText().toString())) {
                    viewModel3 = BlockedListActivity.this.getViewModel();
                    RoomBlockListViewModel.blockList$default(viewModel3, null, 1, null);
                } else {
                    viewModel2 = BlockedListActivity.this.getViewModel();
                    binding2 = BlockedListActivity.this.getBinding();
                    viewModel2.blockList(StringsKt.trim(binding2.searchEditText.getText().toString()).toString());
                }
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.remove_user});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.activity.h
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                BlockedListActivity.initView$lambda$6(BlockedListActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2(BlockedListActivity blockedListActivity, int i, int i2) {
        blockedListActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$4(BlockedListActivity blockedListActivity, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3 && FastClickOneUtils.INSTANCE.isFastClick() && !TextUtils.isEmpty(blockedListActivity.getBinding().searchEditText.getText().toString())) {
            blockedListActivity.getViewModel().blockList(blockedListActivity.getBinding().searchEditText.getText().toString());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(BlockedListActivity blockedListActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (TextUtils.isEmpty(blockedListActivity.getBinding().searchEditText.getText().toString())) {
            RoomBlockListViewModel.blockList$default(blockedListActivity.getViewModel(), null, 1, null);
        } else {
            blockedListActivity.getViewModel().blockList(StringsKt.trim(blockedListActivity.getBinding().searchEditText.getText().toString()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(BlockedListActivity blockedListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        BlockBean blockBean = (BlockBean) blockedListActivity.getMAdapter().getItem(i);
        RoomBlockListViewModel viewModel = blockedListActivity.getViewModel();
        String externalId = blockBean.getUserBase().getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        viewModel.unmaskUser(i, externalId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupMemberBlockAdapter mAdapter_delegate$lambda$1() {
        return new GroupMemberBlockAdapter();
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str) {
        INSTANCE.start(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomBlockListViewModel viewModel_delegate$lambda$0(BlockedListActivity blockedListActivity) {
        return new ViewModelProvider(blockedListActivity).get(RoomBlockListViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_room_blocked_list;
    }

    @NotNull
    public final GroupMemberBlockAdapter getMAdapter() {
        return (GroupMemberBlockAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
        }
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }
}
