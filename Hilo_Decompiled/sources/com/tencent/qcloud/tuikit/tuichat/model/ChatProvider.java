package com.tencent.qcloud.tuikit.tuichat.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.gson.d;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMCompleteCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationOperationResult;
import com.tencent.imsdk.v2.V2TIMFriendInfoResult;
import com.tencent.imsdk.v2.V2TIMGroupApplication;
import com.tencent.imsdk.v2.V2TIMGroupApplicationResult;
import com.tencent.imsdk.v2.V2TIMGroupChangeInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfoResult;
import com.tencent.imsdk.v2.V2TIMGroupMessageReadMemberList;
import com.tencent.imsdk.v2.V2TIMGroupTipsElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMergerElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageListGetOption;
import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageFeature;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageContainerBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflinePushInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.tuichat.bean.UserStatusBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.OfflinePushInfoUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatProvider {
    public static final int ERR_REVOKE_TIME_LIMIT_EXCEED = 6223;
    public static final int ERR_REVOKE_TIME_LIMIT_SVR_GROUP = 10031;
    public static final int ERR_REVOKE_TIME_LIMIT_SVR_MESSAGE = 20016;
    private static final String TAG = "ChatProvider";

    private void setMessageTypingFeature(TUIMessageBean tUIMessageBean) {
        MessageFeature messageFeature = new MessageFeature();
        messageFeature.setNeedTyping(1);
        tUIMessageBean.setMessageTypingFeature(messageFeature);
    }

    public void addJoinGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        V2TIMGroupTipsElem v2TIMGroupTipsElem;
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        if (v2TIMMessage != null) {
            v2TIMGroupTipsElem = v2TIMMessage.getGroupTipsElem();
        } else {
            v2TIMGroupTipsElem = null;
        }
        if (v2TIMGroupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupMemberInfo> memberList = v2TIMGroupTipsElem.getMemberList();
        ArrayList arrayList = new ArrayList();
        if (memberList.size() > 0) {
            for (V2TIMGroupMemberInfo v2TIMGroupMemberInfo : memberList) {
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                groupMemberInfo.covertTIMGroupMemberInfo(v2TIMGroupMemberInfo);
                arrayList.add(groupMemberInfo);
            }
        } else {
            GroupMemberInfo groupMemberInfo2 = new GroupMemberInfo();
            groupMemberInfo2.covertTIMGroupMemberInfo(v2TIMGroupTipsElem.getOpMember());
            arrayList.add(groupMemberInfo2);
        }
        TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
    }

    public void addLeaveGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<List<String>> iUIKitCallback) {
        V2TIMGroupTipsElem v2TIMGroupTipsElem;
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        if (v2TIMMessage != null) {
            v2TIMGroupTipsElem = v2TIMMessage.getGroupTipsElem();
        } else {
            v2TIMGroupTipsElem = null;
        }
        if (v2TIMGroupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupMemberInfo> memberList = v2TIMGroupTipsElem.getMemberList();
        ArrayList arrayList = new ArrayList();
        if (memberList.size() > 0) {
            Iterator<V2TIMGroupMemberInfo> it = memberList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getUserID());
            }
        } else {
            arrayList.add(v2TIMGroupTipsElem.getOpMember().getUserID());
        }
        TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
    }

    public void addModifyGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<Pair<Integer, String>> iUIKitCallback) {
        V2TIMGroupTipsElem v2TIMGroupTipsElem;
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        if (v2TIMMessage != null) {
            v2TIMGroupTipsElem = v2TIMMessage.getGroupTipsElem();
        } else {
            v2TIMGroupTipsElem = null;
        }
        if (v2TIMGroupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupChangeInfo> groupChangeInfoList = v2TIMGroupTipsElem.getGroupChangeInfoList();
        if (groupChangeInfoList.size() > 0) {
            V2TIMGroupChangeInfo v2TIMGroupChangeInfo = groupChangeInfoList.get(0);
            int type = v2TIMGroupChangeInfo.getType();
            if (type == 1) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new Pair(Integer.valueOf(TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME), v2TIMGroupChangeInfo.getValue()));
            } else if (type == 3) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new Pair(Integer.valueOf(TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NOTICE), v2TIMGroupChangeInfo.getValue()));
            }
        }
    }

    public void c2cReadReport(String str) {
        V2TIMManager.getMessageManager().markC2CMessageAsRead(str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.4
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str2) {
                TUIChatLog.e(ChatProvider.TAG, "markC2CMessageAsRead setReadMessage failed, code = " + i + ", desc = " + ErrorMessageConverter.convertIMError(i, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatLog.d(ChatProvider.TAG, "markC2CMessageAsRead setReadMessage success");
            }
        });
        String str2 = TUIConstants.TUIConversation.CONVERSATION_C2C_PREFIX + str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        V2TIMManager.getConversationManager().markConversation(arrayList, V2TIMConversation.V2TIM_CONVERSATION_MARK_TYPE_UNREAD, false, new V2TIMValueCallback<List<V2TIMConversationOperationResult>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.5
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str3) {
                TUIChatLog.e(ChatProvider.TAG, "mark C2C conversation unread disable failed, code = " + i + ", desc = " + ErrorMessageConverter.convertIMError(i, str3));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMConversationOperationResult> list) {
                if (list.size() <= 0) {
                    TUIChatLog.e(ChatProvider.TAG, "mark C2C conversation unread disable failed, results size = 0");
                    return;
                }
                V2TIMConversationOperationResult v2TIMConversationOperationResult = list.get(0);
                TUIChatLog.d(ChatProvider.TAG, "mark C2C conversation unread disable success, code:" + v2TIMConversationOperationResult.getResultCode() + "|msg:" + v2TIMConversationOperationResult.getResultInfo());
            }
        });
    }

    public boolean checkFailedMessageInfo(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean == null || tUIMessageBean.getV2TIMMessage().getStatus() == 3) {
            return true;
        }
        return false;
    }

    public void deleteMessages(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().deleteMessages(arrayList, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.13
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str);
                TUIChatLog.w(ChatProvider.TAG, "deleteMessages code:" + i2 + "|desc:" + ErrorMessageConverter.convertIMError(i2, str));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatLog.i(ChatProvider.TAG, "deleteMessages success");
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void downloadMergerMessage(MergeMessageBean mergeMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMergerElem mergerElem = mergeMessageBean.getMergerElem();
        if (mergerElem != null) {
            mergerElem.downloadMergerMessage(new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.20
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, "MergeMessageElemBean", i, str);
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<V2TIMMessage> list) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
                }
            });
        }
    }

    public void findMessage(List<String> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMManager.getMessageManager().findMessages(list, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.18
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list2) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list2));
            }
        });
    }

    public void getConversationLastMessage(String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getConversationManager().getConversation(str, new V2TIMValueCallback<V2TIMConversation>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.15
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                Log.e(ChatProvider.TAG, "getConversationLastMessage error:" + i + ", desc:" + ErrorMessageConverter.convertIMError(i, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMConversation v2TIMConversation) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMConversation.getLastMessage()));
            }
        });
    }

    public void getFriendName(String str, final IUIKitCallback<String[]> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        V2TIMManager.getFriendshipManager().getFriendsInfo(arrayList, new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.17
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendInfoResult> list) {
                V2TIMFriendInfoResult v2TIMFriendInfoResult = list.get(0);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new String[]{v2TIMFriendInfoResult.getFriendInfo().getFriendRemark(), v2TIMFriendInfoResult.getFriendInfo().getUserProfile().getNickName()});
            }
        });
    }

    public void getGroupMembersInfo(String str, List<String> list, final IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        if (TUIChatUtils.isTopicGroup(str)) {
            str = TUIChatUtils.getGroupIDFromTopicID(str);
        }
        V2TIMManager.getGroupManager().getGroupMembersInfo(str, list, new V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.28
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMGroupMemberFullInfo> list2) {
                ArrayList arrayList = new ArrayList();
                Iterator<V2TIMGroupMemberFullInfo> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new GroupMemberInfo().covertTIMGroupMemberInfo(it.next()));
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void getGroupMessageBySeq(String str, long j, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(1);
        v2TIMMessageListGetOption.setGetType(3);
        v2TIMMessageListGetOption.setLastMsgSeq(j);
        v2TIMMessageListGetOption.setGroupID(str);
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.19
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i, str2);
                TUIChatLog.e(ChatProvider.TAG, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i + ", desc = " + str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void getGroupMessageReadMembers(TUIMessageBean tUIMessageBean, boolean z, int i, long j, final IUIKitCallback<GroupMessageReadMembersInfo> iUIKitCallback) {
        V2TIMManager.getMessageManager().getGroupMessageReadMemberList(tUIMessageBean.getV2TIMMessage(), !z ? 1 : 0, j, i, new V2TIMValueCallback<V2TIMGroupMessageReadMemberList>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.23
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMGroupMessageReadMemberList v2TIMGroupMessageReadMemberList) {
                GroupMessageReadMembersInfo groupMessageReadMembersInfo = new GroupMessageReadMembersInfo();
                groupMessageReadMembersInfo.setReadMembers(v2TIMGroupMessageReadMemberList);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, groupMessageReadMembersInfo);
            }
        });
    }

    public void getMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<List<MessageReceiptInfo>> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        Iterator<TUIMessageBean> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().getMessageReadReceipts(arrayList, new V2TIMValueCallback<List<V2TIMMessageReceipt>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.21
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessageReceipt> list2) {
                ArrayList arrayList2 = new ArrayList();
                for (V2TIMMessageReceipt v2TIMMessageReceipt : list2) {
                    MessageReceiptInfo messageReceiptInfo = new MessageReceiptInfo();
                    messageReceiptInfo.setMessageReceipt(v2TIMMessageReceipt);
                    arrayList2.add(messageReceiptInfo);
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList2);
            }
        });
    }

    public void getReactUserBean(List<String> list, final IUIKitCallback<List<ReactUserBean>> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().getFriendsInfo(list, new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.27
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMFriendInfoResult> list2) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendInfoResult v2TIMFriendInfoResult : list2) {
                    ReactUserBean reactUserBean = new ReactUserBean();
                    reactUserBean.setUserId(v2TIMFriendInfoResult.getFriendInfo().getUserID());
                    reactUserBean.setFriendRemark(v2TIMFriendInfoResult.getFriendInfo().getFriendRemark());
                    reactUserBean.setFaceUrl(v2TIMFriendInfoResult.getFriendInfo().getUserProfile().getFaceUrl());
                    if (v2TIMFriendInfoResult.getFriendInfo().getUserProfile() != null) {
                        reactUserBean.setNikeName(v2TIMFriendInfoResult.getFriendInfo().getUserProfile().getNickName());
                    }
                    arrayList.add(reactUserBean);
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void groupReadReport(String str) {
        V2TIMManager.getMessageManager().markGroupMessageAsRead(str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.6
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str2) {
                TUIChatLog.e(ChatProvider.TAG, "markGroupMessageAsRead failed, code = " + i + ", desc = " + ErrorMessageConverter.convertIMError(i, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatLog.d(ChatProvider.TAG, "markGroupMessageAsRead success");
            }
        });
        String str2 = TUIConstants.TUIConversation.CONVERSATION_GROUP_PREFIX + str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        V2TIMManager.getConversationManager().markConversation(arrayList, V2TIMConversation.V2TIM_CONVERSATION_MARK_TYPE_UNREAD, false, new V2TIMValueCallback<List<V2TIMConversationOperationResult>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.7
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str3) {
                TUIChatLog.e(ChatProvider.TAG, "mark group conversation unread disable failed, code = " + i + ", desc = " + ErrorMessageConverter.convertIMError(i, str3));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMConversationOperationResult> list) {
                if (list.size() <= 0) {
                    TUIChatLog.e(ChatProvider.TAG, "mark group conversation unread disable failed, results size = 0");
                    return;
                }
                V2TIMConversationOperationResult v2TIMConversationOperationResult = list.get(0);
                TUIChatLog.d(ChatProvider.TAG, "mark group conversation unread disable success, code:" + v2TIMConversationOperationResult.getResultCode() + "|msg:" + v2TIMConversationOperationResult.getResultInfo());
            }
        });
    }

    public void loadApplyInfo(final IUIKitCallback<List<GroupApplyInfo>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        V2TIMManager.getGroupManager().getGroupApplicationList(new V2TIMValueCallback<V2TIMGroupApplicationResult>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.8
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                TUIChatLog.e(ChatProvider.TAG, "getGroupPendencyList failed, code: " + i + "|desc: " + ErrorMessageConverter.convertIMError(i, str));
                iUIKitCallback.onError(ChatProvider.TAG, i, ErrorMessageConverter.convertIMError(i, str));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMGroupApplicationResult v2TIMGroupApplicationResult) {
                List<V2TIMGroupApplication> groupApplicationList = v2TIMGroupApplicationResult.getGroupApplicationList();
                for (int i = 0; i < groupApplicationList.size(); i++) {
                    GroupApplyInfo groupApplyInfo = new GroupApplyInfo(groupApplicationList.get(i));
                    groupApplyInfo.setStatus(0);
                    arrayList.add(groupApplyInfo);
                }
                iUIKitCallback.onSuccess(arrayList);
            }
        });
    }

    public void loadC2CMessage(String str, int i, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage;
        if (tUIMessageBean != null) {
            v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        } else {
            v2TIMMessage = null;
        }
        V2TIMManager.getMessageManager().getC2CHistoryMessageList(str, i, v2TIMMessage, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str2);
                TUIChatLog.e(ChatProvider.TAG, "loadChatMessages getC2CHistoryMessageList failed, code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadGroupMembers(String str, long j, final IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        V2TIMManager.getGroupManager().getGroupMemberList(str, 0, j, new V2TIMValueCallback<V2TIMGroupMemberInfoResult>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.30
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                TUIChatLog.e(ChatProvider.TAG, "loadGroupMembers failed, code: " + i + "|desc: " + ErrorMessageConverter.convertIMError(i, str2));
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < v2TIMGroupMemberInfoResult.getMemberInfoList().size(); i++) {
                    arrayList.add(new GroupMemberInfo().covertTIMGroupMemberInfo(v2TIMGroupMemberInfoResult.getMemberInfoList().get(i)));
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void loadGroupMessage(String str, int i, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage;
        if (tUIMessageBean != null) {
            v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        } else {
            v2TIMMessage = null;
        }
        V2TIMManager.getMessageManager().getGroupHistoryMessageList(str, i, v2TIMMessage, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i2, str2);
                TUIChatLog.e(ChatProvider.TAG, "loadChatMessages getC2CHistoryMessageList failed, code = " + i2 + ", desc = " + ErrorMessageConverter.convertIMError(i2, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadHistoryMessageList(String str, boolean z, int i, TUIMessageBean tUIMessageBean, int i2, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(i);
        if (i2 == 0) {
            v2TIMMessageListGetOption.setGetType(1);
        } else if (i2 == 1) {
            v2TIMMessageListGetOption.setGetType(2);
        }
        if (tUIMessageBean != null) {
            v2TIMMessageListGetOption.setLastMsg(tUIMessageBean.getV2TIMMessage());
        }
        if (z) {
            v2TIMMessageListGetOption.setGroupID(str);
        } else {
            v2TIMMessageListGetOption.setUserID(str);
        }
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.3
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i3, str2);
                TUIChatLog.e(ChatProvider.TAG, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i3 + ", desc = " + ErrorMessageConverter.convertIMError(i3, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadUserStatus(List<String> list, final IUIKitCallback<Map<String, UserStatusBean>> iUIKitCallback) {
        if (list != null && list.size() != 0) {
            V2TIMManager.getInstance().getUserStatus(list, new V2TIMValueCallback<List<V2TIMUserStatus>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.29
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    TUIChatLog.e(ChatProvider.TAG, "getUserStatus error code = " + i + ",des = " + str);
                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str);
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<V2TIMUserStatus> list2) {
                    TUIChatLog.i(ChatProvider.TAG, "getUserStatus success");
                    HashMap hashMap = new HashMap();
                    for (V2TIMUserStatus v2TIMUserStatus : list2) {
                        UserStatusBean userStatusBean = new UserStatusBean();
                        userStatusBean.setUserID(v2TIMUserStatus.getUserID());
                        userStatusBean.setOnlineStatus(v2TIMUserStatus.getStatusType());
                        hashMap.put(v2TIMUserStatus.getUserID(), userStatusBean);
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, hashMap);
                }
            });
        } else {
            TUIChatLog.d(TAG, "loadContactUserStatus datasource is null");
            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "data list is empty");
        }
    }

    public void modifyMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getMessageManager().modifyMessage(tUIMessageBean.getV2TIMMessage(), new V2TIMCompleteCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.24
            @Override // com.tencent.imsdk.v2.V2TIMCompleteCallback
            public void onComplete(int i, String str, V2TIMMessage v2TIMMessage) {
                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
                if (i == 8006) {
                    TUIChatUtils.callbackOnError((IUIKitCallback<TUIMessageBean>) iUIKitCallback, i, str, parseMessage);
                } else {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, parseMessage);
                }
            }
        });
    }

    public void revokeMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getMessageManager().revokeMessage(tUIMessageBean.getV2TIMMessage(), new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.12
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void sendGroupTipsMessage(String str, String str2, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getMessageManager().sendMessage(ChatMessageBuilder.buildGroupCustomMessage(str2), null, str, 0, false, null, new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.16
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i, str3);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                TUIChatLog.i(ChatProvider.TAG, "sendTipsMessage onSuccess");
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMMessage));
            }
        });
    }

    public String sendMessage(final TUIMessageBean tUIMessageBean, final ChatInfo chatInfo, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        boolean z;
        String str;
        setMessageTypingFeature(tUIMessageBean);
        OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
        OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
        offlineMessageBean.content = tUIMessageBean.getExtra();
        offlineMessageBean.sender = tUIMessageBean.getSender();
        offlineMessageBean.nickname = chatInfo.getChatName();
        offlineMessageBean.faceUrl = TUIChatConfigs.getConfigs().getGeneralConfig().getUserFaceUrl();
        offlineMessageContainerBean.entity = offlineMessageBean;
        String str2 = "";
        if (chatInfo.getType() == 2) {
            String id2 = chatInfo.getId();
            offlineMessageBean.chatType = 2;
            offlineMessageBean.sender = id2;
            str = id2;
            z = true;
        } else {
            z = false;
            str2 = chatInfo.getId();
            str = "";
        }
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        if (chatInfo.getType() == 2 && ((GroupInfo) chatInfo).getGroupType().equals("Meeting")) {
            v2TIMOfflinePushInfo.disablePush(true);
        }
        v2TIMOfflinePushInfo.setExt(new d().s(offlineMessageContainerBean).getBytes());
        v2TIMOfflinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
        if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
            v2TIMOfflinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
            v2TIMOfflinePushInfo.setAndroidFCMChannelID(OfflinePushInfoUtils.FCM_PUSH_CHANNEL_ID);
        }
        v2TIMOfflinePushInfo.setAndroidHuaWeiCategory("IM");
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        v2TIMMessage.setExcludedFromUnreadCount(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromUnreadCount());
        v2TIMMessage.setExcludedFromLastMessage(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromLastMessage());
        return V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, z ? null : str2, z ? str : null, 0, false, v2TIMOfflinePushInfo, new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.9
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i, str3);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
                TUIChatUtils.callbackOnProgress(iUIKitCallback, Integer.valueOf(i));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage2) {
                TUIChatLog.v(ChatProvider.TAG, "sendMessage onSuccess:" + v2TIMMessage2.getMsgID());
                tUIMessageBean.setV2TIMMessage(v2TIMMessage2);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", chatInfo.getId());
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_SEND_MESSAGE_SUCCESS, hashMap);
            }
        });
    }

    public void sendMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        Iterator<TUIMessageBean> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().sendMessageReadReceipts(arrayList, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.22
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public String sendTypingStatusMessage(final TUIMessageBean tUIMessageBean, final String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        return V2TIMManager.getMessageManager().sendMessage(tUIMessageBean.getV2TIMMessage(), str, null, 0, true, null, new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.10
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                TUIChatLog.v(ChatProvider.TAG, "sendMessage fail:" + i + "=" + ErrorMessageConverter.convertIMError(i, str2));
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                TUIChatLog.v(ChatProvider.TAG, "sendMessage onSuccess:" + v2TIMMessage.getMsgID());
                tUIMessageBean.setStatus(2);
                tUIMessageBean.setV2TIMMessage(v2TIMMessage);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", str);
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_SEND_MESSAGE_SUCCESS, hashMap);
            }
        });
    }

    public void setDraft(String str, final String str2) {
        V2TIMManager.getConversationManager().setConversationDraft(str, str2, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.14
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str3) {
                TUIChatLog.e(ChatProvider.TAG, "set drafts error : " + i + " " + ErrorMessageConverter.convertIMError(i, str3));
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIChatLog.i(ChatProvider.TAG, "set draft success " + str2);
            }
        });
    }

    public void translateMessage(final TUIMessageBean tUIMessageBean, final IUIKitCallback<String> iUIKitCallback) {
        final V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        if (v2TIMMessage == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, BaseConstants.ERR_INVALID_PARAMETERS, "translateMessage v2TIMMessage is null");
            return;
        }
        if (v2TIMMessage.getElemType() != 1) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, BaseConstants.ERR_INVALID_PARAMETERS, "translateMessage v2TIMMessage is not text type");
            return;
        }
        if (tUIMessageBean.getTranslationStatus() == 1) {
            tUIMessageBean.setTranslationStatus(3);
            TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean.getTranslation());
            return;
        }
        tUIMessageBean.setTranslationStatus(2);
        final String str = TextUtils.equals(TUIThemeManager.getInstance().getCurrentLanguage(), TUIThemeManager.LANGUAGE_ZH_CN) ? TUIThemeManager.LANGUAGE_ZH_CN : TUIThemeManager.LANGUAGE_EN;
        List<String> groupAtUserList = v2TIMMessage.getGroupAtUserList();
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList<Integer> arrayList3 = new ArrayList();
        for (int i = 0; i < groupAtUserList.size(); i++) {
            String str2 = groupAtUserList.get(i);
            if (str2.equals("__kImSDK_MesssageAtALL__")) {
                arrayList3.add(Integer.valueOf(i));
            } else {
                arrayList.add(str2);
            }
        }
        if (arrayList.size() == 0) {
            for (Integer num : arrayList3) {
                arrayList2.add(ServiceInitializer.getAppContext().getString(R.string.at_all));
            }
            translateMessage(tUIMessageBean, arrayList2, str, iUIKitCallback);
            return;
        }
        V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.25
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str3) {
                tUIMessageBean.setTranslationStatus(0);
                TUIChatLog.e(ChatProvider.TAG, "translateMessage getUsersInfo error code = " + i2 + ",des = " + str3);
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, BaseConstants.ERR_INVALID_PARAMETERS, "translateMessage-getUsersInfo failed");
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMUserFullInfo> list) {
                for (String str3 : v2TIMMessage.getGroupAtUserList()) {
                    Iterator<V2TIMUserFullInfo> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            V2TIMUserFullInfo next = it.next();
                            if (str3.equals("__kImSDK_MesssageAtALL__")) {
                                arrayList2.add(str3);
                                break;
                            } else if (str3.equals(next.getUserID())) {
                                arrayList2.add(next.getNickName());
                                break;
                            }
                        }
                    }
                }
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    arrayList2.set(((Integer) it2.next()).intValue(), ServiceInitializer.getAppContext().getString(R.string.at_all));
                }
                ChatProvider.this.translateMessage(tUIMessageBean, arrayList2, str, iUIKitCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateMessage(final TUIMessageBean tUIMessageBean, List<String> list, String str, final IUIKitCallback<String> iUIKitCallback) {
        final HashMap<String, List<String>> splitTextByEmojiAndAtUsers = TUIChatUtils.splitTextByEmojiAndAtUsers(tUIMessageBean.getV2TIMMessage().getTextElem().getText(), list);
        List<String> list2 = splitTextByEmojiAndAtUsers.get(TUIChatUtils.SPLIT_TEXT_FOR_TRANSLATION);
        if (list2 != null && !list2.isEmpty()) {
            V2TIMManager.getMessageManager().translateText(list2, null, str, new V2TIMValueCallback<HashMap<String, String>>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.26
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    tUIMessageBean.setTranslationStatus(0);
                    TUIChatLog.e(ChatProvider.TAG, "translateText error code = " + i + ",des = " + str2);
                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(HashMap<String, String> hashMap) {
                    List list3 = (List) splitTextByEmojiAndAtUsers.get(TUIChatUtils.SPLIT_TEXT);
                    Iterator it = ((List) splitTextByEmojiAndAtUsers.get(TUIChatUtils.SPLIT_TEXT_INDEX_FOR_TRANSLATION)).iterator();
                    while (it.hasNext()) {
                        int intValue = Integer.valueOf((String) it.next()).intValue();
                        String str2 = hashMap.get((String) list3.get(intValue));
                        if (!TextUtils.isEmpty(str2)) {
                            list3.set(intValue, str2);
                        }
                    }
                    Iterator it2 = list3.iterator();
                    String str3 = "";
                    while (it2.hasNext()) {
                        str3 = str3 + ((String) it2.next());
                    }
                    tUIMessageBean.setTranslation(str3);
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, str3);
                }
            });
            return;
        }
        List<String> list3 = splitTextByEmojiAndAtUsers.get(TUIChatUtils.SPLIT_TEXT);
        String str2 = "";
        if (list3 != null) {
            Iterator<String> it = list3.iterator();
            while (it.hasNext()) {
                str2 = str2 + it.next();
            }
        }
        tUIMessageBean.setTranslation(str2);
        TUIChatUtils.callbackOnSuccess(iUIKitCallback, str2);
    }

    public String sendMessage(TUIMessageBean tUIMessageBean, boolean z, final String str, OfflinePushInfo offlinePushInfo, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        v2TIMMessage.setExcludedFromUnreadCount(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromUnreadCount());
        v2TIMMessage.setExcludedFromLastMessage(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromLastMessage());
        return V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, z ? null : str, z ? str : null, 0, false, OfflinePushInfoUtils.convertOfflinePushInfoToV2PushInfo(offlinePushInfo), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.ChatProvider.11
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage2) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMMessage2));
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", str);
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_SEND_MESSAGE_SUCCESS, hashMap);
            }
        });
    }
}
