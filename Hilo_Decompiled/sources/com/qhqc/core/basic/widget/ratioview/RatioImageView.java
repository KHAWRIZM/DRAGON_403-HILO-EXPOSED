package com.qhqc.core.basic.widget.ratioview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.qhqc.core.basic.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RatioImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public float f١٢٢٥٩a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٢٢٦٠b;

    public RatioImageView(Context context) {
        super(context);
        this.f١٢٢٥٩a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٢٦٠b = 0;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatioImageView);
            this.f١٢٢٥٩a = obtainStyledAttributes.getFloat(R.styleable.RatioImageView_ratio, DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٢٢٦٠b = obtainStyledAttributes.getInt(R.styleable.RatioImageView_ration_mode, 0);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = 0;
        if (this.f١٢٢٦٠b == 0) {
            if (this.f١٢٢٥٩a != DownloadProgress.UNKNOWN_PROGRESS && (i12 = (int) ((View.MeasureSpec.getSize(i10) * this.f١٢٢٥٩a) + 0.5f)) < getMinimumHeight()) {
                i12 = getMinimumHeight();
            }
            if (i12 != 0) {
                i11 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            }
            super.onMeasure(i10, i11);
            return;
        }
        if (this.f١٢٢٥٩a != DownloadProgress.UNKNOWN_PROGRESS && (i12 = (int) ((View.MeasureSpec.getSize(i11) / this.f١٢٢٥٩a) + 0.5f)) < getMinimumWidth()) {
            i12 = getMinimumWidth();
        }
        if (i12 != 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    public void setRatio(float f10) {
        this.f١٢٢٥٩a = f10;
        requestLayout();
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٢٥٩a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٢٦٠b = 0;
        init(context, attributeSet);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٢٥٩a = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٢٢٦٠b = 0;
        init(context, attributeSet);
    }
}
