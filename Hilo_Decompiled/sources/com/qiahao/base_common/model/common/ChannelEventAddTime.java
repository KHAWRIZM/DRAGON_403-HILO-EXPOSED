package com.qiahao.base_common.model.common;

import androidx.collection.c;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006\""}, d2 = {"Lcom/qiahao/base_common/model/common/ChannelEventAddTime;", "", "addTime", "", "senderAgoraID", "", "remainingDurationInSecs", "isBroadcastSuccess", "", HeaderInterceptor.TOKEN, "", "endTimestampInSecs", "<init>", "(JIJZLjava/lang/String;J)V", "getAddTime", "()J", "getSenderAgoraID", "()I", "getRemainingDurationInSecs", "()Z", "getToken", "()Ljava/lang/String;", "getEndTimestampInSecs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ChannelEventAddTime {
    private final long addTime;
    private final long endTimestampInSecs;
    private final boolean isBroadcastSuccess;
    private final long remainingDurationInSecs;
    private final int senderAgoraID;

    @NotNull
    private final String token;

    public ChannelEventAddTime(long j10, int i10, long j11, boolean z10, @NotNull String token, long j12) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.addTime = j10;
        this.senderAgoraID = i10;
        this.remainingDurationInSecs = j11;
        this.isBroadcastSuccess = z10;
        this.token = token;
        this.endTimestampInSecs = j12;
    }

    /* renamed from: component1, reason: from getter */
    public final long getAddTime() {
        return this.addTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSenderAgoraID() {
        return this.senderAgoraID;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRemainingDurationInSecs() {
        return this.remainingDurationInSecs;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsBroadcastSuccess() {
        return this.isBroadcastSuccess;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component6, reason: from getter */
    public final long getEndTimestampInSecs() {
        return this.endTimestampInSecs;
    }

    @NotNull
    public final ChannelEventAddTime copy(long addTime, int senderAgoraID, long remainingDurationInSecs, boolean isBroadcastSuccess, @NotNull String token, long endTimestampInSecs) {
        Intrinsics.checkNotNullParameter(token, "token");
        return new ChannelEventAddTime(addTime, senderAgoraID, remainingDurationInSecs, isBroadcastSuccess, token, endTimestampInSecs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelEventAddTime)) {
            return false;
        }
        ChannelEventAddTime channelEventAddTime = (ChannelEventAddTime) other;
        return this.addTime == channelEventAddTime.addTime && this.senderAgoraID == channelEventAddTime.senderAgoraID && this.remainingDurationInSecs == channelEventAddTime.remainingDurationInSecs && this.isBroadcastSuccess == channelEventAddTime.isBroadcastSuccess && Intrinsics.areEqual(this.token, channelEventAddTime.token) && this.endTimestampInSecs == channelEventAddTime.endTimestampInSecs;
    }

    public final long getAddTime() {
        return this.addTime;
    }

    public final long getEndTimestampInSecs() {
        return this.endTimestampInSecs;
    }

    public final long getRemainingDurationInSecs() {
        return this.remainingDurationInSecs;
    }

    public final int getSenderAgoraID() {
        return this.senderAgoraID;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (((((((((c.a(this.addTime) * 31) + this.senderAgoraID) * 31) + c.a(this.remainingDurationInSecs)) * 31) + a.a(this.isBroadcastSuccess)) * 31) + this.token.hashCode()) * 31) + c.a(this.endTimestampInSecs);
    }

    public final boolean isBroadcastSuccess() {
        return this.isBroadcastSuccess;
    }

    @NotNull
    public String toString() {
        return "ChannelEventAddTime(addTime=" + this.addTime + ", senderAgoraID=" + this.senderAgoraID + ", remainingDurationInSecs=" + this.remainingDurationInSecs + ", isBroadcastSuccess=" + this.isBroadcastSuccess + ", token=" + this.token + ", endTimestampInSecs=" + this.endTimestampInSecs + ")";
    }

    public /* synthetic */ ChannelEventAddTime(long j10, int i10, long j11, boolean z10, String str, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, i10, j11, (i11 & 8) != 0 ? false : z10, str, j12);
    }
}
