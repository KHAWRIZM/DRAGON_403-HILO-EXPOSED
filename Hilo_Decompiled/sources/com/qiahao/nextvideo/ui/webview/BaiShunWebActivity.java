package com.qiahao.nextvideo.ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowInsetsController;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.view.g3;
import androidx.core.view.h3;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.baishun.BaiShunData;
import com.qiahao.nextvideo.data.baishun.GameConfig;
import com.qiahao.nextvideo.data.baishun.GetConfigData;
import com.qiahao.nextvideo.databinding.ActivityDefaultWebviewBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.gem.GemStoreDialog;
import com.qiahao.nextvideo.ui.webview.JsNativeBridgeListener;
import com.qiahao.nextvideo.utilities.ActivityUtilKt;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.apache.commons.sudcompress.archivers.zip.UnixStat;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0003¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001f\u0010\u0005R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010\nR\"\u0010E\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010A\u001a\u0004\bF\u0010C\"\u0004\bG\u0010\nR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/BaiShunWebActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityDefaultWebviewBinding;", "Lcom/qiahao/nextvideo/ui/webview/JsNativeBridgeListener;", "<init>", "()V", "", "url", "", "analyzeH5", "(Ljava/lang/String;)V", "showWebView", "initWeView", "requestGameConfig", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "event", "onH5Event", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "gameRecharge", "gameLoaded", "Lcom/qiahao/nextvideo/data/baishun/GetConfigData;", "getConfig", "()Lcom/qiahao/nextvideo/data/baishun/GetConfigData;", "onBackPressed", "onResume", "finish", "onDestroy", "Lcom/qiahao/nextvideo/ui/webview/NativeBridge;", "jsInterface", "Lcom/qiahao/nextvideo/ui/webview/NativeBridge;", "getJsInterface", "()Lcom/qiahao/nextvideo/ui/webview/NativeBridge;", "setJsInterface", "(Lcom/qiahao/nextvideo/ui/webview/NativeBridge;)V", "Landroid/webkit/WebChromeClient;", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "getMWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setMWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "gameConfig", "Lcom/qiahao/nextvideo/data/baishun/GetConfigData;", "getGameConfig", "setGameConfig", "(Lcom/qiahao/nextvideo/data/baishun/GetConfigData;)V", "Lcom/qiahao/nextvideo/ui/gem/GemStoreDialog;", "gemStoreDialog", "Lcom/qiahao/nextvideo/ui/gem/GemStoreDialog;", "getGemStoreDialog", "()Lcom/qiahao/nextvideo/ui/gem/GemStoreDialog;", "setGemStoreDialog", "(Lcom/qiahao/nextvideo/ui/gem/GemStoreDialog;)V", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", GameMatchActivity.GAME_ID, "getGameId", "setGameId", "", "mNotStatus", "Z", "getMNotStatus", "()Z", "setMNotStatus", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaiShunWebActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaiShunWebActivity.kt\ncom/qiahao/nextvideo/ui/webview/BaiShunWebActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,319:1\n167#2,2:320\n*S KotlinDebug\n*F\n+ 1 BaiShunWebActivity.kt\ncom/qiahao/nextvideo/ui/webview/BaiShunWebActivity\n*L\n106#1:320,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BaiShunWebActivity extends HiloBaseBindingActivity<ActivityDefaultWebviewBinding> implements JsNativeBridgeListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String URL = "url";

    @Nullable
    private GetConfigData gameConfig;

    @Nullable
    private GemStoreDialog gemStoreDialog;
    public NativeBridge jsInterface;
    private boolean mNotStatus;
    public WebChromeClient mWebChromeClient;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    @NotNull
    private String url = "";

    @NotNull
    private String gameId = "";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/BaiShunWebActivity$Companion;", "", "<init>", "()V", "URL", "", "start", "", "context", "Landroid/content/Context;", "url", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent putExtra = new Intent(context, (Class<?>) BaiShunWebActivity.class).putExtra("url", url);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void analyzeH5(String url) {
        String queryParameter = Uri.parse(url).getQueryParameter("hideNav");
        if (queryParameter == null) {
            queryParameter = MessageService.MSG_DB_READY_REPORT;
        }
        this.mNotStatus = Intrinsics.areEqual(URLDecoder.decode(queryParameter, "UTF-8"), MessageService.MSG_DB_NOTIFY_REACHED);
        LinearLayout linearLayout = ((ActivityDefaultWebviewBinding) getBinding()).linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "linearLayout");
        getStatusBarTopOrBottom(linearLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.webview.a
            public final Object invoke(Object obj, Object obj2) {
                Unit analyzeH5$lambda$0;
                analyzeH5$lambda$0 = BaiShunWebActivity.analyzeH5$lambda$0(BaiShunWebActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return analyzeH5$lambda$0;
            }
        });
        if (this.mNotStatus) {
            ((ActivityDefaultWebviewBinding) getBinding()).toolbar.setVisibility(8);
            ((ActivityDefaultWebviewBinding) getBinding()).myProgressBar.setVisibility(8);
            ActivityUtilKt.setSystemBarsVisibility(this, false, false);
            if (Build.VERSION.SDK_INT >= 28) {
                q6.c.a(getWindow().getAttributes(), 1);
            }
            LinearLayout linearLayout2 = ((ActivityDefaultWebviewBinding) getBinding()).linearLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "linearLayout");
            getStatusBarTopOrBottom(linearLayout2, new Function2() { // from class: com.qiahao.nextvideo.ui.webview.b
                public final Object invoke(Object obj, Object obj2) {
                    Unit analyzeH5$lambda$1;
                    analyzeH5$lambda$1 = BaiShunWebActivity.analyzeH5$lambda$1(BaiShunWebActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return analyzeH5$lambda$1;
                }
            });
        } else {
            ((ActivityDefaultWebviewBinding) getBinding()).toolbar.setVisibility(0);
            ((ActivityDefaultWebviewBinding) getBinding()).myProgressBar.setVisibility(0);
            ActivityUtilKt.setSystemBarsVisibility(this, true, true);
        }
        String queryParameter2 = Uri.parse(url).getQueryParameter(GameMatchActivity.GAME_ID);
        if (queryParameter2 == null) {
            queryParameter2 = "";
        }
        this.gameId = queryParameter2;
        if (!TextUtils.isEmpty(queryParameter2)) {
            setShowGiftTip(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit analyzeH5$lambda$0(BaiShunWebActivity baiShunWebActivity, int i, int i2) {
        ViewKtxKt.setMargin(baiShunWebActivity.getBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit analyzeH5$lambda$1(BaiShunWebActivity baiShunWebActivity, int i, int i2) {
        ViewKtxKt.setMargin(baiShunWebActivity.getBinding().toolbar, 0, 0, 0, 0);
        FrameLayout frameLayout = baiShunWebActivity.getBinding().activityMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "activityMainContainer");
        frameLayout.setPadding(0, 0, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gameRecharge$lambda$8$lambda$7(BaiShunWebActivity baiShunWebActivity) {
        baiShunWebActivity.gemStoreDialog = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    private final void initWeView() {
        WebSettings settings = ((ActivityDefaultWebviewBinding) getBinding()).webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setAllowFileAccess(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(2);
        settings.setAllowContentAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        WebView webView = ((ActivityDefaultWebviewBinding) getBinding()).webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        NativeBridge nativeBridge = new NativeBridge(this, webView);
        nativeBridge.setMListener(this);
        setJsInterface(nativeBridge);
        ((ActivityDefaultWebviewBinding) getBinding()).webView.addJavascriptInterface(getJsInterface(), "NativeBridge");
        ((ActivityDefaultWebviewBinding) getBinding()).webView.setBackgroundColor(0);
        ((ActivityDefaultWebviewBinding) getBinding()).getRoot().setBackgroundColor(0);
        ((ActivityDefaultWebviewBinding) getBinding()).webView.setWebViewClient(new WebViewClient() { // from class: com.qiahao.nextvideo.ui.webview.BaiShunWebActivity$initWeView$3
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
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.qiahao.nextvideo.ui.webview.BaiShunWebActivity$initWeView$4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                ActivityDefaultWebviewBinding binding;
                ActivityDefaultWebviewBinding binding2;
                ActivityDefaultWebviewBinding binding3;
                ActivityDefaultWebviewBinding binding4;
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    binding4 = BaiShunWebActivity.this.getBinding();
                    binding4.myProgressBar.setVisibility(8);
                    return;
                }
                binding = BaiShunWebActivity.this.getBinding();
                if (binding.myProgressBar.getVisibility() == 8) {
                    binding3 = BaiShunWebActivity.this.getBinding();
                    binding3.myProgressBar.setVisibility(0);
                }
                binding2 = BaiShunWebActivity.this.getBinding();
                binding2.myProgressBar.setProgress(newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                ActivityDefaultWebviewBinding binding;
                super.onReceivedTitle(view, title);
                binding = BaiShunWebActivity.this.getBinding();
                binding.title.setText(title);
            }
        };
        ((ActivityDefaultWebviewBinding) getBinding()).webView.setWebChromeClient(webChromeClient);
        setMWebChromeClient(webChromeClient);
        ((ActivityDefaultWebviewBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaiShunWebActivity.initWeView$lambda$5(BaiShunWebActivity.this, view);
            }
        });
        ((ActivityDefaultWebviewBinding) getBinding()).refreshImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaiShunWebActivity.initWeView$lambda$6(BaiShunWebActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWeView$lambda$5(BaiShunWebActivity baiShunWebActivity, View view) {
        if (baiShunWebActivity.getBinding().webView.canGoBack()) {
            baiShunWebActivity.getBinding().webView.goBack();
        } else {
            baiShunWebActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWeView$lambda$6(BaiShunWebActivity baiShunWebActivity, View view) {
        baiShunWebActivity.showWebView(baiShunWebActivity.url);
    }

    private final void requestGameConfig() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().bsCode(this.gameId), new Function1() { // from class: com.qiahao.nextvideo.ui.webview.e
            public final Object invoke(Object obj) {
                Unit requestGameConfig$lambda$9;
                requestGameConfig$lambda$9 = BaiShunWebActivity.requestGameConfig$lambda$9(BaiShunWebActivity.this, (ApiResponse) obj);
                return requestGameConfig$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.webview.f
            public final Object invoke(Object obj) {
                Unit requestGameConfig$lambda$10;
                requestGameConfig$lambda$10 = BaiShunWebActivity.requestGameConfig$lambda$10(BaiShunWebActivity.this, (Throwable) obj);
                return requestGameConfig$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestGameConfig$lambda$10(BaiShunWebActivity baiShunWebActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(baiShunWebActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, baiShunWebActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        baiShunWebActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGameConfig$lambda$9(BaiShunWebActivity baiShunWebActivity, ApiResponse apiResponse) {
        String currencyIcon;
        Integer sceneMode;
        int i;
        Integer gsp;
        String str;
        String str2;
        String str3;
        int i2;
        Intrinsics.checkNotNullParameter(apiResponse, "data");
        String str4 = null;
        baiShunWebActivity.gameConfig = new GetConfigData(null, null, null, null, null, null, null, null, 0, UnixStat.DEFAULT_LINK_PERM, null);
        int i3 = 0;
        GameConfig gameConfig = new GameConfig(0, null, 3, null);
        GetConfigData getConfigData = baiShunWebActivity.gameConfig;
        if (getConfigData != null) {
            getConfigData.setAppChannel(ResourcesKtxKt.getStringById(baiShunWebActivity, 2131952064));
        }
        GetConfigData getConfigData2 = baiShunWebActivity.gameConfig;
        if (getConfigData2 != null) {
            AppService service = AppController.INSTANCE.getService();
            if (service != null && service.checkServerDebug()) {
                i2 = 2131952065;
            } else {
                i2 = 2131952066;
            }
            getConfigData2.setAppId(Long.valueOf(Long.parseLong(ResourcesKtxKt.getStringById(baiShunWebActivity, i2))));
        }
        GetConfigData getConfigData3 = baiShunWebActivity.gameConfig;
        String str5 = "";
        if (getConfigData3 != null) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (str3 = user.getExternalId()) == null) {
                str3 = "";
            }
            getConfigData3.setUserId(str3);
        }
        GetConfigData getConfigData4 = baiShunWebActivity.gameConfig;
        if (getConfigData4 != null) {
            BaiShunData baiShunData = (BaiShunData) apiResponse.getData();
            if (baiShunData == null || (str2 = baiShunData.getCode()) == null) {
                str2 = "";
            }
            getConfigData4.setCode(str2);
        }
        GetConfigData getConfigData5 = baiShunWebActivity.gameConfig;
        if (getConfigData5 != null) {
            getConfigData5.setRoomId("");
        }
        GetConfigData getConfigData6 = baiShunWebActivity.gameConfig;
        if (getConfigData6 != null) {
            BaiShunData baiShunData2 = (BaiShunData) apiResponse.getData();
            if (baiShunData2 != null) {
                str = baiShunData2.getGameMode();
            } else {
                str = null;
            }
            getConfigData6.setGameMode(str);
        }
        GetConfigData getConfigData7 = baiShunWebActivity.gameConfig;
        if (getConfigData7 != null) {
            if (getConfigData7 != null) {
                str4 = getConfigData7.checkLanguage();
            }
            getConfigData7.setLanguage(str4);
        }
        GetConfigData getConfigData8 = baiShunWebActivity.gameConfig;
        if (getConfigData8 != null) {
            BaiShunData baiShunData3 = (BaiShunData) apiResponse.getData();
            if (baiShunData3 != null && (gsp = baiShunData3.getGsp()) != null) {
                i = gsp.intValue();
            } else {
                i = 0;
            }
            getConfigData8.setGsp(i);
        }
        BaiShunData baiShunData4 = (BaiShunData) apiResponse.getData();
        if (baiShunData4 != null && (sceneMode = baiShunData4.getSceneMode()) != null) {
            i3 = sceneMode.intValue();
        }
        gameConfig.setSceneMode(i3);
        BaiShunData baiShunData5 = (BaiShunData) apiResponse.getData();
        if (baiShunData5 != null && (currencyIcon = baiShunData5.getCurrencyIcon()) != null) {
            str5 = currencyIcon;
        }
        gameConfig.setCurrencyIcon(str5);
        GetConfigData getConfigData9 = baiShunWebActivity.gameConfig;
        if (getConfigData9 != null) {
            getConfigData9.setGameConfig(gameConfig);
        }
        baiShunWebActivity.showWebView(baiShunWebActivity.url);
        return Unit.INSTANCE;
    }

    private final void showWebView(String url) {
        getBinding().webView.loadUrl(url);
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str) {
        INSTANCE.start(context, str);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsNativeBridgeListener
    public void destroy() {
        JsNativeBridgeListener.DefaultImpls.destroy(this);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
        ((ActivityDefaultWebviewBinding) getBinding()).webView.destroy();
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsNativeBridgeListener
    public void gameLoaded() {
        JsNativeBridgeListener.DefaultImpls.gameLoaded(this);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsNativeBridgeListener
    public void gameRecharge() {
        JsNativeBridgeListener.DefaultImpls.gameRecharge(this);
        GemStoreDialog gemStoreDialog = this.gemStoreDialog;
        if (gemStoreDialog != null) {
            gemStoreDialog.dismiss();
        }
        if (this.gemStoreDialog == null) {
            GemStoreDialog gemStoreDialog2 = new GemStoreDialog();
            gemStoreDialog2.setMListener(new Function0() { // from class: com.qiahao.nextvideo.ui.webview.g
                public final Object invoke() {
                    Unit gameRecharge$lambda$8$lambda$7;
                    gameRecharge$lambda$8$lambda$7 = BaiShunWebActivity.gameRecharge$lambda$8$lambda$7(BaiShunWebActivity.this);
                    return gameRecharge$lambda$8$lambda$7;
                }
            });
            this.gemStoreDialog = gemStoreDialog2;
        }
        GemStoreDialog gemStoreDialog3 = this.gemStoreDialog;
        if (gemStoreDialog3 != null) {
            gemStoreDialog3.show(getSupportFragmentManager(), "other");
        }
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsNativeBridgeListener
    @Nullable
    /* renamed from: getConfig, reason: from getter */
    public GetConfigData getGameConfig() {
        return this.gameConfig;
    }

    @Nullable
    public final GetConfigData getGameConfig() {
        return this.gameConfig;
    }

    @NotNull
    public final String getGameId() {
        return this.gameId;
    }

    @Nullable
    public final GemStoreDialog getGemStoreDialog() {
        return this.gemStoreDialog;
    }

    @NotNull
    public final NativeBridge getJsInterface() {
        NativeBridge nativeBridge = this.jsInterface;
        if (nativeBridge != null) {
            return nativeBridge;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_default_webview;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    public final boolean getMNotStatus() {
        return this.mNotStatus;
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

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onBackPressed() {
        super.onBackPressed();
        if (getBinding().webView.canGoBack()) {
            getBinding().webView.goBack();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getBinding().webView.destroy();
        this.mCompositeDisposable.d();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onH5Event(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        if (Intrinsics.areEqual(type, "refresh_h5")) {
            getBinding().webView.loadUrl(this.url);
        } else if (Intrinsics.areEqual(type, "H5_FINISH")) {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
        String stringExtra = getIntent().getStringExtra("url");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String addUserStatus = navigationHelper.addUserStatus(stringExtra);
        this.url = addUserStatus;
        analyzeH5(addUserStatus);
        initWeView();
        requestGameConfig();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        WindowInsetsController a;
        super.onResume();
        if (this.mNotStatus) {
            ActivityUtilKt.setSystemBarsVisibility(this, false, false);
            int i = Build.VERSION.SDK_INT;
            if (i >= 29 && i >= 30 && (a = g3.a(getWindow())) != null) {
                h3.a(a, 2);
                return;
            }
            return;
        }
        ActivityUtilKt.setSystemBarsVisibility(this, true, true);
    }

    public final void setGameConfig(@Nullable GetConfigData getConfigData) {
        this.gameConfig = getConfigData;
    }

    public final void setGameId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameId = str;
    }

    public final void setGemStoreDialog(@Nullable GemStoreDialog gemStoreDialog) {
        this.gemStoreDialog = gemStoreDialog;
    }

    public final void setJsInterface(@NotNull NativeBridge nativeBridge) {
        Intrinsics.checkNotNullParameter(nativeBridge, "<set-?>");
        this.jsInterface = nativeBridge;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMNotStatus(boolean z) {
        this.mNotStatus = z;
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
