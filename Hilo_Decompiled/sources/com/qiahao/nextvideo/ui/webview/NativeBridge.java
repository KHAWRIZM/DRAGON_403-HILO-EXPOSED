package com.qiahao.nextvideo.ui.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.qiahao.nextvideo.data.baishun.GetConfigData;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/NativeBridge;", "", "context", "Landroid/content/Context;", "webView", "Landroid/webkit/WebView;", "<init>", "(Landroid/content/Context;Landroid/webkit/WebView;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "mListener", "Lcom/qiahao/nextvideo/ui/webview/JsNativeBridgeListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/webview/JsNativeBridgeListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/webview/JsNativeBridgeListener;)V", "getConfig", "", "params", "", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "gameRecharge", "gameLoaded", "callJs", "str", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NativeBridge {

    @NotNull
    private Context context;

    @Nullable
    private JsNativeBridgeListener mListener;

    @NotNull
    private WebView webView;

    public NativeBridge(@NotNull Context context, @NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.context = context;
        this.webView = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callJs$lambda$1(NativeBridge nativeBridge, String str) {
        nativeBridge.webView.loadUrl("javascript:" + str);
    }

    public final void callJs(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.webView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.webview.h0
            @Override // java.lang.Runnable
            public final void run() {
                NativeBridge.callJs$lambda$1(NativeBridge.this, str);
            }
        });
    }

    @JavascriptInterface
    public final void destroy(@NotNull String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        JsNativeBridgeListener jsNativeBridgeListener = this.mListener;
        if (jsNativeBridgeListener != null) {
            jsNativeBridgeListener.destroy();
        }
    }

    @JavascriptInterface
    public final void gameLoaded(@NotNull String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        JsNativeBridgeListener jsNativeBridgeListener = this.mListener;
        if (jsNativeBridgeListener != null) {
            jsNativeBridgeListener.gameLoaded();
        }
    }

    @JavascriptInterface
    public final void gameRecharge(@NotNull String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        JsNativeBridgeListener jsNativeBridgeListener = this.mListener;
        if (jsNativeBridgeListener != null) {
            jsNativeBridgeListener.gameRecharge();
        }
    }

    @JavascriptInterface
    public final void getConfig(@NotNull String params) {
        GetConfigData config;
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            String optString = new JSONObject(params).optString("jsCallback");
            JsNativeBridgeListener jsNativeBridgeListener = this.mListener;
            if (jsNativeBridgeListener != null && (config = jsNativeBridgeListener.getConfig()) != null) {
                callJs(optString + "(" + new com.google.gson.d().s(config) + ")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final JsNativeBridgeListener getMListener() {
        return this.mListener;
    }

    @NotNull
    public final WebView getWebView() {
        return this.webView;
    }

    public final void setContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void setMListener(@Nullable JsNativeBridgeListener jsNativeBridgeListener) {
        this.mListener = jsNativeBridgeListener;
    }

    public final void setWebView(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<set-?>");
        this.webView = webView;
    }
}
