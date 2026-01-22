package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogWatchRuleBinding extends ViewDataBinding {
    /* JADX INFO: Access modifiers changed from: protected */
    public DialogWatchRuleBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static DialogWatchRuleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogWatchRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogWatchRuleBinding bind(View view, Object obj) {
        return (DialogWatchRuleBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_watch_rule);
    }

    @Deprecated
    public static DialogWatchRuleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogWatchRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_watch_rule, viewGroup, z, obj);
    }

    public static DialogWatchRuleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogWatchRuleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogWatchRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_watch_rule, (ViewGroup) null, false, obj);
    }
}
