package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.AccsState;
import com.taobao.accs.net.j;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class s implements RequestCb {
    final /* synthetic */ IAuth.AuthCallback a;
    final /* synthetic */ j.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(j.a aVar, IAuth.AuthCallback authCallback) {
        this.b = aVar;
        this.a = authCallback;
    }

    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    public void onFinish(int i, String str, RequestStatistic requestStatistic) {
        ILog iLog;
        if (i < 0) {
            iLog = this.b.e;
            iLog.e(new Object[]{"auth onFinish", "statusCode", Integer.valueOf(i)});
            this.a.onAuthFail(i, "onFinish auth fail");
        }
    }

    public void onResponseCode(int i, Map<String, List<String>> map) {
        ILog iLog;
        ILog iLog2;
        ILog iLog3;
        b bVar;
        b bVar2;
        b bVar3;
        Map<String, String> a = UtilityImpl.a(map);
        iLog = this.b.e;
        iLog.d(new Object[]{BaseMonitor.ALARM_POINT_AUTH, "header", a});
        String str = a.get("x-at");
        if (!TextUtils.isEmpty(str)) {
            bVar3 = this.b.d;
            bVar3.k = str;
        }
        if (i == 200) {
            iLog3 = this.b.e;
            iLog3.i(new Object[]{BaseMonitor.ALARM_POINT_AUTH, "httpStatusCode", Integer.valueOf(i)});
            this.a.onAuthSuccess();
            bVar = this.b.d;
            if (bVar instanceof j) {
                bVar2 = this.b.d;
                ((j) bVar2).q();
                return;
            }
            return;
        }
        String str2 = a.get("s-accs-retcode");
        iLog2 = this.b.e;
        iLog2.e(new Object[]{BaseMonitor.ALARM_POINT_AUTH, "httpStatusCode", Integer.valueOf(i)});
        AccsState.getInstance().b(AccsState.RECENT_ERRORS, "auth fail " + str2);
        this.a.onAuthFail(i, "auth fail");
    }
}
