package com.qiahao.base_common.network.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J[\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/qiahao/base_common/network/model/DebugAgoraVideoCallConfig;", "", "agoraChannelName", "", "rongRoomName", "fromUserID", "fromToken", "toToken", "toUID", "userDiamonds", "", "duration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FJ)V", "getAgoraChannelName", "()Ljava/lang/String;", "setAgoraChannelName", "(Ljava/lang/String;)V", "getRongRoomName", "setRongRoomName", "getFromUserID", "setFromUserID", "getFromToken", "setFromToken", "getToToken", "setToToken", "getToUID", "setToUID", "getUserDiamonds", "()F", "setUserDiamonds", "(F)V", "getDuration", "()J", "setDuration", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class DebugAgoraVideoCallConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    @c("channel_name")
    private String agoraChannelName;

    @c("duration")
    private long duration;

    @NotNull
    @c("from_token")
    private String fromToken;

    @NotNull
    @c("from_user_id")
    private String fromUserID;

    @Nullable
    @c("rong_room_name")
    private String rongRoomName;

    @NotNull
    @c("to_token")
    private String toToken;

    @NotNull
    @c("to_user_id")
    private String toUID;

    @c("user_diamonds")
    private float userDiamonds;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/base_common/network/model/DebugAgoraVideoCallConfig$Companion;", "", "<init>", "()V", "fake", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void fake() {
        }

        private Companion() {
        }
    }

    public DebugAgoraVideoCallConfig(@NotNull String agoraChannelName, @Nullable String str, @NotNull String fromUserID, @NotNull String fromToken, @NotNull String toToken, @NotNull String toUID, float f10, long j10) {
        Intrinsics.checkNotNullParameter(agoraChannelName, "agoraChannelName");
        Intrinsics.checkNotNullParameter(fromUserID, "fromUserID");
        Intrinsics.checkNotNullParameter(fromToken, "fromToken");
        Intrinsics.checkNotNullParameter(toToken, "toToken");
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        this.agoraChannelName = agoraChannelName;
        this.rongRoomName = str;
        this.fromUserID = fromUserID;
        this.fromToken = fromToken;
        this.toToken = toToken;
        this.toUID = toUID;
        this.userDiamonds = f10;
        this.duration = j10;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAgoraChannelName() {
        return this.agoraChannelName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getRongRoomName() {
        return this.rongRoomName;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getFromUserID() {
        return this.fromUserID;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getFromToken() {
        return this.fromToken;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getToToken() {
        return this.toToken;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getToUID() {
        return this.toUID;
    }

    /* renamed from: component7, reason: from getter */
    public final float getUserDiamonds() {
        return this.userDiamonds;
    }

    /* renamed from: component8, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final DebugAgoraVideoCallConfig copy(@NotNull String agoraChannelName, @Nullable String rongRoomName, @NotNull String fromUserID, @NotNull String fromToken, @NotNull String toToken, @NotNull String toUID, float userDiamonds, long duration) {
        Intrinsics.checkNotNullParameter(agoraChannelName, "agoraChannelName");
        Intrinsics.checkNotNullParameter(fromUserID, "fromUserID");
        Intrinsics.checkNotNullParameter(fromToken, "fromToken");
        Intrinsics.checkNotNullParameter(toToken, "toToken");
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        return new DebugAgoraVideoCallConfig(agoraChannelName, rongRoomName, fromUserID, fromToken, toToken, toUID, userDiamonds, duration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebugAgoraVideoCallConfig)) {
            return false;
        }
        DebugAgoraVideoCallConfig debugAgoraVideoCallConfig = (DebugAgoraVideoCallConfig) other;
        return Intrinsics.areEqual(this.agoraChannelName, debugAgoraVideoCallConfig.agoraChannelName) && Intrinsics.areEqual(this.rongRoomName, debugAgoraVideoCallConfig.rongRoomName) && Intrinsics.areEqual(this.fromUserID, debugAgoraVideoCallConfig.fromUserID) && Intrinsics.areEqual(this.fromToken, debugAgoraVideoCallConfig.fromToken) && Intrinsics.areEqual(this.toToken, debugAgoraVideoCallConfig.toToken) && Intrinsics.areEqual(this.toUID, debugAgoraVideoCallConfig.toUID) && Float.compare(this.userDiamonds, debugAgoraVideoCallConfig.userDiamonds) == 0 && this.duration == debugAgoraVideoCallConfig.duration;
    }

    @NotNull
    public final String getAgoraChannelName() {
        return this.agoraChannelName;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getFromToken() {
        return this.fromToken;
    }

    @NotNull
    public final String getFromUserID() {
        return this.fromUserID;
    }

    @Nullable
    public final String getRongRoomName() {
        return this.rongRoomName;
    }

    @NotNull
    public final String getToToken() {
        return this.toToken;
    }

    @NotNull
    public final String getToUID() {
        return this.toUID;
    }

    public final float getUserDiamonds() {
        return this.userDiamonds;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.agoraChannelName.hashCode() * 31;
        String str = this.rongRoomName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((((((((hashCode2 + hashCode) * 31) + this.fromUserID.hashCode()) * 31) + this.fromToken.hashCode()) * 31) + this.toToken.hashCode()) * 31) + this.toUID.hashCode()) * 31) + Float.floatToIntBits(this.userDiamonds)) * 31) + androidx.collection.c.a(this.duration);
    }

    public final void setAgoraChannelName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.agoraChannelName = str;
    }

    public final void setDuration(long j10) {
        this.duration = j10;
    }

    public final void setFromToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromToken = str;
    }

    public final void setFromUserID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromUserID = str;
    }

    public final void setRongRoomName(@Nullable String str) {
        this.rongRoomName = str;
    }

    public final void setToToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toToken = str;
    }

    public final void setToUID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toUID = str;
    }

    public final void setUserDiamonds(float f10) {
        this.userDiamonds = f10;
    }

    @NotNull
    public String toString() {
        return "DebugAgoraVideoCallConfig(agoraChannelName=" + this.agoraChannelName + ", rongRoomName=" + this.rongRoomName + ", fromUserID=" + this.fromUserID + ", fromToken=" + this.fromToken + ", toToken=" + this.toToken + ", toUID=" + this.toUID + ", userDiamonds=" + this.userDiamonds + ", duration=" + this.duration + ")";
    }

    public /* synthetic */ DebugAgoraVideoCallConfig(String str, String str2, String str3, String str4, String str5, String str6, float f10, long j10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? "N/A" : str2, str3, str4, str5, str6, f10, j10);
    }
}
