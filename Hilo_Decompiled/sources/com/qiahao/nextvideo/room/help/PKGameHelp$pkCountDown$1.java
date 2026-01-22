package com.qiahao.nextvideo.room.help;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.data.model.MyAward;
import com.qiahao.nextvideo.data.room.BoxData;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.databinding.ViewGamePkBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.rocket.RoomRocketRewardDialog;
import com.qiahao.nextvideo.view.PKSearchView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/qiahao/nextvideo/room/help/PKGameHelp$pkCountDown$1", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKGameHelp$pkCountDown$1 extends CountDownTimer {
    final /* synthetic */ Boolean $isEnd;
    final /* synthetic */ PKGameHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKGameHelp$pkCountDown$1(Boolean bool, PKGameHelp pKGameHelp, long j) {
        super(j, 1000L);
        this.$isEnd = bool;
        this.this$0 = pKGameHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFinish$lambda$2(Boolean bool, PKGameHelp pKGameHelp) {
        PKSearchView pKSearchView;
        ConstraintLayout constraintLayout;
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            RoomPK mpk = meetingRoomManager.getMPK();
            if (mpk != null) {
                mpk.setStatus(3);
            }
            meetingRoomManager.getWsFlow().tryEmit(RoomEvent.roomEvent$default(new RoomEvent(), RoomEvent.ROOM_PK_PUNISH, null, 2, null));
            FragmentAudioRoomBinding binding = pKGameHelp.getFragment().getBinding();
            if (binding != null && (constraintLayout = binding.pkLayout) != null) {
                constraintLayout.setVisibility(8);
            }
            FragmentAudioRoomBinding binding2 = pKGameHelp.getFragment().getBinding();
            if (binding2 != null && (pKSearchView = binding2.pkSearch) != null) {
                pKSearchView.stopAnimation();
            }
            AudioGameHelp mGameHelp = pKGameHelp.getFragment().getMGameHelp();
            if (mGameHelp != null) {
                AudioGameHelp.hideGameView$default(mGameHelp, null, 1, null);
            }
            pKGameHelp.pkEnd();
            return;
        }
        pKGameHelp.getFragment().getMViewModel().getPKStatus();
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        TextView textView;
        TextView textView2;
        if (Intrinsics.areEqual(this.$isEnd, Boolean.TRUE)) {
            ViewGamePkBinding binding = this.this$0.getBinding();
            if (binding != null && (textView2 = binding.time) != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131953660), Arrays.copyOf(new Object[]{"00:00"}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
            }
        } else {
            ViewGamePkBinding binding2 = this.this$0.getBinding();
            if (binding2 != null && (textView = binding2.time) != null) {
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953659), Arrays.copyOf(new Object[]{"00:00"}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView.setText(format2);
            }
        }
        this.this$0.setTimerTask(null);
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final Boolean bool = this.$isEnd;
        final PKGameHelp pKGameHelp = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.e8
            @Override // java.lang.Runnable
            public final void run() {
                PKGameHelp$pkCountDown$1.onFinish$lambda$2(bool, pKGameHelp);
            }
        }, 2000L);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long millisUntilFinished) {
        String c;
        TextView textView;
        TextView textView2;
        int i;
        String str;
        Boolean bool;
        Long num;
        if (millisUntilFinished < 1000) {
            c = "00:00";
        } else {
            c = com.qiahao.base_common.utils.f.c((int) (millisUntilFinished / 1000));
        }
        if (((int) (millisUntilFinished / 1000)) == 5 && Intrinsics.areEqual(this.$isEnd, Boolean.TRUE) && ((BoxData) this.this$0.getFragment().getMViewModel().getMRoomPKBox().getValue()) != null) {
            PKGameHelp pKGameHelp = this.this$0;
            FragmentActivity activity = pKGameHelp.getFragment().getActivity();
            if (activity != null && !activity.isFinishing()) {
                BoxData boxData = (BoxData) pKGameHelp.getFragment().getMViewModel().getMRoomPKBox().getValue();
                if (boxData != null && (num = boxData.getNum()) != null) {
                    i = (int) num.longValue();
                } else {
                    i = 0;
                }
                BoxData boxData2 = (BoxData) pKGameHelp.getFragment().getMViewModel().getMRoomPKBox().getValue();
                if (boxData2 == null || (str = boxData2.getIcon()) == null) {
                    str = "";
                }
                BoxData boxData3 = (BoxData) pKGameHelp.getFragment().getMViewModel().getMRoomPKBox().getValue();
                if (boxData3 != null) {
                    bool = boxData3.getHasAward();
                } else {
                    bool = null;
                }
                new RoomRocketRewardDialog(activity, new MyAward(4, i, str, bool)).show();
            }
        }
        if (Intrinsics.areEqual(this.$isEnd, Boolean.TRUE)) {
            ViewGamePkBinding binding = this.this$0.getBinding();
            if (binding != null && (textView2 = binding.time) != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131953660), Arrays.copyOf(new Object[]{c}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
                return;
            }
            return;
        }
        ViewGamePkBinding binding2 = this.this$0.getBinding();
        if (binding2 != null && (textView = binding2.time) != null) {
            String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953659), Arrays.copyOf(new Object[]{c}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView.setText(format2);
        }
    }
}
