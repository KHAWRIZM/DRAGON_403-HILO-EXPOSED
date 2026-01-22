package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J=\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitResultListItemBean;", "", "date", "", "fruitId", "", "myAward", "", "myStake", "round", "<init>", "(Ljava/lang/String;IJLjava/lang/Object;I)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFruitId", "()I", "setFruitId", "(I)V", "getMyAward", "()J", "setMyAward", "(J)V", "getMyStake", "()Ljava/lang/Object;", "setMyStake", "(Ljava/lang/Object;)V", "getRound", "setRound", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitResultListItemBean {

    @NotNull
    private String date;
    private int fruitId;
    private long myAward;

    @Nullable
    private Object myStake;
    private int round;

    public LuckyFruitResultListItemBean(@NotNull String str, int i, long j, @Nullable Object obj, int i2) {
        Intrinsics.checkNotNullParameter(str, "date");
        this.date = str;
        this.fruitId = i;
        this.myAward = j;
        this.myStake = obj;
        this.round = i2;
    }

    public static /* synthetic */ LuckyFruitResultListItemBean copy$default(LuckyFruitResultListItemBean luckyFruitResultListItemBean, String str, int i, long j, Object obj, int i2, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            str = luckyFruitResultListItemBean.date;
        }
        if ((i3 & 2) != 0) {
            i = luckyFruitResultListItemBean.fruitId;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            j = luckyFruitResultListItemBean.myAward;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            obj = luckyFruitResultListItemBean.myStake;
        }
        Object obj3 = obj;
        if ((i3 & 16) != 0) {
            i2 = luckyFruitResultListItemBean.round;
        }
        return luckyFruitResultListItemBean.copy(str, i4, j2, obj3, i2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFruitId() {
        return this.fruitId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getMyAward() {
        return this.myAward;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Object getMyStake() {
        return this.myStake;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRound() {
        return this.round;
    }

    @NotNull
    public final LuckyFruitResultListItemBean copy(@NotNull String date, int fruitId, long myAward, @Nullable Object myStake, int round) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new LuckyFruitResultListItemBean(date, fruitId, myAward, myStake, round);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitResultListItemBean)) {
            return false;
        }
        LuckyFruitResultListItemBean luckyFruitResultListItemBean = (LuckyFruitResultListItemBean) other;
        return Intrinsics.areEqual(this.date, luckyFruitResultListItemBean.date) && this.fruitId == luckyFruitResultListItemBean.fruitId && this.myAward == luckyFruitResultListItemBean.myAward && Intrinsics.areEqual(this.myStake, luckyFruitResultListItemBean.myStake) && this.round == luckyFruitResultListItemBean.round;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    public final int getFruitId() {
        return this.fruitId;
    }

    public final long getMyAward() {
        return this.myAward;
    }

    @Nullable
    public final Object getMyStake() {
        return this.myStake;
    }

    public final int getRound() {
        return this.round;
    }

    public int hashCode() {
        int hashCode = ((((this.date.hashCode() * 31) + this.fruitId) * 31) + c.a(this.myAward)) * 31;
        Object obj = this.myStake;
        return ((hashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.round;
    }

    public final void setDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final void setFruitId(int i) {
        this.fruitId = i;
    }

    public final void setMyAward(long j) {
        this.myAward = j;
    }

    public final void setMyStake(@Nullable Object obj) {
        this.myStake = obj;
    }

    public final void setRound(int i) {
        this.round = i;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitResultListItemBean(date=" + this.date + ", fruitId=" + this.fruitId + ", myAward=" + this.myAward + ", myStake=" + this.myStake + ", round=" + this.round + ")";
    }
}
