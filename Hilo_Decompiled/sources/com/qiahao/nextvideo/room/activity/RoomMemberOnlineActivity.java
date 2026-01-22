package com.qiahao.nextvideo.room.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.databinding.ActivityRoomMemberBinding;
import com.qiahao.nextvideo.room.adapter.GroupMemberOnlineAdapter;
import com.qiahao.nextvideo.room.dialog.FiltrateUserDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.viewmodel.RoomUserViewModel;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0007J\b\u0010\u001a\u001a\u00020\u0013H\u0014R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomMemberOnlineActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRoomMemberBinding;", "<init>", "()V", "getLayoutResId", "", "mViewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomUserViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomUserViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/room/adapter/GroupMemberOnlineAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupMemberOnlineAdapter;", "mAdapter$delegate", "onInitialize", "", "onRoomEvent", "event", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "initData", "initView", "refreshTitle", "onPause", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomMemberOnlineActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomMemberOnlineActivity.kt\ncom/qiahao/nextvideo/room/activity/RoomMemberOnlineActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,269:1\n61#2,9:270\n61#2,9:279\n*S KotlinDebug\n*F\n+ 1 RoomMemberOnlineActivity.kt\ncom/qiahao/nextvideo/room/activity/RoomMemberOnlineActivity\n*L\n152#1:270,9\n155#1:279,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomMemberOnlineActivity extends HiloBaseBindingActivity<ActivityRoomMemberBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";
    public static final int INTENT_RESULT_TAP = 3;

    @NotNull
    public static final String IS_AT_USER = "is_at_user";

    @NotNull
    public static final String VISITOR_USER = "visitor_user";

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.o1
        public final Object invoke() {
            RoomUserViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = RoomMemberOnlineActivity.mViewModel_delegate$lambda$0(RoomMemberOnlineActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.p1
        public final Object invoke() {
            GroupMemberOnlineAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = RoomMemberOnlineActivity.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomMemberOnlineActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "groupId", "", "isVisitor", "", "GROUP_ID", "IS_AT_USER", "VISITOR_USER", "INTENT_RESULT_TAP", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.start(context, str, z);
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId, boolean isVisitor) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent intent = new Intent(context, (Class<?>) RoomMemberOnlineActivity.class);
            intent.putExtra("group_id", groupId);
            intent.putExtra(RoomMemberOnlineActivity.VISITOR_USER, isVisitor);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final GroupMemberOnlineAdapter getMAdapter() {
        return (GroupMemberOnlineAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomUserViewModel getMViewModel() {
        return (RoomUserViewModel) this.mViewModel.getValue();
    }

    private final void initData() {
        getMViewModel().getUserList().observe(this, new RoomMemberOnlineActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.activity.n1
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = RoomMemberOnlineActivity.initData$lambda$2(RoomMemberOnlineActivity.this, (List) obj);
                return initData$lambda$2;
            }
        }));
        RoomUserViewModel.requestUserList$default(getMViewModel(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$2(RoomMemberOnlineActivity roomMemberOnlineActivity, List list) {
        Integer mRole = roomMemberOnlineActivity.getMViewModel().getMRole();
        if (mRole != null && mRole.intValue() == 100) {
            Intrinsics.checkNotNull(list);
            if (!list.isEmpty()) {
                MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().openUseInfoEvent(((MemberBean) list.get(0)).getExternalId()));
                roomMemberOnlineActivity.finish();
                return Unit.INSTANCE;
            }
        }
        if (roomMemberOnlineActivity.getMViewModel().getUserListData().isOnePage()) {
            roomMemberOnlineActivity.getMAdapter().setList(list);
        } else {
            GroupMemberOnlineAdapter mAdapter = roomMemberOnlineActivity.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter.addData(list);
        }
        roomMemberOnlineActivity.refreshTitle();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityRoomMemberBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.room.activity.i1
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$3;
                initView$lambda$3 = RoomMemberOnlineActivity.initView$lambda$3(RoomMemberOnlineActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$3;
            }
        });
        setStatusBarIconColor(false);
        RoomUserViewModel mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra("group_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        mViewModel.setMGroupId(stringExtra);
        getMViewModel().setMIsVisitorUser(getIntent().getBooleanExtra(VISITOR_USER, false));
        getMViewModel().setMIsAtUser(getIntent().getBooleanExtra(IS_AT_USER, false));
        if (getMViewModel().getMIsVisitorUser()) {
            ((ActivityRoomMemberBinding) getBinding()).title.setText(getString(2131954461));
            ((ActivityRoomMemberBinding) getBinding()).more.setVisibility(0);
            ((ActivityRoomMemberBinding) getBinding()).searchLinearLayout.setVisibility(0);
        } else {
            ((ActivityRoomMemberBinding) getBinding()).title.setText(getString(2131953008));
            ((ActivityRoomMemberBinding) getBinding()).more.setVisibility(8);
            ((ActivityRoomMemberBinding) getBinding()).searchLinearLayout.setVisibility(8);
        }
        ((ActivityRoomMemberBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ActivityRoomMemberBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        SmartRefreshLayout smartRefreshLayout = ((ActivityRoomMemberBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "refreshLayout");
        TextView textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout, Status.Empty.INSTANCE, 2131362075);
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
        }
        getMViewModel().getUserListData().registerStatusLayoutAndRefreshLayout(((ActivityRoomMemberBinding) getBinding()).refreshLayout, ((ActivityRoomMemberBinding) getBinding()).statusView);
        final AppCompatImageView appCompatImageView = ((ActivityRoomMemberBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity$initView$$inlined$singleClick$default$1
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
        final AppCompatImageView appCompatImageView2 = ((ActivityRoomMemberBinding) getBinding()).more;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    FiltrateUserDialog filtrateUserDialog = new FiltrateUserDialog(this);
                    final RoomMemberOnlineActivity roomMemberOnlineActivity = this;
                    filtrateUserDialog.setListener(new FiltrateUserDialog.FiltrateUserDialogListener() { // from class: com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity$initView$3$1$1
                        @Override // com.qiahao.nextvideo.room.dialog.FiltrateUserDialog.FiltrateUserDialogListener
                        public void clickButton(int type, String title) {
                            RoomUserViewModel mViewModel2;
                            RoomUserViewModel mViewModel3;
                            RoomUserViewModel mViewModel4;
                            RoomUserViewModel mViewModel5;
                            ActivityRoomMemberBinding binding;
                            ActivityRoomMemberBinding binding2;
                            Intrinsics.checkNotNullParameter(title, "title");
                            mViewModel2 = RoomMemberOnlineActivity.this.getMViewModel();
                            mViewModel2.setMRole(Integer.valueOf(type));
                            mViewModel3 = RoomMemberOnlineActivity.this.getMViewModel();
                            mViewModel3.setMTitle(title);
                            mViewModel4 = RoomMemberOnlineActivity.this.getMViewModel();
                            mViewModel4.getUserListData().resetPage();
                            mViewModel5 = RoomMemberOnlineActivity.this.getMViewModel();
                            RoomUserViewModel.requestUserList$default(mViewModel5, null, 1, null);
                            binding = RoomMemberOnlineActivity.this.getBinding();
                            binding.searchEditText.setText("");
                            binding2 = RoomMemberOnlineActivity.this.getBinding();
                            binding2.searchLinearLayout.setVisibility(8);
                        }
                    });
                    filtrateUserDialog.show();
                }
            }
        });
        ((ActivityRoomMemberBinding) getBinding()).searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.room.activity.j1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                boolean initView$lambda$7;
                initView$lambda$7 = RoomMemberOnlineActivity.initView$lambda$7(RoomMemberOnlineActivity.this, textView2, i, keyEvent);
                return initView$lambda$7;
            }
        });
        ((ActivityRoomMemberBinding) getBinding()).searchEditText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity$initView$5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                RoomUserViewModel mViewModel2;
                RoomUserViewModel mViewModel3;
                ActivityRoomMemberBinding binding;
                if (TextUtils.isEmpty(s) && HiloUtils.INSTANCE.notFastClick()) {
                    mViewModel2 = RoomMemberOnlineActivity.this.getMViewModel();
                    mViewModel2.getUserListData().resetPage();
                    mViewModel3 = RoomMemberOnlineActivity.this.getMViewModel();
                    binding = RoomMemberOnlineActivity.this.getBinding();
                    mViewModel3.requestUserList(StringsKt.trim(binding.searchEditText.getText().toString()).toString());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivityRoomMemberBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.activity.k1
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                RoomMemberOnlineActivity.initView$lambda$8(RoomMemberOnlineActivity.this, fVar);
            }
        });
        ((ActivityRoomMemberBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.room.activity.l1
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                RoomMemberOnlineActivity.initView$lambda$9(RoomMemberOnlineActivity.this, fVar);
            }
        });
        ((ActivityRoomMemberBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity$initView$8
            public void onRetry(IStatusView statusView, Status status) {
                ActivityRoomMemberBinding binding;
                RoomUserViewModel mViewModel2;
                RoomUserViewModel mViewModel3;
                ActivityRoomMemberBinding binding2;
                RoomUserViewModel mViewModel4;
                RoomUserViewModel mViewModel5;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                binding = RoomMemberOnlineActivity.this.getBinding();
                if (TextUtils.isEmpty(binding.searchEditText.getText().toString())) {
                    mViewModel4 = RoomMemberOnlineActivity.this.getMViewModel();
                    mViewModel4.getUserListData().resetPage();
                    mViewModel5 = RoomMemberOnlineActivity.this.getMViewModel();
                    RoomUserViewModel.requestUserList$default(mViewModel5, null, 1, null);
                    return;
                }
                mViewModel2 = RoomMemberOnlineActivity.this.getMViewModel();
                mViewModel2.getUserListData().resetPage();
                mViewModel3 = RoomMemberOnlineActivity.this.getMViewModel();
                binding2 = RoomMemberOnlineActivity.this.getBinding();
                mViewModel3.requestUserList(StringsKt.trim(binding2.searchEditText.getText().toString()).toString());
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.activity.m1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                RoomMemberOnlineActivity.initView$lambda$10(RoomMemberOnlineActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$10(RoomMemberOnlineActivity roomMemberOnlineActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MemberBean memberBean = (MemberBean) roomMemberOnlineActivity.getMAdapter().getData().get(i);
        if (roomMemberOnlineActivity.getMViewModel().getMIsAtUser()) {
            SvipData svip = memberBean.getSvip();
            if (svip != null && !svip.isMystery()) {
                Intent intent = roomMemberOnlineActivity.getIntent();
                intent.putExtra("user_name", memberBean.getNick());
                intent.putExtra("user_id", memberBean.getExternalId());
                roomMemberOnlineActivity.setResult(-1, intent);
                roomMemberOnlineActivity.finish();
                return;
            }
            return;
        }
        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().openUseInfoEvent(memberBean.getExternalId()));
        roomMemberOnlineActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$3(RoomMemberOnlineActivity roomMemberOnlineActivity, int i, int i2) {
        roomMemberOnlineActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$7(RoomMemberOnlineActivity roomMemberOnlineActivity, TextView textView, int i, KeyEvent keyEvent) {
        if ((i == 3 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) && FastClickOneUtils.INSTANCE.isFastClick() && !TextUtils.isEmpty(roomMemberOnlineActivity.getBinding().searchEditText.getText().toString())) {
            roomMemberOnlineActivity.getMViewModel().getUserListData().resetPage();
            roomMemberOnlineActivity.getMViewModel().requestUserList(roomMemberOnlineActivity.getBinding().searchEditText.getText().toString());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(RoomMemberOnlineActivity roomMemberOnlineActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (TextUtils.isEmpty(roomMemberOnlineActivity.getBinding().searchEditText.getText().toString())) {
            roomMemberOnlineActivity.getMViewModel().getUserListData().resetPage();
            RoomUserViewModel.requestUserList$default(roomMemberOnlineActivity.getMViewModel(), null, 1, null);
        } else {
            roomMemberOnlineActivity.getMViewModel().getUserListData().resetPage();
            roomMemberOnlineActivity.getMViewModel().requestUserList(StringsKt.trim(roomMemberOnlineActivity.getBinding().searchEditText.getText().toString()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(RoomMemberOnlineActivity roomMemberOnlineActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (TextUtils.isEmpty(roomMemberOnlineActivity.getBinding().searchEditText.getText().toString())) {
            RoomUserViewModel.requestUserList$default(roomMemberOnlineActivity.getMViewModel(), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupMemberOnlineAdapter mAdapter_delegate$lambda$1() {
        return new GroupMemberOnlineAdapter(R.layout.item_group_member_online);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomUserViewModel mViewModel_delegate$lambda$0(RoomMemberOnlineActivity roomMemberOnlineActivity) {
        return new ViewModelProvider(roomMemberOnlineActivity).get(RoomUserViewModel.class);
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str, boolean z) {
        INSTANCE.start(context, str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_room_member;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        hideSoftInput();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void refreshTitle() {
        if (getMViewModel().getMIsVisitorUser()) {
            Integer mRole = getMViewModel().getMRole();
            if (mRole != null && mRole.intValue() == 0) {
                ((ActivityRoomMemberBinding) getBinding()).title.setText(getString(2131954461) + "(" + getMViewModel().getMOnLine() + "/" + getMViewModel().getMTotal() + ")");
                return;
            }
            ((ActivityRoomMemberBinding) getBinding()).title.setText(getMViewModel().getMTitle() + "(" + getMViewModel().getMTotal() + ")");
            return;
        }
        ((ActivityRoomMemberBinding) getBinding()).title.setText(getString(2131953008) + "(" + getMViewModel().getMOnLine() + "/" + getMViewModel().getMTotal() + ")");
    }
}
