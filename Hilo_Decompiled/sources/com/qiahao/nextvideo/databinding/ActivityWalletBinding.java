package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityWalletBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final LinearLayout bgContent;
    public final AppCompatImageView endImage;
    public final LinearLayoutCompat linearLayout;
    public final ViewPage2TabLayout tabLayout;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityWalletBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, LinearLayout linearLayout, AppCompatImageView appCompatImageView2, LinearLayoutCompat linearLayoutCompat, ViewPage2TabLayout viewPage2TabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.bgContent = linearLayout;
        this.endImage = appCompatImageView2;
        this.linearLayout = linearLayoutCompat;
        this.tabLayout = viewPage2TabLayout;
        this.viewPage = viewPager2;
    }

    public static ActivityWalletBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityWalletBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityWalletBinding bind(View view, Object obj) {
        return (ActivityWalletBinding) ViewDataBinding.bind(obj, view, R.layout.activity_wallet);
    }

    @Deprecated
    public static ActivityWalletBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityWalletBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_wallet, viewGroup, z, obj);
    }

    public static ActivityWalletBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityWalletBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityWalletBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_wallet, (ViewGroup) null, false, obj);
    }
}
