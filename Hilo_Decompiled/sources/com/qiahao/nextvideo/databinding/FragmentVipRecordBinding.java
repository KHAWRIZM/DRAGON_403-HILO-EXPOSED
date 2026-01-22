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
public abstract class FragmentVipRecordBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentVipRecordBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static FragmentVipRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentVipRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentVipRecordBinding bind(View view, Object obj) {
        return (FragmentVipRecordBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_vip_record);
    }

    @Deprecated
    public static FragmentVipRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentVipRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_vip_record, viewGroup, z, obj);
    }

    public static FragmentVipRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentVipRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentVipRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_vip_record, (ViewGroup) null, false, obj);
    }
}
