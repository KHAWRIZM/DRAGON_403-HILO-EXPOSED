package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemPopularBinding implements a {
    public final QMUIRadiusImageView imageView;
    private final FrameLayout rootView;

    private ItemPopularBinding(FrameLayout frameLayout, QMUIRadiusImageView qMUIRadiusImageView) {
        this.rootView = frameLayout;
        this.imageView = qMUIRadiusImageView;
    }

    public static ItemPopularBinding bind(View view) {
        QMUIRadiusImageView a = b.a(view, 2131363211);
        if (a != null) {
            return new ItemPopularBinding((FrameLayout) view, a);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131363211)));
    }

    public static ItemPopularBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPopularBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_popular, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
