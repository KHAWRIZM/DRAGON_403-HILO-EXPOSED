package com.qiahao.nextvideo.data.foodie;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J2\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieRepeatItem;", "", "fruitId", "", "foodieId", "stake", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getFruitId", "()Ljava/lang/Integer;", "setFruitId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFoodieId", "setFoodieId", "getStake", "()Ljava/lang/Long;", "setStake", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/foodie/FoodieRepeatItem;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FoodieRepeatItem {

    @Nullable
    private Integer foodieId;

    @Nullable
    private Integer fruitId;

    @Nullable
    private Long stake;

    public FoodieRepeatItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FoodieRepeatItem copy$default(FoodieRepeatItem foodieRepeatItem, Integer num, Integer num2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            num = foodieRepeatItem.fruitId;
        }
        if ((i & 2) != 0) {
            num2 = foodieRepeatItem.foodieId;
        }
        if ((i & 4) != 0) {
            l = foodieRepeatItem.stake;
        }
        return foodieRepeatItem.copy(num, num2, l);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getFruitId() {
        return this.fruitId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getFoodieId() {
        return this.foodieId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getStake() {
        return this.stake;
    }

    @NotNull
    public final FoodieRepeatItem copy(@Nullable Integer fruitId, @Nullable Integer foodieId, @Nullable Long stake) {
        return new FoodieRepeatItem(fruitId, foodieId, stake);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FoodieRepeatItem)) {
            return false;
        }
        FoodieRepeatItem foodieRepeatItem = (FoodieRepeatItem) other;
        return Intrinsics.areEqual(this.fruitId, foodieRepeatItem.fruitId) && Intrinsics.areEqual(this.foodieId, foodieRepeatItem.foodieId) && Intrinsics.areEqual(this.stake, foodieRepeatItem.stake);
    }

    @Nullable
    public final Integer getFoodieId() {
        return this.foodieId;
    }

    @Nullable
    public final Integer getFruitId() {
        return this.fruitId;
    }

    @Nullable
    public final Long getStake() {
        return this.stake;
    }

    public int hashCode() {
        Integer num = this.fruitId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.foodieId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.stake;
        return hashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final void setFoodieId(@Nullable Integer num) {
        this.foodieId = num;
    }

    public final void setFruitId(@Nullable Integer num) {
        this.fruitId = num;
    }

    public final void setStake(@Nullable Long l) {
        this.stake = l;
    }

    @NotNull
    public String toString() {
        return "FoodieRepeatItem(fruitId=" + this.fruitId + ", foodieId=" + this.foodieId + ", stake=" + this.stake + ")";
    }

    public FoodieRepeatItem(@Nullable Integer num, @Nullable Integer num2, @Nullable Long l) {
        this.fruitId = num;
        this.foodieId = num2;
        this.stake = l;
    }

    public /* synthetic */ FoodieRepeatItem(Integer num, Integer num2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? 0L : l);
    }
}
