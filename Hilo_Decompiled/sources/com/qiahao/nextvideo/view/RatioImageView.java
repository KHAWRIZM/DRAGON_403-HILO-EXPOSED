package com.qiahao.nextvideo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RatioImageView extends AppCompatImageView {
    public float a;

    public RatioImageView(Context context) {
        super(context);
        this.a = 0.0f;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatioImageView);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        super/*android.widget.ImageView*/.onDraw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onMeasure(int i, int i2) {
        int i3;
        if (this.a != 0.0f) {
            i3 = (int) ((View.MeasureSpec.getSize(i) * this.a) + 0.5f);
            if (i3 < getMinimumHeight()) {
                i3 = getMinimumHeight();
            }
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super/*android.widget.ImageView*/.onMeasure(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRatio(float f) {
        this.a = f;
        requestLayout();
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        init(context, attributeSet);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        init(context, attributeSet);
    }
}
