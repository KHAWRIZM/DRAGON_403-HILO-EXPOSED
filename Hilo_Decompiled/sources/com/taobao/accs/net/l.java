package com.taobao.accs.net;

import android.content.Context;
import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class l implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ILog iLog;
        long j;
        iLog = this.a.t;
        iLog.i("sendAccsHeartbeatMessage");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dataType", "pingreq");
            j = this.a.o;
            jSONObject.put("timeInterval", j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, jSONObject.toString().getBytes(), UUID.randomUUID().toString());
        accsRequest.setTarget("accs-iot");
        accsRequest.setTargetServiceName("sal");
        j jVar = this.a;
        Context context = jVar.d;
        String packageName = context.getPackageName();
        this.a.i.getAppKey();
        this.a.a(Message.a(jVar, context, packageName, Constants.TARGET_SERVICE, accsRequest, true), true);
    }
}
