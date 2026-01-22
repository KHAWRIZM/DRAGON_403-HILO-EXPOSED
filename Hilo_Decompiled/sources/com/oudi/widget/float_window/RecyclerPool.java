package com.oudi.widget.float_window;

import android.util.SparseArray;
import com.oudi.widget.float_window.RecyclerPool;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\u0006\u0010\u0016\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/oudi/widget/float_window/RecyclerPool;", "", "maxSize", "", "<init>", "(I)V", "scrap", "Landroid/util/SparseArray;", "Lcom/oudi/widget/float_window/RecyclerPool$ScrapData;", "getScrap", "()Landroid/util/SparseArray;", "scrap$delegate", "Lkotlin/Lazy;", "setMaxRecycledViews", "", "getItemView", "Lcom/oudi/widget/float_window/ItemView;", "viewType", "putItemView", "", "itemView", "getScrapDataForType", "clear", "ScrapData", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RecyclerPool {
    private int maxSize;

    /* renamed from: scrap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy scrap;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oudi/widget/float_window/RecyclerPool$ScrapData;", "", "maxSize", "", "<init>", "(I)V", "scrapHeap", "Ljava/util/ArrayList;", "Lcom/oudi/widget/float_window/ItemView;", "Lkotlin/collections/ArrayList;", "setMaxSize", "", "get", "add", "", "itemView", "clear", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nRecyclerPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecyclerPool.kt\ncom/oudi/widget/float_window/RecyclerPool$ScrapData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,87:1\n1863#2,2:88\n*S KotlinDebug\n*F\n+ 1 RecyclerPool.kt\ncom/oudi/widget/float_window/RecyclerPool$ScrapData\n*L\n81#1:88,2\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class ScrapData {
        private int maxSize;

        @NotNull
        private final ArrayList<ItemView> scrapHeap = new ArrayList<>();

        public ScrapData(int i10) {
            this.maxSize = i10;
        }

        public final boolean add(@NotNull ItemView itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            if (this.scrapHeap.size() >= this.maxSize) {
                return false;
            }
            this.scrapHeap.add(itemView);
            return true;
        }

        public final void clear() {
            Iterator<T> it = this.scrapHeap.iterator();
            while (it.hasNext()) {
                ((ItemView) it.next()).onCleared();
            }
            this.scrapHeap.clear();
        }

        @Nullable
        public final ItemView get() {
            ArrayList<ItemView> arrayList = this.scrapHeap;
            if (arrayList != null && !arrayList.isEmpty()) {
                return this.scrapHeap.remove(0);
            }
            return null;
        }

        public final void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
            while (this.scrapHeap.size() > maxSize) {
                this.scrapHeap.remove(r0.size() - 1);
            }
        }
    }

    public RecyclerPool() {
        this(0, 1, null);
    }

    private final SparseArray<ScrapData> getScrap() {
        return (SparseArray) this.scrap.getValue();
    }

    private final ScrapData getScrapDataForType(int viewType) {
        ScrapData scrapData = getScrap().get(viewType);
        if (scrapData == null) {
            ScrapData scrapData2 = new ScrapData(this.maxSize);
            getScrap().put(viewType, scrapData2);
            return scrapData2;
        }
        return scrapData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SparseArray scrap_delegate$lambda$0() {
        return new SparseArray();
    }

    public final void clear() {
        int size = getScrap().size();
        for (int i10 = 0; i10 < size; i10++) {
            ScrapData valueAt = getScrap().valueAt(i10);
            if (valueAt != null) {
                valueAt.clear();
            }
        }
        getScrap().clear();
    }

    @Nullable
    public final ItemView getItemView(int viewType) {
        ScrapData scrapData = getScrap().get(viewType);
        if (scrapData != null) {
            return scrapData.get();
        }
        return null;
    }

    public final boolean putItemView(int viewType, @NotNull ItemView itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        return getScrapDataForType(viewType).add(itemView);
    }

    public final void setMaxRecycledViews(int maxSize) {
        this.maxSize = maxSize;
        int size = getScrap().size();
        for (int i10 = 0; i10 < size; i10++) {
            getScrap().valueAt(i10).setMaxSize(maxSize);
        }
    }

    public RecyclerPool(int i10) {
        this.maxSize = i10;
        this.scrap = LazyKt.lazy(new Function0() { // from class: va.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SparseArray scrap_delegate$lambda$0;
                scrap_delegate$lambda$0 = RecyclerPool.scrap_delegate$lambda$0();
                return scrap_delegate$lambda$0;
            }
        });
    }

    public /* synthetic */ RecyclerPool(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 3 : i10);
    }
}
