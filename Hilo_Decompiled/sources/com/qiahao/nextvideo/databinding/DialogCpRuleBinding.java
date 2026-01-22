package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCpRuleBinding extends ViewDataBinding {
    public final TextView bindContent;
    public final TextView bindTitle;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final TextView cpNickContent;
    public final TextView cpNickTitle;
    public final ImageView flower;
    public final TextView title;
    public final TextView unBindContent;
    public final TextView unBindTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpRuleBinding(Object obj, View view, int i, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, ImageView imageView2, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.bindContent = textView;
        this.bindTitle = textView2;
        this.close = imageView;
        this.constraint = constraintLayout;
        this.cpNickContent = textView3;
        this.cpNickTitle = textView4;
        this.flower = imageView2;
        this.title = textView5;
        this.unBindContent = textView6;
        this.unBindTitle = textView7;
    }

    public static DialogCpRuleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpRuleBinding bind(View view, Object obj) {
        return (DialogCpRuleBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_rule);
    }

    @Deprecated
    public static DialogCpRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_rule, viewGroup, z, obj);
    }

    public static DialogCpRuleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpRuleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_rule, (ViewGroup) null, false, obj);
    }
}
