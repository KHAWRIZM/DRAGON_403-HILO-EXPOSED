package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.wallet.ExchangeDiamondsActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/model/BeanChangeDetail;", "", "operationType", "", "amount", "", "createdAt", "", "useType", "<init>", "(IFJI)V", "getOperationType", "()I", "getAmount", "()F", "getCreatedAt", "()J", "getUseType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class BeanChangeDetail {

    @c(ExchangeDiamondsActivity.BEAN_NUM)
    private final float amount;

    @c("createdTime")
    private final long createdAt;

    @c("addReduce")
    private final int operationType;

    @c("operateType")
    private final int useType;

    public BeanChangeDetail(int i, float f, long j, int i2) {
        this.operationType = i;
        this.amount = f;
        this.createdAt = j;
        this.useType = i2;
    }

    public static /* synthetic */ BeanChangeDetail copy$default(BeanChangeDetail beanChangeDetail, int i, float f, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = beanChangeDetail.operationType;
        }
        if ((i3 & 2) != 0) {
            f = beanChangeDetail.amount;
        }
        float f2 = f;
        if ((i3 & 4) != 0) {
            j = beanChangeDetail.createdAt;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            i2 = beanChangeDetail.useType;
        }
        return beanChangeDetail.copy(i, f2, j2, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getOperationType() {
        return this.operationType;
    }

    /* renamed from: component2, reason: from getter */
    public final float getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component4, reason: from getter */
    public final int getUseType() {
        return this.useType;
    }

    @NotNull
    public final BeanChangeDetail copy(int operationType, float amount, long createdAt, int useType) {
        return new BeanChangeDetail(operationType, amount, createdAt, useType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeanChangeDetail)) {
            return false;
        }
        BeanChangeDetail beanChangeDetail = (BeanChangeDetail) other;
        return this.operationType == beanChangeDetail.operationType && Float.compare(this.amount, beanChangeDetail.amount) == 0 && this.createdAt == beanChangeDetail.createdAt && this.useType == beanChangeDetail.useType;
    }

    public final float getAmount() {
        return this.amount;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final int getOperationType() {
        return this.operationType;
    }

    public final int getUseType() {
        return this.useType;
    }

    public int hashCode() {
        return (((((this.operationType * 31) + Float.floatToIntBits(this.amount)) * 31) + androidx.collection.c.a(this.createdAt)) * 31) + this.useType;
    }

    @NotNull
    public String toString() {
        return "BeanChangeDetail(operationType=" + this.operationType + ", amount=" + this.amount + ", createdAt=" + this.createdAt + ", useType=" + this.useType + ")";
    }
}
