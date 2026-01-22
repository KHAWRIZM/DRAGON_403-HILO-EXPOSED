package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerPowerMenuBinding extends ViewDataBinding {
    public final View backView;
    public final AppCompatButton cancelButton;
    public final AppCompatButton leaveButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerPowerMenuBinding(Object obj, View view, int i, View view2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2) {
        super(obj, view, i);
        this.backView = view2;
        this.cancelButton = appCompatButton;
        this.leaveButton = appCompatButton2;
    }

    public static ViewControllerPowerMenuBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerPowerMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerPowerMenuBinding bind(View view, Object obj) {
        return (ViewControllerPowerMenuBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_power_menu);
    }

    @Deprecated
    public static ViewControllerPowerMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerPowerMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_power_menu, viewGroup, z, obj);
    }

    public static ViewControllerPowerMenuBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerPowerMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerPowerMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_power_menu, (ViewGroup) null, false, obj);
    }
}
