package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySelectCountryBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final FrameLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final AppCompatTextView emptyTipTextView;
    public final LinearLayoutCompat linearLayout;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySelectCountryBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.commonIdContentContainer = frameLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.emptyTipTextView = appCompatTextView;
        this.linearLayout = linearLayoutCompat;
        this.toolbar = toolbar;
    }

    public static ActivitySelectCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySelectCountryBinding bind(View view, Object obj) {
        return (ActivitySelectCountryBinding) ViewDataBinding.bind(obj, view, R.layout.activity_select_country);
    }

    @Deprecated
    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySelectCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_select_country, viewGroup, z, obj);
    }

    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySelectCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySelectCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_select_country, (ViewGroup) null, false, obj);
    }
}
