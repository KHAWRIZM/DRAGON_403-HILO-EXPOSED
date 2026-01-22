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
public final class VideoEmtryLayoutBinding implements a {
    public final TextView baseStatusHintContent;
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final TextView statusRetryView;

    private VideoEmtryLayoutBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.baseStatusHintContent = textView;
        this.ivIcon = imageView;
        this.statusRetryView = textView2;
    }

    public static VideoEmtryLayoutBinding bind(View view) {
        int i = 2131362075;
        TextView textView = (TextView) b.a(view, 2131362075);
        if (textView != null) {
            i = 2131363373;
            ImageView imageView = (ImageView) b.a(view, 2131363373);
            if (imageView != null) {
                i = 2131364922;
                TextView textView2 = (TextView) b.a(view, 2131364922);
                if (textView2 != null) {
                    return new VideoEmtryLayoutBinding((ConstraintLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static VideoEmtryLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static VideoEmtryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.video_emtry_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
