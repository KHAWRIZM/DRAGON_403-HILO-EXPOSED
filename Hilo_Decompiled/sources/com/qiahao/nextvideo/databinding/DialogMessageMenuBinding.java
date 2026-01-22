package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogMessageMenuBinding extends ViewDataBinding {
    public final AppCompatButton blockButton;
    public final AppCompatButton cancelButton;
    public final AppCompatButton deleteButton;
    public final View deleteLine;
    public final AppCompatButton reportButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMessageMenuBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, View view2, AppCompatButton appCompatButton4) {
        super(obj, view, i);
        this.blockButton = appCompatButton;
        this.cancelButton = appCompatButton2;
        this.deleteButton = appCompatButton3;
        this.deleteLine = view2;
        this.reportButton = appCompatButton4;
    }

    public static DialogMessageMenuBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogMessageMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogMessageMenuBinding bind(View view, Object obj) {
        return (DialogMessageMenuBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_message_menu);
    }

    @Deprecated
    public static DialogMessageMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMessageMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_message_menu, viewGroup, z, obj);
    }

    public static DialogMessageMenuBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogMessageMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMessageMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_message_menu, (ViewGroup) null, false, obj);
    }
}
