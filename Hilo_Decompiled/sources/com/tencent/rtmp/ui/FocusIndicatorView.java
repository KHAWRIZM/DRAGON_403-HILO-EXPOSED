package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FocusIndicatorView extends View {
    final ScaleAnimation a;
    private final Paint b;
    private final int c;
    private final Rect d;

    public FocusIndicatorView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.c / 2;
        Rect rect = this.d;
        rect.left = i;
        rect.top = i;
        rect.right = getWidth() - i;
        this.d.bottom = getHeight() - i;
        canvas.drawRect(this.d, this.b);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Rect();
        int i2 = (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.c = i2;
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i2);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.a = scaleAnimation;
        scaleAnimation.setDuration(200L);
    }
}
