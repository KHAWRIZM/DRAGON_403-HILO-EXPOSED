package io.agora.rtc.internal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import io.agora.rtc.internal.AudioRoutingController;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AudioDeviceInventoryLowerThanM implements AudioRoutingController.AudioDeviceInventory {
    private static final int ANDROID_SNOW_CONE = 31;
    private static final String PERMISSION_BLUETOOTH_CONNECT = "android.permission.BLUETOOTH_CONNECT";
    private static final String TAG = "AudioRoute";
    private AudioManager mAm;
    private AudioRoutingController.AudioDeviceChangedCallback mAudioDeviceChangedCb;
    private BluetoothAdapter mBTAdapter;
    private BluetoothHeadset mBTHeadset;
    private BluetoothProfile.ServiceListener mBTHeadsetListener;
    private final WeakReference<Context> mContext;
    private final int STATE_DISCONNECT = -1;
    private final int STATE_CONNECT = 1;
    private final String HEADSET_EXTRA_STATE = "state";
    private HeadsetBroadcastReceiver mHeadsetReceiver = null;
    private BTHeadsetBroadcastReceiver mBTHeadsetReceiver = null;
    private int mHeadsetType = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class BTHeadsetBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private BTHeadsetBroadcastReceiver() {
            this.isRegistered = false;
        }

        public boolean getRegistered() {
            return this.isRegistered;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AudioDeviceInventoryLowerThanM.this.processBluetoothIntent(intent);
        }

        public void setRegistered(boolean z10) {
            this.isRegistered = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class HeadsetBroadcastReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private HeadsetBroadcastReceiver() {
            this.isRegistered = false;
        }

        public boolean getRegistered() {
            return this.isRegistered;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                boolean processHeadsetIntent = AudioDeviceInventoryLowerThanM.this.processHeadsetIntent(intent);
                int i10 = 2;
                if (AudioDeviceInventoryLowerThanM.this.mHeadsetType != 2) {
                    i10 = 1;
                }
                AudioDeviceInventoryLowerThanM.this.onAudioDeviceChanged(i10, processHeadsetIntent);
            }
        }

        public void setRegistered(boolean z10) {
            this.isRegistered = z10;
        }
    }

    public AudioDeviceInventoryLowerThanM(Context context) {
        this.mContext = new WeakReference<>(context);
        this.mAm = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        Logging.i(TAG, "AudioDeviceInventoryLowerThanM ctor!");
    }

    private void clearBTResource() {
        BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.closeProfileProxy(1, this.mBTHeadset);
            this.mBTAdapter = null;
        }
        if (this.mBTHeadsetListener != null) {
            this.mBTHeadsetListener = null;
        }
    }

    private int getBtConnectedDevicesSize() {
        BluetoothHeadset bluetoothHeadset = this.mBTHeadset;
        if (bluetoothHeadset == null) {
            return 0;
        }
        try {
            List<BluetoothDevice> connectedDevices = bluetoothHeadset.getConnectedDevices();
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                Logging.i(TAG, "connected device name: " + it.next().getName());
            }
            return connectedDevices.size();
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    private void initBluetoothProfileListener() {
        try {
            this.mBTHeadsetListener = new BluetoothProfile.ServiceListener() { // from class: io.agora.rtc.internal.AudioDeviceInventoryLowerThanM.1
                @Override // android.bluetooth.BluetoothProfile.ServiceListener
                public void onServiceConnected(int i10, BluetoothProfile bluetoothProfile) {
                    Logging.i(AudioDeviceInventoryLowerThanM.TAG, "onServiceConnected " + i10 + " =? headset(1)");
                    if (i10 == 1) {
                        Logging.i(AudioDeviceInventoryLowerThanM.TAG, "on BT service connected: " + i10 + " " + bluetoothProfile);
                        AudioDeviceInventoryLowerThanM.this.mBTHeadset = (BluetoothHeadset) bluetoothProfile;
                    }
                }

                @Override // android.bluetooth.BluetoothProfile.ServiceListener
                public void onServiceDisconnected(int i10) {
                    Logging.i(AudioDeviceInventoryLowerThanM.TAG, "onServiceDisconnected " + i10 + " =? headset(1)");
                    if (i10 == 1) {
                        Logging.i(AudioDeviceInventoryLowerThanM.TAG, "on BT service disconnected: " + i10);
                        AudioDeviceInventoryLowerThanM.this.onAudioDeviceEvent(0);
                        AudioDeviceInventoryLowerThanM.this.mBTHeadset = null;
                    }
                }
            };
        } catch (Exception e10) {
            Logging.e(TAG, "initialize failed: unable to create BluetoothProfile.ServiceListener, err=" + e10.getMessage());
        }
    }

    private void initBtBroadcastReceiver(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if ((i10 >= 31 && !hasPermission(context, PERMISSION_BLUETOOTH_CONNECT)) || (i10 < 31 && !hasPermission(context, "android.permission.BLUETOOTH"))) {
            Logging.w(TAG, "do not support BT monitoring on this device");
            return;
        }
        initBluetoothProfileListener();
        try {
            if (this.mBTHeadsetReceiver == null) {
                this.mBTHeadsetReceiver = new BTHeadsetBroadcastReceiver();
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.mBTAdapter = defaultAdapter;
            if (defaultAdapter != null) {
                defaultAdapter.getProfileProxy(context, this.mBTHeadsetListener, 1);
                IntentFilter intentFilter = new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
                if (!this.mBTHeadsetReceiver.getRegistered()) {
                    context.registerReceiver(this.mBTHeadsetReceiver, intentFilter);
                    this.mBTHeadsetReceiver.setRegistered(true);
                    return;
                }
                return;
            }
            Logging.e(TAG, "initialize: failed to get bluetooth adapter!!");
        } catch (Exception e10) {
            Logging.e(TAG, "unable to create BluetoothHeadsetBroadcastReceiver, err:" + e10.getMessage());
        }
    }

    private void initHeadsetBroadcastReceiver(Context context) {
        if (this.mHeadsetReceiver == null) {
            this.mHeadsetReceiver = new HeadsetBroadcastReceiver();
        }
        if (!this.mHeadsetReceiver.getRegistered()) {
            Intent registerReceiver = context.registerReceiver(this.mHeadsetReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            if (registerReceiver != null && TextUtils.equals(registerReceiver.getAction(), "android.intent.action.HEADSET_PLUG")) {
                processHeadsetIntent(registerReceiver);
            }
            this.mHeadsetReceiver.setRegistered(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioDeviceChanged(int i10, boolean z10) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("onAudioDeviceChanged route :");
        sb.append(i10);
        sb.append(" status: ");
        if (z10) {
            str = "connect";
        } else {
            str = "disconnect";
        }
        sb.append(str);
        Logging.i(TAG, sb.toString());
        AudioRoutingController.AudioDeviceChangedCallback audioDeviceChangedCallback = this.mAudioDeviceChangedCb;
        if (audioDeviceChangedCallback != null) {
            audioDeviceChangedCallback.onAudioDeviceChanged(i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioDeviceEvent(int i10) {
        AudioRoutingController.AudioDeviceChangedCallback audioDeviceChangedCallback = this.mAudioDeviceChangedCb;
        if (audioDeviceChangedCallback != null) {
            audioDeviceChangedCallback.onAudioDeviceEvent(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBluetoothIntent(Intent intent) {
        String action = intent.getAction();
        try {
            String str = "null name";
            if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -99);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null) {
                    str = bluetoothDevice.getName();
                }
                Logging.d(TAG, "BT " + str + " hfp connect state : " + intExtra2 + ", " + intExtra);
                if (intExtra != 0) {
                    if (intExtra != 2) {
                        Logging.i(TAG, bluetoothDevice + " unknown event, state=" + intExtra);
                        return;
                    }
                    Logging.i(TAG, "Bluetooth device " + bluetoothDevice + " connected");
                    onAudioDeviceChanged(3, true);
                    return;
                }
                Logging.i(TAG, "Bluetooth device " + bluetoothDevice + " disconnected");
                if (getBtConnectedDevicesSize() == 0) {
                    onAudioDeviceChanged(3, false);
                    return;
                } else {
                    onAudioDeviceEvent(1);
                    return;
                }
            }
            if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -99);
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice2 != null) {
                    str = bluetoothDevice2.getName();
                }
                Logging.i(TAG, "BT " + str + " audio state: " + intExtra4 + "," + intExtra3);
                if (intExtra3 != 10) {
                    if (intExtra3 != 12) {
                        Logging.i(TAG, bluetoothDevice2 + " audio state event, state=" + intExtra3);
                        return;
                    }
                    Logging.i(TAG, "Bluetooth " + bluetoothDevice2 + " audio state connected");
                    return;
                }
                Logging.i(TAG, "Bluetooth " + bluetoothDevice2 + " audio state disconnected");
                return;
            }
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra5 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -99);
                Logging.d(TAG, "BluetoothAdapter.ACTION_STATE_CHANGED prev " + intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -99) + ", " + intExtra5);
                if (intExtra5 == 10) {
                    onAudioDeviceChanged(3, false);
                    onAudioDeviceChanged(4, false);
                    return;
                }
                return;
            }
            if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                int intExtra6 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -99);
                int intExtra7 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -99);
                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice3 != null) {
                    str = bluetoothDevice3.getName();
                }
                Logging.i(TAG, "BT a2dp " + str + " audio state: " + intExtra7 + "," + intExtra6);
                if (intExtra6 != 0) {
                    if (intExtra6 != 2) {
                        Logging.i(TAG, "Receive a2dp Event Bluetooth device " + bluetoothDevice3 + " unknown event, state=" + intExtra6);
                        return;
                    }
                    onAudioDeviceChanged(4, true);
                    return;
                }
                onAudioDeviceChanged(4, false);
            }
        } catch (Exception e10) {
            Logging.e(TAG, "BT broadcast receiver onReceive fail ", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processHeadsetIntent(Intent intent) {
        int i10;
        int intExtra = intent.getIntExtra("state", -1);
        int intExtra2 = intent.getIntExtra("microphone", -1);
        if (intExtra == 1) {
            if (intExtra2 == 1) {
                i10 = 0;
            } else {
                i10 = 2;
            }
            this.mHeadsetType = i10;
        }
        if (intExtra != 1) {
            return false;
        }
        return true;
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public void dispose() {
        try {
            clearBTResource();
            Context context = this.mContext.get();
            if (context != null) {
                HeadsetBroadcastReceiver headsetBroadcastReceiver = this.mHeadsetReceiver;
                if (headsetBroadcastReceiver != null && headsetBroadcastReceiver.getRegistered()) {
                    context.unregisterReceiver(this.mHeadsetReceiver);
                    this.mHeadsetReceiver.setRegistered(false);
                }
                BTHeadsetBroadcastReceiver bTHeadsetBroadcastReceiver = this.mBTHeadsetReceiver;
                if (bTHeadsetBroadcastReceiver != null && bTHeadsetBroadcastReceiver.getRegistered()) {
                    context.unregisterReceiver(this.mBTHeadsetReceiver);
                    this.mBTHeadsetReceiver.setRegistered(false);
                }
            }
            this.mHeadsetReceiver = null;
            this.mBTHeadsetReceiver = null;
        } catch (Exception e10) {
            Logging.e(TAG, "AudioRoutingController dispose fail: ", e10);
        }
    }

    protected boolean hasPermission(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public void initialize() {
        Context context = this.mContext.get();
        Logging.i(TAG, "AudioDeviceInventoryLowerThanM initialize +");
        initHeadsetBroadcastReceiver(context);
        initBtBroadcastReceiver(context);
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public boolean isDeviceAvaliable(int i10) {
        if (i10 == 3) {
            BluetoothAdapter bluetoothAdapter = this.mBTAdapter;
            if (bluetoothAdapter != null && 2 == bluetoothAdapter.getProfileConnectionState(1)) {
                return true;
            }
        } else {
            if (i10 == 4) {
                return this.mAm.isBluetoothA2dpOn();
            }
            if (i10 == 2 || i10 == 1) {
                return this.mAm.isWiredHeadsetOn();
            }
        }
        return false;
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public void setAudioDeviceChangeCallback(AudioRoutingController.AudioDeviceChangedCallback audioDeviceChangedCallback) {
        this.mAudioDeviceChangedCb = audioDeviceChangedCallback;
    }
}
