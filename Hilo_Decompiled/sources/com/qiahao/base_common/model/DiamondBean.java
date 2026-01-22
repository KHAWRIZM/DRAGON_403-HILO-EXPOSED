package com.qiahao.base_common.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/qiahao/base_common/model/DiamondBean;", "", "diamondNum", "", "<init>", "(D)V", "getDiamondNum", "()D", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class DiamondBean {
    private final double diamondNum;

    public DiamondBean(double d10) {
        this.diamondNum = d10;
    }

    public static /* synthetic */ DiamondBean copy$default(DiamondBean diamondBean, double d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = diamondBean.diamondNum;
        }
        return diamondBean.copy(d10);
    }

    /* renamed from: component1, reason: from getter */
    public final double getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final DiamondBean copy(double diamondNum) {
        return new DiamondBean(diamondNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DiamondBean) && Double.compare(this.diamondNum, ((DiamondBean) other).diamondNum) == 0;
    }

    public final double getDiamondNum() {
        return this.diamondNum;
    }

    public int hashCode() {
        return com.google.firebase.sessions.a.a(this.diamondNum);
    }

    @NotNull
    public String toString() {
        return "DiamondBean(diamondNum=" + this.diamondNum + ")";
    }
}
