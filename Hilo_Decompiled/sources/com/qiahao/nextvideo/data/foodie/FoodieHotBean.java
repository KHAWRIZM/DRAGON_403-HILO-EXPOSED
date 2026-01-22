package com.qiahao.nextvideo.data.foodie;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieHotBean;", "", "<init>", "()V", "foodieId", "", "getFoodieId", "()I", "setFoodieId", "(I)V", "hot", "", "getHot", "()Z", "setHot", "(Z)V", "flamesNumber", "getFlamesNumber", "setFlamesNumber", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieHotBean {
    private int flamesNumber;
    private int foodieId;
    private boolean hot;

    public final int getFlamesNumber() {
        return this.flamesNumber;
    }

    public final int getFoodieId() {
        return this.foodieId;
    }

    public final boolean getHot() {
        return this.hot;
    }

    public final void setFlamesNumber(int i) {
        this.flamesNumber = i;
    }

    public final void setFoodieId(int i) {
        this.foodieId = i;
    }

    public final void setHot(boolean z) {
        this.hot = z;
    }
}
