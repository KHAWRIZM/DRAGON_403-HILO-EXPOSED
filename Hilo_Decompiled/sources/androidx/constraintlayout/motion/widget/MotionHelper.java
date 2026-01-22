package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.k {

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٨٣٥j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٨٣٦k;

    /* renamed from: l, reason: collision with root package name */
    private float f١٨٣٧l;

    /* renamed from: m, reason: collision with root package name */
    protected View[] f١٨٣٨m;

    public MotionHelper(Context context) {
        super(context);
        this.f١٨٣٥j = false;
        this.f١٨٣٦k = false;
    }

    public void A(Canvas canvas) {
    }

    public void B(Canvas canvas) {
    }

    public void C(MotionLayout motionLayout, HashMap hashMap) {
    }

    public void D(View view, float f10) {
    }

    public void a(MotionLayout motionLayout, int i10, int i11, float f10) {
    }

    public void b(MotionLayout motionLayout, int i10) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.k
    public void c(MotionLayout motionLayout, int i10, int i11) {
    }

    public float getProgress() {
        return this.f١٨٣٧l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f١٨٣٥j = obtainStyledAttributes.getBoolean(index, this.f١٨٣٥j);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f١٨٣٦k = obtainStyledAttributes.getBoolean(index, this.f١٨٣٦k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f١٨٣٧l = f10;
        int i10 = 0;
        if (this.f٢٢٨٩b > 0) {
            this.f١٨٣٨m = m((ConstraintLayout) getParent());
            while (i10 < this.f٢٢٨٩b) {
                D(this.f١٨٣٨m[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof MotionHelper)) {
                D(childAt, f10);
            }
            i10++;
        }
    }

    public boolean w() {
        return false;
    }

    public boolean x() {
        return this.f١٨٣٦k;
    }

    public boolean y() {
        return this.f١٨٣٥j;
    }

    public void z(MotionLayout motionLayout) {
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٨٣٥j = false;
        this.f١٨٣٦k = false;
        n(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٨٣٥j = false;
        this.f١٨٣٦k = false;
        n(attributeSet);
    }
}
