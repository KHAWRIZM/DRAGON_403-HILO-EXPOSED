package com.qiahao.base_common.model.common;

import androidx.collection.c;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006("}, d2 = {"Lcom/qiahao/base_common/model/common/ChannelEvent1v1AddTime;", "", HeaderInterceptor.TOKEN, "", "duration", "", "endTimestamp", "", "channelID", "senderAgoraId", "videoUniqueId", "isSend", "", "remainingDurationInSecs", "<init>", "(Ljava/lang/String;IJLjava/lang/String;ILjava/lang/String;ZJ)V", "getToken", "()Ljava/lang/String;", "getDuration", "()I", "getEndTimestamp", "()J", "getChannelID", "getSenderAgoraId", "getVideoUniqueId", "()Z", "getRemainingDurationInSecs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ChannelEvent1v1AddTime {

    @NotNull
    private final String channelID;
    private final int duration;
    private final long endTimestamp;
    private final boolean isSend;
    private final long remainingDurationInSecs;
    private final int senderAgoraId;

    @NotNull
    private final String token;

    @NotNull
    private final String videoUniqueId;

    public ChannelEvent1v1AddTime(@NotNull String token, int i10, long j10, @NotNull String channelID, int i11, @NotNull String videoUniqueId, boolean z10, long j11) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(videoUniqueId, "videoUniqueId");
        this.token = token;
        this.duration = i10;
        this.endTimestamp = j10;
        this.channelID = channelID;
        this.senderAgoraId = i11;
        this.videoUniqueId = videoUniqueId;
        this.isSend = z10;
        this.remainingDurationInSecs = j11;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getChannelID() {
        return this.channelID;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSenderAgoraId() {
        return this.senderAgoraId;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getVideoUniqueId() {
        return this.videoUniqueId;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsSend() {
        return this.isSend;
    }

    /* renamed from: component8, reason: from getter */
    public final long getRemainingDurationInSecs() {
        return this.remainingDurationInSecs;
    }

    @NotNull
    public final ChannelEvent1v1AddTime copy(@NotNull String token, int duration, long endTimestamp, @NotNull String channelID, int senderAgoraId, @NotNull String videoUniqueId, boolean isSend, long remainingDurationInSecs) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(videoUniqueId, "videoUniqueId");
        return new ChannelEvent1v1AddTime(token, duration, endTimestamp, channelID, senderAgoraId, videoUniqueId, isSend, remainingDurationInSecs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelEvent1v1AddTime)) {
            return false;
        }
        ChannelEvent1v1AddTime channelEvent1v1AddTime = (ChannelEvent1v1AddTime) other;
        return Intrinsics.areEqual(this.token, channelEvent1v1AddTime.token) && this.duration == channelEvent1v1AddTime.duration && this.endTimestamp == channelEvent1v1AddTime.endTimestamp && Intrinsics.areEqual(this.channelID, channelEvent1v1AddTime.channelID) && this.senderAgoraId == channelEvent1v1AddTime.senderAgoraId && Intrinsics.areEqual(this.videoUniqueId, channelEvent1v1AddTime.videoUniqueId) && this.isSend == channelEvent1v1AddTime.isSend && this.remainingDurationInSecs == channelEvent1v1AddTime.remainingDurationInSecs;
    }

    @NotNull
    public final String getChannelID() {
        return this.channelID;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final long getRemainingDurationInSecs() {
        return this.remainingDurationInSecs;
    }

    public final int getSenderAgoraId() {
        return this.senderAgoraId;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getVideoUniqueId() {
        return this.videoUniqueId;
    }

    public int hashCode() {
        return (((((((((((((this.token.hashCode() * 31) + this.duration) * 31) + c.a(this.endTimestamp)) * 31) + this.channelID.hashCode()) * 31) + this.senderAgoraId) * 31) + this.videoUniqueId.hashCode()) * 31) + a.a(this.isSend)) * 31) + c.a(this.remainingDurationInSecs);
    }

    public final boolean isSend() {
        return this.isSend;
    }

    @NotNull
    public String toString() {
        return "ChannelEvent1v1AddTime(token=" + this.token + ", duration=" + this.duration + ", endTimestamp=" + this.endTimestamp + ", channelID=" + this.channelID + ", senderAgoraId=" + this.senderAgoraId + ", videoUniqueId=" + this.videoUniqueId + ", isSend=" + this.isSend + ", remainingDurationInSecs=" + this.remainingDurationInSecs + ")";
    }
}
