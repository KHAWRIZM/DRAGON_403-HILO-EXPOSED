package com.qiahao.nextvideo.room.help;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.data.game.Pk1v1End;
import com.qiahao.nextvideo.databinding.RoomPk1v1Binding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/qiahao/nextvideo/room/help/Pk1v1Help$countDown$1", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Pk1v1Help$countDown$1 extends CountDownTimer {
    final /* synthetic */ boolean $isEnd;
    final /* synthetic */ Pk1v1Help this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pk1v1Help$countDown$1(boolean z, Pk1v1Help pk1v1Help, long j) {
        super(j, 1000L);
        this.$isEnd = z;
        this.this$0 = pk1v1Help;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFinish$lambda$1(final Pk1v1Help pk1v1Help) {
        if (!pk1v1Help.getFragment().isDetached() && pk1v1Help.getFragment().getContext() != null) {
            pk1v1Help.getFragment().getMViewModel().pk1v1(new Function1() { // from class: com.qiahao.nextvideo.room.help.i8
                public final Object invoke(Object obj) {
                    Unit onFinish$lambda$1$lambda$0;
                    onFinish$lambda$1$lambda$0 = Pk1v1Help$countDown$1.onFinish$lambda$1$lambda$0(Pk1v1Help.this, (Pk1v1End) obj);
                    return onFinish$lambda$1$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFinish$lambda$1$lambda$0(Pk1v1Help pk1v1Help, Pk1v1End pk1v1End) {
        Intrinsics.checkNotNullParameter(pk1v1End, "it");
        Integer status = pk1v1End.getStatus();
        if (status != null && status.intValue() == 2) {
            pk1v1Help.pkEnd(pk1v1End);
        }
        return Unit.INSTANCE;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        TextView textView;
        TextView textView2;
        if (this.$isEnd) {
            this.this$0.setEndTime(10L);
            RoomPk1v1Binding binding = this.this$0.getBinding();
            if (binding != null && (textView2 = binding.time) != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131953660), Arrays.copyOf(new Object[]{"00:00"}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
            }
            this.this$0.startOrEndAnimation(true);
        } else {
            RoomPk1v1Binding binding2 = this.this$0.getBinding();
            if (binding2 != null && (textView = binding2.time) != null) {
                textView.setText("00:00");
            }
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            final Pk1v1Help pk1v1Help = this.this$0;
            hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.h8
                @Override // java.lang.Runnable
                public final void run() {
                    Pk1v1Help$countDown$1.onFinish$lambda$1(Pk1v1Help.this);
                }
            }, 2000L);
        }
        this.this$0.setTimerTask(null);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long millisUntilFinished) {
        String c;
        TextView textView;
        TextView textView2;
        if (millisUntilFinished < 1000) {
            c = "00:00";
        } else {
            c = com.qiahao.base_common.utils.f.c((int) (millisUntilFinished / 1000));
        }
        if (this.$isEnd) {
            RoomPk1v1Binding binding = this.this$0.getBinding();
            if (binding != null && (textView2 = binding.time) != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131953660), Arrays.copyOf(new Object[]{c}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
                return;
            }
            return;
        }
        RoomPk1v1Binding binding2 = this.this$0.getBinding();
        if (binding2 != null && (textView = binding2.time) != null) {
            textView.setText(c);
        }
    }
}
