package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGroupThemesBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView addImageView;
    public final AppCompatImageView backImageView;
    protected View.OnClickListener mClick;
    public final CommonTabLayout tabLayout;
    public final Toolbar titleBar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGroupThemesBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, CommonTabLayout commonTabLayout, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.addImageView = appCompatImageView;
        this.backImageView = appCompatImageView2;
        this.tabLayout = commonTabLayout;
        this.titleBar = toolbar;
        this.viewPager = viewPager;
    }

    public static ActivityGroupThemesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGroupThemesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityGroupThemesBinding bind(View view, Object obj) {
        return (ActivityGroupThemesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_group_themes);
    }

    @Deprecated
    public static ActivityGroupThemesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGroupThemesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_themes, viewGroup, z, obj);
    }

    public static ActivityGroupThemesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGroupThemesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGroupThemesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_themes, (ViewGroup) null, false, obj);
    }
}
