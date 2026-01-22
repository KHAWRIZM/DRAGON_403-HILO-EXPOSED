package com.qiahao.nextvideo.room.help;

import android.widget.ImageView;
import com.qiahao.hilo_message.databinding.RoomMessageViewBinding;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.dialog.InviteTakeMicGetDiamondDialogListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$inviteUserUpMicToCompeleReward$1$1", "Lcom/qiahao/nextvideo/room/dialog/InviteTakeMicGetDiamondDialogListener;", "upMic", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$inviteUserUpMicToCompeleReward$1$1 implements InviteTakeMicGetDiamondDialogListener {
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomFragmentHelp$inviteUserUpMicToCompeleReward$1$1(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        this.this$0 = audioRoomFragmentHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upMic$lambda$1(final AudioRoomFragmentHelp audioRoomFragmentHelp) {
        audioRoomFragmentHelp.getFragment().checkMicrophonePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.z2
            public final Object invoke() {
                Unit upMic$lambda$1$lambda$0;
                upMic$lambda$1$lambda$0 = AudioRoomFragmentHelp$inviteUserUpMicToCompeleReward$1$1.upMic$lambda$1$lambda$0(AudioRoomFragmentHelp.this);
                return upMic$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upMic$lambda$1$lambda$0(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        ImageView imageView;
        FragmentAudioRoomBinding binding = audioRoomFragmentHelp.getFragment().getBinding();
        if (binding != null && (imageView = binding.closeMicTip) != null) {
            imageView.setVisibility(8);
        }
        RoomMessageView mChatLayout = audioRoomFragmentHelp.getFragment().getMChatLayout();
        if (mChatLayout != null && (messageBinding = mChatLayout.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
            roomInputView.changeRoomSoundStatus(true);
        }
        MeetingRoomManager.INSTANCE.setLocalRoomMicStatus(true);
        RoomViewModel.upMic$default(audioRoomFragmentHelp.getFragment().getMViewModel(), null, null, false, 6, null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.room.dialog.InviteTakeMicGetDiamondDialogListener
    public void upMic() {
        int i;
        Integer touristMic;
        AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
        if (mDialogHelp != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (touristMic = groupDetailBean.getTouristMic()) != null) {
                i = touristMic.intValue();
            } else {
                i = 1;
            }
            final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
            mDialogHelp.checkTouristRole(i, new Function0() { // from class: com.qiahao.nextvideo.room.help.a3
                public final Object invoke() {
                    Unit upMic$lambda$1;
                    upMic$lambda$1 = AudioRoomFragmentHelp$inviteUserUpMicToCompeleReward$1$1.upMic$lambda$1(AudioRoomFragmentHelp.this);
                    return upMic$lambda$1;
                }
            });
        }
    }
}
