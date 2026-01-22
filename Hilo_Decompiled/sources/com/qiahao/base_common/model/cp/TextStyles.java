package com.qiahao.base_common.model.cp;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020!HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0006\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006,"}, d2 = {"Lcom/qiahao/base_common/model/cp/TextStyles;", "Landroid/os/Parcelable;", "textColor", "", "textSize", "", "isBold", "", "textKey", "<init>", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;)V", "getTextColor", "()Ljava/lang/String;", "setTextColor", "(Ljava/lang/String;)V", "getTextSize", "()Ljava/lang/Float;", "setTextSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "()Ljava/lang/Boolean;", "setBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTextKey", "setTextKey", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/qiahao/base_common/model/cp/TextStyles;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class TextStyles implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TextStyles> CREATOR = new Creator();

    @Nullable
    private Boolean isBold;

    @Nullable
    private String textColor;

    @Nullable
    private String textKey;

    @Nullable
    private Float textSize;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<TextStyles> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextStyles createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Boolean bool = null;
            Float valueOf = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new TextStyles(readString, valueOf, bool, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TextStyles[] newArray(int i10) {
            return new TextStyles[i10];
        }
    }

    public TextStyles() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ TextStyles copy$default(TextStyles textStyles, String str, Float f10, Boolean bool, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = textStyles.textColor;
        }
        if ((i10 & 2) != 0) {
            f10 = textStyles.textSize;
        }
        if ((i10 & 4) != 0) {
            bool = textStyles.isBold;
        }
        if ((i10 & 8) != 0) {
            str2 = textStyles.textKey;
        }
        return textStyles.copy(str, f10, bool, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Float getTextSize() {
        return this.textSize;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getIsBold() {
        return this.isBold;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTextKey() {
        return this.textKey;
    }

    @NotNull
    public final TextStyles copy(@Nullable String textColor, @Nullable Float textSize, @Nullable Boolean isBold, @Nullable String textKey) {
        return new TextStyles(textColor, textSize, isBold, textKey);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextStyles)) {
            return false;
        }
        TextStyles textStyles = (TextStyles) other;
        return Intrinsics.areEqual(this.textColor, textStyles.textColor) && Intrinsics.areEqual((Object) this.textSize, (Object) textStyles.textSize) && Intrinsics.areEqual(this.isBold, textStyles.isBold) && Intrinsics.areEqual(this.textKey, textStyles.textKey);
    }

    @Nullable
    public final String getTextColor() {
        return this.textColor;
    }

    @Nullable
    public final String getTextKey() {
        return this.textKey;
    }

    @Nullable
    public final Float getTextSize() {
        return this.textSize;
    }

    public int hashCode() {
        String str = this.textColor;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Float f10 = this.textSize;
        int hashCode2 = (hashCode + (f10 == null ? 0 : f10.hashCode())) * 31;
        Boolean bool = this.isBold;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.textKey;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isBold() {
        return this.isBold;
    }

    public final void setBold(@Nullable Boolean bool) {
        this.isBold = bool;
    }

    public final void setTextColor(@Nullable String str) {
        this.textColor = str;
    }

    public final void setTextKey(@Nullable String str) {
        this.textKey = str;
    }

    public final void setTextSize(@Nullable Float f10) {
        this.textSize = f10;
    }

    @NotNull
    public String toString() {
        return "TextStyles(textColor=" + this.textColor + ", textSize=" + this.textSize + ", isBold=" + this.isBold + ", textKey=" + this.textKey + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.textColor);
        Float f10 = this.textSize;
        if (f10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f10.floatValue());
        }
        Boolean bool = this.isBold;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        dest.writeString(this.textKey);
    }

    public TextStyles(@Nullable String str, @Nullable Float f10, @Nullable Boolean bool, @Nullable String str2) {
        this.textColor = str;
        this.textSize = f10;
        this.isBold = bool;
        this.textKey = str2;
    }

    public /* synthetic */ TextStyles(String str, Float f10, Boolean bool, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : f10, (i10 & 4) != 0 ? null : bool, (i10 & 8) != 0 ? null : str2);
    }
}
