package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogProgressBinding extends ViewDataBinding {
    public final CardView viewProgressContent;
    public final AppCompatTextView viewProgressText;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogProgressBinding(Object obj, View view, int i10, CardView cardView, AppCompatTextView appCompatTextView) {
        super(obj, view, i10);
        this.viewProgressContent = cardView;
        this.viewProgressText = appCompatTextView;
    }

    public static DialogProgressBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogProgressBinding bind(View view, Object obj) {
        return (DialogProgressBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_progress);
    }

    @Deprecated
    public static DialogProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_progress, viewGroup, z10, obj);
    }

    public static DialogProgressBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogProgressBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogProgressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_progress, null, false, obj);
    }
}
