package com.tencent.liteav.audio2;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class LiteavAudioTrack3 {
    private static final int DEFAULT_LATENCY_MS = 160;
    private static final int HARDWARE_LATENCY_MS = 20;
    private static final long LATENCY_THRESHOLD_MS = 1000;
    private static final long NANOS_PER_MS = 1000000;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final String TAG = "LiteavAudioTrack3";
    private AudioTrack mAudioTrack;
    private byte[] mPlayBuffer;
    private int mSampleRate = 0;
    private int mBufferSize = 0;
    private int mSystemOSVersion = 0;
    private int mWriteFrameIndex = 0;
    private int mBytesPerFrame = 0;

    private AudioTrack createStartedAudioTrack(int i, int i2, int i3, int i4) {
        AudioTrack audioTrack;
        try {
            audioTrack = new AudioTrack(i4, i, i2, 2, i3, 1);
        } catch (Throwable unused) {
            audioTrack = null;
        }
        try {
            if (audioTrack.getState() == 1) {
                this.mWriteFrameIndex = 0;
                audioTrack.play();
                Log.i(TAG, "create AudioTrack success. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), streamTypeToString(i4));
                return audioTrack;
            }
            throw new RuntimeException("AudioTrack is not initialized.");
        } catch (Throwable unused2) {
            Log.w(TAG, "create AudioTrack failed. sampleRate: %d, channelConfig: %d, bufferSize: %d, streamType: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), streamTypeToString(i4));
            destroyAudioTrack(audioTrack);
            return null;
        }
    }

    private void destroyAudioTrack(AudioTrack audioTrack) {
        if (audioTrack == null) {
            return;
        }
        try {
            if (audioTrack.getPlayState() == 3) {
                audioTrack.stop();
                audioTrack.flush();
            }
            audioTrack.release();
        } catch (Throwable th) {
            Log.e(TAG, "stop AudioTrack failed.", th);
        }
    }

    private int getLatencyByTimestamp() {
        AudioTimestamp audioTimestamp = new AudioTimestamp();
        if (!this.mAudioTrack.getTimestamp(audioTimestamp)) {
            Log.w(TAG, "fail to get AudioTrack timestamp", new Object[0]);
            return 160;
        }
        int lengthBytesToNano = ((int) (((audioTimestamp.nanoTime + lengthBytesToNano(this.mWriteFrameIndex - audioTimestamp.framePosition)) - System.nanoTime()) / 1000000)) + 20;
        if (lengthBytesToNano <= 0 || lengthBytesToNano >= LATENCY_THRESHOLD_MS) {
            return 160;
        }
        return lengthBytesToNano;
    }

    private long lengthBytesToNano(long j) {
        return (j * 1000000000) / this.mSampleRate;
    }

    private static String streamTypeToString(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return "STREAM_INVALID";
                            }
                            return "STREAM_NOTIFICATION";
                        }
                        return "STREAM_ALARM";
                    }
                    return "STREAM_MUSIC";
                }
                return "STREAM_RING";
            }
            return "STREAM_SYSTEM";
        }
        return "STREAM_VOICE_CALL";
    }

    public int getBufferSize() {
        return this.mBufferSize;
    }

    public int getPlayoutLatencyMs() {
        if (this.mAudioTrack == null || this.mSystemOSVersion < 23) {
            return 160;
        }
        try {
            return getLatencyByTimestamp();
        } catch (Throwable th) {
            Log.w(TAG, "get latency exception " + th.getMessage(), new Object[0]);
            return 160;
        }
    }

    public int getUnderrunCount() {
        int underrunCount;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null) {
            return 0;
        }
        try {
            if (this.mSystemOSVersion >= 24) {
                underrunCount = audioTrack.getUnderrunCount();
                return underrunCount;
            }
            return 0;
        } catch (Throwable th) {
            Log.w(TAG, "get under run count exception " + th.getMessage(), new Object[0]);
            return 0;
        }
    }

    public int startPlayout(int i, int i2, int i3, int i4) {
        int i5;
        this.mBytesPerFrame = i3 * 2;
        this.mSampleRate = i2;
        if (i3 == 1) {
            i5 = 4;
        } else {
            i5 = 12;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i5, 2);
        if (minBufferSize <= 0) {
            Log.e(TAG, "AudioTrack.getMinBufferSize return error: ".concat(String.valueOf(minBufferSize)), new Object[0]);
            return -2;
        }
        int[] iArr = {i, 0, 3, 1};
        for (int i6 = 0; i6 < 4 && this.mAudioTrack == null; i6++) {
            int i7 = iArr[i6];
            for (int i8 = 1; i8 <= 2 && this.mAudioTrack == null; i8++) {
                int i9 = minBufferSize * i8;
                this.mBufferSize = i9;
                if (i9 >= i4 * 4 || i8 >= 2) {
                    this.mAudioTrack = createStartedAudioTrack(i2, i5, i9, i7);
                }
            }
        }
        if (this.mAudioTrack == null) {
            return -1;
        }
        this.mSystemOSVersion = LiteavSystemInfo.getSystemOSVersionInt();
        Process.setThreadPriority(-19);
        return 0;
    }

    public void stopPlayout() {
        destroyAudioTrack(this.mAudioTrack);
        this.mAudioTrack = null;
    }

    public int write(ByteBuffer byteBuffer, int i, int i2, boolean z) {
        int write;
        if (this.mAudioTrack == null) {
            return -1;
        }
        byteBuffer.position(i);
        if (this.mSystemOSVersion >= 21) {
            write = this.mAudioTrack.write(byteBuffer, i2, z ? 1 : 0);
        } else {
            byte[] bArr = this.mPlayBuffer;
            if (bArr == null || bArr.length < i2) {
                this.mPlayBuffer = new byte[i2];
            }
            byteBuffer.get(this.mPlayBuffer, 0, i2);
            write = this.mAudioTrack.write(this.mPlayBuffer, 0, i2);
        }
        if (write < 0) {
            Log.e(TAG, "write audio data to AudioTrack failed. ".concat(String.valueOf(write)), new Object[0]);
            return -1;
        }
        this.mWriteFrameIndex += write / this.mBytesPerFrame;
        return write;
    }
}
