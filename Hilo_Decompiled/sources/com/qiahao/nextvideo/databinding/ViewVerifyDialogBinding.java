package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewVerifyDialogBinding extends ViewDataBinding {
    public final TextView cancel;
    public final WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewVerifyDialogBinding(Object obj, View view, int i, TextView textView, WebView webView) {
        super(obj, view, i);
        this.cancel = textView;
        this.webView = webView;
    }

    public static ViewVerifyDialogBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewVerifyDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewVerifyDialogBinding bind(View view, Object obj) {
        return (ViewVerifyDialogBinding) ViewDataBinding.bind(obj, view, R.layout.view_verify_dialog);
    }

    @Deprecated
    public static ViewVerifyDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewVerifyDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_verify_dialog, viewGroup, z, obj);
    }

    public static ViewVerifyDialogBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewVerifyDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewVerifyDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_verify_dialog, (ViewGroup) null, false, obj);
    }
}
