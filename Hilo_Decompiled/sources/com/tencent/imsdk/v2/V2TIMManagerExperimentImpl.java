package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.CustomServerInfo;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageExtension;
import com.tencent.imsdk.message.MessageExtensionResult;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.offlinepush.OfflinePushConfig;
import com.tencent.imsdk.offlinepush.OfflinePushEventItem;
import com.tencent.imsdk.offlinepush.OfflinePushManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMManagerExperimentImpl {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class V2TIMManagerExperimentImplHolder {
        private static final V2TIMManagerExperimentImpl v2TIMManagerExperiment = new V2TIMManagerExperimentImpl();

        private V2TIMManagerExperimentImplHolder() {
        }
    }

    protected V2TIMManagerExperimentImpl() {
    }

    private void callbackOnError(V2TIMValueCallback<Object> v2TIMValueCallback, int i, String str) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(i, str);
        }
    }

    private void callbackOnSuccess(V2TIMValueCallback<Object> v2TIMValueCallback, Object obj) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onSuccess(obj);
        }
    }

    private void clearLocalHistoryMessage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                MessageCenter.getInstance().clearLocalHistoryMessage(V2TIMConversationManagerImpl.getInstance().getConversationKey(jSONObject.optString(TUIConstants.TUIChat.CONVERSATION_ID)), jSONObject.optLong("beginTimestamp"), jSONObject.optLong("endTimestamp"), new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.8
                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i, String str2) {
                        super.fail(i, str2);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(Object obj2) {
                        super.success(obj2);
                    }
                });
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void findMergerMessages(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("messageID");
                if (TextUtils.isEmpty(optString)) {
                    callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "messageID is empty");
                    return;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("mergerMessageIDList");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String string = optJSONArray.getString(i);
                        if (string != null && (string instanceof String)) {
                            arrayList.add(string);
                        }
                        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "mergerMessageID is empty");
                        return;
                    }
                }
                if (arrayList.size() == 0) {
                    callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "mergerMessageIDList is empty");
                    return;
                } else {
                    MessageCenter.getInstance().findRelayMessageList(optString, arrayList, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.18
                        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                        public void onError(int i2, String str2) {
                            V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                            if (v2TIMValueCallback2 != null) {
                                v2TIMValueCallback2.onError(i2, str2);
                            }
                        }

                        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                        public void onSuccess(List<Message> list) {
                            ArrayList arrayList2 = new ArrayList();
                            for (Message message : list) {
                                V2TIMMessage v2TIMMessage = new V2TIMMessage();
                                v2TIMMessage.setMessage(message);
                                arrayList2.add(v2TIMMessage);
                            }
                            V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                            if (v2TIMValueCallback2 != null) {
                                v2TIMValueCallback2.onSuccess(arrayList2);
                            }
                        }
                    }) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.19
                        @Override // com.tencent.imsdk.common.IMCallback
                        public void fail(int i2, String str2) {
                            super.fail(i2, str2);
                        }

                        @Override // com.tencent.imsdk.common.IMCallback
                        public void success(List<Message> list) {
                            super.success((AnonymousClass19) list);
                        }
                    });
                    return;
                }
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void getAIDenoiseSignature(V2TIMValueCallback<Object> v2TIMValueCallback) {
        BaseManager.getInstance().getAIDenoiseSignature(new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.10
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private void getBriefGroupMemberList(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            V2TIMValueCallback<List<GroupMemberInfo>> v2TIMValueCallback2 = new V2TIMValueCallback<List<GroupMemberInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.20
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<GroupMemberInfo> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberInfo groupMemberInfo : list) {
                            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                            v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                            arrayList.add(v2TIMGroupMemberFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            };
            BaseManager.getInstance().getBriefGroupMemberList((String) obj, new IMCallback<List<GroupMemberInfo>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.21
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<GroupMemberInfo> list) {
                    super.success((AnonymousClass21) list);
                }
            });
            return;
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void getConversationGroupOrderData(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        ConversationManager.getInstance().getConversationGroupOrderData(new IMCallback<String>(new V2TIMValueCallback<String>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(String str) {
                v2TIMValueCallback.onSuccess(str);
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.3
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(String str) {
                super.success((AnonymousClass3) str);
            }
        });
    }

    public static V2TIMManagerExperimentImpl getInstance() {
        return V2TIMManagerExperimentImplHolder.v2TIMManagerExperiment;
    }

    private void getMessageExtensionsBySequence(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        long j;
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            String str2 = "";
            new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("groupID");
                j = jSONObject.optLong("messageSequence");
            } catch (JSONException e) {
                e.printStackTrace();
                j = 0;
            }
            V2TIMValueCallback<List<MessageExtension>> v2TIMValueCallback2 = new V2TIMValueCallback<List<MessageExtension>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.6
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str3) {
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<MessageExtension> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (MessageExtension messageExtension : list) {
                            V2TIMMessageExtension v2TIMMessageExtension = new V2TIMMessageExtension();
                            v2TIMMessageExtension.setMessageExtension(messageExtension);
                            arrayList.add(v2TIMMessageExtension);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            };
            Message message = new Message();
            message.setMessageStatus(2);
            message.setSupportMessageExtension(true);
            message.addElement(new TextElement());
            message.setMessageType(2);
            message.setGroupID(str2);
            message.setSeq(j);
            MessageCenter.getInstance().getMessageExtensions(message, new IMCallback<List<MessageExtension>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.7
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<MessageExtension> list) {
                    super.success((AnonymousClass7) list);
                }
            });
            return;
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void getMessageRevoker(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof List)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not list");
            return;
        }
        List<String> list = (List) obj;
        Iterator<String> it = list.iterator();
        if (it.hasNext() && !(it.next() instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "item is no String type");
        } else {
            MessageCenter.getInstance().findMessageByMessageId(list, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.11
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Message> list2) {
                    if (list2.size() == 0) {
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onError(BaseConstants.ERR_INVALID_PARAMETERS, "local messages do not exist");
                            return;
                        }
                        return;
                    }
                    if (v2TIMValueCallback != null) {
                        HashMap hashMap = new HashMap();
                        for (Message message : list2) {
                            hashMap.put(message.getMsgID(), message.getRevokerInfo().getUserID());
                        }
                        v2TIMValueCallback.onSuccess(hashMap);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.12
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Message> list2) {
                    super.success((AnonymousClass12) list2);
                }
            });
        }
    }

    private void getOfflinePushState(V2TIMValueCallback<Object> v2TIMValueCallback) {
        OfflinePushManager.getInstance().getOfflinePushConfig(new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.14
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                final int openOfflinePush = ((OfflinePushConfig) obj).getOpenOfflinePush();
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((IMCallback) AnonymousClass14.this).valueCallback != null) {
                            ((IMCallback) AnonymousClass14.this).valueCallback.onSuccess(Integer.valueOf(openOfflinePush));
                        }
                    }
                });
            }
        });
    }

    private void initLocalStorage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid userID");
        } else {
            BaseManager.getInstance().initLocalStorage(str, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.17
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void isCommercialAbilityEnabled(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Long)) {
            BaseManager.getInstance().isCommercialAbilityEnabled(((Long) obj).longValue(), new IMCallback<Object>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.15
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not int");
        }
    }

    private void pushLogin(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                BaseManager.getInstance().login(jSONObject.optString("userID"), jSONObject.optString(Constants.KEY_APP_KEY), new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.23
                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i, String str2) {
                        super.fail(i, str2);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(Object obj2) {
                        super.success(obj2);
                    }
                }, 2);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void reportOfflinePushEvent(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("eventList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        OfflinePushEventItem offlinePushEventItem = new OfflinePushEventItem();
                        offlinePushEventItem.setEventType(jSONObject.optInt("type"));
                        offlinePushEventItem.setEventTime(jSONObject.getLong(AgooConstants.MESSAGE_TIME));
                        offlinePushEventItem.setPushId(jSONObject.optString("pushId"));
                        arrayList.add(offlinePushEventItem);
                    }
                }
                OfflinePushManager.getInstance().reportOfflinePushEvent(arrayList, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.22
                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i2, String str2) {
                        super.fail(i2, str2);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(Object obj2) {
                        super.success(obj2);
                    }
                });
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void reportPushSDKEvent(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                BaseManager.getInstance().reportPushSDKEvent(jSONObject.optLong("event_id"), jSONObject.optLong("event_code"), jSONObject.optLong("event_result"), jSONObject.optString("event_message"), jSONObject.optString("more_message"), jSONObject.optString("extension_message"), new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.24
                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i, String str2) {
                        super.fail(i, str2);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(Object obj2) {
                        super.success(obj2);
                    }
                });
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void reportTUIComponentUsage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                BaseManager.getInstance().reportTUIComponentUsage(jSONObject.optLong("UIComponentType"), jSONObject.optLong("UIStyleType"));
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void sendTRTCCustomData(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof byte[])) {
            BaseManager.getInstance().sendTRTCCustomData((byte[]) obj, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.9
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not byte array");
        }
    }

    private void setApplicationID(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Integer)) {
            BaseManager.getInstance().setApplicationID(((Integer) obj).intValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setBuildInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("buildBrand");
                String optString2 = jSONObject.optString("buildManufacturer");
                String optString3 = jSONObject.optString("buildModel");
                String optString4 = jSONObject.optString("buildVersionRelease");
                int optInt = jSONObject.optInt("buildVersionSDKInt");
                SystemUtil.setBuildBrand(optString);
                SystemUtil.setBuildManufacturer(optString2);
                SystemUtil.setBuildModel(optString3);
                SystemUtil.setBuildVersionRelease(optString4);
                SystemUtil.setBuildVersionSDKInt(optInt);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setConversationGroupOrderData(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            ConversationManager.getInstance().setConversationGroupOrderData((String) obj, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.1
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
        }
    }

    private void setCosSaveRegion(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString(TUIConstants.TUIChat.CONVERSATION_ID);
                String optString2 = jSONObject.optString("cosSaveRegion");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    ConversationManager.getInstance().setCosSaveRegionForConversation(V2TIMConversationManagerImpl.getInstance().getConversationKey(optString), optString2, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.16
                        @Override // com.tencent.imsdk.common.IMCallback
                        public void fail(int i, String str2) {
                            super.fail(i, str2);
                        }

                        @Override // com.tencent.imsdk.common.IMCallback
                        public void success(Object obj2) {
                            super.success(obj2);
                        }
                    });
                    return;
                }
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid param");
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setCustomServerInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        boolean z;
        boolean z2;
        boolean z3;
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            CustomServerInfo customServerInfo = new CustomServerInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("longconnectionAddressList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        CustomServerInfo.ServerAddress serverAddress = new CustomServerInfo.ServerAddress();
                        serverAddress.ip = jSONObject2.optString("ip");
                        serverAddress.port = jSONObject2.optInt("port");
                        if (jSONObject2.has("isIPv6")) {
                            z2 = jSONObject2.optBoolean("isIPv6");
                        } else {
                            z2 = false;
                        }
                        serverAddress.isIPv6 = z2;
                        if (jSONObject2.has("isQuic")) {
                            z3 = jSONObject2.optBoolean("isQuic");
                        } else {
                            z3 = false;
                        }
                        serverAddress.isQuic = z3;
                        arrayList.add(serverAddress);
                    }
                    customServerInfo.longconnectionAddressList = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("shortconnectionAddressList");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        CustomServerInfo.ServerAddress serverAddress2 = new CustomServerInfo.ServerAddress();
                        serverAddress2.ip = jSONObject3.optString("ip");
                        serverAddress2.port = jSONObject3.optInt("port");
                        if (jSONObject3.has("isIPv6")) {
                            z = jSONObject3.optBoolean("isIPv6");
                        } else {
                            z = false;
                        }
                        serverAddress2.isIPv6 = z;
                        arrayList2.add(serverAddress2);
                    }
                    customServerInfo.shortconnectionAddressList = arrayList2;
                }
                customServerInfo.serverPublicKey = jSONObject.optString("serverPublicKey");
                BaseManager.getInstance().setCustomServerInfo(customServerInfo);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setDatabaseEncryptInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("encryptType")) {
                    callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "encryptType must be set");
                    return;
                }
                SDKConfig.DatabaseEncryptInfo databaseEncryptInfo = new SDKConfig.DatabaseEncryptInfo();
                databaseEncryptInfo.encryptType = jSONObject.optInt("encryptType");
                if (jSONObject.has("encryptKey")) {
                    databaseEncryptInfo.encryptKey = jSONObject.optString("encryptKey");
                }
                BaseManager.getInstance().setDatabaseEncryptInfo(databaseEncryptInfo);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setIPv6Prior(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setIPv6Prior(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setLibraryPath(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
            return;
        }
        if (BaseManager.getInstance().setLibraryPath((String) obj)) {
            callbackOnSuccess(v2TIMValueCallback, null);
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "system load so library failed");
        }
    }

    private void setMessageExtensionsBySequence(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            String str2 = "";
            ArrayList arrayList = new ArrayList();
            long j = 0;
            try {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("groupID");
                j = jSONObject.optLong("messageSequence");
                JSONArray optJSONArray = jSONObject.optJSONArray("messageExtensionList");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    MessageExtension messageExtension = new MessageExtension();
                    messageExtension.setExtensionKey(jSONObject2.optString("extensionKey"));
                    messageExtension.setExtensionValue(jSONObject2.optString("extensionValue"));
                    arrayList.add(messageExtension);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            V2TIMValueCallback<List<MessageExtensionResult>> v2TIMValueCallback2 = new V2TIMValueCallback<List<MessageExtensionResult>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.4
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str3) {
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(i2, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<MessageExtensionResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (MessageExtensionResult messageExtensionResult : list) {
                            V2TIMMessageExtensionResult v2TIMMessageExtensionResult = new V2TIMMessageExtensionResult();
                            v2TIMMessageExtensionResult.setMessageExtensionResult(messageExtensionResult);
                            arrayList2.add(v2TIMMessageExtensionResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList2);
                    }
                }
            };
            Message message = new Message();
            message.setMessageStatus(2);
            message.setSupportMessageExtension(true);
            message.addElement(new TextElement());
            message.setMessageType(2);
            message.setGroupID(str2);
            message.setSeq(j);
            MessageCenter.getInstance().setMessageExtensions(message, arrayList, new IMCallback<List<MessageExtensionResult>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.5
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str3) {
                    super.fail(i2, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<MessageExtensionResult> list) {
                    super.success((AnonymousClass5) list);
                }
            });
            return;
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setOfflinePushInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("notification_bar_state");
                String optString = jSONObject.optString("tim_push_plugin_version");
                if (optInt < 0 || optInt > 2) {
                    optInt = 0;
                }
                OfflinePushManager.getInstance().setOfflinePushInfo(optString, optInt);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setOfflinePushState(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Integer)) {
            OfflinePushConfig offlinePushConfig = new OfflinePushConfig();
            offlinePushConfig.setOpenOfflinePush(((Integer) obj).intValue());
            OfflinePushManager.getInstance().setOfflinePushConfig(offlinePushConfig, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.13
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
            return;
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not int");
    }

    private void setPacketRetryInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                SDKConfig.PacketRetryInfo packetRetryInfo = new SDKConfig.PacketRetryInfo();
                if (jSONObject.has("maxRetryCount")) {
                    packetRetryInfo.maxRetryCount = jSONObject.optInt("maxRetryCount");
                }
                if (jSONObject.has("packetRequestTimeout")) {
                    packetRetryInfo.packetRequestTimeout = jSONObject.optInt("packetRequestTimeout");
                }
                BaseManager.getInstance().setPacketRetryInfo(packetRetryInfo);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setProxyInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("proxyType")) {
                    callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "proxyType must be set");
                    return;
                }
                if ((jSONObject.has("proxyHost") && !jSONObject.has("proxyPort")) || (!jSONObject.has("proxyHost") && jSONObject.has("proxyPort"))) {
                    callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "proxyHost and proxyPort must be set together if need");
                    return;
                }
                SDKConfig.ProxyInfo proxyInfo = new SDKConfig.ProxyInfo();
                proxyInfo.proxyType = jSONObject.optInt("proxyType");
                if (jSONObject.has("proxyHost") && jSONObject.has("proxyPort")) {
                    proxyInfo.proxyHost = jSONObject.optString("proxyHost");
                    proxyInfo.proxyPort = jSONObject.optInt("proxyPort");
                }
                if (jSONObject.has("proxyUsername")) {
                    proxyInfo.proxyUsername = jSONObject.optString("proxyUsername");
                }
                if (jSONObject.has("proxyPassword")) {
                    proxyInfo.proxyPassword = jSONObject.optString("proxyPassword");
                }
                BaseManager.getInstance().setProxyInfo(proxyInfo);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setQuicChannelEnabled(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                BaseManager.getInstance().setQuicEnabled(new JSONObject(str).optBoolean("enableQuic"));
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    private void setTestEnvironment(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setTestEnvironment(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setUIPlatform(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        String str;
        if (obj == null) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is null");
            return;
        }
        int i = 0;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            if (obj instanceof Integer) {
                i = ((Integer) obj).intValue();
            } else {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is invalid");
            }
            str = "";
        }
        BaseManager.getInstance().setCustomUIPlatform(str, i);
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void writeLog(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("logLevel");
                String optString = jSONObject.optString("logContent");
                String optString2 = jSONObject.optString("fileName");
                if (optInt != 2) {
                    if (optInt != 3) {
                        if (optInt != 4) {
                            if (optInt != 5) {
                                if (optInt != 6) {
                                    callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid logLevel");
                                    return;
                                }
                                IMLog.e(optString2, optString);
                            } else {
                                IMLog.w(optString2, optString);
                            }
                        } else {
                            IMLog.i(optString2, optString);
                        }
                    } else {
                        IMLog.d(optString2, optString);
                    }
                } else {
                    IMLog.v(optString2, optString);
                }
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e) {
                callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "convert param to json failed");
                e.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "param is not string");
    }

    public void callExperimentalAPI(String str, Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "invalid api");
            return;
        }
        if (str.equals("setCustomServerInfo")) {
            setCustomServerInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("enableQuicChannel")) {
            setQuicChannelEnabled(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setProxyInfo")) {
            setProxyInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setLibraryPath")) {
            setLibraryPath(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("initLocalStorage")) {
            initLocalStorage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setTestEnvironment")) {
            setTestEnvironment(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setIPv6Prior")) {
            setIPv6Prior(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setCosSaveRegionForConversation")) {
            setCosSaveRegion(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setUIPlatform")) {
            setUIPlatform(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setBuildInfo")) {
            setBuildInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setDatabaseEncryptInfo")) {
            setDatabaseEncryptInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("isCommercialAbilityEnabled")) {
            isCommercialAbilityEnabled(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setPacketRetryInfo")) {
            setPacketRetryInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setOfflinePushState")) {
            setOfflinePushState(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getOfflinePushState")) {
            getOfflinePushState(v2TIMValueCallback);
            return;
        }
        if (str.equals("getMessageRevoker")) {
            getMessageRevoker(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("writeLog")) {
            writeLog(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getAIDenoiseSignature")) {
            getAIDenoiseSignature(v2TIMValueCallback);
            return;
        }
        if (str.equals("sendTRTCCustomData")) {
            sendTRTCCustomData(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setMessageExtensionsBySequence")) {
            setMessageExtensionsBySequence(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getMessageExtensionsBySequence")) {
            getMessageExtensionsBySequence(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("clearLocalHistoryMessage")) {
            clearLocalHistoryMessage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("reportTUIComponentUsage")) {
            reportTUIComponentUsage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setConversationGroupOrderData")) {
            setConversationGroupOrderData(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getConversationGroupOrderData")) {
            getConversationGroupOrderData(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("reportOfflinePushEvent")) {
            reportOfflinePushEvent(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setOfflinePushInfo")) {
            setOfflinePushInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setApplicationID")) {
            setApplicationID(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("findMergerMessages")) {
            findMergerMessages(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getBriefGroupMemberList")) {
            getBriefGroupMemberList(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("pushLogin")) {
            pushLogin(obj, v2TIMValueCallback);
        } else if (str.equals("reportPushSDKEvent")) {
            reportPushSDKEvent(obj, v2TIMValueCallback);
        } else {
            callbackOnError(v2TIMValueCallback, BaseConstants.ERR_INVALID_PARAMETERS, "unsupported api");
        }
    }
}
