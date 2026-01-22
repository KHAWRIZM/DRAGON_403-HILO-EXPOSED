package com.qiahao.nextvideo.data.game;

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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/data/game/SkinTab;", "Landroid/os/Parcelable;", "selectIcon", "", "defaultIcon", "svga", "topBg", "selectColor", "defaultColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSelectIcon", "()Ljava/lang/String;", "setSelectIcon", "(Ljava/lang/String;)V", "getDefaultIcon", "setDefaultIcon", "getSvga", "setSvga", "getTopBg", "setTopBg", "getSelectColor", "setSelectColor", "getDefaultColor", "setDefaultColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SkinTab implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SkinTab> CREATOR = new Creator();

    @Nullable
    private String defaultColor;

    @Nullable
    private String defaultIcon;

    @Nullable
    private String selectColor;

    @Nullable
    private String selectIcon;

    @Nullable
    private String svga;

    @Nullable
    private String topBg;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<SkinTab> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SkinTab createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SkinTab(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SkinTab[] newArray(int i) {
            return new SkinTab[i];
        }
    }

    public SkinTab() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ SkinTab copy$default(SkinTab skinTab, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = skinTab.selectIcon;
        }
        if ((i & 2) != 0) {
            str2 = skinTab.defaultIcon;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = skinTab.svga;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = skinTab.topBg;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = skinTab.selectColor;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = skinTab.defaultColor;
        }
        return skinTab.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSelectIcon() {
        return this.selectIcon;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getDefaultIcon() {
        return this.defaultIcon;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSvga() {
        return this.svga;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTopBg() {
        return this.topBg;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @NotNull
    public final SkinTab copy(@Nullable String selectIcon, @Nullable String defaultIcon, @Nullable String svga, @Nullable String topBg, @Nullable String selectColor, @Nullable String defaultColor) {
        return new SkinTab(selectIcon, defaultIcon, svga, topBg, selectColor, defaultColor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkinTab)) {
            return false;
        }
        SkinTab skinTab = (SkinTab) other;
        return Intrinsics.areEqual(this.selectIcon, skinTab.selectIcon) && Intrinsics.areEqual(this.defaultIcon, skinTab.defaultIcon) && Intrinsics.areEqual(this.svga, skinTab.svga) && Intrinsics.areEqual(this.topBg, skinTab.topBg) && Intrinsics.areEqual(this.selectColor, skinTab.selectColor) && Intrinsics.areEqual(this.defaultColor, skinTab.defaultColor);
    }

    @Nullable
    public final String getDefaultColor() {
        return this.defaultColor;
    }

    @Nullable
    public final String getDefaultIcon() {
        return this.defaultIcon;
    }

    @Nullable
    public final String getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    public final String getSelectIcon() {
        return this.selectIcon;
    }

    @Nullable
    public final String getSvga() {
        return this.svga;
    }

    @Nullable
    public final String getTopBg() {
        return this.topBg;
    }

    public int hashCode() {
        String str = this.selectIcon;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.defaultIcon;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.svga;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.topBg;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.selectColor;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.defaultColor;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setDefaultColor(@Nullable String str) {
        this.defaultColor = str;
    }

    public final void setDefaultIcon(@Nullable String str) {
        this.defaultIcon = str;
    }

    public final void setSelectColor(@Nullable String str) {
        this.selectColor = str;
    }

    public final void setSelectIcon(@Nullable String str) {
        this.selectIcon = str;
    }

    public final void setSvga(@Nullable String str) {
        this.svga = str;
    }

    public final void setTopBg(@Nullable String str) {
        this.topBg = str;
    }

    @NotNull
    public String toString() {
        return "SkinTab(selectIcon=" + this.selectIcon + ", defaultIcon=" + this.defaultIcon + ", svga=" + this.svga + ", topBg=" + this.topBg + ", selectColor=" + this.selectColor + ", defaultColor=" + this.defaultColor + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.selectIcon);
        dest.writeString(this.defaultIcon);
        dest.writeString(this.svga);
        dest.writeString(this.topBg);
        dest.writeString(this.selectColor);
        dest.writeString(this.defaultColor);
    }

    public SkinTab(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.selectIcon = str;
        this.defaultIcon = str2;
        this.svga = str3;
        this.topBg = str4;
        this.selectColor = str5;
        this.defaultColor = str6;
    }

    public /* synthetic */ SkinTab(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }
}
