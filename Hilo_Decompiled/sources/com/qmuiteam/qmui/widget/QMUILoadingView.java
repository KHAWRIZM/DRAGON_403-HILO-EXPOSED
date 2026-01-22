package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.collection.SimpleArrayMap;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import ic.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUILoadingView extends View implements fc.a {

    /* renamed from: g, reason: collision with root package name */
    private static SimpleArrayMap f١٢٩٧٥g;

    /* renamed from: a, reason: collision with root package name */
    private int f١٢٩٧٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٢٩٧٧b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٩٧٨c;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f١٢٩٧٩d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f١٢٩٨٠e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f١٢٩٨١f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QMUILoadingView.this.f١٢٩٧٨c = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            QMUILoadingView.this.invalidate();
        }
    }

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        f١٢٩٧٥g = simpleArrayMap;
        simpleArrayMap.put("tintColor", Integer.valueOf(R.attr.qmui_skin_support_loading_color));
    }

    public QMUILoadingView(Context context) {
        this(context, null);
    }

    private void b(Canvas canvas, int i10) {
        int i11 = this.f١٢٩٧٦a;
        int i12 = i11 / 12;
        int i13 = i11 / 6;
        this.f١٢٩٨٠e.setStrokeWidth(i12);
        int i14 = this.f١٢٩٧٦a;
        canvas.rotate(i10, i14 / 2, i14 / 2);
        int i15 = this.f١٢٩٧٦a;
        canvas.translate(i15 / 2, i15 / 2);
        int i16 = 0;
        while (i16 < 12) {
            canvas.rotate(30.0f);
            i16++;
            this.f١٢٩٨٠e.setAlpha((int) ((i16 * 255.0f) / 12.0f));
            int i17 = i12 / 2;
            canvas.translate(DownloadProgress.UNKNOWN_PROGRESS, ((-this.f١٢٩٧٦a) / 2) + i17);
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i13, this.f١٢٩٨٠e);
            canvas.translate(DownloadProgress.UNKNOWN_PROGRESS, (this.f١٢٩٧٦a / 2) - i17);
        }
    }

    private void c() {
        Paint paint = new Paint();
        this.f١٢٩٨٠e = paint;
        paint.setColor(this.f١٢٩٧٧b);
        this.f١٢٩٨٠e.setAntiAlias(true);
        this.f١٢٩٨٠e.setStrokeCap(Paint.Cap.ROUND);
    }

    public void d() {
        ValueAnimator valueAnimator = this.f١٢٩٧٩d;
        if (valueAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 11);
            this.f١٢٩٧٩d = ofInt;
            ofInt.addUpdateListener(this.f١٢٩٨١f);
            this.f١٢٩٧٩d.setDuration(600L);
            this.f١٢٩٧٩d.setRepeatMode(1);
            this.f١٢٩٧٩d.setRepeatCount(-1);
            this.f١٢٩٧٩d.setInterpolator(new LinearInterpolator());
            this.f١٢٩٧٩d.start();
            return;
        }
        if (!valueAnimator.isStarted()) {
            this.f١٢٩٧٩d.start();
        }
    }

    public void e() {
        ValueAnimator valueAnimator = this.f١٢٩٧٩d;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.f١٢٩٨١f);
            this.f١٢٩٧٩d.removeAllUpdateListeners();
            this.f١٢٩٧٩d.cancel();
            this.f١٢٩٧٩d = null;
        }
    }

    @Override // fc.a
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return f١٢٩٧٥g;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight(), null, 31);
        b(canvas, this.f١٢٩٧٨c * 30);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = this.f١٢٩٧٦a;
        setMeasuredDimension(i12, i12);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            d();
        } else {
            e();
        }
    }

    public void setColor(int i10) {
        this.f١٢٩٧٧b = i10;
        this.f١٢٩٨٠e.setColor(i10);
        invalidate();
    }

    public void setSize(int i10) {
        this.f١٢٩٧٦a = i10;
        requestLayout();
    }

    public QMUILoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUILoadingStyle);
    }

    public QMUILoadingView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٩٧٨c = 0;
        this.f١٢٩٨١f = new a();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUILoadingView, i10, 0);
        this.f١٢٩٧٦a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUILoadingView_qmui_loading_view_size, e.a(context, 32));
        this.f١٢٩٧٧b = obtainStyledAttributes.getInt(R.styleable.QMUILoadingView_android_color, -1);
        obtainStyledAttributes.recycle();
        c();
    }
}
