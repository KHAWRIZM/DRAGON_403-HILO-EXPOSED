package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityAristocracyBagBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ConstraintLayout buttonLayout;
    public final TextView cardText;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final TextView send;
    public final SuperStatusView statusView;
    public final IncludeTitleWriteBinding titleBar;
    public final TextView use;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityAristocracyBagBinding(Object obj, View view, int i, FrameLayout frameLayout, ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView2, SuperStatusView superStatusView, IncludeTitleWriteBinding includeTitleWriteBinding, TextView textView3) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.buttonLayout = constraintLayout;
        this.cardText = textView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.send = textView2;
        this.statusView = superStatusView;
        this.titleBar = includeTitleWriteBinding;
        this.use = textView3;
    }

    public static ActivityAristocracyBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityAristocracyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityAristocracyBagBinding bind(View view, Object obj) {
        return (ActivityAristocracyBagBinding) ViewDataBinding.bind(obj, view, R.layout.activity_aristocracy_bag);
    }

    @Deprecated
    public static ActivityAristocracyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAristocracyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_aristocracy_bag, viewGroup, z, obj);
    }

    public static ActivityAristocracyBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityAristocracyBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAristocracyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_aristocracy_bag, (ViewGroup) null, false, obj);
    }
}
