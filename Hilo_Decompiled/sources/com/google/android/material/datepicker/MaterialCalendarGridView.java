package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.d1;
import com.google.android.material.R;
import com.google.android.material.internal.k0;
import java.util.Calendar;
import java.util.Iterator;
import m2.g0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f٨٨٢٥a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f٨٨٢٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.q0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i10, Rect rect) {
        if (i10 == 33) {
            setSelection(getAdapter().m());
        } else if (i10 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    private View b(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    private static int c(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(Long l10, Long l11, Long l12, Long l13) {
        if (l10 == null || l11 == null || l12 == null || l13 == null || l12.longValue() > l11.longValue() || l13.longValue() < l10.longValue()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int a10;
        int c10;
        int a11;
        int c11;
        int i10;
        int i11;
        int i12;
        int i13;
        int left;
        int left2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        r adapter = getAdapter();
        DateSelector dateSelector = adapter.f٨٩٨١b;
        b bVar = adapter.f٨٩٨٣d;
        int max = Math.max(adapter.b(), getFirstVisiblePosition());
        int min = Math.min(adapter.m(), getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator it = dateSelector.C().iterator();
        while (it.hasNext()) {
            androidx.core.util.g gVar = (androidx.core.util.g) it.next();
            Object obj = gVar.f٢٨٨٨a;
            if (obj != null) {
                if (gVar.f٢٨٨٩b != null) {
                    Long l10 = (Long) obj;
                    long longValue = l10.longValue();
                    Long l11 = (Long) gVar.f٢٨٨٩b;
                    long longValue2 = l11.longValue();
                    if (!d(item, item2, l10, l11)) {
                        boolean m10 = k0.m(this);
                        if (longValue < item.longValue()) {
                            if (adapter.h(max)) {
                                left2 = 0;
                            } else if (!m10) {
                                left2 = materialCalendarGridView.b(max - 1).getRight();
                            } else {
                                left2 = materialCalendarGridView.b(max - 1).getLeft();
                            }
                            c10 = left2;
                            a10 = max;
                        } else {
                            materialCalendarGridView.f٨٨٢٥a.setTimeInMillis(longValue);
                            a10 = adapter.a(materialCalendarGridView.f٨٨٢٥a.get(5));
                            c10 = c(materialCalendarGridView.b(a10));
                        }
                        if (longValue2 > item2.longValue()) {
                            if (adapter.i(min)) {
                                left = getWidth();
                            } else if (!m10) {
                                left = materialCalendarGridView.b(min).getRight();
                            } else {
                                left = materialCalendarGridView.b(min).getLeft();
                            }
                            c11 = left;
                            a11 = min;
                        } else {
                            materialCalendarGridView.f٨٨٢٥a.setTimeInMillis(longValue2);
                            a11 = adapter.a(materialCalendarGridView.f٨٨٢٥a.get(5));
                            c11 = c(materialCalendarGridView.b(a11));
                        }
                        int itemId = (int) adapter.getItemId(a10);
                        int i14 = max;
                        int i15 = min;
                        int itemId2 = (int) adapter.getItemId(a11);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            r rVar = adapter;
                            int numColumns2 = (numColumns + getNumColumns()) - 1;
                            View b10 = materialCalendarGridView.b(numColumns);
                            int top = b10.getTop() + bVar.f٨٨٦٦a.c();
                            Iterator it2 = it;
                            int bottom = b10.getBottom() - bVar.f٨٨٦٦a.b();
                            if (!m10) {
                                if (numColumns > a10) {
                                    i12 = 0;
                                } else {
                                    i12 = c10;
                                }
                                if (a11 > numColumns2) {
                                    i13 = getWidth();
                                } else {
                                    i13 = c11;
                                }
                            } else {
                                if (a11 > numColumns2) {
                                    i10 = 0;
                                } else {
                                    i10 = c11;
                                }
                                if (numColumns > a10) {
                                    i11 = getWidth();
                                } else {
                                    i11 = c10;
                                }
                                int i16 = i11;
                                i12 = i10;
                                i13 = i16;
                            }
                            canvas.drawRect(i12, top, i13, bottom, bVar.f٨٨٧٣h);
                            itemId++;
                            materialCalendarGridView = this;
                            itemId2 = itemId2;
                            adapter = rVar;
                            it = it2;
                        }
                        materialCalendarGridView = this;
                        max = i14;
                        min = i15;
                    }
                }
            } else {
                materialCalendarGridView = this;
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            a(i10, rect);
        } else {
            super.onFocusChanged(false, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= getAdapter().b() && selectedItemPosition <= getAdapter().m())) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f٨٨٢٦b) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i10) {
        if (i10 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٨٨٢٥a = c0.r();
        if (p.t(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f٨٨٢٦b = p.v(getContext());
        d1.q0(this, new a());
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof r) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), r.class.getCanonicalName()));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public ListAdapter getAdapter2() {
        return (r) super.getAdapter();
    }
}
