package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ShareCommonContactsBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatTextView emptyTipTextView;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerManager;
    public final SmartRefreshLayout smartRefreshLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareCommonContactsBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatTextView appCompatTextView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.emptyTipTextView = appCompatTextView;
        this.recyclerManager = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
    }

    public static ShareCommonContactsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ShareCommonContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ShareCommonContactsBinding bind(View view, Object obj) {
        return (ShareCommonContactsBinding) ViewDataBinding.bind(obj, view, R.layout.share_common_contacts);
    }

    @Deprecated
    public static ShareCommonContactsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ShareCommonContactsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.share_common_contacts, viewGroup, z, obj);
    }

    public static ShareCommonContactsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ShareCommonContactsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ShareCommonContactsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.share_common_contacts, (ViewGroup) null, false, obj);
    }
}
