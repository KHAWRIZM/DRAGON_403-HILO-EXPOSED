package com.qiahao.nextvideo.ui.share;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ILikeGuyItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ShareCommonContactsBinding;
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

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001KB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001b\u00105\u001a\u0002008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/ui/share/ShareILikeChildView;", "Landroid/widget/FrameLayout;", "Lvc/e;", "Lvc/g;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "viewController", "Landroid/content/Context;", "mContext", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;Landroid/content/Context;)V", "", "initRecycle", "()V", "getFirstData", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "onDetachedFromWindow", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "getViewController", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "", "hasNextData", "Z", "getHasNextData", "()Z", "setHasNextData", "(Z)V", "mPageSize", "getMPageSize", "setMPageSize", "Lcom/qiahao/nextvideo/ui/share/ContactsILikeAdapter;", "mContactsLikeMeAdapter$delegate", "Lkotlin/Lazy;", "getMContactsLikeMeAdapter", "()Lcom/qiahao/nextvideo/ui/share/ContactsILikeAdapter;", "mContactsLikeMeAdapter", "Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ShareCommonContactsBinding;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/share/ShareLikeMeChildListener;", "delegate", "Lcom/qiahao/nextvideo/ui/share/ShareLikeMeChildListener;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/share/ShareLikeMeChildListener;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/share/ShareLikeMeChildListener;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShareILikeChildView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareILikeChildView.kt\ncom/qiahao/nextvideo/ui/share/ShareILikeChildView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,151:1\n1#2:152\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ShareILikeChildView extends FrameLayout implements vc.e, vc.g, View.OnClickListener {

    @NotNull
    private static final String TAG = "ShareLikeMeChildView";

    @NotNull
    private ShareCommonContactsBinding binding;

    @Nullable
    private ShareLikeMeChildListener delegate;
    private boolean hasNextData;

    @NotNull
    private nd.a mCompositeDisposable;

    /* renamed from: mContactsLikeMeAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContactsLikeMeAdapter;

    @NotNull
    private final Context mContext;
    private int mPageIndex;
    private int mPageSize;

    @NotNull
    private final BaseViewController viewController;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareILikeChildView(@NotNull BaseViewController baseViewController, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(baseViewController, "viewController");
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.viewController = baseViewController;
        this.mContext = context;
        this.mPageIndex = 1;
        this.mPageSize = 20;
        this.mContactsLikeMeAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.share.i
            public final Object invoke() {
                ContactsILikeAdapter mContactsLikeMeAdapter_delegate$lambda$0;
                mContactsLikeMeAdapter_delegate$lambda$0 = ShareILikeChildView.mContactsLikeMeAdapter_delegate$lambda$0();
                return mContactsLikeMeAdapter_delegate$lambda$0;
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchILikeList(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.share.g
            public final Object invoke(Object obj) {
                Unit firstData$lambda$4;
                firstData$lambda$4 = ShareILikeChildView.getFirstData$lambda$4(ShareILikeChildView.this, (ApiResponse) obj);
                return firstData$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.share.h
            public final Object invoke(Object obj) {
                Unit firstData$lambda$5;
                firstData$lambda$5 = ShareILikeChildView.getFirstData$lambda$5(ShareILikeChildView.this, (Throwable) obj);
                return firstData$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstData$lambda$4(ShareILikeChildView shareILikeChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        shareILikeChildView.binding.smartRefreshLayout.finishRefresh();
        boolean z = true;
        shareILikeChildView.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            shareILikeChildView.binding.emptyTipTextView.setVisibility(8);
            List list = (List) apiResponse.getData();
            if (list == null || list.size() != 20) {
                z = false;
            }
            shareILikeChildView.hasNextData = z;
            shareILikeChildView.getMContactsLikeMeAdapter().setList((Collection) apiResponse.getData());
        } else {
            shareILikeChildView.hasNextData = false;
        }
        shareILikeChildView.binding.smartRefreshLayout.setEnableLoadMore(shareILikeChildView.hasNextData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstData$lambda$5(ShareILikeChildView shareILikeChildView, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        shareILikeChildView.binding.smartRefreshLayout.finishRefresh();
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = shareILikeChildView.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(shareILikeChildView, 2131952667);
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
        getMContactsLikeMeAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.share.j
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShareILikeChildView.initRecycle$lambda$3(ShareILikeChildView.this, baseQuickAdapter, view, i);
            }
        });
        this.binding.smartRefreshLayout.autoRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecycle$lambda$3(ShareILikeChildView shareILikeChildView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        ShareLikeMeChildListener shareLikeMeChildListener;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.ILikeGuyItem");
        User user = ((ILikeGuyItem) item).getUser();
        if (user != null && (shareLikeMeChildListener = shareILikeChildView.delegate) != null) {
            shareLikeMeChildListener.selectShareLikeMeUser(user);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactsILikeAdapter mContactsLikeMeAdapter_delegate$lambda$0() {
        return new ContactsILikeAdapter(R.layout.item_contact_like_me_other, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$7(ShareILikeChildView shareILikeChildView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        boolean z = true;
        shareILikeChildView.mPageIndex++;
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List list = (List) apiResponse.getData();
            if (list == null || list.size() != 20) {
                z = false;
            }
            shareILikeChildView.hasNextData = z;
            List list2 = (List) apiResponse.getData();
            if (list2 != null) {
                shareILikeChildView.getMContactsLikeMeAdapter().addData(list2);
            }
        } else {
            shareILikeChildView.hasNextData = false;
        }
        shareILikeChildView.binding.smartRefreshLayout.setEnableLoadMore(shareILikeChildView.hasNextData);
        shareILikeChildView.binding.smartRefreshLayout.finishLoadMore();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$8(ShareILikeChildView shareILikeChildView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = shareILikeChildView.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(shareILikeChildView, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        shareILikeChildView.binding.smartRefreshLayout.finishLoadMore();
        return Unit.INSTANCE;
    }

    @NotNull
    public final ShareCommonContactsBinding getBinding() {
        return this.binding;
    }

    @Nullable
    public final ShareLikeMeChildListener getDelegate() {
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
    public final ContactsILikeAdapter getMContactsLikeMeAdapter() {
        return (ContactsILikeAdapter) this.mContactsLikeMeAdapter.getValue();
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
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchILikeList(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.ui.share.k
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$7;
                onLoadMore$lambda$7 = ShareILikeChildView.onLoadMore$lambda$7(ShareILikeChildView.this, (ApiResponse) obj);
                return onLoadMore$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.share.l
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$8;
                onLoadMore$lambda$8 = ShareILikeChildView.onLoadMore$lambda$8(ShareILikeChildView.this, (Throwable) obj);
                return onLoadMore$lambda$8;
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

    public final void setDelegate(@Nullable ShareLikeMeChildListener shareLikeMeChildListener) {
        this.delegate = shareLikeMeChildListener;
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
