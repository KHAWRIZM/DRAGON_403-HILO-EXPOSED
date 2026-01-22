package com.qiahao.nextvideo.ui.conversation;

import androidx.annotation.Keep;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.model.ConversationItem;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.imsdk.v2.V2TIMElem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010D\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010%J\t\u0010G\u001a\u00020\nHÆ\u0003J\t\u0010H\u001a\u00020\u0013HÆ\u0003J\t\u0010I\u001a\u00020\u0013HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u009e\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\nHÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010&\u001a\u0004\b.\u0010%R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b/\u0010%\"\u0004\b0\u00101R\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00107\"\u0004\b8\u00109R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006R"}, d2 = {"Lcom/qiahao/nextvideo/ui/conversation/ConversationCellUIModel;", "", "uid", "", "nickname", "lastMessageContent", "Lcom/tencent/imsdk/v2/V2TIMElem;", "imageUIModel", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "conversationType", "", "receivedTimeInSecs", "", "user", "Lcom/qiahao/base_common/model/common/User;", "heartPercentDrawableRes", "heartPer", "imOnlineStatus", "enableHeartProgressIcon", "", "isVip", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/imsdk/v2/V2TIMElem;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/Integer;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;IZZLcom/qiahao/base_common/model/common/NobleInfo;)V", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "getNickname", "getLastMessageContent", "()Lcom/tencent/imsdk/v2/V2TIMElem;", "setLastMessageContent", "(Lcom/tencent/imsdk/v2/V2TIMElem;)V", "getImageUIModel", "()Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", "getConversationType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReceivedTimeInSecs", "()Ljava/lang/Long;", "setReceivedTimeInSecs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "getHeartPercentDrawableRes", "getHeartPer", "setHeartPer", "(Ljava/lang/Integer;)V", "getImOnlineStatus", "()I", "setImOnlineStatus", "(I)V", "getEnableHeartProgressIcon", "()Z", "setVip", "(Z)V", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/imsdk/v2/V2TIMElem;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Ljava/lang/Integer;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Integer;Ljava/lang/Integer;IZZLcom/qiahao/base_common/model/common/NobleInfo;)Lcom/qiahao/nextvideo/ui/conversation/ConversationCellUIModel;", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ConversationCellUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Integer conversationType;
    private final boolean enableHeartProgressIcon;

    @Nullable
    private Integer heartPer;

    @Nullable
    private final Integer heartPercentDrawableRes;
    private int imOnlineStatus;

    @NotNull
    private final ImageUIModel imageUIModel;
    private boolean isVip;

    @Nullable
    private V2TIMElem lastMessageContent;

    @NotNull
    private final String nickname;

    @Nullable
    private NobleInfo noble;

    @Nullable
    private Long receivedTimeInSecs;

    @NotNull
    private String uid;

    @Nullable
    private final User user;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/conversation/ConversationCellUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/ui/conversation/ConversationCellUIModel;", "conversationItem", "Lcom/qiahao/nextvideo/data/model/ConversationItem;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ConversationCellUIModel init(@NotNull ConversationItem conversationItem) {
            String str;
            String nick;
            Intrinsics.checkNotNullParameter(conversationItem, "conversationItem");
            User user = conversationItem.getUser();
            if (user != null) {
                user.setHeartValue(conversationItem.getHeartValue());
                user.setHeartValueMax(conversationItem.getHeartValueMax());
                String externalId = user.getExternalId();
                if (externalId != null) {
                    str = externalId;
                    User user2 = conversationItem.getUser();
                    String str2 = (user2 != null || (nick = user2.getNick()) == null) ? "" : nick;
                    ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                    User user3 = conversationItem.getUser();
                    String avatar = user3 == null ? user3.getAvatar() : null;
                    ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
                    Dimens dimens = Dimens.INSTANCE;
                    lfit.setWidth(dimens.dpToPx(45));
                    lfit.setHeight(dimens.dpToPx(45));
                    Unit unit = Unit.INSTANCE;
                    ImageUIModel displayUserAvatarImage = companion.displayUserAvatarImage(avatar, lfit);
                    User user4 = conversationItem.getUser();
                    int heartPer = conversationItem.getHeartPer();
                    int imOnlineStatus = conversationItem.getImOnlineStatus();
                    boolean z = conversationItem.getHeartValueMax() <= 0;
                    User user5 = conversationItem.getUser();
                    boolean isVip = user5 == null ? user5.isVip() : false;
                    User user6 = conversationItem.getUser();
                    return new ConversationCellUIModel(str, str2, null, displayUserAvatarImage, 1, null, user4, null, Integer.valueOf(heartPer), imOnlineStatus, z, isVip, user6 == null ? user6.getNoble() : null, UserProxyUtility.h5GameVoice, null);
                }
            }
            str = "";
            User user22 = conversationItem.getUser();
            if (user22 != null) {
            }
            ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
            User user32 = conversationItem.getUser();
            if (user32 == null) {
            }
            ResizeMode.LFIT lfit2 = ResizeMode.LFIT.INSTANCE;
            Dimens dimens2 = Dimens.INSTANCE;
            lfit2.setWidth(dimens2.dpToPx(45));
            lfit2.setHeight(dimens2.dpToPx(45));
            Unit unit2 = Unit.INSTANCE;
            ImageUIModel displayUserAvatarImage2 = companion2.displayUserAvatarImage(avatar, lfit2);
            User user42 = conversationItem.getUser();
            int heartPer2 = conversationItem.getHeartPer();
            int imOnlineStatus2 = conversationItem.getImOnlineStatus();
            if (conversationItem.getHeartValueMax() <= 0) {
            }
            User user52 = conversationItem.getUser();
            if (user52 == null) {
            }
            User user62 = conversationItem.getUser();
            return new ConversationCellUIModel(str, str2, null, displayUserAvatarImage2, 1, null, user42, null, Integer.valueOf(heartPer2), imOnlineStatus2, z, isVip, user62 == null ? user62.getNoble() : null, UserProxyUtility.h5GameVoice, null);
        }

        private Companion() {
        }

        @NotNull
        public final ConversationCellUIModel init(@NotNull User user) {
            Intrinsics.checkNotNullParameter(user, "user");
            String externalId = user.getExternalId();
            String nick = user.getNick();
            if (nick == null) {
                nick = "";
            }
            String str = nick;
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String avatar = user.getAvatar();
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            lfit.setWidth(dimens.dpToPx(45));
            lfit.setHeight(dimens.dpToPx(45));
            Unit unit = Unit.INSTANCE;
            return new ConversationCellUIModel(externalId, str, null, companion.displayUserAvatarImage(avatar, lfit), 1, null, user, null, Integer.valueOf(user.getHeartPer()), 2, user.getHeartValueMax() > 0, user.isVip(), user.getNoble(), UserProxyUtility.h5GameVoice, null);
        }
    }

    public ConversationCellUIModel(@NotNull String str, @NotNull String str2, @Nullable V2TIMElem v2TIMElem, @NotNull ImageUIModel imageUIModel, @Nullable Integer num, @Nullable Long l, @Nullable User user, @Nullable Integer num2, @Nullable Integer num3, int i, boolean z, boolean z2, @Nullable NobleInfo nobleInfo) {
        Intrinsics.checkNotNullParameter(str, "uid");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        this.uid = str;
        this.nickname = str2;
        this.lastMessageContent = v2TIMElem;
        this.imageUIModel = imageUIModel;
        this.conversationType = num;
        this.receivedTimeInSecs = l;
        this.user = user;
        this.heartPercentDrawableRes = num2;
        this.heartPer = num3;
        this.imOnlineStatus = i;
        this.enableHeartProgressIcon = z;
        this.isVip = z2;
        this.noble = nobleInfo;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component10, reason: from getter */
    public final int getImOnlineStatus() {
        return this.imOnlineStatus;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getEnableHeartProgressIcon() {
        return this.enableHeartProgressIcon;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final V2TIMElem getLastMessageContent() {
        return this.lastMessageContent;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getConversationType() {
        return this.conversationType;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getReceivedTimeInSecs() {
        return this.receivedTimeInSecs;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getHeartPercentDrawableRes() {
        return this.heartPercentDrawableRes;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getHeartPer() {
        return this.heartPer;
    }

    @NotNull
    public final ConversationCellUIModel copy(@NotNull String uid, @NotNull String nickname, @Nullable V2TIMElem lastMessageContent, @NotNull ImageUIModel imageUIModel, @Nullable Integer conversationType, @Nullable Long receivedTimeInSecs, @Nullable User user, @Nullable Integer heartPercentDrawableRes, @Nullable Integer heartPer, int imOnlineStatus, boolean enableHeartProgressIcon, boolean isVip, @Nullable NobleInfo noble) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(imageUIModel, "imageUIModel");
        return new ConversationCellUIModel(uid, nickname, lastMessageContent, imageUIModel, conversationType, receivedTimeInSecs, user, heartPercentDrawableRes, heartPer, imOnlineStatus, enableHeartProgressIcon, isVip, noble);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationCellUIModel)) {
            return false;
        }
        ConversationCellUIModel conversationCellUIModel = (ConversationCellUIModel) other;
        return Intrinsics.areEqual(this.uid, conversationCellUIModel.uid) && Intrinsics.areEqual(this.nickname, conversationCellUIModel.nickname) && Intrinsics.areEqual(this.lastMessageContent, conversationCellUIModel.lastMessageContent) && Intrinsics.areEqual(this.imageUIModel, conversationCellUIModel.imageUIModel) && Intrinsics.areEqual(this.conversationType, conversationCellUIModel.conversationType) && Intrinsics.areEqual(this.receivedTimeInSecs, conversationCellUIModel.receivedTimeInSecs) && Intrinsics.areEqual(this.user, conversationCellUIModel.user) && Intrinsics.areEqual(this.heartPercentDrawableRes, conversationCellUIModel.heartPercentDrawableRes) && Intrinsics.areEqual(this.heartPer, conversationCellUIModel.heartPer) && this.imOnlineStatus == conversationCellUIModel.imOnlineStatus && this.enableHeartProgressIcon == conversationCellUIModel.enableHeartProgressIcon && this.isVip == conversationCellUIModel.isVip && Intrinsics.areEqual(this.noble, conversationCellUIModel.noble);
    }

    @Nullable
    public final Integer getConversationType() {
        return this.conversationType;
    }

    public final boolean getEnableHeartProgressIcon() {
        return this.enableHeartProgressIcon;
    }

    @Nullable
    public final Integer getHeartPer() {
        return this.heartPer;
    }

    @Nullable
    public final Integer getHeartPercentDrawableRes() {
        return this.heartPercentDrawableRes;
    }

    public final int getImOnlineStatus() {
        return this.imOnlineStatus;
    }

    @NotNull
    public final ImageUIModel getImageUIModel() {
        return this.imageUIModel;
    }

    @Nullable
    public final V2TIMElem getLastMessageContent() {
        return this.lastMessageContent;
    }

    @NotNull
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    public final Long getReceivedTimeInSecs() {
        return this.receivedTimeInSecs;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = ((this.uid.hashCode() * 31) + this.nickname.hashCode()) * 31;
        V2TIMElem v2TIMElem = this.lastMessageContent;
        int hashCode2 = (((hashCode + (v2TIMElem == null ? 0 : v2TIMElem.hashCode())) * 31) + this.imageUIModel.hashCode()) * 31;
        Integer num = this.conversationType;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.receivedTimeInSecs;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        User user = this.user;
        int hashCode5 = (hashCode4 + (user == null ? 0 : user.hashCode())) * 31;
        Integer num2 = this.heartPercentDrawableRes;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.heartPer;
        int hashCode7 = (((((((hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.imOnlineStatus) * 31) + a.a(this.enableHeartProgressIcon)) * 31) + a.a(this.isVip)) * 31;
        NobleInfo nobleInfo = this.noble;
        return hashCode7 + (nobleInfo != null ? nobleInfo.hashCode() : 0);
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setHeartPer(@Nullable Integer num) {
        this.heartPer = num;
    }

    public final void setImOnlineStatus(int i) {
        this.imOnlineStatus = i;
    }

    public final void setLastMessageContent(@Nullable V2TIMElem v2TIMElem) {
        this.lastMessageContent = v2TIMElem;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setReceivedTimeInSecs(@Nullable Long l) {
        this.receivedTimeInSecs = l;
    }

    public final void setUid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uid = str;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    @NotNull
    public String toString() {
        return "ConversationCellUIModel(uid=" + this.uid + ", nickname=" + this.nickname + ", lastMessageContent=" + this.lastMessageContent + ", imageUIModel=" + this.imageUIModel + ", conversationType=" + this.conversationType + ", receivedTimeInSecs=" + this.receivedTimeInSecs + ", user=" + this.user + ", heartPercentDrawableRes=" + this.heartPercentDrawableRes + ", heartPer=" + this.heartPer + ", imOnlineStatus=" + this.imOnlineStatus + ", enableHeartProgressIcon=" + this.enableHeartProgressIcon + ", isVip=" + this.isVip + ", noble=" + this.noble + ")";
    }

    public /* synthetic */ ConversationCellUIModel(String str, String str2, V2TIMElem v2TIMElem, ImageUIModel imageUIModel, Integer num, Long l, User user, Integer num2, Integer num3, int i, boolean z, boolean z2, NobleInfo nobleInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? null : v2TIMElem, imageUIModel, num, (i2 & 32) != 0 ? null : l, (i2 & 64) != 0 ? null : user, (i2 & 128) != 0 ? null : num2, (i2 & 256) != 0 ? null : num3, (i2 & 512) != 0 ? 0 : i, z, z2, (i2 & 4096) != 0 ? null : nobleInfo);
    }
}
