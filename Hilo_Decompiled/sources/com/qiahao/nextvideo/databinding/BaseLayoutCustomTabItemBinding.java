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
public abstract class BaseLayoutCustomTabItemBinding extends ViewDataBinding {
    public final ImageView ivIcon;
    public final TextView redNumber;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseLayoutCustomTabItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivIcon = imageView;
        this.redNumber = textView;
        this.title = textView2;
    }

    public static BaseLayoutCustomTabItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static BaseLayoutCustomTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static BaseLayoutCustomTabItemBinding bind(View view, Object obj) {
        return (BaseLayoutCustomTabItemBinding) ViewDataBinding.bind(obj, view, R.layout.base_layout_custom_tab_item);
    }

    @Deprecated
    public static BaseLayoutCustomTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseLayoutCustomTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_custom_tab_item, viewGroup, z, obj);
    }

    public static BaseLayoutCustomTabItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static BaseLayoutCustomTabItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseLayoutCustomTabItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_layout_custom_tab_item, (ViewGroup) null, false, obj);
    }
}
