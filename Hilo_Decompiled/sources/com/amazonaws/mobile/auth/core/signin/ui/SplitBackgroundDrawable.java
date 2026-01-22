package com.amazonaws.mobile.auth.core.signin.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SplitBackgroundDrawable extends Drawable {
    private static final int DEFAULT_BACKGROUND_COLOR = -1;
    private int distanceFromTopToSplitPoint;
    private Paint paint;
    private int topBackgroundColor;

    public SplitBackgroundDrawable(int i10) {
        this.distanceFromTopToSplitPoint = -1;
        this.paint = new Paint();
        this.topBackgroundColor = -1;
        setSplitPointDistanceFromTop(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int height;
        Rect bounds = getBounds();
        this.paint.setColor(this.topBackgroundColor);
        if (this.distanceFromTopToSplitPoint < bounds.height()) {
            height = this.distanceFromTopToSplitPoint;
        } else {
            height = bounds.height();
        }
        float f10 = height;
        canvas.drawRect(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, bounds.width(), f10, this.paint);
        this.paint.setColor(-1);
        canvas.drawRect(DownloadProgress.UNKNOWN_PROGRESS, f10, bounds.width(), bounds.height(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setSplitPointDistanceFromTop(int i10) {
        this.distanceFromTopToSplitPoint = i10;
        invalidateSelf();
    }

    public SplitBackgroundDrawable(int i10, int i11) {
        this.distanceFromTopToSplitPoint = -1;
        this.paint = new Paint();
        this.topBackgroundColor = i11;
        setSplitPointDistanceFromTop(i10);
    }
}
