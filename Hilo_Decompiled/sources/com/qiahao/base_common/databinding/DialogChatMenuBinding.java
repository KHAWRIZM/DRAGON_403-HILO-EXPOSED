package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class DialogChatMenuBinding extends ViewDataBinding {
    public final View backView;
    public final AppCompatButton blockButton;
    public final AppCompatButton cancelButton;
    public final AppCompatButton deleteButton;
    public final View deleteLine;
    public final AppCompatButton profileButton;
    public final View profileLine;
    public final AppCompatButton reportButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogChatMenuBinding(Object obj, View view, int i10, View view2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, View view3, AppCompatButton appCompatButton4, View view4, AppCompatButton appCompatButton5) {
        super(obj, view, i10);
        this.backView = view2;
        this.blockButton = appCompatButton;
        this.cancelButton = appCompatButton2;
        this.deleteButton = appCompatButton3;
        this.deleteLine = view3;
        this.profileButton = appCompatButton4;
        this.profileLine = view4;
        this.reportButton = appCompatButton5;
    }

    public static DialogChatMenuBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogChatMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static DialogChatMenuBinding bind(View view, Object obj) {
        return (DialogChatMenuBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_chat_menu);
    }

    @Deprecated
    public static DialogChatMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (DialogChatMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_chat_menu, viewGroup, z10, obj);
    }

    public static DialogChatMenuBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogChatMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogChatMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_chat_menu, null, false, obj);
    }
}
