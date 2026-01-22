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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jz\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00107J\u0006\u00108\u001a\u00020\u0007J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006D"}, d2 = {"Lcom/qiahao/base_common/model/common/Special;", "Landroid/os/Parcelable;", "backgroundImg", "", "createdUnix", "", "days", "", "id", FirebaseAnalytics.Param.LEVEL, "name", "points", "type", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;)V", "getBackgroundImg", "()Ljava/lang/String;", "setBackgroundImg", "(Ljava/lang/String;)V", "getCreatedUnix", "()Ljava/lang/Long;", "setCreatedUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDays", "()Ljava/lang/Integer;", "setDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getId", "setId", "getLevel", "setLevel", "getName", "setName", "getPoints", "setPoints", "getType", "setType", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/base_common/model/common/Special;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class Special implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Special> CREATOR = new Creator();

    @Nullable
    private String backgroundImg;

    @Nullable
    private Long createdUnix;

    @Nullable
    private Integer days;

    @Nullable
    private String id;

    @Nullable
    private Integer level;

    @Nullable
    private String name;

    @Nullable
    private Long points;

    @Nullable
    private Integer type;

    @Nullable
    private User user;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<Special> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Special createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Special(parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? User.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Special[] newArray(int i10) {
            return new Special[i10];
        }
    }

    public Special() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getCreatedUnix() {
        return this.createdUnix;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getDays() {
        return this.days;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final Special copy(@Nullable String backgroundImg, @Nullable Long createdUnix, @Nullable Integer days, @Nullable String id, @Nullable Integer level, @Nullable String name, @Nullable Long points, @Nullable Integer type, @Nullable User user) {
        return new Special(backgroundImg, createdUnix, days, id, level, name, points, type, user);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Special)) {
            return false;
        }
        Special special = (Special) other;
        return Intrinsics.areEqual(this.backgroundImg, special.backgroundImg) && Intrinsics.areEqual(this.createdUnix, special.createdUnix) && Intrinsics.areEqual(this.days, special.days) && Intrinsics.areEqual(this.id, special.id) && Intrinsics.areEqual(this.level, special.level) && Intrinsics.areEqual(this.name, special.name) && Intrinsics.areEqual(this.points, special.points) && Intrinsics.areEqual(this.type, special.type) && Intrinsics.areEqual(this.user, special.user);
    }

    @Nullable
    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    @Nullable
    public final Long getCreatedUnix() {
        return this.createdUnix;
    }

    @Nullable
    public final Integer getDays() {
        return this.days;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Long getPoints() {
        return this.points;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.backgroundImg;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l10 = this.createdUnix;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.days;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.id;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.level;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l11 = this.points;
        int hashCode7 = (hashCode6 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num3 = this.type;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        User user = this.user;
        return hashCode8 + (user != null ? user.hashCode() : 0);
    }

    public final void setBackgroundImg(@Nullable String str) {
        this.backgroundImg = str;
    }

    public final void setCreatedUnix(@Nullable Long l10) {
        this.createdUnix = l10;
    }

    public final void setDays(@Nullable Integer num) {
        this.days = num;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPoints(@Nullable Long l10) {
        this.points = l10;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "Special(backgroundImg=" + this.backgroundImg + ", createdUnix=" + this.createdUnix + ", days=" + this.days + ", id=" + this.id + ", level=" + this.level + ", name=" + this.name + ", points=" + this.points + ", type=" + this.type + ", user=" + this.user + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.backgroundImg);
        Long l10 = this.createdUnix;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        Integer num = this.days;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.id);
        Integer num2 = this.level;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.name);
        Long l11 = this.points;
        if (l11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l11.longValue());
        }
        Integer num3 = this.type;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        User user = this.user;
        if (user == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            user.writeToParcel(dest, flags);
        }
    }

    public Special(@Nullable String str, @Nullable Long l10, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable Long l11, @Nullable Integer num3, @Nullable User user) {
        this.backgroundImg = str;
        this.createdUnix = l10;
        this.days = num;
        this.id = str2;
        this.level = num2;
        this.name = str3;
        this.points = l11;
        this.type = num3;
        this.user = user;
    }

    public /* synthetic */ Special(String str, Long l10, Integer num, String str2, Integer num2, String str3, Long l11, Integer num3, User user, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : num2, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : l11, (i10 & 128) != 0 ? null : num3, (i10 & 256) == 0 ? user : null);
    }
}
