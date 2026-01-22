package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import anet.channel.entity.EventType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b9\b\u0087\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010D\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010E\u001a\u00020\u0013HÆ\u0003J¢\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0013HÖ\u0001J\t\u0010K\u001a\u00020\u000bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u0005\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u0007\u0010\u001d\"\u0004\b!\u0010\u001fR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006L"}, d2 = {"Lcom/qiahao/hilo_message/data/CloudCustomData;", "", "wealthGrade", "", "charmGrade", "isVip", "", "isPretty", "medals", "", "powerName", "", "nobleLevel", "svipLevel", "powerNameplate", "powerGrade", "svip", "Lcom/qiahao/hilo_message/data/GMSvipDetail;", "cornerMark", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/qiahao/hilo_message/data/GMSvipDetail;I)V", "getWealthGrade", "()Ljava/lang/Long;", "setWealthGrade", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCharmGrade", "setCharmGrade", "()Ljava/lang/Boolean;", "setVip", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setPretty", "getMedals", "()Ljava/util/List;", "setMedals", "(Ljava/util/List;)V", "getPowerName", "()Ljava/lang/String;", "setPowerName", "(Ljava/lang/String;)V", "getNobleLevel", "setNobleLevel", "getSvipLevel", "setSvipLevel", "getPowerNameplate", "setPowerNameplate", "getPowerGrade", "setPowerGrade", "getSvip", "()Lcom/qiahao/hilo_message/data/GMSvipDetail;", "setSvip", "(Lcom/qiahao/hilo_message/data/GMSvipDetail;)V", "getCornerMark", "()I", "setCornerMark", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/qiahao/hilo_message/data/GMSvipDetail;I)Lcom/qiahao/hilo_message/data/CloudCustomData;", "equals", "other", "hashCode", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CloudCustomData {

    @Nullable
    private Long charmGrade;
    private int cornerMark;

    @Nullable
    private Boolean isPretty;

    @Nullable
    private Boolean isVip;

    @Nullable
    private List<Long> medals;

    @Nullable
    private Long nobleLevel;

    @Nullable
    private Long powerGrade;

    @Nullable
    private String powerName;

    @Nullable
    private String powerNameplate;

    @Nullable
    private GMSvipDetail svip;

    @Nullable
    private Long svipLevel;

    @Nullable
    private Long wealthGrade;

    public CloudCustomData() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, EventType.ALL, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getWealthGrade() {
        return this.wealthGrade;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Long getPowerGrade() {
        return this.powerGrade;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final GMSvipDetail getSvip() {
        return this.svip;
    }

    /* renamed from: component12, reason: from getter */
    public final int getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getCharmGrade() {
        return this.charmGrade;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getIsVip() {
        return this.isVip;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getIsPretty() {
        return this.isPretty;
    }

    @Nullable
    public final List<Long> component5() {
        return this.medals;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getPowerName() {
        return this.powerName;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Long getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getPowerNameplate() {
        return this.powerNameplate;
    }

    @NotNull
    public final CloudCustomData copy(@Nullable Long wealthGrade, @Nullable Long charmGrade, @Nullable Boolean isVip, @Nullable Boolean isPretty, @Nullable List<Long> medals, @Nullable String powerName, @Nullable Long nobleLevel, @Nullable Long svipLevel, @Nullable String powerNameplate, @Nullable Long powerGrade, @Nullable GMSvipDetail svip, int cornerMark) {
        return new CloudCustomData(wealthGrade, charmGrade, isVip, isPretty, medals, powerName, nobleLevel, svipLevel, powerNameplate, powerGrade, svip, cornerMark);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudCustomData)) {
            return false;
        }
        CloudCustomData cloudCustomData = (CloudCustomData) other;
        return Intrinsics.areEqual(this.wealthGrade, cloudCustomData.wealthGrade) && Intrinsics.areEqual(this.charmGrade, cloudCustomData.charmGrade) && Intrinsics.areEqual(this.isVip, cloudCustomData.isVip) && Intrinsics.areEqual(this.isPretty, cloudCustomData.isPretty) && Intrinsics.areEqual(this.medals, cloudCustomData.medals) && Intrinsics.areEqual(this.powerName, cloudCustomData.powerName) && Intrinsics.areEqual(this.nobleLevel, cloudCustomData.nobleLevel) && Intrinsics.areEqual(this.svipLevel, cloudCustomData.svipLevel) && Intrinsics.areEqual(this.powerNameplate, cloudCustomData.powerNameplate) && Intrinsics.areEqual(this.powerGrade, cloudCustomData.powerGrade) && Intrinsics.areEqual(this.svip, cloudCustomData.svip) && this.cornerMark == cloudCustomData.cornerMark;
    }

    @Nullable
    public final Long getCharmGrade() {
        return this.charmGrade;
    }

    public final int getCornerMark() {
        return this.cornerMark;
    }

    @Nullable
    public final List<Long> getMedals() {
        return this.medals;
    }

    @Nullable
    public final Long getNobleLevel() {
        return this.nobleLevel;
    }

    @Nullable
    public final Long getPowerGrade() {
        return this.powerGrade;
    }

    @Nullable
    public final String getPowerName() {
        return this.powerName;
    }

    @Nullable
    public final String getPowerNameplate() {
        return this.powerNameplate;
    }

    @Nullable
    public final GMSvipDetail getSvip() {
        return this.svip;
    }

    @Nullable
    public final Long getSvipLevel() {
        return this.svipLevel;
    }

    @Nullable
    public final Long getWealthGrade() {
        return this.wealthGrade;
    }

    public int hashCode() {
        Long l10 = this.wealthGrade;
        int hashCode = (l10 == null ? 0 : l10.hashCode()) * 31;
        Long l11 = this.charmGrade;
        int hashCode2 = (hashCode + (l11 == null ? 0 : l11.hashCode())) * 31;
        Boolean bool = this.isVip;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isPretty;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        List<Long> list = this.medals;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.powerName;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Long l12 = this.nobleLevel;
        int hashCode7 = (hashCode6 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.svipLevel;
        int hashCode8 = (hashCode7 + (l13 == null ? 0 : l13.hashCode())) * 31;
        String str2 = this.powerNameplate;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l14 = this.powerGrade;
        int hashCode10 = (hashCode9 + (l14 == null ? 0 : l14.hashCode())) * 31;
        GMSvipDetail gMSvipDetail = this.svip;
        return this.cornerMark + ((hashCode10 + (gMSvipDetail != null ? gMSvipDetail.hashCode() : 0)) * 31);
    }

    @Nullable
    public final Boolean isPretty() {
        return this.isPretty;
    }

    @Nullable
    public final Boolean isVip() {
        return this.isVip;
    }

    public final void setCharmGrade(@Nullable Long l10) {
        this.charmGrade = l10;
    }

    public final void setCornerMark(int i10) {
        this.cornerMark = i10;
    }

    public final void setMedals(@Nullable List<Long> list) {
        this.medals = list;
    }

    public final void setNobleLevel(@Nullable Long l10) {
        this.nobleLevel = l10;
    }

    public final void setPowerGrade(@Nullable Long l10) {
        this.powerGrade = l10;
    }

    public final void setPowerName(@Nullable String str) {
        this.powerName = str;
    }

    public final void setPowerNameplate(@Nullable String str) {
        this.powerNameplate = str;
    }

    public final void setPretty(@Nullable Boolean bool) {
        this.isPretty = bool;
    }

    public final void setSvip(@Nullable GMSvipDetail gMSvipDetail) {
        this.svip = gMSvipDetail;
    }

    public final void setSvipLevel(@Nullable Long l10) {
        this.svipLevel = l10;
    }

    public final void setVip(@Nullable Boolean bool) {
        this.isVip = bool;
    }

    public final void setWealthGrade(@Nullable Long l10) {
        this.wealthGrade = l10;
    }

    @NotNull
    public String toString() {
        return "CloudCustomData(wealthGrade=" + this.wealthGrade + ", charmGrade=" + this.charmGrade + ", isVip=" + this.isVip + ", isPretty=" + this.isPretty + ", medals=" + this.medals + ", powerName=" + this.powerName + ", nobleLevel=" + this.nobleLevel + ", svipLevel=" + this.svipLevel + ", powerNameplate=" + this.powerNameplate + ", powerGrade=" + this.powerGrade + ", svip=" + this.svip + ", cornerMark=" + this.cornerMark + ")";
    }

    public CloudCustomData(@Nullable Long l10, @Nullable Long l11, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable List<Long> list, @Nullable String str, @Nullable Long l12, @Nullable Long l13, @Nullable String str2, @Nullable Long l14, @Nullable GMSvipDetail gMSvipDetail, int i10) {
        this.wealthGrade = l10;
        this.charmGrade = l11;
        this.isVip = bool;
        this.isPretty = bool2;
        this.medals = list;
        this.powerName = str;
        this.nobleLevel = l12;
        this.svipLevel = l13;
        this.powerNameplate = str2;
        this.powerGrade = l14;
        this.svip = gMSvipDetail;
        this.cornerMark = i10;
    }

    public /* synthetic */ CloudCustomData(Long l10, Long l11, Boolean bool, Boolean bool2, List list, String str, Long l12, Long l13, String str2, Long l14, GMSvipDetail gMSvipDetail, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : l10, (i11 & 2) != 0 ? null : l11, (i11 & 4) != 0 ? null : bool, (i11 & 8) != 0 ? null : bool2, (i11 & 16) != 0 ? null : list, (i11 & 32) != 0 ? null : str, (i11 & 64) != 0 ? null : l12, (i11 & 128) != 0 ? null : l13, (i11 & 256) != 0 ? null : str2, (i11 & 512) != 0 ? null : l14, (i11 & 1024) == 0 ? gMSvipDetail : null, (i11 & 2048) != 0 ? 0 : i10);
    }
}
