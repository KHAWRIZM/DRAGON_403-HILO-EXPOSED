package com.qiahao.nextvideo.data.transfer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/data/transfer/TransferCheckData;", "", "shareIcon", "", "shareUrl", "rcUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getShareIcon", "()Ljava/lang/String;", "setShareIcon", "(Ljava/lang/String;)V", "getShareUrl", "setShareUrl", "getRcUrl", "setRcUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class TransferCheckData {

    @Nullable
    private String rcUrl;

    @Nullable
    private String shareIcon;

    @Nullable
    private String shareUrl;

    public TransferCheckData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TransferCheckData copy$default(TransferCheckData transferCheckData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transferCheckData.shareIcon;
        }
        if ((i & 2) != 0) {
            str2 = transferCheckData.shareUrl;
        }
        if ((i & 4) != 0) {
            str3 = transferCheckData.rcUrl;
        }
        return transferCheckData.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getShareIcon() {
        return this.shareIcon;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getRcUrl() {
        return this.rcUrl;
    }

    @NotNull
    public final TransferCheckData copy(@Nullable String shareIcon, @Nullable String shareUrl, @Nullable String rcUrl) {
        return new TransferCheckData(shareIcon, shareUrl, rcUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferCheckData)) {
            return false;
        }
        TransferCheckData transferCheckData = (TransferCheckData) other;
        return Intrinsics.areEqual(this.shareIcon, transferCheckData.shareIcon) && Intrinsics.areEqual(this.shareUrl, transferCheckData.shareUrl) && Intrinsics.areEqual(this.rcUrl, transferCheckData.rcUrl);
    }

    @Nullable
    public final String getRcUrl() {
        return this.rcUrl;
    }

    @Nullable
    public final String getShareIcon() {
        return this.shareIcon;
    }

    @Nullable
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public int hashCode() {
        String str = this.shareIcon;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.shareUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.rcUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setRcUrl(@Nullable String str) {
        this.rcUrl = str;
    }

    public final void setShareIcon(@Nullable String str) {
        this.shareIcon = str;
    }

    public final void setShareUrl(@Nullable String str) {
        this.shareUrl = str;
    }

    @NotNull
    public String toString() {
        return "TransferCheckData(shareIcon=" + this.shareIcon + ", shareUrl=" + this.shareUrl + ", rcUrl=" + this.rcUrl + ")";
    }

    public TransferCheckData(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.shareIcon = str;
        this.shareUrl = str2;
        this.rcUrl = str3;
    }

    public /* synthetic */ TransferCheckData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }
}
