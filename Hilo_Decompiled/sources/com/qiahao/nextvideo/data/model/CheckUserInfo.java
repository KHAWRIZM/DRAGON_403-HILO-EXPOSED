package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CheckUserInfo;", "", "canEditCountryDiffSeconds", "", "lastEditCountryTimestamp", "timestamp", "editCountryDays", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getCanEditCountryDiffSeconds", "()Ljava/lang/Long;", "setCanEditCountryDiffSeconds", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLastEditCountryTimestamp", "setLastEditCountryTimestamp", "getTimestamp", "setTimestamp", "getEditCountryDays", "()Ljava/lang/Integer;", "setEditCountryDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/CheckUserInfo;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CheckUserInfo {

    @Nullable
    private Long canEditCountryDiffSeconds;

    @Nullable
    private Integer editCountryDays;

    @Nullable
    private Long lastEditCountryTimestamp;

    @Nullable
    private Long timestamp;

    public CheckUserInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CheckUserInfo copy$default(CheckUserInfo checkUserInfo, Long l, Long l2, Long l3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            l = checkUserInfo.canEditCountryDiffSeconds;
        }
        if ((i & 2) != 0) {
            l2 = checkUserInfo.lastEditCountryTimestamp;
        }
        if ((i & 4) != 0) {
            l3 = checkUserInfo.timestamp;
        }
        if ((i & 8) != 0) {
            num = checkUserInfo.editCountryDays;
        }
        return checkUserInfo.copy(l, l2, l3, num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getCanEditCountryDiffSeconds() {
        return this.canEditCountryDiffSeconds;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getLastEditCountryTimestamp() {
        return this.lastEditCountryTimestamp;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getEditCountryDays() {
        return this.editCountryDays;
    }

    @NotNull
    public final CheckUserInfo copy(@Nullable Long canEditCountryDiffSeconds, @Nullable Long lastEditCountryTimestamp, @Nullable Long timestamp, @Nullable Integer editCountryDays) {
        return new CheckUserInfo(canEditCountryDiffSeconds, lastEditCountryTimestamp, timestamp, editCountryDays);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckUserInfo)) {
            return false;
        }
        CheckUserInfo checkUserInfo = (CheckUserInfo) other;
        return Intrinsics.areEqual(this.canEditCountryDiffSeconds, checkUserInfo.canEditCountryDiffSeconds) && Intrinsics.areEqual(this.lastEditCountryTimestamp, checkUserInfo.lastEditCountryTimestamp) && Intrinsics.areEqual(this.timestamp, checkUserInfo.timestamp) && Intrinsics.areEqual(this.editCountryDays, checkUserInfo.editCountryDays);
    }

    @Nullable
    public final Long getCanEditCountryDiffSeconds() {
        return this.canEditCountryDiffSeconds;
    }

    @Nullable
    public final Integer getEditCountryDays() {
        return this.editCountryDays;
    }

    @Nullable
    public final Long getLastEditCountryTimestamp() {
        return this.lastEditCountryTimestamp;
    }

    @Nullable
    public final Long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        Long l = this.canEditCountryDiffSeconds;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.lastEditCountryTimestamp;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.timestamp;
        int hashCode3 = (hashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Integer num = this.editCountryDays;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public final void setCanEditCountryDiffSeconds(@Nullable Long l) {
        this.canEditCountryDiffSeconds = l;
    }

    public final void setEditCountryDays(@Nullable Integer num) {
        this.editCountryDays = num;
    }

    public final void setLastEditCountryTimestamp(@Nullable Long l) {
        this.lastEditCountryTimestamp = l;
    }

    public final void setTimestamp(@Nullable Long l) {
        this.timestamp = l;
    }

    @NotNull
    public String toString() {
        return "CheckUserInfo(canEditCountryDiffSeconds=" + this.canEditCountryDiffSeconds + ", lastEditCountryTimestamp=" + this.lastEditCountryTimestamp + ", timestamp=" + this.timestamp + ", editCountryDays=" + this.editCountryDays + ")";
    }

    public CheckUserInfo(@Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Integer num) {
        this.canEditCountryDiffSeconds = l;
        this.lastEditCountryTimestamp = l2;
        this.timestamp = l3;
        this.editCountryDays = num;
    }

    public /* synthetic */ CheckUserInfo(Long l, Long l2, Long l3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3, (i & 8) != 0 ? null : num);
    }
}
