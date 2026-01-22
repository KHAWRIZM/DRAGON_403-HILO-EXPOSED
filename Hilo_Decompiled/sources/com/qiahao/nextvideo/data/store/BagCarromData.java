package com.qiahao.nextvideo.data.store;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010*\u001a\u00020\bJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&Jn\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\rHÖ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0004\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/data/store/BagCarromData;", "", "bagId", "", "isForever", "", "resId", "name", "", "picUrl", "timeLeft", "using", "type", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getBagId", "()Ljava/lang/Long;", "setBagId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setForever", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getResId", "setResId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPicUrl", "setPicUrl", "getTimeLeft", "setTimeLeft", "getUsing", "setUsing", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bagAndResId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/store/BagCarromData;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class BagCarromData {

    @Nullable
    private Long bagId;

    @Nullable
    private Boolean isForever;

    @Nullable
    private String name;

    @Nullable
    private String picUrl;

    @Nullable
    private Long resId;

    @Nullable
    private Long timeLeft;

    @Nullable
    private Integer type;

    @Nullable
    private Boolean using;

    public BagCarromData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @NotNull
    public final String bagAndResId() {
        Long l = this.bagId;
        Long l2 = this.resId;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l);
        sb2.append(l2);
        return sb2.toString();
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getBagId() {
        return this.bagId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getIsForever() {
        return this.isForever;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getResId() {
        return this.resId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getTimeLeft() {
        return this.timeLeft;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getUsing() {
        return this.using;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @NotNull
    public final BagCarromData copy(@Nullable Long bagId, @Nullable Boolean isForever, @Nullable Long resId, @Nullable String name, @Nullable String picUrl, @Nullable Long timeLeft, @Nullable Boolean using, @Nullable Integer type) {
        return new BagCarromData(bagId, isForever, resId, name, picUrl, timeLeft, using, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BagCarromData)) {
            return false;
        }
        BagCarromData bagCarromData = (BagCarromData) other;
        return Intrinsics.areEqual(this.bagId, bagCarromData.bagId) && Intrinsics.areEqual(this.isForever, bagCarromData.isForever) && Intrinsics.areEqual(this.resId, bagCarromData.resId) && Intrinsics.areEqual(this.name, bagCarromData.name) && Intrinsics.areEqual(this.picUrl, bagCarromData.picUrl) && Intrinsics.areEqual(this.timeLeft, bagCarromData.timeLeft) && Intrinsics.areEqual(this.using, bagCarromData.using) && Intrinsics.areEqual(this.type, bagCarromData.type);
    }

    @Nullable
    public final Long getBagId() {
        return this.bagId;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final Long getResId() {
        return this.resId;
    }

    @Nullable
    public final Long getTimeLeft() {
        return this.timeLeft;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final Boolean getUsing() {
        return this.using;
    }

    public int hashCode() {
        Long l = this.bagId;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Boolean bool = this.isForever;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l2 = this.resId;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.name;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.picUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l3 = this.timeLeft;
        int hashCode6 = (hashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Boolean bool2 = this.using;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.type;
        return hashCode7 + (num != null ? num.hashCode() : 0);
    }

    @Nullable
    public final Boolean isForever() {
        return this.isForever;
    }

    public final void setBagId(@Nullable Long l) {
        this.bagId = l;
    }

    public final void setForever(@Nullable Boolean bool) {
        this.isForever = bool;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setResId(@Nullable Long l) {
        this.resId = l;
    }

    public final void setTimeLeft(@Nullable Long l) {
        this.timeLeft = l;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    public final void setUsing(@Nullable Boolean bool) {
        this.using = bool;
    }

    @NotNull
    public String toString() {
        return "BagCarromData(bagId=" + this.bagId + ", isForever=" + this.isForever + ", resId=" + this.resId + ", name=" + this.name + ", picUrl=" + this.picUrl + ", timeLeft=" + this.timeLeft + ", using=" + this.using + ", type=" + this.type + ")";
    }

    public BagCarromData(@Nullable Long l, @Nullable Boolean bool, @Nullable Long l2, @Nullable String str, @Nullable String str2, @Nullable Long l3, @Nullable Boolean bool2, @Nullable Integer num) {
        this.bagId = l;
        this.isForever = bool;
        this.resId = l2;
        this.name = str;
        this.picUrl = str2;
        this.timeLeft = l3;
        this.using = bool2;
        this.type = num;
    }

    public /* synthetic */ BagCarromData(Long l, Boolean bool, Long l2, String str, String str2, Long l3, Boolean bool2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : bool2, (i & 128) == 0 ? num : null);
    }
}
