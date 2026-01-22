package com.qiahao.base_common.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B;\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\tHÆ\u0003JH\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/qiahao/base_common/model/ApiListData;", "T", "", "data", "", FirebaseAnalytics.Param.INDEX, "", "total", "hasNextPage", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTotal", "setTotal", "getHasNextPage", "()Z", "setHasNextPage", "(Z)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/qiahao/base_common/model/ApiListData;", "equals", "other", "hashCode", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ApiListData<T> {

    @Nullable
    private List<? extends T> data;
    private boolean hasNextPage;

    @Nullable
    private Integer index;

    @Nullable
    private Integer total;

    public ApiListData() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiListData copy$default(ApiListData apiListData, List list, Integer num, Integer num2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = apiListData.data;
        }
        if ((i10 & 2) != 0) {
            num = apiListData.index;
        }
        if ((i10 & 4) != 0) {
            num2 = apiListData.total;
        }
        if ((i10 & 8) != 0) {
            z10 = apiListData.hasNextPage;
        }
        return apiListData.copy(list, num, num2, z10);
    }

    @Nullable
    public final List<T> component1() {
        return this.data;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getIndex() {
        return this.index;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    @NotNull
    public final ApiListData<T> copy(@Nullable List<? extends T> data, @Nullable Integer index, @Nullable Integer total, boolean hasNextPage) {
        return new ApiListData<>(data, index, total, hasNextPage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiListData)) {
            return false;
        }
        ApiListData apiListData = (ApiListData) other;
        return Intrinsics.areEqual(this.data, apiListData.data) && Intrinsics.areEqual(this.index, apiListData.index) && Intrinsics.areEqual(this.total, apiListData.total) && this.hasNextPage == apiListData.hasNextPage;
    }

    @Nullable
    public final List<T> getData() {
        return this.data;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    @Nullable
    public final Integer getIndex() {
        return this.index;
    }

    @Nullable
    public final Integer getTotal() {
        return this.total;
    }

    public int hashCode() {
        List<? extends T> list = this.data;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.index;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.total;
        return ((hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + q2.a.a(this.hasNextPage);
    }

    public final void setData(@Nullable List<? extends T> list) {
        this.data = list;
    }

    public final void setHasNextPage(boolean z10) {
        this.hasNextPage = z10;
    }

    public final void setIndex(@Nullable Integer num) {
        this.index = num;
    }

    public final void setTotal(@Nullable Integer num) {
        this.total = num;
    }

    @NotNull
    public String toString() {
        return "ApiListData(data=" + this.data + ", index=" + this.index + ", total=" + this.total + ", hasNextPage=" + this.hasNextPage + ")";
    }

    public ApiListData(@Nullable List<? extends T> list, @Nullable Integer num, @Nullable Integer num2, boolean z10) {
        this.data = list;
        this.index = num;
        this.total = num2;
        this.hasNextPage = z10;
    }

    public /* synthetic */ ApiListData(List list, Integer num, Integer num2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : num2, (i10 & 8) != 0 ? true : z10);
    }
}
