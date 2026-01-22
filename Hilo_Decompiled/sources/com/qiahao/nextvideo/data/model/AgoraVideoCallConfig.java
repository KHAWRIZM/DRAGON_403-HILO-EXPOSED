package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.c;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;

@Parcelize
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0001TB\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010C\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010D\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0015HÆ\u0003J°\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u00020\nJ\u0013\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\nHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010(R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b\u0011\u0010.\"\u0004\b/\u00100R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00101\u001a\u0004\b\u0013\u0010.R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105¨\u0006U"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "Landroid/os/Parcelable;", "fromUserID", "", "toUserUID", "userDiamonds", "", "duration", "", "status", "", "channelID", "token", "localAgoraId", "remoteAgoraId", "videoUID", "diamondBalance", "isLike", "", "isLikeMe", "videoSetting", "Lcom/qiahao/base_common/model/common/VideoSetting;", "otherVideoSetting", "<init>", "(Ljava/lang/String;Ljava/lang/String;FJILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getFromUserID", "()Ljava/lang/String;", "getToUserUID", "getUserDiamonds", "()F", "getDuration", "()J", "getStatus", "()I", "getChannelID", "getToken", "getLocalAgoraId", "getRemoteAgoraId", "getVideoUID", "setVideoUID", "(Ljava/lang/String;)V", "getDiamondBalance", "()Ljava/lang/Integer;", "setDiamondBalance", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "setLike", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getVideoSetting", "()Lcom/qiahao/base_common/model/common/VideoSetting;", "setVideoSetting", "(Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getOtherVideoSetting", "setOtherVideoSetting", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;FJILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AgoraVideoCallConfig implements Parcelable {

    @NotNull
    private final String channelID;

    @Nullable
    private Integer diamondBalance;
    private final long duration;

    @NotNull
    private final String fromUserID;

    @Nullable
    private Boolean isLike;

    @Nullable
    private final Boolean isLikeMe;
    private final int localAgoraId;

    @Nullable
    private VideoSetting otherVideoSetting;
    private final int remoteAgoraId;
    private final int status;

    @NotNull
    private final String toUserUID;

    @NotNull
    private final String token;
    private final float userDiamonds;

    @Nullable
    private VideoSetting videoSetting;

    @Nullable
    private String videoUID;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<AgoraVideoCallConfig> CREATOR = new Creator();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "matchConfirm", "LuserProxy/UserProxy$MatchConfirm;", "isLike", "", "isLikeMe", "video", "LuserProxy/UserProxy$Video;", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallParams;", "sendUserId", "", "receiveUserId", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AgoraVideoCallConfig init(@NotNull UserProxy.MatchConfirm matchConfirm, boolean isLike, boolean isLikeMe) {
            Intrinsics.checkNotNullParameter(matchConfirm, "matchConfirm");
            String localUserId = matchConfirm.getLocalUserId();
            Intrinsics.checkNotNullExpressionValue(localUserId, "getLocalUserId(...)");
            String remoteUserId = matchConfirm.getRemoteUserId();
            Intrinsics.checkNotNullExpressionValue(remoteUserId, "getRemoteUserId(...)");
            long callDuration = matchConfirm.getCallDuration();
            int status = matchConfirm.getStatus();
            String channelId = matchConfirm.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
            String token = matchConfirm.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            return new AgoraVideoCallConfig(localUserId, remoteUserId, 0.0f, callDuration, status, channelId, token, matchConfirm.getLocalAgoraId(), matchConfirm.getRemoteAgoraId(), null, null, Boolean.valueOf(isLike), Boolean.valueOf(isLikeMe), null, null, 26112, null);
        }

        private Companion() {
        }

        @NotNull
        public final AgoraVideoCallConfig init(@NotNull UserProxy.Video video) {
            Intrinsics.checkNotNullParameter(video, "video");
            String videoUniqueId = video.getVideoUniqueId();
            int status = video.getStatus();
            String channelId = video.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
            String agoraToken = video.getAgoraToken();
            Intrinsics.checkNotNullExpressionValue(agoraToken, "getAgoraToken(...)");
            String sendUserId = video.getSendUserId();
            Intrinsics.checkNotNullExpressionValue(sendUserId, "getSendUserId(...)");
            String receiveUserId = video.getReceiveUserId();
            Intrinsics.checkNotNullExpressionValue(receiveUserId, "getReceiveUserId(...)");
            int localAgoraId = video.getLocalAgoraId();
            int remoteAgoraId = video.getRemoteAgoraId();
            UserProxy.VideoSetting videoSetting = video.getVideoSetting();
            Intrinsics.checkNotNullExpressionValue(videoSetting, "getVideoSetting(...)");
            VideoSetting videoSet = DataExternalKt.toVideoSet(videoSetting);
            UserProxy.VideoSetting otherVideoSetting = video.getOtherVideoSetting();
            Intrinsics.checkNotNullExpressionValue(otherVideoSetting, "getOtherVideoSetting(...)");
            return new AgoraVideoCallConfig(sendUserId, receiveUserId, 0.0f, -1L, status, channelId, agoraToken, localAgoraId, remoteAgoraId, videoUniqueId, null, null, null, videoSet, DataExternalKt.toVideoSet(otherVideoSetting), 7168, null);
        }

        @NotNull
        public final AgoraVideoCallConfig init(@NotNull AgoraVideoCallParams video, @NotNull String sendUserId, @NotNull String receiveUserId) {
            Intrinsics.checkNotNullParameter(video, "video");
            Intrinsics.checkNotNullParameter(sendUserId, "sendUserId");
            Intrinsics.checkNotNullParameter(receiveUserId, "receiveUserId");
            return new AgoraVideoCallConfig(sendUserId, receiveUserId, 0.0f, -1L, -1, video.getChannelId(), video.getAgoraToken(), video.getLocalAgoraId(), video.getRemoteAgoraId(), video.getVideoUid(), null, null, null, video.getVideoSetting(), video.getOtherVideoSetting(), 7168, null);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<AgoraVideoCallConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AgoraVideoCallConfig createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            float readFloat = parcel.readFloat();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            String readString5 = parcel.readString();
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new AgoraVideoCallConfig(readString, readString2, readFloat, readLong, readInt, readString3, readString4, readInt2, readInt3, readString5, valueOf3, valueOf, valueOf2, parcel.readParcelable(AgoraVideoCallConfig.class.getClassLoader()), parcel.readParcelable(AgoraVideoCallConfig.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AgoraVideoCallConfig[] newArray(int i) {
            return new AgoraVideoCallConfig[i];
        }
    }

    public AgoraVideoCallConfig(@NotNull String str, @NotNull String str2, float f, long j, int i, @NotNull String str3, @NotNull String str4, int i2, int i3, @Nullable String str5, @Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable VideoSetting videoSetting, @Nullable VideoSetting videoSetting2) {
        Intrinsics.checkNotNullParameter(str, "fromUserID");
        Intrinsics.checkNotNullParameter(str2, "toUserUID");
        Intrinsics.checkNotNullParameter(str3, "channelID");
        Intrinsics.checkNotNullParameter(str4, "token");
        this.fromUserID = str;
        this.toUserUID = str2;
        this.userDiamonds = f;
        this.duration = j;
        this.status = i;
        this.channelID = str3;
        this.token = str4;
        this.localAgoraId = i2;
        this.remoteAgoraId = i3;
        this.videoUID = str5;
        this.diamondBalance = num;
        this.isLike = bool;
        this.isLikeMe = bool2;
        this.videoSetting = videoSetting;
        this.otherVideoSetting = videoSetting2;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFromUserID() {
        return this.fromUserID;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getVideoUID() {
        return this.videoUID;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getDiamondBalance() {
        return this.diamondBalance;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Boolean getIsLike() {
        return this.isLike;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getToUserUID() {
        return this.toUserUID;
    }

    /* renamed from: component3, reason: from getter */
    public final float getUserDiamonds() {
        return this.userDiamonds;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component5, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getChannelID() {
        return this.channelID;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component8, reason: from getter */
    public final int getLocalAgoraId() {
        return this.localAgoraId;
    }

    /* renamed from: component9, reason: from getter */
    public final int getRemoteAgoraId() {
        return this.remoteAgoraId;
    }

    @NotNull
    public final AgoraVideoCallConfig copy(@NotNull String fromUserID, @NotNull String toUserUID, float userDiamonds, long duration, int status, @NotNull String channelID, @NotNull String token, int localAgoraId, int remoteAgoraId, @Nullable String videoUID, @Nullable Integer diamondBalance, @Nullable Boolean isLike, @Nullable Boolean isLikeMe, @Nullable VideoSetting videoSetting, @Nullable VideoSetting otherVideoSetting) {
        Intrinsics.checkNotNullParameter(fromUserID, "fromUserID");
        Intrinsics.checkNotNullParameter(toUserUID, "toUserUID");
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(token, "token");
        return new AgoraVideoCallConfig(fromUserID, toUserUID, userDiamonds, duration, status, channelID, token, localAgoraId, remoteAgoraId, videoUID, diamondBalance, isLike, isLikeMe, videoSetting, otherVideoSetting);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgoraVideoCallConfig)) {
            return false;
        }
        AgoraVideoCallConfig agoraVideoCallConfig = (AgoraVideoCallConfig) other;
        return Intrinsics.areEqual(this.fromUserID, agoraVideoCallConfig.fromUserID) && Intrinsics.areEqual(this.toUserUID, agoraVideoCallConfig.toUserUID) && Float.compare(this.userDiamonds, agoraVideoCallConfig.userDiamonds) == 0 && this.duration == agoraVideoCallConfig.duration && this.status == agoraVideoCallConfig.status && Intrinsics.areEqual(this.channelID, agoraVideoCallConfig.channelID) && Intrinsics.areEqual(this.token, agoraVideoCallConfig.token) && this.localAgoraId == agoraVideoCallConfig.localAgoraId && this.remoteAgoraId == agoraVideoCallConfig.remoteAgoraId && Intrinsics.areEqual(this.videoUID, agoraVideoCallConfig.videoUID) && Intrinsics.areEqual(this.diamondBalance, agoraVideoCallConfig.diamondBalance) && Intrinsics.areEqual(this.isLike, agoraVideoCallConfig.isLike) && Intrinsics.areEqual(this.isLikeMe, agoraVideoCallConfig.isLikeMe) && Intrinsics.areEqual(this.videoSetting, agoraVideoCallConfig.videoSetting) && Intrinsics.areEqual(this.otherVideoSetting, agoraVideoCallConfig.otherVideoSetting);
    }

    @NotNull
    public final String getChannelID() {
        return this.channelID;
    }

    @Nullable
    public final Integer getDiamondBalance() {
        return this.diamondBalance;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getFromUserID() {
        return this.fromUserID;
    }

    public final int getLocalAgoraId() {
        return this.localAgoraId;
    }

    @Nullable
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    public final int getRemoteAgoraId() {
        return this.remoteAgoraId;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getToUserUID() {
        return this.toUserUID;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public final float getUserDiamonds() {
        return this.userDiamonds;
    }

    @Nullable
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    @Nullable
    public final String getVideoUID() {
        return this.videoUID;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6 = ((((((((((((((((this.fromUserID.hashCode() * 31) + this.toUserUID.hashCode()) * 31) + Float.floatToIntBits(this.userDiamonds)) * 31) + c.a(this.duration)) * 31) + this.status) * 31) + this.channelID.hashCode()) * 31) + this.token.hashCode()) * 31) + this.localAgoraId) * 31) + this.remoteAgoraId) * 31;
        String str = this.videoUID;
        int i = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i2 = (hashCode6 + hashCode) * 31;
        Integer num = this.diamondBalance;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i3 = (i2 + hashCode2) * 31;
        Boolean bool = this.isLike;
        if (bool == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bool.hashCode();
        }
        int i4 = (i3 + hashCode3) * 31;
        Boolean bool2 = this.isLikeMe;
        if (bool2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool2.hashCode();
        }
        int i5 = (i4 + hashCode4) * 31;
        VideoSetting videoSetting = this.videoSetting;
        if (videoSetting == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = videoSetting.hashCode();
        }
        int i6 = (i5 + hashCode5) * 31;
        VideoSetting videoSetting2 = this.otherVideoSetting;
        if (videoSetting2 != null) {
            i = videoSetting2.hashCode();
        }
        return i6 + i;
    }

    @Nullable
    public final Boolean isLike() {
        return this.isLike;
    }

    @Nullable
    public final Boolean isLikeMe() {
        return this.isLikeMe;
    }

    public final void setDiamondBalance(@Nullable Integer num) {
        this.diamondBalance = num;
    }

    public final void setLike(@Nullable Boolean bool) {
        this.isLike = bool;
    }

    public final void setOtherVideoSetting(@Nullable VideoSetting videoSetting) {
        this.otherVideoSetting = videoSetting;
    }

    public final void setVideoSetting(@Nullable VideoSetting videoSetting) {
        this.videoSetting = videoSetting;
    }

    public final void setVideoUID(@Nullable String str) {
        this.videoUID = str;
    }

    @NotNull
    public String toString() {
        return "AgoraVideoCallConfig(fromUserID=" + this.fromUserID + ", toUserUID=" + this.toUserUID + ", userDiamonds=" + this.userDiamonds + ", duration=" + this.duration + ", status=" + this.status + ", channelID=" + this.channelID + ", token=" + this.token + ", localAgoraId=" + this.localAgoraId + ", remoteAgoraId=" + this.remoteAgoraId + ", videoUID=" + this.videoUID + ", diamondBalance=" + this.diamondBalance + ", isLike=" + this.isLike + ", isLikeMe=" + this.isLikeMe + ", videoSetting=" + this.videoSetting + ", otherVideoSetting=" + this.otherVideoSetting + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.fromUserID);
        dest.writeString(this.toUserUID);
        dest.writeFloat(this.userDiamonds);
        dest.writeLong(this.duration);
        dest.writeInt(this.status);
        dest.writeString(this.channelID);
        dest.writeString(this.token);
        dest.writeInt(this.localAgoraId);
        dest.writeInt(this.remoteAgoraId);
        dest.writeString(this.videoUID);
        Integer num = this.diamondBalance;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Boolean bool = this.isLike;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.isLikeMe;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        dest.writeParcelable(this.videoSetting, flags);
        dest.writeParcelable(this.otherVideoSetting, flags);
    }

    public /* synthetic */ AgoraVideoCallConfig(String str, String str2, float f, long j, int i, String str3, String str4, int i2, int i3, String str5, Integer num, Boolean bool, Boolean bool2, VideoSetting videoSetting, VideoSetting videoSetting2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f, j, i, str3, str4, i2, i3, (i4 & 512) != 0 ? null : str5, (i4 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : num, (i4 & 2048) != 0 ? Boolean.TRUE : bool, (i4 & 4096) != 0 ? Boolean.TRUE : bool2, (i4 & 8192) != 0 ? null : videoSetting, (i4 & 16384) != 0 ? null : videoSetting2);
    }
}
