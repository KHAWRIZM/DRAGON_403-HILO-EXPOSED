package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeMainActivityItemBinding extends ViewDataBinding {
    public final View bg;
    public final ConstraintLayout constraintLayout;
    public final ImageView dataImage;
    public final ImageView icon;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeMainActivityItemBinding(Object obj, View view, int i, View view2, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.bg = view2;
        this.constraintLayout = constraintLayout;
        this.dataImage = imageView;
        this.icon = imageView2;
        this.title = textView;
    }

    public static IncludeMainActivityItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeMainActivityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeMainActivityItemBinding bind(View view, Object obj) {
        return (IncludeMainActivityItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_main_activity_item);
    }

    @Deprecated
    public static IncludeMainActivityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeMainActivityItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_main_activity_item, viewGroup, z, obj);
    }

    public static IncludeMainActivityItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeMainActivityItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeMainActivityItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_main_activity_item, (ViewGroup) null, false, obj);
    }
}
