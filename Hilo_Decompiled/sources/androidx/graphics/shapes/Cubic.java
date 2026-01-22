package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B7\b\u0010\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\bB\u0011\b\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ!\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\u0013\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020(H\u0016J\u0011\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0086\u0002J!\u0010.\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010/\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0000J\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000042\u0006\u0010/\u001a\u00020\rJ\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\b\u00106\u001a\u000207H\u0016J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\rH\u0002J\r\u0010=\u001a\u00020$H\u0000¢\u0006\u0002\b>R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "anchor0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "points", "", "([F)V", "anchor0X", "", "getAnchor0X", "()F", "anchor0Y", "getAnchor0Y", "anchor1X", "getAnchor1X", "anchor1Y", "getAnchor1Y", "control0X", "getControl0X", "control0Y", "getControl0Y", "control1X", "getControl1X", "control1Y", "getControl1Y", "getPoints$graphics_shapes_release", "()[F", "calculateBounds", "", "bounds", "approximate", "", "calculateBounds$graphics_shapes_release", "div", "x", "", "equals", "other", "hashCode", "plus", "o", "pointOnCurve", "t", "pointOnCurve-OOQOV4g$graphics_shapes_release", "(F)J", "reverse", "split", "Lkotlin/Pair;", "times", "toString", "", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "zeroIsh", "value", "zeroLength", "zeroLength$graphics_shapes_release", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCubic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cubic.kt\nandroidx/graphics/shapes/Cubic\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,448:1\n1#2:449\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Cubic {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final float[] points;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "()V", "circularArc", "Landroidx/graphics/shapes/Cubic;", "centerX", "", "centerY", "x0", "y0", "x1", "y1", "straightLine", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Cubic circularArc(float centerX, float centerY, float x02, float y02, float x12, float y12) {
            boolean z10;
            float f10;
            float f11 = x02 - centerX;
            float f12 = y02 - centerY;
            long directionVector = Utils.directionVector(f11, f12);
            float f13 = x12 - centerX;
            float f14 = y12 - centerY;
            long directionVector2 = Utils.directionVector(f13, f14);
            long j10 = Utils.m٦٨rotate90DnnuFBc(directionVector);
            long j11 = Utils.m٦٨rotate90DnnuFBc(directionVector2);
            if (PointKt.m٤٠dotProduct5P9i7ZU(j10, f13, f14) >= DownloadProgress.UNKNOWN_PROGRESS) {
                z10 = true;
            } else {
                z10 = false;
            }
            float f15 = PointKt.m٤١dotProductybeJwSQ(directionVector, directionVector2);
            if (f15 > 0.999f) {
                return straightLine(x02, y02, x12, y12);
            }
            float distance = (((Utils.distance(f11, f12) * 4.0f) / 3.0f) * (((float) Math.sqrt(2 * r10)) - ((float) Math.sqrt(r5 - (f15 * f15))))) / (1 - f15);
            if (z10) {
                f10 = 1.0f;
            } else {
                f10 = -1.0f;
            }
            float f16 = distance * f10;
            return CubicKt.Cubic(x02, y02, (PointKt.m٤٥getXDnnuFBc(j10) * f16) + x02, (PointKt.m٤٦getYDnnuFBc(j10) * f16) + y02, x12 - (PointKt.m٤٥getXDnnuFBc(j11) * f16), y12 - (PointKt.m٤٦getYDnnuFBc(j11) * f16), x12, y12);
        }

        @JvmStatic
        @NotNull
        public final Cubic straightLine(float x02, float y02, float x12, float y12) {
            return CubicKt.Cubic(x02, y02, Utils.interpolate(x02, x12, 0.33333334f), Utils.interpolate(y02, y12, 0.33333334f), Utils.interpolate(x02, x12, 0.6666667f), Utils.interpolate(y02, y12, 0.6666667f), x12, y12);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                fArr = new float[4];
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            cubic.calculateBounds$graphics_shapes_release(fArr, z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
    }

    @JvmStatic
    @NotNull
    public static final Cubic circularArc(float f10, float f11, float f12, float f13, float f14, float f15) {
        return INSTANCE.circularArc(f10, f11, f12, f13, f14, f15);
    }

    @JvmStatic
    @NotNull
    public static final Cubic straightLine(float f10, float f11, float f12, float f13) {
        return INSTANCE.straightLine(f10, f11, f12, f13);
    }

    private final boolean zeroIsh(float value) {
        if (Math.abs(value) < 1.0E-4f) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x01c8, code lost:
    
        if (r3 > r9) goto L٦٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01ca, code lost:
    
        r9 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x021f, code lost:
    
        if (r3 > r9) goto L٦٣;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void calculateBounds$graphics_shapes_release(@NotNull float[] bounds, boolean approximate) {
        float f10;
        float control0Y;
        float f11;
        float f12;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (zeroLength$graphics_shapes_release()) {
            bounds[0] = getAnchor0X();
            bounds[1] = getAnchor0Y();
            bounds[2] = getAnchor0X();
            bounds[3] = getAnchor0Y();
            return;
        }
        float min = Math.min(getAnchor0X(), getAnchor1X());
        float min2 = Math.min(getAnchor0Y(), getAnchor1Y());
        float max = Math.max(getAnchor0X(), getAnchor1X());
        float max2 = Math.max(getAnchor0Y(), getAnchor1Y());
        if (approximate) {
            bounds[0] = Math.min(min, Math.min(getControl0X(), getControl1X()));
            bounds[1] = Math.min(min2, Math.min(getControl0Y(), getControl1Y()));
            bounds[2] = Math.max(max, Math.max(getControl0X(), getControl1X()));
            bounds[3] = Math.max(max2, Math.max(getControl0Y(), getControl1Y()));
            return;
        }
        float f13 = 3;
        float control0X = (((-getAnchor0X()) + (getControl0X() * f13)) - (getControl1X() * f13)) + getAnchor1X();
        float f14 = 2;
        float f15 = 4;
        float anchor0X = ((getAnchor0X() * f14) - (getControl0X() * f15)) + (getControl1X() * f14);
        float control0X2 = (-getAnchor0X()) + getControl0X();
        if (zeroIsh(control0X)) {
            if (anchor0X != DownloadProgress.UNKNOWN_PROGRESS) {
                float f16 = (control0X2 * f14) / ((-2) * anchor0X);
                if (DownloadProgress.UNKNOWN_PROGRESS <= f16 && f16 <= 1.0f) {
                    float f17 = PointKt.m٤٥getXDnnuFBc(m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(f16));
                    if (f17 < min) {
                        min = f17;
                    }
                    if (f17 > max) {
                        max = f17;
                    }
                }
            }
        } else {
            float f18 = (anchor0X * anchor0X) - ((f15 * control0X) * control0X2);
            if (f18 >= DownloadProgress.UNKNOWN_PROGRESS) {
                float f19 = -anchor0X;
                double d10 = f18;
                f10 = min2;
                float f20 = control0X * f14;
                float sqrt = (((float) Math.sqrt(d10)) + f19) / f20;
                if (DownloadProgress.UNKNOWN_PROGRESS <= sqrt && sqrt <= 1.0f) {
                    float f21 = PointKt.m٤٥getXDnnuFBc(m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(sqrt));
                    if (f21 < min) {
                        min = f21;
                    }
                    if (f21 > max) {
                        max = f21;
                    }
                }
                float sqrt2 = (f19 - ((float) Math.sqrt(d10))) / f20;
                if (DownloadProgress.UNKNOWN_PROGRESS <= sqrt2 && sqrt2 <= 1.0f) {
                    float f22 = PointKt.m٤٥getXDnnuFBc(m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(sqrt2));
                    if (f22 < min) {
                        min = f22;
                    }
                    if (f22 > max) {
                        max = f22;
                    }
                }
                control0Y = (((-getAnchor0Y()) + (getControl0Y() * f13)) - (f13 * getControl1Y())) + getAnchor1Y();
                float anchor0Y = ((getAnchor0Y() * f14) - (getControl0Y() * f15)) + (getControl1Y() * f14);
                float control0Y2 = (-getAnchor0Y()) + getControl0Y();
                if (!zeroIsh(control0Y)) {
                    if (anchor0Y != DownloadProgress.UNKNOWN_PROGRESS) {
                        float f23 = (f14 * control0Y2) / ((-2) * anchor0Y);
                        if (DownloadProgress.UNKNOWN_PROGRESS <= f23 && f23 <= 1.0f) {
                            f12 = PointKt.m٤٦getYDnnuFBc(m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(f23));
                            if (f12 < f10) {
                                f11 = f12;
                            } else {
                                f11 = f10;
                            }
                        }
                    }
                    f11 = f10;
                } else {
                    float f24 = (anchor0Y * anchor0Y) - ((f15 * control0Y) * control0Y2);
                    if (f24 >= DownloadProgress.UNKNOWN_PROGRESS) {
                        float f25 = -anchor0Y;
                        double d11 = f24;
                        float f26 = f14 * control0Y;
                        float sqrt3 = (((float) Math.sqrt(d11)) + f25) / f26;
                        if (DownloadProgress.UNKNOWN_PROGRESS <= sqrt3 && sqrt3 <= 1.0f) {
                            float f27 = PointKt.m٤٦getYDnnuFBc(m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(sqrt3));
                            if (f27 < f10) {
                                f11 = f27;
                            } else {
                                f11 = f10;
                            }
                            if (f27 > max2) {
                                max2 = f27;
                            }
                        } else {
                            f11 = f10;
                        }
                        float sqrt4 = (f25 - ((float) Math.sqrt(d11))) / f26;
                        if (DownloadProgress.UNKNOWN_PROGRESS <= sqrt4 && sqrt4 <= 1.0f) {
                            f12 = PointKt.m٤٦getYDnnuFBc(m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(sqrt4));
                            if (f12 < f11) {
                                f11 = f12;
                            }
                        }
                    }
                    f11 = f10;
                }
                bounds[0] = min;
                bounds[1] = f11;
                bounds[2] = max;
                bounds[3] = max2;
            }
        }
        f10 = min2;
        control0Y = (((-getAnchor0Y()) + (getControl0Y() * f13)) - (f13 * getControl1Y())) + getAnchor1Y();
        float anchor0Y2 = ((getAnchor0Y() * f14) - (getControl0Y() * f15)) + (getControl1Y() * f14);
        float control0Y22 = (-getAnchor0Y()) + getControl0Y();
        if (!zeroIsh(control0Y)) {
        }
        bounds[0] = min;
        bounds[1] = f11;
        bounds[2] = max;
        bounds[3] = max2;
    }

    @NotNull
    public final Cubic div(float x10) {
        return times(1.0f / x10);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Cubic)) {
            return false;
        }
        return Arrays.equals(this.points, ((Cubic) other).points);
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    @NotNull
    /* renamed from: getPoints$graphics_shapes_release, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    @NotNull
    public final Cubic plus(@NotNull Cubic o10) {
        Intrinsics.checkNotNullParameter(o10, "o");
        float[] fArr = new float[8];
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = this.points[i10] + o10.points[i10];
        }
        return new Cubic(fArr);
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(float t10) {
        float f10 = 1 - t10;
        float f11 = f10 * f10 * f10;
        float f12 = 3 * t10;
        float f13 = f12 * f10 * f10;
        float f14 = f12 * t10 * f10;
        float f15 = t10 * t10 * t10;
        return FloatFloatPair.m٣constructorimpl((getAnchor0X() * f11) + (getControl0X() * f13) + (getControl1X() * f14) + (getAnchor1X() * f15), (getAnchor0Y() * f11) + (getControl0Y() * f13) + (getControl1Y() * f14) + (getAnchor1Y() * f15));
    }

    @NotNull
    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    @NotNull
    public final Pair<Cubic, Cubic> split(float t10) {
        float f10 = 1 - t10;
        long j10 = m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(t10);
        float f11 = f10 * f10;
        float f12 = 2 * f10 * t10;
        float f13 = t10 * t10;
        return TuplesKt.to(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f10) + (getControl0X() * t10), (getAnchor0Y() * f10) + (getControl0Y() * t10), (getAnchor0X() * f11) + (getControl0X() * f12) + (getControl1X() * f13), (getAnchor0Y() * f11) + (getControl0Y() * f12) + (getControl1Y() * f13), PointKt.m٤٥getXDnnuFBc(j10), PointKt.m٤٦getYDnnuFBc(j10)), CubicKt.Cubic(PointKt.m٤٥getXDnnuFBc(j10), PointKt.m٤٦getYDnnuFBc(j10), (getControl0X() * f11) + (getControl1X() * f12) + (getAnchor1X() * f13), (getControl0Y() * f11) + (getControl1Y() * f12) + (getAnchor1Y() * f13), (getControl1X() * f10) + (getAnchor1X() * t10), (getControl1Y() * f10) + (getAnchor1Y() * t10), getAnchor1X(), getAnchor1Y()));
    }

    @NotNull
    public final Cubic times(float x10) {
        float[] fArr = new float[8];
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = this.points[i10] * x10;
        }
        return new Cubic(fArr);
    }

    @NotNull
    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    @NotNull
    public final Cubic transformed(@NotNull PointTransformer f10) {
        Intrinsics.checkNotNullParameter(f10, "f");
        MutableCubic mutableCubic = new MutableCubic();
        ArraysKt.copyInto$default(this.points, mutableCubic.getPoints(), 0, 0, 0, 14, (Object) null);
        mutableCubic.transform(f10);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        if (Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f) {
            return true;
        }
        return false;
    }

    public /* synthetic */ Cubic(long j10, long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, j11, j12, j13);
    }

    @NotNull
    public final Cubic div(int x10) {
        return div(x10);
    }

    @NotNull
    public final Cubic times(int x10) {
        return times(x10);
    }

    public Cubic(@NotNull float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8");
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new float[8] : fArr);
    }

    private Cubic(long j10, long j11, long j12, long j13) {
        this(new float[]{PointKt.m٤٥getXDnnuFBc(j10), PointKt.m٤٦getYDnnuFBc(j10), PointKt.m٤٥getXDnnuFBc(j11), PointKt.m٤٦getYDnnuFBc(j11), PointKt.m٤٥getXDnnuFBc(j12), PointKt.m٤٦getYDnnuFBc(j12), PointKt.m٤٥getXDnnuFBc(j13), PointKt.m٤٦getYDnnuFBc(j13)});
    }
}
