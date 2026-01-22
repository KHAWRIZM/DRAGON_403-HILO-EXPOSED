package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyBoxRecordBean;", "", "awardN", "", "awardType", "createdTime", "", "<init>", "(IIJ)V", "getAwardN", "()I", "getAwardType", "getCreatedTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyBoxRecordBean {
    private final int awardN;
    private final int awardType;
    private final long createdTime;

    public LuckyBoxRecordBean(int i, int i2, long j) {
        this.awardN = i;
        this.awardType = i2;
        this.createdTime = j;
    }

    public static /* synthetic */ LuckyBoxRecordBean copy$default(LuckyBoxRecordBean luckyBoxRecordBean, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = luckyBoxRecordBean.awardN;
        }
        if ((i3 & 2) != 0) {
            i2 = luckyBoxRecordBean.awardType;
        }
        if ((i3 & 4) != 0) {
            j = luckyBoxRecordBean.createdTime;
        }
        return luckyBoxRecordBean.copy(i, i2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAwardN() {
        return this.awardN;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAwardType() {
        return this.awardType;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreatedTime() {
        return this.createdTime;
    }

    @NotNull
    public final LuckyBoxRecordBean copy(int awardN, int awardType, long createdTime) {
        return new LuckyBoxRecordBean(awardN, awardType, createdTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyBoxRecordBean)) {
            return false;
        }
        LuckyBoxRecordBean luckyBoxRecordBean = (LuckyBoxRecordBean) other;
        return this.awardN == luckyBoxRecordBean.awardN && this.awardType == luckyBoxRecordBean.awardType && this.createdTime == luckyBoxRecordBean.createdTime;
    }

    public final int getAwardN() {
        return this.awardN;
    }

    public final int getAwardType() {
        return this.awardType;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public int hashCode() {
        return (((this.awardN * 31) + this.awardType) * 31) + c.a(this.createdTime);
    }

    @NotNull
    public String toString() {
        return "LuckyBoxRecordBean(awardN=" + this.awardN + ", awardType=" + this.awardType + ", createdTime=" + this.createdTime + ")";
    }
}
