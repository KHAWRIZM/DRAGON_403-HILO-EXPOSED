package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.nextvideo.ui.transfer.TransferCenterFragment;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q2.a;

@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\t\u00109\u001a\u00020\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0010HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0006\u0010>\u001a\u00020\fJ\u0013\u0010?\u001a\u00020\u00102\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\fHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001e\u0010\u000e\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010 \"\u0004\b#\u0010$R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010-R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010-¨\u0006I"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GiftItem;", "Landroid/os/Parcelable;", "specialEffects", "", TransferCenterFragment.TYPE_DIAMONDS, "", "name", TUIConstants.TUIChat.INPUT_MORE_ICON, AgooConstants.MESSAGE_ID, "", "duration", "hasMusic", "", "musicUrl", "num", "cp", "", "together", "senderAvatar", "receiverAvatar", "<init>", "(Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;JJILjava/lang/String;IZZLjava/lang/String;Ljava/lang/String;)V", "getSpecialEffects", "()Ljava/lang/String;", "getDiamonds", "()F", "getName", "getIcon", "getId", "()J", "getDuration", "getHasMusic", "()I", "getMusicUrl", "getNum", "setNum", "(I)V", "getCp", "()Z", "setCp", "(Z)V", "getTogether", "setTogether", "getSenderAvatar", "setSenderAvatar", "(Ljava/lang/String;)V", "getReceiverAvatar", "setReceiverAvatar", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GiftItem implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GiftItem> CREATOR = new Creator();
    private boolean cp;

    @c("diamondNum")
    private final float diamonds;

    @c("second")
    private final long duration;

    @c("has_music")
    private final int hasMusic;

    @NotNull
    @c("iconUrl")
    private final String icon;

    @c("giftId")
    private final long id;

    @NotNull
    @c("musicUrl")
    private final String musicUrl;

    @NotNull
    @c("name")
    private final String name;

    @c("num")
    private int num;

    @NotNull
    private String receiverAvatar;

    @NotNull
    private String senderAvatar;

    @NotNull
    @c("svagUrl")
    private final String specialEffects;
    private boolean together;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<GiftItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GiftItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GiftItem(parcel.readString(), parcel.readFloat(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GiftItem[] newArray(int i) {
            return new GiftItem[i];
        }
    }

    public GiftItem(@NotNull String str, float f, @NotNull String str2, @NotNull String str3, long j, long j2, int i, @NotNull String str4, int i2, boolean z, boolean z2, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "specialEffects");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, TUIConstants.TUIChat.INPUT_MORE_ICON);
        Intrinsics.checkNotNullParameter(str4, "musicUrl");
        Intrinsics.checkNotNullParameter(str5, "senderAvatar");
        Intrinsics.checkNotNullParameter(str6, "receiverAvatar");
        this.specialEffects = str;
        this.diamonds = f;
        this.name = str2;
        this.icon = str3;
        this.id = j;
        this.duration = j2;
        this.hasMusic = i;
        this.musicUrl = str4;
        this.num = i2;
        this.cp = z;
        this.together = z2;
        this.senderAvatar = str5;
        this.receiverAvatar = str6;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSpecialEffects() {
        return this.specialEffects;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getCp() {
        return this.cp;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getTogether() {
        return this.together;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    /* renamed from: component2, reason: from getter */
    public final float getDiamonds() {
        return this.diamonds;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component5, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component6, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component7, reason: from getter */
    public final int getHasMusic() {
        return this.hasMusic;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getMusicUrl() {
        return this.musicUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final int getNum() {
        return this.num;
    }

    @NotNull
    public final GiftItem copy(@NotNull String specialEffects, float diamonds, @NotNull String name, @NotNull String icon, long id2, long duration, int hasMusic, @NotNull String musicUrl, int num, boolean cp, boolean together, @NotNull String senderAvatar, @NotNull String receiverAvatar) {
        Intrinsics.checkNotNullParameter(specialEffects, "specialEffects");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, TUIConstants.TUIChat.INPUT_MORE_ICON);
        Intrinsics.checkNotNullParameter(musicUrl, "musicUrl");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(receiverAvatar, "receiverAvatar");
        return new GiftItem(specialEffects, diamonds, name, icon, id2, duration, hasMusic, musicUrl, num, cp, together, senderAvatar, receiverAvatar);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftItem)) {
            return false;
        }
        GiftItem giftItem = (GiftItem) other;
        return Intrinsics.areEqual(this.specialEffects, giftItem.specialEffects) && Float.compare(this.diamonds, giftItem.diamonds) == 0 && Intrinsics.areEqual(this.name, giftItem.name) && Intrinsics.areEqual(this.icon, giftItem.icon) && this.id == giftItem.id && this.duration == giftItem.duration && this.hasMusic == giftItem.hasMusic && Intrinsics.areEqual(this.musicUrl, giftItem.musicUrl) && this.num == giftItem.num && this.cp == giftItem.cp && this.together == giftItem.together && Intrinsics.areEqual(this.senderAvatar, giftItem.senderAvatar) && Intrinsics.areEqual(this.receiverAvatar, giftItem.receiverAvatar);
    }

    public final boolean getCp() {
        return this.cp;
    }

    public final float getDiamonds() {
        return this.diamonds;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getHasMusic() {
        return this.hasMusic;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getMusicUrl() {
        return this.musicUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getNum() {
        return this.num;
    }

    @NotNull
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @NotNull
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    public final String getSpecialEffects() {
        return this.specialEffects;
    }

    public final boolean getTogether() {
        return this.together;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.specialEffects.hashCode() * 31) + Float.floatToIntBits(this.diamonds)) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + androidx.collection.c.a(this.id)) * 31) + androidx.collection.c.a(this.duration)) * 31) + this.hasMusic) * 31) + this.musicUrl.hashCode()) * 31) + this.num) * 31) + a.a(this.cp)) * 31) + a.a(this.together)) * 31) + this.senderAvatar.hashCode()) * 31) + this.receiverAvatar.hashCode();
    }

    public final void setCp(boolean z) {
        this.cp = z;
    }

    public final void setNum(int i) {
        this.num = i;
    }

    public final void setReceiverAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.receiverAvatar = str;
    }

    public final void setSenderAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senderAvatar = str;
    }

    public final void setTogether(boolean z) {
        this.together = z;
    }

    @NotNull
    public String toString() {
        return "GiftItem(specialEffects=" + this.specialEffects + ", diamonds=" + this.diamonds + ", name=" + this.name + ", icon=" + this.icon + ", id=" + this.id + ", duration=" + this.duration + ", hasMusic=" + this.hasMusic + ", musicUrl=" + this.musicUrl + ", num=" + this.num + ", cp=" + this.cp + ", together=" + this.together + ", senderAvatar=" + this.senderAvatar + ", receiverAvatar=" + this.receiverAvatar + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.specialEffects);
        dest.writeFloat(this.diamonds);
        dest.writeString(this.name);
        dest.writeString(this.icon);
        dest.writeLong(this.id);
        dest.writeLong(this.duration);
        dest.writeInt(this.hasMusic);
        dest.writeString(this.musicUrl);
        dest.writeInt(this.num);
        dest.writeInt(this.cp ? 1 : 0);
        dest.writeInt(this.together ? 1 : 0);
        dest.writeString(this.senderAvatar);
        dest.writeString(this.receiverAvatar);
    }

    public /* synthetic */ GiftItem(String str, float f, String str2, String str3, long j, long j2, int i, String str4, int i2, boolean z, boolean z2, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, (i3 & 4) != 0 ? "N/A" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? 0L : j, j2, i, (i3 & 128) != 0 ? "" : str4, i2, (i3 & 512) != 0 ? false : z, (i3 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? false : z2, (i3 & 2048) != 0 ? "" : str5, (i3 & 4096) != 0 ? "" : str6);
    }
}
