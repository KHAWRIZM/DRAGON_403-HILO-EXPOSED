package com.tencent.imsdk.message;

import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessageListener {
    public void onGroupMessagePinned(String str, Message message, boolean z, GroupMemberInfo groupMemberInfo) {
    }

    public void onReceiveC2CMessageReceipt(List<C2CMessageReceipt> list) {
    }

    public void onReceiveGroupMessageReceipt(List<GroupMessageReceipt> list) {
    }

    public void onReceiveMessageExtensionsChanged(MessageKey messageKey, List<MessageExtension> list) {
    }

    public void onReceiveMessageExtensionsDeleted(MessageKey messageKey, List<MessageExtension> list) {
    }

    public void onReceiveMessageModified(List<Message> list) {
    }

    public void onReceiveMessageReactionsChanged(List<MessageReactionChangeInfo> list) {
    }

    public void onReceiveMessageRevoked(Map<MessageKey, Map<UserInfo, String>> map) {
    }

    public void onReceiveNewMessage(List<Message> list) {
    }
}
