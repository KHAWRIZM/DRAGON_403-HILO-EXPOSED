package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CountryTop3ContributeAllBean;", "", "userDiamond", "", "Lcom/qiahao/nextvideo/data/model/CountryTop3ContributeBean;", "countryIcon", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getUserDiamond", "()Ljava/util/List;", "getCountryIcon", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CountryTop3ContributeAllBean {

    @NotNull
    private final String countryIcon;

    @NotNull
    private final List<CountryTop3ContributeBean> userDiamond;

    public CountryTop3ContributeAllBean(@NotNull List<CountryTop3ContributeBean> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "userDiamond");
        Intrinsics.checkNotNullParameter(str, "countryIcon");
        this.userDiamond = list;
        this.countryIcon = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CountryTop3ContributeAllBean copy$default(CountryTop3ContributeAllBean countryTop3ContributeAllBean, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = countryTop3ContributeAllBean.userDiamond;
        }
        if ((i & 2) != 0) {
            str = countryTop3ContributeAllBean.countryIcon;
        }
        return countryTop3ContributeAllBean.copy(list, str);
    }

    @NotNull
    public final List<CountryTop3ContributeBean> component1() {
        return this.userDiamond;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    public final CountryTop3ContributeAllBean copy(@NotNull List<CountryTop3ContributeBean> userDiamond, @NotNull String countryIcon) {
        Intrinsics.checkNotNullParameter(userDiamond, "userDiamond");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        return new CountryTop3ContributeAllBean(userDiamond, countryIcon);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryTop3ContributeAllBean)) {
            return false;
        }
        CountryTop3ContributeAllBean countryTop3ContributeAllBean = (CountryTop3ContributeAllBean) other;
        return Intrinsics.areEqual(this.userDiamond, countryTop3ContributeAllBean.userDiamond) && Intrinsics.areEqual(this.countryIcon, countryTop3ContributeAllBean.countryIcon);
    }

    @NotNull
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    public final List<CountryTop3ContributeBean> getUserDiamond() {
        return this.userDiamond;
    }

    public int hashCode() {
        return (this.userDiamond.hashCode() * 31) + this.countryIcon.hashCode();
    }

    @NotNull
    public String toString() {
        return "CountryTop3ContributeAllBean(userDiamond=" + this.userDiamond + ", countryIcon=" + this.countryIcon + ")";
    }
}
