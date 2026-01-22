package io.agora.rtc.audio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AudioParams {
    public int channel;
    public int mode;
    public int sampleRate;
    public int samplesPerCall;

    public AudioParams(int i10, int i11, int i12, int i13) {
        this.sampleRate = i10;
        this.channel = i11;
        this.mode = i12;
        this.samplesPerCall = i13;
    }

    public String toString() {
        return "AudioParams{sampleRate=" + this.sampleRate + ", channel=" + this.channel + ", mode=" + this.mode + ", samplesPerCall=" + this.samplesPerCall + '}';
    }
}
