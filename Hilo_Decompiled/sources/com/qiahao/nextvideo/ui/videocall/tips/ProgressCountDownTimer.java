package com.qiahao.nextvideo.ui.videocall.tips;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import com.qiahao.nextvideo.databinding.ViewMaskCoverRemoteSpecifyBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/tips/ProgressCountDownTimer;", "Landroid/os/CountDownTimer;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewMaskCoverRemoteSpecifyBinding;", "millisInFuture", "", "countDownInterval", "<init>", "(Lcom/qiahao/nextvideo/databinding/ViewMaskCoverRemoteSpecifyBinding;JJ)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewMaskCoverRemoteSpecifyBinding;", "onFinish", "", "onTick", "millisUntilFinished", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ProgressCountDownTimer extends CountDownTimer {

    @NotNull
    private final ViewMaskCoverRemoteSpecifyBinding binding;

    public /* synthetic */ ProgressCountDownTimer(ViewMaskCoverRemoteSpecifyBinding viewMaskCoverRemoteSpecifyBinding, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewMaskCoverRemoteSpecifyBinding, (i & 2) != 0 ? 4800L : j, (i & 4) != 0 ? 1000L : j2);
    }

    @NotNull
    public final ViewMaskCoverRemoteSpecifyBinding getBinding() {
        return this.binding;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        try {
            this.binding.removeMaskButton.setEnabled(true);
            ViewMaskCoverRemoteSpecifyBinding viewMaskCoverRemoteSpecifyBinding = this.binding;
            viewMaskCoverRemoteSpecifyBinding.removeMaskButton.setText(viewMaskCoverRemoteSpecifyBinding.getRoot().getContext().getString(2131953906));
            this.binding.removeMaskButton.setAlpha(1.0f);
        } catch (Exception unused) {
        }
    }

    @Override // android.os.CountDownTimer
    @SuppressLint({"SetTextI18n"})
    public void onTick(long millisUntilFinished) {
        try {
            ViewMaskCoverRemoteSpecifyBinding viewMaskCoverRemoteSpecifyBinding = this.binding;
            viewMaskCoverRemoteSpecifyBinding.removeMaskButton.setText(viewMaskCoverRemoteSpecifyBinding.getRoot().getContext().getString(2131953906) + "(" + ((millisUntilFinished / 1000) + 1) + "s)");
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressCountDownTimer(@NotNull ViewMaskCoverRemoteSpecifyBinding viewMaskCoverRemoteSpecifyBinding, long j, long j2) {
        super(j, j2);
        Intrinsics.checkNotNullParameter(viewMaskCoverRemoteSpecifyBinding, "binding");
        this.binding = viewMaskCoverRemoteSpecifyBinding;
    }
}
