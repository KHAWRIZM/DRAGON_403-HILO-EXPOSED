package com.tencent.liteav.extensions.codec;

import android.media.MediaFormat;
import com.tencent.liteav.extensions.codec.AacMediaCodecWrapper;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HardwareAacEncoder {
    private final AacMediaCodecWrapper a = new AacMediaCodecWrapper(AacMediaCodecWrapper.a.a);

    public ByteBuffer encode(ByteBuffer byteBuffer) {
        return this.a.processFrame(byteBuffer);
    }

    public boolean init(int i, int i2, int i3) {
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i, i2);
        createAudioFormat.setInteger("bitrate", i3);
        createAudioFormat.setInteger("aac-profile", 2);
        return this.a.a(createAudioFormat);
    }

    public void unInit() {
        this.a.a();
    }
}
