package com.qiahao.nextvideo.data.service.match;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJb\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/data/service/match/MatchConfigData;", "", "minuteDiamond", "", "remainCard", "signNoVipDayN", "signVipDayN", "timeGiftId", "giftDiamond", "goddessOpenClose", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getMinuteDiamond", "()Ljava/lang/Integer;", "setMinuteDiamond", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRemainCard", "setRemainCard", "getSignNoVipDayN", "setSignNoVipDayN", "getSignVipDayN", "setSignVipDayN", "getTimeGiftId", "setTimeGiftId", "getGiftDiamond", "setGiftDiamond", "getGoddessOpenClose", "()Ljava/lang/Boolean;", "setGoddessOpenClose", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/service/match/MatchConfigData;", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MatchConfigData {

    @Nullable
    private Integer giftDiamond;

    @Nullable
    private Boolean goddessOpenClose;

    @Nullable
    private Integer minuteDiamond;

    @Nullable
    private Integer remainCard;

    @Nullable
    private Integer signNoVipDayN;

    @Nullable
    private Integer signVipDayN;

    @Nullable
    private Integer timeGiftId;

    public MatchConfigData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MatchConfigData copy$default(MatchConfigData matchConfigData, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = matchConfigData.minuteDiamond;
        }
        if ((i & 2) != 0) {
            num2 = matchConfigData.remainCard;
        }
        Integer num7 = num2;
        if ((i & 4) != 0) {
            num3 = matchConfigData.signNoVipDayN;
        }
        Integer num8 = num3;
        if ((i & 8) != 0) {
            num4 = matchConfigData.signVipDayN;
        }
        Integer num9 = num4;
        if ((i & 16) != 0) {
            num5 = matchConfigData.timeGiftId;
        }
        Integer num10 = num5;
        if ((i & 32) != 0) {
            num6 = matchConfigData.giftDiamond;
        }
        Integer num11 = num6;
        if ((i & 64) != 0) {
            bool = matchConfigData.goddessOpenClose;
        }
        return matchConfigData.copy(num, num7, num8, num9, num10, num11, bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getMinuteDiamond() {
        return this.minuteDiamond;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getRemainCard() {
        return this.remainCard;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getSignNoVipDayN() {
        return this.signNoVipDayN;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getSignVipDayN() {
        return this.signVipDayN;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getTimeGiftId() {
        return this.timeGiftId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getGiftDiamond() {
        return this.giftDiamond;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getGoddessOpenClose() {
        return this.goddessOpenClose;
    }

    @NotNull
    public final MatchConfigData copy(@Nullable Integer minuteDiamond, @Nullable Integer remainCard, @Nullable Integer signNoVipDayN, @Nullable Integer signVipDayN, @Nullable Integer timeGiftId, @Nullable Integer giftDiamond, @Nullable Boolean goddessOpenClose) {
        return new MatchConfigData(minuteDiamond, remainCard, signNoVipDayN, signVipDayN, timeGiftId, giftDiamond, goddessOpenClose);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchConfigData)) {
            return false;
        }
        MatchConfigData matchConfigData = (MatchConfigData) other;
        return Intrinsics.areEqual(this.minuteDiamond, matchConfigData.minuteDiamond) && Intrinsics.areEqual(this.remainCard, matchConfigData.remainCard) && Intrinsics.areEqual(this.signNoVipDayN, matchConfigData.signNoVipDayN) && Intrinsics.areEqual(this.signVipDayN, matchConfigData.signVipDayN) && Intrinsics.areEqual(this.timeGiftId, matchConfigData.timeGiftId) && Intrinsics.areEqual(this.giftDiamond, matchConfigData.giftDiamond) && Intrinsics.areEqual(this.goddessOpenClose, matchConfigData.goddessOpenClose);
    }

    @Nullable
    public final Integer getGiftDiamond() {
        return this.giftDiamond;
    }

    @Nullable
    public final Boolean getGoddessOpenClose() {
        return this.goddessOpenClose;
    }

    @Nullable
    public final Integer getMinuteDiamond() {
        return this.minuteDiamond;
    }

    @Nullable
    public final Integer getRemainCard() {
        return this.remainCard;
    }

    @Nullable
    public final Integer getSignNoVipDayN() {
        return this.signNoVipDayN;
    }

    @Nullable
    public final Integer getSignVipDayN() {
        return this.signVipDayN;
    }

    @Nullable
    public final Integer getTimeGiftId() {
        return this.timeGiftId;
    }

    public int hashCode() {
        Integer num = this.minuteDiamond;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.remainCard;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.signNoVipDayN;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.signVipDayN;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.timeGiftId;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.giftDiamond;
        int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Boolean bool = this.goddessOpenClose;
        return hashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setGiftDiamond(@Nullable Integer num) {
        this.giftDiamond = num;
    }

    public final void setGoddessOpenClose(@Nullable Boolean bool) {
        this.goddessOpenClose = bool;
    }

    public final void setMinuteDiamond(@Nullable Integer num) {
        this.minuteDiamond = num;
    }

    public final void setRemainCard(@Nullable Integer num) {
        this.remainCard = num;
    }

    public final void setSignNoVipDayN(@Nullable Integer num) {
        this.signNoVipDayN = num;
    }

    public final void setSignVipDayN(@Nullable Integer num) {
        this.signVipDayN = num;
    }

    public final void setTimeGiftId(@Nullable Integer num) {
        this.timeGiftId = num;
    }

    @NotNull
    public String toString() {
        return "MatchConfigData(minuteDiamond=" + this.minuteDiamond + ", remainCard=" + this.remainCard + ", signNoVipDayN=" + this.signNoVipDayN + ", signVipDayN=" + this.signVipDayN + ", timeGiftId=" + this.timeGiftId + ", giftDiamond=" + this.giftDiamond + ", goddessOpenClose=" + this.goddessOpenClose + ")";
    }

    public MatchConfigData(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6, @Nullable Boolean bool) {
        this.minuteDiamond = num;
        this.remainCard = num2;
        this.signNoVipDayN = num3;
        this.signVipDayN = num4;
        this.timeGiftId = num5;
        this.giftDiamond = num6;
        this.goddessOpenClose = bool;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MatchConfigData(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? r0 : num, (i & 2) != 0 ? r0 : num2, (i & 4) != 0 ? r0 : num3, (i & 8) != 0 ? r0 : num4, (i & 16) != 0 ? r0 : num5, (i & 32) == 0 ? num6 : 0, (i & 64) != 0 ? Boolean.TRUE : bool);
    }
}
