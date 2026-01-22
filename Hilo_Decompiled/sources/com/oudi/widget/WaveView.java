package com.oudi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class WaveView extends View {
    private static final int DEFAULT_CIRCLE_ALPHA = 71;
    private static final int DEFAULT_CIRCLE_EXPANSION = 40;
    private static final float DEFAULT_CIRCLE_SPEED = 0.02f;
    private static final int DEFAULT_CIRCLE_WIDTH = 8;
    private boolean isRelease;
    private boolean isRunning;
    private boolean isStart;
    private Paint mPaint;
    private float mProgress;

    public WaveView(Context context) {
        this(context, null);
    }

    private void drawCircle(Canvas canvas) {
        float f10 = this.mProgress;
        int i10 = (int) (71.0f - ((f10 - DEFAULT_CIRCLE_SPEED) * 71.0f));
        this.mProgress = f10 + DEFAULT_CIRCLE_SPEED;
        this.mPaint.setAlpha(Math.max(i10, 0));
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(getWidth() / 2, getHeight() / 2) + ((int) (40.0f * f10)), this.mPaint);
        if (this.mProgress > 1.0f) {
            this.mProgress = DownloadProgress.UNKNOWN_PROGRESS;
            if (this.isStart) {
                invalidate();
                return;
            } else {
                release();
                return;
            }
        }
        this.isRunning = true;
        invalidate();
    }

    private int getInt(String str) {
        return Integer.parseInt(str, 16);
    }

    private void init(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.WaveView);
        this.mPaint = new Paint();
        setPaint();
        this.mPaint.setColor(obtainStyledAttributes.getInt(R.styleable.WaveView_wave_color, -7829368));
        obtainStyledAttributes.recycle();
    }

    private void setPaint() {
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(8.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.isRelease) {
            drawCircle(canvas);
        }
    }

    public synchronized void release() {
        this.isRelease = true;
        this.isRunning = false;
    }

    public void setWidthAndHeight(int i10, int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i11;
        layoutParams.setMargins(0, i12, 0, 0);
        setLayoutParams(layoutParams);
    }

    public synchronized void start() {
        this.isRelease = false;
        this.isStart = true;
        if (!this.isRunning) {
            postInvalidate();
        }
    }

    public synchronized void stop() {
        this.isStart = false;
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mProgress = DownloadProgress.UNKNOWN_PROGRESS;
        this.isRelease = true;
        init(context, attributeSet, i10);
    }
}
