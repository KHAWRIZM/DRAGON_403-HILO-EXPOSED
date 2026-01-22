package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SoundMessageHolder extends MessageContentHolder {
    private static final int READ = 1;
    private static final int UNREAD = 0;
    private LinearLayout audioContentView;
    private ImageView audioPlayImage;
    private TextView audioTimeText;

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.SoundMessageHolder$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ SoundMessageBean val$message;

        AnonymousClass1(SoundMessageBean soundMessageBean) {
            this.val$message = soundMessageBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AudioPlayer.getInstance().isPlaying()) {
                AudioPlayer.getInstance().stopPlay();
                if (TextUtils.equals(AudioPlayer.getInstance().getPath(), this.val$message.getDataPath())) {
                    return;
                }
            }
            if (TextUtils.isEmpty(this.val$message.getDataPath())) {
                ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.voice_play_tip));
                SoundMessageHolder.this.getSound(this.val$message);
                return;
            }
            SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.play_voice_message);
            if (this.val$message.isSelf()) {
                SoundMessageHolder.this.audioPlayImage.setRotation(180.0f);
            }
            final AnimationDrawable animationDrawable = (AnimationDrawable) SoundMessageHolder.this.audioPlayImage.getDrawable();
            animationDrawable.start();
            this.val$message.setCustomInt(1);
            SoundMessageHolder.this.unreadAudioText.setVisibility(8);
            AudioPlayer.getInstance().startPlay(this.val$message.getDataPath(), new AudioPlayer.Callback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.SoundMessageHolder.1.1
                @Override // com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer.Callback
                public void onCompletion(Boolean bool) {
                    SoundMessageHolder.this.audioPlayImage.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.SoundMessageHolder.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            animationDrawable.stop();
                            SoundMessageHolder.this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
                            if (AnonymousClass1.this.val$message.isSelf()) {
                                SoundMessageHolder.this.audioPlayImage.setRotation(180.0f);
                            }
                        }
                    });
                }
            });
        }
    }

    public SoundMessageHolder(View view) {
        super(view);
        this.audioTimeText = (TextView) view.findViewById(R.id.audio_time_tv);
        this.audioPlayImage = (ImageView) view.findViewById(R.id.audio_play_iv);
        this.audioContentView = (LinearLayout) view.findViewById(R.id.audio_content_ll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSound(final SoundMessageBean soundMessageBean) {
        final String str = TUIConfig.getRecordDownloadDir() + soundMessageBean.getUUID();
        if (!new File(str).exists()) {
            soundMessageBean.downloadSound(str, new SoundMessageBean.SoundDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.SoundMessageHolder.2
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
    public /* synthetic */ boolean lambda$layoutVariableViews$0(TUIMessageBean tUIMessageBean, int i, View view) {
        showDialog(tUIMessageBean, i, view, false, true, tUIMessageBean.isSelf());
        return false;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_audio;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i) {
        SoundMessageBean soundMessageBean = (SoundMessageBean) tUIMessageBean;
        if (soundMessageBean.isSelf()) {
            this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
            this.audioPlayImage.setRotation(180.0f);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage);
            this.unreadAudioText.setVisibility(8);
        } else {
            this.audioPlayImage.setImageResource(R.drawable.voice_msg_playing_3);
            this.audioContentView.removeView(this.audioPlayImage);
            this.audioContentView.addView(this.audioPlayImage, 0);
            if (soundMessageBean.getCustomInt() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.isReadText.getLayoutParams();
                layoutParams.gravity = 16;
                layoutParams.leftMargin = 10;
                this.unreadAudioText.setVisibility(0);
                this.unreadAudioText.setLayoutParams(layoutParams);
            } else {
                this.unreadAudioText.setVisibility(8);
            }
        }
        int duration = soundMessageBean.getDuration();
        if (duration == 0) {
            duration = 1;
        }
        if (!this.isReplyDetailMode && !this.isForwardMode && tUIMessageBean.isSelf()) {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(TUIThemeManager.getAttrResId(this.audioTimeText.getContext(), R.attr.chat_self_msg_text_color)));
        } else {
            this.audioTimeText.setTextColor(this.audioTimeText.getResources().getColor(TUIThemeManager.getAttrResId(this.audioTimeText.getContext(), R.attr.chat_other_msg_text_color)));
        }
        this.audioTimeText.setText(duration + "''");
        this.msgContentFrame.setOnClickListener(new AnonymousClass1(soundMessageBean));
        this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean lambda$layoutVariableViews$0;
                lambda$layoutVariableViews$0 = SoundMessageHolder.this.lambda$layoutVariableViews$0(tUIMessageBean, i, view);
                return lambda$layoutVariableViews$0;
            }
        });
    }
}
