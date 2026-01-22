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
public final class ViewFoodieBigRewardBinding implements a {
    public final ImageView ivImage;
    public final ImageView ivShadow;
    private final ConstraintLayout rootView;
    public final TextView tvRewardType;

    private ViewFoodieBigRewardBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = constraintLayout;
        this.ivImage = imageView;
        this.ivShadow = imageView2;
        this.tvRewardType = textView;
    }

    public static ViewFoodieBigRewardBinding bind(View view) {
        int i = 2131363347;
        ImageView imageView = (ImageView) b.a(view, 2131363347);
        if (imageView != null) {
            i = R.id.ivShadow;
            ImageView imageView2 = (ImageView) b.a(view, R.id.ivShadow);
            if (imageView2 != null) {
                i = R.id.tvRewardType;
                TextView textView = (TextView) b.a(view, R.id.tvRewardType);
                if (textView != null) {
                    return new ViewFoodieBigRewardBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewFoodieBigRewardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewFoodieBigRewardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_foodie_big_reward, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
