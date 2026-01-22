package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySupportGiftRankBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final AppCompatTextView emptyTipTextView;
    public final ImageView icQuestion;
    public final ImageView iconNoble1;
    public final ImageView iconNoble2;
    public final ImageView iconNoble3;
    public final ImageView iconVip1;
    public final ImageView iconVip2;
    public final ImageView iconVip3;
    public final LinearLayout llContentTop1;
    public final LinearLayout llContentTop2;
    public final LinearLayout llContentTop3;
    public final LinearLayout llDiamond1;
    public final LinearLayout llDiamond2;
    public final LinearLayout llDiamond3;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerRank;
    public final SmartRefreshLayout smartRefreshLayout;
    public final ImageView svip1;
    public final ImageView svip2;
    public final ImageView svip3;
    public final AppCompatTextView titleTextView;
    public final Toolbar toolbar;
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
    public ActivitySupportGiftRankBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ImageView imageView8, ImageView imageView9, ImageView imageView10, AppCompatTextView appCompatTextView2, Toolbar toolbar, CircleImageView circleImageView, TextView textView, ShineTextView shineTextView, MedalGridLayout medalGridLayout, TextView textView2, CircleImageView circleImageView2, TextView textView3, ShineTextView shineTextView2, MedalGridLayout medalGridLayout2, TextView textView4, CircleImageView circleImageView3, TextView textView5, ShineTextView shineTextView3, MedalGridLayout medalGridLayout3, TextView textView6) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.emptyTipTextView = appCompatTextView;
        this.icQuestion = imageView;
        this.iconNoble1 = imageView2;
        this.iconNoble2 = imageView3;
        this.iconNoble3 = imageView4;
        this.iconVip1 = imageView5;
        this.iconVip2 = imageView6;
        this.iconVip3 = imageView7;
        this.llContentTop1 = linearLayout;
        this.llContentTop2 = linearLayout2;
        this.llContentTop3 = linearLayout3;
        this.llDiamond1 = linearLayout4;
        this.llDiamond2 = linearLayout5;
        this.llDiamond3 = linearLayout6;
        this.recyclerRank = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.svip1 = imageView8;
        this.svip2 = imageView9;
        this.svip3 = imageView10;
        this.titleTextView = appCompatTextView2;
        this.toolbar = toolbar;
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

    public static ActivitySupportGiftRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySupportGiftRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivitySupportGiftRankBinding bind(View view, Object obj) {
        return (ActivitySupportGiftRankBinding) ViewDataBinding.bind(obj, view, R.layout.activity_support_gift_rank);
    }

    @Deprecated
    public static ActivitySupportGiftRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySupportGiftRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_support_gift_rank, viewGroup, z, obj);
    }

    public static ActivitySupportGiftRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySupportGiftRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySupportGiftRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_support_gift_rank, (ViewGroup) null, false, obj);
    }
}
