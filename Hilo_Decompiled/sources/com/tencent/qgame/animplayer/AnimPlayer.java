package com.tencent.qgame.animplayer;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qgame.animplayer.file.IFileContainer;
import com.tencent.qgame.animplayer.inter.IAnimListener;
import com.tencent.qgame.animplayer.mask.MaskConfig;
import com.tencent.qgame.animplayer.plugin.AnimPluginManager;
import com.tencent.qgame.animplayer.util.ALog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 [2\u00020\u0001:\u0001[B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0002J\u0006\u0010O\u001a\u00020$J\u0016\u0010P\u001a\u00020L2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001eJ\u0006\u0010S\u001a\u00020LJ\u0016\u0010T\u001a\u00020L2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001eJ\b\u0010U\u001a\u00020LH\u0002J\u000e\u0010V\u001a\u00020L2\u0006\u0010M\u001a\u00020NJ\u0006\u0010W\u001a\u00020LJ\u0010\u0010X\u001a\u00020L2\b\u0010Y\u001a\u0004\u0018\u00010ZR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010-\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010/\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001a\u00101\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R\u001a\u00103\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u00105\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R$\u00108\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010&\"\u0004\bG\u0010(R\u001a\u0010H\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\"¨\u0006\\"}, d2 = {"Lcom/tencent/qgame/animplayer/AnimPlayer;", "", "animView", "Lcom/tencent/qgame/animplayer/IAnimView;", "(Lcom/tencent/qgame/animplayer/IAnimView;)V", "animListener", "Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "getAnimListener", "()Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "setAnimListener", "(Lcom/tencent/qgame/animplayer/inter/IAnimListener;)V", "getAnimView", "()Lcom/tencent/qgame/animplayer/IAnimView;", "audioPlayer", "Lcom/tencent/qgame/animplayer/AudioPlayer;", "getAudioPlayer", "()Lcom/tencent/qgame/animplayer/AudioPlayer;", "setAudioPlayer", "(Lcom/tencent/qgame/animplayer/AudioPlayer;)V", "configManager", "Lcom/tencent/qgame/animplayer/AnimConfigManager;", "getConfigManager", "()Lcom/tencent/qgame/animplayer/AnimConfigManager;", "decoder", "Lcom/tencent/qgame/animplayer/Decoder;", "getDecoder", "()Lcom/tencent/qgame/animplayer/Decoder;", "setDecoder", "(Lcom/tencent/qgame/animplayer/Decoder;)V", "defaultFps", "", "getDefaultFps", "()I", "setDefaultFps", "(I)V", "enableVersion1", "", "getEnableVersion1", "()Z", "setEnableVersion1", "(Z)V", "value", "fps", "getFps", "setFps", "isDetachedFromWindow", "setDetachedFromWindow", "isMute", "setMute", "isStartRunning", "setStartRunning", "isSurfaceAvailable", "setSurfaceAvailable", "maskEdgeBlurBoolean", "getMaskEdgeBlurBoolean", "setMaskEdgeBlurBoolean", "playLoop", "getPlayLoop", "setPlayLoop", "pluginManager", "Lcom/tencent/qgame/animplayer/plugin/AnimPluginManager;", "getPluginManager", "()Lcom/tencent/qgame/animplayer/plugin/AnimPluginManager;", "startRunnable", "Ljava/lang/Runnable;", "getStartRunnable", "()Ljava/lang/Runnable;", "setStartRunnable", "(Ljava/lang/Runnable;)V", "supportMaskBoolean", "getSupportMaskBoolean", "setSupportMaskBoolean", "videoMode", "getVideoMode", "setVideoMode", "innerStartPlay", "", "fileContainer", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "isRunning", "onSurfaceTextureAvailable", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "prepareDecoder", "startPlay", "stopPlay", "updateMaskConfig", "maskConfig", "Lcom/tencent/qgame/animplayer/mask/MaskConfig;", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AnimPlayer {
    private static final String TAG = "AnimPlayer.AnimPlayer";

    @Nullable
    private IAnimListener animListener;

    @NotNull
    private final IAnimView animView;

    @Nullable
    private AudioPlayer audioPlayer;

    @Nullable
    private Decoder decoder;
    private int defaultFps;
    private boolean enableVersion1;
    private int fps;
    private boolean isDetachedFromWindow;
    private boolean isMute;
    private boolean isStartRunning;
    private boolean isSurfaceAvailable;
    private boolean maskEdgeBlurBoolean;
    private int playLoop;

    @Nullable
    private Runnable startRunnable;
    private boolean supportMaskBoolean;
    private int videoMode = 1;

    @NotNull
    private final AnimConfigManager configManager = new AnimConfigManager(this);

    @NotNull
    private final AnimPluginManager pluginManager = new AnimPluginManager(this);

    public AnimPlayer(@NotNull IAnimView iAnimView) {
        this.animView = iAnimView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void innerStartPlay(final IFileContainer fileContainer) {
        AudioPlayer audioPlayer;
        synchronized (AnimPlayer.class) {
            try {
                if (this.isSurfaceAvailable) {
                    this.isStartRunning = false;
                    Decoder decoder = this.decoder;
                    if (decoder != null) {
                        decoder.start(fileContainer);
                    }
                    if (!this.isMute && (audioPlayer = this.audioPlayer) != null) {
                        audioPlayer.start(fileContainer);
                    }
                } else {
                    this.startRunnable = new Runnable() { // from class: com.tencent.qgame.animplayer.AnimPlayer$innerStartPlay$$inlined$synchronized$lambda$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnimPlayer.this.innerStartPlay(fileContainer);
                        }
                    };
                    this.animView.prepareTextureView();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void prepareDecoder() {
        if (this.decoder == null) {
            HardDecoder hardDecoder = new HardDecoder(this);
            hardDecoder.setPlayLoop(this.playLoop);
            hardDecoder.setFps(this.fps);
            this.decoder = hardDecoder;
        }
        if (this.audioPlayer == null) {
            AudioPlayer audioPlayer = new AudioPlayer(this);
            audioPlayer.setPlayLoop(this.playLoop);
            this.audioPlayer = audioPlayer;
        }
    }

    @Nullable
    public final IAnimListener getAnimListener() {
        return this.animListener;
    }

    @NotNull
    public final IAnimView getAnimView() {
        return this.animView;
    }

    @Nullable
    public final AudioPlayer getAudioPlayer() {
        return this.audioPlayer;
    }

    @NotNull
    public final AnimConfigManager getConfigManager() {
        return this.configManager;
    }

    @Nullable
    public final Decoder getDecoder() {
        return this.decoder;
    }

    public final int getDefaultFps() {
        return this.defaultFps;
    }

    public final boolean getEnableVersion1() {
        return this.enableVersion1;
    }

    public final int getFps() {
        return this.fps;
    }

    public final boolean getMaskEdgeBlurBoolean() {
        return this.maskEdgeBlurBoolean;
    }

    public final int getPlayLoop() {
        return this.playLoop;
    }

    @NotNull
    public final AnimPluginManager getPluginManager() {
        return this.pluginManager;
    }

    @Nullable
    public final Runnable getStartRunnable() {
        return this.startRunnable;
    }

    public final boolean getSupportMaskBoolean() {
        return this.supportMaskBoolean;
    }

    public final int getVideoMode() {
        return this.videoMode;
    }

    /* renamed from: isDetachedFromWindow, reason: from getter */
    public final boolean getIsDetachedFromWindow() {
        return this.isDetachedFromWindow;
    }

    /* renamed from: isMute, reason: from getter */
    public final boolean getIsMute() {
        return this.isMute;
    }

    public final boolean isRunning() {
        boolean z;
        if (!this.isStartRunning) {
            Decoder decoder = this.decoder;
            if (decoder != null) {
                z = decoder.getIsRunning();
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isStartRunning, reason: from getter */
    public final boolean getIsStartRunning() {
        return this.isStartRunning;
    }

    /* renamed from: isSurfaceAvailable, reason: from getter */
    public final boolean getIsSurfaceAvailable() {
        return this.isSurfaceAvailable;
    }

    public final void onSurfaceTextureAvailable(int width, int height) {
        this.isSurfaceAvailable = true;
        Runnable runnable = this.startRunnable;
        if (runnable != null) {
            runnable.run();
        }
        this.startRunnable = null;
    }

    public final void onSurfaceTextureDestroyed() {
        this.isSurfaceAvailable = false;
        this.isStartRunning = false;
        Decoder decoder = this.decoder;
        if (decoder != null) {
            decoder.destroy();
        }
        AudioPlayer audioPlayer = this.audioPlayer;
        if (audioPlayer != null) {
            audioPlayer.destroy();
        }
    }

    public final void onSurfaceTextureSizeChanged(int width, int height) {
        Decoder decoder = this.decoder;
        if (decoder != null) {
            decoder.onSurfaceSizeChanged(width, height);
        }
    }

    public final void setAnimListener(@Nullable IAnimListener iAnimListener) {
        this.animListener = iAnimListener;
    }

    public final void setAudioPlayer(@Nullable AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    public final void setDecoder(@Nullable Decoder decoder) {
        this.decoder = decoder;
    }

    public final void setDefaultFps(int i) {
        this.defaultFps = i;
    }

    public final void setDetachedFromWindow(boolean z) {
        this.isDetachedFromWindow = z;
    }

    public final void setEnableVersion1(boolean z) {
        this.enableVersion1 = z;
    }

    public final void setFps(int i) {
        Decoder decoder = this.decoder;
        if (decoder != null) {
            decoder.setFps(i);
        }
        this.fps = i;
    }

    public final void setMaskEdgeBlurBoolean(boolean z) {
        this.maskEdgeBlurBoolean = z;
    }

    public final void setMute(boolean z) {
        this.isMute = z;
    }

    public final void setPlayLoop(int i) {
        Decoder decoder = this.decoder;
        if (decoder != null) {
            decoder.setPlayLoop(i);
        }
        AudioPlayer audioPlayer = this.audioPlayer;
        if (audioPlayer != null) {
            audioPlayer.setPlayLoop(i);
        }
        this.playLoop = i;
    }

    public final void setStartRunnable(@Nullable Runnable runnable) {
        this.startRunnable = runnable;
    }

    public final void setStartRunning(boolean z) {
        this.isStartRunning = z;
    }

    public final void setSupportMaskBoolean(boolean z) {
        this.supportMaskBoolean = z;
    }

    public final void setSurfaceAvailable(boolean z) {
        this.isSurfaceAvailable = z;
    }

    public final void setVideoMode(int i) {
        this.videoMode = i;
    }

    public final void startPlay(@NotNull final IFileContainer fileContainer) {
        HandlerHolder renderThread;
        Handler handler;
        this.isStartRunning = true;
        prepareDecoder();
        Decoder decoder = this.decoder;
        if (decoder != null && !decoder.prepareThread()) {
            this.isStartRunning = false;
            Decoder decoder2 = this.decoder;
            if (decoder2 != null) {
                decoder2.onFailed(10003, Constant.ERROR_MSG_CREATE_THREAD);
            }
            Decoder decoder3 = this.decoder;
            if (decoder3 != null) {
                decoder3.onVideoComplete();
                return;
            }
            return;
        }
        Decoder decoder4 = this.decoder;
        if (decoder4 != null && (renderThread = decoder4.getRenderThread()) != null && (handler = renderThread.getHandler()) != null) {
            handler.post(new Runnable() { // from class: com.tencent.qgame.animplayer.AnimPlayer$startPlay$1
                @Override // java.lang.Runnable
                public final void run() {
                    IAnimListener animListener;
                    int parseConfig = AnimPlayer.this.getConfigManager().parseConfig(fileContainer, AnimPlayer.this.getEnableVersion1(), AnimPlayer.this.getVideoMode(), AnimPlayer.this.getDefaultFps());
                    if (parseConfig != 0) {
                        AnimPlayer.this.setStartRunning(false);
                        Decoder decoder5 = AnimPlayer.this.getDecoder();
                        if (decoder5 != null) {
                            decoder5.onFailed(parseConfig, Constant.getErrorMsg$default(Constant.INSTANCE, parseConfig, null, 2, null));
                        }
                        Decoder decoder6 = AnimPlayer.this.getDecoder();
                        if (decoder6 != null) {
                            decoder6.onVideoComplete();
                            return;
                        }
                        return;
                    }
                    ALog aLog = ALog.INSTANCE;
                    aLog.i("AnimPlayer.AnimPlayer", "parse " + AnimPlayer.this.getConfigManager().getConfig());
                    AnimConfig config = AnimPlayer.this.getConfigManager().getConfig();
                    if (config != null && (config.getIsDefaultConfig() || ((animListener = AnimPlayer.this.getAnimListener()) != null && animListener.onVideoConfigReady(config)))) {
                        AnimPlayer.this.innerStartPlay(fileContainer);
                    } else {
                        aLog.i("AnimPlayer.AnimPlayer", "onVideoConfigReady return false");
                    }
                }
            });
        }
    }

    public final void stopPlay() {
        Decoder decoder = this.decoder;
        if (decoder != null) {
            decoder.stop();
        }
        AudioPlayer audioPlayer = this.audioPlayer;
        if (audioPlayer != null) {
            audioPlayer.stop();
        }
    }

    public final void updateMaskConfig(@Nullable MaskConfig maskConfig) {
        MaskConfig maskConfig2;
        MaskConfig maskConfig3;
        Pair<PointRect, RefVec2> pair;
        MaskConfig maskConfig4;
        Bitmap bitmap;
        MaskConfig maskConfig5;
        AnimConfig config = this.configManager.getConfig();
        if (config != null) {
            AnimConfig config2 = this.configManager.getConfig();
            if (config2 == null || (maskConfig5 = config2.getMaskConfig()) == null) {
                maskConfig5 = new MaskConfig();
            }
            config.setMaskConfig(maskConfig5);
        }
        AnimConfig config3 = this.configManager.getConfig();
        Pair<PointRect, RefVec2> pair2 = null;
        if (config3 != null && (maskConfig4 = config3.getMaskConfig()) != null) {
            if (maskConfig != null) {
                bitmap = maskConfig.getAlphaMaskBitmap();
            } else {
                bitmap = null;
            }
            maskConfig4.safeSetMaskBitmapAndReleasePre(bitmap);
        }
        AnimConfig config4 = this.configManager.getConfig();
        if (config4 != null && (maskConfig3 = config4.getMaskConfig()) != null) {
            if (maskConfig != null) {
                pair = maskConfig.getMaskPositionPair();
            } else {
                pair = null;
            }
            maskConfig3.setMaskPositionPair(pair);
        }
        AnimConfig config5 = this.configManager.getConfig();
        if (config5 != null && (maskConfig2 = config5.getMaskConfig()) != null) {
            if (maskConfig != null) {
                pair2 = maskConfig.getMaskTexPair();
            }
            maskConfig2.setMaskTexPair(pair2);
        }
    }
}
