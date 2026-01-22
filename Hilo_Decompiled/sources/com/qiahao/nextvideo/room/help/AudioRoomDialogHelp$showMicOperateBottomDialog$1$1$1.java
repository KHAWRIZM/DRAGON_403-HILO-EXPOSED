package com.qiahao.nextvideo.room.help;

import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.room.dialog.MicOperateListener;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomDialogHelp$showMicOperateBottomDialog$1$1$1", "Lcom/qiahao/nextvideo/room/dialog/MicOperateListener;", "unlockTheMic", "", "micMute", "lockMic", "", "takeTheMic", "lockTheMic", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomDialogHelp$showMicOperateBottomDialog$1$1$1 implements MicOperateListener {
    final /* synthetic */ MicroBean $micBean;
    final /* synthetic */ int $position;
    final /* synthetic */ AudioRoomDialogHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomDialogHelp$showMicOperateBottomDialog$1$1$1(AudioRoomDialogHelp audioRoomDialogHelp, int i, MicroBean microBean) {
        this.this$0 = audioRoomDialogHelp;
        this.$position = i;
        this.$micBean = microBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit takeTheMic$lambda$0(AudioRoomDialogHelp audioRoomDialogHelp, int i, MicroBean microBean) {
        boolean z;
        RoomViewModel mViewModel = audioRoomDialogHelp.getFragment().getMViewModel();
        Integer valueOf = Integer.valueOf(i);
        if (microBean != null && microBean.getMicForbid()) {
            z = true;
        } else {
            z = false;
        }
        RoomViewModel.upMic$default(mViewModel, valueOf, null, z, 2, null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.room.dialog.MicOperateListener
    public void lockTheMic() {
        AudioRoomDialogHelp.showToastOrLog$default(this.this$0, null, "lockTheMic:", false, 5, null);
        this.this$0.getFragment().getMViewModel().lockMic(this.$position);
    }

    @Override // com.qiahao.nextvideo.room.dialog.MicOperateListener
    public void micMute(boolean lockMic) {
        if (lockMic) {
            this.this$0.getFragment().getMViewModel().muteByIndex(this.$position);
        } else {
            this.this$0.getFragment().getMViewModel().unMuteByIndex(this.$position);
        }
    }

    @Override // com.qiahao.nextvideo.room.dialog.MicOperateListener
    public void takeTheMic() {
        if (FastClickUtils.INSTANCE.isFastClick()) {
            AudioRoomFragment fragment = this.this$0.getFragment();
            final AudioRoomDialogHelp audioRoomDialogHelp = this.this$0;
            final int i = this.$position;
            final MicroBean microBean = this.$micBean;
            fragment.checkMicrophonePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.s0
                public final Object invoke() {
                    Unit takeTheMic$lambda$0;
                    takeTheMic$lambda$0 = AudioRoomDialogHelp$showMicOperateBottomDialog$1$1$1.takeTheMic$lambda$0(AudioRoomDialogHelp.this, i, microBean);
                    return takeTheMic$lambda$0;
                }
            });
        }
    }

    @Override // com.qiahao.nextvideo.room.dialog.MicOperateListener
    public void unlockTheMic() {
        AudioRoomDialogHelp.showToastOrLog$default(this.this$0, null, "onLockMic: " + this.$position + " 锁麦位点击", false, 5, null);
        this.this$0.getFragment().getMViewModel().unlockMic(this.$position);
    }
}
