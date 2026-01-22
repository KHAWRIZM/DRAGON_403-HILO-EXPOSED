package com.qiahao.nextvideo.ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.qiahao.base_common.navigation.NavigationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010$\u001a\u00020%H\u0003J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001fJ\b\u0010(\u001a\u00020%H\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/BaseWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "jsInterface", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "getJsInterface", "()Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "setJsInterface", "(Lcom/qiahao/nextvideo/ui/webview/JsInterface;)V", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "getMWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setMWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "mListener", "Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;)V", "mUrl", "", "getMUrl", "()Ljava/lang/String;", "setMUrl", "(Ljava/lang/String;)V", "initWeView", "", "loadWebViewUrl", "url", "onDetachedFromWindow", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseWebView.kt\ncom/qiahao/nextvideo/ui/webview/BaseWebView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n1#2:115\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BaseWebView extends WebView {

    @Nullable
    private JsInterface jsInterface;

    @Nullable
    private JsInterfaceListener mListener;

    @NotNull
    private String mUrl;

    @Nullable
    private WebChromeClient mWebChromeClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mUrl = "";
        initWeView();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void initWeView() {
        setBackgroundColor(0);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        JsInterface jsInterface = new JsInterface(context, this);
        this.jsInterface = jsInterface;
        JsInterfaceListener jsInterfaceListener = this.mListener;
        if (jsInterfaceListener != null) {
            jsInterface.setListener(jsInterfaceListener);
        }
        addJavascriptInterface(jsInterface, "androidJsObject");
        getSettings().setMixedContentMode(2);
        setWebViewClient(new WebViewClient() { // from class: com.qiahao.nextvideo.ui.webview.BaseWebView$initWeView$3
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        this.mWebChromeClient = new WebChromeClient() { // from class: com.qiahao.nextvideo.ui.webview.BaseWebView$initWeView$4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                JsInterfaceListener mListener = BaseWebView.this.getMListener();
                if (mListener != null) {
                    mListener.onProgressChanged(newProgress);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                JsInterfaceListener mListener = BaseWebView.this.getMListener();
                if (mListener != null) {
                    mListener.onReceivedTitle(title);
                }
            }
        };
    }

    @Nullable
    public final JsInterface getJsInterface() {
        return this.jsInterface;
    }

    @Nullable
    public final JsInterfaceListener getMListener() {
        return this.mListener;
    }

    @NotNull
    public final String getMUrl() {
        return this.mUrl;
    }

    @Nullable
    public final WebChromeClient getMWebChromeClient() {
        return this.mWebChromeClient;
    }

    public final void loadWebViewUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String addUserStatus = NavigationHelper.INSTANCE.addUserStatus(url);
        this.mUrl = addUserStatus;
        loadUrl(addUserStatus);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.jsInterface = null;
        this.mListener = null;
        this.mWebChromeClient = null;
    }

    public final void setJsInterface(@Nullable JsInterface jsInterface) {
        this.jsInterface = jsInterface;
    }

    public final void setMListener(@Nullable JsInterfaceListener jsInterfaceListener) {
        this.mListener = jsInterfaceListener;
    }

    public final void setMUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mUrl = str;
    }

    public final void setMWebChromeClient(@Nullable WebChromeClient webChromeClient) {
        this.mWebChromeClient = webChromeClient;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.mUrl = "";
        initWeView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWebView(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        this.mUrl = "";
        initWeView();
    }
}
