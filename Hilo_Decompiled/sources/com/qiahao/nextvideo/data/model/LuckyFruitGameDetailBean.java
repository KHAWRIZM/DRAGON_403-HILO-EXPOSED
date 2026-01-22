package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\u001d\u0010?\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00108Jª\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\u00162\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0005HÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00102R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006M"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitGameDetailBean;", "", "date", "", "fruitId", "", "myAward", "", "myStake", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/MyStake;", "Lkotlin/collections/ArrayList;", "remainSecond", "round", "status", "top3", "", "Lcom/qiahao/nextvideo/data/model/LuckyFruitGameTop3;", "ratio", "Lcom/qiahao/nextvideo/data/model/LuckyFruitRation;", "betNums", "autoBet", "", "<init>", "(Ljava/lang/String;IJLjava/util/ArrayList;IIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getFruitId", "()I", "setFruitId", "(I)V", "getMyAward", "()J", "setMyAward", "(J)V", "getMyStake", "()Ljava/util/ArrayList;", "setMyStake", "(Ljava/util/ArrayList;)V", "getRemainSecond", "setRemainSecond", "getRound", "setRound", "getStatus", "setStatus", "getTop3", "()Ljava/util/List;", "setTop3", "(Ljava/util/List;)V", "getRatio", "setRatio", "getBetNums", "setBetNums", "getAutoBet", "()Ljava/lang/Boolean;", "setAutoBet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;IJLjava/util/ArrayList;IIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/LuckyFruitGameDetailBean;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitGameDetailBean {

    @Nullable
    private Boolean autoBet;

    @Nullable
    private List<Integer> betNums;

    @NotNull
    private String date;
    private int fruitId;
    private long myAward;

    @Nullable
    private ArrayList<MyStake> myStake;

    @Nullable
    private List<LuckyFruitRation> ratio;
    private int remainSecond;
    private int round;
    private int status;

    @Nullable
    private List<LuckyFruitGameTop3> top3;

    public LuckyFruitGameDetailBean(@NotNull String str, int i, long j, @Nullable ArrayList<MyStake> arrayList, int i2, int i3, int i4, @Nullable List<LuckyFruitGameTop3> list, @Nullable List<LuckyFruitRation> list2, @Nullable List<Integer> list3, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "date");
        this.date = str;
        this.fruitId = i;
        this.myAward = j;
        this.myStake = arrayList;
        this.remainSecond = i2;
        this.round = i3;
        this.status = i4;
        this.top3 = list;
        this.ratio = list2;
        this.betNums = list3;
        this.autoBet = bool;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final List<Integer> component10() {
        return this.betNums;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getAutoBet() {
        return this.autoBet;
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
    public final ArrayList<MyStake> component4() {
        return this.myStake;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRemainSecond() {
        return this.remainSecond;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRound() {
        return this.round;
    }

    /* renamed from: component7, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final List<LuckyFruitGameTop3> component8() {
        return this.top3;
    }

    @Nullable
    public final List<LuckyFruitRation> component9() {
        return this.ratio;
    }

    @NotNull
    public final LuckyFruitGameDetailBean copy(@NotNull String date, int fruitId, long myAward, @Nullable ArrayList<MyStake> myStake, int remainSecond, int round, int status, @Nullable List<LuckyFruitGameTop3> top3, @Nullable List<LuckyFruitRation> ratio, @Nullable List<Integer> betNums, @Nullable Boolean autoBet) {
        Intrinsics.checkNotNullParameter(date, "date");
        return new LuckyFruitGameDetailBean(date, fruitId, myAward, myStake, remainSecond, round, status, top3, ratio, betNums, autoBet);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitGameDetailBean)) {
            return false;
        }
        LuckyFruitGameDetailBean luckyFruitGameDetailBean = (LuckyFruitGameDetailBean) other;
        return Intrinsics.areEqual(this.date, luckyFruitGameDetailBean.date) && this.fruitId == luckyFruitGameDetailBean.fruitId && this.myAward == luckyFruitGameDetailBean.myAward && Intrinsics.areEqual(this.myStake, luckyFruitGameDetailBean.myStake) && this.remainSecond == luckyFruitGameDetailBean.remainSecond && this.round == luckyFruitGameDetailBean.round && this.status == luckyFruitGameDetailBean.status && Intrinsics.areEqual(this.top3, luckyFruitGameDetailBean.top3) && Intrinsics.areEqual(this.ratio, luckyFruitGameDetailBean.ratio) && Intrinsics.areEqual(this.betNums, luckyFruitGameDetailBean.betNums) && Intrinsics.areEqual(this.autoBet, luckyFruitGameDetailBean.autoBet);
    }

    @Nullable
    public final Boolean getAutoBet() {
        return this.autoBet;
    }

    @Nullable
    public final List<Integer> getBetNums() {
        return this.betNums;
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
    public final ArrayList<MyStake> getMyStake() {
        return this.myStake;
    }

    @Nullable
    public final List<LuckyFruitRation> getRatio() {
        return this.ratio;
    }

    public final int getRemainSecond() {
        return this.remainSecond;
    }

    public final int getRound() {
        return this.round;
    }

    public final int getStatus() {
        return this.status;
    }

    @Nullable
    public final List<LuckyFruitGameTop3> getTop3() {
        return this.top3;
    }

    public int hashCode() {
        int hashCode = ((((this.date.hashCode() * 31) + this.fruitId) * 31) + c.a(this.myAward)) * 31;
        ArrayList<MyStake> arrayList = this.myStake;
        int hashCode2 = (((((((hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31) + this.remainSecond) * 31) + this.round) * 31) + this.status) * 31;
        List<LuckyFruitGameTop3> list = this.top3;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<LuckyFruitRation> list2 = this.ratio;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Integer> list3 = this.betNums;
        int hashCode5 = (hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool = this.autoBet;
        return hashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setAutoBet(@Nullable Boolean bool) {
        this.autoBet = bool;
    }

    public final void setBetNums(@Nullable List<Integer> list) {
        this.betNums = list;
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

    public final void setMyStake(@Nullable ArrayList<MyStake> arrayList) {
        this.myStake = arrayList;
    }

    public final void setRatio(@Nullable List<LuckyFruitRation> list) {
        this.ratio = list;
    }

    public final void setRemainSecond(int i) {
        this.remainSecond = i;
    }

    public final void setRound(int i) {
        this.round = i;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTop3(@Nullable List<LuckyFruitGameTop3> list) {
        this.top3 = list;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitGameDetailBean(date=" + this.date + ", fruitId=" + this.fruitId + ", myAward=" + this.myAward + ", myStake=" + this.myStake + ", remainSecond=" + this.remainSecond + ", round=" + this.round + ", status=" + this.status + ", top3=" + this.top3 + ", ratio=" + this.ratio + ", betNums=" + this.betNums + ", autoBet=" + this.autoBet + ")";
    }

    public /* synthetic */ LuckyFruitGameDetailBean(String str, int i, long j, ArrayList arrayList, int i2, int i3, int i4, List list, List list2, List list3, Boolean bool, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, j, arrayList, i2, i3, i4, list, (i5 & 256) != 0 ? null : list2, (i5 & 512) != 0 ? null : list3, (i5 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? Boolean.FALSE : bool);
    }
}
