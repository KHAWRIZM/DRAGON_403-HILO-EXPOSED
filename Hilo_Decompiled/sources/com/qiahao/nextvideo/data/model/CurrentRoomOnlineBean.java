package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010J\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010K\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010P\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0016HÆ\u0003JÂ\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u000b2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0012HÖ\u0001J\t\u0010W\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b\n\u0010*\"\u0004\b+\u0010,R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b\f\u0010*\"\u0004\b.\u0010,R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b\r\u0010*\"\u0004\b/\u0010,R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001cR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b=\u00107\"\u0004\b>\u00109R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006X"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBean;", "", "Id", "", "avatar", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", SupportGiftRankActivity.EXTERNAL_ID, "isLogout", "", "isPrettyCode", "isVip", "nick", "noble", "Lcom/qiahao/base_common/model/common/NobleInfo;", "sex", "", "vipExpireTime", "svipLevel", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Lcom/qiahao/base_common/model/svip/SvipData;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getCode", "setCode", "getCountry", "setCountry", "getCountryIcon", "setCountryIcon", "getExternalId", "setExternalId", "()Ljava/lang/Boolean;", "setLogout", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setPrettyCode", "setVip", "getNick", "setNick", "getNoble", "()Lcom/qiahao/base_common/model/common/NobleInfo;", "setNoble", "(Lcom/qiahao/base_common/model/common/NobleInfo;)V", "getSex", "()Ljava/lang/Integer;", "setSex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getVipExpireTime", "setVipExpireTime", "getSvipLevel", "setSvipLevel", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/qiahao/base_common/model/common/NobleInfo;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Lcom/qiahao/base_common/model/svip/SvipData;)Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBean;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CurrentRoomOnlineBean {

    @Nullable
    private Long Id;

    @Nullable
    private String avatar;

    @Nullable
    private String code;

    @Nullable
    private String country;

    @Nullable
    private String countryIcon;

    @Nullable
    private String externalId;

    @Nullable
    private Boolean isLogout;

    @Nullable
    private Boolean isPrettyCode;

    @Nullable
    private Boolean isVip;

    @Nullable
    private String nick;

    @Nullable
    private NobleInfo noble;

    @Nullable
    private Integer sex;

    @Nullable
    private SvipData svip;

    @Nullable
    private Integer svipLevel;

    @Nullable
    private Long vipExpireTime;

    public CurrentRoomOnlineBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.Id;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Long getVipExpireTime() {
        return this.vipExpireTime;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getIsLogout() {
        return this.isLogout;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    @NotNull
    public final CurrentRoomOnlineBean copy(@Nullable Long Id, @Nullable String avatar, @Nullable String code, @Nullable String country, @Nullable String countryIcon, @Nullable String externalId, @Nullable Boolean isLogout, @Nullable Boolean isPrettyCode, @Nullable Boolean isVip, @Nullable String nick, @Nullable NobleInfo noble, @Nullable Integer sex, @Nullable Long vipExpireTime, @Nullable Integer svipLevel, @Nullable SvipData svip) {
        return new CurrentRoomOnlineBean(Id, avatar, code, country, countryIcon, externalId, isLogout, isPrettyCode, isVip, nick, noble, sex, vipExpireTime, svipLevel, svip);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentRoomOnlineBean)) {
            return false;
        }
        CurrentRoomOnlineBean currentRoomOnlineBean = (CurrentRoomOnlineBean) other;
        return Intrinsics.areEqual(this.Id, currentRoomOnlineBean.Id) && Intrinsics.areEqual(this.avatar, currentRoomOnlineBean.avatar) && Intrinsics.areEqual(this.code, currentRoomOnlineBean.code) && Intrinsics.areEqual(this.country, currentRoomOnlineBean.country) && Intrinsics.areEqual(this.countryIcon, currentRoomOnlineBean.countryIcon) && Intrinsics.areEqual(this.externalId, currentRoomOnlineBean.externalId) && Intrinsics.areEqual(this.isLogout, currentRoomOnlineBean.isLogout) && Intrinsics.areEqual(this.isPrettyCode, currentRoomOnlineBean.isPrettyCode) && Intrinsics.areEqual(this.isVip, currentRoomOnlineBean.isVip) && Intrinsics.areEqual(this.nick, currentRoomOnlineBean.nick) && Intrinsics.areEqual(this.noble, currentRoomOnlineBean.noble) && Intrinsics.areEqual(this.sex, currentRoomOnlineBean.sex) && Intrinsics.areEqual(this.vipExpireTime, currentRoomOnlineBean.vipExpireTime) && Intrinsics.areEqual(this.svipLevel, currentRoomOnlineBean.svipLevel) && Intrinsics.areEqual(this.svip, currentRoomOnlineBean.svip);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final Long getId() {
        return this.Id;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final NobleInfo getNoble() {
        return this.noble;
    }

    @Nullable
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    public final Long getVipExpireTime() {
        return this.vipExpireTime;
    }

    public int hashCode() {
        Long l = this.Id;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.avatar;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.code;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.country;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.countryIcon;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.externalId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isLogout;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isPrettyCode;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isVip;
        int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str6 = this.nick;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        NobleInfo nobleInfo = this.noble;
        int hashCode11 = (hashCode10 + (nobleInfo == null ? 0 : nobleInfo.hashCode())) * 31;
        Integer num = this.sex;
        int hashCode12 = (hashCode11 + (num == null ? 0 : num.hashCode())) * 31;
        Long l2 = this.vipExpireTime;
        int hashCode13 = (hashCode12 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num2 = this.svipLevel;
        int hashCode14 = (hashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
        SvipData svipData = this.svip;
        return hashCode14 + (svipData != null ? svipData.hashCode() : 0);
    }

    @Nullable
    public final Boolean isLogout() {
        return this.isLogout;
    }

    @Nullable
    public final Boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    public final Boolean isVip() {
        return this.isVip;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setCountryIcon(@Nullable String str) {
        this.countryIcon = str;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setId(@Nullable Long l) {
        this.Id = l;
    }

    public final void setLogout(@Nullable Boolean bool) {
        this.isLogout = bool;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setNoble(@Nullable NobleInfo nobleInfo) {
        this.noble = nobleInfo;
    }

    public final void setPrettyCode(@Nullable Boolean bool) {
        this.isPrettyCode = bool;
    }

    public final void setSex(@Nullable Integer num) {
        this.sex = num;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setSvipLevel(@Nullable Integer num) {
        this.svipLevel = num;
    }

    public final void setVip(@Nullable Boolean bool) {
        this.isVip = bool;
    }

    public final void setVipExpireTime(@Nullable Long l) {
        this.vipExpireTime = l;
    }

    @NotNull
    public String toString() {
        return "CurrentRoomOnlineBean(Id=" + this.Id + ", avatar=" + this.avatar + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", externalId=" + this.externalId + ", isLogout=" + this.isLogout + ", isPrettyCode=" + this.isPrettyCode + ", isVip=" + this.isVip + ", nick=" + this.nick + ", noble=" + this.noble + ", sex=" + this.sex + ", vipExpireTime=" + this.vipExpireTime + ", svipLevel=" + this.svipLevel + ", svip=" + this.svip + ")";
    }

    public CurrentRoomOnlineBean(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str6, @Nullable NobleInfo nobleInfo, @Nullable Integer num, @Nullable Long l2, @Nullable Integer num2, @Nullable SvipData svipData) {
        this.Id = l;
        this.avatar = str;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.externalId = str5;
        this.isLogout = bool;
        this.isPrettyCode = bool2;
        this.isVip = bool3;
        this.nick = str6;
        this.noble = nobleInfo;
        this.sex = num;
        this.vipExpireTime = l2;
        this.svipLevel = num2;
        this.svip = svipData;
    }

    public /* synthetic */ CurrentRoomOnlineBean(Long l, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, Boolean bool3, String str6, NobleInfo nobleInfo, Integer num, Long l2, Integer num2, SvipData svipData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : bool2, (i & 256) != 0 ? null : bool3, (i & 512) != 0 ? null : str6, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : nobleInfo, (i & 2048) != 0 ? null : num, (i & 4096) != 0 ? 0L : l2, (i & 8192) != 0 ? 0 : num2, (i & 16384) == 0 ? svipData : null);
    }
}
