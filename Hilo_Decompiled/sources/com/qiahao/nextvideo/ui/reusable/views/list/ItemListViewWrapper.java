package com.qiahao.nextvideo.ui.reusable.views.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListCallback;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.taobao.accs.utl.BaseMonitor;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import vc.g;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 `*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001`B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\tJ\r\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\tJ+\u0010\u0019\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0011J\u001d\u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u000eJ\u0015\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001f\u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000bH&¢\u0006\u0004\b'\u0010(J'\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020&2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH&¢\u0006\u0004\b,\u0010\u0011J\u001f\u0010-\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b2\u00103R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00104R\"\u00105\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0011R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010?\u001a\u00020=2\u0006\u0010>\u001a\u00020=8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR$\u0010I\u001a\u00020H2\u0006\u0010>\u001a\u00020H8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR*\u0010X\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b^\u0010_¨\u0006a"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "T", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListCallback;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "", "onDestroy", "()V", "item", "", "position", "onListOnItemSelected", "(Ljava/lang/Object;I)V", "page", "onListShouldLoadNextPage", "(I)V", "", "items", "nextPage", "setItems", "(Ljava/util/List;I)V", "clearItems", "notificationAdapter", "fillInItemsByPageIndex", "(Ljava/util/List;II)V", "index", "insertItems", "removeAt", "reloadItem", "", BaseMonitor.COUNT_ERROR, "onError", "(Ljava/lang/Throwable;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "doCreateItemViewHolder", "(Landroid/view/ViewGroup;I)Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "holder", "doBindItemViewHolder", "(Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;Ljava/lang/Object;I)V", "doLoadNextPage", "doGetViewType", "(Ljava/lang/Object;I)I", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getLayoutManager", "(Landroid/content/Context;)Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/view/View;", "pageSize", "I", "getPageSize", "()I", "setPageSize", "Lvc/g;", "onRefreshListener", "Lvc/g;", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "value", "swipeToRefreshView", "Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "getSwipeToRefreshView", "()Lcom/scwang/smart/refresh/layout/SmartRefreshLayout;", "Landroidx/appcompat/widget/AppCompatTextView;", "emptyTipsTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "contentContainer", "Landroid/view/ViewGroup;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/GenericListAdapter;", "adapter", "Lcom/qiahao/nextvideo/ui/reusable/views/list/GenericListAdapter;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;", "delegate", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;)V", "getItems", "()Ljava/util/List;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemListViewWrapper<T> implements ItemListCallback<T> {
    public static final int PAGE_NO_MORE = -1;
    public static final int VIEW_TYPE_HEAD = 1;

    @Nullable
    private GenericListAdapter<T> adapter;

    @NotNull
    private nd.a compositeDisposable;

    @NotNull
    private ViewGroup contentContainer;

    @Nullable
    private ItemListViewWrapperDelegate<T> delegate;

    @NotNull
    private AppCompatTextView emptyTipsTextView;

    @NotNull
    private final g onRefreshListener;
    private int pageSize;

    @NotNull
    private RecyclerView recyclerView;

    @NotNull
    private SmartRefreshLayout swipeToRefreshView;

    @NotNull
    private final View view;

    public ItemListViewWrapper(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.pageSize = 100;
        g gVar = new g() { // from class: com.qiahao.nextvideo.ui.reusable.views.list.a
            @Override // vc.g
            public final void onRefresh(f fVar) {
                ItemListViewWrapper.onRefreshListener$lambda$0(ItemListViewWrapper.this, fVar);
            }
        };
        this.onRefreshListener = gVar;
        View findViewById = view.findViewById(R.id.common_id_swipe_refresh_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.swipeToRefreshView = (SmartRefreshLayout) findViewById;
        AppCompatTextView findViewById2 = view.findViewById(R.id.empty_tip_text_view);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        AppCompatTextView appCompatTextView = findViewById2;
        appCompatTextView.setCompoundDrawablePadding(Dimens.INSTANCE.getMarginXLarge());
        appCompatTextView.setAlpha(0.0f);
        this.emptyTipsTextView = appCompatTextView;
        View findViewById3 = view.findViewById(R.id.common_id_content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        this.contentContainer = viewGroup;
        RecyclerView findViewById4 = viewGroup.findViewById(R.id.common_id_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.recyclerView = findViewById4;
        this.compositeDisposable = new nd.a();
        this.swipeToRefreshView.setOnRefreshListener(gVar);
        this.swipeToRefreshView.autoRefresh();
        Context context = this.recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        RecyclerView.LayoutManager layoutManager = getLayoutManager(context);
        this.recyclerView.setLayoutManager(layoutManager);
        GenericListAdapter<T> genericListAdapter = new GenericListAdapter<>();
        genericListAdapter.setDelegate(this);
        genericListAdapter.setRecyclerViewLayoutManager(layoutManager);
        this.adapter = genericListAdapter;
        this.recyclerView.setAdapter(genericListAdapter);
    }

    public static /* synthetic */ void insertItems$default(ItemListViewWrapper itemListViewWrapper, List list, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            itemListViewWrapper.insertItems(list, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItems");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(ItemListViewWrapper itemListViewWrapper, f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        itemListViewWrapper.onListShouldLoadNextPage(1);
    }

    public final void clearItems() {
        float f;
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            genericListAdapter.clearAll();
        }
        AppCompatTextView appCompatTextView = this.emptyTipsTextView;
        if (getItems() != null && (!r1.isEmpty())) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        appCompatTextView.setAlpha(f);
    }

    public abstract void doBindItemViewHolder(@NotNull ViewHolder holder, T item, int position);

    @NotNull
    public abstract ViewHolder doCreateItemViewHolder(@NotNull ViewGroup parent, int viewType);

    public int doGetViewType(T item, int position) {
        return 0;
    }

    public abstract void doLoadNextPage(int page);

    public final void fillInItemsByPageIndex(@NotNull List<? extends T> items, int page, int nextPage) {
        float f;
        Intrinsics.checkNotNullParameter(items, "items");
        if (page == 1) {
            GenericListAdapter<T> genericListAdapter = this.adapter;
            if (genericListAdapter != null) {
                genericListAdapter.setItems(items, nextPage);
            }
        } else {
            GenericListAdapter<T> genericListAdapter2 = this.adapter;
            if (genericListAdapter2 != null) {
                genericListAdapter2.addItems(items, page, nextPage);
            }
        }
        this.swipeToRefreshView.finishRefresh();
        AppCompatTextView appCompatTextView = this.emptyTipsTextView;
        if (getItems() != null && (!r4.isEmpty())) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        appCompatTextView.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @Nullable
    public final ItemListViewWrapperDelegate<T> getDelegate() {
        return this.delegate;
    }

    @Nullable
    public final List<T> getItems() {
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            return genericListAdapter.getItems();
        }
        return null;
    }

    @NotNull
    public RecyclerView.LayoutManager getLayoutManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CustomLinearLayoutManager(this.view.getContext());
    }

    public int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @NotNull
    public final SmartRefreshLayout getSwipeToRefreshView() {
        return this.swipeToRefreshView;
    }

    public final void insertItems(@NotNull List<? extends T> items, int index) {
        Intrinsics.checkNotNullParameter(items, "items");
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            genericListAdapter.insertItems(items, index);
        }
        this.swipeToRefreshView.finishRefresh();
    }

    public final void notificationAdapter() {
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            genericListAdapter.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.compositeDisposable.d();
    }

    public final void onError(@NotNull Throwable error) {
        Intrinsics.checkNotNullParameter(error, BaseMonitor.COUNT_ERROR);
        error.printStackTrace();
        this.swipeToRefreshView.finishRefresh();
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            genericListAdapter.onError(error);
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListCallback
    public void onListOnItemSelected(T item, int position) {
        ItemListViewWrapperDelegate<T> itemListViewWrapperDelegate = this.delegate;
        if (itemListViewWrapperDelegate != null) {
            itemListViewWrapperDelegate.listViewControllerOnItemSelected(item, position, null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListCallback
    public void onListShouldLoadNextPage(int page) {
        doLoadNextPage(page);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListCallback
    public void onLongListOnItemSelected(T t, int i) {
        ItemListCallback.DefaultImpls.onLongListOnItemSelected(this, t, i);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListCallback
    public void onViewAttachedToWindow(@NotNull ViewHolder viewHolder) {
        ItemListCallback.DefaultImpls.onViewAttachedToWindow(this, viewHolder);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListCallback
    public void onViewRecycled(@NotNull ViewHolder viewHolder) {
        ItemListCallback.DefaultImpls.onViewRecycled(this, viewHolder);
    }

    public final void reloadItem(T item, int index) {
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            genericListAdapter.reloadItem(item, index);
        }
    }

    public void removeAt(int position) {
        float f;
        List<T> items = getItems();
        if (items != null && items.size() == 0) {
            return;
        }
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            genericListAdapter.removeAt(position);
        }
        AppCompatTextView appCompatTextView = this.emptyTipsTextView;
        if (getItems() != null && (!r0.isEmpty())) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        appCompatTextView.setAlpha(f);
    }

    protected final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setDelegate(@Nullable ItemListViewWrapperDelegate<T> itemListViewWrapperDelegate) {
        this.delegate = itemListViewWrapperDelegate;
    }

    public final void setItems(@NotNull List<? extends T> items, int nextPage) {
        float f;
        ArrayList<T> items2;
        Intrinsics.checkNotNullParameter(items, "items");
        GenericListAdapter<T> genericListAdapter = this.adapter;
        if (genericListAdapter != null) {
            genericListAdapter.setItems(items, nextPage);
        }
        AppCompatTextView appCompatTextView = this.emptyTipsTextView;
        GenericListAdapter<T> genericListAdapter2 = this.adapter;
        if (genericListAdapter2 != null && (items2 = genericListAdapter2.getItems()) != null && (!items2.isEmpty())) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        appCompatTextView.setAlpha(f);
        this.swipeToRefreshView.finishRefresh();
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }
}
