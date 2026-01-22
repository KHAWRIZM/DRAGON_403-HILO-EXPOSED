package com.tencent.imsdk.v2;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class V2TIMAdvancedMsgListener {
    public void onGroupMessagePinned(String str, V2TIMMessage v2TIMMessage, boolean z, V2TIMGroupMemberInfo v2TIMGroupMemberInfo) {
    }

    public void onRecvC2CReadReceipt(List<V2TIMMessageReceipt> list) {
    }

    public void onRecvMessageExtensionsChanged(String str, List<V2TIMMessageExtension> list) {
    }

    public void onRecvMessageExtensionsDeleted(String str, List<String> list) {
    }

    public void onRecvMessageModified(V2TIMMessage v2TIMMessage) {
    }

    public void onRecvMessageReactionsChanged(List<V2TIMMessageReactionChangeInfo> list) {
    }

    public void onRecvMessageReadReceipts(List<V2TIMMessageReceipt> list) {
    }

    @Deprecated
    public void onRecvMessageRevoked(String str) {
    }

    public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
    }

    public void onRecvMessageRevoked(String str, V2TIMUserFullInfo v2TIMUserFullInfo, String str2) {
    }
}
