package com.skydoves.balloon.overlay;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonOverlayRoundRect;", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "radiusX", "", "radiusY", "(FF)V", "getRadiusX", "()F", "getRadiusY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* data */ class BalloonOverlayRoundRect extends BalloonOverlayShape {
    private final float radiusX;
    private final float radiusY;

    public BalloonOverlayRoundRect(float f, float f2) {
        super(null);
        this.radiusX = f;
        this.radiusY = f2;
    }

    public static /* synthetic */ BalloonOverlayRoundRect copy$default(BalloonOverlayRoundRect balloonOverlayRoundRect, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = balloonOverlayRoundRect.radiusX;
        }
        if ((i & 2) != 0) {
            f2 = balloonOverlayRoundRect.radiusY;
        }
        return balloonOverlayRoundRect.copy(f, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getRadiusX() {
        return this.radiusX;
    }

    /* renamed from: component2, reason: from getter */
    public final float getRadiusY() {
        return this.radiusY;
    }

    @NotNull
    public final BalloonOverlayRoundRect copy(float radiusX, float radiusY) {
        return new BalloonOverlayRoundRect(radiusX, radiusY);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BalloonOverlayRoundRect)) {
            return false;
        }
        BalloonOverlayRoundRect balloonOverlayRoundRect = (BalloonOverlayRoundRect) other;
        return Float.compare(this.radiusX, balloonOverlayRoundRect.radiusX) == 0 && Float.compare(this.radiusY, balloonOverlayRoundRect.radiusY) == 0;
    }

    public final float getRadiusX() {
        return this.radiusX;
    }

    public final float getRadiusY() {
        return this.radiusY;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.radiusX) * 31) + Float.floatToIntBits(this.radiusY);
    }

    @NotNull
    public String toString() {
        return "BalloonOverlayRoundRect(radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ")";
    }
}
