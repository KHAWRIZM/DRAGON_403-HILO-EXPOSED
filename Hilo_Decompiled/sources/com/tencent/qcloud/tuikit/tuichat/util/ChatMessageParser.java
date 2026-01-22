package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.r;
import com.qiahao.base_common.model.im.CheckMessageType;
import com.qiahao.base_common.support.BaseControlUtils;
import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.CallModel;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageCustom;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageFeature;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageReactBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.LocationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomTextBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatMessageParser {
    private static final String TAG = "ChatMessageParser";
    private static final com.google.gson.d gson = new com.google.gson.d();

    private static TUIMessageBean getCallingMessage(V2TIMMessage v2TIMMessage) {
        String string;
        int i;
        List<String> list;
        boolean isEmpty = TextUtils.isEmpty(v2TIMMessage.getGroupID());
        CallModel convert2VideoCallData = CallModel.convert2VideoCallData(v2TIMMessage);
        if (convert2VideoCallData == null) {
            return null;
        }
        String displayName = getDisplayName(v2TIMMessage);
        Context appContext = ServiceInitializer.getAppContext();
        switch (convert2VideoCallData.action) {
            case 1:
                if (!isEmpty) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.start_group_call);
                    break;
                } else {
                    string = appContext.getString(R.string.start_call);
                    break;
                }
            case 2:
                if (!isEmpty) {
                    i = R.string.cancle_group_call;
                } else {
                    i = R.string.cancle_call;
                }
                string = appContext.getString(i);
                break;
            case 3:
                if (!isEmpty) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.reject_group_calls);
                    break;
                } else {
                    string = appContext.getString(R.string.reject_calls);
                    break;
                }
            case 4:
                if (!isEmpty && (list = convert2VideoCallData.invitedList) != null && list.size() == 1 && convert2VideoCallData.invitedList.get(0).equals(v2TIMMessage.getSender())) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.no_response_call);
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    List<String> list2 = convert2VideoCallData.invitedList;
                    if (list2 != null && list2.size() > 0) {
                        Iterator<String> it = convert2VideoCallData.invitedList.iterator();
                        while (it.hasNext()) {
                            sb2.append(it.next());
                            sb2.append("、");
                        }
                        if (sb2.length() > 0) {
                            sb2.delete(sb2.length() - 1, sb2.length());
                        }
                    }
                    if (!isEmpty) {
                        string = "\"" + sb2.toString() + "\"" + appContext.getString(R.string.no_response_call);
                        break;
                    } else {
                        string = appContext.getString(R.string.no_response_call);
                        break;
                    }
                }
            case 5:
                if (!isEmpty) {
                    string = appContext.getString(R.string.stop_group_call);
                    break;
                } else {
                    string = appContext.getString(R.string.stop_call_tip) + DateTimeUtil.formatSecondsTo00(convert2VideoCallData.duration);
                    break;
                }
            case 6:
                if (!isEmpty) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.line_busy);
                    break;
                } else {
                    string = appContext.getString(R.string.other_line_busy);
                    break;
                }
            case 7:
                if (!isEmpty) {
                    string = "\"" + displayName + "\"" + appContext.getString(R.string.accept_call);
                    break;
                } else {
                    string = appContext.getString(R.string.accept_call);
                    break;
                }
            case 8:
                string = appContext.getString(R.string.chat_calling_switch_to_audio);
                break;
            case 9:
                string = appContext.getString(R.string.chat_calling_switch_to_audio_accept);
                break;
            case 10:
                string = appContext.getString(R.string.chat_calling_unknown_invitation);
                break;
            default:
                string = appContext.getString(R.string.invalid_command);
                break;
        }
        if (!isEmpty) {
            TipsMessageBean tipsMessageBean = new TipsMessageBean();
            tipsMessageBean.setCommonAttribute(v2TIMMessage);
            tipsMessageBean.setText(string);
            tipsMessageBean.setExtra(string);
            return tipsMessageBean;
        }
        CallingMessageBean callingMessageBean = new CallingMessageBean();
        callingMessageBean.setCommonAttribute(v2TIMMessage);
        callingMessageBean.setText(string);
        callingMessageBean.setExtra(string);
        callingMessageBean.setCallType(convert2VideoCallData.callType);
        return callingMessageBean;
    }

    private static String getCustomBusinessId(V2TIMMessage v2TIMMessage) {
        HashMap hashMap;
        Object obj;
        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
        String str = null;
        if (customElem == null || customElem.getData() == null || customElem.getData().length == 0) {
            return null;
        }
        String str2 = new String(customElem.getData());
        try {
            hashMap = (HashMap) gson.j(str2, HashMap.class);
        } catch (r unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
            hashMap = null;
        }
        if (hashMap != null) {
            obj = hashMap.get(TUIConstants.Message.CUSTOM_BUSINESS_ID_KEY);
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str == null) {
            if (v2TIMMessage.getGroupID() == null) {
                return CheckMessageType.INSTANCE.checkC2CMessageType(str2);
            }
            return CheckMessageType.INSTANCE.checkRoomMessageType(str2);
        }
        return str;
    }

    public static String getDisplayName(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null) {
            return null;
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getNameCard())) {
            return v2TIMMessage.getNameCard();
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getFriendRemark())) {
            return v2TIMMessage.getFriendRemark();
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getNickName())) {
            return v2TIMMessage.getNickName();
        }
        return v2TIMMessage.getSender();
    }

    public static String getDisplayString(V2TIMMessage v2TIMMessage) {
        TUIMessageBean parseMessage;
        String onGetDisplayString;
        String nameCard;
        if (v2TIMMessage == null || (parseMessage = parseMessage(v2TIMMessage)) == null) {
            return null;
        }
        if (parseMessage.getStatus() == 275) {
            if (parseMessage.isSelf()) {
                onGetDisplayString = ServiceInitializer.getAppContext().getString(R.string.revoke_tips_you);
            } else if (parseMessage.isGroup()) {
                if (TextUtils.isEmpty(parseMessage.getNameCard())) {
                    nameCard = parseMessage.getSender();
                } else {
                    nameCard = parseMessage.getNameCard();
                }
                onGetDisplayString = TUIChatConstants.covert2HTMLString(nameCard) + ServiceInitializer.getAppContext().getString(R.string.revoke_tips);
            } else {
                onGetDisplayString = ServiceInitializer.getAppContext().getString(R.string.revoke_tips_other);
            }
        } else {
            onGetDisplayString = parseMessage.onGetDisplayString();
        }
        return FaceManager.emojiJudge(onGetDisplayString);
    }

    public static String getLocalImagePath(TUIMessageBean tUIMessageBean) {
        V2TIMMessage v2TIMMessage;
        V2TIMImageElem imageElem;
        if (tUIMessageBean == null || !tUIMessageBean.isSelf() || (v2TIMMessage = tUIMessageBean.getV2TIMMessage()) == null || v2TIMMessage.getElemType() != 3 || (imageElem = v2TIMMessage.getImageElem()) == null) {
            return null;
        }
        String path = imageElem.getPath();
        if (!new File(path).exists()) {
            return null;
        }
        return path;
    }

    public static String getMsgTypeStr(int i) {
        switch (i) {
            case 3:
                return ServiceInitializer.getAppContext().getString(R.string.picture_extra);
            case 4:
                return ServiceInitializer.getAppContext().getString(R.string.audio_extra);
            case 5:
                return ServiceInitializer.getAppContext().getString(R.string.video_extra);
            case 6:
                return ServiceInitializer.getAppContext().getString(R.string.file_extra);
            case 7:
                return ServiceInitializer.getAppContext().getString(R.string.location_extra);
            case 8:
                return ServiceInitializer.getAppContext().getString(R.string.custom_emoji);
            default:
                return "";
        }
    }

    public static String getReplyMessageAbstract(TUIMessageBean tUIMessageBean) {
        String str;
        if (tUIMessageBean == null) {
            return "";
        }
        if (tUIMessageBean instanceof TextMessageBean) {
            str = ((TextMessageBean) tUIMessageBean).getText();
        } else if (tUIMessageBean instanceof MergeMessageBean) {
            str = ((MergeMessageBean) tUIMessageBean).getTitle();
        } else if (tUIMessageBean instanceof FileMessageBean) {
            str = ((FileMessageBean) tUIMessageBean).getFileName();
        } else if (tUIMessageBean instanceof CustomLinkMessageBean) {
            str = ((CustomLinkMessageBean) tUIMessageBean).getText();
        } else if ((tUIMessageBean instanceof SoundMessageBean) || (tUIMessageBean instanceof ImageMessageBean) || (tUIMessageBean instanceof VideoMessageBean) || (tUIMessageBean instanceof LocationMessageBean) || (tUIMessageBean instanceof FaceMessageBean)) {
            str = "";
        } else {
            str = tUIMessageBean.getExtra();
        }
        return "" + str;
    }

    public static boolean isFileType(int i) {
        return i == 6;
    }

    public static MessageFeature isSupportTyping(TUIMessageBean tUIMessageBean) {
        MessageFeature messageFeature;
        String cloudCustomData = tUIMessageBean.getV2TIMMessage().getCloudCustomData();
        if (TextUtils.isEmpty(cloudCustomData)) {
            return null;
        }
        try {
            com.google.gson.d dVar = gson;
            HashMap hashMap = (HashMap) dVar.j(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TUIChatConstants.MESSAGE_FEATURE_KEY);
                if (obj instanceof Map) {
                    messageFeature = (MessageFeature) dVar.j(dVar.s(obj), MessageFeature.class);
                } else {
                    messageFeature = null;
                }
                if (messageFeature != null) {
                    if (messageFeature.getVersion() > 1) {
                        return null;
                    }
                    return messageFeature;
                }
            }
        } catch (r e) {
            TUIChatLog.e(TAG, " isSupportTyping exception e = " + e);
        }
        return null;
    }

    public static boolean isTyping(byte[] bArr) {
        MessageTyping messageTyping;
        try {
            String str = new String(bArr, "UTF-8");
            if (str.contains("\"userAction\"") && str.contains("\"actionParam\"") && (messageTyping = (MessageTyping) gson.j(str, MessageTyping.class)) != null && messageTyping.userAction == 14) {
                if (TextUtils.equals(messageTyping.actionParam, MessageTyping.EDIT_START)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            TUIChatLog.e(TAG, "parse json error");
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TUIMessageBean parseCallingMessage(V2TIMMessage v2TIMMessage) {
        Double d;
        String str;
        HashMap hashMap;
        V2TIMSignalingInfo signalingInfo = V2TIMManager.getSignalingManager().getSignalingInfo(v2TIMMessage);
        if (signalingInfo == null) {
            return null;
        }
        Double valueOf = Double.valueOf(0.0d);
        try {
            hashMap = (HashMap) gson.j(signalingInfo.getData(), HashMap.class);
        } catch (r unused) {
            TUIChatLog.e(TAG, " get signalingInfoCustomJsonMap error ");
        }
        if (hashMap != null) {
            d = hashMap.get(TUIConstants.Message.CUSTOM_BUSINESS_ID_KEY);
            if (!(d instanceof String)) {
                str = (String) d;
            } else {
                if (d instanceof Double) {
                    valueOf = d;
                }
                str = null;
            }
            if (TextUtils.equals(str, TUIConstants.TUICalling.CUSTOM_MESSAGE_BUSINESS_ID) && Math.abs(valueOf.doubleValue() - TUIConstants.TUICalling.CALL_TIMEOUT_BUSINESS_ID.doubleValue()) >= 1.0E-6d) {
                return null;
            }
            return getCallingMessage(v2TIMMessage);
        }
        d = 0;
        if (!(d instanceof String)) {
        }
        if (TextUtils.equals(str, TUIConstants.TUICalling.CUSTOM_MESSAGE_BUSINESS_ID)) {
        }
        return getCallingMessage(v2TIMMessage);
    }

    private static TUIMessageBean parseCustomMessage(V2TIMMessage v2TIMMessage) {
        TUIMessageBean parseCallingMessage = parseCallingMessage(v2TIMMessage);
        if (parseCallingMessage == null) {
            parseCallingMessage = parseGroupCreateMessage(v2TIMMessage);
        }
        if (parseCallingMessage == null) {
            parseCallingMessage = parseCustomMessageFromMap(v2TIMMessage);
        }
        if (parseCallingMessage == null) {
            TextMessageBean textMessageBean = new TextMessageBean();
            textMessageBean.setText(ServiceInitializer.getAppContext().getString(R.string.this_message_type_is_not_supported));
            return textMessageBean;
        }
        return parseCallingMessage;
    }

    private static TUIMessageBean parseCustomMessageFromMap(V2TIMMessage v2TIMMessage) {
        Class<? extends TUIMessageBean> messageBeanClass = TUIChatService.getInstance().getMessageBeanClass(getCustomBusinessId(v2TIMMessage));
        if (messageBeanClass != null) {
            try {
                return messageBeanClass.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    private static TUIMessageBean parseGroupCreateMessage(V2TIMMessage v2TIMMessage) {
        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
        if (customElem != null && customElem.getData() != null && customElem.getData().length != 0) {
            String str = new String(customElem.getData());
            if (str.equals(MessageCustom.BUSINESS_ID_GROUP_CREATE)) {
                TipsMessageBean tipsMessageBean = new TipsMessageBean();
                tipsMessageBean.setCommonAttribute(v2TIMMessage);
                tipsMessageBean.setTipType(257);
                String str2 = TUIChatConstants.covert2HTMLString(getDisplayName(v2TIMMessage)) + ServiceInitializer.getAppContext().getString(R.string.create_group);
                tipsMessageBean.setText(str2);
                tipsMessageBean.setExtra(str2);
                return tipsMessageBean;
            }
            if (isTyping(customElem.getData())) {
                return null;
            }
            try {
                MessageCustom messageCustom = (MessageCustom) gson.j(str, MessageCustom.class);
                if (!TextUtils.isEmpty(messageCustom.businessID) && messageCustom.businessID.equals(MessageCustom.BUSINESS_ID_GROUP_CREATE)) {
                    TipsMessageBean tipsMessageBean2 = new TipsMessageBean();
                    tipsMessageBean2.setCommonAttribute(v2TIMMessage);
                    tipsMessageBean2.setTipType(257);
                    String str3 = TUIChatConstants.covert2HTMLString(getDisplayName(v2TIMMessage)) + messageCustom.content;
                    tipsMessageBean2.setText(str3);
                    tipsMessageBean2.setExtra(str3);
                    return tipsMessageBean2;
                }
            } catch (Exception e) {
                TUIChatLog.e(TAG, "invalid json: " + str + ", exception:" + e);
            }
        }
        return null;
    }

    public static TUIMessageBean parseMessage(V2TIMMessage v2TIMMessage) {
        return parseMessage(v2TIMMessage, false);
    }

    public static List<TUIMessageBean> parseMessageList(List<V2TIMMessage> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            TUIMessageBean parseMessage = parseMessage(list.get(i));
            if (parseMessage != null) {
                arrayList.add(parseMessage);
            }
        }
        return arrayList;
    }

    public static MessageReactBean parseMessageReact(TUIMessageBean tUIMessageBean) {
        MessageReactBean messageReactBean;
        String cloudCustomData = tUIMessageBean.getV2TIMMessage().getCloudCustomData();
        try {
            com.google.gson.d dVar = gson;
            HashMap hashMap = (HashMap) dVar.j(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TUIChatConstants.MESSAGE_REACT_KEY);
                if (obj instanceof Map) {
                    messageReactBean = (MessageReactBean) dVar.j(dVar.s(obj), MessageReactBean.class);
                } else {
                    messageReactBean = null;
                }
                if (messageReactBean != null) {
                    if (messageReactBean.getVersion() > 1) {
                        return null;
                    }
                    return messageReactBean;
                }
            }
        } catch (r unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
        }
        return null;
    }

    public static MessageRepliesBean parseMessageReplies(TUIMessageBean tUIMessageBean) {
        MessageRepliesBean messageRepliesBean;
        String cloudCustomData = tUIMessageBean.getV2TIMMessage().getCloudCustomData();
        try {
            com.google.gson.d dVar = gson;
            HashMap hashMap = (HashMap) dVar.j(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TUIChatConstants.MESSAGE_REPLIES_KEY);
                if (obj instanceof Map) {
                    messageRepliesBean = (MessageRepliesBean) dVar.j(dVar.s(obj), MessageRepliesBean.class);
                } else {
                    messageRepliesBean = null;
                }
                if (messageRepliesBean != null) {
                    if (messageRepliesBean.getVersion() > 1) {
                        return null;
                    }
                    return messageRepliesBean;
                }
            }
        } catch (r unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
        }
        return null;
    }

    private static TUIMessageBean parseReplyMessage(V2TIMMessage v2TIMMessage) {
        ReplyPreviewBean replyPreviewBean;
        String cloudCustomData = v2TIMMessage.getCloudCustomData();
        if (TextUtils.isEmpty(cloudCustomData)) {
            return null;
        }
        try {
            com.google.gson.d dVar = gson;
            HashMap hashMap = (HashMap) dVar.j(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TUIChatConstants.MESSAGE_REPLY_KEY);
                if (obj instanceof Map) {
                    replyPreviewBean = (ReplyPreviewBean) dVar.j(dVar.s(obj), ReplyPreviewBean.class);
                } else {
                    replyPreviewBean = null;
                }
                if (replyPreviewBean == null || replyPreviewBean.getVersion() > 1) {
                    return null;
                }
                if (TextUtils.isEmpty(replyPreviewBean.getMessageRootID())) {
                    return new QuoteMessageBean(replyPreviewBean);
                }
                return new ReplyMessageBean(replyPreviewBean);
            }
        } catch (r unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
        }
        return null;
    }

    public static TUIMessageBean parseMessage(V2TIMMessage v2TIMMessage, boolean z) {
        if (v2TIMMessage == null) {
            return null;
        }
        if (v2TIMMessage.getStatus() != 4 && v2TIMMessage.getElemType() != 0) {
            r0 = z ? null : parseReplyMessage(v2TIMMessage);
            if (r0 == null) {
                int elemType = v2TIMMessage.getElemType();
                boolean isEmpty = TextUtils.isEmpty(v2TIMMessage.getGroupID());
                switch (elemType) {
                    case 1:
                        if (!isEmpty) {
                            if (BaseControlUtils.INSTANCE.checkStrangerGroupFromSDK(v2TIMMessage.getGroupID())) {
                                r0 = new TextMessageBean();
                                break;
                            } else {
                                r0 = new RoomTextBean();
                                break;
                            }
                        } else {
                            r0 = new TextMessageBean();
                            break;
                        }
                    case 2:
                        r0 = parseCustomMessage(v2TIMMessage);
                        break;
                    case 3:
                        if (!isEmpty) {
                            if (BaseControlUtils.INSTANCE.checkStrangerGroupFromSDK(v2TIMMessage.getGroupID())) {
                                r0 = new ImageMessageBean();
                                break;
                            } else {
                                r0 = new RoomImageBean();
                                break;
                            }
                        } else {
                            r0 = new ImageMessageBean();
                            break;
                        }
                    case 4:
                        r0 = new SoundMessageBean();
                        break;
                    case 5:
                        if (!isEmpty) {
                            r0 = new RoomVideoBean();
                            break;
                        } else {
                            r0 = new VideoMessageBean();
                            break;
                        }
                    case 6:
                        r0 = new FileMessageBean();
                        break;
                    case 7:
                        r0 = new LocationMessageBean();
                        break;
                    case 8:
                        r0 = new FaceMessageBean();
                        break;
                    case 9:
                        r0 = new TipsMessageBean();
                        break;
                    case 10:
                        r0 = new MergeMessageBean();
                        break;
                }
            }
            if (r0 != null) {
                r0.setCommonAttribute(v2TIMMessage);
                r0.onProcessMessage(v2TIMMessage);
            }
        }
        return r0;
    }
}
