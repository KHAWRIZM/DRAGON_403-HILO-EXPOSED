package com.tencent.imsdk.conversation;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class ConversationListener {
    public void onConversationChanged(List<Conversation> list) {
    }

    public void onConversationDeleted(List<String> list) {
    }

    public void onConversationGroupCreated(String str, List<Conversation> list) {
    }

    public void onConversationGroupDeleted(String str) {
    }

    public void onConversationGroupNameChanged(String str, String str2) {
    }

    public void onConversationGroupOrderDataChanged(String str) {
    }

    public void onConversationsAddedToGroup(String str, List<Conversation> list) {
    }

    public void onConversationsDeletedFromGroup(String str, List<Conversation> list, int i) {
    }

    public void onNewConversation(List<Conversation> list) {
    }

    public void onSyncServerFailed() {
    }

    public void onSyncServerFinish() {
    }

    public void onSyncServerStart() {
    }

    public void onUnreadMessageCountChanged(UnreadMessageCountResult unreadMessageCountResult) {
    }
}
