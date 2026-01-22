package com.qiahao.nextvideo.utilities.animation;

import androidx.annotation.Keep;
import com.qiahao.nextvideo.data.model.VideoCallModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b&\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010#\u001a\u00020\u0005J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003Je\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\rHÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001b\"\u0004\b\"\u0010\u001d¨\u00063"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "", AgooConstants.MESSAGE_ID, "", "fromNickname", "", "toNickname", "count", "senderPicture", "giftIcon", "isMystery", "", "nobleLevel", "", "isSame", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZIZ)V", "getId", "()J", "getFromNickname", "()Ljava/lang/String;", "getToNickname", "getCount", "setCount", "(J)V", "getSenderPicture", "getGiftIcon", "()Z", "setMystery", "(Z)V", "getNobleLevel", "()I", "setNobleLevel", "(I)V", "setSame", "getDataId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GiftNoticeUIModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long count;

    @NotNull
    private final String fromNickname;

    @NotNull
    private final String giftIcon;
    private final long id;
    private boolean isMystery;
    private boolean isSame;
    private int nobleLevel;

    @Nullable
    private final String senderPicture;

    @NotNull
    private final String toNickname;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010J<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0007¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "giftId", "", "giftIcon", "", "preloadModel", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "isSender", "", "count", "nobleLevel", "", "Lcom/qiahao/nextvideo/data/model/VideoCallModel;", "user", "LuserProxy/UserProxy$User;", "toUser", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GiftNoticeUIModel init(long giftId, @NotNull String giftIcon, @NotNull VideoCallPreloadModel preloadModel, boolean isSender, long count, int nobleLevel) {
            String toNickname;
            String fromNickname;
            String imageUrl;
            String str;
            Intrinsics.checkNotNullParameter(giftIcon, "giftIcon");
            Intrinsics.checkNotNullParameter(preloadModel, "preloadModel");
            String str2 = (!isSender ? (toNickname = preloadModel.getToNickname()) == null : (toNickname = preloadModel.getFromNickname()) == null) ? toNickname : "";
            String str3 = (!isSender ? (fromNickname = preloadModel.getFromNickname()) == null : (fromNickname = preloadModel.getToNickname()) == null) ? fromNickname : "";
            if (isSender) {
                ImageUIModel fromUserPicture = preloadModel.getFromUserPicture();
                if (fromUserPicture != null) {
                    imageUrl = fromUserPicture.getImageUrl();
                    str = imageUrl;
                }
                str = null;
            } else {
                ImageUIModel toUserPicture = preloadModel.getToUserPicture();
                if (toUserPicture != null) {
                    imageUrl = toUserPicture.getImageUrl();
                    str = imageUrl;
                }
                str = null;
            }
            return new GiftNoticeUIModel(giftId, str2, str3, count, str, giftIcon, false, nobleLevel, false, 320, null);
        }

        private Companion() {
        }

        @NotNull
        public final GiftNoticeUIModel init(long giftId, @NotNull String giftIcon, @NotNull VideoCallModel preloadModel, boolean isSender, long count, int nobleLevel) {
            String name;
            String name2;
            String avatar;
            Intrinsics.checkNotNullParameter(giftIcon, "giftIcon");
            Intrinsics.checkNotNullParameter(preloadModel, "preloadModel");
            String str = (!isSender ? (name = preloadModel.getToUser().getName()) == null : (name = preloadModel.getFromUser().getName()) == null) ? name : "";
            String str2 = (!isSender ? (name2 = preloadModel.getFromUser().getName()) == null : (name2 = preloadModel.getToUser().getName()) == null) ? name2 : "";
            if (isSender) {
                avatar = preloadModel.getFromUser().getAvatar();
            } else {
                avatar = preloadModel.getToUser().getAvatar();
            }
            return new GiftNoticeUIModel(giftId, str, str2, count, avatar, giftIcon, false, nobleLevel, false, 320, null);
        }

        @NotNull
        public final GiftNoticeUIModel init(long giftId, @NotNull String giftIcon, @Nullable UserProxy.User user, @Nullable UserProxy.User toUser, long count) {
            String avatar;
            String nick;
            String nick2;
            Intrinsics.checkNotNullParameter(giftIcon, "giftIcon");
            return new GiftNoticeUIModel(giftId, (user == null || (nick2 = user.getNick()) == null) ? "" : nick2, (toUser == null || (nick = toUser.getNick()) == null) ? "" : nick, count, (user == null || (avatar = user.getAvatar()) == null) ? "" : avatar, giftIcon, false, 0, false, 448, null);
        }
    }

    public GiftNoticeUIModel(long j, @NotNull String str, @NotNull String str2, long j2, @Nullable String str3, @NotNull String str4, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "fromNickname");
        Intrinsics.checkNotNullParameter(str2, "toNickname");
        Intrinsics.checkNotNullParameter(str4, "giftIcon");
        this.id = j;
        this.fromNickname = str;
        this.toNickname = str2;
        this.count = j2;
        this.senderPicture = str3;
        this.giftIcon = str4;
        this.isMystery = z;
        this.nobleLevel = i;
        this.isSame = z2;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFromNickname() {
        return this.fromNickname;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getToNickname() {
        return this.toNickname;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCount() {
        return this.count;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getSenderPicture() {
        return this.senderPicture;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getGiftIcon() {
        return this.giftIcon;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsMystery() {
        return this.isMystery;
    }

    /* renamed from: component8, reason: from getter */
    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsSame() {
        return this.isSame;
    }

    @NotNull
    public final GiftNoticeUIModel copy(long id2, @NotNull String fromNickname, @NotNull String toNickname, long count, @Nullable String senderPicture, @NotNull String giftIcon, boolean isMystery, int nobleLevel, boolean isSame) {
        Intrinsics.checkNotNullParameter(fromNickname, "fromNickname");
        Intrinsics.checkNotNullParameter(toNickname, "toNickname");
        Intrinsics.checkNotNullParameter(giftIcon, "giftIcon");
        return new GiftNoticeUIModel(id2, fromNickname, toNickname, count, senderPicture, giftIcon, isMystery, nobleLevel, isSame);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GiftNoticeUIModel)) {
            return false;
        }
        GiftNoticeUIModel giftNoticeUIModel = (GiftNoticeUIModel) other;
        return this.id == giftNoticeUIModel.id && Intrinsics.areEqual(this.fromNickname, giftNoticeUIModel.fromNickname) && Intrinsics.areEqual(this.toNickname, giftNoticeUIModel.toNickname) && this.count == giftNoticeUIModel.count && Intrinsics.areEqual(this.senderPicture, giftNoticeUIModel.senderPicture) && Intrinsics.areEqual(this.giftIcon, giftNoticeUIModel.giftIcon) && this.isMystery == giftNoticeUIModel.isMystery && this.nobleLevel == giftNoticeUIModel.nobleLevel && this.isSame == giftNoticeUIModel.isSame;
    }

    public final long getCount() {
        return this.count;
    }

    @NotNull
    public final String getDataId() {
        return this.id + "_" + this.fromNickname + "_" + this.toNickname;
    }

    @NotNull
    public final String getFromNickname() {
        return this.fromNickname;
    }

    @NotNull
    public final String getGiftIcon() {
        return this.giftIcon;
    }

    public final long getId() {
        return this.id;
    }

    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final String getSenderPicture() {
        return this.senderPicture;
    }

    @NotNull
    public final String getToNickname() {
        return this.toNickname;
    }

    public int hashCode() {
        int a = ((((((androidx.collection.c.a(this.id) * 31) + this.fromNickname.hashCode()) * 31) + this.toNickname.hashCode()) * 31) + androidx.collection.c.a(this.count)) * 31;
        String str = this.senderPicture;
        return ((((((((a + (str == null ? 0 : str.hashCode())) * 31) + this.giftIcon.hashCode()) * 31) + q2.a.a(this.isMystery)) * 31) + this.nobleLevel) * 31) + q2.a.a(this.isSame);
    }

    public final boolean isMystery() {
        return this.isMystery;
    }

    public final boolean isSame() {
        return this.isSame;
    }

    public final void setCount(long j) {
        this.count = j;
    }

    public final void setMystery(boolean z) {
        this.isMystery = z;
    }

    public final void setNobleLevel(int i) {
        this.nobleLevel = i;
    }

    public final void setSame(boolean z) {
        this.isSame = z;
    }

    @NotNull
    public String toString() {
        return "GiftNoticeUIModel(id=" + this.id + ", fromNickname=" + this.fromNickname + ", toNickname=" + this.toNickname + ", count=" + this.count + ", senderPicture=" + this.senderPicture + ", giftIcon=" + this.giftIcon + ", isMystery=" + this.isMystery + ", nobleLevel=" + this.nobleLevel + ", isSame=" + this.isSame + ")";
    }

    public /* synthetic */ GiftNoticeUIModel(long j, String str, String str2, long j2, String str3, String str4, boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, j2, (i2 & 16) != 0 ? null : str3, str4, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? false : z2);
    }
}
