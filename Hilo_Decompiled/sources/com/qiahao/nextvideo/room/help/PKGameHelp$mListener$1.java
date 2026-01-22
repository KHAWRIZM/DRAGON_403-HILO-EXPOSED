package com.qiahao.nextvideo.room.help;

import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/qiahao/nextvideo/room/help/PKGameHelp$mListener$1", "Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "onAvatarBtnClick", "", "position", "", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "onUnLockMic", "onMicroClick", "onUnMuteAvatarClick", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKGameHelp$mListener$1 implements OnMeetingRoomMicroItemClickListener {
    final /* synthetic */ PKGameHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PKGameHelp$mListener$1(PKGameHelp pKGameHelp) {
        this.this$0 = pKGameHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMicroClick$lambda$1(final PKGameHelp pKGameHelp, final int i, final MicroBean microBean) {
        pKGameHelp.getFragment().checkMicrophonePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.d8
            public final Object invoke() {
                Unit onMicroClick$lambda$1$lambda$0;
                onMicroClick$lambda$1$lambda$0 = PKGameHelp$mListener$1.onMicroClick$lambda$1$lambda$0(PKGameHelp.this, i, microBean);
                return onMicroClick$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMicroClick$lambda$1$lambda$0(PKGameHelp pKGameHelp, int i, MicroBean microBean) {
        boolean z;
        RoomViewModel mViewModel = pKGameHelp.getFragment().getMViewModel();
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
        Boolean bool;
        AudioRoomDialogHelp mDialogHelp;
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        Boolean bool2 = null;
        if (mpk != null) {
            bool = Boolean.valueOf(mpk.checkIsInvite());
        } else {
            bool = null;
        }
        if (micBean != null) {
            bool2 = Boolean.valueOf(micBean.isRed());
        }
        if (!Intrinsics.areEqual(bool, bool2)) {
            this.this$0.toRoomTip();
            return;
        }
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
        Boolean bool;
        String str;
        Integer touristMic;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        RoomPK mpk = meetingRoomManager.getMPK();
        Boolean bool2 = null;
        if (mpk != null) {
            bool = Boolean.valueOf(mpk.checkIsInvite());
        } else {
            bool = null;
        }
        if (micBean != null) {
            bool2 = Boolean.valueOf(micBean.isRed());
        }
        if (!Intrinsics.areEqual(bool, bool2)) {
            this.this$0.toRoomTip();
            return;
        }
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
            final PKGameHelp pKGameHelp = this.this$0;
            mDialogHelp2.checkTouristRole(i, new Function0() { // from class: com.qiahao.nextvideo.room.help.c8
                public final Object invoke() {
                    Unit onMicroClick$lambda$1;
                    onMicroClick$lambda$1 = PKGameHelp$mListener$1.onMicroClick$lambda$1(PKGameHelp.this, position, micBean);
                    return onMicroClick$lambda$1;
                }
            });
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener
    public void onUnLockMic(int position, MicroBean micBean) {
        Boolean bool;
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        Boolean bool2 = null;
        if (mpk != null) {
            bool = Boolean.valueOf(mpk.checkIsInvite());
        } else {
            bool = null;
        }
        if (micBean != null) {
            bool2 = Boolean.valueOf(micBean.isRed());
        }
        if (!Intrinsics.areEqual(bool, bool2)) {
            this.this$0.toRoomTip();
            return;
        }
        AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
        if (mDialogHelp != null) {
            mDialogHelp.showMicOperateBottomDialog(position, micBean, false);
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.OnMeetingRoomMicroItemClickListener
    public void onUnMuteAvatarClick(int position, MicroBean micBean) {
        Boolean bool;
        AudioRoomDialogHelp mDialogHelp;
        RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
        Boolean bool2 = null;
        if (mpk != null) {
            bool = Boolean.valueOf(mpk.checkIsInvite());
        } else {
            bool = null;
        }
        if (micBean != null) {
            bool2 = Boolean.valueOf(micBean.isRed());
        }
        if (!Intrinsics.areEqual(bool, bool2)) {
            this.this$0.toRoomTip();
            return;
        }
        if (micBean != null && (mDialogHelp = this.this$0.getFragment().getMDialogHelp()) != null) {
            String externalId = micBean.getExternalId();
            if (externalId == null) {
                externalId = "";
            }
            mDialogHelp.showUserInfoDialog(externalId, position);
        }
    }
}
