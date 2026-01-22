package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b-\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010&Jj\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001b\"\u0004\b\u001e\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b\u000b\u0010!\"\u0004\b\"\u0010#R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010*\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010\u0011¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "", "avatar", "", "birthday", "", SupportGiftRankActivity.EXTERNAL_ID, "isNew", "", "isOnline", "nick", "isMyLike", "sex", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExternalId", "setExternalId", "()Z", "setNew", "(Z)V", "setOnline", "getNick", "setNick", "()Ljava/lang/Boolean;", "setMyLike", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSex", "()Ljava/lang/Integer;", "setSex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "age", "getAge", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SuperLikeData {

    @Nullable
    private String avatar;

    @Nullable
    private Long birthday;

    @Nullable
    private String externalId;

    @Nullable
    private Boolean isMyLike;
    private boolean isNew;
    private boolean isOnline;

    @Nullable
    private String nick;

    @Nullable
    private Integer sex;

    public SuperLikeData() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getBirthday() {
        return this.birthday;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsNew() {
        return this.isNew;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsOnline() {
        return this.isOnline;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getIsMyLike() {
        return this.isMyLike;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getSex() {
        return this.sex;
    }

    @NotNull
    public final SuperLikeData copy(@Nullable String avatar, @Nullable Long birthday, @Nullable String externalId, boolean isNew, boolean isOnline, @Nullable String nick, @Nullable Boolean isMyLike, @Nullable Integer sex) {
        return new SuperLikeData(avatar, birthday, externalId, isNew, isOnline, nick, isMyLike, sex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuperLikeData)) {
            return false;
        }
        SuperLikeData superLikeData = (SuperLikeData) other;
        return Intrinsics.areEqual(this.avatar, superLikeData.avatar) && Intrinsics.areEqual(this.birthday, superLikeData.birthday) && Intrinsics.areEqual(this.externalId, superLikeData.externalId) && this.isNew == superLikeData.isNew && this.isOnline == superLikeData.isOnline && Intrinsics.areEqual(this.nick, superLikeData.nick) && Intrinsics.areEqual(this.isMyLike, superLikeData.isMyLike) && Intrinsics.areEqual(this.sex, superLikeData.sex);
    }

    @NotNull
    public final String getAge() {
        long j;
        Long l = this.birthday;
        long j2 = 0;
        if (l != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        if (j <= 0) {
            return "";
        }
        long constantTimeSecs = DateTimeUtilityKt.getConstantTimeSecs();
        Long l2 = this.birthday;
        if (l2 != null) {
            j2 = l2.longValue();
        }
        return String.valueOf((constantTimeSecs - j2) / 31536000);
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
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final Integer getSex() {
        return this.sex;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.birthday;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.externalId;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + a.a(this.isNew)) * 31) + a.a(this.isOnline)) * 31;
        String str3 = this.nick;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isMyLike;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.sex;
        return hashCode5 + (num != null ? num.hashCode() : 0);
    }

    @Nullable
    public final Boolean isMyLike() {
        return this.isMyLike;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setBirthday(@Nullable Long l) {
        this.birthday = l;
    }

    public final void setExternalId(@Nullable String str) {
        this.externalId = str;
    }

    public final void setMyLike(@Nullable Boolean bool) {
        this.isMyLike = bool;
    }

    public final void setNew(boolean z) {
        this.isNew = z;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setOnline(boolean z) {
        this.isOnline = z;
    }

    public final void setSex(@Nullable Integer num) {
        this.sex = num;
    }

    @NotNull
    public String toString() {
        return "SuperLikeData(avatar=" + this.avatar + ", birthday=" + this.birthday + ", externalId=" + this.externalId + ", isNew=" + this.isNew + ", isOnline=" + this.isOnline + ", nick=" + this.nick + ", isMyLike=" + this.isMyLike + ", sex=" + this.sex + ")";
    }

    public SuperLikeData(@Nullable String str, @Nullable Long l, @Nullable String str2, boolean z, boolean z2, @Nullable String str3, @Nullable Boolean bool, @Nullable Integer num) {
        this.avatar = str;
        this.birthday = l;
        this.externalId = str2;
        this.isNew = z;
        this.isOnline = z2;
        this.nick = str3;
        this.isMyLike = bool;
        this.sex = num;
    }

    public /* synthetic */ SuperLikeData(String str, Long l, String str2, boolean z, boolean z2, String str3, Boolean bool, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) == 0 ? z2 : false, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) == 0 ? num : null);
    }
}
