package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemBannerActivityBinding implements a {
    public final ImageView bg;
    private final ConstraintLayout rootView;
    public final TextView text;

    private ItemBannerActivityBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.bg = imageView;
        this.text = textView;
    }

    public static ItemBannerActivityBinding bind(View view) {
        int i = 2131362100;
        ImageView imageView = (ImageView) b.a(view, 2131362100);
        if (imageView != null) {
            i = 2131365026;
            TextView textView = (TextView) b.a(view, 2131365026);
            if (textView != null) {
                return new ItemBannerActivityBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemBannerActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBannerActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_banner_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
