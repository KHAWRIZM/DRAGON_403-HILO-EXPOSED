package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HolderVipBinding implements a {
    private final LinearLayout rootView;
    public final TextView vipContent;
    public final ImageView vipIcon;
    public final TextView vipTitle;

    private HolderVipBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = linearLayout;
        this.vipContent = textView;
        this.vipIcon = imageView;
        this.vipTitle = textView2;
    }

    public static HolderVipBinding bind(View view) {
        int i = R.id.vip_content;
        TextView textView = (TextView) b.a(view, R.id.vip_content);
        if (textView != null) {
            i = R.id.vip_icon;
            ImageView imageView = (ImageView) b.a(view, R.id.vip_icon);
            if (imageView != null) {
                i = R.id.vip_title;
                TextView textView2 = (TextView) b.a(view, R.id.vip_title);
                if (textView2 != null) {
                    return new HolderVipBinding((LinearLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static HolderVipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HolderVipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_vip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
