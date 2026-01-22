package com.qiahao.base_common.wedgit.shineText;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class FlowingLightView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f١٢٦٧٢a;

    /* renamed from: b, reason: collision with root package name */
    private Path f١٢٦٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private LinearGradient f١٢٦٧٤c;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f١٢٦٧٥d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f١٢٦٧٦a;

        a(float f10) {
            this.f١٢٦٧٦a = f10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            FlowingLightView flowingLightView = FlowingLightView.this;
            float f10 = this.f١٢٦٧٦a;
            float f11 = 100.0f + floatValue;
            flowingLightView.f١٢٦٧٤c = new LinearGradient(floatValue, f10 * floatValue, f11, f10 * f11, new int[]{Color.parseColor("#00ffbf42"), Color.parseColor("#ffbf42"), Color.parseColor("#00ffbf42")}, (float[]) null, Shader.TileMode.CLAMP);
            FlowingLightView flowingLightView2 = FlowingLightView.this;
            flowingLightView2.f١٢٦٧٢a.setShader(flowingLightView2.f١٢٦٧٤c);
            FlowingLightView.this.invalidate();
        }
    }

    public FlowingLightView(Context context) {
        this(context, null);
    }

    private void d() {
        this.f١٢٦٧٢a = new Paint();
        this.f١٢٦٧٣b = new Path();
    }

    private void e(int i10, int i11) {
        Point point = new Point(0, 0);
        Point point2 = new Point(i10, 0);
        Point point3 = new Point(i10, i11);
        Point point4 = new Point(0, i11);
        this.f١٢٦٧٣b.moveTo(point.x, point.y);
        this.f١٢٦٧٣b.lineTo(point2.x, point2.y);
        this.f١٢٦٧٣b.lineTo(point3.x, point3.y);
        this.f١٢٦٧٣b.lineTo(point4.x, point4.y);
        this.f١٢٦٧٣b.close();
        float f10 = i10;
        float f11 = (i11 * DownloadProgress.UNKNOWN_PROGRESS) / f10;
        float f12 = ((1.0f * f10) / 8.0f) / 2.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS - f12, f10 + f12);
        this.f١٢٦٧٥d = ofFloat;
        ofFloat.setRepeatCount(-1);
        this.f١٢٦٧٥d.setInterpolator(new LinearInterpolator());
        this.f١٢٦٧٥d.setDuration(4000L);
        this.f١٢٦٧٥d.addUpdateListener(new a(f11));
        this.f١٢٦٧٥d.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f١٢٦٧٥d.cancel();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f١٢٦٧٣b, this.f١٢٦٧٢a);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        e(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
    }

    public FlowingLightView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowingLightView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d();
    }
}
