package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00108\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010'J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001cJÆ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u000eHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\u000f\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\b\u0010\u0010)R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\u0011\u0010'R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\u0012\u0010'R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b-\u0010\u001c¨\u0006E"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupRankBeanUserBase;", "", "avatar", "", "birthday", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", "defaultAvatar", "", "description", SupportGiftRankActivity.EXTERNAL_ID, AgooConstants.MESSAGE_ID, "", "isAgentMgr", "isShowAge", "isTradeUnion", "isTradeUnionMatchNotification", "isVip", "nick", "sex", "vipExpireTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/String;ILjava/lang/Long;)V", "getAvatar", "()Ljava/lang/String;", "getBirthday", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCode", "getCountry", "getCountryIcon", "getDefaultAvatar", "()Z", "getDescription", "getExternalId", "getId", "()I", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNick", "getSex", "getVipExpireTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/String;ILjava/lang/Long;)Lcom/qiahao/nextvideo/data/model/GroupRankBeanUserBase;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupRankBeanUserBase {

    @NotNull
    private final String avatar;

    @Nullable
    private final Long birthday;

    @NotNull
    private final String code;

    @NotNull
    private final String country;

    @NotNull
    private final String countryIcon;
    private final boolean defaultAvatar;

    @Nullable
    private final String description;

    @NotNull
    private final String externalId;
    private final int id;

    @Nullable
    private final Boolean isAgentMgr;

    @Nullable
    private final Integer isShowAge;

    @Nullable
    private final Boolean isTradeUnion;

    @Nullable
    private final Boolean isTradeUnionMatchNotification;
    private final boolean isVip;

    @NotNull
    private final String nick;
    private final int sex;

    @Nullable
    private final Long vipExpireTime;

    public GroupRankBeanUserBase(@NotNull String str, @Nullable Long l, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @Nullable String str5, @NotNull String str6, int i, @Nullable Boolean bool, @Nullable Integer num, @Nullable Boolean bool2, @Nullable Boolean bool3, boolean z2, @NotNull String str7, int i2, @Nullable Long l2) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(str6, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(str7, "nick");
        this.avatar = str;
        this.birthday = l;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.defaultAvatar = z;
        this.description = str5;
        this.externalId = str6;
        this.id = i;
        this.isAgentMgr = bool;
        this.isShowAge = num;
        this.isTradeUnion = bool2;
        this.isTradeUnionMatchNotification = bool3;
        this.isVip = z2;
        this.nick = str7;
        this.sex = i2;
        this.vipExpireTime = l2;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Boolean getIsAgentMgr() {
        return this.isAgentMgr;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getIsShowAge() {
        return this.isShowAge;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Boolean getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Boolean getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component16, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Long getVipExpireTime() {
        return this.vipExpireTime;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
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

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getDescription() {
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
    public final GroupRankBeanUserBase copy(@NotNull String avatar, @Nullable Long birthday, @NotNull String code, @NotNull String country, @NotNull String countryIcon, boolean defaultAvatar, @Nullable String description, @NotNull String externalId, int id2, @Nullable Boolean isAgentMgr, @Nullable Integer isShowAge, @Nullable Boolean isTradeUnion, @Nullable Boolean isTradeUnionMatchNotification, boolean isVip, @NotNull String nick, int sex, @Nullable Long vipExpireTime) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new GroupRankBeanUserBase(avatar, birthday, code, country, countryIcon, defaultAvatar, description, externalId, id2, isAgentMgr, isShowAge, isTradeUnion, isTradeUnionMatchNotification, isVip, nick, sex, vipExpireTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupRankBeanUserBase)) {
            return false;
        }
        GroupRankBeanUserBase groupRankBeanUserBase = (GroupRankBeanUserBase) other;
        return Intrinsics.areEqual(this.avatar, groupRankBeanUserBase.avatar) && Intrinsics.areEqual(this.birthday, groupRankBeanUserBase.birthday) && Intrinsics.areEqual(this.code, groupRankBeanUserBase.code) && Intrinsics.areEqual(this.country, groupRankBeanUserBase.country) && Intrinsics.areEqual(this.countryIcon, groupRankBeanUserBase.countryIcon) && this.defaultAvatar == groupRankBeanUserBase.defaultAvatar && Intrinsics.areEqual(this.description, groupRankBeanUserBase.description) && Intrinsics.areEqual(this.externalId, groupRankBeanUserBase.externalId) && this.id == groupRankBeanUserBase.id && Intrinsics.areEqual(this.isAgentMgr, groupRankBeanUserBase.isAgentMgr) && Intrinsics.areEqual(this.isShowAge, groupRankBeanUserBase.isShowAge) && Intrinsics.areEqual(this.isTradeUnion, groupRankBeanUserBase.isTradeUnion) && Intrinsics.areEqual(this.isTradeUnionMatchNotification, groupRankBeanUserBase.isTradeUnionMatchNotification) && this.isVip == groupRankBeanUserBase.isVip && Intrinsics.areEqual(this.nick, groupRankBeanUserBase.nick) && this.sex == groupRankBeanUserBase.sex && Intrinsics.areEqual(this.vipExpireTime, groupRankBeanUserBase.vipExpireTime);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Long getBirthday() {
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

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final Long getVipExpireTime() {
        return this.vipExpireTime;
    }

    public int hashCode() {
        int hashCode = this.avatar.hashCode() * 31;
        Long l = this.birthday;
        int hashCode2 = (((((((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + a.a(this.defaultAvatar)) * 31;
        String str = this.description;
        int hashCode3 = (((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.externalId.hashCode()) * 31) + this.id) * 31;
        Boolean bool = this.isAgentMgr;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.isShowAge;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool2 = this.isTradeUnion;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isTradeUnionMatchNotification;
        int hashCode7 = (((((((hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31) + a.a(this.isVip)) * 31) + this.nick.hashCode()) * 31) + this.sex) * 31;
        Long l2 = this.vipExpireTime;
        return hashCode7 + (l2 != null ? l2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isAgentMgr() {
        return this.isAgentMgr;
    }

    @Nullable
    public final Integer isShowAge() {
        return this.isShowAge;
    }

    @Nullable
    public final Boolean isTradeUnion() {
        return this.isTradeUnion;
    }

    @Nullable
    public final Boolean isTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    @NotNull
    public String toString() {
        return "GroupRankBeanUserBase(avatar=" + this.avatar + ", birthday=" + this.birthday + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", defaultAvatar=" + this.defaultAvatar + ", description=" + this.description + ", externalId=" + this.externalId + ", id=" + this.id + ", isAgentMgr=" + this.isAgentMgr + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", isVip=" + this.isVip + ", nick=" + this.nick + ", sex=" + this.sex + ", vipExpireTime=" + this.vipExpireTime + ")";
    }

    public /* synthetic */ GroupRankBeanUserBase(String str, Long l, String str2, String str3, String str4, boolean z, String str5, String str6, int i, Boolean bool, Integer num, Boolean bool2, Boolean bool3, boolean z2, String str7, int i2, Long l2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : l, str2, str3, str4, z, str5, str6, i, (i3 & 512) != 0 ? Boolean.FALSE : bool, (i3 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? 1 : num, bool2, bool3, z2, str7, i2, (i3 & 65536) != 0 ? 0L : l2);
    }
}
