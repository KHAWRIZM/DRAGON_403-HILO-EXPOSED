package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LayoutPowerRankWeekBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final AppCompatTextView emptyTipTextView;
    public final ImageView iconNoble1;
    public final ImageView iconNoble2;
    public final ImageView iconNoble3;
    public final ImageView iconVip1;
    public final ImageView iconVip2;
    public final ImageView iconVip3;
    public final LinearLayout llDiamond1;
    public final LinearLayout llDiamond2;
    public final LinearLayout llDiamond3;
    public final LinearLayout llTop1;
    public final LinearLayout llTop2;
    public final LinearLayout llTop3;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout smartRefreshLayout;
    public final ImageView svip1;
    public final ImageView svip2;
    public final ImageView svip3;
    public final CircleImageView top1Avatar;
    public final TextView top1Diamond;
    public final ShineTextView top1Id;
    public final MedalGridLayout top1Medal;
    public final TextView top1Name;
    public final CircleImageView top2Avatar;
    public final TextView top2Diamond;
    public final ShineTextView top2Id;
    public final MedalGridLayout top2Medal;
    public final TextView top2Name;
    public final CircleImageView top3Avatar;
    public final TextView top3Diamond;
    public final ShineTextView top3Id;
    public final MedalGridLayout top3Medal;
    public final TextView top3Name;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutPowerRankWeekBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, AppCompatTextView appCompatTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ImageView imageView7, ImageView imageView8, ImageView imageView9, CircleImageView circleImageView, TextView textView, ShineTextView shineTextView, MedalGridLayout medalGridLayout, TextView textView2, CircleImageView circleImageView2, TextView textView3, ShineTextView shineTextView2, MedalGridLayout medalGridLayout2, TextView textView4, CircleImageView circleImageView3, TextView textView5, ShineTextView shineTextView3, MedalGridLayout medalGridLayout3, TextView textView6) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.emptyTipTextView = appCompatTextView;
        this.iconNoble1 = imageView;
        this.iconNoble2 = imageView2;
        this.iconNoble3 = imageView3;
        this.iconVip1 = imageView4;
        this.iconVip2 = imageView5;
        this.iconVip3 = imageView6;
        this.llDiamond1 = linearLayout;
        this.llDiamond2 = linearLayout2;
        this.llDiamond3 = linearLayout3;
        this.llTop1 = linearLayout4;
        this.llTop2 = linearLayout5;
        this.llTop3 = linearLayout6;
        this.recyclerView = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.svip1 = imageView7;
        this.svip2 = imageView8;
        this.svip3 = imageView9;
        this.top1Avatar = circleImageView;
        this.top1Diamond = textView;
        this.top1Id = shineTextView;
        this.top1Medal = medalGridLayout;
        this.top1Name = textView2;
        this.top2Avatar = circleImageView2;
        this.top2Diamond = textView3;
        this.top2Id = shineTextView2;
        this.top2Medal = medalGridLayout2;
        this.top2Name = textView4;
        this.top3Avatar = circleImageView3;
        this.top3Diamond = textView5;
        this.top3Id = shineTextView3;
        this.top3Medal = medalGridLayout3;
        this.top3Name = textView6;
    }

    public static LayoutPowerRankWeekBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutPowerRankWeekBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static LayoutPowerRankWeekBinding bind(View view, Object obj) {
        return (LayoutPowerRankWeekBinding) ViewDataBinding.bind(obj, view, R.layout.layout_power_rank_week);
    }

    @Deprecated
    public static LayoutPowerRankWeekBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutPowerRankWeekBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_power_rank_week, viewGroup, z, obj);
    }

    public static LayoutPowerRankWeekBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutPowerRankWeekBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutPowerRankWeekBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_power_rank_week, (ViewGroup) null, false, obj);
    }
}
