package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewHorizontalInteractiveBinding extends ViewDataBinding {
    public final ProgressBar cellLoadingProgressBar;
    public final RecyclerView horizontalRecyclerView;
    public final TextView interactiveText;
    public final TextView messageText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewHorizontalInteractiveBinding(Object obj, View view, int i, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.cellLoadingProgressBar = progressBar;
        this.horizontalRecyclerView = recyclerView;
        this.interactiveText = textView;
        this.messageText = textView2;
    }

    public static ViewHorizontalInteractiveBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewHorizontalInteractiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewHorizontalInteractiveBinding bind(View view, Object obj) {
        return (ViewHorizontalInteractiveBinding) ViewDataBinding.bind(obj, view, R.layout.view_horizontal_interactive);
    }

    @Deprecated
    public static ViewHorizontalInteractiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewHorizontalInteractiveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_horizontal_interactive, viewGroup, z, obj);
    }

    public static ViewHorizontalInteractiveBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewHorizontalInteractiveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewHorizontalInteractiveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_horizontal_interactive, (ViewGroup) null, false, obj);
    }
}
