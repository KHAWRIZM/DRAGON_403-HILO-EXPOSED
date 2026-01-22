package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewCpRankFlipperHolderBinding extends ViewDataBinding {
    public final ConstraintLayout container;
    public final QMUIRadiusImageView userAvatar1;
    public final QMUIRadiusImageView userAvatar2;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewCpRankFlipperHolderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2) {
        super(obj, view, i);
        this.container = constraintLayout;
        this.userAvatar1 = qMUIRadiusImageView;
        this.userAvatar2 = qMUIRadiusImageView2;
    }

    public static ViewCpRankFlipperHolderBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewCpRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewCpRankFlipperHolderBinding bind(View view, Object obj) {
        return (ViewCpRankFlipperHolderBinding) ViewDataBinding.bind(obj, view, R.layout.view_cp_rank_flipper_holder);
    }

    @Deprecated
    public static ViewCpRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewCpRankFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_cp_rank_flipper_holder, viewGroup, z, obj);
    }

    public static ViewCpRankFlipperHolderBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewCpRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewCpRankFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_cp_rank_flipper_holder, (ViewGroup) null, false, obj);
    }
}
