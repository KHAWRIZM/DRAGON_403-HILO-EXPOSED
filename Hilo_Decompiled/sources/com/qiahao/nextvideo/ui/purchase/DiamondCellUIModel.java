package com.qiahao.nextvideo.ui.purchase;

import androidx.annotation.Keep;
import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJV\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;", "", AgooConstants.MESSAGE_ID, "", "diamondImageRes", "", "name", "", "price", "description", "productID", "extraAmount", "<init>", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()J", "getDiamondImageRes", "()I", "getName", "()Ljava/lang/String;", "getPrice", "setPrice", "(Ljava/lang/String;)V", "getDescription", "getProductID", "getExtraAmount", "()Ljava/lang/Integer;", "setExtraAmount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DiamondCellUIModel {

    @NotNull
    private final String description;
    private final int diamondImageRes;

    @Nullable
    private Integer extraAmount;
    private final long id;

    @NotNull
    private final String name;

    @NotNull
    private String price;

    @NotNull
    private final String productID;

    public DiamondCellUIModel(long j, int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "price");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "productID");
        this.id = j;
        this.diamondImageRes = i;
        this.name = str;
        this.price = str2;
        this.description = str3;
        this.productID = str4;
        this.extraAmount = num;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDiamondImageRes() {
        return this.diamondImageRes;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getProductID() {
        return this.productID;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getExtraAmount() {
        return this.extraAmount;
    }

    @NotNull
    public final DiamondCellUIModel copy(long id2, int diamondImageRes, @NotNull String name, @NotNull String price, @NotNull String description, @NotNull String productID, @Nullable Integer extraAmount) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productID, "productID");
        return new DiamondCellUIModel(id2, diamondImageRes, name, price, description, productID, extraAmount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiamondCellUIModel)) {
            return false;
        }
        DiamondCellUIModel diamondCellUIModel = (DiamondCellUIModel) other;
        return this.id == diamondCellUIModel.id && this.diamondImageRes == diamondCellUIModel.diamondImageRes && Intrinsics.areEqual(this.name, diamondCellUIModel.name) && Intrinsics.areEqual(this.price, diamondCellUIModel.price) && Intrinsics.areEqual(this.description, diamondCellUIModel.description) && Intrinsics.areEqual(this.productID, diamondCellUIModel.productID) && Intrinsics.areEqual(this.extraAmount, diamondCellUIModel.extraAmount);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getDiamondImageRes() {
        return this.diamondImageRes;
    }

    @Nullable
    public final Integer getExtraAmount() {
        return this.extraAmount;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getProductID() {
        return this.productID;
    }

    public int hashCode() {
        int a = ((((((((((c.a(this.id) * 31) + this.diamondImageRes) * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.description.hashCode()) * 31) + this.productID.hashCode()) * 31;
        Integer num = this.extraAmount;
        return a + (num == null ? 0 : num.hashCode());
    }

    public final void setExtraAmount(@Nullable Integer num) {
        this.extraAmount = num;
    }

    public final void setPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.price = str;
    }

    @NotNull
    public String toString() {
        return "DiamondCellUIModel(id=" + this.id + ", diamondImageRes=" + this.diamondImageRes + ", name=" + this.name + ", price=" + this.price + ", description=" + this.description + ", productID=" + this.productID + ", extraAmount=" + this.extraAmount + ")";
    }

    public /* synthetic */ DiamondCellUIModel(long j, int i, String str, String str2, String str3, String str4, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, str, str2, str3, str4, (i2 & 64) != 0 ? null : num);
    }
}
