package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ReactiveGuide extends View implements e.a {

    /* renamed from: a, reason: collision with root package name */
    private int f٢٣٦٥a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٢٣٦٦b;

    /* renamed from: c, reason: collision with root package name */
    private int f٢٣٦٧c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٢٣٦٨d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f٢٣٦٥a = -1;
        this.f٢٣٦٦b = false;
        this.f٢٣٦٧c = 0;
        this.f٢٣٦٨d = true;
        super.setVisibility(8);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f٢٣٦٥a = obtainStyledAttributes.getResourceId(index, this.f٢٣٦٥a);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f٢٣٦٦b = obtainStyledAttributes.getBoolean(index, this.f٢٣٦٦b);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.f٢٣٦٧c = obtainStyledAttributes.getResourceId(index, this.f٢٣٦٧c);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.f٢٣٦٨d = obtainStyledAttributes.getBoolean(index, this.f٢٣٦٨d);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f٢٣٦٥a != -1) {
            ConstraintLayout.getSharedValues().a(this.f٢٣٦٥a, this);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f٢٣٦٧c;
    }

    public int getAttributeId() {
        return this.f٢٣٦٥a;
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z10) {
        this.f٢٣٦٦b = z10;
    }

    public void setApplyToConstraintSetId(int i10) {
        this.f٢٣٦٧c = i10;
    }

    public void setAttributeId(int i10) {
        e sharedValues = ConstraintLayout.getSharedValues();
        int i11 = this.f٢٣٦٥a;
        if (i11 != -1) {
            sharedValues.b(i11, this);
        }
        this.f٢٣٦٥a = i10;
        if (i10 != -1) {
            sharedValues.a(i10, this);
        }
    }

    public void setGuidelineBegin(int i10) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f٢٢٩٩a = i10;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i10) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f٢٣٠١b = i10;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f10) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f٢٣٠٣c = f10;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٣٦٥a = -1;
        this.f٢٣٦٦b = false;
        this.f٢٣٦٧c = 0;
        this.f٢٣٦٨d = true;
        super.setVisibility(8);
        a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٣٦٥a = -1;
        this.f٢٣٦٦b = false;
        this.f٢٣٦٧c = 0;
        this.f٢٣٦٨d = true;
        super.setVisibility(8);
        a(attributeSet);
    }
}
