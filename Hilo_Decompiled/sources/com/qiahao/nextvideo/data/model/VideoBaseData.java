package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bG\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010@\u001a\u00020\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010I\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010J\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010K\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010L\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010M\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010N\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010)JÚ\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u000e2\b\u0010U\u001a\u0004\u0018\u00010VHÖ\u0003J\t\u0010W\u001a\u00020\nHÖ\u0001J\t\u0010X\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b\r\u00101\"\u0004\b2\u00103R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b\u000f\u00101\"\u0004\b5\u00103R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b\u0010\u00101\"\u0004\b6\u00103R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b\u0011\u00101\"\u0004\b7\u00103R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b\u0012\u00101\"\u0004\b8\u00103R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b\u0013\u00101\"\u0004\b9\u00103R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b<\u0010)\"\u0004\b=\u0010+R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b>\u0010)\"\u0004\b?\u0010+¨\u0006Y"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "Ljava/io/Serializable;", "avatar", "", "birthday", "", Constants.KEY_HTTP_CODE, "country", "countryIcon", "diamondMinute", "", SupportGiftRankActivity.EXTERNAL_ID, AgooConstants.MESSAGE_ID, "isLike", "", "isLikeMe", "isLogout", "isOnline", "isPrettyCode", "isVip", "nick", "sex", "vipExpireTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCode", "setCode", "getCountry", "setCountry", "getCountryIcon", "setCountryIcon", "getDiamondMinute", "()Ljava/lang/Integer;", "setDiamondMinute", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExternalId", "setExternalId", "getId", "setId", "()Ljava/lang/Boolean;", "setLike", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setLikeMe", "setLogout", "setOnline", "setPrettyCode", "setVip", "getNick", "setNick", "getSex", "setSex", "getVipExpireTime", "setVipExpireTime", "getAge", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VideoBaseData implements Serializable {

    @Nullable
    private String avatar;

    @Nullable
    private Long birthday;

    @Nullable
    private String code;

    @Nullable
    private String country;

    @Nullable
    private String countryIcon;

    @Nullable
    private Integer diamondMinute;

    @Nullable
    private String externalId;

    @Nullable
    private Integer id;

    @Nullable
    private Boolean isLike;

    @Nullable
    private Boolean isLikeMe;

    @Nullable
    private Boolean isLogout;

    @Nullable
    private Boolean isOnline;

    @Nullable
    private Boolean isPrettyCode;

    @Nullable
    private Boolean isVip;

    @Nullable
    private String nick;

    @Nullable
    private Integer sex;

    @Nullable
    private Integer vipExpireTime;

    public VideoBaseData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Boolean getIsLikeMe() {
        return this.isLikeMe;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getIsLogout() {
        return this.isLogout;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Boolean getIsOnline() {
        return this.isOnline;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getVipExpireTime() {
        return this.vipExpireTime;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
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
    public final Integer getDiamondMinute() {
        return this.diamondMinute;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Boolean getIsLike() {
        return this.isLike;
    }

    @NotNull
    public final VideoBaseData copy(@Nullable String avatar, @Nullable Long birthday, @Nullable String code, @Nullable String country, @Nullable String countryIcon, @Nullable Integer diamondMinute, @Nullable String externalId, @Nullable Integer id2, @Nullable Boolean isLike, @Nullable Boolean isLikeMe, @Nullable Boolean isLogout, @Nullable Boolean isOnline, @Nullable Boolean isPrettyCode, @Nullable Boolean isVip, @Nullable String nick, @Nullable Integer sex, @Nullable Integer vipExpireTime) {
        return new VideoBaseData(avatar, birthday, code, country, countryIcon, diamondMinute, externalId, id2, isLike, isLikeMe, isLogout, isOnline, isPrettyCode, isVip, nick, sex, vipExpireTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoBaseData)) {
            return false;
        }
        VideoBaseData videoBaseData = (VideoBaseData) other;
        return Intrinsics.areEqual(this.avatar, videoBaseData.avatar) && Intrinsics.areEqual(this.birthday, videoBaseData.birthday) && Intrinsics.areEqual(this.code, videoBaseData.code) && Intrinsics.areEqual(this.country, videoBaseData.country) && Intrinsics.areEqual(this.countryIcon, videoBaseData.countryIcon) && Intrinsics.areEqual(this.diamondMinute, videoBaseData.diamondMinute) && Intrinsics.areEqual(this.externalId, videoBaseData.externalId) && Intrinsics.areEqual(this.id, videoBaseData.id) && Intrinsics.areEqual(this.isLike, videoBaseData.isLike) && Intrinsics.areEqual(this.isLikeMe, videoBaseData.isLikeMe) && Intrinsics.areEqual(this.isLogout, videoBaseData.isLogout) && Intrinsics.areEqual(this.isOnline, videoBaseData.isOnline) && Intrinsics.areEqual(this.isPrettyCode, videoBaseData.isPrettyCode) && Intrinsics.areEqual(this.isVip, videoBaseData.isVip) && Intrinsics.areEqual(this.nick, videoBaseData.nick) && Intrinsics.areEqual(this.sex, videoBaseData.sex) && Intrinsics.areEqual(this.vipExpireTime, videoBaseData.vipExpireTime);
    }

    @NotNull
    public final String getAge() {
        long j;
        Long l = this.birthday;
        if (l != null) {
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            if (j > 0) {
                long constantTimeSecs = DateTimeUtilityKt.getConstantTimeSecs();
                Long l2 = this.birthday;
                Intrinsics.checkNotNull(l2);
                return String.valueOf((constantTimeSecs - l2.longValue()) / 31536000);
            }
        }
        return "";
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Long getBirthday() {
        return this.birthday;
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
    public final Integer getDiamondMinute() {
        return this.diamondMinute;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final Integer getSex() {
        return this.sex;
    }

    @Nullable
    public final Integer getVipExpireTime() {
        return this.vipExpireTime;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.birthday;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.code;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.country;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.countryIcon;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.diamondMinute;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.externalId;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.id;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.isLike;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isLikeMe;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isLogout;
        int hashCode11 = (hashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isOnline;
        int hashCode12 = (hashCode11 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isPrettyCode;
        int hashCode13 = (hashCode12 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.isVip;
        int hashCode14 = (hashCode13 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        String str6 = this.nick;
        int hashCode15 = (hashCode14 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num3 = this.sex;
        int hashCode16 = (hashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.vipExpireTime;
        return hashCode16 + (num4 != null ? num4.hashCode() : 0);
    }

    @Nullable
    public final Boolean isLike() {
        return this.isLike;
    }

    @Nullable
    public final Boolean isLikeMe() {
        return this.isLikeMe;
    }

    @Nullable
    public final Boolean isLogout() {
        return this.isLogout;
    }

    @Nullable
    public final Boolean isOnline() {
        return this.isOnline;
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

    public final void setBirthday(@Nullable Long l) {
        this.birthday = l;
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

    public final void setDiamondMinute(@Nullable Integer num) {
        this.diamondMinute = num;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setId(@Nullable Integer num) {
        this.id = num;
    }

    public final void setLike(@Nullable Boolean bool) {
        this.isLike = bool;
    }

    public final void setLikeMe(@Nullable Boolean bool) {
        this.isLikeMe = bool;
    }

    public final void setLogout(@Nullable Boolean bool) {
        this.isLogout = bool;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setOnline(@Nullable Boolean bool) {
        this.isOnline = bool;
    }

    public final void setPrettyCode(@Nullable Boolean bool) {
        this.isPrettyCode = bool;
    }

    public final void setSex(@Nullable Integer num) {
        this.sex = num;
    }

    public final void setVip(@Nullable Boolean bool) {
        this.isVip = bool;
    }

    public final void setVipExpireTime(@Nullable Integer num) {
        this.vipExpireTime = num;
    }

    @NotNull
    public String toString() {
        return "VideoBaseData(avatar=" + this.avatar + ", birthday=" + this.birthday + ", code=" + this.code + ", country=" + this.country + ", countryIcon=" + this.countryIcon + ", diamondMinute=" + this.diamondMinute + ", externalId=" + this.externalId + ", id=" + this.id + ", isLike=" + this.isLike + ", isLikeMe=" + this.isLikeMe + ", isLogout=" + this.isLogout + ", isOnline=" + this.isOnline + ", isPrettyCode=" + this.isPrettyCode + ", isVip=" + this.isVip + ", nick=" + this.nick + ", sex=" + this.sex + ", vipExpireTime=" + this.vipExpireTime + ")";
    }

    public VideoBaseData(@Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Integer num2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable String str6, @Nullable Integer num3, @Nullable Integer num4) {
        this.avatar = str;
        this.birthday = l;
        this.code = str2;
        this.country = str3;
        this.countryIcon = str4;
        this.diamondMinute = num;
        this.externalId = str5;
        this.id = num2;
        this.isLike = bool;
        this.isLikeMe = bool2;
        this.isLogout = bool3;
        this.isOnline = bool4;
        this.isPrettyCode = bool5;
        this.isVip = bool6;
        this.nick = str6;
        this.sex = num3;
        this.vipExpireTime = num4;
    }

    public /* synthetic */ VideoBaseData(String str, Long l, String str2, String str3, String str4, Integer num, String str5, Integer num2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, String str6, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : bool2, (i & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : bool3, (i & 2048) != 0 ? null : bool4, (i & 4096) != 0 ? null : bool5, (i & 8192) != 0 ? null : bool6, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : num3, (i & 65536) != 0 ? null : num4);
    }
}
