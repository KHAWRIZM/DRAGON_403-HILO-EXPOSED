package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerPowerTeamBinding extends ViewDataBinding {
    public final RecyclerView assistantRecycleView;
    public final AppCompatImageView backImageView;
    public final ConstraintLayout bgContent;
    public final ConstraintLayout clMedalWeek;
    public final AppCompatTextView commonIdToolbarTitle;
    public final CommonTabLayout commonTabLayout;
    public final ImageView icQuestion;
    public final RecyclerView ownerRecycleView;
    public final Toolbar toolbar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerPowerTeamBinding(Object obj, View view, int i, RecyclerView recyclerView, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, CommonTabLayout commonTabLayout, ImageView imageView, RecyclerView recyclerView2, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.assistantRecycleView = recyclerView;
        this.backImageView = appCompatImageView;
        this.bgContent = constraintLayout;
        this.clMedalWeek = constraintLayout2;
        this.commonIdToolbarTitle = appCompatTextView;
        this.commonTabLayout = commonTabLayout;
        this.icQuestion = imageView;
        this.ownerRecycleView = recyclerView2;
        this.toolbar = toolbar;
        this.viewPager = viewPager;
    }

    public static ViewControllerPowerTeamBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerPowerTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerPowerTeamBinding bind(View view, Object obj) {
        return (ViewControllerPowerTeamBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_power_team);
    }

    @Deprecated
    public static ViewControllerPowerTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerPowerTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_power_team, viewGroup, z, obj);
    }

    public static ViewControllerPowerTeamBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerPowerTeamBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerPowerTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_power_team, (ViewGroup) null, false, obj);
    }
}
