package com.qiahao.nextvideo.ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowInsetsController;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.core.view.g3;
import androidx.core.view.h3;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.databinding.ActivityHorizontalWebviewBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.webview.JsInterfaceListener;
import com.qiahao.nextvideo.utilities.ActivityUtilKt;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020 H\u0003J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0015H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0015H\u0016J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020 H\u0016J\b\u0010/\u001a\u00020 H\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/HorizontalWebActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityHorizontalWebviewBinding;", "Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "<init>", "()V", "jsInterface", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "getJsInterface", "()Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "setJsInterface", "(Lcom/qiahao/nextvideo/ui/webview/JsInterface;)V", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "getMWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setMWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "getLayoutResId", "", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "mH5Voice", "isJoinChannel", "", "mVoiceData", "LuserProxy/UserProxy1$H5GameVoiceChannelJoinLeave;", "onInitialize", "", "onH5Event", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "checkUrl", "joinChannel", "checkAudioPermission", "showWebView", "initWeView", "openGroupPager", "groupId", "openPersonPage", SupportGiftRankActivity.EXTERNAL_ID, "onBackPressed", "finish", "onResume", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHorizontalWebActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HorizontalWebActivity.kt\ncom/qiahao/nextvideo/ui/webview/HorizontalWebActivity\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,286:1\n29#2:287\n29#2:288\n*S KotlinDebug\n*F\n+ 1 HorizontalWebActivity.kt\ncom/qiahao/nextvideo/ui/webview/HorizontalWebActivity\n*L\n109#1:287\n113#1:288\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HorizontalWebActivity extends HiloBaseBindingActivity<ActivityHorizontalWebviewBinding> implements JsInterfaceListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String URL = "url";
    private boolean isJoinChannel;
    public JsInterface jsInterface;

    @Nullable
    private UserProxy1.H5GameVoiceChannelJoinLeave mVoiceData;
    public WebChromeClient mWebChromeClient;

    @NotNull
    private String url = "";

    @NotNull
    private String mH5Voice = "";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/HorizontalWebActivity$Companion;", "", "<init>", "()V", "URL", "", "start", "", "context", "Landroid/content/Context;", "url", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent putExtra = new Intent(context, (Class<?>) HorizontalWebActivity.class).putExtra("url", url);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean checkAudioPermission() {
        boolean m = w9.h.m(this, fa.b.o());
        if (!m) {
            w9.h.t(this).p(fa.b.o()).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.ui.webview.w
                public final void onResult(List list, List list2) {
                    HorizontalWebActivity.checkAudioPermission$lambda$3(HorizontalWebActivity.this, list, list2);
                }
            });
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAudioPermission$lambda$3(HorizontalWebActivity horizontalWebActivity, List list, List list2) {
        UserProxy1.H5GameVoiceChannelJoinLeave h5GameVoiceChannelJoinLeave;
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty() && (h5GameVoiceChannelJoinLeave = horizontalWebActivity.mVoiceData) != null) {
            HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
            String token = h5GameVoiceChannelJoinLeave.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            String channelId = h5GameVoiceChannelJoinLeave.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
            hiloRtcEngine.joinChannel(token, channelId, h5GameVoiceChannelJoinLeave.getAgoraId(), h5GameVoiceChannelJoinLeave.getProvider());
        }
    }

    private final void checkUrl() {
        String queryParameter = Uri.parse(this.url).getQueryParameter("h5Voice");
        if (queryParameter != null) {
            this.mH5Voice = URLDecoder.decode(queryParameter, "UTF-8");
        }
        if (!TextUtils.isEmpty(Uri.parse(this.url).getQueryParameter("game_id"))) {
            setShowGiftTip(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    private final void initWeView() {
        ActivityUtilKt.setSystemBarsVisibility(this, false, false);
        WebSettings settings = ((ActivityHorizontalWebviewBinding) getBinding()).webView.getSettings();
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
        WebView webView = ((ActivityHorizontalWebviewBinding) getBinding()).webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        JsInterface jsInterface = new JsInterface(this, webView);
        jsInterface.setListener(this);
        setJsInterface(jsInterface);
        ((ActivityHorizontalWebviewBinding) getBinding()).webView.addJavascriptInterface(getJsInterface(), "androidJsObject");
        ((ActivityHorizontalWebviewBinding) getBinding()).webView.setWebViewClient(new WebViewClient() { // from class: com.qiahao.nextvideo.ui.webview.HorizontalWebActivity$initWeView$3
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
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.qiahao.nextvideo.ui.webview.HorizontalWebActivity$initWeView$4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                ActivityHorizontalWebviewBinding binding;
                ActivityHorizontalWebviewBinding binding2;
                ActivityHorizontalWebviewBinding binding3;
                ActivityHorizontalWebviewBinding binding4;
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    binding4 = HorizontalWebActivity.this.getBinding();
                    binding4.myProgressBar.setVisibility(8);
                    return;
                }
                binding = HorizontalWebActivity.this.getBinding();
                ProgressBar progressBar = binding.myProgressBar;
                Intrinsics.checkNotNullExpressionValue(progressBar, "myProgressBar");
                if (progressBar.getVisibility() == 8) {
                    binding3 = HorizontalWebActivity.this.getBinding();
                    binding3.myProgressBar.setVisibility(0);
                }
                binding2 = HorizontalWebActivity.this.getBinding();
                binding2.myProgressBar.setProgress(newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        };
        ((ActivityHorizontalWebviewBinding) getBinding()).webView.setWebChromeClient(webChromeClient);
        setMWebChromeClient(webChromeClient);
    }

    private final void joinChannel() {
        UserProxy1.H5GameVoiceChannelJoinLeave h5GameVoiceChannelJoinLeave;
        this.isJoinChannel = true;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
        cf.c.c().l(new LiveEvent("EXIT_ROOM", DataExternalKt.createExitRoom(meetingRoomManager.getMGroupId(), 0)));
        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
        if (checkAudioPermission() && (h5GameVoiceChannelJoinLeave = this.mVoiceData) != null) {
            HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
            String token = h5GameVoiceChannelJoinLeave.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            String channelId = h5GameVoiceChannelJoinLeave.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
            hiloRtcEngine.joinChannel(token, channelId, h5GameVoiceChannelJoinLeave.getAgoraId(), h5GameVoiceChannelJoinLeave.getProvider());
        }
    }

    private final void showWebView(String url) {
        getBinding().webView.loadUrl(url);
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str) {
        INSTANCE.start(context, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
        ((ActivityHorizontalWebviewBinding) getBinding()).webView.destroy();
        if (this.isJoinChannel) {
            HiloRtcEngine.INSTANCE.leaveChannel();
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_horizontal_webview;
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

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onH5Event(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        switch (type.hashCode()) {
            case -1689495676:
                if (type.equals("H5_JOIN_CHANNEL_SUCCESS") && this.isJoinChannel) {
                    HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
                    hiloRtcEngine.setClientRole(1);
                    hiloRtcEngine.muteAllRemoteAudioStreams(false);
                    return;
                }
                return;
            case -321835855:
                if (type.equals("refresh_h5")) {
                    getBinding().webView.loadUrl(this.url);
                    return;
                }
                return;
            case 1374289957:
                if (type.equals("H5_FINISH")) {
                    finish();
                    return;
                }
                return;
            case 2063841559:
                if (type.equals("H5_GAME_VOICE")) {
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy1.H5GameVoiceChannelJoinLeave");
                    this.mVoiceData = (UserProxy1.H5GameVoiceChannelJoinLeave) data;
                    if (Intrinsics.areEqual(this.mH5Voice, MessageService.MSG_DB_NOTIFY_REACHED)) {
                        UserProxy1.H5GameVoiceChannelJoinLeave h5GameVoiceChannelJoinLeave = this.mVoiceData;
                        if (h5GameVoiceChannelJoinLeave != null && h5GameVoiceChannelJoinLeave.getType() == 1) {
                            joinChannel();
                            return;
                        } else {
                            if (this.isJoinChannel) {
                                HiloRtcEngine.INSTANCE.leaveChannel();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
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
        this.url = navigationHelper.addUserStatus(stringExtra);
        checkUrl();
        initWeView();
        showWebView(this.url);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void onProgressChanged(int i) {
        JsInterfaceListener.DefaultImpls.onProgressChanged(this, i);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void onReceivedTitle(@Nullable String str) {
        JsInterfaceListener.DefaultImpls.onReceivedTitle(this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        WindowInsetsController a;
        super.onResume();
        ActivityUtilKt.setSystemBarsVisibility(this, false, false);
        int i = Build.VERSION.SDK_INT;
        if (i >= 29 && i >= 30 && (a = g3.a(getWindow())) != null) {
            h3.a(a, 2);
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
