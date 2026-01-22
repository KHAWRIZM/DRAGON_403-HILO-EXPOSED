package com.qiahao.nextvideo.room.help;

import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$initClickListener$2", "Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "onAvatarBtnClick", "", "position", "", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "onUnLockMic", "onMicroClick", "onUnMuteAvatarClick", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$initClickListener$2 implements OnMeetingRoomMicroItemClickListener {
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomFragmentHelp$initClickListener$2(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        this.this$0 = audioRoomFragmentHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMicroClick$lambda$1(final AudioRoomFragmentHelp audioRoomFragmentHelp, final int i, final MicroBean microBean) {
        audioRoomFragmentHelp.getFragment().checkMicrophonePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.t2
            public final Object invoke() {
                Unit onMicroClick$lambda$1$lambda$0;
                onMicroClick$lambda$1$lambda$0 = AudioRoomFragmentHelp$initClickListener$2.onMicroClick$lambda$1$lambda$0(AudioRoomFragmentHelp.this, i, microBean);
                return onMicroClick$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMicroClick$lambda$1$lambda$0(AudioRoomFragmentHelp audioRoomFragmentHelp, int i, MicroBean microBean) {
        boolean z;
        RoomViewModel mViewModel = audioRoomFragmentHelp.getFragment().getMViewModel();
        Integer valueOf = Integer.valueOf(i);
        if (microBean != null && microBean.getMicForbid()) {
            z = true;
        } else {
            z = false;
        }
        RoomViewModel.upMic$default(mViewModel, valueOf, null, z, 2, null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener
    public void onAvatarBtnClick(int position, MicroBean micBean) {
        AudioRoomDialogHelp mDialogHelp;
        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "onAvatarBtnClick: " + position + " 用户头像点击", false, 5, null);
        if (micBean != null && (mDialogHelp = this.this$0.getFragment().getMDialogHelp()) != null) {
            String externalId = micBean.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            mDialogHelp.showUserInfoDialog(externalId, position);
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener
    public void onMicroClick(final int position, final MicroBean micBean) {
        String str;
        Integer touristMic;
        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "onMicroClick: " + position + " 麦位点击", false, 5, null);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        int roomUserRole = meetingRoomManager.getRoomUserRole(str);
        int i = 1;
        if (roomUserRole > 1) {
            AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.showMicOperateBottomDialog(position, micBean, true);
                return;
            }
            return;
        }
        AudioRoomDialogHelp mDialogHelp2 = this.this$0.getFragment().getMDialogHelp();
        if (mDialogHelp2 != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (touristMic = groupDetailBean.getTouristMic()) != null) {
                i = touristMic.intValue();
            }
            final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
            mDialogHelp2.checkTouristRole(i, new Function0() { // from class: com.qiahao.nextvideo.room.help.u2
                public final Object invoke() {
                    Unit onMicroClick$lambda$1;
                    onMicroClick$lambda$1 = AudioRoomFragmentHelp$initClickListener$2.onMicroClick$lambda$1(AudioRoomFragmentHelp.this, position, micBean);
                    return onMicroClick$lambda$1;
                }
            });
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener
    public void onUnLockMic(int position, MicroBean micBean) {
        AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
        if (mDialogHelp != null) {
            mDialogHelp.showMicOperateBottomDialog(position, micBean, false);
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener
    public void onUnMuteAvatarClick(int position, MicroBean micBean) {
        AudioRoomDialogHelp mDialogHelp;
        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "onMuteAvatarClick: " + position + " 静音头像点击", false, 5, null);
        if (micBean != null && (mDialogHelp = this.this$0.getFragment().getMDialogHelp()) != null) {
            String externalId = micBean.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            mDialogHelp.showUserInfoDialog(externalId, position);
        }
    }
}
