package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.home.chat.HorizontalInteractiveView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentMessageBinding extends ViewDataBinding {
    public final LinearLayout bottomView;
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final CoordinatorLayout commonIdContentContainer;
    public final LinearLayoutCompat container;
    public final AppCompatTextView emptyTipTextView;
    public final HorizontalInteractiveView horizontalInteractiveView;
    public final LinearLayout linear;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout smartRefreshLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentMessageBinding(Object obj, View view, int i, LinearLayout linearLayout, CollapsingToolbarLayout collapsingToolbarLayout, CoordinatorLayout coordinatorLayout, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, HorizontalInteractiveView horizontalInteractiveView, LinearLayout linearLayout2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.bottomView = linearLayout;
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdContentContainer = coordinatorLayout;
        this.container = linearLayoutCompat;
        this.emptyTipTextView = appCompatTextView;
        this.horizontalInteractiveView = horizontalInteractiveView;
        this.linear = linearLayout2;
        this.recyclerView = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
    }

    public static FragmentMessageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentMessageBinding bind(View view, Object obj) {
        return (FragmentMessageBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_message);
    }

    @Deprecated
    public static FragmentMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_message, viewGroup, z, obj);
    }

    public static FragmentMessageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentMessageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_message, (ViewGroup) null, false, obj);
    }
}
