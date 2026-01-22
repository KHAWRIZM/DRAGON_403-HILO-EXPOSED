package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MySupportAllBean;", "", "userScores", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/MySupportBean;", "Lkotlin/collections/ArrayList;", "total", "", "<init>", "(Ljava/util/ArrayList;I)V", "getUserScores", "()Ljava/util/ArrayList;", "getTotal", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MySupportAllBean {
    private final int total;

    @NotNull
    private final ArrayList<MySupportBean> userScores;

    public MySupportAllBean(@NotNull ArrayList<MySupportBean> arrayList, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "userScores");
        this.userScores = arrayList;
        this.total = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MySupportAllBean copy$default(MySupportAllBean mySupportAllBean, ArrayList arrayList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = mySupportAllBean.userScores;
        }
        if ((i2 & 2) != 0) {
            i = mySupportAllBean.total;
        }
        return mySupportAllBean.copy(arrayList, i);
    }

    @NotNull
    public final ArrayList<MySupportBean> component1() {
        return this.userScores;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final MySupportAllBean copy(@NotNull ArrayList<MySupportBean> userScores, int total) {
        Intrinsics.checkNotNullParameter(userScores, "userScores");
        return new MySupportAllBean(userScores, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MySupportAllBean)) {
            return false;
        }
        MySupportAllBean mySupportAllBean = (MySupportAllBean) other;
        return Intrinsics.areEqual(this.userScores, mySupportAllBean.userScores) && this.total == mySupportAllBean.total;
    }

    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final ArrayList<MySupportBean> getUserScores() {
        return this.userScores;
    }

    public int hashCode() {
        return (this.userScores.hashCode() * 31) + this.total;
    }

    @NotNull
    public String toString() {
        return "MySupportAllBean(userScores=" + this.userScores + ", total=" + this.total + ")";
    }
}
