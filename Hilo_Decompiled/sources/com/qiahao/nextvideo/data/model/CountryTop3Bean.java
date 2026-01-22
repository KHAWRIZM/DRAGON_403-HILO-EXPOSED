package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jg\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u0006,"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CountryTop3Bean;", "", "Id", "", "avatar", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", SupportGiftRankActivity.EXTERNAL_ID, "isPrettyCode", "", "nick", "sex", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)V", "getId", "()I", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getCode", "getCountry", "getCountryIcon", "getExternalId", "()Z", "getNick", "setNick", "getSex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CountryTop3Bean {
    private final int Id;

    @Nullable
    private String avatar;

    @NotNull
    private final String code;

    @NotNull
    private final String country;

    @NotNull
    private final String countryIcon;

    @NotNull
    private final String externalId;
    private final boolean isPrettyCode;

    @Nullable
    private String nick;
    private final int sex;

    public CountryTop3Bean(int i, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, @Nullable String str6, int i2) {
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, "country");
        Intrinsics.checkNotNullParameter(str4, "countryIcon");
        Intrinsics.checkNotNullParameter(str5, SupportGiftRankActivity.EXTERNAL_ID);
        this.Id = i;
        this.avatar = str;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.externalId = str5;
        this.isPrettyCode = z;
        this.nick = str6;
        this.sex = i2;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.Id;
    }

    @Nullable
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

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component9, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final CountryTop3Bean copy(int Id, @Nullable String avatar, @NotNull String code, @NotNull String country, @NotNull String countryIcon, @NotNull String externalId, boolean isPrettyCode, @Nullable String nick, int sex) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(countryIcon, "countryIcon");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        return new CountryTop3Bean(Id, avatar, code, country, countryIcon, externalId, isPrettyCode, nick, sex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryTop3Bean)) {
            return false;
        }
        CountryTop3Bean countryTop3Bean = (CountryTop3Bean) other;
        return this.Id == countryTop3Bean.Id && Intrinsics.areEqual(this.avatar, countryTop3Bean.avatar) && Intrinsics.areEqual(this.code, countryTop3Bean.code) && Intrinsics.areEqual(this.country, countryTop3Bean.country) && Intrinsics.areEqual(this.countryIcon, countryTop3Bean.countryIcon) && Intrinsics.areEqual(this.externalId, countryTop3Bean.externalId) && this.isPrettyCode == countryTop3Bean.isPrettyCode && Intrinsics.areEqual(this.nick, countryTop3Bean.nick) && this.sex == countryTop3Bean.sex;
    }

    @Nullable
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
        return this.Id;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    public final int getSex() {
        return this.sex;
    }

    public int hashCode() {
        int i = this.Id * 31;
        String str = this.avatar;
        int hashCode = (((((((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.code.hashCode()) * 31) + this.country.hashCode()) * 31) + this.countryIcon.hashCode()) * 31) + this.externalId.hashCode()) * 31) + a.a(this.isPrettyCode)) * 31;
        String str2 = this.nick;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.sex;
    }

    public final boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    @NotNull
    public String toString() {
        return "CountryTop3Bean(Id=" + this.Id + ", avatar=" + this.avatar + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", externalId=" + this.externalId + ", isPrettyCode=" + this.isPrettyCode + ", nick=" + this.nick + ", sex=" + this.sex + ")";
    }

    public /* synthetic */ CountryTop3Bean(int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? "" : str, str2, str3, str4, str5, z, (i3 & 128) != 0 ? "" : str6, i2);
    }
}
