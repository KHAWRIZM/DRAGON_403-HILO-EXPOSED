package com.tencent.trtc.hardwareearmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::extensions")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HardwareEarMonitorUtil extends BroadcastReceiver {
    private IntentFilter mFilter;
    private long mNativeHardwareEarMonitorHandle;
    private int mHeadsetState = -1;
    private int mHasMicrophone = -1;
    private String mDeviceName = "NotDefine";
    private String mPortName = "NotDefine";
    private String mDeviceAddress = "NotDefine";
    private Object mLock = new Object();
    private Context mContext = ContextUtils.getApplicationContext();

    public HardwareEarMonitorUtil(long j) {
        this.mNativeHardwareEarMonitorHandle = 0L;
        this.mNativeHardwareEarMonitorHandle = j;
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
            this.mFilter = intentFilter;
            this.mContext.registerReceiver(this, intentFilter);
        } catch (Throwable unused) {
        }
    }

    public static HardwareEarMonitorUtil create(long j) {
        return new HardwareEarMonitorUtil(j);
    }

    private static native void nativeHeadsetDescChanged(long j, int i, int i2, String str, String str2, String str3);

    public void destroy() {
        Context context = this.mContext;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        if (this.mFilter != null) {
            this.mFilter = null;
        }
        synchronized (this.mLock) {
            this.mNativeHardwareEarMonitorHandle = 0L;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
            return;
        }
        synchronized (this.mLock) {
            try {
                this.mHeadsetState = intent.getIntExtra("state", -1);
                this.mHasMicrophone = intent.getIntExtra("microphone", -1);
                this.mDeviceName = intent.getStringExtra("device");
                this.mPortName = intent.getStringExtra("portName");
                String stringExtra = intent.getStringExtra("address");
                this.mDeviceAddress = stringExtra;
                long j = this.mNativeHardwareEarMonitorHandle;
                int i = this.mHeadsetState;
                int i2 = this.mHasMicrophone;
                String str = this.mDeviceName;
                if (str == null) {
                    str = "";
                }
                String str2 = this.mPortName;
                if (str2 == null) {
                    str2 = "";
                }
                if (stringExtra == null) {
                    stringExtra = "";
                }
                nativeHeadsetDescChanged(j, i, i2, str, str2, stringExtra);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
