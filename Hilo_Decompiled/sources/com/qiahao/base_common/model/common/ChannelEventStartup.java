package com.qiahao.base_common.model.common;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J_\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c¨\u0006."}, d2 = {"Lcom/qiahao/base_common/model/common/ChannelEventStartup;", "", "channelId", "", "callDuration", "", "endTimestamp", "startupVideoChatTimestamp", "diffTimeInSecs", "agoraToken", "videoSetting", "Lcom/qiahao/base_common/model/common/VideoSetting;", "otherVideoSetting", "<init>", "(Ljava/lang/String;JJJJLjava/lang/String;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getChannelId", "()Ljava/lang/String;", "getCallDuration", "()J", "getEndTimestamp", "getStartupVideoChatTimestamp", "getDiffTimeInSecs", "getAgoraToken", "setAgoraToken", "(Ljava/lang/String;)V", "getVideoSetting", "()Lcom/qiahao/base_common/model/common/VideoSetting;", "setVideoSetting", "(Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getOtherVideoSetting", "setOtherVideoSetting", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ChannelEventStartup {

    @Nullable
    private String agoraToken;
    private final long callDuration;

    @NotNull
    private final String channelId;
    private final long diffTimeInSecs;
    private final long endTimestamp;

    @Nullable
    private VideoSetting otherVideoSetting;
    private final long startupVideoChatTimestamp;

    @Nullable
    private VideoSetting videoSetting;

    public ChannelEventStartup(@NotNull String channelId, long j10, long j11, long j12, long j13, @Nullable String str, @Nullable VideoSetting videoSetting, @Nullable VideoSetting videoSetting2) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.channelId = channelId;
        this.callDuration = j10;
        this.endTimestamp = j11;
        this.startupVideoChatTimestamp = j12;
        this.diffTimeInSecs = j13;
        this.agoraToken = str;
        this.videoSetting = videoSetting;
        this.otherVideoSetting = videoSetting2;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCallDuration() {
        return this.callDuration;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final long getStartupVideoChatTimestamp() {
        return this.startupVideoChatTimestamp;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDiffTimeInSecs() {
        return this.diffTimeInSecs;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getAgoraToken() {
        return this.agoraToken;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    @NotNull
    public final ChannelEventStartup copy(@NotNull String channelId, long callDuration, long endTimestamp, long startupVideoChatTimestamp, long diffTimeInSecs, @Nullable String agoraToken, @Nullable VideoSetting videoSetting, @Nullable VideoSetting otherVideoSetting) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return new ChannelEventStartup(channelId, callDuration, endTimestamp, startupVideoChatTimestamp, diffTimeInSecs, agoraToken, videoSetting, otherVideoSetting);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelEventStartup)) {
            return false;
        }
        ChannelEventStartup channelEventStartup = (ChannelEventStartup) other;
        return Intrinsics.areEqual(this.channelId, channelEventStartup.channelId) && this.callDuration == channelEventStartup.callDuration && this.endTimestamp == channelEventStartup.endTimestamp && this.startupVideoChatTimestamp == channelEventStartup.startupVideoChatTimestamp && this.diffTimeInSecs == channelEventStartup.diffTimeInSecs && Intrinsics.areEqual(this.agoraToken, channelEventStartup.agoraToken) && Intrinsics.areEqual(this.videoSetting, channelEventStartup.videoSetting) && Intrinsics.areEqual(this.otherVideoSetting, channelEventStartup.otherVideoSetting);
    }

    @Nullable
    public final String getAgoraToken() {
        return this.agoraToken;
    }

    public final long getCallDuration() {
        return this.callDuration;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    public final long getDiffTimeInSecs() {
        return this.diffTimeInSecs;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    @Nullable
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    public final long getStartupVideoChatTimestamp() {
        return this.startupVideoChatTimestamp;
    }

    @Nullable
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    public int hashCode() {
        int hashCode = ((((((((this.channelId.hashCode() * 31) + c.a(this.callDuration)) * 31) + c.a(this.endTimestamp)) * 31) + c.a(this.startupVideoChatTimestamp)) * 31) + c.a(this.diffTimeInSecs)) * 31;
        String str = this.agoraToken;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        VideoSetting videoSetting = this.videoSetting;
        int hashCode3 = (hashCode2 + (videoSetting == null ? 0 : videoSetting.hashCode())) * 31;
        VideoSetting videoSetting2 = this.otherVideoSetting;
        return hashCode3 + (videoSetting2 != null ? videoSetting2.hashCode() : 0);
    }

    public final void setAgoraToken(@Nullable String str) {
        this.agoraToken = str;
    }

    public final void setOtherVideoSetting(@Nullable VideoSetting videoSetting) {
        this.otherVideoSetting = videoSetting;
    }

    public final void setVideoSetting(@Nullable VideoSetting videoSetting) {
        this.videoSetting = videoSetting;
    }

    @NotNull
    public String toString() {
        return "ChannelEventStartup(channelId=" + this.channelId + ", callDuration=" + this.callDuration + ", endTimestamp=" + this.endTimestamp + ", startupVideoChatTimestamp=" + this.startupVideoChatTimestamp + ", diffTimeInSecs=" + this.diffTimeInSecs + ", agoraToken=" + this.agoraToken + ", videoSetting=" + this.videoSetting + ", otherVideoSetting=" + this.otherVideoSetting + ")";
    }

    public /* synthetic */ ChannelEventStartup(String str, long j10, long j11, long j12, long j13, String str2, VideoSetting videoSetting, VideoSetting videoSetting2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j10, j11, j12, j13, (i10 & 32) != 0 ? null : str2, (i10 & 64) != 0 ? null : videoSetting, (i10 & 128) != 0 ? null : videoSetting2);
    }
}
