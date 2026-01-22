package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.cp.TextStyles;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bJ\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\nHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u000fHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003JÚ\u0001\u0010]\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010^J\u0013\u0010_\u001a\u00020\u00062\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020\u000fHÖ\u0001J\t\u0010b\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001d\"\u0004\bA\u0010\u001fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\bB\u0010<\"\u0004\bC\u0010>R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001d\"\u0004\bE\u0010\u001fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001d\"\u0004\bG\u0010\u001fR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserInRoom;", "", "nick", "", SupportGiftRankActivity.EXTERNAL_ID, "isVip", "", "rideEffectUrl", "rideUrl", "rideId", "", "ridSenderAvatar", "ridReceiverAvatar", "userAvatar", "nobleLevel", "", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "cpLevel", "cpUserAvatar", "entryEffectType", "rideSenderNick", "rideReceiverNick", "rideTextStyleList", "", "Lcom/qiahao/base_common/model/cp/TextStyles;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getNick", "()Ljava/lang/String;", "setNick", "(Ljava/lang/String;)V", "getExternalId", "setExternalId", "()Z", "setVip", "(Z)V", "getRideEffectUrl", "setRideEffectUrl", "getRideUrl", "setRideUrl", "getRideId", "()J", "setRideId", "(J)V", "getRidSenderAvatar", "setRidSenderAvatar", "getRidReceiverAvatar", "setRidReceiverAvatar", "getUserAvatar", "setUserAvatar", "getNobleLevel", "()I", "setNobleLevel", "(I)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getCpLevel", "()Ljava/lang/Integer;", "setCpLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCpUserAvatar", "setCpUserAvatar", "getEntryEffectType", "setEntryEffectType", "getRideSenderNick", "setRideSenderNick", "getRideReceiverNick", "setRideReceiverNick", "getRideTextStyleList", "()Ljava/util/List;", "setRideTextStyleList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/qiahao/nextvideo/data/model/UserInRoom;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserInRoom {

    @Nullable
    private Integer cpLevel;

    @Nullable
    private String cpUserAvatar;

    @Nullable
    private Integer entryEffectType;

    @Nullable
    private String externalId;
    private boolean isVip;

    @Nullable
    private String nick;
    private int nobleLevel;

    @Nullable
    private String ridReceiverAvatar;

    @Nullable
    private String ridSenderAvatar;

    @Nullable
    private String rideEffectUrl;
    private long rideId;

    @Nullable
    private String rideReceiverNick;

    @Nullable
    private String rideSenderNick;

    @Nullable
    private List<TextStyles> rideTextStyleList;

    @Nullable
    private String rideUrl;

    @Nullable
    private SvipData svip;

    @Nullable
    private String userAvatar;

    public UserInRoom(@Nullable String str, @Nullable String str2, boolean z, @Nullable String str3, @Nullable String str4, long j, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i, @Nullable SvipData svipData, @Nullable Integer num, @Nullable String str8, @Nullable Integer num2, @Nullable String str9, @Nullable String str10, @Nullable List<TextStyles> list) {
        this.nick = str;
        this.externalId = str2;
        this.isVip = z;
        this.rideEffectUrl = str3;
        this.rideUrl = str4;
        this.rideId = j;
        this.ridSenderAvatar = str5;
        this.ridReceiverAvatar = str6;
        this.userAvatar = str7;
        this.nobleLevel = i;
        this.svip = svipData;
        this.cpLevel = num;
        this.cpUserAvatar = str8;
        this.entryEffectType = num2;
        this.rideSenderNick = str9;
        this.rideReceiverNick = str10;
        this.rideTextStyleList = list;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component10, reason: from getter */
    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getCpUserAvatar() {
        return this.cpUserAvatar;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Integer getEntryEffectType() {
        return this.entryEffectType;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getRideSenderNick() {
        return this.rideSenderNick;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getRideReceiverNick() {
        return this.rideReceiverNick;
    }

    @Nullable
    public final List<TextStyles> component17() {
        return this.rideTextStyleList;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getRideEffectUrl() {
        return this.rideEffectUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getRideUrl() {
        return this.rideUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final long getRideId() {
        return this.rideId;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getRidSenderAvatar() {
        return this.ridSenderAvatar;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getRidReceiverAvatar() {
        return this.ridReceiverAvatar;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    @NotNull
    public final UserInRoom copy(@Nullable String nick, @Nullable String externalId, boolean isVip, @Nullable String rideEffectUrl, @Nullable String rideUrl, long rideId, @Nullable String ridSenderAvatar, @Nullable String ridReceiverAvatar, @Nullable String userAvatar, int nobleLevel, @Nullable SvipData svip, @Nullable Integer cpLevel, @Nullable String cpUserAvatar, @Nullable Integer entryEffectType, @Nullable String rideSenderNick, @Nullable String rideReceiverNick, @Nullable List<TextStyles> rideTextStyleList) {
        return new UserInRoom(nick, externalId, isVip, rideEffectUrl, rideUrl, rideId, ridSenderAvatar, ridReceiverAvatar, userAvatar, nobleLevel, svip, cpLevel, cpUserAvatar, entryEffectType, rideSenderNick, rideReceiverNick, rideTextStyleList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInRoom)) {
            return false;
        }
        UserInRoom userInRoom = (UserInRoom) other;
        return Intrinsics.areEqual(this.nick, userInRoom.nick) && Intrinsics.areEqual(this.externalId, userInRoom.externalId) && this.isVip == userInRoom.isVip && Intrinsics.areEqual(this.rideEffectUrl, userInRoom.rideEffectUrl) && Intrinsics.areEqual(this.rideUrl, userInRoom.rideUrl) && this.rideId == userInRoom.rideId && Intrinsics.areEqual(this.ridSenderAvatar, userInRoom.ridSenderAvatar) && Intrinsics.areEqual(this.ridReceiverAvatar, userInRoom.ridReceiverAvatar) && Intrinsics.areEqual(this.userAvatar, userInRoom.userAvatar) && this.nobleLevel == userInRoom.nobleLevel && Intrinsics.areEqual(this.svip, userInRoom.svip) && Intrinsics.areEqual(this.cpLevel, userInRoom.cpLevel) && Intrinsics.areEqual(this.cpUserAvatar, userInRoom.cpUserAvatar) && Intrinsics.areEqual(this.entryEffectType, userInRoom.entryEffectType) && Intrinsics.areEqual(this.rideSenderNick, userInRoom.rideSenderNick) && Intrinsics.areEqual(this.rideReceiverNick, userInRoom.rideReceiverNick) && Intrinsics.areEqual(this.rideTextStyleList, userInRoom.rideTextStyleList);
    }

    @Nullable
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final String getCpUserAvatar() {
        return this.cpUserAvatar;
    }

    @Nullable
    public final Integer getEntryEffectType() {
        return this.entryEffectType;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final String getRidReceiverAvatar() {
        return this.ridReceiverAvatar;
    }

    @Nullable
    public final String getRidSenderAvatar() {
        return this.ridSenderAvatar;
    }

    @Nullable
    public final String getRideEffectUrl() {
        return this.rideEffectUrl;
    }

    public final long getRideId() {
        return this.rideId;
    }

    @Nullable
    public final String getRideReceiverNick() {
        return this.rideReceiverNick;
    }

    @Nullable
    public final String getRideSenderNick() {
        return this.rideSenderNick;
    }

    @Nullable
    public final List<TextStyles> getRideTextStyleList() {
        return this.rideTextStyleList;
    }

    @Nullable
    public final String getRideUrl() {
        return this.rideUrl;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    public int hashCode() {
        String str = this.nick;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.externalId;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + a.a(this.isVip)) * 31;
        String str3 = this.rideEffectUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rideUrl;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + c.a(this.rideId)) * 31;
        String str5 = this.ridSenderAvatar;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ridReceiverAvatar;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.userAvatar;
        int hashCode7 = (((hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.nobleLevel) * 31;
        SvipData svipData = this.svip;
        int hashCode8 = (hashCode7 + (svipData == null ? 0 : svipData.hashCode())) * 31;
        Integer num = this.cpLevel;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str8 = this.cpUserAvatar;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num2 = this.entryEffectType;
        int hashCode11 = (hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str9 = this.rideSenderNick;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.rideReceiverNick;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<TextStyles> list = this.rideTextStyleList;
        return hashCode13 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setCpLevel(@Nullable Integer num) {
        this.cpLevel = num;
    }

    public final void setCpUserAvatar(@Nullable String str) {
        this.cpUserAvatar = str;
    }

    public final void setEntryEffectType(@Nullable Integer num) {
        this.entryEffectType = num;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setNobleLevel(int i) {
        this.nobleLevel = i;
    }

    public final void setRidReceiverAvatar(@Nullable String str) {
        this.ridReceiverAvatar = str;
    }

    public final void setRidSenderAvatar(@Nullable String str) {
        this.ridSenderAvatar = str;
    }

    public final void setRideEffectUrl(@Nullable String str) {
        this.rideEffectUrl = str;
    }

    public final void setRideId(long j) {
        this.rideId = j;
    }

    public final void setRideReceiverNick(@Nullable String str) {
        this.rideReceiverNick = str;
    }

    public final void setRideSenderNick(@Nullable String str) {
        this.rideSenderNick = str;
    }

    public final void setRideTextStyleList(@Nullable List<TextStyles> list) {
        this.rideTextStyleList = list;
    }

    public final void setRideUrl(@Nullable String str) {
        this.rideUrl = str;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setUserAvatar(@Nullable String str) {
        this.userAvatar = str;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    @NotNull
    public String toString() {
        return "UserInRoom(nick=" + this.nick + ", externalId=" + this.externalId + ", isVip=" + this.isVip + ", rideEffectUrl=" + this.rideEffectUrl + ", rideUrl=" + this.rideUrl + ", rideId=" + this.rideId + ", ridSenderAvatar=" + this.ridSenderAvatar + ", ridReceiverAvatar=" + this.ridReceiverAvatar + ", userAvatar=" + this.userAvatar + ", nobleLevel=" + this.nobleLevel + ", svip=" + this.svip + ", cpLevel=" + this.cpLevel + ", cpUserAvatar=" + this.cpUserAvatar + ", entryEffectType=" + this.entryEffectType + ", rideSenderNick=" + this.rideSenderNick + ", rideReceiverNick=" + this.rideReceiverNick + ", rideTextStyleList=" + this.rideTextStyleList + ")";
    }

    public /* synthetic */ UserInRoom(String str, String str2, boolean z, String str3, String str4, long j, String str5, String str6, String str7, int i, SvipData svipData, Integer num, String str8, Integer num2, String str9, String str10, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? 0L : j, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? 0 : i, (i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : svipData, (i2 & 2048) != 0 ? null : num, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? null : num2, (i2 & 16384) != 0 ? "" : str9, (32768 & i2) != 0 ? "" : str10, (i2 & 65536) != 0 ? null : list);
    }
}
