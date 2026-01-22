package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewChildCharmRankDetailBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
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
    public final RecyclerView recyclerRank;
    public final SmartRefreshLayout smartRefreshLayout;
    public final ImageView svip1;
    public final ImageView svip2;
    public final ImageView svip3;
    public final HiloImageView top1Avatar;
    public final TextView top1Diamond;
    public final CountryIDView top1Id;
    public final MedalGridLayout top1Medal;
    public final NickTextView top1Name;
    public final HiloImageView top2Avatar;
    public final TextView top2Diamond;
    public final CountryIDView top2Id;
    public final MedalGridLayout top2Medal;
    public final NickTextView top2Name;
    public final HiloImageView top3Avatar;
    public final TextView top3Diamond;
    public final CountryIDView top3Id;
    public final MedalGridLayout top3Medal;
    public final NickTextView top3Name;
    public final ImageView top3Platform;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewChildCharmRankDetailBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ImageView imageView7, ImageView imageView8, ImageView imageView9, HiloImageView hiloImageView, TextView textView, CountryIDView countryIDView, MedalGridLayout medalGridLayout, NickTextView nickTextView, HiloImageView hiloImageView2, TextView textView2, CountryIDView countryIDView2, MedalGridLayout medalGridLayout2, NickTextView nickTextView2, HiloImageView hiloImageView3, TextView textView3, CountryIDView countryIDView3, MedalGridLayout medalGridLayout3, NickTextView nickTextView3, ImageView imageView10) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
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
        this.recyclerRank = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.svip1 = imageView7;
        this.svip2 = imageView8;
        this.svip3 = imageView9;
        this.top1Avatar = hiloImageView;
        this.top1Diamond = textView;
        this.top1Id = countryIDView;
        this.top1Medal = medalGridLayout;
        this.top1Name = nickTextView;
        this.top2Avatar = hiloImageView2;
        this.top2Diamond = textView2;
        this.top2Id = countryIDView2;
        this.top2Medal = medalGridLayout2;
        this.top2Name = nickTextView2;
        this.top3Avatar = hiloImageView3;
        this.top3Diamond = textView3;
        this.top3Id = countryIDView3;
        this.top3Medal = medalGridLayout3;
        this.top3Name = nickTextView3;
        this.top3Platform = imageView10;
    }

    public static ViewChildCharmRankDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewChildCharmRankDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewChildCharmRankDetailBinding bind(View view, Object obj) {
        return (ViewChildCharmRankDetailBinding) ViewDataBinding.bind(obj, view, R.layout.view_child_charm_rank_detail);
    }

    @Deprecated
    public static ViewChildCharmRankDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewChildCharmRankDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_child_charm_rank_detail, viewGroup, z, obj);
    }

    public static ViewChildCharmRankDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewChildCharmRankDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewChildCharmRankDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_child_charm_rank_detail, (ViewGroup) null, false, obj);
    }
}
