package com.qiahao.nextvideo.data.foodie;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/Bet;", "", "<init>", "()V", "foodieId", "", "getFoodieId", "()I", "setFoodieId", "(I)V", "betDiamond", "", "getBetDiamond", "()Ljava/lang/Long;", "setBetDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "winDiamond", "getWinDiamond", "setWinDiamond", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Bet {
    private int foodieId;

    @Nullable
    private Long betDiamond = 0L;

    @Nullable
    private Long winDiamond = 0L;

    @Nullable
    public final Long getBetDiamond() {
        return this.betDiamond;
    }

    public final int getFoodieId() {
        return this.foodieId;
    }

    @Nullable
    public final Long getWinDiamond() {
        return this.winDiamond;
    }

    public final void setBetDiamond(@Nullable Long l) {
        this.betDiamond = l;
    }

    public final void setFoodieId(int i) {
        this.foodieId = i;
    }

    public final void setWinDiamond(@Nullable Long l) {
        this.winDiamond = l;
    }
}
