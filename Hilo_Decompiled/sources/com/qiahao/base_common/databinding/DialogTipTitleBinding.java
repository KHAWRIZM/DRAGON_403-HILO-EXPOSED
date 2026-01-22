package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogTipTitleBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final AppCompatTextView content;
    public final ConstraintLayout rootView;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogTipTitleBinding(Object obj, View view, int i10, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, TextView textView3) {
        super(obj, view, i10);
        this.cancel = textView;
        this.confirm = textView2;
        this.content = appCompatTextView;
        this.rootView = constraintLayout;
        this.title = textView3;
    }

    public static DialogTipTitleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogTipTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogTipTitleBinding bind(View view, Object obj) {
        return (DialogTipTitleBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_tip_title);
    }

    @Deprecated
    public static DialogTipTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogTipTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tip_title, viewGroup, z10, obj);
    }

    public static DialogTipTitleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogTipTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogTipTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_tip_title, null, false, obj);
    }
}
