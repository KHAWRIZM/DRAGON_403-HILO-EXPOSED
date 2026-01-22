package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogUploadBinding extends ViewDataBinding {
    public final TextView goToGoogle;
    public final TextView textView3;
    public final TextView textView4;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogUploadBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.goToGoogle = textView;
        this.textView3 = textView2;
        this.textView4 = textView3;
    }

    public static DialogUploadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogUploadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogUploadBinding bind(View view, Object obj) {
        return (DialogUploadBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_upload);
    }

    @Deprecated
    public static DialogUploadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogUploadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_upload, viewGroup, z, obj);
    }

    public static DialogUploadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogUploadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogUploadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_upload, (ViewGroup) null, false, obj);
    }
}
