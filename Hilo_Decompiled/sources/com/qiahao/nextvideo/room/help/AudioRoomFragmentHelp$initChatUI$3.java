package com.qiahao.nextvideo.room.help;

import android.content.Intent;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.room.activity.RoomMemberOnlineActivity;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.im.RoomMessageUtil;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/qiahao/nextvideo/room/help/AudioRoomFragmentHelp$initChatUI$3", "Lcom/qiahao/nextvideo/room/view/OnGroupInputLayoutListener;", "onStartGroupMemberSelectActivity", "", TUIConstants.TUIChat.METHOD_SEND_MESSAGE, "msg", "", "mentionUsers", "", "LroomMessage/RoomMessage$TextElemContentAt;", "setShowSelectPicVideo", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomFragmentHelp$initChatUI$3 implements OnGroupInputLayoutListener {
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioRoomFragmentHelp$initChatUI$3(AudioRoomFragmentHelp audioRoomFragmentHelp) {
        this.this$0 = audioRoomFragmentHelp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendMessage$lambda$0(String str, List list, AudioRoomFragmentHelp audioRoomFragmentHelp) {
        RoomMessageUtil.sendMessage$default(RoomMessageUtil.INSTANCE, audioRoomFragmentHelp.getFragment().getMChatLayout(), BuildMessageUtilsKt.roomMessageText(MeetingRoomManager.INSTANCE.getMGroupId(), str, list), false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setShowSelectPicVideo$lambda$1(final AudioRoomFragmentHelp audioRoomFragmentHelp) {
        audioRoomFragmentHelp.choosePicture(new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initChatUI$3$setShowSelectPicVideo$1$1
            public void onCancel() {
            }

            public void onResult(ArrayList<LocalMedia> result) {
                if (result != null && (!result.isEmpty())) {
                    AudioRoomFragmentHelp audioRoomFragmentHelp2 = AudioRoomFragmentHelp.this;
                    for (LocalMedia localMedia : result) {
                        if (localMedia.getMimeType() != null) {
                            String mimeType = localMedia.getMimeType();
                            Intrinsics.checkNotNullExpressionValue(mimeType, "getMimeType(...)");
                            if (StringsKt.contains$default(mimeType, "video", false, 2, (Object) null)) {
                                audioRoomFragmentHelp2.sendVideo(localMedia);
                            }
                        }
                        if (localMedia.getMimeType() != null) {
                            String mimeType2 = localMedia.getMimeType();
                            Intrinsics.checkNotNullExpressionValue(mimeType2, "getMimeType(...)");
                            if (StringsKt.contains$default(mimeType2, "image", false, 2, (Object) null)) {
                                audioRoomFragmentHelp2.sendImage(localMedia);
                            }
                        }
                    }
                }
            }
        });
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener
    public void onStartGroupMemberSelectActivity() {
        AudioRoomFragmentHelp.showToastOrLog$default(this.this$0, null, "onStartGroupMemberSelectActivity: ", false, 5, null);
        Intent intent = new Intent(this.this$0.getFragment().getContext(), (Class<?>) RoomMemberOnlineActivity.class);
        intent.putExtra("group_id", this.this$0.getFragment().getMViewModel().getMGroupId());
        intent.putExtra(RoomMemberOnlineActivity.IS_AT_USER, true);
        intent.putExtra(RoomMemberOnlineActivity.VISITOR_USER, false);
        FragmentActivity activity = this.this$0.getFragment().getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, 3);
        }
    }

    @Override // com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener
    public void sendMessage(final String msg, final List<RoomMessage.TextElemContentAt> mentionUsers) {
        int i;
        Integer touristSendMsg;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            try {
                AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
                if (mDialogHelp != null) {
                    GroupDetailBean groupDetailBean = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean != null && (touristSendMsg = groupDetailBean.getTouristSendMsg()) != null) {
                        i = touristSendMsg.intValue();
                    } else {
                        i = 1;
                    }
                    final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
                    mDialogHelp.checkTouristRole(i, new Function0() { // from class: com.qiahao.nextvideo.room.help.s2
                        public final Object invoke() {
                            Unit sendMessage$lambda$0;
                            sendMessage$lambda$0 = AudioRoomFragmentHelp$initChatUI$3.sendMessage$lambda$0(msg, mentionUsers, audioRoomFragmentHelp);
                            return sendMessage$lambda$0;
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Unit unit2 = Unit.INSTANCE;
                return;
            }
        }
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.this$0.getFragment().getContext(), ResourcesKtxKt.getStringById(this, 2131954113), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    @Override // com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener
    public void setShowSelectPicVideo() {
        int i;
        Integer touristSendPic;
        AudioRoomDialogHelp mDialogHelp = this.this$0.getFragment().getMDialogHelp();
        if (mDialogHelp != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.this$0.getFragment().getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (touristSendPic = groupDetailBean.getTouristSendPic()) != null) {
                i = touristSendPic.intValue();
            } else {
                i = 1;
            }
            final AudioRoomFragmentHelp audioRoomFragmentHelp = this.this$0;
            mDialogHelp.checkTouristRole(i, new Function0() { // from class: com.qiahao.nextvideo.room.help.r2
                public final Object invoke() {
                    Unit showSelectPicVideo$lambda$1;
                    showSelectPicVideo$lambda$1 = AudioRoomFragmentHelp$initChatUI$3.setShowSelectPicVideo$lambda$1(AudioRoomFragmentHelp.this);
                    return showSelectPicVideo$lambda$1;
                }
            });
        }
    }
}
