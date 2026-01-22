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
public abstract class PopupKeepCallTipsBinding extends ViewDataBinding {
    public final AppCompatTextView contentTextView;
    public final AppCompatButton okButton;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopupKeepCallTipsBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatButton appCompatButton) {
        super(obj, view, i);
        this.contentTextView = appCompatTextView;
        this.okButton = appCompatButton;
    }

    public static PopupKeepCallTipsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static PopupKeepCallTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static PopupKeepCallTipsBinding bind(View view, Object obj) {
        return (PopupKeepCallTipsBinding) ViewDataBinding.bind(obj, view, R.layout.popup_keep_call_tips);
    }

    @Deprecated
    public static PopupKeepCallTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopupKeepCallTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popup_keep_call_tips, viewGroup, z, obj);
    }

    public static PopupKeepCallTipsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static PopupKeepCallTipsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopupKeepCallTipsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.popup_keep_call_tips, (ViewGroup) null, false, obj);
    }
}
