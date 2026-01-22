package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewPowerRankFlipperHolderBinding extends ViewDataBinding {
    public final ConstraintLayout container;
    public final ConstraintLayout flTop1;
    public final ConstraintLayout flTop2;
    public final ConstraintLayout flTop3;
    public final PolygonImageView top1Avatar;
    public final PolygonImageView top2Avatar;
    public final PolygonImageView top3Avatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewPowerRankFlipperHolderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, PolygonImageView polygonImageView, PolygonImageView polygonImageView2, PolygonImageView polygonImageView3) {
        super(obj, view, i);
        this.container = constraintLayout;
        this.flTop1 = constraintLayout2;
        this.flTop2 = constraintLayout3;
        this.flTop3 = constraintLayout4;
        this.top1Avatar = polygonImageView;
        this.top2Avatar = polygonImageView2;
        this.top3Avatar = polygonImageView3;
    }

    public static ViewPowerRankFlipperHolderBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewPowerRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewPowerRankFlipperHolderBinding bind(View view, Object obj) {
        return (ViewPowerRankFlipperHolderBinding) ViewDataBinding.bind(obj, view, R.layout.view_power_rank_flipper_holder);
    }

    @Deprecated
    public static ViewPowerRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewPowerRankFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_power_rank_flipper_holder, viewGroup, z, obj);
    }

    public static ViewPowerRankFlipperHolderBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewPowerRankFlipperHolderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewPowerRankFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_power_rank_flipper_holder, (ViewGroup) null, false, obj);
    }
}
