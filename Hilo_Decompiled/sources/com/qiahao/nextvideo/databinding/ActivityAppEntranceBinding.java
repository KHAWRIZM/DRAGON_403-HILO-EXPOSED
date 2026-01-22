package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qiahao.nextvideo.R;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivityAppEntranceBinding implements a {
    private final FrameLayout rootView;

    private ActivityAppEntranceBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public static ActivityAppEntranceBinding bind(View view) {
        if (view != null) {
            return new ActivityAppEntranceBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityAppEntranceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAppEntranceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_app_entrance, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
