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
public final class BaseStatusEmptyBinding implements a {
    public final TextView baseStatusEmptyCreate;
    public final TextView baseStatusHintContent;
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final ConstraintLayout statusRetryView;

    private BaseStatusEmptyBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.baseStatusEmptyCreate = textView;
        this.baseStatusHintContent = textView2;
        this.ivIcon = imageView;
        this.statusRetryView = constraintLayout2;
    }

    public static BaseStatusEmptyBinding bind(View view) {
        int i10 = R.id.base_status_empty_create;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.base_status_hint_content;
            TextView textView2 = (TextView) b.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.iv_icon;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new BaseStatusEmptyBinding(constraintLayout, textView, textView2, imageView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BaseStatusEmptyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BaseStatusEmptyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.base_status_empty, viewGroup, false);
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
