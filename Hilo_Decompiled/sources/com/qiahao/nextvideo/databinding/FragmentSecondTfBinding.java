package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentSecondTfBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSecondTfBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static FragmentSecondTfBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentSecondTfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentSecondTfBinding bind(View view, Object obj) {
        return (FragmentSecondTfBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_second_tf);
    }

    @Deprecated
    public static FragmentSecondTfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSecondTfBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_second_tf, viewGroup, z, obj);
    }

    public static FragmentSecondTfBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentSecondTfBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSecondTfBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_second_tf, (ViewGroup) null, false, obj);
    }
}
