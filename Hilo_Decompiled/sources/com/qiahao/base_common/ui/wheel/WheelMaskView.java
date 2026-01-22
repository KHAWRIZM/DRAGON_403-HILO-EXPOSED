package com.qiahao.base_common.ui.wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qiahao.base_common.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class WheelMaskView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f١٢٥٣٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٢٥٣٧b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٥٣٨c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٢٥٣٩d;

    public WheelMaskView(Context context) {
        super(context);
        this.f١٢٥٣٦a = new Paint(1);
        this.f١٢٥٣٧b = 0;
        this.f١٢٥٣٨c = 0;
        this.f١٢٥٣٩d = -1895825153;
        a(context, null, 0);
    }

    public void a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelMaskView, i10, 0);
        this.f١٢٥٣٩d = obtainStyledAttributes.getColor(R.styleable.WheelMaskView_wheelMaskLineColor, -1895825153);
        obtainStyledAttributes.recycle();
        this.f١٢٥٣٦a.setStyle(Paint.Style.STROKE);
        this.f١٢٥٣٦a.setStrokeWidth(1.0f);
    }

    public void b(int i10, int i11) {
        if (i10 > 0) {
            int i12 = (i10 / 2) * i11;
            this.f١٢٥٣٧b = i12;
            this.f١٢٥٣٨c = i12 + i11;
        } else {
            this.f١٢٥٣٧b = 0;
            this.f١٢٥٣٨c = 0;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f١٢٥٣٧b > 0 && this.f١٢٥٣٨c > 0) {
            this.f١٢٥٣٦a.setColor(this.f١٢٥٣٩d);
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, this.f١٢٥٣٧b, getWidth(), this.f١٢٥٣٧b, this.f١٢٥٣٦a);
            canvas.drawLine(DownloadProgress.UNKNOWN_PROGRESS, this.f١٢٥٣٨c, getWidth(), this.f١٢٥٣٨c, this.f١٢٥٣٦a);
        }
    }

    public void setLineColor(int i10) {
        this.f١٢٥٣٩d = i10;
        invalidate();
    }

    public WheelMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٥٣٦a = new Paint(1);
        this.f١٢٥٣٧b = 0;
        this.f١٢٥٣٨c = 0;
        this.f١٢٥٣٩d = -1895825153;
        a(context, attributeSet, 0);
    }

    public WheelMaskView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٥٣٦a = new Paint(1);
        this.f١٢٥٣٧b = 0;
        this.f١٢٥٣٨c = 0;
        this.f١٢٥٣٩d = -1895825153;
        a(context, attributeSet, i10);
    }
}
