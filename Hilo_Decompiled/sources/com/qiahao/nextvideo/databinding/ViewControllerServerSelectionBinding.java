package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.StackLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerServerSelectionBinding extends ViewDataBinding {
    public final StackLayout serverSelectionList;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerServerSelectionBinding(Object obj, View view, int i, StackLayout stackLayout) {
        super(obj, view, i);
        this.serverSelectionList = stackLayout;
    }

    public static ViewControllerServerSelectionBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerServerSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerServerSelectionBinding bind(View view, Object obj) {
        return (ViewControllerServerSelectionBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_server_selection);
    }

    @Deprecated
    public static ViewControllerServerSelectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerServerSelectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_server_selection, viewGroup, z, obj);
    }

    public static ViewControllerServerSelectionBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerServerSelectionBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerServerSelectionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_server_selection, (ViewGroup) null, false, obj);
    }
}
