package org.android.agoo.control;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class a implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ String b;
    final /* synthetic */ AgooFactory c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AgooFactory agooFactory, byte[] bArr, String str) {
        this.c = agooFactory;
        this.a = bArr;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        MessageService messageService;
        MessageService messageService2;
        Context context2;
        try {
            String str = new String(this.a, "utf-8");
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 1) {
                String str2 = null;
                String str3 = null;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        str2 = jSONObject.getString("i");
                        str3 = jSONObject.getString("p");
                    }
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("saveMsg msgId:");
                    sb2.append(str2);
                    sb2.append(",message=");
                    sb2.append(str);
                    sb2.append(",currentPack=");
                    sb2.append(str3);
                    sb2.append(",reportTimes=");
                    context2 = AgooFactory.sContext;
                    sb2.append(Config.g(context2));
                    ALog.i("AgooFactory", sb2.toString(), new Object[0]);
                }
                if (!TextUtils.isEmpty(str3)) {
                    context = AgooFactory.sContext;
                    if (TextUtils.equals(str3, context.getPackageName())) {
                        if (TextUtils.isEmpty(this.b)) {
                            messageService2 = this.c.messageService;
                            messageService2.a(str2, str, MessageService.MSG_DB_READY_REPORT);
                        } else {
                            messageService = this.c.messageService;
                            messageService.a(str2, str, this.b);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ALog.e("AgooFactory", "saveMsg fail:" + th.toString(), new Object[0]);
        }
    }
}
