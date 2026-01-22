package com.qiahao.nextvideo.agoraadapter;

import android.content.Context;
import android.view.SurfaceView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class IRTCEngineAdapter {
    private static final String[] SET_VALUES;
    private static final Set<String> methodNotLog;
    private static final String TAG = TRTCEngineAdapter.class.getSimpleName();
    private static boolean useTRTC = true;
    private static boolean isCreateInstance = false;
    private static IRTCEngine mTRTCEngine = null;
    private static IRTCEngine mARTCEngine = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class AdapterHandler implements InvocationHandler {
        private boolean isUseTRTC;
        private IRTCEngine mIRTCEngine;

        public AdapterHandler(IRTCEngine iRTCEngine, boolean z) {
            this.mIRTCEngine = iRTCEngine;
            this.isUseTRTC = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (objArr != null) {
                for (Object obj2 : objArr) {
                    Objects.toString(obj2);
                }
            }
            return method.invoke(this.mIRTCEngine, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class EngineHandlerInvocation implements InvocationHandler {
        private boolean isUseTRTC;
        private IRTCEngineHandler mIRTCEngineHandler;

        public EngineHandlerInvocation(IRTCEngineHandler iRTCEngineHandler, boolean z) {
            this.mIRTCEngineHandler = iRTCEngineHandler;
            this.isUseTRTC = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!IRTCEngineAdapter.methodNotLog.contains(method.getName()) && objArr != null) {
                for (Object obj2 : objArr) {
                    Objects.toString(obj2);
                }
            }
            return method.invoke(this.mIRTCEngineHandler, objArr);
        }
    }

    static {
        String[] strArr = {"onRtcStats", "onLocalVideoStats", "onRemoteVideoStats", "onLocalAudioStats", "onRemoteAudioStats", "onAudioVolumeIndication"};
        SET_VALUES = strArr;
        methodNotLog = new HashSet(Arrays.asList(strArr));
    }

    public static synchronized SurfaceView CreateRendererView(Context context) {
        synchronized (IRTCEngineAdapter.class) {
            if (useTRTC) {
                return TRTCEngineAdapter.CreateRendererView(context);
            }
            return ARTCEngineAdapter.CreateRendererView(context);
        }
    }

    public static synchronized IRTCEngine create(Context context, BaseTRTCEngineAdapterEventHandler baseTRTCEngineAdapterEventHandler, boolean z) {
        IRTCEngine iRTCEngine;
        IRTCEngine iRTCEngine2;
        synchronized (IRTCEngineAdapter.class) {
            if (isCreateInstance) {
                boolean z2 = useTRTC;
                if (z == z2 && (iRTCEngine2 = mTRTCEngine) != null) {
                    return iRTCEngine2;
                }
                if (!z && !z2 && (iRTCEngine = mARTCEngine) != null) {
                    return iRTCEngine;
                }
                destroy();
            }
            useTRTC = z;
            isCreateInstance = true;
            Class[] clsArr = {IRTCEngine.class};
            IRTCEngineHandler iRTCEngineHandler = (IRTCEngineHandler) Proxy.newProxyInstance(IRTCEngineHandler.class.getClassLoader(), new Class[]{IRTCEngineHandler.class}, new EngineHandlerInvocation(baseTRTCEngineAdapterEventHandler, useTRTC));
            if (useTRTC) {
                IRTCEngine iRTCEngine3 = (IRTCEngine) Proxy.newProxyInstance(IRTCEngine.class.getClassLoader(), clsArr, new AdapterHandler(TRTCEngineAdapter.create(context, String.valueOf(SDKConfig.TX_SDKAPPID), iRTCEngineHandler), useTRTC));
                mTRTCEngine = iRTCEngine3;
                return iRTCEngine3;
            }
            IRTCEngine iRTCEngine4 = (IRTCEngine) Proxy.newProxyInstance(IRTCEngine.class.getClassLoader(), clsArr, new AdapterHandler(ARTCEngineAdapter.create(context, SDKConfig.AGORA_APPID, iRTCEngineHandler), useTRTC));
            mARTCEngine = iRTCEngine4;
            return iRTCEngine4;
        }
    }

    public static synchronized void destroy() {
        synchronized (IRTCEngineAdapter.class) {
            try {
                if (useTRTC) {
                    TRTCEngineAdapter.destroy();
                } else {
                    ARTCEngineAdapter.destroy();
                }
                isCreateInstance = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getErrorDescription(int i) {
        if (useTRTC) {
            return TRTCEngineAdapter.getErrorDescription(i);
        }
        return ARTCEngineAdapter.getErrorDescription(i);
    }

    public static String getSdkVersion() {
        if (useTRTC) {
            return TRTCEngineAdapter.getSDKVersion();
        }
        return ARTCEngineAdapter.getSDKVersion();
    }
}
