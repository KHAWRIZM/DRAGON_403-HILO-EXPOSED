package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentCpChildBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeCpItemBinding top1;
    public final IncludeCpItemBinding top2;
    public final IncludeCpItemBinding top3;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCpChildBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeCpItemBinding includeCpItemBinding, IncludeCpItemBinding includeCpItemBinding2, IncludeCpItemBinding includeCpItemBinding3) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.top1 = includeCpItemBinding;
        this.top2 = includeCpItemBinding2;
        this.top3 = includeCpItemBinding3;
    }

    public static FragmentCpChildBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentCpChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentCpChildBinding bind(View view, Object obj) {
        return (FragmentCpChildBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_cp_child);
    }

    @Deprecated
    public static FragmentCpChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentCpChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_cp_child, viewGroup, z, obj);
    }

    public static FragmentCpChildBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentCpChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentCpChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_cp_child, (ViewGroup) null, false, obj);
    }
}
