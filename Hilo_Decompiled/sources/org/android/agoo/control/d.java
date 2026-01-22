package org.android.agoo.control;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class d implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ boolean b;
    final /* synthetic */ AgooFactory c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AgooFactory agooFactory, byte[] bArr, boolean z) {
        this.c = agooFactory;
        this.a = bArr;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        MessageService messageService;
        MessageService messageService2;
        Context context;
        try {
            String str2 = new String(this.a, "utf-8");
            if (TextUtils.isEmpty(str2)) {
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", 0.0d);
                return;
            }
            ALog.i("AgooFactory", "message = " + str2, new Object[0]);
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("api");
            String string2 = jSONObject.getString(AgooConstants.MESSAGE_ID);
            if (TextUtils.equals(string, "agooReport")) {
                str = jSONObject.getString("status");
            } else {
                str = null;
            }
            if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", 0.0d);
            }
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(str)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("updateMsg data begin,api=");
                    sb2.append(string);
                    sb2.append(",id=");
                    sb2.append(string2);
                    sb2.append(",status=");
                    sb2.append(str);
                    sb2.append(",reportTimes=");
                    context = AgooFactory.sContext;
                    sb2.append(Config.g(context));
                    ALog.i("AgooFactory", sb2.toString(), new Object[0]);
                }
                if (TextUtils.equals(string, "agooReport")) {
                    if (TextUtils.equals(str, MessageService.MSG_ACCS_READY_REPORT) && this.b) {
                        messageService2 = this.c.messageService;
                        messageService2.a(string2, MessageService.MSG_DB_NOTIFY_REACHED);
                    } else if ((TextUtils.equals(str, MessageService.MSG_ACCS_NOTIFY_CLICK) || TextUtils.equals(str, MessageService.MSG_ACCS_NOTIFY_DISMISS)) && this.b) {
                        messageService = this.c.messageService;
                        messageService.a(string2, MessageService.MSG_DB_COMPLETE);
                    }
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, str, 0.0d);
                    return;
                }
                return;
            }
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", 0.0d);
        } catch (Throwable th) {
            ALog.e("AgooFactory", "updateMsg get data error,e=" + th, new Object[0]);
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", 0.0d);
        }
    }
}
