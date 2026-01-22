package io.agora.rtc.video;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class LowLightEnhanceOptions {
    public static final int LOW_LIGHT_ENHANCE_AUTO = 0;
    public static final int LOW_LIGHT_ENHANCE_LEVEL_FAST = 1;
    public static final int LOW_LIGHT_ENHANCE_LEVEL_HIGH_QUALITY = 0;
    public static final int LOW_LIGHT_ENHANCE_MANUAL = 1;
    public int lowlightEnhanceLevel;
    public int lowlightEnhanceMode;

    public LowLightEnhanceOptions() {
        this.lowlightEnhanceMode = 0;
        this.lowlightEnhanceLevel = 0;
    }

    public LowLightEnhanceOptions(int i10, int i11) {
        this.lowlightEnhanceMode = i10;
        this.lowlightEnhanceLevel = i11;
    }
}
