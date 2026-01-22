package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/DealerListBean;", "", "dls", "", "Lcom/qiahao/nextvideo/data/model/OfficialRechargeBean;", "official", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getDls", "()Ljava/util/List;", "getOfficial", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DealerListBean {

    @NotNull
    private final List<OfficialRechargeBean> dls;

    @NotNull
    private final String official;

    public DealerListBean(@NotNull List<OfficialRechargeBean> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "dls");
        Intrinsics.checkNotNullParameter(str, "official");
        this.dls = list;
        this.official = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DealerListBean copy$default(DealerListBean dealerListBean, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dealerListBean.dls;
        }
        if ((i & 2) != 0) {
            str = dealerListBean.official;
        }
        return dealerListBean.copy(list, str);
    }

    @NotNull
    public final List<OfficialRechargeBean> component1() {
        return this.dls;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getOfficial() {
        return this.official;
    }

    @NotNull
    public final DealerListBean copy(@NotNull List<OfficialRechargeBean> dls, @NotNull String official) {
        Intrinsics.checkNotNullParameter(dls, "dls");
        Intrinsics.checkNotNullParameter(official, "official");
        return new DealerListBean(dls, official);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DealerListBean)) {
            return false;
        }
        DealerListBean dealerListBean = (DealerListBean) other;
        return Intrinsics.areEqual(this.dls, dealerListBean.dls) && Intrinsics.areEqual(this.official, dealerListBean.official);
    }

    @NotNull
    public final List<OfficialRechargeBean> getDls() {
        return this.dls;
    }

    @NotNull
    public final String getOfficial() {
        return this.official;
    }

    public int hashCode() {
        return (this.dls.hashCode() * 31) + this.official.hashCode();
    }

    @NotNull
    public String toString() {
        return "DealerListBean(dls=" + this.dls + ", official=" + this.official + ")";
    }
}
