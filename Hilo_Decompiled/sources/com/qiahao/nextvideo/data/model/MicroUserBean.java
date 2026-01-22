package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bF\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J¶\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u000b2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0003HÖ\u0001J\t\u0010W\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010(\"\u0004\b)\u0010*R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006X"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MicroUserBean;", "", "tag", "", SupportGiftRankActivity.EXTERNAL_ID, "", "avatar", "nick", "sex", Constants.KEY_HTTP_CODE, "isVip", "", "noble", "headwearPicUrl", "headwearEffectUrl", "headwearReverseEffectUrl", "svipLevel", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "micEffect", "headwearIcon", "music", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getTag", "()I", "setTag", "(I)V", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "getAvatar", "setAvatar", "getNick", "setNick", "getSex", "setSex", "getCode", "setCode", "()Z", "setVip", "(Z)V", "getNoble", "setNoble", "getHeadwearPicUrl", "setHeadwearPicUrl", "getHeadwearEffectUrl", "setHeadwearEffectUrl", "getHeadwearReverseEffectUrl", "setHeadwearReverseEffectUrl", "getSvipLevel", "setSvipLevel", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getMicEffect", "setMicEffect", "getHeadwearIcon", "setHeadwearIcon", "getMusic", "()Ljava/lang/Boolean;", "setMusic", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/MicroUserBean;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MicroUserBean {

    @NotNull
    private String avatar;

    @NotNull
    private String code;

    @NotNull
    private String externalId;

    @NotNull
    private String headwearEffectUrl;

    @Nullable
    private String headwearIcon;

    @NotNull
    private String headwearPicUrl;

    @NotNull
    private String headwearReverseEffectUrl;
    private boolean isVip;

    @Nullable
    private String micEffect;

    @Nullable
    private Boolean music;

    @NotNull
    private String nick;
    private int noble;
    private int sex;

    @Nullable
    private SvipData svip;
    private int svipLevel;
    private int tag;

    public MicroUserBean(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, boolean z, int i3, @NotNull String str5, @NotNull String str6, @NotNull String str7, int i4, @Nullable SvipData svipData, @Nullable String str8, @Nullable String str9, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(str2, "avatar");
        Intrinsics.checkNotNullParameter(str3, "nick");
        Intrinsics.checkNotNullParameter(str4, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str5, "headwearPicUrl");
        Intrinsics.checkNotNullParameter(str6, "headwearEffectUrl");
        Intrinsics.checkNotNullParameter(str7, "headwearReverseEffectUrl");
        this.tag = i;
        this.externalId = str;
        this.avatar = str2;
        this.nick = str3;
        this.sex = i2;
        this.code = str4;
        this.isVip = z;
        this.noble = i3;
        this.headwearPicUrl = str5;
        this.headwearEffectUrl = str6;
        this.headwearReverseEffectUrl = str7;
        this.svipLevel = i4;
        this.svip = svipData;
        this.micEffect = str8;
        this.headwearIcon = str9;
        this.music = bool;
    }

    /* renamed from: component1, reason: from getter */
    public final int getTag() {
        return this.tag;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getHeadwearEffectUrl() {
        return this.headwearEffectUrl;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getHeadwearReverseEffectUrl() {
        return this.headwearReverseEffectUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final int getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getMicEffect() {
        return this.micEffect;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getHeadwearIcon() {
        return this.headwearIcon;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Boolean getMusic() {
        return this.music;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    /* renamed from: component8, reason: from getter */
    public final int getNoble() {
        return this.noble;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getHeadwearPicUrl() {
        return this.headwearPicUrl;
    }

    @NotNull
    public final MicroUserBean copy(int tag, @NotNull String externalId, @NotNull String avatar, @NotNull String nick, int sex, @NotNull String code, boolean isVip, int noble, @NotNull String headwearPicUrl, @NotNull String headwearEffectUrl, @NotNull String headwearReverseEffectUrl, int svipLevel, @Nullable SvipData svip, @Nullable String micEffect, @Nullable String headwearIcon, @Nullable Boolean music) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(headwearPicUrl, "headwearPicUrl");
        Intrinsics.checkNotNullParameter(headwearEffectUrl, "headwearEffectUrl");
        Intrinsics.checkNotNullParameter(headwearReverseEffectUrl, "headwearReverseEffectUrl");
        return new MicroUserBean(tag, externalId, avatar, nick, sex, code, isVip, noble, headwearPicUrl, headwearEffectUrl, headwearReverseEffectUrl, svipLevel, svip, micEffect, headwearIcon, music);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MicroUserBean)) {
            return false;
        }
        MicroUserBean microUserBean = (MicroUserBean) other;
        return this.tag == microUserBean.tag && Intrinsics.areEqual(this.externalId, microUserBean.externalId) && Intrinsics.areEqual(this.avatar, microUserBean.avatar) && Intrinsics.areEqual(this.nick, microUserBean.nick) && this.sex == microUserBean.sex && Intrinsics.areEqual(this.code, microUserBean.code) && this.isVip == microUserBean.isVip && this.noble == microUserBean.noble && Intrinsics.areEqual(this.headwearPicUrl, microUserBean.headwearPicUrl) && Intrinsics.areEqual(this.headwearEffectUrl, microUserBean.headwearEffectUrl) && Intrinsics.areEqual(this.headwearReverseEffectUrl, microUserBean.headwearReverseEffectUrl) && this.svipLevel == microUserBean.svipLevel && Intrinsics.areEqual(this.svip, microUserBean.svip) && Intrinsics.areEqual(this.micEffect, microUserBean.micEffect) && Intrinsics.areEqual(this.headwearIcon, microUserBean.headwearIcon) && Intrinsics.areEqual(this.music, microUserBean.music);
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
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final String getHeadwearEffectUrl() {
        return this.headwearEffectUrl;
    }

    @Nullable
    public final String getHeadwearIcon() {
        return this.headwearIcon;
    }

    @NotNull
    public final String getHeadwearPicUrl() {
        return this.headwearPicUrl;
    }

    @NotNull
    public final String getHeadwearReverseEffectUrl() {
        return this.headwearReverseEffectUrl;
    }

    @Nullable
    public final String getMicEffect() {
        return this.micEffect;
    }

    @Nullable
    public final Boolean getMusic() {
        return this.music;
    }

    @NotNull
    public final String getNick() {
        return this.nick;
    }

    public final int getNoble() {
        return this.noble;
    }

    public final int getSex() {
        return this.sex;
    }

    @Nullable
    public final SvipData getSvip() {
        return this.svip;
    }

    public final int getSvipLevel() {
        return this.svipLevel;
    }

    public final int getTag() {
        return this.tag;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.tag * 31) + this.externalId.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.nick.hashCode()) * 31) + this.sex) * 31) + this.code.hashCode()) * 31) + a.a(this.isVip)) * 31) + this.noble) * 31) + this.headwearPicUrl.hashCode()) * 31) + this.headwearEffectUrl.hashCode()) * 31) + this.headwearReverseEffectUrl.hashCode()) * 31) + this.svipLevel) * 31;
        SvipData svipData = this.svip;
        int hashCode2 = (hashCode + (svipData == null ? 0 : svipData.hashCode())) * 31;
        String str = this.micEffect;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.headwearIcon;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.music;
        return hashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final void setExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.externalId = str;
    }

    public final void setHeadwearEffectUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headwearEffectUrl = str;
    }

    public final void setHeadwearIcon(@Nullable String str) {
        this.headwearIcon = str;
    }

    public final void setHeadwearPicUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headwearPicUrl = str;
    }

    public final void setHeadwearReverseEffectUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headwearReverseEffectUrl = str;
    }

    public final void setMicEffect(@Nullable String str) {
        this.micEffect = str;
    }

    public final void setMusic(@Nullable Boolean bool) {
        this.music = bool;
    }

    public final void setNick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nick = str;
    }

    public final void setNoble(int i) {
        this.noble = i;
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setSvipLevel(int i) {
        this.svipLevel = i;
    }

    public final void setTag(int i) {
        this.tag = i;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    @NotNull
    public String toString() {
        return "MicroUserBean(tag=" + this.tag + ", externalId=" + this.externalId + ", avatar=" + this.avatar + ", nick=" + this.nick + ", sex=" + this.sex + ", code=" + this.code + ", isVip=" + this.isVip + ", noble=" + this.noble + ", headwearPicUrl=" + this.headwearPicUrl + ", headwearEffectUrl=" + this.headwearEffectUrl + ", headwearReverseEffectUrl=" + this.headwearReverseEffectUrl + ", svipLevel=" + this.svipLevel + ", svip=" + this.svip + ", micEffect=" + this.micEffect + ", headwearIcon=" + this.headwearIcon + ", music=" + this.music + ")";
    }

    public /* synthetic */ MicroUserBean(int i, String str, String str2, String str3, int i2, String str4, boolean z, int i3, String str5, String str6, String str7, int i4, SvipData svipData, String str8, String str9, Boolean bool, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, str, str2, str3, i2, str4, (i5 & 64) != 0 ? false : z, i3, (i5 & 256) != 0 ? "" : str5, (i5 & 512) != 0 ? "" : str6, (i5 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? "" : str7, i4, (i5 & 4096) != 0 ? null : svipData, (i5 & 8192) != 0 ? null : str8, (i5 & 16384) != 0 ? null : str9, (i5 & 32768) != 0 ? Boolean.FALSE : bool);
    }
}
