package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityCommonListWithRefreshBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCommonListWithRefreshBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.titleBar = includeTitleBinding;
    }

    public static ActivityCommonListWithRefreshBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityCommonListWithRefreshBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityCommonListWithRefreshBinding bind(View view, Object obj) {
        return (ActivityCommonListWithRefreshBinding) ViewDataBinding.bind(obj, view, R.layout.activity_common_list_with_refresh);
    }

    @Deprecated
    public static ActivityCommonListWithRefreshBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCommonListWithRefreshBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_common_list_with_refresh, viewGroup, z, obj);
    }

    public static ActivityCommonListWithRefreshBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityCommonListWithRefreshBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCommonListWithRefreshBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_common_list_with_refresh, (ViewGroup) null, false, obj);
    }
}
