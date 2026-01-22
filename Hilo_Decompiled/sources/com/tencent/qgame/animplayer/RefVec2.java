package com.tencent.qgame.animplayer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tencent/qgame/animplayer/RefVec2;", "", "w", "", "h", "(II)V", "getH", "()I", "getW", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* data */ class RefVec2 {
    private final int h;
    private final int w;

    public RefVec2(int i, int i2) {
        this.w = i;
        this.h = i2;
    }

    public static /* synthetic */ RefVec2 copy$default(RefVec2 refVec2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = refVec2.w;
        }
        if ((i3 & 2) != 0) {
            i2 = refVec2.h;
        }
        return refVec2.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getW() {
        return this.w;
    }

    /* renamed from: component2, reason: from getter */
    public final int getH() {
        return this.h;
    }

    @NotNull
    public final RefVec2 copy(int w, int h) {
        return new RefVec2(w, h);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RefVec2)) {
            return false;
        }
        RefVec2 refVec2 = (RefVec2) other;
        return this.w == refVec2.w && this.h == refVec2.h;
    }

    public final int getH() {
        return this.h;
    }

    public final int getW() {
        return this.w;
    }

    public int hashCode() {
        return (this.w * 31) + this.h;
    }

    @NotNull
    public String toString() {
        return "RefVec2(w=" + this.w + ", h=" + this.h + ")";
    }
}
