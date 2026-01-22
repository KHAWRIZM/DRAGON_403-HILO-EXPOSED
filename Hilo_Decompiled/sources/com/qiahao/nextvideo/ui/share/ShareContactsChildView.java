package com.qiahao.nextvideo.ui.share;

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
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ShareCommonContactsBinding;
import com.qiahao.nextvideo.ui.home.chat.ContactsLikeEachOtherAdapter;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001KB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001b\u00105\u001a\u0002008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/ui/share/ShareContactsChildView;", "Landroid/widget/FrameLayout;", "Lvc/e;", "Lvc/g;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "viewController", "Landroid/content/Context;", "mContext", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;Landroid/content/Context;)V", "", "initRecycle", "()V", "getFirstData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "onDetachedFromWindow", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "", "hasNextData", "Z", "getHasNextData", "()Z", "setHasNextData", "(Z)V", "mPageSize", "getMPageSize", "setMPageSize", "Lcom/qiahao/nextvideo/ui/home/chat/ContactsLikeEachOtherAdapter;", "mContactsLikeEachAdapter$delegate", "Lkotlin/Lazy;", "getMContactsLikeEachAdapter", "()Lcom/qiahao/nextvideo/ui/home/chat/ContactsLikeEachOtherAdapter;", "mContactsLikeEachAdapter", "Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/share/ShareContactsChildListener;", "delegate", "Lcom/qiahao/nextvideo/ui/share/ShareContactsChildListener;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/share/ShareContactsChildListener;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/share/ShareContactsChildListener;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShareContactsChildView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareContactsChildView.kt\ncom/qiahao/nextvideo/ui/share/ShareContactsChildView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n1#2:151\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ShareContactsChildView extends FrameLayout implements vc.e, vc.g, View.OnClickListener {

    @NotNull
    private static final String TAG = "ShareContactsChildView";

    @NotNull
    private ShareCommonContactsBinding binding;

    @Nullable
    private ShareContactsChildListener delegate;
    private boolean hasNextData;

    @NotNull
    private nd.a mCompositeDisposable;

    /* renamed from: mContactsLikeEachAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContactsLikeEachAdapter;

    @NotNull
    private final Context mContext;
    private int mPageIndex;
    private int mPageSize;

    @NotNull
    private final BaseViewController viewController;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareContactsChildView(@NotNull BaseViewController baseViewController, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(baseViewController, "viewController");
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.viewController = baseViewController;
        this.mContext = context;
        this.mPageIndex = 1;
        this.mPageSize = 20;
        this.mContactsLikeEachAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.share.c
            public final Object invoke() {
                ContactsLikeEachOtherAdapter mContactsLikeEachAdapter_delegate$lambda$0;
                mContactsLikeEachAdapter_delegate$lambda$0 = ShareContactsChildView.mContactsLikeEachAdapter_delegate$lambda$0();
                return mContactsLikeEachAdapter_delegate$lambda$0;
            }
        });
        ViewDataBinding h = androidx.databinding.g.h(LayoutInflater.from(context), R.layout.share_common_contacts, this, true);
        Intrinsics.checkNotNullExpressionValue(h, "inflate(...)");
        this.binding = (ShareCommonContactsBinding) h;
        this.mCompositeDisposable = new nd.a();
        this.binding.setClick(this);
        this.binding.smartRefreshLayout.setOnLoadMoreListener(this);
        this.binding.smartRefreshLayout.setOnRefreshListener(this);
        initRecycle();
    }

    private final void getFirstData() {
        this.mPageIndex = 1;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getLikeEachOtherContacts(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.share.d
            public final Object invoke(Object obj) {
                Unit firstData$lambda$3;
                firstData$lambda$3 = ShareContactsChildView.getFirstData$lambda$3(ShareContactsChildView.this, (ApiResponse) obj);
                return firstData$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.share.e
            public final Object invoke(Object obj) {
                Unit firstData$lambda$4;
                firstData$lambda$4 = ShareContactsChildView.getFirstData$lambda$4(ShareContactsChildView.this, (Throwable) obj);
                return firstData$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstData$lambda$3(ShareContactsChildView shareContactsChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        shareContactsChildView.binding.smartRefreshLayout.finishRefresh();
        boolean z = true;
        shareContactsChildView.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            shareContactsChildView.binding.emptyTipTextView.setVisibility(8);
            List list = (List) apiResponse.getData();
            if (list == null || list.size() != 20) {
                z = false;
            }
            shareContactsChildView.hasNextData = z;
            shareContactsChildView.getMContactsLikeEachAdapter().setList((Collection) apiResponse.getData());
        } else {
            shareContactsChildView.hasNextData = false;
        }
        shareContactsChildView.binding.smartRefreshLayout.setEnableLoadMore(shareContactsChildView.hasNextData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstData$lambda$4(ShareContactsChildView shareContactsChildView, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        shareContactsChildView.binding.smartRefreshLayout.finishRefresh();
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = shareContactsChildView.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(shareContactsChildView, 2131952667);
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
        recyclerView.setAdapter(getMContactsLikeEachAdapter());
        getMContactsLikeEachAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.share.f
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShareContactsChildView.initRecycle$lambda$2(ShareContactsChildView.this, baseQuickAdapter, view, i);
            }
        });
        this.binding.smartRefreshLayout.autoRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycle$lambda$2(ShareContactsChildView shareContactsChildView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.ContactsLikeEachItem");
        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) item;
        Log.d(TAG, "initRecycle: 选择用户 " + contactsLikeEachItem.getUserBase().getCode());
        ShareContactsChildListener shareContactsChildListener = shareContactsChildView.delegate;
        if (shareContactsChildListener != null) {
            shareContactsChildListener.selectContactsUser(contactsLikeEachItem.getUserBase());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactsLikeEachOtherAdapter mContactsLikeEachAdapter_delegate$lambda$0() {
        return new ContactsLikeEachOtherAdapter(R.layout.item_contact_like_each_other, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$6(ShareContactsChildView shareContactsChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        boolean z = true;
        shareContactsChildView.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List list = (List) apiResponse.getData();
            if (list == null || list.size() != 20) {
                z = false;
            }
            shareContactsChildView.hasNextData = z;
            List list2 = (List) apiResponse.getData();
            if (list2 != null) {
                shareContactsChildView.getMContactsLikeEachAdapter().addData(list2);
            }
        } else {
            shareContactsChildView.hasNextData = false;
        }
        shareContactsChildView.binding.smartRefreshLayout.setEnableLoadMore(shareContactsChildView.hasNextData);
        shareContactsChildView.binding.smartRefreshLayout.finishLoadMore();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$7(ShareContactsChildView shareContactsChildView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = shareContactsChildView.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(shareContactsChildView, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        shareContactsChildView.binding.smartRefreshLayout.finishLoadMore();
        return Unit.INSTANCE;
    }

    @NotNull
    public final ShareCommonContactsBinding getBinding() {
        return this.binding;
    }

    @Nullable
    public final ShareContactsChildListener getDelegate() {
        return this.delegate;
    }

    public final boolean getHasNextData() {
        return this.hasNextData;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final ContactsLikeEachOtherAdapter getMContactsLikeEachAdapter() {
        return (ContactsLikeEachOtherAdapter) this.mContactsLikeEachAdapter.getValue();
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    @NotNull
    public final BaseViewController getViewController() {
        return this.viewController;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCompositeDisposable.d();
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getLikeEachOtherContacts(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.share.a
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$6;
                onLoadMore$lambda$6 = ShareContactsChildView.onLoadMore$lambda$6(ShareContactsChildView.this, (ApiResponse) obj);
                return onLoadMore$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.share.b
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$7;
                onLoadMore$lambda$7 = ShareContactsChildView.onLoadMore$lambda$7(ShareContactsChildView.this, (Throwable) obj);
                return onLoadMore$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getFirstData();
    }

    public final void setBinding(@NotNull ShareCommonContactsBinding shareCommonContactsBinding) {
        Intrinsics.checkNotNullParameter(shareCommonContactsBinding, "<set-?>");
        this.binding = shareCommonContactsBinding;
    }

    public final void setDelegate(@Nullable ShareContactsChildListener shareContactsChildListener) {
        this.delegate = shareContactsChildListener;
    }

    public final void setHasNextData(boolean z) {
        this.hasNextData = z;
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
