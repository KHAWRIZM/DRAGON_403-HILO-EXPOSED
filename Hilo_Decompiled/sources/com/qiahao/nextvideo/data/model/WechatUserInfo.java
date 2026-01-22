package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008c\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\rHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/data/model/WechatUserInfo;", "", "city", "", "country", "headimgurl", "language", "nickname", "openid", "privilege", "", "province", "sex", "", "unionid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getCountry", "setCountry", "getHeadimgurl", "setHeadimgurl", "getLanguage", "setLanguage", "getNickname", "setNickname", "getOpenid", "setOpenid", "getPrivilege", "()Ljava/util/List;", "setPrivilege", "(Ljava/util/List;)V", "getProvince", "setProvince", "getSex", "()Ljava/lang/Integer;", "setSex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUnionid", "setUnionid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/WechatUserInfo;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class WechatUserInfo {

    @Nullable
    @c("city")
    private String city;

    @Nullable
    @c("country")
    private String country;

    @Nullable
    @c("headimgurl")
    private String headimgurl;

    @Nullable
    @c("language")
    private String language;

    @Nullable
    @c("nickname")
    private String nickname;

    @Nullable
    @c("openid")
    private String openid;

    @Nullable
    @c("privilege")
    private List<? extends Object> privilege;

    @Nullable
    @c("province")
    private String province;

    @Nullable
    @c("sex")
    private Integer sex;

    @Nullable
    @c("unionid")
    private String unionid;

    public WechatUserInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<? extends Object> list, @Nullable String str7, @Nullable Integer num, @Nullable String str8) {
        this.city = str;
        this.country = str2;
        this.headimgurl = str3;
        this.language = str4;
        this.nickname = str5;
        this.openid = str6;
        this.privilege = list;
        this.province = str7;
        this.sex = num;
        this.unionid = str8;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getUnionid() {
        return this.unionid;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getHeadimgurl() {
        return this.headimgurl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getOpenid() {
        return this.openid;
    }

    @Nullable
    public final List<Object> component7() {
        return this.privilege;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getSex() {
        return this.sex;
    }

    @NotNull
    public final WechatUserInfo copy(@Nullable String city, @Nullable String country, @Nullable String headimgurl, @Nullable String language, @Nullable String nickname, @Nullable String openid, @Nullable List<? extends Object> privilege, @Nullable String province, @Nullable Integer sex, @Nullable String unionid) {
        return new WechatUserInfo(city, country, headimgurl, language, nickname, openid, privilege, province, sex, unionid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WechatUserInfo)) {
            return false;
        }
        WechatUserInfo wechatUserInfo = (WechatUserInfo) other;
        return Intrinsics.areEqual(this.city, wechatUserInfo.city) && Intrinsics.areEqual(this.country, wechatUserInfo.country) && Intrinsics.areEqual(this.headimgurl, wechatUserInfo.headimgurl) && Intrinsics.areEqual(this.language, wechatUserInfo.language) && Intrinsics.areEqual(this.nickname, wechatUserInfo.nickname) && Intrinsics.areEqual(this.openid, wechatUserInfo.openid) && Intrinsics.areEqual(this.privilege, wechatUserInfo.privilege) && Intrinsics.areEqual(this.province, wechatUserInfo.province) && Intrinsics.areEqual(this.sex, wechatUserInfo.sex) && Intrinsics.areEqual(this.unionid, wechatUserInfo.unionid);
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getHeadimgurl() {
        return this.headimgurl;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final String getOpenid() {
        return this.openid;
    }

    @Nullable
    public final List<Object> getPrivilege() {
        return this.privilege;
    }

    @Nullable
    public final String getProvince() {
        return this.province;
    }

    @Nullable
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    public final String getUnionid() {
        return this.unionid;
    }

    public int hashCode() {
        String str = this.city;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.headimgurl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.language;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.nickname;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.openid;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<? extends Object> list = this.privilege;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.province;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.sex;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str8 = this.unionid;
        return hashCode9 + (str8 != null ? str8.hashCode() : 0);
    }

    public final void setCity(@Nullable String str) {
        this.city = str;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setHeadimgurl(@Nullable String str) {
        this.headimgurl = str;
    }

    public final void setLanguage(@Nullable String str) {
        this.language = str;
    }

    public final void setNickname(@Nullable String str) {
        this.nickname = str;
    }

    public final void setOpenid(@Nullable String str) {
        this.openid = str;
    }

    public final void setPrivilege(@Nullable List<? extends Object> list) {
        this.privilege = list;
    }

    public final void setProvince(@Nullable String str) {
        this.province = str;
    }

    public final void setSex(@Nullable Integer num) {
        this.sex = num;
    }

    public final void setUnionid(@Nullable String str) {
        this.unionid = str;
    }

    @NotNull
    public String toString() {
        return "WechatUserInfo(city=" + this.city + ", country=" + this.country + ", headimgurl=" + this.headimgurl + ", language=" + this.language + ", nickname=" + this.nickname + ", openid=" + this.openid + ", privilege=" + this.privilege + ", province=" + this.province + ", sex=" + this.sex + ", unionid=" + this.unionid + ")";
    }
}
