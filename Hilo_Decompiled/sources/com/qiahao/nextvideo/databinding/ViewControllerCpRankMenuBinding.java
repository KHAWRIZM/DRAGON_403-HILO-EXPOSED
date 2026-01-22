package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerCpRankMenuBinding extends ViewDataBinding {
    public final View backView;
    public final AppCompatButton cancelButton;
    public final AppCompatButton releaseCpButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerCpRankMenuBinding(Object obj, View view, int i, View view2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2) {
        super(obj, view, i);
        this.backView = view2;
        this.cancelButton = appCompatButton;
        this.releaseCpButton = appCompatButton2;
    }

    public static ViewControllerCpRankMenuBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerCpRankMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerCpRankMenuBinding bind(View view, Object obj) {
        return (ViewControllerCpRankMenuBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_cp_rank_menu);
    }

    @Deprecated
    public static ViewControllerCpRankMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerCpRankMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_cp_rank_menu, viewGroup, z, obj);
    }

    public static ViewControllerCpRankMenuBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerCpRankMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerCpRankMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_cp_rank_menu, (ViewGroup) null, false, obj);
    }
}
