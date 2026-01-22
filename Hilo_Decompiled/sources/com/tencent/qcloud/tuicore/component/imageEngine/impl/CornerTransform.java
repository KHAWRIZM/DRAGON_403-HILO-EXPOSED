package com.tencent.qcloud.tuicore.component.imageEngine.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.Glide;
import java.security.MessageDigest;
import m4.m;
import o4.v;
import p4.d;
import v4.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CornerTransform implements m {
    private boolean exceptLeftBottom;
    private boolean exceptLeftTop;
    private boolean exceptRightBottom;
    private boolean exceptRightTop;
    private d mBitmapPool;
    private float radius;

    public CornerTransform(Context context, float f) {
        this.mBitmapPool = Glide.get(context).getBitmapPool();
        this.radius = f;
    }

    public void setExceptCorner(boolean z, boolean z2, boolean z3, boolean z4) {
        this.exceptLeftTop = z;
        this.exceptRightTop = z2;
        this.exceptLeftBottom = z3;
        this.exceptRightBottom = z4;
    }

    public v transform(Context context, v vVar, int i, int i2) {
        int height;
        int i3;
        Bitmap bitmap = (Bitmap) vVar.get();
        if (i > i2) {
            float f = i2;
            float f2 = i;
            height = bitmap.getWidth();
            i3 = (int) (bitmap.getWidth() * (f / f2));
            if (i3 > bitmap.getHeight()) {
                i3 = bitmap.getHeight();
                height = (int) (bitmap.getHeight() * (f2 / f));
            }
        } else if (i < i2) {
            float f3 = i;
            float f4 = i2;
            int height2 = bitmap.getHeight();
            int height3 = (int) (bitmap.getHeight() * (f3 / f4));
            if (height3 > bitmap.getWidth()) {
                height = bitmap.getWidth();
                i3 = (int) (bitmap.getWidth() * (f4 / f3));
            } else {
                height = height3;
                i3 = height2;
            }
        } else {
            height = bitmap.getHeight();
            i3 = height;
        }
        this.radius *= i3 / i2;
        d dVar = this.mBitmapPool;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap f5 = dVar.f(height, i3, config);
        if (f5 == null) {
            f5 = Bitmap.createBitmap(height, i3, config);
        }
        Canvas canvas = new Canvas(f5);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        int width = (bitmap.getWidth() - height) / 2;
        int height4 = (bitmap.getHeight() - i3) / 2;
        if (width != 0 || height4 != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width, -height4);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        float f6 = this.radius;
        canvas.drawRoundRect(rectF, f6, f6, paint);
        if (this.exceptLeftTop) {
            float f7 = this.radius;
            canvas.drawRect(0.0f, 0.0f, f7, f7, paint);
        }
        if (this.exceptRightTop) {
            float width2 = canvas.getWidth();
            float f8 = this.radius;
            canvas.drawRect(width2 - f8, 0.0f, f8, f8, paint);
        }
        if (this.exceptLeftBottom) {
            float height5 = canvas.getHeight();
            float f9 = this.radius;
            canvas.drawRect(0.0f, height5 - f9, f9, canvas.getHeight(), paint);
        }
        if (this.exceptRightBottom) {
            canvas.drawRect(canvas.getWidth() - this.radius, canvas.getHeight() - this.radius, canvas.getWidth(), canvas.getHeight(), paint);
        }
        return f.b(f5, this.mBitmapPool);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
