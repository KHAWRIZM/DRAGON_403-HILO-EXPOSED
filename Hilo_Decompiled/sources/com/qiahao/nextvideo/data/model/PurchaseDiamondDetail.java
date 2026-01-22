package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Parcelize
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jd\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u000bJ\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u000bHÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001b¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "Landroid/os/Parcelable;", AgooConstants.MESSAGE_ID, "", "productID", "", "amount", "", "price", "discount", "type", "", "extraAmount", "showPrice", "<init>", "(JLjava/lang/String;FFLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()J", "getProductID", "()Ljava/lang/String;", "getAmount", "()F", "getPrice", "getDiscount", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExtraAmount", "setExtraAmount", "getShowPrice", "setShowPrice", "(Ljava/lang/String;)V", "resId", "getResId", "setResId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;FFLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PurchaseDiamondDetail implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<PurchaseDiamondDetail> CREATOR = new Creator();

    @c("amount")
    private final float amount;

    @NotNull
    @c("discount")
    private final String discount;

    @Nullable
    private Integer extraAmount;

    @c("index")
    private final long id;

    @c("price")
    private final float price;

    @NotNull
    @c("productId")
    private final String productID;

    @Nullable
    private Integer resId;

    @Nullable
    private String showPrice;

    @Nullable
    private Integer type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<PurchaseDiamondDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchaseDiamondDetail createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PurchaseDiamondDetail(parcel.readLong(), parcel.readString(), parcel.readFloat(), parcel.readFloat(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchaseDiamondDetail[] newArray(int i) {
            return new PurchaseDiamondDetail[i];
        }
    }

    public PurchaseDiamondDetail(long j, @NotNull String str, float f, float f2, @NotNull String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "productID");
        Intrinsics.checkNotNullParameter(str2, "discount");
        this.id = j;
        this.productID = str;
        this.amount = f;
        this.price = f2;
        this.discount = str2;
        this.type = num;
        this.extraAmount = num2;
        this.showPrice = str3;
        this.resId = 0;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getProductID() {
        return this.productID;
    }

    /* renamed from: component3, reason: from getter */
    public final float getAmount() {
        return this.amount;
    }

    /* renamed from: component4, reason: from getter */
    public final float getPrice() {
        return this.price;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getDiscount() {
        return this.discount;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getExtraAmount() {
        return this.extraAmount;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getShowPrice() {
        return this.showPrice;
    }

    @NotNull
    public final PurchaseDiamondDetail copy(long id2, @NotNull String productID, float amount, float price, @NotNull String discount, @Nullable Integer type, @Nullable Integer extraAmount, @Nullable String showPrice) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(discount, "discount");
        return new PurchaseDiamondDetail(id2, productID, amount, price, discount, type, extraAmount, showPrice);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseDiamondDetail)) {
            return false;
        }
        PurchaseDiamondDetail purchaseDiamondDetail = (PurchaseDiamondDetail) other;
        return this.id == purchaseDiamondDetail.id && Intrinsics.areEqual(this.productID, purchaseDiamondDetail.productID) && Float.compare(this.amount, purchaseDiamondDetail.amount) == 0 && Float.compare(this.price, purchaseDiamondDetail.price) == 0 && Intrinsics.areEqual(this.discount, purchaseDiamondDetail.discount) && Intrinsics.areEqual(this.type, purchaseDiamondDetail.type) && Intrinsics.areEqual(this.extraAmount, purchaseDiamondDetail.extraAmount) && Intrinsics.areEqual(this.showPrice, purchaseDiamondDetail.showPrice);
    }

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getDiscount() {
        return this.discount;
    }

    @Nullable
    public final Integer getExtraAmount() {
        return this.extraAmount;
    }

    public final long getId() {
        return this.id;
    }

    public final float getPrice() {
        return this.price;
    }

    @NotNull
    public final String getProductID() {
        return this.productID;
    }

    @Nullable
    public final Integer getResId() {
        return this.resId;
    }

    @Nullable
    public final String getShowPrice() {
        return this.showPrice;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int a = ((((((((androidx.collection.c.a(this.id) * 31) + this.productID.hashCode()) * 31) + Float.floatToIntBits(this.amount)) * 31) + Float.floatToIntBits(this.price)) * 31) + this.discount.hashCode()) * 31;
        Integer num = this.type;
        int i = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i2 = (a + hashCode) * 31;
        Integer num2 = this.extraAmount;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i3 = (i2 + hashCode2) * 31;
        String str = this.showPrice;
        if (str != null) {
            i = str.hashCode();
        }
        return i3 + i;
    }

    public final void setExtraAmount(@Nullable Integer num) {
        this.extraAmount = num;
    }

    public final void setResId(@Nullable Integer num) {
        this.resId = num;
    }

    public final void setShowPrice(@Nullable String str) {
        this.showPrice = str;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "PurchaseDiamondDetail(id=" + this.id + ", productID=" + this.productID + ", amount=" + this.amount + ", price=" + this.price + ", discount=" + this.discount + ", type=" + this.type + ", extraAmount=" + this.extraAmount + ", showPrice=" + this.showPrice + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.productID);
        dest.writeFloat(this.amount);
        dest.writeFloat(this.price);
        dest.writeString(this.discount);
        Integer num = this.type;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.extraAmount;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.showPrice);
    }

    public /* synthetic */ PurchaseDiamondDetail(long j, String str, float f, float f2, String str2, Integer num, Integer num2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, f, f2, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : str3);
    }
}
