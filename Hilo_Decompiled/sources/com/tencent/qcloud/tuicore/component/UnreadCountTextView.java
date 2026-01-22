package com.tencent.qcloud.tuicore.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UnreadCountTextView extends TextView {
    private int mNormalSize;
    private Paint mPaint;

    public UnreadCountTextView(Context context) {
        super(context);
        init(context, null);
    }

    private int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mNormalSize = dp2px(18.4f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnreadCountTextView);
        int color = obtainStyledAttributes.getColor(R.styleable.UnreadCountTextView_paint_color, getResources().getColor(R.color.read_dot_bg));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(color);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getText().length() == 0) {
            int measuredWidth = (getMeasuredWidth() - dp2px(6.0f)) / 2;
            int measuredWidth2 = getMeasuredWidth() - measuredWidth;
            float f = measuredWidth;
            float f2 = measuredWidth2;
            canvas.drawOval(new RectF(f, f, f2, f2), this.mPaint);
        } else if (getText().length() == 1) {
            int i = this.mNormalSize;
            canvas.drawOval(new RectF(0.0f, 0.0f, i, i), this.mPaint);
        } else if (getText().length() > 1) {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight()), getMeasuredHeight() / 2, getMeasuredHeight() / 2, this.mPaint);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = this.mNormalSize;
        if (getText().length() > 1) {
            i3 = this.mNormalSize + dp2px((getText().length() - 1) * 10);
        } else {
            i3 = i4;
        }
        setMeasuredDimension(i3, i4);
    }

    public void setPaintColor(int i) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public UnreadCountTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public UnreadCountTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
