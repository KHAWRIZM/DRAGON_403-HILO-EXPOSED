package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitRankAllBean;", "", "list", "", "Lcom/qiahao/nextvideo/data/model/LuckyFruitRankBean;", "remainSecond", "", "total", "title", "", "<init>", "(Ljava/util/List;JJLjava/lang/String;)V", "getList", "()Ljava/util/List;", "getRemainSecond", "()J", "getTotal", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitRankAllBean {

    @Nullable
    @c("rankList")
    private final List<LuckyFruitRankBean> list;
    private final long remainSecond;

    @Nullable
    private String title;
    private final long total;

    public LuckyFruitRankAllBean(@Nullable List<LuckyFruitRankBean> list, long j, long j2, @Nullable String str) {
        this.list = list;
        this.remainSecond = j;
        this.total = j2;
        this.title = str;
    }

    public static /* synthetic */ LuckyFruitRankAllBean copy$default(LuckyFruitRankAllBean luckyFruitRankAllBean, List list, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = luckyFruitRankAllBean.list;
        }
        if ((i & 2) != 0) {
            j = luckyFruitRankAllBean.remainSecond;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = luckyFruitRankAllBean.total;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            str = luckyFruitRankAllBean.title;
        }
        return luckyFruitRankAllBean.copy(list, j3, j4, str);
    }

    @Nullable
    public final List<LuckyFruitRankBean> component1() {
        return this.list;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRemainSecond() {
        return this.remainSecond;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTotal() {
        return this.total;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final LuckyFruitRankAllBean copy(@Nullable List<LuckyFruitRankBean> list, long remainSecond, long total, @Nullable String title) {
        return new LuckyFruitRankAllBean(list, remainSecond, total, title);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitRankAllBean)) {
            return false;
        }
        LuckyFruitRankAllBean luckyFruitRankAllBean = (LuckyFruitRankAllBean) other;
        return Intrinsics.areEqual(this.list, luckyFruitRankAllBean.list) && this.remainSecond == luckyFruitRankAllBean.remainSecond && this.total == luckyFruitRankAllBean.total && Intrinsics.areEqual(this.title, luckyFruitRankAllBean.title);
    }

    @Nullable
    public final List<LuckyFruitRankBean> getList() {
        return this.list;
    }

    public final long getRemainSecond() {
        return this.remainSecond;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final long getTotal() {
        return this.total;
    }

    public int hashCode() {
        List<LuckyFruitRankBean> list = this.list;
        int hashCode = (((((list == null ? 0 : list.hashCode()) * 31) + androidx.collection.c.a(this.remainSecond)) * 31) + androidx.collection.c.a(this.total)) * 31;
        String str = this.title;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitRankAllBean(list=" + this.list + ", remainSecond=" + this.remainSecond + ", total=" + this.total + ", title=" + this.title + ")";
    }

    public /* synthetic */ LuckyFruitRankAllBean(List list, long j, long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j, j2, (i & 8) != 0 ? null : str);
    }
}
