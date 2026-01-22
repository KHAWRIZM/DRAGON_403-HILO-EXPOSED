package com.qiahao.nextvideo.share;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.LikeMeGuyItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ShareChildLikeMeContactsBinding;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001IB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\u0017R\"\u0010/\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010%\u001a\u0004\b0\u0010'\"\u0004\b1\u0010)R\"\u00102\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-\"\u0004\b4\u0010\u0017R\u001b\u0010:\u001a\u0002058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/qiahao/nextvideo/share/GroupShareLikeMeChildView;", "Landroid/widget/FrameLayout;", "Lvc/e;", "Lvc/g;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "mContext", "", "mGroupId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "initRecycle", "()V", "getFirstData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", "selectAll", "setIsSelectAll", "(Z)V", "onDetachedFromWindow", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "hasNextData", "Z", "getHasNextData", "()Z", "setHasNextData", "mPageSize", "getMPageSize", "setMPageSize", "hasSelectAll", "getHasSelectAll", "setHasSelectAll", "Lcom/qiahao/nextvideo/share/ContactsLikeMeAdapter;", "mContactsLikeMeAdapter$delegate", "Lkotlin/Lazy;", "getMContactsLikeMeAdapter", "()Lcom/qiahao/nextvideo/share/ContactsLikeMeAdapter;", "mContactsLikeMeAdapter", "Lcom/qiahao/nextvideo/databinding/ShareChildLikeMeContactsBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ShareChildLikeMeContactsBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ShareChildLikeMeContactsBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ShareChildLikeMeContactsBinding;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupShareLikeMeChildView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupShareLikeMeChildView.kt\ncom/qiahao/nextvideo/share/GroupShareLikeMeChildView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,205:1\n1869#2,2:206\n*S KotlinDebug\n*F\n+ 1 GroupShareLikeMeChildView.kt\ncom/qiahao/nextvideo/share/GroupShareLikeMeChildView\n*L\n160#1:206,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupShareLikeMeChildView extends FrameLayout implements vc.e, vc.g, View.OnClickListener {

    @NotNull
    private static final String TAG = "ShareLikeMeChildView";

    @NotNull
    private ShareChildLikeMeContactsBinding binding;
    private boolean hasNextData;
    private boolean hasSelectAll;

    @NotNull
    private nd.a mCompositeDisposable;

    /* renamed from: mContactsLikeMeAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContactsLikeMeAdapter;

    @NotNull
    private final Context mContext;

    @NotNull
    private final String mGroupId;
    private int mPageIndex;
    private int mPageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupShareLikeMeChildView(@NotNull Context context, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        this.mContext = context;
        this.mGroupId = str;
        this.mPageIndex = 1;
        this.mPageSize = 20;
        this.mContactsLikeMeAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.share.n
            public final Object invoke() {
                ContactsLikeMeAdapter mContactsLikeMeAdapter_delegate$lambda$0;
                mContactsLikeMeAdapter_delegate$lambda$0 = GroupShareLikeMeChildView.mContactsLikeMeAdapter_delegate$lambda$0();
                return mContactsLikeMeAdapter_delegate$lambda$0;
            }
        });
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(context), R.layout.share_child_like_me_contacts, this, true);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        this.binding = (ShareChildLikeMeContactsBinding) h;
        this.mCompositeDisposable = new nd.a();
        this.binding.setClick(this);
        this.binding.smartRefreshLayout.setOnLoadMoreListener(this);
        this.binding.smartRefreshLayout.setOnRefreshListener(this);
        initRecycle();
    }

    private final void getFirstData() {
        this.mPageIndex = 1;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchLikeMeList$default(UserService.INSTANCE.getShared(), this.mPageIndex, this.mPageSize, false, 4, null), new Function1() { // from class: com.qiahao.nextvideo.share.i
            public final Object invoke(Object obj) {
                Unit firstData$lambda$3;
                firstData$lambda$3 = GroupShareLikeMeChildView.getFirstData$lambda$3(GroupShareLikeMeChildView.this, (ApiResponse) obj);
                return firstData$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.share.j
            public final Object invoke(Object obj) {
                Unit firstData$lambda$4;
                firstData$lambda$4 = GroupShareLikeMeChildView.getFirstData$lambda$4(GroupShareLikeMeChildView.this, (Throwable) obj);
                return firstData$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstData$lambda$3(GroupShareLikeMeChildView groupShareLikeMeChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        groupShareLikeMeChildView.binding.smartRefreshLayout.finishRefresh();
        boolean z = true;
        groupShareLikeMeChildView.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            groupShareLikeMeChildView.binding.emptyTipTextView.setVisibility(8);
            List list = (List) apiResponse.getData();
            if (list == null || list.size() != 20) {
                z = false;
            }
            groupShareLikeMeChildView.hasNextData = z;
            groupShareLikeMeChildView.getMContactsLikeMeAdapter().setList((Collection) apiResponse.getData());
        } else {
            groupShareLikeMeChildView.hasNextData = false;
        }
        groupShareLikeMeChildView.binding.smartRefreshLayout.setEnableLoadMore(groupShareLikeMeChildView.hasNextData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstData$lambda$4(GroupShareLikeMeChildView groupShareLikeMeChildView, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        groupShareLikeMeChildView.binding.smartRefreshLayout.finishRefresh();
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = groupShareLikeMeChildView.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(groupShareLikeMeChildView, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void initRecycle() {
        this.binding.smartRefreshLayout.setEnableLoadMore(this.hasNextData);
        RecyclerView recyclerView = this.binding.recyclerManager;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMContactsLikeMeAdapter());
        getMContactsLikeMeAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.share.k
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GroupShareLikeMeChildView.initRecycle$lambda$2(GroupShareLikeMeChildView.this, baseQuickAdapter, view, i);
            }
        });
        this.binding.smartRefreshLayout.autoRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycle$lambda$2(GroupShareLikeMeChildView groupShareLikeMeChildView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.LikeMeGuyItem");
        LikeMeGuyItem likeMeGuyItem = (LikeMeGuyItem) item;
        ArrayList<String> hasSelectList = groupShareLikeMeChildView.getMContactsLikeMeAdapter().getHasSelectList();
        User user = likeMeGuyItem.getUser();
        String str3 = null;
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (CollectionsKt.contains(hasSelectList, str)) {
            ArrayList<String> hasSelectList2 = groupShareLikeMeChildView.getMContactsLikeMeAdapter().getHasSelectList();
            User user2 = likeMeGuyItem.getUser();
            if (user2 != null) {
                str3 = user2.getExternalId();
            }
            TypeIntrinsics.asMutableCollection(hasSelectList2).remove(str3);
        } else {
            ArrayList<String> hasSelectList3 = groupShareLikeMeChildView.getMContactsLikeMeAdapter().getHasSelectList();
            User user3 = likeMeGuyItem.getUser();
            if (user3 == null || (str2 = user3.getExternalId()) == null) {
                str2 = "";
            }
            hasSelectList3.add(str2);
        }
        groupShareLikeMeChildView.getMContactsLikeMeAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactsLikeMeAdapter mContactsLikeMeAdapter_delegate$lambda$0() {
        return new ContactsLikeMeAdapter(R.layout.item_contact_like_me_other, false, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$10(GroupShareLikeMeChildView groupShareLikeMeChildView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, groupShareLikeMeChildView.getContext(), ResourcesKtxKt.getStringById(groupShareLikeMeChildView, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$9(GroupShareLikeMeChildView groupShareLikeMeChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Context context = groupShareLikeMeChildView.mContext;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).finish();
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, groupShareLikeMeChildView.getContext(), ResourcesKtxKt.getStringById(groupShareLikeMeChildView, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, groupShareLikeMeChildView.getContext(), ResourcesKtxKt.getStringById(groupShareLikeMeChildView, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$6(GroupShareLikeMeChildView groupShareLikeMeChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        boolean z = true;
        groupShareLikeMeChildView.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List list = (List) apiResponse.getData();
            if (list == null || list.size() != 20) {
                z = false;
            }
            groupShareLikeMeChildView.hasNextData = z;
            List list2 = (List) apiResponse.getData();
            if (list2 != null) {
                groupShareLikeMeChildView.getMContactsLikeMeAdapter().addData(list2);
            }
        } else {
            groupShareLikeMeChildView.hasNextData = false;
        }
        groupShareLikeMeChildView.binding.smartRefreshLayout.setEnableLoadMore(groupShareLikeMeChildView.hasNextData);
        groupShareLikeMeChildView.binding.smartRefreshLayout.finishLoadMore();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$7(GroupShareLikeMeChildView groupShareLikeMeChildView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(groupShareLikeMeChildView, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        groupShareLikeMeChildView.binding.smartRefreshLayout.finishLoadMore();
        return Unit.INSTANCE;
    }

    @NotNull
    public final ShareChildLikeMeContactsBinding getBinding() {
        return this.binding;
    }

    public final boolean getHasNextData() {
        return this.hasNextData;
    }

    public final boolean getHasSelectAll() {
        return this.hasSelectAll;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final ContactsLikeMeAdapter getMContactsLikeMeAdapter() {
        return (ContactsLikeMeAdapter) this.mContactsLikeMeAdapter.getValue();
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == 2131362424) {
            if (!this.hasSelectAll && getMContactsLikeMeAdapter().getHasSelectList().isEmpty()) {
                Log.d(TAG, "onClick: 没有选择任何人");
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (!this.hasSelectAll) {
                Iterator<T> it = getMContactsLikeMeAdapter().getHasSelectList().iterator();
                while (it.hasNext()) {
                    sb2.append((String) it.next());
                    sb2.append(",");
                }
            }
            Log.d(TAG, "onClick: " + ((Object) sb2) + "  " + this.hasSelectAll + "   shareRoomToLikeMe");
            UserService shared = UserService.INSTANCE.getShared();
            String str = this.mGroupId;
            boolean z = this.hasSelectAll;
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            RxUtilsKt.observeOnMainThread$default(shared.shareRoomToLikeMe(str, z, sb3), new Function1() { // from class: com.qiahao.nextvideo.share.l
                public final Object invoke(Object obj) {
                    Unit onClick$lambda$9;
                    onClick$lambda$9 = GroupShareLikeMeChildView.onClick$lambda$9(GroupShareLikeMeChildView.this, (ApiResponse) obj);
                    return onClick$lambda$9;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.share.m
                public final Object invoke(Object obj) {
                    Unit onClick$lambda$10;
                    onClick$lambda$10 = GroupShareLikeMeChildView.onClick$lambda$10(GroupShareLikeMeChildView.this, (Throwable) obj);
                    return onClick$lambda$10;
                }
            }, (Function0) null, false, 12, (Object) null);
            Log.d(TAG, "onClick: ");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCompositeDisposable.d();
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchLikeMeList$default(UserService.INSTANCE.getShared(), this.mPageIndex, this.mPageSize, false, 4, null), new Function1() { // from class: com.qiahao.nextvideo.share.o
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$6;
                onLoadMore$lambda$6 = GroupShareLikeMeChildView.onLoadMore$lambda$6(GroupShareLikeMeChildView.this, (ApiResponse) obj);
                return onLoadMore$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.share.p
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$7;
                onLoadMore$lambda$7 = GroupShareLikeMeChildView.onLoadMore$lambda$7(GroupShareLikeMeChildView.this, (Throwable) obj);
                return onLoadMore$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getFirstData();
    }

    public final void setBinding(@NotNull ShareChildLikeMeContactsBinding shareChildLikeMeContactsBinding) {
        Intrinsics.checkNotNullParameter(shareChildLikeMeContactsBinding, "<set-?>");
        this.binding = shareChildLikeMeContactsBinding;
    }

    public final void setHasNextData(boolean z) {
        this.hasNextData = z;
    }

    public final void setHasSelectAll(boolean z) {
        this.hasSelectAll = z;
    }

    public final void setIsSelectAll(boolean selectAll) {
        this.hasSelectAll = selectAll;
        getMContactsLikeMeAdapter().setIsSelectAll(selectAll);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }
}
