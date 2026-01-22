package com.qiahao.nextvideo.room.view;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.d1;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class PinEntryEditText extends AppCompatEditText {
    protected int[] A;
    protected ColorStateList B;
    protected String a;
    protected StringBuilder b;
    protected String c;
    protected int d;
    protected float e;
    protected float f;
    protected float g;
    protected float h;
    protected int i;
    protected RectF[] j;
    protected float[] k;
    protected Paint l;
    protected Paint m;
    protected Paint n;
    protected Drawable o;
    protected Rect p;
    protected boolean q;
    protected View.OnClickListener r;
    protected float s;
    protected float t;
    protected Paint u;
    protected boolean v;
    protected boolean w;
    protected ColorStateList x;
    protected int[][] y;
    protected Context z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppCompatEditText appCompatEditText = PinEntryEditText.this;
            appCompatEditText.setSelection(appCompatEditText.getText().length());
            View.OnClickListener onClickListener = PinEntryEditText.this.r;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinEntryEditText.this.m.setTextSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
            PinEntryEditText.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinEntryEditText.this.k[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            PinEntryEditText.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PinEntryEditText.this.m.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface e {
    }

    public PinEntryEditText(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 14.0f;
        this.g = 4.0f;
        this.h = 8.0f;
        this.i = 4;
        this.p = new Rect();
        this.q = false;
        this.s = 1.0f;
        this.t = 2.0f;
        this.v = false;
        this.w = false;
        this.y = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.A = new int[]{-16711936, -65536, RoundedDrawable.DEFAULT_BORDER_COLOR, -7829368};
        this.B = new ColorStateList(this.y, this.A);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(CharSequence charSequence, int i) {
        float[] fArr = this.k;
        float f = this.j[i].bottom - this.h;
        fArr[i] = f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f + getPaint().getTextSize(), this.k[i]);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new c(i));
        this.m.setAlpha(255);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.setDuration(300L);
        ofInt.addUpdateListener(new d());
        AnimatorSet animatorSet = new AnimatorSet();
        charSequence.length();
        animatorSet.playTogether(ofFloat, ofInt);
        animatorSet.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, getPaint().getTextSize());
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new OvershootInterpolator());
        ofFloat.addUpdateListener(new b());
        getText().length();
        ofFloat.start();
    }

    private int c(int... iArr) {
        return this.B.getColorForState(iArr, -7829368);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(Context context, AttributeSet attributeSet) {
        int color;
        this.z = context;
        float f = context.getResources().getDisplayMetrics().density;
        this.s *= f;
        this.t *= f;
        this.e *= f;
        this.h = f * this.h;
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qiahao.nextvideo.R.styleable.PinEntryEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(0, typedValue);
            this.d = typedValue.data;
            this.a = obtainStyledAttributes.getString(3);
            this.c = obtainStyledAttributes.getString(8);
            this.s = obtainStyledAttributes.getDimension(6, this.s);
            this.t = obtainStyledAttributes.getDimension(7, this.t);
            this.e = obtainStyledAttributes.getDimension(4, this.e);
            this.h = obtainStyledAttributes.getDimension(9, this.h);
            this.q = obtainStyledAttributes.getBoolean(2, this.q);
            this.o = obtainStyledAttributes.getDrawable(1);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(5);
            if (colorStateList != null) {
                this.B = colorStateList;
            }
            obtainStyledAttributes.recycle();
            this.l = new Paint(getPaint());
            this.m = new Paint(getPaint());
            this.n = new Paint(getPaint());
            Paint paint = new Paint(getPaint());
            this.u = paint;
            paint.setStrokeWidth(this.s);
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(2130968991, typedValue2, true);
            this.A[0] = typedValue2.data;
            int i = -7829368;
            if (isInEditMode()) {
                color = -7829368;
            } else {
                color = androidx.core.content.a.getColor(context, 2131099918);
            }
            this.A[1] = color;
            if (!isInEditMode()) {
                i = androidx.core.content.a.getColor(context, 2131099918);
            }
            this.A[2] = i;
            setBackgroundResource(0);
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLength", 4);
            this.i = attributeIntValue;
            this.g = attributeIntValue;
            super/*android.widget.EditText*/.setOnClickListener(new a());
            if ((getInputType() & 128) == 128 && TextUtils.isEmpty(this.a)) {
                this.a = "●";
            } else if ((getInputType() & 16) == 16 && TextUtils.isEmpty(this.a)) {
                this.a = "●";
            }
            if (!TextUtils.isEmpty(this.a)) {
                this.b = getMaskChars();
            }
            getPaint().getTextBounds("|", 0, 1, this.p);
            if (this.d > -1) {
                z = true;
            }
            this.v = z;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private CharSequence getFullText() {
        if (TextUtils.isEmpty(this.a)) {
            return getText();
        }
        return getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.b == null) {
            this.b = new StringBuilder();
        }
        int length = getText().length();
        while (this.b.length() != length) {
            if (this.b.length() < length) {
                this.b.append(this.a);
            } else {
                this.b.deleteCharAt(r1.length() - 1);
            }
        }
        return this.b;
    }

    private void setCustomTypeface(Typeface typeface) {
        Paint paint = this.l;
        if (paint != null) {
            paint.setTypeface(typeface);
            this.m.setTypeface(typeface);
            this.n.setTypeface(typeface);
            this.u.setTypeface(typeface);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void e(boolean z) {
        if (this.w) {
            this.u.setColor(c(R.attr.state_active));
            return;
        }
        if (isFocused()) {
            this.u.setStrokeWidth(this.t);
            this.u.setColor(c(R.attr.state_focused));
            if (z) {
                this.u.setColor(c(R.attr.state_selected));
                return;
            }
            return;
        }
        this.u.setStrokeWidth(this.s);
        this.u.setColor(c(-16842908));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void f(boolean z, boolean z2) {
        if (this.w) {
            this.o.setState(new int[]{R.attr.state_active});
            return;
        }
        if (isFocused()) {
            this.o.setState(new int[]{R.attr.state_focused});
            if (z2) {
                this.o.setState(new int[]{R.attr.state_focused, R.attr.state_selected});
                return;
            } else {
                if (z) {
                    this.o.setState(new int[]{R.attr.state_focused, R.attr.state_checked});
                    return;
                }
                return;
            }
        }
        if (z) {
            this.o.setState(new int[]{-16842908, R.attr.state_checked});
        } else {
            this.o.setState(new int[]{-16842908});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        float f;
        boolean z;
        boolean z2;
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(fullText, 0, length, fArr);
        String str = this.c;
        float f2 = 0.0f;
        if (str != null) {
            int length2 = str.length();
            float[] fArr2 = new float[length2];
            getPaint().getTextWidths(this.c, fArr2);
            for (int i = 0; i < length2; i++) {
                f2 += fArr2[i];
            }
            f = f2;
        } else {
            f = 0.0f;
        }
        for (int i2 = 0; i2 < this.g; i2++) {
            boolean z3 = true;
            if (this.o != null) {
                if (i2 < length) {
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == length) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                f(z, z2);
                Drawable drawable = this.o;
                RectF rectF = this.j[i2];
                drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.o.draw(canvas);
            }
            float f3 = this.j[i2].left + (this.f / 2.0f);
            if (length > i2) {
                if (this.v && i2 == length - 1) {
                    canvas.drawText(fullText, i2, i2 + 1, f3 - (fArr[i2] / 2.0f), this.k[i2], this.m);
                } else {
                    canvas.drawText(fullText, i2, i2 + 1, f3 - (fArr[i2] / 2.0f), this.k[i2], this.l);
                }
            } else {
                String str2 = this.c;
                if (str2 != null) {
                    canvas.drawText(str2, f3 - (f / 2.0f), this.k[i2], this.n);
                }
            }
            if (this.o == null) {
                if (i2 > length) {
                    z3 = false;
                }
                e(z3);
                RectF rectF2 = this.j[i2];
                canvas.drawLine(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.u);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onMeasure(int i, int i2) {
        int paddingLeft;
        float f;
        float f2;
        float f3;
        int size;
        float f4;
        float f5;
        float f6;
        Log.e("PinEntryEditText", "onMeasure:----------- ");
        if (this.q) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 1073741824) {
                paddingLeft = View.MeasureSpec.getSize(i);
                f = paddingLeft;
                f2 = this.g;
                f3 = this.e;
            } else {
                if (mode2 == 1073741824) {
                    size = View.MeasureSpec.getSize(i2);
                    f4 = this.g;
                    f5 = size * f4;
                    f6 = this.e;
                } else if (mode == Integer.MIN_VALUE) {
                    paddingLeft = View.MeasureSpec.getSize(i);
                    f = paddingLeft;
                    f2 = this.g;
                    f3 = this.e;
                } else if (mode2 == Integer.MIN_VALUE) {
                    size = View.MeasureSpec.getSize(i2);
                    f4 = this.g;
                    f5 = size * f4;
                    f6 = this.e;
                } else {
                    paddingLeft = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
                    f = paddingLeft;
                    f2 = this.g;
                    f3 = this.e;
                }
                paddingLeft = (int) (f5 + ((f6 * f4) - 1.0f));
                setMeasuredDimension(View.resolveSizeAndState(paddingLeft, i, 1), View.resolveSizeAndState(size, i2, 0));
                return;
            }
            size = (int) ((f - (f2 - (f3 * 1.0f))) / f2);
            setMeasuredDimension(View.resolveSizeAndState(paddingLeft, i, 1), View.resolveSizeAndState(size, i2, 0));
            return;
        }
        super/*android.widget.EditText*/.onMeasure(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int I;
        float f;
        super/*android.widget.EditText*/.onSizeChanged(i, i2, i3, i4);
        Log.e("PinEntryEditText", "onSizeChanged:----------- ");
        ColorStateList textColors = getTextColors();
        this.x = textColors;
        if (textColors != null) {
            this.m.setColor(textColors.getDefaultColor());
            this.l.setColor(this.x.getDefaultColor());
            this.n.setColor(getCurrentHintTextColor());
        }
        int width = (getWidth() - d1.H(this)) - d1.I(this);
        float f2 = this.e;
        if (f2 < 0.0f) {
            this.f = width / ((this.g * 2.0f) - 1.0f);
        } else {
            float f3 = this.g;
            this.f = (width - (f2 * (f3 - 1.0f))) / f3;
        }
        float f4 = this.g;
        this.j = new RectF[(int) f4];
        this.k = new float[(int) f4];
        int height = getHeight() - getPaddingBottom();
        int i5 = 1;
        if (d1.D(this) == 1) {
            I = (int) ((getWidth() - d1.I(this)) - this.f);
            i5 = -1;
        } else {
            I = d1.I(this);
        }
        for (int i6 = 0; i6 < this.g; i6++) {
            float f5 = I;
            float f6 = height;
            this.j[i6] = new RectF(f5, f6, this.f + f5, f6);
            if (this.o != null) {
                if (this.q) {
                    this.j[i6].top = getPaddingTop();
                    RectF rectF = this.j[i6];
                    rectF.right = rectF.width() + f5;
                } else {
                    this.j[i6].top -= this.p.height() + (this.h * 2.0f);
                }
            }
            float f7 = this.e;
            if (f7 < 0.0f) {
                f = f5 + (i5 * this.f * 2.0f);
            } else {
                f = f5 + (i5 * (this.f + f7));
            }
            I = (int) f;
            float textSize = getPaint().getTextSize() / this.z.getResources().getDisplayMetrics().density;
            if (this.q) {
                float[] fArr = this.k;
                RectF rectF2 = this.j[i6];
                float f8 = rectF2.bottom;
                fArr[i6] = (f8 - ((f8 - rectF2.top) / 2.0f)) + textSize;
            } else {
                this.k[i6] = this.j[i6].bottom - this.h;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setError(false);
        if (this.j != null && this.v) {
            int i4 = this.d;
            if (i4 == -1) {
                invalidate();
            } else if (i3 > i2) {
                if (i4 == 0) {
                    b();
                } else {
                    a(charSequence, i);
                }
            }
        }
    }

    public void setAnimateText(boolean z) {
        this.v = z;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setError(boolean z) {
        this.w = z;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInputType(int i) {
        super/*android.widget.EditText*/.setInputType(i);
        if ((i & 128) != 128 && (i & 16) != 16) {
            setMask(null);
        } else if (TextUtils.isEmpty(this.a)) {
            setMask("●");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMask(String str) {
        this.a = str;
        this.b = null;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxLength(int i) {
        this.i = i;
        this.g = i;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        setText(null);
        invalidate();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setOnPinEnteredListener(e eVar) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPinBackground(Drawable drawable) {
        this.o = drawable;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPinLineColors(ColorStateList colorStateList) {
        this.B = colorStateList;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSingleCharHint(String str) {
        this.c = str;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTypeface(Typeface typeface) {
        super/*android.widget.EditText*/.setTypeface(typeface);
        setCustomTypeface(typeface);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTypeface(Typeface typeface, int i) {
        super/*android.widget.EditText*/.setTypeface(typeface, i);
        setCustomTypeface(typeface);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 14.0f;
        this.g = 4.0f;
        this.h = 8.0f;
        this.i = 4;
        this.p = new Rect();
        this.q = false;
        this.s = 1.0f;
        this.t = 2.0f;
        this.v = false;
        this.w = false;
        this.y = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.A = new int[]{-16711936, -65536, RoundedDrawable.DEFAULT_BORDER_COLOR, -7829368};
        this.B = new ColorStateList(this.y, this.A);
        d(context, attributeSet);
    }

    public PinEntryEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 14.0f;
        this.g = 4.0f;
        this.h = 8.0f;
        this.i = 4;
        this.p = new Rect();
        this.q = false;
        this.s = 1.0f;
        this.t = 2.0f;
        this.v = false;
        this.w = false;
        this.y = new int[][]{new int[]{R.attr.state_selected}, new int[]{R.attr.state_active}, new int[]{R.attr.state_focused}, new int[]{-16842908}};
        this.A = new int[]{-16711936, -65536, RoundedDrawable.DEFAULT_BORDER_COLOR, -7829368};
        this.B = new ColorStateList(this.y, this.A);
        d(context, attributeSet);
    }
}
