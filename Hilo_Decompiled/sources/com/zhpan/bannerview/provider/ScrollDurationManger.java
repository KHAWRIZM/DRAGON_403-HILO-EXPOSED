package com.zhpan.bannerview.provider;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import m2.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ScrollDurationManger extends LinearLayoutManager {
    private final LinearLayoutManager a;
    private final int b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        protected int calculateTimeForDeceleration(int i) {
            return ScrollDurationManger.this.b;
        }
    }

    public ScrollDurationManger(ViewPager2 viewPager2, int i, LinearLayoutManager linearLayoutManager) {
        super(viewPager2.getContext(), linearLayoutManager.getOrientation(), false);
        this.b = i;
        this.a = linearLayoutManager;
    }

    protected void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        try {
            Method declaredMethod = this.a.getClass().getDeclaredMethod("calculateExtraLayoutSpace", state.getClass(), iArr.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.a, state, iArr);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            dd.a.e(e.getMessage());
        }
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, g0 g0Var) {
        this.a.onInitializeAccessibilityNodeInfo(recycler, state, g0Var);
    }

    public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i, Bundle bundle) {
        return this.a.performAccessibilityAction(recycler, state, i, bundle);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i);
        startSmoothScroll(aVar);
    }
}
