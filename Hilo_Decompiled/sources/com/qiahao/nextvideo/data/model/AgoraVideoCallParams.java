package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.common.VideoSetting;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Parcelize
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003Jg\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0006\u0010+\u001a\u00020\u0006J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AgoraVideoCallParams;", "Landroid/os/Parcelable;", "agoraToken", "", "channelId", "localAgoraId", "", "remoteAgoraId", "videoUid", "diamondNum", "remoteUser", "Lcom/qiahao/base_common/model/common/User;", "videoSetting", "Lcom/qiahao/base_common/model/common/VideoSetting;", "otherVideoSetting", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getAgoraToken", "()Ljava/lang/String;", "getChannelId", "getLocalAgoraId", "()I", "getRemoteAgoraId", "getVideoUid", "getDiamondNum", "getRemoteUser", "()Lcom/qiahao/base_common/model/common/User;", "getVideoSetting", "()Lcom/qiahao/base_common/model/common/VideoSetting;", "setVideoSetting", "(Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getOtherVideoSetting", "setOtherVideoSetting", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AgoraVideoCallParams implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AgoraVideoCallParams> CREATOR = new Creator();

    @NotNull
    @c("agoraToken")
    private final String agoraToken;

    @NotNull
    @c("channelId")
    private final String channelId;

    @c("diamondNum")
    private final int diamondNum;

    @c("localAgoraId")
    private final int localAgoraId;

    @Nullable
    private VideoSetting otherVideoSetting;

    @c("remoteAgoraId")
    private final int remoteAgoraId;

    @NotNull
    @c("remoteUser")
    private final User remoteUser;

    @Nullable
    private VideoSetting videoSetting;

    @NotNull
    @c("videoUid")
    private final String videoUid;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<AgoraVideoCallParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AgoraVideoCallParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AgoraVideoCallParams(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readParcelable(AgoraVideoCallParams.class.getClassLoader()), parcel.readParcelable(AgoraVideoCallParams.class.getClassLoader()), parcel.readParcelable(AgoraVideoCallParams.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AgoraVideoCallParams[] newArray(int i) {
            return new AgoraVideoCallParams[i];
        }
    }

    public AgoraVideoCallParams(@NotNull String str, @NotNull String str2, int i, int i2, @NotNull String str3, int i3, @NotNull User user, @Nullable VideoSetting videoSetting, @Nullable VideoSetting videoSetting2) {
        Intrinsics.checkNotNullParameter(str, "agoraToken");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "videoUid");
        Intrinsics.checkNotNullParameter(user, "remoteUser");
        this.agoraToken = str;
        this.channelId = str2;
        this.localAgoraId = i;
        this.remoteAgoraId = i2;
        this.videoUid = str3;
        this.diamondNum = i3;
        this.remoteUser = user;
        this.videoSetting = videoSetting;
        this.otherVideoSetting = videoSetting2;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAgoraToken() {
        return this.agoraToken;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLocalAgoraId() {
        return this.localAgoraId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRemoteAgoraId() {
        return this.remoteAgoraId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getVideoUid() {
        return this.videoUid;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final User getRemoteUser() {
        return this.remoteUser;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    @NotNull
    public final AgoraVideoCallParams copy(@NotNull String agoraToken, @NotNull String channelId, int localAgoraId, int remoteAgoraId, @NotNull String videoUid, int diamondNum, @NotNull User remoteUser, @Nullable VideoSetting videoSetting, @Nullable VideoSetting otherVideoSetting) {
        Intrinsics.checkNotNullParameter(agoraToken, "agoraToken");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(videoUid, "videoUid");
        Intrinsics.checkNotNullParameter(remoteUser, "remoteUser");
        return new AgoraVideoCallParams(agoraToken, channelId, localAgoraId, remoteAgoraId, videoUid, diamondNum, remoteUser, videoSetting, otherVideoSetting);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgoraVideoCallParams)) {
            return false;
        }
        AgoraVideoCallParams agoraVideoCallParams = (AgoraVideoCallParams) other;
        return Intrinsics.areEqual(this.agoraToken, agoraVideoCallParams.agoraToken) && Intrinsics.areEqual(this.channelId, agoraVideoCallParams.channelId) && this.localAgoraId == agoraVideoCallParams.localAgoraId && this.remoteAgoraId == agoraVideoCallParams.remoteAgoraId && Intrinsics.areEqual(this.videoUid, agoraVideoCallParams.videoUid) && this.diamondNum == agoraVideoCallParams.diamondNum && Intrinsics.areEqual(this.remoteUser, agoraVideoCallParams.remoteUser) && Intrinsics.areEqual(this.videoSetting, agoraVideoCallParams.videoSetting) && Intrinsics.areEqual(this.otherVideoSetting, agoraVideoCallParams.otherVideoSetting);
    }

    @NotNull
    public final String getAgoraToken() {
        return this.agoraToken;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    public final int getDiamondNum() {
        return this.diamondNum;
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

    @NotNull
    public final User getRemoteUser() {
        return this.remoteUser;
    }

    @Nullable
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    @NotNull
    public final String getVideoUid() {
        return this.videoUid;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.agoraToken.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.localAgoraId) * 31) + this.remoteAgoraId) * 31) + this.videoUid.hashCode()) * 31) + this.diamondNum) * 31) + this.remoteUser.hashCode()) * 31;
        VideoSetting videoSetting = this.videoSetting;
        int hashCode2 = (hashCode + (videoSetting == null ? 0 : videoSetting.hashCode())) * 31;
        VideoSetting videoSetting2 = this.otherVideoSetting;
        return hashCode2 + (videoSetting2 != null ? videoSetting2.hashCode() : 0);
    }

    public final void setOtherVideoSetting(@Nullable VideoSetting videoSetting) {
        this.otherVideoSetting = videoSetting;
    }

    public final void setVideoSetting(@Nullable VideoSetting videoSetting) {
        this.videoSetting = videoSetting;
    }

    @NotNull
    public String toString() {
        return "AgoraVideoCallParams(agoraToken=" + this.agoraToken + ", channelId=" + this.channelId + ", localAgoraId=" + this.localAgoraId + ", remoteAgoraId=" + this.remoteAgoraId + ", videoUid=" + this.videoUid + ", diamondNum=" + this.diamondNum + ", remoteUser=" + this.remoteUser + ", videoSetting=" + this.videoSetting + ", otherVideoSetting=" + this.otherVideoSetting + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.agoraToken);
        dest.writeString(this.channelId);
        dest.writeInt(this.localAgoraId);
        dest.writeInt(this.remoteAgoraId);
        dest.writeString(this.videoUid);
        dest.writeInt(this.diamondNum);
        dest.writeParcelable(this.remoteUser, flags);
        dest.writeParcelable(this.videoSetting, flags);
        dest.writeParcelable(this.otherVideoSetting, flags);
    }

    public /* synthetic */ AgoraVideoCallParams(String str, String str2, int i, int i2, String str3, int i3, User user, VideoSetting videoSetting, VideoSetting videoSetting2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2, str3, i3, user, (i4 & 128) != 0 ? null : videoSetting, (i4 & 256) != 0 ? null : videoSetting2);
    }
}
