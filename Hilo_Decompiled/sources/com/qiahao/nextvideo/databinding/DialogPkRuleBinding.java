package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogPkRuleBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final ConstraintLayout constraint;
    public final TextView content;
    public final View line;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogPkRuleBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView, View view2, TextView textView2) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.constraint = constraintLayout;
        this.content = textView;
        this.line = view2;
        this.title = textView2;
    }

    public static DialogPkRuleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogPkRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogPkRuleBinding bind(View view, Object obj) {
        return (DialogPkRuleBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_pk_rule);
    }

    @Deprecated
    public static DialogPkRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPkRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pk_rule, viewGroup, z, obj);
    }

    public static DialogPkRuleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogPkRuleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPkRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pk_rule, (ViewGroup) null, false, obj);
    }
}
