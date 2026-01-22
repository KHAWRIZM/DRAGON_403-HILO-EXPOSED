package com.qiahao.nextvideo.data.family;

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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u0005J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\bHÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/data/family/FamilyWheel;", "Landroid/os/Parcelable;", ExchangeDetailActivity.TYPE_DIAMOND, "", "totalUserNum", "", "userNum", "wheelUrl", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTotalUserNum", "()Ljava/lang/Integer;", "setTotalUserNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUserNum", "setUserNum", "getWheelUrl", "()Ljava/lang/String;", "setWheelUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/family/FamilyWheel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FamilyWheel implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FamilyWheel> CREATOR = new Creator();

    @Nullable
    private Long diamond;

    @Nullable
    private Integer totalUserNum;

    @Nullable
    private Integer userNum;

    @Nullable
    private String wheelUrl;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FamilyWheel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyWheel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FamilyWheel(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyWheel[] newArray(int i) {
            return new FamilyWheel[i];
        }
    }

    public FamilyWheel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FamilyWheel copy$default(FamilyWheel familyWheel, Long l, Integer num, Integer num2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = familyWheel.diamond;
        }
        if ((i & 2) != 0) {
            num = familyWheel.totalUserNum;
        }
        if ((i & 4) != 0) {
            num2 = familyWheel.userNum;
        }
        if ((i & 8) != 0) {
            str = familyWheel.wheelUrl;
        }
        return familyWheel.copy(l, num, num2, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getTotalUserNum() {
        return this.totalUserNum;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getUserNum() {
        return this.userNum;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getWheelUrl() {
        return this.wheelUrl;
    }

    @NotNull
    public final FamilyWheel copy(@Nullable Long diamond, @Nullable Integer totalUserNum, @Nullable Integer userNum, @Nullable String wheelUrl) {
        return new FamilyWheel(diamond, totalUserNum, userNum, wheelUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyWheel)) {
            return false;
        }
        FamilyWheel familyWheel = (FamilyWheel) other;
        return Intrinsics.areEqual(this.diamond, familyWheel.diamond) && Intrinsics.areEqual(this.totalUserNum, familyWheel.totalUserNum) && Intrinsics.areEqual(this.userNum, familyWheel.userNum) && Intrinsics.areEqual(this.wheelUrl, familyWheel.wheelUrl);
    }

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Integer getTotalUserNum() {
        return this.totalUserNum;
    }

    @Nullable
    public final Integer getUserNum() {
        return this.userNum;
    }

    @Nullable
    public final String getWheelUrl() {
        return this.wheelUrl;
    }

    public int hashCode() {
        Long l = this.diamond;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.totalUserNum;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.userNum;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.wheelUrl;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setTotalUserNum(@Nullable Integer num) {
        this.totalUserNum = num;
    }

    public final void setUserNum(@Nullable Integer num) {
        this.userNum = num;
    }

    public final void setWheelUrl(@Nullable String str) {
        this.wheelUrl = str;
    }

    @NotNull
    public String toString() {
        return "FamilyWheel(diamond=" + this.diamond + ", totalUserNum=" + this.totalUserNum + ", userNum=" + this.userNum + ", wheelUrl=" + this.wheelUrl + ")";
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
        Integer num = this.totalUserNum;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.userNum;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.wheelUrl);
    }

    public FamilyWheel(@Nullable Long l, @Nullable Integer num, @Nullable Integer num2, @Nullable String str) {
        this.diamond = l;
        this.totalUserNum = num;
        this.userNum = num2;
        this.wheelUrl = str;
    }

    public /* synthetic */ FamilyWheel(Long l, Integer num, Integer num2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str);
    }
}
