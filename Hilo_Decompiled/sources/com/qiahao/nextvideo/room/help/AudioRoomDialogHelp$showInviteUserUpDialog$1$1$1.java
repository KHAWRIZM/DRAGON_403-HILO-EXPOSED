package com.qiahao.nextvideo.room.help;

import android.widget.ImageView;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.hilo_message.databinding.RoomMessageViewBinding;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomDialogHelp$showInviteUserUpDialog$1$1$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "cancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomDialogHelp$showInviteUserUpDialog$1$1$1 implements OnCommonDialogListener {
    final /* synthetic */ AudioRoomDialogHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomDialogHelp$showInviteUserUpDialog$1$1$1(AudioRoomDialogHelp audioRoomDialogHelp) {
        this.this$0 = audioRoomDialogHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(final AudioRoomDialogHelp audioRoomDialogHelp) {
        audioRoomDialogHelp.getFragment().checkMicrophonePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.r0
            public final Object invoke() {
                Unit confirm$lambda$1$lambda$0;
                confirm$lambda$1$lambda$0 = AudioRoomDialogHelp$showInviteUserUpDialog$1$1$1.confirm$lambda$1$lambda$0(AudioRoomDialogHelp.this);
                return confirm$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1$lambda$0(AudioRoomDialogHelp audioRoomDialogHelp) {
        RoomMessageViewBinding messageBinding;
        RoomInputView roomInputView;
        ImageView imageView;
        NewMicroView newMicroView;
        FragmentAudioRoomBinding binding = audioRoomDialogHelp.getFragment().getBinding();
        if (binding != null && (newMicroView = binding.microView) != null) {
            newMicroView.setVisibility(0);
        }
        FragmentAudioRoomBinding binding2 = audioRoomDialogHelp.getFragment().getBinding();
        if (binding2 != null && (imageView = binding2.closeMicTip) != null) {
            imageView.setVisibility(8);
        }
        RoomMessageView mChatLayout = audioRoomDialogHelp.getFragment().getMChatLayout();
        if (mChatLayout != null && (messageBinding = mChatLayout.messageBinding()) != null && (roomInputView = messageBinding.chatInputLayout) != null) {
            roomInputView.changeRoomSoundStatus(true);
        }
        MeetingRoomManager.INSTANCE.setLocalRoomMicStatus(true);
        RoomViewModel.upMic$default(audioRoomDialogHelp.getFragment().getMViewModel(), null, null, false, 6, null);
        return Unit.INSTANCE;
    }

    public void cancel() {
    }

    public void confirm() {
        int i;
        Integer touristMic;
        AudioRoomDialogHelp audioRoomDialogHelp = this.this$0;
        GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomDialogHelp.getFragment().getMViewModel().getMGroupDetailBean().getValue();
        if (groupDetailBean != null && (touristMic = groupDetailBean.getTouristMic()) != null) {
            i = touristMic.intValue();
        } else {
            i = 1;
        }
        final AudioRoomDialogHelp audioRoomDialogHelp2 = this.this$0;
        audioRoomDialogHelp.checkTouristRole(i, new Function0() { // from class: com.qiahao.nextvideo.room.help.q0
            public final Object invoke() {
                Unit confirm$lambda$1;
                confirm$lambda$1 = AudioRoomDialogHelp$showInviteUserUpDialog$1$1$1.confirm$lambda$1(AudioRoomDialogHelp.this);
                return confirm$lambda$1;
            }
        });
    }
}
