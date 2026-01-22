package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PowerTop3Bean;", "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", ExchangeDetailActivity.TYPE_DIAMOND, "", "<init>", "(Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;J)V", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "getDiamond", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PowerTop3Bean {
    private final long diamond;

    @NotNull
    private final UserSummaryInfo user;

    public PowerTop3Bean(@NotNull UserSummaryInfo userSummaryInfo, long j) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        this.user = userSummaryInfo;
        this.diamond = j;
    }

    public static /* synthetic */ PowerTop3Bean copy$default(PowerTop3Bean powerTop3Bean, UserSummaryInfo userSummaryInfo, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            userSummaryInfo = powerTop3Bean.user;
        }
        if ((i & 2) != 0) {
            j = powerTop3Bean.diamond;
        }
        return powerTop3Bean.copy(userSummaryInfo, j);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final PowerTop3Bean copy(@NotNull UserSummaryInfo user, long diamond) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new PowerTop3Bean(user, diamond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PowerTop3Bean)) {
            return false;
        }
        PowerTop3Bean powerTop3Bean = (PowerTop3Bean) other;
        return Intrinsics.areEqual(this.user, powerTop3Bean.user) && this.diamond == powerTop3Bean.diamond;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public int hashCode() {
        return (this.user.hashCode() * 31) + c.a(this.diamond);
    }

    @NotNull
    public String toString() {
        return "PowerTop3Bean(user=" + this.user + ", diamond=" + this.diamond + ")";
    }
}
