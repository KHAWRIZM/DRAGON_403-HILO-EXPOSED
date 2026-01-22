package io.agora.rtc.video;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CameraCapturerConfiguration {
    public CAMERA_DIRECTION cameraDirection;
    public CaptureDimensions dimensions;
    public CAPTURER_OUTPUT_PREFERENCE preference;
    public static final CaptureDimensions CD_640x480 = new CaptureDimensions(640, 480);
    public static final CaptureDimensions CD_1280x720 = new CaptureDimensions(1280, 720);
    public static final CaptureDimensions CD_1920x1080 = new CaptureDimensions(1920, 1080);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum CAMERA_DIRECTION {
        CAMERA_REAR(0),
        CAMERA_FRONT(1);

        private int value;

        CAMERA_DIRECTION(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum CAPTURER_OUTPUT_PREFERENCE {
        CAPTURER_OUTPUT_PREFERENCE_AUTO(0),
        CAPTURER_OUTPUT_PREFERENCE_PERFORMANCE(1),
        CAPTURER_OUTPUT_PREFERENCE_PREVIEW(2),
        CAPTURER_OUTPUT_PREFERENCE_MANUAL(3);

        private int value;

        CAPTURER_OUTPUT_PREFERENCE(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    public CameraCapturerConfiguration(CAPTURER_OUTPUT_PREFERENCE capturer_output_preference, CAMERA_DIRECTION camera_direction) {
        this.preference = capturer_output_preference;
        this.cameraDirection = camera_direction;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class CaptureDimensions {
        public int height;
        public int width;

        public CaptureDimensions(int i10, int i11) {
            this.width = i10;
            this.height = i11;
        }

        public CaptureDimensions() {
            this.width = 640;
            this.height = 480;
        }
    }

    public CameraCapturerConfiguration(int i10, int i11, CAMERA_DIRECTION camera_direction) {
        this.preference = CAPTURER_OUTPUT_PREFERENCE.CAPTURER_OUTPUT_PREFERENCE_MANUAL;
        this.cameraDirection = camera_direction;
        this.dimensions = new CaptureDimensions(i10, i11);
    }

    public CameraCapturerConfiguration(CaptureDimensions captureDimensions, CAMERA_DIRECTION camera_direction) {
        this.preference = CAPTURER_OUTPUT_PREFERENCE.CAPTURER_OUTPUT_PREFERENCE_MANUAL;
        this.cameraDirection = camera_direction;
        this.dimensions = captureDimensions;
    }
}
