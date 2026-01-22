package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: l, reason: collision with root package name */
    private Paint f٢٢٧٨l;

    /* renamed from: m, reason: collision with root package name */
    MotionLayout f٢٢٧٩m;

    /* renamed from: n, reason: collision with root package name */
    float[] f٢٢٨٠n;

    /* renamed from: o, reason: collision with root package name */
    Matrix f٢٢٨١o;

    /* renamed from: p, reason: collision with root package name */
    int f٢٢٨٢p;

    /* renamed from: q, reason: collision with root package name */
    int f٢٢٨٣q;

    /* renamed from: r, reason: collision with root package name */
    float f٢٢٨٤r;

    public MotionTelltales(Context context) {
        super(context);
        this.f٢٢٧٨l = new Paint();
        this.f٢٢٨٠n = new float[2];
        this.f٢٢٨١o = new Matrix();
        this.f٢٢٨٢p = 0;
        this.f٢٢٨٣q = -65281;
        this.f٢٢٨٤r = 0.25f;
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f٢٢٨٣q = obtainStyledAttributes.getColor(index, this.f٢٢٨٣q);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.f٢٢٨٢p = obtainStyledAttributes.getInt(index, this.f٢٢٨٢p);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.f٢٢٨٤r = obtainStyledAttributes.getFloat(index, this.f٢٢٨٤r);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f٢٢٧٨l.setColor(this.f٢٢٨٣q);
        this.f٢٢٧٨l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f٢٢٨١o);
        if (this.f٢٢٧٩m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f٢٢٧٩m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i10 = 0; i10 < 5; i10++) {
            float f10 = fArr[i10];
            for (int i11 = 0; i11 < 5; i11++) {
                float f11 = fArr[i11];
                this.f٢٢٧٩m.a0(this, f11, f10, this.f٢٢٨٠n, this.f٢٢٨٢p);
                this.f٢٢٨١o.mapVectors(this.f٢٢٨٠n);
                float f12 = width * f11;
                float f13 = height * f10;
                float[] fArr2 = this.f٢٢٨٠n;
                float f14 = fArr2[0];
                float f15 = this.f٢٢٨٤r;
                float f16 = f13 - (fArr2[1] * f15);
                this.f٢٢٨١o.mapVectors(fArr2);
                canvas.drawLine(f12, f13, f12 - (f14 * f15), f16, this.f٢٢٧٨l);
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f٢٢٣٦f = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٢٧٨l = new Paint();
        this.f٢٢٨٠n = new float[2];
        this.f٢٢٨١o = new Matrix();
        this.f٢٢٨٢p = 0;
        this.f٢٢٨٣q = -65281;
        this.f٢٢٨٤r = 0.25f;
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٢٧٨l = new Paint();
        this.f٢٢٨٠n = new float[2];
        this.f٢٢٨١o = new Matrix();
        this.f٢٢٨٢p = 0;
        this.f٢٢٨٣q = -65281;
        this.f٢٢٨٤r = 0.25f;
        a(context, attributeSet);
    }
}
