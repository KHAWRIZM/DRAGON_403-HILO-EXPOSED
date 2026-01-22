package io.agora.rtc.utils;

import android.content.Context;
import android.os.Process;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.video.VideoCaptureFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CameraUtils {
    private static final String TAG = "CameraUtils";

    public static void checkCameraPermission(Context context) {
        if (context != null && context.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
        } else {
            throw new SecurityException("android.permission.CAMERA is not granted");
        }
    }

    public static int getNumberOfCameras(Context context) {
        try {
            return VideoCaptureFactory.getNumberOfCameras(context);
        } catch (Exception e10) {
            Logging.e(TAG, e10.toString());
            return 0;
        }
    }

    public static int selectFrontCamera(Context context) {
        return VideoCaptureFactory.getFrontCameraIndex(context);
    }
}
