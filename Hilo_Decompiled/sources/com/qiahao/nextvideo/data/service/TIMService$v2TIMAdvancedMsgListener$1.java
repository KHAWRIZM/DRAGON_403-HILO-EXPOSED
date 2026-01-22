package com.qiahao.nextvideo.data.service;

import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.im.StrangerProvide;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"com/qiahao/nextvideo/data/service/TIMService$v2TIMAdvancedMsgListener$1", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "onRecvNewMessage", "", "msg", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "onRecvC2CReadReceipt", "receiptList", "", "Lcom/tencent/imsdk/v2/V2TIMMessageReceipt;", "onRecvMessageRevoked", "msgID", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TIMService$v2TIMAdvancedMsgListener$1 extends V2TIMAdvancedMsgListener {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRecvNewMessage$lambda$2$lambda$0() {
        StrangerProvide.INSTANCE.displayData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRecvNewMessage$lambda$2$lambda$1(V2TIMMessage v2TIMMessage) {
        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
        if (v2TIMMessage.getElemType() == 2) {
            TIMService.INSTANCE.getReceivedMessageRelay().accept(v2TIMMessage);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
    public void onRecvC2CReadReceipt(List<V2TIMMessageReceipt> receiptList) {
        super.onRecvC2CReadReceipt(receiptList);
    }

    @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
    public void onRecvMessageRevoked(String msgID) {
        super.onRecvMessageRevoked(msgID);
    }

    @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
    public void onRecvNewMessage(final V2TIMMessage msg) {
        super.onRecvNewMessage(msg);
        if (msg != null) {
            if (msg.getGroupID() != null) {
                if (msg.getCustomElem() != null) {
                    MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                    String groupID = msg.getGroupID();
                    Intrinsics.checkNotNullExpressionValue(groupID, "getGroupID(...)");
                    if (meetingRoomManager.currentInRoom(groupID)) {
                        TIMService.INSTANCE.dealWithGroupCustomMessage(msg);
                    }
                }
                MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                String groupID2 = msg.getGroupID();
                Intrinsics.checkNotNullExpressionValue(groupID2, "getGroupID(...)");
                if (!meetingRoomManager2.currentInRoom(groupID2)) {
                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.data.service.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            TIMService$v2TIMAdvancedMsgListener$1.onRecvNewMessage$lambda$2$lambda$0();
                        }
                    }, 500L);
                    return;
                }
                return;
            }
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.data.service.s
                @Override // java.lang.Runnable
                public final void run() {
                    TIMService$v2TIMAdvancedMsgListener$1.onRecvNewMessage$lambda$2$lambda$1(V2TIMMessage.this);
                }
            }, 500L);
        }
    }
}
