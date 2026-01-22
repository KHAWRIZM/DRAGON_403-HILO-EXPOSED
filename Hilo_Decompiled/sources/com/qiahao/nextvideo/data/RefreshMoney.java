package com.qiahao.nextvideo.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/RefreshMoney;", "", "diamondNum", "", "pinkDiamondNum", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getDiamondNum", "()Ljava/lang/Double;", "setDiamondNum", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getPinkDiamondNum", "setPinkDiamondNum", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/qiahao/nextvideo/data/RefreshMoney;", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RefreshMoney {

    @Nullable
    private Double diamondNum;

    @Nullable
    private Double pinkDiamondNum;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RefreshMoney() {
        this(r0, r0, 3, r0);
        Double d = null;
    }

    public static /* synthetic */ RefreshMoney copy$default(RefreshMoney refreshMoney, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = refreshMoney.diamondNum;
        }
        if ((i & 2) != 0) {
            d2 = refreshMoney.pinkDiamondNum;
        }
        return refreshMoney.copy(d, d2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Double getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Double getPinkDiamondNum() {
        return this.pinkDiamondNum;
    }

    @NotNull
    public final RefreshMoney copy(@Nullable Double diamondNum, @Nullable Double pinkDiamondNum) {
        return new RefreshMoney(diamondNum, pinkDiamondNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RefreshMoney)) {
            return false;
        }
        RefreshMoney refreshMoney = (RefreshMoney) other;
        return Intrinsics.areEqual(this.diamondNum, refreshMoney.diamondNum) && Intrinsics.areEqual(this.pinkDiamondNum, refreshMoney.pinkDiamondNum);
    }

    @Nullable
    public final Double getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final Double getPinkDiamondNum() {
        return this.pinkDiamondNum;
    }

    public int hashCode() {
        Double d = this.diamondNum;
        int hashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.pinkDiamondNum;
        return hashCode + (d2 != null ? d2.hashCode() : 0);
    }

    public final void setDiamondNum(@Nullable Double d) {
        this.diamondNum = d;
    }

    public final void setPinkDiamondNum(@Nullable Double d) {
        this.pinkDiamondNum = d;
    }

    @NotNull
    public String toString() {
        return "RefreshMoney(diamondNum=" + this.diamondNum + ", pinkDiamondNum=" + this.pinkDiamondNum + ")";
    }

    public RefreshMoney(@Nullable Double d, @Nullable Double d2) {
        this.diamondNum = d;
        this.pinkDiamondNum = d2;
    }

    public /* synthetic */ RefreshMoney(Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2);
    }
}
