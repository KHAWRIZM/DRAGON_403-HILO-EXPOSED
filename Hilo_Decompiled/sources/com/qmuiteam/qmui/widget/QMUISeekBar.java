package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import ic.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUISeekBar extends QMUISlider {

    /* renamed from: y, reason: collision with root package name */
    private static SimpleArrayMap f١٣٠٥٠y;

    /* renamed from: w, reason: collision with root package name */
    private int f١٣٠٥١w;

    /* renamed from: x, reason: collision with root package name */
    private int f١٣٠٥٢x;

    static {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(2);
        f١٣٠٥٠y = simpleArrayMap;
        int i10 = R.attr.qmui_skin_support_seek_bar_color;
        simpleArrayMap.put("background", Integer.valueOf(i10));
        f١٣٠٥٠y.put("progressColor", Integer.valueOf(i10));
    }

    public QMUISeekBar(Context context) {
        this(context, null);
    }

    @Override // com.qmuiteam.qmui.widget.QMUISlider, fc.a
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return f١٣٠٥٠y;
    }

    public int getTickHeight() {
        return this.f١٣٠٥١w;
    }

    @Override // com.qmuiteam.qmui.widget.QMUISlider
    protected void m(Canvas canvas, RectF rectF, int i10, Paint paint, boolean z10) {
        canvas.drawRect(rectF, paint);
    }

    @Override // com.qmuiteam.qmui.widget.QMUISlider
    protected void n(Canvas canvas, int i10, int i11, int i12, int i13, float f10, Paint paint, int i14, int i15) {
        int i16;
        int i17;
        int i18 = this.f١٣٠٥١w;
        if (i18 > 0 && (i16 = this.f١٣٠٥٢x) > 0 && i11 >= 1) {
            float f11 = ((i13 - i12) - i16) / i11;
            float f12 = f10 - (i18 / 2.0f);
            float f13 = f10 + (i18 / 2.0f);
            float f14 = i12 + (i16 / 2.0f);
            for (int i19 = 0; i19 <= i11; i19++) {
                int i20 = this.f١٣٠٥٢x;
                float f15 = f14 - (i20 / 2.0f);
                float f16 = f14 + (i20 / 2.0f);
                if (i19 <= i10) {
                    i17 = i15;
                } else {
                    i17 = i14;
                }
                paint.setColor(i17);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(f15, f12, f16, f13, paint);
                f14 += f11;
            }
        }
    }

    public void setTickHeight(int i10) {
        this.f١٣٠٥١w = i10;
        invalidate();
    }

    public void setTickWidth(int i10) {
        this.f١٣٠٥٢x = i10;
        invalidate();
    }

    public QMUISeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUISeekBarStyle);
    }

    public QMUISeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUISeekBar, i10, 0);
        this.f١٣٠٥٢x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISeekBar_qmui_seek_bar_tick_width, e.a(context, 1));
        this.f١٣٠٥١w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISeekBar_qmui_seek_bar_tick_height, e.a(context, 4));
        obtainStyledAttributes.recycle();
        setClickToChangeProgress(true);
    }
}
