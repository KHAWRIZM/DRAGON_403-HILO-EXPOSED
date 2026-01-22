package com.alibaba.sdk.android.push.g;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h extends com.alibaba.sdk.android.push.common.util.a.c {

    /* renamed from: c, reason: collision with root package name */
    private static final AmsLogger f٦٧٤١c = AmsLogger.getLogger("MPS:VipRequestTask");

    /* renamed from: d, reason: collision with root package name */
    private final CommonCallback f٦٧٤٢d;

    public h(Context context, String str, CommonCallback commonCallback) {
        super(context, str);
        this.f٦٧٤٢d = commonCallback;
    }

    @Override // com.alibaba.sdk.android.push.common.util.a.c
    protected Map<String, String> a(Context context, Map<String, String> map) {
        return com.alibaba.sdk.android.ams.common.util.c.a(map);
    }

    private void a(int i10, com.alibaba.sdk.android.push.common.util.a.b bVar, CommonCallback commonCallback) {
        ErrorCode build;
        String code;
        if (commonCallback == null) {
            return;
        }
        f٦٧٤١c.d("requestType: " + i10 + ", errorCode:" + bVar.f٦٦١٨c + ", httpcode: " + bVar.f٦٦١٧b + ", content:" + bVar.f٦٦١٦a);
        if (!bVar.f٦٦١٨c.getCode().equals(com.alibaba.sdk.android.push.common.a.d.f٦٥٨٩a.getCode())) {
            commonCallback.onFailed(bVar.f٦٦١٨c.getCode(), bVar.f٦٦١٨c.getMsg());
            return;
        }
        try {
            commonCallback.onSuccess(i.a(i10, bVar.f٦٦١٧b, bVar.f٦٦١٦a));
        } catch (com.alibaba.sdk.android.push.b.f e10) {
            f٦٧٤١c.e("Vip call failed", e10);
            code = e10.a().getCode();
            build = e10.a();
            commonCallback.onFailed(code, build.getMsg());
        } catch (Throwable th) {
            f٦٧٤١c.e("Vip call failed.", th);
            build = com.alibaba.sdk.android.push.common.a.d.f٦٥٩٩k.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build();
            code = build.getCode();
            commonCallback.onFailed(code, build.getMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.push.common.util.a.c, android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.alibaba.sdk.android.push.common.util.a.b bVar) {
        super.onPostExecute(bVar);
        a(a(), bVar, this.f٦٧٤٢d);
    }
}
