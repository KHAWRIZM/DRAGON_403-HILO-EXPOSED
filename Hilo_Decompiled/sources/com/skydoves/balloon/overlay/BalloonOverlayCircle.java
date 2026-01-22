package com.skydoves.balloon.overlay;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonOverlayCircle;", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "radius", "", "(F)V", "getRadius", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* data */ class BalloonOverlayCircle extends BalloonOverlayShape {
    private final float radius;

    public BalloonOverlayCircle(float f) {
        super(null);
        this.radius = f;
    }

    public static /* synthetic */ BalloonOverlayCircle copy$default(BalloonOverlayCircle balloonOverlayCircle, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = balloonOverlayCircle.radius;
        }
        return balloonOverlayCircle.copy(f);
    }

    /* renamed from: component1, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    @NotNull
    public final BalloonOverlayCircle copy(float radius) {
        return new BalloonOverlayCircle(radius);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            return (other instanceof BalloonOverlayCircle) && Float.compare(this.radius, ((BalloonOverlayCircle) other).radius) == 0;
        }
        return true;
    }

    public final float getRadius() {
        return this.radius;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.radius);
    }

    @NotNull
    public String toString() {
        return "BalloonOverlayCircle(radius=" + this.radius + ")";
    }
}
