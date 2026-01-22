package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemAdvertisingPic1Binding implements a {
    public final AppCompatImageView adImageView;
    public final ConstraintLayout bodyView;
    private final ConstraintLayout rootView;

    private ItemAdvertisingPic1Binding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.adImageView = appCompatImageView;
        this.bodyView = constraintLayout2;
    }

    public static ItemAdvertisingPic1Binding bind(View view) {
        AppCompatImageView a = b.a(view, R.id.ad_image_view);
        if (a != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new ItemAdvertisingPic1Binding(constraintLayout, a, constraintLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.ad_image_view)));
    }

    public static ItemAdvertisingPic1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAdvertisingPic1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_advertising_pic1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
