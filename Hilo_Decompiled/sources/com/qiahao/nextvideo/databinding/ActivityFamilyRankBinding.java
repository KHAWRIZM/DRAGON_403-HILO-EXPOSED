package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HiloTabLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFamilyRankBinding extends ViewDataBinding {
    public final AppCompatImageView activityImage;
    public final FrameLayout activityMainContainer;
    public final PolygonImageView avatar;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final ConstraintLayout constraintLayout;
    public final TextView diamond;
    public final AppCompatImageView helperImage;
    public final LinearLayoutCompat linearLayout;
    public final LinearLayout llDiamond;
    public final ConstraintLayout myFamily;
    public final IncludeFamilyNamePlateBinding namePlate;
    public final TextView position;
    public final HiloTabLayout tabLayout;
    public final AppCompatTextView title;
    public final TextView userName;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilyRankBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, FrameLayout frameLayout, PolygonImageView polygonImageView, AppCompatImageView appCompatImageView2, View view2, ConstraintLayout constraintLayout, TextView textView, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat, LinearLayout linearLayout, ConstraintLayout constraintLayout2, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, TextView textView2, HiloTabLayout hiloTabLayout, AppCompatTextView appCompatTextView, TextView textView3, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityImage = appCompatImageView;
        this.activityMainContainer = frameLayout;
        this.avatar = polygonImageView;
        this.backImageView = appCompatImageView2;
        this.bar = view2;
        this.constraintLayout = constraintLayout;
        this.diamond = textView;
        this.helperImage = appCompatImageView3;
        this.linearLayout = linearLayoutCompat;
        this.llDiamond = linearLayout;
        this.myFamily = constraintLayout2;
        this.namePlate = includeFamilyNamePlateBinding;
        this.position = textView2;
        this.tabLayout = hiloTabLayout;
        this.title = appCompatTextView;
        this.userName = textView3;
        this.viewPage = viewPager2;
    }

    public static ActivityFamilyRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilyRankBinding bind(View view, Object obj) {
        return (ActivityFamilyRankBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_rank);
    }

    @Deprecated
    public static ActivityFamilyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_rank, viewGroup, z, obj);
    }

    public static ActivityFamilyRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilyRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_rank, (ViewGroup) null, false, obj);
    }
}
