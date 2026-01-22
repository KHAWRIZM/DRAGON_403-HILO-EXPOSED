package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import c2.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: j, reason: collision with root package name */
    private int f٢٢٨٥j;

    /* renamed from: k, reason: collision with root package name */
    private int f٢٢٨٦k;

    /* renamed from: l, reason: collision with root package name */
    private c2.a f٢٢٨٧l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void w(c2.e eVar, int i10, boolean z10) {
        this.f٢٢٨٦k = i10;
        if (z10) {
            int i11 = this.f٢٢٨٥j;
            if (i11 == 5) {
                this.f٢٢٨٦k = 1;
            } else if (i11 == 6) {
                this.f٢٢٨٦k = 0;
            }
        } else {
            int i12 = this.f٢٢٨٥j;
            if (i12 == 5) {
                this.f٢٢٨٦k = 0;
            } else if (i12 == 6) {
                this.f٢٢٨٦k = 1;
            }
        }
        if (eVar instanceof c2.a) {
            ((c2.a) eVar).E1(this.f٢٢٨٦k);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f٢٢٨٧l.y1();
    }

    public int getMargin() {
        return this.f٢٢٨٧l.A1();
    }

    public int getType() {
        return this.f٢٢٨٥j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f٢٢٨٧l = new c2.a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f٢٢٨٧l.D1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f٢٢٨٧l.F1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f٢٢٩١d = this.f٢٢٨٧l;
        v();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void o(c.a aVar, j jVar, ConstraintLayout.b bVar, SparseArray sparseArray) {
        super.o(aVar, jVar, bVar, sparseArray);
        if (jVar instanceof c2.a) {
            c2.a aVar2 = (c2.a) jVar;
            w(aVar2, aVar.f٢٤١٩e.f٢٤٥٢h0, ((c2.f) jVar.M()).U1());
            aVar2.D1(aVar.f٢٤١٩e.f٢٤٦٨p0);
            aVar2.F1(aVar.f٢٤١٩e.f٢٤٥٤i0);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(c2.e eVar, boolean z10) {
        w(eVar, this.f٢٢٨٥j, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f٢٢٨٧l.D1(z10);
    }

    public void setDpMargin(int i10) {
        this.f٢٢٨٧l.F1((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f٢٢٨٧l.F1(i10);
    }

    public void setType(int i10) {
        this.f٢٢٨٥j = i10;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        super.setVisibility(8);
    }
}
