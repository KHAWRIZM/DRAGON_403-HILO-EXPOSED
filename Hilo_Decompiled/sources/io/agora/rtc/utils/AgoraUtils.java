package io.agora.rtc.utils;

import android.content.Context;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import io.agora.rtc.internal.RtcEngineImpl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AgoraUtils {
    private static final String TAG = "AgoraUtils";

    public static boolean ensureNativeLibsInitialized() {
        return RtcEngineImpl.initializeNativeLibs();
    }

    public static int getDisplayRotation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return SubsamplingScaleImageView.ORIENTATION_270;
            }
            return 180;
        }
        return 90;
    }

    public static int getFrameOrientation(int i10, int i11, boolean z10, boolean z11) {
        if (z10) {
            int i12 = (i11 + i10) % 360;
            if (z11) {
                return (360 - i12) % 360;
            }
            return i12;
        }
        return ((i11 - i10) + 360) % 360;
    }
}
