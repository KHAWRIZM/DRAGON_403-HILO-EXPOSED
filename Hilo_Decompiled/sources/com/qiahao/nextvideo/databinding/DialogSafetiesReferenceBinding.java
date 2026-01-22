package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogSafetiesReferenceBinding extends ViewDataBinding {
    public final AppCompatButton agreeButton;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogSafetiesReferenceBinding(Object obj, View view, int i, AppCompatButton appCompatButton, Toolbar toolbar) {
        super(obj, view, i);
        this.agreeButton = appCompatButton;
        this.toolbar = toolbar;
    }

    public static DialogSafetiesReferenceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogSafetiesReferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogSafetiesReferenceBinding bind(View view, Object obj) {
        return (DialogSafetiesReferenceBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_safeties_reference);
    }

    @Deprecated
    public static DialogSafetiesReferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSafetiesReferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_safeties_reference, viewGroup, z, obj);
    }

    public static DialogSafetiesReferenceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogSafetiesReferenceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSafetiesReferenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_safeties_reference, (ViewGroup) null, false, obj);
    }
}
