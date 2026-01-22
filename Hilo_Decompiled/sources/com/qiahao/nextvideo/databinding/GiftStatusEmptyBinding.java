package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftStatusEmptyBinding implements a {
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final ConstraintLayout statusRetryView;

    private GiftStatusEmptyBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.ivIcon = imageView;
        this.statusRetryView = constraintLayout2;
    }

    public static GiftStatusEmptyBinding bind(View view) {
        ImageView imageView = (ImageView) b.a(view, 2131363373);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new GiftStatusEmptyBinding(constraintLayout, imageView, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(2131363373)));
    }

    public static GiftStatusEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GiftStatusEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.gift_status_empty, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
