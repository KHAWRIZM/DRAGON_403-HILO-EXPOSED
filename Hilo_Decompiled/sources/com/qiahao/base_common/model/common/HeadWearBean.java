package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qiahao.base_common.utils.HiloUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0004J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006'"}, d2 = {"Lcom/qiahao/base_common/model/common/HeadWearBean;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "effectUrl", "", "picUrl", "headwearIcon", "reverseEffectUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEffectUrl", "()Ljava/lang/String;", "setEffectUrl", "(Ljava/lang/String;)V", "getPicUrl", "setPicUrl", "getHeadwearIcon", "setHeadwearIcon", "getReverseEffectUrl", "setReverseEffectUrl", "getEffectUrl1", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class HeadWearBean implements Serializable, Parcelable {

    @NotNull
    public static final Parcelable.Creator<HeadWearBean> CREATOR = new Creator();

    @Nullable
    private String effectUrl;

    @Nullable
    private String headwearIcon;

    @Nullable
    private String picUrl;

    @Nullable
    private String reverseEffectUrl;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<HeadWearBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HeadWearBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HeadWearBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HeadWearBean[] newArray(int i10) {
            return new HeadWearBean[i10];
        }
    }

    public HeadWearBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.effectUrl = str;
        this.picUrl = str2;
        this.headwearIcon = str3;
        this.reverseEffectUrl = str4;
    }

    public static /* synthetic */ HeadWearBean copy$default(HeadWearBean headWearBean, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = headWearBean.effectUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = headWearBean.picUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = headWearBean.headwearIcon;
        }
        if ((i10 & 8) != 0) {
            str4 = headWearBean.reverseEffectUrl;
        }
        return headWearBean.copy(str, str2, str3, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getHeadwearIcon() {
        return this.headwearIcon;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getReverseEffectUrl() {
        return this.reverseEffectUrl;
    }

    @NotNull
    public final HeadWearBean copy(@Nullable String effectUrl, @Nullable String picUrl, @Nullable String headwearIcon, @Nullable String reverseEffectUrl) {
        return new HeadWearBean(effectUrl, picUrl, headwearIcon, reverseEffectUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeadWearBean)) {
            return false;
        }
        HeadWearBean headWearBean = (HeadWearBean) other;
        return Intrinsics.areEqual(this.effectUrl, headWearBean.effectUrl) && Intrinsics.areEqual(this.picUrl, headWearBean.picUrl) && Intrinsics.areEqual(this.headwearIcon, headWearBean.headwearIcon) && Intrinsics.areEqual(this.reverseEffectUrl, headWearBean.reverseEffectUrl);
    }

    @Nullable
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @NotNull
    public final String getEffectUrl1() {
        String str;
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            String str2 = this.reverseEffectUrl;
            if (str2 == null) {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                str = this.reverseEffectUrl;
                if (str == null) {
                    return "";
                }
            } else {
                str = this.effectUrl;
                if (str == null) {
                    return "";
                }
            }
        } else {
            str = this.effectUrl;
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @Nullable
    public final String getHeadwearIcon() {
        return this.headwearIcon;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final String getReverseEffectUrl() {
        return this.reverseEffectUrl;
    }

    public int hashCode() {
        String str = this.effectUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.picUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.headwearIcon;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.reverseEffectUrl;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setEffectUrl(@Nullable String str) {
        this.effectUrl = str;
    }

    public final void setHeadwearIcon(@Nullable String str) {
        this.headwearIcon = str;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setReverseEffectUrl(@Nullable String str) {
        this.reverseEffectUrl = str;
    }

    @NotNull
    public String toString() {
        return "HeadWearBean(effectUrl=" + this.effectUrl + ", picUrl=" + this.picUrl + ", headwearIcon=" + this.headwearIcon + ", reverseEffectUrl=" + this.reverseEffectUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.effectUrl);
        dest.writeString(this.picUrl);
        dest.writeString(this.headwearIcon);
        dest.writeString(this.reverseEffectUrl);
    }

    public /* synthetic */ HeadWearBean(String str, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}
