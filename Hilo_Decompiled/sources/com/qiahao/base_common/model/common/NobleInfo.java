package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J2\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/qiahao/base_common/model/common/NobleInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", FirebaseAnalytics.Param.LEVEL, "", "endTime", "", "ornaments", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOrnaments", "()Ljava/lang/String;", "setOrnaments", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)Lcom/qiahao/base_common/model/common/NobleInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class NobleInfo implements Parcelable, Serializable {

    @NotNull
    public static final Parcelable.Creator<NobleInfo> CREATOR = new Creator();

    @Nullable
    private Long endTime;

    @Nullable
    private Integer level;

    @Nullable
    private String ornaments;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<NobleInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NobleInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NobleInfo(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NobleInfo[] newArray(int i10) {
            return new NobleInfo[i10];
        }
    }

    public NobleInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NobleInfo copy$default(NobleInfo nobleInfo, Integer num, Long l10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = nobleInfo.level;
        }
        if ((i10 & 2) != 0) {
            l10 = nobleInfo.endTime;
        }
        if ((i10 & 4) != 0) {
            str = nobleInfo.ornaments;
        }
        return nobleInfo.copy(num, l10, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getEndTime() {
        return this.endTime;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getOrnaments() {
        return this.ornaments;
    }

    @NotNull
    public final NobleInfo copy(@Nullable Integer level, @Nullable Long endTime, @Nullable String ornaments) {
        return new NobleInfo(level, endTime, ornaments);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NobleInfo)) {
            return false;
        }
        NobleInfo nobleInfo = (NobleInfo) other;
        return Intrinsics.areEqual(this.level, nobleInfo.level) && Intrinsics.areEqual(this.endTime, nobleInfo.endTime) && Intrinsics.areEqual(this.ornaments, nobleInfo.ornaments);
    }

    @Nullable
    public final Long getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final String getOrnaments() {
        return this.ornaments;
    }

    public int hashCode() {
        Integer num = this.level;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l10 = this.endTime;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.ornaments;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setEndTime(@Nullable Long l10) {
        this.endTime = l10;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setOrnaments(@Nullable String str) {
        this.ornaments = str;
    }

    @NotNull
    public String toString() {
        return "NobleInfo(level=" + this.level + ", endTime=" + this.endTime + ", ornaments=" + this.ornaments + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Long l10 = this.endTime;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.ornaments);
    }

    public NobleInfo(@Nullable Integer num, @Nullable Long l10, @Nullable String str) {
        this.level = num;
        this.endTime = l10;
        this.ornaments = str;
    }

    public /* synthetic */ NobleInfo(Integer num, Long l10, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0 : num, (i10 & 2) != 0 ? 0L : l10, (i10 & 4) != 0 ? null : str);
    }
}
