package com.qiahao.nextvideo.ui.videocall;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/CountDownTimerPreloadModel;", "", "totalMills", "", "currentCountDownValueInMills", "millisInFuture", "countDownInterval", "<init>", "(JJJJ)V", "getTotalMills", "()J", "setTotalMills", "(J)V", "getCurrentCountDownValueInMills", "setCurrentCountDownValueInMills", "getMillisInFuture", "setMillisInFuture", "getCountDownInterval", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CountDownTimerPreloadModel {
    private final long countDownInterval;
    private long currentCountDownValueInMills;
    private long millisInFuture;
    private long totalMills;

    public CountDownTimerPreloadModel(long j, long j2, long j3, long j4) {
        this.totalMills = j;
        this.currentCountDownValueInMills = j2;
        this.millisInFuture = j3;
        this.countDownInterval = j4;
    }

    /* renamed from: component1, reason: from getter */
    public final long getTotalMills() {
        return this.totalMills;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCurrentCountDownValueInMills() {
        return this.currentCountDownValueInMills;
    }

    /* renamed from: component3, reason: from getter */
    public final long getMillisInFuture() {
        return this.millisInFuture;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCountDownInterval() {
        return this.countDownInterval;
    }

    @NotNull
    public final CountDownTimerPreloadModel copy(long totalMills, long currentCountDownValueInMills, long millisInFuture, long countDownInterval) {
        return new CountDownTimerPreloadModel(totalMills, currentCountDownValueInMills, millisInFuture, countDownInterval);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountDownTimerPreloadModel)) {
            return false;
        }
        CountDownTimerPreloadModel countDownTimerPreloadModel = (CountDownTimerPreloadModel) other;
        return this.totalMills == countDownTimerPreloadModel.totalMills && this.currentCountDownValueInMills == countDownTimerPreloadModel.currentCountDownValueInMills && this.millisInFuture == countDownTimerPreloadModel.millisInFuture && this.countDownInterval == countDownTimerPreloadModel.countDownInterval;
    }

    public final long getCountDownInterval() {
        return this.countDownInterval;
    }

    public final long getCurrentCountDownValueInMills() {
        return this.currentCountDownValueInMills;
    }

    public final long getMillisInFuture() {
        return this.millisInFuture;
    }

    public final long getTotalMills() {
        return this.totalMills;
    }

    public int hashCode() {
        return (((((androidx.collection.c.a(this.totalMills) * 31) + androidx.collection.c.a(this.currentCountDownValueInMills)) * 31) + androidx.collection.c.a(this.millisInFuture)) * 31) + androidx.collection.c.a(this.countDownInterval);
    }

    public final void setCurrentCountDownValueInMills(long j) {
        this.currentCountDownValueInMills = j;
    }

    public final void setMillisInFuture(long j) {
        this.millisInFuture = j;
    }

    public final void setTotalMills(long j) {
        this.totalMills = j;
    }

    @NotNull
    public String toString() {
        return "CountDownTimerPreloadModel(totalMills=" + this.totalMills + ", currentCountDownValueInMills=" + this.currentCountDownValueInMills + ", millisInFuture=" + this.millisInFuture + ", countDownInterval=" + this.countDownInterval + ")";
    }

    public /* synthetic */ CountDownTimerPreloadModel(long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, j3, (i & 8) != 0 ? 1000L : j4);
    }
}
