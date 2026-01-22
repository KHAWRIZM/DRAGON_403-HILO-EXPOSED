package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityHorizontalWebviewBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    protected View.OnClickListener mClick;
    public final ProgressBar myProgressBar;
    public final WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityHorizontalWebviewBinding(Object obj, View view, int i, FrameLayout frameLayout, ProgressBar progressBar, WebView webView) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.myProgressBar = progressBar;
        this.webView = webView;
    }

    public static ActivityHorizontalWebviewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityHorizontalWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityHorizontalWebviewBinding bind(View view, Object obj) {
        return (ActivityHorizontalWebviewBinding) ViewDataBinding.bind(obj, view, R.layout.activity_horizontal_webview);
    }

    @Deprecated
    public static ActivityHorizontalWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityHorizontalWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_horizontal_webview, viewGroup, z, obj);
    }

    public static ActivityHorizontalWebviewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityHorizontalWebviewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityHorizontalWebviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_horizontal_webview, (ViewGroup) null, false, obj);
    }
}
