package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerPlatformProtocalBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final AppCompatButton childSafetyPolicy;
    public final AppCompatButton copyrightPolicyButton;
    public final AppCompatButton privacyPolicyButton;
    public final AppCompatButton termsOfServiceButton;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerPlatformProtocalBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, AppCompatButton appCompatButton4, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.childSafetyPolicy = appCompatButton;
        this.copyrightPolicyButton = appCompatButton2;
        this.privacyPolicyButton = appCompatButton3;
        this.termsOfServiceButton = appCompatButton4;
        this.toolbar = toolbar;
    }

    public static ViewControllerPlatformProtocalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerPlatformProtocalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerPlatformProtocalBinding bind(View view, Object obj) {
        return (ViewControllerPlatformProtocalBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_platform_protocal);
    }

    @Deprecated
    public static ViewControllerPlatformProtocalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerPlatformProtocalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_platform_protocal, viewGroup, z, obj);
    }

    public static ViewControllerPlatformProtocalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerPlatformProtocalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerPlatformProtocalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_platform_protocal, (ViewGroup) null, false, obj);
    }
}
