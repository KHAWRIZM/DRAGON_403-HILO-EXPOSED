package com.qiahao.nextvideo.ui.reusable.views.list;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\b\u0016\u0018\u0000 ?*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001?B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001cH\u0016J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001cH\u0016J\u0012\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020-2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\u0018\u00102\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u001cH\u0016J\u001c\u0010\u0013\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001b\u001a\u00020\u001cJ$\u00105\u001a\u00020 2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u00106\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u00107\u001a\u00020 2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u0000042\b\b\u0002\u00108\u001a\u00020\u001cJ\u001b\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00028\u00002\u0006\u00108\u001a\u00020\u001c¢\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020 J\u000e\u0010=\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010>\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/list/GenericListAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "<init>", "()V", "recyclerViewLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getRecyclerViewLayoutManager", "()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setRecyclerViewLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "items", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "delegate", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;)V", "nextPage", "", BaseMonitor.COUNT_ERROR, "", "onViewAttachedToWindow", "", "holder", "onViewRecycled", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onClick", "v", "Landroid/view/View;", "onLongClick", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemCount", "onBindViewHolder", "friends", "", "addItems", "page", "insertItems", "index", "reloadItem", "item", "(Ljava/lang/Object;I)V", "clearAll", "removeAt", "onError", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class GenericListAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    @NotNull
    private static final String TAG = "ItemListViewWrapper";
    public static final int VIEW_TYPE_ITEM = 0;
    public static final int VIEW_TYPE_LOADING = -1;

    @Nullable
    private ItemListViewWrapper<T> delegate;

    @Nullable
    private Throwable error;

    @NotNull
    private ArrayList<T> items = new ArrayList<>();
    private int nextPage = 1;

    @Nullable
    private RecyclerView.LayoutManager recyclerViewLayoutManager;

    public static /* synthetic */ void insertItems$default(GenericListAdapter genericListAdapter, List list, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            genericListAdapter.insertItems(list, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItems");
    }

    public final void addItems(@NotNull List<? extends T> items, int page, int nextPage) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (this.nextPage == page) {
            this.nextPage = nextPage;
            int size = this.items.size();
            this.items.addAll(items);
            notifyItemRangeChanged(size, items.size());
            notifyItemChanged(this.items.size());
        }
    }

    public final void clearAll() {
        this.error = null;
        this.nextPage = 1;
        int size = this.items.size();
        this.items.clear();
        notifyItemRangeRemoved(0, size);
        notifyItemChanged(this.items.size());
    }

    @Nullable
    public final ItemListViewWrapper<T> getDelegate() {
        return this.delegate;
    }

    public int getItemCount() {
        return this.items.size() + 1;
    }

    public int getItemViewType(int position) {
        if (position < this.items.size()) {
            ItemListViewWrapper<T> itemListViewWrapper = this.delegate;
            if (itemListViewWrapper != null) {
                return itemListViewWrapper.doGetViewType(this.items.get(position), position);
            }
            return 0;
        }
        return -1;
    }

    @NotNull
    public final ArrayList<T> getItems() {
        return this.items;
    }

    @Nullable
    public final RecyclerView.LayoutManager getRecyclerViewLayoutManager() {
        return this.recyclerViewLayoutManager;
    }

    public final void insertItems(@NotNull List<? extends T> items, int index) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items.addAll(index, items);
        notifyDataSetChanged();
    }

    public void onAttachedToRecyclerView(@NotNull final RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: com.qiahao.nextvideo.ui.reusable.views.list.GenericListAdapter$onAttachedToRecyclerView$1
                final /* synthetic */ GenericListAdapter<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                public int getSpanSize(int position) {
                    if (this.this$0.getItemViewType(position) == -1) {
                        GridLayoutManager layoutManager2 = recyclerView.getLayoutManager();
                        Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                        return layoutManager2.getSpanCount();
                    }
                    if (this.this$0.getItemViewType(position) == 1) {
                        GridLayoutManager layoutManager3 = recyclerView.getLayoutManager();
                        Intrinsics.checkNotNull(layoutManager3, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                        return layoutManager3.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        Object obj;
        int i;
        ItemListViewWrapper<T> itemListViewWrapper;
        Integer num = null;
        if (v != null) {
            obj = v.getTag(R.id.id_item_position);
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        if (i >= 0 && i < this.items.size() && (itemListViewWrapper = this.delegate) != null) {
            itemListViewWrapper.onListOnItemSelected(this.items.get(i), i);
        }
    }

    public final void onError(@NotNull Throwable error) {
        Intrinsics.checkNotNullParameter(error, BaseMonitor.COUNT_ERROR);
        this.error = error;
        notifyItemChanged(this.items.size());
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View v) {
        Object obj;
        int i;
        ItemListViewWrapper<T> itemListViewWrapper;
        Integer num = null;
        if (v != null) {
            obj = v.getTag(R.id.id_item_position);
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        }
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        if (i >= 0) {
            if (i < this.items.size() && (itemListViewWrapper = this.delegate) != null) {
                itemListViewWrapper.onLongListOnItemSelected(this.items.get(i), i);
                return true;
            }
            return true;
        }
        return false;
    }

    public final void reloadItem(T item, int index) {
        if (CollectionsKt.getIndices(this.items).contains(index)) {
            this.items.set(index, item);
            notifyItemChanged(index, Unit.INSTANCE);
        }
    }

    public final void removeAt(int position) {
        this.items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.items.size());
    }

    public final void setDelegate(@Nullable ItemListViewWrapper<T> itemListViewWrapper) {
        this.delegate = itemListViewWrapper;
    }

    public final void setItems(@NotNull ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.items = arrayList;
    }

    public final void setRecyclerViewLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        this.recyclerViewLayoutManager = layoutManager;
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.d(TAG, "onBindViewHolder:--------- ");
        if (holder instanceof LoadingViewHolder) {
            LinearLayoutManager linearLayoutManager = this.recyclerViewLayoutManager;
            if (linearLayoutManager instanceof LinearLayoutManager) {
                Intrinsics.checkNotNull(linearLayoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (linearLayoutManager.getOrientation() == 0) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                } else {
                    layoutParams = new ViewGroup.LayoutParams(-1, -2);
                }
            } else {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            if (this.error != null) {
                ((RecyclerView.ViewHolder) holder).itemView.setLayoutParams(layoutParams);
                ((LoadingViewHolder) holder).setRetry();
                return;
            }
            if (this.nextPage == -1) {
                ((RecyclerView.ViewHolder) holder).itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, 0));
                ((LoadingViewHolder) holder).setMessage("");
                return;
            }
            ((RecyclerView.ViewHolder) holder).itemView.setLayoutParams(layoutParams);
            if (this.nextPage > 1) {
                ((LoadingViewHolder) holder).setLoading();
                ItemListViewWrapper<T> itemListViewWrapper = this.delegate;
                if (itemListViewWrapper != null) {
                    itemListViewWrapper.onListShouldLoadNextPage(this.nextPage);
                    return;
                }
                return;
            }
            return;
        }
        if (position < this.items.size()) {
            View clickableView = holder.getClickableView();
            if (clickableView != null) {
                clickableView.setTag(R.id.id_item_position, Integer.valueOf(position));
            }
            ItemListViewWrapper<T> itemListViewWrapper2 = this.delegate;
            if (itemListViewWrapper2 != null) {
                itemListViewWrapper2.doBindItemViewHolder(holder, this.items.get(position), position);
            }
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        ViewHolder emptyViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Log.d(TAG, "onCreateViewHolder:--------- ");
        if (viewType == -1) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_loading, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new LoadingViewHolder(inflate);
        }
        ItemListViewWrapper<T> itemListViewWrapper = this.delegate;
        if (itemListViewWrapper == null || (emptyViewHolder = itemListViewWrapper.doCreateItemViewHolder(parent, viewType)) == null) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_row_icon_title, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            emptyViewHolder = new EmptyViewHolder(inflate2);
        }
        View clickableView = emptyViewHolder.getClickableView();
        if (clickableView != null) {
            clickableView.setOnClickListener(this);
        }
        View clickableView2 = emptyViewHolder.getClickableView();
        if (clickableView2 == null) {
            return emptyViewHolder;
        }
        clickableView2.setOnLongClickListener(this);
        return emptyViewHolder;
    }

    public void onViewAttachedToWindow(@NotNull ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ItemListViewWrapper<T> itemListViewWrapper = this.delegate;
        if (itemListViewWrapper != null) {
            itemListViewWrapper.onViewAttachedToWindow(holder);
        }
        Log.d(TAG, "onViewAttachedToWindow:--------- ");
    }

    public void onViewRecycled(@NotNull ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        ItemListViewWrapper<T> itemListViewWrapper = this.delegate;
        if (itemListViewWrapper != null) {
            itemListViewWrapper.onViewRecycled(holder);
        }
    }

    public final void setItems(@NotNull List<? extends T> friends, int nextPage) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        this.error = null;
        this.nextPage = nextPage;
        this.items.clear();
        this.items.addAll(friends);
        notifyDataSetChanged();
    }
}
