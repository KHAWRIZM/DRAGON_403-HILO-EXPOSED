package com.qiahao.nextvideo.ui.videocall.matchinguser;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import com.qiahao.nextvideo.ui.videocall.CountDownTimerPreloadModel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoDownTimer;", "Landroid/os/CountDownTimer;", "preloadModel", "Lcom/qiahao/nextvideo/ui/videocall/CountDownTimerPreloadModel;", "<init>", "(Lcom/qiahao/nextvideo/ui/videocall/CountDownTimerPreloadModel;)V", "getPreloadModel", "()Lcom/qiahao/nextvideo/ui/videocall/CountDownTimerPreloadModel;", "setPreloadModel", "mListener", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoDownTimerListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoDownTimerListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/videocall/matchinguser/VideoDownTimerListener;)V", "isComingEndTipReminder", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onFinish", "", "onTick", "millisUntilFinished", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoDownTimer extends CountDownTimer {

    @NotNull
    public static final String TAG = "ProgressCountDownTimer";

    @NotNull
    private AtomicBoolean isComingEndTipReminder;

    @Nullable
    private VideoDownTimerListener mListener;

    @NotNull
    private CountDownTimerPreloadModel preloadModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoDownTimer(@NotNull CountDownTimerPreloadModel countDownTimerPreloadModel) {
        super(countDownTimerPreloadModel.getMillisInFuture(), countDownTimerPreloadModel.getCountDownInterval());
        Intrinsics.checkNotNullParameter(countDownTimerPreloadModel, "preloadModel");
        this.preloadModel = countDownTimerPreloadModel;
        this.isComingEndTipReminder = new AtomicBoolean(true);
    }

    @Nullable
    public final VideoDownTimerListener getMListener() {
        return this.mListener;
    }

    @NotNull
    public final CountDownTimerPreloadModel getPreloadModel() {
        return this.preloadModel;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        VideoDownTimerListener videoDownTimerListener = this.mListener;
        if (videoDownTimerListener != null) {
            videoDownTimerListener.onFinish();
        }
    }

    @Override // android.os.CountDownTimer
    @SuppressLint({"SetTextI18n"})
    public void onTick(long millisUntilFinished) {
        VideoDownTimerListener videoDownTimerListener;
        this.preloadModel.setCurrentCountDownValueInMills(millisUntilFinished);
        VideoDownTimerListener videoDownTimerListener2 = this.mListener;
        if (videoDownTimerListener2 != null) {
            videoDownTimerListener2.timerTick(millisUntilFinished, this.preloadModel.getTotalMills());
        }
        if (millisUntilFinished / 1000 > 3) {
            this.isComingEndTipReminder.set(true);
        } else if (this.isComingEndTipReminder.getAndSet(false) && (videoDownTimerListener = this.mListener) != null) {
            videoDownTimerListener.onTimerLine();
        }
    }

    public final void setMListener(@Nullable VideoDownTimerListener videoDownTimerListener) {
        this.mListener = videoDownTimerListener;
    }

    public final void setPreloadModel(@NotNull CountDownTimerPreloadModel countDownTimerPreloadModel) {
        Intrinsics.checkNotNullParameter(countDownTimerPreloadModel, "<set-?>");
        this.preloadModel = countDownTimerPreloadModel;
    }
}
