package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/model/FreeCheckMessageResponseBean;", "", "TodayHasTime", "", "freeTime", "<init>", "(II)V", "getTodayHasTime", "()I", "getFreeTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FreeCheckMessageResponseBean {

    @c("dailyN")
    private final int TodayHasTime;

    @c("freeN")
    private final int freeTime;

    public FreeCheckMessageResponseBean(int i, int i2) {
        this.TodayHasTime = i;
        this.freeTime = i2;
    }

    public static /* synthetic */ FreeCheckMessageResponseBean copy$default(FreeCheckMessageResponseBean freeCheckMessageResponseBean, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = freeCheckMessageResponseBean.TodayHasTime;
        }
        if ((i3 & 2) != 0) {
            i2 = freeCheckMessageResponseBean.freeTime;
        }
        return freeCheckMessageResponseBean.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTodayHasTime() {
        return this.TodayHasTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFreeTime() {
        return this.freeTime;
    }

    @NotNull
    public final FreeCheckMessageResponseBean copy(int TodayHasTime, int freeTime) {
        return new FreeCheckMessageResponseBean(TodayHasTime, freeTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FreeCheckMessageResponseBean)) {
            return false;
        }
        FreeCheckMessageResponseBean freeCheckMessageResponseBean = (FreeCheckMessageResponseBean) other;
        return this.TodayHasTime == freeCheckMessageResponseBean.TodayHasTime && this.freeTime == freeCheckMessageResponseBean.freeTime;
    }

    public final int getFreeTime() {
        return this.freeTime;
    }

    public final int getTodayHasTime() {
        return this.TodayHasTime;
    }

    public int hashCode() {
        return (this.TodayHasTime * 31) + this.freeTime;
    }

    @NotNull
    public String toString() {
        return "FreeCheckMessageResponseBean(TodayHasTime=" + this.TodayHasTime + ", freeTime=" + this.freeTime + ")";
    }
}
