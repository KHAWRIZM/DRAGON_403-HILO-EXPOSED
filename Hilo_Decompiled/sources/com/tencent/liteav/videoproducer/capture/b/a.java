package com.tencent.liteav.videoproducer.capture.b;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Range;
import android.util.Rational;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.q;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;
import com.tencent.liteav.videoproducer.capture.FaceRect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a extends CameraControllerInterface {
    private static boolean c;
    private CountDownLatch A;
    private CameraEventCallback B;
    private Rect H;
    private final q g;
    private CaptureRequest l;
    private CaptureRequest.Builder m;
    private Size n;
    private SurfaceTexture s;
    private CountDownLatch z;
    private static final HashMap<String, CameraCharacteristics> b = new HashMap<>();
    private static String d = "";
    private static String e = "";
    private final Handler f = new Handler(Looper.getMainLooper());
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicReference<CameraDevice> i = new AtomicReference<>();
    private final AtomicBoolean j = new AtomicBoolean(false);
    private final AtomicReference<CameraCaptureSession> k = new AtomicReference<>();
    private k o = k.NORMAL;
    private k p = null;
    private boolean q = false;
    private int r = 0;
    private boolean t = true;
    private boolean u = true;
    private boolean v = true;
    private int w = -1;
    private EnumC٠٠١٨a x = EnumC٠٠١٨a.IDLE;
    private boolean y = false;
    public boolean a = false;
    private float C = 0.0f;
    private float D = 0.0f;
    private float E = 1.0f;
    private boolean F = false;
    private boolean G = false;
    private com.tencent.liteav.videoproducer.capture.b I = new com.tencent.liteav.videoproducer.capture.b();
    private float J = 0.0f;
    private final CameraDevice.StateCallback K = new CameraDevice.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.1
        private void a(CameraDevice cameraDevice, int i) {
            if (a.this.h.get()) {
                a.b(a.this, i);
            } else {
                a.this.a(false, cameraDevice);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onClosed(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onClosed!" + a(cameraDevice));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onDisconnected(CameraDevice cameraDevice) {
            LiteavLog.e("Camera2Controller", "CameraDevice onDisconnected!" + a(cameraDevice));
            a(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onError(CameraDevice cameraDevice, int i) {
            LiteavLog.e("Camera2Controller", "CameraDevice onError!" + a(cameraDevice) + ", error:" + i);
            int i2 = 3;
            if (i == 3) {
                i2 = 2;
            } else if (i == 1) {
                i2 = 1;
            } else if (i != 5) {
                i2 = 4;
                if (i != 4) {
                    i2 = 0;
                }
            }
            a(cameraDevice, i2);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public final void onOpened(CameraDevice cameraDevice) {
            LiteavLog.i("Camera2Controller", "CameraDevice onOpen!" + a(cameraDevice));
            a.this.a(true, cameraDevice);
        }

        private static String a(CameraDevice cameraDevice) {
            if (cameraDevice == null) {
                return "null";
            }
            return "CameraDevice[id:" + cameraDevice.getId() + "]";
        }
    };
    private final CameraCaptureSession.StateCallback L = new CameraCaptureSession.StateCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.2
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.e("Camera2Controller", "CameraCaptureSession onConfigureFailed!");
            a.this.a(false, cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
            LiteavLog.i("Camera2Controller", "CameraCaptureSession onConfigured!");
            a.this.a(true, cameraCaptureSession);
        }
    };
    private final CameraManager.AvailabilityCallback M = new CameraManager.AvailabilityCallback() { // from class: com.tencent.liteav.videoproducer.capture.b.a.3
        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAccessPrioritiesChanged() {
            super.onCameraAccessPrioritiesChanged();
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            LiteavLog.i("Camera2Controller", "onCameraAvailable: ".concat(String.valueOf(str)));
            if (!a.this.g() && a.b(a.this.t).equals(str) && a.this.h.get()) {
                LiteavLog.w("Camera2Controller", "Current camera is available, it could be interrupted by system app.");
                a aVar = a.this;
                aVar.a(false, (CameraDevice) aVar.i.get());
                a.b(a.this, 1);
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public final void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            LiteavLog.i("Camera2Controller", "onCameraUnavailable: ".concat(String.valueOf(str)));
        }
    };
    private final CameraCaptureSession.CaptureCallback N = new AnonymousClass4();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum EnumC٠٠١٨a {
        IDLE,
        PREVIEWING
    }

    public a(q qVar) {
        this.g = qVar;
    }

    static /* synthetic */ boolean j(a aVar) {
        aVar.y = false;
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableCameraDynamicFps(boolean z) {
        this.q = z;
        LiteavLog.i("Camera2Controller", "set enable camera dynamic fps value is:".concat(String.valueOf(z)));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableFaceDetection(boolean z) {
        this.F = z;
        LiteavLog.i("Camera2Controller", "enable face detection is: ".concat(String.valueOf(z)));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void enableTapToFocus(boolean z) {
        this.u = z;
        if (!this.y) {
            c(z);
            d();
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final FaceRect getCameraFaceRect() {
        return this.I.a();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final k getCameraSystemRotation() {
        return this.o;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getCameraSystemRotationValue() {
        return this.o.mValue;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getCurrentCameraISO() {
        return (int) this.J;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final float getExposureCompensationStep() {
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "getExposureCompensationStep fail, mCameraStatus:" + this.x);
            return 0.0f;
        }
        Rational rational = (Rational) a().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (rational == null) {
            LiteavLog.e("Camera2Controller", "getExposureCompensationStep fail, rational is null");
            return 0.0f;
        }
        return rational.floatValue();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final int getMaxZoom() {
        return Math.round(this.E);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final Size getPreviewSize() {
        return this.n;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraAutoFocusFaceModeSupported() {
        if (a() != null && ((Integer) a().get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCameraFocusPositionInPreviewSupported() {
        if (a() != null && ((Integer) a().get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isCurrentPreviewSizeAspectRatioMatch(int i, int i2, boolean z) {
        boolean z2;
        k kVar = this.p;
        if (kVar == null) {
            kVar = this.o;
        }
        Size a = com.tencent.liteav.videoproducer.capture.c.a(f(), kVar, i, i2);
        int i3 = a.width;
        Size size = this.n;
        boolean z3 = false;
        if (i3 <= size.width && a.height <= size.height) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (a(a) != a(this.n)) {
            z2 = false;
        }
        if (!z || Math.abs(a.aspectRatio() - this.n.aspectRatio()) <= 0.001d) {
            z3 = z2;
        }
        LiteavLog.i("Camera2Controller", "isCurrentPreviewSizeAspectRatioMatch:".concat(String.valueOf(z3)));
        return z3;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isTorchSupported() {
        if (a() != null && ((Boolean) a().get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final boolean isZoomSupported() {
        if (a() != null && this.E > 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setCameraRotationCorrectionValue(int i) {
        k kVar;
        if (k.b(i)) {
            kVar = k.a(i);
        } else {
            kVar = null;
        }
        this.p = kVar;
        LiteavLog.i("Camera2Controller", "camera rotation correction is " + this.p);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setExposureCompensation(int i) {
        if (this.m != null && a() != null) {
            if (((Integer) ((Range) a().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE)).getUpper()).intValue() <= 0) {
                LiteavLog.i("Camera2Controller", "camera doesn't support exposure compensation");
                return;
            } else {
                this.m.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(i));
                d();
                return;
            }
        }
        LiteavLog.e("Camera2Controller", "setExposureCompensation fail, value:" + i + " mCameraStatus:" + this.x);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setExposureCompensationNormalization(float f) {
        this.C = f;
        b(f);
        d();
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setFaceAEStrategy(int i) {
        this.r = i;
        LiteavLog.i("Camera2Controller", "set enable camera face ae value is: " + this.r);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void setZoom(float f) {
        this.D = f;
        a(f);
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void startAutoFocusAtPosition(int i, int i2) {
        CameraCaptureSession cameraCaptureSession;
        double d2;
        double d3;
        Rect rect;
        if (this.u && this.v) {
            if (!g() && !this.y) {
                CameraCaptureSession cameraCaptureSession2 = this.k.get();
                if (cameraCaptureSession2 == null) {
                    LiteavLog.e("Camera2Controller", "CameraCaptureSession get fail");
                    return;
                }
                if (i >= 0) {
                    Size size = this.n;
                    if (i < size.width && i2 >= 0 && i2 < size.height) {
                        LiteavLog.i("Camera2Controller", "Start auto focus at (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
                        double d4 = i;
                        double d5 = i2;
                        Rect rect2 = (Rect) this.l.get(CaptureRequest.SCALER_CROP_REGION);
                        if (rect2 == null) {
                            LiteavLog.e("Camera2Controller", "getMeteringRect can't get crop region");
                            rect2 = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                            if (rect2 == null || rect2.height() <= 0 || rect2.width() <= 0) {
                                cameraCaptureSession = cameraCaptureSession2;
                                rect = null;
                                if (rect != null) {
                                    LiteavLog.e("Camera2Controller", "Illegal meterRect:" + ((Object) null));
                                    return;
                                }
                                try {
                                    this.m.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect, 1000)});
                                    this.m.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect, 1000)});
                                    this.m.set(CaptureRequest.CONTROL_AF_MODE, 1);
                                    this.m.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                                    this.m.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                                    this.y = true;
                                    this.a = false;
                                    this.m.setTag(this);
                                    cameraCaptureSession.setRepeatingRequest(this.m.build(), this.N, this.f);
                                    return;
                                } catch (Throwable th) {
                                    LiteavLog.e("Camera2Controller", "startAutoFocusAtPosition exception:".concat(String.valueOf(th)));
                                    return;
                                }
                            }
                        }
                        int width = rect2.width();
                        int height = rect2.height();
                        Size size2 = this.n;
                        int i3 = size2.height;
                        int i4 = i3 * width;
                        int i5 = size2.width;
                        double d6 = 0.0d;
                        if (i4 > i5 * height) {
                            cameraCaptureSession = cameraCaptureSession2;
                            d2 = (height * 1.0d) / i3;
                            d3 = 0.0d;
                            d6 = (width - (i5 * d2)) / 2.0d;
                        } else {
                            cameraCaptureSession = cameraCaptureSession2;
                            d2 = (width * 1.0d) / i5;
                            d3 = (height - (i3 * d2)) / 2.0d;
                        }
                        double d7 = (d4 * d2) + d6 + rect2.left;
                        double d8 = (d5 * d2) + d3 + rect2.top;
                        rect = new Rect();
                        rect.left = g.a((int) (d7 - (rect2.width() * 0.05d)), 0, rect2.width());
                        rect.right = g.a((int) (d7 + (rect2.width() * 0.05d)), 0, rect2.width());
                        rect.top = g.a((int) (d8 - (rect2.height() * 0.05d)), 0, rect2.height());
                        rect.bottom = g.a((int) (d8 + (rect2.height() * 0.05d)), 0, rect2.height());
                        if (rect != null) {
                        }
                    }
                }
                LiteavLog.w("Camera2Controller", "Start auto focus at (%d, %d) invalid ", Integer.valueOf(i), Integer.valueOf(i2));
                return;
            }
            LiteavLog.e("Camera2Controller", "autoFocus not preview, mCameraStatus:" + this.x + " mIsAutoFocusing:" + this.y);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0120  */
    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean startCapture(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, CameraEventCallback cameraEventCallback) {
        String str;
        boolean z;
        this.B = cameraEventCallback;
        if (!c) {
            try {
                CameraManager cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService("camera");
                for (String str2 : cameraManager.getCameraIdList()) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str2);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num != null && num.intValue() == 0 && MessageService.MSG_DB_NOTIFY_REACHED.equals(str2)) {
                        b.put(str2, cameraCharacteristics);
                        e = str2;
                    } else if (num != null && num.intValue() == 1 && MessageService.MSG_DB_READY_REPORT.equals(str2)) {
                        b.put(str2, cameraCharacteristics);
                        d = str2;
                    }
                }
                LiteavLog.i("Camera2Controller", "initCamera2Ability front:" + e + ", back:" + d);
            } catch (Throwable th) {
                e = MessageService.MSG_DB_NOTIFY_REACHED;
                LiteavLog.e("Camera2Controller", "initCamera2Ability exception!".concat(String.valueOf(th)));
            }
            c = true;
        }
        if (cameraCaptureParams != null && surfaceTexture != null) {
            EnumC٠٠١٨a r0 = this.x;
            EnumC٠٠١٨a r4 = EnumC٠٠١٨a.IDLE;
            if (r0 != r4) {
                LiteavLog.e("Camera2Controller", "it's capturing, you should Stop first.");
                return false;
            }
            this.s = surfaceTexture;
            this.t = cameraCaptureParams.a.booleanValue();
            if (a() != null) {
                int[] iArr = (int[]) a().get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
                if (iArr.length != 0 && (iArr.length != 1 || iArr[0] != 0)) {
                    z = true;
                    this.v = z;
                    ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).registerAvailabilityCallback(this.M, this.f);
                    if (a(cameraCaptureParams.c, cameraCaptureParams.d)) {
                        LiteavLog.e("Camera2Controller", "openCamera failed.");
                        c();
                        this.x = r4;
                        return false;
                    }
                    if (!a(surfaceTexture)) {
                        LiteavLog.e("Camera2Controller", "startPreview failed.");
                        b();
                        this.x = r4;
                        return false;
                    }
                    com.tencent.liteav.videoproducer.capture.b bVar = this.I;
                    bVar.a = this.o.mValue;
                    Size size = this.n;
                    bVar.a(size.width, size.height);
                    this.I.b = this.t;
                    this.m.set(CaptureRequest.CONTROL_AE_MODE, 1);
                    int i = cameraCaptureParams.b;
                    LiteavLog.i("Camera2Controller", "preferred fps: ".concat(String.valueOf(i)));
                    Range range = new Range(Integer.valueOf(i), Integer.valueOf(i));
                    CameraCharacteristics a = a();
                    if (a == null) {
                        LiteavLog.e("Camera2Controller", "camera characteristics is null");
                    } else {
                        com.tencent.liteav.videoproducer.a.a a2 = com.tencent.liteav.videoproducer.capture.c.a(a((Range<Integer>[]) a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)), i, this.q);
                        if (a2 != null) {
                            range = new Range(Integer.valueOf(a2.a), Integer.valueOf(a2.b));
                        }
                    }
                    LiteavLog.i("Camera2Controller", "get best matched fps range result is ".concat(String.valueOf(range)));
                    this.m.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    c(this.u);
                    a(this.D);
                    b(this.C);
                    e();
                    if (this.F) {
                        if (!isCameraAutoFocusFaceModeSupported()) {
                            LiteavLog.e("Camera2Controller", "Camera not support auto focus face mode");
                        } else {
                            try {
                                this.m.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 1);
                                this.G = true;
                            } catch (Throwable th2) {
                                LiteavLog.e("Camera2Controller", "startFaceDetection exception:".concat(String.valueOf(th2)));
                            }
                        }
                    }
                    this.l = this.m.build();
                    d();
                    this.x = EnumC٠٠١٨a.PREVIEWING;
                    this.E = ((Float) a().get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
                    this.H = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                    LiteavLog.i("Camera2Controller", "startCaptureInternal ok, mMaxZoomLevel:" + this.E);
                    return true;
                }
                StringBuilder sb2 = new StringBuilder("Current ");
                if (this.t) {
                    str = "front camera ";
                } else {
                    str = "back camera ";
                }
                sb2.append(str);
                sb2.append(" is not support auto focus.");
                LiteavLog.w("Camera2Controller", sb2.toString());
            }
            z = false;
            this.v = z;
            ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).registerAvailabilityCallback(this.M, this.f);
            if (a(cameraCaptureParams.c, cameraCaptureParams.d)) {
            }
        } else {
            LiteavLog.e("Camera2Controller", "captureParams or surfaceTexture is null");
            return false;
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void stopCapture() {
        CountDownLatch countDownLatch = this.z;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        this.z = null;
        CountDownLatch countDownLatch2 = this.A;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        this.A = null;
        if (this.G) {
            try {
                this.m.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
                this.G = false;
            } catch (Throwable th) {
                LiteavLog.e("Camera2Controller", "stopFaceDetection exception:".concat(String.valueOf(th)));
            }
        }
        b();
        c();
        this.l = null;
        this.a = false;
        this.h.set(false);
        this.s = null;
        this.w = -1;
        this.x = EnumC٠٠١٨a.IDLE;
        this.I.b();
        LiteavLog.i("Camera2Controller", "stopCapture success");
    }

    @Override // com.tencent.liteav.videoproducer.capture.CameraControllerInterface
    public final void turnOnTorch(boolean z) {
        if (g()) {
            LiteavLog.e("Camera2Controller", "turnOnTorch error mCameraStatus:" + this.x);
            return;
        }
        boolean z2 = true;
        if (z && this.w != 2) {
            this.w = 2;
        } else if (!z) {
            this.w = 0;
        } else {
            z2 = false;
        }
        LiteavLog.i("Camera2Controller", "turnOnTorch:" + z + ", mode:" + this.w + ", updateView:" + z2);
        if (z2) {
            this.m.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.w));
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.capture.b.a$4, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public final class AnonymousClass4 extends CameraCaptureSession.CaptureCallback {
        AnonymousClass4() {
        }

        private static boolean a(CaptureRequest captureRequest) {
            return (captureRequest.getTag() instanceof a) && !((a) captureRequest.getTag()).a;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            a.this.g.a(c.a(this, totalCaptureResult, captureRequest));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            LiteavLog.e("Camera2Controller", "onCaptureFailed failure reason:" + captureFailure.getReason());
            a.this.g.a(d.a(this, captureRequest));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public final void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        private void a(CaptureRequest captureRequest, boolean z) {
            if (a.this.g()) {
                return;
            }
            a.j(a.this);
            try {
                a.this.m.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                a.this.m.set(CaptureRequest.CONTROL_AE_MODE, 1);
                a.this.m.set(CaptureRequest.CONTROL_AF_MODE, 3);
                a.this.d();
                if (captureRequest.getTag() instanceof a) {
                    a.a((a) captureRequest.getTag(), z);
                }
            } catch (Throwable th) {
                LiteavLog.e("Camera2Controller", "mAfCaptureCallback exception:".concat(String.valueOf(th)));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, CaptureRequest captureRequest) {
            if (!a(captureRequest)) {
                a.j(a.this);
            } else {
                anonymousClass4.a(captureRequest, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(AnonymousClass4 anonymousClass4, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
            a.this.J = ((Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY)).intValue();
            if (a.this.F && a.this.G) {
                Face[] faceArr = (Face[]) totalCaptureResult.get(CaptureResult.STATISTICS_FACES);
                ArrayList arrayList = new ArrayList();
                for (Face face : faceArr) {
                    arrayList.add(face.getBounds());
                }
                com.tencent.liteav.videoproducer.capture.b bVar = a.this.I;
                Rect rect = a.this.H;
                a aVar = a.this;
                bVar.a(arrayList, rect, aVar.c(aVar.D));
            }
            if (!a(captureRequest)) {
                a.j(a.this);
                return;
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num == null) {
                LiteavLog.e("Camera2Controller", "handleCaptureCompleted get afState fail");
                anonymousClass4.a(captureRequest, false);
            } else if (4 == num.intValue() || 5 == num.intValue()) {
                anonymousClass4.a(captureRequest, true);
            }
        }
    }

    private void c() {
        CameraDevice andSet = this.i.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th) {
                LiteavLog.e("Camera2Controller", "closeCamera fail, Exception:".concat(String.valueOf(th)));
            }
        }
        ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).unregisterAvailabilityCallback(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CaptureRequest.Builder builder;
        CameraCaptureSession cameraCaptureSession = this.k.get();
        if (cameraCaptureSession == null || (builder = this.m) == null) {
            return;
        }
        try {
            cameraCaptureSession.setRepeatingRequest(builder.build(), this.N, null);
        } catch (Throwable th) {
            LiteavLog.e("Camera2Controller", "updatePreview exception:".concat(String.valueOf(th)));
        }
    }

    private void e() {
        CameraCharacteristics a;
        int i = this.r;
        if (i != 0) {
            if (i != 2 || this.t) {
                if ((i == 3 && this.t) || this.m == null || (a = a()) == null) {
                    return;
                }
                for (int i2 : (int[]) a.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
                    if (i2 == 1) {
                        this.m.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 1);
                        this.m.set(CaptureRequest.CONTROL_SCENE_MODE, 1);
                        LiteavLog.i("Camera2Controller", "set control scene mode to 1");
                        return;
                    }
                }
                LiteavLog.e("Camera2Controller", "enable face ae, but device not support.");
            }
        }
    }

    private List<Size> f() {
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes error, Characteristics is null");
            return null;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a().get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes map null");
            return null;
        }
        android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (outputSizes == null) {
            LiteavLog.e("Camera2Controller", "getPreviewSizes choices is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : outputSizes) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return a() == null || this.m == null || this.x != EnumC٠٠١٨a.PREVIEWING;
    }

    private void b(float f) {
        float f2;
        int i;
        if (this.m != null && a() != null) {
            Range range = (Range) a().get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
            int intValue = ((Integer) range.getLower()).intValue();
            int intValue2 = ((Integer) range.getUpper()).intValue();
            if (intValue == 0 && intValue2 == 0) {
                LiteavLog.i("Camera2Controller", "camera doesn't support exposure compensation");
                return;
            }
            float a = g.a(f, -1.0f);
            if (a == 0.0f) {
                i = 0;
            } else {
                if (a > 0.0f) {
                    f2 = intValue2;
                } else {
                    a = Math.abs(a);
                    f2 = intValue;
                }
                i = (int) (a * f2);
            }
            this.m.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(g.a(i, intValue, intValue2)));
            return;
        }
        LiteavLog.e("Camera2Controller", "setExposureCompensation fail, value:" + f + " mCameraStatus:" + this.x);
    }

    private void a(float f) {
        if (this.m != null && a() != null) {
            Rect c2 = c(f);
            if (c2 == null) {
                LiteavLog.e("Camera2Controller", "Illegal zoomRect:".concat(String.valueOf(c2)));
                return;
            } else {
                this.m.set(CaptureRequest.SCALER_CROP_REGION, c2);
                return;
            }
        }
        LiteavLog.e("Camera2Controller", "setZoom fail, scale:" + f + " mPreviewBuilder is null.");
    }

    private void c(boolean z) {
        CaptureRequest.Builder builder = this.m;
        if (builder == null) {
            return;
        }
        int i = z ? 1 : 3;
        builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i));
        LiteavLog.i("Camera2Controller", "setFocusModeWithoutUpdatePreview to ".concat(String.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect c(float f) {
        Rect rect = (Rect) a().get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect == null || rect.height() <= 0 || rect.width() <= 0) {
            return null;
        }
        float a = (g.a(f, 0.0f) * (this.E - 1.0f)) + 1.0f;
        int width = (int) (rect.width() / this.E);
        int height = (int) (rect.height() / this.E);
        int width2 = rect.width() - width;
        int height2 = rect.height() - height;
        float f2 = width2;
        float f3 = a - 1.0f;
        float f4 = this.E;
        int i = (int) (((f2 * f3) / (f4 - 1.0f)) / 2.0f);
        int i2 = (int) (((height2 * f3) / (f4 - 1.0f)) / 2.0f);
        Rect rect2 = new Rect(i, i2, rect.width() - i, rect.height() - i2);
        LiteavLog.d("Camera2Controller", "calculateZoomRect calculatedZoomLevel:" + a + " rect:" + rect + " newRect2:" + rect2);
        return rect2;
    }

    private static int a(Size size) {
        int i = size.width;
        int i2 = size.height;
        if (i == i2) {
            return 0;
        }
        return i > i2 ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, int i) {
        if (aVar.g()) {
            LiteavLog.e("Camera2Controller", "onCameraError, but camera is invalid, do not send camera error.");
            return;
        }
        CameraEventCallback cameraEventCallback = aVar.B;
        if (cameraEventCallback != null) {
            cameraEventCallback.onCameraError(aVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(boolean z) {
        return z ? !TextUtils.isEmpty(e) ? e : d : !TextUtils.isEmpty(d) ? d : e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CameraDevice cameraDevice) {
        CountDownLatch countDownLatch = this.z;
        this.h.set(z);
        this.i.set(cameraDevice);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private void b() {
        CameraCaptureSession andSet = this.k.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (Throwable th) {
                LiteavLog.e("Camera2Controller", "closePreviewSession fail, Exception:".concat(String.valueOf(th)));
            }
        }
    }

    static /* synthetic */ void b(a aVar, int i) {
        aVar.g.a(b.a(aVar, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, CameraCaptureSession cameraCaptureSession) {
        CountDownLatch countDownLatch = this.A;
        this.j.set(z);
        this.k.set(cameraCaptureSession);
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private CameraCharacteristics a() {
        String b2 = b(this.t);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b.get(b2);
    }

    private boolean a(int i, int i2) {
        String b2 = b(this.t);
        if (a() == null) {
            LiteavLog.e("Camera2Controller", "openCamera fail getCameraCharacteristics null");
            return false;
        }
        k a = k.a(((Integer) a().get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue());
        this.o = a;
        k kVar = this.p;
        if (kVar != null) {
            a = kVar;
        }
        this.n = com.tencent.liteav.videoproducer.capture.c.a(f(), a, i, i2);
        StringBuilder sb2 = new StringBuilder("openCamera ,id:");
        sb2.append(b2);
        sb2.append(",");
        sb2.append(this.t ? "front camera" : "back camera");
        sb2.append(" mPreviewSize ");
        sb2.append(this.n);
        sb2.append(" cameraRotation ");
        sb2.append(a);
        sb2.append(" mIsCameraSupportAutoFocus ");
        sb2.append(this.v);
        LiteavLog.i("Camera2Controller", sb2.toString());
        try {
            this.z = new CountDownLatch(1);
            ((CameraManager) ContextUtils.getApplicationContext().getSystemService("camera")).openCamera(b2, this.K, this.f);
            this.z.await();
        } catch (Throwable th) {
            LiteavLog.e("Camera2Controller", "openCamera exception:".concat(String.valueOf(th)));
            a(false, (CameraDevice) null);
        }
        return this.h.get();
    }

    private boolean a(SurfaceTexture surfaceTexture) {
        CameraDevice cameraDevice;
        try {
            cameraDevice = this.i.get();
        } catch (Throwable th) {
            LiteavLog.e("Camera2Controller", "startPreview exception", th);
            a(false, (CameraCaptureSession) null);
        }
        if (cameraDevice != null && surfaceTexture != null) {
            b();
            SurfaceTexture surfaceTexture2 = this.s;
            Size size = this.n;
            surfaceTexture2.setDefaultBufferSize(size.width, size.height);
            Surface surface = new Surface(this.s);
            CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(3);
            this.m = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            List<Surface> singletonList = Collections.singletonList(surface);
            this.A = new CountDownLatch(1);
            cameraDevice.createCaptureSession(singletonList, this.L, this.f);
            this.A.await();
            return this.j.get();
        }
        throw new IOException("startPreview cameraDevice null!");
    }

    private static com.tencent.liteav.videoproducer.a.a[] a(Range<Integer>[] rangeArr) {
        if (rangeArr != null && rangeArr.length > 0) {
            com.tencent.liteav.videoproducer.a.a[] aVarArr = new com.tencent.liteav.videoproducer.a.a[rangeArr.length];
            for (int i = 0; i < rangeArr.length; i++) {
                aVarArr[i] = new com.tencent.liteav.videoproducer.a.a(rangeArr[i].getLower().intValue(), rangeArr[i].getUpper().intValue());
            }
            return aVarArr;
        }
        return new com.tencent.liteav.videoproducer.a.a[0];
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        LiteavLog.i("Camera2Controller", "onFocusCallback success:".concat(String.valueOf(z)));
        aVar.a = true;
        boolean z2 = aVar.u;
        if (z2) {
            return;
        }
        aVar.c(z2);
        aVar.d();
    }
}
