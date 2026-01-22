package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.home.discover.DiscoverBroadCastView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentDiscoverHeadBinding extends ViewDataBinding {
    public final FrameLayout activityLayout;
    public final RecyclerView activityRecycler;
    public final ViewFlipper allRankFlipper;
    public final LinearLayout broadCastMore;
    public final ConstraintLayout clCountry;
    public final ConstraintLayout constraintGift;
    public final ImageView countryBgTop1;
    public final ImageView countryBgTop2;
    public final ImageView countryBgTop3;
    public final FrameLayout countryFrameLayout;
    public final ImageView countryImage;
    public final LinearLayout countryLayout;
    public final TextView countryMore;
    public final TextView countryName;
    public final CircleImageView countryTop1;
    public final CircleImageView countryTop2;
    public final CircleImageView countryTop3;
    public final ViewFlipper cpRankFlipper;
    public final TextView cpRankText;
    public final DiscoverBroadCastView discoverBroadCast;
    public final RecyclerView discoverCountryRecycler;
    public final BaseStatusEmptyBinding empty;
    public final TextView event;
    public final ViewFlipper giftWallFlipper;
    public final ConstraintLayout llCp;
    public final ConstraintLayout llFamous;
    public final ConstraintLayout llPower;
    public final TextView more;
    public final LinearLayout moreLayout;
    public final ViewFlipper powerRankFlipper;
    public final TextView powerTip;
    public final TextView rankText;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentDiscoverHeadBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, ViewFlipper viewFlipper, LinearLayout linearLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout2, ImageView imageView4, LinearLayout linearLayout2, TextView textView, TextView textView2, CircleImageView circleImageView, CircleImageView circleImageView2, CircleImageView circleImageView3, ViewFlipper viewFlipper2, TextView textView3, DiscoverBroadCastView discoverBroadCastView, RecyclerView recyclerView2, BaseStatusEmptyBinding baseStatusEmptyBinding, TextView textView4, ViewFlipper viewFlipper3, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView5, LinearLayout linearLayout3, ViewFlipper viewFlipper4, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.activityLayout = frameLayout;
        this.activityRecycler = recyclerView;
        this.allRankFlipper = viewFlipper;
        this.broadCastMore = linearLayout;
        this.clCountry = constraintLayout;
        this.constraintGift = constraintLayout2;
        this.countryBgTop1 = imageView;
        this.countryBgTop2 = imageView2;
        this.countryBgTop3 = imageView3;
        this.countryFrameLayout = frameLayout2;
        this.countryImage = imageView4;
        this.countryLayout = linearLayout2;
        this.countryMore = textView;
        this.countryName = textView2;
        this.countryTop1 = circleImageView;
        this.countryTop2 = circleImageView2;
        this.countryTop3 = circleImageView3;
        this.cpRankFlipper = viewFlipper2;
        this.cpRankText = textView3;
        this.discoverBroadCast = discoverBroadCastView;
        this.discoverCountryRecycler = recyclerView2;
        this.empty = baseStatusEmptyBinding;
        this.event = textView4;
        this.giftWallFlipper = viewFlipper3;
        this.llCp = constraintLayout3;
        this.llFamous = constraintLayout4;
        this.llPower = constraintLayout5;
        this.more = textView5;
        this.moreLayout = linearLayout3;
        this.powerRankFlipper = viewFlipper4;
        this.powerTip = textView6;
        this.rankText = textView7;
    }

    public static FragmentDiscoverHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentDiscoverHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentDiscoverHeadBinding bind(View view, Object obj) {
        return (FragmentDiscoverHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_discover_head);
    }

    @Deprecated
    public static FragmentDiscoverHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDiscoverHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_discover_head, viewGroup, z, obj);
    }

    public static FragmentDiscoverHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentDiscoverHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDiscoverHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_discover_head, (ViewGroup) null, false, obj);
    }
}
