package com.qiahao.nextvideo.ui.webview;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.luck.picture.lib.config.SelectMimeType;
import com.oudi.core.callback.SuperCallBack;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J-\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001d\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001bH\u0007J\b\u0010\"\u001a\u00020\u0017H\u0007J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001bH\u0007J\b\u0010%\u001a\u00020\u0017H\u0007J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001bH\u0007J\b\u0010(\u001a\u00020\u0017H\u0007J\b\u0010)\u001a\u00020\u0017H\u0007J\b\u0010*\u001a\u00020\u0017H\u0007J\b\u0010+\u001a\u00020\u0017H\u0007J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020.H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "", "context", "Landroid/content/Context;", "webView", "Landroid/webkit/WebView;", "<init>", "(Landroid/content/Context;Landroid/webkit/WebView;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "mJsInterfaceListener", "Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "getMJsInterfaceListener", "()Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "setMJsInterfaceListener", "(Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;)V", "setListener", "", "listener", "callJsInterface", "apiName", "", "objects", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "getToken", "openPersonPage", SupportGiftRankActivity.EXTERNAL_ID, "tokenTimeOutOrError", "gotoGroupDetail", "groupId", "openGroupSupport", "urlAgent", "url", "goback", "choosePicture", "choosePictureNotCrop", "chooseVideo", "chooseJsPicture", "enableCrop", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class JsInterface {

    @NotNull
    public static final String IMAGE_PATH = "https://image.whoisamy.shop/";

    @NotNull
    private static final String TAG = "JsInterface";

    @NotNull
    private Context context;
    public JsInterfaceListener mJsInterfaceListener;

    @NotNull
    private WebView webView;

    public JsInterface(@NotNull Context context, @NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.context = context;
        this.webView = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callJsInterface$lambda$0(String str, Object[] objArr, JsInterface jsInterface) {
        boolean z;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:");
        sb2.append(str);
        sb2.append("(");
        if (objArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                sb2.append(objArr[i]);
                if (i != objArr.length - 1) {
                    sb2.append(",");
                }
            }
        }
        sb2.append(")");
        jsInterface.webView.evaluateJavascript(sb2.toString(), null);
    }

    private final void chooseJsPicture(boolean enableCrop) {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).isMEnableCrop(enableCrop).build(), new JsInterface$chooseJsPicture$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gotoGroupDetail$lambda$3(JsInterface jsInterface, String str) {
        if (FastClickUtils.INSTANCE.isFastClick()) {
            jsInterface.getMJsInterfaceListener().openGroupPager(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openGroupSupport$lambda$4(JsInterface jsInterface) {
        if (FastClickUtils.INSTANCE.isFastClick()) {
            jsInterface.getMJsInterfaceListener().openGroupSupport();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openPersonPage$lambda$1(String str, JsInterface jsInterface) {
        Log.d(TAG, "openPersonPage: " + str);
        jsInterface.getMJsInterfaceListener().openPersonPage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tokenTimeOutOrError$lambda$2() {
        UserStore.INSTANCE.getShared().logout();
    }

    public final void callJsInterface(@Nullable final String apiName, @NotNull final Object... objects) {
        Intrinsics.checkNotNullParameter(objects, "objects");
        this.webView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.webview.a0
            @Override // java.lang.Runnable
            public final void run() {
                JsInterface.callJsInterface$lambda$0(apiName, objects, this);
            }
        });
    }

    @JavascriptInterface
    public final void choosePicture() {
        chooseJsPicture(true);
    }

    @JavascriptInterface
    public final void choosePictureNotCrop() {
        chooseJsPicture(false);
    }

    @JavascriptInterface
    public final void chooseVideo() {
        if (HiloUtils.INSTANCE.isFastClick()) {
            return;
        }
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).setMShowType(SelectMimeType.ofVideo()).isMEnableCrop(false).setMVideoMinSecond(3).setMVideoMaxSecond(100).build(), new JsInterface$chooseVideo$1(this));
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final JsInterfaceListener getMJsInterfaceListener() {
        JsInterfaceListener jsInterfaceListener = this.mJsInterfaceListener;
        if (jsInterfaceListener != null) {
            return jsInterfaceListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mJsInterfaceListener");
        return null;
    }

    @JavascriptInterface
    @NotNull
    public final String getToken() {
        UserStore.Companion companion = UserStore.INSTANCE;
        String authenticationToken = companion.getShared().getAuthenticationToken();
        Intrinsics.checkNotNull(authenticationToken);
        Log.d(TAG, "getToken: " + authenticationToken);
        String authenticationToken2 = companion.getShared().getAuthenticationToken();
        Intrinsics.checkNotNull(authenticationToken2);
        return authenticationToken2;
    }

    @NotNull
    public final WebView getWebView() {
        return this.webView;
    }

    @JavascriptInterface
    public final void goback() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(this.context);
        if (activity != null) {
            activity.finish();
        }
    }

    @JavascriptInterface
    public final void gotoGroupDetail(@NotNull final String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.webView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.webview.b0
            @Override // java.lang.Runnable
            public final void run() {
                JsInterface.gotoGroupDetail$lambda$3(JsInterface.this, groupId);
            }
        });
    }

    @JavascriptInterface
    public final void openGroupSupport() {
        this.webView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.webview.y
            @Override // java.lang.Runnable
            public final void run() {
                JsInterface.openGroupSupport$lambda$4(JsInterface.this);
            }
        });
    }

    @JavascriptInterface
    public final void openPersonPage(@NotNull final String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        this.webView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.webview.z
            @Override // java.lang.Runnable
            public final void run() {
                JsInterface.openPersonPage$lambda$1(externalId, this);
            }
        });
    }

    public final void setContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void setListener(@NotNull JsInterfaceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setMJsInterfaceListener(listener);
    }

    public final void setMJsInterfaceListener(@NotNull JsInterfaceListener jsInterfaceListener) {
        Intrinsics.checkNotNullParameter(jsInterfaceListener, "<set-?>");
        this.mJsInterfaceListener = jsInterfaceListener;
    }

    public final void setWebView(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<set-?>");
        this.webView = webView;
    }

    @JavascriptInterface
    public final void tokenTimeOutOrError() {
        this.webView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.webview.x
            @Override // java.lang.Runnable
            public final void run() {
                JsInterface.tokenTimeOutOrError$lambda$2();
            }
        });
    }

    @JavascriptInterface
    public final void urlAgent(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        NavigationHelper.jump$default(NavigationHelper.INSTANCE, url, (SuperCallBack) null, 2, (Object) null);
    }
}
