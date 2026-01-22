package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogWealthMedalBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final RecyclerView recyclerView;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogWealthMedalBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.recyclerView = recyclerView;
        this.title = textView;
    }

    public static DialogWealthMedalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogWealthMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogWealthMedalBinding bind(View view, Object obj) {
        return (DialogWealthMedalBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_wealth_medal);
    }

    @Deprecated
    public static DialogWealthMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogWealthMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_wealth_medal, viewGroup, z, obj);
    }

    public static DialogWealthMedalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogWealthMedalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogWealthMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_wealth_medal, (ViewGroup) null, false, obj);
    }
}
