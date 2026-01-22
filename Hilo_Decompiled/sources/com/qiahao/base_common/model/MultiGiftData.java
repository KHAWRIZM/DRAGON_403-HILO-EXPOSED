package com.qiahao.base_common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0004J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/qiahao/base_common/model/MultiGiftData;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Landroid/os/Parcelable;", "itemType", "", "giftData", "Lcom/qiahao/base_common/model/GiftData;", "<init>", "(ILcom/qiahao/base_common/model/GiftData;)V", "getItemType", "()I", "getGiftData", "()Lcom/qiahao/base_common/model/GiftData;", "setGiftData", "(Lcom/qiahao/base_common/model/GiftData;)V", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MultiGiftData implements MultiItemEntity, Parcelable {
    public static final int ITEM_TYPE_EFFECT = 1;
    public static final int ITEM_TYPE_GIFT = 0;

    @Nullable
    private GiftData giftData;
    private final int itemType;

    @NotNull
    public static final Parcelable.Creator<MultiGiftData> CREATOR = new Creator();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<MultiGiftData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MultiGiftData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MultiGiftData(parcel.readInt(), parcel.readInt() == 0 ? null : GiftData.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MultiGiftData[] newArray(int i10) {
            return new MultiGiftData[i10];
        }
    }

    public MultiGiftData(int i10, @Nullable GiftData giftData) {
        this.itemType = i10;
        this.giftData = giftData;
    }

    public static /* synthetic */ MultiGiftData copy$default(MultiGiftData multiGiftData, int i10, GiftData giftData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = multiGiftData.itemType;
        }
        if ((i11 & 2) != 0) {
            giftData = multiGiftData.giftData;
        }
        return multiGiftData.copy(i10, giftData);
    }

    /* renamed from: component1, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final GiftData getGiftData() {
        return this.giftData;
    }

    @NotNull
    public final MultiGiftData copy(int itemType, @Nullable GiftData giftData) {
        return new MultiGiftData(itemType, giftData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiGiftData)) {
            return false;
        }
        MultiGiftData multiGiftData = (MultiGiftData) other;
        return this.itemType == multiGiftData.itemType && Intrinsics.areEqual(this.giftData, multiGiftData.giftData);
    }

    @Nullable
    public final GiftData getGiftData() {
        return this.giftData;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        int i10 = this.itemType * 31;
        GiftData giftData = this.giftData;
        return i10 + (giftData == null ? 0 : giftData.hashCode());
    }

    public final void setGiftData(@Nullable GiftData giftData) {
        this.giftData = giftData;
    }

    @NotNull
    public String toString() {
        return "MultiGiftData(itemType=" + this.itemType + ", giftData=" + this.giftData + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.itemType);
        GiftData giftData = this.giftData;
        if (giftData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            giftData.writeToParcel(dest, flags);
        }
    }

    public /* synthetic */ MultiGiftData(int i10, GiftData giftData, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? null : giftData);
    }
}
