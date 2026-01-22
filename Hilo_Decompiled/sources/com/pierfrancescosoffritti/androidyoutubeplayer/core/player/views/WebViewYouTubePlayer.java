package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amazonaws.services.s3.util.Mimetypes;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerCallbacks;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import java.io.InputStream;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rJ5\u0010!\u001a\u00020\u00182\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b'J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\u000e\u0010/\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020*J\u000e\u00100\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020*J\b\u00101\u001a\u00020\u0018H\u0016J\u001a\u00102\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0003J\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer;", "Landroid/webkit/WebView;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "youTubePlayerCallbacks", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerCallbacks;", "_youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerImpl;", "youtubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "getYoutubePlayer$core_release", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "youTubePlayerInitListener", "Lkotlin/Function1;", "", "isBackgroundPlaybackEnabled", "", "isBackgroundPlaybackEnabled$core_release", "()Z", "setBackgroundPlaybackEnabled$core_release", "(Z)V", "youTubePlayerBridge", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge;", "initialize", "initListener", "playerOptions", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "videoId", "", "initialize$core_release", "listeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "getListeners", "()Ljava/util/Collection;", "getInstance", "onYouTubeIFrameAPIReady", "addListener", "removeListener", "destroy", "initWebView", "onWindowVisibilityChanged", ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class WebViewYouTubePlayer extends WebView implements YouTubePlayerBridge.YouTubePlayerBridgeCallbacks {

    @NotNull
    private final YouTubePlayerImpl _youTubePlayer;
    private boolean isBackgroundPlaybackEnabled;

    @NotNull
    private final FullscreenListener listener;

    @NotNull
    private final YouTubePlayerBridge youTubePlayerBridge;

    @NotNull
    private final YouTubePlayerCallbacks youTubePlayerCallbacks;
    private Function1<? super YouTubePlayer, Unit> youTubePlayerInitListener;

    public /* synthetic */ WebViewYouTubePlayer(Context context, FullscreenListener fullscreenListener, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fullscreenListener, (i11 & 4) != 0 ? null : attributeSet, (i11 & 8) != 0 ? 0 : i10);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void initWebView(IFramePlayerOptions playerOptions, String videoId) {
        String str;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(-1);
        addJavascriptInterface(this.youTubePlayerBridge, "YouTubePlayerBridge");
        addJavascriptInterface(this.youTubePlayerCallbacks, "YouTubePlayerCallbacks");
        InputStream openRawResource = getResources().openRawResource(R.raw.ayp_youtube_player);
        Intrinsics.checkNotNullExpressionValue(openRawResource, "openRawResource(...)");
        String readHTMLFromUTF8File = WebViewYouTubePlayerKt.readHTMLFromUTF8File(openRawResource);
        if (videoId != null) {
            str = '\'' + videoId + '\'';
        } else {
            str = "undefined";
        }
        loadDataWithBaseURL(playerOptions.getOrigin$core_release(), StringsKt.replace$default(StringsKt.replace$default(readHTMLFromUTF8File, "<<injectedVideoId>>", str, false, 4, (Object) null), "<<injectedPlayerVars>>", playerOptions.toString(), false, 4, (Object) null), Mimetypes.MIMETYPE_HTML, "utf-8", null);
        setWebChromeClient(new WebViewYouTubePlayer$initWebView$2(this));
    }

    public final boolean addListener(@NotNull YouTubePlayerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this._youTubePlayer.addListener(listener);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this._youTubePlayer.release();
        super.destroy();
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge.YouTubePlayerBridgeCallbacks
    @NotNull
    public YouTubePlayer getInstance() {
        return this._youTubePlayer;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge.YouTubePlayerBridgeCallbacks
    @NotNull
    public Collection<YouTubePlayerListener> getListeners() {
        return this._youTubePlayer.getListeners();
    }

    @NotNull
    public final YouTubePlayer getYoutubePlayer$core_release() {
        return this._youTubePlayer;
    }

    public final void initialize$core_release(@NotNull Function1<? super YouTubePlayer, Unit> initListener, @Nullable IFramePlayerOptions playerOptions, @Nullable String videoId) {
        Intrinsics.checkNotNullParameter(initListener, "initListener");
        this.youTubePlayerInitListener = initListener;
        if (playerOptions == null) {
            IFramePlayerOptions.Companion companion = IFramePlayerOptions.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            playerOptions = companion.getDefault(context);
        }
        initWebView(playerOptions, videoId);
    }

    /* renamed from: isBackgroundPlaybackEnabled$core_release, reason: from getter */
    public final boolean getIsBackgroundPlaybackEnabled() {
        return this.isBackgroundPlaybackEnabled;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        if (this.isBackgroundPlaybackEnabled && (visibility == 8 || visibility == 4)) {
            return;
        }
        super.onWindowVisibilityChanged(visibility);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge.YouTubePlayerBridgeCallbacks
    public void onYouTubeIFrameAPIReady() {
        Function1<? super YouTubePlayer, Unit> function1 = this.youTubePlayerInitListener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("youTubePlayerInitListener");
            function1 = null;
        }
        function1.invoke(this._youTubePlayer);
    }

    public final boolean removeListener(@NotNull YouTubePlayerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this._youTubePlayer.removeListener(listener);
    }

    public final void setBackgroundPlaybackEnabled$core_release(boolean z10) {
        this.isBackgroundPlaybackEnabled = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewYouTubePlayer(@NotNull Context context, @NotNull FullscreenListener listener, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        YouTubePlayerCallbacks youTubePlayerCallbacks = new YouTubePlayerCallbacks();
        this.youTubePlayerCallbacks = youTubePlayerCallbacks;
        this._youTubePlayer = new YouTubePlayerImpl(this, youTubePlayerCallbacks);
        this.youTubePlayerBridge = new YouTubePlayerBridge(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebViewYouTubePlayer(@NotNull Context context) {
        this(context, FakeWebViewYouTubeListener.INSTANCE, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
