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
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentFamilyRankBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final PolygonImageView rankAvatar1;
    public final PolygonImageView rankAvatar2;
    public final PolygonImageView rankAvatar3;
    public final ImageView rankBg1;
    public final ImageView rankBg2;
    public final ImageView rankBg3;
    public final ImageView rankHeader1;
    public final ImageView rankHeader2;
    public final ImageView rankHeader3;
    public final TextView rankName1;
    public final TextView rankName2;
    public final TextView rankName3;
    public final IncludeFamilyNamePlateBinding rankNamePlate1;
    public final IncludeFamilyNamePlateBinding rankNamePlate2;
    public final IncludeFamilyNamePlateBinding rankNamePlate3;
    public final TextView rankNumber1;
    public final TextView rankNumber2;
    public final TextView rankNumber3;
    public final LinearLayout rankNumberLayout1;
    public final LinearLayout rankNumberLayout2;
    public final LinearLayout rankNumberLayout3;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout smartRefreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentFamilyRankBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, PolygonImageView polygonImageView, PolygonImageView polygonImageView2, PolygonImageView polygonImageView3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, TextView textView3, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding2, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.rankAvatar1 = polygonImageView;
        this.rankAvatar2 = polygonImageView2;
        this.rankAvatar3 = polygonImageView3;
        this.rankBg1 = imageView;
        this.rankBg2 = imageView2;
        this.rankBg3 = imageView3;
        this.rankHeader1 = imageView4;
        this.rankHeader2 = imageView5;
        this.rankHeader3 = imageView6;
        this.rankName1 = textView;
        this.rankName2 = textView2;
        this.rankName3 = textView3;
        this.rankNamePlate1 = includeFamilyNamePlateBinding;
        this.rankNamePlate2 = includeFamilyNamePlateBinding2;
        this.rankNamePlate3 = includeFamilyNamePlateBinding3;
        this.rankNumber1 = textView4;
        this.rankNumber2 = textView5;
        this.rankNumber3 = textView6;
        this.rankNumberLayout1 = linearLayout;
        this.rankNumberLayout2 = linearLayout2;
        this.rankNumberLayout3 = linearLayout3;
        this.recyclerView = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static FragmentFamilyRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentFamilyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentFamilyRankBinding bind(View view, Object obj) {
        return (FragmentFamilyRankBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_family_rank);
    }

    @Deprecated
    public static FragmentFamilyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFamilyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_rank, viewGroup, z, obj);
    }

    public static FragmentFamilyRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentFamilyRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFamilyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_family_rank, (ViewGroup) null, false, obj);
    }
}
