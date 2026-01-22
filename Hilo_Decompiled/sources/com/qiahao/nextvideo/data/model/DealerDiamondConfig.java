package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "dollar", "", AgooConstants.MESSAGE_ID, "<init>", "(JII)V", "getDiamond", "()J", "getDollar", "()I", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DealerDiamondConfig {
    private final long diamond;
    private final int dollar;
    private final int id;

    public DealerDiamondConfig(long j, int i, int i2) {
        this.diamond = j;
        this.dollar = i;
        this.id = i2;
    }

    public static /* synthetic */ DealerDiamondConfig copy$default(DealerDiamondConfig dealerDiamondConfig, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = dealerDiamondConfig.diamond;
        }
        if ((i3 & 2) != 0) {
            i = dealerDiamondConfig.dollar;
        }
        if ((i3 & 4) != 0) {
            i2 = dealerDiamondConfig.id;
        }
        return dealerDiamondConfig.copy(j, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDiamond() {
        return this.diamond;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDollar() {
        return this.dollar;
    }

    /* renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    public final DealerDiamondConfig copy(long diamond, int dollar, int id2) {
        return new DealerDiamondConfig(diamond, dollar, id2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DealerDiamondConfig)) {
            return false;
        }
        DealerDiamondConfig dealerDiamondConfig = (DealerDiamondConfig) other;
        return this.diamond == dealerDiamondConfig.diamond && this.dollar == dealerDiamondConfig.dollar && this.id == dealerDiamondConfig.id;
    }

    public final long getDiamond() {
        return this.diamond;
    }

    public final int getDollar() {
        return this.dollar;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return (((c.a(this.diamond) * 31) + this.dollar) * 31) + this.id;
    }

    @NotNull
    public String toString() {
        return "DealerDiamondConfig(diamond=" + this.diamond + ", dollar=" + this.dollar + ", id=" + this.id + ")";
    }
}
