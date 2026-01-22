package com.tencent.qcloud.tuikit.tuichat.component;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.AudioRecordEventListener;
import com.tencent.qcloud.tuikit.tuichat.model.AIDenoiseSignatureManager;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AudioRecorder {
    private static final String TAG = "AudioRecorder";
    private String mAudioRecordPath;
    private AudioRecordEventListener mCallkitAudioRecordEventListener;
    private boolean mIsCallkitRecorder;
    private Callback mRecordCallback;
    private MediaRecorder mRecorder;
    private static AudioRecorder sInstance = new AudioRecorder();
    private static String CURRENT_RECORD_FILE = TUIConfig.getRecordDir() + "auto_";
    private static int MAGIC_NUMBER = 500;
    private static int MIN_RECORD_DURATION = 1000;
    private Runnable mUpdateMicStatusTimer = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.3
        @Override // java.lang.Runnable
        public void run() {
            AudioRecorder.this.updateMicStatus();
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface Callback {
        void onCompletion(Boolean bool);

        void onVoiceDb(double d);
    }

    private AudioRecorder() {
        initCallkitAudioRecordListener();
    }

    public static AudioRecorder getInstance() {
        return sInstance;
    }

    private void initCallkitAudioRecordListener() {
        this.mCallkitAudioRecordEventListener = new AudioRecordEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.1
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.AudioRecordEventListener
            public void onRecordBegin(int i, String str) {
                TUIChatLog.i(AudioRecorder.TAG, "callkit recorder begin, errorCode:" + i);
                if (i != -2001 && i != -1302) {
                    if (i != 0) {
                        switch (i) {
                            case -1319:
                            case TUIConstants.TUICalling.ERR_MIC_SET_PARAM_FAIL /* -1318 */:
                            case -1317:
                                break;
                            default:
                                switch (i) {
                                    case TUIConstants.TUICalling.ERROR_REQUEST_AUDIO_FOCUS_FAILED /* -1005 */:
                                        break;
                                    case TUIConstants.TUICalling.ERROR_MIC_PERMISSION_REFUSED /* -1004 */:
                                        AudioRecorder.this.mHandler.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.1.4
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AudioRecorder.this.stopCallkitRecord();
                                                AudioRecorder.this.onRecordCompleted(false);
                                                ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.audio_permission_error));
                                            }
                                        });
                                        return;
                                    case TUIConstants.TUICalling.ERROR_STATUS_IS_AUDIO_RECORDING /* -1003 */:
                                        AudioRecorder.this.mHandler.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.1.3
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AudioRecorder.this.onRecordCompleted(false);
                                                ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_rejected_for_in_recording));
                                            }
                                        });
                                        return;
                                    case TUIConstants.TUICalling.ERROR_STATUS_IN_CALL /* -1002 */:
                                        AudioRecorder.this.mHandler.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AudioRecorder.this.onRecordCompleted(false);
                                                ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_rejected_for_in_call));
                                            }
                                        });
                                        return;
                                    default:
                                        AudioRecorder.this.mHandler.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.1.6
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AudioRecorder.this.stopCallkitRecord();
                                                AudioRecorder.this.startSystemRecorder();
                                            }
                                        });
                                        return;
                                }
                        }
                    } else {
                        AudioRecorder.this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AudioRecorder.this.stopCallkitRecord();
                                AudioRecorder.this.onRecordCompleted(true);
                                ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_limit_tips));
                            }
                        }, TUIChatConfigs.getConfigs().getGeneralConfig().getAudioRecordMaxTime() * 1000);
                        return;
                    }
                }
                AudioRecorder.this.mHandler.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AudioRecorder.this.stopCallkitRecord();
                        AudioRecorder.this.onRecordCompleted(false);
                    }
                });
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.AudioRecordEventListener
            public void onRecordComplete(int i, String str) {
                TUIChatLog.i(AudioRecorder.TAG, "callkit recorder complete, errorCode:" + i);
                if (i == -2004 || i == -2003) {
                    AudioRecorder.this.onRecordCompleted(false);
                } else if (i == 0) {
                    AudioRecorder.this.onRecordCompleted(true);
                }
            }
        };
        TUIChatService.getInstance().addAudioRecordEventListener(this.mCallkitAudioRecordEventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRecordCompleted(boolean z) {
        Callback callback = this.mRecordCallback;
        if (callback != null) {
            callback.onCompletion(Boolean.valueOf(z));
            this.mRecordCallback = null;
        }
        if (!this.mIsCallkitRecorder && this.mRecorder != null) {
            this.mRecorder = null;
        }
    }

    private boolean startCallkitRecorder() {
        if (TUICore.getService("TUIAudioMessageRecordService") == null) {
            TUIChatLog.i(TAG, "audio record service does not exists");
            return false;
        }
        String signature = AIDenoiseSignatureManager.getInstance().getSignature();
        if (TextUtils.isEmpty(signature)) {
            TUIChatLog.e(TAG, "denoise signature is empty");
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, signature);
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_SDK_APP_ID, Integer.valueOf(TUILogin.getSdkAppId()));
        hashMap.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, this.mAudioRecordPath);
        TUICore.callService("TUIAudioMessageRecordService", TUIConstants.TUICalling.METHOD_NAME_START_RECORD_AUDIO_MESSAGE, hashMap);
        this.mIsCallkitRecorder = true;
        TUIChatLog.i(TAG, "use callkit recorder");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSystemRecorder() {
        TUIChatLog.i(TAG, "use system media recorder");
        this.mIsCallkitRecorder = false;
        try {
            MediaRecorder mediaRecorder = new MediaRecorder();
            this.mRecorder = mediaRecorder;
            mediaRecorder.setAudioSource(1);
            this.mRecorder.setOutputFormat(2);
            this.mRecorder.setOutputFile(this.mAudioRecordPath);
            this.mRecorder.setAudioEncoder(3);
            this.mRecorder.prepare();
            this.mRecorder.start();
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioRecorder.2
                @Override // java.lang.Runnable
                public void run() {
                    AudioRecorder.this.stopInternalRecord();
                    AudioRecorder.this.onRecordCompleted(true);
                    ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.record_limit_tips));
                }
            }, TUIChatConfigs.getConfigs().getGeneralConfig().getAudioRecordMaxTime() * 1000);
            updateMicStatus();
        } catch (Exception e) {
            TUIChatLog.w(TAG, "startRecord failed", e);
            stopInternalRecord();
            onRecordCompleted(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCallkitRecord() {
        this.mHandler.removeCallbacksAndMessages(null);
        TUICore.callService("TUIAudioMessageRecordService", TUIConstants.TUICalling.METHOD_NAME_STOP_RECORD_AUDIO_MESSAGE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternalRecord() {
        this.mHandler.removeCallbacksAndMessages(null);
        MediaRecorder mediaRecorder = this.mRecorder;
        if (mediaRecorder == null) {
            return;
        }
        mediaRecorder.release();
        this.mRecorder = null;
    }

    private void stopMediaRecord() {
        stopInternalRecord();
        onRecordCompleted(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMicStatus() {
        double d;
        if (this.mRecorder != null) {
            double maxAmplitude = r0.getMaxAmplitude() / 1.0d;
            if (maxAmplitude > 1.0d) {
                d = Math.log10(maxAmplitude) * 20.0d;
            } else {
                d = 0.0d;
            }
            TUIChatLog.d(TAG, "计算分贝值 = " + d + "dB");
            Callback callback = this.mRecordCallback;
            if (callback != null) {
                callback.onVoiceDb(d);
            }
            this.mHandler.postDelayed(this.mUpdateMicStatusTimer, 100L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getDuration() {
        int i;
        if (TextUtils.isEmpty(this.mAudioRecordPath)) {
            return 0;
        }
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this.mAudioRecordPath);
            mediaPlayer.prepare();
            i = mediaPlayer.getDuration();
        } catch (Exception e) {
            e = e;
            i = 0;
        }
        try {
            if (i < MIN_RECORD_DURATION) {
                i = 0;
            } else {
                i += MAGIC_NUMBER;
            }
        } catch (Exception e2) {
            e = e2;
            TUIChatLog.w(TAG, "getDuration failed", e);
            if (i >= 0) {
            }
        }
        if (i >= 0) {
            return 0;
        }
        return i;
    }

    public String getPath() {
        return this.mAudioRecordPath;
    }

    public void startRecord(Callback callback) {
        this.mRecordCallback = callback;
        this.mAudioRecordPath = CURRENT_RECORD_FILE + System.currentTimeMillis() + ".m4a";
        if (!startCallkitRecorder()) {
            startSystemRecorder();
        }
    }

    public void stopRecord() {
        if (this.mIsCallkitRecorder) {
            stopCallkitRecord();
        } else {
            stopMediaRecord();
        }
    }
}
