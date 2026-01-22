package com.qiahao.nextvideo.data.transfer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/transfer/TransferBanner;", "", "bannerUrl", "", "h5Url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBannerUrl", "()Ljava/lang/String;", "setBannerUrl", "(Ljava/lang/String;)V", "getH5Url", "setH5Url", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TransferBanner {

    @Nullable
    private String bannerUrl;

    @Nullable
    private String h5Url;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TransferBanner() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    public static /* synthetic */ TransferBanner copy$default(TransferBanner transferBanner, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transferBanner.bannerUrl;
        }
        if ((i & 2) != 0) {
            str2 = transferBanner.h5Url;
        }
        return transferBanner.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getH5Url() {
        return this.h5Url;
    }

    @NotNull
    public final TransferBanner copy(@Nullable String bannerUrl, @Nullable String h5Url) {
        return new TransferBanner(bannerUrl, h5Url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferBanner)) {
            return false;
        }
        TransferBanner transferBanner = (TransferBanner) other;
        return Intrinsics.areEqual(this.bannerUrl, transferBanner.bannerUrl) && Intrinsics.areEqual(this.h5Url, transferBanner.h5Url);
    }

    @Nullable
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    public final String getH5Url() {
        return this.h5Url;
    }

    public int hashCode() {
        String str = this.bannerUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.h5Url;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setBannerUrl(@Nullable String str) {
        this.bannerUrl = str;
    }

    public final void setH5Url(@Nullable String str) {
        this.h5Url = str;
    }

    @NotNull
    public String toString() {
        return "TransferBanner(bannerUrl=" + this.bannerUrl + ", h5Url=" + this.h5Url + ")";
    }

    public TransferBanner(@Nullable String str, @Nullable String str2) {
        this.bannerUrl = str;
        this.h5Url = str2;
    }

    public /* synthetic */ TransferBanner(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
