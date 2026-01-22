package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.HomeRoomBannerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeRoomBinding extends ViewDataBinding {
    public final HomeRoomBannerView banner;
    public final View bottomView;
    public final ConstraintLayout container;
    public final ImageView search;
    public final SlidingTabLayout tabLayout;
    public final ConstraintLayout title;
    public final ImageView topBg;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeRoomBinding(Object obj, View view, int i, HomeRoomBannerView homeRoomBannerView, View view2, ConstraintLayout constraintLayout, ImageView imageView, SlidingTabLayout slidingTabLayout, ConstraintLayout constraintLayout2, ImageView imageView2, ViewPager viewPager) {
        super(obj, view, i);
        this.banner = homeRoomBannerView;
        this.bottomView = view2;
        this.container = constraintLayout;
        this.search = imageView;
        this.tabLayout = slidingTabLayout;
        this.title = constraintLayout2;
        this.topBg = imageView2;
        this.viewPager = viewPager;
    }

    public static FragmentHomeRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeRoomBinding bind(View view, Object obj) {
        return (FragmentHomeRoomBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home_room);
    }

    @Deprecated
    public static FragmentHomeRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_room, viewGroup, z, obj);
    }

    public static FragmentHomeRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_room, (ViewGroup) null, false, obj);
    }
}
