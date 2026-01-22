package com.qiahao.nextvideo.ui.friends;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityCommonListWithRefreshBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/friends/FriendsChoseActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCommonListWithRefreshBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/friends/FriendsChoseViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/friends/FriendsChoseViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/friends/FriendsListAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/friends/FriendsListAdapter;", "mAdapter$delegate", "isCheck", "", "()Z", "setCheck", "(Z)V", "getLayoutResId", "", "onInitialize", "", "checkShare", "bean", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FriendsChoseActivity extends HiloBaseBindingActivity<ActivityCommonListWithRefreshBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int REQUEST_CODE = 4609;
    private boolean isCheck;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.friends.i
        public final Object invoke() {
            FriendsChoseViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FriendsChoseActivity.viewModel_delegate$lambda$0(FriendsChoseActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.friends.j
        public final Object invoke() {
            FriendsListAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = FriendsChoseActivity.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007J>\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/friends/FriendsChoseActivity$Companion;", "", "<init>", "()V", "REQUEST_CODE", "", "startForResult", "", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/app/Activity;", "maxNum", "onParseActivityResult", "requestCode", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onResult", "Lkotlin/Function1;", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startForResult$default(Companion companion, Activity activity, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 1;
            }
            companion.startForResult(activity, i);
        }

        @JvmStatic
        public final void onParseActivityResult(int requestCode, int resultCode, @Nullable Intent data, @Nullable Function1<? super List<String>, Unit> onResult) {
            if (resultCode == -1 && requestCode == FriendsChoseActivity.REQUEST_CODE && data != null) {
                ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("friend_ids");
                if (stringArrayListExtra == null) {
                    stringArrayListExtra = new ArrayList<>();
                }
                if (onResult != null) {
                    onResult.invoke(stringArrayListExtra);
                }
            }
        }

        @JvmStatic
        public final void startForResult(@NotNull Activity activity, int maxNum) {
            Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
            Intent intent = new Intent(activity, (Class<?>) FriendsChoseActivity.class);
            intent.putExtra("maxNum", maxNum);
            activity.startActivityForResult(intent, FriendsChoseActivity.REQUEST_CODE);
        }

        private Companion() {
        }
    }

    private final void checkShare(final ContactsLikeEachItem bean) {
        if (this.isCheck) {
            return;
        }
        this.isCheck = true;
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().checkShare(bean.getUserBase().getExternalId(), 0, 1), new Function1() { // from class: com.qiahao.nextvideo.ui.friends.g
            public final Object invoke(Object obj) {
                Unit checkShare$lambda$10;
                checkShare$lambda$10 = FriendsChoseActivity.checkShare$lambda$10(FriendsChoseActivity.this, bean, (ApiResponse) obj);
                return checkShare$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.friends.h
            public final Object invoke(Object obj) {
                Unit checkShare$lambda$11;
                checkShare$lambda$11 = FriendsChoseActivity.checkShare$lambda$11(FriendsChoseActivity.this, (Throwable) obj);
                return checkShare$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit checkShare$lambda$10(FriendsChoseActivity friendsChoseActivity, ContactsLikeEachItem contactsLikeEachItem, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Intent intent = new Intent();
        intent.putStringArrayListExtra("friend_ids", CollectionsKt.arrayListOf(new String[]{contactsLikeEachItem.getUserBase().getExternalId()}));
        Unit unit = Unit.INSTANCE;
        friendsChoseActivity.setResult(-1, intent);
        friendsChoseActivity.isCheck = false;
        friendsChoseActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit checkShare$lambda$11(FriendsChoseActivity friendsChoseActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(friendsChoseActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, friendsChoseActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        friendsChoseActivity.isCheck = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FriendsListAdapter mAdapter_delegate$lambda$1() {
        return new FriendsListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(FriendsChoseActivity friendsChoseActivity, int i, int i2) {
        friendsChoseActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(FriendsChoseActivity friendsChoseActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        friendsChoseActivity.checkShare((ContactsLikeEachItem) friendsChoseActivity.getMAdapter().getItem(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$6(FriendsChoseActivity friendsChoseActivity, List list) {
        if (friendsChoseActivity.getViewModel().getBaseListData().isOnePage()) {
            friendsChoseActivity.getMAdapter().setList(list);
        } else {
            FriendsListAdapter mAdapter = friendsChoseActivity.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter.addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$7(FriendsChoseActivity friendsChoseActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        friendsChoseActivity.getViewModel().getBaseListData().resetPage();
        friendsChoseActivity.getViewModel().getFriendData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$8(FriendsChoseActivity friendsChoseActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        friendsChoseActivity.getViewModel().getFriendData();
    }

    @JvmStatic
    public static final void onParseActivityResult(int i, int i2, @Nullable Intent intent, @Nullable Function1<? super List<String>, Unit> function1) {
        INSTANCE.onParseActivityResult(i, i2, intent, function1);
    }

    @JvmStatic
    public static final void startForResult(@NotNull Activity activity, int i) {
        INSTANCE.startForResult(activity, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FriendsChoseViewModel viewModel_delegate$lambda$0(FriendsChoseActivity friendsChoseActivity) {
        return new ViewModelProvider(friendsChoseActivity).get(FriendsChoseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_common_list_with_refresh;
    }

    @NotNull
    public final FriendsListAdapter getMAdapter() {
        return (FriendsListAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final FriendsChoseViewModel getViewModel() {
        return (FriendsChoseViewModel) this.viewModel.getValue();
    }

    /* renamed from: isCheck, reason: from getter */
    public final boolean getIsCheck() {
        return this.isCheck;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = ((ActivityCommonListWithRefreshBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.friends.a
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = FriendsChoseActivity.onInitialize$lambda$2(FriendsChoseActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        ((ActivityCommonListWithRefreshBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.friends.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FriendsChoseActivity.this.onBackPressed();
            }
        });
        ((ActivityCommonListWithRefreshBinding) getBinding()).titleBar.title.setText(2131952370);
        RecyclerView recyclerView = ((ActivityCommonListWithRefreshBinding) getBinding()).recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(getMAdapter());
        getViewModel().getBaseListData().registerStatusLayoutAndRefreshLayout(((ActivityCommonListWithRefreshBinding) getBinding()).refreshLayout, ((ActivityCommonListWithRefreshBinding) getBinding()).statusView);
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.friends.c
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                FriendsChoseActivity.onInitialize$lambda$5(FriendsChoseActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getViewModel().getListLiveData().observe(this, new FriendsChoseActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.friends.d
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$6;
                onInitialize$lambda$6 = FriendsChoseActivity.onInitialize$lambda$6(FriendsChoseActivity.this, (List) obj);
                return onInitialize$lambda$6;
            }
        }));
        ((ActivityCommonListWithRefreshBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.friends.e
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FriendsChoseActivity.onInitialize$lambda$7(FriendsChoseActivity.this, fVar);
            }
        });
        ((ActivityCommonListWithRefreshBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.friends.f
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                FriendsChoseActivity.onInitialize$lambda$8(FriendsChoseActivity.this, fVar);
            }
        });
        ((ActivityCommonListWithRefreshBinding) getBinding()).refreshLayout.autoRefresh();
    }

    public final void setCheck(boolean z) {
        this.isCheck = z;
    }
}
