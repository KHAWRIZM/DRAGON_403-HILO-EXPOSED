package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.Config;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c extends IAgooAppReceiver {
    final /* synthetic */ IRegister a;
    final /* synthetic */ Context b;
    final /* synthetic */ IACCSManager c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IRegister iRegister, Context context, IACCSManager iACCSManager, String str, String str2) {
        this.a = iRegister;
        this.b = context;
        this.c = iACCSManager;
        this.d = str;
        this.e = str2;
    }

    @Override // com.taobao.accs.IAgooAppReceiver
    public String getAppkey() {
        return this.d;
    }

    @Override // com.taobao.accs.IAppReceiverV2
    public void onBindApp(int i, String str, String str2) {
        if (i == AccsErrorCode.SUCCESS.getCodeInt()) {
            onBindApp(i, str2);
        } else if (this.a != null) {
            ErrorCode build = a.a(i, str).detail("bindApp").build();
            this.a.onFailure(build.getCode(), build.getMsg());
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2, com.taobao.accs.IAppReceiverV1
    public void onBindApp(int i, String str) {
        com.taobao.agoo.a.b bVar;
        com.taobao.agoo.a.b bVar2;
        com.taobao.agoo.a.b bVar3;
        try {
            ALog.i("TaobaoRegister", "onBindApp", Constants.KEY_ERROR_CODE, Integer.valueOf(i));
            if (i == AccsErrorCode.SUCCESS.getCodeInt()) {
                bVar = TaobaoRegister.mRequestListener;
                if (bVar == null) {
                    com.taobao.agoo.a.b unused = TaobaoRegister.mRequestListener = new com.taobao.agoo.a.b(this.b);
                }
                IACCSManager iACCSManager = this.c;
                Context context = this.b;
                bVar2 = TaobaoRegister.mRequestListener;
                iACCSManager.registerDataListener(context, "AgooDeviceCmd", bVar2);
                if (com.taobao.agoo.a.b.b.b(this.b.getPackageName()) && Config.getDeviceToken(this.b) != null) {
                    ALog.i("TaobaoRegister", "agoo aready Registered return ", new Object[0]);
                    IRegister iRegister = this.a;
                    if (iRegister != null) {
                        iRegister.onSuccess(Config.getDeviceToken(this.b));
                        return;
                    }
                    return;
                }
                byte[] a = com.taobao.agoo.a.a.c.a(this.b, this.d, this.e);
                if (a == null) {
                    IRegister iRegister2 = this.a;
                    if (iRegister2 != null) {
                        ErrorCode errorCode = a.REGISTER_DATA_ERROR;
                        iRegister2.onFailure(errorCode.getCode(), errorCode.getMsg());
                        return;
                    }
                    return;
                }
                String sendRequest = this.c.sendRequest(this.b, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", a, null));
                if (TextUtils.isEmpty(sendRequest)) {
                    IRegister iRegister3 = this.a;
                    if (iRegister3 != null) {
                        ErrorCode errorCode2 = a.ACCS_CHECK_ERROR;
                        iRegister3.onFailure(errorCode2.getCode(), errorCode2.getMsg());
                        return;
                    }
                    return;
                }
                if (this.a != null) {
                    bVar3 = TaobaoRegister.mRequestListener;
                    bVar3.a.put(sendRequest, this.a);
                    return;
                }
                return;
            }
            if (this.a != null) {
                ErrorCode build = a.a(i, "no error msg").detail("bindApp").build();
                this.a.onFailure(build.getCode(), build.getMsg());
            }
        } catch (Throwable th) {
            ALog.e("TaobaoRegister", "register onBindApp", th, new Object[0]);
        }
    }
}
