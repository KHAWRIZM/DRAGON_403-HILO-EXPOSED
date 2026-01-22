package com.qiahao.nextvideo.ui.videocall.specifyuser;

import android.os.CountDownTimer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimer;", "Landroid/os/CountDownTimer;", "connectionTimeOut", "", "<init>", "(J)V", "listener", "Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimerListener;", "getListener", "()Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimerListener;", "setListener", "(Lcom/qiahao/nextvideo/ui/videocall/specifyuser/SoloDownTimerListener;)V", "onFinish", "", "onTick", "millisUntilFinished", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SoloDownTimer extends CountDownTimer {
    public static final long SINGLE_CONNECTION_TIMEOUT = 30;

    @Nullable
    private SoloDownTimerListener listener;

    public SoloDownTimer() {
        this(0L, 1, null);
    }

    @Nullable
    public final SoloDownTimerListener getListener() {
        return this.listener;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        SoloDownTimerListener soloDownTimerListener = this.listener;
        if (soloDownTimerListener != null) {
            soloDownTimerListener.onTimeout();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long millisUntilFinished) {
    }

    public final void setListener(@Nullable SoloDownTimerListener soloDownTimerListener) {
        this.listener = soloDownTimerListener;
    }

    public /* synthetic */ SoloDownTimer(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 30L : j);
    }

    public SoloDownTimer(long j) {
        super(j * 1000, 1000L);
    }
}
