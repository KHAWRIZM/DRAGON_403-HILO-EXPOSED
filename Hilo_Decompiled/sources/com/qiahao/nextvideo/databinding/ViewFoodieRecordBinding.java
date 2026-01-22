package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewFoodieRecordBinding extends ViewDataBinding {
    public final ImageView ivClose;
    public final LinearLayout llRow;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final TextView tvBetDetails;
    public final TextView tvBetTime;
    public final TextView tvRewardDetails;
    public final TextView tvTitle;
    public final View vLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFoodieRecordBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.ivClose = imageView;
        this.llRow = linearLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.tvBetDetails = textView;
        this.tvBetTime = textView2;
        this.tvRewardDetails = textView3;
        this.tvTitle = textView4;
        this.vLine = view2;
    }

    public static ViewFoodieRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewFoodieRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewFoodieRecordBinding bind(View view, Object obj) {
        return (ViewFoodieRecordBinding) ViewDataBinding.bind(obj, view, R.layout.view_foodie_record);
    }

    @Deprecated
    public static ViewFoodieRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewFoodieRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_record, viewGroup, z, obj);
    }

    public static ViewFoodieRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewFoodieRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewFoodieRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_record, (ViewGroup) null, false, obj);
    }
}
