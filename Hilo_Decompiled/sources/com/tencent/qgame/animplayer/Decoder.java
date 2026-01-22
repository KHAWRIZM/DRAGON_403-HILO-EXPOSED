package com.tencent.qgame.animplayer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qgame.animplayer.file.IFileContainer;
import com.tencent.qgame.animplayer.inter.IAnimListener;
import com.tencent.qgame.animplayer.util.ALog;
import com.tencent.qgame.animplayer.util.SpeedControlUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 J2\u00020\u0001:\u0001JB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H&J\u0006\u0010.\u001a\u00020-J\u001a\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0016\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nJ\b\u00106\u001a\u00020-H\u0016J\b\u00107\u001a\u00020-H\u0016J\u001a\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020-H\u0016J\u0016\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nJ\u000e\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011J\u0006\u0010B\u001a\u00020\u0011J\u0010\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020EH&J\u0006\u0010F\u001a\u00020-J\u0016\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u001b\u0010$\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/tencent/qgame/animplayer/Decoder;", "Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "player", "Lcom/tencent/qgame/animplayer/AnimPlayer;", "(Lcom/tencent/qgame/animplayer/AnimPlayer;)V", "decodeThread", "Lcom/tencent/qgame/animplayer/HandlerHolder;", "getDecodeThread", "()Lcom/tencent/qgame/animplayer/HandlerHolder;", "value", "", "fps", "getFps", "()I", "setFps", "(I)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "isStopReq", "setStopReq", "playLoop", "getPlayLoop", "setPlayLoop", "getPlayer", "()Lcom/tencent/qgame/animplayer/AnimPlayer;", "render", "Lcom/tencent/qgame/animplayer/IRenderListener;", "getRender", "()Lcom/tencent/qgame/animplayer/IRenderListener;", "setRender", "(Lcom/tencent/qgame/animplayer/IRenderListener;)V", "renderThread", "getRenderThread", "speedControlUtil", "Lcom/tencent/qgame/animplayer/util/SpeedControlUtil;", "getSpeedControlUtil", "()Lcom/tencent/qgame/animplayer/util/SpeedControlUtil;", "speedControlUtil$delegate", "Lkotlin/Lazy;", "surfaceHeight", "surfaceWidth", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "", "destroyThread", "onFailed", "errorType", "errorMsg", "", "onSurfaceSizeChanged", "width", "height", "onVideoComplete", "onVideoDestroy", "onVideoRender", "frameIndex", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "onVideoStart", "preparePlay", "videoWidth", "videoHeight", "prepareRender", "needYUV", "prepareThread", "start", "fileContainer", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "stop", "videoSizeChange", "newWidth", "newHeight", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class Decoder implements IAnimListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Decoder.class), "speedControlUtil", "getSpeedControlUtil()Lcom/tencent/qgame/animplayer/util/SpeedControlUtil;"))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AnimPlayer.Decoder";
    private int fps;
    private boolean isRunning;
    private boolean isStopReq;
    private int playLoop;

    @NotNull
    private final AnimPlayer player;

    @Nullable
    private IRenderListener render;
    private int surfaceHeight;
    private int surfaceWidth;

    @NotNull
    private final HandlerHolder renderThread = new HandlerHolder(null, null);

    @NotNull
    private final HandlerHolder decodeThread = new HandlerHolder(null, null);

    /* renamed from: speedControlUtil$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy speedControlUtil = LazyKt.lazy(new Function0<SpeedControlUtil>() { // from class: com.tencent.qgame.animplayer.Decoder$speedControlUtil$2
        @NotNull
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SpeedControlUtil m١٦٢invoke() {
            return new SpeedControlUtil();
        }
    });

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tencent/qgame/animplayer/Decoder$Companion;", "", "()V", "TAG", "", "createThread", "", "handlerHolder", "Lcom/tencent/qgame/animplayer/HandlerHolder;", "name", "quitSafely", "Landroid/os/HandlerThread;", "thread", "animplayer_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public final boolean createThread(@NotNull HandlerHolder handlerHolder, @NotNull String name) {
            HandlerThread thread;
            try {
                if (handlerHolder.getThread() != null && ((thread = handlerHolder.getThread()) == null || thread.isAlive())) {
                    return true;
                }
                HandlerThread handlerThread = new HandlerThread(name);
                handlerThread.start();
                handlerHolder.setHandler(new Handler(handlerThread.getLooper()));
                handlerHolder.setThread(handlerThread);
                return true;
            } catch (OutOfMemoryError e) {
                ALog.INSTANCE.e(Decoder.TAG, "createThread OOM", e);
                return false;
            }
        }

        @Nullable
        public final HandlerThread quitSafely(@Nullable HandlerThread thread) {
            if (thread != null) {
                thread.quitSafely();
                return null;
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Decoder(@NotNull AnimPlayer animPlayer) {
        this.player = animPlayer;
    }

    public abstract void destroy();

    public final void destroyThread() {
        if (this.player.getIsDetachedFromWindow()) {
            ALog.INSTANCE.i(TAG, "destroyThread");
            Handler handler = this.renderThread.getHandler();
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.decodeThread.getHandler();
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            HandlerHolder handlerHolder = this.renderThread;
            Companion companion = INSTANCE;
            handlerHolder.setThread(companion.quitSafely(handlerHolder.getThread()));
            HandlerHolder handlerHolder2 = this.decodeThread;
            handlerHolder2.setThread(companion.quitSafely(handlerHolder2.getThread()));
            this.renderThread.setHandler(null);
            this.decodeThread.setHandler(null);
        }
    }

    @NotNull
    public final HandlerHolder getDecodeThread() {
        return this.decodeThread;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getPlayLoop() {
        return this.playLoop;
    }

    @NotNull
    public final AnimPlayer getPlayer() {
        return this.player;
    }

    @Nullable
    public final IRenderListener getRender() {
        return this.render;
    }

    @NotNull
    public final HandlerHolder getRenderThread() {
        return this.renderThread;
    }

    @NotNull
    public final SpeedControlUtil getSpeedControlUtil() {
        Lazy lazy = this.speedControlUtil;
        KProperty kProperty = $$delegatedProperties[0];
        return (SpeedControlUtil) lazy.getValue();
    }

    /* renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    /* renamed from: isStopReq, reason: from getter */
    public final boolean getIsStopReq() {
        return this.isStopReq;
    }

    @Override // com.tencent.qgame.animplayer.inter.IAnimListener
    public void onFailed(int errorType, @Nullable String errorMsg) {
        ALog.INSTANCE.e(TAG, "onFailed errorType=" + errorType + ", errorMsg=" + errorMsg);
        IAnimListener animListener = this.player.getAnimListener();
        if (animListener != null) {
            animListener.onFailed(errorType, errorMsg);
        }
    }

    public final void onSurfaceSizeChanged(int width, int height) {
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        IRenderListener iRenderListener = this.render;
        if (iRenderListener != null) {
            iRenderListener.updateViewPort(width, height);
        }
    }

    @Override // com.tencent.qgame.animplayer.inter.IAnimListener
    public void onVideoComplete() {
        ALog.INSTANCE.i(TAG, "onVideoComplete");
        IAnimListener animListener = this.player.getAnimListener();
        if (animListener != null) {
            animListener.onVideoComplete();
        }
    }

    @Override // com.tencent.qgame.animplayer.inter.IAnimListener
    public boolean onVideoConfigReady(@NotNull AnimConfig animConfig) {
        return IAnimListener.DefaultImpls.onVideoConfigReady(this, animConfig);
    }

    @Override // com.tencent.qgame.animplayer.inter.IAnimListener
    public void onVideoDestroy() {
        ALog.INSTANCE.i(TAG, "onVideoDestroy");
        IAnimListener animListener = this.player.getAnimListener();
        if (animListener != null) {
            animListener.onVideoDestroy();
        }
    }

    @Override // com.tencent.qgame.animplayer.inter.IAnimListener
    public void onVideoRender(int frameIndex, @Nullable AnimConfig config) {
        ALog.INSTANCE.d(TAG, "onVideoRender");
        IAnimListener animListener = this.player.getAnimListener();
        if (animListener != null) {
            animListener.onVideoRender(frameIndex, config);
        }
    }

    @Override // com.tencent.qgame.animplayer.inter.IAnimListener
    public void onVideoStart() {
        ALog.INSTANCE.i(TAG, "onVideoStart");
        IAnimListener animListener = this.player.getAnimListener();
        if (animListener != null) {
            animListener.onVideoStart();
        }
    }

    public final void preparePlay(int videoWidth, int videoHeight) {
        IRenderListener iRenderListener;
        this.player.getConfigManager().defaultConfig(videoWidth, videoHeight);
        AnimConfig config = this.player.getConfigManager().getConfig();
        if (config != null && (iRenderListener = this.render) != null) {
            iRenderListener.setAnimConfig(config);
        }
        this.player.getPluginManager().onRenderCreate();
    }

    public final boolean prepareRender(boolean needYUV) {
        if (this.render == null) {
            ALog aLog = ALog.INSTANCE;
            aLog.i(TAG, "prepareRender");
            SurfaceTexture surfaceTexture = this.player.getAnimView().getSurfaceTexture();
            if (surfaceTexture != null) {
                if (needYUV) {
                    aLog.i(TAG, "use yuv render");
                    this.render = new YUVRender(surfaceTexture);
                } else {
                    Render render = new Render(surfaceTexture);
                    render.updateViewPort(this.surfaceWidth, this.surfaceHeight);
                    this.render = render;
                }
            }
        }
        if (this.render != null) {
            return true;
        }
        return false;
    }

    public final boolean prepareThread() {
        Companion companion = INSTANCE;
        if (companion.createThread(this.renderThread, "anim_render_thread") && companion.createThread(this.decodeThread, "anim_decode_thread")) {
            return true;
        }
        return false;
    }

    public final void setFps(int i) {
        getSpeedControlUtil().setFixedPlaybackRate(i);
        this.fps = i;
    }

    public final void setPlayLoop(int i) {
        this.playLoop = i;
    }

    public final void setRender(@Nullable IRenderListener iRenderListener) {
        this.render = iRenderListener;
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
    }

    public final void setStopReq(boolean z) {
        this.isStopReq = z;
    }

    public abstract void start(@NotNull IFileContainer fileContainer);

    public final void stop() {
        this.isStopReq = true;
    }

    public final void videoSizeChange(int newWidth, int newHeight) {
        AnimConfig config;
        if (newWidth > 0 && newHeight > 0 && (config = this.player.getConfigManager().getConfig()) != null) {
            if (config.getVideoWidth() != newWidth || config.getVideoHeight() != newHeight) {
                ALog.INSTANCE.i(TAG, "videoSizeChange old=(" + config.getVideoWidth() + ',' + config.getVideoHeight() + "), new=(" + newWidth + ',' + newHeight + ')');
                config.setVideoWidth(newWidth);
                config.setVideoHeight(newHeight);
                IRenderListener iRenderListener = this.render;
                if (iRenderListener != null) {
                    iRenderListener.setAnimConfig(config);
                }
            }
        }
    }
}
