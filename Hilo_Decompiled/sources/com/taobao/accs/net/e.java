package com.taobao.accs.net;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!UtilityImpl.l(this.a)) {
            return;
        }
        ALog.d(this.b.d(), "startChannelService", new Object[0]);
        Intent intent = new Intent(Constants.ACTION_START_SERVICE);
        intent.putExtra(Constants.KEY_APP_KEY, this.b.i());
        intent.putExtra(Constants.KEY_TTID, this.b.a);
        intent.putExtra(Constants.KEY_PACKAGE_NAME, this.a.getPackageName());
        intent.putExtra("app_sercet", this.b.i.getAppSecret());
        intent.putExtra(Constants.KEY_MODE, AccsClientConfig.mEnv);
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.b.m);
        String packageName = this.a.getPackageName();
        String str = AdapterUtilityImpl.channelService;
        intent.setClassName(packageName, str);
        IntentDispatch.dispatchIntent(this.a, intent, str);
        Intent intent2 = new Intent();
        intent2.setAction("org.agoo.android.intent.action.REPORT");
        intent2.setPackage(this.a.getPackageName());
        String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(this.a);
        if (TextUtils.isEmpty(agooCustomServiceName)) {
            return;
        }
        intent2.setClassName(this.a.getPackageName(), agooCustomServiceName);
        IntentDispatch.dispatchIntent(this.a, intent2, agooCustomServiceName);
    }
}
