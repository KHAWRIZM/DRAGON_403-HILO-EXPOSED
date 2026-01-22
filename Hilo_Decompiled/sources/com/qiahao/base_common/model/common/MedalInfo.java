package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u0004J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006("}, d2 = {"Lcom/qiahao/base_common/model/common/MedalInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "id", "", "picUrl", "", "effectUrl", "svgaUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getPicUrl", "()Ljava/lang/String;", "setPicUrl", "(Ljava/lang/String;)V", "getEffectUrl", "setEffectUrl", "getSvgaUrl", "setSvgaUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MedalInfo implements Parcelable, Serializable {

    @NotNull
    public static final Parcelable.Creator<MedalInfo> CREATOR = new Creator();

    @Nullable
    private String effectUrl;
    private int id;

    @Nullable
    private String picUrl;

    @Nullable
    private String svgaUrl;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<MedalInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MedalInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MedalInfo(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MedalInfo[] newArray(int i10) {
            return new MedalInfo[i10];
        }
    }

    public MedalInfo(int i10, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.id = i10;
        this.picUrl = str;
        this.effectUrl = str2;
        this.svgaUrl = str3;
    }

    public static /* synthetic */ MedalInfo copy$default(MedalInfo medalInfo, int i10, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = medalInfo.id;
        }
        if ((i11 & 2) != 0) {
            str = medalInfo.picUrl;
        }
        if ((i11 & 4) != 0) {
            str2 = medalInfo.effectUrl;
        }
        if ((i11 & 8) != 0) {
            str3 = medalInfo.svgaUrl;
        }
        return medalInfo.copy(i10, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    public final MedalInfo copy(int id, @Nullable String picUrl, @Nullable String effectUrl, @Nullable String svgaUrl) {
        return new MedalInfo(id, picUrl, effectUrl, svgaUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalInfo)) {
            return false;
        }
        MedalInfo medalInfo = (MedalInfo) other;
        return this.id == medalInfo.id && Intrinsics.areEqual(this.picUrl, medalInfo.picUrl) && Intrinsics.areEqual(this.effectUrl, medalInfo.effectUrl) && Intrinsics.areEqual(this.svgaUrl, medalInfo.svgaUrl);
    }

    @Nullable
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public int hashCode() {
        int i10 = this.id * 31;
        String str = this.picUrl;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.effectUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.svgaUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setEffectUrl(@Nullable String str) {
        this.effectUrl = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setSvgaUrl(@Nullable String str) {
        this.svgaUrl = str;
    }

    @NotNull
    public String toString() {
        return "MedalInfo(id=" + this.id + ", picUrl=" + this.picUrl + ", effectUrl=" + this.effectUrl + ", svgaUrl=" + this.svgaUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.picUrl);
        dest.writeString(this.effectUrl);
        dest.writeString(this.svgaUrl);
    }

    public /* synthetic */ MedalInfo(int i10, String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, str2, (i11 & 8) != 0 ? null : str3);
    }
}
