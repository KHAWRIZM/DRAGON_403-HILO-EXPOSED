package com.tencent.qgame.animplayer.util;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tencent/qgame/animplayer/util/SpeedControlUtil;", "", "()V", "ONE_MILLION", "", "fixedFrameDurationUsec", "loopReset", "", "prevMonoUsec", "prevPresentUsec", "preRender", "", "presentationTimeUsec", "reset", "setFixedPlaybackRate", "fps", "", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class SpeedControlUtil {
    private static final String TAG = "AnimPlayer.SpeedControlUtil";
    private long fixedFrameDurationUsec;
    private long prevMonoUsec;
    private long prevPresentUsec;
    private final long ONE_MILLION = 1000000;
    private boolean loopReset = true;

    public final void preRender(long presentationTimeUsec) {
        long j = this.prevMonoUsec;
        long j2 = 0;
        if (j == 0) {
            this.prevMonoUsec = System.nanoTime() / 1000;
            this.prevPresentUsec = presentationTimeUsec;
            return;
        }
        if (this.loopReset) {
            this.prevPresentUsec = presentationTimeUsec - (this.ONE_MILLION / 30);
            this.loopReset = false;
        }
        long j3 = this.fixedFrameDurationUsec;
        if (j3 == 0) {
            j3 = presentationTimeUsec - this.prevPresentUsec;
        }
        if (j3 >= 0) {
            long j4 = this.ONE_MILLION;
            if (j3 > 10 * j4) {
                j2 = j4 * 5;
            } else {
                j2 = j3;
            }
        }
        long j5 = j + j2;
        long nanoTime = System.nanoTime();
        long j6 = 1000;
        while (true) {
            long j7 = nanoTime / j6;
            if (j7 < j5 - 100) {
                long j8 = j5 - j7;
                if (j8 > 500000) {
                    j8 = 500000;
                }
                try {
                    Thread.sleep(j8 / j6, ((int) (j8 % j6)) * 1000);
                } catch (InterruptedException e) {
                    ALog.INSTANCE.e(TAG, "e=" + e, e);
                }
                nanoTime = System.nanoTime();
            } else {
                this.prevMonoUsec += j2;
                this.prevPresentUsec += j2;
                return;
            }
        }
    }

    public final void reset() {
        this.prevPresentUsec = 0L;
        this.prevMonoUsec = 0L;
    }

    public final void setFixedPlaybackRate(int fps) {
        if (fps <= 0) {
            return;
        }
        this.fixedFrameDurationUsec = this.ONE_MILLION / fps;
    }
}
