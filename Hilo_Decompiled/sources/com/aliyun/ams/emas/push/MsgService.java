package com.aliyun.ams.emas.push;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.data.MsgDistributeService;
import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MsgService extends MsgDistributeService {

    /* renamed from: b, reason: collision with root package name */
    b4.f f٦٨٧٤b = new b4.f();

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            ALog.d("MPS:MsgService", "intent null", new Object[0]);
            return super.onStartCommand(intent, i10, i11);
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return super.onStartCommand(intent, i10, i11);
        }
        ALog.d("MPS:MsgService", "MsgService onStartCommand begin...action=" + action, new Object[0]);
        if (TextUtils.equals(action, l.f٦٨٩٩b)) {
            this.f٦٨٧٤b.a(intent, getApplicationContext());
            return 2;
        }
        return super.onStartCommand(intent, i10, i11);
    }
}
