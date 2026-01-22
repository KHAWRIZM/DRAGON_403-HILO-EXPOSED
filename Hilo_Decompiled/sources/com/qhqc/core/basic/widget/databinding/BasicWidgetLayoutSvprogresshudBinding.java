package com.qhqc.core.basic.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qhqc.core.basic.widget.R;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicWidgetLayoutSvprogresshudBinding implements a {
    private final FrameLayout rootView;
    public final FrameLayout svOutmostContainer;

    private BasicWidgetLayoutSvprogresshudBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.svOutmostContainer = frameLayout2;
    }

    public static BasicWidgetLayoutSvprogresshudBinding bind(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new BasicWidgetLayoutSvprogresshudBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    public static BasicWidgetLayoutSvprogresshudBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicWidgetLayoutSvprogresshudBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_widget_layout_svprogresshud, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
