package com.tencent.qgame.animplayer;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qgame.animplayer.file.IFileContainer;
import com.tencent.qgame.animplayer.util.ALog;
import com.tencent.qgame.animplayer.util.MediaUtil;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020.H\u0002J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020.H\u0002J\u000e\u00104\u001a\u00020.2\u0006\u00105\u001a\u000206J\u0010\u00107\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0002J\u0006\u00108\u001a\u00020.R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006:"}, d2 = {"Lcom/tencent/qgame/animplayer/AudioPlayer;", "", "player", "Lcom/tencent/qgame/animplayer/AnimPlayer;", "(Lcom/tencent/qgame/animplayer/AnimPlayer;)V", "audioTrack", "Landroid/media/AudioTrack;", "getAudioTrack", "()Landroid/media/AudioTrack;", "setAudioTrack", "(Landroid/media/AudioTrack;)V", "decodeThread", "Lcom/tencent/qgame/animplayer/HandlerHolder;", "getDecodeThread", "()Lcom/tencent/qgame/animplayer/HandlerHolder;", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "extractor", "Landroid/media/MediaExtractor;", "getExtractor", "()Landroid/media/MediaExtractor;", "setExtractor", "(Landroid/media/MediaExtractor;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "isStopReq", "setStopReq", "needDestroy", "getNeedDestroy", "setNeedDestroy", "playLoop", "", "getPlayLoop", "()I", "setPlayLoop", "(I)V", "getPlayer", "()Lcom/tencent/qgame/animplayer/AnimPlayer;", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "", "destroyInner", "getChannelConfig", "channelCount", "prepareThread", "release", "start", "fileContainer", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "startPlay", "stop", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AudioPlayer {
    private static final String TAG = "AnimPlayer.AudioPlayer";

    @Nullable
    private AudioTrack audioTrack;

    @NotNull
    private final HandlerHolder decodeThread = new HandlerHolder(null, null);

    @Nullable
    private MediaCodec decoder;

    @Nullable
    private MediaExtractor extractor;
    private boolean isRunning;
    private boolean isStopReq;
    private boolean needDestroy;
    private int playLoop;

    @NotNull
    private final AnimPlayer player;

    public AudioPlayer(@NotNull AnimPlayer animPlayer) {
        this.player = animPlayer;
    }

    private final void destroyInner() {
        if (this.player.getIsDetachedFromWindow()) {
            ALog.INSTANCE.i(TAG, "destroyThread");
            Handler handler = this.decodeThread.getHandler();
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            HandlerHolder handlerHolder = this.decodeThread;
            handlerHolder.setThread(Decoder.INSTANCE.quitSafely(handlerHolder.getThread()));
        }
    }

    private final int getChannelConfig(int channelCount) {
        switch (channelCount) {
            case 1:
                return 2;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            default:
                throw new RuntimeException("Unsupported channel count: " + channelCount);
        }
    }

    private final boolean prepareThread() {
        return Decoder.INSTANCE.createThread(this.decodeThread, "anim_audio_thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void release() {
        try {
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            this.decoder = null;
            MediaExtractor mediaExtractor = this.extractor;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            this.extractor = null;
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack != null) {
                audioTrack.pause();
                audioTrack.flush();
                audioTrack.stop();
                audioTrack.release();
            }
            this.audioTrack = null;
        } catch (Throwable th) {
            ALog.INSTANCE.e(TAG, "release exception=" + th, th);
        }
        this.isRunning = false;
        if (this.needDestroy) {
            destroyInner();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void startPlay(IFileContainer fileContainer) {
        AudioTrack audioTrack;
        boolean z;
        int dequeueOutputBuffer;
        int dequeueInputBuffer;
        MediaUtil mediaUtil = MediaUtil.INSTANCE;
        MediaExtractor extractor = mediaUtil.getExtractor(fileContainer);
        this.extractor = extractor;
        int selectAudioTrack = mediaUtil.selectAudioTrack(extractor);
        if (selectAudioTrack < 0) {
            ALog.INSTANCE.e(TAG, "cannot find audio track");
            release();
            return;
        }
        extractor.selectTrack(selectAudioTrack);
        MediaFormat trackFormat = extractor.getTrackFormat(selectAudioTrack);
        String string = trackFormat.getString("mime");
        if (string == null) {
            string = "";
        }
        ALog aLog = ALog.INSTANCE;
        aLog.i(TAG, "audio mime=" + string);
        if (!mediaUtil.checkSupportCodec(string)) {
            aLog.e(TAG, "mime=" + string + " not support");
            release();
            return;
        }
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
        createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
        createDecoderByType.start();
        this.decoder = createDecoderByType;
        Intrinsics.checkExpressionValueIsNotNull(createDecoderByType, "decoder");
        ByteBuffer[] inputBuffers = createDecoderByType.getInputBuffers();
        ByteBuffer[] outputBuffers = createDecoderByType.getOutputBuffers();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int integer = trackFormat.getInteger("sample-rate");
        int channelConfig = getChannelConfig(trackFormat.getInteger("channel-count"));
        AudioTrack audioTrack2 = new AudioTrack(3, integer, channelConfig, 2, AudioTrack.getMinBufferSize(integer, channelConfig, 2), 1);
        this.audioTrack = audioTrack2;
        if (audioTrack2.getState() != 1) {
            release();
            aLog.e(TAG, "init audio track failure");
            return;
        }
        audioTrack2.play();
        ByteBuffer[] byteBufferArr = outputBuffers;
        boolean z2 = false;
        while (true) {
            if (this.isStopReq) {
                break;
            }
            if (!z2 && (dequeueInputBuffer = createDecoderByType.dequeueInputBuffer(1000L)) >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                int readSampleData = extractor.readSampleData(byteBuffer, 0);
                if (readSampleData < 0) {
                    audioTrack = audioTrack2;
                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    z = true;
                    dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 0L);
                    if (dequeueOutputBuffer == -2) {
                        byteBufferArr = createDecoderByType.getOutputBuffers();
                    }
                    if (dequeueOutputBuffer < 0) {
                        ByteBuffer byteBuffer2 = byteBufferArr[dequeueOutputBuffer];
                        byte[] bArr = new byte[bufferInfo.size];
                        byteBuffer2.get(bArr);
                        byteBuffer2.clear();
                        audioTrack2 = audioTrack;
                        audioTrack2.write(bArr, 0, bufferInfo.size);
                        createDecoderByType.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        audioTrack2 = audioTrack;
                    }
                    if (!z && (bufferInfo.flags & 4) != 0) {
                        int i = this.playLoop - 1;
                        this.playLoop = i;
                        if (i > 0) {
                            ALog.INSTANCE.d(TAG, "Reached EOS, looping -> playLoop");
                            extractor.seekTo(0L, 2);
                            createDecoderByType.flush();
                            z2 = false;
                        } else {
                            ALog.INSTANCE.i(TAG, "decode finish");
                            release();
                            break;
                        }
                    } else {
                        z2 = z;
                    }
                } else {
                    audioTrack = audioTrack2;
                    createDecoderByType.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, 0L, 0);
                    extractor.advance();
                }
            } else {
                audioTrack = audioTrack2;
            }
            z = z2;
            dequeueOutputBuffer = createDecoderByType.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -2) {
            }
            if (dequeueOutputBuffer < 0) {
            }
            if (!z) {
            }
            z2 = z;
        }
        release();
    }

    public final void destroy() {
        if (this.isRunning) {
            this.needDestroy = true;
            stop();
        } else {
            destroyInner();
        }
    }

    @Nullable
    public final AudioTrack getAudioTrack() {
        return this.audioTrack;
    }

    @NotNull
    public final HandlerHolder getDecodeThread() {
        return this.decodeThread;
    }

    @Nullable
    public final MediaCodec getDecoder() {
        return this.decoder;
    }

    @Nullable
    public final MediaExtractor getExtractor() {
        return this.extractor;
    }

    public final boolean getNeedDestroy() {
        return this.needDestroy;
    }

    public final int getPlayLoop() {
        return this.playLoop;
    }

    @NotNull
    public final AnimPlayer getPlayer() {
        return this.player;
    }

    /* renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    /* renamed from: isStopReq, reason: from getter */
    public final boolean getIsStopReq() {
        return this.isStopReq;
    }

    public final void setAudioTrack(@Nullable AudioTrack audioTrack) {
        this.audioTrack = audioTrack;
    }

    public final void setDecoder(@Nullable MediaCodec mediaCodec) {
        this.decoder = mediaCodec;
    }

    public final void setExtractor(@Nullable MediaExtractor mediaExtractor) {
        this.extractor = mediaExtractor;
    }

    public final void setNeedDestroy(boolean z) {
        this.needDestroy = z;
    }

    public final void setPlayLoop(int i) {
        this.playLoop = i;
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
    }

    public final void setStopReq(boolean z) {
        this.isStopReq = z;
    }

    public final void start(@NotNull final IFileContainer fileContainer) {
        this.isStopReq = false;
        this.needDestroy = false;
        if (!prepareThread()) {
            return;
        }
        if (this.isRunning) {
            stop();
        }
        this.isRunning = true;
        Handler handler = this.decodeThread.getHandler();
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qgame.animplayer.AudioPlayer$start$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AudioPlayer.this.startPlay(fileContainer);
                    } catch (Throwable th) {
                        ALog.INSTANCE.e("AnimPlayer.AudioPlayer", "Audio exception=" + th, th);
                        AudioPlayer.this.release();
                    }
                }
            });
        }
    }

    public final void stop() {
        this.isStopReq = true;
    }
}
