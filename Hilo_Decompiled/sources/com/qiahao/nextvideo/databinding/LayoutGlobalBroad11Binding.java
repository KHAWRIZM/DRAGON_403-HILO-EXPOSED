package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LayoutGlobalBroad11Binding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout constraint;
    public final TextView content;
    public final ImageView icon;
    public final LinearLayout linear;
    public final TextView name;
    public final ImageView svipType;

    /* renamed from: top, reason: collision with root package name */
    public final ImageView f٦٦top;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutGlobalBroad11Binding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2, ImageView imageView2, ImageView imageView3) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.constraint = constraintLayout;
        this.content = textView;
        this.icon = imageView;
        this.linear = linearLayout;
        this.name = textView2;
        this.svipType = imageView2;
        this.f٦٦top = imageView3;
    }

    public static LayoutGlobalBroad11Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutGlobalBroad11Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static LayoutGlobalBroad11Binding bind(View view, Object obj) {
        return (LayoutGlobalBroad11Binding) ViewDataBinding.bind(obj, view, R.layout.layout_global_broad11);
    }

    @Deprecated
    public static LayoutGlobalBroad11Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutGlobalBroad11Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_global_broad11, viewGroup, z, obj);
    }

    public static LayoutGlobalBroad11Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutGlobalBroad11Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutGlobalBroad11Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_global_broad11, (ViewGroup) null, false, obj);
    }
}
