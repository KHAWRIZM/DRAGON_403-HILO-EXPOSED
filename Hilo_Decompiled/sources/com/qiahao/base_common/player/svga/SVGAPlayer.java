package com.qiahao.base_common.player.svga;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.FileUtils;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.player.MediaDownloader;
import com.qiahao.base_common.player.PlayerEventListener;
import com.qiahao.base_common.player.PlayerException;
import com.qiahao.base_common.player.PlayerMediaSource;
import com.qiahao.base_common.player.PlayerState;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eJ\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010/\u001a\u00020*2\u0006\u00102\u001a\u0002032\u0006\u00100\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u00020*2\u0006\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u00020*H\u0016J\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u0012H\u0016J\u001a\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u00122\b\b\u0002\u00109\u001a\u00020\u0012H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010;\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0015H\u0016J\n\u0010?\u001a\u0004\u0018\u000101H\u0016J\u0012\u0010@\u001a\u00020*2\b\u0010A\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010B\u001a\u00020\rJ\u0010\u00109\u001a\u00020*2\u0006\u0010C\u001a\u00020\u0015H\u0002J\u0010\u0010D\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020*H\u0007J\b\u0010J\u001a\u00020*H\u0007J\b\u0010K\u001a\u00020*H\u0007J\b\u0010L\u001a\u00020*H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b&\u0010'¨\u0006M"}, d2 = {"Lcom/qiahao/base_common/player/svga/SVGAPlayer;", "Lcom/opensource/svgaplayer/SVGAImageView;", "Lcom/qiahao/base_common/player/svga/ISVGAPlayer;", "Lcom/oudi/utils/log/ILog;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mediaSource", "Lcom/qiahao/base_common/player/svga/SVGAMediaSource;", "playWhenReady", "", "playWhenReadyRecord", "playerState", "Lcom/qiahao/base_common/player/PlayerState;", "playerEventListener", "Lcom/qiahao/base_common/player/PlayerEventListener;", "downloader", "Lcom/qiahao/base_common/player/MediaDownloader;", "getDownloader", "()Lcom/qiahao/base_common/player/MediaDownloader;", "downloader$delegate", "Lkotlin/Lazy;", "downloadListener", "Lcom/qiahao/base_common/download/DownloadListener;", "resourceParser", "Lcom/qiahao/base_common/player/svga/SVGAResourceParser;", "isIgnoreFinished", "Ljava/lang/Boolean;", "parseCompletion", "Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "getParseCompletion", "()Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "parseCompletion$delegate", "setResourceParse", "", "parser", "bindingLifeCycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "prepare", "source", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "filePath", "", "startAssetsSVGA", "assetsFilePath", "restart", "stop", "reset", "postState", "setPlayWhenReady", "getPlayWhenReady", "getView", "Landroid/view/View;", "getCurrentState", "getCurrentSource", "setPlayerEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getPlayingPosition", "state", "postPlayWhenReady", "postError", "exception", "Lcom/qiahao/base_common/player/PlayerException;", "getDownloadListenerNotNull", "onPause", "onResume", "onDestroy", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SVGAPlayer extends SVGAImageView implements ISVGAPlayer, ILog, LifecycleObserver {

    @Nullable
    private DownloadListener downloadListener;

    /* renamed from: downloader$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy downloader;

    @Nullable
    private Boolean isIgnoreFinished;

    @Nullable
    private SVGAMediaSource mediaSource;

    /* renamed from: parseCompletion$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy parseCompletion;
    private boolean playWhenReady;
    private boolean playWhenReadyRecord;

    @Nullable
    private PlayerEventListener playerEventListener;

    @NotNull
    private PlayerState playerState;

    @Nullable
    private SVGAResourceParser resourceParser;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MediaDownloader.MediaDownloaderImpl downloader_delegate$lambda$0() {
        return new MediaDownloader.MediaDownloaderImpl(0L, 1, null);
    }

    private final DownloadListener getDownloadListenerNotNull() {
        if (this.downloadListener == null) {
            this.downloadListener = new DownloadListener() { // from class: com.qiahao.base_common.player.svga.SVGAPlayer$getDownloadListenerNotNull$1
                @Override // com.qiahao.base_common.download.DownloadListener
                public void onCompleted(DownloadTask task) {
                    SVGAMediaSource sVGAMediaSource;
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
                        if (filePath2 == null) {
                            filePath2 = "";
                        }
                        file2 = new File(filePath2);
                    }
                    sVGAMediaSource = SVGAPlayer.this.mediaSource;
                    if (!file2.exists() || sVGAMediaSource == null) {
                        SVGAPlayer.this.postError(new PlayerException(0, "下载文件异常"));
                        return;
                    }
                    SVGAPlayer sVGAPlayer = SVGAPlayer.this;
                    String filePath3 = task.getFilePath();
                    if (filePath3 != null) {
                        str = filePath3;
                    }
                    sVGAPlayer.prepare(str, sVGAMediaSource);
                }

                @Override // com.qiahao.base_common.download.DownloadListener
                public void onError(DownloadTask task, Throwable throwable) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    DownloadListener.DefaultImpls.onError(this, task, throwable);
                    ILog.DefaultImpls.logE$default((ILog) SVGAPlayer.this, "DownloadListener onError() e:" + throwable, (String) null, false, 6, (Object) null);
                    SVGAPlayer.this.postError(new PlayerException(0, "下载文件异常", throwable));
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

    private final SVGAParser.ParseCompletion getParseCompletion() {
        return (SVGAParser.ParseCompletion) this.parseCompletion.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.qiahao.base_common.player.svga.SVGAPlayer$parseCompletion$2$1] */
    public static final SVGAPlayer$parseCompletion$2$1 parseCompletion_delegate$lambda$1(final SVGAPlayer sVGAPlayer) {
        return new SVGAParser.ParseCompletion() { // from class: com.qiahao.base_common.player.svga.SVGAPlayer$parseCompletion$2$1
            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                SVGAMediaSource sVGAMediaSource;
                SVGADynamicEntity sVGADynamicEntity;
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                ILog.DefaultImpls.logD$default(SVGAPlayer.this, "ParseCompletion - onComplete()", null, false, 6, null);
                SVGAPlayer sVGAPlayer2 = SVGAPlayer.this;
                sVGAMediaSource = sVGAPlayer2.mediaSource;
                if (sVGAMediaSource != null) {
                    sVGADynamicEntity = sVGAMediaSource.getDynamicEntity();
                } else {
                    sVGADynamicEntity = null;
                }
                sVGAPlayer2.setVideoItem(videoItem, sVGADynamicEntity);
                if (SVGAPlayer.this.getPlayWhenReady()) {
                    SVGAPlayer.this.startAnimation();
                }
                SVGAPlayer.this.postState(PlayerState.READY);
            }

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
                ILog.DefaultImpls.logE$default((ILog) SVGAPlayer.this, "ParseCompletion - onError()", (String) null, false, 6, (Object) null);
                SVGAPlayer.this.postError(new PlayerException(0, "资源解析异常"));
            }
        };
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void postState(PlayerState state) {
        if (state != this.playerState) {
            this.playerState = state;
            PlayerEventListener playerEventListener = this.playerEventListener;
            if (playerEventListener != null) {
                playerEventListener.onPlayerStateChanged(this.playWhenReady, state);
            }
        }
    }

    private final void startAssetsSVGA(String assetsFilePath) {
        SVGAParser.INSTANCE.shareParser().decodeFromAssets(assetsFilePath, getParseCompletion());
    }

    static /* synthetic */ void stop$default(SVGAPlayer sVGAPlayer, boolean z10, boolean z11, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            sVGAPlayer.stop(z10, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
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

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    public final int getPlayingPosition() {
        SVGADrawable sVGADrawable;
        Drawable drawable = getDrawable();
        if (drawable instanceof SVGADrawable) {
            sVGADrawable = (SVGADrawable) drawable;
        } else {
            sVGADrawable = null;
        }
        if (sVGADrawable == null) {
            return 0;
        }
        return sVGADrawable.getCurrentFrame();
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.qiahao.base_common.player.IPlayer, com.oudi.utils.ICleared
    public void onCleared() {
        ILog.DefaultImpls.logD$default(this, "onCleared()", null, false, 6, null);
        getDownloader().onCleared();
        stop(true);
        clearAnimation();
        SVGAResourceParser sVGAResourceParser = this.resourceParser;
        if (sVGAResourceParser != null) {
            sVGAResourceParser.onCleared();
        }
        this.resourceParser = null;
        this.playerEventListener = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        onCleared();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.playWhenReadyRecord = getPlayWhenReady();
        setPlayWhenReady(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.playWhenReadyRecord) {
            setPlayWhenReady(true);
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void prepare(@NotNull PlayerMediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.playerState != PlayerState.IDLE) {
            stop(true, false);
        }
        this.isIgnoreFinished = null;
        SVGAMediaSource sVGAMediaSource = this.mediaSource;
        if (sVGAMediaSource != null) {
            sVGAMediaSource.onCleared();
        }
        boolean z10 = source instanceof SVGAMediaSource;
        this.mediaSource = z10 ? (SVGAMediaSource) source : null;
        postState(PlayerState.BUFFERING);
        if (!z10) {
            ILog.DefaultImpls.logE$default((ILog) this, "prepare() 不支持数据源", (String) null, false, 6, (Object) null);
            postError(new PlayerException(0, "不支持数据源"));
            return;
        }
        SVGAMediaSource sVGAMediaSource2 = (SVGAMediaSource) source;
        setScaleType(sVGAMediaSource2.getScaleType());
        setLoops(sVGAMediaSource2.getLoopCount() <= 0 ? Integer.MAX_VALUE : sVGAMediaSource2.getLoopCount());
        String filePath = sVGAMediaSource2.getFilePath();
        String url = sVGAMediaSource2.getUrl();
        String assetsFilePath = sVGAMediaSource2.getAssetsFilePath();
        if (assetsFilePath != null && assetsFilePath.length() != 0) {
            startAssetsSVGA(assetsFilePath);
            return;
        }
        if (filePath != null && filePath.length() != 0) {
            prepare(filePath, sVGAMediaSource2);
        } else if (url != null && url.length() != 0) {
            getDownloader().download(url, getDownloadListenerNotNull(), Boolean.FALSE);
        } else {
            postError(new PlayerException(0, "视频数据源信息不完整"));
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void restart() {
        stop(false);
        SVGAMediaSource sVGAMediaSource = this.mediaSource;
        if (sVGAMediaSource != null) {
            Intrinsics.checkNotNull(sVGAMediaSource);
            prepare(sVGAMediaSource);
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void setPlayWhenReady(boolean playWhenReady) {
        postPlayWhenReady(playWhenReady);
        if (playWhenReady) {
            this.isIgnoreFinished = null;
            if (getPlayerState() == PlayerState.READY) {
                super.stepToFrame(getPlayingPosition(), true);
                return;
            }
            return;
        }
        this.isIgnoreFinished = Boolean.TRUE;
        pauseAnimation();
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void setPlayerEventListener(@Nullable PlayerEventListener listener) {
        this.playerEventListener = listener;
    }

    @Override // com.qiahao.base_common.player.svga.ISVGAPlayer
    public void setResourceParse(@Nullable SVGAResourceParser parser) {
        this.resourceParser = parser;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void stop(boolean reset) {
        stop(reset, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void stop(boolean reset, boolean postState) {
        ILog.DefaultImpls.logD$default(this, "stop() reset:" + reset + " ,postState:" + postState, null, false, 6, null);
        this.isIgnoreFinished = Boolean.TRUE;
        stopAnimation(reset);
        setImageDrawable(null);
        if (reset) {
            SVGAMediaSource sVGAMediaSource = this.mediaSource;
            if (sVGAMediaSource != null) {
                sVGAMediaSource.onCleared();
            }
            this.mediaSource = null;
            getDownloader().onCleared();
        }
        if (postState) {
            postState(PlayerState.IDLE);
        }
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.playWhenReady = true;
        this.playerState = PlayerState.IDLE;
        this.downloader = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.svga.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MediaDownloader.MediaDownloaderImpl downloader_delegate$lambda$0;
                downloader_delegate$lambda$0 = SVGAPlayer.downloader_delegate$lambda$0();
                return downloader_delegate$lambda$0;
            }
        });
        this.parseCompletion = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.svga.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SVGAPlayer$parseCompletion$2$1 parseCompletion_delegate$lambda$1;
                parseCompletion_delegate$lambda$1 = SVGAPlayer.parseCompletion_delegate$lambda$1(SVGAPlayer.this);
                return parseCompletion_delegate$lambda$1;
            }
        });
        setCallback(new SVGACallback() { // from class: com.qiahao.base_common.player.svga.SVGAPlayer.1
            @Override // com.opensource.svgaplayer.SVGACallback
            public void onFinished() {
                ILog.DefaultImpls.logD$default(SVGAPlayer.this, "onFinished()", null, false, 6, null);
                if (!Intrinsics.areEqual(SVGAPlayer.this.isIgnoreFinished, Boolean.TRUE)) {
                    SVGAPlayer.this.postState(PlayerState.ENDED);
                }
                SVGAPlayer.this.isIgnoreFinished = null;
            }

            @Override // com.opensource.svgaplayer.SVGACallback
            public void onPause() {
            }

            @Override // com.opensource.svgaplayer.SVGACallback
            public void onRepeat() {
            }

            @Override // com.opensource.svgaplayer.SVGACallback
            public void onStep(int frame, double percentage) {
            }
        });
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepare(String filePath, SVGAMediaSource source) {
        ILog.DefaultImpls.logD$default(this, "prepare() filePath:" + filePath, null, false, 6, null);
        try {
            SVGAParser.decodeFromInputStream$default(SVGAParser.INSTANCE.shareParser(), new BufferedInputStream(new FileInputStream(filePath)), filePath, getParseCompletion(), true, null, null, 48, null);
        } catch (Exception e10) {
            ILog.DefaultImpls.logE$default((ILog) this, "prepare() e:" + e10, (String) null, false, 6, (Object) null);
            postError(new PlayerException(0, e10));
        }
    }
}
