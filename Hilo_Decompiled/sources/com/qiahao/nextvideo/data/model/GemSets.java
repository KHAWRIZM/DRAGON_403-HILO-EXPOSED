package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GemSets;", "", "gemToDiamond", "", "<init>", "(F)V", "getGemToDiamond", "()F", "setGemToDiamond", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GemSets {
    private float gemToDiamond;

    public GemSets(float f) {
        this.gemToDiamond = f;
    }

    public static /* synthetic */ GemSets copy$default(GemSets gemSets, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = gemSets.gemToDiamond;
        }
        return gemSets.copy(f);
    }

    /* renamed from: component1, reason: from getter */
    public final float getGemToDiamond() {
        return this.gemToDiamond;
    }

    @NotNull
    public final GemSets copy(float gemToDiamond) {
        return new GemSets(gemToDiamond);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GemSets) && Float.compare(this.gemToDiamond, ((GemSets) other).gemToDiamond) == 0;
    }

    public final float getGemToDiamond() {
        return this.gemToDiamond;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.gemToDiamond);
    }

    public final void setGemToDiamond(float f) {
        this.gemToDiamond = f;
    }

    @NotNull
    public String toString() {
        return "GemSets(gemToDiamond=" + this.gemToDiamond + ")";
    }
}
