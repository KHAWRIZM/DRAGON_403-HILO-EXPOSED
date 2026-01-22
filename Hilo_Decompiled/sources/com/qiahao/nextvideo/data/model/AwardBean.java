package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AwardBean;", "", "propertyUrl", "", "headdress1Url", "headdress2Url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPropertyUrl", "()Ljava/lang/String;", "getHeaddress1Url", "getHeaddress2Url", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AwardBean {

    @NotNull
    private final String headdress1Url;

    @NotNull
    private final String headdress2Url;

    @NotNull
    private final String propertyUrl;

    public AwardBean(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "propertyUrl");
        Intrinsics.checkNotNullParameter(str2, "headdress1Url");
        Intrinsics.checkNotNullParameter(str3, "headdress2Url");
        this.propertyUrl = str;
        this.headdress1Url = str2;
        this.headdress2Url = str3;
    }

    public static /* synthetic */ AwardBean copy$default(AwardBean awardBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = awardBean.propertyUrl;
        }
        if ((i & 2) != 0) {
            str2 = awardBean.headdress1Url;
        }
        if ((i & 4) != 0) {
            str3 = awardBean.headdress2Url;
        }
        return awardBean.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPropertyUrl() {
        return this.propertyUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getHeaddress1Url() {
        return this.headdress1Url;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getHeaddress2Url() {
        return this.headdress2Url;
    }

    @NotNull
    public final AwardBean copy(@NotNull String propertyUrl, @NotNull String headdress1Url, @NotNull String headdress2Url) {
        Intrinsics.checkNotNullParameter(propertyUrl, "propertyUrl");
        Intrinsics.checkNotNullParameter(headdress1Url, "headdress1Url");
        Intrinsics.checkNotNullParameter(headdress2Url, "headdress2Url");
        return new AwardBean(propertyUrl, headdress1Url, headdress2Url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AwardBean)) {
            return false;
        }
        AwardBean awardBean = (AwardBean) other;
        return Intrinsics.areEqual(this.propertyUrl, awardBean.propertyUrl) && Intrinsics.areEqual(this.headdress1Url, awardBean.headdress1Url) && Intrinsics.areEqual(this.headdress2Url, awardBean.headdress2Url);
    }

    @NotNull
    public final String getHeaddress1Url() {
        return this.headdress1Url;
    }

    @NotNull
    public final String getHeaddress2Url() {
        return this.headdress2Url;
    }

    @NotNull
    public final String getPropertyUrl() {
        return this.propertyUrl;
    }

    public int hashCode() {
        return (((this.propertyUrl.hashCode() * 31) + this.headdress1Url.hashCode()) * 31) + this.headdress2Url.hashCode();
    }

    @NotNull
    public String toString() {
        return "AwardBean(propertyUrl=" + this.propertyUrl + ", headdress1Url=" + this.headdress1Url + ", headdress2Url=" + this.headdress2Url + ")";
    }
}
