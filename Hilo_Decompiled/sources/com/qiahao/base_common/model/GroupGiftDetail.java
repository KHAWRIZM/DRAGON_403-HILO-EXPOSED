package com.qiahao.base_common.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006%"}, d2 = {"Lcom/qiahao/base_common/model/GroupGiftDetail;", "Landroid/os/Parcelable;", "svgaUrl", "", "iconUrl", "senderAvatar", "receiverAvatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSvgaUrl", "()Ljava/lang/String;", "setSvgaUrl", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getSenderAvatar", "setSenderAvatar", "getReceiverAvatar", "setReceiverAvatar", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GroupGiftDetail implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GroupGiftDetail> CREATOR = new Creator();

    @Nullable
    private String iconUrl;

    @Nullable
    private String receiverAvatar;

    @Nullable
    private String senderAvatar;

    @Nullable
    private String svgaUrl;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<GroupGiftDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GroupGiftDetail createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GroupGiftDetail(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GroupGiftDetail[] newArray(int i10) {
            return new GroupGiftDetail[i10];
        }
    }

    public GroupGiftDetail() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GroupGiftDetail copy$default(GroupGiftDetail groupGiftDetail, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = groupGiftDetail.svgaUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = groupGiftDetail.iconUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = groupGiftDetail.senderAvatar;
        }
        if ((i10 & 8) != 0) {
            str4 = groupGiftDetail.receiverAvatar;
        }
        return groupGiftDetail.copy(str, str2, str3, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @NotNull
    public final GroupGiftDetail copy(@Nullable String svgaUrl, @Nullable String iconUrl, @Nullable String senderAvatar, @Nullable String receiverAvatar) {
        return new GroupGiftDetail(svgaUrl, iconUrl, senderAvatar, receiverAvatar);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupGiftDetail)) {
            return false;
        }
        GroupGiftDetail groupGiftDetail = (GroupGiftDetail) other;
        return Intrinsics.areEqual(this.svgaUrl, groupGiftDetail.svgaUrl) && Intrinsics.areEqual(this.iconUrl, groupGiftDetail.iconUrl) && Intrinsics.areEqual(this.senderAvatar, groupGiftDetail.senderAvatar) && Intrinsics.areEqual(this.receiverAvatar, groupGiftDetail.receiverAvatar);
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public int hashCode() {
        String str = this.svgaUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iconUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.senderAvatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.receiverAvatar;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setIconUrl(@Nullable String str) {
        this.iconUrl = str;
    }

    public final void setReceiverAvatar(@Nullable String str) {
        this.receiverAvatar = str;
    }

    public final void setSenderAvatar(@Nullable String str) {
        this.senderAvatar = str;
    }

    public final void setSvgaUrl(@Nullable String str) {
        this.svgaUrl = str;
    }

    @NotNull
    public String toString() {
        return "GroupGiftDetail(svgaUrl=" + this.svgaUrl + ", iconUrl=" + this.iconUrl + ", senderAvatar=" + this.senderAvatar + ", receiverAvatar=" + this.receiverAvatar + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.svgaUrl);
        dest.writeString(this.iconUrl);
        dest.writeString(this.senderAvatar);
        dest.writeString(this.receiverAvatar);
    }

    public GroupGiftDetail(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.svgaUrl = str;
        this.iconUrl = str2;
        this.senderAvatar = str3;
        this.receiverAvatar = str4;
    }

    public /* synthetic */ GroupGiftDetail(String str, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}
