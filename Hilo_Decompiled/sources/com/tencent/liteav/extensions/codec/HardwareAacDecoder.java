package com.tencent.liteav.extensions.codec;

import android.media.MediaFormat;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.extensions.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HardwareAacDecoder {
    private final AacMediaCodecWrapper a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.b);

    public ByteBuffer decode(ByteBuffer byteBuffer) {
        return this.a.processFrame(byteBuffer);
    }

    public int getCacheSize() {
        return this.a.b;
    }

    public int getOutputChannelCount() {
        MediaFormat mediaFormat = this.a.a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("channel-count");
        } catch (Exception e) {
            Log.e("HardwareAacDecoder", "getOutputChannelCount failed. ".concat(String.valueOf(e)), new Object[0]);
            return -1;
        }
    }

    public int getOutputSampleRate() {
        MediaFormat mediaFormat = this.a.a;
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getInteger("sample-rate");
        } catch (Exception e) {
            Log.e("HardwareAacDecoder", "getOutputSampleRate failed. ".concat(String.valueOf(e)), new Object[0]);
            return -1;
        }
    }

    public boolean init(int i, int i2, ByteBuffer byteBuffer) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
        createAudioFormat.setString("mime", "audio/mp4a-latm");
        createAudioFormat.setByteBuffer("csd-0", byteBuffer);
        return this.a.a(createAudioFormat);
    }

    public void unInit() {
        this.a.a();
    }
}
