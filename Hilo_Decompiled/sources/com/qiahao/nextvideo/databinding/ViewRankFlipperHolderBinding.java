package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewRankFlipperHolderBinding extends ViewDataBinding {
    public final ConstraintLayout container;
    public final FrameLayout flTop1;
    public final FrameLayout flTop2;
    public final FrameLayout flTop3;
    public final QMUIRadiusImageView top1Avatar;
    public final QMUIRadiusImageView top2Avatar;
    public final QMUIRadiusImageView top3Avatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewRankFlipperHolderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, QMUIRadiusImageView qMUIRadiusImageView3) {
        super(obj, view, i);
        this.container = constraintLayout;
        this.flTop1 = frameLayout;
        this.flTop2 = frameLayout2;
        this.flTop3 = frameLayout3;
        this.top1Avatar = qMUIRadiusImageView;
        this.top2Avatar = qMUIRadiusImageView2;
        this.top3Avatar = qMUIRadiusImageView3;
    }

    public static ViewRankFlipperHolderBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewRankFlipperHolderBinding bind(View view, Object obj) {
        return (ViewRankFlipperHolderBinding) ViewDataBinding.bind(obj, view, R.layout.view_rank_flipper_holder);
    }

    @Deprecated
    public static ViewRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewRankFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_rank_flipper_holder, viewGroup, z, obj);
    }

    public static ViewRankFlipperHolderBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewRankFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_rank_flipper_holder, (ViewGroup) null, false, obj);
    }
}
