package com.qiahao.nextvideo.data.foodie;

import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;", "", "<init>", "()V", "foodieId", "", "getFoodieId", "()I", "setFoodieId", "(I)V", ExchangeDetailActivity.TYPE_DIAMOND, "", "getDiamond", "()J", "setDiamond", "(J)V", "rate", "getRate", "setRate", "hasBet", "", "getHasBet", "()Z", "setHasBet", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieBetBean {
    private long diamond;
    private int foodieId;
    private boolean hasBet;
    private int rate = 5;

    public final long getDiamond() {
        return this.diamond;
    }

    public final int getFoodieId() {
        return this.foodieId;
    }

    public final boolean getHasBet() {
        return this.hasBet;
    }

    public final int getRate() {
        return this.rate;
    }

    public final void setDiamond(long j) {
        this.diamond = j;
    }

    public final void setFoodieId(int i) {
        this.foodieId = i;
    }

    public final void setHasBet(boolean z) {
        this.hasBet = z;
    }

    public final void setRate(int i) {
        this.rate = i;
    }
}
