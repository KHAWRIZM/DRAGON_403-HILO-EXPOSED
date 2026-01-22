package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIFloatLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private int f١٢٩٦٣a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٢٩٦٤b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٩٦٥c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٢٩٦٦d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٩٦٧e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٩٦٨f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f١٢٩٦٩g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f١٢٩٧٠h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٢٩٧١i;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface a {
    }

    public QMUIFloatLayout(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIFloatLayout);
        this.f١٢٩٦٣a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIFloatLayout_qmui_childHorizontalSpacing, 0);
        this.f١٢٩٦٤b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIFloatLayout_qmui_childVerticalSpacing, 0);
        this.f١٢٩٦٥c = obtainStyledAttributes.getInteger(R.styleable.QMUIFloatLayout_android_gravity, 3);
        int i10 = obtainStyledAttributes.getInt(R.styleable.QMUIFloatLayout_android_maxLines, -1);
        if (i10 >= 0) {
            setMaxLines(i10);
        }
        int i11 = obtainStyledAttributes.getInt(R.styleable.QMUIFloatLayout_qmui_maxNumber, -1);
        if (i11 >= 0) {
            setMaxNumber(i11);
        }
        obtainStyledAttributes.recycle();
    }

    private void b(int i10) {
        int paddingTop = getPaddingTop();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f١٢٩٦٩g;
            if (i11 >= iArr.length || iArr[i11] == 0) {
                break;
            }
            int paddingLeft = ((((i10 - getPaddingLeft()) - getPaddingRight()) - this.f١٢٩٧٠h[i11]) / 2) + getPaddingLeft();
            int i14 = 0;
            int i15 = 0;
            while (i14 < this.f١٢٩٦٩g[i11]) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 8) {
                    i12++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    i15 = Math.max(i15, measuredHeight);
                    paddingLeft += measuredWidth + this.f١٢٩٦٣a;
                    i13++;
                    i14++;
                    i12++;
                    if (i13 == this.f١٢٩٧١i) {
                        break;
                    }
                }
            }
            if (i13 == this.f١٢٩٧١i) {
                break;
            }
            paddingTop += i15 + this.f١٢٩٦٤b;
            i11++;
        }
        int childCount = getChildCount();
        while (i12 < childCount) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.layout(0, 0, 0, 0);
            }
            i12++;
        }
    }

    private void c(int i10) {
        int paddingRight = i10 - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                if (i11 < this.f١٢٩٧١i) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (paddingLeft + measuredWidth > paddingRight) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += i12 + this.f١٢٩٦٤b;
                        i12 = 0;
                    }
                    childAt.layout(paddingLeft, paddingTop, paddingLeft + measuredWidth, paddingTop + measuredHeight);
                    paddingLeft += measuredWidth + this.f١٢٩٦٣a;
                    i12 = Math.max(i12, measuredHeight);
                    i11++;
                } else {
                    childAt.layout(0, 0, 0, 0);
                }
            }
        }
    }

    private void d(int i10) {
        int paddingTop = getPaddingTop();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f١٢٩٦٩g;
            if (i11 >= iArr.length || iArr[i11] == 0) {
                break;
            }
            int paddingRight = (i10 - getPaddingRight()) - this.f١٢٩٧٠h[i11];
            int i14 = 0;
            int i15 = 0;
            while (i14 < this.f١٢٩٦٩g[i11]) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 8) {
                    i12++;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(paddingRight, paddingTop, paddingRight + measuredWidth, paddingTop + measuredHeight);
                    i15 = Math.max(i15, measuredHeight);
                    paddingRight += measuredWidth + this.f١٢٩٦٣a;
                    i13++;
                    i14++;
                    i12++;
                    if (i13 == this.f١٢٩٧١i) {
                        break;
                    }
                }
            }
            if (i13 == this.f١٢٩٧١i) {
                break;
            }
            paddingTop += i15 + this.f١٢٩٦٤b;
            i11++;
        }
        int childCount = getChildCount();
        while (i12 < childCount) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.layout(0, 0, 0, 0);
            }
            i12++;
        }
    }

    public int getGravity() {
        return this.f١٢٩٦٥c;
    }

    public int getLineCount() {
        return this.f١٢٩٦٨f;
    }

    public int getMaxLines() {
        if (this.f١٢٩٦٦d == 0) {
            return this.f١٢٩٦٧e;
        }
        return -1;
    }

    public int getMaxNumber() {
        if (this.f١٢٩٦٦d == 1) {
            return this.f١٢٩٦٧e;
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = i12 - i10;
        int i15 = this.f١٢٩٦٥c & 7;
        if (i15 != 1) {
            if (i15 != 3) {
                if (i15 != 5) {
                    c(i14);
                    return;
                } else {
                    d(i14);
                    return;
                }
            }
            c(i14);
            return;
        }
        b(i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0135  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        View childAt;
        int i14;
        int i15;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        int childCount = getChildCount();
        this.f١٢٩٦٩g = new int[childCount];
        this.f١٢٩٧٠h = new int[childCount];
        int i16 = 1;
        int i17 = 0;
        if (mode == 1073741824) {
            this.f١٢٩٧١i = 0;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = size - getPaddingRight();
            int i18 = 0;
            int i19 = 0;
            while (i17 < childCount) {
                int i20 = this.f١٢٩٦٦d;
                if ((i20 == i16 && this.f١٢٩٧١i >= this.f١٢٩٦٧e) || (i20 == 0 && i18 >= this.f١٢٩٦٧e)) {
                    break;
                }
                View childAt2 = getChildAt(i17);
                if (childAt2.getVisibility() == 8) {
                    i14 = size;
                } else {
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    i14 = size;
                    childAt2.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                    int measuredWidth = childAt2.getMeasuredWidth();
                    i19 = Math.max(i19, childAt2.getMeasuredHeight());
                    if (paddingLeft + measuredWidth > paddingRight) {
                        if (this.f١٢٩٦٦d == 0 && i18 + 1 >= this.f١٢٩٦٧e) {
                            break;
                        }
                        int[] iArr = this.f١٢٩٧٠h;
                        iArr[i18] = iArr[i18] - this.f١٢٩٦٣a;
                        i18++;
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.f١٢٩٦٤b + i19;
                    }
                    int[] iArr2 = this.f١٢٩٦٩g;
                    iArr2[i18] = iArr2[i18] + 1;
                    int[] iArr3 = this.f١٢٩٧٠h;
                    int i21 = iArr3[i18];
                    int i22 = this.f١٢٩٦٣a;
                    iArr3[i18] = i21 + measuredWidth + i22;
                    paddingLeft += measuredWidth + i22;
                    this.f١٢٩٧١i++;
                }
                i17++;
                size = i14;
                i16 = 1;
            }
            i14 = size;
            int[] iArr4 = this.f١٢٩٧٠h;
            if (iArr4.length > 0 && (i15 = iArr4[i18]) > 0) {
                iArr4[i18] = i15 - this.f١٢٩٦٣a;
            }
            if (mode2 == 0) {
                size2 = paddingTop + i19 + getPaddingBottom();
            } else if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(paddingTop + i19 + getPaddingBottom(), size2);
            }
            i17 = i18;
            i13 = i14;
        } else {
            int paddingLeft2 = getPaddingLeft() + getPaddingRight();
            this.f١٢٩٧١i = 0;
            int i23 = 0;
            int i24 = 0;
            while (true) {
                if (i23 < childCount) {
                    int i25 = this.f١٢٩٦٦d;
                    i12 = 1;
                    if (i25 == 1) {
                        if (this.f١٢٩٧١i > this.f١٢٩٦٧e) {
                            break;
                        }
                        childAt = getChildAt(i23);
                        if (childAt.getVisibility() == 8) {
                            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                            childAt.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), layoutParams2.width), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), layoutParams2.height));
                            paddingLeft2 += childAt.getMeasuredWidth();
                            i24 = Math.max(i24, childAt.getMeasuredHeight());
                            this.f١٢٩٧١i++;
                        }
                        i23++;
                    } else {
                        if (i25 == 0 && 1 > this.f١٢٩٦٧e) {
                            break;
                        }
                        childAt = getChildAt(i23);
                        if (childAt.getVisibility() == 8) {
                        }
                        i23++;
                    }
                } else {
                    i12 = 1;
                    break;
                }
            }
            int i26 = this.f١٢٩٧١i;
            if (i26 > 0) {
                paddingLeft2 += this.f١٢٩٦٣a * (i26 - i12);
            }
            i13 = paddingLeft2;
            size2 = i24 + getPaddingTop() + getPaddingBottom();
            int[] iArr5 = this.f١٢٩٦٩g;
            if (iArr5.length > 0) {
                iArr5[0] = childCount;
            }
            int[] iArr6 = this.f١٢٩٧٠h;
            if (iArr6.length > 0) {
                iArr6[0] = i13;
            }
        }
        setMeasuredDimension(i13, size2);
        int i27 = i17 + 1;
        if (this.f١٢٩٦٨f != i27) {
            this.f١٢٩٦٨f = i27;
        }
    }

    public void setChildHorizontalSpacing(int i10) {
        this.f١٢٩٦٣a = i10;
        invalidate();
    }

    public void setChildVerticalSpacing(int i10) {
        this.f١٢٩٦٤b = i10;
        invalidate();
    }

    public void setGravity(int i10) {
        if (this.f١٢٩٦٥c != i10) {
            this.f١٢٩٦٥c = i10;
            requestLayout();
        }
    }

    public void setMaxLines(int i10) {
        this.f١٢٩٦٧e = i10;
        this.f١٢٩٦٦d = 0;
        requestLayout();
    }

    public void setMaxNumber(int i10) {
        this.f١٢٩٦٧e = i10;
        this.f١٢٩٦٦d = 1;
        requestLayout();
    }

    public void setOnLineCountChangeListener(a aVar) {
    }

    public QMUIFloatLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIFloatLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٩٦٦d = 0;
        this.f١٢٩٦٧e = Integer.MAX_VALUE;
        this.f١٢٩٦٨f = 0;
        a(context, attributeSet);
    }
}
