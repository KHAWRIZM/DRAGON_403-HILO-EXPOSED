package com.tencent.liteav.videobase.base;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface GLConstants {
    public static final float[] a = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] b = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] c = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] d = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] e = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] f = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] g = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public static final float[] h = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum ColorRange {
        UNKNOWN(0),
        VIDEO_RANGE(1),
        FULL_RANGE(2);

        private final int mJniValue;

        ColorRange(int i) {
            this.mJniValue = i;
        }

        public static ColorRange a(int i) {
            for (ColorRange colorRange : values()) {
                if (colorRange.mJniValue == i) {
                    return colorRange;
                }
            }
            return UNKNOWN;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum ColorSpace {
        UNKNOWN(0),
        BT601(1),
        BT709(2);

        private final int mJniValue;

        ColorSpace(int i) {
            this.mJniValue = i;
        }

        public static ColorSpace a(int i) {
            for (ColorSpace colorSpace : values()) {
                if (colorSpace.mJniValue == i) {
                    return colorSpace;
                }
            }
            return UNKNOWN;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum GLScaleType {
        CENTER_CROP(0),
        FIT_CENTER(1),
        FILL(2);

        private static final GLScaleType[] d = values();
        public int mValue;

        GLScaleType(int i) {
            this.mValue = i;
        }

        public static GLScaleType a(int i) {
            for (GLScaleType gLScaleType : d) {
                if (gLScaleType.mValue == i) {
                    return gLScaleType;
                }
            }
            return FIT_CENTER;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum PixelFormatType {
        I420(0),
        NV12(1),
        NV21(2),
        RGB(3),
        YUY2(4),
        RGBA(5),
        BGR(6),
        YV12(7),
        BGRA(8),
        ARGB(9),
        YUV422P(10),
        UYVY(11),
        YUYV(12),
        JPG(13),
        H264(14),
        MAX(100);

        private static final PixelFormatType[] q = values();
        private final int mJniValue;

        PixelFormatType(int i) {
            this.mJniValue = i;
        }

        public static PixelFormatType a(int i) {
            for (PixelFormatType pixelFormatType : q) {
                if (pixelFormatType.mJniValue == i) {
                    return pixelFormatType;
                }
            }
            return null;
        }

        public final int getValue() {
            return this.mJniValue;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum a {
        BYTE_BUFFER(0),
        TEXTURE_2D(1),
        TEXTURE_OES(2),
        BYTE_ARRAY(3);

        private static final a[] e = values();
        public int mValue;

        a(int i) {
            this.mValue = i;
        }

        public static a a(int i) {
            for (a aVar : e) {
                if (aVar.mValue == i) {
                    return aVar;
                }
            }
            return TEXTURE_2D;
        }
    }
}
