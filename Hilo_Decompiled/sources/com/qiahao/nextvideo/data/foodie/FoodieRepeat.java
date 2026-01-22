package com.qiahao.nextvideo.data.foodie;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010JD\u0010\u0019\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieRepeat;", "", "autoBets", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/foodie/FoodieRepeatItem;", "Lkotlin/collections/ArrayList;", "diamondNum", "", "stake", "<init>", "(Ljava/util/ArrayList;Ljava/lang/Long;Ljava/lang/Long;)V", "getAutoBets", "()Ljava/util/ArrayList;", "setAutoBets", "(Ljava/util/ArrayList;)V", "getDiamondNum", "()Ljava/lang/Long;", "setDiamondNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStake", "setStake", "component1", "component2", "component3", "copy", "(Ljava/util/ArrayList;Ljava/lang/Long;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/foodie/FoodieRepeat;", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FoodieRepeat {

    @Nullable
    private ArrayList<FoodieRepeatItem> autoBets;

    @Nullable
    private Long diamondNum;

    @Nullable
    private Long stake;

    public FoodieRepeat() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FoodieRepeat copy$default(FoodieRepeat foodieRepeat, ArrayList arrayList, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = foodieRepeat.autoBets;
        }
        if ((i & 2) != 0) {
            l = foodieRepeat.diamondNum;
        }
        if ((i & 4) != 0) {
            l2 = foodieRepeat.stake;
        }
        return foodieRepeat.copy(arrayList, l, l2);
    }

    @Nullable
    public final ArrayList<FoodieRepeatItem> component1() {
        return this.autoBets;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getStake() {
        return this.stake;
    }

    @NotNull
    public final FoodieRepeat copy(@Nullable ArrayList<FoodieRepeatItem> autoBets, @Nullable Long diamondNum, @Nullable Long stake) {
        return new FoodieRepeat(autoBets, diamondNum, stake);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FoodieRepeat)) {
            return false;
        }
        FoodieRepeat foodieRepeat = (FoodieRepeat) other;
        return Intrinsics.areEqual(this.autoBets, foodieRepeat.autoBets) && Intrinsics.areEqual(this.diamondNum, foodieRepeat.diamondNum) && Intrinsics.areEqual(this.stake, foodieRepeat.stake);
    }

    @Nullable
    public final ArrayList<FoodieRepeatItem> getAutoBets() {
        return this.autoBets;
    }

    @Nullable
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final Long getStake() {
        return this.stake;
    }

    public int hashCode() {
        ArrayList<FoodieRepeatItem> arrayList = this.autoBets;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        Long l = this.diamondNum;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.stake;
        return hashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public final void setAutoBets(@Nullable ArrayList<FoodieRepeatItem> arrayList) {
        this.autoBets = arrayList;
    }

    public final void setDiamondNum(@Nullable Long l) {
        this.diamondNum = l;
    }

    public final void setStake(@Nullable Long l) {
        this.stake = l;
    }

    @NotNull
    public String toString() {
        return "FoodieRepeat(autoBets=" + this.autoBets + ", diamondNum=" + this.diamondNum + ", stake=" + this.stake + ")";
    }

    public FoodieRepeat(@Nullable ArrayList<FoodieRepeatItem> arrayList, @Nullable Long l, @Nullable Long l2) {
        this.autoBets = arrayList;
        this.diamondNum = l;
        this.stake = l2;
    }

    public /* synthetic */ FoodieRepeat(ArrayList arrayList, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }
}
