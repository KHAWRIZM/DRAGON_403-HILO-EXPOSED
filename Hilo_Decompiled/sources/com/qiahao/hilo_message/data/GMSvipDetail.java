package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/qiahao/hilo_message/data/GMSvipDetail;", "", "svipLevel", "", "mysteryCode", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getSvipLevel", "()Ljava/lang/Long;", "setSvipLevel", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMysteryCode", "()Ljava/lang/String;", "setMysteryCode", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/qiahao/hilo_message/data/GMSvipDetail;", "equals", "", "other", "hashCode", "", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GMSvipDetail {

    @Nullable
    private String mysteryCode;

    @Nullable
    private Long svipLevel;

    /* JADX WARN: Multi-variable type inference failed */
    public GMSvipDetail() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GMSvipDetail copy$default(GMSvipDetail gMSvipDetail, Long l10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = gMSvipDetail.svipLevel;
        }
        if ((i10 & 2) != 0) {
            str = gMSvipDetail.mysteryCode;
        }
        return gMSvipDetail.copy(l10, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMysteryCode() {
        return this.mysteryCode;
    }

    @NotNull
    public final GMSvipDetail copy(@Nullable Long svipLevel, @Nullable String mysteryCode) {
        return new GMSvipDetail(svipLevel, mysteryCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GMSvipDetail)) {
            return false;
        }
        GMSvipDetail gMSvipDetail = (GMSvipDetail) other;
        return Intrinsics.areEqual(this.svipLevel, gMSvipDetail.svipLevel) && Intrinsics.areEqual(this.mysteryCode, gMSvipDetail.mysteryCode);
    }

    @Nullable
    public final String getMysteryCode() {
        return this.mysteryCode;
    }

    @Nullable
    public final Long getSvipLevel() {
        return this.svipLevel;
    }

    public int hashCode() {
        Long l10 = this.svipLevel;
        int hashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        String str = this.mysteryCode;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setMysteryCode(@Nullable String str) {
        this.mysteryCode = str;
    }

    public final void setSvipLevel(@Nullable Long l10) {
        this.svipLevel = l10;
    }

    @NotNull
    public String toString() {
        return "GMSvipDetail(svipLevel=" + this.svipLevel + ", mysteryCode=" + this.mysteryCode + ")";
    }

    public GMSvipDetail(@Nullable Long l10, @Nullable String str) {
        this.svipLevel = l10;
        this.mysteryCode = str;
    }

    public /* synthetic */ GMSvipDetail(Long l10, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : str);
    }
}
