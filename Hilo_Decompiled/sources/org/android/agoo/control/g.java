package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ AgooFactory c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AgooFactory agooFactory, String str, String str2) {
        this.c = agooFactory;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        NotifManager notifManager;
        NotifManager notifManager2;
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i("AgooFactory", "dismissMessage", "msgid", this.a, AgooConstants.MESSAGE_EXT, this.b);
            }
            if (TextUtils.isEmpty(this.a)) {
                ALog.d("AgooFactory", "messageId == null", new Object[0]);
                return;
            }
            MsgDO msgDO2 = new MsgDO();
            try {
                String str = this.a;
                msgDO2.msgIds = str;
                msgDO2.extData = this.b;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = MessageService.MSG_ACCS_NOTIFY_DISMISS;
                this.c.updateMsgStatus(str, MessageService.MSG_ACCS_NOTIFY_DISMISS);
                notifManager2 = this.c.notifyManager;
                notifManager2.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e("AgooFactory", "clickMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        notifManager = this.c.notifyManager;
                        notifManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
