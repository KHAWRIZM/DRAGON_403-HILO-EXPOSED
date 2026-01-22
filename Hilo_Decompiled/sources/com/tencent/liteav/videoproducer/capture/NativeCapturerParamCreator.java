package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NativeCapturerParamCreator {
    public static Boolean createBooleanWithValue(boolean z) {
        return Boolean.valueOf(z);
    }

    public static CameraCaptureParams createCameraParams(Boolean bool, int i, int i2, int i3) {
        CameraCaptureParams cameraCaptureParams = new CameraCaptureParams();
        cameraCaptureParams.a = bool;
        cameraCaptureParams.b = i;
        cameraCaptureParams.c = i2;
        cameraCaptureParams.d = i3;
        return cameraCaptureParams;
    }
}
