package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b?\b\u0086\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\rHÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\t\u0010?\u001a\u00020\u0001HÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\u0001HÆ\u0003J\t\u0010B\u001a\u00020\u0001HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003JÚ\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\rHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0013\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010.R\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010(R\u0011\u0010\u0015\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010.R\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010.R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\u0019\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AgentMgrConnectionLogRecordBean;", "", "avatar", "", "birthday", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", "defaultAvatar", "", "description", "diamondBalance", "", "diamondIncome", "duration", SupportGiftRankActivity.EXTERNAL_ID, "frequency", AgooConstants.MESSAGE_ID, "isAgentMgr", "isShowAge", "isTradeUnion", "isTradeUnionMatchNotification", "nick", "sex", "likeMeCount", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIILjava/lang/String;IILjava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;II)V", "getAvatar", "()Ljava/lang/String;", "getBirthday", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCode", "getCountry", "getCountryIcon", "getDefaultAvatar", "()Z", "getDescription", "getDiamondBalance", "()I", "getDiamondIncome", "getDuration", "getExternalId", "getFrequency", "getId", "()Ljava/lang/Object;", "getNick", "getSex", "getLikeMeCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIILjava/lang/String;IILjava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/String;II)Lcom/qiahao/nextvideo/data/model/AgentMgrConnectionLogRecordBean;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AgentMgrConnectionLogRecordBean {

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

    @c("diamond_balance")
    private final int diamondBalance;

    @c("diamond_income")
    private final int diamondIncome;
    private final int duration;

    @NotNull
    private final String externalId;
    private final int frequency;
    private final int id;

    @NotNull
    private final Object isAgentMgr;
    private final int isShowAge;

    @NotNull
    private final Object isTradeUnion;

    @NotNull
    private final Object isTradeUnionMatchNotification;
    private final int likeMeCount;

    @NotNull
    private final String nick;
    private final int sex;

    public AgentMgrConnectionLogRecordBean(@NotNull String str, @Nullable Long l, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @Nullable String str5, int i, int i2, int i3, @NotNull String str6, int i4, int i5, @NotNull Object obj, int i6, @NotNull Object obj2, @NotNull Object obj3, @NotNull String str7, int i7, int i8) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(str6, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(obj, "isAgentMgr");
        Intrinsics.checkNotNullParameter(obj2, "isTradeUnion");
        Intrinsics.checkNotNullParameter(obj3, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(str7, "nick");
        this.avatar = str;
        this.birthday = l;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.defaultAvatar = z;
        this.description = str5;
        this.diamondBalance = i;
        this.diamondIncome = i2;
        this.duration = i3;
        this.externalId = str6;
        this.frequency = i4;
        this.id = i5;
        this.isAgentMgr = obj;
        this.isShowAge = i6;
        this.isTradeUnion = obj2;
        this.isTradeUnionMatchNotification = obj3;
        this.nick = str7;
        this.sex = i7;
        this.likeMeCount = i8;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component10, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component12, reason: from getter */
    public final int getFrequency() {
        return this.frequency;
    }

    /* renamed from: component13, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final Object getIsAgentMgr() {
        return this.isAgentMgr;
    }

    /* renamed from: component15, reason: from getter */
    public final int getIsShowAge() {
        return this.isShowAge;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final Object getIsTradeUnion() {
        return this.isTradeUnion;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final Object getIsTradeUnionMatchNotification() {
        return this.isTradeUnionMatchNotification;
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

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
    }

    /* renamed from: component20, reason: from getter */
    public final int getLikeMeCount() {
        return this.likeMeCount;
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

    /* renamed from: component8, reason: from getter */
    public final int getDiamondBalance() {
        return this.diamondBalance;
    }

    /* renamed from: component9, reason: from getter */
    public final int getDiamondIncome() {
        return this.diamondIncome;
    }

    @NotNull
    public final AgentMgrConnectionLogRecordBean copy(@NotNull String avatar, @Nullable Long birthday, @NotNull String code, @NotNull String country, @NotNull String countryIcon, boolean defaultAvatar, @Nullable String description, int diamondBalance, int diamondIncome, int duration, @NotNull String externalId, int frequency, int id2, @NotNull Object isAgentMgr, int isShowAge, @NotNull Object isTradeUnion, @NotNull Object isTradeUnionMatchNotification, @NotNull String nick, int sex, int likeMeCount) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(isAgentMgr, "isAgentMgr");
        Intrinsics.checkNotNullParameter(isTradeUnion, "isTradeUnion");
        Intrinsics.checkNotNullParameter(isTradeUnionMatchNotification, "isTradeUnionMatchNotification");
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new AgentMgrConnectionLogRecordBean(avatar, birthday, code, country, countryIcon, defaultAvatar, description, diamondBalance, diamondIncome, duration, externalId, frequency, id2, isAgentMgr, isShowAge, isTradeUnion, isTradeUnionMatchNotification, nick, sex, likeMeCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentMgrConnectionLogRecordBean)) {
            return false;
        }
        AgentMgrConnectionLogRecordBean agentMgrConnectionLogRecordBean = (AgentMgrConnectionLogRecordBean) other;
        return Intrinsics.areEqual(this.avatar, agentMgrConnectionLogRecordBean.avatar) && Intrinsics.areEqual(this.birthday, agentMgrConnectionLogRecordBean.birthday) && Intrinsics.areEqual(this.code, agentMgrConnectionLogRecordBean.code) && Intrinsics.areEqual(this.country, agentMgrConnectionLogRecordBean.country) && Intrinsics.areEqual(this.countryIcon, agentMgrConnectionLogRecordBean.countryIcon) && this.defaultAvatar == agentMgrConnectionLogRecordBean.defaultAvatar && Intrinsics.areEqual(this.description, agentMgrConnectionLogRecordBean.description) && this.diamondBalance == agentMgrConnectionLogRecordBean.diamondBalance && this.diamondIncome == agentMgrConnectionLogRecordBean.diamondIncome && this.duration == agentMgrConnectionLogRecordBean.duration && Intrinsics.areEqual(this.externalId, agentMgrConnectionLogRecordBean.externalId) && this.frequency == agentMgrConnectionLogRecordBean.frequency && this.id == agentMgrConnectionLogRecordBean.id && Intrinsics.areEqual(this.isAgentMgr, agentMgrConnectionLogRecordBean.isAgentMgr) && this.isShowAge == agentMgrConnectionLogRecordBean.isShowAge && Intrinsics.areEqual(this.isTradeUnion, agentMgrConnectionLogRecordBean.isTradeUnion) && Intrinsics.areEqual(this.isTradeUnionMatchNotification, agentMgrConnectionLogRecordBean.isTradeUnionMatchNotification) && Intrinsics.areEqual(this.nick, agentMgrConnectionLogRecordBean.nick) && this.sex == agentMgrConnectionLogRecordBean.sex && this.likeMeCount == agentMgrConnectionLogRecordBean.likeMeCount;
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

    public final int getDiamondBalance() {
        return this.diamondBalance;
    }

    public final int getDiamondIncome() {
        return this.diamondIncome;
    }

    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLikeMeCount() {
        return this.likeMeCount;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public final int getSex() {
        return this.sex;
    }

    public int hashCode() {
        int hashCode = this.avatar.hashCode() * 31;
        Long l = this.birthday;
        int hashCode2 = (((((((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + a.a(this.defaultAvatar)) * 31;
        String str = this.description;
        return ((((((((((((((((((((((((((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.diamondBalance) * 31) + this.diamondIncome) * 31) + this.duration) * 31) + this.externalId.hashCode()) * 31) + this.frequency) * 31) + this.id) * 31) + this.isAgentMgr.hashCode()) * 31) + this.isShowAge) * 31) + this.isTradeUnion.hashCode()) * 31) + this.isTradeUnionMatchNotification.hashCode()) * 31) + this.nick.hashCode()) * 31) + this.sex) * 31) + this.likeMeCount;
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

    @NotNull
    public String toString() {
        return "AgentMgrConnectionLogRecordBean(avatar=" + this.avatar + ", birthday=" + this.birthday + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", defaultAvatar=" + this.defaultAvatar + ", description=" + this.description + ", diamondBalance=" + this.diamondBalance + ", diamondIncome=" + this.diamondIncome + ", duration=" + this.duration + ", externalId=" + this.externalId + ", frequency=" + this.frequency + ", id=" + this.id + ", isAgentMgr=" + this.isAgentMgr + ", isShowAge=" + this.isShowAge + ", isTradeUnion=" + this.isTradeUnion + ", isTradeUnionMatchNotification=" + this.isTradeUnionMatchNotification + ", nick=" + this.nick + ", sex=" + this.sex + ", likeMeCount=" + this.likeMeCount + ")";
    }
}
