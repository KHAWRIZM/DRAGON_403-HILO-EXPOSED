package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitResultMyRecord;", "", "list", "", "Lcom/qiahao/nextvideo/data/model/LuckyFruitResultMyRecordItemBean;", "total", "", "profitToday", "<init>", "(Ljava/util/List;JJ)V", "getList", "()Ljava/util/List;", "getTotal", "()J", "getProfitToday", "setProfitToday", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitResultMyRecord {

    @Nullable
    private final List<LuckyFruitResultMyRecordItemBean> list;
    private long profitToday;
    private final long total;

    public LuckyFruitResultMyRecord(@Nullable List<LuckyFruitResultMyRecordItemBean> list, long j, long j2) {
        this.list = list;
        this.total = j;
        this.profitToday = j2;
    }

    public static /* synthetic */ LuckyFruitResultMyRecord copy$default(LuckyFruitResultMyRecord luckyFruitResultMyRecord, List list, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = luckyFruitResultMyRecord.list;
        }
        if ((i & 2) != 0) {
            j = luckyFruitResultMyRecord.total;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = luckyFruitResultMyRecord.profitToday;
        }
        return luckyFruitResultMyRecord.copy(list, j3, j2);
    }

    @Nullable
    public final List<LuckyFruitResultMyRecordItemBean> component1() {
        return this.list;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final long getProfitToday() {
        return this.profitToday;
    }

    @NotNull
    public final LuckyFruitResultMyRecord copy(@Nullable List<LuckyFruitResultMyRecordItemBean> list, long total, long profitToday) {
        return new LuckyFruitResultMyRecord(list, total, profitToday);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitResultMyRecord)) {
            return false;
        }
        LuckyFruitResultMyRecord luckyFruitResultMyRecord = (LuckyFruitResultMyRecord) other;
        return Intrinsics.areEqual(this.list, luckyFruitResultMyRecord.list) && this.total == luckyFruitResultMyRecord.total && this.profitToday == luckyFruitResultMyRecord.profitToday;
    }

    @Nullable
    public final List<LuckyFruitResultMyRecordItemBean> getList() {
        return this.list;
    }

    public final long getProfitToday() {
        return this.profitToday;
    }

    public final long getTotal() {
        return this.total;
    }

    public int hashCode() {
        List<LuckyFruitResultMyRecordItemBean> list = this.list;
        return ((((list == null ? 0 : list.hashCode()) * 31) + c.a(this.total)) * 31) + c.a(this.profitToday);
    }

    public final void setProfitToday(long j) {
        this.profitToday = j;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitResultMyRecord(list=" + this.list + ", total=" + this.total + ", profitToday=" + this.profitToday + ")";
    }
}
