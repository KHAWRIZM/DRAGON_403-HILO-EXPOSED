package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewFoodieRankBinding extends ViewDataBinding {
    public final ImageView ivBeardEnd;
    public final ImageView ivBeardStart;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFoodieRankBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, TextView textView) {
        super(obj, view, i);
        this.ivBeardEnd = imageView;
        this.ivBeardStart = imageView2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.tvTitle = textView;
    }

    public static ViewFoodieRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewFoodieRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewFoodieRankBinding bind(View view, Object obj) {
        return (ViewFoodieRankBinding) ViewDataBinding.bind(obj, view, R.layout.view_foodie_rank);
    }

    @Deprecated
    public static ViewFoodieRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewFoodieRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_rank, viewGroup, z, obj);
    }

    public static ViewFoodieRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewFoodieRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewFoodieRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_rank, (ViewGroup) null, false, obj);
    }
}
