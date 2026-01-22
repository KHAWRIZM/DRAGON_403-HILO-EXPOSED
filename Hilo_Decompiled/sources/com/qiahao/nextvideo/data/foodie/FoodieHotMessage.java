package com.qiahao.nextvideo.data.foodie;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieHotMessage;", "", "hotFoodies", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/foodie/FoodieHotBean;", "Lkotlin/collections/ArrayList;", "round", "", "<init>", "(Ljava/util/ArrayList;Ljava/lang/Integer;)V", "getHotFoodies", "()Ljava/util/ArrayList;", "setHotFoodies", "(Ljava/util/ArrayList;)V", "getRound", "()Ljava/lang/Integer;", "setRound", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/ArrayList;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/foodie/FoodieHotMessage;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FoodieHotMessage {

    @Nullable
    private ArrayList<FoodieHotBean> hotFoodies;

    @Nullable
    private Integer round;

    /* JADX WARN: Multi-variable type inference failed */
    public FoodieHotMessage() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FoodieHotMessage copy$default(FoodieHotMessage foodieHotMessage, ArrayList arrayList, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = foodieHotMessage.hotFoodies;
        }
        if ((i & 2) != 0) {
            num = foodieHotMessage.round;
        }
        return foodieHotMessage.copy(arrayList, num);
    }

    @Nullable
    public final ArrayList<FoodieHotBean> component1() {
        return this.hotFoodies;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getRound() {
        return this.round;
    }

    @NotNull
    public final FoodieHotMessage copy(@Nullable ArrayList<FoodieHotBean> hotFoodies, @Nullable Integer round) {
        return new FoodieHotMessage(hotFoodies, round);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FoodieHotMessage)) {
            return false;
        }
        FoodieHotMessage foodieHotMessage = (FoodieHotMessage) other;
        return Intrinsics.areEqual(this.hotFoodies, foodieHotMessage.hotFoodies) && Intrinsics.areEqual(this.round, foodieHotMessage.round);
    }

    @Nullable
    public final ArrayList<FoodieHotBean> getHotFoodies() {
        return this.hotFoodies;
    }

    @Nullable
    public final Integer getRound() {
        return this.round;
    }

    public int hashCode() {
        ArrayList<FoodieHotBean> arrayList = this.hotFoodies;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        Integer num = this.round;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setHotFoodies(@Nullable ArrayList<FoodieHotBean> arrayList) {
        this.hotFoodies = arrayList;
    }

    public final void setRound(@Nullable Integer num) {
        this.round = num;
    }

    @NotNull
    public String toString() {
        return "FoodieHotMessage(hotFoodies=" + this.hotFoodies + ", round=" + this.round + ")";
    }

    public FoodieHotMessage(@Nullable ArrayList<FoodieHotBean> arrayList, @Nullable Integer num) {
        this.hotFoodies = arrayList;
        this.round = num;
    }

    public /* synthetic */ FoodieHotMessage(ArrayList arrayList, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : num);
    }
}
