package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B5\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0002Jf\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u00060\u0003j\u0002`\u00042\n\u0010.\u001a\u00060\u0003j\u0002`\u00042\n\u0010/\u001a\u00060\u0003j\u0002`\u00042\n\u00100\u001a\u00060\u0003j\u0002`\u00042\n\u00101\u001a\u00060\u0003j\u0002`\u00042\u0006\u00102\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104J \u00105\u001a\b\u0012\u0004\u0012\u00020*062\u0006\u00107\u001a\u00020\u00112\b\b\u0002\u00108\u001a\u00020\u0011H\u0007JJ\u00109\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\n\u0010:\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0016\u001a\u00060\u0003j\u0002`\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<R&\u0010\n\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\u0016\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u0018\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0019\u0010\fR\u0011\u0010\u001a\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001d\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001e\u0010\fR\u001d\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001f\u0010\fR\u001d\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b \u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0011\u0010%\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/graphics/shapes/RoundedCorner;", "", "p0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "p1", "p2", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "(JJJLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "center", "getCenter-1ufDz9w", "()J", "setCenter-DnnuFBc", "(J)V", "J", "cornerRadius", "", "getCornerRadius", "()F", "cosAngle", "getCosAngle", "d1", "getD1-1ufDz9w", "d2", "getD2-1ufDz9w", "expectedCut", "getExpectedCut", "expectedRoundCut", "getExpectedRoundCut", "getP0-1ufDz9w", "getP1-1ufDz9w", "getP2-1ufDz9w", "getRounding", "()Landroidx/graphics/shapes/CornerRounding;", "sinAngle", "getSinAngle", "smoothing", "getSmoothing", "calculateActualSmoothingValue", "allowedCut", "computeFlankingCurve", "Landroidx/graphics/shapes/Cubic;", "actualRoundCut", "actualSmoothingValues", "corner", "sideStart", "circleSegmentIntersection", "otherCircleSegmentIntersection", "circleCenter", "actualR", "computeFlankingCurve-oAJzIJU", "(FFJJJJJF)Landroidx/graphics/shapes/Cubic;", "getCubics", "", "allowedCut0", "allowedCut1", "lineIntersection", "d0", "lineIntersection-CBFvKDc", "(JJJJ)Landroidx/collection/FloatFloatPair;", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;
    private final long d1;
    private final long d2;
    private final float expectedRoundCut;
    private final long p0;
    private final long p1;
    private final long p2;

    @Nullable
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    public /* synthetic */ RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, j11, j12, cornerRounding);
    }

    private final float calculateActualSmoothingValue(float allowedCut) {
        if (allowedCut > getExpectedCut()) {
            return this.smoothing;
        }
        float f10 = this.expectedRoundCut;
        if (allowedCut > f10) {
            return (this.smoothing * (allowedCut - f10)) / (getExpectedCut() - this.expectedRoundCut);
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m٥٥computeFlankingCurveoAJzIJU(float actualRoundCut, float actualSmoothingValues, long corner, long sideStart, long circleSegmentIntersection, long otherCircleSegmentIntersection, long circleCenter, float actualR) {
        long j10 = PointKt.m٤٢getDirectionDnnuFBc(PointKt.m٤٨minusybeJwSQ(sideStart, corner));
        long j11 = PointKt.m٤٩plusybeJwSQ(corner, PointKt.m٥١timesso9K2fw(PointKt.m٥١timesso9K2fw(j10, actualRoundCut), 1 + actualSmoothingValues));
        long j12 = circleSegmentIntersection;
        long j13 = PointKt.m٤٧interpolatedLqxh1s(j12, PointKt.m٣٩divso9K2fw(PointKt.m٤٩plusybeJwSQ(circleSegmentIntersection, otherCircleSegmentIntersection), 2.0f), actualSmoothingValues);
        long j14 = PointKt.m٤٩plusybeJwSQ(circleCenter, PointKt.m٥١timesso9K2fw(Utils.directionVector(PointKt.m٤٥getXDnnuFBc(j13) - PointKt.m٤٥getXDnnuFBc(circleCenter), PointKt.m٤٦getYDnnuFBc(j13) - PointKt.m٤٦getYDnnuFBc(circleCenter)), actualR));
        FloatFloatPair floatFloatPair = m٥٦lineIntersectionCBFvKDc(sideStart, j10, j14, Utils.m٦٨rotate90DnnuFBc(PointKt.m٤٨minusybeJwSQ(j14, circleCenter)));
        if (floatFloatPair != null) {
            j12 = floatFloatPair.getPackedValue();
        }
        return new Cubic(j11, PointKt.m٣٩divso9K2fw(PointKt.m٤٩plusybeJwSQ(j11, PointKt.m٥١timesso9K2fw(j12, 2.0f)), 3.0f), j12, j14, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = f10;
        }
        return roundedCorner.getCubics(f10, f11);
    }

    /* renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m٥٦lineIntersectionCBFvKDc(long p02, long d02, long p12, long d12) {
        long j10 = Utils.m٦٨rotate90DnnuFBc(d12);
        float f10 = PointKt.m٤١dotProductybeJwSQ(d02, j10);
        if (Math.abs(f10) < 1.0E-4f) {
            return null;
        }
        float f11 = PointKt.m٤١dotProductybeJwSQ(PointKt.m٤٨minusybeJwSQ(p12, p02), j10);
        if (Math.abs(f10) < Math.abs(f11) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m٠boximpl(PointKt.m٤٩plusybeJwSQ(p02, PointKt.m٥١timesso9K2fw(d02, f11 / f10)));
    }

    /* renamed from: getCenter-1ufDz9w, reason: not valid java name and from getter */
    public final long getCenter() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    @JvmOverloads
    @NotNull
    public final List<Cubic> getCubics(float f10) {
        return getCubics$default(this, f10, DownloadProgress.UNKNOWN_PROGRESS, 2, null);
    }

    /* renamed from: getD1-1ufDz9w, reason: not valid java name and from getter */
    public final long getD1() {
        return this.d1;
    }

    /* renamed from: getD2-1ufDz9w, reason: not valid java name and from getter */
    public final long getD2() {
        return this.d2;
    }

    public final float getExpectedCut() {
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* renamed from: getP0-1ufDz9w, reason: not valid java name and from getter */
    public final long getP0() {
        return this.p0;
    }

    /* renamed from: getP1-1ufDz9w, reason: not valid java name and from getter */
    public final long getP1() {
        return this.p1;
    }

    /* renamed from: getP2-1ufDz9w, reason: not valid java name and from getter */
    public final long getP2() {
        return this.p2;
    }

    @Nullable
    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m٦٣setCenterDnnuFBc(long j10) {
        this.center = j10;
    }

    private RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding) {
        this.p0 = j10;
        this.p1 = j11;
        this.p2 = j12;
        this.rounding = cornerRounding;
        long j13 = PointKt.m٤٢getDirectionDnnuFBc(PointKt.m٤٨minusybeJwSQ(j10, j11));
        this.d1 = j13;
        long j14 = PointKt.m٤٢getDirectionDnnuFBc(PointKt.m٤٨minusybeJwSQ(j12, j11));
        this.d2 = j14;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : DownloadProgress.UNKNOWN_PROGRESS;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : DownloadProgress.UNKNOWN_PROGRESS;
        float f10 = PointKt.m٤١dotProductybeJwSQ(j13, j14);
        this.cosAngle = f10;
        float f11 = 1;
        float sqrt = (float) Math.sqrt(f11 - Utils.square(f10));
        this.sinAngle = sqrt;
        this.expectedRoundCut = ((double) sqrt) > 0.001d ? (radius * (f10 + f11)) / sqrt : DownloadProgress.UNKNOWN_PROGRESS;
        this.center = FloatFloatPair.m٣constructorimpl(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
    }

    @JvmOverloads
    @NotNull
    public final List<Cubic> getCubics(float allowedCut0, float allowedCut1) {
        float min = Math.min(allowedCut0, allowedCut1);
        float f10 = this.expectedRoundCut;
        if (f10 >= 1.0E-4f && min >= 1.0E-4f && this.cornerRadius >= 1.0E-4f) {
            float min2 = Math.min(min, f10);
            float calculateActualSmoothingValue = calculateActualSmoothingValue(allowedCut0);
            float calculateActualSmoothingValue2 = calculateActualSmoothingValue(allowedCut1);
            float f11 = (this.cornerRadius * min2) / this.expectedRoundCut;
            this.center = PointKt.m٤٩plusybeJwSQ(this.p1, PointKt.m٥١timesso9K2fw(PointKt.m٤٢getDirectionDnnuFBc(PointKt.m٣٩divso9K2fw(PointKt.m٤٩plusybeJwSQ(this.d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(f11) + Utils.square(min2))));
            long j10 = PointKt.m٤٩plusybeJwSQ(this.p1, PointKt.m٥١timesso9K2fw(this.d1, min2));
            long j11 = PointKt.m٤٩plusybeJwSQ(this.p1, PointKt.m٥١timesso9K2fw(this.d2, min2));
            Cubic cubic = m٥٥computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue, this.p1, this.p0, j10, j11, this.center, f11);
            Cubic reverse = m٥٥computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue2, this.p1, this.p2, j11, j10, this.center, f11).reverse();
            return CollectionsKt.listOf((Object[]) new Cubic[]{cubic, Cubic.INSTANCE.circularArc(PointKt.m٤٥getXDnnuFBc(this.center), PointKt.m٤٦getYDnnuFBc(this.center), cubic.getAnchor1X(), cubic.getAnchor1Y(), reverse.getAnchor0X(), reverse.getAnchor0Y()), reverse});
        }
        long j12 = this.p1;
        this.center = j12;
        return CollectionsKt.listOf(Cubic.INSTANCE.straightLine(PointKt.m٤٥getXDnnuFBc(j12), PointKt.m٤٦getYDnnuFBc(this.p1), PointKt.m٤٥getXDnnuFBc(this.p1), PointKt.m٤٦getYDnnuFBc(this.p1)));
    }

    public /* synthetic */ RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, j11, j12, (i10 & 8) != 0 ? null : cornerRounding, null);
    }
}
