package com.tencent.trtc.hardwareearmonitor.oplus;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.taobao.accs.utl.BaseMonitor;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.l;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.trtc.hardwareearmonitor.oplus.OplusKaraokeServiceAidlInterface;
import i9.b;

@JNINamespace("liteav::extensions")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HardwareEarMonitorOplus {
    private static final int AUTHENTICATE_FAIL = 1002;
    private static final String AUTH_URI = "content://com.oplus.ocs.out.OpenCapabilityThirdProvider/oplus";
    private static final int KARAOKE_MESSAGE_CODE = 3000;
    private static final int KARAOKE_SUCCESS = 1000;
    private static final int ON_BIND_EXCEPTION = 1012;
    private static final int OPEN_CAPABILITY_THIRD_PROVIDER_NOT_FOUND = 1013;
    private static final String TAG = "HardwareEarMonitorOplus";
    private OplusKaraokeServiceAidlInterface mKaraokeServiceInterface;
    private long mNativeHardwareEarMonitorHandle;
    private Intent mServiceIntent;
    private Object mLock = new Object();
    private AudioManager mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(TUIConstants.TUICalling.TYPE_AUDIO);
    private Context mContext = ContextUtils.getApplicationContext();
    private KaraokeServiceConnection mConnection = new KaraokeServiceConnection();
    private l mTaskRunner = new l();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class KaraokeServiceConnection implements ServiceConnection {
        private String mDescName;

        public KaraokeServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OplusKaraokeServiceAidlInterface.Stub.setDESCRIPTOR(this.mDescName);
            HardwareEarMonitorOplus.this.mKaraokeServiceInterface = OplusKaraokeServiceAidlInterface.Stub.asInterface(iBinder);
            if (HardwareEarMonitorOplus.this.mKaraokeServiceInterface != null) {
                LiteavLog.i(HardwareEarMonitorOplus.TAG, "mKaraokeServiceInterface Create Success");
                HardwareEarMonitorOplus.this.notifyResult(1000);
            } else {
                LiteavLog.i(HardwareEarMonitorOplus.TAG, "mKaraokeServiceInterface Create Failed");
                HardwareEarMonitorOplus.this.notifyResult(1012);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            HardwareEarMonitorOplus.this.mKaraokeServiceInterface = null;
            LiteavLog.i(HardwareEarMonitorOplus.TAG, "onServiceDisconnected");
            HardwareEarMonitorOplus.this.notifyResult(1012);
        }

        void setDescName(String str) {
            this.mDescName = str;
        }
    }

    public HardwareEarMonitorOplus(long j) {
        this.mNativeHardwareEarMonitorHandle = j;
    }

    public static HardwareEarMonitorOplus create(long j) {
        return new HardwareEarMonitorOplus(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeHandleResult(long j, int i);

    public void authCheck(String str) {
        Bundle bundle;
        Uri parse = Uri.parse(AUTH_URI);
        Messenger messenger = new Messenger(new Handler(this.mContext.getMainLooper()) { // from class: com.tencent.trtc.hardwareearmonitor.oplus.HardwareEarMonitorOplus.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                try {
                    super.handleMessage(message);
                    HardwareEarMonitorOplus.this.notifyResult(message.getData().getInt("result_code"));
                } catch (Throwable th) {
                    LiteavLog.i(HardwareEarMonitorOplus.TAG, "authCheck ex:" + th.getMessage());
                    HardwareEarMonitorOplus.this.notifyResult(1002);
                }
            }
        });
        Bundle bundle2 = new Bundle();
        bundle2.putBinder("callback", messenger.getBinder());
        try {
            bundle = this.mContext.getContentResolver().call(parse, BaseMonitor.ALARM_POINT_AUTH, str, bundle2);
        } catch (Throwable th) {
            LiteavLog.e(TAG, "component is not exist or not visible ex:" + th.getMessage());
            notifyResult(OPEN_CAPABILITY_THIRD_PROVIDER_NOT_FOUND);
            bundle = null;
        }
        if (bundle == null) {
            LiteavLog.e(TAG, "retBundle is null");
            notifyResult(OPEN_CAPABILITY_THIRD_PROVIDER_NOT_FOUND);
        }
    }

    public void bindKaraokeService(String str, String str2, String str3) {
        this.mServiceIntent = new Intent();
        LiteavLog.i(TAG, "bindKaraokeService service package name:" + str + " service name:" + str2 + " android os:" + Build.VERSION.SDK_INT + " oplus os:" + getOplusOSVersionInt());
        this.mServiceIntent.setPackage(str);
        this.mServiceIntent.setAction(str2);
        this.mConnection.setDescName(str3);
        try {
            this.mContext.bindService(this.mServiceIntent, this.mConnection, 1);
        } catch (Throwable th) {
            LiteavLog.i(TAG, "bindKaraokeService ex:" + th.getMessage());
            notifyResult(1012);
        }
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.mNativeHardwareEarMonitorHandle = 0L;
        }
        try {
            this.mContext.unbindService(this.mConnection);
        } catch (Throwable th) {
            LiteavLog.i(TAG, "destroy ex:" + th.getMessage());
        }
        this.mConnection = null;
        this.mKaraokeServiceInterface = null;
    }

    public String getManifestMeta(String str) {
        try {
            return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData.getString(str);
        } catch (Throwable th) {
            LiteavLog.i(TAG, "getManifestMeta ex:" + th.getMessage());
            return "";
        }
    }

    public int getOplusOSVersionInt() {
        try {
            Class<?> cls = Class.forName("com.oplus.os.OplusBuild");
            return ((Integer) cls.getDeclaredMethod("getOplusOSVERSION", null).invoke(cls, null)).intValue();
        } catch (Throwable th) {
            LiteavLog.i(TAG, "getOplusOSVersionInt ex:" + th.getMessage());
            return 0;
        }
    }

    public int getUidFromPackage() {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                return 0;
            }
            return b.a(this.mContext.getPackageManager(), this.mContext.getPackageName(), 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void notifyResult(final int i) {
        this.mTaskRunner.a(new Runnable() { // from class: com.tencent.trtc.hardwareearmonitor.oplus.HardwareEarMonitorOplus.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (HardwareEarMonitorOplus.this.mLock) {
                    HardwareEarMonitorOplus.nativeHandleResult(HardwareEarMonitorOplus.this.mNativeHardwareEarMonitorHandle, i);
                }
            }
        });
    }

    public void setActiveClient(String str) {
        OplusKaraokeServiceAidlInterface oplusKaraokeServiceAidlInterface = this.mKaraokeServiceInterface;
        if (oplusKaraokeServiceAidlInterface != null) {
            try {
                oplusKaraokeServiceAidlInterface.setActiveClient(str);
            } catch (Throwable th) {
                LiteavLog.i(TAG, "setActiveClient ex:" + th.getMessage());
            }
        }
    }

    public boolean setAudioParams(String str) {
        try {
            this.mAudioManager.setParameters(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean systemFeatureSupported(String str) {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return this.mContext.getPackageManager().hasSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
