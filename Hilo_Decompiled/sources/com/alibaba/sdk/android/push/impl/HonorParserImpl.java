package com.alibaba.sdk.android.push.impl;

import android.content.Intent;
import com.facebook.bolts.AppLinks;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class HonorParserImpl implements BaseNotifyClickActivity.INotifyListener {
    private static final String TAG = "MPS:HonorParserImpl";

    public String getMsgSource() {
        return "honor";
    }

    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            ALog.e(TAG, "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            return intent.getStringExtra(AppLinks.KEY_NAME_EXTRAS);
        } catch (Throwable th) {
            ALog.e(TAG, "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
