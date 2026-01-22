package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.data.family.FamilyRankItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/WeekPowerTop3Bean;", "", "day", "", "Lcom/qiahao/nextvideo/data/family/FamilyRankItem;", "month", "week", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDay", "()Ljava/util/List;", "getMonth", "getWeek", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class WeekPowerTop3Bean {

    @Nullable
    private final List<FamilyRankItem> day;

    @Nullable
    private final List<FamilyRankItem> month;

    @Nullable
    private final List<FamilyRankItem> week;

    public WeekPowerTop3Bean(@Nullable List<FamilyRankItem> list, @Nullable List<FamilyRankItem> list2, @Nullable List<FamilyRankItem> list3) {
        this.day = list;
        this.month = list2;
        this.week = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WeekPowerTop3Bean copy$default(WeekPowerTop3Bean weekPowerTop3Bean, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = weekPowerTop3Bean.day;
        }
        if ((i & 2) != 0) {
            list2 = weekPowerTop3Bean.month;
        }
        if ((i & 4) != 0) {
            list3 = weekPowerTop3Bean.week;
        }
        return weekPowerTop3Bean.copy(list, list2, list3);
    }

    @Nullable
    public final List<FamilyRankItem> component1() {
        return this.day;
    }

    @Nullable
    public final List<FamilyRankItem> component2() {
        return this.month;
    }

    @Nullable
    public final List<FamilyRankItem> component3() {
        return this.week;
    }

    @NotNull
    public final WeekPowerTop3Bean copy(@Nullable List<FamilyRankItem> day, @Nullable List<FamilyRankItem> month, @Nullable List<FamilyRankItem> week) {
        return new WeekPowerTop3Bean(day, month, week);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeekPowerTop3Bean)) {
            return false;
        }
        WeekPowerTop3Bean weekPowerTop3Bean = (WeekPowerTop3Bean) other;
        return Intrinsics.areEqual(this.day, weekPowerTop3Bean.day) && Intrinsics.areEqual(this.month, weekPowerTop3Bean.month) && Intrinsics.areEqual(this.week, weekPowerTop3Bean.week);
    }

    @Nullable
    public final List<FamilyRankItem> getDay() {
        return this.day;
    }

    @Nullable
    public final List<FamilyRankItem> getMonth() {
        return this.month;
    }

    @Nullable
    public final List<FamilyRankItem> getWeek() {
        return this.week;
    }

    public int hashCode() {
        List<FamilyRankItem> list = this.day;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<FamilyRankItem> list2 = this.month;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<FamilyRankItem> list3 = this.week;
        return hashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "WeekPowerTop3Bean(day=" + this.day + ", month=" + this.month + ", week=" + this.week + ")";
    }
}
