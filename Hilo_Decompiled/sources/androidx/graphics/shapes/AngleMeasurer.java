package androidx.graphics.shapes;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000e"}, d2 = {"Landroidx/graphics/shapes/AngleMeasurer;", "Landroidx/graphics/shapes/Measurer;", "centerX", "", "centerY", "(FF)V", "getCenterX", "()F", "getCenterY", "findCubicCutPoint", "c", "Landroidx/graphics/shapes/Cubic;", "m", "measureCubic", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class AngleMeasurer implements Measurer {
    private final float centerX;
    private final float centerY;

    public AngleMeasurer(float f10, float f11) {
        this.centerX = f10;
        this.centerY = f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float findCubicCutPoint$lambda$1(Cubic c10, AngleMeasurer this$0, float f10, float f11, float f12) {
        Intrinsics.checkNotNullParameter(c10, "$c");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j10 = c10.m٣٣pointOnCurveOOQOV4g$graphics_shapes_release(f12);
        return Math.abs(Utils.positiveModulo(Utils.angle(PointKt.m٤٥getXDnnuFBc(j10) - this$0.centerX, PointKt.m٤٦getYDnnuFBc(j10) - this$0.centerY) - f10, Utils.getTwoPi()) - f11);
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(@NotNull final Cubic c10, final float m10) {
        Intrinsics.checkNotNullParameter(c10, "c");
        final float angle = Utils.angle(c10.getAnchor0X() - this.centerX, c10.getAnchor0Y() - this.centerY);
        return Utils.findMinimum(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1.0E-5f, new FindMinimumFunction() { // from class: androidx.graphics.shapes.a
            @Override // androidx.graphics.shapes.FindMinimumFunction
            public final float invoke(float f10) {
                float findCubicCutPoint$lambda$1;
                findCubicCutPoint$lambda$1 = AngleMeasurer.findCubicCutPoint$lambda$1(Cubic.this, this, angle, m10, f10);
                return findCubicCutPoint$lambda$1;
            }
        });
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(@NotNull Cubic c10) {
        Intrinsics.checkNotNullParameter(c10, "c");
        float positiveModulo = Utils.positiveModulo(Utils.angle(c10.getAnchor1X() - this.centerX, c10.getAnchor1Y() - this.centerY) - Utils.angle(c10.getAnchor0X() - this.centerX, c10.getAnchor0Y() - this.centerY), Utils.getTwoPi());
        if (positiveModulo > Utils.getTwoPi() - 1.0E-4f) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return positiveModulo;
    }
}
