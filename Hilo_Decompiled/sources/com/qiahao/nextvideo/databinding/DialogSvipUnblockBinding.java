package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogSvipUnblockBinding extends ViewDataBinding {
    public final TextView cancel;
    public final TextView confirm;
    public final TextView content1;
    public final TextView content2;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogSvipUnblockBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.cancel = textView;
        this.confirm = textView2;
        this.content1 = textView3;
        this.content2 = textView4;
        this.title = appCompatTextView;
    }

    public static DialogSvipUnblockBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogSvipUnblockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogSvipUnblockBinding bind(View view, Object obj) {
        return (DialogSvipUnblockBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_svip_unblock);
    }

    @Deprecated
    public static DialogSvipUnblockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSvipUnblockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_svip_unblock, viewGroup, z, obj);
    }

    public static DialogSvipUnblockBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogSvipUnblockBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSvipUnblockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_svip_unblock, (ViewGroup) null, false, obj);
    }
}
