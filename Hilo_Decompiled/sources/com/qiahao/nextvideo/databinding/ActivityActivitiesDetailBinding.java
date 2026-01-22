package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityActivitiesDetailBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final FrameLayout buttonLayout;
    public final QMUIRadiusImageView2 centerImage;
    public final ConstraintLayout centerLayout;
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final CoordinatorLayout commonIdContentContainer;
    public final AppCompatTextView content;
    public final TextView go;
    public final QMUIRadiusImageView2 headerImage;
    public final TextView idText;
    public final LinearLayout interested;
    public final ImageView interestedImage;
    public final TextView interestedText;
    public final ImageView more;
    public final TextView nickName;
    public final LinearLayout peopleLayout;
    public final TextView peopleNumber;
    public final ImageView rankBg;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final AppCompatTextView stateContent;
    public final ImageView stateImage;
    public final LinearLayout stateLayout;
    public final SuperStatusView statusView;
    public final AppCompatTextView subContent;
    public final AppCompatTextView timeContent;
    public final ImageView timeImage;
    public final TextView title;
    public final AppBarLayout toolbar;
    public final ConstraintLayout topLayout;
    public final LinearLayout trophyLayout;
    public final TextView trophyNumber;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityActivitiesDetailBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, FrameLayout frameLayout2, QMUIRadiusImageView2 qMUIRadiusImageView2, ConstraintLayout constraintLayout, CollapsingToolbarLayout collapsingToolbarLayout, CoordinatorLayout coordinatorLayout, AppCompatTextView appCompatTextView, TextView textView, QMUIRadiusImageView2 qMUIRadiusImageView22, TextView textView2, LinearLayout linearLayout, ImageView imageView, TextView textView3, ImageView imageView2, TextView textView4, LinearLayout linearLayout2, TextView textView5, ImageView imageView3, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView2, ImageView imageView4, LinearLayout linearLayout3, SuperStatusView superStatusView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, ImageView imageView5, TextView textView6, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout4, TextView textView7) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.buttonLayout = frameLayout2;
        this.centerImage = qMUIRadiusImageView2;
        this.centerLayout = constraintLayout;
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdContentContainer = coordinatorLayout;
        this.content = appCompatTextView;
        this.go = textView;
        this.headerImage = qMUIRadiusImageView22;
        this.idText = textView2;
        this.interested = linearLayout;
        this.interestedImage = imageView;
        this.interestedText = textView3;
        this.more = imageView2;
        this.nickName = textView4;
        this.peopleLayout = linearLayout2;
        this.peopleNumber = textView5;
        this.rankBg = imageView3;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.stateContent = appCompatTextView2;
        this.stateImage = imageView4;
        this.stateLayout = linearLayout3;
        this.statusView = superStatusView;
        this.subContent = appCompatTextView3;
        this.timeContent = appCompatTextView4;
        this.timeImage = imageView5;
        this.title = textView6;
        this.toolbar = appBarLayout;
        this.topLayout = constraintLayout2;
        this.trophyLayout = linearLayout4;
        this.trophyNumber = textView7;
    }

    public static ActivityActivitiesDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityActivitiesDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityActivitiesDetailBinding bind(View view, Object obj) {
        return (ActivityActivitiesDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_activities_detail);
    }

    @Deprecated
    public static ActivityActivitiesDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityActivitiesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_activities_detail, viewGroup, z, obj);
    }

    public static ActivityActivitiesDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityActivitiesDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityActivitiesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_activities_detail, (ViewGroup) null, false, obj);
    }
}
