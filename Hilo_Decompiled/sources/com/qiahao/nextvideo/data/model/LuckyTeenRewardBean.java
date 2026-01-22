package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyTeenRewardBean;", "", "diamondNum", "", "picUrls", "", "", "<init>", "(JLjava/util/List;)V", "getDiamondNum", "()J", "getPicUrls", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyTeenRewardBean {
    private final long diamondNum;

    @NotNull
    private final List<String> picUrls;

    public LuckyTeenRewardBean(long j, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "picUrls");
        this.diamondNum = j;
        this.picUrls = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LuckyTeenRewardBean copy$default(LuckyTeenRewardBean luckyTeenRewardBean, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = luckyTeenRewardBean.diamondNum;
        }
        if ((i & 2) != 0) {
            list = luckyTeenRewardBean.picUrls;
        }
        return luckyTeenRewardBean.copy(j, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final List<String> component2() {
        return this.picUrls;
    }

    @NotNull
    public final LuckyTeenRewardBean copy(long diamondNum, @NotNull List<String> picUrls) {
        Intrinsics.checkNotNullParameter(picUrls, "picUrls");
        return new LuckyTeenRewardBean(diamondNum, picUrls);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyTeenRewardBean)) {
            return false;
        }
        LuckyTeenRewardBean luckyTeenRewardBean = (LuckyTeenRewardBean) other;
        return this.diamondNum == luckyTeenRewardBean.diamondNum && Intrinsics.areEqual(this.picUrls, luckyTeenRewardBean.picUrls);
    }

    public final long getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final List<String> getPicUrls() {
        return this.picUrls;
    }

    public int hashCode() {
        return (c.a(this.diamondNum) * 31) + this.picUrls.hashCode();
    }

    @NotNull
    public String toString() {
        return "LuckyTeenRewardBean(diamondNum=" + this.diamondNum + ", picUrls=" + this.picUrls + ")";
    }
}
