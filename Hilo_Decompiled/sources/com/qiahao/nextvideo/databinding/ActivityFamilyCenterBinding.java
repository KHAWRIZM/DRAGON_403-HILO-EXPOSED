package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFamilyCenterBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final TextView applyButton;
    public final LinearLayout applyLayout;
    public final AppCompatImageView backImageView;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final AppCompatImageView setting;
    public final AppCompatImageView share;
    public final SVGAImageView svgaView;
    public final TextView text;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilyCenterBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, SVGAImageView sVGAImageView, TextView textView2, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.applyButton = textView;
        this.applyLayout = linearLayout;
        this.backImageView = appCompatImageView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.setting = appCompatImageView2;
        this.share = appCompatImageView3;
        this.svgaView = sVGAImageView;
        this.text = textView2;
        this.toolbar = toolbar;
    }

    public static ActivityFamilyCenterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilyCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilyCenterBinding bind(View view, Object obj) {
        return (ActivityFamilyCenterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_center);
    }

    @Deprecated
    public static ActivityFamilyCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilyCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_center, viewGroup, z, obj);
    }

    public static ActivityFamilyCenterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilyCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilyCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_center, (ViewGroup) null, false, obj);
    }
}
