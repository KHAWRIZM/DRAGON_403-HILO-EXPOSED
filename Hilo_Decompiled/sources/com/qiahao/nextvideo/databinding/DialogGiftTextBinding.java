package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogGiftTextBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final AppCompatEditText editText;
    public final TextView number;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogGiftTextBinding(Object obj, View view, int i, TextView textView, TextView textView2, AppCompatEditText appCompatEditText, TextView textView3, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.cancel = textView;
        this.confirm = textView2;
        this.editText = appCompatEditText;
        this.number = textView3;
        this.title = appCompatTextView;
    }

    public static DialogGiftTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogGiftTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogGiftTextBinding bind(View view, Object obj) {
        return (DialogGiftTextBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_gift_text);
    }

    @Deprecated
    public static DialogGiftTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGiftTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gift_text, viewGroup, z, obj);
    }

    public static DialogGiftTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogGiftTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGiftTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_gift_text, (ViewGroup) null, false, obj);
    }
}
