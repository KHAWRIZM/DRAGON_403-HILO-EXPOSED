package com.qiahao.nextvideo.data.foodie;

import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieDrawResult;", "", "<init>", "()V", ExchangeDetailActivity.TYPE_DIAMOND, "", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "user", "Lcom/qiahao/base_common/model/common/User;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieDrawResult {

    @Nullable
    private Long diamond;

    @Nullable
    private User user;

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }
}
