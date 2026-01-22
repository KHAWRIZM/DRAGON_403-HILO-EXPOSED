package com.qiahao.nextvideo.ui.home.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MessageTopData;
import com.qiahao.nextvideo.data.model.PrivateRecordBean;
import com.qiahao.nextvideo.databinding.ViewHorizontalInteractiveBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.OneHorizonGetSessionListUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010:\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/HorizontalInteractiveView;", "Landroid/widget/LinearLayout;", "Lvc/g;", "Lvc/e;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "i", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "checkVisible", "()V", "initView", "onRefreshView", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "Lcom/qiahao/nextvideo/databinding/ViewHorizontalInteractiveBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewHorizontalInteractiveBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewHorizontalInteractiveBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewHorizontalInteractiveBinding;)V", "Lcom/qiahao/nextvideo/ui/home/chat/MessageTopAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/chat/MessageTopAdapter;", "mAdapter", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "mIndex", "I", "getMIndex", "()I", "setMIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "mIsCanLoadMore", "Z", "getMIsCanLoadMore", "()Z", "setMIsCanLoadMore", "(Z)V", "Lcom/qiahao/nextvideo/ui/home/chat/OnLoadMoreListener;", "mOnLoadMoreListener", "Lcom/qiahao/nextvideo/ui/home/chat/OnLoadMoreListener;", "getMOnLoadMoreListener", "()Lcom/qiahao/nextvideo/ui/home/chat/OnLoadMoreListener;", "setMOnLoadMoreListener", "(Lcom/qiahao/nextvideo/ui/home/chat/OnLoadMoreListener;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHorizontalInteractiveViewWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HorizontalInteractiveViewWrapper.kt\ncom/qiahao/nextvideo/ui/home/chat/HorizontalInteractiveView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,258:1\n1563#2:259\n1634#2,3:260\n1563#2:263\n1634#2,3:264\n*S KotlinDebug\n*F\n+ 1 HorizontalInteractiveViewWrapper.kt\ncom/qiahao/nextvideo/ui/home/chat/HorizontalInteractiveView\n*L\n128#1:259\n128#1:260,3\n213#1:263\n213#1:264,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HorizontalInteractiveView extends LinearLayout implements vc.g, vc.e {

    @NotNull
    private static final String TAG = "HorizontalInteractiveVi";

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompositeDisposable;
    public ViewHorizontalInteractiveBinding mDataBinding;
    private int mIndex;
    private boolean mIsCanLoadMore;

    @NotNull
    private OnLoadMoreListener mOnLoadMoreListener;
    private int mPageSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HorizontalInteractiveView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void checkVisible() {
        postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.chat.o
            @Override // java.lang.Runnable
            public final void run() {
                HorizontalInteractiveView.checkVisible$lambda$6(HorizontalInteractiveView.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkVisible$lambda$6(HorizontalInteractiveView horizontalInteractiveView) {
        int i;
        if (horizontalInteractiveView.getMAdapter().getData().isEmpty()) {
            i = 8;
        } else {
            i = 0;
        }
        horizontalInteractiveView.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MessageTopAdapter mAdapter_delegate$lambda$0() {
        return new MessageTopAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$10(HorizontalInteractiveView horizontalInteractiveView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        horizontalInteractiveView.mIsCanLoadMore = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$11(HorizontalInteractiveView horizontalInteractiveView) {
        horizontalInteractiveView.getMDataBinding().cellLoadingProgressBar.setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLoadMore$lambda$9(HorizontalInteractiveView horizontalInteractiveView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            if (!list.isEmpty() && list.size() >= horizontalInteractiveView.mPageSize) {
                horizontalInteractiveView.mOnLoadMoreListener.setLastItemCount(0);
            } else {
                horizontalInteractiveView.mIsCanLoadMore = false;
            }
            horizontalInteractiveView.mIndex++;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MessageTopData(2, (PrivateRecordBean) it.next(), null, 4, null));
            }
            horizontalInteractiveView.getMAdapter().addData(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefreshView$lambda$4(HorizontalInteractiveView horizontalInteractiveView, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            if (!list.isEmpty() && list.size() >= horizontalInteractiveView.mPageSize) {
                horizontalInteractiveView.mIsCanLoadMore = true;
                horizontalInteractiveView.mOnLoadMoreListener.setLastItemCount(0);
            } else {
                horizontalInteractiveView.mIsCanLoadMore = false;
            }
            horizontalInteractiveView.mIndex++;
            MessageTopAdapter mAdapter = horizontalInteractiveView.getMAdapter();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new MessageTopData(2, (PrivateRecordBean) it.next(), null, 4, null));
            }
            mAdapter.setList(arrayList);
            horizontalInteractiveView.checkVisible();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRefreshView$lambda$5(HorizontalInteractiveView horizontalInteractiveView, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        horizontalInteractiveView.checkVisible();
        horizontalInteractiveView.mIsCanLoadMore = true;
        Log.d(TAG, "onRefreshView: 报错");
        return Unit.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                Log.d("viewPager滑动", "发射initObserve: true");
                UserStore.INSTANCE.getShared().getViewPagePublicRelay().accept(Boolean.TRUE);
            }
        } else {
            Log.d("viewPager滑动", "发射initObserve: false");
            UserStore.INSTANCE.getShared().getViewPagePublicRelay().accept(Boolean.FALSE);
        }
        return super.dispatchTouchEvent(ev);
    }

    @NotNull
    public final MessageTopAdapter getMAdapter() {
        return (MessageTopAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final ViewHorizontalInteractiveBinding getMDataBinding() {
        ViewHorizontalInteractiveBinding viewHorizontalInteractiveBinding = this.mDataBinding;
        if (viewHorizontalInteractiveBinding != null) {
            return viewHorizontalInteractiveBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    public final int getMIndex() {
        return this.mIndex;
    }

    public final boolean getMIsCanLoadMore() {
        return this.mIsCanLoadMore;
    }

    @NotNull
    public final OnLoadMoreListener getMOnLoadMoreListener() {
        return this.mOnLoadMoreListener;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    public final void initView() {
        setMDataBinding(ViewHorizontalInteractiveBinding.inflate(LayoutInflater.from(getContext()), this, true));
        RecyclerView recyclerView = getMDataBinding().horizontalRecyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(getMAdapter());
        getMDataBinding().cellLoadingProgressBar.setVisibility(8);
        getMDataBinding().horizontalRecyclerView.addOnScrollListener(this.mOnLoadMoreListener);
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getMDataBinding().cellLoadingProgressBar.setVisibility(0);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().privateRecordList(this.mPageSize, this.mIndex), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.p
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$9;
                onLoadMore$lambda$9 = HorizontalInteractiveView.onLoadMore$lambda$9(HorizontalInteractiveView.this, (ApiResponse) obj);
                return onLoadMore$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.q
            public final Object invoke(Object obj) {
                Unit onLoadMore$lambda$10;
                onLoadMore$lambda$10 = HorizontalInteractiveView.onLoadMore$lambda$10(HorizontalInteractiveView.this, (Throwable) obj);
                return onLoadMore$lambda$10;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.r
            public final Object invoke() {
                Unit onLoadMore$lambda$11;
                onLoadMore$lambda$11 = HorizontalInteractiveView.onLoadMore$lambda$11(HorizontalInteractiveView.this);
                return onLoadMore$lambda$11;
            }
        }, false, 8, (Object) null), this.mCompositeDisposable);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        onRefreshView();
    }

    public final void onRefreshView() {
        if (OneHorizonGetSessionListUtils.INSTANCE.isFastClick()) {
            this.mIndex = 1;
            Log.d(TAG, "onRefreshView: 横向刷新数据");
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().privateRecordList(this.mPageSize, this.mIndex), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.m
                public final Object invoke(Object obj) {
                    Unit onRefreshView$lambda$4;
                    onRefreshView$lambda$4 = HorizontalInteractiveView.onRefreshView$lambda$4(HorizontalInteractiveView.this, (ApiResponse) obj);
                    return onRefreshView$lambda$4;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.n
                public final Object invoke(Object obj) {
                    Unit onRefreshView$lambda$5;
                    onRefreshView$lambda$5 = HorizontalInteractiveView.onRefreshView$lambda$5(HorizontalInteractiveView.this, (Throwable) obj);
                    return onRefreshView$lambda$5;
                }
            }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
        }
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMDataBinding(@NotNull ViewHorizontalInteractiveBinding viewHorizontalInteractiveBinding) {
        Intrinsics.checkNotNullParameter(viewHorizontalInteractiveBinding, "<set-?>");
        this.mDataBinding = viewHorizontalInteractiveBinding;
    }

    public final void setMIndex(int i) {
        this.mIndex = i;
    }

    public final void setMIsCanLoadMore(boolean z) {
        this.mIsCanLoadMore = z;
    }

    public final void setMOnLoadMoreListener(@NotNull OnLoadMoreListener onLoadMoreListener) {
        Intrinsics.checkNotNullParameter(onLoadMoreListener, "<set-?>");
        this.mOnLoadMoreListener = onLoadMoreListener;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HorizontalInteractiveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalInteractiveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.l
            public final Object invoke() {
                MessageTopAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = HorizontalInteractiveView.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        this.mCompositeDisposable = new nd.a();
        this.mIndex = 1;
        this.mPageSize = 10;
        this.mIsCanLoadMore = true;
        this.mOnLoadMoreListener = new HorizontalInteractiveView$mOnLoadMoreListener$1(this);
        initView();
    }
}
