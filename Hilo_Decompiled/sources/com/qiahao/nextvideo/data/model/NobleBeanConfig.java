package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0019\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000eHÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010D\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'JÀ\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0003HÖ\u0001J\t\u0010K\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010-R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010-R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "", "dailyGold", "", "duration", "headdressId", "level", "picUrl", "", "purchasePrice", "renewalPrice", "rideId", "privileges", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "l8Diamond", "", "l8DiamondGetDesc", "l9Diamond", "l9DiamondGetDesc", "l8Noble10Diamond", "l9Noble10Diamond", "<init>", "(IIIILjava/lang/String;IIILjava/util/ArrayList;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getDailyGold", "()I", "getDuration", "getHeaddressId", "getLevel", "getPicUrl", "()Ljava/lang/String;", "getPurchasePrice", "getRenewalPrice", "getRideId", "getPrivileges", "()Ljava/util/ArrayList;", "setPrivileges", "(Ljava/util/ArrayList;)V", "getL8Diamond", "()Ljava/lang/Long;", "setL8Diamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getL8DiamondGetDesc", "setL8DiamondGetDesc", "(Ljava/lang/String;)V", "getL9Diamond", "setL9Diamond", "getL9DiamondGetDesc", "setL9DiamondGetDesc", "getL8Noble10Diamond", "setL8Noble10Diamond", "getL9Noble10Diamond", "setL9Noble10Diamond", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(IIIILjava/lang/String;IIILjava/util/ArrayList;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class NobleBeanConfig {
    private final int dailyGold;
    private final int duration;
    private final int headdressId;

    @Nullable
    private Long l8Diamond;

    @Nullable
    private String l8DiamondGetDesc;

    @Nullable
    private Long l8Noble10Diamond;

    @Nullable
    private Long l9Diamond;

    @Nullable
    private String l9DiamondGetDesc;

    @Nullable
    private Long l9Noble10Diamond;
    private final int level;

    @NotNull
    private final String picUrl;

    @NotNull
    private ArrayList<Integer> privileges;
    private final int purchasePrice;
    private final int renewalPrice;
    private final int rideId;

    public NobleBeanConfig(int i, int i2, int i3, int i4, @NotNull String str, int i5, int i6, int i7, @NotNull ArrayList<Integer> arrayList, @Nullable Long l, @Nullable String str2, @Nullable Long l2, @Nullable String str3, @Nullable Long l3, @Nullable Long l4) {
        Intrinsics.checkNotNullParameter(str, "picUrl");
        Intrinsics.checkNotNullParameter(arrayList, "privileges");
        this.dailyGold = i;
        this.duration = i2;
        this.headdressId = i3;
        this.level = i4;
        this.picUrl = str;
        this.purchasePrice = i5;
        this.renewalPrice = i6;
        this.rideId = i7;
        this.privileges = arrayList;
        this.l8Diamond = l;
        this.l8DiamondGetDesc = str2;
        this.l9Diamond = l2;
        this.l9DiamondGetDesc = str3;
        this.l8Noble10Diamond = l3;
        this.l9Noble10Diamond = l4;
    }

    /* renamed from: component1, reason: from getter */
    public final int getDailyGold() {
        return this.dailyGold;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Long getL8Diamond() {
        return this.l8Diamond;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getL8DiamondGetDesc() {
        return this.l8DiamondGetDesc;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Long getL9Diamond() {
        return this.l9Diamond;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getL9DiamondGetDesc() {
        return this.l9DiamondGetDesc;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Long getL8Noble10Diamond() {
        return this.l8Noble10Diamond;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Long getL9Noble10Diamond() {
        return this.l9Noble10Diamond;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeaddressId() {
        return this.headdressId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPurchasePrice() {
        return this.purchasePrice;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRenewalPrice() {
        return this.renewalPrice;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRideId() {
        return this.rideId;
    }

    @NotNull
    public final ArrayList<Integer> component9() {
        return this.privileges;
    }

    @NotNull
    public final NobleBeanConfig copy(int dailyGold, int duration, int headdressId, int level, @NotNull String picUrl, int purchasePrice, int renewalPrice, int rideId, @NotNull ArrayList<Integer> privileges, @Nullable Long l8Diamond, @Nullable String l8DiamondGetDesc, @Nullable Long l9Diamond, @Nullable String l9DiamondGetDesc, @Nullable Long l8Noble10Diamond, @Nullable Long l9Noble10Diamond) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(privileges, "privileges");
        return new NobleBeanConfig(dailyGold, duration, headdressId, level, picUrl, purchasePrice, renewalPrice, rideId, privileges, l8Diamond, l8DiamondGetDesc, l9Diamond, l9DiamondGetDesc, l8Noble10Diamond, l9Noble10Diamond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NobleBeanConfig)) {
            return false;
        }
        NobleBeanConfig nobleBeanConfig = (NobleBeanConfig) other;
        return this.dailyGold == nobleBeanConfig.dailyGold && this.duration == nobleBeanConfig.duration && this.headdressId == nobleBeanConfig.headdressId && this.level == nobleBeanConfig.level && Intrinsics.areEqual(this.picUrl, nobleBeanConfig.picUrl) && this.purchasePrice == nobleBeanConfig.purchasePrice && this.renewalPrice == nobleBeanConfig.renewalPrice && this.rideId == nobleBeanConfig.rideId && Intrinsics.areEqual(this.privileges, nobleBeanConfig.privileges) && Intrinsics.areEqual(this.l8Diamond, nobleBeanConfig.l8Diamond) && Intrinsics.areEqual(this.l8DiamondGetDesc, nobleBeanConfig.l8DiamondGetDesc) && Intrinsics.areEqual(this.l9Diamond, nobleBeanConfig.l9Diamond) && Intrinsics.areEqual(this.l9DiamondGetDesc, nobleBeanConfig.l9DiamondGetDesc) && Intrinsics.areEqual(this.l8Noble10Diamond, nobleBeanConfig.l8Noble10Diamond) && Intrinsics.areEqual(this.l9Noble10Diamond, nobleBeanConfig.l9Noble10Diamond);
    }

    public final int getDailyGold() {
        return this.dailyGold;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getHeaddressId() {
        return this.headdressId;
    }

    @Nullable
    public final Long getL8Diamond() {
        return this.l8Diamond;
    }

    @Nullable
    public final String getL8DiamondGetDesc() {
        return this.l8DiamondGetDesc;
    }

    @Nullable
    public final Long getL8Noble10Diamond() {
        return this.l8Noble10Diamond;
    }

    @Nullable
    public final Long getL9Diamond() {
        return this.l9Diamond;
    }

    @Nullable
    public final String getL9DiamondGetDesc() {
        return this.l9DiamondGetDesc;
    }

    @Nullable
    public final Long getL9Noble10Diamond() {
        return this.l9Noble10Diamond;
    }

    public final int getLevel() {
        return this.level;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final ArrayList<Integer> getPrivileges() {
        return this.privileges;
    }

    public final int getPurchasePrice() {
        return this.purchasePrice;
    }

    public final int getRenewalPrice() {
        return this.renewalPrice;
    }

    public final int getRideId() {
        return this.rideId;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.dailyGold * 31) + this.duration) * 31) + this.headdressId) * 31) + this.level) * 31) + this.picUrl.hashCode()) * 31) + this.purchasePrice) * 31) + this.renewalPrice) * 31) + this.rideId) * 31) + this.privileges.hashCode()) * 31;
        Long l = this.l8Diamond;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.l8DiamondGetDesc;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l2 = this.l9Diamond;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.l9DiamondGetDesc;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l3 = this.l8Noble10Diamond;
        int hashCode6 = (hashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.l9Noble10Diamond;
        return hashCode6 + (l4 != null ? l4.hashCode() : 0);
    }

    public final void setL8Diamond(@Nullable Long l) {
        this.l8Diamond = l;
    }

    public final void setL8DiamondGetDesc(@Nullable String str) {
        this.l8DiamondGetDesc = str;
    }

    public final void setL8Noble10Diamond(@Nullable Long l) {
        this.l8Noble10Diamond = l;
    }

    public final void setL9Diamond(@Nullable Long l) {
        this.l9Diamond = l;
    }

    public final void setL9DiamondGetDesc(@Nullable String str) {
        this.l9DiamondGetDesc = str;
    }

    public final void setL9Noble10Diamond(@Nullable Long l) {
        this.l9Noble10Diamond = l;
    }

    public final void setPrivileges(@NotNull ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.privileges = arrayList;
    }

    @NotNull
    public String toString() {
        return "NobleBeanConfig(dailyGold=" + this.dailyGold + ", duration=" + this.duration + ", headdressId=" + this.headdressId + ", level=" + this.level + ", picUrl=" + this.picUrl + ", purchasePrice=" + this.purchasePrice + ", renewalPrice=" + this.renewalPrice + ", rideId=" + this.rideId + ", privileges=" + this.privileges + ", l8Diamond=" + this.l8Diamond + ", l8DiamondGetDesc=" + this.l8DiamondGetDesc + ", l9Diamond=" + this.l9Diamond + ", l9DiamondGetDesc=" + this.l9DiamondGetDesc + ", l8Noble10Diamond=" + this.l8Noble10Diamond + ", l9Noble10Diamond=" + this.l9Noble10Diamond + ")";
    }

    public /* synthetic */ NobleBeanConfig(int i, int i2, int i3, int i4, String str, int i5, int i6, int i7, ArrayList arrayList, Long l, String str2, Long l2, String str3, Long l3, Long l4, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, str, i5, i6, i7, arrayList, (i8 & 512) != 0 ? null : l, (i8 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str2, (i8 & 2048) != 0 ? null : l2, (i8 & 4096) != 0 ? null : str3, (i8 & 8192) != 0 ? null : l3, (i8 & 16384) != 0 ? null : l4);
    }
}
