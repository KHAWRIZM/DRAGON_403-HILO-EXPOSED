package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.databinding.ActivityRoomMemberOnlineBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.adapter.GroupMemberAdminAdapter;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
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
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u00015B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0007J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R2\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\"j\b\u0012\u0004\u0012\u00020\u001b`#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomMemberAdminActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRoomMemberOnlineBinding;", "Landroid/view/View$OnClickListener;", "Lcom/chad/library/adapter/base/listener/OnLoadMoreListener;", "Lvc/g;", "<init>", "()V", "", "initRecycle", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "event", "onRoomEvent", "(Lcom/qiahao/nextvideo/room/manager/RoomEvent;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "onLoadMore", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "", "mGroupId", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mHasUserList", "Ljava/util/ArrayList;", "getMHasUserList", "()Ljava/util/ArrayList;", "setMHasUserList", "(Ljava/util/ArrayList;)V", "Lcom/qiahao/nextvideo/room/adapter/GroupMemberAdminAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/GroupMemberAdminAdapter;", "mAdapter", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomMemberAdminActivity extends HiloBaseBindingActivity<ActivityRoomMemberOnlineBinding> implements View.OnClickListener, OnLoadMoreListener, vc.g {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";

    @NotNull
    public static final String Group_HAS_SELECT_USER = "group_has_select_user";

    @NotNull
    private static final String TAG = "RoomMemberAdminActivity";

    @NotNull
    private String mGroupId = "";

    @NotNull
    private ArrayList<String> mHasUserList = new ArrayList<>();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.e1
        public final Object invoke() {
            GroupMemberAdminAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = RoomMemberAdminActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.f1
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$1;
            mViewModel_delegate$lambda$1 = RoomMemberAdminActivity.mViewModel_delegate$lambda$1(RoomMemberAdminActivity.this);
            return mViewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\fH\u0007R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/RoomMemberAdminActivity$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "groupId", "", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "GROUP_ID", "Group_HAS_SELECT_USER", "TAG", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void startActivity(@NotNull Context context, @NotNull String groupId, @NotNull ArrayList<String> userList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(userList, "userList");
            Intent intent = new Intent(context, (Class<?>) RoomMemberAdminActivity.class);
            intent.putExtra("group_id", groupId);
            intent.putExtra(RoomMemberAdminActivity.Group_HAS_SELECT_USER, userList);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    private final void initRecycle() {
        getBinding().smartRefreshLayout.setEnableLoadMore(false);
        RecyclerView recyclerView = getBinding().recyclerManager;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.activity.d1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomMemberAdminActivity.initRecycle$lambda$6(RoomMemberAdminActivity.this, baseQuickAdapter, view, i);
            }
        });
        getBinding().smartRefreshLayout.autoRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycle$lambda$6(final RoomMemberAdminActivity roomMemberAdminActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MemberBean");
            final MemberBean memberBean = (MemberBean) item;
            if (roomMemberAdminActivity.mHasUserList.contains(memberBean.getExternalId())) {
                Log.d(TAG, "initRecycle: 已经选择过该人 不能再选了~~~~");
            } else {
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkAdminSupportGetAward(roomMemberAdminActivity.mGroupId, memberBean.getExternalId()), new Function1() { // from class: com.qiahao.nextvideo.room.activity.b1
                    public final Object invoke(Object obj) {
                        Unit initRecycle$lambda$6$lambda$4;
                        initRecycle$lambda$6$lambda$4 = RoomMemberAdminActivity.initRecycle$lambda$6$lambda$4(RoomMemberAdminActivity.this, memberBean, (ApiResponse) obj);
                        return initRecycle$lambda$6$lambda$4;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.c1
                    public final Object invoke(Object obj) {
                        Unit initRecycle$lambda$6$lambda$5;
                        initRecycle$lambda$6$lambda$5 = RoomMemberAdminActivity.initRecycle$lambda$6$lambda$5(RoomMemberAdminActivity.this, memberBean, (Throwable) obj);
                        return initRecycle$lambda$6$lambda$5;
                    }
                }, (Function0) null, false, 12, (Object) null), roomMemberAdminActivity.getMViewModel().getMCompositeDisposable());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initRecycle$lambda$6$lambda$4(RoomMemberAdminActivity roomMemberAdminActivity, MemberBean memberBean, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Log.d(TAG, "initRecycle: " + apiResponse);
            Intent intent = roomMemberAdminActivity.getIntent();
            intent.putExtra("member_bean", memberBean);
            roomMemberAdminActivity.setResult(-1, intent);
            roomMemberAdminActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initRecycle$lambda$6$lambda$5(RoomMemberAdminActivity roomMemberAdminActivity, MemberBean memberBean, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 14018 && code != 14019) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = roomMemberAdminActivity.getString(2131952667);
                    Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, roomMemberAdminActivity, errorMessage, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            } else {
                HiloToasty.Companion companion2 = HiloToasty.Companion;
                String string = roomMemberAdminActivity.getString(2131953006, memberBean.getNick());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, roomMemberAdminActivity, string, false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            HiloToasty.Companion companion3 = HiloToasty.Companion;
            String string2 = roomMemberAdminActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion3, roomMemberAdminActivity, string2, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        Log.d(TAG, "initRecycle: " + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupMemberAdminAdapter mAdapter_delegate$lambda$0() {
        return new GroupMemberAdminAdapter(R.layout.item_group_member_admin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$1(RoomMemberAdminActivity roomMemberAdminActivity) {
        return new ViewModelProvider(roomMemberAdminActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(RoomMemberAdminActivity roomMemberAdminActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = roomMemberAdminActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$7(RoomMemberAdminActivity roomMemberAdminActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomMemberAdminActivity.getBinding().smartRefreshLayout.finishRefresh();
        roomMemberAdminActivity.getMAdapter().setList((Collection) apiResponse.getData());
        roomMemberAdminActivity.getBinding().emptyTipTextView.setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefresh$lambda$8(RoomMemberAdminActivity roomMemberAdminActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomMemberAdminActivity.getBinding().smartRefreshLayout.finishRefresh();
        roomMemberAdminActivity.getBinding().emptyTipTextView.setVisibility(0);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void startActivity(@NotNull Context context, @NotNull String str, @NotNull ArrayList<String> arrayList) {
        INSTANCE.startActivity(context, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_room_member_online;
    }

    @NotNull
    public final GroupMemberAdminAdapter getMAdapter() {
        return (GroupMemberAdminAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @NotNull
    public final ArrayList<String> getMHasUserList() {
        return this.mHasUserList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == 2131362039) {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityRoomMemberOnlineBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.a1
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = RoomMemberAdminActivity.onInitialize$lambda$2(RoomMemberAdminActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityRoomMemberOnlineBinding) getBinding()).setClick(this);
        String stringExtra = getIntent().getStringExtra("group_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mGroupId = stringExtra;
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(Group_HAS_SELECT_USER);
        if (stringArrayListExtra == null) {
            stringArrayListExtra = new ArrayList<>();
        }
        this.mHasUserList = stringArrayListExtra;
        ((ActivityRoomMemberOnlineBinding) getBinding()).smartRefreshLayout.setOnRefreshListener(this);
        ((ActivityRoomMemberOnlineBinding) getBinding()).title.setText(getString(2131952947));
        initRecycle();
    }

    public void onLoadMore() {
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomAdminMember(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.activity.g1
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$7;
                onRefresh$lambda$7 = RoomMemberAdminActivity.onRefresh$lambda$7(RoomMemberAdminActivity.this, (ApiResponse) obj);
                return onRefresh$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.h1
            public final Object invoke(Object obj) {
                Unit onRefresh$lambda$8;
                onRefresh$lambda$8 = RoomMemberAdminActivity.onRefresh$lambda$8(RoomMemberAdminActivity.this, (Throwable) obj);
                return onRefresh$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMViewModel().getMCompositeDisposable());
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

    public final void setMHasUserList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mHasUserList = arrayList;
    }
}
