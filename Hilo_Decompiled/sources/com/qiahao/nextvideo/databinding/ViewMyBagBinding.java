package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewMyBagBinding extends ViewDataBinding {
    public final FrameLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final AppCompatTextView emptyTipTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewMyBagBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.commonIdContentContainer = frameLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.emptyTipTextView = appCompatTextView;
    }

    public static ViewMyBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewMyBagBinding bind(View view, Object obj) {
        return (ViewMyBagBinding) ViewDataBinding.bind(obj, view, R.layout.view_my_bag);
    }

    @Deprecated
    public static ViewMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_my_bag, viewGroup, z, obj);
    }

    public static ViewMyBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewMyBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_my_bag, (ViewGroup) null, false, obj);
    }
}
