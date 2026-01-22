package com.tencent.rtmp.video.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.audio2.SystemLoopbackRecorder2;
import com.tencent.rtmp.video.BaseBridge;
import com.tencent.rtmp.video.ScreenCaptureService;
import com.tencent.rtmp.video.TXScreenCapture;
import com.tencent.rtmp.video.VirtualDisplayListener;
import com.tencent.rtmp.video.VirtualDisplayWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class f {
    MediaProjection e;
    public WeakReference<Activity> a = null;
    final Map<Surface, a> d = new HashMap();
    boolean f = false;
    final Runnable g = g.a(this);
    final Runnable h = h.a(this);
    final MediaProjection.Callback i = new AnonymousClass1();
    final Handler b = new Handler(Looper.getMainLooper());
    public final com.tencent.rtmp.video.a.a c = new com.tencent.rtmp.video.a.a();

    /* renamed from: com.tencent.rtmp.video.a.f$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    final class AnonymousClass1 extends MediaProjection.Callback {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(f fVar) {
            HashMap hashMap = new HashMap(fVar.d);
            fVar.d.clear();
            for (a aVar : hashMap.values()) {
                VirtualDisplayListener virtualDisplayListener = aVar.d;
                if (virtualDisplayListener != null) {
                    if (aVar.e != null) {
                        virtualDisplayListener.onCaptureError();
                    } else {
                        virtualDisplayListener.onStartFinish(false, false);
                    }
                }
            }
            fVar.c();
        }

        @Override // android.media.projection.MediaProjection.Callback
        public final void onStop() {
            BaseBridge.printLog("VirtualDisplayManager", "MediaProjection session is no longer valid");
            f fVar = f.this;
            fVar.c.a(m.a(fVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class a {
        public Surface a;
        public int b;
        public int c;
        public VirtualDisplayListener d;
        public VirtualDisplayWrapper e;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        Context appContext = BaseBridge.getAppContext();
        if (appContext == null) {
            BaseBridge.printLog("VirtualDisplayManager", "context is null!");
            return;
        }
        Intent intent = new Intent(appContext, (Class<?>) TXScreenCapture.TXScreenCaptureAssistantActivity.class);
        intent.addFlags(268435456);
        appContext.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        BaseBridge.printLog("VirtualDisplayManager", "stopScreenCaptureService");
        try {
            Context appContext = BaseBridge.getAppContext();
            if (appContext == null) {
                BaseBridge.printLog("VirtualDisplayManager", "context is null!");
            } else {
                appContext.stopService(new Intent(appContext, (Class<?>) ScreenCaptureService.class));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        for (a aVar : this.d.values()) {
            if (aVar.e == null) {
                try {
                    aVar.e = new VirtualDisplayWrapper(this.e.createVirtualDisplay("TXCScreenCapture", aVar.b, aVar.c, 1, 1, aVar.a, null, null));
                    BaseBridge.printLog("VirtualDisplayManager", "create VirtualDisplay " + aVar.e);
                    VirtualDisplayListener virtualDisplayListener = aVar.d;
                    if (virtualDisplayListener != null) {
                        virtualDisplayListener.onVirtualDisplayCreate(aVar.e);
                        aVar.d.onStartFinish(true, false);
                    }
                } catch (Throwable th) {
                    BaseBridge.printLog("VirtualDisplayManager", "create VirtualDisplay error ".concat(String.valueOf(th)));
                    VirtualDisplayListener virtualDisplayListener2 = aVar.d;
                    if (virtualDisplayListener2 != null) {
                        virtualDisplayListener2.onStartFinish(false, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (!this.d.isEmpty()) {
            return;
        }
        BaseBridge.printLog("VirtualDisplayManager", "Stop media projection session " + this.e);
        if (this.e != null) {
            b(null);
            try {
                this.e.unregisterCallback(this.i);
                this.e.stop();
            } catch (Throwable th) {
                BaseBridge.printLog("VirtualDisplayManager", "stop media projection session with exception ".concat(String.valueOf(th)));
            }
            this.e = null;
        }
        d();
    }

    public final void a(MediaProjection mediaProjection) {
        this.c.a(l.a(this, mediaProjection));
    }

    public final synchronized void a(Activity activity) {
        BaseBridge.printLog("VirtualDisplayManager", "Register request permission activity:".concat(String.valueOf(activity)));
        this.a = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(MediaProjection mediaProjection) {
        try {
            int i = SystemLoopbackRecorder2.a;
            SystemLoopbackRecorder2.class.getMethod("notifyMediaProjectionState", MediaProjection.class).invoke(null, mediaProjection);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            BaseBridge.printLog("VirtualDisplayManager", "fail to send media projection session " + e.getMessage());
        }
    }
}
