package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityVideoResultBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final AppCompatTextView callDuration;
    public final ImageView countryImage;
    public final AppCompatTextView countryName;
    public final LinearLayoutCompat linearLayout;
    public final AppCompatTextView nickName;
    public final ImageView proceedsIcon;
    public final ConstraintLayout proceedsLayout;
    public final AppCompatTextView proceedsNum;
    public final AppCompatTextView proceedsText;
    public final AppCompatImageView reportImage;
    public final ImageView revenueIcon;
    public final ConstraintLayout revenueLayout;
    public final AppCompatTextView revenueNum;
    public final AppCompatTextView revenueText;
    public final AppCompatTextView time;
    public final CircleImageView userAvatar;
    public final AppCompatImageView vip;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityVideoResultBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, AppCompatImageView appCompatImageView, View view2, AppCompatTextView appCompatTextView, ImageView imageView, AppCompatTextView appCompatTextView2, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView3, ImageView imageView2, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatImageView appCompatImageView2, ImageView imageView3, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, CircleImageView circleImageView, AppCompatImageView appCompatImageView3) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.callDuration = appCompatTextView;
        this.countryImage = imageView;
        this.countryName = appCompatTextView2;
        this.linearLayout = linearLayoutCompat;
        this.nickName = appCompatTextView3;
        this.proceedsIcon = imageView2;
        this.proceedsLayout = constraintLayout;
        this.proceedsNum = appCompatTextView4;
        this.proceedsText = appCompatTextView5;
        this.reportImage = appCompatImageView2;
        this.revenueIcon = imageView3;
        this.revenueLayout = constraintLayout2;
        this.revenueNum = appCompatTextView6;
        this.revenueText = appCompatTextView7;
        this.time = appCompatTextView8;
        this.userAvatar = circleImageView;
        this.vip = appCompatImageView3;
    }

    public static ActivityVideoResultBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityVideoResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityVideoResultBinding bind(View view, Object obj) {
        return (ActivityVideoResultBinding) ViewDataBinding.bind(obj, view, R.layout.activity_video_result);
    }

    @Deprecated
    public static ActivityVideoResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityVideoResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_video_result, viewGroup, z, obj);
    }

    public static ActivityVideoResultBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityVideoResultBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityVideoResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_video_result, (ViewGroup) null, false, obj);
    }
}
