package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/PopularTop3Bean;", "", "celebrity", "", "Lcom/qiahao/nextvideo/data/model/Celebrity;", "groupPowers", "Lcom/qiahao/nextvideo/data/model/GroupPower;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getCelebrity", "()Ljava/util/List;", "getGroupPowers", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PopularTop3Bean {

    @NotNull
    private final List<Celebrity> celebrity;

    @NotNull
    private final List<GroupPower> groupPowers;

    public PopularTop3Bean(@NotNull List<Celebrity> list, @NotNull List<GroupPower> list2) {
        Intrinsics.checkNotNullParameter(list, "celebrity");
        Intrinsics.checkNotNullParameter(list2, "groupPowers");
        this.celebrity = list;
        this.groupPowers = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PopularTop3Bean copy$default(PopularTop3Bean popularTop3Bean, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = popularTop3Bean.celebrity;
        }
        if ((i & 2) != 0) {
            list2 = popularTop3Bean.groupPowers;
        }
        return popularTop3Bean.copy(list, list2);
    }

    @NotNull
    public final List<Celebrity> component1() {
        return this.celebrity;
    }

    @NotNull
    public final List<GroupPower> component2() {
        return this.groupPowers;
    }

    @NotNull
    public final PopularTop3Bean copy(@NotNull List<Celebrity> celebrity, @NotNull List<GroupPower> groupPowers) {
        Intrinsics.checkNotNullParameter(celebrity, "celebrity");
        Intrinsics.checkNotNullParameter(groupPowers, "groupPowers");
        return new PopularTop3Bean(celebrity, groupPowers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PopularTop3Bean)) {
            return false;
        }
        PopularTop3Bean popularTop3Bean = (PopularTop3Bean) other;
        return Intrinsics.areEqual(this.celebrity, popularTop3Bean.celebrity) && Intrinsics.areEqual(this.groupPowers, popularTop3Bean.groupPowers);
    }

    @NotNull
    public final List<Celebrity> getCelebrity() {
        return this.celebrity;
    }

    @NotNull
    public final List<GroupPower> getGroupPowers() {
        return this.groupPowers;
    }

    public int hashCode() {
        return (this.celebrity.hashCode() * 31) + this.groupPowers.hashCode();
    }

    @NotNull
    public String toString() {
        return "PopularTop3Bean(celebrity=" + this.celebrity + ", groupPowers=" + this.groupPowers + ")";
    }
}
