package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogTipBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final AppCompatTextView content;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogTipBinding(Object obj, View view, int i10, TextView textView, TextView textView2, AppCompatTextView appCompatTextView) {
        super(obj, view, i10);
        this.cancel = textView;
        this.confirm = textView2;
        this.content = appCompatTextView;
    }

    public static DialogTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogTipBinding bind(View view, Object obj) {
        return (DialogTipBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_tip);
    }

    @Deprecated
    public static DialogTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tip, viewGroup, z10, obj);
    }

    public static DialogTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tip, null, false, obj);
    }
}
