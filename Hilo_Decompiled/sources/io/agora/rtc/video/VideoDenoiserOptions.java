package io.agora.rtc.video;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoDenoiserOptions {
    public static final int VIDEO_DENOISER_AUTO = 0;
    public static final int VIDEO_DENOISER_LEVEL_FAST = 1;
    public static final int VIDEO_DENOISER_LEVEL_HIGH_QUALITY = 0;
    public static final int VIDEO_DENOISER_LEVEL_STRENGTH = 2;
    public static final int VIDEO_DENOISER_MANUAL = 1;
    public int denoiserLevel;
    public int denoiserMode;

    public VideoDenoiserOptions() {
        this.denoiserMode = 0;
        this.denoiserLevel = 0;
    }

    public VideoDenoiserOptions(int i10, int i11) {
        this.denoiserMode = i10;
        this.denoiserLevel = i11;
    }
}
