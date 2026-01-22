package com.qiahao.nextvideo.data.transfer;

import com.qiahao.nextvideo.ui.transfer.TransferCenterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/transfer/TransferMonth;", "", "clients", "", TransferCenterFragment.TYPE_DIAMONDS, "", "dollar", "totalC", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getClients", "()Ljava/lang/Integer;", "setClients", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDiamonds", "()Ljava/lang/Long;", "setDiamonds", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDollar", "setDollar", "getTotalC", "setTotalC", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/transfer/TransferMonth;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TransferMonth {

    @Nullable
    private Integer clients;

    @Nullable
    private Long diamonds;

    @Nullable
    private Long dollar;

    @Nullable
    private Long totalC;

    public TransferMonth() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TransferMonth copy$default(TransferMonth transferMonth, Integer num, Long l, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = transferMonth.clients;
        }
        if ((i & 2) != 0) {
            l = transferMonth.diamonds;
        }
        if ((i & 4) != 0) {
            l2 = transferMonth.dollar;
        }
        if ((i & 8) != 0) {
            l3 = transferMonth.totalC;
        }
        return transferMonth.copy(num, l, l2, l3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getClients() {
        return this.clients;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDiamonds() {
        return this.diamonds;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getDollar() {
        return this.dollar;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getTotalC() {
        return this.totalC;
    }

    @NotNull
    public final TransferMonth copy(@Nullable Integer clients, @Nullable Long diamonds, @Nullable Long dollar, @Nullable Long totalC) {
        return new TransferMonth(clients, diamonds, dollar, totalC);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferMonth)) {
            return false;
        }
        TransferMonth transferMonth = (TransferMonth) other;
        return Intrinsics.areEqual(this.clients, transferMonth.clients) && Intrinsics.areEqual(this.diamonds, transferMonth.diamonds) && Intrinsics.areEqual(this.dollar, transferMonth.dollar) && Intrinsics.areEqual(this.totalC, transferMonth.totalC);
    }

    @Nullable
    public final Integer getClients() {
        return this.clients;
    }

    @Nullable
    public final Long getDiamonds() {
        return this.diamonds;
    }

    @Nullable
    public final Long getDollar() {
        return this.dollar;
    }

    @Nullable
    public final Long getTotalC() {
        return this.totalC;
    }

    public int hashCode() {
        Integer num = this.clients;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.diamonds;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.dollar;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.totalC;
        return hashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public final void setClients(@Nullable Integer num) {
        this.clients = num;
    }

    public final void setDiamonds(@Nullable Long l) {
        this.diamonds = l;
    }

    public final void setDollar(@Nullable Long l) {
        this.dollar = l;
    }

    public final void setTotalC(@Nullable Long l) {
        this.totalC = l;
    }

    @NotNull
    public String toString() {
        return "TransferMonth(clients=" + this.clients + ", diamonds=" + this.diamonds + ", dollar=" + this.dollar + ", totalC=" + this.totalC + ")";
    }

    public TransferMonth(@Nullable Integer num, @Nullable Long l, @Nullable Long l2, @Nullable Long l3) {
        this.clients = num;
        this.diamonds = l;
        this.dollar = l2;
        this.totalC = l3;
    }

    public /* synthetic */ TransferMonth(Integer num, Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : l3);
    }
}
