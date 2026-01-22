package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityDefaultWebviewBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final LinearLayout linearLayout;
    protected View.OnClickListener mClick;
    public final ProgressBar myProgressBar;
    public final AppCompatImageView refreshImageView;
    public final AppCompatTextView title;
    public final Toolbar toolbar;
    public final WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityDefaultWebviewBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, ProgressBar progressBar, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, Toolbar toolbar, WebView webView) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.linearLayout = linearLayout;
        this.myProgressBar = progressBar;
        this.refreshImageView = appCompatImageView2;
        this.title = appCompatTextView;
        this.toolbar = toolbar;
        this.webView = webView;
    }

    public static ActivityDefaultWebviewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityDefaultWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityDefaultWebviewBinding bind(View view, Object obj) {
        return (ActivityDefaultWebviewBinding) ViewDataBinding.bind(obj, view, R.layout.activity_default_webview);
    }

    @Deprecated
    public static ActivityDefaultWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDefaultWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_default_webview, viewGroup, z, obj);
    }

    public static ActivityDefaultWebviewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityDefaultWebviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDefaultWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_default_webview, (ViewGroup) null, false, obj);
    }
}
