package io.agora.rtc.video;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VirtualBackgroundSource {
    public static final int BACKGROUND_BLUR = 3;
    public static final int BACKGROUND_COLOR = 1;
    public static final int BACKGROUND_IMG = 2;
    public static final int BLUR_DEGREE_HIGH = 3;
    public static final int BLUR_DEGREE_LOW = 1;
    public static final int BLUR_DEGREE_MEDIUM = 2;
    public int backgroundSourceType;
    public int blur_degree;
    public int color;
    public String source;

    public VirtualBackgroundSource(int i10, int i11, String str, int i12) {
        this.backgroundSourceType = i10;
        this.color = i11;
        this.source = str;
        this.blur_degree = i12;
    }

    public VirtualBackgroundSource() {
        this.backgroundSourceType = 1;
        this.color = 16777215;
        this.source = "";
        this.blur_degree = 3;
    }
}
