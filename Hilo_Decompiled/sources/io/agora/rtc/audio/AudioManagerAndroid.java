package io.agora.rtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager$AudioRecordingCallback;
import android.media.MediaRouter;
import android.os.Build;
import android.os.Handler;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.liteav.audio2.i;
import com.tencent.liteav.audio2.y;
import io.agora.rtc.internal.Logging;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AudioManagerAndroid {
    private static final int DEFAULT_FRAMES_PER_BUFFER = 256;
    private static final int DEFAULT_SAMPLING_RATE = 44100;
    private static final String TAG = "AudioManagerAndroid";
    private AudioManager audioManager;
    private int mActiveRecordCnt;
    AudioRecordingCallbackImpl mActiveRecordingCallback;
    private int mAudioLowLatencyOutputFrameSize;
    private boolean mAudioLowLatencySupported;
    private int mNativeOutputSampleRate;
    private WeakReference<Context> mcontext;

    @TargetApi(24)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class AudioRecordingCallbackImpl extends AudioManager$AudioRecordingCallback {
        private AudioRecordingCallbackImpl() {
        }

        public void onRecordingConfigChanged(List<android.media.AudioRecordingConfiguration> list) {
            super.onRecordingConfigChanged(list);
            Logging.d(AudioManagerAndroid.TAG, "recording callback, cnt : " + list.size());
            Iterator<android.media.AudioRecordingConfiguration> it = list.iterator();
            while (it.hasNext()) {
                i.a(it.next());
            }
            AudioManagerAndroid.this.mActiveRecordCnt = list.size();
        }
    }

    private AudioManagerAndroid(Context context) {
        List activeRecordingConfigurations;
        this.mcontext = new WeakReference<>(context);
        AudioManager audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        this.audioManager = audioManager;
        this.mNativeOutputSampleRate = DEFAULT_SAMPLING_RATE;
        this.mAudioLowLatencyOutputFrameSize = 256;
        this.mActiveRecordCnt = 1;
        int i10 = Build.VERSION.SDK_INT;
        String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property != null) {
            this.mNativeOutputSampleRate = Integer.parseInt(property);
        }
        String property2 = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        if (property2 != null) {
            this.mAudioLowLatencyOutputFrameSize = Integer.parseInt(property2);
        }
        this.mAudioLowLatencySupported = context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        this.mActiveRecordingCallback = null;
        if (i10 >= 24) {
            AudioRecordingCallbackImpl audioRecordingCallbackImpl = new AudioRecordingCallbackImpl();
            this.mActiveRecordingCallback = audioRecordingCallbackImpl;
            y.a(this.audioManager, audioRecordingCallbackImpl, new Handler(context.getMainLooper()));
            activeRecordingConfigurations = this.audioManager.getActiveRecordingConfigurations();
            this.mActiveRecordCnt = activeRecordingConfigurations.size();
        }
        Logging.d(TAG, "ctor " + this + ", cb " + this.mActiveRecordingCallback);
    }

    private int GetAudioMode() {
        return this.audioManager.getMode();
    }

    private int QuerySpeakerStatus() {
        boolean z10;
        int deviceType;
        if (this.audioManager.getMode() != 3 && this.audioManager.getMode() != 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        Context context = this.mcontext.get();
        if (this.audioManager == null && context != null) {
            this.audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        if (z10) {
            if (this.audioManager.isSpeakerphoneOn()) {
                return 3;
            }
            if (this.audioManager.isBluetoothScoOn()) {
                return 5;
            }
            if (this.audioManager.isWiredHeadsetOn()) {
                return 0;
            }
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            deviceType = ((MediaRouter) context.getSystemService("media_router")).getSelectedRoute(1).getDeviceType();
            if (deviceType == 3) {
                return 5;
            }
            if (this.audioManager.isWiredHeadsetOn()) {
                return 0;
            }
            if (!this.audioManager.isSpeakerphoneOn()) {
                return 1;
            }
            return 3;
        }
        if (this.audioManager.isBluetoothA2dpOn()) {
            return 5;
        }
        if (this.audioManager.isWiredHeadsetOn()) {
            return 0;
        }
        if (!this.audioManager.isSpeakerphoneOn()) {
            return 1;
        }
        return 3;
    }

    private int SetAudioMode(int i10) {
        try {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            this.audioManager.setMode(0);
                        } else {
                            this.audioManager.setMode(3);
                        }
                    } else {
                        this.audioManager.setMode(2);
                    }
                } else {
                    this.audioManager.setMode(1);
                }
            } else {
                this.audioManager.setMode(0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return 0;
    }

    private int SetPlayoutSpeaker(boolean z10) {
        this.audioManager.setSpeakerphoneOn(z10);
        return 0;
    }

    private boolean checkAudioPermission() {
        Context context = this.mcontext.get();
        if (context == null || context.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            return true;
        }
        return false;
    }

    private int enableHardwareEarback(boolean z10) {
        Context context = this.mcontext.get();
        if (context != null) {
            return HardwareEarbackController.getInstance(context).enableHardwareEarback(z10);
        }
        return -1;
    }

    private int getAudioLowLatencyOutputFrameSize() {
        return this.mAudioLowLatencyOutputFrameSize;
    }

    private int getCurrenPlayoutDevices() {
        int i10 = 0;
        try {
            i10 = ((Integer) AudioManager.class.getMethod("getDevicesForStream", Integer.TYPE).invoke(this.audioManager, Integer.valueOf(getStreamType()))).intValue();
            Logging.d(TAG, "get current playout devices: " + i10);
            return i10;
        } catch (Exception e10) {
            Logging.e(TAG, "Error getDevicesForStream! ", e10);
            return i10;
        }
    }

    private int getCurrentRecordingCnt() {
        return this.mActiveRecordCnt;
    }

    private int getNativeOutputSampleRate() {
        return this.mNativeOutputSampleRate;
    }

    private int getStreamType() {
        int mode = this.audioManager.getMode();
        int i10 = 0;
        if (mode != 3) {
            if (mode == 0) {
                i10 = 3;
            } else {
                Logging.w(TAG, "invalid audio mode");
            }
        }
        Logging.d(TAG, "get stream type is " + i10);
        return i10;
    }

    private boolean isAudioLowLatencySupported() {
        return this.mAudioLowLatencySupported;
    }

    private boolean isHardwareEarbackSupported() {
        Context context = this.mcontext.get();
        if (context != null) {
            return HardwareEarbackController.getInstance(context).isHardwareEarbackSupported();
        }
        return false;
    }

    private int prepareRelease() {
        if (Build.VERSION.SDK_INT >= 24) {
            Logging.d(TAG, "Release resource, cb " + this.mActiveRecordingCallback);
            AudioRecordingCallbackImpl audioRecordingCallbackImpl = this.mActiveRecordingCallback;
            if (audioRecordingCallbackImpl != null) {
                this.audioManager.unregisterAudioRecordingCallback(audioRecordingCallbackImpl);
                this.mActiveRecordingCallback = null;
                return 0;
            }
            return 0;
        }
        return 0;
    }

    private int setHardwareEarbackVolume(int i10) {
        Context context = this.mcontext.get();
        if (context != null) {
            return HardwareEarbackController.getInstance(context).setHardwareEarbackVolume(i10);
        }
        return -1;
    }
}
