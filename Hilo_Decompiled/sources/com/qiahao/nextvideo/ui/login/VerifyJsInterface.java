package com.qiahao.nextvideo.ui.login;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.qiahao.base_common.utils.HiloUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/VerifyJsInterface;", "", "context", "Landroid/content/Context;", "webView", "Landroid/webkit/WebView;", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "str", "", "<init>", "(Landroid/content/Context;Landroid/webkit/WebView;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "getListener", "()Lkotlin/jvm/functions/Function1;", "getSlideData", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VerifyJsInterface {

    @NotNull
    private Context context;

    @NotNull
    private final Function1<String, Unit> listener;

    @NotNull
    private WebView webView;

    /* JADX WARN: Multi-variable type inference failed */
    public VerifyJsInterface(@NotNull Context context, @NotNull WebView webView, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(function1, "listener");
        this.context = context;
        this.webView = webView;
        this.listener = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSlideData$lambda$0(VerifyJsInterface verifyJsInterface, String str) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            verifyJsInterface.listener.invoke(str);
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Function1<String, Unit> getListener() {
        return this.listener;
    }

    @JavascriptInterface
    public final void getSlideData(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.webView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.login.r0
            @Override // java.lang.Runnable
            public final void run() {
                VerifyJsInterface.getSlideData$lambda$0(VerifyJsInterface.this, str);
            }
        });
    }

    @NotNull
    public final WebView getWebView() {
        return this.webView;
    }

    public final void setContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void setWebView(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<set-?>");
        this.webView = webView;
    }
}
