package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentDiamondTaskBinding extends ViewDataBinding {
    public final RecyclerView dailyTasksRecycler;
    public final RecyclerView growthTasksRecycler;
    public final LinearLayoutCompat linearLayout;
    public final NestedScrollView scrollView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentDiamondTaskBinding(Object obj, View view, int i, RecyclerView recyclerView, RecyclerView recyclerView2, LinearLayoutCompat linearLayoutCompat, NestedScrollView nestedScrollView) {
        super(obj, view, i);
        this.dailyTasksRecycler = recyclerView;
        this.growthTasksRecycler = recyclerView2;
        this.linearLayout = linearLayoutCompat;
        this.scrollView = nestedScrollView;
    }

    public static FragmentDiamondTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentDiamondTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentDiamondTaskBinding bind(View view, Object obj) {
        return (FragmentDiamondTaskBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_diamond_task);
    }

    @Deprecated
    public static FragmentDiamondTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDiamondTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_diamond_task, viewGroup, z, obj);
    }

    public static FragmentDiamondTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentDiamondTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDiamondTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_diamond_task, (ViewGroup) null, false, obj);
    }
}
