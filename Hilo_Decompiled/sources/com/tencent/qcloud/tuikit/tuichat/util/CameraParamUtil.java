package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.Context;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CameraParamUtil {
    private static final String TAG = "CameraParamUtil";
    private static CameraParamUtil cameraParamUtil;
    private CameraSizeComparator sizeComparator = new CameraSizeComparator();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private class CameraSizeComparator implements Comparator<Camera.Size> {
        private CameraSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            int i = size.width;
            int i2 = size2.width;
            if (i == i2) {
                return 0;
            }
            return i > i2 ? 1 : -1;
        }
    }

    private CameraParamUtil() {
    }

    private boolean equalRate(Camera.Size size, float f) {
        if (Math.abs((size.width / size.height) - f) <= 0.2d) {
            return true;
        }
        return false;
    }

    private Camera.Size getBestSize(List<Camera.Size> list, float f) {
        float f2 = 100.0f;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Camera.Size size = list.get(i2);
            float f3 = f - (size.width / size.height);
            if (Math.abs(f3) < f2) {
                f2 = Math.abs(f3);
                i = i2;
            }
        }
        return list.get(i);
    }

    public static CameraParamUtil getInstance() {
        CameraParamUtil cameraParamUtil2 = cameraParamUtil;
        if (cameraParamUtil2 == null) {
            CameraParamUtil cameraParamUtil3 = new CameraParamUtil();
            cameraParamUtil = cameraParamUtil3;
            return cameraParamUtil3;
        }
        return cameraParamUtil2;
    }

    public int getCameraDisplayOrientation(Context context, int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation == 3) {
                        i2 = 270;
                    }
                } else {
                    i2 = 180;
                }
            } else {
                i2 = 90;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }

    public Camera.Size getPictureSize(List<Camera.Size> list, int i, float f) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i && equalRate(next, f)) {
                TUIChatLog.i(TAG, "MakeSure Picture :w = " + next.width + " h = " + next.height);
                break;
            }
            i2++;
        }
        if (i2 == list.size()) {
            return getBestSize(list, f);
        }
        return list.get(i2);
    }

    public Camera.Size getPreviewSize(List<Camera.Size> list, int i, float f) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i && equalRate(next, f)) {
                TUIChatLog.i(TAG, "MakeSure Preview :w = " + next.width + " h = " + next.height);
                break;
            }
            i2++;
        }
        if (i2 == list.size()) {
            return getBestSize(list, f);
        }
        return list.get(i2);
    }

    public boolean isSupportedFocusMode(List<String> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                TUIChatLog.i(TAG, "FocusMode supported " + str);
                return true;
            }
        }
        TUIChatLog.i(TAG, "FocusMode not supported " + str);
        return false;
    }

    public boolean isSupportedPictureFormats(List<Integer> list, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i == list.get(i2).intValue()) {
                TUIChatLog.i(TAG, "Formats supported " + i);
                return true;
            }
        }
        TUIChatLog.i(TAG, "Formats not supported " + i);
        return false;
    }
}
