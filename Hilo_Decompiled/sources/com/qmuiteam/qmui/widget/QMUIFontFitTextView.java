package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.qmuiteam.qmui.R;
import ic.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIFontFitTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    private Paint f١٢٩٧٢a;

    /* renamed from: b, reason: collision with root package name */
    private float f١٢٩٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private float f١٢٩٧٤c;

    public QMUIFontFitTextView(Context context) {
        this(context, null);
    }

    private void k(String str, int i10) {
        if (i10 <= 0) {
            return;
        }
        int paddingLeft = (i10 - getPaddingLeft()) - getPaddingRight();
        float f10 = this.f١٢٩٧٤c;
        float f11 = this.f١٢٩٧٣b;
        this.f١٢٩٧٢a.set(getPaint());
        this.f١٢٩٧٢a.setTextSize(this.f١٢٩٧٤c);
        float f12 = paddingLeft;
        if (this.f١٢٩٧٢a.measureText(str) <= f12) {
            f11 = this.f١٢٩٧٤c;
        } else {
            this.f١٢٩٧٢a.setTextSize(this.f١٢٩٧٣b);
            if (this.f١٢٩٧٢a.measureText(str) < f12) {
                while (f10 - f11 > 0.5f) {
                    float f13 = (f10 + f11) / 2.0f;
                    this.f١٢٩٧٢a.setTextSize(f13);
                    if (this.f١٢٩٧٢a.measureText(str) >= f12) {
                        f10 = f13;
                    } else {
                        f11 = f13;
                    }
                }
            }
        }
        setTextSize(0, f11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        int measuredHeight = getMeasuredHeight();
        k(getText().toString(), size);
        setMeasuredDimension(size, measuredHeight);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        if (i10 != i12) {
            k(getText().toString(), i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        k(charSequence.toString(), getWidth());
    }

    public QMUIFontFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f١٢٩٧٢a = paint;
        paint.set(getPaint());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIFontFitTextView);
        int i10 = R.styleable.QMUIFontFitTextView_qmui_minTextSize;
        float f10 = e.f١٤٨٧٤a;
        this.f١٢٩٧٣b = obtainStyledAttributes.getDimensionPixelSize(i10, Math.round(14.0f * f10));
        this.f١٢٩٧٤c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIFontFitTextView_qmui_maxTextSize, Math.round(f10 * 18.0f));
        obtainStyledAttributes.recycle();
    }
}
