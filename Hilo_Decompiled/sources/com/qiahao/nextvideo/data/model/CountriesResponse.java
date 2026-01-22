package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.Country;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CountriesResponse;", "", "common", "", "Lcom/qiahao/base_common/model/common/Country;", "noCommon", "recommend", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCommon", "()Ljava/util/List;", "getNoCommon", "getRecommend", "setRecommend", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CountriesResponse {

    @NotNull
    @c("common")
    private final List<Country> common;

    @NotNull
    @c("noCommon")
    private final List<Country> noCommon;

    @Nullable
    private List<Country> recommend;

    public CountriesResponse(@NotNull List<Country> list, @NotNull List<Country> list2, @Nullable List<Country> list3) {
        Intrinsics.checkNotNullParameter(list, "common");
        Intrinsics.checkNotNullParameter(list2, "noCommon");
        this.common = list;
        this.noCommon = list2;
        this.recommend = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CountriesResponse copy$default(CountriesResponse countriesResponse, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = countriesResponse.common;
        }
        if ((i & 2) != 0) {
            list2 = countriesResponse.noCommon;
        }
        if ((i & 4) != 0) {
            list3 = countriesResponse.recommend;
        }
        return countriesResponse.copy(list, list2, list3);
    }

    @NotNull
    public final List<Country> component1() {
        return this.common;
    }

    @NotNull
    public final List<Country> component2() {
        return this.noCommon;
    }

    @Nullable
    public final List<Country> component3() {
        return this.recommend;
    }

    @NotNull
    public final CountriesResponse copy(@NotNull List<Country> common, @NotNull List<Country> noCommon, @Nullable List<Country> recommend) {
        Intrinsics.checkNotNullParameter(common, "common");
        Intrinsics.checkNotNullParameter(noCommon, "noCommon");
        return new CountriesResponse(common, noCommon, recommend);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountriesResponse)) {
            return false;
        }
        CountriesResponse countriesResponse = (CountriesResponse) other;
        return Intrinsics.areEqual(this.common, countriesResponse.common) && Intrinsics.areEqual(this.noCommon, countriesResponse.noCommon) && Intrinsics.areEqual(this.recommend, countriesResponse.recommend);
    }

    @NotNull
    public final List<Country> getCommon() {
        return this.common;
    }

    @NotNull
    public final List<Country> getNoCommon() {
        return this.noCommon;
    }

    @Nullable
    public final List<Country> getRecommend() {
        return this.recommend;
    }

    public int hashCode() {
        int hashCode = ((this.common.hashCode() * 31) + this.noCommon.hashCode()) * 31;
        List<Country> list = this.recommend;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public final void setRecommend(@Nullable List<Country> list) {
        this.recommend = list;
    }

    @NotNull
    public String toString() {
        return "CountriesResponse(common=" + this.common + ", noCommon=" + this.noCommon + ", recommend=" + this.recommend + ")";
    }

    public /* synthetic */ CountriesResponse(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? null : list3);
    }
}
