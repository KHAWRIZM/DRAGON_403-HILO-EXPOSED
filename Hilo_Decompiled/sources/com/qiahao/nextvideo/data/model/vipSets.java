package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/data/model/vipSets;", "", "actitySpeed", "", "charmSpeed", "iLikeNum", "", "wealthSpeed", "<init>", "(FFIF)V", "getActitySpeed", "()F", "setActitySpeed", "(F)V", "getCharmSpeed", "setCharmSpeed", "getILikeNum", "()I", "setILikeNum", "(I)V", "getWealthSpeed", "setWealthSpeed", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class vipSets {
    private float actitySpeed;
    private float charmSpeed;
    private int iLikeNum;
    private float wealthSpeed;

    public vipSets(float f, float f2, int i, float f3) {
        this.actitySpeed = f;
        this.charmSpeed = f2;
        this.iLikeNum = i;
        this.wealthSpeed = f3;
    }

    public static /* synthetic */ vipSets copy$default(vipSets vipsets, float f, float f2, int i, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = vipsets.actitySpeed;
        }
        if ((i2 & 2) != 0) {
            f2 = vipsets.charmSpeed;
        }
        if ((i2 & 4) != 0) {
            i = vipsets.iLikeNum;
        }
        if ((i2 & 8) != 0) {
            f3 = vipsets.wealthSpeed;
        }
        return vipsets.copy(f, f2, i, f3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getActitySpeed() {
        return this.actitySpeed;
    }

    /* renamed from: component2, reason: from getter */
    public final float getCharmSpeed() {
        return this.charmSpeed;
    }

    /* renamed from: component3, reason: from getter */
    public final int getILikeNum() {
        return this.iLikeNum;
    }

    /* renamed from: component4, reason: from getter */
    public final float getWealthSpeed() {
        return this.wealthSpeed;
    }

    @NotNull
    public final vipSets copy(float actitySpeed, float charmSpeed, int iLikeNum, float wealthSpeed) {
        return new vipSets(actitySpeed, charmSpeed, iLikeNum, wealthSpeed);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof vipSets)) {
            return false;
        }
        vipSets vipsets = (vipSets) other;
        return Float.compare(this.actitySpeed, vipsets.actitySpeed) == 0 && Float.compare(this.charmSpeed, vipsets.charmSpeed) == 0 && this.iLikeNum == vipsets.iLikeNum && Float.compare(this.wealthSpeed, vipsets.wealthSpeed) == 0;
    }

    public final float getActitySpeed() {
        return this.actitySpeed;
    }

    public final float getCharmSpeed() {
        return this.charmSpeed;
    }

    public final int getILikeNum() {
        return this.iLikeNum;
    }

    public final float getWealthSpeed() {
        return this.wealthSpeed;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.actitySpeed) * 31) + Float.floatToIntBits(this.charmSpeed)) * 31) + this.iLikeNum) * 31) + Float.floatToIntBits(this.wealthSpeed);
    }

    public final void setActitySpeed(float f) {
        this.actitySpeed = f;
    }

    public final void setCharmSpeed(float f) {
        this.charmSpeed = f;
    }

    public final void setILikeNum(int i) {
        this.iLikeNum = i;
    }

    public final void setWealthSpeed(float f) {
        this.wealthSpeed = f;
    }

    @NotNull
    public String toString() {
        return "vipSets(actitySpeed=" + this.actitySpeed + ", charmSpeed=" + this.charmSpeed + ", iLikeNum=" + this.iLikeNum + ", wealthSpeed=" + this.wealthSpeed + ")";
    }
}
