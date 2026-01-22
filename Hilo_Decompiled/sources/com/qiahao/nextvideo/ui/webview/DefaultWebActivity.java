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
import androidx.core.view.g3;
import androidx.core.view.h3;
import androidx.core.view.w0;
import androidx.core.view.x2;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.databinding.ActivityDefaultWebviewBinding;
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
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00018B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u00100\u001a\u00020(H\u0003J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0015H\u0016J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020(H\u0016J\b\u00106\u001a\u00020(H\u0014J\b\u00107\u001a\u00020(H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/DefaultWebActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityDefaultWebviewBinding;", "Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "<init>", "()V", "jsInterface", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "getJsInterface", "()Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "setJsInterface", "(Lcom/qiahao/nextvideo/ui/webview/JsInterface;)V", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "getMWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setMWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "getLayoutResId", "", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "mTitle", "getMTitle", "setMTitle", "mNotStatus", "", "getMNotStatus", "()Z", "setMNotStatus", "(Z)V", "mH5Voice", "isJoinChannel", "mVoiceData", "LuserProxy/UserProxy1$H5GameVoiceChannelJoinLeave;", "onInitialize", "", "onH5Event", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "joinChannel", "checkAudioPermission", "analyzeH5", "showWebView", "initWeView", "openGroupPager", "groupId", "openPersonPage", SupportGiftRankActivity.EXTERNAL_ID, "onBackPressed", "onResume", "finish", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultWebActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultWebActivity.kt\ncom/qiahao/nextvideo/ui/webview/DefaultWebActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,355:1\n167#2,2:356\n*S KotlinDebug\n*F\n+ 1 DefaultWebActivity.kt\ncom/qiahao/nextvideo/ui/webview/DefaultWebActivity\n*L\n196#1:356,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DefaultWebActivity extends HiloBaseBindingActivity<ActivityDefaultWebviewBinding> implements JsInterfaceListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TITLE = "title";

    @NotNull
    public static final String URL = "url";
    private boolean isJoinChannel;
    public JsInterface jsInterface;
    private boolean mNotStatus;

    @Nullable
    private UserProxy1.H5GameVoiceChannelJoinLeave mVoiceData;
    public WebChromeClient mWebChromeClient;

    @NotNull
    private String url = "";

    @NotNull
    private String mTitle = "";

    @NotNull
    private String mH5Voice = "";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/DefaultWebActivity$Companion;", "", "<init>", "()V", "URL", "", "TITLE", "start", "", "context", "Landroid/content/Context;", "url", "title", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            companion.start(context, str, str2);
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String url, @Nullable String title) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent(context, (Class<?>) DefaultWebActivity.class);
            intent.putExtra("url", url);
            if (!TextUtils.isEmpty(title)) {
                intent.putExtra("title", title);
            }
            context.startActivity(intent);
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
        getStatusBarTopOrBottom(linearLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.webview.i
            public final Object invoke(Object obj, Object obj2) {
                Unit analyzeH5$lambda$3;
                analyzeH5$lambda$3 = DefaultWebActivity.analyzeH5$lambda$3(DefaultWebActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return analyzeH5$lambda$3;
            }
        });
        if (this.mNotStatus) {
            ((ActivityDefaultWebviewBinding) getBinding()).toolbar.setVisibility(8);
            ((ActivityDefaultWebviewBinding) getBinding()).myProgressBar.setVisibility(8);
            ActivityUtilKt.setSystemBarsVisibility(this, false, false);
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                q6.c.a(getWindow().getAttributes(), 1);
            }
            if (i >= 30) {
                WindowInsetsController a = g3.a(getWindow());
                if (a != null) {
                    w0.a(a, x2.a());
                    h3.a(a, 2);
                }
            } else {
                getWindow().getDecorView().setSystemUiVisibility(4102);
            }
            LinearLayout linearLayout2 = ((ActivityDefaultWebviewBinding) getBinding()).linearLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "linearLayout");
            getStatusBarTopOrBottom(linearLayout2, new Function2() { // from class: com.qiahao.nextvideo.ui.webview.j
                public final Object invoke(Object obj, Object obj2) {
                    Unit analyzeH5$lambda$6;
                    analyzeH5$lambda$6 = DefaultWebActivity.analyzeH5$lambda$6(DefaultWebActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return analyzeH5$lambda$6;
                }
            });
        } else {
            ((ActivityDefaultWebviewBinding) getBinding()).toolbar.setVisibility(0);
            ((ActivityDefaultWebviewBinding) getBinding()).myProgressBar.setVisibility(0);
            ActivityUtilKt.setSystemBarsVisibility(this, true, true);
        }
        String queryParameter2 = Uri.parse(url).getQueryParameter("h5Voice");
        if (queryParameter2 != null) {
            this.mH5Voice = URLDecoder.decode(queryParameter2, "UTF-8");
        }
        if (!TextUtils.isEmpty(Uri.parse(url).getQueryParameter("game_id"))) {
            setShowGiftTip(false);
        }
    }

    public static final Unit analyzeH5$lambda$3(DefaultWebActivity defaultWebActivity, int i, int i2) {
        ViewKtxKt.setMargin(defaultWebActivity.getBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    public static final Unit analyzeH5$lambda$6(DefaultWebActivity defaultWebActivity, int i, int i2) {
        defaultWebActivity.getBinding().linearLayout.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.webview.h
            @Override // java.lang.Runnable
            public final void run() {
                DefaultWebActivity.analyzeH5$lambda$6$lambda$5(DefaultWebActivity.this);
            }
        }, 300L);
        return Unit.INSTANCE;
    }

    public static final void analyzeH5$lambda$6$lambda$5(DefaultWebActivity defaultWebActivity) {
        ViewKtxKt.setMargin(defaultWebActivity.getBinding().toolbar, 0, 0, 0, 0);
        FrameLayout frameLayout = defaultWebActivity.getBinding().activityMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "activityMainContainer");
        frameLayout.setPadding(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean checkAudioPermission() {
        boolean m = w9.h.m(this, fa.b.o());
        if (!m) {
            w9.h.t(this).p(fa.b.o()).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.ui.webview.m
                public final void onResult(List list, List list2) {
                    DefaultWebActivity.checkAudioPermission$lambda$2(DefaultWebActivity.this, list, list2);
                }
            });
        }
        return m;
    }

    public static final void checkAudioPermission$lambda$2(DefaultWebActivity defaultWebActivity, List list, List list2) {
        UserProxy1.H5GameVoiceChannelJoinLeave h5GameVoiceChannelJoinLeave;
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty() && (h5GameVoiceChannelJoinLeave = defaultWebActivity.mVoiceData) != null) {
            HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
            String token = h5GameVoiceChannelJoinLeave.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            String channelId = h5GameVoiceChannelJoinLeave.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
            hiloRtcEngine.joinChannel(token, channelId, h5GameVoiceChannelJoinLeave.getAgoraId(), h5GameVoiceChannelJoinLeave.getProvider());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    private final void initWeView() {
        WebSettings settings = ((ActivityDefaultWebviewBinding) getBinding()).webView.getSettings();
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
        WebView webView = ((ActivityDefaultWebviewBinding) getBinding()).webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        JsInterface jsInterface = new JsInterface(this, webView);
        jsInterface.setListener(this);
        setJsInterface(jsInterface);
        ((ActivityDefaultWebviewBinding) getBinding()).webView.addJavascriptInterface(getJsInterface(), "androidJsObject");
        ((ActivityDefaultWebviewBinding) getBinding()).webView.setWebViewClient(new WebViewClient() { // from class: com.qiahao.nextvideo.ui.webview.DefaultWebActivity$initWeView$3
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
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.qiahao.nextvideo.ui.webview.DefaultWebActivity$initWeView$4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                ActivityDefaultWebviewBinding binding;
                ActivityDefaultWebviewBinding binding2;
                ActivityDefaultWebviewBinding binding3;
                ActivityDefaultWebviewBinding binding4;
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    binding4 = DefaultWebActivity.this.getBinding();
                    binding4.myProgressBar.setVisibility(8);
                    return;
                }
                binding = DefaultWebActivity.this.getBinding();
                if (binding.myProgressBar.getVisibility() == 8) {
                    binding3 = DefaultWebActivity.this.getBinding();
                    binding3.myProgressBar.setVisibility(0);
                }
                binding2 = DefaultWebActivity.this.getBinding();
                binding2.myProgressBar.setProgress(newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                ActivityDefaultWebviewBinding binding;
                ActivityDefaultWebviewBinding binding2;
                super.onReceivedTitle(view, title);
                if (TextUtils.isEmpty(DefaultWebActivity.this.getMTitle())) {
                    binding2 = DefaultWebActivity.this.getBinding();
                    binding2.title.setText(title);
                } else {
                    binding = DefaultWebActivity.this.getBinding();
                    binding.title.setText(DefaultWebActivity.this.getMTitle());
                }
            }
        };
        ((ActivityDefaultWebviewBinding) getBinding()).webView.setWebChromeClient(webChromeClient);
        setMWebChromeClient(webChromeClient);
        ((ActivityDefaultWebviewBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultWebActivity.initWeView$lambda$11(DefaultWebActivity.this, view);
            }
        });
        ((ActivityDefaultWebviewBinding) getBinding()).refreshImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultWebActivity.initWeView$lambda$12(DefaultWebActivity.this, view);
            }
        });
    }

    public static final void initWeView$lambda$11(DefaultWebActivity defaultWebActivity, View view) {
        if (defaultWebActivity.getBinding().webView.canGoBack()) {
            defaultWebActivity.getBinding().webView.goBack();
        } else {
            defaultWebActivity.finish();
        }
    }

    public static final void initWeView$lambda$12(DefaultWebActivity defaultWebActivity, View view) {
        defaultWebActivity.showWebView(defaultWebActivity.url);
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
    public static final void start(@NotNull Context context, @NotNull String str, @Nullable String str2) {
        INSTANCE.start(context, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
        ((ActivityDefaultWebviewBinding) getBinding()).webView.destroy();
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

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_default_webview;
    }

    public final boolean getMNotStatus() {
        return this.mNotStatus;
    }

    @NotNull
    public final String getMTitle() {
        return this.mTitle;
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
        String stringExtra = getIntent().getStringExtra("title");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mTitle = stringExtra;
        NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
        String stringExtra2 = getIntent().getStringExtra("url");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        String addUserStatus = navigationHelper.addUserStatus(str);
        this.url = addUserStatus;
        analyzeH5(addUserStatus);
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
    public void openPersonPage(@NotNull String r5) {
        Intrinsics.checkNotNullParameter(r5, SupportGiftRankActivity.EXTERNAL_ID);
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, r5, false, 2, null);
    }

    public final void setJsInterface(@NotNull JsInterface jsInterface) {
        Intrinsics.checkNotNullParameter(jsInterface, "<set-?>");
        this.jsInterface = jsInterface;
    }

    public final void setMNotStatus(boolean z) {
        this.mNotStatus = z;
    }

    public final void setMTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTitle = str;
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
