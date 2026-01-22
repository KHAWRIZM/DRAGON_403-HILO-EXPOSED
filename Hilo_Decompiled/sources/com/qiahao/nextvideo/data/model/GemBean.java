package com.qiahao.nextvideo.data.model;

import com.google.firebase.sessions.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GemBean;", "", "diamondNum", "", "pinkDiamondNum", "<init>", "(DD)V", "getDiamondNum", "()D", "setDiamondNum", "(D)V", "getPinkDiamondNum", "setPinkDiamondNum", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GemBean {
    private double diamondNum;
    private double pinkDiamondNum;

    public GemBean(double d, double d2) {
        this.diamondNum = d;
        this.pinkDiamondNum = d2;
    }

    public static /* synthetic */ GemBean copy$default(GemBean gemBean, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = gemBean.diamondNum;
        }
        if ((i & 2) != 0) {
            d2 = gemBean.pinkDiamondNum;
        }
        return gemBean.copy(d, d2);
    }

    /* renamed from: component1, reason: from getter */
    public final double getDiamondNum() {
        return this.diamondNum;
    }

    /* renamed from: component2, reason: from getter */
    public final double getPinkDiamondNum() {
        return this.pinkDiamondNum;
    }

    @NotNull
    public final GemBean copy(double diamondNum, double pinkDiamondNum) {
        return new GemBean(diamondNum, pinkDiamondNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GemBean)) {
            return false;
        }
        GemBean gemBean = (GemBean) other;
        return Double.compare(this.diamondNum, gemBean.diamondNum) == 0 && Double.compare(this.pinkDiamondNum, gemBean.pinkDiamondNum) == 0;
    }

    public final double getDiamondNum() {
        return this.diamondNum;
    }

    public final double getPinkDiamondNum() {
        return this.pinkDiamondNum;
    }

    public int hashCode() {
        return (a.a(this.diamondNum) * 31) + a.a(this.pinkDiamondNum);
    }

    public final void setDiamondNum(double d) {
        this.diamondNum = d;
    }

    public final void setPinkDiamondNum(double d) {
        this.pinkDiamondNum = d;
    }

    @NotNull
    public String toString() {
        return "GemBean(diamondNum=" + this.diamondNum + ", pinkDiamondNum=" + this.pinkDiamondNum + ")";
    }
}
