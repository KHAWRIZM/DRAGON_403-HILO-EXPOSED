package com.qiahao.nextvideo.ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.DialogH5GameBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.webview.JsInterfaceListener;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0007J\b\u0010'\u001a\u00020#H\u0003J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020#H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0019H\u0016J\b\u0010-\u001a\u00020#H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/H5GameDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogH5GameBinding;", "Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/GameConfiguration;)V", "getData", "()Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "jsInterface", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "getJsInterface", "()Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "setJsInterface", "(Lcom/qiahao/nextvideo/ui/webview/JsInterface;)V", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "getMWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setMWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getLayoutResId", "", "isBottomStyle", "", "onInitialize", "", "onVideoEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "initWebView", "openGroupPager", "groupId", "dismiss", "openPersonPage", SupportGiftRankActivity.EXTERNAL_ID, "onBackPressed", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class H5GameDialog extends BaseBindingDialog<DialogH5GameBinding> implements JsInterfaceListener {

    @NotNull
    private final GameConfiguration data;
    public JsInterface jsInterface;
    public WebChromeClient mWebChromeClient;

    @NotNull
    private String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H5GameDialog(@NotNull Context context, @NotNull GameConfiguration gameConfiguration) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameConfiguration, "data");
        this.data = gameConfiguration;
        this.url = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    private final void initWebView() {
        setBackgroundDimEnabled(false);
        try {
            ((DialogH5GameBinding) getBinding()).bg.setBackgroundColor(Color.parseColor(this.data.getThemeColor()));
        } catch (Exception unused) {
        }
        ImageView imageView = ((DialogH5GameBinding) getBinding()).gameIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "gameIcon");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(this.data.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        TextView textView = ((DialogH5GameBinding) getBinding()).gameTitle;
        String title = this.data.getTitle();
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        View view = ((DialogH5GameBinding) getBinding()).topBg;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        String themeColor = this.data.getThemeColor();
        if (themeColor == null) {
            themeColor = "#671bcf";
        }
        view.setBackground(shapeUtil.createShapeTop(themeColor, 14));
        ViewGroup.LayoutParams layoutParams = ((DialogH5GameBinding) getBinding()).webView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
        ((ConstraintLayout.b) layoutParams2).I = "1:" + this.data.getRate();
        ((DialogH5GameBinding) getBinding()).webView.setLayoutParams(layoutParams2);
        WebSettings settings = ((DialogH5GameBinding) getBinding()).webView.getSettings();
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setDatabaseEnabled(true);
        settings.setMixedContentMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        ((DialogH5GameBinding) getBinding()).webView.setBackgroundColor(0);
        ((DialogH5GameBinding) getBinding()).webView.getBackground().setAlpha(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WebView webView = ((DialogH5GameBinding) getBinding()).webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        JsInterface jsInterface = new JsInterface(context, webView);
        jsInterface.setListener(this);
        setJsInterface(jsInterface);
        ((DialogH5GameBinding) getBinding()).webView.addJavascriptInterface(getJsInterface(), "androidJsObject");
        ((DialogH5GameBinding) getBinding()).webView.setWebViewClient(new WebViewClient() { // from class: com.qiahao.nextvideo.ui.webview.H5GameDialog$initWebView$3
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view2, String url) {
                super.onPageFinished(view2, url);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view2, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view2, handler, error);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view2, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view2, request);
            }
        });
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.qiahao.nextvideo.ui.webview.H5GameDialog$initWebView$4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view2, int newProgress) {
                super.onProgressChanged(view2, newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view2, String title2) {
                super.onReceivedTitle(view2, title2);
            }
        };
        ((DialogH5GameBinding) getBinding()).webView.setWebChromeClient(webChromeClient);
        setMWebChromeClient(webChromeClient);
        ((DialogH5GameBinding) getBinding()).cloase.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                H5GameDialog.this.dismiss();
            }
        });
    }

    public void dismiss() {
        super.dismiss();
        ((DialogH5GameBinding) getBinding()).webView.destroy();
        cf.c.c().r(this);
    }

    @NotNull
    public final GameConfiguration getData() {
        return this.data;
    }

    @NotNull
    public final JsInterface getJsInterface() {
        JsInterface jsInterface = this.jsInterface;
        if (jsInterface != null) {
            return jsInterface;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        return null;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_h5_game;
    }

    @NotNull
    public final WebChromeClient getMWebChromeClient() {
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (webChromeClient != null) {
            return webChromeClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWebChromeClient");
        return null;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        super/*android.app.Dialog*/.onBackPressed();
        if (((DialogH5GameBinding) getBinding()).webView.canGoBack()) {
            ((DialogH5GameBinding) getBinding()).webView.goBack();
        } else {
            dismiss();
        }
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        cf.c.c().p(this);
        NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
        String url = this.data.getUrl();
        if (url == null) {
            url = "";
        }
        this.url = navigationHelper.addUserStatus(url);
        initWebView();
        ((DialogH5GameBinding) getBinding()).webView.loadUrl(this.url);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void onProgressChanged(int i) {
        JsInterfaceListener.DefaultImpls.onProgressChanged(this, i);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void onReceivedTitle(@Nullable String str) {
        JsInterfaceListener.DefaultImpls.onReceivedTitle(this, str);
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "refresh_h5")) {
            ((DialogH5GameBinding) getBinding()).webView.loadUrl(this.url);
        }
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openGroupPager(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        JsInterfaceListener.DefaultImpls.openGroupPager(this, groupId);
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, groupId, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openGroupSupport() {
        JsInterfaceListener.DefaultImpls.openGroupSupport(this);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openPersonPage(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    public final void setJsInterface(@NotNull JsInterface jsInterface) {
        Intrinsics.checkNotNullParameter(jsInterface, "<set-?>");
        this.jsInterface = jsInterface;
    }

    public final void setMWebChromeClient(@NotNull WebChromeClient webChromeClient) {
        Intrinsics.checkNotNullParameter(webChromeClient, "<set-?>");
        this.mWebChromeClient = webChromeClient;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}
