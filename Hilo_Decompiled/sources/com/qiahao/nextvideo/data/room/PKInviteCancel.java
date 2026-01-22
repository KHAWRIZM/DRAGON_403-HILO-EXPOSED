package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b8\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010.J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J¨\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0003HÖ\u0001J\t\u0010K\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "", "type", "", GameMatchActivity.GAME_ID, "groupId", "", Constants.KEY_HTTP_CODE, "name", "gameType", "avatar", Constants.KEY_MODE, SupportGiftRankActivity.EXTERNAL_ID, "country", "birthDay", "", "sex", "svipLevel", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/Integer;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGameId", "setGameId", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getCode", "setCode", "getName", "setName", "getGameType", "setGameType", "getAvatar", "setAvatar", "getMode", "setMode", "getExternalId", "setExternalId", "getCountry", "setCountry", "getBirthDay", "()Ljava/lang/Long;", "setBirthDay", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSex", "()I", "setSex", "(I)V", "getSvipLevel", "setSvipLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/Integer;)Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PKInviteCancel {

    @Nullable
    private String avatar;

    @Nullable
    private Long birthDay;

    @Nullable
    private String code;

    @Nullable
    private String country;

    @Nullable
    private String externalId;

    @Nullable
    private Integer gameId;

    @Nullable
    private Integer gameType;

    @Nullable
    private String groupId;

    @Nullable
    private Integer mode;

    @Nullable
    private String name;
    private int sex;

    @Nullable
    private Integer svipLevel;

    @Nullable
    private Integer type;

    public PKInviteCancel() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, null, 8191, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Long getBirthDay() {
        return this.birthDay;
    }

    /* renamed from: component12, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getMode() {
        return this.mode;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final PKInviteCancel copy(@Nullable Integer type, @Nullable Integer gameId, @Nullable String groupId, @Nullable String code, @Nullable String name, @Nullable Integer gameType, @Nullable String avatar, @Nullable Integer mode, @Nullable String externalId, @Nullable String country, @Nullable Long birthDay, int sex, @Nullable Integer svipLevel) {
        return new PKInviteCancel(type, gameId, groupId, code, name, gameType, avatar, mode, externalId, country, birthDay, sex, svipLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PKInviteCancel)) {
            return false;
        }
        PKInviteCancel pKInviteCancel = (PKInviteCancel) other;
        return Intrinsics.areEqual(this.type, pKInviteCancel.type) && Intrinsics.areEqual(this.gameId, pKInviteCancel.gameId) && Intrinsics.areEqual(this.groupId, pKInviteCancel.groupId) && Intrinsics.areEqual(this.code, pKInviteCancel.code) && Intrinsics.areEqual(this.name, pKInviteCancel.name) && Intrinsics.areEqual(this.gameType, pKInviteCancel.gameType) && Intrinsics.areEqual(this.avatar, pKInviteCancel.avatar) && Intrinsics.areEqual(this.mode, pKInviteCancel.mode) && Intrinsics.areEqual(this.externalId, pKInviteCancel.externalId) && Intrinsics.areEqual(this.country, pKInviteCancel.country) && Intrinsics.areEqual(this.birthDay, pKInviteCancel.birthDay) && this.sex == pKInviteCancel.sex && Intrinsics.areEqual(this.svipLevel, pKInviteCancel.svipLevel);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Long getBirthDay() {
        return this.birthDay;
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
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final Integer getGameId() {
        return this.gameId;
    }

    @Nullable
    public final Integer getGameType() {
        return this.gameType;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final Integer getMode() {
        return this.mode;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.gameId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.groupId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.code;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.gameType;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.avatar;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num4 = this.mode;
        int hashCode8 = (hashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str5 = this.externalId;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.country;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l = this.birthDay;
        int hashCode11 = (((hashCode10 + (l == null ? 0 : l.hashCode())) * 31) + this.sex) * 31;
        Integer num5 = this.svipLevel;
        return hashCode11 + (num5 != null ? num5.hashCode() : 0);
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setBirthDay(@Nullable Long l) {
        this.birthDay = l;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setGameId(@Nullable Integer num) {
        this.gameId = num;
    }

    public final void setGameType(@Nullable Integer num) {
        this.gameType = num;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setMode(@Nullable Integer num) {
        this.mode = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final void setSvipLevel(@Nullable Integer num) {
        this.svipLevel = num;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "PKInviteCancel(type=" + this.type + ", gameId=" + this.gameId + ", groupId=" + this.groupId + ", code=" + this.code + ", name=" + this.name + ", gameType=" + this.gameType + ", avatar=" + this.avatar + ", mode=" + this.mode + ", externalId=" + this.externalId + ", country=" + this.country + ", birthDay=" + this.birthDay + ", sex=" + this.sex + ", svipLevel=" + this.svipLevel + ")";
    }

    public PKInviteCancel(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num3, @Nullable String str4, @Nullable Integer num4, @Nullable String str5, @Nullable String str6, @Nullable Long l, int i, @Nullable Integer num5) {
        this.type = num;
        this.gameId = num2;
        this.groupId = str;
        this.code = str2;
        this.name = str3;
        this.gameType = num3;
        this.avatar = str4;
        this.mode = num4;
        this.externalId = str5;
        this.country = str6;
        this.birthDay = l;
        this.sex = i;
        this.svipLevel = num5;
    }

    public /* synthetic */ PKInviteCancel(Integer num, Integer num2, String str, String str2, String str3, Integer num3, String str4, Integer num4, String str5, String str6, Long l, int i, Integer num5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : num3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : num4, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? null : str6, (i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : l, (i2 & 2048) == 0 ? i : 0, (i2 & 4096) == 0 ? num5 : null);
    }
}
