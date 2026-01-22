package com.qhqc.core.basic.rvadapter;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.module.h;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qhqc.core.basic.rvadapter.BasicLoadMoreStateHelper;
import com.qhqc.core.basic.rvadapter.data.Page;
import com.qhqc.core.basic.rvadapter.data.PageData;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u0005B#\b\u0007\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\nJ8\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00122\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016J\u0016\u0010$\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0016\u0010'\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J\u001a\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0016\u00102\u001a\u00020\u00132\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000103J)\u00104\u001a\u00020\u00132!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00130\u0011J\u001c\u00108\u001a\u00020\u00132\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011J\u0016\u0010:\u001a\u00020\u00132\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010<R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006="}, d2 = {"Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreQuickAdapter;", "T", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "layoutResId", "", "data", "", "(ILjava/util/List;)V", "limitItemCount", "getLimitItemCount", "()I", "setLimitItemCount", "(I)V", "mOnDataLoad", "Lkotlin/Function1;", "Lcom/qhqc/core/basic/rvadapter/data/Page;", "", "page", "getPage", "()Lcom/qhqc/core/basic/rvadapter/data/Page;", "setPage", "(Lcom/qhqc/core/basic/rvadapter/data/Page;)V", "stateHelper", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreStateHelper;", "getStateHelper", "()Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreStateHelper;", "addDataWithPage", "pageInfo", "list", "isFirstPage", "", "isCurrentFirstPage", "loadMoreEnable", "addPageDataWithCursor", "pageData", "Lcom/qhqc/core/basic/rvadapter/data/PageData;", "addPageDataWithIndex", "loadData", "loadDataError", "notifyItemChangedAt", "position", "payload", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "removeAt", "setListWithStateEmpty", "", "setLoadMoreListener", "onLoadMore", "Lkotlin/ParameterName;", "name", "setOnDataLoad", "onAction", "setReloadListener", "reloadListener", "Lkotlin/Function0;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicLoadMoreQuickAdapter<T, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> implements LoadMoreModule {
    private final int layoutResId;
    private int limitItemCount;

    @Nullable
    private Function1<? super Page, Unit> mOnDataLoad;

    @Nullable
    private Page page;

    @NotNull
    private final BasicLoadMoreStateHelper stateHelper;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BasicLoadMoreQuickAdapter(int i10) {
        this(i10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void notifyItemChangedAt$default(BasicLoadMoreQuickAdapter basicLoadMoreQuickAdapter, int i10, Object obj, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 2) != 0) {
                obj = null;
            }
            basicLoadMoreQuickAdapter.notifyItemChangedAt(i10, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyItemChangedAt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLoadMoreListener$lambda$0(Function1 onLoadMore, BasicLoadMoreQuickAdapter this$0) {
        Intrinsics.checkNotNullParameter(onLoadMore, "$onLoadMore");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Page page = this$0.page;
        if (page == null) {
            return;
        }
        onLoadMore.invoke(page);
    }

    public void addDataWithPage(@NotNull Page pageInfo, @Nullable List<T> list, boolean isFirstPage, boolean isCurrentFirstPage, boolean loadMoreEnable) {
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        if (pageInfo.getPage() != -1 && !pageInfo.getLoadError()) {
            if (list != null && !list.isEmpty()) {
                if (isFirstPage) {
                    setNewInstance(list);
                    if (loadMoreEnable) {
                        getLoadMoreModule().setEnableLoadMore(true);
                    } else {
                        getLoadMoreModule().loadMoreEnd(true);
                    }
                } else {
                    addData((Collection) list);
                    if (loadMoreEnable) {
                        getLoadMoreModule().loadMoreComplete();
                    } else {
                        getLoadMoreModule().loadMoreEnd(true);
                    }
                }
                pageInfo.setPage(pageInfo.getPage() + 1);
                this.page = pageInfo;
                return;
            }
            if (isFirstPage) {
                setList(list);
                this.stateHelper.onStateChange(new BasicLoadMoreStateHelper.State(2));
            }
            getLoadMoreModule().loadMoreEnd(true);
            return;
        }
        if (isCurrentFirstPage) {
            if (getData().size() != 0) {
                return;
            }
            this.stateHelper.onStateChange(new BasicLoadMoreStateHelper.State(3));
            return;
        }
        getLoadMoreModule().loadMoreFail();
    }

    @Override // com.chad.library.adapter.base.module.LoadMoreModule
    public /* synthetic */ BaseLoadMoreModule addLoadMoreModule(BaseQuickAdapter baseQuickAdapter) {
        return h.a(this, baseQuickAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addPageDataWithCursor(@NotNull PageData<T> pageData) {
        boolean z10;
        boolean z11;
        List<T> data;
        int i10;
        boolean z12;
        String nextPageCursor;
        boolean z13;
        String str;
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Page page = pageData.getPage();
        List<T> data2 = pageData.getData();
        String currentPageCursor = pageData.getPage().getCurrentPageCursor();
        if (currentPageCursor != null && currentPageCursor.length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        Page page2 = this.page;
        if (page2 != null) {
            if (page2 != null) {
                str = page2.getCurrentPageCursor();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z11 = false;
                data = pageData.getData();
                if (data == null) {
                    i10 = data.size();
                } else {
                    i10 = 0;
                }
                if (i10 > 0 && pageData.getPage().getHasNextPage()) {
                    nextPageCursor = pageData.getPage().getNextPageCursor();
                    if (nextPageCursor == null && nextPageCursor.length() != 0) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (!z13) {
                        z12 = true;
                        addDataWithPage(page, data2, z10, z11, z12);
                    }
                }
                z12 = false;
                addDataWithPage(page, data2, z10, z11, z12);
            }
        }
        z11 = true;
        data = pageData.getData();
        if (data == null) {
        }
        if (i10 > 0) {
            nextPageCursor = pageData.getPage().getNextPageCursor();
            if (nextPageCursor == null) {
            }
            z13 = true;
            if (!z13) {
            }
        }
        z12 = false;
        addDataWithPage(page, data2, z10, z11, z12);
    }

    public void addPageDataWithIndex(@NotNull PageData<T> pageData) {
        boolean z10;
        boolean z11;
        int i10;
        boolean z12;
        Intrinsics.checkNotNullParameter(pageData, "pageData");
        Page page = pageData.getPage();
        List<T> data = pageData.getData();
        if (pageData.getPage().getPage() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Page page2 = this.page;
        if (page2 != null && (page2 == null || page2.getPage() != 1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        List<T> data2 = pageData.getData();
        if (data2 != null) {
            i10 = data2.size();
        } else {
            i10 = 0;
        }
        if (i10 > this.limitItemCount) {
            z12 = true;
        } else {
            z12 = false;
        }
        addDataWithPage(page, data, z10, z11, z12);
    }

    public final int getLimitItemCount() {
        return this.limitItemCount;
    }

    @Nullable
    public final Page getPage() {
        return this.page;
    }

    @NotNull
    public final BasicLoadMoreStateHelper getStateHelper() {
        return this.stateHelper;
    }

    public final void loadData() {
        Function1<? super Page, Unit> function1 = this.mOnDataLoad;
        if (function1 != null) {
            function1.invoke(new Page(1, null, null, false, 0, false, 62, null));
        }
    }

    public final void loadDataError() {
        addDataWithPage(new Page(-1, null, null, false, 0, true, 30, null), null, false, false, false);
    }

    public final void notifyItemChangedAt(int position, @Nullable Object payload) {
        notifyItemChanged(position + getHeaderLayoutCount(), payload);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.stateHelper.onAttachedToRecyclerView();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void removeAt(int position) {
        super.removeAt(position);
        if (getData().isEmpty() && this.stateHelper.getIsShowEmptyView()) {
            this.stateHelper.onStateChange(new BasicLoadMoreStateHelper.State(2));
        }
    }

    public final void setLimitItemCount(int i10) {
        this.limitItemCount = i10;
    }

    public final void setListWithStateEmpty(@Nullable Collection<? extends T> list) {
        super.setList(list);
        if (list == null || list.isEmpty()) {
            this.stateHelper.onStateChange(new BasicLoadMoreStateHelper.State(2));
        }
    }

    public final void setLoadMoreListener(@NotNull final Function1<? super Page, Unit> onLoadMore) {
        Intrinsics.checkNotNullParameter(onLoadMore, "onLoadMore");
        getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.qhqc.core.basic.rvadapter.a
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                BasicLoadMoreQuickAdapter.setLoadMoreListener$lambda$0(Function1.this, this);
            }
        });
    }

    public final void setOnDataLoad(@Nullable final Function1<? super Page, Unit> onAction) {
        this.mOnDataLoad = onAction;
        setLoadMoreListener(new Function1<Page, Unit>() { // from class: com.qhqc.core.basic.rvadapter.BasicLoadMoreQuickAdapter$setOnDataLoad$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Page page) {
                invoke2(page);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Page page) {
                Intrinsics.checkNotNullParameter(page, "page");
                Function1<Page, Unit> function1 = onAction;
                if (function1 != null) {
                    function1.invoke(page);
                }
            }
        });
        setReloadListener(new Function0<Unit>() { // from class: com.qhqc.core.basic.rvadapter.BasicLoadMoreQuickAdapter$setOnDataLoad$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1<Page, Unit> function1 = onAction;
                if (function1 != null) {
                    function1.invoke(new Page(1, null, null, false, 0, false, 62, null));
                }
            }
        });
    }

    public final void setPage(@Nullable Page page) {
        this.page = page;
    }

    public final void setReloadListener(@Nullable Function0<Unit> reloadListener) {
        this.stateHelper.setReloadListener(reloadListener);
    }

    public /* synthetic */ BasicLoadMoreQuickAdapter(int i10, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? null : list);
    }

    @JvmOverloads
    public BasicLoadMoreQuickAdapter(int i10, @Nullable List<T> list) {
        super(i10, list);
        this.layoutResId = i10;
        this.limitItemCount = 1;
        this.stateHelper = new BasicLoadMoreStateHelper(this);
    }
}
