package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySvipPointBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final TextView getSvip;
    public final TextView point;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeTitleWriteBinding titleBar;
    public final ImageView topImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySvipPointBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, TextView textView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeTitleWriteBinding includeTitleWriteBinding, ImageView imageView) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.getSvip = textView;
        this.point = textView2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.titleBar = includeTitleWriteBinding;
        this.topImage = imageView;
    }

    public static ActivitySvipPointBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySvipPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySvipPointBinding bind(View view, Object obj) {
        return (ActivitySvipPointBinding) ViewDataBinding.bind(obj, view, R.layout.activity_svip_point);
    }

    @Deprecated
    public static ActivitySvipPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySvipPointBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip_point, viewGroup, z, obj);
    }

    public static ActivitySvipPointBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySvipPointBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySvipPointBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip_point, (ViewGroup) null, false, obj);
    }
}
