package io.agora.rtc.gl;

import android.graphics.Matrix;
import android.graphics.Point;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RendererCommon {
    private static float BALANCED_VISIBLE_FRACTION = 0.5625f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.agora.rtc.gl.RendererCommon$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$agora$rtc$gl$RendererCommon$ScalingType;

        static {
            int[] iArr = new int[ScalingType.values().length];
            $SwitchMap$io$agora$rtc$gl$RendererCommon$ScalingType = iArr;
            try {
                iArr[ScalingType.SCALE_ASPECT_FIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$agora$rtc$gl$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$agora$rtc$gl$RendererCommon$ScalingType[ScalingType.SCALE_ASPECT_BALANCED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface GlDrawer {
        void drawOes(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16);

        void drawRgb(int i10, float[] fArr, int i11, int i12, int i13, int i14, int i15, int i16);

        void drawYuv(int[] iArr, float[] fArr, int i10, int i11, int i12, int i13, int i14, int i15);

        void release();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface RendererEvents {
        void onFirstFrameRendered();

        void onFrameResolutionChanged(int i10, int i11, int i12);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum ScalingType {
        SCALE_ASPECT_FIT,
        SCALE_ASPECT_FILL,
        SCALE_ASPECT_BALANCED
    }

    private static void adjustOrigin(float[] fArr) {
        float f10 = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[12] = f10;
        float f11 = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[13] = f11;
        fArr[12] = f10 + 0.5f;
        fArr[13] = f11 + 0.5f;
    }

    public static float[] convertMatrixFromAndroidGraphicsMatrix(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return new float[]{fArr[0], fArr[3], DownloadProgress.UNKNOWN_PROGRESS, fArr[6], fArr[1], fArr[4], DownloadProgress.UNKNOWN_PROGRESS, fArr[7], DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, fArr[2], fArr[5], DownloadProgress.UNKNOWN_PROGRESS, fArr[8]};
    }

    public static Matrix convertMatrixToAndroidGraphicsMatrix(float[] fArr) {
        float[] fArr2 = {fArr[0], fArr[4], fArr[12], fArr[1], fArr[5], fArr[13], fArr[3], fArr[7], fArr[15]};
        Matrix matrix = new Matrix();
        matrix.setValues(fArr2);
        return matrix;
    }

    private static float convertScalingTypeToVisibleFraction(ScalingType scalingType) {
        int i10 = AnonymousClass1.$SwitchMap$io$agora$rtc$gl$RendererCommon$ScalingType[scalingType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return BALANCED_VISIBLE_FRACTION;
                }
                throw new IllegalArgumentException();
            }
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return 1.0f;
    }

    public static Point getDisplaySize(ScalingType scalingType, float f10, int i10, int i11) {
        return getDisplaySize(convertScalingTypeToVisibleFraction(scalingType), f10, i10, i11);
    }

    public static float[] getLayoutMatrix(boolean z10, float f10, float f11) {
        float f12;
        float f13;
        if (f11 > f10) {
            f13 = f10 / f11;
            f12 = 1.0f;
        } else {
            f12 = f11 / f10;
            f13 = 1.0f;
        }
        if (z10) {
            f12 *= -1.0f;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        android.opengl.Matrix.scaleM(fArr, 0, f12, f13, 1.0f);
        adjustOrigin(fArr);
        return fArr;
    }

    public static final float[] horizontalFlipMatrix() {
        return new float[]{-1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f};
    }

    public static final float[] identityMatrix() {
        return new float[]{1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f};
    }

    public static float[] multiplyMatrices(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        android.opengl.Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
        return fArr3;
    }

    public static float[] rotateTextureMatrix(float[] fArr, float f10) {
        float[] fArr2 = new float[16];
        android.opengl.Matrix.setRotateM(fArr2, 0, f10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        adjustOrigin(fArr2);
        return multiplyMatrices(fArr, fArr2);
    }

    public static final float[] verticalFlipMatrix() {
        return new float[]{1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, -1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f};
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class VideoLayoutMeasure {
        private ScalingType scalingTypeMatchOrientation;
        private ScalingType scalingTypeMismatchOrientation;

        public VideoLayoutMeasure() {
            ScalingType scalingType = ScalingType.SCALE_ASPECT_BALANCED;
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public Point measure(int i10, int i11, int i12, int i13) {
            boolean z10;
            ScalingType scalingType;
            int defaultSize = View.getDefaultSize(Integer.MAX_VALUE, i10);
            int defaultSize2 = View.getDefaultSize(Integer.MAX_VALUE, i11);
            if (i12 != 0 && i13 != 0 && defaultSize != 0 && defaultSize2 != 0) {
                float f10 = i12 / i13;
                float f11 = defaultSize / defaultSize2;
                boolean z11 = false;
                if (f10 > 1.0f) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (f11 > 1.0f) {
                    z11 = true;
                }
                if (z10 == z11) {
                    scalingType = this.scalingTypeMatchOrientation;
                } else {
                    scalingType = this.scalingTypeMismatchOrientation;
                }
                Point displaySize = RendererCommon.getDisplaySize(scalingType, f10, defaultSize, defaultSize2);
                if (View.MeasureSpec.getMode(i10) == 1073741824) {
                    displaySize.x = defaultSize;
                }
                if (View.MeasureSpec.getMode(i11) == 1073741824) {
                    displaySize.y = defaultSize2;
                }
                return displaySize;
            }
            return new Point(defaultSize, defaultSize2);
        }

        public void setScalingType(ScalingType scalingType) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType;
        }

        public void setScalingType(ScalingType scalingType, ScalingType scalingType2) {
            this.scalingTypeMatchOrientation = scalingType;
            this.scalingTypeMismatchOrientation = scalingType2;
        }
    }

    private static Point getDisplaySize(float f10, float f11, int i10, int i11) {
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS && f11 != DownloadProgress.UNKNOWN_PROGRESS) {
            return new Point(Math.min(i10, Math.round((i11 / f10) * f11)), Math.min(i11, Math.round((i10 / f10) / f11)));
        }
        return new Point(i10, i11);
    }
}
