package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerConfirmTipBinding extends ViewDataBinding {
    public final AppCompatButton cancelButton;
    public final AppCompatButton confirmButton;
    public final AppCompatTextView descriptionText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerConfirmTipBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.cancelButton = appCompatButton;
        this.confirmButton = appCompatButton2;
        this.descriptionText = appCompatTextView;
    }

    public static ViewControllerConfirmTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerConfirmTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerConfirmTipBinding bind(View view, Object obj) {
        return (ViewControllerConfirmTipBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_confirm_tip);
    }

    @Deprecated
    public static ViewControllerConfirmTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerConfirmTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_confirm_tip, viewGroup, z, obj);
    }

    public static ViewControllerConfirmTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerConfirmTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerConfirmTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_confirm_tip, (ViewGroup) null, false, obj);
    }
}
