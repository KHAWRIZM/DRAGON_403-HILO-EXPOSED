package io.agora.rtc.audio;

import android.content.Context;
import io.agora.rtc.internal.Logging;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class OppoHardwareEarback implements IHardwareEarback {
    private static String TAG = "AG-OPPO";
    private Class clsMediaClient;
    private Class clsMediaUnit;
    private Class clsOnConnectionSucceedListener;
    private boolean isConnected = false;
    private boolean mClsInited = false;
    private Context mContext;

    public OppoHardwareEarback(Context context) {
        this.mContext = context;
        initialize();
    }

    public static boolean hasMediaUnitClass() {
        Class safeFindClass = ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnit");
        Class safeFindClass2 = ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnitClient");
        Class safeFindClass3 = ReflectUtils.safeFindClass("com.coloros.ocs.base.common.api.OnConnectionSucceedListener");
        if (safeFindClass2 != null && safeFindClass != null && safeFindClass3 != null) {
            return true;
        }
        return false;
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public void destroy() {
        Object safeCallMethod;
        if (!this.mClsInited) {
            return;
        }
        try {
            Context context = this.mContext;
            if (context != null && (safeCallMethod = ReflectUtils.safeCallMethod(this.clsMediaUnit, null, "getMediaClient", new Class[]{Context.class}, new Object[]{context})) != null) {
                ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "release", new Class[0], new Object[0]);
            }
        } catch (Exception e10) {
            Logging.e(e10.getMessage());
        }
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public int enableEarbackFeature(boolean z10) {
        if (!this.mClsInited) {
            return -1;
        }
        try {
            Context context = this.mContext;
            if (context != null && this.isConnected) {
                final Object safeCallMethod = ReflectUtils.safeCallMethod(this.clsMediaUnit, null, "getMediaClient", new Class[]{Context.class}, new Object[]{context});
                if (z10) {
                    if (safeCallMethod != null) {
                        ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "addOnConnectionSucceedListener", new Class[]{this.clsOnConnectionSucceedListener}, new Object[]{Proxy.newProxyInstance(this.clsOnConnectionSucceedListener.getClassLoader(), new Class[]{this.clsOnConnectionSucceedListener}, new InvocationHandler() { // from class: io.agora.rtc.audio.OppoHardwareEarback.2
                            @Override // java.lang.reflect.InvocationHandler
                            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                                if (method.getName().equals("onConnectionSucceed") && OppoHardwareEarback.this.mContext != null) {
                                    ReflectUtils.safeCallMethod(OppoHardwareEarback.this.clsMediaClient, safeCallMethod, "requestAudioLoopback", new Class[0], new Object[0]);
                                    return null;
                                }
                                return null;
                            }
                        })});
                    }
                } else if (safeCallMethod != null) {
                    ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "addOnConnectionSucceedListener", new Class[]{this.clsOnConnectionSucceedListener}, new Object[]{Proxy.newProxyInstance(this.clsOnConnectionSucceedListener.getClassLoader(), new Class[]{this.clsOnConnectionSucceedListener}, new InvocationHandler() { // from class: io.agora.rtc.audio.OppoHardwareEarback.3
                        @Override // java.lang.reflect.InvocationHandler
                        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                            if (method.getName().equals("onConnectionSucceed") && OppoHardwareEarback.this.mContext != null) {
                                ReflectUtils.safeCallMethod(OppoHardwareEarback.this.clsMediaClient, safeCallMethod, "abandonAudioLoopback", new Class[0], new Object[0]);
                                return null;
                            }
                            return null;
                        }
                    })});
                }
                return 0;
            }
        } catch (Exception e10) {
            Logging.e(e10.getMessage());
        }
        return -1;
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public void initialize() {
        Class cls;
        Object safeCallMethod;
        this.clsMediaUnit = ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnit");
        this.clsMediaClient = ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnitClient");
        Class safeFindClass = ReflectUtils.safeFindClass("com.coloros.ocs.base.common.api.OnConnectionSucceedListener");
        this.clsOnConnectionSucceedListener = safeFindClass;
        if (this.clsMediaClient != null && (cls = this.clsMediaUnit) != null && safeFindClass != null) {
            this.mClsInited = true;
            try {
                Context context = this.mContext;
                if (context != null && (safeCallMethod = ReflectUtils.safeCallMethod(cls, null, "getMediaClient", new Class[]{Context.class}, new Object[]{context})) != null) {
                    ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "addOnConnectionSucceedListener", new Class[]{this.clsOnConnectionSucceedListener}, new Object[]{Proxy.newProxyInstance(this.clsOnConnectionSucceedListener.getClassLoader(), new Class[]{this.clsOnConnectionSucceedListener}, new InvocationHandler() { // from class: io.agora.rtc.audio.OppoHardwareEarback.1
                        @Override // java.lang.reflect.InvocationHandler
                        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                            if (method.getName().equals("onConnectionSucceed")) {
                                OppoHardwareEarback.this.isConnected = true;
                                return null;
                            }
                            return null;
                        }
                    })});
                }
            } catch (Exception e10) {
                Logging.e(e10.getMessage());
            }
        }
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public boolean isHardwareEarbackSupported() {
        if (this.isConnected && this.mClsInited) {
            return true;
        }
        return false;
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public int setHardwareEarbackVolume(int i10) {
        return 0;
    }
}
