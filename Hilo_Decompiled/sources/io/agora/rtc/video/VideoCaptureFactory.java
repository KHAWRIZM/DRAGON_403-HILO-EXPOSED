package io.agora.rtc.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.facebook.internal.security.CertificateUtil;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.internal.Logging;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoCaptureFactory {
    private static final int ANDROID_CAMERA1 = 0;
    private static final int ANDROID_CAMERA2 = 1;
    private static final int ANDROID_CAMERA_NOT_DEFINE = -1;
    private static final String TAG = "CAM-FACTORY";

    public static void cacheLowPowerFlag(Context context, int i10) {
        SharedPreferences.Editor edit = context.getSharedPreferences("CamCapsLowPower", 0).edit();
        edit.putInt("Cam_LowPower", i10);
        edit.commit();
    }

    public static VideoCapture createVideoCapture(Context context, int i10, int i11, boolean z10, int i12, int i13, EglBase.Context context2, long j10) {
        Logging.i(TAG, "createVideoCapture id: " + i10 + " select: " + i11 + " fallback: " + z10 + " pqFirst: " + i12 + " lowPowerFlag: " + i13);
        if (i13 != fetchLowPowerFlag(context)) {
            cacheLowPowerFlag(context, i13);
            VideoCapture.clearCapabilityCache(context);
        }
        if (useCamera2(i10, context, i11, z10)) {
            Logging.d(TAG, "create CAMERA2, id:" + i10);
            return new VideoCaptureCamera2(context, i10, i12, context2, j10);
        }
        Logging.d(TAG, "create CAMERA1, id:" + i10);
        return new VideoCaptureCamera(context, i10, i12, context2, j10);
    }

    public static int fetchLowPowerFlag(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("CamCapsLowPower", 0);
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("Cam_LowPower", -1);
    }

    public static String getCapabilities(int i10, Context context, int i11, boolean z10) {
        String fetchCapability;
        if (useCamera2(i10, context, i11, z10)) {
            fetchCapability = VideoCapture.fetchCapability(i10, context, VideoCaptureCamera2.getCaptureName());
        } else {
            fetchCapability = VideoCapture.fetchCapability(i10, context, VideoCaptureCamera.getCaptureName());
        }
        if (fetchCapability == null) {
            Logging.e(TAG, "Capability hasn't been created");
        } else {
            printCameraInfo(fetchCapability);
        }
        return fetchCapability;
    }

    public static String getDeviceName(int i10, Context context, int i11, boolean z10) {
        if (useCamera2(i10, context, i11, z10)) {
            return VideoCaptureCamera2.getName(i10, context);
        }
        return VideoCaptureCamera.getName(i10);
    }

    public static int getDeviceOrientation(int i10, Context context, int i11, boolean z10) {
        if (useCamera2(i10, context, i11, z10)) {
            return VideoCaptureCamera2.getSensorOrientation(i10, context);
        }
        return VideoCaptureCamera.getSensorOrientation(i10);
    }

    public static int getFrontCameraIndex(Context context) {
        int frontCameraIndex;
        if (isCamera2Available()) {
            frontCameraIndex = VideoCaptureCamera2.getFrontCameraIndex(context);
        } else {
            frontCameraIndex = VideoCaptureCamera.getFrontCameraIndex();
        }
        Logging.i(TAG, "getFrontCameraIndex  = " + frontCameraIndex);
        return frontCameraIndex;
    }

    public static int getNumberOfCameras(Context context) {
        if (Build.VERSION.SDK_INT < 23 && context.getPackageManager().checkPermission("android.permission.CAMERA", context.getPackageName()) != 0) {
            Logging.e(TAG, "Missing android.permission.CAMERA permission, no system camera available");
            return 0;
        }
        if (isCamera2Available()) {
            return VideoCaptureCamera2.getNumberOfCameras(context);
        }
        return VideoCaptureCamera.getNumberOfCameras();
    }

    public static boolean isCamera2Available() {
        String str = Build.DEVICE;
        if ("ocean".equalsIgnoreCase(str) && "oe106".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        if ("trident".equalsIgnoreCase(str) && "de106".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        if (("shark".equalsIgnoreCase(str) && "skr-a0".equalsIgnoreCase(Build.MODEL)) || "hnnem-h".equalsIgnoreCase(str)) {
            return false;
        }
        if ((!"on7xelte".equals(str) || !"SM-G610F".equals(Build.MODEL)) && !"m2c".equals(str)) {
            String str2 = Build.MODEL;
            if (!"M578CA".equals(str2)) {
                String str3 = Build.MANUFACTURER;
                if ("samsung".equalsIgnoreCase(str3) && str2 != null && (str2.contains("SM-G930") || str2.contains("SM-G935") || str2.contains("SM-G950") || str2.contains("SM-G955") || "SC-02H".equals(str2) || "SCV33".equals(str2) || "SC-02J".equals(str2) || "SCV36".equals(str2) || "SM-G892A".equals(str2) || "SM-G892U".equals(str2) || "SC-03J".equals(str2) || "SCV35".equals(str2))) {
                    return false;
                }
                if ("oneplus".equalsIgnoreCase(str3) && !str2.contains("ONEPLUS A6")) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static int printCameraInfo(String str) {
        String str2;
        int length = str.length() / 150;
        int i10 = length + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            try {
                String str3 = "lines = " + i10 + CertificateUtil.DELIMITER;
                if (i11 == length) {
                    str2 = str3 + str.substring(i11 * 150, str.length());
                } else {
                    str2 = str3 + str.substring(i11 * 150, (i11 + 1) * 150);
                }
                Logging.d("CameraInfo", str2);
            } catch (IndexOutOfBoundsException e10) {
                e10.printStackTrace();
            }
        }
        return 0;
    }

    private static boolean useCamera2(int i10, Context context, int i11, boolean z10) {
        if (!isCamera2Available()) {
            return false;
        }
        if (i11 != 1 && i11 != 0) {
            if (VideoCaptureCamera2.isLegacyDevice(context, i10) || z10) {
                return false;
            }
            return true;
        }
        if (i11 != 1) {
            return false;
        }
        return true;
    }
}
