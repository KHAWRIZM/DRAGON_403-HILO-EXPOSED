package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SoundMessageHolder extends MessageContentHolder {
    private static final int READ = 1;
    private static final int UNREAD = 0;
    private ImageView audioPlayImage;
    private TextView audioTimeText;
    private Timer mTimer;
    private int times;

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.SoundMessageHolder$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ int val$finalDuration;
        final /* synthetic */ SoundMessageBean val$message;
        final /* synthetic */ String val$timeString;

        AnonymousClass1(String str, SoundMessageBean soundMessageBean, int i) {
            this.val$timeString = str;
            this.val$message = soundMessageBean;
            this.val$finalDuration = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AudioPlayer.getInstance().isPlaying()) {
                AudioPlayer.getInstance().stopPlay();
                SoundMessageHolder.this.resetTimerStatus(this.val$timeString);
                if (TextUtils.equals(AudioPlayer.getInstance().getPath(), this.val$message.getDataPath())) {
                    return;
                }
            }
            if (TextUtils.isEmpty(this.val$message.getDataPath())) {
                ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.voice_play_tip));
                SoundMessageHolder.this.getSound(this.val$message);
                return;
            }
            if (this.val$finalDuration > 1) {
                if (SoundMessageHolder.this.mTimer == null) {
                    SoundMessageHolder.this.mTimer = new Timer();
                }
                SoundMessageHolder.this.mTimer.schedule(new TimerTask() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.SoundMessageHolder.1.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.SoundMessageHolder.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int i = SoundMessageHolder.this.times;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (i < anonymousClass1.val$finalDuration) {
                                    SoundMessageHolder.this.times++;
                                    SoundMessageHolder.this.audioTimeText.setText(DateTimeUtil.formatSecondsTo00(SoundMessageHolder.this.times));
                                    return;
                                }
                                SoundMessageHolder.this.audioTimeText.setText(AnonymousClass1.this.val$timeString);
                            }
                        });
                    }
                }, 0L, 1000L);
            }
            SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.chat_audio_stop_btn_ic);
            this.val$message.setCustomInt(1);
            AudioPlayer.getInstance().startPlay(this.val$message.getDataPath(), new AudioPlayer.Callback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.SoundMessageHolder.1.2
                @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.Callback
                public void onCompletion(Boolean bool) {
                    SoundMessageHolder.this.audioPlayImage.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.SoundMessageHolder.1.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.chat_audio_play_btn_ic);
                        }
                    });
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    SoundMessageHolder.this.resetTimerStatus(anonymousClass1.val$timeString);
                }
            });
        }
    }

    public SoundMessageHolder(View view) {
        super(view);
        this.times = 0;
        this.audioTimeText = (TextView) view.findViewById(R.id.audio_time_tv);
        this.audioPlayImage = (ImageView) view.findViewById(R.id.audio_play_iv);
        this.timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.time_in_line_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSound(final SoundMessageBean soundMessageBean) {
        final String str = TUIConfig.getRecordDownloadDir() + soundMessageBean.getUUID();
        if (!new File(str).exists()) {
            soundMessageBean.downloadSound(str, new SoundMessageBean.SoundDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.SoundMessageHolder.2
                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.SoundDownloadCallback
                public void onError(int i, String str2) {
                    TUIChatLog.e("getSoundToFile failed code = ", i + ", info = " + str2);
                    ToastUtil.toastLongMessage("getSoundToFile failed code = " + i + ", info = " + str2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.SoundDownloadCallback
                public void onProgress(long j, long j2) {
                    TUIChatLog.i("downloadSound progress current:", j + ", total:" + j2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean.SoundDownloadCallback
                public void onSuccess() {
                    soundMessageBean.setDataPath(str);
                }
            });
        } else {
            soundMessageBean.setDataPath(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetTimerStatus(String str) {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        this.audioTimeText.setText(str);
        this.times = 0;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.minimalist_message_adapter_content_audio;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        SoundMessageBean soundMessageBean = (SoundMessageBean) tUIMessageBean;
        int duration = soundMessageBean.getDuration();
        if (duration == 0) {
            duration = 1;
        }
        String formatSecondsTo00 = DateTimeUtil.formatSecondsTo00(duration);
        resetTimerStatus(formatSecondsTo00);
        this.msgContentFrame.setOnClickListener(new AnonymousClass1(formatSecondsTo00, soundMessageBean, duration));
    }
}
