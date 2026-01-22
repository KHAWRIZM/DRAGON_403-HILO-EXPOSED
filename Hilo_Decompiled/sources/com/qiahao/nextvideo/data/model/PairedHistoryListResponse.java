package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PairedHistoryListResponse;", "", "list", "", "Lcom/qiahao/nextvideo/data/model/PairedHistoryItem;", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PairedHistoryListResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    @c("list")
    private final List<PairedHistoryItem> list;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PairedHistoryListResponse$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/nextvideo/data/model/PairedHistoryListResponse;", "pageIndex", "", "pageSize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPairedHistoryItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PairedHistoryItem.kt\ncom/qiahao/nextvideo/data/model/PairedHistoryListResponse$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,54:1\n1563#2:55\n1634#2,3:56\n*S KotlinDebug\n*F\n+ 1 PairedHistoryItem.kt\ncom/qiahao/nextvideo/data/model/PairedHistoryListResponse$Companion\n*L\n49#1:55\n49#1:56,3\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PairedHistoryListResponse fake(int pageIndex, int pageSize) {
            IntRange until = RangesKt.until(0, pageSize);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            IntIterator it = until.iterator();
            while (it.hasNext()) {
                it.nextInt();
                arrayList.add(PairedHistoryItem.INSTANCE.fake());
            }
            return new PairedHistoryListResponse(arrayList);
        }

        private Companion() {
        }
    }

    public PairedHistoryListResponse(@NotNull List<PairedHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PairedHistoryListResponse copy$default(PairedHistoryListResponse pairedHistoryListResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pairedHistoryListResponse.list;
        }
        return pairedHistoryListResponse.copy(list);
    }

    @NotNull
    public final List<PairedHistoryItem> component1() {
        return this.list;
    }

    @NotNull
    public final PairedHistoryListResponse copy(@NotNull List<PairedHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new PairedHistoryListResponse(list);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PairedHistoryListResponse) && Intrinsics.areEqual(this.list, ((PairedHistoryListResponse) other).list);
    }

    @NotNull
    public final List<PairedHistoryItem> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "PairedHistoryListResponse(list=" + this.list + ")";
    }
}
