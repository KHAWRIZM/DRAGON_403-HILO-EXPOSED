package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
public abstract class ViewControllerConnectionLogsBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final FrameLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final LinearLayout container;
    public final AppCompatTextView emptyTipTextView;
    public final Toolbar toolbar;
    public final TextView toolbarTitleTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerConnectionLogsBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, LinearLayout linearLayout, AppCompatTextView appCompatTextView, Toolbar toolbar, TextView textView) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.commonIdContentContainer = frameLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.container = linearLayout;
        this.emptyTipTextView = appCompatTextView;
        this.toolbar = toolbar;
        this.toolbarTitleTextView = textView;
    }

    public static ViewControllerConnectionLogsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerConnectionLogsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerConnectionLogsBinding bind(View view, Object obj) {
        return (ViewControllerConnectionLogsBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_connection_logs);
    }

    @Deprecated
    public static ViewControllerConnectionLogsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerConnectionLogsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_connection_logs, viewGroup, z, obj);
    }

    public static ViewControllerConnectionLogsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerConnectionLogsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerConnectionLogsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_connection_logs, (ViewGroup) null, false, obj);
    }
}
