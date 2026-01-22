package com.qiahao.base_common.player.vap;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.core.component.ICleared;
import com.oudi.utils.FileUtils;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.player.MediaDownloader;
import com.qiahao.base_common.player.PlayerEventListener;
import com.qiahao.base_common.player.PlayerException;
import com.qiahao.base_common.player.PlayerMediaSource;
import com.qiahao.base_common.player.PlayerState;
import com.qiahao.base_common.player.vap.IVapPlayer;
import com.tencent.qgame.animplayer.AnimConfig;
import com.tencent.qgame.animplayer.AnimView;
import com.tencent.qgame.animplayer.inter.IAnimListener;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eB+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u0010J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0016\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020\u0012J\u0010\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u00108\u001a\u00020,2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00109\u001a\u00020,2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010:\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016J\b\u0010<\u001a\u00020\u0019H\u0016J\b\u0010=\u001a\u00020,H\u0016J\u001a\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u00172\b\b\u0002\u0010>\u001a\u00020\u0017H\u0002J\u0010\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020#H\u0002J\u0010\u0010>\u001a\u00020,2\u0006\u0010C\u001a\u00020\u0019H\u0002J\u0010\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020%H\u0002J\b\u0010F\u001a\u00020,H\u0002J\u001a\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020\r2\b\u0010I\u001a\u0004\u0018\u000100H\u0002J\b\u0010J\u001a\u00020,H\u0002J\b\u0010K\u001a\u00020,H\u0007J\b\u0010L\u001a\u00020,H\u0007J\b\u0010M\u001a\u00020,H\u0007J\b\u0010N\u001a\u00020,H\u0016R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b(\u0010)¨\u0006O"}, d2 = {"Lcom/qiahao/base_common/player/vap/VapPlayer;", "Lcom/tencent/qgame/animplayer/AnimView;", "Lcom/qiahao/base_common/player/vap/IVapPlayer;", "Lcom/oudi/utils/log/ILog;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mediaSource", "Lcom/qiahao/base_common/player/vap/VapMediaSource;", "pendingMediaSource", "fetchResource", "Lcom/tencent/qgame/animplayer/inter/IFetchResource;", "playWhenReady", "", "playerState", "Lcom/qiahao/base_common/player/PlayerState;", "playerEventListener", "Lcom/qiahao/base_common/player/PlayerEventListener;", "downloader", "Lcom/qiahao/base_common/player/MediaDownloader;", "getDownloader", "()Lcom/qiahao/base_common/player/MediaDownloader;", "downloader$delegate", "Lkotlin/Lazy;", "downloadListener", "Lcom/qiahao/base_common/download/DownloadListener;", "currentPlaybackException", "Lcom/qiahao/base_common/player/PlayerException;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "prepare", "", "source", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "filePath", "", "stop", "reset", "getView", "Landroid/view/View;", "getCurrentSource", "setPlayerEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setFetchResource", "setSuperFetchResource", "setPlayWhenReady", "getPlayWhenReady", "getCurrentState", "restart", "postState", "bindingLifeCycle", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getDownloadListenerNotNull", "state", "postError", "exception", "onVideoStart", "onVideoFailed", "errorType", "errorMsg", "onVideoComplete", "onPause", "onResume", "onDestroy", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VapPlayer extends AnimView implements IVapPlayer, ILog, LifecycleObserver {

    @Nullable
    private PlayerException currentPlaybackException;

    @Nullable
    private DownloadListener downloadListener;

    /* renamed from: downloader$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy downloader;

    @Nullable
    private IFetchResource fetchResource;

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mainHandler;

    @Nullable
    private VapMediaSource mediaSource;

    @Nullable
    private VapMediaSource pendingMediaSource;
    private boolean playWhenReady;

    @Nullable
    private PlayerEventListener playerEventListener;

    @NotNull
    private PlayerState playerState;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"com/qiahao/base_common/player/vap/VapPlayer$1", "Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "onFailed", "", "errorType", "", "errorMsg", "", "onVideoComplete", "onVideoDestroy", "onVideoRender", "frameIndex", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "onVideoStart", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.qiahao.base_common.player.vap.VapPlayer$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnonymousClass1 implements IAnimListener {
        AnonymousClass1() {
        }

        public void onFailed(final int errorType, final String errorMsg) {
            Handler mainHandler = VapPlayer.this.getMainHandler();
            final VapPlayer vapPlayer = VapPlayer.this;
            mainHandler.post(new Runnable() { // from class: com.qiahao.base_common.player.vap.f
                @Override // java.lang.Runnable
                public final void run() {
                    VapPlayer.access$onVideoFailed(VapPlayer.this, errorType, errorMsg);
                }
            });
        }

        public void onVideoComplete() {
            Handler mainHandler = VapPlayer.this.getMainHandler();
            final VapPlayer vapPlayer = VapPlayer.this;
            mainHandler.post(new Runnable() { // from class: com.qiahao.base_common.player.vap.d
                @Override // java.lang.Runnable
                public final void run() {
                    VapPlayer.access$onVideoComplete(VapPlayer.this);
                }
            });
        }

        public boolean onVideoConfigReady(AnimConfig animConfig) {
            return IAnimListener.DefaultImpls.onVideoConfigReady(this, animConfig);
        }

        public void onVideoDestroy() {
        }

        public void onVideoRender(int frameIndex, AnimConfig config) {
        }

        public void onVideoStart() {
            Handler mainHandler = VapPlayer.this.getMainHandler();
            final VapPlayer vapPlayer = VapPlayer.this;
            mainHandler.post(new Runnable() { // from class: com.qiahao.base_common.player.vap.e
                @Override // java.lang.Runnable
                public final void run() {
                    VapPlayer.access$onVideoStart(VapPlayer.this);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VapPlayer(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ void access$onVideoComplete(VapPlayer vapPlayer) {
        vapPlayer.onVideoComplete();
    }

    public static final /* synthetic */ void access$onVideoFailed(VapPlayer vapPlayer, int i10, String str) {
        vapPlayer.onVideoFailed(i10, str);
    }

    public static final /* synthetic */ void access$onVideoStart(VapPlayer vapPlayer) {
        vapPlayer.onVideoStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MediaDownloader.MediaDownloaderImpl downloader_delegate$lambda$0() {
        return new MediaDownloader.MediaDownloaderImpl(0L, 1, null);
    }

    private final DownloadListener getDownloadListenerNotNull() {
        if (this.downloadListener == null) {
            this.downloadListener = new DownloadListener() { // from class: com.qiahao.base_common.player.vap.VapPlayer$getDownloadListenerNotNull$1
                @Override // com.qiahao.base_common.download.DownloadListener
                public void onCompleted(DownloadTask task) {
                    VapMediaSource vapMediaSource;
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
                    vapMediaSource = VapPlayer.this.mediaSource;
                    if (!file2.exists() || vapMediaSource == null) {
                        VapPlayer.this.postError(new PlayerException(0, "下载文件异常"));
                        return;
                    }
                    VapPlayer vapPlayer = VapPlayer.this;
                    String filePath3 = task.getFilePath();
                    if (filePath3 != null) {
                        str = filePath3;
                    }
                    vapPlayer.prepare(str, vapMediaSource);
                }

                @Override // com.qiahao.base_common.download.DownloadListener
                public void onError(DownloadTask task, Throwable throwable) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    DownloadListener.DefaultImpls.onError(this, task, throwable);
                    ILog.DefaultImpls.logE$default((ILog) VapPlayer.this, "DownloadListener onError() e:" + throwable, (String) null, false, 6, (Object) null);
                    VapPlayer.this.postError(new PlayerException(0, "下载文件异常", throwable));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mainHandler_delegate$lambda$1() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoComplete() {
        if (this.currentPlaybackException == null && getPlayerState() == PlayerState.READY) {
            postState(PlayerState.ENDED);
        } else {
            ILog.DefaultImpls.logD$default(this, "postComplete() 播放异常或主动停止播放导致的结束", null, false, 6, null);
        }
        VapMediaSource vapMediaSource = this.pendingMediaSource;
        if (vapMediaSource != null) {
            this.pendingMediaSource = null;
            prepare(vapMediaSource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoFailed(int errorType, String errorMsg) {
        ILog.DefaultImpls.logE$default((ILog) this, "onVideoFailed() errorType:" + errorType + " ,errorMsg:" + errorMsg, (String) null, false, 6, (Object) null);
        postError(new PlayerException(1, errorMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoStart() {
        postState(PlayerState.READY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postError(PlayerException exception) {
        this.currentPlaybackException = exception;
        PlayerEventListener playerEventListener = this.playerEventListener;
        if (playerEventListener != null) {
            playerEventListener.onPlayerError(exception);
        }
        postState(PlayerState.IDLE);
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

    private final void setSuperFetchResource(IFetchResource fetchResource) {
        super.setFetchResource(fetchResource);
    }

    static /* synthetic */ void stop$default(VapPlayer vapPlayer, boolean z10, boolean z11, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            vapPlayer.stop(z10, z11);
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

    @Override // com.qiahao.base_common.player.vap.IVapPlayer, com.qiahao.base_common.player.IPlayer
    public boolean getPlayWhenReady() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.base_common.player.IPlayer, com.oudi.utils.ICleared
    public void onCleared() {
        ICleared iCleared;
        ILog.DefaultImpls.logD$default(this, "onCleared()", null, false, 6, null);
        getDownloader().onCleared();
        stop(true);
        clearAnimation();
        setAnimListener((IAnimListener) null);
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
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        onCleared();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        setPlayWhenReady(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.mediaSource != null) {
            setPlayWhenReady(true);
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void prepare(@NotNull PlayerMediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (isRunning()) {
            ILog.DefaultImpls.logD$default(this, "prepare() 当前状态不可播放，添加至等待区", null, false, 6, null);
            this.pendingMediaSource = source instanceof VapMediaSource ? (VapMediaSource) source : null;
            stop(true, false);
            return;
        }
        if (this.playerState != PlayerState.IDLE) {
            stop(true, false);
        }
        this.currentPlaybackException = null;
        VapMediaSource vapMediaSource = this.mediaSource;
        if (vapMediaSource != null) {
            vapMediaSource.onCleared();
        }
        boolean z10 = source instanceof VapMediaSource;
        this.mediaSource = z10 ? (VapMediaSource) source : null;
        postState(PlayerState.BUFFERING);
        if (!z10) {
            ILog.DefaultImpls.logE$default((ILog) this, "prepare() 不支持数据源", (String) null, false, 6, (Object) null);
            postError(new PlayerException(0, "不支持数据源"));
            return;
        }
        VapMediaSource vapMediaSource2 = (VapMediaSource) source;
        setScaleType(vapMediaSource2.getScaleType());
        setLoop(vapMediaSource2.getLoopCount());
        IFetchResource fetchResource = vapMediaSource2.getFetchResource();
        if (fetchResource != null) {
            setSuperFetchResource(fetchResource);
        } else {
            setSuperFetchResource(this.fetchResource);
        }
        String filePath = vapMediaSource2.getFilePath();
        String url = vapMediaSource2.getUrl();
        if (filePath != null && filePath.length() != 0) {
            prepare(filePath, vapMediaSource2);
        } else if (url != null && url.length() != 0) {
            getDownloader().download(url, getDownloadListenerNotNull(), Boolean.FALSE);
        } else {
            postError(new PlayerException(0, "视频数据源信息不完整"));
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void restart() {
        IVapPlayer.DefaultImpls.restart(this);
        stop(false);
        VapMediaSource vapMediaSource = this.mediaSource;
        if (vapMediaSource != null) {
            Intrinsics.checkNotNull(vapMediaSource);
            prepare(vapMediaSource);
        }
    }

    @Override // com.qiahao.base_common.player.vap.IVapPlayer
    public void setFetchResource(@Nullable IFetchResource fetchResource) {
        this.fetchResource = fetchResource;
        super.setFetchResource(fetchResource);
    }

    @Override // com.qiahao.base_common.player.vap.IVapPlayer, com.qiahao.base_common.player.IPlayer
    public void setPlayWhenReady(boolean playWhenReady) {
        IVapPlayer.DefaultImpls.setPlayWhenReady(this, playWhenReady);
        if (playWhenReady) {
            restart();
        } else {
            stop(false);
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void setPlayerEventListener(@Nullable PlayerEventListener listener) {
        this.playerEventListener = listener;
    }

    @Override // com.qiahao.base_common.player.IPlayer
    public void stop(boolean reset) {
        stop(reset, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VapPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void stop(boolean reset, boolean postState) {
        ILog.DefaultImpls.logD$default(this, "stop() reset:" + reset + " ,postState:" + postState, null, false, 6, null);
        stopPlay();
        if (reset) {
            this.currentPlaybackException = null;
            VapMediaSource vapMediaSource = this.mediaSource;
            if (vapMediaSource != null) {
                vapMediaSource.onCleared();
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

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VapPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VapPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.playWhenReady = true;
        this.playerState = PlayerState.IDLE;
        this.downloader = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.vap.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MediaDownloader.MediaDownloaderImpl downloader_delegate$lambda$0;
                downloader_delegate$lambda$0 = VapPlayer.downloader_delegate$lambda$0();
                return downloader_delegate$lambda$0;
            }
        });
        this.mainHandler = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.vap.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Handler mainHandler_delegate$lambda$1;
                mainHandler_delegate$lambda$1 = VapPlayer.mainHandler_delegate$lambda$1();
                return mainHandler_delegate$lambda$1;
            }
        });
        setAnimListener(new AnonymousClass1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void prepare(@NotNull String filePath, @NotNull VapMediaSource source) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(source, "source");
        ILog.DefaultImpls.logD$default(this, "prepare() filePath:" + filePath, null, false, 6, null);
        if (new File(filePath).isAbsolute() && new File(filePath).exists()) {
            startPlay(new File(filePath));
            return;
        }
        AssetManager assets = getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        startPlay(assets, filePath);
    }
}
