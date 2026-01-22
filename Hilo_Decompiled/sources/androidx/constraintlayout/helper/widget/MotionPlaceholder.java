package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.VirtualLayout;
import c2.f;
import c2.i;
import c2.l;
import c2.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MotionPlaceholder extends VirtualLayout {

    /* renamed from: l, reason: collision with root package name */
    l f١٨٣٤l;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f٢٢٩١d = new l();
        v();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int i10, int i11) {
        w(this.f١٨٣٤l, i10, i11);
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

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void u(f fVar, i iVar, SparseArray sparseArray) {
    }
}
