package com.tencent.liteav.extensions.codec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AacMediaCodecWrapper {
    MediaFormat a;
    int b = 0;
    private final String c;
    private final int d;
    private MediaCodec e;
    private final MediaCodec.BufferInfo f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = {1, 2};
    }

    public AacMediaCodecWrapper(int i) {
        String str;
        this.d = i;
        if (i == a.a) {
            str = "HardwareAacEncoder";
        } else {
            str = "HardwareAacDecoder";
        }
        this.c = str;
        this.f = new MediaCodec.BufferInfo();
    }

    private ByteBuffer b() {
        ByteBuffer byteBuffer;
        try {
            int dequeueOutputBuffer = this.e.dequeueOutputBuffer(this.f, TimeUnit.MILLISECONDS.toMicros(5L));
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                Log.i(this.c, "codec output buffers changed.", new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer == -2) {
                this.a = this.e.getOutputFormat();
                Log.i(this.c, "codec output format changed: " + this.a, new Object[0]);
                return null;
            }
            if (dequeueOutputBuffer < 0) {
                Log.e(this.c, "unexpected result from dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)), new Object[0]);
                return null;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                byteBuffer = this.e.getOutputBuffer(dequeueOutputBuffer);
            } else {
                byteBuffer = this.e.getOutputBuffers()[dequeueOutputBuffer];
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.f.size);
            allocateDirect.put(byteBuffer);
            this.e.releaseOutputBuffer(dequeueOutputBuffer, false);
            int i = this.b;
            if (i > 0) {
                this.b = i - 1;
            }
            return allocateDirect;
        } catch (Exception e) {
            Log.e(this.c, "dequeueOutputBuffer failed. ".concat(String.valueOf(e)), new Object[0]);
            return null;
        }
    }

    public final boolean a(MediaFormat mediaFormat) {
        if (this.e == null && mediaFormat != null) {
            try {
                int i = this.d == a.a ? 1 : 0;
                if (i != 0) {
                    this.e = MediaCodec.createEncoderByType("audio/mp4a-latm");
                } else {
                    this.e = MediaCodec.createDecoderByType("audio/mp4a-latm");
                }
                this.e.configure(mediaFormat, (Surface) null, (MediaCrypto) null, i);
                this.e.start();
                return true;
            } catch (IOException e) {
                Log.e(this.c, "create codec failed. ".concat(String.valueOf(e)), new Object[0]);
                a();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0064 -> B:14:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ByteBuffer processFrame(ByteBuffer byteBuffer) {
        ByteBuffer[] inputBuffers;
        MediaCodec mediaCodec = this.e;
        if (mediaCodec != null && byteBuffer != null) {
            int i = 0;
            try {
                inputBuffers = mediaCodec.getInputBuffers();
            } catch (Exception e) {
                Log.e(this.c, "feedData failed. ".concat(String.valueOf(e)), new Object[i]);
            }
            if (inputBuffers != null && inputBuffers.length > 0) {
                int dequeueInputBuffer = this.e.dequeueInputBuffer(TimeUnit.MILLISECONDS.toMicros(5L));
                if (dequeueInputBuffer >= 0) {
                    int remaining = byteBuffer.remaining();
                    inputBuffers[dequeueInputBuffer].put(byteBuffer);
                    this.e.queueInputBuffer(dequeueInputBuffer, 0, remaining, 0L, 0);
                    this.b++;
                }
                if (i < 3) {
                    ByteBuffer b = b();
                    if (b != null) {
                        return b;
                    }
                    i++;
                    if (i < 3) {
                    }
                }
            }
            Log.e(this.c, "get invalid input buffers.", new Object[0]);
            if (i < 3) {
            }
        }
        return null;
    }

    public final void a() {
        MediaCodec mediaCodec = this.e;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.stop();
        } catch (Exception e) {
            Log.e(this.c, "codec stop failed.".concat(String.valueOf(e)), new Object[0]);
        }
        try {
            this.e.release();
        } catch (Exception e2) {
            Log.e(this.c, "codec release failed.".concat(String.valueOf(e2)), new Object[0]);
        }
        this.e = null;
        this.b = 0;
    }
}
