package io.agora.rtc.mediaio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class MediaIO {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum BufferType {
        BYTE_BUFFER(1),
        BYTE_ARRAY(2),
        TEXTURE(3);

        final int value;

        BufferType(int i10) {
            this.value = i10;
        }

        public int intValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum CaptureType {
        UNKNOWN(0),
        CAMERA(1),
        SCREEN(2);

        final int value;

        CaptureType(int i10) {
            this.value = i10;
        }

        public int intValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum ContentHint {
        NONE(0),
        MOTION(1),
        DETAIL(2);

        final int value;

        ContentHint(int i10) {
            this.value = i10;
        }

        public int intValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum PixelFormat {
        I420(1),
        NV21(3),
        RGBA(4),
        TEXTURE_2D(10),
        TEXTURE_OES(11);

        final int value;

        PixelFormat(int i10) {
            this.value = i10;
        }

        public int intValue() {
            return this.value;
        }
    }
}
