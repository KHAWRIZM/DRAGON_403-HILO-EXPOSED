package com.tencent.qcloud.tuikit.tuichat.bean;

import android.text.TextUtils;
import com.google.gson.d;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.taobao.accs.common.Constants;
import com.taobao.agoo.a.a.b;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import p8.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CallModel implements Cloneable, Serializable {
    public static String SIGNALING_EXTRA_KEY_BUSINESS_ID = "businessID";
    public static String SIGNALING_EXTRA_KEY_CALL_END = "call_end";
    public static String SIGNALING_EXTRA_KEY_CALL_TYPE = "call_type";
    public static String SIGNALING_EXTRA_KEY_LINE_BUSY = "line_busy";
    public static String SIGNALING_EXTRA_KEY_ROOM_ID = "room_id";
    public static String SIGNALING_EXTRA_KEY_VERSION = "version";
    public static String SIGNALING_EXTRA_VALUE_BUSINESS_ID = "av_call";
    private static final String TAG = "CallModel";
    public static final int VIDEO_CALL_ACTION_ACCEPT = 7;
    public static final int VIDEO_CALL_ACTION_DIALING = 1;
    public static final int VIDEO_CALL_ACTION_ERROR = -1;
    public static final int VIDEO_CALL_ACTION_HANGUP = 5;
    public static final int VIDEO_CALL_ACTION_LINE_BUSY = 6;
    public static final int VIDEO_CALL_ACTION_REJECT = 3;
    public static final int VIDEO_CALL_ACTION_SPONSOR_CANCEL = 2;
    public static final int VIDEO_CALL_ACTION_SPONSOR_TIMEOUT = 4;
    public static final int VIDEO_CALL_ACTION_SWITCH_TO_AUDIO = 8;
    public static final int VIDEO_CALL_ACTION_SWITCH_TO_AUDIO_ACCEPT = 9;
    public static final int VIDEO_CALL_ACTION_UNKNOWN = 0;
    public static final int VIDEO_CALL_ACTION_UNKNOWN_INVITE = 10;

    @c(TUIConstants.Message.CUSTOM_BUSINESS_ID_KEY)
    public String bussinessID;

    @c("call_id")
    public String callId;
    public String data;

    @c("invited_list")
    public List<String> invitedList;
    public String sender;
    public int timeout;
    public long timestamp;

    @c(Constants.SP_KEY_VERSION)
    public int version = 0;

    @c(GameMatchActivity.ROOM_ID)
    public int roomId = 0;

    @c("group_id")
    public String groupId = "";

    @c("action")
    public int action = 0;

    @c(TUIConstants.Message.CALLING_TYPE_KEY)
    public int callType = 0;

    @c("duration")
    public int duration = 0;

    @c(Constants.KEY_HTTP_CODE)
    public int code = 0;

    public static CallModel convert2VideoCallData(V2TIMMessage v2TIMMessage) {
        Map map;
        V2TIMSignalingInfo signalingInfo = V2TIMManager.getSignalingManager().getSignalingInfo(v2TIMMessage);
        if (signalingInfo == null) {
            return null;
        }
        d dVar = new d();
        CallModel callModel = new CallModel();
        try {
            map = (Map) dVar.j(signalingInfo.getData(), Map.class);
        } catch (Exception e) {
            TUIChatLog.e(TAG, "convert2VideoCallData exception:" + e);
        }
        if (map != null && map.containsKey(SIGNALING_EXTRA_KEY_VERSION) && ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue() > TUIChatConstants.version) {
            callModel.action = 0;
            return callModel;
        }
        callModel.data = signalingInfo.getData();
        if (map != null) {
            callModel.callType = ((Double) map.get(TUIConstants.Message.CALLING_TYPE_KEY)).intValue();
            callModel.bussinessID = (String) map.get(SIGNALING_EXTRA_KEY_BUSINESS_ID);
        }
        if (signalingInfo.getActionType() == 1 && map != null) {
            handleInvite(v2TIMMessage, signalingInfo, dVar, callModel, map);
        } else if (signalingInfo.getActionType() == 2) {
            callModel.action = 2;
            callModel.groupId = signalingInfo.getGroupID();
            callModel.callId = signalingInfo.getInviteID();
            callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
        } else if (signalingInfo.getActionType() == 4 && map != null) {
            callModel.groupId = signalingInfo.getGroupID();
            callModel.callId = signalingInfo.getInviteID();
            callModel.invitedList = signalingInfo.getInviteeList();
            callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
            if (map.containsKey(SIGNALING_EXTRA_KEY_LINE_BUSY)) {
                callModel.action = 6;
            } else {
                callModel.action = 3;
            }
        } else if (signalingInfo.getActionType() == 5) {
            callModel.action = 4;
            callModel.groupId = signalingInfo.getGroupID();
            callModel.callId = signalingInfo.getInviteID();
            callModel.invitedList = signalingInfo.getInviteeList();
        } else if (signalingInfo.getActionType() == 3) {
            handleAccept(signalingInfo, callModel, map);
        }
        return callModel;
    }

    private static void handleAccept(V2TIMSignalingInfo v2TIMSignalingInfo, CallModel callModel, Map map) {
        callModel.groupId = v2TIMSignalingInfo.getGroupID();
        callModel.callId = v2TIMSignalingInfo.getInviteID();
        callModel.invitedList = v2TIMSignalingInfo.getInviteeList();
        callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
        callModel.callType = ((Double) map.get(TUIConstants.Message.CALLING_TYPE_KEY)).intValue();
        Map map2 = (Map) map.get("data");
        if (map2 != null) {
            if (!map2.containsKey(b.JSON_CMD)) {
                callModel.action = 10;
                return;
            } else if (TextUtils.equals((String) map2.get(b.JSON_CMD), "switchToAudio")) {
                callModel.action = 9;
                callModel.callType = 2;
                return;
            } else {
                callModel.action = 7;
                return;
            }
        }
        callModel.action = 7;
    }

    private static void handleInvite(V2TIMMessage v2TIMMessage, V2TIMSignalingInfo v2TIMSignalingInfo, d dVar, CallModel callModel, Map map) {
        callModel.groupId = v2TIMSignalingInfo.getGroupID();
        callModel.timestamp = v2TIMMessage.getTimestamp();
        callModel.version = ((Double) map.get(SIGNALING_EXTRA_KEY_VERSION)).intValue();
        Map map2 = (Map) map.get("data");
        int i = 1;
        if (map2 != null) {
            if (!map2.containsKey(b.JSON_CMD)) {
                callModel.action = 10;
                return;
            }
            String str = (String) map2.get(b.JSON_CMD);
            if (TextUtils.equals(str, "switchToAudio")) {
                callModel.action = 8;
                return;
            }
            if (TextUtils.equals(str, "hangup")) {
                callModel.action = 5;
                callModel.duration = Double.valueOf(String.valueOf(map.get(SIGNALING_EXTRA_KEY_CALL_END))).intValue();
                return;
            }
            if (!TextUtils.equals(str, "videoCall") && !TextUtils.equals(str, "audioCall")) {
                callModel.action = 10;
                return;
            }
            callModel.action = 1;
            callModel.callId = v2TIMSignalingInfo.getInviteID();
            callModel.sender = v2TIMSignalingInfo.getInviter();
            callModel.invitedList = v2TIMSignalingInfo.getInviteeList();
            if (!TextUtils.equals(str, "audioCall")) {
                i = 2;
            }
            callModel.callType = i;
            callModel.roomId = ((Double) map.get(SIGNALING_EXTRA_KEY_ROOM_ID)).intValue();
            return;
        }
        if (map.containsKey(SIGNALING_EXTRA_KEY_CALL_END)) {
            callModel.action = 5;
            callModel.duration = Double.valueOf(String.valueOf(map.get(SIGNALING_EXTRA_KEY_CALL_END))).intValue();
            return;
        }
        callModel.action = 1;
        callModel.callId = v2TIMSignalingInfo.getInviteID();
        callModel.sender = v2TIMSignalingInfo.getInviter();
        callModel.invitedList = v2TIMSignalingInfo.getInviteeList();
        callModel.callType = ((Double) map.get(SIGNALING_EXTRA_KEY_CALL_TYPE)).intValue();
        callModel.roomId = ((Double) map.get(SIGNALING_EXTRA_KEY_ROOM_ID)).intValue();
    }
}
