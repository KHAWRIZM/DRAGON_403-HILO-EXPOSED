package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyFruitRation;", "", "fruitId", "", "ratio", "<init>", "(II)V", "getFruitId", "()I", "setFruitId", "(I)V", "getRatio", "setRatio", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyFruitRation {
    private int fruitId;
    private int ratio;

    public LuckyFruitRation(int i, int i2) {
        this.fruitId = i;
        this.ratio = i2;
    }

    public static /* synthetic */ LuckyFruitRation copy$default(LuckyFruitRation luckyFruitRation, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = luckyFruitRation.fruitId;
        }
        if ((i3 & 2) != 0) {
            i2 = luckyFruitRation.ratio;
        }
        return luckyFruitRation.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFruitId() {
        return this.fruitId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRatio() {
        return this.ratio;
    }

    @NotNull
    public final LuckyFruitRation copy(int fruitId, int ratio) {
        return new LuckyFruitRation(fruitId, ratio);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyFruitRation)) {
            return false;
        }
        LuckyFruitRation luckyFruitRation = (LuckyFruitRation) other;
        return this.fruitId == luckyFruitRation.fruitId && this.ratio == luckyFruitRation.ratio;
    }

    public final int getFruitId() {
        return this.fruitId;
    }

    public final int getRatio() {
        return this.ratio;
    }

    public int hashCode() {
        return (this.fruitId * 31) + this.ratio;
    }

    public final void setFruitId(int i) {
        this.fruitId = i;
    }

    public final void setRatio(int i) {
        this.ratio = i;
    }

    @NotNull
    public String toString() {
        return "LuckyFruitRation(fruitId=" + this.fruitId + ", ratio=" + this.ratio + ")";
    }
}
