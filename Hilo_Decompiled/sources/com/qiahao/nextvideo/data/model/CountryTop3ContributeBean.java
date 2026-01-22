package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CountryTop3ContributeBean;", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "<init>", "(JLcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getDiamond", "()J", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CountryTop3ContributeBean {
    private final long diamond;

    @NotNull
    private final UserSummaryInfo user;

    public CountryTop3ContributeBean(long j, @NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        this.diamond = j;
        this.user = userSummaryInfo;
    }

    public static /* synthetic */ CountryTop3ContributeBean copy$default(CountryTop3ContributeBean countryTop3ContributeBean, long j, UserSummaryInfo userSummaryInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = countryTop3ContributeBean.diamond;
        }
        if ((i & 2) != 0) {
            userSummaryInfo = countryTop3ContributeBean.user;
        }
        return countryTop3ContributeBean.copy(j, userSummaryInfo);
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
    public final CountryTop3ContributeBean copy(long diamond, @NotNull UserSummaryInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new CountryTop3ContributeBean(diamond, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryTop3ContributeBean)) {
            return false;
        }
        CountryTop3ContributeBean countryTop3ContributeBean = (CountryTop3ContributeBean) other;
        return this.diamond == countryTop3ContributeBean.diamond && Intrinsics.areEqual(this.user, countryTop3ContributeBean.user);
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

    @NotNull
    public String toString() {
        return "CountryTop3ContributeBean(diamond=" + this.diamond + ", user=" + this.user + ")";
    }
}
