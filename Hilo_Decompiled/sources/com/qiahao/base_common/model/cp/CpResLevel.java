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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0005J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006-"}, d2 = {"Lcom/qiahao/base_common/model/cp/CpResLevel;", "Landroid/os/Parcelable;", "icon", "", FirebaseAnalytics.Param.LEVEL, "", "startPoints", "endPoints", "medalEffectUrl", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStartPoints", "setStartPoints", "getEndPoints", "setEndPoints", "getMedalEffectUrl", "setMedalEffectUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/base_common/model/cp/CpResLevel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CpResLevel implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CpResLevel> CREATOR = new Creator();

    @Nullable
    private Integer endPoints;

    @Nullable
    private String icon;

    @Nullable
    private Integer level;

    @Nullable
    private String medalEffectUrl;

    @Nullable
    private Integer startPoints;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<CpResLevel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpResLevel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CpResLevel(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CpResLevel[] newArray(int i10) {
            return new CpResLevel[i10];
        }
    }

    public CpResLevel() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CpResLevel copy$default(CpResLevel cpResLevel, String str, Integer num, Integer num2, Integer num3, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cpResLevel.icon;
        }
        if ((i10 & 2) != 0) {
            num = cpResLevel.level;
        }
        Integer num4 = num;
        if ((i10 & 4) != 0) {
            num2 = cpResLevel.startPoints;
        }
        Integer num5 = num2;
        if ((i10 & 8) != 0) {
            num3 = cpResLevel.endPoints;
        }
        Integer num6 = num3;
        if ((i10 & 16) != 0) {
            str2 = cpResLevel.medalEffectUrl;
        }
        return cpResLevel.copy(str, num4, num5, num6, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getStartPoints() {
        return this.startPoints;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getEndPoints() {
        return this.endPoints;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getMedalEffectUrl() {
        return this.medalEffectUrl;
    }

    @NotNull
    public final CpResLevel copy(@Nullable String icon, @Nullable Integer level, @Nullable Integer startPoints, @Nullable Integer endPoints, @Nullable String medalEffectUrl) {
        return new CpResLevel(icon, level, startPoints, endPoints, medalEffectUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpResLevel)) {
            return false;
        }
        CpResLevel cpResLevel = (CpResLevel) other;
        return Intrinsics.areEqual(this.icon, cpResLevel.icon) && Intrinsics.areEqual(this.level, cpResLevel.level) && Intrinsics.areEqual(this.startPoints, cpResLevel.startPoints) && Intrinsics.areEqual(this.endPoints, cpResLevel.endPoints) && Intrinsics.areEqual(this.medalEffectUrl, cpResLevel.medalEffectUrl);
    }

    @Nullable
    public final Integer getEndPoints() {
        return this.endPoints;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final String getMedalEffectUrl() {
        return this.medalEffectUrl;
    }

    @Nullable
    public final Integer getStartPoints() {
        return this.startPoints;
    }

    public int hashCode() {
        String str = this.icon;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.level;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.startPoints;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.endPoints;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.medalEffectUrl;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setEndPoints(@Nullable Integer num) {
        this.endPoints = num;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setMedalEffectUrl(@Nullable String str) {
        this.medalEffectUrl = str;
    }

    public final void setStartPoints(@Nullable Integer num) {
        this.startPoints = num;
    }

    @NotNull
    public String toString() {
        return "CpResLevel(icon=" + this.icon + ", level=" + this.level + ", startPoints=" + this.startPoints + ", endPoints=" + this.endPoints + ", medalEffectUrl=" + this.medalEffectUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.icon);
        Integer num = this.level;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.startPoints;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.endPoints;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        dest.writeString(this.medalEffectUrl);
    }

    public CpResLevel(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str2) {
        this.icon = str;
        this.level = num;
        this.startPoints = num2;
        this.endPoints = num3;
        this.medalEffectUrl = str2;
    }

    public /* synthetic */ CpResLevel(String str, Integer num, Integer num2, Integer num3, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : num2, (i10 & 8) != 0 ? null : num3, (i10 & 16) != 0 ? null : str2);
    }
}
