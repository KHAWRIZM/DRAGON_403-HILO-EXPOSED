package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.home.chat.HorizontalInteractiveView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogMessageListBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final CoordinatorLayout commonIdContentContainer;
    public final LinearLayoutCompat container;
    public final AppCompatTextView emptyTipTextView;
    public final HorizontalInteractiveView horizontalInteractiveView;
    public final LinearLayout linear;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout smartRefreshLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMessageListBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, CoordinatorLayout coordinatorLayout, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, HorizontalInteractiveView horizontalInteractiveView, LinearLayout linearLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdContentContainer = coordinatorLayout;
        this.container = linearLayoutCompat;
        this.emptyTipTextView = appCompatTextView;
        this.horizontalInteractiveView = horizontalInteractiveView;
        this.linear = linearLayout;
        this.recyclerView = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
    }

    public static DialogMessageListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogMessageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogMessageListBinding bind(View view, Object obj) {
        return (DialogMessageListBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_message_list);
    }

    @Deprecated
    public static DialogMessageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMessageListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_message_list, viewGroup, z, obj);
    }

    public static DialogMessageListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogMessageListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMessageListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_message_list, (ViewGroup) null, false, obj);
    }
}
