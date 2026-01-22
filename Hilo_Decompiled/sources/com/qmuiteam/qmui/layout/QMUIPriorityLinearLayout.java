package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class QMUIPriorityLinearLayout extends QMUILinearLayout {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList f١٢٧١٨c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList f١٢٧١٩d;

    public QMUIPriorityLinearLayout(Context context) {
        super(context);
        this.f١٢٧١٨c = new ArrayList();
        this.f١٢٧١٩d = new ArrayList();
    }

    private int getVisibleChildCount() {
        int childCount = getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            if (getChildAt(i11).getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private void k(int i10, int i11) {
        int size = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        int mode = View.MeasureSpec.getMode(i10);
        int visibleChildCount = getVisibleChildCount();
        if (mode != 0 && visibleChildCount != 0 && size > 0) {
            int l10 = l(i10, i11);
            if (l10 >= size) {
                Iterator it = this.f١٢٧١٨c.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    a aVar = (a) view.getLayoutParams();
                    view.measure(View.MeasureSpec.makeMeasureSpec(aVar.f١٢٧٢١b, Integer.MIN_VALUE), i11);
                    ((LinearLayout.LayoutParams) aVar).width = view.getMeasuredWidth();
                }
                Iterator it2 = this.f١٢٧١٩d.iterator();
                while (it2.hasNext()) {
                    a aVar2 = (a) ((View) it2.next()).getLayoutParams();
                    ((LinearLayout.LayoutParams) aVar2).width = 0;
                    ((LinearLayout.LayoutParams) aVar2).leftMargin = 0;
                    ((LinearLayout.LayoutParams) aVar2).rightMargin = 0;
                }
                return;
            }
            int i12 = size - l10;
            Iterator it3 = this.f١٢٧١٨c.iterator();
            int i13 = 0;
            int i14 = 0;
            while (it3.hasNext()) {
                View view2 = (View) it3.next();
                a aVar3 = (a) view2.getLayoutParams();
                view2.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i11);
                int i15 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                i14 += view2.getMeasuredWidth() + i15;
                i13 += Math.min(view2.getMeasuredWidth(), aVar3.f١٢٧٢١b) + i15;
            }
            if (i13 >= i12) {
                Iterator it4 = this.f١٢٧١٨c.iterator();
                while (it4.hasNext()) {
                    View view3 = (View) it4.next();
                    a aVar4 = (a) view3.getLayoutParams();
                    ((LinearLayout.LayoutParams) aVar4).width = Math.min(view3.getMeasuredWidth(), aVar4.f١٢٧٢١b);
                }
                Iterator it5 = this.f١٢٧١٩d.iterator();
                while (it5.hasNext()) {
                    a aVar5 = (a) ((View) it5.next()).getLayoutParams();
                    ((LinearLayout.LayoutParams) aVar5).width = 0;
                    ((LinearLayout.LayoutParams) aVar5).leftMargin = 0;
                    ((LinearLayout.LayoutParams) aVar5).rightMargin = 0;
                }
                return;
            }
            if (i14 < i12) {
                if (!this.f١٢٧١٩d.isEmpty()) {
                    g(this.f١٢٧١٩d, i10, i11, i12 - i14);
                    return;
                }
                return;
            }
            Iterator it6 = this.f١٢٧١٩d.iterator();
            while (it6.hasNext()) {
                a aVar6 = (a) ((View) it6.next()).getLayoutParams();
                ((LinearLayout.LayoutParams) aVar6).width = 0;
                ((LinearLayout.LayoutParams) aVar6).leftMargin = 0;
                ((LinearLayout.LayoutParams) aVar6).rightMargin = 0;
            }
            if (i12 < i14 && !this.f١٢٧١٨c.isEmpty()) {
                h(this.f١٢٧١٨c, i12, i14);
            }
        }
    }

    private int l(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int measuredHeight;
        int size = (View.MeasureSpec.getSize(i10) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i11) - getPaddingTop()) - getPaddingBottom();
        this.f١٢٧١٨c.clear();
        this.f١٢٧١٩d.clear();
        int orientation = getOrientation();
        int i15 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                aVar.b();
                int c10 = aVar.c(orientation);
                if (orientation == 0) {
                    i12 = ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i13 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                } else {
                    i12 = ((LinearLayout.LayoutParams) aVar).topMargin;
                    i13 = ((LinearLayout.LayoutParams) aVar).bottomMargin;
                }
                int i17 = i12 + i13;
                if (c10 == 3) {
                    if (orientation == 0) {
                        i14 = ((LinearLayout.LayoutParams) aVar).width;
                        if (i14 < 0) {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i11);
                            measuredHeight = childAt.getMeasuredWidth();
                            i15 += measuredHeight + i17;
                        }
                        i15 += i14 + i17;
                    } else {
                        i14 = ((LinearLayout.LayoutParams) aVar).height;
                        if (i14 < 0) {
                            childAt.measure(i10, View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                            measuredHeight = childAt.getMeasuredHeight();
                            i15 += measuredHeight + i17;
                        }
                        i15 += i14 + i17;
                    }
                } else if (c10 == 2) {
                    this.f١٢٧١٨c.add(childAt);
                } else if (((LinearLayout.LayoutParams) aVar).weight == DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f١٢٧١٩d.add(childAt);
                }
            }
        }
        return i15;
    }

    private void m(int i10, int i11) {
        int size = (View.MeasureSpec.getSize(i11) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i11);
        int visibleChildCount = getVisibleChildCount();
        if (mode != 0 && visibleChildCount != 0 && size > 0) {
            int l10 = l(i10, i11);
            if (l10 >= size) {
                Iterator it = this.f١٢٧١٨c.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    a aVar = (a) view.getLayoutParams();
                    view.measure(i10, View.MeasureSpec.makeMeasureSpec(aVar.f١٢٧٢١b, Integer.MIN_VALUE));
                    ((LinearLayout.LayoutParams) aVar).height = view.getMeasuredHeight();
                }
                Iterator it2 = this.f١٢٧١٩d.iterator();
                while (it2.hasNext()) {
                    a aVar2 = (a) ((View) it2.next()).getLayoutParams();
                    ((LinearLayout.LayoutParams) aVar2).height = 0;
                    ((LinearLayout.LayoutParams) aVar2).topMargin = 0;
                    ((LinearLayout.LayoutParams) aVar2).bottomMargin = 0;
                }
                return;
            }
            int i12 = size - l10;
            Iterator it3 = this.f١٢٧١٨c.iterator();
            int i13 = 0;
            int i14 = 0;
            while (it3.hasNext()) {
                View view2 = (View) it3.next();
                a aVar3 = (a) view2.getLayoutParams();
                view2.measure(i10, View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE));
                int i15 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                i14 += view2.getMeasuredHeight() + i15;
                i13 += Math.min(view2.getMeasuredHeight(), aVar3.f١٢٧٢١b) + i15;
            }
            if (i13 >= i12) {
                Iterator it4 = this.f١٢٧١٨c.iterator();
                while (it4.hasNext()) {
                    View view3 = (View) it4.next();
                    a aVar4 = (a) view3.getLayoutParams();
                    ((LinearLayout.LayoutParams) aVar4).height = Math.min(view3.getMeasuredHeight(), aVar4.f١٢٧٢١b);
                }
                Iterator it5 = this.f١٢٧١٩d.iterator();
                while (it5.hasNext()) {
                    a aVar5 = (a) ((View) it5.next()).getLayoutParams();
                    ((LinearLayout.LayoutParams) aVar5).height = 0;
                    ((LinearLayout.LayoutParams) aVar5).topMargin = 0;
                    ((LinearLayout.LayoutParams) aVar5).bottomMargin = 0;
                }
                return;
            }
            if (i14 < i12) {
                if (!this.f١٢٧١٩d.isEmpty()) {
                    g(this.f١٢٧١٩d, i10, i11, i12 - i14);
                    return;
                }
                return;
            }
            Iterator it6 = this.f١٢٧١٩d.iterator();
            while (it6.hasNext()) {
                a aVar6 = (a) ((View) it6.next()).getLayoutParams();
                ((LinearLayout.LayoutParams) aVar6).height = 0;
                ((LinearLayout.LayoutParams) aVar6).topMargin = 0;
                ((LinearLayout.LayoutParams) aVar6).bottomMargin = 0;
            }
            if (i12 < i14 && !this.f١٢٧١٨c.isEmpty()) {
                h(this.f١٢٧١٨c, i12, i14);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof a) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    protected void g(ArrayList arrayList, int i10, int i11, int i12) {
        int measuredWidth;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            a aVar = (a) view.getLayoutParams();
            if (getOrientation() == 0) {
                if (i12 <= 0) {
                    ((LinearLayout.LayoutParams) aVar).leftMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).rightMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).width = 0;
                }
                i12 -= ((LinearLayout.LayoutParams) aVar).leftMargin - ((LinearLayout.LayoutParams) aVar).rightMargin;
                if (i12 > 0) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE), ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom(), ((LinearLayout.LayoutParams) aVar).height));
                    if (view.getMeasuredWidth() >= i12) {
                        ((LinearLayout.LayoutParams) aVar).width = i12;
                        i12 = 0;
                    } else {
                        measuredWidth = view.getMeasuredWidth();
                        i12 -= measuredWidth;
                    }
                } else {
                    ((LinearLayout.LayoutParams) aVar).leftMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).rightMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).width = 0;
                }
            } else {
                if (i12 <= 0) {
                    ((LinearLayout.LayoutParams) aVar).topMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).bottomMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).height = 0;
                }
                i12 -= ((LinearLayout.LayoutParams) aVar).topMargin - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                if (i12 > 0) {
                    view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), ((LinearLayout.LayoutParams) aVar).width), View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE));
                    if (view.getMeasuredHeight() >= i12) {
                        ((LinearLayout.LayoutParams) aVar).height = i12;
                        i12 = 0;
                    } else {
                        measuredWidth = view.getMeasuredHeight();
                        i12 -= measuredWidth;
                    }
                } else {
                    ((LinearLayout.LayoutParams) aVar).topMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).bottomMargin = 0;
                    ((LinearLayout.LayoutParams) aVar).height = 0;
                }
            }
        }
    }

    protected void h(ArrayList arrayList, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar = (a) ((View) it.next()).getLayoutParams();
                if (getOrientation() == 0) {
                    ((LinearLayout.LayoutParams) aVar).width = Math.max(0, (int) (r0.getMeasuredWidth() - (i12 * ((((r0.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar).leftMargin) + ((LinearLayout.LayoutParams) aVar).rightMargin) * 1.0f) / i11))));
                } else {
                    ((LinearLayout.LayoutParams) aVar).height = Math.max(0, (int) (r0.getMeasuredHeight() - (i12 * ((((r0.getMeasuredHeight() + ((LinearLayout.LayoutParams) aVar).topMargin) + ((LinearLayout.LayoutParams) aVar).bottomMargin) * 1.0f) / i11))));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (getOrientation() == 0) {
            k(i10, i11);
        } else {
            m(i10, i11);
        }
        super.onMeasure(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public QMUIPriorityLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٧١٨c = new ArrayList();
        this.f١٢٧١٩d = new ArrayList();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        private int f١٢٧٢٠a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٢٧٢١b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٢٧٢٢c;

        /* renamed from: d, reason: collision with root package name */
        private int f١٢٧٢٣d;

        /* renamed from: e, reason: collision with root package name */
        private int f١٢٧٢٤e;

        /* renamed from: f, reason: collision with root package name */
        private int f١٢٧٢٥f;

        /* renamed from: g, reason: collision with root package name */
        private int f١٢٧٢٦g;

        /* renamed from: h, reason: collision with root package name */
        private int f١٢٧٢٧h;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f١٢٧٢٠a = 2;
            this.f١٢٧٢١b = 0;
            this.f١٢٧٢٢c = Integer.MIN_VALUE;
            this.f١٢٧٢٣d = Integer.MIN_VALUE;
            this.f١٢٧٢٤e = 0;
            this.f١٢٧٢٥f = 0;
            this.f١٢٧٢٦g = 0;
            this.f١٢٧٢٧h = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPriorityLinearLayout_Layout);
            this.f١٢٧٢٠a = obtainStyledAttributes.getInteger(R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_priority, 2);
            this.f١٢٧٢١b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_miniContentProtectionSize, 0);
            obtainStyledAttributes.recycle();
        }

        void b() {
            int i10 = this.f١٢٧٢٢c;
            if (i10 == Integer.MIN_VALUE) {
                this.f١٢٧٢٢c = ((LinearLayout.LayoutParams) this).width;
                this.f١٢٧٢٤e = ((LinearLayout.LayoutParams) this).leftMargin;
                this.f١٢٧٢٥f = ((LinearLayout.LayoutParams) this).rightMargin;
            } else {
                ((LinearLayout.LayoutParams) this).width = i10;
                ((LinearLayout.LayoutParams) this).leftMargin = this.f١٢٧٢٤e;
                ((LinearLayout.LayoutParams) this).rightMargin = this.f١٢٧٢٥f;
            }
            int i11 = this.f١٢٧٢٣d;
            if (i11 == Integer.MIN_VALUE) {
                this.f١٢٧٢٣d = ((LinearLayout.LayoutParams) this).height;
                this.f١٢٧٢٦g = ((LinearLayout.LayoutParams) this).topMargin;
                this.f١٢٧٢٧h = ((LinearLayout.LayoutParams) this).bottomMargin;
            } else {
                ((LinearLayout.LayoutParams) this).height = i11;
                ((LinearLayout.LayoutParams) this).topMargin = this.f١٢٧٢٦g;
                ((LinearLayout.LayoutParams) this).bottomMargin = this.f١٢٧٢٧h;
            }
        }

        public int c(int i10) {
            if (((LinearLayout.LayoutParams) this).weight > DownloadProgress.UNKNOWN_PROGRESS) {
                return 1;
            }
            if (i10 == 0) {
                if (((LinearLayout.LayoutParams) this).width >= 0) {
                    return 3;
                }
            } else if (((LinearLayout.LayoutParams) this).height >= 0) {
                return 3;
            }
            return this.f١٢٧٢٠a;
        }

        public void d(int i10) {
            this.f١٢٧٢٠a = i10;
        }

        public a(int i10, int i11) {
            super(i10, i11);
            this.f١٢٧٢٠a = 2;
            this.f١٢٧٢١b = 0;
            this.f١٢٧٢٢c = Integer.MIN_VALUE;
            this.f١٢٧٢٣d = Integer.MIN_VALUE;
            this.f١٢٧٢٤e = 0;
            this.f١٢٧٢٥f = 0;
            this.f١٢٧٢٦g = 0;
            this.f١٢٧٢٧h = 0;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f١٢٧٢٠a = 2;
            this.f١٢٧٢١b = 0;
            this.f١٢٧٢٢c = Integer.MIN_VALUE;
            this.f١٢٧٢٣d = Integer.MIN_VALUE;
            this.f١٢٧٢٤e = 0;
            this.f١٢٧٢٥f = 0;
            this.f١٢٧٢٦g = 0;
            this.f١٢٧٢٧h = 0;
        }
    }
}
