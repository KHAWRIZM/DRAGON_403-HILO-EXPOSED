package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class TabLayoutTextBinding extends ViewDataBinding {
    public final TextView textView;

    /* JADX INFO: Access modifiers changed from: protected */
    public TabLayoutTextBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.textView = textView;
    }

    public static TabLayoutTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static TabLayoutTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static TabLayoutTextBinding bind(View view, Object obj) {
        return (TabLayoutTextBinding) ViewDataBinding.bind(obj, view, R.layout.tab_layout_text);
    }

    @Deprecated
    public static TabLayoutTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TabLayoutTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.tab_layout_text, viewGroup, z, obj);
    }

    public static TabLayoutTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static TabLayoutTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TabLayoutTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.tab_layout_text, (ViewGroup) null, false, obj);
    }
}
