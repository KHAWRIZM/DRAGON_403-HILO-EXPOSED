package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class c implements Runnable {
    final /* synthetic */ AgooFactory a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AgooFactory agooFactory) {
        this.a = agooFactory;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageService messageService;
        NotifManager notifManager;
        messageService = this.a.messageService;
        ArrayList<MsgDO> a = messageService.a();
        if (a != null && a.size() > 0) {
            ALog.e("AgooFactory", "reportCacheMsg", "size", Integer.valueOf(a.size()));
            Iterator<MsgDO> it = a.iterator();
            while (it.hasNext()) {
                MsgDO next = it.next();
                if (next != null) {
                    next.isFromCache = true;
                    notifManager = this.a.notifyManager;
                    notifManager.report(next, null);
                }
            }
        }
    }
}
