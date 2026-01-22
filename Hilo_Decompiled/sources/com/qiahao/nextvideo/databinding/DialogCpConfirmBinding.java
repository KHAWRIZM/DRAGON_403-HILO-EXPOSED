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
public abstract class DialogCpConfirmBinding extends ViewDataBinding {
    public final TextView confirm;
    public final AppCompatTextView content;
    public final FrameLayout frameLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpConfirmBinding(Object obj, View view, int i, TextView textView, AppCompatTextView appCompatTextView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.confirm = textView;
        this.content = appCompatTextView;
        this.frameLayout = frameLayout;
    }

    public static DialogCpConfirmBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpConfirmBinding bind(View view, Object obj) {
        return (DialogCpConfirmBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_confirm);
    }

    @Deprecated
    public static DialogCpConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_confirm, viewGroup, z, obj);
    }

    public static DialogCpConfirmBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpConfirmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_confirm, (ViewGroup) null, false, obj);
    }
}
