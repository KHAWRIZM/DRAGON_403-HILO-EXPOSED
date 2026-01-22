package com.alibaba.sdk.android.push.popup;

import android.content.Intent;
import com.alibaba.sdk.android.push.notification.PushData;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.agoo.BaseNotifyClick;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PopupNotifyClick extends BaseNotifyClick {
    static final String TAG = "PopupNotifyClick";
    private final PopupNotifyClickListener mPopupNotifyClickListener;

    public PopupNotifyClick(PopupNotifyClickListener popupNotifyClickListener) {
        this.mPopupNotifyClickListener = popupNotifyClickListener;
    }

    public void onMessage(Intent intent) {
        if (intent == null) {
            ALog.e(TAG, "intent null, return", new Object[0]);
            return;
        }
        String stringExtra = intent.getStringExtra("body");
        if (stringExtra != null) {
            ALog.i(TAG, "Receive notification, body: " + stringExtra, new Object[0]);
            try {
                Map map = JsonUtility.toMap(new JSONObject(stringExtra));
                String str = (String) map.get("title");
                String str2 = (String) map.get("content");
                String str3 = (String) map.get(PushData.KEY_MSG_ID);
                int parseInt = Integer.parseInt((String) map.get("type"));
                if (1 == parseInt) {
                    Map<String, String> map2 = JsonUtility.toMap(new JSONObject((String) map.get(PushData.KEY_EXT)));
                    map2.put("_ALIYUN_NOTIFICATION_MSG_ID_", str3);
                    PopupNotifyClickListener popupNotifyClickListener = this.mPopupNotifyClickListener;
                    if (popupNotifyClickListener != null) {
                        popupNotifyClickListener.onSysNoticeOpened(str, str2, map2);
                    } else {
                        ALog.e(TAG, "PopupNotifyClickListener is null", new Object[0]);
                    }
                } else if (2 == parseInt) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_ALIYUN_NOTIFICATION_MSG_ID_", str3);
                    PopupNotifyClickListener popupNotifyClickListener2 = this.mPopupNotifyClickListener;
                    if (popupNotifyClickListener2 != null) {
                        popupNotifyClickListener2.onSysNoticeOpened(str, str2, hashMap);
                    } else {
                        ALog.e(TAG, "PopupNotifyClickListener is null", new Object[0]);
                    }
                }
            } catch (JSONException e10) {
                ALog.e(TAG, "Parse json error, " + e10, new Object[0]);
            }
        }
    }

    public void onNotPushData(Intent intent) {
        PopupNotifyClickListener popupNotifyClickListener = this.mPopupNotifyClickListener;
        if (popupNotifyClickListener instanceof OnPushParseFailedListener) {
            ((OnPushParseFailedListener) popupNotifyClickListener).onNotPushData(intent);
        }
    }

    public void onParseFailed(Intent intent) {
        PopupNotifyClickListener popupNotifyClickListener = this.mPopupNotifyClickListener;
        if (popupNotifyClickListener instanceof OnPushParseFailedListener) {
            ((OnPushParseFailedListener) popupNotifyClickListener).onParseFailed(intent);
        }
    }
}
