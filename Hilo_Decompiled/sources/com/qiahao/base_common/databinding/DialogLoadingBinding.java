package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogLoadingBinding extends ViewDataBinding {
    public final TextView loading;
    public final ProgressBar progressBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLoadingBinding(Object obj, View view, int i10, TextView textView, ProgressBar progressBar) {
        super(obj, view, i10);
        this.loading = textView;
        this.progressBar = progressBar;
    }

    public static DialogLoadingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogLoadingBinding bind(View view, Object obj) {
        return (DialogLoadingBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_loading);
    }

    @Deprecated
    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_loading, viewGroup, z10, obj);
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLoadingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_loading, null, false, obj);
    }
}
