package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.Character;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIVerticalTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٣١٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٣١٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private float[] f١٣١٠٨c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f١٣١٠٩d;

    public QMUIVerticalTextView(Context context) {
        super(context);
        this.f١٣١٠٦a = true;
        k();
    }

    private void k() {
    }

    private static boolean l(int i10) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(i10);
        if (of != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS && of != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS && of != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A && of != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS && of != Character.UnicodeBlock.HANGUL_SYLLABLES && of != Character.UnicodeBlock.HANGUL_JAMO && of != Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO && of != Character.UnicodeBlock.HIRAGANA && of != Character.UnicodeBlock.KATAKANA && of != Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) {
            return false;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        Paint.FontMetricsInt fontMetricsInt;
        if (!this.f١٣١٠٦a) {
            super.onDraw(canvas);
            return;
        }
        if (this.f١٣١٠٧b == 0) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        char[] charArray = getText().toString().toCharArray();
        canvas.save();
        float width = (getWidth() - getPaddingRight()) - this.f١٣١٠٨c[0];
        float f11 = width;
        float paddingTop = getPaddingTop();
        int i10 = 0;
        int i11 = 0;
        while (i10 < charArray.length) {
            int codePointAt = Character.codePointAt(charArray, i10);
            int charCount = Character.charCount(codePointAt);
            boolean l10 = l(codePointAt);
            int save = canvas.save();
            if (!l10) {
                canvas.rotate(90.0f, width, paddingTop);
            }
            if (!l10) {
                f10 = (paddingTop - ((this.f١٣١٠٨c[i11] - (fontMetricsInt2.bottom - fontMetricsInt2.top)) / 2.0f)) - fontMetricsInt2.descent;
            } else {
                f10 = paddingTop - fontMetricsInt2.ascent;
            }
            float f12 = width;
            Paint.FontMetricsInt fontMetricsInt3 = fontMetricsInt2;
            canvas.drawText(charArray, i10, charCount, width, f10, paint);
            canvas.restoreToCount(save);
            int i12 = i10 + charCount;
            if (i12 < charArray.length) {
                if (i10 + 1 > this.f١٣١٠٩d[i11]) {
                    int i13 = i11 + 1;
                    float[] fArr = this.f١٣١٠٨c;
                    if (i13 < fArr.length) {
                        f11 -= (fArr[i13] * getLineSpacingMultiplier()) + getLineSpacingExtra();
                        i11 = i13;
                        paddingTop = getPaddingTop();
                        width = f11;
                        fontMetricsInt = fontMetricsInt3;
                        fontMetricsInt2 = fontMetricsInt;
                        i10 = i12;
                    }
                }
                if (!l10) {
                    paddingTop += paint.measureText(charArray, i10, charCount);
                } else {
                    fontMetricsInt = fontMetricsInt3;
                    paddingTop += fontMetricsInt.descent - fontMetricsInt.ascent;
                    width = f12;
                    fontMetricsInt2 = fontMetricsInt;
                    i10 = i12;
                }
            }
            fontMetricsInt = fontMetricsInt3;
            width = f12;
            fontMetricsInt2 = fontMetricsInt;
            i10 = i12;
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        float f10;
        float f11;
        super.onMeasure(i10, i11);
        if (this.f١٣١٠٦a) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i10);
            int size2 = View.MeasureSpec.getSize(i11);
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float paddingTop = getPaddingTop() + getPaddingBottom();
            char[] charArray = getText().toString().toCharArray();
            TextPaint paint = getPaint();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (mode2 == 0) {
                i12 = Integer.MAX_VALUE;
            } else {
                i12 = size2;
            }
            int paddingBottom = i12 - getPaddingBottom();
            float paddingTop2 = getPaddingTop();
            this.f١٣١٠٧b = 0;
            this.f١٣١٠٨c = new float[charArray.length + 1];
            this.f١٣١٠٩d = new int[charArray.length + 1];
            float f12 = paddingTop2;
            int i14 = 0;
            int i15 = 0;
            int i16 = 1;
            while (i14 < charArray.length) {
                int codePointAt = Character.codePointAt(charArray, i14);
                int charCount = Character.charCount(codePointAt);
                if (!l(codePointAt)) {
                    i13 = size;
                    f11 = fontMetricsInt.descent - fontMetricsInt.ascent;
                    f10 = paint.measureText(charArray, i14, charCount);
                } else {
                    i13 = size;
                    float measureText = paint.measureText(charArray, i14, charCount);
                    f10 = fontMetricsInt.descent - fontMetricsInt.ascent;
                    f11 = measureText;
                }
                float f13 = paddingTop2 + f10;
                TextPaint textPaint = paint;
                if (f13 > paddingBottom && i14 > 0) {
                    if (f12 >= paddingTop2) {
                        paddingTop2 = f12;
                    }
                    this.f١٣١٠٩d[i15] = i14 - charCount;
                    paddingLeft += this.f١٣١٠٨c[i15];
                    i15++;
                    f12 = paddingTop2;
                    paddingTop2 = getPaddingTop() + f10;
                } else {
                    paddingTop2 = f13;
                    if (f12 < f13) {
                        f12 = paddingTop2;
                    }
                }
                float[] fArr = this.f١٣١٠٨c;
                if (fArr[i15] < f11) {
                    fArr[i15] = f11;
                }
                i14 += charCount;
                if (i14 >= charArray.length) {
                    paddingLeft += fArr[i15];
                    paddingTop = getPaddingBottom() + f12;
                }
                i16 = charCount;
                size = i13;
                paint = textPaint;
            }
            int i17 = size;
            if (charArray.length > 0) {
                this.f١٣١٠٧b = i15 + 1;
                this.f١٣١٠٩d[i15] = charArray.length - i16;
            }
            int i18 = this.f١٣١٠٧b;
            if (i18 > 1) {
                int i19 = i18 - 1;
                for (int i20 = 0; i20 < i19; i20++) {
                    paddingLeft += (this.f١٣١٠٨c[i20] * (getLineSpacingMultiplier() - 1.0f)) + getLineSpacingExtra();
                }
            }
            if (mode2 == 1073741824) {
                paddingTop = size2;
            } else if (mode2 == Integer.MIN_VALUE) {
                paddingTop = Math.min(paddingTop, size2);
            }
            if (mode == 1073741824) {
                paddingLeft = i17;
            } else if (mode == Integer.MIN_VALUE) {
                paddingLeft = Math.min(paddingLeft, i17);
            }
            setMeasuredDimension((int) paddingLeft, (int) paddingTop);
        }
    }

    public void setVerticalMode(boolean z10) {
        this.f١٣١٠٦a = z10;
        requestLayout();
    }

    public QMUIVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣١٠٦a = true;
        k();
    }

    public QMUIVerticalTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣١٠٦a = true;
        k();
    }
}
