package com.tencent.qcloud.tuikit.tuichat.component;

import android.media.MediaPlayer;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AudioPlayer {
    private static final String TAG = "AudioPlayer";
    private static AudioPlayer sInstance = new AudioPlayer();
    private String mAudioRecordPath;
    private Callback mPlayCallback;
    private MediaPlayer mPlayer;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface Callback {
        void onCompletion(Boolean bool);
    }

    private AudioPlayer() {
    }

    public static AudioPlayer getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayCompleted(boolean z) {
        Callback callback = this.mPlayCallback;
        if (callback != null) {
            callback.onCompletion(Boolean.valueOf(z));
        }
        this.mPlayer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopInternalPlay() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.release();
        this.mPlayer = null;
    }

    public String getPath() {
        return this.mAudioRecordPath;
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    public void startPlay(String str, Callback callback) {
        this.mAudioRecordPath = str;
        this.mPlayCallback = callback;
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mPlayer = mediaPlayer;
            mediaPlayer.setDataSource(str);
            this.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.1
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer2) {
                    AudioPlayer.this.stopInternalPlay();
                    AudioPlayer.this.onPlayCompleted(true);
                }
            });
            this.mPlayer.prepare();
            this.mPlayer.start();
        } catch (Exception e) {
            TUIChatLog.w(TAG, "startPlay failed", e);
            ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.play_error_tip));
            stopInternalPlay();
            onPlayCompleted(false);
        }
    }

    public void stopPlay() {
        stopInternalPlay();
        onPlayCompleted(false);
        this.mPlayCallback = null;
    }
}
