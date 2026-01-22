package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GroupChatPresenter extends ChatPresenter {
    private static final String TAG = "GroupChatPresenter";
    private List<GroupApplyInfo> currentApplies = new ArrayList();
    private List<GroupMemberInfo> currentGroupMembers = new ArrayList();
    public GroupChatEventListener groupChatEventListener;
    private GroupInfo groupInfo;

    public GroupChatPresenter() {
        TUIChatLog.i(TAG, "GroupChatPresenter Init");
    }

    private void addGroupMessage(TUIMessageBean tUIMessageBean) {
        if (!(tUIMessageBean instanceof TipsMessageBean)) {
            return;
        }
        TipsMessageBean tipsMessageBean = (TipsMessageBean) tUIMessageBean;
        if (tipsMessageBean.getTipType() == 259) {
            this.provider.addJoinGroupMessage(tipsMessageBean, new IUIKitCallback<List<GroupMemberInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.4
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatLog.e(GroupChatPresenter.TAG, "addJoinGroupMessage error : " + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<GroupMemberInfo> list) {
                    GroupChatPresenter.this.currentGroupMembers.addAll(list);
                    GroupChatPresenter.this.groupInfo.setMemberDetails(GroupChatPresenter.this.currentGroupMembers);
                }
            });
            return;
        }
        if (tipsMessageBean.getTipType() != 260 && tipsMessageBean.getTipType() != 261) {
            if (tipsMessageBean.getTipType() == 262 || tipsMessageBean.getTipType() == 263) {
                this.provider.addModifyGroupMessage(tipsMessageBean, new IUIKitCallback<Pair<Integer, String>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.6
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i, String str2) {
                        TUIChatLog.e(GroupChatPresenter.TAG, "addModifyGroupMessage error " + str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(Pair<Integer, String> pair) {
                        if (((Integer) pair.first).intValue() == 262) {
                            GroupChatPresenter.this.groupInfo.setGroupName((String) pair.second);
                            ChatPresenter.ChatNotifyHandler chatNotifyHandler = GroupChatPresenter.this.chatNotifyHandler;
                            if (chatNotifyHandler != null) {
                                chatNotifyHandler.onGroupNameChanged((String) pair.second);
                            }
                        }
                        if (((Integer) pair.first).intValue() == 263) {
                            GroupChatPresenter.this.groupInfo.setNotice((String) pair.second);
                        }
                    }
                });
                return;
            }
            return;
        }
        this.provider.addLeaveGroupMessage(tipsMessageBean, new IUIKitCallback<List<String>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.5
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<String> list) {
                for (String str : list) {
                    int i = 0;
                    while (true) {
                        if (i >= GroupChatPresenter.this.currentGroupMembers.size()) {
                            break;
                        }
                        if (((GroupMemberInfo) GroupChatPresenter.this.currentGroupMembers.get(i)).getAccount().equals(str)) {
                            GroupChatPresenter.this.currentGroupMembers.remove(i);
                            break;
                        }
                        i++;
                    }
                }
                GroupChatPresenter.this.groupInfo.setMemberDetails(GroupChatPresenter.this.currentGroupMembers);
            }
        });
    }

    private void sendGroupTipsMessage(final String str, String str2, final IUIKitCallback<String> iUIKitCallback) {
        this.provider.sendGroupTipsMessage(str, str2, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str3, int i, String str4) {
                TUIChatUtils.callbackOnError(iUIKitCallback, str3, i, str4);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void addMessageInfo(TUIMessageBean tUIMessageBean) {
        super.addMessageInfo(tUIMessageBean);
        addGroupMessage(tUIMessageBean);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    protected void assembleGroupMessage(TUIMessageBean tUIMessageBean) {
        tUIMessageBean.setGroup(true);
        String groupType = this.groupInfo.getGroupType();
        if (TextUtils.equals(groupType, "AVChatRoom") || TextUtils.equals(groupType, "Community") || TUIChatUtils.isCommunityGroup(this.groupInfo.getId())) {
            tUIMessageBean.setNeedReadReceipt(false);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    public void initListener() {
        this.groupChatEventListener = new GroupChatEventListener() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.1
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void addMessage(TUIMessageBean tUIMessageBean, String str) {
                if (TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.addMessageInfo(tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void clearGroupMessage(String str) {
                if (TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.clearMessage();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void exitGroupChat(String str) {
                GroupChatPresenter.this.onExitChat(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void handleRevoke(String str) {
                GroupChatPresenter.this.handleRevoke(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onApplied(int i) {
                GroupChatPresenter.this.onApplied(i);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onGroupFaceUrlChanged(String str, String str2) {
                if (GroupChatPresenter.this.groupInfo != null && TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.onGroupFaceUrlChanged(str2);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onGroupForceExit(String str) {
                GroupChatPresenter.this.onGroupForceExit(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onGroupNameChanged(String str, String str2) {
                if (GroupChatPresenter.this.groupInfo != null && TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.onGroupNameChanged(str2);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onMessageChanged(TUIMessageBean tUIMessageBean) {
                GroupChatPresenter.this.updateMessageInfo(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onReadReport(List<MessageReceiptInfo> list) {
                GroupChatPresenter.this.onReadReport(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                if (GroupChatPresenter.this.groupInfo != null && TextUtils.equals(tUIMessageBean.getGroupId(), GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.onRecvMessageModified(tUIMessageBean);
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener
            public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
                if (GroupChatPresenter.this.groupInfo != null && TextUtils.equals(tUIMessageBean.getGroupId(), GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.onRecvNewMessage(tUIMessageBean);
                }
            }
        };
        TUIChatService.getInstance().addGroupChatEventListener(this.groupChatEventListener);
        initMessageSender();
    }

    public void loadGroupMembers(String str, IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        this.provider.loadGroupMembers(str, 0L, iUIKitCallback);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void loadMessage(final int i, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        GroupInfo groupInfo = this.groupInfo;
        if (groupInfo != null && !this.isLoading) {
            this.isLoading = true;
            String id2 = groupInfo.getId();
            if (i == 0) {
                this.provider.loadGroupMessage(id2, 20, tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.GroupChatPresenter.2
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        GroupChatPresenter groupChatPresenter = GroupChatPresenter.this;
                        groupChatPresenter.isHaveMoreNewMessage = false;
                        groupChatPresenter.isHaveMoreOldMessage = false;
                        TUIChatLog.e(GroupChatPresenter.TAG, "load group message failed " + i2 + "  " + str2);
                        TUIChatUtils.callbackOnError(iUIKitCallback, i2, str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                        TUIChatLog.i(GroupChatPresenter.TAG, "load group message success " + list.size());
                        if (tUIMessageBean == null) {
                            GroupChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                        if (list.size() < 20) {
                            GroupChatPresenter.this.isHaveMoreOldMessage = false;
                        }
                        GroupChatPresenter.this.onMessageLoadCompleted(list, i);
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                    }
                });
            } else {
                loadHistoryMessageList(id2, true, i, 20, tUIMessageBean, iUIKitCallback);
            }
        }
    }

    public void onApplied(int i) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onApplied(i);
        }
    }

    public void onGroupFaceUrlChanged(String str) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onGroupFaceUrlChanged(str);
        }
    }

    public void onGroupForceExit(String str) {
        if (this.chatNotifyHandler != null && TextUtils.equals(str, this.groupInfo.getId())) {
            this.chatNotifyHandler.onGroupForceExit();
        }
    }

    public void onGroupNameChanged(String str) {
        ChatPresenter.ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onGroupNameChanged(str);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    protected void onMessageLoadCompleted(List<TUIMessageBean> list, int i) {
        groupReadReport(this.groupInfo.getId());
        getMessageReadReceipt(list, i);
    }

    public void onReadReport(List<MessageReceiptInfo> list) {
        if (this.groupInfo != null) {
            ArrayList arrayList = new ArrayList();
            for (MessageReceiptInfo messageReceiptInfo : list) {
                if (TextUtils.equals(messageReceiptInfo.getGroupID(), this.groupInfo.getId())) {
                    arrayList.add(messageReceiptInfo);
                }
            }
            onMessageReadReceiptUpdated(this.loadedMessageInfoList, arrayList);
        }
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }
}
