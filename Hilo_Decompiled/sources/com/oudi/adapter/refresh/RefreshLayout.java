package com.oudi.adapter.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.adapter.refresh.RefreshLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tc.f;
import vc.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ!\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b!\u0010\u001fJ!\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\"\u0010\u001fJ;\u0010&\u001a\u00020\u000b2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010#2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u000b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#H\u0016¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u00020\u000b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#H\u0016¢\u0006\u0004\b*\u0010)J#\u0010+\u001a\u00020\u000b2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#H\u0016¢\u0006\u0004\b+\u0010)J#\u0010,\u001a\u00020\u000b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#H\u0016¢\u0006\u0004\b,\u0010)J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b$\u0010/J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b%\u0010/RC\u00106\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#00j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#`18BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105RC\u00109\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#00j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0#`18BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105¨\u0006:"}, d2 = {"Lcom/oudi/adapter/refresh/RefreshLayout;", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "Lcom/oudi/adapter/refresh/IRefreshLayout;", "Lvc/h;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "checkSetRefreshListener", "()V", "", "delayed", "", "autoRefresh", "(Ljava/lang/Integer;)Z", "autoLoadMore", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "success", "noMoreData", "finishRefresh", "(ZZLjava/lang/Integer;)V", "finishLoadMore", "", ViewHierarchyConstants.TAG_KEY, "setNoMoreData", "(ZLjava/lang/Object;)V", "enabled", "setEnableRefresh", "setEnableLoadMore", "Lkotlin/Function1;", "onRefresh", "onLoadMore", "setOnRefreshLoadMoreListener", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "addOnRefreshListener", "(Lkotlin/jvm/functions/Function1;)V", "addOnLoadMoreListener", "removeOnRefreshListener", "removeOnLoadMoreListener", "Ltc/f;", "refreshLayout", "(Ltc/f;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onRefreshList$delegate", "Lkotlin/Lazy;", "getOnRefreshList", "()Ljava/util/ArrayList;", "onRefreshList", "onLoadMoreList$delegate", "getOnLoadMoreList", "onLoadMoreList", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class RefreshLayout extends SmartRefreshLayout implements IRefreshLayout, h {

    /* renamed from: onLoadMoreList$delegate, reason: from kotlin metadata */
    private final Lazy onLoadMoreList;

    /* renamed from: onRefreshList$delegate, reason: from kotlin metadata */
    private final Lazy onRefreshList;

    public RefreshLayout(Context context) {
        super(context);
        this.onRefreshList = LazyKt.lazy(new Function0() { // from class: sa.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList onRefreshList_delegate$lambda$0;
                onRefreshList_delegate$lambda$0 = RefreshLayout.onRefreshList_delegate$lambda$0();
                return onRefreshList_delegate$lambda$0;
            }
        });
        this.onLoadMoreList = LazyKt.lazy(new Function0() { // from class: sa.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList onLoadMoreList_delegate$lambda$1;
                onLoadMoreList_delegate$lambda$1 = RefreshLayout.onLoadMoreList_delegate$lambda$1();
                return onLoadMoreList_delegate$lambda$1;
            }
        });
    }

    private final void checkSetRefreshListener() {
        if (!getOnRefreshList().isEmpty() || !getOnLoadMoreList().isEmpty()) {
            if (((SmartRefreshLayout) this).mRefreshListener == null || ((SmartRefreshLayout) this).mLoadMoreListener == null) {
                setOnRefreshLoadMoreListener(this);
            }
        }
    }

    private final ArrayList<Function1<IRefreshLayout, Unit>> getOnLoadMoreList() {
        return (ArrayList) this.onLoadMoreList.getValue();
    }

    private final ArrayList<Function1<IRefreshLayout, Unit>> getOnRefreshList() {
        return (ArrayList) this.onRefreshList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList onLoadMoreList_delegate$lambda$1() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList onRefreshList_delegate$lambda$0() {
        return new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void addOnLoadMoreListener(Function1<? super IRefreshLayout, Unit> onLoadMore) {
        Intrinsics.checkNotNullParameter(onLoadMore, "onLoadMore");
        getOnLoadMoreList().add(onLoadMore);
        checkSetRefreshListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void addOnRefreshListener(Function1<? super IRefreshLayout, Unit> onRefresh) {
        Intrinsics.checkNotNullParameter(onRefresh, "onRefresh");
        getOnRefreshList().add(onRefresh);
        checkSetRefreshListener();
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public boolean autoLoadMore(Integer delayed) {
        int i10;
        if (delayed != null) {
            i10 = delayed.intValue();
        } else {
            i10 = 0;
        }
        return autoLoadMore(i10);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public boolean autoRefresh(Integer delayed) {
        int i10;
        if (delayed != null) {
            i10 = delayed.intValue();
        } else {
            i10 = 0;
        }
        return autoRefresh(i10);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void finishLoadMore(boolean success, boolean noMoreData, Integer delayed) {
        int i10;
        if (delayed != null) {
            i10 = delayed.intValue();
        } else {
            i10 = 0;
        }
        finishLoadMore(i10, success, noMoreData);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void finishRefresh(boolean success, boolean noMoreData, Integer delayed) {
        int i10;
        if (delayed != null) {
            i10 = delayed.intValue();
        } else {
            i10 = 0;
        }
        finishRefresh(i10, success, Boolean.valueOf(noMoreData));
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public RecyclerView getRecyclerView() {
        View childAt = getLayout().getChildAt(0);
        if (childAt instanceof RecyclerView) {
            return (RecyclerView) childAt;
        }
        return null;
    }

    public void onLoadMore(f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Iterator<T> it = getOnLoadMoreList().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this);
        }
    }

    public void onRefresh(f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Iterator<T> it = getOnRefreshList().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this);
        }
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void removeOnLoadMoreListener(Function1<? super IRefreshLayout, Unit> onLoadMore) {
        Intrinsics.checkNotNullParameter(onLoadMore, "onLoadMore");
        getOnLoadMoreList().remove(onLoadMore);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void removeOnRefreshListener(Function1<? super IRefreshLayout, Unit> onRefresh) {
        Intrinsics.checkNotNullParameter(onRefresh, "onRefresh");
        getOnRefreshList().remove(onRefresh);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void setEnableLoadMore(boolean enabled, Object tag) {
        setEnableLoadMore(enabled);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void setEnableRefresh(boolean enabled, Object tag) {
        setEnableRefresh(enabled);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void setNoMoreData(boolean noMoreData, Object tag) {
        setNoMoreData(noMoreData);
    }

    @Override // com.oudi.adapter.refresh.IRefreshLayout
    public void setOnRefreshLoadMoreListener(Function1<? super IRefreshLayout, Unit> onRefresh, Function1<? super IRefreshLayout, Unit> onLoadMore) {
        getOnRefreshList().clear();
        getOnLoadMoreList().clear();
        if (onRefresh != null) {
            addOnRefreshListener(onRefresh);
        }
        if (onLoadMore != null) {
            addOnLoadMoreListener(onLoadMore);
        }
    }

    public RefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onRefreshList = LazyKt.lazy(new Function0() { // from class: sa.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList onRefreshList_delegate$lambda$0;
                onRefreshList_delegate$lambda$0 = RefreshLayout.onRefreshList_delegate$lambda$0();
                return onRefreshList_delegate$lambda$0;
            }
        });
        this.onLoadMoreList = LazyKt.lazy(new Function0() { // from class: sa.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList onLoadMoreList_delegate$lambda$1;
                onLoadMoreList_delegate$lambda$1 = RefreshLayout.onLoadMoreList_delegate$lambda$1();
                return onLoadMoreList_delegate$lambda$1;
            }
        });
    }
}
