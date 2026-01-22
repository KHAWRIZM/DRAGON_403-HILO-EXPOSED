package com.qhqc.core.basic.rvadapter.binder;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qhqc.core.basic.rvadapter.BasicLoadMoreQuickAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0004J9\u0010\u000f\u001a\u00020\u0000\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00022\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u0002H\u0010\u0012\u0002\b\u00030\f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\bH\u0086\bJF\u0010\u000f\u001a\u00020\u0000\"\b\b\u0000\u0010\u0010*\u00020\u00022\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00100\u00072\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u0002H\u0010\u0012\u0002\b\u00030\f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\bH\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0014J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0014J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J&\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0014J\u0014\u0010\u001f\u001a\u00020\u000e2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0014J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001e\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u000eH\u0014J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0003H\u0016RB\u0010\u0005\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b0\u0006j\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u000e0\u0006j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u000e`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/binder/BasicLoadMoreBinderAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "classDiffMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lkotlin/collections/HashMap;", "mBinderArray", "Landroid/util/SparseArray;", "Lcom/qhqc/core/basic/rvadapter/binder/BasicItemBinder;", "mTypeMap", "", "addItemBinder", "T", "baseItemBinder", "callback", "clazz", "bindChildClick", "", "viewHolder", "viewType", "bindClick", "bindViewClickListener", "convert", "holder", "item", "payloads", "", "findViewType", "getDefItemViewType", "position", "getItemBinder", "getItemBinderOrNull", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "onFailedToRecycleView", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ItemCallback", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBasicLoadMoreBinderAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicLoadMoreBinderAdapter.kt\ncom/qhqc/core/basic/rvadapter/binder/BasicLoadMoreBinderAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,221:1\n1#2:222\n1863#3,2:223\n1863#3,2:225\n*S KotlinDebug\n*F\n+ 1 BasicLoadMoreBinderAdapter.kt\ncom/qhqc/core/basic/rvadapter/binder/BasicLoadMoreBinderAdapter\n*L\n150#1:223,2\n169#1:225,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicLoadMoreBinderAdapter extends BasicLoadMoreQuickAdapter<Object, BaseViewHolder> {

    @NotNull
    private final HashMap<Class<?>, DiffUtil.ItemCallback<Object>> classDiffMap;

    @NotNull
    private final SparseArray<BasicItemBinder<Object, ?>> mBinderArray;

    @NotNull
    private final HashMap<Class<?>, Integer> mTypeMap;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/binder/BasicLoadMoreBinderAdapter$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "(Lcom/qhqc/core/basic/rvadapter/binder/BasicLoadMoreBinderAdapter;)V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "getChangePayload", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private final class ItemCallback extends DiffUtil.ItemCallback<Object> {
        public ItemCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(@NotNull Object oldItem, @NotNull Object newItem) {
            DiffUtil.ItemCallback itemCallback;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) && (itemCallback = (DiffUtil.ItemCallback) BasicLoadMoreBinderAdapter.this.classDiffMap.get(oldItem.getClass())) != null) {
                return itemCallback.areContentsTheSame(oldItem, newItem);
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull Object oldItem, @NotNull Object newItem) {
            DiffUtil.ItemCallback itemCallback;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) && (itemCallback = (DiffUtil.ItemCallback) BasicLoadMoreBinderAdapter.this.classDiffMap.get(oldItem.getClass())) != null) {
                return itemCallback.areItemsTheSame(oldItem, newItem);
            }
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        public Object getChangePayload(@NotNull Object oldItem, @NotNull Object newItem) {
            DiffUtil.ItemCallback itemCallback;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!Intrinsics.areEqual(oldItem.getClass(), newItem.getClass()) || (itemCallback = (DiffUtil.ItemCallback) BasicLoadMoreBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) {
                return null;
            }
            return itemCallback.getChangePayload(oldItem, newItem);
        }
    }

    public BasicLoadMoreBinderAdapter() {
        super(0, null);
        this.classDiffMap = new HashMap<>();
        this.mTypeMap = new HashMap<>();
        this.mBinderArray = new SparseArray<>();
        setDiffCallback(new ItemCallback());
    }

    public static /* synthetic */ BasicLoadMoreBinderAdapter addItemBinder$default(BasicLoadMoreBinderAdapter basicLoadMoreBinderAdapter, Class cls, BasicItemBinder basicItemBinder, DiffUtil.ItemCallback itemCallback, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i10 & 4) != 0) {
            itemCallback = null;
        }
        return basicLoadMoreBinderAdapter.addItemBinder(cls, basicItemBinder, itemCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindChildClick$lambda$11$lambda$10$lambda$9(BaseViewHolder viewHolder, BasicLoadMoreBinderAdapter this$0, BasicItemBinder provider, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(provider, "$provider");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = adapterPosition - this$0.getHeaderLayoutCount();
        Intrinsics.checkNotNull(view);
        return provider.onChildLongClick(viewHolder, view, this$0.getData().get(headerLayoutCount), headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindChildClick$lambda$8$lambda$7$lambda$6(BaseViewHolder viewHolder, BasicLoadMoreBinderAdapter this$0, BasicItemBinder provider, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(provider, "$provider");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition == -1) {
            return;
        }
        int headerLayoutCount = adapterPosition - this$0.getHeaderLayoutCount();
        Intrinsics.checkNotNull(view);
        provider.onChildClick(viewHolder, view, this$0.getData().get(headerLayoutCount), headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindClick$lambda$4(BaseViewHolder viewHolder, BasicLoadMoreBinderAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition == -1) {
            return;
        }
        int headerLayoutCount = adapterPosition - this$0.getHeaderLayoutCount();
        BasicItemBinder<Object, BaseViewHolder> itemBinder = this$0.getItemBinder(viewHolder.getItemViewType());
        Intrinsics.checkNotNull(view);
        itemBinder.onClick(viewHolder, view, this$0.getData().get(headerLayoutCount), headerLayoutCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindClick$lambda$5(BaseViewHolder viewHolder, BasicLoadMoreBinderAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        int headerLayoutCount = adapterPosition - this$0.getHeaderLayoutCount();
        BasicItemBinder<Object, BaseViewHolder> itemBinder = this$0.getItemBinder(viewHolder.getItemViewType());
        Intrinsics.checkNotNull(view);
        return itemBinder.onLongClick(viewHolder, view, this$0.getData().get(headerLayoutCount), headerLayoutCount);
    }

    @JvmOverloads
    @NotNull
    public final <T> BasicLoadMoreBinderAdapter addItemBinder(@NotNull Class<? extends T> clazz, @NotNull BasicItemBinder<T, ?> baseItemBinder) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        return addItemBinder$default(this, clazz, baseItemBinder, null, 4, null);
    }

    protected void bindChildClick(@NotNull final BaseViewHolder viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemChildClickListener() == null) {
            final BasicItemBinder<Object, BaseViewHolder> itemBinder = getItemBinder(viewType);
            Iterator<T> it = itemBinder.getChildClickViewIds().iterator();
            while (it.hasNext()) {
                View findViewById = viewHolder.itemView.findViewById(((Number) it.next()).intValue());
                if (findViewById != null) {
                    Intrinsics.checkNotNull(findViewById);
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.basic.rvadapter.binder.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BasicLoadMoreBinderAdapter.bindChildClick$lambda$8$lambda$7$lambda$6(BaseViewHolder.this, this, itemBinder, view);
                        }
                    });
                }
            }
        }
        if (getMOnItemChildLongClickListener() == null) {
            final BasicItemBinder<Object, BaseViewHolder> itemBinder2 = getItemBinder(viewType);
            Iterator<T> it2 = itemBinder2.getChildLongClickViewIds().iterator();
            while (it2.hasNext()) {
                View findViewById2 = viewHolder.itemView.findViewById(((Number) it2.next()).intValue());
                if (findViewById2 != null) {
                    Intrinsics.checkNotNull(findViewById2);
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qhqc.core.basic.rvadapter.binder.b
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view) {
                            boolean bindChildClick$lambda$11$lambda$10$lambda$9;
                            bindChildClick$lambda$11$lambda$10$lambda$9 = BasicLoadMoreBinderAdapter.bindChildClick$lambda$11$lambda$10$lambda$9(BaseViewHolder.this, this, itemBinder2, view);
                            return bindChildClick$lambda$11$lambda$10$lambda$9;
                        }
                    });
                }
            }
        }
    }

    protected void bindClick(@NotNull final BaseViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getMOnItemClickListener() == null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.basic.rvadapter.binder.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BasicLoadMoreBinderAdapter.bindClick$lambda$4(BaseViewHolder.this, this, view);
                }
            });
        }
        if (getMOnItemLongClickListener() == null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qhqc.core.basic.rvadapter.binder.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bindClick$lambda$5;
                    bindClick$lambda$5 = BasicLoadMoreBinderAdapter.bindClick$lambda$5(BaseViewHolder.this, this, view);
                    return bindClick$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(@NotNull BaseViewHolder viewHolder, int viewType) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.bindViewClickListener(viewHolder, viewType);
        bindClick(viewHolder);
        bindChildClick(viewHolder, viewType);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected void convert(@NotNull BaseViewHolder holder, @NotNull Object item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        getItemBinder(holder.getItemViewType()).convert(holder, item);
    }

    protected final int findViewType(@NotNull Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Integer num = this.mTypeMap.get(clazz);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(("findViewType: ViewType: " + clazz + " Not Find!").toString());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int getDefItemViewType(int position) {
        return findViewType(getData().get(position).getClass());
    }

    @NotNull
    public BasicItemBinder<Object, BaseViewHolder> getItemBinder(int viewType) {
        BasicItemBinder<Object, BaseViewHolder> basicItemBinder = (BasicItemBinder) this.mBinderArray.get(viewType);
        if (basicItemBinder != null) {
            return basicItemBinder;
        }
        throw new IllegalStateException(("getItemBinder: viewType '" + viewType + "' no such Binder found，please use addItemBinder() first!").toString());
    }

    @Nullable
    public BasicItemBinder<Object, BaseViewHolder> getItemBinderOrNull(int viewType) {
        BasicItemBinder<Object, BaseViewHolder> basicItemBinder = (BasicItemBinder) this.mBinderArray.get(viewType);
        if (basicItemBinder == null) {
            return null;
        }
        return basicItemBinder;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @NotNull
    protected BaseViewHolder onCreateDefViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        BasicItemBinder<Object, BaseViewHolder> itemBinder = getItemBinder(viewType);
        itemBinder.set_context$basic_release(getContext());
        return itemBinder.onCreateViewHolder(parent, viewType);
    }

    public static /* synthetic */ BasicLoadMoreBinderAdapter addItemBinder$default(BasicLoadMoreBinderAdapter basicLoadMoreBinderAdapter, BasicItemBinder baseItemBinder, DiffUtil.ItemCallback itemCallback, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                itemCallback = null;
            }
            Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
            Intrinsics.reifiedOperationMarker(4, "T");
            basicLoadMoreBinderAdapter.addItemBinder(Object.class, baseItemBinder, itemCallback);
            return basicLoadMoreBinderAdapter;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
    }

    @JvmOverloads
    @NotNull
    public final <T> BasicLoadMoreBinderAdapter addItemBinder(@NotNull Class<? extends T> clazz, @NotNull BasicItemBinder<T, ?> baseItemBinder, @Nullable DiffUtil.ItemCallback<T> callback) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        int size = this.mTypeMap.size() + 1;
        this.mTypeMap.put(clazz, Integer.valueOf(size));
        this.mBinderArray.append(size, baseItemBinder);
        baseItemBinder.set_adapter$basic_release(this);
        if (callback != null) {
            this.classDiffMap.put(clazz, callback);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected void convert(@NotNull BaseViewHolder holder, @NotNull Object item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        getItemBinder(holder.getItemViewType()).convert(holder, item, payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BasicItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            return itemBinderOrNull.onFailedToRecycleView(holder);
        }
        return false;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((BasicLoadMoreBinderAdapter) holder);
        BasicItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewAttachedToWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull BaseViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((BasicLoadMoreBinderAdapter) holder);
        BasicItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewDetachedFromWindow(holder);
        }
    }

    public final /* synthetic */ <T> BasicLoadMoreBinderAdapter addItemBinder(BasicItemBinder<T, ?> baseItemBinder, DiffUtil.ItemCallback<T> callback) {
        Intrinsics.checkNotNullParameter(baseItemBinder, "baseItemBinder");
        Intrinsics.reifiedOperationMarker(4, "T");
        addItemBinder(Object.class, baseItemBinder, callback);
        return this;
    }
}
