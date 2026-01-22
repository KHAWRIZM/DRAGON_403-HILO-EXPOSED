package io.agora.rtc.internal;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.luck.picture.lib.config.PictureMimeType;
import io.agora.rtc.internal.RtcEngineMessage;
import io.agora.rtc.utils.CameraUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import kotlin.KotlinVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CommonUtility {
    private static final int INTERNAL_UPDATE_ROTATION = 100;
    private static final String PREFIX_URI = "content://";
    private static final String TAG = "CommonUtility";
    private static final int VIDEO_SOURCE_TYPE_CUSTOMIZED = 2;
    private static final int VIDEO_SOURCE_TYPE_DEFAULT = 1;
    private static final int VIDEO_SOURCE_TYPE_EXTERNAL_DEPRECATED = 3;
    private static final int VIDEO_SOURCE_TYPE_NULL = 0;
    private static WeakReference<Application> mApplication;
    private static ConnectivityManager.NetworkCallback mobileNetworkCallback;
    private volatile boolean mAccessible;
    private boolean mAudioOnly;
    private long mBridgeHandle;
    private WeakReference<Context> mContext;
    private Handler mHandler;
    private Handler workerHandler;
    private HandlerThread workerThread;
    private AgoraPhoneStateListener mPhoneStateListener = null;
    private ConnectionChangeBroadcastReceiver mConnectionBroadcastReceiver = null;
    private BroadcastReceiver mOrientationObserver = null;
    private PowerConnectionReceiver mPowerConnectionReceiver = null;
    private int mMobileType = -1;
    private int batteryPercentage = KotlinVersion.MAX_COMPONENT_VALUE;
    private int mOrientation = -1;
    private boolean mLocalVideoEnabled = false;
    private int mVideoSourceType = 1;
    private int mSensorOrietation = -1;
    private DisplayManager.DisplayListener mOrientationListener = null;
    private String localIpv4 = null;
    private String localIpv6 = null;
    private String gatewayIp = null;
    private boolean shouldGetIp = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class AgoraPhoneStateListener extends PhoneStateListener {
        private SignalStrength mSignalStrenth;
        private boolean phoneStatusNeedResume = false;

        public AgoraPhoneStateListener() {
        }

        private int invokeMethod(String str) {
            Method declaredMethod;
            try {
                SignalStrength signalStrength = this.mSignalStrenth;
                if (signalStrength != null && (declaredMethod = signalStrength.getClass().getDeclaredMethod(str, null)) != null) {
                    return ((Integer) declaredMethod.invoke(this.mSignalStrenth, null)).intValue();
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }

        public int getAsuLevel() {
            if (Build.VERSION.SDK_INT <= 28) {
                return invokeMethod("getAsuLevel");
            }
            return 0;
        }

        public int getLevel() {
            return invokeMethod("getLevel");
        }

        public int getRssi() {
            if (Build.VERSION.SDK_INT <= 28) {
                return invokeMethod("getDbm");
            }
            return 0;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i10, String str) {
            if (((Context) CommonUtility.this.mContext.get()) != null && CommonUtility.this.mAccessible) {
                super.onCallStateChanged(i10, str);
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            Logging.i(CommonUtility.TAG, "system phone call start");
                            this.phoneStatusNeedResume = true;
                            CommonUtility.this.onPhoneStateChanged(false, 22, 2);
                            return;
                        }
                        return;
                    }
                    Logging.i(CommonUtility.TAG, "system phone call ring");
                    this.phoneStatusNeedResume = true;
                    CommonUtility.this.onPhoneStateChanged(false, 22, 1);
                    return;
                }
                if (this.phoneStatusNeedResume) {
                    this.phoneStatusNeedResume = false;
                    Logging.i(CommonUtility.TAG, "system phone call end delay 1000ms");
                    new Handler().postDelayed(new Runnable() { // from class: io.agora.rtc.internal.CommonUtility.AgoraPhoneStateListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                CommonUtility.this.onPhoneStateChanged(true, 22, 0);
                            } catch (Exception e10) {
                                Logging.e(CommonUtility.TAG, "fail to resume ", e10);
                            }
                        }
                    }, 1000L);
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (((Context) CommonUtility.this.mContext.get()) != null && CommonUtility.this.mAccessible) {
                super.onSignalStrengthsChanged(signalStrength);
                this.mSignalStrenth = signalStrength;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class MobileType {
        public static final int Cdma = 1;
        public static final int Gsm = 0;
        public static final int Lte = 3;
        public static final int Unknown = -1;
        public static final int Wcdma = 2;
    }

    public CommonUtility(final Context context, long j10, boolean z10) {
        this.mAccessible = false;
        this.mBridgeHandle = 0L;
        this.mAudioOnly = z10;
        this.mContext = new WeakReference<>(context);
        this.mBridgeHandle = j10;
        HandlerThread handlerThread = new HandlerThread("CommonUtilityThread");
        this.workerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.workerThread.getLooper());
        this.workerHandler = handler;
        handler.post(new Runnable() { // from class: io.agora.rtc.internal.CommonUtility.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CommonUtility.this.mPhoneStateListener = new AgoraPhoneStateListener();
                    ((TelephonyManager) context.getSystemService("phone")).listen(CommonUtility.this.mPhoneStateListener, 288);
                } catch (Exception e10) {
                    Logging.e(CommonUtility.TAG, "Unable to create PhoneStateListener, ", e10);
                }
            }
        });
        monitorConnectionEvent(true);
        monitorPowerChange(true);
        HandlerThread handlerThread2 = new HandlerThread("CommonUtilityThread");
        handlerThread2.start();
        Handler handler2 = new Handler(handlerThread2.getLooper());
        this.mHandler = handler2;
        handler2.post(new Runnable() { // from class: io.agora.rtc.internal.CommonUtility.2
            @Override // java.lang.Runnable
            public void run() {
                CommonUtility.this.monitorOrientationChange(context, true);
            }
        });
        this.mAccessible = true;
        Logging.i(TAG, "[init] done!");
    }

    public static boolean canGetDefaultContext() {
        Looper.myLooper();
        Looper.getMainLooper();
        return true;
    }

    private static boolean checkAccessNetworkState(Context context) {
        if (context == null || context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) {
            return false;
        }
        return true;
    }

    private static boolean checkAccessWifiState(Context context) {
        if (context == null || context.checkPermission("android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) {
            return false;
        }
        return true;
    }

    private void checkOrientation(int i10) {
        if (!this.mAudioOnly && i10 != -1 && this.mAccessible) {
            int i11 = 0;
            if (i10 <= 340 && i10 >= 20) {
                if (i10 > 70 && i10 < 110) {
                    nativeNotifyGravityOriChange(this.mBridgeHandle, 180);
                    i11 = 90;
                } else if (i10 > 160 && i10 < 200) {
                    nativeNotifyGravityOriChange(this.mBridgeHandle, 90);
                    i11 = 180;
                } else if (i10 > 250 && i10 < 290) {
                    nativeNotifyGravityOriChange(this.mBridgeHandle, 0);
                    i11 = SubsamplingScaleImageView.ORIENTATION_270;
                } else {
                    i11 = -1;
                }
            } else {
                nativeNotifyGravityOriChange(this.mBridgeHandle, SubsamplingScaleImageView.ORIENTATION_270);
            }
            if (i11 != -1 && i11 != this.mSensorOrietation) {
                this.mSensorOrietation = i11;
                updateViewOrientation();
            }
        }
    }

    private void checkVoipPermissions(Context context, String str) throws SecurityException {
        if (context == null || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) {
            throw new SecurityException(str + " is not granted");
        }
    }

    private void disableOrientationListener() {
        Context context;
        if (!this.mAudioOnly && (context = this.mContext.get()) != null && this.mOrientationListener != null) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                displayManager.unregisterDisplayListener(this.mOrientationListener);
                this.mOrientationListener = null;
            }
            Logging.i(TAG, "[disableOrientationListener] done!");
        }
    }

    private RtcEngineMessage.MediaNetworkInfo doGetNetworkInfo(Context context) {
        InetAddress intToInetAddress;
        if (context == null || !this.mAccessible) {
            return null;
        }
        RtcEngineMessage.MediaNetworkInfo mediaNetworkInfo = new RtcEngineMessage.MediaNetworkInfo();
        if (!checkAccessNetworkState(context)) {
            mediaNetworkInfo.ssid = "";
            mediaNetworkInfo.bssid = "";
            mediaNetworkInfo.rssi = 0;
            mediaNetworkInfo.signalLevel = 0;
            mediaNetworkInfo.frequency = 0;
            mediaNetworkInfo.linkspeed = 0;
            return mediaNetworkInfo;
        }
        if (this.shouldGetIp) {
            String localHost = getLocalHost(true);
            if (localHost != null) {
                mediaNetworkInfo.localIp4 = localHost;
            }
            String localHost2 = getLocalHost(false);
            if (localHost2 != null) {
                mediaNetworkInfo.localIp6 = localHost2;
            }
            this.localIpv4 = localHost;
            this.localIpv6 = localHost2;
            this.shouldGetIp = false;
        } else {
            String str = this.localIpv4;
            if (str != null) {
                mediaNetworkInfo.localIp4 = str;
            }
            String str2 = this.localIpv6;
            if (str2 != null) {
                mediaNetworkInfo.localIp6 = str2;
            }
        }
        NetworkInfo networkInfo = Connectivity.getNetworkInfo(context);
        mediaNetworkInfo.networkType = Connectivity.getNetworkType(networkInfo);
        if (networkInfo != null) {
            mediaNetworkInfo.networkSubtype = networkInfo.getSubtype();
        }
        mediaNetworkInfo.dnsList = Connectivity.getDnsList();
        if (mediaNetworkInfo.networkType == 2) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (checkAccessWifiState(context) && wifiManager != null) {
                if (TextUtils.isEmpty(this.gatewayIp)) {
                    DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                    if (dhcpInfo != null && (intToInetAddress = intToInetAddress(dhcpInfo.gateway)) != null) {
                        String hostAddress = intToInetAddress.getHostAddress();
                        this.gatewayIp = hostAddress;
                        mediaNetworkInfo.gatewayIp4 = hostAddress;
                    }
                } else {
                    mediaNetworkInfo.gatewayIp4 = this.gatewayIp;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    mediaNetworkInfo.ssid = "";
                    mediaNetworkInfo.bssid = "";
                    int rssi = connectionInfo.getRssi();
                    mediaNetworkInfo.rssi = rssi;
                    mediaNetworkInfo.signalLevel = WifiManager.calculateSignalLevel(rssi, 5);
                    mediaNetworkInfo.linkspeed = connectionInfo.getLinkSpeed();
                    int frequency = connectionInfo.getFrequency();
                    mediaNetworkInfo.frequency = frequency;
                    if (frequency >= 5000) {
                        mediaNetworkInfo.networkSubtype = 101;
                    } else if (frequency >= 2400) {
                        mediaNetworkInfo.networkSubtype = 100;
                    }
                }
                mediaNetworkInfo.ifconfigs = getIfconfigs();
            } else {
                mediaNetworkInfo.ssid = "";
                mediaNetworkInfo.bssid = "";
                mediaNetworkInfo.rssi = 0;
                mediaNetworkInfo.signalLevel = 0;
                mediaNetworkInfo.frequency = 0;
                mediaNetworkInfo.linkspeed = 0;
                return mediaNetworkInfo;
            }
        } else {
            AgoraPhoneStateListener agoraPhoneStateListener = this.mPhoneStateListener;
            if (agoraPhoneStateListener != null) {
                this.gatewayIp = null;
                try {
                    mediaNetworkInfo.rssi = agoraPhoneStateListener.getRssi();
                    mediaNetworkInfo.signalLevel = this.mPhoneStateListener.getLevel();
                    mediaNetworkInfo.asu = this.mPhoneStateListener.getAsuLevel();
                } catch (Exception unused) {
                }
            } else {
                this.gatewayIp = null;
            }
        }
        return mediaNetworkInfo;
    }

    private void enableOrientationListener(Context context) {
        if (this.mAudioOnly || this.mHandler == null || this.mOrientationListener != null) {
            return;
        }
        try {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager == null) {
                return;
            }
            DisplayManager.DisplayListener displayListener = new DisplayManager.DisplayListener() { // from class: io.agora.rtc.internal.CommonUtility.5
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i10) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i10) {
                    CommonUtility.this.updateOrientationManual();
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i10) {
                }
            };
            this.mOrientationListener = displayListener;
            displayManager.registerDisplayListener(displayListener, this.mHandler);
            Logging.i(TAG, "[enableOrientationListener] done!");
        } catch (Exception e10) {
            Logging.e(TAG, "Unable to create OrientationEventListener, ", e10);
        }
    }

    private static String getAndroidID(Context context) {
        return "";
    }

    public static String getAppPrivateStorageDir(Context context) {
        File externalFilesDir;
        if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return context.getFilesDir().getAbsolutePath();
    }

    private String getAssetsCacheFile(Context context, String str) {
        InputStream open;
        Logging.i(TAG, "getAssetsCacheFile filePath: " + str);
        boolean startsWith = str.startsWith(PREFIX_URI);
        try {
            File file = new File(context.getCacheDir(), "wm_image_cache");
            if (file.exists()) {
                file.delete();
            }
            if (startsWith) {
                open = new FileInputStream(context.getContentResolver().openFileDescriptor(Uri.parse(str), "r").getFileDescriptor());
            } else {
                open = context.getAssets().open(str);
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            open.close();
                            return file.getAbsolutePath();
                        }
                    }
                } finally {
                    fileOutputStream.close();
                }
            } catch (Throwable th) {
                open.close();
                throw th;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private AudioManager getAudioManager(Context context) {
        if (context == null) {
            return null;
        }
        return (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
    }

    public static byte[] getContextInfo(Context context) {
        if (context == null) {
            return null;
        }
        RtcEngineMessage.PAndroidContextInfo pAndroidContextInfo = new RtcEngineMessage.PAndroidContextInfo();
        pAndroidContextInfo.device = DeviceUtils.buildDeviceId();
        pAndroidContextInfo.deviceInfo = DeviceUtils.getDeviceInfo();
        pAndroidContextInfo.systemInfo = DeviceUtils.getSystemInfo();
        pAndroidContextInfo.configDir = getAppPrivateStorageDir(context);
        pAndroidContextInfo.dataDir = context.getCacheDir().getAbsolutePath();
        pAndroidContextInfo.pluginDir = context.getApplicationInfo().nativeLibraryDir;
        pAndroidContextInfo.androidID = "";
        if (TextUtils.isEmpty(pAndroidContextInfo.device)) {
            pAndroidContextInfo.device = "";
        }
        if (TextUtils.isEmpty(pAndroidContextInfo.deviceInfo)) {
            pAndroidContextInfo.deviceInfo = "";
        }
        if (TextUtils.isEmpty(pAndroidContextInfo.systemInfo)) {
            pAndroidContextInfo.systemInfo = "";
        }
        if (TextUtils.isEmpty(pAndroidContextInfo.configDir)) {
            pAndroidContextInfo.configDir = "";
        }
        if (TextUtils.isEmpty(pAndroidContextInfo.dataDir)) {
            pAndroidContextInfo.dataDir = "";
        }
        if (TextUtils.isEmpty(pAndroidContextInfo.pluginDir)) {
            pAndroidContextInfo.pluginDir = "";
        }
        if (TextUtils.isEmpty(pAndroidContextInfo.androidID)) {
            pAndroidContextInfo.androidID = "";
        }
        return pAndroidContextInfo.marshall();
    }

    public static String getLocalHost(boolean z10) {
        String str;
        try {
            str = null;
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (!networkInterface.getName().startsWith("usb")) {
                    for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress()) {
                            if (z10 && (inetAddress instanceof Inet4Address)) {
                                Inet4Address inet4Address = (Inet4Address) inetAddress;
                                if (str == null) {
                                    str = inet4Address.getHostAddress();
                                }
                                if (!inet4Address.isLinkLocalAddress() && !inet4Address.isAnyLocalAddress()) {
                                    return inet4Address.getHostAddress();
                                }
                            }
                            if (!z10 && (inetAddress instanceof Inet6Address)) {
                                Inet6Address inet6Address = (Inet6Address) inetAddress;
                                if (str == null) {
                                    str = inet6Address.getHostAddress();
                                }
                                if (!inet6Address.isLinkLocalAddress() && !inet6Address.isAnyLocalAddress()) {
                                    return inet6Address.getHostAddress();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (str == null) {
            return null;
        }
        return str;
    }

    public static String[] getLocalHostList() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            ArrayList arrayList = new ArrayList();
            for (NetworkInterface networkInterface : list) {
                String name = networkInterface.getName();
                if (!name.startsWith("usb")) {
                    Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it.hasNext()) {
                        String inetAddressToIpAddress = inetAddressToIpAddress((InetAddress) it.next());
                        if (inetAddressToIpAddress != null) {
                            arrayList.add(inetAddressToIpAddress + "+" + name);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                String[] strArr = new String[arrayList.size()];
                Iterator it2 = arrayList.iterator();
                int i10 = 0;
                while (it2.hasNext()) {
                    strArr[i10] = (String) it2.next();
                    i10++;
                }
                return strArr;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    private static String getSystemProperty(String str) throws Exception {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        return (String) cls.getMethod("get", String.class).invoke(cls, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String inetAddressToIpAddress(InetAddress inetAddress) {
        if (!inetAddress.isLoopbackAddress()) {
            if (inetAddress instanceof Inet4Address) {
                return ((Inet4Address) inetAddress).getHostAddress();
            }
            if ((inetAddress instanceof Inet6Address) && !inetAddress.isLinkLocalAddress()) {
                return ((Inet6Address) inetAddress).getHostAddress();
            }
            return null;
        }
        return null;
    }

    private static InetAddress intToInetAddress(int i10) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE)});
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r1.toLowerCase().equals("intel") != false) goto L٧;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isSimulatorProperty() {
        int i10;
        String property;
        String str = "";
        String str2 = Build.MANUFACTURER;
        try {
            str = getSystemProperty("ro.hardware");
            if (str != null) {
            }
            i10 = 1;
        } catch (Exception unused) {
            Logging.e(TAG, "get property hardware fail.");
        }
        String str3 = TAG;
        Logging.i(str3, "hardware = " + str + ", suspectCount = " + i10);
        try {
            property = System.getProperty("os.arch");
            if (property != null || (property.toLowerCase().equals("i686") && !str2.toLowerCase().contains("asus"))) {
                i10++;
                Logging.i(str3, "arch = " + property + ", suspectCount = " + i10);
            }
        } catch (Exception unused2) {
            Logging.e(TAG, "get property arch fail.");
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (str.toLowerCase().contains("ttvm") || str.toLowerCase().contains("nox")) {
                i10 += 10;
            }
            try {
                String systemProperty = getSystemProperty("ro.build.flavor");
                if (systemProperty == null || systemProperty.contains("vbox") || systemProperty.contains("sdk_gphone")) {
                    i10++;
                    Logging.i(TAG, "buildFlavor = " + systemProperty + ", suspectCount = " + i10);
                }
            } catch (Exception unused3) {
                Logging.e(TAG, "get property buildFlavor fail.");
            }
            try {
                String systemProperty2 = getSystemProperty("ro.product.board");
                if (systemProperty2 == null || (systemProperty2.contains("android") | systemProperty2.contains("goldfish"))) {
                    i10++;
                    Logging.i(TAG, "productBoard = " + systemProperty2 + ", suspectCount = " + i10);
                }
            } catch (Exception unused4) {
                Logging.e(TAG, "get property productBoard fail.");
            }
            try {
                String systemProperty3 = getSystemProperty("ro.board.platform");
                if (systemProperty3 == null || systemProperty3.contains("android")) {
                    i10++;
                    Logging.i(TAG, "boardPlatform = " + systemProperty3 + ", suspectCount = " + i10);
                }
            } catch (Exception unused5) {
                Logging.e(TAG, "get property boardPlatform fail.");
            }
        }
        if (i10 <= 0) {
            return true;
        }
        return false;
        i10 = 0;
        String str32 = TAG;
        Logging.i(str32, "hardware = " + str + ", suspectCount = " + i10);
        property = System.getProperty("os.arch");
        if (property != null) {
        }
        i10++;
        Logging.i(str32, "arch = " + property + ", suspectCount = " + i10);
        if (Build.VERSION.SDK_INT > 28) {
        }
        if (i10 <= 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorOrientationChange(Context context, boolean z10) {
        if (this.mAudioOnly) {
            return;
        }
        if (z10) {
            enableOrientationListener(context);
            regiseterBroadcaster(context);
        } else {
            disableOrientationListener();
            unregisterBroadcaster(context);
        }
    }

    private native void nativeAudioRoutingPhoneChanged(long j10, boolean z10, int i10, int i11);

    private native int nativeNotifyAddressBound(long j10, String str);

    private native int nativeNotifyGravityOriChange(long j10, int i10);

    private native int nativeNotifyNetworkChange(long j10, byte[] bArr);

    private native int nativeNotifyOrientationChange(long j10, int i10);

    private void regiseterBroadcaster(Context context) {
        if (this.mAudioOnly || context == null) {
            return;
        }
        this.mOrientationObserver = new BroadcastReceiver() { // from class: io.agora.rtc.internal.CommonUtility.6
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED") && CommonUtility.this.mAccessible) {
                    CommonUtility.this.updateOrientationManual();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        context.registerReceiver(this.mOrientationObserver, intentFilter);
        Logging.i(TAG, "[regiseterBroadcaster] done!");
    }

    private void unregisterBroadcaster(Context context) {
        BroadcastReceiver broadcastReceiver;
        if (!this.mAudioOnly && context != null && (broadcastReceiver = this.mOrientationObserver) != null) {
            context.unregisterReceiver(broadcastReceiver);
            Logging.i(TAG, "[unregisterBroadcaster] done!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewOrientation() {
        Display display;
        int rotation;
        if (this.mAudioOnly) {
            return;
        }
        if (this.mContext.get() != null && this.mAccessible) {
            DisplayManager displayManager = (DisplayManager) this.mContext.get().getSystemService("display");
            if (displayManager == null || (display = displayManager.getDisplay(0)) == null || (rotation = display.getRotation()) == this.mOrientation) {
                return;
            }
            if (rotation != 0) {
                if (rotation != 1) {
                    if (rotation != 2) {
                        if (rotation == 3) {
                            this.mOrientation = 3;
                            nativeNotifyOrientationChange(this.mBridgeHandle, 3);
                            return;
                        }
                        return;
                    }
                    this.mOrientation = 2;
                    nativeNotifyOrientationChange(this.mBridgeHandle, 2);
                    return;
                }
                this.mOrientation = 1;
                nativeNotifyOrientationChange(this.mBridgeHandle, 1);
                return;
            }
            this.mOrientation = 0;
            nativeNotifyOrientationChange(this.mBridgeHandle, 0);
            return;
        }
        Logging.e(TAG, "[updateViewOrientation] mContext is null or mAccessible is false!");
    }

    public int VPNBehindAddress() {
        Context context = this.mContext.get();
        if (context == null) {
            return 1;
        }
        return Connectivity.VPNBehindAddress(context);
    }

    public void bindSocketToNetwork(final int i10, String str) {
        final ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.get().getSystemService("connectivity");
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).build();
        final String str2 = new String(str);
        ConnectivityManager.NetworkCallback networkCallback = mobileNetworkCallback;
        if (networkCallback != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: io.agora.rtc.internal.CommonUtility.3
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                if (linkProperties != null && !linkProperties.getLinkAddresses().isEmpty()) {
                    String inetAddressToIpAddress = CommonUtility.inetAddressToIpAddress(linkProperties.getLinkAddresses().get(0).getAddress());
                    if (inetAddressToIpAddress != null && inetAddressToIpAddress.equals(str2)) {
                        Logging.d("start bindSocketToNetwork");
                        Logging.d("addressInner" + str2);
                        FileDescriptor fileDescriptor = new FileDescriptor();
                        try {
                            Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                            declaredField.setAccessible(true);
                            declaredField.setInt(fileDescriptor, i10);
                            com.tencent.liteav.base.networkbinder.a.a(network, fileDescriptor);
                            this.notifyAddressBound(str2);
                            Logging.d("bindSocketToNetwork success: network" + network + "+socketfd" + i10);
                            return;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                Logging.e(CommonUtility.TAG, "onAvailable: prop is null or empty!");
            }
        };
        mobileNetworkCallback = networkCallback2;
        try {
            connectivityManager.requestNetwork(build, networkCallback2);
        } catch (Exception e10) {
            mobileNetworkCallback = null;
            Logging.e(TAG, "requestNetwork failed " + e10.toString());
        }
    }

    public int checkChangeNetPermission() {
        if (this.mContext.get().checkPermission("android.permission.CHANGE_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
            return 1;
        }
        return 0;
    }

    public void destroy() {
        this.mAccessible = false;
        Context context = this.mContext.get();
        if (this.mPhoneStateListener != null && context != null) {
            ((TelephonyManager) context.getSystemService("phone")).listen(this.mPhoneStateListener, 0);
            this.mPhoneStateListener = null;
        }
        if (mobileNetworkCallback != null && context != null) {
            ((ConnectivityManager) context.getSystemService("connectivity")).unregisterNetworkCallback(mobileNetworkCallback);
        }
        Handler handler = this.workerHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = this.workerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        monitorConnectionEvent(false);
        monitorPowerChange(false);
        monitorOrientationChange(context, false);
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.mHandler.getLooper().quitSafely();
            this.mHandler = null;
        }
        this.mContext.clear();
        Logging.i(TAG, "[destroy] done!");
    }

    public int getAndroidVersion() {
        return Build.VERSION.SDK_INT;
    }

    public int getBatteryLifePercent() {
        if (this.mContext.get() != null && this.mAccessible) {
            return this.batteryPercentage;
        }
        return KotlinVersion.MAX_COMPONENT_VALUE;
    }

    public int getFrontCameraIndex(Context context) {
        return DeviceUtils.selectFrontCamera(context);
    }

    public ArrayList<String> getIfconfigs() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                String name = ((NetworkInterface) it.next()).getName();
                if (!name.contains("tun") && !name.contains("ppp") && !name.contains("ipsec") && !name.contains("tap")) {
                }
                arrayList.add(name);
            }
        } catch (Exception e10) {
            Logging.e(TAG, "Fail to get network interfaces array list. ", e10);
        }
        return arrayList;
    }

    public byte[] getNetworkInfo() {
        RtcEngineMessage.MediaNetworkInfo doGetNetworkInfo;
        Context context = this.mContext.get();
        if (context == null || !this.mAccessible || (doGetNetworkInfo = doGetNetworkInfo(context)) == null) {
            return null;
        }
        return doGetNetworkInfo.marshall();
    }

    public int getNetworkType() {
        Context context = this.mContext.get();
        if (context == null || !this.mAccessible || !checkAccessNetworkState(context)) {
            return -1;
        }
        return Connectivity.getNetworkType(context);
    }

    public int getNumberOfCameras(Context context) {
        return DeviceUtils.getNumberOfCameras(context);
    }

    public String getPkgName() {
        Context context = this.mContext.get();
        if (context == null) {
            return "";
        }
        return context.getPackageName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int isSimulator() {
        String str;
        boolean z10;
        int i10;
        try {
            str = Build.MANUFACTURER;
        } catch (Exception unused) {
            str = "";
        }
        try {
            z10 = str.toLowerCase().contains("netease");
            try {
                Logging.i(TAG, "manufacturer = " + str);
                i10 = z10;
            } catch (Exception unused2) {
                Logging.e(TAG, "get manufacturer info fail.");
                i10 = z10;
                int i11 = i10;
                if (isSimulatorProperty()) {
                }
                if (Build.VERSION.SDK_INT > 28) {
                }
                return 0;
            }
        } catch (Exception unused3) {
            z10 = false;
            Logging.e(TAG, "get manufacturer info fail.");
            i10 = z10;
            int i112 = i10;
            if (isSimulatorProperty()) {
            }
            if (Build.VERSION.SDK_INT > 28) {
            }
            return 0;
        }
        int i1122 = i10;
        if (isSimulatorProperty()) {
            i1122 = i10 + 1;
        }
        if (Build.VERSION.SDK_INT > 28) {
            if ((!"nokia".equalsIgnoreCase(str) || (!"Nokia_N1".equalsIgnoreCase(Build.DEVICE) && !"N1".equalsIgnoreCase(Build.MODEL))) && i1122 > 0 && !str.toLowerCase().contains("welldo")) {
                return 1;
            }
        } else if (("".toLowerCase().equals("unknown") || i1122 > 0) && !str.toLowerCase().contains("welldo")) {
            return 1;
        }
        return 0;
    }

    public int isSpeakerphoneEnabled(Context context) {
        if (context == null) {
            return 0;
        }
        return getAudioManager(context).isSpeakerphoneOn() ? 1 : 0;
    }

    public void monitorConnectionEvent(boolean z10) {
        ConnectionChangeBroadcastReceiver connectionChangeBroadcastReceiver;
        ConnectionChangeBroadcastReceiver connectionChangeBroadcastReceiver2;
        if (z10) {
            if (this.mConnectionBroadcastReceiver == null) {
                try {
                    this.mConnectionBroadcastReceiver = new ConnectionChangeBroadcastReceiver(this);
                    Context context = this.mContext.get();
                    if (context != null && (connectionChangeBroadcastReceiver2 = this.mConnectionBroadcastReceiver) != null) {
                        context.registerReceiver(connectionChangeBroadcastReceiver2, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        return;
                    }
                    return;
                } catch (Exception e10) {
                    Logging.e(TAG, "Unable to create ConnectionChangeBroadcastReceiver, ", e10);
                    return;
                }
            }
            return;
        }
        try {
            Context context2 = this.mContext.get();
            if (context2 != null && (connectionChangeBroadcastReceiver = this.mConnectionBroadcastReceiver) != null) {
                context2.unregisterReceiver(connectionChangeBroadcastReceiver);
            }
        } catch (IllegalArgumentException unused) {
        }
        this.mConnectionBroadcastReceiver = null;
    }

    public void monitorPowerChange(boolean z10) {
        PowerConnectionReceiver powerConnectionReceiver;
        if (z10) {
            if (this.mPowerConnectionReceiver == null) {
                try {
                    this.mPowerConnectionReceiver = new PowerConnectionReceiver(this);
                    Context context = this.mContext.get();
                    if (context != null && this.mPowerConnectionReceiver != null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                        context.registerReceiver(this.mPowerConnectionReceiver, intentFilter);
                        return;
                    }
                    return;
                } catch (Exception e10) {
                    Logging.e(TAG, "Unable to create PowerConnectionReceiver, ", e10);
                    return;
                }
            }
            return;
        }
        try {
            Context context2 = this.mContext.get();
            if (context2 != null && (powerConnectionReceiver = this.mPowerConnectionReceiver) != null) {
                context2.unregisterReceiver(powerConnectionReceiver);
            }
        } catch (IllegalArgumentException unused) {
        }
        this.mPowerConnectionReceiver = null;
    }

    public void notifyAddressBound(String str) {
        if (this.mContext.get() != null && this.mAccessible) {
            nativeNotifyAddressBound(this.mBridgeHandle, str);
        }
    }

    public void notifyNetworkChange() {
        if (this.mContext.get() != null && this.mAccessible) {
            this.shouldGetIp = true;
            byte[] networkInfo = getNetworkInfo();
            if (networkInfo != null && this.mAccessible) {
                nativeNotifyNetworkChange(this.mBridgeHandle, networkInfo);
            }
        }
    }

    public void onPhoneStateChanged(boolean z10, int i10, int i11) {
        if (this.mBridgeHandle != 0 && this.mAccessible) {
            nativeAudioRoutingPhoneChanged(this.mBridgeHandle, z10, i10, i11);
        }
    }

    public void onPowerChange(int i10) {
        if (this.mContext.get() != null && this.mAccessible) {
            this.batteryPercentage = i10;
        }
    }

    public void updateLocalVideoEnableState(boolean z10) {
        Logging.d(TAG, "updateLocalVideoEnableState: " + z10);
        this.mLocalVideoEnabled = z10;
    }

    public void updateOrientationManual() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: io.agora.rtc.internal.CommonUtility.4
            @Override // java.lang.Runnable
            public void run() {
                CommonUtility.this.updateViewOrientation();
            }
        }, 100L);
    }

    public void updateVideoSourceType(int i10) {
        Logging.d(TAG, "updateVideoSourceType: " + i10);
        this.mVideoSourceType = i10;
    }

    private void checkVoipPermissions(Context context) throws SecurityException {
        checkVoipPermissions(context, "android.permission.INTERNET");
        checkVoipPermissions(context, "android.permission.RECORD_AUDIO");
        checkVoipPermissions(context, "android.permission.MODIFY_AUDIO_SETTINGS");
        if (this.mVideoSourceType == 1 && this.mLocalVideoEnabled) {
            CameraUtils.checkCameraPermission(context);
        }
    }

    private int checkVoipPermissions(Context context, int i10) {
        if (i10 == 1) {
            try {
                checkVoipPermissions(context);
                return 0;
            } catch (SecurityException e10) {
                Logging.e(TAG, "Do not have enough permission! ", e10);
                return -9;
            }
        }
        if (i10 != 2) {
            return -2;
        }
        try {
            checkVoipPermissions(context, "android.permission.INTERNET");
            return 0;
        } catch (SecurityException unused) {
            Logging.e(TAG, "Do not have Internet permission!");
            return -9;
        }
    }
}
