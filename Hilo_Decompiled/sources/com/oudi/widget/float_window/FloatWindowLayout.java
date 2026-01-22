package com.oudi.widget.float_window;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.oudi.widget.float_window.FloatWindowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u000289B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u000bJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0018J\u0016\u0010#\u001a\u00020\u001f2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010&J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0018H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u000bH\u0002J\u000e\u00100\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020.H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020\u001fH\u0002J\u0006\u00105\u001a\u00020\u001fJ\b\u00106\u001a\u00020\u001fH\u0002J\u0006\u00107\u001a\u00020\u001fR\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006:"}, d2 = {"Lcom/oudi/widget/float_window/FloatWindowLayout;", "Landroid/widget/LinearLayout;", "Lcom/oudi/widget/float_window/IFloatWindowLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "maxVisibleCount", "adapter", "Lcom/oudi/widget/float_window/FloatWindowLayout$Adapter;", "recycler", "Lcom/oudi/widget/float_window/FloatWindowLayout$Recycler;", "isAppendMode", "", "queue", "Ljava/util/ArrayList;", "Lcom/oudi/widget/float_window/ItemData;", "Lkotlin/collections/ArrayList;", "getQueue", "()Ljava/util/ArrayList;", "queue$delegate", "Lkotlin/Lazy;", "setAppendMode", "", "setMaxVisibleCount", "count", "setRecycler", "addData", "data", "list", "", "addQueue", "loop", "tryMergeInView", "tryMergeInQueue", "showItem", "itemData", "getItemView", "Lcom/oudi/widget/float_window/ItemView;", "itemViewType", "setAdapter", "dismissItem", "itemView", "getQueueCount", "initLayoutTransition", "clearQueue", "checkMainThread", "onCleared", "Adapter", "Recycler", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFloatWindowLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatWindowLayout.kt\ncom/oudi/widget/float_window/FloatWindowLayout\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,311:1\n1863#2,2:312\n1863#2,2:314\n1#3:316\n*S KotlinDebug\n*F\n+ 1 FloatWindowLayout.kt\ncom/oudi/widget/float_window/FloatWindowLayout\n*L\n103#1:312,2\n168#1:314,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class FloatWindowLayout extends LinearLayout implements IFloatWindowLayout {

    @Nullable
    private Adapter adapter;
    private boolean isAppendMode;
    private int maxVisibleCount;

    /* renamed from: queue$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy queue;

    @Nullable
    private Recycler recycler;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/oudi/widget/float_window/FloatWindowLayout$Adapter;", "", "<init>", "()V", "onCreateItemView", "Lcom/oudi/widget/float_window/ItemView;", "context", "Landroid/content/Context;", "itemViewType", "", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static abstract class Adapter {
        @Nullable
        public abstract ItemView onCreateItemView(@NotNull Context context, int itemViewType);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/oudi/widget/float_window/FloatWindowLayout$Recycler;", "", "<init>", "()V", "get", "Lcom/oudi/widget/float_window/ItemView;", "itemViewType", "", "tryRecycle", "", "windowLayout", "Lcom/oudi/widget/float_window/IFloatWindowLayout;", "itemView", "onCleared", "", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static abstract class Recycler {
        @Nullable
        public abstract ItemView get(int itemViewType);

        public abstract void onCleared();

        public abstract boolean tryRecycle(@NotNull IFloatWindowLayout windowLayout, @NotNull ItemView itemView);
    }

    public FloatWindowLayout(@Nullable Context context) {
        this(context, null);
    }

    private final void addQueue(ItemData data) {
        int size = getQueue().size();
        for (int i10 = 0; i10 < size; i10++) {
            ItemData itemData = getQueue().get(i10);
            Intrinsics.checkNotNullExpressionValue(itemData, "get(...)");
            if (data.getItemPriority() > itemData.getItemPriority()) {
                getQueue().add(i10, data);
                return;
            }
        }
        getQueue().add(data);
    }

    private final void checkMainThread() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
        } else {
            throw new IllegalStateException("Not in applications main thread");
        }
    }

    private final ItemView getItemView(int itemViewType) {
        ItemView itemView;
        Recycler recycler = this.recycler;
        if (recycler != null) {
            itemView = recycler.get(itemViewType);
        } else {
            itemView = null;
        }
        if (itemView == null) {
            Log.d(getClass().getSimpleName(), "getItemView() new");
            Adapter adapter = this.adapter;
            if (adapter == null) {
                return null;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            return adapter.onCreateItemView(context, itemViewType);
        }
        Log.d(getClass().getSimpleName(), "getItemView() recycler");
        return itemView;
    }

    private final ArrayList<ItemData> getQueue() {
        return (ArrayList) this.queue.getValue();
    }

    private final void initLayoutTransition() {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(2, null);
        layoutTransition.setAnimator(3, null);
        setLayoutTransition(layoutTransition);
    }

    private final void loop() {
        if (getQueue().isEmpty() || getChildCount() >= this.maxVisibleCount) {
            return;
        }
        ItemData remove = getQueue().remove(0);
        Intrinsics.checkNotNullExpressionValue(remove, "removeAt(...)");
        showItem(remove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList queue_delegate$lambda$0() {
        return new ArrayList();
    }

    private final void showItem(ItemData itemData) {
        ItemView itemView = getItemView(itemData.getItemViewType());
        if (itemView == null) {
            Log.e(getClass().getSimpleName(), "未找到有效的条目视图 data:" + itemData);
            loop();
            return;
        }
        if (this.isAppendMode) {
            addView(itemView.getView());
        } else {
            addView(itemView.getView(), 0);
        }
        itemView.onAttached(this, itemData);
    }

    private final boolean tryMergeInQueue(ItemData data) {
        ArrayList<ItemData> queue;
        MergeItemData mergeItemData;
        if ((data instanceof MergeItemData) && (queue = getQueue()) != null && !queue.isEmpty()) {
            for (ItemData itemData : getQueue()) {
                if (itemData instanceof MergeItemData) {
                    mergeItemData = (MergeItemData) itemData;
                } else {
                    mergeItemData = null;
                }
                if (mergeItemData != null && mergeItemData.tryMerge(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean tryMergeInView(ItemData data) {
        ItemView itemView;
        if (!(data instanceof MergeItemData) || getChildCount() <= 0) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            KeyEvent.Callback childAt = getChildAt(i10);
            if (childAt instanceof ItemView) {
                itemView = (ItemView) childAt;
            } else {
                itemView = null;
            }
            if (itemView != null && itemView.tryMerge((MergeItemData) data)) {
                return true;
            }
        }
        return false;
    }

    public final void addData(@NotNull ItemData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        checkMainThread();
        if (tryMergeInView(data) || tryMergeInQueue(data)) {
            return;
        }
        addQueue(data);
        loop();
    }

    public final void clearQueue() {
        checkMainThread();
        getQueue().clear();
    }

    @Override // com.oudi.widget.float_window.IFloatWindowLayout
    public void dismissItem(@NotNull ItemView itemView) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        checkMainThread();
        itemView.onDetached();
        Recycler recycler = this.recycler;
        if (recycler != null) {
            bool = Boolean.valueOf(recycler.tryRecycle(this, itemView));
        } else {
            bool = null;
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            itemView.onCleared();
        }
        removeView(itemView.getView());
        loop();
    }

    @Override // com.oudi.widget.float_window.IFloatWindowLayout
    public int getQueueCount() {
        return getQueue().size();
    }

    public final void onCleared() {
        ItemView itemView;
        checkMainThread();
        getQueue().clear();
        while (getChildCount() > 0) {
            KeyEvent.Callback childAt = getChildAt(0);
            if (childAt instanceof ItemView) {
                itemView = (ItemView) childAt;
            } else {
                itemView = null;
            }
            if (itemView != null) {
                itemView.onDetached();
            }
            if (itemView != null) {
                itemView.onCleared();
            }
            removeViewAt(0);
        }
    }

    public final void setAdapter(@NotNull Adapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    public final void setAppendMode(boolean isAppendMode) {
        this.isAppendMode = isAppendMode;
    }

    @NotNull
    public final FloatWindowLayout setMaxVisibleCount(int count) {
        this.maxVisibleCount = count;
        return this;
    }

    @NotNull
    public final FloatWindowLayout setRecycler(@Nullable Recycler recycler) {
        this.recycler = recycler;
        return this;
    }

    public FloatWindowLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatWindowLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public FloatWindowLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.maxVisibleCount = 1;
        this.queue = LazyKt.lazy(new Function0() { // from class: va.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList queue_delegate$lambda$0;
                queue_delegate$lambda$0 = FloatWindowLayout.queue_delegate$lambda$0();
                return queue_delegate$lambda$0;
            }
        });
        initLayoutTransition();
    }

    public final void addData(@Nullable List<? extends ItemData> list) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                addData((ItemData) it.next());
            }
        }
    }
}
