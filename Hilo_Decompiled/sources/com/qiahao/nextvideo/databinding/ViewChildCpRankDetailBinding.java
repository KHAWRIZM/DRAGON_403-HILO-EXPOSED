package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewChildCpRankDetailBinding extends ViewDataBinding {
    public final FrameLayout container;
    public final AppCompatTextView emptyTipTextView;
    public final SVGAImageView heartBg;
    public final SVGAImageView heartBg2;
    public final SVGAImageView heartBg3;
    public final ConstraintLayout llTop1;
    public final ConstraintLayout llTop2;
    public final ConstraintLayout llTop3;
    public final RecyclerView recyclerRank;
    public final SmartRefreshLayout smartRefreshLayout;
    public final HiloImageView top1Cp1Avatar;
    public final ImageView top1Cp1Bg;
    public final MedalGridLayout top1Cp1Medal;
    public final ImageView top1Cp1Noble;
    public final TextView top1Cp1UserName;
    public final ImageView top1Cp1Vip;
    public final HiloImageView top1Cp2Avatar;
    public final ImageView top1Cp2Bg;
    public final MedalGridLayout top1Cp2Medal;
    public final ImageView top1Cp2Noble;
    public final TextView top1Cp2UserName;
    public final ImageView top1Cp2Vip;
    public final TextView top1CpValue;
    public final HiloImageView top2Cp1Avatar;
    public final ImageView top2Cp1Bg;
    public final MedalGridLayout top2Cp1Medal;
    public final ImageView top2Cp1Noble;
    public final TextView top2Cp1UserName;
    public final ImageView top2Cp1Vip;
    public final HiloImageView top2Cp2Avatar;
    public final ImageView top2Cp2Bg;
    public final MedalGridLayout top2Cp2Medal;
    public final ImageView top2Cp2Noble;
    public final TextView top2Cp2UserName;
    public final ImageView top2Cp2Vip;
    public final TextView top2CpValue;
    public final HiloImageView top3Cp1Avatar;
    public final ImageView top3Cp1Bg;
    public final MedalGridLayout top3Cp1Medal;
    public final ImageView top3Cp1Noble;
    public final TextView top3Cp1UserName;
    public final ImageView top3Cp1Vip;
    public final HiloImageView top3Cp2Avatar;
    public final ImageView top3Cp2Bg;
    public final MedalGridLayout top3Cp2Medal;
    public final ImageView top3Cp2Noble;
    public final TextView top3Cp2UserName;
    public final ImageView top3Cp2Vip;
    public final TextView top3CpValue;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewChildCpRankDetailBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatTextView appCompatTextView, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, SVGAImageView sVGAImageView3, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, HiloImageView hiloImageView, ImageView imageView, MedalGridLayout medalGridLayout, ImageView imageView2, TextView textView, ImageView imageView3, HiloImageView hiloImageView2, ImageView imageView4, MedalGridLayout medalGridLayout2, ImageView imageView5, TextView textView2, ImageView imageView6, TextView textView3, HiloImageView hiloImageView3, ImageView imageView7, MedalGridLayout medalGridLayout3, ImageView imageView8, TextView textView4, ImageView imageView9, HiloImageView hiloImageView4, ImageView imageView10, MedalGridLayout medalGridLayout4, ImageView imageView11, TextView textView5, ImageView imageView12, TextView textView6, HiloImageView hiloImageView5, ImageView imageView13, MedalGridLayout medalGridLayout5, ImageView imageView14, TextView textView7, ImageView imageView15, HiloImageView hiloImageView6, ImageView imageView16, MedalGridLayout medalGridLayout6, ImageView imageView17, TextView textView8, ImageView imageView18, TextView textView9) {
        super(obj, view, i);
        this.container = frameLayout;
        this.emptyTipTextView = appCompatTextView;
        this.heartBg = sVGAImageView;
        this.heartBg2 = sVGAImageView2;
        this.heartBg3 = sVGAImageView3;
        this.llTop1 = constraintLayout;
        this.llTop2 = constraintLayout2;
        this.llTop3 = constraintLayout3;
        this.recyclerRank = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.top1Cp1Avatar = hiloImageView;
        this.top1Cp1Bg = imageView;
        this.top1Cp1Medal = medalGridLayout;
        this.top1Cp1Noble = imageView2;
        this.top1Cp1UserName = textView;
        this.top1Cp1Vip = imageView3;
        this.top1Cp2Avatar = hiloImageView2;
        this.top1Cp2Bg = imageView4;
        this.top1Cp2Medal = medalGridLayout2;
        this.top1Cp2Noble = imageView5;
        this.top1Cp2UserName = textView2;
        this.top1Cp2Vip = imageView6;
        this.top1CpValue = textView3;
        this.top2Cp1Avatar = hiloImageView3;
        this.top2Cp1Bg = imageView7;
        this.top2Cp1Medal = medalGridLayout3;
        this.top2Cp1Noble = imageView8;
        this.top2Cp1UserName = textView4;
        this.top2Cp1Vip = imageView9;
        this.top2Cp2Avatar = hiloImageView4;
        this.top2Cp2Bg = imageView10;
        this.top2Cp2Medal = medalGridLayout4;
        this.top2Cp2Noble = imageView11;
        this.top2Cp2UserName = textView5;
        this.top2Cp2Vip = imageView12;
        this.top2CpValue = textView6;
        this.top3Cp1Avatar = hiloImageView5;
        this.top3Cp1Bg = imageView13;
        this.top3Cp1Medal = medalGridLayout5;
        this.top3Cp1Noble = imageView14;
        this.top3Cp1UserName = textView7;
        this.top3Cp1Vip = imageView15;
        this.top3Cp2Avatar = hiloImageView6;
        this.top3Cp2Bg = imageView16;
        this.top3Cp2Medal = medalGridLayout6;
        this.top3Cp2Noble = imageView17;
        this.top3Cp2UserName = textView8;
        this.top3Cp2Vip = imageView18;
        this.top3CpValue = textView9;
    }

    public static ViewChildCpRankDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewChildCpRankDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewChildCpRankDetailBinding bind(View view, Object obj) {
        return (ViewChildCpRankDetailBinding) ViewDataBinding.bind(obj, view, R.layout.view_child_cp_rank_detail);
    }

    @Deprecated
    public static ViewChildCpRankDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewChildCpRankDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_child_cp_rank_detail, viewGroup, z, obj);
    }

    public static ViewChildCpRankDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewChildCpRankDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewChildCpRankDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_child_cp_rank_detail, (ViewGroup) null, false, obj);
    }
}
