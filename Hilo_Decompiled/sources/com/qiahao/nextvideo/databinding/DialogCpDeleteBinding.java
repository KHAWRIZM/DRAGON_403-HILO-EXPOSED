package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCpDeleteBinding extends ViewDataBinding {
    public final View backView;
    public final AppCompatButton cancelButton;
    public final AppCompatButton delete;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpDeleteBinding(Object obj, View view, int i, View view2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2) {
        super(obj, view, i);
        this.backView = view2;
        this.cancelButton = appCompatButton;
        this.delete = appCompatButton2;
    }

    public static DialogCpDeleteBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpDeleteBinding bind(View view, Object obj) {
        return (DialogCpDeleteBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_delete);
    }

    @Deprecated
    public static DialogCpDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpDeleteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_delete, viewGroup, z, obj);
    }

    public static DialogCpDeleteBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpDeleteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpDeleteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_delete, (ViewGroup) null, false, obj);
    }
}
