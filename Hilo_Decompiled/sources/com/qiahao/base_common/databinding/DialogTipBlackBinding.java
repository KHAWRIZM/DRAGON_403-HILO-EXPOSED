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
public abstract class DialogTipBlackBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final AppCompatTextView content;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogTipBlackBinding(Object obj, View view, int i10, TextView textView, TextView textView2, AppCompatTextView appCompatTextView) {
        super(obj, view, i10);
        this.cancel = textView;
        this.confirm = textView2;
        this.content = appCompatTextView;
    }

    public static DialogTipBlackBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogTipBlackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogTipBlackBinding bind(View view, Object obj) {
        return (DialogTipBlackBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_tip_black);
    }

    @Deprecated
    public static DialogTipBlackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogTipBlackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tip_black, viewGroup, z10, obj);
    }

    public static DialogTipBlackBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogTipBlackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogTipBlackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tip_black, null, false, obj);
    }
}
