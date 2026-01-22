package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyBoxRankingBean;", "", "details", "", "Lcom/qiahao/nextvideo/data/model/LuckyBoxRankingDetailBean;", "remainSecond", "", "<init>", "(Ljava/util/List;J)V", "getDetails", "()Ljava/util/List;", "getRemainSecond", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyBoxRankingBean {

    @NotNull
    private final List<LuckyBoxRankingDetailBean> details;
    private final long remainSecond;

    public LuckyBoxRankingBean(@NotNull List<LuckyBoxRankingDetailBean> list, long j) {
        Intrinsics.checkNotNullParameter(list, "details");
        this.details = list;
        this.remainSecond = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LuckyBoxRankingBean copy$default(LuckyBoxRankingBean luckyBoxRankingBean, List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = luckyBoxRankingBean.details;
        }
        if ((i & 2) != 0) {
            j = luckyBoxRankingBean.remainSecond;
        }
        return luckyBoxRankingBean.copy(list, j);
    }

    @NotNull
    public final List<LuckyBoxRankingDetailBean> component1() {
        return this.details;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRemainSecond() {
        return this.remainSecond;
    }

    @NotNull
    public final LuckyBoxRankingBean copy(@NotNull List<LuckyBoxRankingDetailBean> details, long remainSecond) {
        Intrinsics.checkNotNullParameter(details, "details");
        return new LuckyBoxRankingBean(details, remainSecond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyBoxRankingBean)) {
            return false;
        }
        LuckyBoxRankingBean luckyBoxRankingBean = (LuckyBoxRankingBean) other;
        return Intrinsics.areEqual(this.details, luckyBoxRankingBean.details) && this.remainSecond == luckyBoxRankingBean.remainSecond;
    }

    @NotNull
    public final List<LuckyBoxRankingDetailBean> getDetails() {
        return this.details;
    }

    public final long getRemainSecond() {
        return this.remainSecond;
    }

    public int hashCode() {
        return (this.details.hashCode() * 31) + c.a(this.remainSecond);
    }

    @NotNull
    public String toString() {
        return "LuckyBoxRankingBean(details=" + this.details + ", remainSecond=" + this.remainSecond + ")";
    }
}
