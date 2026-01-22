package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.oudi.widget.CustomTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeCommunityBinding extends ViewDataBinding {
    public final CustomTabLayout communityTabLayout;
    public final ViewPager communityViewPager;
    public final LinearLayout container;
    public final AppCompatImageView postBtn;
    public final ImageView topBg;
    public final ConstraintLayout topNav;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeCommunityBinding(Object obj, View view, int i, CustomTabLayout customTabLayout, ViewPager viewPager, LinearLayout linearLayout, AppCompatImageView appCompatImageView, ImageView imageView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.communityTabLayout = customTabLayout;
        this.communityViewPager = viewPager;
        this.container = linearLayout;
        this.postBtn = appCompatImageView;
        this.topBg = imageView;
        this.topNav = constraintLayout;
    }

    public static FragmentHomeCommunityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeCommunityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeCommunityBinding bind(View view, Object obj) {
        return (FragmentHomeCommunityBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home_community);
    }

    @Deprecated
    public static FragmentHomeCommunityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeCommunityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_community, viewGroup, z, obj);
    }

    public static FragmentHomeCommunityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeCommunityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeCommunityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_community, (ViewGroup) null, false, obj);
    }
}
