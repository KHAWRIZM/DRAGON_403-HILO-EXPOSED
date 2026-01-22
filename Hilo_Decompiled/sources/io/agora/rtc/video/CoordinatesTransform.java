package io.agora.rtc.video;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CoordinatesTransform {
    public static RectF normalizedFaceRect(Rect rect, int i10, boolean z10) {
        Matrix matrix = new Matrix();
        prepareMatrix(matrix, z10, i10);
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        return rectF;
    }

    private static void prepareMatrix(Matrix matrix, boolean z10, int i10) {
        float f10;
        if (z10) {
            f10 = -1.0f;
        } else {
            f10 = 1.0f;
        }
        matrix.setScale(f10, 1.0f);
        matrix.postRotate(i10);
        matrix.postScale(5.0E-4f, 5.0E-4f);
        matrix.postTranslate(0.5f, 0.5f);
    }

    public static Rect sensorToNormalizedPreview(Rect rect, int i10, int i11, Rect rect2) {
        double d10;
        double d11;
        if (i10 > i11) {
            d10 = i10;
            d11 = i11;
        } else {
            d10 = i11;
            d11 = i10;
        }
        double d12 = d10 / d11;
        double width = rect2.width() / rect2.height();
        int width2 = rect2.width();
        int height = rect2.height();
        if (d12 > width) {
            height = (int) (width2 / d12);
        } else {
            width2 = (int) (height * d12);
        }
        int abs = Math.abs(width2 - rect2.width());
        int abs2 = Math.abs(height - rect2.height());
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.postTranslate((-rect2.left) - (abs / 2), (-rect2.top) - (abs2 / 2));
        matrix.postTranslate((-width2) / 2, (-height) / 2);
        matrix.postScale(2000.0f / width2, 2000.0f / height);
        matrix.mapRect(rectF);
        Rect rect3 = new Rect();
        rectF.round(rect3);
        return rect3;
    }
}
