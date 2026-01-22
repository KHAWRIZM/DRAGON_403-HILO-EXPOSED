package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.svip.SvipData;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u008e\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0007HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b+\u0010%\"\u0004\b,\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'¨\u0006D"}, d2 = {"Lcom/qiahao/nextvideo/data/model/EnterEffectData;", "", "userName", "", "isVip", "", "nobleLevel", "", "svip", "Lcom/qiahao/base_common/model/svip/SvipData;", "userAvatar", "cpLevel", "cpUserAvatar", "entryEffectType", Constants.KEY_HTTP_CODE, "content", "svipLevel", "<init>", "(Ljava/lang/String;ZILcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "()Z", "setVip", "(Z)V", "getNobleLevel", "()I", "setNobleLevel", "(I)V", "getSvip", "()Lcom/qiahao/base_common/model/svip/SvipData;", "setSvip", "(Lcom/qiahao/base_common/model/svip/SvipData;)V", "getUserAvatar", "setUserAvatar", "getCpLevel", "()Ljava/lang/Integer;", "setCpLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCpUserAvatar", "setCpUserAvatar", "getEntryEffectType", "setEntryEffectType", "getCode", "setCode", "getContent", "setContent", "getSvipLevel", "setSvipLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;ZILcom/qiahao/base_common/model/svip/SvipData;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/EnterEffectData;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EnterEffectData {

    @Nullable
    private String code;

    @Nullable
    private String content;

    @Nullable
    private Integer cpLevel;

    @Nullable
    private String cpUserAvatar;

    @Nullable
    private Integer entryEffectType;
    private boolean isVip;
    private int nobleLevel;

    @Nullable
    private SvipData svip;

    @Nullable
    private Integer svipLevel;

    @Nullable
    private String userAvatar;

    @Nullable
    private String userName;

    public EnterEffectData(@Nullable String str, boolean z, int i, @Nullable SvipData svipData, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Integer num2, @Nullable String str4, @Nullable String str5, @Nullable Integer num3) {
        this.userName = str;
        this.isVip = z;
        this.nobleLevel = i;
        this.svip = svipData;
        this.userAvatar = str2;
        this.cpLevel = num;
        this.cpUserAvatar = str3;
        this.entryEffectType = num2;
        this.code = str4;
        this.content = str5;
        this.svipLevel = num3;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final SvipData getSvip() {
        return this.svip;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getCpUserAvatar() {
        return this.cpUserAvatar;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getEntryEffectType() {
        return this.entryEffectType;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final EnterEffectData copy(@Nullable String userName, boolean isVip, int nobleLevel, @Nullable SvipData svip, @Nullable String userAvatar, @Nullable Integer cpLevel, @Nullable String cpUserAvatar, @Nullable Integer entryEffectType, @Nullable String code, @Nullable String content, @Nullable Integer svipLevel) {
        return new EnterEffectData(userName, isVip, nobleLevel, svip, userAvatar, cpLevel, cpUserAvatar, entryEffectType, code, content, svipLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterEffectData)) {
            return false;
        }
        EnterEffectData enterEffectData = (EnterEffectData) other;
        return Intrinsics.areEqual(this.userName, enterEffectData.userName) && this.isVip == enterEffectData.isVip && this.nobleLevel == enterEffectData.nobleLevel && Intrinsics.areEqual(this.svip, enterEffectData.svip) && Intrinsics.areEqual(this.userAvatar, enterEffectData.userAvatar) && Intrinsics.areEqual(this.cpLevel, enterEffectData.cpLevel) && Intrinsics.areEqual(this.cpUserAvatar, enterEffectData.cpUserAvatar) && Intrinsics.areEqual(this.entryEffectType, enterEffectData.entryEffectType) && Intrinsics.areEqual(this.code, enterEffectData.code) && Intrinsics.areEqual(this.content, enterEffectData.content) && Intrinsics.areEqual(this.svipLevel, enterEffectData.svipLevel);
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Integer getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final String getCpUserAvatar() {
        return this.cpUserAvatar;
    }

    @Nullable
    public final Integer getEntryEffectType() {
        return this.entryEffectType;
    }

    public final int getNobleLevel() {
        return this.nobleLevel;
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
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    @Nullable
    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.userName;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + a.a(this.isVip)) * 31) + this.nobleLevel) * 31;
        SvipData svipData = this.svip;
        int hashCode2 = (hashCode + (svipData == null ? 0 : svipData.hashCode())) * 31;
        String str2 = this.userAvatar;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.cpLevel;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.cpUserAvatar;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.entryEffectType;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.code;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.content;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num3 = this.svipLevel;
        return hashCode8 + (num3 != null ? num3.hashCode() : 0);
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setCpLevel(@Nullable Integer num) {
        this.cpLevel = num;
    }

    public final void setCpUserAvatar(@Nullable String str) {
        this.cpUserAvatar = str;
    }

    public final void setEntryEffectType(@Nullable Integer num) {
        this.entryEffectType = num;
    }

    public final void setNobleLevel(int i) {
        this.nobleLevel = i;
    }

    public final void setSvip(@Nullable SvipData svipData) {
        this.svip = svipData;
    }

    public final void setSvipLevel(@Nullable Integer num) {
        this.svipLevel = num;
    }

    public final void setUserAvatar(@Nullable String str) {
        this.userAvatar = str;
    }

    public final void setUserName(@Nullable String str) {
        this.userName = str;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    @NotNull
    public String toString() {
        return "EnterEffectData(userName=" + this.userName + ", isVip=" + this.isVip + ", nobleLevel=" + this.nobleLevel + ", svip=" + this.svip + ", userAvatar=" + this.userAvatar + ", cpLevel=" + this.cpLevel + ", cpUserAvatar=" + this.cpUserAvatar + ", entryEffectType=" + this.entryEffectType + ", code=" + this.code + ", content=" + this.content + ", svipLevel=" + this.svipLevel + ")";
    }

    public /* synthetic */ EnterEffectData(String str, boolean z, int i, SvipData svipData, String str2, Integer num, String str3, Integer num2, String str4, String str5, Integer num3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? false : z, i, (i2 & 8) != 0 ? null : svipData, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : str3, (i2 & 128) != 0 ? null : num2, (i2 & 256) != 0 ? null : str4, (i2 & 512) != 0 ? null : str5, (i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : num3);
    }
}
