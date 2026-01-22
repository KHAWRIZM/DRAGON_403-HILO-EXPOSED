package com.qiahao.nextvideo.ui.im;

import android.os.Parcel;
import android.os.Parcelable;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.ui.home.onlinefeed.list.OnlineCellUIModel;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.ForeverHeartUIModel;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0001OB\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u000fHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J\t\u0010>\u001a\u00020\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u0013HÆ\u0003J\t\u0010@\u001a\u00020\u0015HÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J«\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001J\u0006\u0010D\u001a\u00020\u0007J\u0013\u0010E\u001a\u00020\u000f2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0007HÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\u0016\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010&\"\u0004\b)\u0010(R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010&\"\u0004\b*\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010&\"\u0004\b2\u0010(¨\u0006P"}, d2 = {"Lcom/qiahao/nextvideo/ui/im/ChatPreloadModel;", "Landroid/os/Parcelable;", "uid", "", "nickname", "profilePictureUrl", "sex", "", Constants.KEY_HTTP_CODE, "description", "age", "country", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "countryName", "isLike", "", "isLikeMe", "isFreeMessage", TUIChatConstants.CHAT_INFO, "Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "foreverHeartUIModel", "Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;", "showLikeEachOtherBalloon", "isOfficialStaff", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/String;ZZZLcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;ZZ)V", "getUid", "()Ljava/lang/String;", "getNickname", "getProfilePictureUrl", "getSex", "()I", "getCode", "getDescription", "getAge", "getCountry", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getCountryName", "()Z", "setLike", "(Z)V", "setLikeMe", "setFreeMessage", "getChatInfo", "()Lcom/tencent/qcloud/tuikit/tuichat/bean/ChatInfo;", "getForeverHeartUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;", "setForeverHeartUIModel", "(Lcom/qiahao/nextvideo/ui/reusable/views/ForeverHeartUIModel;)V", "getShowLikeEachOtherBalloon", "setOfficialStaff", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ChatPreloadModel implements Parcelable {

    @NotNull
    public static final String keyPreloadModel = "keyPreloadModel";

    @Nullable
    private final String age;

    @NotNull
    private final ChatInfo chatInfo;

    @NotNull
    private final String code;

    @NotNull
    private final ImageUIModel country;

    @NotNull
    private final String countryName;

    @NotNull
    private final String description;

    @NotNull
    private ForeverHeartUIModel foreverHeartUIModel;
    private boolean isFreeMessage;
    private boolean isLike;
    private boolean isLikeMe;
    private boolean isOfficialStaff;

    @NotNull
    private final String nickname;

    @NotNull
    private final String profilePictureUrl;
    private final int sex;
    private final boolean showLikeEachOtherBalloon;

    @NotNull
    private final String uid;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<ChatPreloadModel> CREATOR = new Creator();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\f2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/im/ChatPreloadModel$Companion;", "", "<init>", "()V", "keyPreloadModel", "", "init", "Lcom/qiahao/nextvideo/ui/im/ChatPreloadModel;", "uiModel", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel;", "showLikeEachOtherBalloon", "", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ChatPreloadModel init$default(Companion companion, OnlineCellUIModel onlineCellUIModel, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.init(onlineCellUIModel, z);
        }

        @NotNull
        public final ChatPreloadModel init(@NotNull OnlineCellUIModel uiModel, boolean showLikeEachOtherBalloon) {
            Intrinsics.checkNotNullParameter(uiModel, "uiModel");
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setId(uiModel.getUid());
            chatInfo.setType(1);
            chatInfo.setChatName(uiModel.getNickname());
            String uid = uiModel.getUid();
            String nickname = uiModel.getNickname();
            String imageUrl = uiModel.getThumbnail().getImageUrl();
            if (imageUrl == null) {
                imageUrl = "";
            }
            return new ChatPreloadModel(uid, nickname, imageUrl, uiModel.getSex(), uiModel.getCode(), uiModel.getDescription(), uiModel.getAge(), uiModel.getCountry(), uiModel.getCountryName(), uiModel.isLiked(), uiModel.isLikeMe(), uiModel.isFreeMessage(), chatInfo, uiModel.getForeverHeartUIModel(), showLikeEachOtherBalloon, uiModel.isOfficialStaff());
        }

        private Companion() {
        }

        public static /* synthetic */ ChatPreloadModel init$default(Companion companion, ProfileDetailUIModel profileDetailUIModel, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.init(profileDetailUIModel, z);
        }

        @NotNull
        public final ChatPreloadModel init(@NotNull ProfileDetailUIModel uiModel, boolean showLikeEachOtherBalloon) {
            Intrinsics.checkNotNullParameter(uiModel, "uiModel");
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setId(uiModel.getUid());
            chatInfo.setType(1);
            chatInfo.setChatName(uiModel.getNickname());
            String uid = uiModel.getUid();
            String nickname = uiModel.getNickname();
            String imageUrl = uiModel.getImageUIModel().getImageUrl();
            String str = imageUrl == null ? "" : imageUrl;
            int sex = uiModel.getSex();
            String code = uiModel.getCode();
            String description = uiModel.getDescription();
            return new ChatPreloadModel(uid, nickname, str, sex, code, description == null ? "" : description, uiModel.getAge(), uiModel.getCountryImageUIModel(), uiModel.getCountryName(), uiModel.isLike(), uiModel.isLikeMe(), uiModel.isFreeMessage(), chatInfo, ForeverHeartUIModel.INSTANCE.init(uiModel.getHeartPer()), showLikeEachOtherBalloon, uiModel.isOfficialStaff());
        }

        @NotNull
        public final ChatPreloadModel init(@NotNull User user) {
            Intrinsics.checkNotNullParameter(user, "user");
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setId(user.getExternalId());
            chatInfo.setType(1);
            chatInfo.setChatName(user.getNick());
            String externalId = user.getExternalId();
            String nick = user.getNick();
            String str = nick == null ? "" : nick;
            String avatar = user.getAvatar();
            String str2 = avatar == null ? "" : avatar;
            int sex = user.getSex();
            String code = user.getCode();
            String description = user.getDescription();
            String str3 = description == null ? "" : description;
            String age = user.getAge();
            ImageUIModel full = ImageUIModel.INSTANCE.full(user.getCountryIcon());
            String country = user.getCountry();
            String str4 = country == null ? "" : country;
            Boolean isLike = user.isLike();
            Boolean bool = Boolean.TRUE;
            return new ChatPreloadModel(externalId, str, str2, sex, code, str3, age, full, str4, Intrinsics.areEqual(isLike, bool), Intrinsics.areEqual(user.isLikeMe(), bool), Intrinsics.areEqual(user.isSession(), bool), chatInfo, ForeverHeartUIModel.INSTANCE.init(user), false, user.isOfficialStaff(), 16384, null);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Creator implements Parcelable.Creator<ChatPreloadModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChatPreloadModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChatPreloadModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), ImageUIModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, (ChatInfo) parcel.readSerializable(), ForeverHeartUIModel.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChatPreloadModel[] newArray(int i) {
            return new ChatPreloadModel[i];
        }
    }

    public ChatPreloadModel(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, @NotNull String str5, @Nullable String str6, @NotNull ImageUIModel imageUIModel, @NotNull String str7, boolean z, boolean z2, boolean z3, @NotNull ChatInfo chatInfo, @NotNull ForeverHeartUIModel foreverHeartUIModel, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "uid");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        Intrinsics.checkNotNullParameter(str3, "profilePictureUrl");
        Intrinsics.checkNotNullParameter(str4, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str5, "description");
        Intrinsics.checkNotNullParameter(imageUIModel, "country");
        Intrinsics.checkNotNullParameter(str7, "countryName");
        Intrinsics.checkNotNullParameter(chatInfo, TUIChatConstants.CHAT_INFO);
        Intrinsics.checkNotNullParameter(foreverHeartUIModel, "foreverHeartUIModel");
        this.uid = str;
        this.nickname = str2;
        this.profilePictureUrl = str3;
        this.sex = i;
        this.code = str4;
        this.description = str5;
        this.age = str6;
        this.country = imageUIModel;
        this.countryName = str7;
        this.isLike = z;
        this.isLikeMe = z2;
        this.isFreeMessage = z3;
        this.chatInfo = chatInfo;
        this.foreverHeartUIModel = foreverHeartUIModel;
        this.showLikeEachOtherBalloon = z4;
        this.isOfficialStaff = z5;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsFreeMessage() {
        return this.isFreeMessage;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final ForeverHeartUIModel getForeverHeartUIModel() {
        return this.foreverHeartUIModel;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getShowLikeEachOtherBalloon() {
        return this.showLikeEachOtherBalloon;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getIsOfficialStaff() {
        return this.isOfficialStaff;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getProfilePictureUrl() {
        return this.profilePictureUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getAge() {
        return this.age;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final ImageUIModel getCountry() {
        return this.country;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    @NotNull
    public final ChatPreloadModel copy(@NotNull String uid, @NotNull String nickname, @NotNull String profilePictureUrl, int sex, @NotNull String code, @NotNull String description, @Nullable String age, @NotNull ImageUIModel country, @NotNull String countryName, boolean isLike, boolean isLikeMe, boolean isFreeMessage, @NotNull ChatInfo chatInfo, @NotNull ForeverHeartUIModel foreverHeartUIModel, boolean showLikeEachOtherBalloon, boolean isOfficialStaff) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(profilePictureUrl, "profilePictureUrl");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryName, "countryName");
        Intrinsics.checkNotNullParameter(chatInfo, TUIChatConstants.CHAT_INFO);
        Intrinsics.checkNotNullParameter(foreverHeartUIModel, "foreverHeartUIModel");
        return new ChatPreloadModel(uid, nickname, profilePictureUrl, sex, code, description, age, country, countryName, isLike, isLikeMe, isFreeMessage, chatInfo, foreverHeartUIModel, showLikeEachOtherBalloon, isOfficialStaff);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatPreloadModel)) {
            return false;
        }
        ChatPreloadModel chatPreloadModel = (ChatPreloadModel) other;
        return Intrinsics.areEqual(this.uid, chatPreloadModel.uid) && Intrinsics.areEqual(this.nickname, chatPreloadModel.nickname) && Intrinsics.areEqual(this.profilePictureUrl, chatPreloadModel.profilePictureUrl) && this.sex == chatPreloadModel.sex && Intrinsics.areEqual(this.code, chatPreloadModel.code) && Intrinsics.areEqual(this.description, chatPreloadModel.description) && Intrinsics.areEqual(this.age, chatPreloadModel.age) && Intrinsics.areEqual(this.country, chatPreloadModel.country) && Intrinsics.areEqual(this.countryName, chatPreloadModel.countryName) && this.isLike == chatPreloadModel.isLike && this.isLikeMe == chatPreloadModel.isLikeMe && this.isFreeMessage == chatPreloadModel.isFreeMessage && Intrinsics.areEqual(this.chatInfo, chatPreloadModel.chatInfo) && Intrinsics.areEqual(this.foreverHeartUIModel, chatPreloadModel.foreverHeartUIModel) && this.showLikeEachOtherBalloon == chatPreloadModel.showLikeEachOtherBalloon && this.isOfficialStaff == chatPreloadModel.isOfficialStaff;
    }

    @Nullable
    public final String getAge() {
        return this.age;
    }

    @NotNull
    public final ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final ImageUIModel getCountry() {
        return this.country;
    }

    @NotNull
    public final String getCountryName() {
        return this.countryName;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final ForeverHeartUIModel getForeverHeartUIModel() {
        return this.foreverHeartUIModel;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @NotNull
    public final String getProfilePictureUrl() {
        return this.profilePictureUrl;
    }

    public final int getSex() {
        return this.sex;
    }

    public final boolean getShowLikeEachOtherBalloon() {
        return this.showLikeEachOtherBalloon;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.uid.hashCode() * 31) + this.nickname.hashCode()) * 31) + this.profilePictureUrl.hashCode()) * 31) + this.sex) * 31) + this.code.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.age;
        return ((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.country.hashCode()) * 31) + this.countryName.hashCode()) * 31) + q2.a.a(this.isLike)) * 31) + q2.a.a(this.isLikeMe)) * 31) + q2.a.a(this.isFreeMessage)) * 31) + this.chatInfo.hashCode()) * 31) + this.foreverHeartUIModel.hashCode()) * 31) + q2.a.a(this.showLikeEachOtherBalloon)) * 31) + q2.a.a(this.isOfficialStaff);
    }

    public final boolean isFreeMessage() {
        return this.isFreeMessage;
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final boolean isLikeMe() {
        return this.isLikeMe;
    }

    public final boolean isOfficialStaff() {
        return this.isOfficialStaff;
    }

    public final void setForeverHeartUIModel(@NotNull ForeverHeartUIModel foreverHeartUIModel) {
        Intrinsics.checkNotNullParameter(foreverHeartUIModel, "<set-?>");
        this.foreverHeartUIModel = foreverHeartUIModel;
    }

    public final void setFreeMessage(boolean z) {
        this.isFreeMessage = z;
    }

    public final void setLike(boolean z) {
        this.isLike = z;
    }

    public final void setLikeMe(boolean z) {
        this.isLikeMe = z;
    }

    public final void setOfficialStaff(boolean z) {
        this.isOfficialStaff = z;
    }

    @NotNull
    public String toString() {
        return "ChatPreloadModel(uid=" + this.uid + ", nickname=" + this.nickname + ", profilePictureUrl=" + this.profilePictureUrl + ", sex=" + this.sex + ", code=" + this.code + ", description=" + this.description + ", age=" + this.age + ", country=" + this.country + ", countryName=" + this.countryName + ", isLike=" + this.isLike + ", isLikeMe=" + this.isLikeMe + ", isFreeMessage=" + this.isFreeMessage + ", chatInfo=" + this.chatInfo + ", foreverHeartUIModel=" + this.foreverHeartUIModel + ", showLikeEachOtherBalloon=" + this.showLikeEachOtherBalloon + ", isOfficialStaff=" + this.isOfficialStaff + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.uid);
        dest.writeString(this.nickname);
        dest.writeString(this.profilePictureUrl);
        dest.writeInt(this.sex);
        dest.writeString(this.code);
        dest.writeString(this.description);
        dest.writeString(this.age);
        this.country.writeToParcel(dest, flags);
        dest.writeString(this.countryName);
        dest.writeInt(this.isLike ? 1 : 0);
        dest.writeInt(this.isLikeMe ? 1 : 0);
        dest.writeInt(this.isFreeMessage ? 1 : 0);
        dest.writeSerializable(this.chatInfo);
        this.foreverHeartUIModel.writeToParcel(dest, flags);
        dest.writeInt(this.showLikeEachOtherBalloon ? 1 : 0);
        dest.writeInt(this.isOfficialStaff ? 1 : 0);
    }

    public /* synthetic */ ChatPreloadModel(String str, String str2, String str3, int i, String str4, String str5, String str6, ImageUIModel imageUIModel, String str7, boolean z, boolean z2, boolean z3, ChatInfo chatInfo, ForeverHeartUIModel foreverHeartUIModel, boolean z4, boolean z5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, str4, str5, str6, imageUIModel, str7, z, z2, z3, chatInfo, foreverHeartUIModel, (i2 & 16384) != 0 ? false : z4, (i2 & 32768) != 0 ? false : z5);
    }
}
