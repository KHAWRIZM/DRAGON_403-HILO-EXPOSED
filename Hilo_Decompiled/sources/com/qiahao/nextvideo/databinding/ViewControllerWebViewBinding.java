package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerWebViewBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final WebView fragmentAgreementWebview;
    public final AppCompatTextView titleTextView;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerWebViewBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, WebView webView, AppCompatTextView appCompatTextView, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.fragmentAgreementWebview = webView;
        this.titleTextView = appCompatTextView;
        this.toolbar = toolbar;
    }

    public static ViewControllerWebViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerWebViewBinding bind(View view, Object obj) {
        return (ViewControllerWebViewBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_web_view);
    }

    @Deprecated
    public static ViewControllerWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerWebViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_web_view, viewGroup, z, obj);
    }

    public static ViewControllerWebViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerWebViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerWebViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_web_view, (ViewGroup) null, false, obj);
    }
}
