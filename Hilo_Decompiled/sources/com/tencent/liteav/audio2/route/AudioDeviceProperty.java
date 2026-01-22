package com.tencent.liteav.audio2.route;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.liteav.audio2.route.a;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.Iterator;
import java.util.List;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AudioDeviceProperty implements a.InterfaceC٠٠١٥a {
    private static final String TAG = "AudioDeviceProperty";
    private AudioDeviceCallback mAudioDeviceCallback;
    private a mAudioEventBroadcastReceiver;
    private final AudioManager mAudioManager;
    private b mBluetoothHeadsetListener;
    private final Context mContext;
    private long mNativeAudioDeviceProperty;
    private boolean mAudioDeviceCallbackAvailable = false;
    private boolean mUseBluetoothSco = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class UsbAudioDeviceInfo {
        public String a = "";
        public String b = "";

        public String getName() {
            return this.a;
        }

        public String getVidPid() {
            return this.b;
        }
    }

    public AudioDeviceProperty(long j) {
        this.mNativeAudioDeviceProperty = j;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mContext = applicationContext;
        this.mAudioManager = (AudioManager) applicationContext.getSystemService(TUIConstants.TUICalling.TYPE_AUDIO);
    }

    private void buildAudioDeviceCallback() {
        if (this.mAudioDeviceCallback != null) {
            return;
        }
        this.mAudioDeviceCallback = new AudioDeviceCallback() { // from class: com.tencent.liteav.audio2.route.AudioDeviceProperty.1
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0050, code lost:
            
                if (r5 == 26) goto L١١;
             */
            @Override // android.media.AudioDeviceCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                int type;
                boolean isSink;
                CharSequence productName;
                int type2;
                int type3;
                CharSequence productName2;
                int type4;
                int type5;
                int type6;
                int type7;
                int type8;
                if (audioDeviceInfoArr.length != 0) {
                    AudioDeviceProperty.this.mAudioDeviceCallbackAvailable = true;
                    for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                        StringBuilder sb2 = new StringBuilder("added device type is ");
                        type = audioDeviceInfo.getType();
                        sb2.append(type);
                        sb2.append(" sink: ");
                        isSink = audioDeviceInfo.isSink();
                        sb2.append(isSink);
                        sb2.append(" product name: ");
                        productName = audioDeviceInfo.getProductName();
                        sb2.append((Object) productName);
                        Log.i(AudioDeviceProperty.TAG, sb2.toString(), new Object[0]);
                        type2 = audioDeviceInfo.getType();
                        if (type2 != 8) {
                            type8 = audioDeviceInfo.getType();
                        }
                        if (LiteavSystemInfo.getSystemOSVersionInt() > 30) {
                            AudioDeviceProperty.nativeNotifyBluetoothConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, true);
                        }
                        type3 = audioDeviceInfo.getType();
                        if (type3 != 11) {
                            type4 = audioDeviceInfo.getType();
                            if (type4 != 12) {
                                type5 = audioDeviceInfo.getType();
                                if (type5 != 22) {
                                    type6 = audioDeviceInfo.getType();
                                    if (type6 != 3) {
                                        type7 = audioDeviceInfo.getType();
                                        if (type7 != 4) {
                                        }
                                    }
                                    AudioDeviceProperty.nativeNotifyWiredHeadsetConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, true);
                                }
                            }
                        }
                        long j = AudioDeviceProperty.this.mNativeAudioDeviceProperty;
                        productName2 = audioDeviceInfo.getProductName();
                        AudioDeviceProperty.nativeNotifyUsbConnectionChangedFromJava(j, productName2.toString(), AudioDeviceProperty.this.isUsbHeadsetAvailable());
                    }
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
            
                if (r4 == 26) goto L١٣;
             */
            @Override // android.media.AudioDeviceCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                int type;
                boolean isSink;
                CharSequence productName;
                int type2;
                int type3;
                CharSequence productName2;
                int type4;
                int type5;
                int type6;
                int type7;
                int type8;
                int type9;
                if (audioDeviceInfoArr.length == 0) {
                    return;
                }
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    StringBuilder sb2 = new StringBuilder("removed device type is ");
                    type = audioDeviceInfo.getType();
                    sb2.append(type);
                    sb2.append(" sink: ");
                    isSink = audioDeviceInfo.isSink();
                    sb2.append(isSink);
                    sb2.append(" product name: ");
                    productName = audioDeviceInfo.getProductName();
                    sb2.append((Object) productName);
                    Log.i(AudioDeviceProperty.TAG, sb2.toString(), new Object[0]);
                    type2 = audioDeviceInfo.getType();
                    if (type2 != 8) {
                        type8 = audioDeviceInfo.getType();
                        if (type8 != 7) {
                            type9 = audioDeviceInfo.getType();
                        }
                    }
                    if (LiteavSystemInfo.getSystemOSVersionInt() > 30 && !AudioDeviceProperty.this.isBluetoothHeadsetConnected()) {
                        AudioDeviceProperty.nativeNotifyBluetoothConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, false);
                    }
                    type3 = audioDeviceInfo.getType();
                    if (type3 != 11) {
                        type4 = audioDeviceInfo.getType();
                        if (type4 != 12) {
                            type5 = audioDeviceInfo.getType();
                            if (type5 != 22) {
                                type6 = audioDeviceInfo.getType();
                                if (type6 != 3) {
                                    type7 = audioDeviceInfo.getType();
                                    if (type7 != 4) {
                                    }
                                }
                                AudioDeviceProperty.nativeNotifyWiredHeadsetConnectionChangedFromJava(AudioDeviceProperty.this.mNativeAudioDeviceProperty, false);
                            }
                        }
                    }
                    long j = AudioDeviceProperty.this.mNativeAudioDeviceProperty;
                    productName2 = audioDeviceInfo.getProductName();
                    AudioDeviceProperty.nativeNotifyUsbConnectionChangedFromJava(j, productName2.toString(), AudioDeviceProperty.this.isUsbHeadsetAvailable());
                }
            }
        };
    }

    private boolean isCommunicationDeviceConnected(int i) {
        int type;
        try {
            AudioDeviceInfo a = e.a(AudioManager.class.getMethod("getCommunicationDevice", null).invoke(this.mAudioManager, null));
            if (a == null) {
                return false;
            }
            type = a.getType();
            if (type != i) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Log.i(TAG, "get communication device failed. ".concat(String.valueOf(th)), new Object[0]);
            return false;
        }
    }

    public static boolean isUsbHeadsetDevice(UsbDevice usbDevice) {
        if (usbDevice == null) {
            return false;
        }
        for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
            try {
                if (usbDevice.getInterface(i).getInterfaceClass() == 1) {
                    return true;
                }
            } catch (Throwable th) {
                Log.e(TAG, "Get interface exception " + th.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyBluetoothConnectionChangedFromJava(long j, boolean z);

    private static native void nativeNotifyBluetoothScoConnectedFromJava(long j, boolean z);

    private static native void nativeNotifySystemVolumeChangedFromJava(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyUsbConnectionChangedFromJava(long j, String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeNotifyWiredHeadsetConnectionChangedFromJava(long j, boolean z);

    private void registerAudioDeviceCallback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 23) {
            return;
        }
        if (this.mAudioDeviceCallback == null) {
            buildAudioDeviceCallback();
        }
        AudioDeviceCallback audioDeviceCallback = this.mAudioDeviceCallback;
        if (audioDeviceCallback != null) {
            try {
                this.mAudioManager.registerAudioDeviceCallback(audioDeviceCallback, null);
                Log.i(TAG, "register audio device callback", new Object[0]);
            } catch (Throwable th) {
                Log.e(TAG, "registerAudioDeviceCallback exception " + th.getMessage(), new Object[0]);
            }
        }
    }

    private void setCommunicationDevice(AudioDeviceInfo audioDeviceInfo) {
        int type;
        CharSequence productName;
        try {
            boolean booleanValue = ((Boolean) AudioManager.class.getMethod("setCommunicationDevice", g.a()).invoke(this.mAudioManager, audioDeviceInfo)).booleanValue();
            if (!booleanValue) {
                AudioManager.class.getMethod("clearCommunicationDevice", null).invoke(this.mAudioManager, null);
            }
            StringBuilder sb2 = new StringBuilder("setCommunicationDevice: ");
            sb2.append(booleanValue);
            sb2.append(", type: ");
            type = audioDeviceInfo.getType();
            sb2.append(type);
            sb2.append(", product name: ");
            productName = audioDeviceInfo.getProductName();
            sb2.append((Object) productName);
            Log.i(TAG, sb2.toString(), new Object[0]);
        } catch (Throwable th) {
            Log.i(TAG, "set communication device failed. ".concat(String.valueOf(th)), new Object[0]);
        }
    }

    private void unregisterAudioDeviceCallback() {
        AudioDeviceCallback audioDeviceCallback;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && (audioDeviceCallback = this.mAudioDeviceCallback) != null) {
            try {
                this.mAudioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
                Log.i(TAG, "unregister audio device callback", new Object[0]);
            } catch (Throwable th) {
                Log.e(TAG, "unregisterAudioDeviceCallback exception " + th.getMessage(), new Object[0]);
            }
        }
    }

    public UsbAudioDeviceInfo GetUsbAudioDeviceInfo(String str) {
        UsbManager usbManager;
        UsbAudioDeviceInfo usbAudioDeviceInfo = new UsbAudioDeviceInfo();
        try {
            usbManager = (UsbManager) this.mContext.getSystemService("usb");
        } catch (Throwable th) {
            Log.i(TAG, "getDeviceList exception " + th.getMessage(), new Object[0]);
        }
        if (usbManager != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                if (!str.contains(usbDevice.getProductName()) && !isUsbHeadsetDevice(usbDevice)) {
                }
                usbAudioDeviceInfo.a = usbDevice.getProductName();
                usbAudioDeviceInfo.b = String.valueOf(usbDevice.getVendorId()) + usbDevice.getProductId();
            }
            return usbAudioDeviceInfo;
        }
        return usbAudioDeviceInfo;
    }

    public boolean checkBluetoothPermission() {
        return b.a(this.mContext);
    }

    public void connectBluetooth() {
        int type;
        int type2;
        try {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 35) {
                this.mUseBluetoothSco = true;
                this.mAudioManager.startBluetoothSco();
                Log.i(TAG, "startBluetoothSco", new Object[0]);
                return;
            }
            List list = (List) AudioManager.class.getMethod("getAvailableCommunicationDevices", null).invoke(this.mAudioManager, null);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    AudioDeviceInfo a = e.a(it.next());
                    type = a.getType();
                    if (type != 7) {
                        type2 = a.getType();
                        if (type2 == 26) {
                        }
                    }
                    setCommunicationDevice(a);
                    return;
                }
                Log.w(TAG, "not found available communication devices, try to startBluetoothSco", new Object[0]);
                this.mUseBluetoothSco = true;
                this.mAudioManager.startBluetoothSco();
            }
        } catch (Throwable th) {
            Log.i(TAG, "startBluetooth exception " + th.getMessage(), new Object[0]);
        }
    }

    public void disconnectBluetooth() {
        try {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 35 && !this.mUseBluetoothSco) {
                AudioManager.class.getMethod("clearCommunicationDevice", null).invoke(this.mAudioManager, null);
                Log.i(TAG, "clearCommunicationDevice", new Object[0]);
                return;
            }
            this.mUseBluetoothSco = false;
            this.mAudioManager.stopBluetoothSco();
            Log.i(TAG, "stopBluetoothSco", new Object[0]);
        } catch (Throwable th) {
            Log.i(TAG, "stopBluetooth exception " + th.getMessage(), new Object[0]);
        }
    }

    public int getMode() {
        try {
            return this.mAudioManager.getMode();
        } catch (Throwable th) {
            Log.i(TAG, "Get mode exception " + th.getMessage(), new Object[0]);
            return 0;
        }
    }

    public int getSystemVolume() {
        int i;
        try {
            if (this.mAudioManager.getMode() == 0) {
                i = 3;
            } else {
                i = 0;
            }
            int streamMaxVolume = this.mAudioManager.getStreamMaxVolume(i);
            if (streamMaxVolume <= 0) {
                return -1;
            }
            return (int) ((this.mAudioManager.getStreamVolume(i) / streamMaxVolume) * 100.0f);
        } catch (Throwable th) {
            Log.e(TAG, "getStreamVolume exception " + th.getMessage(), new Object[0]);
            return -1;
        }
    }

    public boolean isBluetoothConnected() {
        try {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 35) {
                Intent registerReceiver = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
                if (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0) != 1) {
                    return false;
                }
                return true;
            }
            if (!isCommunicationDeviceConnected(7) && !isCommunicationDeviceConnected(26)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Log.i(TAG, "isBluetoothConnected exception " + th.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isBluetoothHeadsetConnected() {
        b bVar = this.mBluetoothHeadsetListener;
        if (bVar == null) {
            Log.e(TAG, "mBluetoothHeadsetListener is null", new Object[0]);
            return false;
        }
        return bVar.a();
    }

    public boolean isBluetoothOn() {
        try {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 35) {
                return this.mAudioManager.isBluetoothScoOn();
            }
            if (!isCommunicationDeviceConnected(7) && !isCommunicationDeviceConnected(26)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            Log.i(TAG, "isBluetoothOn exception " + th.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isSpeakerphoneOn() {
        try {
            return this.mAudioManager.isSpeakerphoneOn();
        } catch (Throwable th) {
            Log.i(TAG, "isSpeakerphoneOn exception " + th.getMessage(), new Object[0]);
            return false;
        }
    }

    public boolean isUsbHeadsetAvailable() {
        UsbManager usbManager;
        try {
            usbManager = (UsbManager) this.mContext.getSystemService("usb");
        } catch (Throwable th) {
            Log.i(TAG, "getDeviceList exception " + th.getMessage(), new Object[0]);
        }
        if (usbManager == null) {
            return false;
        }
        Iterator<UsbDevice> it = usbManager.getDeviceList().values().iterator();
        while (it.hasNext()) {
            if (isUsbHeadsetDevice(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean isWiredHeadsetOn() {
        try {
            return this.mAudioManager.isWiredHeadsetOn();
        } catch (Throwable th) {
            Log.i(TAG, "isWiredHeadsetOn exception " + th.getMessage(), new Object[0]);
            return false;
        }
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC٠٠١٥a
    public void onBluetoothConnectionChanged(boolean z) {
        nativeNotifyBluetoothConnectionChangedFromJava(this.mNativeAudioDeviceProperty, z);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC٠٠١٥a
    public void onBluetoothScoConnected(boolean z) {
        nativeNotifyBluetoothScoConnectedFromJava(this.mNativeAudioDeviceProperty, z);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC٠٠١٥a
    public void onSystemVolumeChanged() {
        nativeNotifySystemVolumeChangedFromJava(this.mNativeAudioDeviceProperty);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC٠٠١٥a
    public void onUsbConnectionChanged(String str, boolean z) {
        if (this.mAudioDeviceCallbackAvailable) {
            return;
        }
        nativeNotifyUsbConnectionChangedFromJava(this.mNativeAudioDeviceProperty, str, z);
    }

    @Override // com.tencent.liteav.audio2.route.a.InterfaceC٠٠١٥a
    public void onWiredHeadsetConnectionChanged(boolean z) {
        if (this.mAudioDeviceCallbackAvailable) {
            return;
        }
        nativeNotifyWiredHeadsetConnectionChangedFromJava(this.mNativeAudioDeviceProperty, z);
    }

    public void setBluetoothOn(boolean z) {
        try {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 35) {
                this.mAudioManager.setBluetoothScoOn(z);
                Log.i(TAG, "setBluetoothScoOn ".concat(String.valueOf(z)), new Object[0]);
            }
        } catch (Throwable th) {
            Log.i(TAG, "setBluetoothOn exception " + th.getMessage(), new Object[0]);
        }
    }

    public void setSpeakerphoneOn(boolean z) {
        try {
            this.mAudioManager.setSpeakerphoneOn(z);
            Log.i(TAG, "setSpeakerphoneOn ".concat(String.valueOf(z)), new Object[0]);
        } catch (Throwable th) {
            Log.i(TAG, "setSpeakerphoneOn exception " + th.getMessage(), new Object[0]);
        }
    }

    public void setVoip(boolean z) {
        int i;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        try {
            this.mAudioManager.setMode(i);
            Log.i(TAG, "setMode ".concat(String.valueOf(i)), new Object[0]);
        } catch (Throwable th) {
            Log.i(TAG, "Set mode exception " + th.getMessage(), new Object[0]);
        }
    }

    public void setWiredHeadsetOn(boolean z) {
        try {
            this.mAudioManager.setWiredHeadsetOn(z);
            Log.i(TAG, "setWiredHeadsetOn ".concat(String.valueOf(z)), new Object[0]);
        } catch (Throwable th) {
            Log.i(TAG, "setWiredHeadsetOn exception " + th.getMessage(), new Object[0]);
        }
    }

    public void start() {
        registerAudioDeviceCallback();
        a aVar = new a(this.mContext, this);
        this.mAudioEventBroadcastReceiver = aVar;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            aVar.a.registerReceiver(aVar, intentFilter);
        } catch (Throwable unused) {
            Log.e("AudioEventBroadcastReceiver", "register broadcast exception", new Object[0]);
        }
        this.mBluetoothHeadsetListener = new b(this.mContext);
    }

    public void stop() {
        Context context;
        a aVar = this.mAudioEventBroadcastReceiver;
        if (aVar != null && (context = aVar.a) != null) {
            try {
                context.unregisterReceiver(aVar);
            } catch (Exception unused) {
            }
        }
        this.mAudioEventBroadcastReceiver = null;
        b bVar = this.mBluetoothHeadsetListener;
        if (bVar != null) {
            synchronized (bVar.c) {
                try {
                    if (bVar.a != null && bVar.b != null) {
                        bVar.b();
                        bVar.b = null;
                    }
                } finally {
                }
            }
        }
        this.mBluetoothHeadsetListener = null;
        unregisterAudioDeviceCallback();
    }
}
