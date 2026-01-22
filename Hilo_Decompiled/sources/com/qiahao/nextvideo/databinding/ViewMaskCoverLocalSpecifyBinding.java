package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewMaskCoverLocalSpecifyBinding extends ViewDataBinding {
    public final AppCompatImageView backgroundImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewMaskCoverLocalSpecifyBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.backgroundImageView = appCompatImageView;
    }

    public static ViewMaskCoverLocalSpecifyBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewMaskCoverLocalSpecifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewMaskCoverLocalSpecifyBinding bind(View view, Object obj) {
        return (ViewMaskCoverLocalSpecifyBinding) ViewDataBinding.bind(obj, view, R.layout.view_mask_cover_local_specify);
    }

    @Deprecated
    public static ViewMaskCoverLocalSpecifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewMaskCoverLocalSpecifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_mask_cover_local_specify, viewGroup, z, obj);
    }

    public static ViewMaskCoverLocalSpecifyBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewMaskCoverLocalSpecifyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewMaskCoverLocalSpecifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_mask_cover_local_specify, (ViewGroup) null, false, obj);
    }
}
