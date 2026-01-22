package com.qiahao.base_common.model.common;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003JE\u0010\u0011\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/qiahao/base_common/model/common/NetworkData;", "", "httpsUrl", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "wssUrl", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getHttpsUrl", "()Ljava/util/ArrayList;", "setHttpsUrl", "(Ljava/util/ArrayList;)V", "getWssUrl", "setWssUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class NetworkData {

    @Nullable
    private ArrayList<String> httpsUrl;

    @Nullable
    private ArrayList<String> wssUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkData copy$default(NetworkData networkData, ArrayList arrayList, ArrayList arrayList2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = networkData.httpsUrl;
        }
        if ((i10 & 2) != 0) {
            arrayList2 = networkData.wssUrl;
        }
        return networkData.copy(arrayList, arrayList2);
    }

    @Nullable
    public final ArrayList<String> component1() {
        return this.httpsUrl;
    }

    @Nullable
    public final ArrayList<String> component2() {
        return this.wssUrl;
    }

    @NotNull
    public final NetworkData copy(@Nullable ArrayList<String> httpsUrl, @Nullable ArrayList<String> wssUrl) {
        return new NetworkData(httpsUrl, wssUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkData)) {
            return false;
        }
        NetworkData networkData = (NetworkData) other;
        return Intrinsics.areEqual(this.httpsUrl, networkData.httpsUrl) && Intrinsics.areEqual(this.wssUrl, networkData.wssUrl);
    }

    @Nullable
    public final ArrayList<String> getHttpsUrl() {
        return this.httpsUrl;
    }

    @Nullable
    public final ArrayList<String> getWssUrl() {
        return this.wssUrl;
    }

    public int hashCode() {
        ArrayList<String> arrayList = this.httpsUrl;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        ArrayList<String> arrayList2 = this.wssUrl;
        return hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0);
    }

    public final void setHttpsUrl(@Nullable ArrayList<String> arrayList) {
        this.httpsUrl = arrayList;
    }

    public final void setWssUrl(@Nullable ArrayList<String> arrayList) {
        this.wssUrl = arrayList;
    }

    @NotNull
    public String toString() {
        return "NetworkData(httpsUrl=" + this.httpsUrl + ", wssUrl=" + this.wssUrl + ")";
    }

    public NetworkData(@Nullable ArrayList<String> arrayList, @Nullable ArrayList<String> arrayList2) {
        this.httpsUrl = arrayList;
        this.wssUrl = arrayList2;
    }

    public /* synthetic */ NetworkData(ArrayList arrayList, ArrayList arrayList2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : arrayList, (i10 & 2) != 0 ? null : arrayList2);
    }
}
