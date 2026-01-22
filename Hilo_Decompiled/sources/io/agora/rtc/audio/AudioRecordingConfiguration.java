package io.agora.rtc.audio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AudioRecordingConfiguration {
    public String filePath;
    public int recordingChannel;
    public int recordingPosition;
    public int recordingQuality;
    public int recordingSampleRate;

    public AudioRecordingConfiguration() {
        this.recordingQuality = 1;
        this.recordingPosition = 0;
        this.recordingSampleRate = 32000;
        this.recordingChannel = 1;
    }

    public AudioRecordingConfiguration(String str, int i10, int i11, int i12, int i13) {
        this.filePath = str;
        this.recordingQuality = i10;
        this.recordingPosition = i11;
        this.recordingSampleRate = i12;
        this.recordingChannel = i13;
    }
}
