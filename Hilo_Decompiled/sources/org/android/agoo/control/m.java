package org.android.agoo.control;

import android.content.Context;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ boolean e;
    final /* synthetic */ NotifManager f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NotifManager notifManager, String str, String str2, String str3, String str4, boolean z) {
        this.f = notifManager;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        String sendPushResponse;
        Context context9;
        try {
            HashMap hashMap = new HashMap();
            String str = this.a;
            if (str != null) {
                hashMap.put("sdkVer", str);
            }
            hashMap.put("thirdTokenType", this.b);
            hashMap.put("token", this.c);
            context2 = NotifManager.mContext;
            hashMap.put(Constants.SP_KEY_APPKEY, Config.b(context2));
            context3 = NotifManager.mContext;
            hashMap.put("utdid", AdapterUtilityImpl.getDeviceId(context3));
            String str2 = this.d;
            if (str2 != null) {
                hashMap.put("vendorSdkVersion", str2);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("report,utdid=");
            context4 = NotifManager.mContext;
            sb2.append(AdapterUtilityImpl.getDeviceId(context4));
            sb2.append(",regId=");
            sb2.append(this.c);
            sb2.append(",type=");
            sb2.append(this.b);
            sb2.append(" sdkVer=");
            sb2.append(this.a);
            sb2.append(" thirdVer=");
            sb2.append(this.d);
            ALog.d("NotifManager", sb2.toString(), new Object[0]);
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, "agooTokenReport", new JSONObject(hashMap).toString().getBytes("UTF-8"), null, null, null, null);
            context5 = NotifManager.mContext;
            context6 = NotifManager.mContext;
            String b = Config.b(context6);
            context7 = NotifManager.mContext;
            IACCSManager accsInstance = ACCSManager.getAccsInstance(context5, b, Config.d(context7));
            if (this.e) {
                context9 = NotifManager.mContext;
                sendPushResponse = accsInstance.sendData(context9, accsRequest);
            } else {
                context8 = NotifManager.mContext;
                sendPushResponse = accsInstance.sendPushResponse(context8, accsRequest, new TaoBaseService.ExtraInfo());
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.i("NotifManager", "reportThirdPushToken,dataId=" + sendPushResponse + ",regId=" + this.c + ",type=" + this.b, new Object[0]);
            }
        } catch (Throwable th) {
            UTMini uTMini = UTMini.getInstance();
            context = NotifManager.mContext;
            uTMini.commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", AdapterUtilityImpl.getDeviceId(context), th.toString());
            if (ALog.isPrintLog(ALog.Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
