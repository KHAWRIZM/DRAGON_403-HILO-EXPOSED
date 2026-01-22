package com.qiahao.nextvideo.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.common.VideoSetting;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.videocall.VideoResultActivity;
import com.qiahao.nextvideo.ui.videocall.specifyuser.VideoCallType;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;

@Parcelize
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\t\u0010A\u001a\u00020\u000bHÆ\u0003J\t\u0010B\u001a\u00020\u000bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010.J\t\u0010F\u001a\u00020\u0012HÆ\u0003J\t\u0010G\u001a\u00020\u0012HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0017HÆ\u0003J®\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010LJ\u0006\u0010M\u001a\u00020\u0012J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QHÖ\u0003J\t\u0010R\u001a\u00020\u0012HÖ\u0001J\t\u0010S\u001a\u00020\u0006HÖ\u0001J\u0016\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109¨\u0006Z"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "Landroid/os/Parcelable;", "imageUIModel", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "countryIcon", "countryName", "", "nickname", "callSpecifyType", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallType;", "fromUser", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "toUser", "answeredPreloadModel", "Lcom/qiahao/nextvideo/data/model/AnsweredPreloadModel;", "dialedPreloadModel", "Lcom/qiahao/nextvideo/data/model/DialedPreloadModel;", "gem", "", "localAgoraId", "remoteAgoraId", VideoResultActivity.VIDEO_MATCH_UNIQUE_ID, "videoSetting", "Lcom/qiahao/base_common/model/common/VideoSetting;", "otherVideoSetting", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallType;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;Lcom/qiahao/nextvideo/data/model/AnsweredPreloadModel;Lcom/qiahao/nextvideo/data/model/DialedPreloadModel;Ljava/lang/Integer;IILjava/lang/String;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getImageUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getCountryIcon", "getCountryName", "()Ljava/lang/String;", "getNickname", "getCallSpecifyType", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallType;", "getFromUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "setFromUser", "(Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getToUser", "setToUser", "getAnsweredPreloadModel", "()Lcom/qiahao/nextvideo/data/model/AnsweredPreloadModel;", "getDialedPreloadModel", "()Lcom/qiahao/nextvideo/data/model/DialedPreloadModel;", "getGem", "()Ljava/lang/Integer;", "setGem", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLocalAgoraId", "()I", "getRemoteAgoraId", "getMatchUniqueID", "getVideoSetting", "()Lcom/qiahao/base_common/model/common/VideoSetting;", "setVideoSetting", "(Lcom/qiahao/base_common/model/common/VideoSetting;)V", "getOtherVideoSetting", "setOtherVideoSetting", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallType;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;Lcom/qiahao/nextvideo/data/model/AnsweredPreloadModel;Lcom/qiahao/nextvideo/data/model/DialedPreloadModel;Ljava/lang/Integer;IILjava/lang/String;Lcom/qiahao/base_common/model/common/VideoSetting;Lcom/qiahao/base_common/model/common/VideoSetting;)Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoCallModel implements Parcelable {

    @Nullable
    private final AnsweredPreloadModel answeredPreloadModel;

    @NotNull
    private final VideoCallType callSpecifyType;

    @NotNull
    private final ImageUIModel countryIcon;

    @NotNull
    private final String countryName;

    @Nullable
    private final DialedPreloadModel dialedPreloadModel;

    @NotNull
    private UserSummaryInfo fromUser;

    @Nullable
    private Integer gem;

    @NotNull
    private final ImageUIModel imageUIModel;
    private final int localAgoraId;

    @NotNull
    private final String matchUniqueID;

    @NotNull
    private final String nickname;

    @Nullable
    private VideoSetting otherVideoSetting;
    private final int remoteAgoraId;

    @NotNull
    private UserSummaryInfo toUser;

    @Nullable
    private VideoSetting videoSetting;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<VideoCallModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoCallModel$Companion;", "", "<init>", "()V", "initInDialed", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "videoCallType", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallType;", "agoraVideoCallConfig", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "user", "Lcom/qiahao/base_common/model/common/User;", ExchangeDetailActivity.TYPE_DIAMOND, "", "initInAnswered", "video", "LuserProxy/UserProxy$Video;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VideoCallModel initInAnswered$default(Companion companion, VideoCallType videoCallType, AgoraVideoCallConfig agoraVideoCallConfig, UserProxy.Video video, int i, Object obj) {
            if ((i & 1) != 0) {
                videoCallType = VideoCallType.ANSWERED;
            }
            return companion.initInAnswered(videoCallType, agoraVideoCallConfig, video);
        }

        public static /* synthetic */ VideoCallModel initInDialed$default(Companion companion, VideoCallType videoCallType, AgoraVideoCallConfig agoraVideoCallConfig, User user, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                videoCallType = VideoCallType.DIALED;
            }
            if ((i2 & 8) != 0) {
                i = 0;
            }
            return companion.initInDialed(videoCallType, agoraVideoCallConfig, user, i);
        }

        @NotNull
        public final VideoCallModel initInAnswered(@NotNull VideoCallType videoCallType, @NotNull AgoraVideoCallConfig agoraVideoCallConfig, @NotNull UserProxy.Video video) {
            Intrinsics.checkNotNullParameter(videoCallType, "videoCallType");
            Intrinsics.checkNotNullParameter(agoraVideoCallConfig, "agoraVideoCallConfig");
            Intrinsics.checkNotNullParameter(video, "video");
            AnsweredPreloadModel answeredPreloadModel = new AnsweredPreloadModel(agoraVideoCallConfig);
            int localAgoraId = agoraVideoCallConfig.getLocalAgoraId();
            int remoteAgoraId = agoraVideoCallConfig.getRemoteAgoraId();
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            ImageUIModel full = companion.full(video.getSendUser().getAvatar());
            full.setScaleType(ImageView.ScaleType.CENTER_CROP);
            full.setPlaceholder(Integer.valueOf(R.drawable.bg_default_online_list_female_placeholder));
            ImageUIModel countryTag = companion.countryTag(video.getSendUser().getCountryIcon());
            String nick = video.getSendUser().getNick();
            Intrinsics.checkNotNullExpressionValue(nick, "getNick(...)");
            String country = video.getSendUser().getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
            UserSummaryInfo.Companion companion2 = UserSummaryInfo.INSTANCE;
            User user = UserStore.INSTANCE.getShared().getUser();
            Intrinsics.checkNotNull(user);
            UserSummaryInfo init = companion2.init(user);
            UserSummaryInfo init2 = companion2.init(video);
            String videoUID = agoraVideoCallConfig.getVideoUID();
            Intrinsics.checkNotNull(videoUID);
            return new VideoCallModel(full, countryTag, country, nick, videoCallType, init, init2, answeredPreloadModel, null, null, localAgoraId, remoteAgoraId, videoUID, agoraVideoCallConfig.getVideoSetting(), agoraVideoCallConfig.getOtherVideoSetting(), 768, null);
        }

        @NotNull
        public final VideoCallModel initInDialed(@NotNull VideoCallType videoCallType, @NotNull AgoraVideoCallConfig agoraVideoCallConfig, @NotNull User user, int diamond) {
            String str;
            String str2;
            String str3;
            Intrinsics.checkNotNullParameter(videoCallType, "videoCallType");
            Intrinsics.checkNotNullParameter(agoraVideoCallConfig, "agoraVideoCallConfig");
            Intrinsics.checkNotNullParameter(user, "user");
            DialedPreloadModel dialedPreloadModel = new DialedPreloadModel(agoraVideoCallConfig);
            int localAgoraId = agoraVideoCallConfig.getLocalAgoraId();
            int remoteAgoraId = agoraVideoCallConfig.getRemoteAgoraId();
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            ImageUIModel full = companion.full(user.getAvatar());
            full.setScaleType(ImageView.ScaleType.CENTER_CROP);
            full.setPlaceholder(Integer.valueOf(R.drawable.bg_default_online_list_female_placeholder));
            ImageUIModel countryTag = companion.countryTag(user.getCountryIcon());
            String nick = user.getNick();
            if (nick == null) {
                str = "";
            } else {
                str = nick;
            }
            String country = user.getCountry();
            if (country == null) {
                str2 = "";
            } else {
                str2 = country;
            }
            UserSummaryInfo.Companion companion2 = UserSummaryInfo.INSTANCE;
            User user2 = UserStore.INSTANCE.getShared().getUser();
            Intrinsics.checkNotNull(user2);
            UserSummaryInfo init = companion2.init(user2);
            UserSummaryInfo init2 = companion2.init(user);
            String videoUID = agoraVideoCallConfig.getVideoUID();
            if (videoUID == null) {
                str3 = "";
            } else {
                str3 = videoUID;
            }
            return new VideoCallModel(full, countryTag, str2, str, videoCallType, init, init2, null, dialedPreloadModel, Integer.valueOf(diamond), localAgoraId, remoteAgoraId, str3, agoraVideoCallConfig.getVideoSetting(), agoraVideoCallConfig.getOtherVideoSetting(), 128, null);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<VideoCallModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoCallModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Parcelable.Creator<ImageUIModel> creator = ImageUIModel.CREATOR;
            return new VideoCallModel(creator.createFromParcel(parcel), creator.createFromParcel(parcel), parcel.readString(), parcel.readString(), VideoCallType.valueOf(parcel.readString()), (UserSummaryInfo) parcel.readParcelable(VideoCallModel.class.getClassLoader()), (UserSummaryInfo) parcel.readParcelable(VideoCallModel.class.getClassLoader()), (AnsweredPreloadModel) parcel.readParcelable(VideoCallModel.class.getClassLoader()), (DialedPreloadModel) parcel.readParcelable(VideoCallModel.class.getClassLoader()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readParcelable(VideoCallModel.class.getClassLoader()), parcel.readParcelable(VideoCallModel.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoCallModel[] newArray(int i) {
            return new VideoCallModel[i];
        }
    }

    public VideoCallModel(@NotNull ImageUIModel imageUIModel, @NotNull ImageUIModel imageUIModel2, @NotNull String str, @NotNull String str2, @NotNull VideoCallType videoCallType, @NotNull UserSummaryInfo userSummaryInfo, @NotNull UserSummaryInfo userSummaryInfo2, @Nullable AnsweredPreloadModel answeredPreloadModel, @Nullable DialedPreloadModel dialedPreloadModel, @Nullable Integer num, int i, int i2, @NotNull String str3, @Nullable VideoSetting videoSetting, @Nullable VideoSetting videoSetting2) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        Intrinsics.checkNotNullParameter(imageUIModel2, "countryIcon");
        Intrinsics.checkNotNullParameter(str, "countryName");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        Intrinsics.checkNotNullParameter(videoCallType, "callSpecifyType");
        Intrinsics.checkNotNullParameter(userSummaryInfo, "fromUser");
        Intrinsics.checkNotNullParameter(userSummaryInfo2, "toUser");
        Intrinsics.checkNotNullParameter(str3, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        this.imageUIModel = imageUIModel;
        this.countryIcon = imageUIModel2;
        this.countryName = str;
        this.nickname = str2;
        this.callSpecifyType = videoCallType;
        this.fromUser = userSummaryInfo;
        this.toUser = userSummaryInfo2;
        this.answeredPreloadModel = answeredPreloadModel;
        this.dialedPreloadModel = dialedPreloadModel;
        this.gem = num;
        this.localAgoraId = i;
        this.remoteAgoraId = i2;
        this.matchUniqueID = str3;
        this.videoSetting = videoSetting;
        this.otherVideoSetting = videoSetting2;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getGem() {
        return this.gem;
    }

    /* renamed from: component11, reason: from getter */
    public final int getLocalAgoraId() {
        return this.localAgoraId;
    }

    /* renamed from: component12, reason: from getter */
    public final int getRemoteAgoraId() {
        return this.remoteAgoraId;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
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
    public final ImageUIModel getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final VideoCallType getCallSpecifyType() {
        return this.callSpecifyType;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final UserSummaryInfo getFromUser() {
        return this.fromUser;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final UserSummaryInfo getToUser() {
        return this.toUser;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final AnsweredPreloadModel getAnsweredPreloadModel() {
        return this.answeredPreloadModel;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final DialedPreloadModel getDialedPreloadModel() {
        return this.dialedPreloadModel;
    }

    @NotNull
    public final VideoCallModel copy(@NotNull ImageUIModel imageUIModel, @NotNull ImageUIModel countryIcon, @NotNull String countryName, @NotNull String nickname, @NotNull VideoCallType callSpecifyType, @NotNull UserSummaryInfo fromUser, @NotNull UserSummaryInfo toUser, @Nullable AnsweredPreloadModel answeredPreloadModel, @Nullable DialedPreloadModel dialedPreloadModel, @Nullable Integer gem, int localAgoraId, int remoteAgoraId, @NotNull String matchUniqueID, @Nullable VideoSetting videoSetting, @Nullable VideoSetting otherVideoSetting) {
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(countryName, "countryName");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(callSpecifyType, "callSpecifyType");
        Intrinsics.checkNotNullParameter(fromUser, "fromUser");
        Intrinsics.checkNotNullParameter(toUser, "toUser");
        Intrinsics.checkNotNullParameter(matchUniqueID, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        return new VideoCallModel(imageUIModel, countryIcon, countryName, nickname, callSpecifyType, fromUser, toUser, answeredPreloadModel, dialedPreloadModel, gem, localAgoraId, remoteAgoraId, matchUniqueID, videoSetting, otherVideoSetting);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoCallModel)) {
            return false;
        }
        VideoCallModel videoCallModel = (VideoCallModel) other;
        return Intrinsics.areEqual(this.imageUIModel, videoCallModel.imageUIModel) && Intrinsics.areEqual(this.countryIcon, videoCallModel.countryIcon) && Intrinsics.areEqual(this.countryName, videoCallModel.countryName) && Intrinsics.areEqual(this.nickname, videoCallModel.nickname) && this.callSpecifyType == videoCallModel.callSpecifyType && Intrinsics.areEqual(this.fromUser, videoCallModel.fromUser) && Intrinsics.areEqual(this.toUser, videoCallModel.toUser) && Intrinsics.areEqual(this.answeredPreloadModel, videoCallModel.answeredPreloadModel) && Intrinsics.areEqual(this.dialedPreloadModel, videoCallModel.dialedPreloadModel) && Intrinsics.areEqual(this.gem, videoCallModel.gem) && this.localAgoraId == videoCallModel.localAgoraId && this.remoteAgoraId == videoCallModel.remoteAgoraId && Intrinsics.areEqual(this.matchUniqueID, videoCallModel.matchUniqueID) && Intrinsics.areEqual(this.videoSetting, videoCallModel.videoSetting) && Intrinsics.areEqual(this.otherVideoSetting, videoCallModel.otherVideoSetting);
    }

    @Nullable
    public final AnsweredPreloadModel getAnsweredPreloadModel() {
        return this.answeredPreloadModel;
    }

    @NotNull
    public final VideoCallType getCallSpecifyType() {
        return this.callSpecifyType;
    }

    @NotNull
    public final ImageUIModel getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    public final String getCountryName() {
        return this.countryName;
    }

    @Nullable
    public final DialedPreloadModel getDialedPreloadModel() {
        return this.dialedPreloadModel;
    }

    @NotNull
    public final UserSummaryInfo getFromUser() {
        return this.fromUser;
    }

    @Nullable
    public final Integer getGem() {
        return this.gem;
    }

    @NotNull
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    public final int getLocalAgoraId() {
        return this.localAgoraId;
    }

    @NotNull
    public final String getMatchUniqueID() {
        return this.matchUniqueID;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final VideoSetting getOtherVideoSetting() {
        return this.otherVideoSetting;
    }

    public final int getRemoteAgoraId() {
        return this.remoteAgoraId;
    }

    @NotNull
    public final UserSummaryInfo getToUser() {
        return this.toUser;
    }

    @Nullable
    public final VideoSetting getVideoSetting() {
        return this.videoSetting;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.imageUIModel.hashCode() * 31) + this.countryIcon.hashCode()) * 31) + this.countryName.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.callSpecifyType.hashCode()) * 31) + this.fromUser.hashCode()) * 31) + this.toUser.hashCode()) * 31;
        AnsweredPreloadModel answeredPreloadModel = this.answeredPreloadModel;
        int hashCode2 = (hashCode + (answeredPreloadModel == null ? 0 : answeredPreloadModel.hashCode())) * 31;
        DialedPreloadModel dialedPreloadModel = this.dialedPreloadModel;
        int hashCode3 = (hashCode2 + (dialedPreloadModel == null ? 0 : dialedPreloadModel.hashCode())) * 31;
        Integer num = this.gem;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + this.localAgoraId) * 31) + this.remoteAgoraId) * 31) + this.matchUniqueID.hashCode()) * 31;
        VideoSetting videoSetting = this.videoSetting;
        int hashCode5 = (hashCode4 + (videoSetting == null ? 0 : videoSetting.hashCode())) * 31;
        VideoSetting videoSetting2 = this.otherVideoSetting;
        return hashCode5 + (videoSetting2 != null ? videoSetting2.hashCode() : 0);
    }

    public final void setFromUser(@NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "<set-?>");
        this.fromUser = userSummaryInfo;
    }

    public final void setGem(@Nullable Integer num) {
        this.gem = num;
    }

    public final void setOtherVideoSetting(@Nullable VideoSetting videoSetting) {
        this.otherVideoSetting = videoSetting;
    }

    public final void setToUser(@NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "<set-?>");
        this.toUser = userSummaryInfo;
    }

    public final void setVideoSetting(@Nullable VideoSetting videoSetting) {
        this.videoSetting = videoSetting;
    }

    @NotNull
    public String toString() {
        return "VideoCallModel(imageUIModel=" + this.imageUIModel + ", countryIcon=" + this.countryIcon + ", countryName=" + this.countryName + ", nickname=" + this.nickname + ", callSpecifyType=" + this.callSpecifyType + ", fromUser=" + this.fromUser + ", toUser=" + this.toUser + ", answeredPreloadModel=" + this.answeredPreloadModel + ", dialedPreloadModel=" + this.dialedPreloadModel + ", gem=" + this.gem + ", localAgoraId=" + this.localAgoraId + ", remoteAgoraId=" + this.remoteAgoraId + ", matchUniqueID=" + this.matchUniqueID + ", videoSetting=" + this.videoSetting + ", otherVideoSetting=" + this.otherVideoSetting + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        int intValue;
        Intrinsics.checkNotNullParameter(dest, "dest");
        this.imageUIModel.writeToParcel(dest, flags);
        this.countryIcon.writeToParcel(dest, flags);
        dest.writeString(this.countryName);
        dest.writeString(this.nickname);
        dest.writeString(this.callSpecifyType.name());
        dest.writeParcelable(this.fromUser, flags);
        dest.writeParcelable(this.toUser, flags);
        dest.writeParcelable(this.answeredPreloadModel, flags);
        dest.writeParcelable(this.dialedPreloadModel, flags);
        Integer num = this.gem;
        if (num == null) {
            intValue = 0;
        } else {
            dest.writeInt(1);
            intValue = num.intValue();
        }
        dest.writeInt(intValue);
        dest.writeInt(this.localAgoraId);
        dest.writeInt(this.remoteAgoraId);
        dest.writeString(this.matchUniqueID);
        dest.writeParcelable(this.videoSetting, flags);
        dest.writeParcelable(this.otherVideoSetting, flags);
    }

    public /* synthetic */ VideoCallModel(ImageUIModel imageUIModel, ImageUIModel imageUIModel2, String str, String str2, VideoCallType videoCallType, UserSummaryInfo userSummaryInfo, UserSummaryInfo userSummaryInfo2, AnsweredPreloadModel answeredPreloadModel, DialedPreloadModel dialedPreloadModel, Integer num, int i, int i2, String str3, VideoSetting videoSetting, VideoSetting videoSetting2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageUIModel, imageUIModel2, str, str2, videoCallType, userSummaryInfo, userSummaryInfo2, (i3 & 128) != 0 ? null : answeredPreloadModel, (i3 & 256) != 0 ? null : dialedPreloadModel, (i3 & 512) != 0 ? 0 : num, i, i2, str3, (i3 & 8192) != 0 ? null : videoSetting, (i3 & 16384) != 0 ? null : videoSetting2);
    }
}
