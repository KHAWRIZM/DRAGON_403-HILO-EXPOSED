package io.agora.rtc.gl;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.liulishuo.okdownload.DownloadTask;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.ATrace;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class TextureBufferPool {
    private static final String TAG = "TextureBufferPool";
    private static final boolean VERBOSE = false;
    private static final AtomicInteger nextSeq = new AtomicInteger(0);
    private final GlRectDrawer drawer;
    private int dropCount;
    private final EglBase eglBase;
    private final EglBase.Context eglContext;
    private final int glPixelFormat;
    private final Handler handler;
    private boolean isQuitting;
    private final int keepBufferCnt;
    private final int maxBufferCnt;
    private final String name;
    private final boolean ownGlThread;
    private final boolean shrinkPool;
    private final ArrayList<TextureInfo> textureInfoList;
    private final YuvConverter yuvConverter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.agora.rtc.gl.TextureBufferPool$5, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type;

        static {
            int[] iArr = new int[VideoFrame.TextureBuffer.Type.values().length];
            $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type = iArr;
            try {
                iArr[VideoFrame.TextureBuffer.Type.OES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type[VideoFrame.TextureBuffer.Type.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class TextureInfo {
        int frameBufferId;
        int textureId;
        boolean inUse = false;
        boolean specified = false;
        int width = 0;
        int height = 0;

        public TextureInfo(int i10, int i11) {
            this.textureId = i10;
            this.frameBufferId = i11;
        }

        public String toString() {
            return "TextureInfo{textureId=" + this.textureId + ", frameBufferId=" + this.frameBufferId + ", inUse=" + this.inUse + ", specified=" + this.specified + ", width=" + this.width + ", height=" + this.height + '}';
        }
    }

    private TextureInfo acquireTextureFramebuffer() {
        TextureInfo textureInfo;
        Iterator<TextureInfo> it = this.textureInfoList.iterator();
        while (true) {
            if (it.hasNext()) {
                textureInfo = it.next();
                if (!textureInfo.inUse) {
                    break;
                }
            } else {
                textureInfo = null;
                break;
            }
        }
        if (textureInfo == null) {
            if (this.textureInfoList.size() >= this.maxBufferCnt) {
                int i10 = this.dropCount + 1;
                this.dropCount = i10;
                ATrace.traceCounter("Drop@TexPool", i10);
                return null;
            }
            int generateTexture = GlUtil.generateTexture(3553);
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            TextureInfo textureInfo2 = new TextureInfo(generateTexture, iArr[0]);
            this.textureInfoList.add(textureInfo2);
            textureInfo = textureInfo2;
        }
        textureInfo.inUse = true;
        return textureInfo;
    }

    public static VideoFrame.TextureBuffer.Type agoraFrameTypeToTextureBufferType(int i10) {
        if (i10 == 11) {
            return VideoFrame.TextureBuffer.Type.OES;
        }
        return VideoFrame.TextureBuffer.Type.RGB;
    }

    public static TextureBufferPool create(final String str, final EglBase.Context context, final int i10) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        return (TextureBufferPool) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<TextureBufferPool>() { // from class: io.agora.rtc.gl.TextureBufferPool.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public TextureBufferPool call() {
                try {
                    EglBase create = EglBase.create(EglBase.Context.this, EglBase.CONFIG_PIXEL_BUFFER);
                    try {
                        create.createDummyPbufferSurface();
                        create.makeCurrent();
                        return new TextureBufferPool(str, i10, 6408, handler, true, create, null);
                    } catch (RuntimeException e10) {
                        Logging.e(TextureBufferPool.TAG, str + " failed to create pbufferSurface!!");
                        create.release();
                        throw e10;
                    }
                } catch (RuntimeException e11) {
                    Logging.e(TextureBufferPool.TAG, str + " create failure", e11);
                    handler.getLooper().quit();
                    return null;
                }
            }
        });
    }

    public static TextureBufferPool createWithinGlThread(String str, int i10, int i11, Handler handler, EglBase eglBase, YuvConverter yuvConverter) {
        return new TextureBufferPool(str, i10, i11, handler, false, eglBase, yuvConverter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoFrame.TextureBuffer doTextureCopy(int i10, VideoFrame.TextureBuffer.Type type, int i11, int i12, Matrix matrix, final Runnable runnable) {
        final TextureInfo acquireTextureFramebuffer = acquireTextureFramebuffer();
        if (acquireTextureFramebuffer == null) {
            return null;
        }
        ATrace.beginSection("setupTextureFrameBuffer");
        boolean z10 = setupTextureFrameBuffer(acquireTextureFramebuffer, i11, i12);
        ATrace.endSection();
        if (!z10) {
            releaseTextureFramebuffer(acquireTextureFramebuffer);
            return null;
        }
        GLES20.glBindFramebuffer(36160, acquireTextureFramebuffer.frameBufferId);
        ATrace.beginSection("drawTexture");
        drawTexture(i10, type, i11, i12);
        ATrace.endSection();
        ATrace.beginSection("flush");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        GLES20.glFlush();
        ATrace.endSection();
        TextureBufferImpl textureBufferImpl = new TextureBufferImpl(this.eglContext, i11, i12, VideoFrame.TextureBuffer.Type.RGB, acquireTextureFramebuffer.textureId, matrix, this.handler, this.yuvConverter, new Runnable() { // from class: io.agora.rtc.gl.TextureBufferPool.4
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferPool.this.handler.post(new Runnable() { // from class: io.agora.rtc.gl.TextureBufferPool.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        TextureBufferPool.this.releaseTextureFramebuffer(acquireTextureFramebuffer);
                        if (TextureBufferPool.this.isQuitting && !TextureBufferPool.this.anyTextureInUse()) {
                            Logging.i(TextureBufferPool.TAG, TextureBufferPool.this.name + " ready to release since no buffer in flight");
                            TextureBufferPool.this.release();
                        }
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                });
            }
        }, nextSeq.getAndIncrement());
        final VideoFrame.TextureBuffer[] textureBufferArr = {textureBufferImpl};
        return textureBufferImpl;
    }

    private void drawTexture(int i10, VideoFrame.TextureBuffer.Type type, int i11, int i12) {
        GLES20.glClear(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        int i13 = AnonymousClass5.$SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type[type.ordinal()];
        if (i13 != 1) {
            if (i13 == 2) {
                this.drawer.drawRgb(i10, GlUtil.IDENTITY_MATRIX, i11, i12, 0, 0, i11, i12);
            } else {
                throw new RuntimeException("Unknown texture type.");
            }
        } else {
            this.drawer.drawOes(i10, GlUtil.IDENTITY_MATRIX, i11, i12, 0, 0, i11, i12);
        }
        GlUtil.checkNoGLES2Error("TextureBufferPool.drawFrameBuffer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Logging.i(TAG, this.name + " release()");
        if (!this.textureInfoList.isEmpty()) {
            int size = this.textureInfoList.size();
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                TextureInfo textureInfo = this.textureInfoList.get(i10);
                iArr[i10] = textureInfo.textureId;
                iArr2[i10] = textureInfo.frameBufferId;
            }
            Logging.d(TAG, this.name + ": delete textures " + Arrays.toString(iArr));
            GLES20.glDeleteTextures(size, iArr, 0);
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.textureInfoList.clear();
        }
        this.drawer.release();
        if (this.ownGlThread) {
            EglBase eglBase = this.eglBase;
            if (eglBase != null) {
                eglBase.release();
            }
            this.handler.getLooper().quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseTextureFramebuffer(TextureInfo textureInfo) {
        textureInfo.inUse = false;
        int indexOf = this.textureInfoList.indexOf(textureInfo);
        if (indexOf < 0) {
            Logging.e(TAG, "texture info not found!");
        } else if (indexOf >= this.keepBufferCnt) {
            GLES20.glDeleteTextures(1, new int[]{textureInfo.textureId}, 0);
            GLES20.glDeleteFramebuffers(1, new int[]{textureInfo.frameBufferId}, 0);
            this.textureInfoList.remove(indexOf);
        }
    }

    private boolean setupTextureFrameBuffer(TextureInfo textureInfo, int i10, int i11) {
        if (i10 > 0 && i11 > 0) {
            if (textureInfo.specified && textureInfo.width == i10 && textureInfo.height == i11) {
                return true;
            }
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, textureInfo.textureId);
            ATrace.beginSection("glTexImage2D");
            int i12 = this.glPixelFormat;
            GLES20.glTexImage2D(3553, 0, i12, i10, i11, 0, i12, 5121, null);
            ATrace.endSection();
            GlUtil.checkNoGLES2Error("TextureBufferPool.glTexImage2D");
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, textureInfo.frameBufferId);
            ATrace.beginSection("glFramebufferTexture2D");
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, textureInfo.textureId, 0);
            ATrace.endSection();
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            GLES20.glBindFramebuffer(36160, 0);
            if (glCheckFramebufferStatus != 36053) {
                Logging.w(TAG, "Framebuffer not complete, status: " + glCheckFramebufferStatus);
                return false;
            }
            textureInfo.specified = true;
            textureInfo.width = i10;
            textureInfo.height = i11;
            return true;
        }
        Logging.w(TAG, "Invalid size: " + i10 + "x" + i11);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean anyTextureInUse() {
        Iterator<TextureInfo> it = this.textureInfoList.iterator();
        while (it.hasNext()) {
            if (it.next().inUse) {
                return true;
            }
        }
        return false;
    }

    public void dispose() {
        Logging.i(TAG, this.name + " dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: io.agora.rtc.gl.TextureBufferPool.3
            @Override // java.lang.Runnable
            public void run() {
                TextureBufferPool.this.isQuitting = true;
                if (!TextureBufferPool.this.anyTextureInUse()) {
                    Logging.i(TextureBufferPool.TAG, TextureBufferPool.this.name + " ready to release since no more buffer in flight");
                    TextureBufferPool.this.release();
                }
            }
        });
    }

    public VideoFrame.TextureBuffer makeTextureBuffer(int i10, int i11, int i12, int i13, float[] fArr) {
        Matrix convertMatrixToAndroidGraphicsMatrix;
        if (fArr == null) {
            convertMatrixToAndroidGraphicsMatrix = new Matrix();
        } else {
            convertMatrixToAndroidGraphicsMatrix = RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr);
        }
        return new TextureBufferImpl(this.eglContext, i12, i13, agoraFrameTypeToTextureBufferType(i10), i11, convertMatrixToAndroidGraphicsMatrix, this.handler, this.yuvConverter, null, nextSeq.getAndIncrement());
    }

    public VideoFrame.TextureBuffer textureCopy(VideoFrame.TextureBuffer textureBuffer, Runnable runnable) {
        if (textureBuffer == null) {
            return null;
        }
        return textureCopy(textureBuffer.getTextureId(), textureBuffer.getType(), textureBuffer.getWidth(), textureBuffer.getHeight(), textureBuffer.getTransformMatrix(), runnable);
    }

    private TextureBufferPool(String str, int i10, int i11, Handler handler, boolean z10, EglBase eglBase, YuvConverter yuvConverter) {
        this.shrinkPool = true;
        this.textureInfoList = new ArrayList<>();
        this.isQuitting = false;
        this.dropCount = 0;
        Logging.i(TAG, str + " init buffer pool, ownGlThread: " + z10 + " cnt: " + i10);
        this.name = str;
        int max = Math.max(i10, 1);
        this.maxBufferCnt = max;
        this.keepBufferCnt = Math.min(max, 3);
        this.glPixelFormat = i11;
        this.handler = handler;
        this.ownGlThread = z10;
        this.eglBase = eglBase;
        this.yuvConverter = yuvConverter == null ? new YuvConverter() : yuvConverter;
        this.eglContext = eglBase.getEglBaseContext();
        this.drawer = new GlRectDrawer();
    }

    public VideoFrame.TextureBuffer textureCopy(final int i10, final VideoFrame.TextureBuffer.Type type, final int i11, final int i12, final Matrix matrix, final Runnable runnable) {
        return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Callable<VideoFrame.TextureBuffer>() { // from class: io.agora.rtc.gl.TextureBufferPool.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public VideoFrame.TextureBuffer call() throws Exception {
                return TextureBufferPool.this.doTextureCopy(i10, type, i11, i12, matrix, runnable);
            }
        });
    }

    public static VideoFrame.TextureBuffer makeTextureBuffer(EglBase.Context context, int i10, int i11, int i12, int i13, float[] fArr, Handler handler, YuvConverter yuvConverter, Runnable runnable) {
        Matrix convertMatrixToAndroidGraphicsMatrix;
        if (fArr == null) {
            convertMatrixToAndroidGraphicsMatrix = new Matrix();
        } else {
            convertMatrixToAndroidGraphicsMatrix = RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr);
        }
        return new TextureBufferImpl(context == null ? EglBase.getCurrentContext() : context, i12, i13, agoraFrameTypeToTextureBufferType(i10), i11, convertMatrixToAndroidGraphicsMatrix, handler, yuvConverter, runnable, nextSeq.getAndIncrement());
    }
}
