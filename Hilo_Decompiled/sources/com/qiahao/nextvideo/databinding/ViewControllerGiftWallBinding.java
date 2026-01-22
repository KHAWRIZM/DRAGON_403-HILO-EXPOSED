package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerGiftWallBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final FrameLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final AppCompatTextView emptyTipTextView;
    public final AppCompatTextView title;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerGiftWallBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.commonIdContentContainer = frameLayout2;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.emptyTipTextView = appCompatTextView;
        this.title = appCompatTextView2;
        this.toolbar = toolbar;
    }

    public static ViewControllerGiftWallBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerGiftWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerGiftWallBinding bind(View view, Object obj) {
        return (ViewControllerGiftWallBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_gift_wall);
    }

    @Deprecated
    public static ViewControllerGiftWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerGiftWallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_gift_wall, viewGroup, z, obj);
    }

    public static ViewControllerGiftWallBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerGiftWallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerGiftWallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_gift_wall, (ViewGroup) null, false, obj);
    }
}
