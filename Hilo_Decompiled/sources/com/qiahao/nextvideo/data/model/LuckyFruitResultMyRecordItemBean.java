package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003JM\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0005HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001a¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitResultMyRecordItemBean;", "", "date", "", "fruitId", "", "myAward", "", "myStake", "", "Lcom/qiahao/nextvideo/data/model/MyStake;", "round", "startTime", "<init>", "(Ljava/lang/String;IJLjava/util/List;IJ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFruitId", "()I", "setFruitId", "(I)V", "getMyAward", "()J", "setMyAward", "(J)V", "getMyStake", "()Ljava/util/List;", "setMyStake", "(Ljava/util/List;)V", "getRound", "setRound", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitResultMyRecordItemBean {

    @NotNull
    private String date;
    private int fruitId;
    private long myAward;

    @Nullable
    private List<MyStake> myStake;
    private int round;
    private long startTime;

    public LuckyFruitResultMyRecordItemBean(@NotNull String str, int i, long j, @Nullable List<MyStake> list, int i2, long j2) {
        Intrinsics.checkNotNullParameter(str, "date");
        this.date = str;
        this.fruitId = i;
        this.myAward = j;
        this.myStake = list;
        this.round = i2;
        this.startTime = j2;
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
    public final List<MyStake> component4() {
        return this.myStake;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRound() {
        return this.round;
    }

    /* renamed from: component6, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final LuckyFruitResultMyRecordItemBean copy(@NotNull String date, int fruitId, long myAward, @Nullable List<MyStake> myStake, int round, long startTime) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new LuckyFruitResultMyRecordItemBean(date, fruitId, myAward, myStake, round, startTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitResultMyRecordItemBean)) {
            return false;
        }
        LuckyFruitResultMyRecordItemBean luckyFruitResultMyRecordItemBean = (LuckyFruitResultMyRecordItemBean) other;
        return Intrinsics.areEqual(this.date, luckyFruitResultMyRecordItemBean.date) && this.fruitId == luckyFruitResultMyRecordItemBean.fruitId && this.myAward == luckyFruitResultMyRecordItemBean.myAward && Intrinsics.areEqual(this.myStake, luckyFruitResultMyRecordItemBean.myStake) && this.round == luckyFruitResultMyRecordItemBean.round && this.startTime == luckyFruitResultMyRecordItemBean.startTime;
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
    public final List<MyStake> getMyStake() {
        return this.myStake;
    }

    public final int getRound() {
        return this.round;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int hashCode = ((((this.date.hashCode() * 31) + this.fruitId) * 31) + c.a(this.myAward)) * 31;
        List<MyStake> list = this.myStake;
        return ((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.round) * 31) + c.a(this.startTime);
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

    public final void setMyStake(@Nullable List<MyStake> list) {
        this.myStake = list;
    }

    public final void setRound(int i) {
        this.round = i;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitResultMyRecordItemBean(date=" + this.date + ", fruitId=" + this.fruitId + ", myAward=" + this.myAward + ", myStake=" + this.myStake + ", round=" + this.round + ", startTime=" + this.startTime + ")";
    }
}
