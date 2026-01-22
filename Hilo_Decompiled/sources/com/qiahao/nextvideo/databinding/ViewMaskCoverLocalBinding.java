package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewMaskCoverLocalBinding extends ViewDataBinding {
    public final AppCompatImageView backgroundImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewMaskCoverLocalBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.backgroundImageView = appCompatImageView;
    }

    public static ViewMaskCoverLocalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewMaskCoverLocalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewMaskCoverLocalBinding bind(View view, Object obj) {
        return (ViewMaskCoverLocalBinding) ViewDataBinding.bind(obj, view, R.layout.view_mask_cover_local);
    }

    @Deprecated
    public static ViewMaskCoverLocalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewMaskCoverLocalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_mask_cover_local, viewGroup, z, obj);
    }

    public static ViewMaskCoverLocalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewMaskCoverLocalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewMaskCoverLocalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_mask_cover_local, (ViewGroup) null, false, obj);
    }
}
