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
public final class GiftEffectViewBinding implements a {
    public final ImageView avatar;
    public final ImageView heardBg;
    private final ConstraintLayout rootView;

    private GiftEffectViewBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.avatar = imageView;
        this.heardBg = imageView2;
    }

    public static GiftEffectViewBinding bind(View view) {
        int i = 2131362013;
        ImageView imageView = (ImageView) b.a(view, 2131362013);
        if (imageView != null) {
            i = R.id.heardBg;
            ImageView imageView2 = (ImageView) b.a(view, R.id.heardBg);
            if (imageView2 != null) {
                return new GiftEffectViewBinding((ConstraintLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static GiftEffectViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GiftEffectViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.gift_effect_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
