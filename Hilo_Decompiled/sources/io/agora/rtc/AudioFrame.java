package io.agora.rtc;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AudioFrame {
    public int bytesPerSample;
    public int channels;
    public int numOfSamples;
    public ByteBuffer samples;
    public int samplesPerSec;

    public AudioFrame(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13) {
        this.samples = byteBuffer;
        this.numOfSamples = i10;
        this.bytesPerSample = i11;
        this.channels = i12;
        this.samplesPerSec = i13;
    }

    public String toString() {
        return "AgoraAudioFrame{samples=" + this.samples + ", numOfSamples=" + this.numOfSamples + ", bytesPerSample=" + this.bytesPerSample + ", channels=" + this.channels + ", samplesPerSec=" + this.samplesPerSec + '}';
    }
}
