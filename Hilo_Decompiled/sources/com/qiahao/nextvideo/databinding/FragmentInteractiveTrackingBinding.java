package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentInteractiveTrackingBinding extends ViewDataBinding {
    public final ConstraintLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final SuperStatusView statusView;
    public final TextView unlock;
    public final LinearLayout unlockLayout;
    public final View unlockLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentInteractiveTrackingBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, TextView textView, LinearLayout linearLayout, View view2) {
        super(obj, view, i);
        this.commonIdContentContainer = constraintLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.unlock = textView;
        this.unlockLayout = linearLayout;
        this.unlockLine = view2;
    }

    public static FragmentInteractiveTrackingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentInteractiveTrackingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentInteractiveTrackingBinding bind(View view, Object obj) {
        return (FragmentInteractiveTrackingBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_interactive_tracking);
    }

    @Deprecated
    public static FragmentInteractiveTrackingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentInteractiveTrackingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_interactive_tracking, viewGroup, z, obj);
    }

    public static FragmentInteractiveTrackingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentInteractiveTrackingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentInteractiveTrackingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_interactive_tracking, (ViewGroup) null, false, obj);
    }
}
