package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.d;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageContainerBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflinePushInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.tuichat.bean.UserStatusBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.model.AIDenoiseSignatureManager;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.OfflinePushInfoUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class ChatPresenter {
    private static final int FORWARD_C2C_INTERVAL = 50;
    private static final int FORWARD_GROUP_INTERVAL = 90;
    protected static final int MSG_PAGE_COUNT = 20;
    private static final int READ_REPORT_INTERVAL = 1000;
    private static final String TAG = "ChatPresenter";
    private IBaseMessageSender baseMessageSender;
    protected ChatNotifyHandler chatNotifyHandler;
    private TUIMessageBean locateMessage;
    protected IMessageAdapter messageListAdapter;
    private IMessageRecyclerView messageRecyclerView;
    protected final ChatProvider provider;
    protected List<TUIMessageBean> loadedMessageInfoList = new ArrayList();
    private int currentChatUnreadCount = 0;
    private TUIMessageBean mCacheNewMessage = null;
    private long lastReadReportTime = 0;
    private boolean canReadReport = true;
    private final MessageReadReportHandler readReportHandler = new MessageReadReportHandler();
    private boolean isChatFragmentShow = false;
    protected boolean isHaveMoreNewMessage = true;
    protected boolean isHaveMoreOldMessage = true;
    protected boolean isLoading = false;
    protected boolean isNeedShowTranslation = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface ChatNotifyHandler {
        void onApplied(int i);

        void onExitChat(String str);

        void onFriendFaceUrlChanged(String str);

        void onFriendNameChanged(String str);

        void onGroupFaceUrlChanged(String str);

        void onGroupForceExit();

        void onGroupNameChanged(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class MessageReadReportHandler extends Handler {
        MessageReadReportHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface TypingListener {
        void onTyping(int i);
    }

    public ChatPresenter() {
        TUIChatLog.i(TAG, "ChatPresenter Init");
        this.provider = new ChatProvider();
        AIDenoiseSignatureManager.getInstance().updateSignature();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessageAfterPreProcess(TUIMessageBean tUIMessageBean) {
        String userId;
        String str;
        boolean z;
        if (tUIMessageBean != null) {
            if (!TextUtils.isEmpty(tUIMessageBean.getGroupId())) {
                str = tUIMessageBean.getGroupId();
                userId = null;
                z = true;
            } else if (!TextUtils.isEmpty(tUIMessageBean.getUserId())) {
                userId = tUIMessageBean.getUserId();
                str = null;
                z = false;
            } else {
                return;
            }
            addMessageInfo(tUIMessageBean);
            if (isChatFragmentShow()) {
                IMessageRecyclerView iMessageRecyclerView = this.messageRecyclerView;
                if (iMessageRecyclerView != null && iMessageRecyclerView.isDisplayJumpMessageLayout()) {
                    if (tUIMessageBean.getStatus() != 275) {
                        this.currentChatUnreadCount++;
                        if (this.mCacheNewMessage == null) {
                            this.mCacheNewMessage = tUIMessageBean;
                        }
                        this.messageRecyclerView.displayBackToNewMessage(true, this.mCacheNewMessage.getId(), this.currentChatUnreadCount);
                        return;
                    }
                    if (tUIMessageBean.getStatus() == 275) {
                        int i = this.currentChatUnreadCount - 1;
                        this.currentChatUnreadCount = i;
                        if (i == 0) {
                            this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                            this.mCacheNewMessage = null;
                            return;
                        } else {
                            this.messageRecyclerView.displayBackToNewMessage(true, this.mCacheNewMessage.getId(), this.currentChatUnreadCount);
                            return;
                        }
                    }
                    return;
                }
                this.mCacheNewMessage = null;
                this.currentChatUnreadCount = 0;
                if (z) {
                    limitReadReport(str, true);
                } else {
                    limitReadReport(userId, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filterGroupMessageReceipt(TUIMessageBean tUIMessageBean, String str) {
        if (TUIChatUtils.isCommunityGroup(str)) {
            tUIMessageBean.setNeedReadReceipt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getReadReceiptAndRefresh(final TUIMessageBean tUIMessageBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        getMessageReadReceipt(arrayList, new IUIKitCallback<List<MessageReceiptInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.29
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                ChatPresenter.this.refreshData(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<MessageReceiptInfo> list) {
                tUIMessageBean.setMessageReceiptInfo(list.get(0));
                ChatPresenter.this.refreshData(tUIMessageBean);
            }
        });
    }

    private void limitReadReport(final String str, final boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastReadReportTime;
        if (j >= 1000) {
            readReport(str, z);
            this.lastReadReportTime = currentTimeMillis;
            return;
        }
        if (!this.canReadReport) {
            TUIChatLog.d(TAG, "limitReadReport : Reporting , please wait.");
            return;
        }
        long j2 = 1000 - j;
        TUIChatLog.d(TAG, "limitReadReport : Please retry after " + j2 + " ms.");
        this.canReadReport = false;
        this.readReportHandler.postDelayed(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.19
            @Override // java.lang.Runnable
            public void run() {
                ChatPresenter.this.readReport(str, z);
                ChatPresenter.this.lastReadReportTime = System.currentTimeMillis();
                ChatPresenter.this.canReadReport = true;
            }
        }, j2);
    }

    private void loadToWayMessageAsync(final String str, final boolean z, final int i, final int i2, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.locateMessage = tUIMessageBean;
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final boolean[] zArr = {false};
        Runnable runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                ChatPresenter.this.provider.loadHistoryMessageList(str, z, i2 / 2, tUIMessageBean, 1, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.4.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str2, int i3, String str3) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, i3, str3);
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        zArr[0] = true;
                        countDownLatch.countDown();
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                        int size = list.size();
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        if (size >= i2 / 2) {
                            ChatPresenter.this.isHaveMoreNewMessage = true;
                        } else {
                            ChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                        arrayList.addAll(list);
                        countDownLatch.countDown();
                    }
                });
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                ChatPresenter.this.provider.loadHistoryMessageList(str, z, i2 / 2, tUIMessageBean, 0, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.5.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str2, int i3, String str3) {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        zArr[0] = true;
                        countDownLatch.countDown();
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                        int size = list.size();
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        if (size < i2 / 2) {
                            ChatPresenter.this.isHaveMoreOldMessage = false;
                        }
                        arrayList2.addAll(list);
                        countDownLatch.countDown();
                    }
                });
            }
        };
        Runnable runnable3 = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (zArr[0]) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "load failed");
                    return;
                }
                Collections.reverse(arrayList);
                arrayList2.addAll(0, arrayList);
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        ChatPresenter.this.onMessageLoadCompleted(arrayList2, i);
                    }
                });
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList2);
            }
        };
        ThreadHelper threadHelper = ThreadHelper.INST;
        threadHelper.execute(runnable);
        threadHelper.execute(runnable2);
        threadHelper.execute(runnable3);
    }

    private void notifyConversationInfo(ChatInfo chatInfo) {
        String str;
        if (2 == chatInfo.getType()) {
            str = TUIConstants.TUIConversation.CONVERSATION_GROUP_PREFIX + chatInfo.getId();
        } else {
            str = TUIConstants.TUIConversation.CONVERSATION_C2C_PREFIX + chatInfo.getId();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUIConversation.CONVERSATION_ID, str);
        TUICore.notifyEvent(TUIConstants.TUIConversation.EVENT_KEY_MESSAGE_SEND_FOR_CONVERSATION, TUIConstants.TUIConversation.EVENT_SUB_KEY_MESSAGE_SEND_FOR_CONVERSATION, hashMap);
    }

    private void notifyTyping() {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "notifyTyping unSafetyCall");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadedMessageProcessed(List<TUIMessageBean> list, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (i == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z || z2 || z3) {
            Collections.reverse(list);
        }
        if (!z && !z2 && !z3) {
            removeDuplication(list);
            this.loadedMessageInfoList.addAll(list);
            updateAdapter(3, list.size());
        } else {
            removeDuplication(list);
            this.loadedMessageInfoList.addAll(0, list);
            if (z) {
                if (this.loadedMessageInfoList.size() == list.size()) {
                    updateAdapter(1, list.size());
                } else {
                    updateAdapter(2, list.size());
                }
            } else if (z2) {
                updateAdapter(7, this.locateMessage);
            } else {
                updateAdapter(10, this.locateMessage);
            }
        }
        this.isLoading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessageDeleted(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean == null) {
            return;
        }
        ListIterator<TUIMessageBean> listIterator = this.loadedMessageInfoList.listIterator();
        while (listIterator.hasNext()) {
            TUIMessageBean next = listIterator.next();
            if (TextUtils.equals(next.getId(), tUIMessageBean.getId())) {
                updateAdapter(5, next);
                listIterator.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMessageListDeleted(List<TUIMessageBean> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<TUIMessageBean> it = list.iterator();
            while (it.hasNext()) {
                onMessageDeleted(it.next());
            }
        }
    }

    private void preProcessMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        preProcessMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.10
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, "preProcessReplyMessage failed");
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list) {
                if (list != null && list.size() == 1) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
                } else {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "preProcessReplyMessage failed");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readReport(String str, boolean z) {
        if (!z) {
            TUIChatLog.i(TAG, "C2C message ReadReport userId is " + str);
            c2cReadReport(str);
            return;
        }
        TUIChatLog.i(TAG, "Group message ReadReport groupId is " + str);
        groupReadReport(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData(TUIMessageBean tUIMessageBean) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onViewNeedRefresh(4, tUIMessageBean);
        }
    }

    private void removeDuplication(List<TUIMessageBean> list) {
        onMessageListDeleted(list);
    }

    private void resendMessageInfo(TUIMessageBean tUIMessageBean) {
        onMessageDeleted(tUIMessageBean);
        addMessageInfo(tUIMessageBean);
    }

    protected void addMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "addMessage unSafetyCall");
        } else {
            preProcessMessage(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.14
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    ChatPresenter.this.addMessageAfterPreProcess(tUIMessageBean);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(TUIMessageBean tUIMessageBean2) {
                    ChatPresenter.this.addMessageAfterPreProcess(tUIMessageBean2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addMessageInfo(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean == null || checkExist(tUIMessageBean)) {
            return;
        }
        this.loadedMessageInfoList.add(tUIMessageBean);
        updateAdapter(8, 1);
    }

    protected void assembleGroupMessage(TUIMessageBean tUIMessageBean) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c2cReadReport(String str) {
        this.provider.c2cReadReport(str);
    }

    protected boolean checkExist(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean != null) {
            String id2 = tUIMessageBean.getId();
            for (int size = this.loadedMessageInfoList.size() - 1; size >= 0; size--) {
                if (this.loadedMessageInfoList.get(size).getId().equals(id2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean checkFailedMessageInfos(List<TUIMessageBean> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (this.provider.checkFailedMessageInfo(list.get(i))) {
                    return true;
                }
            }
            return false;
        }
        TUIChatLog.w(TAG, "checkFailedMessagesById unSafetyCall");
        return false;
    }

    public void clearMessage() {
        this.loadedMessageInfoList.clear();
        this.messageListAdapter.onViewNeedRefresh(0, 0);
    }

    public void deleteMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "deleteMessage unSafetyCall");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.provider.deleteMessages(arrayList, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.18
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                ChatPresenter.this.onMessageDeleted(tUIMessageBean);
            }
        });
    }

    public void deleteMessageInfos(final List<TUIMessageBean> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            this.provider.deleteMessages(list, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.20
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r2) {
                    ChatPresenter.this.onMessageListDeleted(list);
                }
            });
        } else {
            TUIChatLog.w(TAG, "deleteMessages unSafetyCall");
        }
    }

    public void deleteMessages(List<Integer> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(this.loadedMessageInfoList.get(list.get(i).intValue()));
            }
            this.provider.deleteMessages(arrayList, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.21
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i2, String str2) {
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r2) {
                    ChatPresenter.this.onMessageListDeleted(arrayList);
                }
            });
            return;
        }
        TUIChatLog.w(TAG, "deleteMessages unSafetyCall");
    }

    public void deleteMessages1(List<Integer> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(this.loadedMessageInfoList.get(list.get(i).intValue()));
            }
            onMessageListDeleted(arrayList);
            return;
        }
        TUIChatLog.w(TAG, "deleteMessages unSafetyCall");
    }

    public void findMessage(String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        for (TUIMessageBean tUIMessageBean : this.loadedMessageInfoList) {
            if (TextUtils.equals(str, tUIMessageBean.getId())) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.provider.findMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.26
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list) {
                if (list != null && !list.isEmpty()) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0));
                } else {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "can't find message");
                }
            }
        });
    }

    public void forwardMessage(List<TUIMessageBean> list, boolean z, String str, String str2, int i, boolean z2, boolean z3, IUIKitCallback iUIKitCallback) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "sendMessage unSafetyCall");
            return;
        }
        for (TUIMessageBean tUIMessageBean : list) {
            if (tUIMessageBean instanceof TextMessageBean) {
                TUIChatLog.d(TAG, "chatprensetor forwardMessage onTextSelected selectedText = " + ((TextMessageBean) tUIMessageBean).getSelectText());
            }
        }
        if (i == 0) {
            forwardMessageOneByOne(list, z, str, str2, z2, z3, iUIKitCallback);
        } else if (i == 1) {
            forwardMessageMerge(list, z, str, str2, z2, iUIKitCallback);
        } else {
            TUIChatLog.d(TAG, "invalid forwardMode");
        }
    }

    public void forwardMessageInternal(final TUIMessageBean tUIMessageBean, boolean z, String str, OfflinePushInfo offlinePushInfo, final IUIKitCallback iUIKitCallback) {
        if (tUIMessageBean == null) {
            TUIChatLog.e(TAG, "forwardMessageInternal null message!");
            return;
        }
        String sendMessage = this.provider.sendMessage(tUIMessageBean, z, str, offlinePushInfo, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.24
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i, String str3) {
                TUIChatLog.v(ChatPresenter.TAG, "sendMessage fail:" + i + "=" + str3);
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str3);
                tUIMessageBean.setStatus(3);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean2);
                tUIMessageBean.setStatus(2);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean);
                HashMap hashMap = new HashMap();
                hashMap.put("messageBean", tUIMessageBean2);
                TUICore.notifyEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, hashMap);
            }
        });
        TUIChatLog.i(TAG, "sendMessage msgID:" + sendMessage);
        tUIMessageBean.setId(sendMessage);
        tUIMessageBean.setStatus(1);
    }

    public void forwardMessageMerge(List<TUIMessageBean> list, boolean z, String str, String str2, boolean z2, IUIKitCallback iUIKitCallback) {
        if (list != null && !list.isEmpty()) {
            Context appContext = ServiceInitializer.getAppContext();
            if (appContext == null) {
                TUIChatLog.d(TAG, "context == null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size() && i < 3; i++) {
                TUIMessageBean tUIMessageBean = list.get(i);
                String displayName = ChatMessageParser.getDisplayName(tUIMessageBean.getV2TIMMessage());
                if (!(tUIMessageBean instanceof TipsMessageBean)) {
                    if (tUIMessageBean instanceof TextMessageBean) {
                        arrayList.add(displayName + ":" + tUIMessageBean.getExtra());
                    } else if (tUIMessageBean instanceof FaceMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.custom_emoji));
                    } else if (tUIMessageBean instanceof SoundMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.audio_extra));
                    } else if (tUIMessageBean instanceof ImageMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.picture_extra));
                    } else if (tUIMessageBean instanceof VideoMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.video_extra));
                    } else if (tUIMessageBean instanceof FileMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.file_extra));
                    } else if (tUIMessageBean instanceof MergeMessageBean) {
                        arrayList.add(displayName + ":" + appContext.getString(R.string.forward_extra));
                    } else {
                        arrayList.add(displayName + ":" + tUIMessageBean.getExtra());
                    }
                }
            }
            TUIMessageBean buildMergeMessage = ChatMessageBuilder.buildMergeMessage(list, str2, arrayList, ServiceInitializer.getAppContext().getString(R.string.forward_compatible_text));
            if (z2) {
                sendMessage(buildMergeMessage, false, (IUIKitCallback<TUIMessageBean>) iUIKitCallback);
                return;
            }
            if (z) {
                filterGroupMessageReceipt(buildMergeMessage, str);
            }
            OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
            OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
            offlineMessageBean.content = buildMergeMessage.getExtra().toString();
            offlineMessageBean.sender = buildMergeMessage.getSender();
            offlineMessageBean.nickname = TUIChatConfigs.getConfigs().getGeneralConfig().getUserNickname();
            offlineMessageBean.faceUrl = TUIChatConfigs.getConfigs().getGeneralConfig().getUserFaceUrl();
            offlineMessageContainerBean.entity = offlineMessageBean;
            if (z) {
                offlineMessageBean.chatType = 2;
                offlineMessageBean.sender = str;
            }
            OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
            offlinePushInfo.setExtension(new d().s(offlineMessageContainerBean).getBytes());
            offlinePushInfo.setDescription(str2);
            offlinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
            if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
                offlinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
            }
            forwardMessageInternal(buildMergeMessage, z, str, offlinePushInfo, iUIKitCallback);
        }
    }

    public void forwardMessageOneByOne(final List<TUIMessageBean> list, final boolean z, final String str, final String str2, final boolean z2, final boolean z3, final IUIKitCallback iUIKitCallback) {
        if (list != null && !list.isEmpty()) {
            Thread thread = new Thread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.23
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    TUIMessageBean buildForwardMessage;
                    if (z) {
                        i = 90;
                    } else {
                        i = 50;
                    }
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        TUIMessageBean tUIMessageBean = (TUIMessageBean) list.get(i2);
                        if (z3) {
                            buildForwardMessage = ChatMessageBuilder.buildTextMessage(tUIMessageBean.getTranslation());
                        } else {
                            buildForwardMessage = ChatMessageBuilder.buildForwardMessage(tUIMessageBean.getV2TIMMessage());
                        }
                        TUIMessageBean tUIMessageBean2 = buildForwardMessage;
                        if (z2) {
                            ChatPresenter.this.sendMessage(tUIMessageBean2, false, iUIKitCallback);
                            try {
                                Thread.sleep(i);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (tUIMessageBean2 != null && tUIMessageBean2.getStatus() != 1) {
                            if (z) {
                                ChatPresenter.this.filterGroupMessageReceipt(tUIMessageBean2, str);
                            }
                            OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
                            OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
                            offlineMessageBean.content = tUIMessageBean2.getExtra().toString();
                            offlineMessageBean.sender = tUIMessageBean2.getSender();
                            offlineMessageBean.nickname = TUIChatConfigs.getConfigs().getGeneralConfig().getUserNickname();
                            offlineMessageBean.faceUrl = TUIChatConfigs.getConfigs().getGeneralConfig().getUserFaceUrl();
                            offlineMessageContainerBean.entity = offlineMessageBean;
                            if (z) {
                                offlineMessageBean.chatType = 2;
                                offlineMessageBean.sender = str;
                            }
                            OfflinePushInfo offlinePushInfo = new OfflinePushInfo();
                            offlinePushInfo.setExtension(new d().s(offlineMessageContainerBean).getBytes());
                            offlinePushInfo.setDescription(str2);
                            offlinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
                            if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
                                offlinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
                            }
                            ChatPresenter.this.forwardMessageInternal(tUIMessageBean2, z, str, offlinePushInfo, iUIKitCallback);
                            try {
                                Thread.sleep(i);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            });
            thread.setName("ForwardMessageThread");
            ThreadHelper.INST.execute(thread);
        }
    }

    public List<TUIMessageBean> forwardTextMessageForSelected(List<TUIMessageBean> list) {
        if (list != null && list.size() > 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        TUIMessageBean tUIMessageBean = list.get(0);
        if (tUIMessageBean instanceof TextMessageBean) {
            TextMessageBean textMessageBean = (TextMessageBean) tUIMessageBean;
            if (textMessageBean.getText().equals(textMessageBean.getSelectText())) {
                return list;
            }
            arrayList.add(ChatMessageBuilder.buildTextMessage(textMessageBean.getSelectText()));
            return arrayList;
        }
        return list;
    }

    public ChatInfo getChatInfo() {
        return null;
    }

    public void getConversationLastMessage(String str, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        this.provider.getConversationLastMessage(str, iUIKitCallback);
    }

    public int getMessageCount() {
        return this.loadedMessageInfoList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getMessageReadReceipt(final List<TUIMessageBean> list, final int i) {
        getMessageReadReceipt(list, new IUIKitCallback<List<MessageReceiptInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.8
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ChatPresenter.this.processLoadedMessage(list, i);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<MessageReceiptInfo> list2) {
                for (MessageReceiptInfo messageReceiptInfo : list2) {
                    for (TUIMessageBean tUIMessageBean : list) {
                        if (TextUtils.equals(tUIMessageBean.getId(), messageReceiptInfo.getMsgID())) {
                            tUIMessageBean.setMessageReceiptInfo(messageReceiptInfo);
                        }
                    }
                }
                ChatPresenter.this.processLoadedMessage(list, i);
            }
        });
    }

    public void getReactUserBean(Set<String> set, final IUIKitCallback<Map<String, ReactUserBean>> iUIKitCallback) {
        final HashMap hashMap = new HashMap();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), null);
        }
        ChatInfo chatInfo = getChatInfo();
        if (chatInfo instanceof GroupInfo) {
            this.provider.getGroupMembersInfo(chatInfo.getId(), new ArrayList(set), new IUIKitCallback<List<GroupMemberInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.40
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<GroupMemberInfo> list) {
                    for (GroupMemberInfo groupMemberInfo : list) {
                        ReactUserBean reactUserBean = new ReactUserBean();
                        reactUserBean.setUserId(groupMemberInfo.getAccount());
                        reactUserBean.setFriendRemark(groupMemberInfo.getFriendRemark());
                        reactUserBean.setNameCard(groupMemberInfo.getNameCard());
                        reactUserBean.setNikeName(groupMemberInfo.getNickName());
                        reactUserBean.setFaceUrl(groupMemberInfo.getIconUrl());
                        hashMap.put(reactUserBean.getUserId(), reactUserBean);
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, hashMap);
                }
            });
        } else {
            this.provider.getReactUserBean(new ArrayList(set), new IUIKitCallback<List<ReactUserBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.41
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<ReactUserBean> list) {
                    for (ReactUserBean reactUserBean : list) {
                        hashMap.put(reactUserBean.getUserId(), reactUserBean);
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, hashMap);
                }
            });
        }
    }

    public Set<String> getReactUserNames(List<TUIMessageBean> list) {
        Map<String, Set<String>> reacts;
        HashSet hashSet = new HashSet();
        Iterator<TUIMessageBean> it = list.iterator();
        while (it.hasNext()) {
            MessageReactBean messageReactBean = it.next().getMessageReactBean();
            if (messageReactBean != null && (reacts = messageReactBean.getReacts()) != null) {
                Iterator<Set<String>> it2 = reacts.values().iterator();
                while (it2.hasNext()) {
                    hashSet.addAll(it2.next());
                }
            }
        }
        return hashSet;
    }

    public Set<String> getReplyUserNames(List<TUIMessageBean> list) {
        HashSet hashSet = new HashSet();
        Iterator<TUIMessageBean> it = list.iterator();
        while (it.hasNext()) {
            MessageRepliesBean messageRepliesBean = it.next().getMessageRepliesBean();
            if (messageRepliesBean != null && messageRepliesBean.getRepliesSize() > 0) {
                Iterator<MessageRepliesBean.ReplyBean> it2 = messageRepliesBean.getReplies().iterator();
                while (it2.hasNext()) {
                    hashSet.add(it2.next().getMessageSender());
                }
            }
        }
        return hashSet;
    }

    public List<TUIMessageBean> getSelectPositionMessage(List<Integer> list) {
        if (safetyCall() && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).intValue() < this.loadedMessageInfoList.size()) {
                    arrayList.add(this.loadedMessageInfoList.get(list.get(i).intValue()));
                } else {
                    TUIChatLog.d(TAG, "mCurrentProvider not include SelectPosition ");
                }
            }
            return arrayList;
        }
        TUIChatLog.w(TAG, "getSelectPositionMessage unSafetyCall");
        return null;
    }

    public List<TUIMessageBean> getSelectPositionMessageById(List<String> list) {
        ArrayList arrayList = null;
        if (safetyCall() && list != null && !list.isEmpty()) {
            List<TUIMessageBean> list2 = this.loadedMessageInfoList;
            if (list2 != null && list2.size() > 0) {
                arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= list2.size()) {
                            break;
                        }
                        if (list.get(i).equals(list2.get(i2).getId())) {
                            arrayList.add(list2.get(i2));
                            break;
                        }
                        i2++;
                    }
                }
            }
            return arrayList;
        }
        TUIChatLog.w(TAG, "getSelectPositionMessageById unSafetyCall");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void groupReadReport(String str) {
        this.provider.groupReadReport(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleRevoke(String str) {
        IMessageRecyclerView iMessageRecyclerView;
        int i;
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "handleInvoke unSafetyCall");
            return;
        }
        TUIChatLog.i(TAG, "handleInvoke msgID = " + str);
        for (int i2 = 0; i2 < this.loadedMessageInfoList.size(); i2++) {
            TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i2);
            if (tUIMessageBean.getId().equals(str)) {
                tUIMessageBean.setStatus(TUIMessageBean.MSG_STATUS_REVOKE);
                updateAdapter(4, i2);
                if (isChatFragmentShow() && (iMessageRecyclerView = this.messageRecyclerView) != null && iMessageRecyclerView.isDisplayJumpMessageLayout() && tUIMessageBean.getStatus() == 275) {
                    int i3 = this.currentChatUnreadCount - 1;
                    this.currentChatUnreadCount = i3;
                    if (i3 <= 0) {
                        this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                        this.mCacheNewMessage = null;
                        this.currentChatUnreadCount = 0;
                    } else {
                        ChatInfo chatInfo = getChatInfo();
                        if (chatInfo != null) {
                            if (chatInfo.getType() == 2) {
                                if (tUIMessageBean.getV2TIMMessage().getSeq() > this.mCacheNewMessage.getV2TIMMessage().getSeq()) {
                                }
                                i = i2 + 1;
                                if (i >= this.loadedMessageInfoList.size()) {
                                    TUIMessageBean tUIMessageBean2 = this.loadedMessageInfoList.get(i);
                                    this.mCacheNewMessage = tUIMessageBean2;
                                    this.messageRecyclerView.displayBackToNewMessage(true, tUIMessageBean2.getId(), this.currentChatUnreadCount);
                                } else {
                                    this.messageRecyclerView.displayBackToNewMessage(false, "", 0);
                                    this.mCacheNewMessage = null;
                                }
                            } else {
                                if (tUIMessageBean.getV2TIMMessage().getTimestamp() > this.mCacheNewMessage.getV2TIMMessage().getTimestamp()) {
                                }
                                i = i2 + 1;
                                if (i >= this.loadedMessageInfoList.size()) {
                                }
                            }
                        }
                        this.messageRecyclerView.displayBackToNewMessage(true, this.mCacheNewMessage.getId(), this.currentChatUnreadCount);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initMessageSender() {
        this.baseMessageSender = new IBaseMessageSender() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.1
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender
            public void sendMessage(TUIMessageBean tUIMessageBean, String str, boolean z) {
                ChatPresenter.this.sendMessage(tUIMessageBean, str, z);
            }
        };
        TUIChatService.getInstance().setMessageSender(this.baseMessageSender);
    }

    public boolean isChatFragmentShow() {
        return this.isChatFragmentShow;
    }

    public boolean isNeedShowTranslation() {
        return this.isNeedShowTranslation;
    }

    public boolean isSupportTyping(long j) {
        return false;
    }

    public void loadApplyList(final IUIKitCallback<List<GroupApplyInfo>> iUIKitCallback) {
        this.provider.loadApplyInfo(new IUIKitCallback<List<GroupApplyInfo>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.25
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, str, i, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<GroupApplyInfo> list) {
                if (ChatPresenter.this.getChatInfo() instanceof GroupInfo) {
                    String id2 = ChatPresenter.this.getChatInfo().getId();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        GroupApplyInfo groupApplyInfo = list.get(i);
                        if (id2.equals(groupApplyInfo.getGroupApplication().getGroupID()) && !groupApplyInfo.isStatusHandled()) {
                            arrayList.add(groupApplyInfo);
                        }
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
                }
            }
        });
    }

    public void loadHistoryMessageList(String str, boolean z, final int i, final int i2, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        if (i != 2 && i != 3) {
            this.provider.loadHistoryMessageList(str, z, i2, tUIMessageBean, i, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.7
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i3, String str3) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i3, str3);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list) {
                    if (i == 1) {
                        if (list.size() >= i2) {
                            ChatPresenter.this.isHaveMoreNewMessage = true;
                        } else {
                            ChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                    }
                    ChatPresenter.this.onMessageLoadCompleted(list, i);
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                }
            });
        } else {
            loadToWayMessageAsync(str, z, i, i2, tUIMessageBean, iUIKitCallback);
        }
    }

    public void loadMessage(int i, TUIMessageBean tUIMessageBean, IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
    }

    public void loadUserStatus(List<String> list, IUIKitCallback<Map<String, UserStatusBean>> iUIKitCallback) {
        this.provider.loadUserStatus(list, iUIKitCallback);
    }

    public void locateMessage(String str, final IUIKitCallback<Void> iUIKitCallback) {
        for (TUIMessageBean tUIMessageBean : this.loadedMessageInfoList) {
            if (TextUtils.equals(str, tUIMessageBean.getId())) {
                if (tUIMessageBean.getStatus() == 275) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                    return;
                } else {
                    updateAdapter(9, tUIMessageBean);
                    return;
                }
            }
        }
        findMessage(str, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i, String str3) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                if (tUIMessageBean2.getStatus() == 275) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                    return;
                }
                ChatPresenter.this.loadedMessageInfoList.clear();
                ChatPresenter.this.updateAdapter(0, 0);
                ChatPresenter.this.loadMessage(3, tUIMessageBean2, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.3.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str2, int i, String str3) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, i, str3);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(List<TUIMessageBean> list) {
                    }
                });
            }
        });
    }

    public void locateMessageBySeq(String str, final long j, final IUIKitCallback<Void> iUIKitCallback) {
        if (j < 0) {
            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "invalid param");
        } else {
            this.provider.getGroupMessageBySeq(str, j, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.2
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str2, int i, String str3) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str3);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list) {
                    if (list != null && list.size() != 0) {
                        TUIMessageBean tUIMessageBean = list.get(0);
                        if (tUIMessageBean.getMsgSeq() != j) {
                            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "can't find origin message");
                            return;
                        } else if (tUIMessageBean.getStatus() == 275) {
                            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "origin msg is revoked");
                            return;
                        } else {
                            ChatPresenter.this.locateMessage(tUIMessageBean.getId(), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.2.1
                                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                                public void onError(String str2, int i, String str3) {
                                    TUIChatUtils.callbackOnError(iUIKitCallback, i, str3);
                                }

                                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                                public void onSuccess(Void r1) {
                                }
                            });
                            return;
                        }
                    }
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "null message");
                }
            });
        }
    }

    public void markMessageAsRead(ChatInfo chatInfo) {
        if (chatInfo == null) {
            TUIChatLog.i(TAG, "markMessageAsRead() chatInfo is null");
            return;
        }
        boolean z = true;
        if (chatInfo.getType() == 1) {
            z = false;
        }
        String id2 = chatInfo.getId();
        if (z) {
            groupReadReport(id2);
        } else {
            c2cReadReport(id2);
        }
    }

    public void modifyMessage(TUIMessageBean tUIMessageBean) {
        this.provider.modifyMessage(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.39
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(int i, String str, TUIMessageBean tUIMessageBean2) {
                ToastUtil.toastShortMessage("modify failed code=" + i + " msg=" + str);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                ChatPresenter.this.onRecvMessageModified(tUIMessageBean2);
            }
        });
    }

    public void modifyRootMessageToAddReplyInfo(final ReplyMessageBean replyMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        findMessage(replyMessageBean.getMsgRootId(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.33
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean) {
                ChatPresenter.this.modifyRootMessageToAddReplyInfo(tUIMessageBean, replyMessageBean);
            }
        });
    }

    public void modifyRootMessageToRemoveReplyInfo(final ReplyMessageBean replyMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        findMessage(replyMessageBean.getMsgRootId(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.30
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean) {
                ChatPresenter.this.modifyRootMessageToRemoveReplyInfo(tUIMessageBean, replyMessageBean);
            }
        });
    }

    public void onExitChat(String str) {
        ChatNotifyHandler chatNotifyHandler = this.chatNotifyHandler;
        if (chatNotifyHandler != null) {
            chatNotifyHandler.onExitChat(str);
        }
    }

    protected void onMessageLoadCompleted(List<TUIMessageBean> list, int i) {
    }

    public void onMessageReadReceiptUpdated(List<TUIMessageBean> list, List<MessageReceiptInfo> list2) {
        for (MessageReceiptInfo messageReceiptInfo : list2) {
            for (int i = 0; i < list.size(); i++) {
                TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i);
                if (TextUtils.equals(tUIMessageBean.getId(), messageReceiptInfo.getMsgID())) {
                    tUIMessageBean.setMessageReceiptInfo(messageReceiptInfo);
                    updateAdapter(4, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRecvMessageModified(final TUIMessageBean tUIMessageBean) {
        int size = this.loadedMessageInfoList.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.loadedMessageInfoList.get(i).getId(), tUIMessageBean.getId())) {
                this.loadedMessageInfoList.set(i, tUIMessageBean);
                preProcessMessage(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.28
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        ChatPresenter.this.getReadReceiptAndRefresh(tUIMessageBean);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(TUIMessageBean tUIMessageBean2) {
                        ChatPresenter.this.getReadReceiptAndRefresh(tUIMessageBean2);
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
        if (!this.isHaveMoreNewMessage) {
            addMessage(tUIMessageBean);
        }
    }

    protected void processLoadedMessage(final List<TUIMessageBean> list, final int i) {
        preProcessMessage(list, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.9
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ChatPresenter.this.onLoadedMessageProcessed(list, i);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list2) {
                ChatPresenter.this.onLoadedMessageProcessed(list2, i);
            }
        });
    }

    public void reactMessage(final String str, TUIMessageBean tUIMessageBean) {
        ChatModifyMessageHelper.enqueueTask(new ChatModifyMessageHelper.ModifyMessageTask(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.36
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i, String str3) {
                ToastUtil.toastShortMessage("reactMessage failed code=" + i + " msg=" + str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
            }
        }) { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.37
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper.ModifyMessageTask
            public TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean2) {
                MessageReactBean messageReactBean = tUIMessageBean2.getMessageReactBean();
                if (messageReactBean == null) {
                    messageReactBean = new MessageReactBean();
                }
                messageReactBean.operateUser(str, TUILogin.getLoginUser());
                tUIMessageBean2.setMessageReactBean(messageReactBean);
                return tUIMessageBean2;
            }
        });
    }

    public void resetCurrentChatUnreadCount() {
        this.currentChatUnreadCount = 0;
        this.mCacheNewMessage = null;
    }

    public void resetNewMessageCount() {
        this.currentChatUnreadCount = 0;
        this.mCacheNewMessage = null;
    }

    public void revokeMessage(final TUIMessageBean tUIMessageBean) {
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "revokeMessage unSafetyCall");
        } else {
            this.provider.revokeMessage(tUIMessageBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.22
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i, String str2) {
                    if (i != 6223 && i != 10031 && i != 20016) {
                        ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.revoke_fail) + i + "=" + str2);
                        return;
                    }
                    ToastUtil.toastLongMessage(ServiceInitializer.getAppContext().getString(R.string.send_two_mins));
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r3) {
                    TUIMessageBean tUIMessageBean2 = tUIMessageBean;
                    if (tUIMessageBean2 instanceof ReplyMessageBean) {
                        ChatPresenter.this.modifyRootMessageToRemoveReplyInfo((ReplyMessageBean) tUIMessageBean2, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.22.1
                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onError(String str, int i, String str2) {
                                ToastUtil.toastShortMessage("modify message failed code = " + i + " message = " + str2);
                            }
                        });
                    }
                    ChatPresenter.this.updateMessageRevoked(tUIMessageBean.getId());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean safetyCall() {
        if (getChatInfo() == null) {
            return false;
        }
        return true;
    }

    public void scrollToNewestMessage() {
        if (!this.isHaveMoreNewMessage) {
            this.messageListAdapter.onScrollToEnd();
            return;
        }
        this.loadedMessageInfoList.clear();
        this.messageListAdapter.onViewNeedRefresh(0, 0);
        this.isHaveMoreOldMessage = true;
        loadMessage(0, null);
    }

    public void sendMessage(TUIMessageBean tUIMessageBean, String str, boolean z) {
        if (TextUtils.isEmpty(str) || (TextUtils.equals(getChatInfo().getId(), str) && z == TUIChatUtils.isGroupChat(getChatInfo().getType()))) {
            sendMessage(tUIMessageBean, false, (IUIKitCallback<TUIMessageBean>) null);
        }
    }

    public void sendMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            if (tUIMessageBean.isNeedReadReceipt()) {
                arrayList.add(tUIMessageBean);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.provider.sendMessageReadReceipt(arrayList, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.15
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatLog.e(ChatPresenter.TAG, "sendMessageReadReceipt failed, errCode " + i + " errMsg " + str2);
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void sendTypingStatusMessage(TUIMessageBean tUIMessageBean, String str, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
    }

    public void setChatFragmentShow(boolean z) {
        this.isChatFragmentShow = z;
    }

    public void setChatNotifyHandler(ChatNotifyHandler chatNotifyHandler) {
        this.chatNotifyHandler = chatNotifyHandler;
    }

    public void setDraft(String str) {
        ChatInfo chatInfo = getChatInfo();
        if (chatInfo == null) {
            return;
        }
        this.provider.setDraft(TUIChatUtils.getConversationIdByUserId(chatInfo.getId(), TUIChatUtils.isGroupChat(chatInfo.getType())), str);
    }

    public void setMessageListAdapter(IMessageAdapter iMessageAdapter) {
        this.messageListAdapter = iMessageAdapter;
    }

    public void setMessageRecycleView(IMessageRecyclerView iMessageRecyclerView) {
        this.messageRecyclerView = iMessageRecyclerView;
        this.currentChatUnreadCount = 0;
        this.mCacheNewMessage = null;
    }

    public void setMessageReplyBean(MessageRepliesBean messageRepliesBean, Map<String, ReactUserBean> map) {
        List<MessageRepliesBean.ReplyBean> replies = messageRepliesBean.getReplies();
        if (replies != null && replies.size() > 0) {
            for (MessageRepliesBean.ReplyBean replyBean : replies) {
                ReactUserBean reactUserBean = map.get(replyBean.getMessageSender());
                if (reactUserBean != null) {
                    replyBean.setSenderFaceUrl(reactUserBean.getFaceUrl());
                    replyBean.setSenderShowName(reactUserBean.getDisplayString());
                }
            }
        }
    }

    public void setNeedShowTranslation(boolean z) {
        this.isNeedShowTranslation = z;
    }

    public void translateMessage(final TUIMessageBean tUIMessageBean) {
        this.provider.translateMessage(tUIMessageBean, new IUIKitCallback<String>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.38
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatLog.e(ChatPresenter.TAG, "translateMessage failed code:" + i + ", msg:" + str2);
                ToastUtil.toastShortMessage(ServiceInitializer.getAppContext().getString(R.string.translation_fail));
                ChatPresenter.this.updateAdapter(4, tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(String str) {
                TUIChatLog.i(ChatPresenter.TAG, "translateMessage success:" + str);
                ChatPresenter.this.updateAdapter(4, tUIMessageBean);
            }
        });
        updateAdapter(4, tUIMessageBean);
    }

    protected void updateAdapter(int i, int i2) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onDataSourceChanged(this.loadedMessageInfoList);
            this.messageListAdapter.onViewNeedRefresh(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateMessageInfo(TUIMessageBean tUIMessageBean) {
        for (int i = 0; i < this.loadedMessageInfoList.size(); i++) {
            if (this.loadedMessageInfoList.get(i) != null && this.loadedMessageInfoList.get(i).getId() != null && tUIMessageBean.getId() != null && this.loadedMessageInfoList.get(i).getId().equals(tUIMessageBean.getId())) {
                this.loadedMessageInfoList.set(i, tUIMessageBean);
                updateAdapter(4, tUIMessageBean);
                return;
            }
        }
    }

    public boolean updateMessageRevoked(String str) {
        for (int i = 0; i < this.loadedMessageInfoList.size(); i++) {
            TUIMessageBean tUIMessageBean = this.loadedMessageInfoList.get(i);
            if (tUIMessageBean.getId().equals(str)) {
                tUIMessageBean.setStatus(TUIMessageBean.MSG_STATUS_REVOKE);
                updateAdapter(4, i);
            }
        }
        return false;
    }

    public void updateTranslationMessage(TUIMessageBean tUIMessageBean) {
        updateMessageInfo(tUIMessageBean);
    }

    public void getMessageReadReceipt(List<TUIMessageBean> list, IUIKitCallback<List<MessageReceiptInfo>> iUIKitCallback) {
        this.provider.getMessageReadReceipt(list, iUIKitCallback);
    }

    public void loadMessage(int i, TUIMessageBean tUIMessageBean) {
        if (i != 1 || this.isHaveMoreNewMessage) {
            if (i == 0 && !this.isHaveMoreOldMessage) {
                updateAdapter(2, 0);
            } else {
                loadMessage(i, tUIMessageBean, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyRootMessageToAddReplyInfo(final TUIMessageBean tUIMessageBean, final ReplyMessageBean replyMessageBean) {
        ChatModifyMessageHelper.enqueueTask(new ChatModifyMessageHelper.ModifyMessageTask(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.34
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                ToastUtil.toastShortMessage("modifyRootMessageAddReply failed code=" + i + " msg=" + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", tUIMessageBean.getGroupId());
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_REPLY_MESSAGE_SUCCESS, hashMap);
            }
        }) { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.35
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper.ModifyMessageTask
            public TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean2) {
                MessageRepliesBean messageRepliesBean = tUIMessageBean2.getMessageRepliesBean();
                if (messageRepliesBean == null) {
                    messageRepliesBean = new MessageRepliesBean();
                }
                messageRepliesBean.addReplyMessage(replyMessageBean.getId(), replyMessageBean.getContentMessageBean().getExtra(), replyMessageBean.getSender());
                tUIMessageBean2.setMessageRepliesBean(messageRepliesBean);
                return tUIMessageBean2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void modifyRootMessageToRemoveReplyInfo(TUIMessageBean tUIMessageBean, final ReplyMessageBean replyMessageBean) {
        ChatModifyMessageHelper.enqueueTask(new ChatModifyMessageHelper.ModifyMessageTask(tUIMessageBean, new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.31
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                ToastUtil.toastShortMessage("modifyRootMessageRemoveReply failed code=" + i + " msg=" + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
            }
        }) { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.32
            @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatModifyMessageHelper.ModifyMessageTask
            public TUIMessageBean packageMessage(TUIMessageBean tUIMessageBean2) {
                MessageRepliesBean messageRepliesBean = tUIMessageBean2.getMessageRepliesBean();
                if (messageRepliesBean == null) {
                    return tUIMessageBean2;
                }
                messageRepliesBean.removeReplyMessage(replyMessageBean.getId());
                tUIMessageBean2.setMessageRepliesBean(messageRepliesBean);
                return tUIMessageBean2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void preProcessMessage(final List<TUIMessageBean> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        for (TUIMessageBean tUIMessageBean : list) {
            if (tUIMessageBean instanceof QuoteMessageBean) {
                arrayList.add(((QuoteMessageBean) tUIMessageBean).getOriginMsgId());
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.11
            @Override // java.lang.Runnable
            public void run() {
                if (arrayList.isEmpty()) {
                    countDownLatch.countDown();
                } else {
                    ChatPresenter.this.findMessage(arrayList, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.11.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i, String str2) {
                            countDownLatch.countDown();
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(List<TUIMessageBean> list2) {
                            for (int i = 0; i < list2.size(); i++) {
                                TUIMessageBean tUIMessageBean2 = list2.get(i);
                                if (tUIMessageBean2 != null) {
                                    for (TUIMessageBean tUIMessageBean3 : list) {
                                        if (tUIMessageBean3 instanceof QuoteMessageBean) {
                                            QuoteMessageBean quoteMessageBean = (QuoteMessageBean) tUIMessageBean3;
                                            if (TextUtils.equals(quoteMessageBean.getOriginMsgId(), tUIMessageBean2.getId())) {
                                                quoteMessageBean.setOriginMessageBean(tUIMessageBean2);
                                            }
                                        }
                                    }
                                }
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
            }
        };
        ThreadHelper threadHelper = ThreadHelper.INST;
        threadHelper.execute(runnable);
        threadHelper.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.12
            @Override // java.lang.Runnable
            public void run() {
                Set<String> reactUserNames = ChatPresenter.this.getReactUserNames(list);
                reactUserNames.addAll(ChatPresenter.this.getReplyUserNames(list));
                if (reactUserNames.isEmpty()) {
                    countDownLatch.countDown();
                } else {
                    ChatPresenter.this.getReactUserBean(reactUserNames, new IUIKitCallback<Map<String, ReactUserBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.12.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i, String str2) {
                            countDownLatch.countDown();
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(Map<String, ReactUserBean> map) {
                            for (TUIMessageBean tUIMessageBean2 : list) {
                                MessageReactBean messageReactBean = tUIMessageBean2.getMessageReactBean();
                                if (messageReactBean != null) {
                                    messageReactBean.setReactUserBeanMap(map);
                                }
                                MessageRepliesBean messageRepliesBean = tUIMessageBean2.getMessageRepliesBean();
                                if (messageRepliesBean != null) {
                                    ChatPresenter.this.setMessageReplyBean(messageRepliesBean, map);
                                }
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
            }
        });
        threadHelper.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "mergeRunnable error");
                    e.printStackTrace();
                }
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                    }
                });
            }
        });
    }

    public void sendMessage(final TUIMessageBean tUIMessageBean, final boolean z, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.16
                @Override // java.lang.Runnable
                public void run() {
                    ChatPresenter.this.sendMessage(tUIMessageBean, z, iUIKitCallback);
                }
            });
            return;
        }
        if (!safetyCall()) {
            TUIChatLog.w(TAG, "sendMessage unSafetyCall");
            return;
        }
        if (tUIMessageBean == null || tUIMessageBean.getStatus() == 1) {
            return;
        }
        assembleGroupMessage(tUIMessageBean);
        notifyConversationInfo(getChatInfo());
        String sendMessage = this.provider.sendMessage(tUIMessageBean, getChatInfo(), new IUIKitCallback<TUIMessageBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.17
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatLog.v(ChatPresenter.TAG, "sendMessage fail:" + i + "=" + str2);
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatPresenter.TAG, i, str2);
                tUIMessageBean.setStatus(3);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onProgress(Object obj) {
                TUIChatUtils.callbackOnProgress(iUIKitCallback, obj);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(TUIMessageBean tUIMessageBean2) {
                TUIChatLog.v(ChatPresenter.TAG, "sendMessage onSuccess:" + tUIMessageBean2.getId());
                if (!ChatPresenter.this.safetyCall()) {
                    TUIChatLog.w(ChatPresenter.TAG, "sendMessage unSafetyCall");
                    return;
                }
                tUIMessageBean.setStatus(2);
                TUIMessageBean tUIMessageBean3 = tUIMessageBean;
                if (tUIMessageBean3 instanceof FileMessageBean) {
                    tUIMessageBean3.setDownloadStatus(6);
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean2);
                ChatPresenter.this.updateMessageInfo(tUIMessageBean);
                HashMap hashMap = new HashMap();
                hashMap.put("messageBean", tUIMessageBean2);
                TUICore.notifyEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, hashMap);
            }
        });
        TUIChatLog.i(TAG, "sendMessage msgID:" + sendMessage);
        tUIMessageBean.setId(sendMessage);
        tUIMessageBean.setStatus(1);
        if (z) {
            resendMessageInfo(tUIMessageBean);
        } else {
            addMessageInfo(tUIMessageBean);
        }
    }

    protected void updateAdapter(int i, TUIMessageBean tUIMessageBean) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onDataSourceChanged(this.loadedMessageInfoList);
            this.messageListAdapter.onViewNeedRefresh(i, tUIMessageBean);
        }
    }

    public void findMessage(List<String> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        this.provider.findMessage(list, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter.27
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<TUIMessageBean> list2) {
                if (list2 != null && !list2.isEmpty()) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list2);
                } else {
                    TUIChatUtils.callbackOnError(iUIKitCallback, 0, "");
                }
            }
        });
    }
}
