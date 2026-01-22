package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogImageTypeBinding extends ViewDataBinding {
    public final View backView;
    public final AppCompatButton cancelButton;
    public final AppCompatButton gif;
    public final AppCompatButton other;
    public final View profileLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogImageTypeBinding(Object obj, View view, int i10, View view2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, View view3) {
        super(obj, view, i10);
        this.backView = view2;
        this.cancelButton = appCompatButton;
        this.gif = appCompatButton2;
        this.other = appCompatButton3;
        this.profileLine = view3;
    }

    public static DialogImageTypeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogImageTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogImageTypeBinding bind(View view, Object obj) {
        return (DialogImageTypeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_image_type);
    }

    @Deprecated
    public static DialogImageTypeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogImageTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_image_type, viewGroup, z10, obj);
    }

    public static DialogImageTypeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogImageTypeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogImageTypeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_image_type, null, false, obj);
    }
}
