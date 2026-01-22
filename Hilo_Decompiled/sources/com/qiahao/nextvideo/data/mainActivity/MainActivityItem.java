package com.qiahao.nextvideo.data.mainActivity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 Jh\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u000e\u0010 \"\u0004\b*\u0010\"¨\u00068"}, d2 = {"Lcom/qiahao/nextvideo/data/mainActivity/MainActivityItem;", "", "charge", "", "diamondNum", "", "diamondNumPicUrl", "", "hasGetReward", "", "productId", "awards", "", "Lcom/qiahao/nextvideo/data/mainActivity/MainAwardData;", "isCanRecharge", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "getCharge", "()Ljava/lang/Integer;", "setCharge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDiamondNum", "()Ljava/lang/Long;", "setDiamondNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDiamondNumPicUrl", "()Ljava/lang/String;", "setDiamondNumPicUrl", "(Ljava/lang/String;)V", "getHasGetReward", "()Ljava/lang/Boolean;", "setHasGetReward", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getProductId", "setProductId", "getAwards", "()Ljava/util/List;", "setAwards", "(Ljava/util/List;)V", "setCanRecharge", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/mainActivity/MainActivityItem;", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MainActivityItem {

    @Nullable
    private List<MainAwardData> awards;

    @Nullable
    private Integer charge;

    @Nullable
    private Long diamondNum;

    @Nullable
    private String diamondNumPicUrl;

    @Nullable
    private Boolean hasGetReward;

    @Nullable
    private Boolean isCanRecharge;

    @Nullable
    private String productId;

    public MainActivityItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ MainActivityItem copy$default(MainActivityItem mainActivityItem, Integer num, Long l, String str, Boolean bool, String str2, List list, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mainActivityItem.charge;
        }
        if ((i & 2) != 0) {
            l = mainActivityItem.diamondNum;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str = mainActivityItem.diamondNumPicUrl;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            bool = mainActivityItem.hasGetReward;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            str2 = mainActivityItem.productId;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            list = mainActivityItem.awards;
        }
        List list2 = list;
        if ((i & 64) != 0) {
            bool2 = mainActivityItem.isCanRecharge;
        }
        return mainActivityItem.copy(num, l2, str3, bool3, str4, list2, bool2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCharge() {
        return this.charge;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getDiamondNumPicUrl() {
        return this.diamondNumPicUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getHasGetReward() {
        return this.hasGetReward;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    public final List<MainAwardData> component6() {
        return this.awards;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getIsCanRecharge() {
        return this.isCanRecharge;
    }

    @NotNull
    public final MainActivityItem copy(@Nullable Integer charge, @Nullable Long diamondNum, @Nullable String diamondNumPicUrl, @Nullable Boolean hasGetReward, @Nullable String productId, @Nullable List<MainAwardData> awards, @Nullable Boolean isCanRecharge) {
        return new MainActivityItem(charge, diamondNum, diamondNumPicUrl, hasGetReward, productId, awards, isCanRecharge);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainActivityItem)) {
            return false;
        }
        MainActivityItem mainActivityItem = (MainActivityItem) other;
        return Intrinsics.areEqual(this.charge, mainActivityItem.charge) && Intrinsics.areEqual(this.diamondNum, mainActivityItem.diamondNum) && Intrinsics.areEqual(this.diamondNumPicUrl, mainActivityItem.diamondNumPicUrl) && Intrinsics.areEqual(this.hasGetReward, mainActivityItem.hasGetReward) && Intrinsics.areEqual(this.productId, mainActivityItem.productId) && Intrinsics.areEqual(this.awards, mainActivityItem.awards) && Intrinsics.areEqual(this.isCanRecharge, mainActivityItem.isCanRecharge);
    }

    @Nullable
    public final List<MainAwardData> getAwards() {
        return this.awards;
    }

    @Nullable
    public final Integer getCharge() {
        return this.charge;
    }

    @Nullable
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final String getDiamondNumPicUrl() {
        return this.diamondNumPicUrl;
    }

    @Nullable
    public final Boolean getHasGetReward() {
        return this.hasGetReward;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        Integer num = this.charge;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.diamondNum;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.diamondNumPicUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.hasGetReward;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.productId;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MainAwardData> list = this.awards;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool2 = this.isCanRecharge;
        return hashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isCanRecharge() {
        return this.isCanRecharge;
    }

    public final void setAwards(@Nullable List<MainAwardData> list) {
        this.awards = list;
    }

    public final void setCanRecharge(@Nullable Boolean bool) {
        this.isCanRecharge = bool;
    }

    public final void setCharge(@Nullable Integer num) {
        this.charge = num;
    }

    public final void setDiamondNum(@Nullable Long l) {
        this.diamondNum = l;
    }

    public final void setDiamondNumPicUrl(@Nullable String str) {
        this.diamondNumPicUrl = str;
    }

    public final void setHasGetReward(@Nullable Boolean bool) {
        this.hasGetReward = bool;
    }

    public final void setProductId(@Nullable String str) {
        this.productId = str;
    }

    @NotNull
    public String toString() {
        return "MainActivityItem(charge=" + this.charge + ", diamondNum=" + this.diamondNum + ", diamondNumPicUrl=" + this.diamondNumPicUrl + ", hasGetReward=" + this.hasGetReward + ", productId=" + this.productId + ", awards=" + this.awards + ", isCanRecharge=" + this.isCanRecharge + ")";
    }

    public MainActivityItem(@Nullable Integer num, @Nullable Long l, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable List<MainAwardData> list, @Nullable Boolean bool2) {
        this.charge = num;
        this.diamondNum = l;
        this.diamondNumPicUrl = str;
        this.hasGetReward = bool;
        this.productId = str2;
        this.awards = list;
        this.isCanRecharge = bool2;
    }

    public /* synthetic */ MainActivityItem(Integer num, Long l, String str, Boolean bool, String str2, List list, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : bool2);
    }
}
