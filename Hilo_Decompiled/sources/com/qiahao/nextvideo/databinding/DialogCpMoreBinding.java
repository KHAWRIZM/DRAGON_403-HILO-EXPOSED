package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCpMoreBinding extends ViewDataBinding {
    public final View backView;
    public final AppCompatButton cancelButton;
    public final AppCompatButton cpExit;
    public final View cpExitLine;
    public final AppCompatButton cpIntroduce;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpMoreBinding(Object obj, View view, int i, View view2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, View view3, AppCompatButton appCompatButton3) {
        super(obj, view, i);
        this.backView = view2;
        this.cancelButton = appCompatButton;
        this.cpExit = appCompatButton2;
        this.cpExitLine = view3;
        this.cpIntroduce = appCompatButton3;
    }

    public static DialogCpMoreBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpMoreBinding bind(View view, Object obj) {
        return (DialogCpMoreBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_more);
    }

    @Deprecated
    public static DialogCpMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_more, viewGroup, z, obj);
    }

    public static DialogCpMoreBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpMoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_more, (ViewGroup) null, false, obj);
    }
}
