package com.alibaba.sdk.android.push.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.sdk.android.push.notification.PushData;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VivoMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    public static final String TAG = "MPS:VivoMsgParseImpl";
    private Context context;

    private String fixVivoMsg(String str, Intent intent) {
        Context context;
        ALog.i(TAG, "fixVivoMsg intent:" + printBundle(intent.getExtras(), 1), new Object[0]);
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    if (!jSONObject.has("p") && (context = this.context) != null) {
                        jSONObject.put("p", context.getPackageName());
                    }
                    if (!jSONObject.has(PushData.KEY_EXT)) {
                        jSONObject.put(PushData.KEY_EXT, intent.getStringExtra(PushData.KEY_EXT));
                    }
                    if (!jSONObject.has("b")) {
                        jSONObject.put("b", intent.getStringExtra("b"));
                    }
                    if (!jSONObject.has("f")) {
                        jSONObject.put("f", intent.getLongExtra("f", 0L));
                    }
                    if (!jSONObject.has("i")) {
                        jSONObject.put("i", intent.getStringExtra("i"));
                    }
                    jSONArray.put(i10, jSONObject);
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
            return jSONArray.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    private static String printBundle(Bundle bundle, int i10) {
        StringBuilder sb = new StringBuilder();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                for (int i11 = 0; i11 < i10; i11++) {
                    sb.append('\t');
                }
                if (obj instanceof String) {
                    sb.append("String\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Integer) {
                    sb.append("int\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Long) {
                    sb.append("long\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Boolean) {
                    sb.append("boolean\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                } else if (obj instanceof Bundle) {
                    sb.append("Bundle\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append('\n');
                    sb.append(printBundle((Bundle) obj, i10 + 1));
                } else {
                    sb.append("unknown\t");
                    sb.append(str);
                    sb.append('\t');
                    sb.append(obj);
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public String getMsgSource() {
        return "vivo";
    }

    public String parseMsgFromIntent(Intent intent) {
        String str = null;
        if (intent == null) {
            ALog.e(TAG, "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("vivo_payload");
            ALog.i(TAG, "parseMsgFromIntent msg:" + stringExtra, new Object[0]);
            str = fixVivoMsg(stringExtra, intent);
            ALog.i(TAG, "after fixup msg:" + str, new Object[0]);
            return str;
        } catch (Throwable th) {
            ALog.e(TAG, "parseMsgFromIntent ", th, new Object[0]);
            return str;
        }
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }
}
