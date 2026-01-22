package com.tencent.liteav.videobase.videobase;

import android.view.TextureView;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.ui.AndroidViewEventListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.Method;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TXCCloudVideoViewMethodInvoker {
    private static final String TAG = "TXCCloudVideoViewMethodInvoker";

    public static void addViewInternal(TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        callMethod(tXCloudVideoView, "addViewInternal", new Class[]{TextureView.class}, textureView);
    }

    private static Object callMethod(TXCloudVideoView tXCloudVideoView, String str, Class<?>[] clsArr, Object... objArr) {
        if (tXCloudVideoView == null) {
            LiteavLog.w(TAG, str + ",TXCloudVideoView is null.");
            return null;
        }
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(tXCloudVideoView, objArr);
        } catch (Throwable th) {
            LiteavLog.e(TAG, str + ",Exception:", th);
            return null;
        }
    }

    public static TextureView getFreeTextureView(TXCloudVideoView tXCloudVideoView) {
        Object callMethod = callMethod(tXCloudVideoView, "getFreeInnerTextureView", new Class[0], new Object[0]);
        if (callMethod instanceof TextureView) {
            return (TextureView) callMethod;
        }
        return null;
    }

    public static Object getGLContextFromView(DisplayTarget displayTarget) {
        if (displayTarget != null && displayTarget.getTXCloudVideoView() != null) {
            return displayTarget.getTXCloudVideoView().getOpenGLContext();
        }
        return null;
    }

    public static TextureView getTextureViewSetByUser(TXCloudVideoView tXCloudVideoView) {
        Object callMethod = callMethod(tXCloudVideoView, "getTextureViewSetByUser", new Class[0], new Object[0]);
        if (callMethod instanceof TextureView) {
            return (TextureView) callMethod;
        }
        return null;
    }

    public static void notifyFirstFrameRendered(TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        callMethod(tXCloudVideoView, "notifyFirstFrameRendered", new Class[]{TextureView.class}, textureView);
    }

    public static void removeViewInternal(TXCloudVideoView tXCloudVideoView, TextureView textureView, boolean z) {
        callMethod(tXCloudVideoView, "removeViewInternal", new Class[]{TextureView.class, Boolean.TYPE}, textureView, Boolean.valueOf(z));
    }

    public static void setAndroidViewEventListener(TXCloudVideoView tXCloudVideoView, AndroidViewEventListener androidViewEventListener) {
        callMethod(tXCloudVideoView, "setAndroidViewEventListener", new Class[]{AndroidViewEventListener.class}, androidViewEventListener);
    }

    public static void setBackgroundColorForInternalView(TXCloudVideoView tXCloudVideoView, int i) {
        callMethod(tXCloudVideoView, "setBackgroundColorForInternalView", new Class[]{Integer.TYPE}, Integer.valueOf(i));
    }

    public static void setTouchToFocusEnabled(TXCloudVideoView tXCloudVideoView, boolean z) {
        callMethod(tXCloudVideoView, "setTouchToFocusEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public static void setZoomEnabled(TXCloudVideoView tXCloudVideoView, boolean z) {
        callMethod(tXCloudVideoView, "setZoomEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public static void showFocusView(TXCloudVideoView tXCloudVideoView, int i, int i2, int i3, int i4) {
        Class cls = Integer.TYPE;
        callMethod(tXCloudVideoView, "showFocusView", new Class[]{cls, cls, cls, cls}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
