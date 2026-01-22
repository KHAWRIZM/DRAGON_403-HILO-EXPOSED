package io.agora.rtc;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ScreenCaptureParameters implements Serializable {
    public boolean captureAudio = false;
    public VideoCaptureParameters videoCaptureParameters = new VideoCaptureParameters();
    public boolean captureVideo = true;
    public AudioCaptureParameters audioCaptureParameters = new AudioCaptureParameters();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class AudioCaptureParameters implements Serializable {
        public int sampleRate = 16000;
        public int channels = 2;
        public int captureSignalVolume = 100;
        public boolean allowCaptureCurrentApp = false;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AudioCaptureParameters audioCaptureParameters = (AudioCaptureParameters) obj;
            if (this.sampleRate == audioCaptureParameters.sampleRate && this.channels == audioCaptureParameters.channels && this.captureSignalVolume == audioCaptureParameters.captureSignalVolume && this.allowCaptureCurrentApp == audioCaptureParameters.allowCaptureCurrentApp) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.sampleRate), Integer.valueOf(this.channels), Integer.valueOf(this.captureSignalVolume), Boolean.valueOf(this.allowCaptureCurrentApp));
        }

        public String toString() {
            return "AudioCaptureParameters{sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", captureSignalVolume=" + this.captureSignalVolume + ", allowCaptureCurrentApp=" + this.allowCaptureCurrentApp + '}';
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class VideoCaptureParameters implements Serializable {
        public int bitrate;
        public int framerate = 15;
        public int width = 1280;
        public int height = 720;
        public int contentHint = 1;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            VideoCaptureParameters videoCaptureParameters = (VideoCaptureParameters) obj;
            if (this.bitrate == videoCaptureParameters.bitrate && this.framerate == videoCaptureParameters.framerate && this.width == videoCaptureParameters.width && this.height == videoCaptureParameters.height && this.contentHint == videoCaptureParameters.contentHint) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.bitrate), Integer.valueOf(this.framerate), Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.contentHint));
        }

        public String toString() {
            return "VideoCaptureParameters{bitrate=" + this.bitrate + ", framerate=" + this.framerate + ", width=" + this.width + ", height=" + this.height + ", contentHint=" + this.contentHint + '}';
        }
    }

    public String toString() {
        return "ScreenCaptureParameters{captureAudio=" + this.captureAudio + ", videoCaptureParameters=" + this.videoCaptureParameters + ", captureVideo=" + this.captureVideo + ", audioCaptureParameters=" + this.audioCaptureParameters + '}';
    }
}
