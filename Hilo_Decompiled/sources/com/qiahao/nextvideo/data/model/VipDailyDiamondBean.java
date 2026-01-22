package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VipDailyDiamondBean;", "", "diamondNum", "", AgooConstants.MESSAGE_FLAG, "", "isVip", "matchCardNum", "", "<init>", "(JZZI)V", "getDiamondNum", "()J", "getFlag", "()Z", "getMatchCardNum", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VipDailyDiamondBean {
    private final long diamondNum;
    private final boolean flag;
    private final boolean isVip;
    private final int matchCardNum;

    public VipDailyDiamondBean(long j, boolean z, boolean z2, int i) {
        this.diamondNum = j;
        this.flag = z;
        this.isVip = z2;
        this.matchCardNum = i;
    }

    public static /* synthetic */ VipDailyDiamondBean copy$default(VipDailyDiamondBean vipDailyDiamondBean, long j, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = vipDailyDiamondBean.diamondNum;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            z = vipDailyDiamondBean.flag;
        }
        boolean z3 = z;
        if ((i2 & 4) != 0) {
            z2 = vipDailyDiamondBean.isVip;
        }
        boolean z4 = z2;
        if ((i2 & 8) != 0) {
            i = vipDailyDiamondBean.matchCardNum;
        }
        return vipDailyDiamondBean.copy(j2, z3, z4, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDiamondNum() {
        return this.diamondNum;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getFlag() {
        return this.flag;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMatchCardNum() {
        return this.matchCardNum;
    }

    @NotNull
    public final VipDailyDiamondBean copy(long diamondNum, boolean flag, boolean isVip, int matchCardNum) {
        return new VipDailyDiamondBean(diamondNum, flag, isVip, matchCardNum);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VipDailyDiamondBean)) {
            return false;
        }
        VipDailyDiamondBean vipDailyDiamondBean = (VipDailyDiamondBean) other;
        return this.diamondNum == vipDailyDiamondBean.diamondNum && this.flag == vipDailyDiamondBean.flag && this.isVip == vipDailyDiamondBean.isVip && this.matchCardNum == vipDailyDiamondBean.matchCardNum;
    }

    public final long getDiamondNum() {
        return this.diamondNum;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final int getMatchCardNum() {
        return this.matchCardNum;
    }

    public int hashCode() {
        return (((((c.a(this.diamondNum) * 31) + a.a(this.flag)) * 31) + a.a(this.isVip)) * 31) + this.matchCardNum;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    @NotNull
    public String toString() {
        return "VipDailyDiamondBean(diamondNum=" + this.diamondNum + ", flag=" + this.flag + ", isVip=" + this.isVip + ", matchCardNum=" + this.matchCardNum + ")";
    }
}
