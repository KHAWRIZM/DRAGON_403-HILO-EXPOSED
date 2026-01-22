package com.qiahao.base_common.model.cp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0086\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020\u0005J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0005HÖ\u0001J\t\u0010?\u001a\u00020\u0007HÖ\u0001J\u0016\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006E"}, d2 = {"Lcom/qiahao/base_common/model/cp/CpLevel;", "Landroid/os/Parcelable;", "expireAtUnix", "", FirebaseAnalytics.Param.LEVEL, "", "settlementDate", "", "endPoints", "points", "createdUnix", "startPoints", "maxLevel", "title", "keepPoints", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getExpireAtUnix", "()Ljava/lang/Long;", "setExpireAtUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSettlementDate", "()Ljava/lang/String;", "setSettlementDate", "(Ljava/lang/String;)V", "getEndPoints", "setEndPoints", "getPoints", "setPoints", "getCreatedUnix", "setCreatedUnix", "getStartPoints", "setStartPoints", "getMaxLevel", "setMaxLevel", "getTitle", "setTitle", "getKeepPoints", "setKeepPoints", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/qiahao/base_common/model/cp/CpLevel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CpLevel implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpLevel> CREATOR = new Creator();

    @Nullable
    private Long createdUnix;

    @Nullable
    private Long endPoints;

    @Nullable
    private Long expireAtUnix;

    @Nullable
    private Long keepPoints;

    @Nullable
    private Integer level;

    @Nullable
    private Long maxLevel;

    @Nullable
    private Long points;

    @Nullable
    private String settlementDate;

    @Nullable
    private Long startPoints;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<CpLevel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpLevel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CpLevel(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpLevel[] newArray(int i10) {
            return new CpLevel[i10];
        }
    }

    public CpLevel() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getExpireAtUnix() {
        return this.expireAtUnix;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Long getKeepPoints() {
        return this.keepPoints;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSettlementDate() {
        return this.settlementDate;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getEndPoints() {
        return this.endPoints;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getCreatedUnix() {
        return this.createdUnix;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getStartPoints() {
        return this.startPoints;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Long getMaxLevel() {
        return this.maxLevel;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final CpLevel copy(@Nullable Long expireAtUnix, @Nullable Integer level, @Nullable String settlementDate, @Nullable Long endPoints, @Nullable Long points, @Nullable Long createdUnix, @Nullable Long startPoints, @Nullable Long maxLevel, @Nullable String title, @Nullable Long keepPoints) {
        return new CpLevel(expireAtUnix, level, settlementDate, endPoints, points, createdUnix, startPoints, maxLevel, title, keepPoints);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpLevel)) {
            return false;
        }
        CpLevel cpLevel = (CpLevel) other;
        return Intrinsics.areEqual(this.expireAtUnix, cpLevel.expireAtUnix) && Intrinsics.areEqual(this.level, cpLevel.level) && Intrinsics.areEqual(this.settlementDate, cpLevel.settlementDate) && Intrinsics.areEqual(this.endPoints, cpLevel.endPoints) && Intrinsics.areEqual(this.points, cpLevel.points) && Intrinsics.areEqual(this.createdUnix, cpLevel.createdUnix) && Intrinsics.areEqual(this.startPoints, cpLevel.startPoints) && Intrinsics.areEqual(this.maxLevel, cpLevel.maxLevel) && Intrinsics.areEqual(this.title, cpLevel.title) && Intrinsics.areEqual(this.keepPoints, cpLevel.keepPoints);
    }

    @Nullable
    public final Long getCreatedUnix() {
        return this.createdUnix;
    }

    @Nullable
    public final Long getEndPoints() {
        return this.endPoints;
    }

    @Nullable
    public final Long getExpireAtUnix() {
        return this.expireAtUnix;
    }

    @Nullable
    public final Long getKeepPoints() {
        return this.keepPoints;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final Long getMaxLevel() {
        return this.maxLevel;
    }

    @Nullable
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    public final String getSettlementDate() {
        return this.settlementDate;
    }

    @Nullable
    public final Long getStartPoints() {
        return this.startPoints;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Long l10 = this.expireAtUnix;
        int hashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        Integer num = this.level;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.settlementDate;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l11 = this.endPoints;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.points;
        int hashCode5 = (hashCode4 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.createdUnix;
        int hashCode6 = (hashCode5 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.startPoints;
        int hashCode7 = (hashCode6 + (l14 == null ? 0 : l14.hashCode())) * 31;
        Long l15 = this.maxLevel;
        int hashCode8 = (hashCode7 + (l15 == null ? 0 : l15.hashCode())) * 31;
        String str2 = this.title;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l16 = this.keepPoints;
        return hashCode9 + (l16 != null ? l16.hashCode() : 0);
    }

    public final void setCreatedUnix(@Nullable Long l10) {
        this.createdUnix = l10;
    }

    public final void setEndPoints(@Nullable Long l10) {
        this.endPoints = l10;
    }

    public final void setExpireAtUnix(@Nullable Long l10) {
        this.expireAtUnix = l10;
    }

    public final void setKeepPoints(@Nullable Long l10) {
        this.keepPoints = l10;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setMaxLevel(@Nullable Long l10) {
        this.maxLevel = l10;
    }

    public final void setPoints(@Nullable Long l10) {
        this.points = l10;
    }

    public final void setSettlementDate(@Nullable String str) {
        this.settlementDate = str;
    }

    public final void setStartPoints(@Nullable Long l10) {
        this.startPoints = l10;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "CpLevel(expireAtUnix=" + this.expireAtUnix + ", level=" + this.level + ", settlementDate=" + this.settlementDate + ", endPoints=" + this.endPoints + ", points=" + this.points + ", createdUnix=" + this.createdUnix + ", startPoints=" + this.startPoints + ", maxLevel=" + this.maxLevel + ", title=" + this.title + ", keepPoints=" + this.keepPoints + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l10 = this.expireAtUnix;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.settlementDate);
        Long l11 = this.endPoints;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        Long l12 = this.points;
        if (l12 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l12.longValue());
        }
        Long l13 = this.createdUnix;
        if (l13 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l13.longValue());
        }
        Long l14 = this.startPoints;
        if (l14 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l14.longValue());
        }
        Long l15 = this.maxLevel;
        if (l15 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l15.longValue());
        }
        dest.writeString(this.title);
        Long l16 = this.keepPoints;
        if (l16 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l16.longValue());
        }
    }

    public CpLevel(@Nullable Long l10, @Nullable Integer num, @Nullable String str, @Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @Nullable Long l14, @Nullable Long l15, @Nullable String str2, @Nullable Long l16) {
        this.expireAtUnix = l10;
        this.level = num;
        this.settlementDate = str;
        this.endPoints = l11;
        this.points = l12;
        this.createdUnix = l13;
        this.startPoints = l14;
        this.maxLevel = l15;
        this.title = str2;
        this.keepPoints = l16;
    }

    public /* synthetic */ CpLevel(Long l10, Integer num, String str, Long l11, Long l12, Long l13, Long l14, Long l15, String str2, Long l16, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : l10, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? "" : str, (i10 & 8) != 0 ? null : l11, (i10 & 16) != 0 ? null : l12, (i10 & 32) != 0 ? null : l13, (i10 & 64) != 0 ? null : l14, (i10 & 128) != 0 ? null : l15, (i10 & 256) != 0 ? null : str2, (i10 & 512) == 0 ? l16 : null);
    }
}
