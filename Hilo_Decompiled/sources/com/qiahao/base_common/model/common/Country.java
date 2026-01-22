package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 62\u00020\u0001:\u00016BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003JE\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0006\u0010*\u001a\u00020\u0018J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0018HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR$\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0016\n\u0002\u0010\u001e\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u0010¨\u00067"}, d2 = {"Lcom/qiahao/base_common/model/common/Country;", "Landroid/os/Parcelable;", "shortName", "", "icon", "name", "code", "", "areaCode", "areaShortName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getShortName", "()Ljava/lang/String;", "getIcon", "setIcon", "(Ljava/lang/String;)V", "getName", "setName", "getCode", "()J", "getAreaCode", "getAreaShortName", "isCommom", "", "isCommom$annotations", "()V", "()Ljava/lang/Integer;", "setCommom", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "countryType", "getCountryType$annotations", "getCountryType", "setCountryType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class Country implements Parcelable {

    @NotNull
    @c("areaCode")
    private final String areaCode;

    @NotNull
    @c("areaShortName")
    private final String areaShortName;

    @c("code")
    private final long code;

    @NotNull
    private String countryType;

    @NotNull
    @c("icon")
    private String icon;

    @Nullable
    private Integer isCommom;

    @NotNull
    @c("name")
    private String name;

    @NotNull
    @c("shortName")
    private final String shortName;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<Country> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/base_common/model/common/Country$Companion;", "", "<init>", "()V", "fake", "Lcom/qiahao/base_common/model/common/Country;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Country fake() {
            return new Country("China", "", "China", 0L, null, null, 48, null);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<Country> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Country createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Country(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Country[] newArray(int i10) {
            return new Country[i10];
        }
    }

    public Country() {
        this(null, null, null, 0L, null, null, 63, null);
    }

    public static /* synthetic */ Country copy$default(Country country, String str, String str2, String str3, long j10, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = country.shortName;
        }
        if ((i10 & 2) != 0) {
            str2 = country.icon;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = country.name;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            j10 = country.code;
        }
        long j11 = j10;
        if ((i10 & 16) != 0) {
            str4 = country.areaCode;
        }
        String str8 = str4;
        if ((i10 & 32) != 0) {
            str5 = country.areaShortName;
        }
        return country.copy(str, str6, str7, j11, str8, str5);
    }

    public static /* synthetic */ void getCountryType$annotations() {
    }

    public static /* synthetic */ void isCommom$annotations() {
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getAreaCode() {
        return this.areaCode;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getAreaShortName() {
        return this.areaShortName;
    }

    @NotNull
    public final Country copy(@NotNull String shortName, @NotNull String icon, @NotNull String name, long code, @NotNull String areaCode, @NotNull String areaShortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(areaCode, "areaCode");
        Intrinsics.checkNotNullParameter(areaShortName, "areaShortName");
        return new Country(shortName, icon, name, code, areaCode, areaShortName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Country)) {
            return false;
        }
        Country country = (Country) other;
        return Intrinsics.areEqual(this.shortName, country.shortName) && Intrinsics.areEqual(this.icon, country.icon) && Intrinsics.areEqual(this.name, country.name) && this.code == country.code && Intrinsics.areEqual(this.areaCode, country.areaCode) && Intrinsics.areEqual(this.areaShortName, country.areaShortName);
    }

    @NotNull
    public final String getAreaCode() {
        return this.areaCode;
    }

    @NotNull
    public final String getAreaShortName() {
        return this.areaShortName;
    }

    public final long getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountryType() {
        return this.countryType;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getShortName() {
        return this.shortName;
    }

    public int hashCode() {
        return (((((((((this.shortName.hashCode() * 31) + this.icon.hashCode()) * 31) + this.name.hashCode()) * 31) + androidx.collection.c.a(this.code)) * 31) + this.areaCode.hashCode()) * 31) + this.areaShortName.hashCode();
    }

    @Nullable
    /* renamed from: isCommom, reason: from getter */
    public final Integer getIsCommom() {
        return this.isCommom;
    }

    public final void setCommom(@Nullable Integer num) {
        this.isCommom = num;
    }

    public final void setCountryType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryType = str;
    }

    public final void setIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @NotNull
    public String toString() {
        return "Country(shortName=" + this.shortName + ", icon=" + this.icon + ", name=" + this.name + ", code=" + this.code + ", areaCode=" + this.areaCode + ", areaShortName=" + this.areaShortName + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.shortName);
        dest.writeString(this.icon);
        dest.writeString(this.name);
        dest.writeLong(this.code);
        dest.writeString(this.areaCode);
        dest.writeString(this.areaShortName);
    }

    public Country(@NotNull String shortName, @NotNull String icon, @NotNull String name, long j10, @NotNull String areaCode, @NotNull String areaShortName) {
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(areaCode, "areaCode");
        Intrinsics.checkNotNullParameter(areaShortName, "areaShortName");
        this.shortName = shortName;
        this.icon = icon;
        this.name = name;
        this.code = j10;
        this.areaCode = areaCode;
        this.areaShortName = areaShortName;
        this.countryType = "";
    }

    public /* synthetic */ Country(String str, String str2, String str3, long j10, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? 0L : j10, (i10 & 16) != 0 ? "" : str4, (i10 & 32) != 0 ? "" : str5);
    }
}
