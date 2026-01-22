package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerCommonListBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final FrameLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final FrameLayout container;
    public final AppCompatTextView emptyTipTextView;
    public final Toolbar toolbar;
    public final TextView toolbarTitleTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerCommonListBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, Toolbar toolbar, TextView textView) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.commonIdContentContainer = frameLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.container = frameLayout2;
        this.emptyTipTextView = appCompatTextView;
        this.toolbar = toolbar;
        this.toolbarTitleTextView = textView;
    }

    public static ViewControllerCommonListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerCommonListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerCommonListBinding bind(View view, Object obj) {
        return (ViewControllerCommonListBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_common_list);
    }

    @Deprecated
    public static ViewControllerCommonListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerCommonListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_common_list, viewGroup, z, obj);
    }

    public static ViewControllerCommonListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerCommonListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerCommonListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_common_list, (ViewGroup) null, false, obj);
    }
}
