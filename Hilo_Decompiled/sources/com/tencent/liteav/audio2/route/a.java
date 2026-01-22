package com.tencent.liteav.audio2.route;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class a extends BroadcastReceiver {
    final Context a;
    private final InterfaceC٠٠١٥a b;

    /* renamed from: com.tencent.liteav.audio2.route.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface InterfaceC٠٠١٥a {
        void onBluetoothConnectionChanged(boolean z);

        void onBluetoothScoConnected(boolean z);

        void onSystemVolumeChanged();

        void onUsbConnectionChanged(String str, boolean z);

        void onWiredHeadsetConnectionChanged(boolean z);
    }

    public a(Context context, InterfaceC٠٠١٥a r2) {
        this.a = context;
        this.b = r2;
    }

    private static String a(int i) {
        switch (i) {
            case 10:
                return "STATE_OFF";
            case 11:
                return "STATE_TURNING_ON";
            case 12:
                return "STATE_ON";
            case 13:
                return "STATE_TURNING_OFF";
            default:
                return UtilityImpl.NET_TYPE_UNKNOWN;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c;
        String str;
        String str2;
        boolean z = true;
        if (intent != null && context != null) {
            String action = intent.getAction();
            if (action == null) {
                return;
            }
            switch (action.hashCode()) {
                case -2114103349:
                    if (action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1940635523:
                    if (action.equals("android.media.VOLUME_CHANGED_ACTION")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1676458352:
                    if (action.equals("android.intent.action.HEADSET_PLUG")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1608292967:
                    if (action.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1435586571:
                    if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 3:
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    if (usbDevice != null) {
                        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                            str = usbDevice.getProductName();
                            Log.i("AudioEventBroadcastReceiver", "Usb device attached " + str + " manufacture " + usbDevice.getManufacturerName(), new Object[0]);
                        } else {
                            str = "";
                        }
                        if (!AudioDeviceProperty.isUsbHeadsetDevice(usbDevice)) {
                            Log.i("AudioEventBroadcastReceiver", "The attached usb device doesn't seem to support audio, ignore it", new Object[0]);
                            return;
                        }
                        if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
                            this.b.onUsbConnectionChanged(str, true);
                            return;
                        } else {
                            if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(intent.getAction())) {
                                this.b.onUsbConnectionChanged(str, false);
                                return;
                            }
                            Log.i("AudioEventBroadcastReceiver", "Unknown action, ignore it " + intent.getAction(), new Object[0]);
                            return;
                        }
                    }
                    return;
                case 1:
                    InterfaceC٠٠١٥a r12 = this.b;
                    if (r12 != null) {
                        r12.onSystemVolumeChanged();
                        return;
                    }
                    return;
                case 2:
                    int a = a(intent, "state", -1);
                    Log.i("AudioEventBroadcastReceiver", "Receive ACTION_HEADSET_PLUG, EXTRA_STATE:".concat(String.valueOf(a)), new Object[0]);
                    if (a == -1) {
                        Log.e("AudioEventBroadcastReceiver", "Unknown headset state, ignore...", new Object[0]);
                        return;
                    }
                    InterfaceC٠٠١٥a r13 = this.b;
                    if (a == 0) {
                        z = false;
                    }
                    r13.onWiredHeadsetConnectionChanged(z);
                    return;
                case 4:
                    int a2 = a(intent, "android.bluetooth.adapter.extra.STATE", 0);
                    Log.i("AudioEventBroadcastReceiver", "Receive ACTION_STATE_CHANGED, EXTRA_STATE:" + a(a2) + " EXTRA_PREVIOUS_STATE: " + a(a(intent, "android.bluetooth.adapter.extra.PREVIOUS_STATE", 0)), new Object[0]);
                    if (a2 == 10) {
                        this.b.onBluetoothConnectionChanged(false);
                        return;
                    }
                    return;
                case 5:
                    int a3 = a(intent, "android.bluetooth.profile.extra.STATE", 10);
                    if (a3 == 12) {
                        Log.i("AudioEventBroadcastReceiver", "Receive bluetooth audio state changed to STATE_AUDIO_CONNECTED", new Object[0]);
                        this.b.onBluetoothScoConnected(true);
                        return;
                    } else {
                        if (a3 == 10) {
                            Log.i("AudioEventBroadcastReceiver", "Receive bluetooth audio state changed to STATE_AUDIO_DISCONNECTED", new Object[0]);
                            this.b.onBluetoothScoConnected(false);
                            return;
                        }
                        return;
                    }
                case 6:
                    int a4 = a(intent, "android.bluetooth.profile.extra.STATE", -1);
                    if (a4 != 0) {
                        if (a4 != 1) {
                            if (a4 != 2) {
                                if (a4 != 3) {
                                    str2 = UtilityImpl.NET_TYPE_UNKNOWN;
                                } else {
                                    str2 = "STATE_DISCONNECTING";
                                }
                            } else {
                                str2 = "STATE_CONNECTED";
                            }
                        } else {
                            str2 = "STATE_CONNECTING";
                        }
                    } else {
                        str2 = "STATE_DISCONNECTED";
                    }
                    Log.i("AudioEventBroadcastReceiver", "Receive bluetooth headset connection state changed: %s", str2);
                    if (a4 != 0) {
                        if (a4 == 2) {
                            this.b.onBluetoothConnectionChanged(true);
                            return;
                        }
                        return;
                    }
                    this.b.onBluetoothConnectionChanged(false);
                    return;
                default:
                    Log.w("AudioEventBroadcastReceiver", "Ignore unknown Action:".concat(action), new Object[0]);
                    return;
            }
        }
        Log.e("AudioEventBroadcastReceiver", "Receive intent or context is null", new Object[0]);
    }

    private static int a(Intent intent, String str, int i) {
        try {
            return intent.getIntExtra(str, i);
        } catch (Exception e) {
            Log.e("AudioEventBroadcastReceiver", "getIntentIntExtra ".concat(String.valueOf(e)), new Object[0]);
            return i;
        }
    }
}
