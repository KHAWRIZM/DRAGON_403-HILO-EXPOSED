package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SvipCheckData;", "", "canDel", "", "svipLevel", "", "delTimes", "maxTimes", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCanDel", "()Ljava/lang/Boolean;", "setCanDel", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSvipLevel", "()Ljava/lang/Integer;", "setSvipLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDelTimes", "setDelTimes", "getMaxTimes", "setMaxTimes", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/SvipCheckData;", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SvipCheckData {

    @Nullable
    private Boolean canDel;

    @Nullable
    private Integer delTimes;

    @Nullable
    private Integer maxTimes;

    @Nullable
    private Integer svipLevel;

    public SvipCheckData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SvipCheckData copy$default(SvipCheckData svipCheckData, Boolean bool, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = svipCheckData.canDel;
        }
        if ((i & 2) != 0) {
            num = svipCheckData.svipLevel;
        }
        if ((i & 4) != 0) {
            num2 = svipCheckData.delTimes;
        }
        if ((i & 8) != 0) {
            num3 = svipCheckData.maxTimes;
        }
        return svipCheckData.copy(bool, num, num2, num3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getCanDel() {
        return this.canDel;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getDelTimes() {
        return this.delTimes;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getMaxTimes() {
        return this.maxTimes;
    }

    @NotNull
    public final SvipCheckData copy(@Nullable Boolean canDel, @Nullable Integer svipLevel, @Nullable Integer delTimes, @Nullable Integer maxTimes) {
        return new SvipCheckData(canDel, svipLevel, delTimes, maxTimes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SvipCheckData)) {
            return false;
        }
        SvipCheckData svipCheckData = (SvipCheckData) other;
        return Intrinsics.areEqual(this.canDel, svipCheckData.canDel) && Intrinsics.areEqual(this.svipLevel, svipCheckData.svipLevel) && Intrinsics.areEqual(this.delTimes, svipCheckData.delTimes) && Intrinsics.areEqual(this.maxTimes, svipCheckData.maxTimes);
    }

    @Nullable
    public final Boolean getCanDel() {
        return this.canDel;
    }

    @Nullable
    public final Integer getDelTimes() {
        return this.delTimes;
    }

    @Nullable
    public final Integer getMaxTimes() {
        return this.maxTimes;
    }

    @Nullable
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    public int hashCode() {
        Boolean bool = this.canDel;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.svipLevel;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.delTimes;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.maxTimes;
        return hashCode3 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setCanDel(@Nullable Boolean bool) {
        this.canDel = bool;
    }

    public final void setDelTimes(@Nullable Integer num) {
        this.delTimes = num;
    }

    public final void setMaxTimes(@Nullable Integer num) {
        this.maxTimes = num;
    }

    public final void setSvipLevel(@Nullable Integer num) {
        this.svipLevel = num;
    }

    @NotNull
    public String toString() {
        return "SvipCheckData(canDel=" + this.canDel + ", svipLevel=" + this.svipLevel + ", delTimes=" + this.delTimes + ", maxTimes=" + this.maxTimes + ")";
    }

    public SvipCheckData(@Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.canDel = bool;
        this.svipLevel = num;
        this.delTimes = num2;
        this.maxTimes = num3;
    }

    public /* synthetic */ SvipCheckData(Boolean bool, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
    }
}
