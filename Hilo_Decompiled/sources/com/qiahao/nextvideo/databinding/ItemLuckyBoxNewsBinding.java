package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ItemLuckyBoxNewsBinding implements a {
    public final CircleImageView avatar;
    public final LinearLayout contentBg;
    private final LinearLayout rootView;
    public final TextView textDiamond;

    private ItemLuckyBoxNewsBinding(LinearLayout linearLayout, CircleImageView circleImageView, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.avatar = circleImageView;
        this.contentBg = linearLayout2;
        this.textDiamond = textView;
    }

    public static ItemLuckyBoxNewsBinding bind(View view) {
        int i = 2131362013;
        CircleImageView circleImageView = (CircleImageView) b.a(view, 2131362013);
        if (circleImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView = (TextView) b.a(view, R.id.text_diamond);
            if (textView != null) {
                return new ItemLuckyBoxNewsBinding(linearLayout, circleImageView, linearLayout, textView);
            }
            i = R.id.text_diamond;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemLuckyBoxNewsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLuckyBoxNewsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_lucky_box_news, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
