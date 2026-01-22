package com.qiahao.nextvideo.room.activity;

import android.os.CountDownTimer;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/GroupSupportUpdateCountDownTimer;", "Landroid/os/CountDownTimer;", "connectionTimeOut", "", "<init>", "(J)V", "getConnectionTimeOut", "()J", "setConnectionTimeOut", "delegate", "Lcom/qiahao/nextvideo/room/activity/GroupSupportUpdateCountDownTimerDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/room/activity/GroupSupportUpdateCountDownTimerDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/room/activity/GroupSupportUpdateCountDownTimerDelegate;)V", "onFinish", "", "onTick", "millisUntilFinished", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupSupportUpdateCountDownTimer extends CountDownTimer {
    private long connectionTimeOut;

    @Nullable
    private GroupSupportUpdateCountDownTimerDelegate delegate;

    public GroupSupportUpdateCountDownTimer(long j) {
        super(j, 1000L);
        this.connectionTimeOut = j;
    }

    public final long getConnectionTimeOut() {
        return this.connectionTimeOut;
    }

    @Nullable
    public final GroupSupportUpdateCountDownTimerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        GroupSupportUpdateCountDownTimerDelegate groupSupportUpdateCountDownTimerDelegate = this.delegate;
        if (groupSupportUpdateCountDownTimerDelegate != null) {
            groupSupportUpdateCountDownTimerDelegate.groupSupportUpdateCountDownTimerTimeout();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long millisUntilFinished) {
        GroupSupportUpdateCountDownTimerDelegate groupSupportUpdateCountDownTimerDelegate = this.delegate;
        if (groupSupportUpdateCountDownTimerDelegate != null) {
            groupSupportUpdateCountDownTimerDelegate.groupSupportUpdateCountDownTimerOnTick(millisUntilFinished);
        }
    }

    public final void setConnectionTimeOut(long j) {
        this.connectionTimeOut = j;
    }

    public final void setDelegate(@Nullable GroupSupportUpdateCountDownTimerDelegate groupSupportUpdateCountDownTimerDelegate) {
        this.delegate = groupSupportUpdateCountDownTimerDelegate;
    }
}
