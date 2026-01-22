package com.qiahao.nextvideo.ui.reusable.uimodels;

import androidx.annotation.Keep;
import androidx.collection.c;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.ReceivedGift;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.Debug;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b,\b\u0087\b\u0018\u0000 82\u00020\u0001:\u00018Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010/\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010!J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J|\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\rHÖ\u0001J\t\u00107\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001d¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/uimodels/PurchaseableItemUIModel;", "", "itemId", "", "imageUIModel", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "itemName", "", "isSelected", "", "giftName", "tagName", "nameStartDrawableResId", "", "tagTitleStartDrawableResid", "cp", "together", "<init>", "(JLcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZ)V", "getItemId", "()J", "getImageUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "setImageUIModel", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;)V", "getItemName", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "getGiftName", "getTagName", "getNameStartDrawableResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagTitleStartDrawableResid", "getCp", "setCp", "getTogether", "setTogether", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JLcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZ)Lcom/qiahao/nextvideo/ui/reusable/uimodels/PurchaseableItemUIModel;", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PurchaseableItemUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean cp;

    @Nullable
    private final String giftName;

    @NotNull
    private ImageUIModel imageUIModel;
    private boolean isSelected;
    private final long itemId;

    @Nullable
    private final String itemName;

    @Nullable
    private final Integer nameStartDrawableResId;

    @Nullable
    private final String tagName;

    @Nullable
    private final Integer tagTitleStartDrawableResid;
    private boolean together;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/uimodels/PurchaseableItemUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/PurchaseableItemUIModel;", Constants.KEY_MODEL, "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "receivedGift", "Lcom/qiahao/nextvideo/data/model/ReceivedGift;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PurchaseableItemUIModel init(@NotNull PurchaseDiamondDetail model) {
            Intrinsics.checkNotNullParameter(model, Constants.KEY_MODEL);
            return new PurchaseableItemUIModel(model.getId(), ImageUIModel.Companion.displayImage$default(ImageUIModel.INSTANCE, (String) CollectionsKt.random(Debug.INSTANCE.getImages(), Random.Default), null, 2, null), "", false, "", "", null, null, false, false, RoomEvent.ROOM_GAME_BET_RANK, null);
        }

        private Companion() {
        }

        @NotNull
        public final PurchaseableItemUIModel init(@NotNull ReceivedGift receivedGift) {
            Intrinsics.checkNotNullParameter(receivedGift, "receivedGift");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String icon = receivedGift.getIcon();
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            lfit.setWidth(dimens.dpToPx(70));
            lfit.setHeight(dimens.dpToPx(70));
            Unit unit = Unit.INSTANCE;
            ImageUIModel displayImage = companion.displayImage(icon, lfit);
            displayImage.setPlaceholder(2131232497);
            return new PurchaseableItemUIModel(0L, displayImage, "x " + receivedGift.getCount(), false, "", null, null, null, false, false, RoomEvent.ROOM_GAME_BET_RANK, null);
        }
    }

    public PurchaseableItemUIModel(long j, @NotNull ImageUIModel imageUIModel, @Nullable String str, boolean z, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Integer num2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        this.itemId = j;
        this.imageUIModel = imageUIModel;
        this.itemName = str;
        this.isSelected = z;
        this.giftName = str2;
        this.tagName = str3;
        this.nameStartDrawableResId = num;
        this.tagTitleStartDrawableResid = num2;
        this.cp = z2;
        this.together = z3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getItemId() {
        return this.itemId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getTogether() {
        return this.together;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getItemName() {
        return this.itemName;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getGiftName() {
        return this.giftName;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getNameStartDrawableResId() {
        return this.nameStartDrawableResId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getTagTitleStartDrawableResid() {
        return this.tagTitleStartDrawableResid;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getCp() {
        return this.cp;
    }

    @NotNull
    public final PurchaseableItemUIModel copy(long itemId, @NotNull ImageUIModel imageUIModel, @Nullable String itemName, boolean isSelected, @Nullable String giftName, @Nullable String tagName, @Nullable Integer nameStartDrawableResId, @Nullable Integer tagTitleStartDrawableResid, boolean cp, boolean together) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        return new PurchaseableItemUIModel(itemId, imageUIModel, itemName, isSelected, giftName, tagName, nameStartDrawableResId, tagTitleStartDrawableResid, cp, together);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseableItemUIModel)) {
            return false;
        }
        PurchaseableItemUIModel purchaseableItemUIModel = (PurchaseableItemUIModel) other;
        return this.itemId == purchaseableItemUIModel.itemId && Intrinsics.areEqual(this.imageUIModel, purchaseableItemUIModel.imageUIModel) && Intrinsics.areEqual(this.itemName, purchaseableItemUIModel.itemName) && this.isSelected == purchaseableItemUIModel.isSelected && Intrinsics.areEqual(this.giftName, purchaseableItemUIModel.giftName) && Intrinsics.areEqual(this.tagName, purchaseableItemUIModel.tagName) && Intrinsics.areEqual(this.nameStartDrawableResId, purchaseableItemUIModel.nameStartDrawableResId) && Intrinsics.areEqual(this.tagTitleStartDrawableResid, purchaseableItemUIModel.tagTitleStartDrawableResid) && this.cp == purchaseableItemUIModel.cp && this.together == purchaseableItemUIModel.together;
    }

    public final boolean getCp() {
        return this.cp;
    }

    @Nullable
    public final String getGiftName() {
        return this.giftName;
    }

    @NotNull
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    public final long getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getItemName() {
        return this.itemName;
    }

    @Nullable
    public final Integer getNameStartDrawableResId() {
        return this.nameStartDrawableResId;
    }

    @Nullable
    public final String getTagName() {
        return this.tagName;
    }

    @Nullable
    public final Integer getTagTitleStartDrawableResid() {
        return this.tagTitleStartDrawableResid;
    }

    public final boolean getTogether() {
        return this.together;
    }

    public int hashCode() {
        int a = ((c.a(this.itemId) * 31) + this.imageUIModel.hashCode()) * 31;
        String str = this.itemName;
        int hashCode = (((a + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.isSelected)) * 31;
        String str2 = this.giftName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tagName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.nameStartDrawableResId;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.tagTitleStartDrawableResid;
        return ((((hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31) + a.a(this.cp)) * 31) + a.a(this.together);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setCp(boolean z) {
        this.cp = z;
    }

    public final void setImageUIModel(@NotNull ImageUIModel imageUIModel) {
        Intrinsics.checkNotNullParameter(imageUIModel, "<set-?>");
        this.imageUIModel = imageUIModel;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setTogether(boolean z) {
        this.together = z;
    }

    @NotNull
    public String toString() {
        return "PurchaseableItemUIModel(itemId=" + this.itemId + ", imageUIModel=" + this.imageUIModel + ", itemName=" + this.itemName + ", isSelected=" + this.isSelected + ", giftName=" + this.giftName + ", tagName=" + this.tagName + ", nameStartDrawableResId=" + this.nameStartDrawableResId + ", tagTitleStartDrawableResid=" + this.tagTitleStartDrawableResid + ", cp=" + this.cp + ", together=" + this.together + ")";
    }

    public /* synthetic */ PurchaseableItemUIModel(long j, ImageUIModel imageUIModel, String str, boolean z, String str2, String str3, Integer num, Integer num2, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, imageUIModel, str, z, str2, str3, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? false : z3);
    }
}
