package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerHomeDrawerHeadLayoutBinding extends ViewDataBinding {
    public final HiloGradeView activityLevel;
    public final HiloGradeView charmLevel;
    public final CountryIDView countryID;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final AppCompatTextView increaseFansCountTextView;
    public final AppCompatTextView increaseVisitorCountTextView;
    public final LinearLayoutCompat likeCountContainer;
    public final AppCompatTextView likeCountTextView;
    public final AppCompatTextView likeTitle;
    public final LinearLayout llLevel;
    public final NickTextView nicknameTextView;
    public final AppCompatTextView praiseCount;
    public final LinearLayoutCompat praiseCountContainer;
    public final AppCompatTextView praiseCountTextView;
    public final AppCompatTextView praiseTitle;
    public final AppCompatImageView privilegeImageView;
    public final ImageView topBg;
    public final LinearLayoutCompat topLinearLayout;
    public final HiloImageView userHeadIconImageView;
    public final AppCompatTextView visitorTitle;
    public final LinearLayoutCompat visitorsCountContainer;
    public final AppCompatTextView visitorsCountTextView;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerHomeDrawerHeadLayoutBinding(Object obj, View view, int i, HiloGradeView hiloGradeView, HiloGradeView hiloGradeView2, CountryIDView countryIDView, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, LinearLayout linearLayout, NickTextView nickTextView, AppCompatTextView appCompatTextView5, LinearLayoutCompat linearLayoutCompat2, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatImageView appCompatImageView, ImageView imageView3, LinearLayoutCompat linearLayoutCompat3, HiloImageView hiloImageView, AppCompatTextView appCompatTextView8, LinearLayoutCompat linearLayoutCompat4, AppCompatTextView appCompatTextView9, HiloGradeView hiloGradeView3) {
        super(obj, view, i);
        this.activityLevel = hiloGradeView;
        this.charmLevel = hiloGradeView2;
        this.countryID = countryIDView;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.increaseFansCountTextView = appCompatTextView;
        this.increaseVisitorCountTextView = appCompatTextView2;
        this.likeCountContainer = linearLayoutCompat;
        this.likeCountTextView = appCompatTextView3;
        this.likeTitle = appCompatTextView4;
        this.llLevel = linearLayout;
        this.nicknameTextView = nickTextView;
        this.praiseCount = appCompatTextView5;
        this.praiseCountContainer = linearLayoutCompat2;
        this.praiseCountTextView = appCompatTextView6;
        this.praiseTitle = appCompatTextView7;
        this.privilegeImageView = appCompatImageView;
        this.topBg = imageView3;
        this.topLinearLayout = linearLayoutCompat3;
        this.userHeadIconImageView = hiloImageView;
        this.visitorTitle = appCompatTextView8;
        this.visitorsCountContainer = linearLayoutCompat4;
        this.visitorsCountTextView = appCompatTextView9;
        this.wealthLevel = hiloGradeView3;
    }

    public static ViewControllerHomeDrawerHeadLayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerHomeDrawerHeadLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerHomeDrawerHeadLayoutBinding bind(View view, Object obj) {
        return (ViewControllerHomeDrawerHeadLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_home_drawer_head_layout);
    }

    @Deprecated
    public static ViewControllerHomeDrawerHeadLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerHomeDrawerHeadLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_home_drawer_head_layout, viewGroup, z, obj);
    }

    public static ViewControllerHomeDrawerHeadLayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerHomeDrawerHeadLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerHomeDrawerHeadLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_home_drawer_head_layout, (ViewGroup) null, false, obj);
    }
}
