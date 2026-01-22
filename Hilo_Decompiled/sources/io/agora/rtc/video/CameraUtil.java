package io.agora.rtc.video;

import android.content.Context;
import android.hardware.Camera;
import android.view.Display;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import io.agora.rtc.internal.Logging;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CameraUtil {
    private static final String TAG = "CAMERA_UTIL";

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getCameraDisplayOrientation(Context context, int i10) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i10, cameraInfo);
        int i11 = 90;
        if (context == null || context.getSystemService("window") == null) {
            return 90;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay == null) {
            Logging.e(TAG, "display is null");
            return 90;
        }
        int rotation = defaultDisplay.getRotation();
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        i11 = SubsamplingScaleImageView.ORIENTATION_270;
                    }
                } else {
                    i11 = 180;
                }
            }
            if (cameraInfo.facing != 1) {
                return (360 - ((cameraInfo.orientation + i11) % 360)) % 360;
            }
            return ((cameraInfo.orientation - i11) + 360) % 360;
        }
        i11 = 0;
        if (cameraInfo.facing != 1) {
        }
    }
}
