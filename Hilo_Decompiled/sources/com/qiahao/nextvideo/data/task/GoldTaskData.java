package com.qiahao.nextvideo.data.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/task/GoldTaskData;", "", "monthCharge", "", "process", "", "Lcom/qiahao/nextvideo/data/task/TaskProcess;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getMonthCharge", "()Ljava/lang/Integer;", "setMonthCharge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getProcess", "()Ljava/util/List;", "setProcess", "(Ljava/util/List;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/qiahao/nextvideo/data/task/GoldTaskData;", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GoldTaskData {

    @Nullable
    private Integer monthCharge;

    @Nullable
    private List<TaskProcess> process;

    /* JADX WARN: Multi-variable type inference failed */
    public GoldTaskData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GoldTaskData copy$default(GoldTaskData goldTaskData, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = goldTaskData.monthCharge;
        }
        if ((i & 2) != 0) {
            list = goldTaskData.process;
        }
        return goldTaskData.copy(num, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getMonthCharge() {
        return this.monthCharge;
    }

    @Nullable
    public final List<TaskProcess> component2() {
        return this.process;
    }

    @NotNull
    public final GoldTaskData copy(@Nullable Integer monthCharge, @Nullable List<TaskProcess> process) {
        return new GoldTaskData(monthCharge, process);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoldTaskData)) {
            return false;
        }
        GoldTaskData goldTaskData = (GoldTaskData) other;
        return Intrinsics.areEqual(this.monthCharge, goldTaskData.monthCharge) && Intrinsics.areEqual(this.process, goldTaskData.process);
    }

    @Nullable
    public final Integer getMonthCharge() {
        return this.monthCharge;
    }

    @Nullable
    public final List<TaskProcess> getProcess() {
        return this.process;
    }

    public int hashCode() {
        Integer num = this.monthCharge;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<TaskProcess> list = this.process;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setMonthCharge(@Nullable Integer num) {
        this.monthCharge = num;
    }

    public final void setProcess(@Nullable List<TaskProcess> list) {
        this.process = list;
    }

    @NotNull
    public String toString() {
        return "GoldTaskData(monthCharge=" + this.monthCharge + ", process=" + this.process + ")";
    }

    public GoldTaskData(@Nullable Integer num, @Nullable List<TaskProcess> list) {
        this.monthCharge = num;
        this.process = list;
    }

    public /* synthetic */ GoldTaskData(Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list);
    }
}
