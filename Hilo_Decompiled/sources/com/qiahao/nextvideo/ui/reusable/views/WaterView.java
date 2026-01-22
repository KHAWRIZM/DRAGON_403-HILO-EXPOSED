package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class WaterView extends View {
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private int m;
    private int n;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface a {
    }

    public WaterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        int parseColor = Color.parseColor("#01FFFFFF");
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(parseColor);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(parseColor);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setColor(parseColor);
        paint3.setAlpha(100);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.setAlpha((int) this.f);
        this.b.setAlpha((int) this.i);
        canvas.drawCircle(this.k, this.l, this.d, this.a);
        canvas.drawCircle(this.k, this.l, this.g, this.b);
        canvas.drawCircle(this.k, this.l, this.j, this.c);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.n = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.m = size;
        this.k = this.n / 2;
        float f = size / 2;
        this.l = f;
        float f2 = this.j;
        this.e = f - f2;
        this.h = f - f2;
        this.j = 10.0f;
    }

    public void setEndListener(a aVar) {
    }
}
