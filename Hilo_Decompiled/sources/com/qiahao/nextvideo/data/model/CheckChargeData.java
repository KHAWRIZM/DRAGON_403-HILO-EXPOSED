package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CheckChargeData;", "", "chargeLink", "", "inWhiteList", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getChargeLink", "()Ljava/lang/String;", "setChargeLink", "(Ljava/lang/String;)V", "getInWhiteList", "()Ljava/lang/Boolean;", "setInWhiteList", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/CheckChargeData;", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CheckChargeData {

    @Nullable
    private String chargeLink;

    @Nullable
    private Boolean inWhiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckChargeData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CheckChargeData copy$default(CheckChargeData checkChargeData, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkChargeData.chargeLink;
        }
        if ((i & 2) != 0) {
            bool = checkChargeData.inWhiteList;
        }
        return checkChargeData.copy(str, bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getChargeLink() {
        return this.chargeLink;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getInWhiteList() {
        return this.inWhiteList;
    }

    @NotNull
    public final CheckChargeData copy(@Nullable String chargeLink, @Nullable Boolean inWhiteList) {
        return new CheckChargeData(chargeLink, inWhiteList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckChargeData)) {
            return false;
        }
        CheckChargeData checkChargeData = (CheckChargeData) other;
        return Intrinsics.areEqual(this.chargeLink, checkChargeData.chargeLink) && Intrinsics.areEqual(this.inWhiteList, checkChargeData.inWhiteList);
    }

    @Nullable
    public final String getChargeLink() {
        return this.chargeLink;
    }

    @Nullable
    public final Boolean getInWhiteList() {
        return this.inWhiteList;
    }

    public int hashCode() {
        String str = this.chargeLink;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.inWhiteList;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final void setChargeLink(@Nullable String str) {
        this.chargeLink = str;
    }

    public final void setInWhiteList(@Nullable Boolean bool) {
        this.inWhiteList = bool;
    }

    @NotNull
    public String toString() {
        return "CheckChargeData(chargeLink=" + this.chargeLink + ", inWhiteList=" + this.inWhiteList + ")";
    }

    public CheckChargeData(@Nullable String str, @Nullable Boolean bool) {
        this.chargeLink = str;
        this.inWhiteList = bool;
    }

    public /* synthetic */ CheckChargeData(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool);
    }
}
