package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewPkSearchBinding extends ViewDataBinding {
    public final ConstraintLayout rootLayout;
    public final ImageView search;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewPkSearchBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, i);
        this.rootLayout = constraintLayout;
        this.search = imageView;
    }

    public static ViewPkSearchBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewPkSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewPkSearchBinding bind(View view, Object obj) {
        return (ViewPkSearchBinding) ViewDataBinding.bind(obj, view, R.layout.view_pk_search);
    }

    @Deprecated
    public static ViewPkSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewPkSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_pk_search, viewGroup, z, obj);
    }

    public static ViewPkSearchBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewPkSearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewPkSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_pk_search, (ViewGroup) null, false, obj);
    }
}
