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
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentFamilyStarChildBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final ImageView diamondImage1;
    public final ImageView diamondImage2;
    public final ImageView diamondImage3;
    public final LinearLayout llDiamond1;
    public final LinearLayout llDiamond2;
    public final LinearLayout llDiamond3;
    public final LinearLayout llTop1;
    public final LinearLayout llTop2;
    public final LinearLayout llTop3;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout smartRefreshLayout;
    public final SuperStatusView statusView;
    public final CircleImageView top1Avatar;
    public final TextView top1Diamond;
    public final ShineTextView top1Id;
    public final TextView top1Name;
    public final CircleImageView top2Avatar;
    public final TextView top2Diamond;
    public final ShineTextView top2Id;
    public final TextView top2Name;
    public final CircleImageView top3Avatar;
    public final TextView top3Diamond;
    public final ShineTextView top3Id;
    public final TextView top3Name;
    public final ImageView top3Platform;
    public final ImageView topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentFamilyStarChildBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, CircleImageView circleImageView, TextView textView, ShineTextView shineTextView, TextView textView2, CircleImageView circleImageView2, TextView textView3, ShineTextView shineTextView2, TextView textView4, CircleImageView circleImageView3, TextView textView5, ShineTextView shineTextView3, TextView textView6, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.diamondImage1 = imageView;
        this.diamondImage2 = imageView2;
        this.diamondImage3 = imageView3;
        this.llDiamond1 = linearLayout;
        this.llDiamond2 = linearLayout2;
        this.llDiamond3 = linearLayout3;
        this.llTop1 = linearLayout4;
        this.llTop2 = linearLayout5;
        this.llTop3 = linearLayout6;
        this.recyclerView = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.top1Avatar = circleImageView;
        this.top1Diamond = textView;
        this.top1Id = shineTextView;
        this.top1Name = textView2;
        this.top2Avatar = circleImageView2;
        this.top2Diamond = textView3;
        this.top2Id = shineTextView2;
        this.top2Name = textView4;
        this.top3Avatar = circleImageView3;
        this.top3Diamond = textView5;
        this.top3Id = shineTextView3;
        this.top3Name = textView6;
        this.top3Platform = imageView4;
        this.topBg = imageView5;
    }

    public static FragmentFamilyStarChildBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentFamilyStarChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentFamilyStarChildBinding bind(View view, Object obj) {
        return (FragmentFamilyStarChildBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_family_star_child);
    }

    @Deprecated
    public static FragmentFamilyStarChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFamilyStarChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_star_child, viewGroup, z, obj);
    }

    public static FragmentFamilyStarChildBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentFamilyStarChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFamilyStarChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_star_child, (ViewGroup) null, false, obj);
    }
}
