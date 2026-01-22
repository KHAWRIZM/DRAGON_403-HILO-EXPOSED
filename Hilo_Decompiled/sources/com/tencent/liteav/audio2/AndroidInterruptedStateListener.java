package com.tencent.liteav.audio2;

import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.liteav.audio2.d;
import com.tencent.liteav.audio2.e;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.Executor;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AndroidInterruptedStateListener implements d.a, e.b {
    private static final int RECORDING_CONFIGS_LIMIT = 10;
    public static final String TAG = "AndroidInterruptedStateListener";
    private static d mRecordingCallback;
    private final long mNativeRecordingConfigListener;
    private volatile boolean mNeedNotify = false;
    private Object mObject = new Object();
    private e mPhoneStateManager;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class RecordingConfig {
        int a = 0;
        boolean b = false;

        public int getSessionId() {
            return this.a;
        }

        public boolean isSilenced() {
            return this.b;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            mRecordingCallback = new d();
        }
    }

    public AndroidInterruptedStateListener(long j) {
        this.mNativeRecordingConfigListener = j;
        Log.d(TAG, "new AndroidInterruptedStateListener" + hashCode(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$registerAudioRecordingCallback$0(AndroidInterruptedStateListener androidInterruptedStateListener) {
        if (androidInterruptedStateListener.mPhoneStateManager == null) {
            androidInterruptedStateListener.mPhoneStateManager = new e(androidInterruptedStateListener);
        }
        e eVar = androidInterruptedStateListener.mPhoneStateManager;
        if (e.b()) {
            try {
                TelephonyManager telephonyManager = eVar.a;
                if (telephonyManager != null) {
                    telephonyManager.listen(eVar, 32);
                } else {
                    Log.w("PhoneStateManager", "TelephonyManager is null, start listen phone state failed.", new Object[0]);
                }
            } catch (Throwable th) {
                Log.e("PhoneStateManager", "start listen phone state failed, " + th.getMessage(), new Object[0]);
            }
        } else {
            int i = Build.VERSION.SDK_INT;
            if (i >= 31) {
                try {
                    if (eVar.d == null) {
                        eVar.d = Class.forName("android.media.AudioManager$OnModeChangedListener");
                    }
                    if (eVar.e == null) {
                        eVar.e = Proxy.newProxyInstance(eVar.d.getClassLoader(), new Class[]{eVar.d}, new e.a(eVar));
                    }
                    AudioManager.class.getMethod("addOnModeChangedListener", Executor.class, eVar.d).invoke(eVar.b, h.a(eVar), eVar.e);
                } catch (Throwable th2) {
                    Log.e("PhoneStateManager", "add mode changed listener failed, " + th2.getMessage(), new Object[0]);
                }
            } else if (i >= 26 && e.c != null) {
                Log.i("PhoneStateManager", "register audio playback callback.", new Object[0]);
                e.c.a = eVar;
            }
        }
        eVar.f.a(f.a(eVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$unregisterAudioRecordingCallback$1(AndroidInterruptedStateListener androidInterruptedStateListener) {
        e eVar = androidInterruptedStateListener.mPhoneStateManager;
        if (eVar != null) {
            if (e.b()) {
                try {
                    TelephonyManager telephonyManager = eVar.a;
                    if (telephonyManager != null) {
                        telephonyManager.listen(eVar, 0);
                    }
                    eVar.g = 0;
                    return;
                } catch (Throwable th) {
                    Log.e("PhoneStateManager", "stop listen phone state failed, " + th.getMessage(), new Object[0]);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 31) {
                try {
                    Class<?> cls = eVar.d;
                    if (cls != null && eVar.e != null) {
                        AudioManager.class.getMethod("removeOnModeChangedListener", cls).invoke(eVar.b, eVar.e);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    Log.e("PhoneStateManager", "remove mode changed listener failed, " + th2.getMessage(), new Object[0]);
                    return;
                }
            }
            e.c();
        }
    }

    private static native void nativeNotifyAudioRecordingConfigChangedFromJava(long j, RecordingConfig[] recordingConfigArr);

    private static native void nativeNotifyInterruptedByPhoneCallFromJava(long j);

    private static native void nativeNotifyResumedByPhoneCallFromJava(long j);

    @Override // com.tencent.liteav.audio2.d.a
    public void OnRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
        int clientAudioSessionId;
        boolean isClientSilenced;
        if (list == null) {
            return;
        }
        int min = Math.min(list.size(), 10);
        RecordingConfig[] recordingConfigArr = new RecordingConfig[min];
        for (int i = 0; i < min; i++) {
            recordingConfigArr[i] = new RecordingConfig();
            AudioRecordingConfiguration a = i.a(list.get(i));
            RecordingConfig recordingConfig = recordingConfigArr[i];
            clientAudioSessionId = a.getClientAudioSessionId();
            recordingConfig.a = clientAudioSessionId;
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 29) {
                if (Build.VERSION.SDK_INT >= 29) {
                    RecordingConfig recordingConfig2 = recordingConfigArr[i];
                    isClientSilenced = a.isClientSilenced();
                    recordingConfig2.b = isClientSilenced;
                }
            } else {
                recordingConfigArr[i].b = false;
            }
        }
        synchronized (this.mObject) {
            try {
                if (this.mNeedNotify) {
                    nativeNotifyAudioRecordingConfigChangedFromJava(this.mNativeRecordingConfigListener, recordingConfigArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.liteav.audio2.e.b
    public void onInterruptedByPhoneCall() {
        synchronized (this.mObject) {
            try {
                if (this.mNeedNotify) {
                    nativeNotifyInterruptedByPhoneCallFromJava(this.mNativeRecordingConfigListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.liteav.audio2.e.b
    public void onResumedByPhoneCall() {
        synchronized (this.mObject) {
            try {
                if (this.mNeedNotify) {
                    nativeNotifyResumedByPhoneCallFromJava(this.mNativeRecordingConfigListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void registerAudioRecordingCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 24) {
            return;
        }
        d dVar = mRecordingCallback;
        if (dVar != null) {
            dVar.a = this;
        }
        ThreadUtils.getUiThreadHandler().post(a.a(this));
        this.mNeedNotify = true;
    }

    public void unregisterAudioRecordingCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 24 || mRecordingCallback == null) {
            return;
        }
        synchronized (this.mObject) {
            this.mNeedNotify = false;
            mRecordingCallback.a = null;
            ThreadUtils.getUiThreadHandler().post(b.a(this));
        }
    }
}
