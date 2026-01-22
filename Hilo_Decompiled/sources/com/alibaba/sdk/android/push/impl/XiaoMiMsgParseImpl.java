package com.alibaba.sdk.android.push.impl;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class XiaoMiMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    private static final String TAG = "MPS:MiPushRegister";

    public String getMsgSource() {
        return "xiaomi";
    }

    public String parseMsgFromIntent(Intent intent) {
        String str;
        try {
            str = intent.getSerializableExtra("key_message").getContent();
        } catch (Exception unused) {
            str = null;
        }
        ALog.i(TAG, "parseMsgFromIntent msg:" + str, new Object[0]);
        return str;
    }

    public String toString() {
        return "INotifyListener: " + getMsgSource();
    }
}
