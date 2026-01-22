package io.agora.rtc.audio;

import android.content.Context;
import io.agora.rtc.internal.Logging;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
class HuaweiHardwareEarback implements IHardwareEarback {
    private static final String TAG = "HuaweiHardwareEarback";
    private Context mContext;
    private Object mHwAudioKit = null;
    private Object mHwAudioKaraokeFeatureKit = null;
    private boolean mInited = false;
    private boolean mEarbackEnabled = false;
    private int latency = 0;
    private int volume = 0;
    Class clsHwAudioKit = null;
    Class clsAudioKitCallback = null;
    Class clsHwAudioKaraokeFeatureKit = null;
    private boolean mClsInited = false;

    public HuaweiHardwareEarback(Context context) {
        this.mContext = null;
        Logging.d(TAG, ">>ctor");
        this.mContext = context;
        initialize();
    }

    public static boolean hasHwAudioKitClass() {
        Class safeFindClass = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKit");
        Class safeFindClass2 = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback");
        Class safeFindClass3 = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit");
        if (safeFindClass2 != null && safeFindClass != null && safeFindClass3 != null) {
            return true;
        }
        return false;
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public void destroy() {
        Logging.d(TAG, ">>destroy");
        Object obj = this.mHwAudioKaraokeFeatureKit;
        if (obj != null) {
            ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, obj, "destroy", new Class[0], new Object[0]);
        }
        Object obj2 = this.mHwAudioKit;
        if (obj2 != null) {
            ReflectUtils.safeCallMethod(this.clsHwAudioKit, obj2, "destroy", new Class[0], new Object[0]);
        }
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public synchronized int enableEarbackFeature(boolean z10) {
        if (this.mInited && this.mClsInited) {
            Logging.d(TAG, ">>enableEarbackFeature " + z10);
            Object safeCallMethod = ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, this.mHwAudioKaraokeFeatureKit, "isKaraokeFeatureSupport", new Class[0], new Object[0]);
            if (safeCallMethod != null && safeCallMethod.getClass().equals(Boolean.class)) {
                if (!((Boolean) safeCallMethod).booleanValue()) {
                    Logging.e(TAG, "karaoke not supported");
                    return -1;
                }
                Object safeCallMethod2 = ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, this.mHwAudioKaraokeFeatureKit, "enableKaraokeFeature", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z10)});
                if (safeCallMethod2 != null && safeCallMethod2.getClass().equals(Integer.class)) {
                    int intValue = ((Integer) safeCallMethod2).intValue();
                    if (intValue != 0) {
                        Logging.e(TAG, "enableKaraokeFeature failed ret " + intValue);
                        return -1;
                    }
                    this.mEarbackEnabled = z10;
                    if (z10) {
                        Object safeCallMethod3 = ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, this.mHwAudioKaraokeFeatureKit, "getKaraokeLatency", new Class[0], new Object[0]);
                        if (safeCallMethod3 == null || !safeCallMethod3.getClass().equals(Integer.class)) {
                            this.latency = ((Integer) safeCallMethod3).intValue();
                        }
                        Logging.i(TAG, "latency " + this.latency);
                    }
                    return 0;
                }
                return -1;
            }
            return -1;
        }
        return -7;
    }

    protected void finalize() throws Throwable {
        Logging.d(TAG, ">>finalize");
        destroy();
        super.finalize();
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public void initialize() {
        Constructor constructor;
        Object obj;
        if (this.mContext == null) {
            Logging.e(TAG, "mContext is null!");
            return;
        }
        Logging.d(TAG, ">>initialize");
        this.clsHwAudioKit = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKit");
        this.clsAudioKitCallback = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback");
        Class safeFindClass = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit");
        this.clsHwAudioKaraokeFeatureKit = safeFindClass;
        Class cls = this.clsAudioKitCallback;
        if (cls != null && this.clsHwAudioKit != null && safeFindClass != null) {
            Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{this.clsAudioKitCallback}, new InvocationHandler() { // from class: io.agora.rtc.audio.HuaweiHardwareEarback.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                    if (method.getName().equals("onResult")) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        if (intValue != 0) {
                            if (intValue != 2) {
                                if (intValue == 1000) {
                                    HuaweiHardwareEarback.this.mInited = true;
                                    Logging.i(HuaweiHardwareEarback.TAG, "IAudioKitCallback: HwAudioKaraokeFeatureKit init success ");
                                    return null;
                                }
                                Logging.e(HuaweiHardwareEarback.TAG, "IAudioKitCallback: onResult error number " + intValue);
                                return null;
                            }
                            Logging.i(HuaweiHardwareEarback.TAG, "IAudioKitCallback: audio kit not installed");
                            return null;
                        }
                        Logging.i(HuaweiHardwareEarback.TAG, "IAudioKitCallback: HwAudioKit init success");
                        return null;
                    }
                    return null;
                }
            });
            Method method = null;
            try {
                constructor = this.clsHwAudioKit.getConstructor(Context.class, this.clsAudioKitCallback);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
                constructor = null;
            }
            if (constructor == null) {
                Logging.e(TAG, "find HwAudioKit constructor failed");
                return;
            }
            try {
                this.mHwAudioKit = constructor.newInstance(this.mContext, newProxyInstance);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (this.mHwAudioKit == null) {
                Logging.e(TAG, "create HwAudioKit failed");
                return;
            }
            try {
                Method method2 = this.clsHwAudioKit.getMethod("initialize", null);
                if (method2 != null) {
                    method2.invoke(this.mHwAudioKit, null);
                }
                Class<?> safeFindClass2 = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKit$FeatureType");
                if (safeFindClass2 == null) {
                    Logging.e(TAG, "cannot find class  HwAudioKit$FeatureType initialize failed");
                    return;
                }
                if (safeFindClass2.isEnum()) {
                    obj = safeFindClass2.getEnumConstants()[0];
                } else {
                    obj = null;
                }
                if (obj == null) {
                    Logging.e(TAG, "cannot find class  HwAudioKit$FeatureType initialize failed");
                    return;
                }
                try {
                    method = this.clsHwAudioKit.getMethod("createFeature", safeFindClass2);
                } catch (NoSuchMethodException e12) {
                    e12.printStackTrace();
                }
                if (method == null) {
                    Logging.e(TAG, "cannot find method createFeature ");
                    return;
                }
                try {
                    this.mHwAudioKaraokeFeatureKit = method.invoke(this.mHwAudioKit, obj);
                } catch (IllegalAccessException e13) {
                    e13.printStackTrace();
                } catch (InvocationTargetException e14) {
                    e14.printStackTrace();
                }
                if (this.mHwAudioKaraokeFeatureKit == null) {
                    Logging.e(TAG, " createFeature failed");
                } else {
                    this.mClsInited = true;
                }
            } catch (IllegalAccessException e15) {
                e15.printStackTrace();
                Logging.e(TAG, "create HwAudioKit initialize failed");
            } catch (NoSuchMethodException e16) {
                e16.printStackTrace();
                Logging.e(TAG, "create HwAudioKit initialize failed");
            } catch (InvocationTargetException e17) {
                e17.printStackTrace();
                Logging.e(TAG, "create HwAudioKit initialize failed");
            }
        }
    }

    @Override // io.agora.rtc.audio.IHardwareEarback
    public boolean isHardwareEarbackSupported() {
        boolean z10 = false;
        if (this.mInited && this.mClsInited) {
            Logging.d(TAG, ">>isHardwareEarbackSupported");
            try {
                z10 = ((Boolean) ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, this.mHwAudioKaraokeFeatureKit, "isKaraokeFeatureSupport", new Class[0], new Object[0])).booleanValue();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            Logging.d(TAG, "isSupported " + z10);
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008b A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:9:0x000e, B:12:0x002e, B:14:0x0037, B:18:0x0043, B:20:0x004d, B:25:0x0057, B:29:0x0060, B:31:0x0068, B:44:0x008b, B:48:0x0094, B:50:0x00be, B:53:0x00d6, B:58:0x00b8, B:61:0x0080, B:41:0x0085), top: B:3:0x0004, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.agora.rtc.audio.IHardwareEarback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int setHardwareEarbackVolume(int i10) {
        Object obj;
        int i11;
        if (this.mInited && this.mClsInited) {
            Logging.d(TAG, ">>setHardwareEarbackVolume " + i10);
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 > 100) {
                i10 = 100;
            }
            Class safeFindClass = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit$ParameName");
            if (safeFindClass == null) {
                Logging.e(TAG, "cannot find method  ParameName.getParameName");
                return -1;
            }
            Method safeGetMethod = ReflectUtils.safeGetMethod(safeFindClass, "getParameName", new Class[0]);
            if (safeGetMethod == null) {
                Logging.e(TAG, "cannot find method  ParameName.getParameName");
                return -1;
            }
            Object obj2 = null;
            try {
                obj = null;
                for (Object obj3 : safeFindClass.getEnumConstants()) {
                    try {
                        Object invoke = safeGetMethod.invoke(obj3, null);
                        if (invoke != null && ((String) invoke).equals("Karaoke_volume=")) {
                            obj = obj3;
                        }
                    } catch (IllegalAccessException e10) {
                        e = e10;
                        obj2 = obj;
                        e.printStackTrace();
                        obj = obj2;
                        if (obj == null) {
                        }
                    } catch (InvocationTargetException e11) {
                        e = e11;
                        obj2 = obj;
                        e.printStackTrace();
                        obj = obj2;
                        if (obj == null) {
                        }
                    }
                }
            } catch (IllegalAccessException e12) {
                e = e12;
            } catch (InvocationTargetException e13) {
                e = e13;
            }
            if (obj == null) {
                Logging.e(TAG, "cannot find object  ParameName.CMD_SET_VOCAL_VOLUME_BASE");
                return -1;
            }
            try {
                i11 = ((Integer) ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, this.mHwAudioKaraokeFeatureKit, "setParameter", new Class[]{safeFindClass, Integer.TYPE}, new Object[]{obj, Integer.valueOf(i10)})).intValue();
            } catch (Exception e14) {
                e14.printStackTrace();
                i11 = -1;
            }
            if (i11 != 0) {
                Logging.e(TAG, "setParameter error number " + i11);
                return -1;
            }
            this.volume = i10;
            return 0;
        }
        return -7;
    }
}
