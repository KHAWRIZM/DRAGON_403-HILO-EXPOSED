package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CustomFooterBinding extends ViewDataBinding {
    public final LinearLayout linearLayout;
    public final ProgressBar progressBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public CustomFooterBinding(Object obj, View view, int i, LinearLayout linearLayout, ProgressBar progressBar) {
        super(obj, view, i);
        this.linearLayout = linearLayout;
        this.progressBar = progressBar;
    }

    public static CustomFooterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CustomFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CustomFooterBinding bind(View view, Object obj) {
        return (CustomFooterBinding) ViewDataBinding.bind(obj, view, R.layout.custom_footer);
    }

    @Deprecated
    public static CustomFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CustomFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.custom_footer, viewGroup, z, obj);
    }

    public static CustomFooterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CustomFooterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CustomFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.custom_footer, (ViewGroup) null, false, obj);
    }
}
