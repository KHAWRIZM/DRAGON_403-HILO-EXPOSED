package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerHiloAssistantBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final FrameLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SmartRefreshLayout commonIdSwipeRefreshLayout;
    public final AppCompatTextView emptyTipTextView;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerHiloAssistantBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.commonIdContentContainer = frameLayout;
        this.commonIdRecyclerView = recyclerView;
        this.commonIdSwipeRefreshLayout = smartRefreshLayout;
        this.emptyTipTextView = appCompatTextView;
        this.toolbar = toolbar;
    }

    public static ViewControllerHiloAssistantBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerHiloAssistantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerHiloAssistantBinding bind(View view, Object obj) {
        return (ViewControllerHiloAssistantBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_hilo_assistant);
    }

    @Deprecated
    public static ViewControllerHiloAssistantBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerHiloAssistantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_hilo_assistant, viewGroup, z, obj);
    }

    public static ViewControllerHiloAssistantBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerHiloAssistantBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerHiloAssistantBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_hilo_assistant, (ViewGroup) null, false, obj);
    }
}
