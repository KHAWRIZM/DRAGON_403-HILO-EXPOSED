package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.c;
import c2.e;
import c2.g;
import c2.j;
import c2.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Flow extends VirtualLayout {

    /* renamed from: l, reason: collision with root package name */
    private g f١٨٠٨l;

    public Flow(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f١٨٠٨l = new g();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f١٨٠٨l.H2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.f١٨٠٨l.M1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f١٨٠٨l.R1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f١٨٠٨l.O1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f١٨٠٨l.P1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f١٨٠٨l.S1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f١٨٠٨l.Q1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f١٨٠٨l.N1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f١٨٠٨l.M2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f١٨٠٨l.B2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f١٨٠٨l.L2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f١٨٠٨l.v2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f١٨٠٨l.D2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f١٨٠٨l.x2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f١٨٠٨l.F2(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f١٨٠٨l.z2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f١٨٠٨l.u2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f١٨٠٨l.C2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f١٨٠٨l.w2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f١٨٠٨l.E2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f١٨٠٨l.J2(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f١٨٠٨l.y2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f١٨٠٨l.I2(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f١٨٠٨l.A2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f١٨٠٨l.K2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f١٨٠٨l.G2(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f٢٢٩١d = this.f١٨٠٨l;
        v();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void o(c.a aVar, j jVar, ConstraintLayout.b bVar, SparseArray sparseArray) {
        super.o(aVar, jVar, bVar, sparseArray);
        if (jVar instanceof g) {
            g gVar = (g) jVar;
            int i10 = bVar.Z;
            if (i10 != -1) {
                gVar.H2(i10);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int i10, int i11) {
        w(this.f١٨٠٨l, i10, i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(e eVar, boolean z10) {
        this.f١٨٠٨l.x1(z10);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f١٨٠٨l.u2(f10);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f١٨٠٨l.v2(i10);
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f١٨٠٨l.w2(f10);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f١٨٠٨l.x2(i10);
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f١٨٠٨l.y2(i10);
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f١٨٠٨l.z2(f10);
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f١٨٠٨l.A2(i10);
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f١٨٠٨l.B2(i10);
        requestLayout();
    }

    public void setLastHorizontalBias(float f10) {
        this.f١٨٠٨l.C2(f10);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f١٨٠٨l.D2(i10);
        requestLayout();
    }

    public void setLastVerticalBias(float f10) {
        this.f١٨٠٨l.E2(f10);
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f١٨٠٨l.F2(i10);
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f١٨٠٨l.G2(i10);
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f١٨٠٨l.H2(i10);
        requestLayout();
    }

    public void setPadding(int i10) {
        this.f١٨٠٨l.M1(i10);
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f١٨٠٨l.N1(i10);
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f١٨٠٨l.P1(i10);
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f١٨٠٨l.Q1(i10);
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f١٨٠٨l.S1(i10);
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f١٨٠٨l.I2(i10);
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f١٨٠٨l.J2(f10);
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f١٨٠٨l.K2(i10);
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f١٨٠٨l.L2(i10);
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f١٨٠٨l.M2(i10);
        requestLayout();
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void w(m mVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mVar != null) {
            mVar.G1(mode, size, mode2, size2);
            setMeasuredDimension(mVar.B1(), mVar.A1());
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
