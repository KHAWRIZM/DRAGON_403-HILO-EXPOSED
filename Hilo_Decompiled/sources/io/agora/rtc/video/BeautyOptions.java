package io.agora.rtc.video;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BeautyOptions {
    public static final int LIGHTENING_CONTRAST_HIGH = 2;
    public static final int LIGHTENING_CONTRAST_LOW = 0;
    public static final int LIGHTENING_CONTRAST_NORMAL = 1;
    public int lighteningContrastLevel;
    public float lighteningLevel;
    public float rednessLevel;
    public float sharpnessLevel;
    public float smoothnessLevel;

    public BeautyOptions(int i10, float f10, float f11, float f12, float f13) {
        this.lighteningContrastLevel = i10;
        this.lighteningLevel = f10;
        this.smoothnessLevel = f11;
        this.rednessLevel = f12;
        this.sharpnessLevel = f13;
    }

    public BeautyOptions() {
        this.lighteningContrastLevel = 1;
        this.lighteningLevel = 0.6f;
        this.smoothnessLevel = 0.5f;
        this.rednessLevel = 0.1f;
        this.sharpnessLevel = 0.3f;
    }
}
