package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentBinderBinding extends ViewDataBinding {
    public final AppCompatImageView arrow;
    public final ImageView centerImage;
    public final AppCompatTextView title;
    public final IncludeTitleBinding titleBar;
    public final View topBg;
    public final ConstraintLayout unbindLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentBinderBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, ImageView imageView, AppCompatTextView appCompatTextView, IncludeTitleBinding includeTitleBinding, View view2, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.arrow = appCompatImageView;
        this.centerImage = imageView;
        this.title = appCompatTextView;
        this.titleBar = includeTitleBinding;
        this.topBg = view2;
        this.unbindLayout = constraintLayout;
    }

    public static FragmentBinderBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentBinderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentBinderBinding bind(View view, Object obj) {
        return (FragmentBinderBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_binder);
    }

    @Deprecated
    public static FragmentBinderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBinderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_binder, viewGroup, z, obj);
    }

    public static FragmentBinderBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentBinderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBinderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_binder, (ViewGroup) null, false, obj);
    }
}
