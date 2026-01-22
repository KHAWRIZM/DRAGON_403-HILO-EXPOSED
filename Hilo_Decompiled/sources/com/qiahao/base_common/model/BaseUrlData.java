package com.qiahao.base_common.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/model/BaseUrlData;", "", "apiURLs", "", "", "wsURLs", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getApiURLs", "()Ljava/util/List;", "setApiURLs", "(Ljava/util/List;)V", "getWsURLs", "setWsURLs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class BaseUrlData {

    @Nullable
    private List<String> apiURLs;

    @Nullable
    private List<String> wsURLs;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseUrlData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseUrlData copy$default(BaseUrlData baseUrlData, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = baseUrlData.apiURLs;
        }
        if ((i10 & 2) != 0) {
            list2 = baseUrlData.wsURLs;
        }
        return baseUrlData.copy(list, list2);
    }

    @Nullable
    public final List<String> component1() {
        return this.apiURLs;
    }

    @Nullable
    public final List<String> component2() {
        return this.wsURLs;
    }

    @NotNull
    public final BaseUrlData copy(@Nullable List<String> apiURLs, @Nullable List<String> wsURLs) {
        return new BaseUrlData(apiURLs, wsURLs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseUrlData)) {
            return false;
        }
        BaseUrlData baseUrlData = (BaseUrlData) other;
        return Intrinsics.areEqual(this.apiURLs, baseUrlData.apiURLs) && Intrinsics.areEqual(this.wsURLs, baseUrlData.wsURLs);
    }

    @Nullable
    public final List<String> getApiURLs() {
        return this.apiURLs;
    }

    @Nullable
    public final List<String> getWsURLs() {
        return this.wsURLs;
    }

    public int hashCode() {
        List<String> list = this.apiURLs;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.wsURLs;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setApiURLs(@Nullable List<String> list) {
        this.apiURLs = list;
    }

    public final void setWsURLs(@Nullable List<String> list) {
        this.wsURLs = list;
    }

    @NotNull
    public String toString() {
        return "BaseUrlData(apiURLs=" + this.apiURLs + ", wsURLs=" + this.wsURLs + ")";
    }

    public BaseUrlData(@Nullable List<String> list, @Nullable List<String> list2) {
        this.apiURLs = list;
        this.wsURLs = list2;
    }

    public /* synthetic */ BaseUrlData(List list, List list2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : list2);
    }
}
