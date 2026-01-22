package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.RestrictTo;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0007J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\b\u0010\u0015\u001a\u00020\tH\u0007J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000eH\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000eH\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge;", "", "youTubePlayerOwner", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "<init>", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;)V", "mainThreadHandler", "Landroid/os/Handler;", "sendYouTubeIFrameAPIReady", "", "sendReady", "sendStateChange", "", "state", "", "sendPlaybackQualityChange", "quality", "sendPlaybackRateChange", "rate", "sendError", "error", "sendApiChange", "sendVideoCurrentTime", "seconds", "sendVideoDuration", "sendVideoLoadedFraction", "fraction", "sendVideoId", "videoId", "parsePlayerState", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "parsePlaybackQuality", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "parsePlaybackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "parsePlayerError", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "Companion", "YouTubePlayerBridgeCallbacks", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nYouTubePlayerBridge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTubePlayerBridge.kt\ncom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,211:1\n1863#2,2:212\n1863#2,2:214\n1863#2,2:216\n1863#2,2:218\n1863#2,2:220\n1863#2,2:222\n1863#2,2:224\n1863#2,2:226\n1863#2,2:228\n1863#2,2:230\n*S KotlinDebug\n*F\n+ 1 YouTubePlayerBridge.kt\ncom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge\n*L\n64#1:212,2\n72#1:214,2\n81#1:216,2\n90#1:218,2\n99#1:220,2\n105#1:222,2\n118#1:224,2\n133#1:226,2\n147#1:228,2\n153#1:230,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class YouTubePlayerBridge {

    @NotNull
    private static final String ERROR_HTML_5_PLAYER = "5";

    @NotNull
    private static final String ERROR_INVALID_PARAMETER_IN_REQUEST = "2";

    @NotNull
    private static final String ERROR_REQUEST_MISSING_HTTP_REFERER = "153";

    @NotNull
    private static final String ERROR_VIDEO_NOT_FOUND = "100";

    @NotNull
    private static final String ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER1 = "101";

    @NotNull
    private static final String ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER2 = "150";

    @NotNull
    private static final String QUALITY_DEFAULT = "default";

    @NotNull
    private static final String QUALITY_HD1080 = "hd1080";

    @NotNull
    private static final String QUALITY_HD720 = "hd720";

    @NotNull
    private static final String QUALITY_HIGH_RES = "highres";

    @NotNull
    private static final String QUALITY_LARGE = "large";

    @NotNull
    private static final String QUALITY_MEDIUM = "medium";

    @NotNull
    private static final String QUALITY_SMALL = "small";

    @NotNull
    private static final String RATE_0_25 = "0.25";

    @NotNull
    private static final String RATE_0_5 = "0.5";

    @NotNull
    private static final String RATE_0_75 = "0.75";

    @NotNull
    private static final String RATE_1 = "1";

    @NotNull
    private static final String RATE_1_25 = "1.25";

    @NotNull
    private static final String RATE_1_5 = "1.5";

    @NotNull
    private static final String RATE_1_75 = "1.75";

    @NotNull
    private static final String RATE_2 = "2";

    @NotNull
    private static final String STATE_BUFFERING = "BUFFERING";

    @NotNull
    private static final String STATE_CUED = "CUED";

    @NotNull
    private static final String STATE_ENDED = "ENDED";

    @NotNull
    private static final String STATE_PAUSED = "PAUSED";

    @NotNull
    private static final String STATE_PLAYING = "PLAYING";

    @NotNull
    private static final String STATE_UNSTARTED = "UNSTARTED";

    @NotNull
    private final Handler mainThreadHandler;

    @NotNull
    private final YouTubePlayerBridgeCallbacks youTubePlayerOwner;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerBridge$YouTubePlayerBridgeCallbacks;", "", "listeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "getListeners", "()Ljava/util/Collection;", "getInstance", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "onYouTubeIFrameAPIReady", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface YouTubePlayerBridgeCallbacks {
        @NotNull
        YouTubePlayer getInstance();

        @NotNull
        Collection<YouTubePlayerListener> getListeners();

        void onYouTubeIFrameAPIReady();
    }

    public YouTubePlayerBridge(@NotNull YouTubePlayerBridgeCallbacks youTubePlayerOwner) {
        Intrinsics.checkNotNullParameter(youTubePlayerOwner, "youTubePlayerOwner");
        this.youTubePlayerOwner = youTubePlayerOwner;
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
    }

    private final PlayerConstants.PlaybackQuality parsePlaybackQuality(String quality) {
        if (StringsKt.equals(quality, QUALITY_SMALL, true)) {
            return PlayerConstants.PlaybackQuality.SMALL;
        }
        if (StringsKt.equals(quality, "medium", true)) {
            return PlayerConstants.PlaybackQuality.MEDIUM;
        }
        if (StringsKt.equals(quality, QUALITY_LARGE, true)) {
            return PlayerConstants.PlaybackQuality.LARGE;
        }
        if (StringsKt.equals(quality, QUALITY_HD720, true)) {
            return PlayerConstants.PlaybackQuality.HD720;
        }
        if (StringsKt.equals(quality, QUALITY_HD1080, true)) {
            return PlayerConstants.PlaybackQuality.HD1080;
        }
        if (StringsKt.equals(quality, QUALITY_HIGH_RES, true)) {
            return PlayerConstants.PlaybackQuality.HIGH_RES;
        }
        if (StringsKt.equals(quality, "default", true)) {
            return PlayerConstants.PlaybackQuality.DEFAULT;
        }
        return PlayerConstants.PlaybackQuality.UNKNOWN;
    }

    private final PlayerConstants.PlaybackRate parsePlaybackRate(String rate) {
        if (StringsKt.equals(rate, RATE_0_25, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_25;
        }
        if (StringsKt.equals(rate, RATE_0_5, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_5;
        }
        if (StringsKt.equals(rate, RATE_0_75, true)) {
            return PlayerConstants.PlaybackRate.RATE_0_75;
        }
        if (StringsKt.equals(rate, "1", true)) {
            return PlayerConstants.PlaybackRate.RATE_1;
        }
        if (StringsKt.equals(rate, RATE_1_25, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_25;
        }
        if (StringsKt.equals(rate, RATE_1_5, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_5;
        }
        if (StringsKt.equals(rate, RATE_1_75, true)) {
            return PlayerConstants.PlaybackRate.RATE_1_75;
        }
        if (StringsKt.equals(rate, "2", true)) {
            return PlayerConstants.PlaybackRate.RATE_2;
        }
        return PlayerConstants.PlaybackRate.UNKNOWN;
    }

    private final PlayerConstants.PlayerError parsePlayerError(String error) {
        if (StringsKt.equals(error, "2", true)) {
            return PlayerConstants.PlayerError.INVALID_PARAMETER_IN_REQUEST;
        }
        if (StringsKt.equals(error, "5", true)) {
            return PlayerConstants.PlayerError.HTML_5_PLAYER;
        }
        if (StringsKt.equals(error, ERROR_VIDEO_NOT_FOUND, true)) {
            return PlayerConstants.PlayerError.VIDEO_NOT_FOUND;
        }
        if (StringsKt.equals(error, "101", true)) {
            return PlayerConstants.PlayerError.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
        }
        if (StringsKt.equals(error, ERROR_VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER2, true)) {
            return PlayerConstants.PlayerError.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
        }
        if (StringsKt.equals(error, ERROR_REQUEST_MISSING_HTTP_REFERER, true)) {
            return PlayerConstants.PlayerError.REQUEST_MISSING_HTTP_REFERER;
        }
        return PlayerConstants.PlayerError.UNKNOWN;
    }

    private final PlayerConstants.PlayerState parsePlayerState(String state) {
        if (StringsKt.equals(state, STATE_UNSTARTED, true)) {
            return PlayerConstants.PlayerState.UNSTARTED;
        }
        if (StringsKt.equals(state, STATE_ENDED, true)) {
            return PlayerConstants.PlayerState.ENDED;
        }
        if (StringsKt.equals(state, STATE_PLAYING, true)) {
            return PlayerConstants.PlayerState.PLAYING;
        }
        if (StringsKt.equals(state, STATE_PAUSED, true)) {
            return PlayerConstants.PlayerState.PAUSED;
        }
        if (StringsKt.equals(state, STATE_BUFFERING, true)) {
            return PlayerConstants.PlayerState.BUFFERING;
        }
        if (StringsKt.equals(state, STATE_CUED, true)) {
            return PlayerConstants.PlayerState.VIDEO_CUED;
        }
        return PlayerConstants.PlayerState.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendApiChange$lambda$12(YouTubePlayerBridge youTubePlayerBridge) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onApiChange(youTubePlayerBridge.youTubePlayerOwner.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendError$lambda$10(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlayerError playerError) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onError(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playerError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPlaybackQualityChange$lambda$6(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlaybackQuality playbackQuality) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onPlaybackQualityChange(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playbackQuality);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPlaybackRateChange$lambda$8(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlaybackRate playbackRate) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onPlaybackRateChange(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playbackRate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReady$lambda$2(YouTubePlayerBridge youTubePlayerBridge) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onReady(youTubePlayerBridge.youTubePlayerOwner.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendStateChange$lambda$4(YouTubePlayerBridge youTubePlayerBridge, PlayerConstants.PlayerState playerState) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onStateChange(youTubePlayerBridge.youTubePlayerOwner.getInstance(), playerState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoCurrentTime$lambda$14(YouTubePlayerBridge youTubePlayerBridge, float f10) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onCurrentSecond(youTubePlayerBridge.youTubePlayerOwner.getInstance(), f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoDuration$lambda$16(YouTubePlayerBridge youTubePlayerBridge, float f10) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoDuration(youTubePlayerBridge.youTubePlayerOwner.getInstance(), f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoId$lambda$20(YouTubePlayerBridge youTubePlayerBridge, String str) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoId(youTubePlayerBridge.youTubePlayerOwner.getInstance(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideoLoadedFraction$lambda$18(YouTubePlayerBridge youTubePlayerBridge, float f10) {
        Iterator<T> it = youTubePlayerBridge.youTubePlayerOwner.getListeners().iterator();
        while (it.hasNext()) {
            ((YouTubePlayerListener) it.next()).onVideoLoadedFraction(youTubePlayerBridge.youTubePlayerOwner.getInstance(), f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendYouTubeIFrameAPIReady$lambda$0(YouTubePlayerBridge youTubePlayerBridge) {
        youTubePlayerBridge.youTubePlayerOwner.onYouTubeIFrameAPIReady();
    }

    @JavascriptInterface
    public final boolean sendApiChange() {
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.g
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendApiChange$lambda$12(YouTubePlayerBridge.this);
            }
        });
    }

    @JavascriptInterface
    public final void sendError(@NotNull String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        final PlayerConstants.PlayerError parsePlayerError = parsePlayerError(error);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.j
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendError$lambda$10(YouTubePlayerBridge.this, parsePlayerError);
            }
        });
    }

    @JavascriptInterface
    public final void sendPlaybackQualityChange(@NotNull String quality) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        final PlayerConstants.PlaybackQuality parsePlaybackQuality = parsePlaybackQuality(quality);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.c
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendPlaybackQualityChange$lambda$6(YouTubePlayerBridge.this, parsePlaybackQuality);
            }
        });
    }

    @JavascriptInterface
    public final void sendPlaybackRateChange(@NotNull String rate) {
        Intrinsics.checkNotNullParameter(rate, "rate");
        final PlayerConstants.PlaybackRate parsePlaybackRate = parsePlaybackRate(rate);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.e
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendPlaybackRateChange$lambda$8(YouTubePlayerBridge.this, parsePlaybackRate);
            }
        });
    }

    @JavascriptInterface
    public final boolean sendReady() {
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.h
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendReady$lambda$2(YouTubePlayerBridge.this);
            }
        });
    }

    @JavascriptInterface
    public final void sendStateChange(@NotNull String state) {
        Intrinsics.checkNotNullParameter(state, "state");
        final PlayerConstants.PlayerState parsePlayerState = parsePlayerState(state);
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.k
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendStateChange$lambda$4(YouTubePlayerBridge.this, parsePlayerState);
            }
        });
    }

    @JavascriptInterface
    public final void sendVideoCurrentTime(@NotNull String seconds) {
        Intrinsics.checkNotNullParameter(seconds, "seconds");
        try {
            final float parseFloat = Float.parseFloat(seconds);
            this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.a
                @Override // java.lang.Runnable
                public final void run() {
                    YouTubePlayerBridge.sendVideoCurrentTime$lambda$14(YouTubePlayerBridge.this, parseFloat);
                }
            });
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void sendVideoDuration(@NotNull String seconds) {
        Intrinsics.checkNotNullParameter(seconds, "seconds");
        try {
            if (TextUtils.isEmpty(seconds)) {
                seconds = "0";
            }
            final float parseFloat = Float.parseFloat(seconds);
            this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.d
                @Override // java.lang.Runnable
                public final void run() {
                    YouTubePlayerBridge.sendVideoDuration$lambda$16(YouTubePlayerBridge.this, parseFloat);
                }
            });
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendVideoId(@NotNull final String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.f
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendVideoId$lambda$20(YouTubePlayerBridge.this, videoId);
            }
        });
    }

    @JavascriptInterface
    public final void sendVideoLoadedFraction(@NotNull String fraction) {
        Intrinsics.checkNotNullParameter(fraction, "fraction");
        try {
            final float parseFloat = Float.parseFloat(fraction);
            this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.i
                @Override // java.lang.Runnable
                public final void run() {
                    YouTubePlayerBridge.sendVideoLoadedFraction$lambda$18(YouTubePlayerBridge.this, parseFloat);
                }
            });
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendYouTubeIFrameAPIReady() {
        return this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.b
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerBridge.sendYouTubeIFrameAPIReady$lambda$0(YouTubePlayerBridge.this);
            }
        });
    }
}
