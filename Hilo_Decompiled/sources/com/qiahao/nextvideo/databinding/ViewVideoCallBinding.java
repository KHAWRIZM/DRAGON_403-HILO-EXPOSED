package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewVideoCallBinding extends ViewDataBinding {
    public final ImageView acceptImageView;
    public final QMUIRadiusImageView avatarImageView;
    public final AppCompatImageView countryFlagImageView;
    public final AppCompatTextView countryProvinceTextView;
    public final AppCompatImageView coverImageView;
    public final ImageView hangupImageView;
    public final FrameLayout largeBoxVideoContainer;
    public final AppCompatTextView nicknameTextView;
    public final AppCompatTextView pendingDescriptionTextView;
    public final LinearLayoutCompat topLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewVideoCallBinding(Object obj, View view, int i, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, ImageView imageView2, FrameLayout frameLayout, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, LinearLayoutCompat linearLayoutCompat) {
        super(obj, view, i);
        this.acceptImageView = imageView;
        this.avatarImageView = qMUIRadiusImageView;
        this.countryFlagImageView = appCompatImageView;
        this.countryProvinceTextView = appCompatTextView;
        this.coverImageView = appCompatImageView2;
        this.hangupImageView = imageView2;
        this.largeBoxVideoContainer = frameLayout;
        this.nicknameTextView = appCompatTextView2;
        this.pendingDescriptionTextView = appCompatTextView3;
        this.topLayout = linearLayoutCompat;
    }

    public static ViewVideoCallBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewVideoCallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewVideoCallBinding bind(View view, Object obj) {
        return (ViewVideoCallBinding) ViewDataBinding.bind(obj, view, R.layout.view_video_call);
    }

    @Deprecated
    public static ViewVideoCallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewVideoCallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_video_call, viewGroup, z, obj);
    }

    public static ViewVideoCallBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewVideoCallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewVideoCallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_video_call, (ViewGroup) null, false, obj);
    }
}
