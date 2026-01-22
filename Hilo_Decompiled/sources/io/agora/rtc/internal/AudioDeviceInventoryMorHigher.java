package io.agora.rtc.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Handler;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.liteav.audio2.route.c;
import com.tencent.liteav.audio2.route.d;
import com.tencent.liteav.audio2.route.f;
import com.tencent.liteav.audio2.route.j;
import io.agora.rtc.internal.AudioRoutingController;
import java.util.HashMap;

@TargetApi(23)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AudioDeviceInventoryMorHigher implements AudioRoutingController.AudioDeviceInventory {
    private static final HashMap<Integer, Integer> DEVICE_TYPE_MAP;
    private static final String TAG = "AudioRoute";
    private AudioManager mAm;
    private AudioRoutingController.AudioDeviceChangedCallback mAudioDeviceChangedCb = null;
    private AudioDeviceCallbackImpl mDevCb;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class AudioDeviceCallbackImpl extends AudioDeviceCallback {
        public AudioDeviceCallbackImpl() {
            Logging.i(AudioDeviceInventoryMorHigher.TAG, "AudioDeviceCallbackImpl ctor!");
        }

        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioDeviceInventoryMorHigher.this.processDevicesChanged(audioDeviceInfoArr, true);
        }

        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioDeviceInventoryMorHigher.this.processDevicesChanged(audioDeviceInfoArr, false);
        }
    }

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        DEVICE_TYPE_MAP = hashMap;
        hashMap.put(3, 1);
        hashMap.put(4, 2);
        hashMap.put(7, 3);
        hashMap.put(8, 4);
        hashMap.put(22, 1);
    }

    public AudioDeviceInventoryMorHigher(Context context) {
        this.mAm = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
    }

    private void onAudioDeviceChanged(int i10, boolean z10) {
        AudioRoutingController.AudioDeviceChangedCallback audioDeviceChangedCallback = this.mAudioDeviceChangedCb;
        if (audioDeviceChangedCallback != null) {
            audioDeviceChangedCallback.onAudioDeviceChanged(i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDevicesChanged(AudioDeviceInfo[] audioDeviceInfoArr, boolean z10) {
        boolean isSource;
        String str;
        for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
            isSource = audioDeviceInfo.isSource();
            int a10 = f.a(audioDeviceInfo);
            String str2 = "disconnect";
            if (!isSource) {
                HashMap<Integer, Integer> hashMap = DEVICE_TYPE_MAP;
                if (hashMap.containsKey(Integer.valueOf(f.a(audioDeviceInfo)))) {
                    int intValue = hashMap.get(Integer.valueOf(a10)).intValue();
                    onAudioDeviceChanged(intValue, z10);
                    StringBuilder sb = new StringBuilder();
                    sb.append("processDevicesChanged : ");
                    sb.append(intValue);
                    sb.append(" ");
                    if (z10) {
                        str2 = "connect";
                    }
                    sb.append(str2);
                    Logging.i(TAG, sb.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not process ");
            if (z10) {
                str2 = "connect";
            }
            sb2.append(str2);
            if (isSource) {
                str = " input ";
            } else {
                str = " output ";
            }
            sb2.append(str);
            sb2.append("device type: ");
            sb2.append(a10);
            Logging.i(TAG, sb2.toString());
        }
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public void dispose() {
        d.a(this.mAm, this.mDevCb);
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public void initialize() {
        AudioDeviceCallbackImpl audioDeviceCallbackImpl = new AudioDeviceCallbackImpl();
        this.mDevCb = audioDeviceCallbackImpl;
        c.a(this.mAm, audioDeviceCallbackImpl, (Handler) null);
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public boolean isDeviceAvaliable(int i10) {
        for (AudioDeviceInfo audioDeviceInfo : j.a(this.mAm, 2)) {
            int a10 = f.a(audioDeviceInfo);
            HashMap<Integer, Integer> hashMap = DEVICE_TYPE_MAP;
            if (hashMap.containsKey(Integer.valueOf(a10)) && hashMap.get(Integer.valueOf(a10)).intValue() == i10) {
                return true;
            }
        }
        return false;
    }

    @Override // io.agora.rtc.internal.AudioRoutingController.AudioDeviceInventory
    public void setAudioDeviceChangeCallback(AudioRoutingController.AudioDeviceChangedCallback audioDeviceChangedCallback) {
        this.mAudioDeviceChangedCb = audioDeviceChangedCallback;
    }
}
