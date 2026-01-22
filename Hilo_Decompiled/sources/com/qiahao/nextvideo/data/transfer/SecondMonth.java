package com.qiahao.nextvideo.data.transfer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/data/transfer/SecondMonth;", "", "clients", "", "reCharges", "", "totalSales", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)V", "getClients", "()Ljava/lang/Integer;", "setClients", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReCharges", "()Ljava/lang/Long;", "setReCharges", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTotalSales", "setTotalSales", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/transfer/SecondMonth;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SecondMonth {

    @Nullable
    private Integer clients;

    @Nullable
    private Long reCharges;

    @Nullable
    private Long totalSales;

    public SecondMonth() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SecondMonth copy$default(SecondMonth secondMonth, Integer num, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = secondMonth.clients;
        }
        if ((i & 2) != 0) {
            l = secondMonth.reCharges;
        }
        if ((i & 4) != 0) {
            l2 = secondMonth.totalSales;
        }
        return secondMonth.copy(num, l, l2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getClients() {
        return this.clients;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getReCharges() {
        return this.reCharges;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getTotalSales() {
        return this.totalSales;
    }

    @NotNull
    public final SecondMonth copy(@Nullable Integer clients, @Nullable Long reCharges, @Nullable Long totalSales) {
        return new SecondMonth(clients, reCharges, totalSales);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SecondMonth)) {
            return false;
        }
        SecondMonth secondMonth = (SecondMonth) other;
        return Intrinsics.areEqual(this.clients, secondMonth.clients) && Intrinsics.areEqual(this.reCharges, secondMonth.reCharges) && Intrinsics.areEqual(this.totalSales, secondMonth.totalSales);
    }

    @Nullable
    public final Integer getClients() {
        return this.clients;
    }

    @Nullable
    public final Long getReCharges() {
        return this.reCharges;
    }

    @Nullable
    public final Long getTotalSales() {
        return this.totalSales;
    }

    public int hashCode() {
        Integer num = this.clients;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.reCharges;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.totalSales;
        return hashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public final void setClients(@Nullable Integer num) {
        this.clients = num;
    }

    public final void setReCharges(@Nullable Long l) {
        this.reCharges = l;
    }

    public final void setTotalSales(@Nullable Long l) {
        this.totalSales = l;
    }

    @NotNull
    public String toString() {
        return "SecondMonth(clients=" + this.clients + ", reCharges=" + this.reCharges + ", totalSales=" + this.totalSales + ")";
    }

    public SecondMonth(@Nullable Integer num, @Nullable Long l, @Nullable Long l2) {
        this.clients = num;
        this.reCharges = l;
        this.totalSales = l2;
    }

    public /* synthetic */ SecondMonth(Integer num, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0L : l, (i & 4) != 0 ? 0L : l2);
    }
}
