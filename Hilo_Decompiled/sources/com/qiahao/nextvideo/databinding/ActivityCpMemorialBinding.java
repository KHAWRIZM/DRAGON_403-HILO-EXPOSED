package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityCpMemorialBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ImageView add;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCpMemorialBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.add = imageView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.titleBar = includeTitleBinding;
    }

    public static ActivityCpMemorialBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityCpMemorialBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityCpMemorialBinding bind(View view, Object obj) {
        return (ActivityCpMemorialBinding) ViewDataBinding.bind(obj, view, R.layout.activity_cp_memorial);
    }

    @Deprecated
    public static ActivityCpMemorialBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCpMemorialBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cp_memorial, viewGroup, z, obj);
    }

    public static ActivityCpMemorialBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityCpMemorialBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCpMemorialBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cp_memorial, (ViewGroup) null, false, obj);
    }
}
