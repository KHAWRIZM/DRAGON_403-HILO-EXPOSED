package io.agora.rtc.video;

import android.hardware.Camera;
import io.agora.rtc.internal.Logging;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CameraHelper {
    private static final String TAG = "CameraHelper";

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class Capability {
        public static final int CAMERA_FACING_BACK = 0;
        public static final int CAMERA_FACING_FRONT = 1;
        public int facing;
        public int height;
        public int id;
        public int maxFps;
        public int width;

        public Capability(int i10, int i11, int i12, int i13, int i14) {
            this.id = i10;
            this.facing = i11;
            this.width = i12;
            this.height = i13;
            this.maxFps = i14;
        }
    }

    public static boolean checkPermission() {
        return true;
    }

    public static Capability createCapability(int i10, int i11, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (!supportedPreviewSizes.isEmpty() && !supportedPreviewFpsRange.isEmpty()) {
            Camera.Size size = supportedPreviewSizes.get(0);
            for (Camera.Size size2 : supportedPreviewSizes) {
                if (size2.width * size2.height > size.width * size.height) {
                    size = size2;
                }
            }
            int i12 = supportedPreviewFpsRange.get(0)[1] / 1000;
            Logging.d(TAG, "creaet capability for camera " + i10 + " : width: " + size.width + " , height: " + size.height + " max fps: " + i12);
            return new Capability(i10, i11, size.width, size.height, i12);
        }
        Logging.e(TAG, "failed get preview size/fps, parameters = " + parameters.flatten());
        throw new IllegalArgumentException(parameters.flatten());
    }

    public static synchronized List<Capability> getCameraCapability() {
        ArrayList arrayList;
        synchronized (CameraHelper.class) {
            try {
                arrayList = new ArrayList();
                int numberOfCameras = Camera.getNumberOfCameras();
                if (numberOfCameras >= 1) {
                    for (int i10 = 0; i10 < numberOfCameras; i10++) {
                        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                        Camera.getCameraInfo(i10, cameraInfo);
                        try {
                            Camera open = Camera.open(i10);
                            arrayList.add(createCapability(i10, cameraInfo.facing, open.getParameters()));
                            open.release();
                        } catch (RuntimeException e10) {
                            throw e10;
                        }
                    }
                } else {
                    throw new RuntimeException("no camera device");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }
}
