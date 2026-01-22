package com.oudi.adapter;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.adapter.BaseSelectorListAdapter.SelectorItemEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zd.v2;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001)B#\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010 \u001a\u00020\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010!\u001a\u00020\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010\"\u001a\u00020\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010$\u001a\u00020\u0007J\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000eJ\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00028\u00000'j\b\u0012\u0004\u0012\u00028\u0000`(R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012¨\u0006*"}, d2 = {"Lcom/oudi/adapter/BaseSelectorListAdapter;", "T", "Lcom/oudi/adapter/BaseSelectorListAdapter$SelectorItemEntity;", "B", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/oudi/adapter/BaseListAdapter;", "layoutResId", "", "data", "", "<init>", "(ILjava/util/List;)V", "selectedSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "value", "", "isEditMode", "()Z", "isAllSelected", "isSelected", "item", "(Lcom/oudi/adapter/BaseSelectorListAdapter$SelectorItemEntity;)Z", "selectedIndexOf", "(Lcom/oudi/adapter/BaseSelectorListAdapter$SelectorItemEntity;)I", "selectItem", "", "(Lcom/oudi/adapter/BaseSelectorListAdapter$SelectorItemEntity;)V", "changeItemSelectState", "position", "payload", "", "selectAll", "cancelAllSelected", "removeSelectedItem", "switchMode", "getSelectedCount", "getSelectedSet", "getSelectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "SelectorItemEntity", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseSelectorListAdapter<T extends SelectorItemEntity, B extends BaseViewHolder> extends BaseListAdapter<T, B> {
    private boolean isEditMode;
    private final HashSet<T> selectedSet;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000H&¨\u0006\u0005"}, d2 = {"Lcom/oudi/adapter/BaseSelectorListAdapter$SelectorItemEntity;", "", "equalsItem", "", "item", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface SelectorItemEntity {
        boolean equalsItem(SelectorItemEntity item);
    }

    public BaseSelectorListAdapter(int i10, List<T> list) {
        super(i10, list);
        this.selectedSet = new HashSet<>();
    }

    public static /* synthetic */ void cancelAllSelected$default(BaseSelectorListAdapter baseSelectorListAdapter, Object obj, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 1) != 0) {
                obj = null;
            }
            baseSelectorListAdapter.cancelAllSelected(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancelAllSelected");
    }

    public static /* synthetic */ void changeItemSelectState$default(BaseSelectorListAdapter baseSelectorListAdapter, int i10, Object obj, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 2) != 0) {
                obj = null;
            }
            baseSelectorListAdapter.changeItemSelectState(i10, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeItemSelectState");
    }

    public static /* synthetic */ void removeSelectedItem$default(BaseSelectorListAdapter baseSelectorListAdapter, Object obj, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 1) != 0) {
                obj = null;
            }
            baseSelectorListAdapter.removeSelectedItem(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeSelectedItem");
    }

    public static /* synthetic */ void selectAll$default(BaseSelectorListAdapter baseSelectorListAdapter, Object obj, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 1) != 0) {
                obj = null;
            }
            baseSelectorListAdapter.selectAll(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectAll");
    }

    public static /* synthetic */ void switchMode$default(BaseSelectorListAdapter baseSelectorListAdapter, boolean z10, Object obj, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 2) != 0) {
                obj = null;
            }
            baseSelectorListAdapter.switchMode(z10, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchMode");
    }

    public final void cancelAllSelected(Object payload) {
        this.selectedSet.clear();
        notifyItemRangeChanged(0, getItemCount(), payload);
    }

    public final void changeItemSelectState(int position, Object payload) {
        if (getItemCount() <= position && position < 0) {
            return;
        }
        SelectorItemEntity selectorItemEntity = (SelectorItemEntity) getItem(position);
        if (this.selectedSet.contains(selectorItemEntity)) {
            this.selectedSet.remove(selectorItemEntity);
        } else {
            this.selectedSet.add(selectorItemEntity);
        }
        notifyItemChanged(position, payload);
    }

    public final int getSelectedCount() {
        return this.selectedSet.size();
    }

    public final ArrayList<T> getSelectedList() {
        v2.o oVar = (ArrayList<T>) new ArrayList();
        Iterator<T> it = this.selectedSet.iterator();
        while (it.hasNext()) {
            oVar.add((SelectorItemEntity) it.next());
        }
        return oVar;
    }

    public final HashSet<T> getSelectedSet() {
        return this.selectedSet;
    }

    public final boolean isAllSelected() {
        if (this.selectedSet.size() == getItemCount() && getItemCount() > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: isEditMode, reason: from getter */
    public final boolean getIsEditMode() {
        return this.isEditMode;
    }

    public boolean isSelected(T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.selectedSet.contains(item);
    }

    public final void removeSelectedItem(Object payload) {
        Iterator<T> it = this.selectedSet.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            getData().remove(it.next());
        }
        this.selectedSet.clear();
        notifyItemRangeChanged(0, getItemCount(), payload);
    }

    public final void selectAll(Object payload) {
        Iterator it = getData().iterator();
        while (it.hasNext()) {
            this.selectedSet.add((SelectorItemEntity) it.next());
        }
        notifyItemRangeChanged(0, getItemCount(), payload);
    }

    public final void selectItem(T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.selectedSet.add(item);
    }

    public int selectedIndexOf(T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return CollectionsKt.indexOf(this.selectedSet, item);
    }

    public final void switchMode(boolean isEditMode, Object payload) {
        this.isEditMode = isEditMode;
        notifyItemRangeChanged(0, getItemCount(), payload);
    }

    public /* synthetic */ BaseSelectorListAdapter(int i10, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? new ArrayList() : list);
    }
}
