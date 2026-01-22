package com.qiahao.base_common.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.cp.TextStyles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002By\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0081\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0001J\u0006\u0010;\u001a\u00020\u0004J\u0013\u0010<\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0004HÖ\u0001J\t\u0010@\u001a\u00020\u0006HÖ\u0001J\u0016\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006F"}, d2 = {"Lcom/qiahao/base_common/model/common/RideBean;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "id", "", "picUrl", "", "effectUrl", "using", "", "timeLeft", "senderAvatar", "receiverAvatar", "senderNick", "receiverNick", "textStyleList", "", "Lcom/qiahao/base_common/model/cp/TextStyles;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()I", "setId", "(I)V", "getPicUrl", "()Ljava/lang/String;", "setPicUrl", "(Ljava/lang/String;)V", "getEffectUrl", "setEffectUrl", "getUsing", "()Z", "setUsing", "(Z)V", "getTimeLeft", "setTimeLeft", "getSenderAvatar", "setSenderAvatar", "getReceiverAvatar", "setReceiverAvatar", "getSenderNick", "setSenderNick", "getReceiverNick", "setReceiverNick", "getTextStyleList", "()Ljava/util/List;", "setTextStyleList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class RideBean implements Parcelable, Serializable {

    @NotNull
    public static final Parcelable.Creator<RideBean> CREATOR = new Creator();

    @Nullable
    private String effectUrl;
    private int id;

    @Nullable
    private String picUrl;

    @Nullable
    private String receiverAvatar;

    @Nullable
    private String receiverNick;

    @Nullable
    private String senderAvatar;

    @Nullable
    private String senderNick;

    @Nullable
    private List<TextStyles> textStyleList;
    private int timeLeft;
    private boolean using;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Creator implements Parcelable.Creator<RideBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RideBean createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z10 = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList = new ArrayList(readInt3);
                for (int i10 = 0; i10 != readInt3; i10++) {
                    arrayList.add(TextStyles.CREATOR.createFromParcel(parcel));
                }
            }
            return new RideBean(readInt, readString, readString2, z10, readInt2, readString3, readString4, readString5, readString6, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RideBean[] newArray(int i10) {
            return new RideBean[i10];
        }
    }

    public RideBean(int i10, @Nullable String str, @Nullable String str2, boolean z10, int i11, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<TextStyles> list) {
        this.id = i10;
        this.picUrl = str;
        this.effectUrl = str2;
        this.using = z10;
        this.timeLeft = i11;
        this.senderAvatar = str3;
        this.receiverAvatar = str4;
        this.senderNick = str5;
        this.receiverNick = str6;
        this.textStyleList = list;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    public final List<TextStyles> component10() {
        return this.textStyleList;
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

    /* renamed from: component4, reason: from getter */
    public final boolean getUsing() {
        return this.using;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTimeLeft() {
        return this.timeLeft;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getSenderNick() {
        return this.senderNick;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getReceiverNick() {
        return this.receiverNick;
    }

    @NotNull
    public final RideBean copy(int id, @Nullable String picUrl, @Nullable String effectUrl, boolean using, int timeLeft, @Nullable String senderAvatar, @Nullable String receiverAvatar, @Nullable String senderNick, @Nullable String receiverNick, @Nullable List<TextStyles> textStyleList) {
        return new RideBean(id, picUrl, effectUrl, using, timeLeft, senderAvatar, receiverAvatar, senderNick, receiverNick, textStyleList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RideBean)) {
            return false;
        }
        RideBean rideBean = (RideBean) other;
        return this.id == rideBean.id && Intrinsics.areEqual(this.picUrl, rideBean.picUrl) && Intrinsics.areEqual(this.effectUrl, rideBean.effectUrl) && this.using == rideBean.using && this.timeLeft == rideBean.timeLeft && Intrinsics.areEqual(this.senderAvatar, rideBean.senderAvatar) && Intrinsics.areEqual(this.receiverAvatar, rideBean.receiverAvatar) && Intrinsics.areEqual(this.senderNick, rideBean.senderNick) && Intrinsics.areEqual(this.receiverNick, rideBean.receiverNick) && Intrinsics.areEqual(this.textStyleList, rideBean.textStyleList);
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
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    public final String getReceiverNick() {
        return this.receiverNick;
    }

    @Nullable
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @Nullable
    public final String getSenderNick() {
        return this.senderNick;
    }

    @Nullable
    public final List<TextStyles> getTextStyleList() {
        return this.textStyleList;
    }

    public final int getTimeLeft() {
        return this.timeLeft;
    }

    public final boolean getUsing() {
        return this.using;
    }

    public int hashCode() {
        int i10 = this.id * 31;
        String str = this.picUrl;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.effectUrl;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + a.a(this.using)) * 31) + this.timeLeft) * 31;
        String str3 = this.senderAvatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.receiverAvatar;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.senderNick;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.receiverNick;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<TextStyles> list = this.textStyleList;
        return hashCode6 + (list != null ? list.hashCode() : 0);
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

    public final void setReceiverAvatar(@Nullable String str) {
        this.receiverAvatar = str;
    }

    public final void setReceiverNick(@Nullable String str) {
        this.receiverNick = str;
    }

    public final void setSenderAvatar(@Nullable String str) {
        this.senderAvatar = str;
    }

    public final void setSenderNick(@Nullable String str) {
        this.senderNick = str;
    }

    public final void setTextStyleList(@Nullable List<TextStyles> list) {
        this.textStyleList = list;
    }

    public final void setTimeLeft(int i10) {
        this.timeLeft = i10;
    }

    public final void setUsing(boolean z10) {
        this.using = z10;
    }

    @NotNull
    public String toString() {
        return "RideBean(id=" + this.id + ", picUrl=" + this.picUrl + ", effectUrl=" + this.effectUrl + ", using=" + this.using + ", timeLeft=" + this.timeLeft + ", senderAvatar=" + this.senderAvatar + ", receiverAvatar=" + this.receiverAvatar + ", senderNick=" + this.senderNick + ", receiverNick=" + this.receiverNick + ", textStyleList=" + this.textStyleList + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.picUrl);
        dest.writeString(this.effectUrl);
        dest.writeInt(this.using ? 1 : 0);
        dest.writeInt(this.timeLeft);
        dest.writeString(this.senderAvatar);
        dest.writeString(this.receiverAvatar);
        dest.writeString(this.senderNick);
        dest.writeString(this.receiverNick);
        List<TextStyles> list = this.textStyleList;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(list.size());
        Iterator<TextStyles> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    public /* synthetic */ RideBean(int i10, String str, String str2, boolean z10, int i11, String str3, String str4, String str5, String str6, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, str2, (i12 & 8) != 0 ? false : z10, (i12 & 16) != 0 ? 0 : i11, (i12 & 32) != 0 ? "" : str3, (i12 & 64) != 0 ? "" : str4, (i12 & 128) != 0 ? "" : str5, (i12 & 256) != 0 ? "" : str6, (i12 & 512) != 0 ? null : list);
    }
}
