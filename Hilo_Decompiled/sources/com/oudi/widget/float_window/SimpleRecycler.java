package com.oudi.widget.float_window;

import com.oudi.widget.float_window.FloatWindowLayout;
import com.oudi.widget.float_window.RecyclerPool;
import com.oudi.widget.float_window.SimpleRecycler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/oudi/widget/float_window/SimpleRecycler;", "Lcom/oudi/widget/float_window/FloatWindowLayout$Recycler;", "maxSize", "", "<init>", "(I)V", "getMaxSize", "()I", "pool", "Lcom/oudi/widget/float_window/RecyclerPool;", "getPool", "()Lcom/oudi/widget/float_window/RecyclerPool;", "pool$delegate", "Lkotlin/Lazy;", "get", "Lcom/oudi/widget/float_window/ItemView;", "itemViewType", "tryRecycle", "", "windowLayout", "Lcom/oudi/widget/float_window/IFloatWindowLayout;", "itemView", "onCleared", "", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SimpleRecycler extends FloatWindowLayout.Recycler {
    private final int maxSize;

    /* renamed from: pool$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy pool = LazyKt.lazy(new Function0() { // from class: va.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            RecyclerPool pool_delegate$lambda$0;
            pool_delegate$lambda$0 = SimpleRecycler.pool_delegate$lambda$0(SimpleRecycler.this);
            return pool_delegate$lambda$0;
        }
    });

    public SimpleRecycler(int i10) {
        this.maxSize = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecyclerPool pool_delegate$lambda$0(SimpleRecycler simpleRecycler) {
        return new RecyclerPool(simpleRecycler.maxSize);
    }

    @Override // com.oudi.widget.float_window.FloatWindowLayout.Recycler
    @Nullable
    public ItemView get(int itemViewType) {
        return getPool().getItemView(itemViewType);
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    @NotNull
    public final RecyclerPool getPool() {
        return (RecyclerPool) this.pool.getValue();
    }

    @Override // com.oudi.widget.float_window.FloatWindowLayout.Recycler
    public void onCleared() {
        getPool().clear();
    }

    @Override // com.oudi.widget.float_window.FloatWindowLayout.Recycler
    public boolean tryRecycle(@NotNull IFloatWindowLayout windowLayout, @NotNull ItemView itemView) {
        Intrinsics.checkNotNullParameter(windowLayout, "windowLayout");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (windowLayout.getQueueCount() == 0) {
            getPool().clear();
            return false;
        }
        Integer itemViewType = itemView.getItemViewType();
        if (itemViewType == null) {
            return false;
        }
        return getPool().putItemView(itemViewType.intValue(), itemView);
    }
}
