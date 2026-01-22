package io.agora.rtc.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import com.facebook.internal.AnalyticsEvents;
import com.luck.picture.lib.config.PictureMimeType;
import io.agora.rtc.Constants;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AudioRoutingController {
    private static final int BLUETOOTH = 5;
    private static final int BLUETOOTH_RESET_BT_DELAY = 3000;
    private static final int BLUETOOTH_SCO_TIMEOUT_MS = 3000;
    public static final int CMD_DEFAULT_DEVICE = 10;
    public static final int CMD_FORCE_TO_SPEAKER = 11;
    public static final int CMD_MUTE_VIDEO_ALL = 14;
    public static final int CMD_MUTE_VIDEO_LOCAL = 12;
    public static final int CMD_MUTE_VIDEO_REMOTES = 13;
    public static final int DEVICE_BLUETOOTH_A2DP = 4;
    public static final int DEVICE_BLUETOOTH_SCO = 3;
    public static final int DEVICE_EVT_BT_OFF = 0;
    public static final int DEVICE_EVT_BT_RECONNECT = 1;
    public static final int DEVICE_HEADPHONE = 2;
    public static final int DEVICE_HEADSET = 1;
    public static final int DEVICE_USB_HEADSET = 5;
    private static final int EARPIECE = 1;
    public static final int EVT_AUDIO_ADM_ROUTING_UPDATE = 114;
    private static final int EVT_BT_HEADSET_A2DP = 2;
    private static final int EVT_BT_HEADSET_HFP = 4;
    private static final int EVT_BT_SCO = 3;
    private static final int EVT_HEADSET = 1;
    public static final int EVT_PHONE_STATE_CHANGED = 22;
    public static final int EVT_USING_COMM_PARAMETERS = 112;
    public static final int EVT_USING_NORM_PARAMETERS = 113;
    private static final int FEATURE_BYPASS_A2DP_N = 1;
    private static final int FEATURE_BYPASS_A2DP_Y = 0;
    private static final int FEATURE_ROUTING_V_BELOW_M = 2;
    private static final int FEATURE_ROUTING_V_HIGHER_M = 3;
    private static final int HEADSET = 0;
    private static final int MAX_SCO_CONNECT_ATTEMPS = 3;
    public static final int OFF = 0;
    public static final int ON = 1;
    private static final SparseIntArray ROUTE_TYPE_TO_EVT;
    private static final int SPEAKER = 3;
    private static final int STOP = 4;
    private static final String TAG = "AudioRoute";
    public static final int UNSET = -1;
    AudioManager am;
    private AudioDeviceInventory mAudioDeviceInventory;
    private AudioDeviceList mAvailDevices;
    private WeakReference<Context> mContext;
    private EventHandler mEventHandler;
    private WeakReference<AudioRoutingListener> mListener;
    private int mScoConnectionAttemps;
    private AudioRouteState mState;
    private int mVersionInUsed;
    private StopState mStopState = null;
    private SpeakerState mSpeakerState = null;
    private EarpieceState mEarpieceState = null;
    private BTState mBTState = null;
    private HeadsetState mHeadsetState = null;
    private int mTargetRoute = -1;
    private boolean mIsBTHeadsetPlugged = false;
    private boolean mVideoDisabled = true;
    private boolean mMuteLocal = false;
    private boolean mMuteRemotes = false;
    private boolean mPhoneInCall = false;
    private boolean mHfpEnable = false;
    private boolean mA2dpEnable = false;
    private boolean mA2dpEventBypass = false;
    AudioManagerScoStateReceiver mScoStateReceiver = null;
    private int mStreamType = 0;
    private int mChannelProfile = 1;
    private int dynamic_timeout = 0;
    private int mLastNotifiedRouting = -1;
    private int mHfpDeviceId = -1;
    private final Runnable TryConnectBtScoRunnable = new Runnable() { // from class: io.agora.rtc.internal.AudioRoutingController.1
        @Override // java.lang.Runnable
        public void run() {
            AudioRoutingController.this.tryToConnectBtSco();
        }
    };
    private final Runnable TrytoResetBTRunnable = new Runnable() { // from class: io.agora.rtc.internal.AudioRoutingController.2
        @Override // java.lang.Runnable
        public void run() {
            if (!AudioRoutingController.this.am.isBluetoothA2dpOn() && !AudioRoutingController.this.am.isBluetoothScoOn()) {
                Logging.d(AudioRoutingController.TAG, "bluetooth routing start failed a2dp:false sco:false");
                if (AudioRoutingController.this.mListener.get() != null) {
                    ((AudioRoutingListener) AudioRoutingController.this.mListener.get()).onAudioRoutingError(Constants.ERR_AUDIO_BT_NO_ROUTE);
                }
            }
        }
    };

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface AudioDeviceChangedCallback {
        void onAudioDeviceChanged(int i10, boolean z10);

        void onAudioDeviceEvent(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class AudioDeviceChangedCallbackImpl implements AudioDeviceChangedCallback {
        private AudioDeviceChangedCallbackImpl() {
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceChangedCallback
        public void onAudioDeviceChanged(int i10, boolean z10) {
            int i11 = -1;
            if (i10 != 1) {
                if (i10 != 2) {
                    int i12 = 500;
                    if (i10 != 3) {
                        if (i10 != 4) {
                            Logging.i(AudioRoutingController.TAG, "not handle device: " + i10 + " connect: " + z10);
                            return;
                        }
                        if (AudioRoutingController.this.mA2dpEventBypass) {
                            Logging.w(AudioRoutingController.TAG, "dont handle a2dp event !");
                            return;
                        }
                        if (z10) {
                            i12 = 1000;
                        }
                        AudioRoutingController.this.sendBtEventDelay(2, z10 ? 1 : 0, -1, i12);
                        return;
                    }
                    if (z10) {
                        i12 = 1000;
                    }
                    AudioRoutingController.this.sendBtEventDelay(4, z10 ? 1 : 0, -1, i12);
                    return;
                }
                if (z10) {
                    i11 = 2;
                }
                AudioRoutingController.this.sendEvent(1, i11);
                return;
            }
            if (z10) {
                i11 = 0;
            }
            AudioRoutingController.this.sendEvent(1, i11);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceChangedCallback
        public void onAudioDeviceEvent(int i10) {
            if (i10 == 0) {
                AudioRoutingController.this.cancelTimer();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface AudioDeviceInventory {
        void dispose();

        void initialize();

        boolean isDeviceAvaliable(int i10);

        void setAudioDeviceChangeCallback(AudioDeviceChangedCallback audioDeviceChangedCallback);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class AudioDeviceList {
        public int mBTRoute;
        public int mDefaultRoute;
        public int mForcedRoute;
        public int mHeadSetRoute;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class AudioManagerScoStateReceiver extends BroadcastReceiver {
        private boolean isRegistered;

        private AudioManagerScoStateReceiver() {
            this.isRegistered = false;
        }

        public boolean getRegistered() {
            return this.isRegistered;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -99);
                Logging.i(AudioRoutingController.TAG, "BT ACTION_SCO_AUDIO_STATE_UPDATED prev " + intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -99) + "," + intExtra);
                if (intExtra != -1) {
                    if (intExtra != 0) {
                        if (intExtra != 1) {
                            if (intExtra != 2) {
                                Logging.i(AudioRoutingController.TAG, "Bluetooth SCO device unknown event, state=" + intExtra);
                                return;
                            }
                            Logging.i(AudioRoutingController.TAG, "Bluetooth SCO state connecting");
                            return;
                        }
                        Logging.i(AudioRoutingController.TAG, "Bluetooth SCO state connected");
                        AudioRoutingController.this.sendEvent(3, 1);
                        return;
                    }
                    Logging.i(AudioRoutingController.TAG, "Bluetooth SCO state disconnected");
                    AudioRoutingController.this.sendEvent(3, 0);
                    return;
                }
                Logging.i(AudioRoutingController.TAG, "Bluetooth SCO state error");
            }
        }

        public void setRegistered(boolean z10) {
            this.isRegistered = z10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private abstract class AudioRouteBaseState implements AudioRouteState {
        private AudioRouteBaseState() {
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugInProcess(int i10, int i11, int i12) {
            AudioRoutingController.this.notifyAudioBtProfileChanged();
            AudioRoutingController.this.changeAvailDevices(i10, i11);
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            if (4 != i10) {
                i12 = audioRoutingController.mHfpDeviceId;
            }
            audioRoutingController.mHfpDeviceId = i12;
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT plugin event mA2dpEnable= " + AudioRoutingController.this.mA2dpEnable);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugOutProcess(int i10, int i11, int i12) {
            AudioRoutingController.this.updateAudioBtProfileState();
            AudioRoutingController.this.changeAvailDevices(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT plugout event mA2dpEnable= " + AudioRoutingController.this.mA2dpEnable);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoConnectProcess(int i10, int i11) {
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT SCO Connect event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoDisConnectProcess(int i10, int i11) {
            if (AudioRoutingController.this.getBtDeviceList() > 0) {
                AudioRoutingController.this.mAvailDevices.mBTRoute = 5;
            } else {
                AudioRoutingController.this.mAvailDevices.mBTRoute = -1;
            }
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process BT SCO Disconnect, bt route: " + AudioRoutingController.this.mAvailDevices.mBTRoute);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void commStreamEvtProcess(int i10, int i11) {
            AudioRoutingController.this.mStreamType = 0;
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process Communication stream event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceEarpieceProcess(int i10, int i11) {
            AudioRoutingController.this.changeAvailDevices(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process ForceEarpiece event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceSpkProcess(int i10, int i11) {
            AudioRoutingController.this.changeAvailDevices(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process ForceSpeaker event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugInProcess(int i10, int i11) {
            AudioRoutingController.this.changeAvailDevices(i10, i11);
            StringBuilder sb = new StringBuilder();
            sb.append("Process HeadSet plugin event at AudioRouteBaseState mAvailDevices.mHeadSetRoute = ");
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            sb.append(audioRoutingController.getAudioRouteDesc(audioRoutingController.mAvailDevices.mHeadSetRoute));
            Logging.i(AudioRoutingController.TAG, sb.toString());
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugOutProcess(int i10, int i11) {
            AudioRoutingController.this.changeAvailDevices(i10, i11);
            StringBuilder sb = new StringBuilder();
            sb.append("Process HeadSet plugout event at AudioRouteBaseState mAvailDevices.mHeadSetRoute = ");
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            sb.append(audioRoutingController.getAudioRouteDesc(audioRoutingController.mAvailDevices.mHeadSetRoute));
            Logging.i(AudioRoutingController.TAG, sb.toString());
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void musicStreamEvtProcess(int i10, int i11) {
            AudioRoutingController.this.mStreamType = 3;
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process Music stream event");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void phoneChangeEvtProcess(int i10, int i11) {
            boolean z10;
            AudioRoutingController audioRoutingController = AudioRoutingController.this;
            if (i11 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            audioRoutingController.mPhoneInCall = z10;
            AudioRoutingController.this.checkAndUpdateRouteAfterCall();
            Logging.i(AudioRoutingController.TAG, "At AudioRouteBaseState Process Phone state change event " + i11);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void switchtoTargetRoute() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface AudioRouteState {
        void btPlugInProcess(int i10, int i11, int i12);

        void btPlugOutProcess(int i10, int i11, int i12);

        void btScoConnectProcess(int i10, int i11);

        void btScoDisConnectProcess(int i10, int i11);

        void commStreamEvtProcess(int i10, int i11);

        void forceEarpieceProcess(int i10, int i11);

        void forceSpkProcess(int i10, int i11);

        void headSetPlugInProcess(int i10, int i11);

        void headSetPlugOutProcess(int i10, int i11);

        void musicStreamEvtProcess(int i10, int i11);

        void phoneChangeEvtProcess(int i10, int i11);

        void switchtoTargetRoute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class BTState extends AudioRouteBaseState {
        private BTState() {
            super();
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugInProcess(int i10, int i11, int i12) {
            super.btPlugInProcess(i10, i11, i12);
            Logging.i(AudioRoutingController.TAG, "At BTState Process bt plug in event " + i10);
            if (!AudioRoutingController.this.mPhoneInCall) {
                AudioRoutingController.this.notifyAudioRoutingChanged(5);
                if (4 == i10 && AudioRoutingController.this.mStreamType == 0) {
                    Logging.i(AudioRoutingController.TAG, "At BTState Process bt plug in process reconnect sco!");
                    AudioRoutingController.this.resetBtSco();
                }
            }
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugOutProcess(int i10, int i11, int i12) {
            super.btPlugOutProcess(i10, i11, i12);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At BTState Process bt plug out, mStreamType " + AudioRoutingController.this.mStreamType + " event " + i10 + " deviceId " + i12 + " mHfpDeviceId " + AudioRoutingController.this.mHfpDeviceId);
            if (AudioRoutingController.this.getBtDeviceList() <= 0) {
                AudioRoutingController.this.cancelTimer();
                AudioRoutingController.this.disableBtSco();
            } else {
                Logging.i(AudioRoutingController.TAG, "At BTState Process bt plug out but still has other headset!");
                if (i10 == 4 && AudioRoutingController.this.mHfpEnable) {
                    AudioRoutingController.this.resetBtSco();
                    return;
                }
                if (AudioRoutingController.this.sysRouteToBt() && AudioRoutingController.this.am.isBluetoothA2dpOn()) {
                    AudioRoutingController.this.changeState(5);
                    AudioRoutingController.this.notifyAudioRoutingChanged(5);
                    return;
                } else {
                    Logging.i(AudioRoutingController.TAG, "At BTState Process bt plug out but route error!");
                    AudioRoutingController.this.cancelTimer();
                    AudioRoutingController.this.disableBtSco();
                    if (AudioRoutingController.this.mListener.get() != null) {
                        ((AudioRoutingListener) AudioRoutingController.this.mListener.get()).onAudioRoutingError(Constants.ERR_AUDIO_BT_NO_ROUTE);
                    }
                }
            }
            if (AudioRoutingController.this.mAvailDevices.mHeadSetRoute != -1) {
                AudioRoutingController.this.changeState(0);
                return;
            }
            if (AudioRoutingController.this.mAvailDevices.mForcedRoute != -1) {
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.changeState(audioRoutingController.mAvailDevices.mForcedRoute);
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At BTState Process btPlugOutProcess default device:" + AudioRoutingController.this.mAvailDevices.mDefaultRoute);
            AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
            audioRoutingController2.changeState(audioRoutingController2.mAvailDevices.mDefaultRoute);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoConnectProcess(int i10, int i11) {
            super.btScoConnectProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            try {
                AudioRoutingController.this.am.setSpeakerphoneOn(false);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            Logging.i(AudioRoutingController.TAG, "At BTState Process SCO Connect,Nothing todo since already in BT State");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoDisConnectProcess(int i10, int i11) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process BT SCO DisConnect");
            super.btScoDisConnectProcess(i10, i11);
            if (AudioRoutingController.this.mStreamType == 0) {
                AudioRoutingController.this.rescheTimer();
            }
            boolean unused = AudioRoutingController.this.mPhoneInCall;
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void commStreamEvtProcess(int i10, int i11) {
            super.commStreamEvtProcess(i10, i11);
            AudioRoutingController.this.enableBtSco();
            AudioRoutingController.this.startTimer();
            Logging.i(AudioRoutingController.TAG, "At BTState Process CommStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceEarpieceProcess(int i10, int i11) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process Cannot Support ForceEarpiece event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceSpkProcess(int i10, int i11) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process Cannot Support ForceSpeaker event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugInProcess(int i10, int i11) {
            Logging.i(AudioRoutingController.TAG, "At BTState Process HeadSet connect event param = " + i11);
            super.headSetPlugInProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            if (AudioRoutingController.this.mStreamType == 0) {
                AudioRoutingController.this.disableBtSco();
            }
            AudioRoutingController.this.changeState(0);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugOutProcess(int i10, int i11) {
            super.headSetPlugOutProcess(i10, i11);
            AudioRoutingController.this.am.setSpeakerphoneOn(false);
            Logging.i(AudioRoutingController.TAG, "At BTState Process HeadSet disconnect,Nothting need todo ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void musicStreamEvtProcess(int i10, int i11) {
            super.musicStreamEvtProcess(i10, i11);
            AudioRoutingController.this.cancelTimer();
            AudioRoutingController.this.disableBtSco();
            Logging.i(AudioRoutingController.TAG, "At BTState Process MusicStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void switchtoTargetRoute() {
            if (5 != AudioRoutingController.this.mTargetRoute) {
                AudioRoutingController.this.mTargetRoute = 5;
                AudioRoutingController.this.muteAudioStream(false);
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.notifyAudioRoutingChanged(audioRoutingController.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At BT State switchtoTargetRoute:  ");
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                sb.append(audioRoutingController2.getAudioRouteDesc(audioRoutingController2.mTargetRoute));
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class EarpieceState extends AudioRouteBaseState {
        private EarpieceState() {
            super();
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugInProcess(int i10, int i11, int i12) {
            super.btPlugInProcess(i10, i11, i12);
            if (!AudioRoutingController.this.mPhoneInCall) {
                AudioRoutingController.this.changeState(5);
                Logging.i(AudioRoutingController.TAG, "At EarpieceState Process BT connect event");
            }
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoConnectProcess(int i10, int i11) {
            if (AudioRoutingController.this.am == null) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At Earpiece Process SCO connect event,Nothing to-do");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void commStreamEvtProcess(int i10, int i11) {
            super.commStreamEvtProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At EarpieceState Process CommStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceSpkProcess(int i10, int i11) {
            if (AudioRoutingController.this.am == null) {
                return;
            }
            super.forceSpkProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At EarpieceState Process ForceSpeaker event param =  " + i11);
            if (!AudioRoutingController.this.isSpeakerEnable()) {
                AudioRoutingController.this.am.setSpeakerphoneOn(true);
                AudioRoutingController.this.changeState(3);
            }
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugInProcess(int i10, int i11) {
            super.headSetPlugInProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            AudioRoutingController.this.muteAudioStream(true);
            Logging.i(AudioRoutingController.TAG, "At EarpieceState Process HeadSet connect event param = " + i11);
            AudioRoutingController.this.changeState(0);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void musicStreamEvtProcess(int i10, int i11) {
            super.musicStreamEvtProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At EarpieceState Process MusicStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void switchtoTargetRoute() {
            if (1 != AudioRoutingController.this.mTargetRoute) {
                AudioRoutingController.this.mTargetRoute = 1;
                AudioRoutingController.this.am.setSpeakerphoneOn(false);
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.notifyAudioRoutingChanged(audioRoutingController.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At Earpiece State switchtoTargetRoute: ");
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                sb.append(audioRoutingController2.getAudioRouteDesc(audioRoutingController2.mTargetRoute));
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class EventHandler extends Handler {
        public EventHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            int i11 = message.arg1;
            if (AudioRoutingController.this.mState == null) {
                Logging.e(AudioRoutingController.TAG, "dont handle evt " + i10 + " in error state!");
                return;
            }
            boolean z10 = true;
            try {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                if (i10 != 22) {
                                    switch (i10) {
                                        case 11:
                                            if (i11 == 0) {
                                                AudioRoutingController.this.mState.forceEarpieceProcess(i10, i11);
                                                break;
                                            } else {
                                                AudioRoutingController.this.mState.forceSpkProcess(i10, i11);
                                                break;
                                            }
                                        case 12:
                                            AudioRoutingController audioRoutingController = AudioRoutingController.this;
                                            if (i11 <= 0) {
                                                z10 = false;
                                            }
                                            audioRoutingController.mMuteLocal = z10;
                                            break;
                                        case 13:
                                            AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                                            if (i11 <= 0) {
                                                z10 = false;
                                            }
                                            audioRoutingController2.mMuteRemotes = z10;
                                            break;
                                        case 14:
                                            AudioRoutingController audioRoutingController3 = AudioRoutingController.this;
                                            if (i11 <= 0) {
                                                z10 = false;
                                            }
                                            audioRoutingController3.mVideoDisabled = z10;
                                            break;
                                        default:
                                            switch (i10) {
                                                case 112:
                                                    AudioRoutingController.this.mState.commStreamEvtProcess(i10, i11);
                                                    break;
                                                case 113:
                                                    AudioRoutingController.this.mState.musicStreamEvtProcess(i10, i11);
                                                    break;
                                                case 114:
                                                    AudioRoutingController.this.changeState(i11);
                                                    break;
                                                default:
                                                    return;
                                            }
                                    }
                                } else {
                                    AudioRoutingController.this.mState.phoneChangeEvtProcess(i10, i11);
                                }
                            }
                        } else if (i11 == 1) {
                            AudioRoutingController.this.mState.btScoConnectProcess(i10, i11);
                        } else {
                            AudioRoutingController.this.mState.btScoDisConnectProcess(i10, i11);
                        }
                    }
                    int i12 = message.arg2;
                    if (i11 == 1) {
                        AudioRoutingController.this.mState.btPlugInProcess(i10, i11, i12);
                    } else {
                        AudioRoutingController.this.mState.btPlugOutProcess(i10, i11, i12);
                    }
                } else if (i11 >= 0) {
                    AudioRoutingController.this.mState.headSetPlugInProcess(i10, i11);
                } else {
                    AudioRoutingController.this.mState.headSetPlugOutProcess(i10, i11);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class HeadsetState extends AudioRouteBaseState {
        private HeadsetState() {
            super();
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugInProcess(int i10, int i11, int i12) {
            super.btPlugInProcess(i10, i11, i12);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At HeadSet bt PlugInProcess sco:" + AudioRoutingController.this.am.isBluetoothScoOn() + " a2dp:" + AudioRoutingController.this.am.isBluetoothA2dpOn());
            AudioRoutingController.this.changeState(5);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugOutProcess(int i10, int i11, int i12) {
            super.btPlugOutProcess(i10, i11, i12);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoConnectProcess(int i10, int i11) {
            super.btScoConnectProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At HeadSet btScoConnectProcess Nothing to-do");
            AudioRoutingController.this.changeState(5);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoDisConnectProcess(int i10, int i11) {
            super.btScoDisConnectProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At HeadSet btScoDisConnectProcess Nothing to-do");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void commStreamEvtProcess(int i10, int i11) {
            super.commStreamEvtProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At HeadSetState Process CommStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceEarpieceProcess(int i10, int i11) {
            Logging.i(AudioRoutingController.TAG, "At HeadState Process Cannot Support ForceEarpiece event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceSpkProcess(int i10, int i11) {
            Logging.i(AudioRoutingController.TAG, "At HeadState Process Cannot Support ForceSpeaker event ");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugInProcess(int i10, int i11) {
            super.headSetPlugInProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At HeadSet Process HeadSet connect event param = " + i11);
            AudioRoutingController.this.changeState(0);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugOutProcess(int i10, int i11) {
            super.headSetPlugOutProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At HeadSet headSetPlugOutProcess sco:" + AudioRoutingController.this.am.isBluetoothScoOn() + " a2dp:" + AudioRoutingController.this.am.isBluetoothA2dpOn());
            if (AudioRoutingController.this.getBtDeviceList() > 0) {
                AudioRoutingController.this.changeState(5);
            } else if (AudioRoutingController.this.mAvailDevices.mForcedRoute != -1) {
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.changeState(audioRoutingController.mAvailDevices.mForcedRoute);
            } else {
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                audioRoutingController2.changeState(audioRoutingController2.mAvailDevices.mDefaultRoute);
            }
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void musicStreamEvtProcess(int i10, int i11) {
            super.musicStreamEvtProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At HeadSetState Process MusicStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void switchtoTargetRoute() {
            if (AudioRoutingController.this.mTargetRoute != AudioRoutingController.this.mAvailDevices.mHeadSetRoute) {
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.mTargetRoute = audioRoutingController.mAvailDevices.mHeadSetRoute;
                AudioRoutingController.this.am.setSpeakerphoneOn(false);
                AudioRoutingController.this.muteAudioStream(false);
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                audioRoutingController2.notifyAudioRoutingChanged(audioRoutingController2.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At HeadSet State switchtoTargetRoute:  ");
                AudioRoutingController audioRoutingController3 = AudioRoutingController.this;
                sb.append(audioRoutingController3.getAudioRouteDesc(audioRoutingController3.mTargetRoute));
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class SpeakerState extends AudioRouteBaseState {
        private SpeakerState() {
            super();
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btPlugInProcess(int i10, int i11, int i12) {
            if (AudioRoutingController.this.am == null) {
                return;
            }
            super.btPlugInProcess(i10, i11, i12);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process BT connect event");
            AudioRoutingController.this.changeState(5);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void btScoConnectProcess(int i10, int i11) {
            if (AudioRoutingController.this.am == null) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process SCO connect event,Nothing to-do");
            AudioRoutingController.this.changeState(5);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void commStreamEvtProcess(int i10, int i11) {
            super.commStreamEvtProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process CommStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceEarpieceProcess(int i10, int i11) {
            if (AudioRoutingController.this.am == null) {
                return;
            }
            super.forceEarpieceProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process ForceEarpiece event param =  " + i11);
            AudioRoutingController.this.changeState(1);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void forceSpkProcess(int i10, int i11) {
            if (AudioRoutingController.this.am == null) {
                return;
            }
            super.forceSpkProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process ForceSpeaker event param =  " + i11);
            if (!AudioRoutingController.this.isSpeakerEnable()) {
                Logging.i(AudioRoutingController.TAG, "At SpeakerState Process audio mode =  " + AudioRoutingController.this.am.getMode());
                AudioRoutingController.this.am.setSpeakerphoneOn(true);
                AudioRoutingController.this.changeState(3);
            }
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void headSetPlugInProcess(int i10, int i11) {
            super.headSetPlugInProcess(i10, i11);
            if (AudioRoutingController.this.mPhoneInCall) {
                return;
            }
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process HeadSet connect event param = " + i11);
            AudioRoutingController.this.changeState(0);
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void musicStreamEvtProcess(int i10, int i11) {
            super.musicStreamEvtProcess(i10, i11);
            Logging.i(AudioRoutingController.TAG, "At SpeakerState Process MusicStream");
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void switchtoTargetRoute() {
            if (AudioRoutingController.this.mTargetRoute != 3) {
                AudioRoutingController.this.mTargetRoute = 3;
                AudioRoutingController.this.am.setSpeakerphoneOn(true);
                AudioRoutingController audioRoutingController = AudioRoutingController.this;
                audioRoutingController.notifyAudioRoutingChanged(audioRoutingController.mTargetRoute);
                StringBuilder sb = new StringBuilder();
                sb.append("At Speaker State switchtoTargetRoute: ");
                AudioRoutingController audioRoutingController2 = AudioRoutingController.this;
                sb.append(audioRoutingController2.getAudioRouteDesc(audioRoutingController2.mTargetRoute));
                Logging.i(AudioRoutingController.TAG, sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class StopState extends AudioRouteBaseState {
        private StopState() {
            super();
        }

        @Override // io.agora.rtc.internal.AudioRoutingController.AudioRouteBaseState, io.agora.rtc.internal.AudioRoutingController.AudioRouteState
        public void switchtoTargetRoute() {
            int i10;
            int i11;
            Logging.i(AudioRoutingController.TAG, "Coming to Stop state, switchtoTargetRoute");
            AudioRoutingController.this.cancelTimer();
            AudioRoutingController.this.disableBtSco();
            AudioDeviceList audioDeviceList = AudioRoutingController.this.mAvailDevices;
            if (AudioRoutingController.this.getBtDeviceList() > 0) {
                i10 = 5;
            } else {
                i10 = -1;
            }
            audioDeviceList.mBTRoute = i10;
            AudioDeviceList audioDeviceList2 = AudioRoutingController.this.mAvailDevices;
            if (AudioRoutingController.this.isHeadSetConnected()) {
                i11 = 0;
            } else {
                i11 = -1;
            }
            audioDeviceList2.mHeadSetRoute = i11;
            AudioRoutingController.this.mAvailDevices.mDefaultRoute = -1;
            AudioRoutingController.this.mAvailDevices.mForcedRoute = -1;
            AudioRoutingController.this.mTargetRoute = -1;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ROUTE_TYPE_TO_EVT = sparseIntArray;
        sparseIntArray.put(1, 1);
        sparseIntArray.put(2, 1);
        sparseIntArray.put(3, 4);
        sparseIntArray.put(4, 2);
    }

    public AudioRoutingController(Context context, AudioRoutingListener audioRoutingListener) {
        this.am = null;
        this.mContext = new WeakReference<>(context);
        this.mListener = new WeakReference<>(audioRoutingListener);
        this.am = getAudioManager();
        this.mVersionInUsed = Build.VERSION.SDK_INT >= 31 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTimer() {
        Logging.i(TAG, "cancel bluetooth timer");
        this.dynamic_timeout = 0;
        this.mScoConnectionAttemps = 0;
        this.mEventHandler.removeCallbacks(this.TryConnectBtScoRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeState(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            Logging.d(TAG, "--------------------Comming to UNKNOWN STATE----------- ");
                            if (this.mSpeakerState == null) {
                                this.mSpeakerState = new SpeakerState();
                            }
                            this.mState = this.mSpeakerState;
                        } else {
                            if (this.mBTState == null) {
                                this.mBTState = new BTState();
                            }
                            this.mState = this.mBTState;
                            Logging.d(TAG, "--------------------Comming to BLUETOOTH--------------- ");
                        }
                    } else {
                        if (this.mStopState == null) {
                            this.mStopState = new StopState();
                        }
                        this.mState = this.mStopState;
                        Logging.d(TAG, "--------------------Comming to STOP-------------------- ");
                    }
                } else {
                    if (this.mSpeakerState == null) {
                        this.mSpeakerState = new SpeakerState();
                    }
                    this.mState = this.mSpeakerState;
                    Logging.d(TAG, "--------------------Comming to SPEAKER----------------- ");
                }
            } else {
                if (this.mEarpieceState == null) {
                    this.mEarpieceState = new EarpieceState();
                }
                this.mState = this.mEarpieceState;
                Logging.d(TAG, "--------------------Comming to EARPIECE---------------- ");
            }
        } else {
            if (this.mHeadsetState == null) {
                this.mHeadsetState = new HeadsetState();
            }
            this.mState = this.mHeadsetState;
            Logging.d(TAG, "--------------------Comming to HEADSET----------------- ");
        }
        try {
            this.mState.switchtoTargetRoute();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndUpdateRouteAfterCall() {
        int targetRouteByPriority;
        if (!this.mPhoneInCall && (targetRouteByPriority = setTargetRouteByPriority()) != this.mTargetRoute) {
            Logging.i(TAG, "after call, sys route is different from sdk route, update to " + targetRouteByPriority);
            sendEvent(114, targetRouteByPriority);
        }
    }

    private void checkFallbackA2dpIfNeed() {
        AudioRoutingListener audioRoutingListener;
        if (this.mA2dpEnable && (audioRoutingListener = this.mListener.get()) != null) {
            audioRoutingListener.onAudioBtProfileChanged(2);
            notifyAudioRoutingChanged(5);
            checkNeedResetBT();
            Logging.i(TAG, "set A2DP profile only to fallback !");
        }
    }

    private void checkNeedResetBT() {
        this.mEventHandler.postDelayed(this.TrytoResetBTRunnable, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableBtSco() {
        try {
            this.am.stopBluetoothSco();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableBtSco() {
        try {
            this.am.startBluetoothSco();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private AudioManager getAudioManager() {
        Context context = this.mContext.get();
        if (context == null) {
            return null;
        }
        return (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAudioRouteDesc(int i10) {
        switch (i10) {
            case -1:
                return "UNSET";
            case 0:
                return "Headset";
            case 1:
                return "Earpiece";
            case 2:
                return "HeadsetOnly";
            case 3:
                return "Speakerphone";
            case 4:
                return "Loudspeaker";
            case 5:
                return "HeadsetBluetooth";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public int getBtDeviceList() {
        this.mA2dpEnable = this.mAudioDeviceInventory.isDeviceAvaliable(4);
        boolean isDeviceAvaliable = this.mAudioDeviceInventory.isDeviceAvaliable(3);
        this.mHfpEnable = isDeviceAvaliable;
        ?? r02 = isDeviceAvaliable;
        if (!this.mA2dpEventBypass) {
            if (!isDeviceAvaliable && !this.mA2dpEnable) {
                r02 = 0;
            } else {
                r02 = 1;
            }
        }
        Logging.i(TAG, "System bluetooth state:  hfp " + this.mHfpEnable + " a2dp " + this.mA2dpEnable);
        return r02;
    }

    private String getEventDesc(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 11) {
                            if (i10 != 112) {
                                if (i10 != 113) {
                                    return "unkown event";
                                }
                                return "music stream event";
                            }
                            return "communication stream event";
                        }
                        return "set forcespeakerphone event";
                    }
                    return "bt hfp connect/disconnect event";
                }
                return "sco connect/disconnect event";
            }
            return "bt a2dp connect/disconnect event";
        }
        return "headset connect/disconnect event";
    }

    private boolean isAudioOnly() {
        if (!this.mVideoDisabled && (!this.mMuteLocal || !this.mMuteRemotes)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeadSetConnected() {
        AudioManager audioManager = this.am;
        if (audioManager == null) {
            return false;
        }
        return audioManager.isWiredHeadsetOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSpeakerEnable() {
        AudioManager audioManager = this.am;
        if (audioManager == null) {
            return true;
        }
        return audioManager.isSpeakerphoneOn();
    }

    private String modeAsString(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return "Unknown " + i10;
                    }
                    return "MODE_IN_COMMUNICATION";
                }
                return "MODE_IN_CALL";
            }
            return "MODE_RINGTONE";
        }
        return "MODE_NORMAL";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAudioBtProfileChanged() {
        int i10;
        updateAudioBtProfileState();
        AudioRoutingListener audioRoutingListener = this.mListener.get();
        if (audioRoutingListener != null) {
            boolean z10 = this.mHfpEnable;
            if (this.mA2dpEnable) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            int i11 = (z10 ? 1 : 0) | i10;
            audioRoutingListener.onAudioBtProfileChanged(i11);
            Logging.i(TAG, "BT headset  btProfile " + i11);
            return;
        }
        Logging.w(TAG, "failed to get audio routing listener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAudioRoutingChanged(int i10) {
        AudioRoutingListener audioRoutingListener = this.mListener.get();
        if (audioRoutingListener != null) {
            audioRoutingListener.onAudioRoutingChanged(i10);
        } else {
            Logging.w(TAG, "failed to get audio routing listener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rescheTimer() {
        Logging.i(TAG, "re-schedule bluetooth timer");
        this.mEventHandler.removeCallbacks(this.TryConnectBtScoRunnable);
        this.mEventHandler.postDelayed(this.TryConnectBtScoRunnable, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetBtSco() {
        disableBtSco();
        cancelTimer();
        enableBtSco();
        startTimer();
    }

    private int setTargetRouteByPriority() {
        try {
            AudioDeviceList audioDeviceList = this.mAvailDevices;
            int i10 = audioDeviceList.mBTRoute;
            if (i10 != -1 && audioDeviceList.mHeadSetRoute != -1) {
                if (!sysRouteToBt()) {
                    return 0;
                }
                return 5;
            }
            if (i10 != -1) {
                return 5;
            }
            if (audioDeviceList.mHeadSetRoute != -1 && isHeadSetConnected()) {
                return 0;
            }
            AudioDeviceList audioDeviceList2 = this.mAvailDevices;
            int i11 = audioDeviceList2.mForcedRoute;
            if (i11 != -1) {
                return i11;
            }
            return audioDeviceList2.mDefaultRoute;
        } catch (Exception e10) {
            Logging.e(TAG, "fatal error setTargetRouteByPriority", e10);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        this.dynamic_timeout += 3000;
        Logging.i(TAG, "audio route start bluetooth timer " + this.dynamic_timeout + ", times:" + this.mScoConnectionAttemps);
        this.mEventHandler.postDelayed(this.TryConnectBtScoRunnable, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sysRouteToBt() {
        int deviceType;
        Context context = this.mContext.get();
        if (Build.VERSION.SDK_INT >= 24 && context != null) {
            deviceType = ((MediaRouter) context.getSystemService("media_router")).getSelectedRoute(1).getDeviceType();
            if (deviceType == 3) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToConnectBtSco() {
        if (this.am.isBluetoothScoOn()) {
            return;
        }
        try {
            int i10 = this.mScoConnectionAttemps + 1;
            this.mScoConnectionAttemps = i10;
            if (i10 < 3) {
                startTimer();
                Logging.d(TAG, "Attemp retry sco connected  times:" + this.mScoConnectionAttemps);
                this.am.stopBluetoothSco();
                enableBtSco();
                Logging.e(TAG, "start bluetooth sco on ? " + this.am.isBluetoothScoOn() + ",audiomode:" + this.am.getMode());
                return;
            }
            Logging.e(TAG, "start bluetooth sco timeout, mA2dpEventBypass " + this.mA2dpEventBypass);
            if (!this.mA2dpEventBypass) {
                this.am.setMode(0);
                this.am.stopBluetoothSco();
                checkFallbackA2dpIfNeed();
            }
            if (this.mListener.get() != null) {
                this.mListener.get().onAudioRoutingError(1030);
            }
        } catch (Exception e10) {
            Logging.e(TAG, "fatal error for connect sco", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAudioBtProfileState() {
        this.mA2dpEnable = this.mAudioDeviceInventory.isDeviceAvaliable(4);
        this.mHfpEnable = this.mAudioDeviceInventory.isDeviceAvaliable(3);
    }

    public void changeAvailDevices(int i10, int i11) {
        int i12 = 2;
        if (i10 != 1) {
            if (i10 != 2 && i10 != 4) {
                if (i10 != 10) {
                    if (i10 != 11) {
                        Logging.i(TAG, "No device changed!");
                    } else if (i11 == 0) {
                        this.mAvailDevices.mForcedRoute = 1;
                    } else {
                        this.mAvailDevices.mForcedRoute = 3;
                    }
                } else {
                    this.mAvailDevices.mDefaultRoute = i11;
                }
            } else if (this.mA2dpEnable | this.mHfpEnable) {
                this.mAvailDevices.mBTRoute = 5;
            } else {
                this.mAvailDevices.mBTRoute = -1;
            }
        } else if (i11 >= 0) {
            AudioDeviceList audioDeviceList = this.mAvailDevices;
            if (i11 <= 0) {
                i12 = 0;
            }
            audioDeviceList.mHeadSetRoute = i12;
        } else {
            this.mAvailDevices.mHeadSetRoute = -1;
        }
        Logging.i(TAG, "event device changed!" + i10 + "  mAvailDevices.mDefaultRoute" + this.mAvailDevices.mDefaultRoute);
    }

    public void clearListenerNativeHandle() {
        Logging.d(TAG, "clearListenerNativeHandle");
        AudioRoutingListener audioRoutingListener = this.mListener.get();
        if (audioRoutingListener != null) {
            audioRoutingListener.onAudioRoutingDestroyed();
        } else {
            Logging.w(TAG, "failed to get audio routing listener");
        }
    }

    protected boolean hasPermission(Context context, String str) {
        if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public int initAudioDeviceInventory() {
        int i10;
        String str;
        Context context = this.mContext.get();
        if (context == null) {
            Logging.e(TAG, "initAudioDeviceInventory Failed cause of invalid context");
            return -1;
        }
        if (this.mVersionInUsed == 1 && Build.VERSION.SDK_INT >= 23) {
            this.mAudioDeviceInventory = new AudioDeviceInventoryMorHigher(context);
            i10 = 1;
        } else {
            this.mAudioDeviceInventory = new AudioDeviceInventoryLowerThanM(context);
            i10 = 0;
        }
        this.mAudioDeviceInventory.setAudioDeviceChangeCallback(new AudioDeviceChangedCallbackImpl());
        this.mAudioDeviceInventory.initialize();
        StringBuilder sb = new StringBuilder();
        sb.append("initAudioDeviceInventory to ");
        if (i10 == 1) {
            str = "Callback Invertory ";
        } else {
            str = "Old intent Inventory";
        }
        sb.append(str);
        Logging.i(TAG, sb.toString());
        return i10;
    }

    public int initialize() {
        Logging.i(TAG, "initialize +");
        AudioDeviceList audioDeviceList = new AudioDeviceList();
        this.mAvailDevices = audioDeviceList;
        audioDeviceList.mDefaultRoute = -1;
        audioDeviceList.mForcedRoute = -1;
        audioDeviceList.mHeadSetRoute = -1;
        audioDeviceList.mBTRoute = -1;
        Context context = this.mContext.get();
        if (context != null && this.am != null) {
            HandlerThread handlerThread = new HandlerThread(TAG);
            handlerThread.start();
            this.mEventHandler = new EventHandler(handlerThread.getLooper());
            initAudioDeviceInventory();
            changeState(4);
            this.mScoStateReceiver = new AudioManagerScoStateReceiver();
            context.registerReceiver(this.mScoStateReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
            this.mScoStateReceiver.setRegistered(true);
            Logging.i(TAG, "initialize -");
            return 0;
        }
        Logging.e(TAG, "Initilize Failed cause of invalid context or invalid audiomanager");
        return -1;
    }

    public void muteAudioStream(boolean z10) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (z10) {
                    this.am.adjustStreamVolume(3, -100, 0);
                } else {
                    this.am.adjustStreamVolume(3, 100, 0);
                }
            } else if (z10) {
                this.am.setStreamMute(3, true);
            } else {
                this.am.setStreamMute(3, false);
            }
        } catch (Exception e10) {
            Logging.e(TAG, "muteAudioStream: " + e10);
        }
    }

    public int resetAudioDeviceInventory() {
        AudioDeviceInventory audioDeviceInventory = this.mAudioDeviceInventory;
        if (audioDeviceInventory != null) {
            audioDeviceInventory.dispose();
        }
        return initAudioDeviceInventory();
    }

    public void sendBtEventDelay(int i10, int i11, int i12, int i13) {
        Logging.d(TAG, "sendBtEventDelay: [" + getEventDesc(i10) + "], Parameters: " + i11 + "... " + this.mEventHandler);
        EventHandler eventHandler = this.mEventHandler;
        if (eventHandler != null) {
            eventHandler.removeMessages(4);
            this.mEventHandler.removeMessages(2);
            this.mEventHandler.sendMessageDelayed(this.mEventHandler.obtainMessage(i10, i11, i12), i13);
        }
    }

    public void sendEvent(int i10, int i11) {
        Logging.d(TAG, "sendEvent: [" + getEventDesc(i10) + "], Parameters: " + i11 + "... " + this.mEventHandler);
        EventHandler eventHandler = this.mEventHandler;
        if (eventHandler != null) {
            this.mEventHandler.sendMessage(eventHandler.obtainMessage(i10, i11, 0));
        }
    }

    public void setRoutingFeature(int i10) {
        Logging.d(TAG, "setRoutingFeature : " + i10);
        if (i10 == 0) {
            this.mA2dpEventBypass = true;
            return;
        }
        if (i10 == 1) {
            this.mA2dpEventBypass = false;
            return;
        }
        if (i10 == 2 && this.mVersionInUsed == 1) {
            this.mVersionInUsed = 0;
            resetAudioDeviceInventory();
        } else if (i10 == 3 && this.mVersionInUsed == 0) {
            this.mVersionInUsed = 1;
            resetAudioDeviceInventory();
        }
    }

    public void startMonitoring(int i10, int i11) {
        this.mContext.get();
        Logging.i(TAG, "--------------Comming to startMonitoring--------------------");
        notifyAudioBtProfileChanged();
        changeAvailDevices(10, i10);
        this.mChannelProfile = i11;
        if (this.mAvailDevices.mDefaultRoute == -1) {
            if (i11 == 0 && isAudioOnly()) {
                changeAvailDevices(10, 1);
                this.am.setSpeakerphoneOn(false);
            } else {
                changeAvailDevices(10, 3);
                if (this.am.getMode() != 3) {
                    this.am.setSpeakerphoneOn(false);
                    this.am.setSpeakerphoneOn(true);
                }
            }
        }
        this.mTargetRoute = -1;
        if (getBtDeviceList() > 0) {
            this.mAvailDevices.mBTRoute = 5;
        }
        int targetRouteByPriority = setTargetRouteByPriority();
        Logging.i(TAG, "mDefaultRoute: ," + this.mAvailDevices.mDefaultRoute + "  mAvailDevices.mForcedRoute :" + this.mAvailDevices.mForcedRoute);
        Logging.i(TAG, "mBtRoute: " + getAudioRouteDesc(this.mAvailDevices.mBTRoute) + ",mAvailDevices.mHeadSetRoute :" + getAudioRouteDesc(this.mAvailDevices.mHeadSetRoute));
        if (targetRouteByPriority == 5) {
            checkNeedResetBT();
        }
        changeState(targetRouteByPriority);
    }

    public void stopMonitoring() {
        Logging.i(TAG, "Stop Mornitor State process");
        changeState(4);
    }

    public void uninitialize() {
        Logging.d(TAG, "uninitialize");
        AudioDeviceInventory audioDeviceInventory = this.mAudioDeviceInventory;
        if (audioDeviceInventory != null) {
            audioDeviceInventory.dispose();
        }
        try {
            AudioManagerScoStateReceiver audioManagerScoStateReceiver = this.mScoStateReceiver;
            if (audioManagerScoStateReceiver != null && audioManagerScoStateReceiver.getRegistered()) {
                Context context = this.mContext.get();
                if (context != null) {
                    context.unregisterReceiver(this.mScoStateReceiver);
                    Logging.d(TAG, "unregisterReceiver mScoStateReceiver");
                }
                this.mScoStateReceiver.setRegistered(false);
            }
            this.mEventHandler.getLooper().quit();
        } catch (Exception e10) {
            Logging.e(TAG, "AudioRoutingController uninitialize fail: ", e10);
        }
    }

    public void sendEvent(int i10, int i11, int i12) {
        Logging.d(TAG, "sendEvent: [" + getEventDesc(i10) + "], Parameters: " + i11 + "... " + this.mEventHandler);
        EventHandler eventHandler = this.mEventHandler;
        if (eventHandler != null) {
            this.mEventHandler.sendMessage(eventHandler.obtainMessage(i10, i11, i12));
        }
    }
}
