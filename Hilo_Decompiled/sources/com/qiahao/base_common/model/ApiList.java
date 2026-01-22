package com.qiahao.base_common.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B/\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J<\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/qiahao/base_common/model/ApiList;", "T", "", "data", "", "nextPageIndex", "", "hasNextPage", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Z)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getNextPageIndex", "()Ljava/lang/Integer;", "setNextPageIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasNextPage", "()Z", "setHasNextPage", "(Z)V", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Z)Lcom/qiahao/base_common/model/ApiList;", "equals", "other", "hashCode", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ApiList<T> {

    @Nullable
    private List<? extends T> data;
    private boolean hasNextPage;

    @Nullable
    private Integer nextPageIndex;

    public ApiList() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiList copy$default(ApiList apiList, List list, Integer num, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = apiList.data;
        }
        if ((i10 & 2) != 0) {
            num = apiList.nextPageIndex;
        }
        if ((i10 & 4) != 0) {
            z10 = apiList.hasNextPage;
        }
        return apiList.copy(list, num, z10);
    }

    @Nullable
    public final List<T> component1() {
        return this.data;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getNextPageIndex() {
        return this.nextPageIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    @NotNull
    public final ApiList<T> copy(@Nullable List<? extends T> data, @Nullable Integer nextPageIndex, boolean hasNextPage) {
        return new ApiList<>(data, nextPageIndex, hasNextPage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiList)) {
            return false;
        }
        ApiList apiList = (ApiList) other;
        return Intrinsics.areEqual(this.data, apiList.data) && Intrinsics.areEqual(this.nextPageIndex, apiList.nextPageIndex) && this.hasNextPage == apiList.hasNextPage;
    }

    @Nullable
    public final List<T> getData() {
        return this.data;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    @Nullable
    public final Integer getNextPageIndex() {
        return this.nextPageIndex;
    }

    public int hashCode() {
        List<? extends T> list = this.data;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.nextPageIndex;
        return ((hashCode + (num != null ? num.hashCode() : 0)) * 31) + q2.a.a(this.hasNextPage);
    }

    public final void setData(@Nullable List<? extends T> list) {
        this.data = list;
    }

    public final void setHasNextPage(boolean z10) {
        this.hasNextPage = z10;
    }

    public final void setNextPageIndex(@Nullable Integer num) {
        this.nextPageIndex = num;
    }

    @NotNull
    public String toString() {
        return "ApiList(data=" + this.data + ", nextPageIndex=" + this.nextPageIndex + ", hasNextPage=" + this.hasNextPage + ")";
    }

    public ApiList(@Nullable List<? extends T> list, @Nullable Integer num, boolean z10) {
        this.data = list;
        this.nextPageIndex = num;
        this.hasNextPage = z10;
    }

    public /* synthetic */ ApiList(List list, Integer num, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? true : z10);
    }
}
