package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class SplashAdvertisingViewBinding extends ViewDataBinding {
    public final AppCompatImageView bgAdvertisingImageView;
    public final ConstraintLayout bgContent;
    public final TextView countText;
    public final ImageView countryBg;
    public final CircleImageView countryImage;
    public final ConstraintLayout countryLayout;
    public final CircleImageView cpAvatar1;
    public final CircleImageView cpAvatar2;
    public final ImageView cpBg;
    public final TextView cpCenter;
    public final TextView cpNick1;
    public final TextView cpNick2;
    public final ConstraintLayout cpWeekLayout;
    public final ImageView crown;
    public final ConstraintLayout flCpAvatar1;
    public final ConstraintLayout flCpAvatar2;
    public final ImageView textWeekStar;
    public final CircleImageView weekStarAvatar;
    public final ImageView weekStarAvatarBg;
    public final ImageView weekStarBg;
    public final ConstraintLayout weekStarLayout;
    public final TextView weekStarNick;

    /* JADX INFO: Access modifiers changed from: protected */
    public SplashAdvertisingViewBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, CircleImageView circleImageView, ConstraintLayout constraintLayout2, CircleImageView circleImageView2, CircleImageView circleImageView3, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout3, ImageView imageView3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ImageView imageView4, CircleImageView circleImageView4, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout6, TextView textView5) {
        super(obj, view, i);
        this.bgAdvertisingImageView = appCompatImageView;
        this.bgContent = constraintLayout;
        this.countText = textView;
        this.countryBg = imageView;
        this.countryImage = circleImageView;
        this.countryLayout = constraintLayout2;
        this.cpAvatar1 = circleImageView2;
        this.cpAvatar2 = circleImageView3;
        this.cpBg = imageView2;
        this.cpCenter = textView2;
        this.cpNick1 = textView3;
        this.cpNick2 = textView4;
        this.cpWeekLayout = constraintLayout3;
        this.crown = imageView3;
        this.flCpAvatar1 = constraintLayout4;
        this.flCpAvatar2 = constraintLayout5;
        this.textWeekStar = imageView4;
        this.weekStarAvatar = circleImageView4;
        this.weekStarAvatarBg = imageView5;
        this.weekStarBg = imageView6;
        this.weekStarLayout = constraintLayout6;
        this.weekStarNick = textView5;
    }

    public static SplashAdvertisingViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static SplashAdvertisingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static SplashAdvertisingViewBinding bind(View view, Object obj) {
        return (SplashAdvertisingViewBinding) ViewDataBinding.bind(obj, view, R.layout.splash_advertising_view);
    }

    @Deprecated
    public static SplashAdvertisingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (SplashAdvertisingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.splash_advertising_view, viewGroup, z, obj);
    }

    public static SplashAdvertisingViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static SplashAdvertisingViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (SplashAdvertisingViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.splash_advertising_view, (ViewGroup) null, false, obj);
    }
}
