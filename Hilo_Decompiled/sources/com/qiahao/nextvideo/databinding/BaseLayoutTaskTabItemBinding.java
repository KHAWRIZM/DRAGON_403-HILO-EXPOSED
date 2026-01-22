package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseLayoutTaskTabItemBinding extends ViewDataBinding {
    public final ImageView bg;
    public final ImageView lockIcon;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseLayoutTaskTabItemBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.bg = imageView;
        this.lockIcon = imageView2;
        this.title = textView;
    }

    public static BaseLayoutTaskTabItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static BaseLayoutTaskTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static BaseLayoutTaskTabItemBinding bind(View view, Object obj) {
        return (BaseLayoutTaskTabItemBinding) ViewDataBinding.bind(obj, view, R.layout.base_layout_task_tab_item);
    }

    @Deprecated
    public static BaseLayoutTaskTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseLayoutTaskTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_task_tab_item, viewGroup, z, obj);
    }

    public static BaseLayoutTaskTabItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static BaseLayoutTaskTabItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseLayoutTaskTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_task_tab_item, (ViewGroup) null, false, obj);
    }
}
