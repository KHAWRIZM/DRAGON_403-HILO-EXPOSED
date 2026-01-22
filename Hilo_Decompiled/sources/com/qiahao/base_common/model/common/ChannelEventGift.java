package com.qiahao.base_common.model.common;

import androidx.collection.c;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\u008b\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\rHÆ\u0001J\u0013\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\rHÖ\u0001J\t\u00108\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/qiahao/base_common/model/common/ChannelEventGift;", "", "addTime", "", "giftID", "channelID", "", "isSender", "", HeaderInterceptor.TOKEN, "remainingDurationInSecs", "endTimestampInSecs", "number", "", "iconUrl", "svgaUrl", "senderAvatar", "receiverAvatar", "nobleLevel", "<init>", "(JJLjava/lang/String;ZLjava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAddTime", "()J", "getGiftID", "getChannelID", "()Ljava/lang/String;", "()Z", "getToken", "getRemainingDurationInSecs", "getEndTimestampInSecs", "getNumber", "()I", "getIconUrl", "getSvgaUrl", "getSenderAvatar", "getReceiverAvatar", "getNobleLevel", "setNobleLevel", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ChannelEventGift {
    private final long addTime;

    @NotNull
    private final String channelID;
    private final long endTimestampInSecs;
    private final long giftID;

    @NotNull
    private final String iconUrl;
    private final boolean isSender;
    private int nobleLevel;
    private final int number;

    @NotNull
    private final String receiverAvatar;
    private final long remainingDurationInSecs;

    @NotNull
    private final String senderAvatar;

    @NotNull
    private final String svgaUrl;

    @NotNull
    private final String token;

    public ChannelEventGift(long j10, long j11, @NotNull String channelID, boolean z10, @NotNull String token, long j12, long j13, int i10, @NotNull String iconUrl, @NotNull String svgaUrl, @NotNull String senderAvatar, @NotNull String receiverAvatar, int i11) {
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(receiverAvatar, "receiverAvatar");
        this.addTime = j10;
        this.giftID = j11;
        this.channelID = channelID;
        this.isSender = z10;
        this.token = token;
        this.remainingDurationInSecs = j12;
        this.endTimestampInSecs = j13;
        this.number = i10;
        this.iconUrl = iconUrl;
        this.svgaUrl = svgaUrl;
        this.senderAvatar = senderAvatar;
        this.receiverAvatar = receiverAvatar;
        this.nobleLevel = i11;
    }

    /* renamed from: component1, reason: from getter */
    public final long getAddTime() {
        return this.addTime;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    /* renamed from: component13, reason: from getter */
    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    /* renamed from: component2, reason: from getter */
    public final long getGiftID() {
        return this.giftID;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getChannelID() {
        return this.channelID;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsSender() {
        return this.isSender;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component6, reason: from getter */
    public final long getRemainingDurationInSecs() {
        return this.remainingDurationInSecs;
    }

    /* renamed from: component7, reason: from getter */
    public final long getEndTimestampInSecs() {
        return this.endTimestampInSecs;
    }

    /* renamed from: component8, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final ChannelEventGift copy(long addTime, long giftID, @NotNull String channelID, boolean isSender, @NotNull String token, long remainingDurationInSecs, long endTimestampInSecs, int number, @NotNull String iconUrl, @NotNull String svgaUrl, @NotNull String senderAvatar, @NotNull String receiverAvatar, int nobleLevel) {
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(receiverAvatar, "receiverAvatar");
        return new ChannelEventGift(addTime, giftID, channelID, isSender, token, remainingDurationInSecs, endTimestampInSecs, number, iconUrl, svgaUrl, senderAvatar, receiverAvatar, nobleLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelEventGift)) {
            return false;
        }
        ChannelEventGift channelEventGift = (ChannelEventGift) other;
        return this.addTime == channelEventGift.addTime && this.giftID == channelEventGift.giftID && Intrinsics.areEqual(this.channelID, channelEventGift.channelID) && this.isSender == channelEventGift.isSender && Intrinsics.areEqual(this.token, channelEventGift.token) && this.remainingDurationInSecs == channelEventGift.remainingDurationInSecs && this.endTimestampInSecs == channelEventGift.endTimestampInSecs && this.number == channelEventGift.number && Intrinsics.areEqual(this.iconUrl, channelEventGift.iconUrl) && Intrinsics.areEqual(this.svgaUrl, channelEventGift.svgaUrl) && Intrinsics.areEqual(this.senderAvatar, channelEventGift.senderAvatar) && Intrinsics.areEqual(this.receiverAvatar, channelEventGift.receiverAvatar) && this.nobleLevel == channelEventGift.nobleLevel;
    }

    public final long getAddTime() {
        return this.addTime;
    }

    @NotNull
    public final String getChannelID() {
        return this.channelID;
    }

    public final long getEndTimestampInSecs() {
        return this.endTimestampInSecs;
    }

    public final long getGiftID() {
        return this.giftID;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    public final int getNumber() {
        return this.number;
    }

    @NotNull
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    public final long getRemainingDurationInSecs() {
        return this.remainingDurationInSecs;
    }

    @NotNull
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((((((((((((((((((((((c.a(this.addTime) * 31) + c.a(this.giftID)) * 31) + this.channelID.hashCode()) * 31) + a.a(this.isSender)) * 31) + this.token.hashCode()) * 31) + c.a(this.remainingDurationInSecs)) * 31) + c.a(this.endTimestampInSecs)) * 31) + this.number) * 31) + this.iconUrl.hashCode()) * 31) + this.svgaUrl.hashCode()) * 31) + this.senderAvatar.hashCode()) * 31) + this.receiverAvatar.hashCode()) * 31) + this.nobleLevel;
    }

    public final boolean isSender() {
        return this.isSender;
    }

    public final void setNobleLevel(int i10) {
        this.nobleLevel = i10;
    }

    @NotNull
    public String toString() {
        return "ChannelEventGift(addTime=" + this.addTime + ", giftID=" + this.giftID + ", channelID=" + this.channelID + ", isSender=" + this.isSender + ", token=" + this.token + ", remainingDurationInSecs=" + this.remainingDurationInSecs + ", endTimestampInSecs=" + this.endTimestampInSecs + ", number=" + this.number + ", iconUrl=" + this.iconUrl + ", svgaUrl=" + this.svgaUrl + ", senderAvatar=" + this.senderAvatar + ", receiverAvatar=" + this.receiverAvatar + ", nobleLevel=" + this.nobleLevel + ")";
    }

    public /* synthetic */ ChannelEventGift(long j10, long j11, String str, boolean z10, String str2, long j12, long j13, int i10, String str3, String str4, String str5, String str6, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, j11, str, z10, str2, j12, j13, i10, str3, str4, str5, str6, (i12 & 4096) != 0 ? 0 : i11);
    }
}
