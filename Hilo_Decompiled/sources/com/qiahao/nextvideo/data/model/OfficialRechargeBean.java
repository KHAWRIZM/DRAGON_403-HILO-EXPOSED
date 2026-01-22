package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/data/model/OfficialRechargeBean;", "", "Id", "", "avatar", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", SupportGiftRankActivity.EXTERNAL_ID, "isPrettyCode", "", "nick", "sex", "whatsapp", AgooConstants.MESSAGE_FLAG, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;I)V", "getId", "()I", "getAvatar", "()Ljava/lang/String;", "getCode", "getCountry", "getCountryIcon", "getExternalId", "()Z", "getNick", "getSex", "getWhatsapp", "getFlag", "setFlag", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class OfficialRechargeBean {
    private final int Id;

    @NotNull
    private final String avatar;

    @NotNull
    private final String code;

    @NotNull
    private final String country;

    @NotNull
    private final String countryIcon;

    @NotNull
    private final String externalId;
    private int flag;
    private final boolean isPrettyCode;

    @NotNull
    private final String nick;
    private final int sex;

    @NotNull
    private final String whatsapp;

    public OfficialRechargeBean(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, @NotNull String str6, int i2, @NotNull String str7, int i3) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(str5, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(str6, "nick");
        Intrinsics.checkNotNullParameter(str7, "whatsapp");
        this.Id = i;
        this.avatar = str;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.externalId = str5;
        this.isPrettyCode = z;
        this.nick = str6;
        this.sex = i2;
        this.whatsapp = str7;
        this.flag = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.Id;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getWhatsapp() {
        return this.whatsapp;
    }

    /* renamed from: component11, reason: from getter */
    public final int getFlag() {
        return this.flag;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
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

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component9, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final OfficialRechargeBean copy(int Id, @NotNull String avatar, @NotNull String code, @NotNull String country, @NotNull String countryIcon, @NotNull String externalId, boolean isPrettyCode, @NotNull String nick, int sex, @NotNull String whatsapp, int flag) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(whatsapp, "whatsapp");
        return new OfficialRechargeBean(Id, avatar, code, country, countryIcon, externalId, isPrettyCode, nick, sex, whatsapp, flag);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficialRechargeBean)) {
            return false;
        }
        OfficialRechargeBean officialRechargeBean = (OfficialRechargeBean) other;
        return this.Id == officialRechargeBean.Id && Intrinsics.areEqual(this.avatar, officialRechargeBean.avatar) && Intrinsics.areEqual(this.code, officialRechargeBean.code) && Intrinsics.areEqual(this.country, officialRechargeBean.country) && Intrinsics.areEqual(this.countryIcon, officialRechargeBean.countryIcon) && Intrinsics.areEqual(this.externalId, officialRechargeBean.externalId) && this.isPrettyCode == officialRechargeBean.isPrettyCode && Intrinsics.areEqual(this.nick, officialRechargeBean.nick) && this.sex == officialRechargeBean.sex && Intrinsics.areEqual(this.whatsapp, officialRechargeBean.whatsapp) && this.flag == officialRechargeBean.flag;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
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

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    public final int getFlag() {
        return this.flag;
    }

    public final int getId() {
        return this.Id;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final String getWhatsapp() {
        return this.whatsapp;
    }

    public int hashCode() {
        return (((((((((((((((((((this.Id * 31) + this.avatar.hashCode()) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.externalId.hashCode()) * 31) + a.a(this.isPrettyCode)) * 31) + this.nick.hashCode()) * 31) + this.sex) * 31) + this.whatsapp.hashCode()) * 31) + this.flag;
    }

    public final boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    public final void setFlag(int i) {
        this.flag = i;
    }

    @NotNull
    public String toString() {
        return "OfficialRechargeBean(Id=" + this.Id + ", avatar=" + this.avatar + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", externalId=" + this.externalId + ", isPrettyCode=" + this.isPrettyCode + ", nick=" + this.nick + ", sex=" + this.sex + ", whatsapp=" + this.whatsapp + ", flag=" + this.flag + ")";
    }
}
