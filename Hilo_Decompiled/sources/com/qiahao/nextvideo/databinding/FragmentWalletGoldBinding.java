package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentWalletGoldBinding extends ViewDataBinding {
    public final BannerViewPager banner;
    public final DiamondTickTextView beansCountTickTextView;
    public final AppCompatTextView contactUsTextView;
    public final ImageView image;
    public final TextView recharge;
    public final RecyclerView recyclerView;
    public final ConstraintLayout topLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWalletGoldBinding(Object obj, View view, int i, BannerViewPager bannerViewPager, DiamondTickTextView diamondTickTextView, AppCompatTextView appCompatTextView, ImageView imageView, TextView textView, RecyclerView recyclerView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.banner = bannerViewPager;
        this.beansCountTickTextView = diamondTickTextView;
        this.contactUsTextView = appCompatTextView;
        this.image = imageView;
        this.recharge = textView;
        this.recyclerView = recyclerView;
        this.topLayout = constraintLayout;
    }

    public static FragmentWalletGoldBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentWalletGoldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentWalletGoldBinding bind(View view, Object obj) {
        return (FragmentWalletGoldBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_wallet_gold);
    }

    @Deprecated
    public static FragmentWalletGoldBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWalletGoldBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wallet_gold, viewGroup, z, obj);
    }

    public static FragmentWalletGoldBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentWalletGoldBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWalletGoldBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wallet_gold, (ViewGroup) null, false, obj);
    }
}
