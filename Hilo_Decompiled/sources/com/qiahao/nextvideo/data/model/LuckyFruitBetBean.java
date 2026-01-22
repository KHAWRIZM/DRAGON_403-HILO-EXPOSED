package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JF\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitBetBean;", "", "stake", "", "diamondNum", "", "amount", "round", "ts", "<init>", "(IJLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)V", "getStake", "()I", "getDiamondNum", "()J", "getAmount", "()Ljava/lang/Long;", "setAmount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getRound", "()Ljava/lang/Integer;", "setRound", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTs", "setTs", "component1", "component2", "component3", "component4", "component5", "copy", "(IJLjava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/model/LuckyFruitBetBean;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitBetBean {

    @Nullable
    private Long amount;
    private final long diamondNum;

    @Nullable
    private Integer round;
    private final int stake;

    @Nullable
    private Long ts;

    public LuckyFruitBetBean(int i, long j, @Nullable Long l, @Nullable Integer num, @Nullable Long l2) {
        this.stake = i;
        this.diamondNum = j;
        this.amount = l;
        this.round = num;
        this.ts = l2;
    }

    public static /* synthetic */ LuckyFruitBetBean copy$default(LuckyFruitBetBean luckyFruitBetBean, int i, long j, Long l, Integer num, Long l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = luckyFruitBetBean.stake;
        }
        if ((i2 & 2) != 0) {
            j = luckyFruitBetBean.diamondNum;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            l = luckyFruitBetBean.amount;
        }
        Long l3 = l;
        if ((i2 & 8) != 0) {
            num = luckyFruitBetBean.round;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            l2 = luckyFruitBetBean.ts;
        }
        return luckyFruitBetBean.copy(i, j2, l3, num2, l2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStake() {
        return this.stake;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getAmount() {
        return this.amount;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getRound() {
        return this.round;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getTs() {
        return this.ts;
    }

    @NotNull
    public final LuckyFruitBetBean copy(int stake, long diamondNum, @Nullable Long amount, @Nullable Integer round, @Nullable Long ts) {
        return new LuckyFruitBetBean(stake, diamondNum, amount, round, ts);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitBetBean)) {
            return false;
        }
        LuckyFruitBetBean luckyFruitBetBean = (LuckyFruitBetBean) other;
        return this.stake == luckyFruitBetBean.stake && this.diamondNum == luckyFruitBetBean.diamondNum && Intrinsics.areEqual(this.amount, luckyFruitBetBean.amount) && Intrinsics.areEqual(this.round, luckyFruitBetBean.round) && Intrinsics.areEqual(this.ts, luckyFruitBetBean.ts);
    }

    @Nullable
    public final Long getAmount() {
        return this.amount;
    }

    public final long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final Integer getRound() {
        return this.round;
    }

    public final int getStake() {
        return this.stake;
    }

    @Nullable
    public final Long getTs() {
        return this.ts;
    }

    public int hashCode() {
        int a = ((this.stake * 31) + c.a(this.diamondNum)) * 31;
        Long l = this.amount;
        int hashCode = (a + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.round;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l2 = this.ts;
        return hashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public final void setAmount(@Nullable Long l) {
        this.amount = l;
    }

    public final void setRound(@Nullable Integer num) {
        this.round = num;
    }

    public final void setTs(@Nullable Long l) {
        this.ts = l;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitBetBean(stake=" + this.stake + ", diamondNum=" + this.diamondNum + ", amount=" + this.amount + ", round=" + this.round + ", ts=" + this.ts + ")";
    }

    public /* synthetic */ LuckyFruitBetBean(int i, long j, Long l, Integer num, Long l2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, j, (i2 & 4) != 0 ? null : l, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : l2);
    }
}
