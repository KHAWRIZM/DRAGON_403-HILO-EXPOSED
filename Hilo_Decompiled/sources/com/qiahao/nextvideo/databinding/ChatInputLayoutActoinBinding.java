package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatInputLayoutActoinBinding implements a {
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final TextView textView;

    private ChatInputLayoutActoinBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.imageView = imageView;
        this.textView = textView;
    }

    public static ChatInputLayoutActoinBinding bind(View view) {
        int i = 2131363211;
        ImageView imageView = (ImageView) b.a(view, 2131363211);
        if (imageView != null) {
            i = 2131365073;
            TextView textView = (TextView) b.a(view, 2131365073);
            if (textView != null) {
                return new ChatInputLayoutActoinBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ChatInputLayoutActoinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ChatInputLayoutActoinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(2131558587, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
