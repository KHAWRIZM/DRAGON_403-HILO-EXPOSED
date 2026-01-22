package com.oudi.widget.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.oudi.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import l2.q;

@RequiresApi(api = 3)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class GradientTextView extends PerfectTextView {
    private float angle;
    private int curStrokeTextColor;
    private Float defaultStrokeMiter;
    private boolean gradientColor;
    private final List<ColorStateList> gradientColorStates;
    private int[] gradientColors;
    private float[] gradientPositions;
    private boolean gradientStrokeColor;
    private final List<ColorStateList> gradientStrokeColorStates;
    private int[] gradientStrokeColors;
    private float[] gradientStrokePositions;
    private boolean isRtl;
    private boolean rtlAngle;
    private float strokeAngle;
    private Paint.Join strokeJoin;
    private boolean strokeRtlAngle;
    private ColorStateList strokeTextColor;
    private int strokeWidth;

    @RequiresApi(api = 17)
    public GradientTextView(Context context) {
        this(context, null);
    }

    public static CharSequence createIndentedText(CharSequence charSequence, int i10, int i11) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new LeadingMarginSpan.Standard(i10, i11), 0, charSequence.length(), 0);
        return spannableString;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean updateColors() {
        boolean z10;
        int[] drawableState = getDrawableState();
        int i10 = 0;
        int colorForState = this.strokeTextColor.getColorForState(drawableState, 0);
        boolean z11 = true;
        if (colorForState != this.curStrokeTextColor) {
            this.curStrokeTextColor = colorForState;
            z10 = true;
        } else {
            z10 = false;
        }
        List<ColorStateList> list = this.gradientStrokeColorStates;
        if (list != null && list.size() > 0) {
            int size = this.gradientStrokeColorStates.size();
            int[] iArr = new int[size];
            for (int i11 = 0; i11 < this.gradientStrokeColorStates.size(); i11++) {
                iArr[i11] = this.gradientStrokeColorStates.get(i11).getColorForState(drawableState, 0);
            }
            int[] iArr2 = this.gradientStrokeColors;
            if (iArr2 == null) {
                this.gradientStrokeColors = iArr;
            } else if (iArr2.length != size) {
                this.gradientStrokeColors = iArr;
            } else {
                int i12 = 0;
                while (true) {
                    int[] iArr3 = this.gradientStrokeColors;
                    if (i12 >= iArr3.length) {
                        break;
                    }
                    if (iArr3[i12] != iArr[i12]) {
                        this.gradientStrokeColors = iArr;
                        break;
                    }
                    i12++;
                }
            }
            z10 = true;
        }
        List<ColorStateList> list2 = this.gradientColorStates;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.gradientColorStates.size();
            int[] iArr4 = new int[size2];
            for (int i13 = 0; i13 < this.gradientColorStates.size(); i13++) {
                iArr4[i13] = this.gradientColorStates.get(i13).getColorForState(drawableState, 0);
            }
            int[] iArr5 = this.gradientColors;
            if (iArr5 == null) {
                this.gradientColors = iArr4;
            } else if (iArr5.length == size2) {
                while (true) {
                    int[] iArr6 = this.gradientColors;
                    if (i10 >= iArr6.length) {
                        break;
                    }
                    if (iArr6[i10] != iArr4[i10]) {
                        this.gradientColors = iArr4;
                        break;
                    }
                    i10++;
                }
            } else {
                this.gradientColors = iArr4;
            }
            if (z11) {
                invalidate();
            }
            return z11;
        }
        z11 = z10;
        if (z11) {
        }
        return z11;
    }

    @Override // com.oudi.widget.text.PerfectTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        updateColors();
    }

    public float getAngle() {
        return this.angle;
    }

    public float[] getAngleXY(float f10) {
        int i10;
        int i11;
        float tan;
        int i12;
        int i13;
        Layout layout = getLayout();
        int height = layout.getHeight();
        int width = layout.getWidth();
        float f11 = f10 % 360.0f;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        if (f11 < DownloadProgress.UNKNOWN_PROGRESS) {
            f11 += 360.0f;
        }
        if ((f11 >= DownloadProgress.UNKNOWN_PROGRESS && f11 < 90.0f) || (f11 >= 180.0f && f11 < 270.0f)) {
            double d10 = width / 2;
            float f13 = 90.0f - f11;
            float f14 = height;
            double signum = (Math.signum(f13) * f14) / 2.0f;
            if (f11 >= 180.0f) {
                i12 = 180;
            } else {
                i12 = 0;
            }
            tan = (float) ((Math.tan(Math.toRadians(f11 - i12)) * signum) + d10);
            float f15 = width;
            if (tan < f15 && tan > DownloadProgress.UNKNOWN_PROGRESS) {
                if (f11 >= 90.0f) {
                    f12 = f14;
                }
            } else {
                if (f11 < 90.0f) {
                    f12 = f15;
                }
                double d11 = height / 2;
                double signum2 = (Math.signum(f13) * f15) / 2.0f;
                if (f11 >= 180.0f) {
                    i13 = SubsamplingScaleImageView.ORIENTATION_270;
                } else {
                    i13 = 90;
                }
                float f16 = f12;
                f12 = (float) (d11 - (Math.tan(Math.toRadians(i13 - f11)) * signum2));
                tan = f16;
            }
        } else {
            float f17 = height;
            double d12 = f17 / 2.0f;
            float f18 = 180.0f - f11;
            float f19 = width;
            double signum3 = (Math.signum(f18) * f19) / 2.0f;
            if (f11 < 180.0f) {
                i10 = 90;
            } else {
                i10 = SubsamplingScaleImageView.ORIENTATION_270;
            }
            float tan2 = (float) ((Math.tan(Math.toRadians(f11 - i10)) * signum3) + d12);
            if (tan2 < f17 && tan2 > DownloadProgress.UNKNOWN_PROGRESS) {
                if (f11 < 180.0f) {
                    f12 = f19;
                }
                tan = f12;
                f12 = tan2;
            } else {
                if (f11 < 180.0f) {
                    f12 = f17;
                }
                double d13 = width / 2;
                double signum4 = (Math.signum(f18) * f17) / 2.0f;
                if (f11 < 180.0f) {
                    i11 = 180;
                } else {
                    i11 = 360;
                }
                tan = (float) ((Math.tan(Math.toRadians(i11 - f11)) * signum4) + d13);
            }
        }
        return new float[]{tan, f12, width - tan, height - f12};
    }

    public List<ColorStateList> getGradientColorStates() {
        return this.gradientColorStates;
    }

    public int[] getGradientColors() {
        return this.gradientColors;
    }

    public float[] getGradientPositions() {
        return this.gradientPositions;
    }

    public List<ColorStateList> getGradientStrokeColorStates() {
        return this.gradientStrokeColorStates;
    }

    public int[] getGradientStrokeColors() {
        return this.gradientStrokeColors;
    }

    public float[] getGradientStrokePositions() {
        return this.gradientStrokePositions;
    }

    public float getStrokeAngle() {
        return this.strokeAngle;
    }

    public int getStrokeTextColor() {
        return this.curStrokeTextColor;
    }

    public ColorStateList getStrokeTextColors() {
        return this.strokeTextColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public boolean isRtlAngle() {
        return this.rtlAngle;
    }

    public boolean isStrokeRtlAngle() {
        return this.strokeRtlAngle;
    }

    @Override // com.oudi.widget.text.PerfectTextView, android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        LinearGradient linearGradient;
        LinearGradient linearGradient2;
        int[] iArr;
        int[] iArr2;
        TextPaint paint = getPaint();
        Paint.Style style = paint.getStyle();
        paint.setStrokeWidth(this.strokeWidth);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(this.strokeJoin);
        if (this.defaultStrokeMiter == null) {
            this.defaultStrokeMiter = Float.valueOf(paint.getStrokeMiter());
        }
        if (this.strokeJoin == Paint.Join.MITER) {
            paint.setStrokeMiter(2.6f);
        } else {
            paint.setStrokeMiter(this.defaultStrokeMiter.floatValue());
        }
        if (this.gradientStrokeColor && (iArr2 = this.gradientStrokeColors) != null && iArr2.length > 1) {
            float f10 = this.strokeAngle;
            if (this.strokeRtlAngle && this.isRtl) {
                f10 = -f10;
            }
            float[] angleXY = getAngleXY(f10);
            linearGradient = new LinearGradient(angleXY[0], angleXY[1], angleXY[2], angleXY[3], this.gradientStrokeColors, this.gradientStrokePositions, Shader.TileMode.CLAMP);
        } else {
            float width = getWidth();
            float height = getHeight();
            int i10 = this.curStrokeTextColor;
            linearGradient = new LinearGradient(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height, new int[]{i10, i10}, (float[]) null, Shader.TileMode.CLAMP);
        }
        paint.setShader(linearGradient);
        super.onDraw(canvas);
        paint.setStrokeWidth(DownloadProgress.UNKNOWN_PROGRESS);
        paint.setStyle(style);
        if (this.gradientColor && (iArr = this.gradientColors) != null && iArr.length > 1) {
            float f11 = this.angle;
            if (this.rtlAngle && this.isRtl) {
                f11 = -f11;
            }
            float[] angleXY2 = getAngleXY(f11);
            linearGradient2 = new LinearGradient(angleXY2[0], angleXY2[1], angleXY2[2], angleXY2[3], this.gradientColors, this.gradientPositions, Shader.TileMode.CLAMP);
        } else {
            linearGradient2 = null;
        }
        paint.setShader(linearGradient2);
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredWidth;
        int size;
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && this.strokeWidth > 0 && (measuredWidth = getMeasuredWidth()) < (size = View.MeasureSpec.getSize(i10))) {
            setMeasuredDimension(Math.min(this.strokeWidth / 2, size - measuredWidth) + measuredWidth, getMeasuredHeight());
        }
    }

    public void setAngle(float f10) {
        this.angle = f10;
        invalidate();
    }

    public void setGradientColors(int[] iArr) {
        ColorStateList[] colorStateListArr;
        if (iArr != null) {
            colorStateListArr = new ColorStateList[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                colorStateListArr[i10] = ColorStateList.valueOf(iArr[i10]);
            }
        } else {
            colorStateListArr = null;
        }
        setGradientColors(colorStateListArr);
    }

    public void setGradientPositions(float[] fArr) {
        this.gradientPositions = fArr;
        invalidate();
    }

    public void setGradientStrokeColors(int[] iArr) {
        ColorStateList[] colorStateListArr;
        if (iArr != null) {
            colorStateListArr = new ColorStateList[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                colorStateListArr[i10] = ColorStateList.valueOf(iArr[i10]);
            }
        } else {
            colorStateListArr = null;
        }
        setGradientStrokeColors(colorStateListArr);
    }

    public void setGradientStrokePositions(float[] fArr) {
        this.gradientStrokePositions = fArr;
        invalidate();
    }

    public void setRtlAngle(boolean z10) {
        this.rtlAngle = z10;
        invalidate();
    }

    public void setStrokeAngle(float f10) {
        this.strokeAngle = f10;
        invalidate();
    }

    public void setStrokeJoin(Paint.Join join) {
        this.strokeJoin = join;
        invalidate();
    }

    public void setStrokeRtlAngle(boolean z10) {
        this.strokeRtlAngle = z10;
        invalidate();
    }

    public void setStrokeTextColor(int i10) {
        setStrokeTextColors(ColorStateList.valueOf(i10));
    }

    public void setStrokeTextColors(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return;
        }
        this.strokeTextColor = colorStateList;
        this.gradientStrokeColor = false;
        updateColors();
    }

    public void setStrokeWidth(int i10) {
        this.strokeWidth = i10;
        invalidate();
    }

    @Override // com.oudi.widget.text.PerfectTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        int i10 = this.strokeWidth;
        if (i10 > 0) {
            int i11 = i10 / 2;
            charSequence = createIndentedText(charSequence, i11, i11);
        }
        super.setText(charSequence, bufferType);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        this.gradientColor = false;
        super.setTextColor(i10);
    }

    @RequiresApi(api = 17)
    public GradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @RequiresApi(api = 17)
    public GradientTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        ArrayList arrayList = new ArrayList();
        this.gradientStrokeColorStates = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.gradientColorStates = arrayList2;
        this.isRtl = q.a(Locale.getDefault()) == 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GradientTextView);
        this.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GradientTextView_gradient_stroke_strokeWidth, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.GradientTextView_gradient_stroke_startColor);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.GradientTextView_gradient_stroke_centerColor);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.GradientTextView_gradient_stroke_endColor);
        this.strokeTextColor = obtainStyledAttributes.getColorStateList(R.styleable.GradientTextView_gradient_stroke_textColor);
        this.strokeAngle = obtainStyledAttributes.getFloat(R.styleable.GradientTextView_gradient_stroke_angle, DownloadProgress.UNKNOWN_PROGRESS);
        this.strokeRtlAngle = obtainStyledAttributes.getBoolean(R.styleable.GradientTextView_gradient_stroke_rtl_angle, false);
        ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(R.styleable.GradientTextView_gradient_startColor);
        ColorStateList colorStateList5 = obtainStyledAttributes.getColorStateList(R.styleable.GradientTextView_gradient_centerColor);
        ColorStateList colorStateList6 = obtainStyledAttributes.getColorStateList(R.styleable.GradientTextView_gradient_endColor);
        this.angle = obtainStyledAttributes.getFloat(R.styleable.GradientTextView_gradient_angle2, DownloadProgress.UNKNOWN_PROGRESS);
        this.rtlAngle = obtainStyledAttributes.getBoolean(R.styleable.GradientTextView_gradient_rtl_angle, false);
        int i11 = R.styleable.GradientTextView_gradient_stroke_join;
        Paint.Join join = Paint.Join.ROUND;
        int i12 = obtainStyledAttributes.getInt(i11, join.ordinal());
        obtainStyledAttributes.recycle();
        if (this.strokeTextColor == null) {
            this.strokeTextColor = getTextColors();
        }
        if (colorStateList != null) {
            arrayList.add(colorStateList);
        }
        if (colorStateList2 != null) {
            arrayList.add(colorStateList2);
        }
        if (colorStateList3 != null) {
            arrayList.add(colorStateList3);
        }
        if (arrayList.size() == 1) {
            arrayList.add(ColorStateList.valueOf(0));
        }
        if (colorStateList4 != null) {
            arrayList2.add(colorStateList4);
        }
        if (colorStateList5 != null) {
            arrayList2.add(colorStateList5);
        }
        if (colorStateList6 != null) {
            arrayList2.add(colorStateList6);
        }
        if (arrayList2.size() == 1) {
            arrayList2.add(ColorStateList.valueOf(0));
        }
        this.gradientStrokeColor = arrayList.size() > 0;
        this.gradientColor = arrayList2.size() > 0;
        updateColors();
        if (i12 >= 0 && i12 <= 2) {
            this.strokeJoin = Paint.Join.values()[i12];
        } else {
            this.strokeJoin = join;
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        this.gradientColor = false;
        super.setTextColor(colorStateList);
    }

    public void setGradientColors(ColorStateList[] colorStateListArr) {
        this.gradientColorStates.clear();
        if (colorStateListArr != null) {
            this.gradientColorStates.addAll(Arrays.asList(colorStateListArr));
            if (this.gradientColorStates.size() == 1) {
                this.gradientColorStates.add(ColorStateList.valueOf(0));
            }
            this.gradientColor = this.gradientColorStates.size() > 0;
            if (this.gradientPositions != null && this.gradientColorStates.size() != this.gradientPositions.length) {
                this.gradientPositions = null;
            }
            updateColors();
            return;
        }
        this.gradientColor = false;
        if (updateColors()) {
            return;
        }
        invalidate();
    }

    public void setGradientStrokeColors(ColorStateList[] colorStateListArr) {
        this.gradientStrokeColorStates.clear();
        if (colorStateListArr != null) {
            this.gradientStrokeColorStates.addAll(Arrays.asList(colorStateListArr));
            if (this.gradientStrokeColorStates.size() == 1) {
                this.gradientStrokeColorStates.add(ColorStateList.valueOf(0));
            }
            this.gradientStrokeColor = this.gradientStrokeColorStates.size() > 0;
            if (this.gradientStrokePositions != null && this.gradientStrokeColorStates.size() != this.gradientStrokePositions.length) {
                this.gradientStrokePositions = null;
            }
            updateColors();
            return;
        }
        this.gradientStrokeColor = false;
        if (updateColors()) {
            return;
        }
        invalidate();
    }
}
