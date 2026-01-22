package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.v;
import f8.w;
import f8.x;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialButtonGroup extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    private static final int f٨٥٣٠k = R.style.Widget_Material3_MaterialButtonGroup;

    /* renamed from: a, reason: collision with root package name */
    private final List f٨٥٣١a;

    /* renamed from: b, reason: collision with root package name */
    private final List f٨٥٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private final b f٨٥٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private final Comparator f٨٥٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private Integer[] f٨٥٣٥e;

    /* renamed from: f, reason: collision with root package name */
    v f٨٥٣٦f;

    /* renamed from: g, reason: collision with root package name */
    private w f٨٥٣٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٥٣٨h;

    /* renamed from: i, reason: collision with root package name */
    private x f٨٥٣٩i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f٨٥٤٠j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class b implements MaterialButton.c {
        private b() {
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(MaterialButton materialButton, boolean z10) {
            MaterialButtonGroup.this.invalidate();
        }
    }

    public MaterialButtonGroup(Context context) {
        this(context, null);
    }

    private void b() {
        int i10;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i11 = firstVisibleChildIndex + 1; i11 < getChildCount(); i11++) {
            MaterialButton f10 = f(i11);
            MaterialButton f11 = f(i11 - 1);
            if (this.f٨٥٣٨h <= 0) {
                i10 = Math.min(f10.getStrokeWidth(), f11.getStrokeWidth());
                f10.setShouldDrawSurfaceColorStroke(true);
                f11.setShouldDrawSurfaceColorStroke(true);
            } else {
                f10.setShouldDrawSurfaceColorStroke(false);
                f11.setShouldDrawSurfaceColorStroke(false);
                i10 = 0;
            }
            LinearLayout.LayoutParams d10 = d(f10);
            if (getOrientation() == 0) {
                d10.setMarginEnd(0);
                d10.setMarginStart(this.f٨٥٣٨h - i10);
                d10.topMargin = 0;
            } else {
                d10.bottomMargin = 0;
                d10.topMargin = this.f٨٥٣٨h - i10;
                d10.setMarginStart(0);
            }
            f10.setLayoutParams(d10);
        }
        n(firstVisibleChildIndex);
    }

    private void c() {
        int i10;
        if (this.f٨٥٣٩i != null && getChildCount() != 0) {
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i11 = Integer.MAX_VALUE;
            for (int i12 = firstVisibleChildIndex; i12 <= lastVisibleChildIndex; i12++) {
                if (j(i12)) {
                    int e10 = e(i12);
                    if (i12 != firstVisibleChildIndex && i12 != lastVisibleChildIndex) {
                        e10 /= 2;
                    }
                    i11 = Math.min(i11, e10);
                }
            }
            for (int i13 = firstVisibleChildIndex; i13 <= lastVisibleChildIndex; i13++) {
                if (j(i13)) {
                    f(i13).setSizeChange(this.f٨٥٣٩i);
                    MaterialButton f10 = f(i13);
                    if (i13 != firstVisibleChildIndex && i13 != lastVisibleChildIndex) {
                        i10 = i11 * 2;
                    } else {
                        i10 = i11;
                    }
                    f10.setWidthChangeMax(i10);
                }
            }
        }
    }

    private int e(int i10) {
        int allowedWidthDecrease;
        int i11 = 0;
        if (!j(i10) || this.f٨٥٣٩i == null) {
            return 0;
        }
        int max = Math.max(0, this.f٨٥٣٩i.c(f(i10).getWidth()));
        MaterialButton i12 = i(i10);
        if (i12 == null) {
            allowedWidthDecrease = 0;
        } else {
            allowedWidthDecrease = i12.getAllowedWidthDecrease();
        }
        MaterialButton g10 = g(i10);
        if (g10 != null) {
            i11 = g10.getAllowedWidthDecrease();
        }
        return Math.min(max, allowedWidthDecrease + i11);
    }

    private MaterialButton g(int i10) {
        int childCount = getChildCount();
        do {
            i10++;
            if (i10 >= childCount) {
                return null;
            }
        } while (!j(i10));
        return f(i10);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (j(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (j(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private w.b h(boolean z10, boolean z11, int i10) {
        w wVar = this.f٨٥٣٧g;
        if (wVar == null || (!z10 && !z11)) {
            wVar = (w) this.f٨٥٣٢b.get(i10);
        }
        if (wVar == null) {
            return new w.b((o) this.f٨٥٣١a.get(i10));
        }
        return wVar.i();
    }

    private MaterialButton i(int i10) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (j(i11)) {
                return f(i11);
            }
        }
        return null;
    }

    private boolean j(int i10) {
        if (getChildAt(i10).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int k(MaterialButton materialButton, MaterialButton materialButton2) {
        int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        return Integer.compare(indexOfChild(materialButton), indexOfChild(materialButton2));
    }

    private void m() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f(i10).u();
        }
    }

    private void n(int i10) {
        if (getChildCount() != 0 && i10 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f(i10).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
            } else {
                layoutParams.setMarginEnd(0);
                layoutParams.setMarginStart(0);
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
            }
        }
    }

    private void o() {
        TreeMap treeMap = new TreeMap(this.f٨٥٣٤d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(f(i10), Integer.valueOf(i10));
        }
        this.f٨٥٣٥e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        m();
        this.f٨٥٤٠j = true;
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f٨٥٣٣c);
        this.f٨٥٣١a.add(materialButton.getShapeAppearanceModel());
        this.f٨٥٣٢b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        o();
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialButton f(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public x getButtonSizeChange() {
        return this.f٨٥٣٩i;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f٨٥٣٥e;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i11;
    }

    public f8.d getInnerCornerSize() {
        return this.f٨٥٣٦f.e();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public v getInnerCornerSizeStateList() {
        return this.f٨٥٣٦f;
    }

    public o getShapeAppearance() {
        w wVar = this.f٨٥٣٧g;
        if (wVar == null) {
            return null;
        }
        return wVar.c(true);
    }

    public int getSpacing() {
        return this.f٨٥٣٨h;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public w getStateListShapeAppearance() {
        return this.f٨٥٣٧g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(MaterialButton materialButton, int i10) {
        int indexOfChild = indexOfChild(materialButton);
        if (indexOfChild < 0) {
            return;
        }
        MaterialButton i11 = i(indexOfChild);
        MaterialButton g10 = g(indexOfChild);
        if (i11 == null && g10 == null) {
            return;
        }
        if (i11 == null) {
            g10.setDisplayedWidthDecrease(i10);
        }
        if (g10 == null) {
            i11.setDisplayedWidthDecrease(i10);
        }
        if (i11 != null && g10 != null) {
            i11.setDisplayedWidthDecrease(i10 / 2);
            g10.setDisplayedWidthDecrease((i10 + 1) / 2);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            m();
            c();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        p();
        b();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f٨٥٣١a.remove(indexOfChild);
            this.f٨٥٣٢b.remove(indexOfChild);
        }
        this.f٨٥٤٠j = true;
        p();
        m();
        b();
    }

    void p() {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        if ((this.f٨٥٣٦f == null && this.f٨٥٣٧g == null) || !this.f٨٥٤٠j) {
            return;
        }
        this.f٨٥٤٠j = false;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i11 = 0; i11 < childCount; i11++) {
            MaterialButton f10 = f(i11);
            if (f10.getVisibility() != 8) {
                if (i11 == firstVisibleChildIndex) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (i11 == lastVisibleChildIndex) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                w.b h10 = h(z10, z11, i11);
                if (getOrientation() == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean m10 = k0.m(this);
                if (z12) {
                    if (z10) {
                        i10 = 5;
                    } else {
                        i10 = 0;
                    }
                    if (z11) {
                        i10 |= 10;
                    }
                    if (m10) {
                        i10 = w.h(i10);
                    }
                } else {
                    if (z10) {
                        i10 = 3;
                    } else {
                        i10 = 0;
                    }
                    if (z11) {
                        i10 |= 12;
                    }
                }
                w j10 = h10.n(this.f٨٥٣٦f, ~i10).j();
                if (j10.f()) {
                    f10.setStateListShapeAppearanceModel(j10);
                } else {
                    f10.setShapeAppearanceModel(j10.c(true));
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setButtonSizeChange(x xVar) {
        if (this.f٨٥٣٩i != xVar) {
            this.f٨٥٣٩i = xVar;
            c();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            f(i10).setEnabled(z10);
        }
    }

    public void setInnerCornerSize(f8.d dVar) {
        this.f٨٥٣٦f = v.c(dVar);
        this.f٨٥٤٠j = true;
        p();
        invalidate();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInnerCornerSizeStateList(v vVar) {
        this.f٨٥٣٦f = vVar;
        this.f٨٥٤٠j = true;
        p();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (getOrientation() != i10) {
            this.f٨٥٤٠j = true;
        }
        super.setOrientation(i10);
    }

    public void setShapeAppearance(o oVar) {
        this.f٨٥٣٧g = new w.b(oVar).j();
        this.f٨٥٤٠j = true;
        p();
        invalidate();
    }

    public void setSpacing(int i10) {
        this.f٨٥٣٨h = i10;
        invalidate();
        requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearance(w wVar) {
        this.f٨٥٣٧g = wVar;
        this.f٨٥٤٠j = true;
        p();
        invalidate();
    }

    public MaterialButtonGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButtonGroup(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f٨٥٣٠k;
        this.f٨٥٣١a = new ArrayList();
        this.f٨٥٣٢b = new ArrayList();
        this.f٨٥٣٣c = new b();
        this.f٨٥٣٤d = new Comparator() { // from class: com.google.android.material.button.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k10;
                k10 = MaterialButtonGroup.this.k((MaterialButton) obj, (MaterialButton) obj2);
                return k10;
            }
        };
        this.f٨٥٤٠j = true;
        Context context2 = getContext();
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.MaterialButtonGroup, i10, i11, new int[0]);
        int i13 = R.styleable.MaterialButtonGroup_buttonSizeChange;
        if (i12.hasValue(i13)) {
            this.f٨٥٣٩i = x.b(context2, i12, i13);
        }
        int i14 = R.styleable.MaterialButtonGroup_shapeAppearance;
        if (i12.hasValue(i14)) {
            w b10 = w.b(context2, i12, i14);
            this.f٨٥٣٧g = b10;
            if (b10 == null) {
                this.f٨٥٣٧g = new w.b(o.b(context2, i12.getResourceId(i14, 0), i12.getResourceId(R.styleable.MaterialButtonGroup_shapeAppearanceOverlay, 0)).m()).j();
            }
        }
        int i15 = R.styleable.MaterialButtonGroup_innerCornerSize;
        if (i12.hasValue(i15)) {
            this.f٨٥٣٦f = v.b(context2, i12, i15, new f8.a(DownloadProgress.UNKNOWN_PROGRESS));
        }
        this.f٨٥٣٨h = i12.getDimensionPixelSize(R.styleable.MaterialButtonGroup_android_spacing, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(i12.getBoolean(R.styleable.MaterialButtonGroup_android_enabled, true));
        i12.recycle();
    }
}
