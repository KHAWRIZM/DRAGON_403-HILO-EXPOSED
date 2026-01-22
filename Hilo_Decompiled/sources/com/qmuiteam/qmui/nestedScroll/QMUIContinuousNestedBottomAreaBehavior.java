package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.t;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedBottomAreaBehavior extends QMUIViewOffsetBehavior<View> {

    /* renamed from: d, reason: collision with root package name */
    private final Rect f١٢٧٤٩d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f١٢٧٥٠e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٧٥١f;

    public QMUIContinuousNestedBottomAreaBehavior() {
        this.f١٢٧٤٩d = new Rect();
        this.f١٢٧٥٠e = new Rect();
        this.f١٢٧٥١f = 0;
    }

    private static int O(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior
    public void M(CoordinatorLayout coordinatorLayout, View view, int i10) {
        List x10 = coordinatorLayout.x(view);
        if (!x10.isEmpty()) {
            View view2 = (View) x10.get(0);
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f١٢٧٤٩d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, view2.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + view2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            Rect rect2 = this.f١٢٧٥٠e;
            t.a(O(fVar.f٢٥٦٢c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
            view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            return;
        }
        super.M(coordinatorLayout, view, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
        N(view2.getBottom() - K());
        return false;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        boolean r10 = super.r(coordinatorLayout, view, i10);
        List x10 = coordinatorLayout.x(view);
        if (!x10.isEmpty()) {
            N(((View) x10.get(0)).getBottom() - K());
        }
        return r10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = view.getLayoutParams().height;
        if (i15 != -1 && i15 != -2) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        int i16 = size - this.f١٢٧٥١f;
        if (i15 == -1) {
            i14 = 1073741824;
        } else {
            i14 = Integer.MIN_VALUE;
        }
        coordinatorLayout.P(view, i10, i11, View.MeasureSpec.makeMeasureSpec(i16, i14), i13);
        return true;
    }

    public QMUIContinuousNestedBottomAreaBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٧٤٩d = new Rect();
        this.f١٢٧٥٠e = new Rect();
        this.f١٢٧٥١f = 0;
    }
}
