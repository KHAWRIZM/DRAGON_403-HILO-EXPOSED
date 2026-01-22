package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogDeleteAccountBinding extends ViewDataBinding {
    public final AppCompatTextView descriptionText;
    public final AppCompatButton giveUpDelete;
    public final AppCompatButton switchAccounts;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogDeleteAccountBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2) {
        super(obj, view, i);
        this.descriptionText = appCompatTextView;
        this.giveUpDelete = appCompatButton;
        this.switchAccounts = appCompatButton2;
    }

    public static DialogDeleteAccountBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogDeleteAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogDeleteAccountBinding bind(View view, Object obj) {
        return (DialogDeleteAccountBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_delete_account);
    }

    @Deprecated
    public static DialogDeleteAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogDeleteAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_delete_account, viewGroup, z, obj);
    }

    public static DialogDeleteAccountBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogDeleteAccountBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogDeleteAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_delete_account, (ViewGroup) null, false, obj);
    }
}
