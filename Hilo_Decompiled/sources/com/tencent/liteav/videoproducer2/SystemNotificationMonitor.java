package com.tencent.liteav.videoproducer2;

import android.os.Looper;
import android.view.OrientationEventListener;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.videobase.SystemDisplayInfo;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SystemNotificationMonitor extends OrientationEventListener implements r.a {
    private static final int SENSOR_ROTATION_DETECTION_THRESHOLD = 30;
    private k mDisplayRotation;
    private int mLastOrientation;
    private volatile long mListenerPtr;
    private k mSensorRotation;
    private volatile r mTimer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer2.SystemNotificationMonitor$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.values().length];
            a = iArr;
            try {
                iArr[k.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[k.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SystemNotificationMonitor() {
        super(ContextUtils.getApplicationContext());
        this.mLastOrientation = -1;
        this.mTimer = null;
        this.mListenerPtr = 0L;
        this.mSensorRotation = null;
        this.mDisplayRotation = null;
    }

    private k getSensorRotationByDisplayRotation(k kVar) {
        if (kVar == null) {
            return k.NORMAL;
        }
        int i = AnonymousClass1.a[kVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return k.NORMAL;
                }
                return k.ROTATION_90;
            }
            return k.ROTATION_180;
        }
        return k.ROTATION_270;
    }

    private k getSensorRotationCorrection() {
        if (this.mListenerPtr == 0) {
            return null;
        }
        int nativeGetGravitySensorRotationCorrection = nativeGetGravitySensorRotationCorrection(this.mListenerPtr);
        if (!k.b(nativeGetGravitySensorRotationCorrection)) {
            return null;
        }
        return k.a(nativeGetGravitySensorRotationCorrection);
    }

    private static native synchronized int nativeGetGravitySensorRotationCorrection(long j);

    private static native void nativeSensorChanged(long j, int i, int i2);

    private synchronized void notifyOrientationChanged() {
        int i;
        try {
            if (this.mListenerPtr == 0) {
                return;
            }
            int i2 = 0;
            if (getSensorRotationCorrection() != null) {
                i = getSensorRotationCorrection().mValue;
            } else {
                k kVar = this.mSensorRotation;
                if (kVar != null) {
                    i = kVar.mValue;
                } else {
                    i = 0;
                }
            }
            k kVar2 = this.mDisplayRotation;
            if (kVar2 != null) {
                i2 = kVar2.mValue;
            }
            nativeSensorChanged(this.mListenerPtr, i, i2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void initialize(long j) {
        this.mListenerPtr = j;
        if (this.mTimer != null) {
            return;
        }
        super.enable();
        this.mTimer = new r(Looper.getMainLooper(), this);
        this.mTimer.a(200);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // android.view.OrientationEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onOrientationChanged(int i) {
        k kVar;
        if (i == -1) {
            return;
        }
        int i2 = this.mLastOrientation;
        if (i2 != -1 && Math.abs(i - i2) <= 30) {
            return;
        }
        this.mLastOrientation = i;
        if (i > 45) {
            if (i <= 135) {
                kVar = k.ROTATION_90;
            } else if (i <= 225) {
                kVar = k.ROTATION_180;
            } else if (i <= 315) {
                kVar = k.ROTATION_270;
            }
            if (this.mSensorRotation == kVar) {
                this.mSensorRotation = kVar;
                this.mDisplayRotation = k.a(SystemDisplayInfo.getDisplayRotationDegree());
                notifyOrientationChanged();
                return;
            }
            return;
        }
        kVar = k.NORMAL;
        if (this.mSensorRotation == kVar) {
        }
    }

    @Override // com.tencent.liteav.base.util.r.a
    public void onTimeout() {
        k a = k.a(SystemDisplayInfo.getDisplayRotationDegree());
        if (this.mDisplayRotation == a) {
            return;
        }
        this.mDisplayRotation = a;
        if (this.mSensorRotation == null) {
            this.mSensorRotation = getSensorRotationByDisplayRotation(a);
        }
        notifyOrientationChanged();
    }

    public synchronized void uninitialize() {
        super.disable();
        this.mListenerPtr = 0L;
        if (this.mTimer != null) {
            this.mTimer.a();
            this.mTimer = null;
        }
    }
}
