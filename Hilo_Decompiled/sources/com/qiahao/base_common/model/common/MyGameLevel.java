package com.qiahao.base_common.model.common;

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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0003J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013¨\u0006-"}, d2 = {"Lcom/qiahao/base_common/model/common/MyGameLevel;", "Landroid/os/Parcelable;", FirebaseAnalytics.Param.LEVEL, "", "title", "", "points", "", "medalUrl", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getPoints", "()Ljava/lang/Long;", "setPoints", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMedalUrl", "setMedalUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/qiahao/base_common/model/common/MyGameLevel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MyGameLevel implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<MyGameLevel> CREATOR = new Creator();

    @Nullable
    private Integer level;

    @Nullable
    private String medalUrl;

    @Nullable
    private Long points;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<MyGameLevel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyGameLevel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MyGameLevel(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MyGameLevel[] newArray(int i10) {
            return new MyGameLevel[i10];
        }
    }

    public MyGameLevel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MyGameLevel copy$default(MyGameLevel myGameLevel, Integer num, String str, Long l10, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = myGameLevel.level;
        }
        if ((i10 & 2) != 0) {
            str = myGameLevel.title;
        }
        if ((i10 & 4) != 0) {
            l10 = myGameLevel.points;
        }
        if ((i10 & 8) != 0) {
            str2 = myGameLevel.medalUrl;
        }
        return myGameLevel.copy(num, str, l10, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    @NotNull
    public final MyGameLevel copy(@Nullable Integer level, @Nullable String title, @Nullable Long points, @Nullable String medalUrl) {
        return new MyGameLevel(level, title, points, medalUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyGameLevel)) {
            return false;
        }
        MyGameLevel myGameLevel = (MyGameLevel) other;
        return Intrinsics.areEqual(this.level, myGameLevel.level) && Intrinsics.areEqual(this.title, myGameLevel.title) && Intrinsics.areEqual(this.points, myGameLevel.points) && Intrinsics.areEqual(this.medalUrl, myGameLevel.medalUrl);
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    @Nullable
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Integer num = this.level;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.points;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.medalUrl;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setMedalUrl(@Nullable String str) {
        this.medalUrl = str;
    }

    public final void setPoints(@Nullable Long l10) {
        this.points = l10;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "MyGameLevel(level=" + this.level + ", title=" + this.title + ", points=" + this.points + ", medalUrl=" + this.medalUrl + ")";
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
        dest.writeString(this.title);
        Long l10 = this.points;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.medalUrl);
    }

    public MyGameLevel(@Nullable Integer num, @Nullable String str, @Nullable Long l10, @Nullable String str2) {
        this.level = num;
        this.title = str;
        this.points = l10;
        this.medalUrl = str2;
    }

    public /* synthetic */ MyGameLevel(Integer num, String str, Long l10, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? 0 : num, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? 0L : l10, (i10 & 8) != 0 ? null : str2);
    }
}
