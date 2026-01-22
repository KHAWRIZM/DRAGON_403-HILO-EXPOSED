package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class ViewTabLayoutTitleBinding extends ViewDataBinding {
    public final TextView content;
    public final TextView redPoint;
    public final ConstraintLayout root;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewTabLayoutTitleBinding(Object obj, View view, int i10, TextView textView, TextView textView2, ConstraintLayout constraintLayout) {
        super(obj, view, i10);
        this.content = textView;
        this.redPoint = textView2;
        this.root = constraintLayout;
    }

    public static ViewTabLayoutTitleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewTabLayoutTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static ViewTabLayoutTitleBinding bind(View view, Object obj) {
        return (ViewTabLayoutTitleBinding) ViewDataBinding.bind(obj, view, R.layout.view_tab_layout_title);
    }

    @Deprecated
    public static ViewTabLayoutTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (ViewTabLayoutTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_tab_layout_title, viewGroup, z10, obj);
    }

    public static ViewTabLayoutTitleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewTabLayoutTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewTabLayoutTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_tab_layout_title, null, false, obj);
    }
}
