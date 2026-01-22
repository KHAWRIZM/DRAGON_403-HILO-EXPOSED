package com.qiahao.nextvideo.ui.im;

import android.text.TextUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.strange.StrangeItemData;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMGroupAtInfo;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/im/MessageInfoUtils;", "", "<init>", "()V", "conversationToMessageListInfo", "Lcom/qiahao/nextvideo/ui/im/MessageListInfo;", "conversation", "Lcom/tencent/imsdk/v2/V2TIMConversation;", "conversationToStrange", "Lcom/qiahao/nextvideo/data/strange/StrangeItemData;", "getLastMessage", "", "lastMsg", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "getAtInfoType", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageInfoUtils {

    @NotNull
    public static final MessageInfoUtils INSTANCE = new MessageInfoUtils();

    private MessageInfoUtils() {
    }

    private final int getAtInfoType(V2TIMConversation conversation) {
        List<V2TIMGroupAtInfo> groupAtInfoList = conversation.getGroupAtInfoList();
        if (groupAtInfoList == null || groupAtInfoList.isEmpty()) {
            return 0;
        }
        boolean z = false;
        boolean z2 = false;
        for (V2TIMGroupAtInfo v2TIMGroupAtInfo : groupAtInfoList) {
            if (v2TIMGroupAtInfo.getAtType() != 1) {
                if (v2TIMGroupAtInfo.getAtType() == 2) {
                    z = true;
                } else if (v2TIMGroupAtInfo.getAtType() == 3) {
                    z = true;
                }
            }
            z2 = true;
        }
        if (z && z2) {
            return 3;
        }
        if (z) {
            return 2;
        }
        if (!z2) {
            return 0;
        }
        return 1;
    }

    private final String getLastMessage(V2TIMMessage lastMsg) {
        String str;
        int i;
        if (lastMsg.getStatus() == 6) {
            String sender = lastMsg.getSender();
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                str = user.getExternalId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(sender, str)) {
                i = 2131953933;
            } else {
                i = 2131953932;
            }
            return ResourcesKtxKt.getStringById(this, i);
        }
        int elemType = lastMsg.getElemType();
        if (elemType != 1) {
            if (elemType != 2) {
                if (elemType != 3) {
                    if (elemType != 4) {
                        if (elemType != 5) {
                            return ResourcesKtxKt.getStringById(this, 2131954263);
                        }
                        return ResourcesKtxKt.getStringById(this, 2131953028);
                    }
                    return ResourcesKtxKt.getStringById(this, 2131954462);
                }
                return ResourcesKtxKt.getStringById(this, 2131953109);
            }
            String onGetDisplayString = ChatMessageParser.parseMessage(lastMsg).onGetDisplayString();
            Intrinsics.checkNotNull(onGetDisplayString);
            return onGetDisplayString;
        }
        String text = lastMsg.getTextElem().getText();
        Intrinsics.checkNotNull(text);
        return text;
    }

    @NotNull
    public final MessageListInfo conversationToMessageListInfo(@NotNull V2TIMConversation conversation) {
        boolean z;
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        MessageListInfo messageListInfo = new MessageListInfo();
        V2TIMMessage lastMessage = conversation.getLastMessage();
        if (lastMessage != null) {
            messageListInfo.setLastMessageTime(lastMessage.getTimestamp());
            messageListInfo.setLastMessage(lastMessage);
            messageListInfo.setLastMessageStr(INSTANCE.getLastMessage(lastMessage));
        }
        if (conversation.getType() == 2) {
            z = true;
        } else {
            z = false;
        }
        messageListInfo.setGroup(z);
        int atInfoType = getAtInfoType(conversation);
        if (atInfoType != 1) {
            if (atInfoType != 2) {
                if (atInfoType != 3) {
                    messageListInfo.setAtInfoText("");
                } else {
                    messageListInfo.setAtInfoText(ResourcesKtxKt.getStringById(this, 2131954344));
                }
            } else {
                messageListInfo.setAtInfoText(ResourcesKtxKt.getStringById(this, 2131954343));
            }
        } else {
            messageListInfo.setAtInfoText(ResourcesKtxKt.getStringById(this, 2131954345));
        }
        messageListInfo.setTitle(conversation.getShowName());
        if (!messageListInfo.getIsGroup()) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(conversation.getFaceUrl())) {
                arrayList.add(2131231654);
            } else {
                String faceUrl = conversation.getFaceUrl();
                Intrinsics.checkNotNullExpressionValue(faceUrl, "getFaceUrl(...)");
                arrayList.add(faceUrl);
            }
            messageListInfo.setIconUrlList(arrayList);
        }
        if (messageListInfo.getIsGroup()) {
            messageListInfo.setId(conversation.getGroupID());
        } else {
            messageListInfo.setId(conversation.getUserID());
        }
        messageListInfo.setConversationId(conversation.getConversationID());
        if (!Intrinsics.areEqual("Public", conversation.getGroupType()) && !Intrinsics.areEqual("AVChatRoom", conversation.getGroupType())) {
            messageListInfo.setUnRead(conversation.getUnreadCount());
        }
        return messageListInfo;
    }

    @NotNull
    public final StrangeItemData conversationToStrange(@NotNull V2TIMConversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        StrangeItemData strangeItemData = new StrangeItemData(0, null, 0L, null, null, 0, null, 127, null);
        V2TIMMessage lastMessage = conversation.getLastMessage();
        if (lastMessage != null) {
            strangeItemData.setLastMessageTime(lastMessage.getTimestamp());
            strangeItemData.setLastMessageStr(INSTANCE.getLastMessage(lastMessage));
        }
        strangeItemData.setGroupId(conversation.getGroupID());
        if (Intrinsics.areEqual("Public", conversation.getGroupType())) {
            strangeItemData.setUnRead(conversation.getUnreadCount());
        }
        return strangeItemData;
    }
}
