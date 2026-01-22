package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001J\u0013\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\tHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PrivateRecordBean;", "", "avatar", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", SupportGiftRankActivity.EXTERNAL_ID, AgooConstants.MESSAGE_ID, "", "isPrettyCode", "", "nick", "recordType", "sendTime", "sex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;III)V", "getAvatar", "()Ljava/lang/String;", "getCode", "getCountry", "getCountryIcon", "getExternalId", "getId", "()I", "()Z", "getNick", "getRecordType", "getSendTime", "getSex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PrivateRecordBean {

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
    private final int id;
    private final boolean isPrettyCode;

    @NotNull
    private final String nick;
    private final int recordType;
    private final int sendTime;
    private final int sex;

    public PrivateRecordBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i, boolean z, @NotNull String str6, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(str5, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(str6, "nick");
        this.avatar = str;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.externalId = str5;
        this.id = i;
        this.isPrettyCode = z;
        this.nick = str6;
        this.recordType = i2;
        this.sendTime = i3;
        this.sex = i4;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component10, reason: from getter */
    public final int getSendTime() {
        return this.sendTime;
    }

    /* renamed from: component11, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getCountryIcon() {
        return this.countryIcon;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component6, reason: from getter */
    public final int getId() {
        return this.id;
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
    public final int getRecordType() {
        return this.recordType;
    }

    @NotNull
    public final PrivateRecordBean copy(@NotNull String avatar, @NotNull String code, @NotNull String country, @NotNull String countryIcon, @NotNull String externalId, int id2, boolean isPrettyCode, @NotNull String nick, int recordType, int sendTime, int sex) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(nick, "nick");
        return new PrivateRecordBean(avatar, code, country, countryIcon, externalId, id2, isPrettyCode, nick, recordType, sendTime, sex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrivateRecordBean)) {
            return false;
        }
        PrivateRecordBean privateRecordBean = (PrivateRecordBean) other;
        return Intrinsics.areEqual(this.avatar, privateRecordBean.avatar) && Intrinsics.areEqual(this.code, privateRecordBean.code) && Intrinsics.areEqual(this.country, privateRecordBean.country) && Intrinsics.areEqual(this.countryIcon, privateRecordBean.countryIcon) && Intrinsics.areEqual(this.externalId, privateRecordBean.externalId) && this.id == privateRecordBean.id && this.isPrettyCode == privateRecordBean.isPrettyCode && Intrinsics.areEqual(this.nick, privateRecordBean.nick) && this.recordType == privateRecordBean.recordType && this.sendTime == privateRecordBean.sendTime && this.sex == privateRecordBean.sex;
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

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public final int getRecordType() {
        return this.recordType;
    }

    public final int getSendTime() {
        return this.sendTime;
    }

    public final int getSex() {
        return this.sex;
    }

    public int hashCode() {
        return (((((((((((((((((((this.avatar.hashCode() * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.id) * 31) + a.a(this.isPrettyCode)) * 31) + this.nick.hashCode()) * 31) + this.recordType) * 31) + this.sendTime) * 31) + this.sex;
    }

    public final boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    @NotNull
    public String toString() {
        return "PrivateRecordBean(avatar=" + this.avatar + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", externalId=" + this.externalId + ", id=" + this.id + ", isPrettyCode=" + this.isPrettyCode + ", nick=" + this.nick + ", recordType=" + this.recordType + ", sendTime=" + this.sendTime + ", sex=" + this.sex + ")";
    }
}
