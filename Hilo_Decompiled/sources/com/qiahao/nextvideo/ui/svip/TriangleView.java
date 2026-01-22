package com.qiahao.nextvideo.ui.svip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class TriangleView extends View {
    private Paint a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Path f;

    public TriangleView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStyle(Paint.Style.FILL);
        this.f = new Path();
        this.e = 1;
    }

    public void b(int i, int i2, boolean z) {
        if (z) {
            i = androidx.core.content.a.getColor(getContext(), i);
        }
        this.b = i;
        this.e = i2;
        this.a.setColor(this.b);
        postInvalidateDelayed(100L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.e;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.f.moveTo(0.0f, this.d / 2);
                        this.f.lineTo(this.c, this.d);
                        this.f.lineTo(this.c, 0.0f);
                    }
                } else {
                    this.f.moveTo(0.0f, 0.0f);
                    this.f.lineTo(0.0f, this.d);
                    this.f.lineTo(this.c, this.d / 2);
                }
            } else {
                this.f.moveTo(0.0f, 0.0f);
                this.f.lineTo(this.c / 2, this.d);
                this.f.lineTo(this.c, 0.0f);
            }
        } else {
            this.f.moveTo(0.0f, this.d);
            this.f.lineTo(this.c, this.d);
            this.f.lineTo(this.c / 2, 0.0f);
        }
        this.f.close();
        canvas.drawPath(this.f, this.a);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = View.MeasureSpec.getSize(i);
        this.d = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.c == 0 || mode != 1073741824) {
            this.c = dd.a.a(10.0f);
        }
        if (this.d == 0 || mode2 != 1073741824) {
            this.d = dd.a.a(6.0f);
        }
        setMeasuredDimension(this.c, this.d);
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TriangleView, 0, 0);
        this.b = obtainStyledAttributes.getColor(0, androidx.core.content.a.getColor(getContext(), 2131101214));
        this.e = obtainStyledAttributes.getInt(1, this.e);
        obtainStyledAttributes.recycle();
        this.a.setColor(this.b);
    }
}
