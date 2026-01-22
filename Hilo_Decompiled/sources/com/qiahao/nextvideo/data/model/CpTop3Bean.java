package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CpTop3Bean;", "", "day", "", "Lcom/qiahao/nextvideo/data/model/CpTopBean;", "week", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getDay", "()Ljava/util/List;", "getWeek", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CpTop3Bean {

    @NotNull
    private final List<CpTopBean> day;

    @NotNull
    private final List<CpTopBean> week;

    public CpTop3Bean(@NotNull List<CpTopBean> list, @NotNull List<CpTopBean> list2) {
        Intrinsics.checkNotNullParameter(list, "day");
        Intrinsics.checkNotNullParameter(list2, "week");
        this.day = list;
        this.week = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CpTop3Bean copy$default(CpTop3Bean cpTop3Bean, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = cpTop3Bean.day;
        }
        if ((i & 2) != 0) {
            list2 = cpTop3Bean.week;
        }
        return cpTop3Bean.copy(list, list2);
    }

    @NotNull
    public final List<CpTopBean> component1() {
        return this.day;
    }

    @NotNull
    public final List<CpTopBean> component2() {
        return this.week;
    }

    @NotNull
    public final CpTop3Bean copy(@NotNull List<CpTopBean> day, @NotNull List<CpTopBean> week) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(week, "week");
        return new CpTop3Bean(day, week);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpTop3Bean)) {
            return false;
        }
        CpTop3Bean cpTop3Bean = (CpTop3Bean) other;
        return Intrinsics.areEqual(this.day, cpTop3Bean.day) && Intrinsics.areEqual(this.week, cpTop3Bean.week);
    }

    @NotNull
    public final List<CpTopBean> getDay() {
        return this.day;
    }

    @NotNull
    public final List<CpTopBean> getWeek() {
        return this.week;
    }

    public int hashCode() {
        return (this.day.hashCode() * 31) + this.week.hashCode();
    }

    @NotNull
    public String toString() {
        return "CpTop3Bean(day=" + this.day + ", week=" + this.week + ")";
    }
}
