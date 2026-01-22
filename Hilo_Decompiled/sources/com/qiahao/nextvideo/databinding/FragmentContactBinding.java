package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentContactBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final CoordinatorLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final LinearLayoutCompat container;
    public final AppCompatTextView emptyTipTextView;
    public final TextView iLike;
    public final AppCompatTextView iLikeUnread;
    public final TextView likeMe;
    public final AppCompatTextView likeMeUnread;
    public final LinearLayout llILike;
    public final LinearLayout llLikeMe;
    public final LinearLayout llVisit;
    public final AppBarLayout toolbar;
    public final AppCompatTextView visitUnread;
    public final TextView visitor;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentContactBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2, TextView textView2, AppCompatTextView appCompatTextView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, AppBarLayout appBarLayout, AppCompatTextView appCompatTextView4, TextView textView3) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdContentContainer = coordinatorLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.container = linearLayoutCompat;
        this.emptyTipTextView = appCompatTextView;
        this.iLike = textView;
        this.iLikeUnread = appCompatTextView2;
        this.likeMe = textView2;
        this.likeMeUnread = appCompatTextView3;
        this.llILike = linearLayout;
        this.llLikeMe = linearLayout2;
        this.llVisit = linearLayout3;
        this.toolbar = appBarLayout;
        this.visitUnread = appCompatTextView4;
        this.visitor = textView3;
    }

    public static FragmentContactBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentContactBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentContactBinding bind(View view, Object obj) {
        return (FragmentContactBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_contact);
    }

    @Deprecated
    public static FragmentContactBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentContactBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_contact, viewGroup, z, obj);
    }

    public static FragmentContactBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentContactBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentContactBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_contact, (ViewGroup) null, false, obj);
    }
}
