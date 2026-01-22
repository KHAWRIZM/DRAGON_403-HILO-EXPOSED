package com.qiahao.base_common.player.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.oudi.core.component.ICleared;
import com.oudi.utils.FileUtils;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.player.IPlayer;
import com.qiahao.base_common.player.MediaDownloader;
import com.qiahao.base_common.player.PlayerEventListener;
import com.qiahao.base_common.player.PlayerException;
import com.qiahao.base_common.player.PlayerMediaSource;
import com.qiahao.base_common.player.PlayerState;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import com.tencent.qgame.animplayer.util.ScaleType;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000fJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u001a\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u00162\b\b\u0002\u00108\u001a\u00020\u0016H\u0002J\b\u00109\u001a\u000204H\u0002J\b\u0010:\u001a\u000204H\u0014J\b\u0010;\u001a\u00020-H\u0002J\u0010\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u0016H\u0016J\b\u0010?\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020AH\u0016J\n\u0010B\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010C\u001a\u0002042\b\u0010D\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010E\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010F\u001a\u000204H\u0016J\u0010\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u00108\u001a\u0002042\u0006\u0010K\u001a\u00020\u0018H\u0002J\u0010\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u000204H\u0002J\u001a\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020\f2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\b\u0010T\u001a\u000204H\u0002J\b\u0010U\u001a\u000204H\u0007J\b\u0010V\u001a\u000204H\u0007J\b\u0010W\u001a\u000204H\u0007J\b\u0010X\u001a\u000204H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b0\u00101¨\u0006Y"}, d2 = {"Lcom/qiahao/base_common/player/video/VideoPlayer;", "Landroid/widget/VideoView;", "Lcom/qiahao/base_common/player/IPlayer;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mediaSource", "Lcom/qiahao/base_common/player/video/VideoMediaSource;", "pendingMediaSource", "fetchResource", "Lcom/tencent/qgame/animplayer/inter/IFetchResource;", "playWhenReady", "", "playerState", "Lcom/qiahao/base_common/player/PlayerState;", "playerEventListener", "Lcom/qiahao/base_common/player/PlayerEventListener;", "mLoop", "getMLoop", "()I", "setMLoop", "(I)V", "mScaleType", "Lcom/tencent/qgame/animplayer/util/ScaleType;", "getMScaleType", "()Lcom/tencent/qgame/animplayer/util/ScaleType;", "setMScaleType", "(Lcom/tencent/qgame/animplayer/util/ScaleType;)V", "downloader", "Lcom/qiahao/base_common/player/MediaDownloader;", "getDownloader", "()Lcom/qiahao/base_common/player/MediaDownloader;", "downloader$delegate", "Lkotlin/Lazy;", "downloadListener", "Lcom/qiahao/base_common/download/DownloadListener;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "startVideo", "", "pauseVideo", "stop", "reset", "postState", "stopVideo", "onDetachedFromWindow", "getDownloadListenerNotNull", "prepare", "source", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "getCurrentState", "getView", "Landroid/view/View;", "getCurrentSource", "setPlayerEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPlayWhenReady", "restart", "bindingLifeCycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "postPlayWhenReady", "state", "postError", "exception", "Lcom/qiahao/base_common/player/PlayerException;", "onVideoStart", "onVideoFailed", "errorType", "errorMsg", "", "onVideoComplete", "onPause", "onResume", "onDestroy", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class VideoPlayer extends VideoView implements IPlayer, LifecycleObserver {

    @Nullable
    private DownloadListener downloadListener;

    /* renamed from: downloader$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy downloader;

    @Nullable
    private IFetchResource fetchResource;
    private int mLoop;

    @NotNull
    private ScaleType mScaleType;

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mainHandler;

    @Nullable
    private VideoMediaSource mediaSource;

    @Nullable
    private VideoMediaSource pendingMediaSource;
    private boolean playWhenReady;

    @Nullable
    private PlayerEventListener playerEventListener;

    @NotNull
    private PlayerState playerState;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayer(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(final VideoPlayer videoPlayer, MediaPlayer mediaPlayer) {
        int i10;
        videoPlayer.getMainHandler().post(new Runnable() { // from class: com.qiahao.base_common.player.video.j
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayer.this.onVideoStart();
            }
        });
        double videoWidth = mediaPlayer.getVideoWidth();
        double videoHeight = mediaPlayer.getVideoHeight();
        if (videoWidth > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && videoHeight > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            final ViewGroup.LayoutParams layoutParams = videoPlayer.getLayoutParams();
            final int i11 = videoPlayer.getResources().getDisplayMetrics().widthPixels;
            int i12 = videoPlayer.getResources().getDisplayMetrics().heightPixels;
            BaseApplication companion = BaseApplication.INSTANCE.getInstance();
            if (companion != null) {
                i10 = companion.getMNavigationHeight();
            } else {
                i10 = 0;
            }
            final int i13 = i12 + i10;
            if (i11 > 0 && i13 > 0) {
                final int i14 = i11 / i13;
                final double d10 = videoWidth / videoHeight;
                videoPlayer.post(new Runnable() { // from class: com.qiahao.base_common.player.video.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoPlayer._init_$lambda$4$lambda$3(i14, d10, layoutParams, i11, i13, videoPlayer);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4$lambda$3(int i10, double d10, ViewGroup.LayoutParams layoutParams, int i11, int i12, VideoPlayer videoPlayer) {
        if (i10 > d10) {
            layoutParams.height = (int) (i11 / d10);
        } else {
            layoutParams.width = (int) (i12 * d10);
        }
        videoPlayer.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(final VideoPlayer videoPlayer, MediaPlayer mediaPlayer) {
        videoPlayer.getMainHandler().post(new Runnable() { // from class: com.qiahao.base_common.player.video.b
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayer.this.onVideoComplete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$8(final VideoPlayer videoPlayer, MediaPlayer mediaPlayer, final int i10, final int i11) {
        videoPlayer.getMainHandler().post(new Runnable() { // from class: com.qiahao.base_common.player.video.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayer._init_$lambda$8$lambda$7(VideoPlayer.this, i10, i11);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$8$lambda$7(VideoPlayer videoPlayer, int i10, int i11) {
        videoPlayer.onVideoFailed(i10, "MediaPlayer error: what=" + i10 + " extra=" + i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MediaDownloader.MediaDownloaderImpl downloader_delegate$lambda$0() {
        return new MediaDownloader.MediaDownloaderImpl(0L, 1, null);
    }

    private final DownloadListener getDownloadListenerNotNull() {
        if (this.downloadListener == null) {
            this.downloadListener = new DownloadListener() { // from class: com.qiahao.base_common.player.video.VideoPlayer$getDownloadListenerNotNull$1
                @Override // com.qiahao.base_common.download.DownloadListener
                public void onCompleted(DownloadTask task) {
                    VideoMediaSource videoMediaSource;
                    VideoMediaSource videoMediaSource2;
                    Intrinsics.checkNotNullParameter(task, "task");
                    DownloadListener.DefaultImpls.onCompleted(this, task);
                    File file = new File(task.getRequest().getTempPath());
                    String filePath = task.getFilePath();
                    String str = "";
                    if (filePath == null) {
                        filePath = "";
                    }
                    File file2 = new File(filePath);
                    if (!file2.exists() && file.exists()) {
                        FileUtils.rename(task.getRequest().getTempPath(), task.getRequest().getFileName());
                        String filePath2 = task.getFilePath();
                        if (filePath2 != null) {
                            str = filePath2;
                        }
                        file2 = new File(str);
                    }
                    if (file2.exists()) {
                        videoMediaSource = VideoPlayer.this.mediaSource;
                        if (videoMediaSource != null) {
                            videoMediaSource2 = VideoPlayer.this.mediaSource;
                            if (videoMediaSource2 != null) {
                                videoMediaSource2.setFilePath(task.getFilePath());
                            }
                            VideoPlayer.this.setVideoPath(task.getFilePath());
                            VideoPlayer.this.setMLoop(VideoPlayer.this.getMLoop() - 1);
                            VideoPlayer.this.startVideo();
                            return;
                        }
                    }
                    VideoPlayer.this.postError(new PlayerException(0, "下载文件异常"));
                }

                @Override // com.qiahao.base_common.download.DownloadListener
                public void onError(DownloadTask task, Throwable throwable) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    DownloadListener.DefaultImpls.onError(this, task, throwable);
                    VideoPlayer.this.postError(new PlayerException(0, "下载文件异常", throwable));
                }

                @Override // com.qiahao.base_common.download.DownloadListener
                public void onProgress(DownloadTask downloadTask, int i10, int i11) {
                    DownloadListener.DefaultImpls.onProgress(this, downloadTask, i10, i11);
                }
            };
        }
        DownloadListener downloadListener = this.downloadListener;
        Intrinsics.checkNotNull(downloadListener);
        return downloadListener;
    }

    private final MediaDownloader getDownloader() {
        return (MediaDownloader) this.downloader.getValue();
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mainHandler_delegate$lambda$1() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoComplete() {
        int i10 = this.mLoop;
        if (i10 != -1 && i10 <= 0) {
            postState(PlayerState.ENDED);
            VideoMediaSource videoMediaSource = this.pendingMediaSource;
            if (videoMediaSource != null) {
                this.pendingMediaSource = null;
                prepare(videoMediaSource);
                return;
            }
            return;
        }
        if (i10 > 0) {
            this.mLoop = i10 - 1;
        }
        startVideo();
    }

    private final void onVideoFailed(int errorType, String errorMsg) {
        postError(new PlayerException(1, errorMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoStart() {
        postState(PlayerState.READY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postError(PlayerException exception) {
        PlayerEventListener playerEventListener = this.playerEventListener;
        if (playerEventListener != null) {
            playerEventListener.onPlayerError(exception);
        }
        postState(PlayerState.IDLE);
    }

    private final void postPlayWhenReady(boolean playWhenReady) {
        if (playWhenReady != this.playWhenReady) {
            this.playWhenReady = playWhenReady;
            PlayerEventListener playerEventListener = this.playerEventListener;
            if (playerEventListener != null) {
                playerEventListener.onPlayerStateChanged(playWhenReady, this.playerState);
            }
        }
    }

    private final void postState(PlayerState state) {
        if (state != this.playerState) {
            this.playerState = state;
            PlayerEventListener playerEventListener = this.playerEventListener;
            if (playerEventListener != null) {
                playerEventListener.onPlayerStateChanged(this.playWhenReady, state);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startVideo$lambda$9(VideoPlayer videoPlayer) {
        videoPlayer.seekTo(0);
        videoPlayer.start();
    }

    private final void stop(boolean reset, boolean postState) {
        pauseVideo();
        if (reset) {
            VideoMediaSource videoMediaSource = this.mediaSource;
            if (videoMediaSource != null) {
                videoMediaSource.onCleared();
            }
            this.mediaSource = null;
            getDownloader().onCleared();
        }
        if (postState) {
            postState(PlayerState.IDLE);
        } else {
            this.playerState = PlayerState.IDLE;
        }
    }

    static /* synthetic */ void stop$default(VideoPlayer videoPlayer, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        videoPlayer.stop(z10, z11);
    }

    private final void stopVideo() {
        getMainHandler().post(new Runnable() { // from class: com.qiahao.base_common.player.video.i
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayer.this.stopPlayback();
            }
        });
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void bindingLifeCycle(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @Nullable
    public PlayerMediaSource getCurrentSource() {
        return this.mediaSource;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @NotNull
    /* renamed from: getCurrentState, reason: from getter */
    public PlayerState getPlayerState() {
        return this.playerState;
    }

    public final int getMLoop() {
        return this.mLoop;
    }

    @NotNull
    public final ScaleType getMScaleType() {
        return this.mScaleType;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public boolean getPlayWhenReady() {
        return IPlayer.DefaultImpls.getPlayWhenReady(this);
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.qiahao.base_common.player.IPlayer, com.oudi.utils.ICleared
    public void onCleared() {
        ICleared iCleared;
        stopVideo();
        setOnPreparedListener(null);
        setOnCompletionListener(null);
        setOnErrorListener(null);
        getDownloader().onCleared();
        clearAnimation();
        ICleared iCleared2 = this.fetchResource;
        if (iCleared2 instanceof ICleared) {
            iCleared = iCleared2;
        } else {
            iCleared = null;
        }
        if (iCleared != null) {
            iCleared.onCleared();
        }
        this.fetchResource = null;
        this.playerEventListener = null;
        getMainHandler().removeCallbacksAndMessages(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        onCleared();
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onCleared();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        setPlayWhenReady(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        restart();
    }

    public final void pauseVideo() {
        if (isPlaying()) {
            pause();
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void prepare(@NotNull PlayerMediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        VideoMediaSource videoMediaSource = null;
        if (isPlaying()) {
            if (source instanceof VideoMediaSource) {
                videoMediaSource = (VideoMediaSource) source;
            }
            this.pendingMediaSource = videoMediaSource;
            return;
        }
        VideoMediaSource videoMediaSource2 = this.mediaSource;
        if (videoMediaSource2 != null) {
            videoMediaSource2.onCleared();
        }
        boolean z10 = source instanceof VideoMediaSource;
        if (z10) {
            videoMediaSource = (VideoMediaSource) source;
        }
        this.mediaSource = videoMediaSource;
        postState(PlayerState.BUFFERING);
        if (!z10) {
            postError(new PlayerException(0, "不支持数据源"));
            return;
        }
        VideoMediaSource videoMediaSource3 = (VideoMediaSource) source;
        this.mScaleType = videoMediaSource3.getScaleType();
        this.mLoop = videoMediaSource3.getLoopCount();
        String filePath = videoMediaSource3.getFilePath();
        String url = videoMediaSource3.getUrl();
        if (filePath != null && filePath.length() != 0) {
            setVideoPath(filePath);
            this.mLoop--;
            startVideo();
        } else if (url != null && url.length() != 0) {
            getDownloader().download(url, getDownloadListenerNotNull(), Boolean.FALSE);
        } else {
            postError(new PlayerException(0, "视频数据源信息不完整"));
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void restart() {
        IPlayer.DefaultImpls.restart(this);
        stop(false);
        VideoMediaSource videoMediaSource = this.mediaSource;
        if (videoMediaSource != null) {
            Intrinsics.checkNotNull(videoMediaSource);
            prepare(videoMediaSource);
        }
    }

    public final void setMLoop(int i10) {
        this.mLoop = i10;
    }

    public final void setMScaleType(@NotNull ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "<set-?>");
        this.mScaleType = scaleType;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void setPlayWhenReady(boolean playWhenReady) {
        postPlayWhenReady(playWhenReady);
        if (playWhenReady) {
            restart();
        } else {
            pauseVideo();
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void setPlayerEventListener(@Nullable PlayerEventListener listener) {
        this.playerEventListener = listener;
    }

    public final void startVideo() {
        getMainHandler().post(new Runnable() { // from class: com.qiahao.base_common.player.video.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayer.startVideo$lambda$9(VideoPlayer.this);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.playWhenReady = true;
        this.playerState = PlayerState.IDLE;
        this.mLoop = 1;
        this.mScaleType = ScaleType.FIT_CENTER;
        this.downloader = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.video.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MediaDownloader.MediaDownloaderImpl downloader_delegate$lambda$0;
                downloader_delegate$lambda$0 = VideoPlayer.downloader_delegate$lambda$0();
                return downloader_delegate$lambda$0;
            }
        });
        this.mainHandler = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.video.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Handler mainHandler_delegate$lambda$1;
                mainHandler_delegate$lambda$1 = VideoPlayer.mainHandler_delegate$lambda$1();
                return mainHandler_delegate$lambda$1;
            }
        });
        setBackgroundColor(0);
        setZOrderOnTop(true);
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.qiahao.base_common.player.video.f
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                VideoPlayer._init_$lambda$4(VideoPlayer.this, mediaPlayer);
            }
        });
        setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.qiahao.base_common.player.video.g
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                VideoPlayer._init_$lambda$6(VideoPlayer.this, mediaPlayer);
            }
        });
        setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.qiahao.base_common.player.video.h
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i12, int i13) {
                boolean _init_$lambda$8;
                _init_$lambda$8 = VideoPlayer._init_$lambda$8(VideoPlayer.this, mediaPlayer, i12, i13);
                return _init_$lambda$8;
            }
        });
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void stop(boolean reset) {
        stop(reset, true);
    }
}
