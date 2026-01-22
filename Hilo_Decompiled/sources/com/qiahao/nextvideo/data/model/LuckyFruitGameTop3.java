package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitGameTop3;", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "<init>", "(JLcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getDiamond", "()J", "setDiamond", "(J)V", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "setUser", "(Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitGameTop3 {
    private long diamond;

    @NotNull
    private UserSummaryInfo user;

    public LuckyFruitGameTop3(long j, @NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        this.diamond = j;
        this.user = userSummaryInfo;
    }

    public static /* synthetic */ LuckyFruitGameTop3 copy$default(LuckyFruitGameTop3 luckyFruitGameTop3, long j, UserSummaryInfo userSummaryInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = luckyFruitGameTop3.diamond;
        }
        if ((i & 2) != 0) {
            userSummaryInfo = luckyFruitGameTop3.user;
        }
        return luckyFruitGameTop3.copy(j, userSummaryInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    @NotNull
    public final LuckyFruitGameTop3 copy(long diamond, @NotNull UserSummaryInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new LuckyFruitGameTop3(diamond, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitGameTop3)) {
            return false;
        }
        LuckyFruitGameTop3 luckyFruitGameTop3 = (LuckyFruitGameTop3) other;
        return this.diamond == luckyFruitGameTop3.diamond && Intrinsics.areEqual(this.user, luckyFruitGameTop3.user);
    }

    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public int hashCode() {
        return (c.a(this.diamond) * 31) + this.user.hashCode();
    }

    public final void setDiamond(long j) {
        this.diamond = j;
    }

    public final void setUser(@NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "<set-?>");
        this.user = userSummaryInfo;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitGameTop3(diamond=" + this.diamond + ", user=" + this.user + ")";
    }
}
