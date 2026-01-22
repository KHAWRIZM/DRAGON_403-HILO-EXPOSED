package com.qiahao.nextvideo.ui.videocall;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.ChannelEventStartup;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 f2\u00020\u0001:\u0001fB÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010O\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010S\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010T\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u001aHÆ\u0003Jþ\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0002\u0010YJ\u0006\u0010Z\u001a\u00020\u0010J\u0013\u0010[\u001a\u00020\\2\b\u0010]\u001a\u0004\u0018\u00010^HÖ\u0003J\t\u0010_\u001a\u00020\u0010HÖ\u0001J\t\u0010`\u001a\u00020\u0005HÖ\u0001J\u0016\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u0010R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u00100\u001a\u0004\b1\u0010/R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b2\u0010\u001fR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b3\u0010\u001fR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b4\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b5\u0010/\"\u0004\b6\u00107R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010?\"\u0004\bC\u0010A¨\u0006g"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "Landroid/os/Parcelable;", "remainingTime", "", "fromUserID", "", "toUID", "fromNickname", "toNickname", "fromUserPicture", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "toUserPicture", "channelID", "fromAgoraToken", VideoResultActivity.VIDEO_MATCH_UNIQUE_ID, "localAgoraId", "", "remoteAgoraId", "startTimeSecs", "endTimeSecs", "differenceTimeInSecs", "diamondBalance", "toUser", "Lcom/qiahao/base_common/model/common/User;", "formUser", "videoSetting", "Lcom/qiahao/base_common/model/common/VideoSetting;", "otherVideoSetting", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getRemainingTime", "()Ljava/lang/Long;", "setRemainingTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFromUserID", "()Ljava/lang/String;", "getToUID", "getFromNickname", "getToNickname", "getFromUserPicture", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getToUserPicture", "getChannelID", "getFromAgoraToken", "getMatchUniqueID", "getLocalAgoraId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRemoteAgoraId", "getStartTimeSecs", "getEndTimeSecs", "getDifferenceTimeInSecs", "getDiamondBalance", "setDiamondBalance", "(Ljava/lang/Integer;)V", "getToUser", "()Lcom/qiahao/base_common/model/common/User;", "setToUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getFormUser", "setFormUser", "getVideoSetting", "()Lcom/qiahao/base_common/model/common/VideoSetting;", "setVideoSetting", "(Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getOtherVideoSetting", "setOtherVideoSetting", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoCallPreloadModel implements Parcelable {

    @Nullable
    private final String channelID;

    @Nullable
    private Integer diamondBalance;

    @Nullable
    private final Long differenceTimeInSecs;

    @Nullable
    private final Long endTimeSecs;

    @Nullable
    private User formUser;

    @Nullable
    private final String fromAgoraToken;

    @Nullable
    private final String fromNickname;

    @Nullable
    private final String fromUserID;

    @Nullable
    private final ImageUIModel fromUserPicture;

    @Nullable
    private final Integer localAgoraId;

    @Nullable
    private final String matchUniqueID;

    @Nullable
    private VideoSetting otherVideoSetting;

    @Nullable
    private Long remainingTime;

    @Nullable
    private final Integer remoteAgoraId;

    @Nullable
    private final Long startTimeSecs;

    @Nullable
    private final String toNickname;

    @Nullable
    private final String toUID;

    @Nullable
    private User toUser;

    @Nullable
    private final ImageUIModel toUserPicture;

    @Nullable
    private VideoSetting videoSetting;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<VideoCallPreloadModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "agoraVideoCallConfig", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "fromUser", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "toUser", "Lcom/qiahao/base_common/model/common/User;", VideoResultActivity.VIDEO_MATCH_UNIQUE_ID, "", "channelEventStartup", "Lcom/qiahao/base_common/model/common/ChannelEventStartup;", "diffTimeInSecs", "", "(Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;Lcom/qiahao/base_common/model/common/ChannelEventStartup;Ljava/lang/Long;)Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VideoCallPreloadModel init$default(Companion companion, AgoraVideoCallConfig agoraVideoCallConfig, UserSummaryInfo userSummaryInfo, User user, String str, ChannelEventStartup channelEventStartup, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                agoraVideoCallConfig = null;
            }
            if ((i & 2) != 0) {
                userSummaryInfo = null;
            }
            if ((i & 4) != 0) {
                user = null;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            if ((i & 16) != 0) {
                channelEventStartup = null;
            }
            if ((i & 32) != 0) {
                l = null;
            }
            return companion.init(agoraVideoCallConfig, userSummaryInfo, user, str, channelEventStartup, l);
        }

        @NotNull
        public final VideoCallPreloadModel init(@Nullable AgoraVideoCallConfig agoraVideoCallConfig, @Nullable UserSummaryInfo fromUser, @Nullable User toUser, @Nullable String matchUniqueID, @Nullable ChannelEventStartup channelEventStartup, @Nullable Long diffTimeInSecs) {
            Long l;
            String str;
            String str2;
            String str3;
            String str4;
            Integer num;
            Integer num2;
            String str5;
            String str6;
            String str7;
            String str8;
            Long l2;
            Long l3;
            Integer num3;
            User user;
            VideoSetting videoSetting;
            long j;
            VideoSetting videoSetting2 = null;
            if (agoraVideoCallConfig != null) {
                l = Long.valueOf(agoraVideoCallConfig.getDuration());
            } else {
                l = null;
            }
            if (agoraVideoCallConfig != null) {
                str = agoraVideoCallConfig.getFromUserID();
            } else {
                str = null;
            }
            if (agoraVideoCallConfig != null) {
                str2 = agoraVideoCallConfig.getToken();
            } else {
                str2 = null;
            }
            if (fromUser == null || (str3 = fromUser.getName()) == null) {
                str3 = "";
            }
            if (toUser == null || (str4 = toUser.getNick()) == null) {
                str4 = "";
            }
            if (agoraVideoCallConfig != null) {
                num = Integer.valueOf(agoraVideoCallConfig.getLocalAgoraId());
            } else {
                num = null;
            }
            if (agoraVideoCallConfig != null) {
                num2 = Integer.valueOf(agoraVideoCallConfig.getRemoteAgoraId());
            } else {
                num2 = null;
            }
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            if (fromUser != null) {
                str5 = fromUser.getAvatar();
            } else {
                str5 = null;
            }
            ImageUIModel full = companion.full(str5);
            if (toUser != null) {
                str6 = toUser.getAvatar();
            } else {
                str6 = null;
            }
            ImageUIModel full2 = companion.full(str6);
            if (agoraVideoCallConfig != null) {
                str7 = agoraVideoCallConfig.getChannelID();
            } else {
                str7 = null;
            }
            if (agoraVideoCallConfig != null) {
                str8 = agoraVideoCallConfig.getToUserUID();
            } else {
                str8 = null;
            }
            if (channelEventStartup != null) {
                l2 = Long.valueOf(channelEventStartup.getStartupVideoChatTimestamp());
            } else {
                l2 = null;
            }
            if (channelEventStartup != null) {
                l3 = Long.valueOf(channelEventStartup.getEndTimestamp());
            } else {
                l3 = null;
            }
            if (agoraVideoCallConfig != null) {
                num3 = agoraVideoCallConfig.getDiamondBalance();
            } else {
                num3 = null;
            }
            if (fromUser != null) {
                user = DataExternalKt.toUser(fromUser);
            } else {
                user = null;
            }
            if (channelEventStartup != null) {
                videoSetting = channelEventStartup.getVideoSetting();
            } else {
                videoSetting = null;
            }
            if (channelEventStartup != null) {
                videoSetting2 = channelEventStartup.getOtherVideoSetting();
            }
            VideoCallPreloadModel videoCallPreloadModel = new VideoCallPreloadModel(l, str, str8, str3, str4, full, full2, str7, str2, matchUniqueID, num, num2, l2, l3, diffTimeInSecs, num3, toUser, user, videoSetting, videoSetting2);
            Long endTimeSecs = videoCallPreloadModel.getEndTimeSecs();
            long j2 = 0;
            if (endTimeSecs != null) {
                j = endTimeSecs.longValue();
            } else {
                j = 0;
            }
            Long startTimeSecs = videoCallPreloadModel.getStartTimeSecs();
            if (startTimeSecs != null) {
                j2 = startTimeSecs.longValue();
            }
            videoCallPreloadModel.setRemainingTime(Long.valueOf(j - j2));
            return videoCallPreloadModel;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<VideoCallPreloadModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoCallPreloadModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoCallPreloadModel(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : ImageUIModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ImageUIModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readParcelable(VideoCallPreloadModel.class.getClassLoader()), parcel.readParcelable(VideoCallPreloadModel.class.getClassLoader()), parcel.readParcelable(VideoCallPreloadModel.class.getClassLoader()), parcel.readParcelable(VideoCallPreloadModel.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoCallPreloadModel[] newArray(int i) {
            return new VideoCallPreloadModel[i];
        }
    }

    public VideoCallPreloadModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getRemainingTime() {
        return this.remainingTime;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getLocalAgoraId() {
        return this.localAgoraId;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getRemoteAgoraId() {
        return this.remoteAgoraId;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Long getStartTimeSecs() {
        return this.startTimeSecs;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Long getEndTimeSecs() {
        return this.endTimeSecs;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Long getDifferenceTimeInSecs() {
        return this.differenceTimeInSecs;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Integer getDiamondBalance() {
        return this.diamondBalance;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final User getToUser() {
        return this.toUser;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final User getFormUser() {
        return this.formUser;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFromUserID() {
        return this.fromUserID;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getToUID() {
        return this.toUID;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getFromNickname() {
        return this.fromNickname;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getToNickname() {
        return this.toNickname;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final ImageUIModel getFromUserPicture() {
        return this.fromUserPicture;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final ImageUIModel getToUserPicture() {
        return this.toUserPicture;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getChannelID() {
        return this.channelID;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getFromAgoraToken() {
        return this.fromAgoraToken;
    }

    @NotNull
    public final VideoCallPreloadModel copy(@Nullable Long remainingTime, @Nullable String fromUserID, @Nullable String toUID, @Nullable String fromNickname, @Nullable String toNickname, @Nullable ImageUIModel fromUserPicture, @Nullable ImageUIModel toUserPicture, @Nullable String channelID, @Nullable String fromAgoraToken, @Nullable String matchUniqueID, @Nullable Integer localAgoraId, @Nullable Integer remoteAgoraId, @Nullable Long startTimeSecs, @Nullable Long endTimeSecs, @Nullable Long differenceTimeInSecs, @Nullable Integer diamondBalance, @Nullable User toUser, @Nullable User formUser, @Nullable VideoSetting videoSetting, @Nullable VideoSetting otherVideoSetting) {
        return new VideoCallPreloadModel(remainingTime, fromUserID, toUID, fromNickname, toNickname, fromUserPicture, toUserPicture, channelID, fromAgoraToken, matchUniqueID, localAgoraId, remoteAgoraId, startTimeSecs, endTimeSecs, differenceTimeInSecs, diamondBalance, toUser, formUser, videoSetting, otherVideoSetting);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallPreloadModel)) {
            return false;
        }
        VideoCallPreloadModel videoCallPreloadModel = (VideoCallPreloadModel) other;
        return Intrinsics.areEqual(this.remainingTime, videoCallPreloadModel.remainingTime) && Intrinsics.areEqual(this.fromUserID, videoCallPreloadModel.fromUserID) && Intrinsics.areEqual(this.toUID, videoCallPreloadModel.toUID) && Intrinsics.areEqual(this.fromNickname, videoCallPreloadModel.fromNickname) && Intrinsics.areEqual(this.toNickname, videoCallPreloadModel.toNickname) && Intrinsics.areEqual(this.fromUserPicture, videoCallPreloadModel.fromUserPicture) && Intrinsics.areEqual(this.toUserPicture, videoCallPreloadModel.toUserPicture) && Intrinsics.areEqual(this.channelID, videoCallPreloadModel.channelID) && Intrinsics.areEqual(this.fromAgoraToken, videoCallPreloadModel.fromAgoraToken) && Intrinsics.areEqual(this.matchUniqueID, videoCallPreloadModel.matchUniqueID) && Intrinsics.areEqual(this.localAgoraId, videoCallPreloadModel.localAgoraId) && Intrinsics.areEqual(this.remoteAgoraId, videoCallPreloadModel.remoteAgoraId) && Intrinsics.areEqual(this.startTimeSecs, videoCallPreloadModel.startTimeSecs) && Intrinsics.areEqual(this.endTimeSecs, videoCallPreloadModel.endTimeSecs) && Intrinsics.areEqual(this.differenceTimeInSecs, videoCallPreloadModel.differenceTimeInSecs) && Intrinsics.areEqual(this.diamondBalance, videoCallPreloadModel.diamondBalance) && Intrinsics.areEqual(this.toUser, videoCallPreloadModel.toUser) && Intrinsics.areEqual(this.formUser, videoCallPreloadModel.formUser) && Intrinsics.areEqual(this.videoSetting, videoCallPreloadModel.videoSetting) && Intrinsics.areEqual(this.otherVideoSetting, videoCallPreloadModel.otherVideoSetting);
    }

    @Nullable
    public final String getChannelID() {
        return this.channelID;
    }

    @Nullable
    public final Integer getDiamondBalance() {
        return this.diamondBalance;
    }

    @Nullable
    public final Long getDifferenceTimeInSecs() {
        return this.differenceTimeInSecs;
    }

    @Nullable
    public final Long getEndTimeSecs() {
        return this.endTimeSecs;
    }

    @Nullable
    public final User getFormUser() {
        return this.formUser;
    }

    @Nullable
    public final String getFromAgoraToken() {
        return this.fromAgoraToken;
    }

    @Nullable
    public final String getFromNickname() {
        return this.fromNickname;
    }

    @Nullable
    public final String getFromUserID() {
        return this.fromUserID;
    }

    @Nullable
    public final ImageUIModel getFromUserPicture() {
        return this.fromUserPicture;
    }

    @Nullable
    public final Integer getLocalAgoraId() {
        return this.localAgoraId;
    }

    @Nullable
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
    }

    @Nullable
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    @Nullable
    public final Long getRemainingTime() {
        return this.remainingTime;
    }

    @Nullable
    public final Integer getRemoteAgoraId() {
        return this.remoteAgoraId;
    }

    @Nullable
    public final Long getStartTimeSecs() {
        return this.startTimeSecs;
    }

    @Nullable
    public final String getToNickname() {
        return this.toNickname;
    }

    @Nullable
    public final String getToUID() {
        return this.toUID;
    }

    @Nullable
    public final User getToUser() {
        return this.toUser;
    }

    @Nullable
    public final ImageUIModel getToUserPicture() {
        return this.toUserPicture;
    }

    @Nullable
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    public int hashCode() {
        Long l = this.remainingTime;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.fromUserID;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.toUID;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fromNickname;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toNickname;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ImageUIModel imageUIModel = this.fromUserPicture;
        int hashCode6 = (hashCode5 + (imageUIModel == null ? 0 : imageUIModel.hashCode())) * 31;
        ImageUIModel imageUIModel2 = this.toUserPicture;
        int hashCode7 = (hashCode6 + (imageUIModel2 == null ? 0 : imageUIModel2.hashCode())) * 31;
        String str5 = this.channelID;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.fromAgoraToken;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.matchUniqueID;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.localAgoraId;
        int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.remoteAgoraId;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l2 = this.startTimeSecs;
        int hashCode13 = (hashCode12 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.endTimeSecs;
        int hashCode14 = (hashCode13 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.differenceTimeInSecs;
        int hashCode15 = (hashCode14 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Integer num3 = this.diamondBalance;
        int hashCode16 = (hashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
        User user = this.toUser;
        int hashCode17 = (hashCode16 + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.formUser;
        int hashCode18 = (hashCode17 + (user2 == null ? 0 : user2.hashCode())) * 31;
        VideoSetting videoSetting = this.videoSetting;
        int hashCode19 = (hashCode18 + (videoSetting == null ? 0 : videoSetting.hashCode())) * 31;
        VideoSetting videoSetting2 = this.otherVideoSetting;
        return hashCode19 + (videoSetting2 != null ? videoSetting2.hashCode() : 0);
    }

    public final void setDiamondBalance(@Nullable Integer num) {
        this.diamondBalance = num;
    }

    public final void setFormUser(@Nullable User user) {
        this.formUser = user;
    }

    public final void setOtherVideoSetting(@Nullable VideoSetting videoSetting) {
        this.otherVideoSetting = videoSetting;
    }

    public final void setRemainingTime(@Nullable Long l) {
        this.remainingTime = l;
    }

    public final void setToUser(@Nullable User user) {
        this.toUser = user;
    }

    public final void setVideoSetting(@Nullable VideoSetting videoSetting) {
        this.videoSetting = videoSetting;
    }

    @NotNull
    public String toString() {
        return "VideoCallPreloadModel(remainingTime=" + this.remainingTime + ", fromUserID=" + this.fromUserID + ", toUID=" + this.toUID + ", fromNickname=" + this.fromNickname + ", toNickname=" + this.toNickname + ", fromUserPicture=" + this.fromUserPicture + ", toUserPicture=" + this.toUserPicture + ", channelID=" + this.channelID + ", fromAgoraToken=" + this.fromAgoraToken + ", matchUniqueID=" + this.matchUniqueID + ", localAgoraId=" + this.localAgoraId + ", remoteAgoraId=" + this.remoteAgoraId + ", startTimeSecs=" + this.startTimeSecs + ", endTimeSecs=" + this.endTimeSecs + ", differenceTimeInSecs=" + this.differenceTimeInSecs + ", diamondBalance=" + this.diamondBalance + ", toUser=" + this.toUser + ", formUser=" + this.formUser + ", videoSetting=" + this.videoSetting + ", otherVideoSetting=" + this.otherVideoSetting + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Long l = this.remainingTime;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.fromUserID);
        dest.writeString(this.toUID);
        dest.writeString(this.fromNickname);
        dest.writeString(this.toNickname);
        ImageUIModel imageUIModel = this.fromUserPicture;
        if (imageUIModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            imageUIModel.writeToParcel(dest, flags);
        }
        ImageUIModel imageUIModel2 = this.toUserPicture;
        if (imageUIModel2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            imageUIModel2.writeToParcel(dest, flags);
        }
        dest.writeString(this.channelID);
        dest.writeString(this.fromAgoraToken);
        dest.writeString(this.matchUniqueID);
        Integer num = this.localAgoraId;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.remoteAgoraId;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Long l2 = this.startTimeSecs;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        Long l3 = this.endTimeSecs;
        if (l3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l3.longValue());
        }
        Long l4 = this.differenceTimeInSecs;
        if (l4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l4.longValue());
        }
        Integer num3 = this.diamondBalance;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        dest.writeParcelable(this.toUser, flags);
        dest.writeParcelable(this.formUser, flags);
        dest.writeParcelable(this.videoSetting, flags);
        dest.writeParcelable(this.otherVideoSetting, flags);
    }

    public VideoCallPreloadModel(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable ImageUIModel imageUIModel, @Nullable ImageUIModel imageUIModel2, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Integer num3, @Nullable User user, @Nullable User user2, @Nullable VideoSetting videoSetting, @Nullable VideoSetting videoSetting2) {
        this.remainingTime = l;
        this.fromUserID = str;
        this.toUID = str2;
        this.fromNickname = str3;
        this.toNickname = str4;
        this.fromUserPicture = imageUIModel;
        this.toUserPicture = imageUIModel2;
        this.channelID = str5;
        this.fromAgoraToken = str6;
        this.matchUniqueID = str7;
        this.localAgoraId = num;
        this.remoteAgoraId = num2;
        this.startTimeSecs = l2;
        this.endTimeSecs = l3;
        this.differenceTimeInSecs = l4;
        this.diamondBalance = num3;
        this.toUser = user;
        this.formUser = user2;
        this.videoSetting = videoSetting;
        this.otherVideoSetting = videoSetting2;
    }

    public /* synthetic */ VideoCallPreloadModel(Long l, String str, String str2, String str3, String str4, ImageUIModel imageUIModel, ImageUIModel imageUIModel2, String str5, String str6, String str7, Integer num, Integer num2, Long l2, Long l3, Long l4, Integer num3, User user, User user2, VideoSetting videoSetting, VideoSetting videoSetting2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : imageUIModel, (i & 64) != 0 ? null : imageUIModel2, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : num, (i & 2048) != 0 ? null : num2, (i & 4096) != 0 ? null : l2, (i & 8192) != 0 ? null : l3, (i & 16384) != 0 ? null : l4, (i & 32768) != 0 ? null : num3, (i & 65536) != 0 ? null : user, (i & 131072) != 0 ? null : user2, (i & 262144) != 0 ? null : videoSetting, (i & 524288) != 0 ? null : videoSetting2);
    }
}
