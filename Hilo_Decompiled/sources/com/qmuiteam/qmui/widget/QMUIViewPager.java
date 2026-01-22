package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.d1;
import androidx.viewpager.widget.ViewPager;
import ic.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIViewPager extends ViewPager {

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٣١١٠a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٣١١١b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٣١١٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣١١٣d;

    public QMUIViewPager(Context context) {
        this(context, null);
    }

    public int getInfiniteRatio() {
        return this.f١٣١١٣d;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (!this.f١٣١١٠a) {
                return false;
            }
            if (!super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i10, int i11) {
        this.f١٣١١١b = true;
        super.onMeasure(i10, i11);
        this.f١٣١١١b = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (!this.f١٣١١٠a) {
                return false;
            }
            if (!super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        d1.n0(view);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(androidx.viewpager.widget.a aVar) {
        super.setAdapter(aVar);
    }

    public void setEnableLoop(boolean z10) {
        if (this.f١٣١١٢c != z10) {
            this.f١٣١١٢c = z10;
            if (getAdapter() != null) {
                getAdapter().notifyDataSetChanged();
            }
        }
    }

    public void setInfiniteRatio(int i10) {
        this.f١٣١١٣d = i10;
    }

    public void setSwipeable(boolean z10) {
        this.f١٣١١٠a = z10;
    }

    public QMUIViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣١١٠a = true;
        this.f١٣١١١b = false;
        this.f١٣١١٢c = false;
        this.f١٣١١٣d = 100;
        n.h(this);
    }
}
