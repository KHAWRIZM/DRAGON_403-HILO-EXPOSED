package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\u0001HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u000eHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\u0001HÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0001HÆ\u0003J×\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\n2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0001HÆ\u0001J\u0013\u0010F\u001a\u00020\n2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u0005HÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010%R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010%R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010 R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010%R\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010'R\u0011\u0010\u0015\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010%R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b0\u0010'¨\u0006J"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ProfitAllocator;", "", "avatar", "", "birthday", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", "defaultAvatar", "", "description", SupportGiftRankActivity.EXTERNAL_ID, "headwear", "Lcom/qiahao/nextvideo/data/model/Headwear;", AgooConstants.MESSAGE_ID, "isAgentMgr", "isPrettyCode", "isShowAge", "isTradeUnion", "isTradeUnionMatchNotification", "isVip", "medals", "", "nick", "sex", "vipExpireTime", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;Lcom/qiahao/nextvideo/data/model/Headwear;IZZIZLjava/lang/Object;ZLjava/util/List;Ljava/lang/String;ILjava/lang/Object;)V", "getAvatar", "()Ljava/lang/String;", "getBirthday", "()I", "getCode", "getCountry", "getCountryIcon", "getDefaultAvatar", "()Z", "getDescription", "()Ljava/lang/Object;", "getExternalId", "getHeadwear", "()Lcom/qiahao/nextvideo/data/model/Headwear;", "getId", "getMedals", "()Ljava/util/List;", "getNick", "getSex", "getVipExpireTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ProfitAllocator {

    @NotNull
    private final String avatar;
    private final int birthday;

    @NotNull
    private final String code;

    @NotNull
    private final String country;

    @NotNull
    private final String countryIcon;
    private final boolean defaultAvatar;

    @NotNull
    private final Object description;

    @NotNull
    private final String externalId;

    @NotNull
    private final Headwear headwear;
    private final int id;
    private final boolean isAgentMgr;
    private final boolean isPrettyCode;
    private final int isShowAge;
    private final boolean isTradeUnion;

    @NotNull
    private final Object isTradeUnionMatchNotification;
    private final boolean isVip;

    @NotNull
    private final List<Object> medals;

    @NotNull
    private final String nick;
    private final int sex;

    @NotNull
    private final Object vipExpireTime;

    public ProfitAllocator(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull Object obj, @NotNull String str5, @NotNull Headwear headwear, int i2, boolean z2, boolean z3, int i3, boolean z4, @NotNull Object obj2, boolean z5, @NotNull List<? extends Object> list, @NotNull String str6, int i4, @NotNull Object obj3) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(obj, "description");
        Intrinsics.checkNotNullParameter(str5, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(headwear, "headwear");
        Intrinsics.checkNotNullParameter(obj2, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(list, "medals");
        Intrinsics.checkNotNullParameter(str6, "nick");
        Intrinsics.checkNotNullParameter(obj3, "vipExpireTime");
        this.avatar = str;
        this.birthday = i;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.defaultAvatar = z;
        this.description = obj;
        this.externalId = str5;
        this.headwear = headwear;
        this.id = i2;
        this.isAgentMgr = z2;
        this.isPrettyCode = z3;
        this.isShowAge = i3;
        this.isTradeUnion = z4;
        this.isTradeUnionMatchNotification = obj2;
        this.isVip = z5;
        this.medals = list;
        this.nick = str6;
        this.sex = i4;
        this.vipExpireTime = obj3;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component10, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsAgentMgr() {
        return this.isAgentMgr;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    /* renamed from: component13, reason: from getter */
    public final int getIsShowAge() {
        return this.isShowAge;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final Object getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    @NotNull
    public final List<Object> component17() {
        return this.medals;
    }

    @NotNull
    /* renamed from: component18, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component19, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBirthday() {
        return this.birthday;
    }

    @NotNull
    /* renamed from: component20, reason: from getter */
    public final Object getVipExpireTime() {
        return this.vipExpireTime;
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

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final Headwear getHeadwear() {
        return this.headwear;
    }

    @NotNull
    public final ProfitAllocator copy(@NotNull String avatar, int birthday, @NotNull String code, @NotNull String country, @NotNull String countryIcon, boolean defaultAvatar, @NotNull Object description, @NotNull String externalId, @NotNull Headwear headwear, int id2, boolean isAgentMgr, boolean isPrettyCode, int isShowAge, boolean isTradeUnion, @NotNull Object isTradeUnionMatchNotification, boolean isVip, @NotNull List<? extends Object> medals, @NotNull String nick, int sex, @NotNull Object vipExpireTime) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(headwear, "headwear");
        Intrinsics.checkNotNullParameter(isTradeUnionMatchNotification, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(medals, "medals");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(vipExpireTime, "vipExpireTime");
        return new ProfitAllocator(avatar, birthday, code, country, countryIcon, defaultAvatar, description, externalId, headwear, id2, isAgentMgr, isPrettyCode, isShowAge, isTradeUnion, isTradeUnionMatchNotification, isVip, medals, nick, sex, vipExpireTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfitAllocator)) {
            return false;
        }
        ProfitAllocator profitAllocator = (ProfitAllocator) other;
        return Intrinsics.areEqual(this.avatar, profitAllocator.avatar) && this.birthday == profitAllocator.birthday && Intrinsics.areEqual(this.code, profitAllocator.code) && Intrinsics.areEqual(this.country, profitAllocator.country) && Intrinsics.areEqual(this.countryIcon, profitAllocator.countryIcon) && this.defaultAvatar == profitAllocator.defaultAvatar && Intrinsics.areEqual(this.description, profitAllocator.description) && Intrinsics.areEqual(this.externalId, profitAllocator.externalId) && Intrinsics.areEqual(this.headwear, profitAllocator.headwear) && this.id == profitAllocator.id && this.isAgentMgr == profitAllocator.isAgentMgr && this.isPrettyCode == profitAllocator.isPrettyCode && this.isShowAge == profitAllocator.isShowAge && this.isTradeUnion == profitAllocator.isTradeUnion && Intrinsics.areEqual(this.isTradeUnionMatchNotification, profitAllocator.isTradeUnionMatchNotification) && this.isVip == profitAllocator.isVip && Intrinsics.areEqual(this.medals, profitAllocator.medals) && Intrinsics.areEqual(this.nick, profitAllocator.nick) && this.sex == profitAllocator.sex && Intrinsics.areEqual(this.vipExpireTime, profitAllocator.vipExpireTime);
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

    @NotNull
    public final Headwear getHeadwear() {
        return this.headwear;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final List<Object> getMedals() {
        return this.medals;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final Object getVipExpireTime() {
        return this.vipExpireTime;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.avatar.hashCode() * 31) + this.birthday) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + a.a(this.defaultAvatar)) * 31) + this.description.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.headwear.hashCode()) * 31) + this.id) * 31) + a.a(this.isAgentMgr)) * 31) + a.a(this.isPrettyCode)) * 31) + this.isShowAge) * 31) + a.a(this.isTradeUnion)) * 31) + this.isTradeUnionMatchNotification.hashCode()) * 31) + a.a(this.isVip)) * 31) + this.medals.hashCode()) * 31) + this.nick.hashCode()) * 31) + this.sex) * 31) + this.vipExpireTime.hashCode();
    }

    public final boolean isAgentMgr() {
        return this.isAgentMgr;
    }

    public final boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    public final int isShowAge() {
        return this.isShowAge;
    }

    public final boolean isTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    public final Object isTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    @NotNull
    public String toString() {
        return "ProfitAllocator(avatar=" + this.avatar + ", birthday=" + this.birthday + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", defaultAvatar=" + this.defaultAvatar + ", description=" + this.description + ", externalId=" + this.externalId + ", headwear=" + this.headwear + ", id=" + this.id + ", isAgentMgr=" + this.isAgentMgr + ", isPrettyCode=" + this.isPrettyCode + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", isVip=" + this.isVip + ", medals=" + this.medals + ", nick=" + this.nick + ", sex=" + this.sex + ", vipExpireTime=" + this.vipExpireTime + ")";
    }
}
