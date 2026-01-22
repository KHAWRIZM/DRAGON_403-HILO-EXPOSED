package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewMaskCoverRemoteBinding extends ViewDataBinding {
    public final AppCompatImageView backgroundImageView;
    public final AppCompatButton rematchButton;
    public final AppCompatButton removeMaskButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewMaskCoverRemoteBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2) {
        super(obj, view, i);
        this.backgroundImageView = appCompatImageView;
        this.rematchButton = appCompatButton;
        this.removeMaskButton = appCompatButton2;
    }

    public static ViewMaskCoverRemoteBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewMaskCoverRemoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewMaskCoverRemoteBinding bind(View view, Object obj) {
        return (ViewMaskCoverRemoteBinding) ViewDataBinding.bind(obj, view, R.layout.view_mask_cover_remote);
    }

    @Deprecated
    public static ViewMaskCoverRemoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewMaskCoverRemoteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_mask_cover_remote, viewGroup, z, obj);
    }

    public static ViewMaskCoverRemoteBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewMaskCoverRemoteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewMaskCoverRemoteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_mask_cover_remote, (ViewGroup) null, false, obj);
    }
}
