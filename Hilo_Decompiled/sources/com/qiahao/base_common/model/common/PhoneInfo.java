package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006)"}, d2 = {"Lcom/qiahao/base_common/model/common/PhoneInfo;", "Landroid/os/Parcelable;", "areaCode", "", "icon", "phone", "phoneCountry", "pwd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreaCode", "()Ljava/lang/String;", "setAreaCode", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getPhone", "setPhone", "getPhoneCountry", "setPhoneCountry", "getPwd", "setPwd", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PhoneInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PhoneInfo> CREATOR = new Creator();

    @Nullable
    private String areaCode;

    @Nullable
    private String icon;

    @Nullable
    private String phone;

    @Nullable
    private String phoneCountry;

    @Nullable
    private String pwd;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<PhoneInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PhoneInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneInfo[] newArray(int i10) {
            return new PhoneInfo[i10];
        }
    }

    public PhoneInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PhoneInfo copy$default(PhoneInfo phoneInfo, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = phoneInfo.areaCode;
        }
        if ((i10 & 2) != 0) {
            str2 = phoneInfo.icon;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = phoneInfo.phone;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = phoneInfo.phoneCountry;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = phoneInfo.pwd;
        }
        return phoneInfo.copy(str, str6, str7, str8, str5);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAreaCode() {
        return this.areaCode;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPhoneCountry() {
        return this.phoneCountry;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPwd() {
        return this.pwd;
    }

    @NotNull
    public final PhoneInfo copy(@Nullable String areaCode, @Nullable String icon, @Nullable String phone, @Nullable String phoneCountry, @Nullable String pwd) {
        return new PhoneInfo(areaCode, icon, phone, phoneCountry, pwd);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhoneInfo)) {
            return false;
        }
        PhoneInfo phoneInfo = (PhoneInfo) other;
        return Intrinsics.areEqual(this.areaCode, phoneInfo.areaCode) && Intrinsics.areEqual(this.icon, phoneInfo.icon) && Intrinsics.areEqual(this.phone, phoneInfo.phone) && Intrinsics.areEqual(this.phoneCountry, phoneInfo.phoneCountry) && Intrinsics.areEqual(this.pwd, phoneInfo.pwd);
    }

    @Nullable
    public final String getAreaCode() {
        return this.areaCode;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final String getPhoneCountry() {
        return this.phoneCountry;
    }

    @Nullable
    public final String getPwd() {
        return this.pwd;
    }

    public int hashCode() {
        String str = this.areaCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.phone;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phoneCountry;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.pwd;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setAreaCode(@Nullable String str) {
        this.areaCode = str;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setPhone(@Nullable String str) {
        this.phone = str;
    }

    public final void setPhoneCountry(@Nullable String str) {
        this.phoneCountry = str;
    }

    public final void setPwd(@Nullable String str) {
        this.pwd = str;
    }

    @NotNull
    public String toString() {
        return "PhoneInfo(areaCode=" + this.areaCode + ", icon=" + this.icon + ", phone=" + this.phone + ", phoneCountry=" + this.phoneCountry + ", pwd=" + this.pwd + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.areaCode);
        dest.writeString(this.icon);
        dest.writeString(this.phone);
        dest.writeString(this.phoneCountry);
        dest.writeString(this.pwd);
    }

    public PhoneInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.areaCode = str;
        this.icon = str2;
        this.phone = str3;
        this.phoneCountry = str4;
        this.pwd = str5;
    }

    public /* synthetic */ PhoneInfo(String str, String str2, String str3, String str4, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5);
    }
}
