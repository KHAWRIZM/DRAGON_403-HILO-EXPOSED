package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\u0007J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GiftShortcutData;", "Landroid/os/Parcelable;", "avatar", "", "avatar2", "entryUrl", "resMedalType", "", "type", "bannerUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getAvatar2", "setAvatar2", "getEntryUrl", "setEntryUrl", "getResMedalType", "()Ljava/lang/Integer;", "setResMedalType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getType", "setType", "getBannerUrl", "setBannerUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/GiftShortcutData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GiftShortcutData implements Parcelable {
    public static final int TYPE_ACTIVITY = 6;
    public static final int TYPE_COUNTRY = 4;
    public static final int TYPE_CP = 2;
    public static final int TYPE_EXCLUSIVE = 5;
    public static final int TYPE_MEDAL = 3;
    public static final int TYPE_WEEK = 1;

    @Nullable
    private String avatar;

    @Nullable
    private String avatar2;

    @Nullable
    private String bannerUrl;

    @Nullable
    private String entryUrl;

    @Nullable
    private Integer resMedalType;

    @Nullable
    private Integer type;

    @NotNull
    public static final Parcelable.Creator<GiftShortcutData> CREATOR = new Creator();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GiftShortcutData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GiftShortcutData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GiftShortcutData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GiftShortcutData[] newArray(int i) {
            return new GiftShortcutData[i];
        }
    }

    public GiftShortcutData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ GiftShortcutData copy$default(GiftShortcutData giftShortcutData, String str, String str2, String str3, Integer num, Integer num2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = giftShortcutData.avatar;
        }
        if ((i & 2) != 0) {
            str2 = giftShortcutData.avatar2;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = giftShortcutData.entryUrl;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            num = giftShortcutData.resMedalType;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = giftShortcutData.type;
        }
        Integer num4 = num2;
        if ((i & 32) != 0) {
            str4 = giftShortcutData.bannerUrl;
        }
        return giftShortcutData.copy(str, str5, str6, num3, num4, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAvatar2() {
        return this.avatar2;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getEntryUrl() {
        return this.entryUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getResMedalType() {
        return this.resMedalType;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @NotNull
    public final GiftShortcutData copy(@Nullable String avatar, @Nullable String avatar2, @Nullable String entryUrl, @Nullable Integer resMedalType, @Nullable Integer type, @Nullable String bannerUrl) {
        return new GiftShortcutData(avatar, avatar2, entryUrl, resMedalType, type, bannerUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftShortcutData)) {
            return false;
        }
        GiftShortcutData giftShortcutData = (GiftShortcutData) other;
        return Intrinsics.areEqual(this.avatar, giftShortcutData.avatar) && Intrinsics.areEqual(this.avatar2, giftShortcutData.avatar2) && Intrinsics.areEqual(this.entryUrl, giftShortcutData.entryUrl) && Intrinsics.areEqual(this.resMedalType, giftShortcutData.resMedalType) && Intrinsics.areEqual(this.type, giftShortcutData.type) && Intrinsics.areEqual(this.bannerUrl, giftShortcutData.bannerUrl);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getAvatar2() {
        return this.avatar2;
    }

    @Nullable
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    public final String getEntryUrl() {
        return this.entryUrl;
    }

    @Nullable
    public final Integer getResMedalType() {
        return this.resMedalType;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.avatar2;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.entryUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.resMedalType;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.type;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.bannerUrl;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setAvatar2(@Nullable String str) {
        this.avatar2 = str;
    }

    public final void setBannerUrl(@Nullable String str) {
        this.bannerUrl = str;
    }

    public final void setEntryUrl(@Nullable String str) {
        this.entryUrl = str;
    }

    public final void setResMedalType(@Nullable Integer num) {
        this.resMedalType = num;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "GiftShortcutData(avatar=" + this.avatar + ", avatar2=" + this.avatar2 + ", entryUrl=" + this.entryUrl + ", resMedalType=" + this.resMedalType + ", type=" + this.type + ", bannerUrl=" + this.bannerUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.avatar);
        dest.writeString(this.avatar2);
        dest.writeString(this.entryUrl);
        Integer num = this.resMedalType;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.type;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.bannerUrl);
    }

    public GiftShortcutData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Integer num2, @Nullable String str4) {
        this.avatar = str;
        this.avatar2 = str2;
        this.entryUrl = str3;
        this.resMedalType = num;
        this.type = num2;
        this.bannerUrl = str4;
    }

    public /* synthetic */ GiftShortcutData(String str, String str2, String str3, Integer num, Integer num2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str4);
    }
}
