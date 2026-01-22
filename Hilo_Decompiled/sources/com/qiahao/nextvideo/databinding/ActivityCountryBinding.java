package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityCountryBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final AppCompatTextView emptyTipTextView;
    public final ImageView icQuestion;
    public final ImageView iconNoble1;
    public final ImageView iconNoble2;
    public final ImageView iconNoble3;
    public final ImageView iconVip1;
    public final ImageView iconVip2;
    public final ImageView iconVip3;
    public final ConstraintLayout llTop1;
    public final ConstraintLayout llTop2;
    public final ConstraintLayout llTop3;
    public final SuperStatusView statusView;
    public final ImageView svip1;
    public final ImageView svip2;
    public final ImageView svip3;
    public final AppCompatTextView title;
    public final Toolbar toolbar;
    public final HiloImageView top1Avatar;
    public final ShineTextView top1Id;
    public final MedalGridLayout top1Medal;
    public final TextView top1Name;
    public final HiloImageView top2Avatar;
    public final ShineTextView top2Id;
    public final MedalGridLayout top2Medal;
    public final TextView top2Name;
    public final HiloImageView top3Avatar;
    public final ShineTextView top3Id;
    public final MedalGridLayout top3Medal;
    public final TextView top3Name;
    public final ConstraintLayout topContainer1;
    public final ConstraintLayout topContainer2;
    public final ConstraintLayout topContainer3;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCountryBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, CollapsingToolbarLayout collapsingToolbarLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, SuperStatusView superStatusView, ImageView imageView8, ImageView imageView9, ImageView imageView10, AppCompatTextView appCompatTextView2, Toolbar toolbar, HiloImageView hiloImageView, ShineTextView shineTextView, MedalGridLayout medalGridLayout, TextView textView, HiloImageView hiloImageView2, ShineTextView shineTextView2, MedalGridLayout medalGridLayout2, TextView textView2, HiloImageView hiloImageView3, ShineTextView shineTextView3, MedalGridLayout medalGridLayout3, TextView textView3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.emptyTipTextView = appCompatTextView;
        this.icQuestion = imageView;
        this.iconNoble1 = imageView2;
        this.iconNoble2 = imageView3;
        this.iconNoble3 = imageView4;
        this.iconVip1 = imageView5;
        this.iconVip2 = imageView6;
        this.iconVip3 = imageView7;
        this.llTop1 = constraintLayout;
        this.llTop2 = constraintLayout2;
        this.llTop3 = constraintLayout3;
        this.statusView = superStatusView;
        this.svip1 = imageView8;
        this.svip2 = imageView9;
        this.svip3 = imageView10;
        this.title = appCompatTextView2;
        this.toolbar = toolbar;
        this.top1Avatar = hiloImageView;
        this.top1Id = shineTextView;
        this.top1Medal = medalGridLayout;
        this.top1Name = textView;
        this.top2Avatar = hiloImageView2;
        this.top2Id = shineTextView2;
        this.top2Medal = medalGridLayout2;
        this.top2Name = textView2;
        this.top3Avatar = hiloImageView3;
        this.top3Id = shineTextView3;
        this.top3Medal = medalGridLayout3;
        this.top3Name = textView3;
        this.topContainer1 = constraintLayout4;
        this.topContainer2 = constraintLayout5;
        this.topContainer3 = constraintLayout6;
    }

    public static ActivityCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityCountryBinding bind(View view, Object obj) {
        return (ActivityCountryBinding) ViewDataBinding.bind(obj, view, R.layout.activity_country);
    }

    @Deprecated
    public static ActivityCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_country, viewGroup, z, obj);
    }

    public static ActivityCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_country, (ViewGroup) null, false, obj);
    }
}
