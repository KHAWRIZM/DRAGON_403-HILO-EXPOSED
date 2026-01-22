package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityMainBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView bgLaunchImageView;
    public final FrameLayout contentBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMainBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.bgLaunchImageView = appCompatImageView;
        this.contentBg = frameLayout2;
    }

    public static ActivityMainBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.bind(obj, view, R.layout.activity_main);
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, viewGroup, z, obj);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_main, (ViewGroup) null, false, obj);
    }
}
