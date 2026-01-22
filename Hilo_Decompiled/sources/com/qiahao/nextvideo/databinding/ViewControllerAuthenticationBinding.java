package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.videoView.LifecycleVideoView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerAuthenticationBinding extends ViewDataBinding {
    public final AppCompatImageView bgLaunchImageView;
    public final FrameLayout commonIdCoordinateLayout;
    public final FrameLayout loginByFacebookButton;
    public final FrameLayout loginByGoogleButton;
    public final ImageView loginPhone;
    public final AppCompatImageView logoImageview;
    public final Button muLogin;
    public final LinearLayoutCompat orLayout;
    public final RelativeLayout relativeLayout;
    public final AppCompatTextView serverTextView;
    public final AppCompatTextView userProtocalTextView;
    public final AppCompatTextView versionTextView;
    public final LifecycleVideoView videoView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerAuthenticationBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, AppCompatImageView appCompatImageView2, Button button, LinearLayoutCompat linearLayoutCompat, RelativeLayout relativeLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, LifecycleVideoView lifecycleVideoView) {
        super(obj, view, i);
        this.bgLaunchImageView = appCompatImageView;
        this.commonIdCoordinateLayout = frameLayout;
        this.loginByFacebookButton = frameLayout2;
        this.loginByGoogleButton = frameLayout3;
        this.loginPhone = imageView;
        this.logoImageview = appCompatImageView2;
        this.muLogin = button;
        this.orLayout = linearLayoutCompat;
        this.relativeLayout = relativeLayout;
        this.serverTextView = appCompatTextView;
        this.userProtocalTextView = appCompatTextView2;
        this.versionTextView = appCompatTextView3;
        this.videoView = lifecycleVideoView;
    }

    public static ViewControllerAuthenticationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerAuthenticationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerAuthenticationBinding bind(View view, Object obj) {
        return (ViewControllerAuthenticationBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_authentication);
    }

    @Deprecated
    public static ViewControllerAuthenticationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerAuthenticationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_authentication, viewGroup, z, obj);
    }

    public static ViewControllerAuthenticationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerAuthenticationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerAuthenticationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_authentication, (ViewGroup) null, false, obj);
    }
}
