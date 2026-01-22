package com.qiahao.nextvideo.room.help;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.MaxDialogUtils;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog;
import com.tencent.imsdk.v2.V2TIMManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010 \u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/room/help/EnvelopeHelper;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "envelopeDialog", "Lcom/qiahao/nextvideo/room/redEnvelope/OpenEnvelopeDialog;", "getEnvelopeDialog", "()Lcom/qiahao/nextvideo/room/redEnvelope/OpenEnvelopeDialog;", "setEnvelopeDialog", "(Lcom/qiahao/nextvideo/room/redEnvelope/OpenEnvelopeDialog;)V", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "envelopeTimerTask", "getEnvelopeTimerTask", "setEnvelopeTimerTask", "showEnvelopeDialog", "", "isAuto", "", "checkEnvelope", "startTimerTask", "data", "Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "endTimerTask", "releaseEnvelope", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class EnvelopeHelper {

    @Nullable
    private OpenEnvelopeDialog envelopeDialog;

    @Nullable
    private CountDownTimer envelopeTimerTask;

    @NotNull
    private final AudioRoomFragment fragment;

    @Nullable
    private CountDownTimer timerTask;

    public EnvelopeHelper(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
    }

    public static /* synthetic */ void checkEnvelope$default(EnvelopeHelper envelopeHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        envelopeHelper.checkEnvelope(z);
    }

    private final void endTimerTask(EnvelopeData data) {
        long j;
        CountDownTimer countDownTimer = this.envelopeTimerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Long end = data.getEnd();
        if (end != null) {
            j = end.longValue();
        } else {
            j = 0;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer((j - V2TIMManager.getInstance().getServerTime()) * 1000) { // from class: com.qiahao.nextvideo.room.help.EnvelopeHelper$endTimerTask$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                EnvelopeHelper.checkEnvelope$default(EnvelopeHelper.this, false, 1, null);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }
        };
        this.envelopeTimerTask = countDownTimer2;
        countDownTimer2.start();
    }

    private final void showEnvelopeDialog(boolean isAuto) {
        long j;
        Long myDiamond;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        EnvelopeData mEnvelopeData = meetingRoomManager.getMEnvelopeData();
        if (mEnvelopeData != null && (myDiamond = mEnvelopeData.getMyDiamond()) != null) {
            j = myDiamond.longValue();
        } else {
            j = 0;
        }
        if ((j == 0 || !isAuto) && this.fragment.getActivity() != null) {
            FragmentActivity activity = this.fragment.getActivity();
            if (activity == null || !activity.isFinishing()) {
                FragmentActivity activity2 = this.fragment.getActivity();
                if (activity2 == null || !activity2.isDestroyed()) {
                    OpenEnvelopeDialog openEnvelopeDialog = this.envelopeDialog;
                    if (openEnvelopeDialog != null) {
                        openEnvelopeDialog.dismiss();
                    }
                    this.envelopeDialog = null;
                    FragmentActivity activity3 = this.fragment.getActivity();
                    if (activity3 != null) {
                        this.envelopeDialog = new OpenEnvelopeDialog(activity3, meetingRoomManager.getMEnvelopeData());
                    }
                    BaseBindingDialog baseBindingDialog = this.envelopeDialog;
                    if (baseBindingDialog != null) {
                        baseBindingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.y4
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                EnvelopeHelper.this.envelopeDialog = null;
                            }
                        });
                    }
                    MaxDialogUtils.INSTANCE.showDialog(this.envelopeDialog);
                }
            }
        }
    }

    static /* synthetic */ void showEnvelopeDialog$default(EnvelopeHelper envelopeHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        envelopeHelper.showEnvelopeDialog(z);
    }

    private final void startTimerTask(EnvelopeData data) {
        long j;
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Long start = data.getStart();
        if (start != null) {
            j = start.longValue();
        } else {
            j = 0;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer((j - V2TIMManager.getInstance().getServerTime()) * 1000) { // from class: com.qiahao.nextvideo.room.help.EnvelopeHelper$startTimerTask$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView textView;
                FragmentAudioRoomBinding binding = EnvelopeHelper.this.getFragment().getBinding();
                if (binding != null && (textView = binding.envelopeTime) != null) {
                    textView.setVisibility(8);
                }
                EnvelopeHelper.this.checkEnvelope(true);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView textView;
                FragmentAudioRoomBinding binding = EnvelopeHelper.this.getFragment().getBinding();
                if (binding != null && (textView = binding.envelopeTime) != null) {
                    textView.setText(com.qiahao.base_common.utils.f.c(((int) millisUntilFinished) / 1000));
                }
            }
        };
        this.timerTask = countDownTimer2;
        countDownTimer2.start();
    }

    public final void checkEnvelope(boolean isAuto) {
        TextView textView;
        long j;
        TextView textView2;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        EnvelopeData mEnvelopeData = MeetingRoomManager.INSTANCE.getMEnvelopeData();
        if (mEnvelopeData != null) {
            if (mEnvelopeData.checkEnvelopeExpired()) {
                FragmentAudioRoomBinding binding = this.fragment.getBinding();
                if (binding != null && (frameLayout2 = binding.envelopeLayout) != null) {
                    frameLayout2.setVisibility(8);
                }
                CountDownTimer countDownTimer = this.timerTask;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                this.timerTask = null;
                CountDownTimer countDownTimer2 = this.envelopeTimerTask;
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                }
                this.envelopeTimerTask = null;
                return;
            }
            FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
            if (binding2 != null && (frameLayout = binding2.envelopeLayout) != null) {
                frameLayout.setVisibility(0);
            }
            if (Intrinsics.areEqual(mEnvelopeData.isWorld(), Boolean.TRUE)) {
                Long start = mEnvelopeData.getStart();
                if (start != null) {
                    j = start.longValue();
                } else {
                    j = 0;
                }
                if (j > V2TIMManager.getInstance().getServerTime()) {
                    FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                    if (binding3 != null && (textView2 = binding3.envelopeTime) != null) {
                        textView2.setVisibility(0);
                    }
                    startTimerTask(mEnvelopeData);
                    showEnvelopeDialog(isAuto);
                    endTimerTask(mEnvelopeData);
                }
            }
            FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
            if (binding4 != null && (textView = binding4.envelopeTime) != null) {
                textView.setVisibility(8);
            }
            showEnvelopeDialog(isAuto);
            endTimerTask(mEnvelopeData);
        }
    }

    @Nullable
    public final OpenEnvelopeDialog getEnvelopeDialog() {
        return this.envelopeDialog;
    }

    @Nullable
    public final CountDownTimer getEnvelopeTimerTask() {
        return this.envelopeTimerTask;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    public final void releaseEnvelope() {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        CountDownTimer countDownTimer2 = this.envelopeTimerTask;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        this.envelopeTimerTask = null;
        OpenEnvelopeDialog openEnvelopeDialog = this.envelopeDialog;
        if (openEnvelopeDialog != null) {
            openEnvelopeDialog.dismiss();
        }
    }

    public final void setEnvelopeDialog(@Nullable OpenEnvelopeDialog openEnvelopeDialog) {
        this.envelopeDialog = openEnvelopeDialog;
    }

    public final void setEnvelopeTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.envelopeTimerTask = countDownTimer;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }
}
