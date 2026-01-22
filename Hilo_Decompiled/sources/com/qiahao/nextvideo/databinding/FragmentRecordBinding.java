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
public abstract class FragmentRecordBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRecordBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static FragmentRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentRecordBinding bind(View view, Object obj) {
        return (FragmentRecordBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_record);
    }

    @Deprecated
    public static FragmentRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_record, viewGroup, z, obj);
    }

    public static FragmentRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_record, (ViewGroup) null, false, obj);
    }
}
