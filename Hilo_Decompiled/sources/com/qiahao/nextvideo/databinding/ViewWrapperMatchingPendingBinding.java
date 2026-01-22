package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.paired.MatchingActionPendingCountDownProgressBar;
import com.qiahao.nextvideo.ui.paired.view.LaunchVideoCallButton;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewWrapperMatchingPendingBinding extends ViewDataBinding {
    public final LaunchVideoCallButton acceptInviteButton;
    public final GenderAgeTextView ageTextView;
    public final CircleImageView circleImageView;
    public final SVGAImageView connectFailedSvgImageView;
    public final LinearLayoutCompat connectResultViewContainer;
    public final MatchingActionPendingCountDownProgressBar connectStatusProgressBar;
    public final AppCompatImageView countryFlagImageView;
    public final AppCompatTextView countryProvinceTextView;
    public final ImageView iconVip;
    public final AppCompatTextView nicknameTextView;
    public final AppCompatButton refuseInviteButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewWrapperMatchingPendingBinding(Object obj, View view, int i, LaunchVideoCallButton launchVideoCallButton, GenderAgeTextView genderAgeTextView, CircleImageView circleImageView, SVGAImageView sVGAImageView, LinearLayoutCompat linearLayoutCompat, MatchingActionPendingCountDownProgressBar matchingActionPendingCountDownProgressBar, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, ImageView imageView, AppCompatTextView appCompatTextView2, AppCompatButton appCompatButton) {
        super(obj, view, i);
        this.acceptInviteButton = launchVideoCallButton;
        this.ageTextView = genderAgeTextView;
        this.circleImageView = circleImageView;
        this.connectFailedSvgImageView = sVGAImageView;
        this.connectResultViewContainer = linearLayoutCompat;
        this.connectStatusProgressBar = matchingActionPendingCountDownProgressBar;
        this.countryFlagImageView = appCompatImageView;
        this.countryProvinceTextView = appCompatTextView;
        this.iconVip = imageView;
        this.nicknameTextView = appCompatTextView2;
        this.refuseInviteButton = appCompatButton;
    }

    public static ViewWrapperMatchingPendingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewWrapperMatchingPendingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewWrapperMatchingPendingBinding bind(View view, Object obj) {
        return (ViewWrapperMatchingPendingBinding) ViewDataBinding.bind(obj, view, R.layout.view_wrapper_matching_pending);
    }

    @Deprecated
    public static ViewWrapperMatchingPendingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewWrapperMatchingPendingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_wrapper_matching_pending, viewGroup, z, obj);
    }

    public static ViewWrapperMatchingPendingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewWrapperMatchingPendingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewWrapperMatchingPendingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_wrapper_matching_pending, (ViewGroup) null, false, obj);
    }
}
