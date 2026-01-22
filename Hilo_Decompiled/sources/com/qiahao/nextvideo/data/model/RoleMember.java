package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\bQ\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\nHÆ\u0003J\t\u0010W\u001a\u00020\fHÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\fHÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\fHÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\nHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010GJ\u000b\u0010d\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jæ\u0001\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010gJ\u0013\u0010h\u001a\u00020\n2\b\u0010i\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010j\u001a\u00020\u0005HÖ\u0001J\t\u0010k\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u00102\"\u0004\b9\u00104R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010$\"\u0004\b:\u0010&R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u00102\"\u0004\b;\u00104R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u00102\"\u0004\b<\u00104R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010.\"\u0004\bE\u00100R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\"¨\u0006l"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RoleMember;", "Ljava/io/Serializable;", "avatar", "", "birthday", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", "defaultAvatar", "", "description", "", SupportGiftRankActivity.EXTERNAL_ID, AgooConstants.MESSAGE_ID, "isAgentMgr", "isShowAge", "isTradeUnion", "isTradeUnionMatchNotification", "nick", "onlineStatus", "role", "sex", "isVip", "vipExpireTime", "", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "groupHeadwear", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;ILjava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;IIIZLjava/lang/Long;Lcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getBirthday", "()I", "setBirthday", "(I)V", "getCode", "setCode", "getCountry", "setCountry", "getCountryIcon", "setCountryIcon", "getDefaultAvatar", "()Z", "setDefaultAvatar", "(Z)V", "getDescription", "()Ljava/lang/Object;", "setDescription", "(Ljava/lang/Object;)V", "getExternalId", "setExternalId", "getId", "setId", "setAgentMgr", "setShowAge", "setTradeUnion", "setTradeUnionMatchNotification", "getNick", "setNick", "getOnlineStatus", "setOnlineStatus", "getRole", "setRole", "getSex", "setSex", "setVip", "getVipExpireTime", "()Ljava/lang/Long;", "setVipExpireTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "getGroupHeadwear", "setGroupHeadwear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;ILjava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;IIIZLjava/lang/Long;Lcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/RoleMember;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoleMember implements Serializable {

    @NotNull
    private String avatar;
    private int birthday;

    @NotNull
    private String code;

    @NotNull
    private String country;

    @NotNull
    private String countryIcon;
    private boolean defaultAvatar;

    @NotNull
    private Object description;

    @NotNull
    private String externalId;

    @Nullable
    private String groupHeadwear;
    private int id;

    @NotNull
    private Object isAgentMgr;
    private int isShowAge;

    @NotNull
    private Object isTradeUnion;

    @NotNull
    private Object isTradeUnionMatchNotification;
    private boolean isVip;

    @NotNull
    private String nick;

    @Nullable
    private NobleInfo noble;
    private int onlineStatus;
    private int role;
    private int sex;

    @Nullable
    private Long vipExpireTime;

    public RoleMember(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull Object obj, @NotNull String str5, int i2, @NotNull Object obj2, int i3, @NotNull Object obj3, @NotNull Object obj4, @NotNull String str6, int i4, int i5, int i6, boolean z2, @Nullable Long l, @Nullable NobleInfo nobleInfo, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(obj, "description");
        Intrinsics.checkNotNullParameter(str5, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(obj2, "isAgentMgr");
        Intrinsics.checkNotNullParameter(obj3, "isTradeUnion");
        Intrinsics.checkNotNullParameter(obj4, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(str6, "nick");
        this.avatar = str;
        this.birthday = i;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.defaultAvatar = z;
        this.description = obj;
        this.externalId = str5;
        this.id = i2;
        this.isAgentMgr = obj2;
        this.isShowAge = i3;
        this.isTradeUnion = obj3;
        this.isTradeUnionMatchNotification = obj4;
        this.nick = str6;
        this.onlineStatus = i4;
        this.role = i5;
        this.sex = i6;
        this.isVip = z2;
        this.vipExpireTime = l;
        this.noble = nobleInfo;
        this.groupHeadwear = str7;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final Object getIsAgentMgr() {
        return this.isAgentMgr;
    }

    /* renamed from: component11, reason: from getter */
    public final int getIsShowAge() {
        return this.isShowAge;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final Object getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final Object getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component15, reason: from getter */
    public final int getOnlineStatus() {
        return this.onlineStatus;
    }

    /* renamed from: component16, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    /* renamed from: component17, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Long getVipExpireTime() {
        return this.vipExpireTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBirthday() {
        return this.birthday;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final String getGroupHeadwear() {
        return this.groupHeadwear;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final Object getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component9, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    public final RoleMember copy(@NotNull String avatar, int birthday, @NotNull String code, @NotNull String country, @NotNull String countryIcon, boolean defaultAvatar, @NotNull Object description, @NotNull String externalId, int id2, @NotNull Object isAgentMgr, int isShowAge, @NotNull Object isTradeUnion, @NotNull Object isTradeUnionMatchNotification, @NotNull String nick, int onlineStatus, int role, int sex, boolean isVip, @Nullable Long vipExpireTime, @Nullable NobleInfo noble, @Nullable String groupHeadwear) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(isAgentMgr, "isAgentMgr");
        Intrinsics.checkNotNullParameter(isTradeUnion, "isTradeUnion");
        Intrinsics.checkNotNullParameter(isTradeUnionMatchNotification, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new RoleMember(avatar, birthday, code, country, countryIcon, defaultAvatar, description, externalId, id2, isAgentMgr, isShowAge, isTradeUnion, isTradeUnionMatchNotification, nick, onlineStatus, role, sex, isVip, vipExpireTime, noble, groupHeadwear);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleMember)) {
            return false;
        }
        RoleMember roleMember = (RoleMember) other;
        return Intrinsics.areEqual(this.avatar, roleMember.avatar) && this.birthday == roleMember.birthday && Intrinsics.areEqual(this.code, roleMember.code) && Intrinsics.areEqual(this.country, roleMember.country) && Intrinsics.areEqual(this.countryIcon, roleMember.countryIcon) && this.defaultAvatar == roleMember.defaultAvatar && Intrinsics.areEqual(this.description, roleMember.description) && Intrinsics.areEqual(this.externalId, roleMember.externalId) && this.id == roleMember.id && Intrinsics.areEqual(this.isAgentMgr, roleMember.isAgentMgr) && this.isShowAge == roleMember.isShowAge && Intrinsics.areEqual(this.isTradeUnion, roleMember.isTradeUnion) && Intrinsics.areEqual(this.isTradeUnionMatchNotification, roleMember.isTradeUnionMatchNotification) && Intrinsics.areEqual(this.nick, roleMember.nick) && this.onlineStatus == roleMember.onlineStatus && this.role == roleMember.role && this.sex == roleMember.sex && this.isVip == roleMember.isVip && Intrinsics.areEqual(this.vipExpireTime, roleMember.vipExpireTime) && Intrinsics.areEqual(this.noble, roleMember.noble) && Intrinsics.areEqual(this.groupHeadwear, roleMember.groupHeadwear);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    public final int getBirthday() {
        return this.birthday;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    public final Object getDescription() {
        return this.description;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getGroupHeadwear() {
        return this.groupHeadwear;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    public final int getOnlineStatus() {
        return this.onlineStatus;
    }

    public final int getRole() {
        return this.role;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final Long getVipExpireTime() {
        return this.vipExpireTime;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((this.avatar.hashCode() * 31) + this.birthday) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + a.a(this.defaultAvatar)) * 31) + this.description.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.id) * 31) + this.isAgentMgr.hashCode()) * 31) + this.isShowAge) * 31) + this.isTradeUnion.hashCode()) * 31) + this.isTradeUnionMatchNotification.hashCode()) * 31) + this.nick.hashCode()) * 31) + this.onlineStatus) * 31) + this.role) * 31) + this.sex) * 31) + a.a(this.isVip)) * 31;
        Long l = this.vipExpireTime;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode3 = (hashCode2 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31;
        String str = this.groupHeadwear;
        return hashCode3 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public final Object isAgentMgr() {
        return this.isAgentMgr;
    }

    public final int isShowAge() {
        return this.isShowAge;
    }

    @NotNull
    public final Object isTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    public final Object isTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setAgentMgr(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.isAgentMgr = obj;
    }

    public final void setAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setBirthday(int i) {
        this.birthday = i;
    }

    public final void setCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final void setCountry(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.country = str;
    }

    public final void setCountryIcon(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.countryIcon = str;
    }

    public final void setDefaultAvatar(boolean z) {
        this.defaultAvatar = z;
    }

    public final void setDescription(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.description = obj;
    }

    public final void setExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.externalId = str;
    }

    public final void setGroupHeadwear(@Nullable String str) {
        this.groupHeadwear = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setNick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setOnlineStatus(int i) {
        this.onlineStatus = i;
    }

    public final void setRole(int i) {
        this.role = i;
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final void setShowAge(int i) {
        this.isShowAge = i;
    }

    public final void setTradeUnion(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.isTradeUnion = obj;
    }

    public final void setTradeUnionMatchNotification(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.isTradeUnionMatchNotification = obj;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    public final void setVipExpireTime(@Nullable Long l) {
        this.vipExpireTime = l;
    }

    @NotNull
    public String toString() {
        return "RoleMember(avatar=" + this.avatar + ", birthday=" + this.birthday + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", defaultAvatar=" + this.defaultAvatar + ", description=" + this.description + ", externalId=" + this.externalId + ", id=" + this.id + ", isAgentMgr=" + this.isAgentMgr + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", nick=" + this.nick + ", onlineStatus=" + this.onlineStatus + ", role=" + this.role + ", sex=" + this.sex + ", isVip=" + this.isVip + ", vipExpireTime=" + this.vipExpireTime + ", noble=" + this.noble + ", groupHeadwear=" + this.groupHeadwear + ")";
    }

    public /* synthetic */ RoleMember(String str, int i, String str2, String str3, String str4, boolean z, Object obj, String str5, int i2, Object obj2, int i3, Object obj3, Object obj4, String str6, int i4, int i5, int i6, boolean z2, Long l, NobleInfo nobleInfo, String str7, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, str3, str4, z, obj, str5, i2, obj2, i3, obj3, obj4, str6, i4, i5, i6, (i7 & 131072) != 0 ? false : z2, (i7 & 262144) != 0 ? 0L : l, (i7 & 524288) != 0 ? null : nobleInfo, (i7 & AgoraRtcService.CUSTOM_REMOTE_VIDEO_IDLE) != 0 ? null : str7);
    }
}
