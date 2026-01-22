package com.tencent.qcloud.tuikit.tuichat;

import android.content.Context;
import android.text.TextUtils;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;
import com.qiahao.base_common.model.im.Identifier;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMFriendshipListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomEvaluationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomOrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MessageTypingBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.BroadcastGroupMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.CpSuccessMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.CpTipMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.CpUnbindMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.FamilyInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.GiftMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.HeadWearMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.InviteCpMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.InviteEnterRoomMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.LikeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.LinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.MountsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.NobleMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.PKInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.PictureLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.ReceiverGiftTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.ReceiverSuperLikeTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationSuccessMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationTipMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationUnbindMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.SendGiftTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.SendSuperLikeTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.SheepInviteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.TextAndImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.UnionFirstMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.VideoCallMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.VideoTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomActivityBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomAppointedBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomCreateLudoOrUnoBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomEnvelopeBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomEnvelopeGetBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomGiftBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomGlobalGiftBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomJoinBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomJumpBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomKickBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomLuckyBoxBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomLuckyFruitBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomMatchGameBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomOwnWelcomeBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomPK1v1Bean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomPKEndBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomRocketBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomRolledBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomSupportBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomTipBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomUnNoBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomUserEnterBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.strange.StrangeGiftTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.strange.StrangePlayTipMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.AudioRecordEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.C2CChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IBaseMessageSender;
import com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener;
import com.tencent.qcloud.tuikit.tuichat.interfaces.TotalUnreadCountListener;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIChatService extends ServiceInitializer implements ITUIChatService {
    public static final String TAG = "TUIChatService";
    private static TUIChatService instance;
    private WeakReference<IBaseMessageSender> messageSender;
    private final List<WeakReference<GroupChatEventListener>> groupChatEventListenerList = new ArrayList();
    private final List<WeakReference<C2CChatEventListener>> c2CChatEventListenerList = new ArrayList();
    private final List<WeakReference<TotalUnreadCountListener>> unreadCountListenerList = new ArrayList();
    private final List<WeakReference<NetworkConnectionListener>> connectListenerList = new ArrayList();
    private final Map<String, Class<? extends TUIMessageBean>> customMessageMap = new HashMap();
    private final List<WeakReference<AudioRecordEventListener>> audioRecordEventListenerList = new ArrayList();
    private RxDataStore<Preferences> mChatDataStore = null;

    private void addCustomMessageType(String str, Class<? extends TUIMessageBean> cls) {
        this.customMessageMap.put(str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<C2CChatEventListener> getC2CChatEventListenerList() {
        ArrayList arrayList = new ArrayList();
        ListIterator<WeakReference<C2CChatEventListener>> listIterator = this.c2CChatEventListenerList.listIterator();
        while (listIterator.hasNext()) {
            C2CChatEventListener c2CChatEventListener = listIterator.next().get();
            if (c2CChatEventListener == null) {
                listIterator.remove();
            } else {
                arrayList.add(c2CChatEventListener);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GroupChatEventListener> getGroupChatEventListenerList() {
        ArrayList arrayList = new ArrayList();
        ListIterator<WeakReference<GroupChatEventListener>> listIterator = this.groupChatEventListenerList.listIterator();
        while (listIterator.hasNext()) {
            GroupChatEventListener groupChatEventListener = listIterator.next().get();
            if (groupChatEventListener == null) {
                listIterator.remove();
            } else {
                arrayList.add(groupChatEventListener);
            }
        }
        return arrayList;
    }

    public static TUIChatService getInstance() {
        return instance;
    }

    private IBaseMessageSender getMessageSender() {
        WeakReference<IBaseMessageSender> weakReference = this.messageSender;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private Object getOrDefault(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    private List<TotalUnreadCountListener> getUnreadCountListenerList() {
        ArrayList arrayList = new ArrayList();
        ListIterator<WeakReference<TotalUnreadCountListener>> listIterator = this.unreadCountListenerList.listIterator();
        while (listIterator.hasNext()) {
            TotalUnreadCountListener totalUnreadCountListener = listIterator.next().get();
            if (totalUnreadCountListener == null) {
                listIterator.remove();
            } else {
                arrayList.add(totalUnreadCountListener);
            }
        }
        return arrayList;
    }

    private void initDataStore() {
        if (this.mChatDataStore == null) {
            this.mChatDataStore = new RxPreferenceDataStoreBuilder(ServiceInitializer.getAppContext(), TUIChatConstants.DataStore.DATA_STORE_NAME).build();
        }
        DataStoreUtil.getInstance().setDataStore(this.mChatDataStore);
    }

    private void initEvent() {
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_INFO_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_EXIT_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_MEMBER_KICKED_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_DISMISS, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_JOIN_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_INVITED_GROUP, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_RECYCLE, this);
        TUICore.registerEvent(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED, TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUIGroup.EVENT_GROUP, TUIConstants.TUIGroup.EVENT_SUB_KEY_CLEAR_MESSAGE, this);
        TUICore.registerEvent(TUIConstants.TUIContact.EVENT_USER, TUIConstants.TUIContact.EVENT_SUB_KEY_CLEAR_MESSAGE, this);
        TUICore.registerEvent(TUIConstants.TUIConversation.EVENT_UNREAD, TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED, this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, this);
        TUICore.registerEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, this);
        TUICore.registerEvent(TUIConstants.TUICalling.EVENT_KEY_RECORD_AUDIO_MESSAGE, TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START, this);
        TUICore.registerEvent(TUIConstants.TUICalling.EVENT_KEY_RECORD_AUDIO_MESSAGE, TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_STOP, this);
        TUICore.registerEvent(TUIChatConstants.EVENT_KEY_OFFLINE_MESSAGE_PRIVATE_RING, TUIChatConstants.EVENT_SUB_KEY_OFFLINE_MESSAGE_PRIVATE_RING, this);
    }

    private void initIMListener() {
        V2TIMManager.getMessageManager().addAdvancedMsgListener(new V2TIMAdvancedMsgListener() { // from class: com.tencent.qcloud.tuikit.tuichat.TUIChatService.1
            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvMessageModified(V2TIMMessage v2TIMMessage) {
                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
                if (parseMessage == null) {
                    return;
                }
                Iterator it = TUIChatService.getInstance().getC2CChatEventListenerList().iterator();
                while (it.hasNext()) {
                    ((C2CChatEventListener) it.next()).onRecvMessageModified(parseMessage);
                }
                Iterator it2 = TUIChatService.getInstance().getGroupChatEventListenerList().iterator();
                while (it2.hasNext()) {
                    ((GroupChatEventListener) it2.next()).onRecvMessageModified(parseMessage);
                }
                TUIChatLog.i(TUIChatService.TAG, "onRecvMessageModified msgID:" + v2TIMMessage.getMsgID());
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvMessageReadReceipts(List<V2TIMMessageReceipt> list) {
                List c2CChatEventListenerList = TUIChatService.getInstance().getC2CChatEventListenerList();
                List groupChatEventListenerList = TUIChatService.getInstance().getGroupChatEventListenerList();
                ArrayList arrayList = new ArrayList();
                for (V2TIMMessageReceipt v2TIMMessageReceipt : list) {
                    MessageReceiptInfo messageReceiptInfo = new MessageReceiptInfo();
                    messageReceiptInfo.setMessageReceipt(v2TIMMessageReceipt);
                    arrayList.add(messageReceiptInfo);
                }
                Iterator it = groupChatEventListenerList.iterator();
                while (it.hasNext()) {
                    ((GroupChatEventListener) it.next()).onReadReport(arrayList);
                }
                Iterator it2 = c2CChatEventListenerList.iterator();
                while (it2.hasNext()) {
                    ((C2CChatEventListener) it2.next()).onReadReport(arrayList);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvMessageRevoked(String str) {
                Iterator it = TUIChatService.getInstance().getC2CChatEventListenerList().iterator();
                while (it.hasNext()) {
                    ((C2CChatEventListener) it.next()).handleRevoke(str);
                }
                Iterator it2 = TUIChatService.getInstance().getGroupChatEventListenerList().iterator();
                while (it2.hasNext()) {
                    ((GroupChatEventListener) it2.next()).handleRevoke(str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
            public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
                String str;
                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
                if (parseMessage == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                if (TextUtils.isEmpty(v2TIMMessage.getGroupID())) {
                    Iterator it = TUIChatService.getInstance().getC2CChatEventListenerList().iterator();
                    while (it.hasNext()) {
                        ((C2CChatEventListener) it.next()).onRecvNewMessage(parseMessage);
                    }
                    str = TUIConstants.TUIConversation.CONVERSATION_C2C_PREFIX + v2TIMMessage.getUserID();
                    if (parseMessage instanceof MessageTypingBean) {
                        hashMap.put(TUIConstants.TUIChat.IS_TYPING_MESSAGE, Boolean.TRUE);
                    } else {
                        hashMap.put(TUIConstants.TUIChat.IS_TYPING_MESSAGE, Boolean.FALSE);
                    }
                } else {
                    Iterator it2 = TUIChatService.getInstance().getGroupChatEventListenerList().iterator();
                    while (it2.hasNext()) {
                        ((GroupChatEventListener) it2.next()).onRecvNewMessage(parseMessage);
                    }
                    str = TUIConstants.TUIConversation.CONVERSATION_GROUP_PREFIX + v2TIMMessage.getGroupID();
                }
                hashMap.put(TUIConstants.TUIChat.CONVERSATION_ID, str);
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_RECEIVE_MESSAGE, TUIConstants.TUIChat.EVENT_SUB_KEY_CONVERSATION_ID, hashMap);
            }
        });
        V2TIMManager.getFriendshipManager().addFriendListener(new V2TIMFriendshipListener() { // from class: com.tencent.qcloud.tuikit.tuichat.TUIChatService.2
            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendInfoChanged(List<V2TIMFriendInfo> list) {
                for (C2CChatEventListener c2CChatEventListener : TUIChatService.getInstance().getC2CChatEventListenerList()) {
                    for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                        if (TextUtils.isEmpty(v2TIMFriendInfo.getFriendRemark())) {
                            String nickName = v2TIMFriendInfo.getUserProfile().getNickName();
                            if (TextUtils.isEmpty(nickName)) {
                                c2CChatEventListener.onFriendNameChanged(v2TIMFriendInfo.getUserID(), v2TIMFriendInfo.getUserID());
                            } else {
                                c2CChatEventListener.onFriendNameChanged(v2TIMFriendInfo.getUserID(), nickName);
                            }
                        } else {
                            c2CChatEventListener.onFriendNameChanged(v2TIMFriendInfo.getUserID(), v2TIMFriendInfo.getFriendRemark());
                        }
                        c2CChatEventListener.onFriendFaceUrlChanged(v2TIMFriendInfo.getUserID(), v2TIMFriendInfo.getUserProfile().getFaceUrl());
                    }
                }
            }
        });
        V2TIMManager.getInstance().addIMSDKListener(new V2TIMSDKListener() { // from class: com.tencent.qcloud.tuikit.tuichat.TUIChatService.3
            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectSuccess() {
                Iterator it = TUIChatService.this.connectListenerList.iterator();
                while (it.hasNext()) {
                    NetworkConnectionListener networkConnectionListener = (NetworkConnectionListener) ((WeakReference) it.next()).get();
                    if (networkConnectionListener != null) {
                        networkConnectionListener.onConnected();
                    }
                }
            }
        });
    }

    private void initMessageType() {
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_EVALUATION, CustomEvaluationMessageBean.class);
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, CustomOrderMessageBean.class);
        addCustomMessageType(TUIChatConstants.BUSINESS_ID_CUSTOM_TYPING, MessageTypingBean.class);
        addCustomMessageType(Identifier.TIMGiftMessage.name(), GiftMessageBean.class);
        addCustomMessageType(Identifier.TIMGroupBroadcastMessage.name(), BroadcastGroupMessageBean.class);
        addCustomMessageType(Identifier.TIMVideoTradeUnionTimeout.name(), VideoTimeOutMessageBean.class);
        addCustomMessageType(Identifier.TIMGiftTimeoutReceiver.name(), ReceiverGiftTimeOutMessageBean.class);
        addCustomMessageType(Identifier.TIMGiftTimeoutSender.name(), SendGiftTimeOutMessageBean.class);
        addCustomMessageType(Identifier.TIMSendHeadwearMessage.name(), HeadWearMessageBean.class);
        addCustomMessageType(Identifier.TIMSendPropertyMessage.name(), MountsMessageBean.class);
        addCustomMessageType(Identifier.HiloLinkMessage.name(), LinkMessageBean.class);
        addCustomMessageType(Identifier.TIMSendNobleMessage.name(), NobleMessageBean.class);
        addCustomMessageType(Identifier.TIMGroupInviteMessage.name(), InviteEnterRoomMessageBean.class);
        addCustomMessageType(Identifier.TIMFamilyInvitation.name(), FamilyInviteMessageBean.class);
        addCustomMessageType(Identifier.TIMCommonImageText.name(), TextAndImageMessageBean.class);
        addCustomMessageType(Identifier.TIMVideoCallMessage.name(), VideoCallMessageBean.class);
        addCustomMessageType(Identifier.TIMGuildUserHello.name(), UnionFirstMessageBean.class);
        addCustomMessageType(Identifier.SheepPKInviteMessage.name(), SheepInviteMessageBean.class);
        addCustomMessageType(Identifier.GamePKInviteMessage.name(), PKInviteMessageBean.class);
        addCustomMessageType(Identifier.CpInviteMessage.name(), InviteCpMessageBean.class);
        addCustomMessageType(Identifier.CpAcceptInviteMessage.name(), CpSuccessMessageBean.class);
        addCustomMessageType(Identifier.CpCancelMessage.name(), CpUnbindMessageBean.class);
        addCustomMessageType(Identifier.CpDenyInviteMessage.name(), CpTipMessageBean.class);
        addCustomMessageType(Identifier.CpDealCancelMessage.name(), CpTipMessageBean.class);
        addCustomMessageType(Identifier.TIMCommonMessage.name(), PictureLinkMessageBean.class);
        addCustomMessageType(Identifier.SpecialRelationInviteMessage.name(), RelationInviteMessageBean.class);
        addCustomMessageType(Identifier.SpecialRelationAcceptInviteMessage.name(), RelationSuccessMessageBean.class);
        addCustomMessageType(Identifier.SpecialRelationCancelMessage.name(), RelationUnbindMessageBean.class);
        addCustomMessageType(Identifier.SpecialRelationDenyInviteMessage.name(), RelationTipMessageBean.class);
        addCustomMessageType(Identifier.SpecialRelationDealCancelMessage.name(), RelationTipMessageBean.class);
        addCustomMessageType(Identifier.TIMSuperLikeMessage.name(), LikeMessageBean.class);
        addCustomMessageType(Identifier.TIMSuperLikeTimeoutReceiver.name(), ReceiverSuperLikeTimeOutMessageBean.class);
        addCustomMessageType(Identifier.TIMSuperLikeTimeoutSender.name(), SendSuperLikeTimeOutMessageBean.class);
        addCustomMessageType(MessageService.MSG_DB_NOTIFY_REACHED, RoomJoinBean.class);
        addCustomMessageType(AgooConstants.ACK_PACK_NOBIND, RoomUserEnterBean.class);
        addCustomMessageType(MessageService.MSG_DB_NOTIFY_CLICK, RoomKickBean.class);
        addCustomMessageType("3", RoomKickBean.class);
        addCustomMessageType(MessageService.MSG_ACCS_READY_REPORT, RoomAppointedBean.class);
        addCustomMessageType("5", RoomAppointedBean.class);
        addCustomMessageType("6", RoomGiftBean.class);
        addCustomMessageType("109", RoomUnNoBean.class);
        addCustomMessageType("1000", RoomTipBean.class);
        addCustomMessageType("108", RoomTipBean.class);
        addCustomMessageType("7", RoomRolledBean.class);
        addCustomMessageType(AgooConstants.ACK_BODY_NULL, RoomRocketBean.class);
        addCustomMessageType(MessageService.MSG_ACCS_NOTIFY_CLICK, RoomGlobalGiftBean.class);
        addCustomMessageType(MessageService.MSG_ACCS_NOTIFY_DISMISS, RoomSupportBean.class);
        addCustomMessageType(AgooConstants.ACK_REMOVE_PACKAGE, RoomJumpBean.class);
        addCustomMessageType(AgooConstants.ACK_PACK_NULL, RoomLuckyBoxBean.class);
        addCustomMessageType(AgooConstants.ACK_FLAG_NULL, RoomLuckyFruitBean.class);
        addCustomMessageType("105", RoomActivityBean.class);
        addCustomMessageType("101", RoomCreateLudoOrUnoBean.class);
        addCustomMessageType("102", RoomCreateLudoOrUnoBean.class);
        addCustomMessageType("103", RoomCreateLudoOrUnoBean.class);
        addCustomMessageType("106", RoomOwnWelcomeBean.class);
        addCustomMessageType("104", RoomCreateLudoOrUnoBean.class);
        addCustomMessageType("120", RoomMatchGameBean.class);
        addCustomMessageType("121", RoomPKEndBean.class);
        addCustomMessageType("124", RoomCreateLudoOrUnoBean.class);
        addCustomMessageType("127", RoomCreateLudoOrUnoBean.class);
        addCustomMessageType("125", RoomEnvelopeBean.class);
        addCustomMessageType("126", RoomEnvelopeGetBean.class);
        addCustomMessageType("128", RoomPK1v1Bean.class);
        addCustomMessageType("129", RoomPK1v1Bean.class);
        addCustomMessageType("130", RoomPK1v1Bean.class);
        addCustomMessageType("131", RoomCreateLudoOrUnoBean.class);
        addCustomMessageType("122", StrangePlayTipMessageBean.class);
        addCustomMessageType("123", StrangeGiftTimeOutMessageBean.class);
    }

    private void initService() {
        TUICore.registerService("TUIChatService", this);
    }

    public void addAudioRecordEventListener(AudioRecordEventListener audioRecordEventListener) {
        if (audioRecordEventListener == null) {
            return;
        }
        Iterator<WeakReference<AudioRecordEventListener>> it = this.audioRecordEventListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == audioRecordEventListener) {
                return;
            }
        }
        this.audioRecordEventListenerList.add(new WeakReference<>(audioRecordEventListener));
    }

    public void addC2CChatEventListener(C2CChatEventListener c2CChatEventListener) {
        if (c2CChatEventListener == null) {
            return;
        }
        Iterator<WeakReference<C2CChatEventListener>> it = this.c2CChatEventListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == c2CChatEventListener) {
                return;
            }
        }
        this.c2CChatEventListenerList.add(new WeakReference<>(c2CChatEventListener));
    }

    public void addGroupChatEventListener(GroupChatEventListener groupChatEventListener) {
        if (groupChatEventListener == null) {
            return;
        }
        Iterator<WeakReference<GroupChatEventListener>> it = this.groupChatEventListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == groupChatEventListener) {
                return;
            }
        }
        this.groupChatEventListenerList.add(new WeakReference<>(groupChatEventListener));
    }

    public void addUnreadCountListener(TotalUnreadCountListener totalUnreadCountListener) {
        if (totalUnreadCountListener == null) {
            return;
        }
        Iterator<WeakReference<TotalUnreadCountListener>> it = this.unreadCountListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == totalUnreadCountListener) {
                return;
            }
        }
        this.unreadCountListenerList.add(new WeakReference<>(totalUnreadCountListener));
    }

    public List<AudioRecordEventListener> getAudioRecordEventListenerList() {
        ArrayList arrayList = new ArrayList();
        ListIterator<WeakReference<AudioRecordEventListener>> listIterator = this.audioRecordEventListenerList.listIterator();
        while (listIterator.hasNext()) {
            AudioRecordEventListener audioRecordEventListener = listIterator.next().get();
            if (audioRecordEventListener == null) {
                listIterator.remove();
            } else {
                arrayList.add(audioRecordEventListener);
            }
        }
        return arrayList;
    }

    public RxDataStore<Preferences> getChatDataStore() {
        return this.mChatDataStore;
    }

    public Class<? extends TUIMessageBean> getMessageBeanClass(String str) {
        return this.customMessageMap.get(str);
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public void init(Context context) {
        instance = this;
        initMessageType();
        initService();
        initEvent();
        initIMListener();
        initDataStore();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ITUIChatService, com.tencent.qcloud.tuicore.interfaces.ITUIService
    public Object onCall(String str, Map<String, Object> map) {
        V2TIMMessage v2TIMMessage;
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_SEND_MESSAGE, str)) {
            String str2 = (String) map.get("chatId");
            int intValue = ((Integer) getOrDefault(map.get(TUIConstants.TUIChat.CHAT_TYPE), 0)).intValue();
            String str3 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_CONTENT), "");
            String str4 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_DESCRIPTION), "");
            String str5 = (String) getOrDefault(map.get(TUIConstants.TUIChat.MESSAGE_EXTENSION), "");
            IBaseMessageSender messageSender = getMessageSender();
            if (messageSender != null) {
                messageSender.sendMessage(ChatMessageBuilder.buildCustomMessage(str3, str4, str5.getBytes()), str2, TUIChatUtils.isGroupChat(intValue));
                return null;
            }
            return null;
        }
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_EXIT_CHAT, str)) {
            String str6 = (String) map.get("chatId");
            if (((Boolean) map.get(TUIConstants.TUIChat.IS_GROUP_CHAT)).booleanValue()) {
                Iterator<GroupChatEventListener> it = getGroupChatEventListenerList().iterator();
                while (it.hasNext()) {
                    it.next().exitGroupChat(str6);
                }
                return null;
            }
            Iterator<C2CChatEventListener> it2 = getC2CChatEventListenerList().iterator();
            while (it2.hasNext()) {
                it2.next().exitC2CChat(str6);
            }
            return null;
        }
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_GET_DISPLAY_STRING, str)) {
            if (map != null && (v2TIMMessage = (V2TIMMessage) map.get(TUIConstants.TUIChat.V2TIMMESSAGE)) != null) {
                return ChatMessageParser.getDisplayString(v2TIMMessage);
            }
            return null;
        }
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_ADD_MESSAGE_TO_CHAT, str)) {
            TUIMessageBean tUIMessageBean = (TUIMessageBean) map.get("messageBean");
            String str7 = (String) map.get("chatId");
            if (((Boolean) map.get(TUIConstants.TUIChat.IS_GROUP_CHAT)).booleanValue()) {
                Iterator<GroupChatEventListener> it3 = getGroupChatEventListenerList().iterator();
                while (it3.hasNext()) {
                    it3.next().addMessage(tUIMessageBean, str7);
                }
                return null;
            }
            Iterator<C2CChatEventListener> it4 = getC2CChatEventListenerList().iterator();
            while (it4.hasNext()) {
                it4.next().addMessage(tUIMessageBean, str7);
            }
            return null;
        }
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_GROUP_APPLICAITON_PROCESSED, str)) {
            int intValue2 = ((Integer) map.get(TUIConstants.TUIChat.GROUP_APPLY_NUM)).intValue();
            if (((Boolean) map.get(TUIConstants.TUIChat.IS_GROUP_CHAT)).booleanValue()) {
                Iterator<GroupChatEventListener> it5 = getGroupChatEventListenerList().iterator();
                while (it5.hasNext()) {
                    it5.next().onApplied(intValue2);
                }
                return null;
            }
            return null;
        }
        if (TextUtils.equals(TUIConstants.TUIChat.METHOD_UPDATE_DATA_STORE_CHAT_URI, str)) {
            String str8 = (String) map.get(TUIConstants.TUIChat.CHAT_BACKGROUND_URI);
            String str9 = (String) map.get("chatId");
            if (!TextUtils.isEmpty(str8)) {
                DataStoreUtil.getInstance().putValue(str9, str8);
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ITUIChatService, com.tencent.qcloud.tuicore.interfaces.ITUINotification
    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        if (TextUtils.equals(str, TUIConstants.TUIGroup.EVENT_GROUP)) {
            String str3 = null;
            if (!TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_EXIT_GROUP) && !TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_DISMISS) && !TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_RECYCLE)) {
                if (TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_GROUP_INFO_CHANGED)) {
                    if (map == null) {
                        return;
                    }
                    String str4 = (String) getOrDefault(map.get("groupName"), null);
                    String str5 = (String) getOrDefault(map.get("groupId"), "");
                    String str6 = (String) getOrDefault(map.get(TUIConstants.TUIGroup.GROUP_FACE_URL), null);
                    if (TextUtils.isEmpty(str5)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        Iterator<GroupChatEventListener> it = getGroupChatEventListenerList().iterator();
                        while (it.hasNext()) {
                            it.next().onGroupNameChanged(str5, str4);
                        }
                    }
                    if (!TextUtils.isEmpty(str6)) {
                        Iterator<GroupChatEventListener> it2 = getGroupChatEventListenerList().iterator();
                        while (it2.hasNext()) {
                            it2.next().onGroupFaceUrlChanged(str5, str6);
                        }
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_MEMBER_KICKED_GROUP)) {
                    if (map == null) {
                        return;
                    }
                    String str7 = (String) getOrDefault(map.get("groupId"), "");
                    ArrayList arrayList = (ArrayList) map.get(TUIConstants.TUIGroup.GROUP_MEMBER_ID_LIST);
                    if (!TextUtils.isEmpty(str7) && arrayList != null && !arrayList.isEmpty() && arrayList.contains(TUILogin.getLoginUser())) {
                        Iterator<GroupChatEventListener> it3 = getGroupChatEventListenerList().iterator();
                        while (it3.hasNext()) {
                            it3.next().onGroupForceExit(str7);
                        }
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str2, TUIConstants.TUIGroup.EVENT_SUB_KEY_CLEAR_MESSAGE)) {
                    String str8 = (String) getOrDefault(map.get("groupId"), "");
                    Iterator<GroupChatEventListener> it4 = getGroupChatEventListenerList().iterator();
                    while (it4.hasNext()) {
                        it4.next().clearGroupMessage(str8);
                    }
                    return;
                }
                return;
            }
            List<GroupChatEventListener> groupChatEventListenerList = getGroupChatEventListenerList();
            if (map != null) {
                str3 = (String) getOrDefault(map.get("groupId"), "");
            }
            Iterator<GroupChatEventListener> it5 = groupChatEventListenerList.iterator();
            while (it5.hasNext()) {
                it5.next().onGroupForceExit(str3);
            }
            return;
        }
        if (str.equals(TUIConstants.TUIContact.EVENT_USER)) {
            if (str2.equals(TUIConstants.TUIContact.EVENT_SUB_KEY_CLEAR_MESSAGE) && map != null && !map.isEmpty()) {
                String str9 = (String) getOrDefault(map.get(TUIConstants.TUIContact.FRIEND_ID), "");
                Iterator<C2CChatEventListener> it6 = getC2CChatEventListenerList().iterator();
                while (it6.hasNext()) {
                    it6.next().clearC2CMessage(str9);
                }
                return;
            }
            return;
        }
        if (str.equals(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED)) {
            if (str2.equals(TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED) && map != null && !map.isEmpty()) {
                String str10 = (String) map.get(TUIConstants.TUIContact.FRIEND_ID);
                String str11 = (String) map.get(TUIConstants.TUIContact.FRIEND_REMARK);
                Iterator<C2CChatEventListener> it7 = getC2CChatEventListenerList().iterator();
                while (it7.hasNext()) {
                    it7.next().onFriendNameChanged(str10, str11);
                }
                return;
            }
            return;
        }
        if (str.equals(TUIConstants.TUIConversation.EVENT_UNREAD)) {
            if (str2.equals(TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED)) {
                long longValue = ((Long) map.get(TUIConstants.TUIConversation.TOTAL_UNREAD_COUNT)).longValue();
                Iterator<TotalUnreadCountListener> it8 = getUnreadCountListenerList().iterator();
                while (it8.hasNext()) {
                    it8.next().onTotalUnreadCountChanged(longValue);
                }
                return;
            }
            return;
        }
        if (TextUtils.equals(str, TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED)) {
            if (TextUtils.equals(str2, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS)) {
                FaceManager.loadEmojis();
                HashMap hashMap = new HashMap();
                hashMap.put(TUIConstants.TUICalling.PARAM_NAME_ENABLE_FLOAT_WINDOW, Boolean.valueOf(TUIChatConfigs.getConfigs().getGeneralConfig().isEnableFloatWindowForCall()));
                TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_ENABLE_FLOAT_WINDOW, hashMap);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(TUIConstants.TUICalling.PARAM_NAME_ENABLE_MULTI_DEVICE, Boolean.valueOf(TUIChatConfigs.getConfigs().getGeneralConfig().isEnableMultiDeviceForCall()));
                TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_ENABLE_MULTI_DEVICE, hashMap2);
                return;
            }
            return;
        }
        if (TextUtils.equals(str, TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED)) {
            if (TextUtils.equals(str2, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND)) {
                Object obj = map.get("messageBean");
                if (obj instanceof TUIMessageBean) {
                    Iterator<GroupChatEventListener> it9 = getGroupChatEventListenerList().iterator();
                    while (it9.hasNext()) {
                        it9.next().onMessageChanged((TUIMessageBean) obj);
                    }
                    Iterator<C2CChatEventListener> it10 = getC2CChatEventListenerList().iterator();
                    while (it10.hasNext()) {
                        it10.next().onMessageChanged((TUIMessageBean) obj);
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (TextUtils.equals(str, TUIConstants.TUICalling.EVENT_KEY_RECORD_AUDIO_MESSAGE)) {
            if (map == null) {
                return;
            }
            int intValue = ((Integer) getOrDefault(map.get(Constants.KEY_ERROR_CODE), Integer.valueOf(TUIConstants.TUICalling.ERROR_INVALID_PARAM))).intValue();
            String str12 = (String) getOrDefault(map.get(TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH), "");
            for (AudioRecordEventListener audioRecordEventListener : getAudioRecordEventListenerList()) {
                if (TextUtils.equals(str2, TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_START)) {
                    audioRecordEventListener.onRecordBegin(intValue, str12);
                } else if (TextUtils.equals(str2, TUIConstants.TUICalling.EVENT_SUB_KEY_RECORD_STOP)) {
                    audioRecordEventListener.onRecordComplete(intValue, str12);
                }
            }
            return;
        }
        if (TextUtils.equals(str, TUIChatConstants.EVENT_KEY_OFFLINE_MESSAGE_PRIVATE_RING) && TextUtils.equals(str2, TUIChatConstants.EVENT_SUB_KEY_OFFLINE_MESSAGE_PRIVATE_RING)) {
            TUIChatConfigs.getConfigs().getGeneralConfig().setAndroidPrivateRing(((Boolean) map.get(TUIChatConstants.OFFLINE_MESSAGE_PRIVATE_RING)).booleanValue());
        }
    }

    public void registerNetworkListener(NetworkConnectionListener networkConnectionListener) {
        if (networkConnectionListener == null) {
            return;
        }
        Iterator<WeakReference<NetworkConnectionListener>> it = this.connectListenerList.iterator();
        while (it.hasNext()) {
            if (it.next().get() == networkConnectionListener) {
                return;
            }
        }
        this.connectListenerList.add(new WeakReference<>(networkConnectionListener));
    }

    public void setMessageSender(IBaseMessageSender iBaseMessageSender) {
        this.messageSender = new WeakReference<>(iBaseMessageSender);
    }
}
