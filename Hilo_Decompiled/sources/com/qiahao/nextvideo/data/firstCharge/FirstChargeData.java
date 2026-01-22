package com.qiahao.nextvideo.data.firstCharge;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&Jh\u00102\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00103J\u0006\u00104\u001a\u000205J\u0013\u00106\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u000205HÖ\u0001J\t\u0010:\u001a\u00020\nHÖ\u0001J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000205R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b\u000e\u0010&\"\u0004\b*\u0010(¨\u0006@"}, d2 = {"Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "Landroid/os/Parcelable;", "awards", "", "Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeAward;", "charge", "", "originalPrice", "", "productId", "", "diamondValue", "hasGetReward", "", "isCanRecharge", "<init>", "(Ljava/util/List;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAwards", "()Ljava/util/List;", "setAwards", "(Ljava/util/List;)V", "getCharge", "()Ljava/lang/Float;", "setCharge", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getOriginalPrice", "()Ljava/lang/Long;", "setOriginalPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getDiamondValue", "setDiamondValue", "getHasGetReward", "()Ljava/lang/Boolean;", "setHasGetReward", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setCanRecharge", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FirstChargeData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FirstChargeData> CREATOR = new Creator();

    @Nullable
    private List<FirstChargeAward> awards;

    @Nullable
    private Float charge;

    @Nullable
    private Long diamondValue;

    @Nullable
    private Boolean hasGetReward;

    @Nullable
    private Boolean isCanRecharge;

    @Nullable
    private Long originalPrice;

    @Nullable
    private String productId;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<FirstChargeData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FirstChargeData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(FirstChargeAward.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new FirstChargeData(arrayList, parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FirstChargeData[] newArray(int i) {
            return new FirstChargeData[i];
        }
    }

    public FirstChargeData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ FirstChargeData copy$default(FirstChargeData firstChargeData, List list, Float f, Long l, String str, Long l2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = firstChargeData.awards;
        }
        if ((i & 2) != 0) {
            f = firstChargeData.charge;
        }
        Float f2 = f;
        if ((i & 4) != 0) {
            l = firstChargeData.originalPrice;
        }
        Long l3 = l;
        if ((i & 8) != 0) {
            str = firstChargeData.productId;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            l2 = firstChargeData.diamondValue;
        }
        Long l4 = l2;
        if ((i & 32) != 0) {
            bool = firstChargeData.hasGetReward;
        }
        Boolean bool3 = bool;
        if ((i & 64) != 0) {
            bool2 = firstChargeData.isCanRecharge;
        }
        return firstChargeData.copy(list, f2, l3, str2, l4, bool3, bool2);
    }

    @Nullable
    public final List<FirstChargeAward> component1() {
        return this.awards;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Float getCharge() {
        return this.charge;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getOriginalPrice() {
        return this.originalPrice;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getDiamondValue() {
        return this.diamondValue;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getHasGetReward() {
        return this.hasGetReward;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getIsCanRecharge() {
        return this.isCanRecharge;
    }

    @NotNull
    public final FirstChargeData copy(@Nullable List<FirstChargeAward> awards, @Nullable Float charge, @Nullable Long originalPrice, @Nullable String productId, @Nullable Long diamondValue, @Nullable Boolean hasGetReward, @Nullable Boolean isCanRecharge) {
        return new FirstChargeData(awards, charge, originalPrice, productId, diamondValue, hasGetReward, isCanRecharge);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirstChargeData)) {
            return false;
        }
        FirstChargeData firstChargeData = (FirstChargeData) other;
        return Intrinsics.areEqual(this.awards, firstChargeData.awards) && Intrinsics.areEqual(this.charge, firstChargeData.charge) && Intrinsics.areEqual(this.originalPrice, firstChargeData.originalPrice) && Intrinsics.areEqual(this.productId, firstChargeData.productId) && Intrinsics.areEqual(this.diamondValue, firstChargeData.diamondValue) && Intrinsics.areEqual(this.hasGetReward, firstChargeData.hasGetReward) && Intrinsics.areEqual(this.isCanRecharge, firstChargeData.isCanRecharge);
    }

    @Nullable
    public final List<FirstChargeAward> getAwards() {
        return this.awards;
    }

    @Nullable
    public final Float getCharge() {
        return this.charge;
    }

    @Nullable
    public final Long getDiamondValue() {
        return this.diamondValue;
    }

    @Nullable
    public final Boolean getHasGetReward() {
        return this.hasGetReward;
    }

    @Nullable
    public final Long getOriginalPrice() {
        return this.originalPrice;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        List<FirstChargeAward> list = this.awards;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Float f = this.charge;
        int hashCode2 = (hashCode + (f == null ? 0 : f.hashCode())) * 31;
        Long l = this.originalPrice;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.productId;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Long l2 = this.diamondValue;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool = this.hasGetReward;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isCanRecharge;
        return hashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isCanRecharge() {
        return this.isCanRecharge;
    }

    public final void setAwards(@Nullable List<FirstChargeAward> list) {
        this.awards = list;
    }

    public final void setCanRecharge(@Nullable Boolean bool) {
        this.isCanRecharge = bool;
    }

    public final void setCharge(@Nullable Float f) {
        this.charge = f;
    }

    public final void setDiamondValue(@Nullable Long l) {
        this.diamondValue = l;
    }

    public final void setHasGetReward(@Nullable Boolean bool) {
        this.hasGetReward = bool;
    }

    public final void setOriginalPrice(@Nullable Long l) {
        this.originalPrice = l;
    }

    public final void setProductId(@Nullable String str) {
        this.productId = str;
    }

    @NotNull
    public String toString() {
        return "FirstChargeData(awards=" + this.awards + ", charge=" + this.charge + ", originalPrice=" + this.originalPrice + ", productId=" + this.productId + ", diamondValue=" + this.diamondValue + ", hasGetReward=" + this.hasGetReward + ", isCanRecharge=" + this.isCanRecharge + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        List<FirstChargeAward> list = this.awards;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<FirstChargeAward> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        Float f = this.charge;
        if (f == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f.floatValue());
        }
        Long l = this.originalPrice;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.productId);
        Long l2 = this.diamondValue;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        Boolean bool = this.hasGetReward;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.isCanRecharge;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }

    public FirstChargeData(@Nullable List<FirstChargeAward> list, @Nullable Float f, @Nullable Long l, @Nullable String str, @Nullable Long l2, @Nullable Boolean bool, @Nullable Boolean bool2) {
        this.awards = list;
        this.charge = f;
        this.originalPrice = l;
        this.productId = str;
        this.diamondValue = l2;
        this.hasGetReward = bool;
        this.isCanRecharge = bool2;
    }

    public /* synthetic */ FirstChargeData(List list, Float f, Long l, String str, Long l2, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : f, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2);
    }
}
