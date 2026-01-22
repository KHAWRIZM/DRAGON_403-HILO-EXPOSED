package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogGoldTaskBinding extends ViewDataBinding {
    public final TextView confirm;
    public final AppCompatTextView content;
    public final AppCompatTextView content1;
    public final AppCompatTextView content2;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogGoldTaskBinding(Object obj, View view, int i, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i);
        this.confirm = textView;
        this.content = appCompatTextView;
        this.content1 = appCompatTextView2;
        this.content2 = appCompatTextView3;
    }

    public static DialogGoldTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogGoldTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogGoldTaskBinding bind(View view, Object obj) {
        return (DialogGoldTaskBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_gold_task);
    }

    @Deprecated
    public static DialogGoldTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGoldTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gold_task, viewGroup, z, obj);
    }

    public static DialogGoldTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogGoldTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGoldTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gold_task, (ViewGroup) null, false, obj);
    }
}
