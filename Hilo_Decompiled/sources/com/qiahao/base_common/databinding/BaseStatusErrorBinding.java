package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.base_common.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BaseStatusErrorBinding implements a {
    public final TextView baseStatusHintContent;
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final TextView statusRetryView;

    private BaseStatusErrorBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.baseStatusHintContent = textView;
        this.ivIcon = imageView;
        this.statusRetryView = textView2;
    }

    public static BaseStatusErrorBinding bind(View view) {
        int i10 = R.id.base_status_hint_content;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.iv_icon;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = R.id.status_retry_view;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    return new BaseStatusErrorBinding((ConstraintLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BaseStatusErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BaseStatusErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.base_status_error, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
