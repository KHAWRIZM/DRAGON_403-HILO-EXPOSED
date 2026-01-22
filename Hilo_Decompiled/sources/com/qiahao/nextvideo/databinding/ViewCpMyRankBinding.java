package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewCpMyRankBinding extends ViewDataBinding {
    public final AppCompatTextView emptyTipTextView;
    public final RecyclerView recyclerRank;
    public final SmartRefreshLayout smartRefreshLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewCpMyRankBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.emptyTipTextView = appCompatTextView;
        this.recyclerRank = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
    }

    public static ViewCpMyRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewCpMyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewCpMyRankBinding bind(View view, Object obj) {
        return (ViewCpMyRankBinding) ViewDataBinding.bind(obj, view, R.layout.view_cp_my_rank);
    }

    @Deprecated
    public static ViewCpMyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewCpMyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_cp_my_rank, viewGroup, z, obj);
    }

    public static ViewCpMyRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewCpMyRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewCpMyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_cp_my_rank, (ViewGroup) null, false, obj);
    }
}
