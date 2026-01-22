package com.qhqc.core.feature.bean;

import anetwork.channel.util.RequestConstant;
import com.liulishuo.okdownload.DownloadTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\bM\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\nHÆ\u0003J\t\u0010I\u001a\u00020\nHÆ\u0003J\t\u0010J\u001a\u00020\nHÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\nHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\nHÆ\u0003J\t\u0010T\u001a\u00020\nHÆ\u0003J\t\u0010U\u001a\u00020\nHÆ\u0003JÙ\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\nHÆ\u0001J\u0013\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\nHÖ\u0001J\t\u0010[\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010)\"\u0004\b0\u0010+R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010)\"\u0004\b2\u0010+R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\u001e\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010)\"\u0004\bA\u0010+R\u001e\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010)\"\u0004\bB\u0010+¨\u0006\\"}, d2 = {"Lcom/qhqc/core/feature/bean/UserInfoBean;", "", "id", "", "code", "", "nick", "avatar", "externalId", "sex", "", RequestConstant.ENV_ONLINE, "age", "isShowAge", "vipLevel", "svipLevel", "headwearUrl", "effectUrl", "picUrl", "headwearIcon", "roomId", "countryId", "isSuper", "isAdmin", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "getId", "()J", "setId", "(J)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getNick", "setNick", "getAvatar", "setAvatar", "getExternalId", "setExternalId", "getSex", "()I", "setSex", "(I)V", "getOnline", "setOnline", "getAge", "setAge", "setShowAge", "getVipLevel", "setVipLevel", "getSvipLevel", "setSvipLevel", "getHeadwearUrl", "setHeadwearUrl", "getEffectUrl", "setEffectUrl", "getPicUrl", "setPicUrl", "getHeadwearIcon", "setHeadwearIcon", "getRoomId", "setRoomId", "getCountryId", "setCountryId", "setSuper", "setAdmin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "", "other", "hashCode", "toString", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class UserInfoBean {
    private int age;

    @Nullable
    private String avatar;

    @Nullable
    private String code;

    @c("country_id")
    private int countryId;

    @Nullable
    private String effectUrl;

    @Nullable
    private String externalId;

    @Nullable
    private String headwearIcon;

    @Nullable
    private String headwearUrl;
    private long id;

    @c("is_admin")
    private int isAdmin;
    private int isShowAge;

    @c("is_super")
    private int isSuper;

    @Nullable
    private String nick;
    private int online;

    @Nullable
    private String picUrl;

    @Nullable
    private String roomId;
    private int sex;
    private int svipLevel;
    private int vipLevel;

    public UserInfoBean(long j10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i10, int i11, int i12, int i13, int i14, int i15, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, int i16, int i17, int i18) {
        this.id = j10;
        this.code = str;
        this.nick = str2;
        this.avatar = str3;
        this.externalId = str4;
        this.sex = i10;
        this.online = i11;
        this.age = i12;
        this.isShowAge = i13;
        this.vipLevel = i14;
        this.svipLevel = i15;
        this.headwearUrl = str5;
        this.effectUrl = str6;
        this.picUrl = str7;
        this.headwearIcon = str8;
        this.roomId = str9;
        this.countryId = i16;
        this.isSuper = i17;
        this.isAdmin = i18;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getVipLevel() {
        return this.vipLevel;
    }

    /* renamed from: component11, reason: from getter */
    public final int getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getHeadwearUrl() {
        return this.headwearUrl;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getHeadwearIcon() {
        return this.headwearIcon;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: component17, reason: from getter */
    public final int getCountryId() {
        return this.countryId;
    }

    /* renamed from: component18, reason: from getter */
    public final int getIsSuper() {
        return this.isSuper;
    }

    /* renamed from: component19, reason: from getter */
    public final int getIsAdmin() {
        return this.isAdmin;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* renamed from: component7, reason: from getter */
    public final int getOnline() {
        return this.online;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAge() {
        return this.age;
    }

    /* renamed from: component9, reason: from getter */
    public final int getIsShowAge() {
        return this.isShowAge;
    }

    @NotNull
    public final UserInfoBean copy(long id, @Nullable String code, @Nullable String nick, @Nullable String avatar, @Nullable String externalId, int sex, int online, int age, int isShowAge, int vipLevel, int svipLevel, @Nullable String headwearUrl, @Nullable String effectUrl, @Nullable String picUrl, @Nullable String headwearIcon, @Nullable String roomId, int countryId, int isSuper, int isAdmin) {
        return new UserInfoBean(id, code, nick, avatar, externalId, sex, online, age, isShowAge, vipLevel, svipLevel, headwearUrl, effectUrl, picUrl, headwearIcon, roomId, countryId, isSuper, isAdmin);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfoBean)) {
            return false;
        }
        UserInfoBean userInfoBean = (UserInfoBean) other;
        return this.id == userInfoBean.id && Intrinsics.areEqual(this.code, userInfoBean.code) && Intrinsics.areEqual(this.nick, userInfoBean.nick) && Intrinsics.areEqual(this.avatar, userInfoBean.avatar) && Intrinsics.areEqual(this.externalId, userInfoBean.externalId) && this.sex == userInfoBean.sex && this.online == userInfoBean.online && this.age == userInfoBean.age && this.isShowAge == userInfoBean.isShowAge && this.vipLevel == userInfoBean.vipLevel && this.svipLevel == userInfoBean.svipLevel && Intrinsics.areEqual(this.headwearUrl, userInfoBean.headwearUrl) && Intrinsics.areEqual(this.effectUrl, userInfoBean.effectUrl) && Intrinsics.areEqual(this.picUrl, userInfoBean.picUrl) && Intrinsics.areEqual(this.headwearIcon, userInfoBean.headwearIcon) && Intrinsics.areEqual(this.roomId, userInfoBean.roomId) && this.countryId == userInfoBean.countryId && this.isSuper == userInfoBean.isSuper && this.isAdmin == userInfoBean.isAdmin;
    }

    public final int getAge() {
        return this.age;
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getHeadwearIcon() {
        return this.headwearIcon;
    }

    @Nullable
    public final String getHeadwearUrl() {
        return this.headwearUrl;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    public final int getOnline() {
        return this.online;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
    }

    public final int getSex() {
        return this.sex;
    }

    public final int getSvipLevel() {
        return this.svipLevel;
    }

    public final int getVipLevel() {
        return this.vipLevel;
    }

    public int hashCode() {
        int a10 = androidx.collection.c.a(this.id) * 31;
        String str = this.code;
        int hashCode = (a10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nick;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.externalId;
        int hashCode4 = (((((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.sex) * 31) + this.online) * 31) + this.age) * 31) + this.isShowAge) * 31) + this.vipLevel) * 31) + this.svipLevel) * 31;
        String str5 = this.headwearUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.effectUrl;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.picUrl;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.headwearIcon;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.roomId;
        return ((((((hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.countryId) * 31) + this.isSuper) * 31) + this.isAdmin;
    }

    public final int isAdmin() {
        return this.isAdmin;
    }

    public final int isShowAge() {
        return this.isShowAge;
    }

    public final int isSuper() {
        return this.isSuper;
    }

    public final void setAdmin(int i10) {
        this.isAdmin = i10;
    }

    public final void setAge(int i10) {
        this.age = i10;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setCountryId(int i10) {
        this.countryId = i10;
    }

    public final void setEffectUrl(@Nullable String str) {
        this.effectUrl = str;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setHeadwearIcon(@Nullable String str) {
        this.headwearIcon = str;
    }

    public final void setHeadwearUrl(@Nullable String str) {
        this.headwearUrl = str;
    }

    public final void setId(long j10) {
        this.id = j10;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setOnline(int i10) {
        this.online = i10;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setRoomId(@Nullable String str) {
        this.roomId = str;
    }

    public final void setSex(int i10) {
        this.sex = i10;
    }

    public final void setShowAge(int i10) {
        this.isShowAge = i10;
    }

    public final void setSuper(int i10) {
        this.isSuper = i10;
    }

    public final void setSvipLevel(int i10) {
        this.svipLevel = i10;
    }

    public final void setVipLevel(int i10) {
        this.vipLevel = i10;
    }

    @NotNull
    public String toString() {
        return "UserInfoBean(id=" + this.id + ", code=" + this.code + ", nick=" + this.nick + ", avatar=" + this.avatar + ", externalId=" + this.externalId + ", sex=" + this.sex + ", online=" + this.online + ", age=" + this.age + ", isShowAge=" + this.isShowAge + ", vipLevel=" + this.vipLevel + ", svipLevel=" + this.svipLevel + ", headwearUrl=" + this.headwearUrl + ", effectUrl=" + this.effectUrl + ", picUrl=" + this.picUrl + ", headwearIcon=" + this.headwearIcon + ", roomId=" + this.roomId + ", countryId=" + this.countryId + ", isSuper=" + this.isSuper + ", isAdmin=" + this.isAdmin + ")";
    }

    public /* synthetic */ UserInfoBean(long j10, String str, String str2, String str3, String str4, int i10, int i11, int i12, int i13, int i14, int i15, String str5, String str6, String str7, String str8, String str9, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, (i19 & 2) != 0 ? "" : str, (i19 & 4) != 0 ? "" : str2, (i19 & 8) != 0 ? "" : str3, (i19 & 16) != 0 ? "" : str4, (i19 & 32) != 0 ? 0 : i10, (i19 & 64) != 0 ? 0 : i11, (i19 & 128) != 0 ? 0 : i12, (i19 & 256) != 0 ? 0 : i13, (i19 & 512) != 0 ? 0 : i14, (i19 & 1024) != 0 ? 0 : i15, (i19 & 2048) != 0 ? "" : str5, (i19 & 4096) != 0 ? "" : str6, (i19 & 8192) != 0 ? "" : str7, (i19 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? "" : str8, (32768 & i19) != 0 ? "" : str9, (65536 & i19) != 0 ? 0 : i16, (131072 & i19) != 0 ? 0 : i17, (i19 & 262144) != 0 ? 0 : i18);
    }
}
