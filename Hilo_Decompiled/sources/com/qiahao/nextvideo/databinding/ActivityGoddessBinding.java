package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGoddessBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final AppCompatImageView endImage;
    public final FrameLayout historyLayout;
    public final LinearLayoutCompat linearLayout;
    public final RecyclerView recyclerView;
    public final ImageView redPoint;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final AppCompatTextView title;
    public final LinearLayoutCompat titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGoddessBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, AppCompatImageView appCompatImageView2, FrameLayout frameLayout2, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, ImageView imageView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.endImage = appCompatImageView2;
        this.historyLayout = frameLayout2;
        this.linearLayout = linearLayoutCompat;
        this.recyclerView = recyclerView;
        this.redPoint = imageView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.title = appCompatTextView;
        this.titleBar = linearLayoutCompat2;
    }

    public static ActivityGoddessBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGoddessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityGoddessBinding bind(View view, Object obj) {
        return (ActivityGoddessBinding) ViewDataBinding.bind(obj, view, R.layout.activity_goddess);
    }

    @Deprecated
    public static ActivityGoddessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGoddessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_goddess, viewGroup, z, obj);
    }

    public static ActivityGoddessBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGoddessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGoddessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_goddess, (ViewGroup) null, false, obj);
    }
}
