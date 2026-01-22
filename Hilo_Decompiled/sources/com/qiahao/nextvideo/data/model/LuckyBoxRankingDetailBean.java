package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyBoxRankingDetailBean;", "", "diamondNum", "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "<init>", "(ILcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getDiamondNum", "()I", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyBoxRankingDetailBean {
    private final int diamondNum;

    @NotNull
    private final UserSummaryInfo user;

    public LuckyBoxRankingDetailBean(int i, @NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        this.diamondNum = i;
        this.user = userSummaryInfo;
    }

    public static /* synthetic */ LuckyBoxRankingDetailBean copy$default(LuckyBoxRankingDetailBean luckyBoxRankingDetailBean, int i, UserSummaryInfo userSummaryInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = luckyBoxRankingDetailBean.diamondNum;
        }
        if ((i2 & 2) != 0) {
            userSummaryInfo = luckyBoxRankingDetailBean.user;
        }
        return luckyBoxRankingDetailBean.copy(i, userSummaryInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    @NotNull
    public final LuckyBoxRankingDetailBean copy(int diamondNum, @NotNull UserSummaryInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new LuckyBoxRankingDetailBean(diamondNum, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyBoxRankingDetailBean)) {
            return false;
        }
        LuckyBoxRankingDetailBean luckyBoxRankingDetailBean = (LuckyBoxRankingDetailBean) other;
        return this.diamondNum == luckyBoxRankingDetailBean.diamondNum && Intrinsics.areEqual(this.user, luckyBoxRankingDetailBean.user);
    }

    public final int getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public int hashCode() {
        return (this.diamondNum * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "LuckyBoxRankingDetailBean(diamondNum=" + this.diamondNum + ", user=" + this.user + ")";
    }
}
