package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewFoodieItemBinding implements a {
    public final ImageView ivBottomBg;
    public final ImageView ivFinger;
    public final ImageView ivMask;
    public final ImageView ivPicture;
    public final LinearLayout llHotContainer;
    private final ConstraintLayout rootView;
    public final TextView tvMultiplier;
    public final TextView tvRate;
    public final View vCenterRef;

    private ViewFoodieItemBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.ivBottomBg = imageView;
        this.ivFinger = imageView2;
        this.ivMask = imageView3;
        this.ivPicture = imageView4;
        this.llHotContainer = linearLayout;
        this.tvMultiplier = textView;
        this.tvRate = textView2;
        this.vCenterRef = view;
    }

    public static ViewFoodieItemBinding bind(View view) {
        int i = R.id.ivBottomBg;
        ImageView imageView = (ImageView) b.a(view, R.id.ivBottomBg);
        if (imageView != null) {
            i = R.id.ivFinger;
            ImageView imageView2 = (ImageView) b.a(view, R.id.ivFinger);
            if (imageView2 != null) {
                i = R.id.ivMask;
                ImageView imageView3 = (ImageView) b.a(view, R.id.ivMask);
                if (imageView3 != null) {
                    i = 2131363352;
                    ImageView imageView4 = (ImageView) b.a(view, 2131363352);
                    if (imageView4 != null) {
                        i = R.id.llHotContainer;
                        LinearLayout linearLayout = (LinearLayout) b.a(view, R.id.llHotContainer);
                        if (linearLayout != null) {
                            i = R.id.tvMultiplier;
                            TextView textView = (TextView) b.a(view, R.id.tvMultiplier);
                            if (textView != null) {
                                i = R.id.tvRate;
                                TextView textView2 = (TextView) b.a(view, R.id.tvRate);
                                if (textView2 != null) {
                                    i = R.id.vCenterRef;
                                    View a = b.a(view, R.id.vCenterRef);
                                    if (a != null) {
                                        return new ViewFoodieItemBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, linearLayout, textView, textView2, a);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewFoodieItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewFoodieItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_foodie_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
