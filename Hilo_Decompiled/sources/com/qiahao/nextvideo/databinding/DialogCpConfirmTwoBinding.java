package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCpConfirmTwoBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final AppCompatTextView content;
    public final FrameLayout frameLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpConfirmTwoBinding(Object obj, View view, int i, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.cancel = textView;
        this.confirm = textView2;
        this.content = appCompatTextView;
        this.frameLayout = frameLayout;
    }

    public static DialogCpConfirmTwoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpConfirmTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpConfirmTwoBinding bind(View view, Object obj) {
        return (DialogCpConfirmTwoBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_confirm_two);
    }

    @Deprecated
    public static DialogCpConfirmTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpConfirmTwoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_confirm_two, viewGroup, z, obj);
    }

    public static DialogCpConfirmTwoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpConfirmTwoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpConfirmTwoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_confirm_two, (ViewGroup) null, false, obj);
    }
}
