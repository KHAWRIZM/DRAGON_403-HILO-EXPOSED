package com.qiahao.nextvideo.data.firstCharge;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014Jb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0005J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0005HÖ\u0001J\t\u00103\u001a\u00020\bHÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeAward;", "Landroid/os/Parcelable;", ExchangeDetailActivity.TYPE_DIAMOND, "", "duration", "", "nobleLevel", "picUrl", "", "svgaUrl", "name", "type", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNobleLevel", "setNobleLevel", "getPicUrl", "()Ljava/lang/String;", "setPicUrl", "(Ljava/lang/String;)V", "getSvgaUrl", "setSvgaUrl", "getName", "setName", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeAward;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FirstChargeAward implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FirstChargeAward> CREATOR = new Creator();

    @Nullable
    private Long diamond;

    @Nullable
    private Integer duration;

    @Nullable
    private String name;

    @Nullable
    private Integer nobleLevel;

    @Nullable
    private String picUrl;

    @Nullable
    private String svgaUrl;

    @Nullable
    private Integer type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FirstChargeAward> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FirstChargeAward createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FirstChargeAward(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FirstChargeAward[] newArray(int i) {
            return new FirstChargeAward[i];
        }
    }

    public FirstChargeAward() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ FirstChargeAward copy$default(FirstChargeAward firstChargeAward, Long l, Integer num, Integer num2, String str, String str2, String str3, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = firstChargeAward.diamond;
        }
        if ((i & 2) != 0) {
            num = firstChargeAward.duration;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = firstChargeAward.nobleLevel;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            str = firstChargeAward.picUrl;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = firstChargeAward.svgaUrl;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = firstChargeAward.name;
        }
        String str6 = str3;
        if ((i & 64) != 0) {
            num3 = firstChargeAward.type;
        }
        return firstChargeAward.copy(l, num4, num5, str4, str5, str6, num3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @NotNull
    public final FirstChargeAward copy(@Nullable Long diamond, @Nullable Integer duration, @Nullable Integer nobleLevel, @Nullable String picUrl, @Nullable String svgaUrl, @Nullable String name, @Nullable Integer type) {
        return new FirstChargeAward(diamond, duration, nobleLevel, picUrl, svgaUrl, name, type);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirstChargeAward)) {
            return false;
        }
        FirstChargeAward firstChargeAward = (FirstChargeAward) other;
        return Intrinsics.areEqual(this.diamond, firstChargeAward.diamond) && Intrinsics.areEqual(this.duration, firstChargeAward.duration) && Intrinsics.areEqual(this.nobleLevel, firstChargeAward.nobleLevel) && Intrinsics.areEqual(this.picUrl, firstChargeAward.picUrl) && Intrinsics.areEqual(this.svgaUrl, firstChargeAward.svgaUrl) && Intrinsics.areEqual(this.name, firstChargeAward.name) && Intrinsics.areEqual(this.type, firstChargeAward.type);
    }

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Long l = this.diamond;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.duration;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.nobleLevel;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.picUrl;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.svgaUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.type;
        return hashCode6 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setDuration(@Nullable Integer num) {
        this.duration = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setNobleLevel(@Nullable Integer num) {
        this.nobleLevel = num;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setSvgaUrl(@Nullable String str) {
        this.svgaUrl = str;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "FirstChargeAward(diamond=" + this.diamond + ", duration=" + this.duration + ", nobleLevel=" + this.nobleLevel + ", picUrl=" + this.picUrl + ", svgaUrl=" + this.svgaUrl + ", name=" + this.name + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l = this.diamond;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Integer num = this.duration;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.nobleLevel;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.picUrl);
        dest.writeString(this.svgaUrl);
        dest.writeString(this.name);
        Integer num3 = this.type;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
    }

    public FirstChargeAward(@Nullable Long l, @Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num3) {
        this.diamond = l;
        this.duration = num;
        this.nobleLevel = num2;
        this.picUrl = str;
        this.svgaUrl = str2;
        this.name = str3;
        this.type = num3;
    }

    public /* synthetic */ FirstChargeAward(Long l, Integer num, Integer num2, String str, String str2, String str3, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : num3);
    }
}
