package com.qiahao.nextvideo.data.giftRecord;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/giftRecord/UploadGiftConfirm;", "", "giftDiamond", "", "effectUrl", "", "iconUrl", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getGiftDiamond", "()Ljava/lang/Long;", "setGiftDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEffectUrl", "()Ljava/lang/String;", "setEffectUrl", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/giftRecord/UploadGiftConfirm;", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UploadGiftConfirm {

    @Nullable
    private String effectUrl;

    @Nullable
    private Long giftDiamond;

    @Nullable
    private String iconUrl;

    public UploadGiftConfirm() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ UploadGiftConfirm copy$default(UploadGiftConfirm uploadGiftConfirm, Long l, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = uploadGiftConfirm.giftDiamond;
        }
        if ((i & 2) != 0) {
            str = uploadGiftConfirm.effectUrl;
        }
        if ((i & 4) != 0) {
            str2 = uploadGiftConfirm.iconUrl;
        }
        return uploadGiftConfirm.copy(l, str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getGiftDiamond() {
        return this.giftDiamond;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final UploadGiftConfirm copy(@Nullable Long giftDiamond, @Nullable String effectUrl, @Nullable String iconUrl) {
        return new UploadGiftConfirm(giftDiamond, effectUrl, iconUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadGiftConfirm)) {
            return false;
        }
        UploadGiftConfirm uploadGiftConfirm = (UploadGiftConfirm) other;
        return Intrinsics.areEqual(this.giftDiamond, uploadGiftConfirm.giftDiamond) && Intrinsics.areEqual(this.effectUrl, uploadGiftConfirm.effectUrl) && Intrinsics.areEqual(this.iconUrl, uploadGiftConfirm.iconUrl);
    }

    @Nullable
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    public final Long getGiftDiamond() {
        return this.giftDiamond;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public int hashCode() {
        Long l = this.giftDiamond;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.effectUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.iconUrl;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setEffectUrl(@Nullable String str) {
        this.effectUrl = str;
    }

    public final void setGiftDiamond(@Nullable Long l) {
        this.giftDiamond = l;
    }

    public final void setIconUrl(@Nullable String str) {
        this.iconUrl = str;
    }

    @NotNull
    public String toString() {
        return "UploadGiftConfirm(giftDiamond=" + this.giftDiamond + ", effectUrl=" + this.effectUrl + ", iconUrl=" + this.iconUrl + ")";
    }

    public UploadGiftConfirm(@Nullable Long l, @Nullable String str, @Nullable String str2) {
        this.giftDiamond = l;
        this.effectUrl = str;
        this.iconUrl = str2;
    }

    public /* synthetic */ UploadGiftConfirm(Long l, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
