package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/data/model/EarnDiamondBean;", "", "advanceds", "", "Lcom/qiahao/nextvideo/data/model/EarnDiamondDailyBean;", "dailys", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAdvanceds", "()Ljava/util/List;", "getDailys", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EarnDiamondBean {

    @NotNull
    private final List<EarnDiamondDailyBean> advanceds;

    @NotNull
    private final List<EarnDiamondDailyBean> dailys;

    public EarnDiamondBean(@NotNull List<EarnDiamondDailyBean> list, @NotNull List<EarnDiamondDailyBean> list2) {
        Intrinsics.checkNotNullParameter(list, "advanceds");
        Intrinsics.checkNotNullParameter(list2, "dailys");
        this.advanceds = list;
        this.dailys = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EarnDiamondBean copy$default(EarnDiamondBean earnDiamondBean, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = earnDiamondBean.advanceds;
        }
        if ((i & 2) != 0) {
            list2 = earnDiamondBean.dailys;
        }
        return earnDiamondBean.copy(list, list2);
    }

    @NotNull
    public final List<EarnDiamondDailyBean> component1() {
        return this.advanceds;
    }

    @NotNull
    public final List<EarnDiamondDailyBean> component2() {
        return this.dailys;
    }

    @NotNull
    public final EarnDiamondBean copy(@NotNull List<EarnDiamondDailyBean> advanceds, @NotNull List<EarnDiamondDailyBean> dailys) {
        Intrinsics.checkNotNullParameter(advanceds, "advanceds");
        Intrinsics.checkNotNullParameter(dailys, "dailys");
        return new EarnDiamondBean(advanceds, dailys);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EarnDiamondBean)) {
            return false;
        }
        EarnDiamondBean earnDiamondBean = (EarnDiamondBean) other;
        return Intrinsics.areEqual(this.advanceds, earnDiamondBean.advanceds) && Intrinsics.areEqual(this.dailys, earnDiamondBean.dailys);
    }

    @NotNull
    public final List<EarnDiamondDailyBean> getAdvanceds() {
        return this.advanceds;
    }

    @NotNull
    public final List<EarnDiamondDailyBean> getDailys() {
        return this.dailys;
    }

    public int hashCode() {
        return (this.advanceds.hashCode() * 31) + this.dailys.hashCode();
    }

    @NotNull
    public String toString() {
        return "EarnDiamondBean(advanceds=" + this.advanceds + ", dailys=" + this.dailys + ")";
    }
}
