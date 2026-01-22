package com.qiahao.base_common.model.svip;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u0006J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006'"}, d2 = {"Lcom/qiahao/base_common/model/svip/SvipCardDetails;", "Landroid/os/Parcelable;", "cardUrl", "", "description", "cardWidth", "", "cardHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getCardUrl", "()Ljava/lang/String;", "setCardUrl", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getCardWidth", "()I", "setCardWidth", "(I)V", "getCardHeight", "setCardHeight", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class SvipCardDetails implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SvipCardDetails> CREATOR = new Creator();
    private int cardHeight;

    @Nullable
    private String cardUrl;
    private int cardWidth;

    @Nullable
    private String description;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<SvipCardDetails> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipCardDetails createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SvipCardDetails(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SvipCardDetails[] newArray(int i10) {
            return new SvipCardDetails[i10];
        }
    }

    public SvipCardDetails() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ SvipCardDetails copy$default(SvipCardDetails svipCardDetails, String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = svipCardDetails.cardUrl;
        }
        if ((i12 & 2) != 0) {
            str2 = svipCardDetails.description;
        }
        if ((i12 & 4) != 0) {
            i10 = svipCardDetails.cardWidth;
        }
        if ((i12 & 8) != 0) {
            i11 = svipCardDetails.cardHeight;
        }
        return svipCardDetails.copy(str, str2, i10, i11);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCardUrl() {
        return this.cardUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCardWidth() {
        return this.cardWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCardHeight() {
        return this.cardHeight;
    }

    @NotNull
    public final SvipCardDetails copy(@Nullable String cardUrl, @Nullable String description, int cardWidth, int cardHeight) {
        return new SvipCardDetails(cardUrl, description, cardWidth, cardHeight);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SvipCardDetails)) {
            return false;
        }
        SvipCardDetails svipCardDetails = (SvipCardDetails) other;
        return Intrinsics.areEqual(this.cardUrl, svipCardDetails.cardUrl) && Intrinsics.areEqual(this.description, svipCardDetails.description) && this.cardWidth == svipCardDetails.cardWidth && this.cardHeight == svipCardDetails.cardHeight;
    }

    public final int getCardHeight() {
        return this.cardHeight;
    }

    @Nullable
    public final String getCardUrl() {
        return this.cardUrl;
    }

    public final int getCardWidth() {
        return this.cardWidth;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    public int hashCode() {
        String str = this.cardUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.cardWidth) * 31) + this.cardHeight;
    }

    public final void setCardHeight(int i10) {
        this.cardHeight = i10;
    }

    public final void setCardUrl(@Nullable String str) {
        this.cardUrl = str;
    }

    public final void setCardWidth(int i10) {
        this.cardWidth = i10;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    @NotNull
    public String toString() {
        return "SvipCardDetails(cardUrl=" + this.cardUrl + ", description=" + this.description + ", cardWidth=" + this.cardWidth + ", cardHeight=" + this.cardHeight + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.cardUrl);
        dest.writeString(this.description);
        dest.writeInt(this.cardWidth);
        dest.writeInt(this.cardHeight);
    }

    public SvipCardDetails(@Nullable String str, @Nullable String str2, int i10, int i11) {
        this.cardUrl = str;
        this.description = str2;
        this.cardWidth = i10;
        this.cardHeight = i11;
    }

    public /* synthetic */ SvipCardDetails(String str, String str2, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? 1 : i10, (i12 & 8) != 0 ? 1 : i11);
    }
}
