package com.aliyun.ams.emas.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareConstants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Context f٦٨٩٢a;

    /* renamed from: b, reason: collision with root package name */
    private int f٦٨٩٣b;

    /* renamed from: c, reason: collision with root package name */
    private int f٦٨٩٤c;

    /* renamed from: d, reason: collision with root package name */
    private int f٦٨٩٥d;

    /* renamed from: e, reason: collision with root package name */
    private int f٦٨٩٦e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٦٨٩٧f = false;

    public j(Context context) {
        this.f٦٨٩٢a = context;
    }

    public void a(int i10, int i11, int i12, int i13, a aVar) {
        ALog.d("MPS:CloudPushService", "setDoNotDisturb " + i10 + CertificateUtil.DELIMITER + i11 + "-" + i12 + CertificateUtil.DELIMITER + i13, new Object[0]);
        if (i10 >= 0 && i10 <= 23 && i12 >= 0 && i12 <= 23 && i11 >= 0 && i11 <= 59 && i13 >= 0 && i13 <= 59) {
            this.f٦٨٩٧f = true;
            this.f٦٨٩٣b = i10;
            this.f٦٨٩٤c = i11;
            this.f٦٨٩٥d = i12;
            this.f٦٨٩٦e = i13;
            if (aVar != null) {
                aVar.onSuccess("");
                return;
            }
            return;
        }
        if (aVar != null) {
            ErrorCode errorCode = com.taobao.agoo.a.INVALID_ARG;
            aVar.onFailed(errorCode.getCode(), errorCode.getMsg());
        }
    }

    public void b(CPushMessage cPushMessage) {
        if (cPushMessage != null && !TextUtils.isEmpty(cPushMessage.c())) {
            if (this.f٦٨٩٢a == null) {
                ALog.e("MPS:CloudPushService", "context is null", new Object[0]);
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction(l.f٦٨٩٩b);
                intent.setClassName(this.f٦٨٩٢a.getPackageName(), MsgService.class.getName());
                intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, "message_open");
                intent.putExtra("msgId", cPushMessage.c());
                intent.putExtra("extData", cPushMessage.e());
                this.f٦٨٩٢a.startService(intent);
                return;
            } catch (Throwable th) {
                ALog.e("MPS:CloudPushService", "Click message event upload failed.", th, new Object[0]);
                return;
            }
        }
        ALog.e("MPS:CloudPushService", "message is null", new Object[0]);
    }

    public void c(boolean z10) {
        this.f٦٨٩٧f = z10;
    }

    public boolean d() {
        if (!this.f٦٨٩٧f) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        int i10 = (this.f٦٨٩٣b * 60) + this.f٦٨٩٤c;
        int i11 = (this.f٦٨٩٥d * 60) + this.f٦٨٩٦e;
        int i12 = (calendar.get(11) * 60) + calendar.get(12);
        if (i10 <= i11) {
            if (i12 < i10 || i12 > i11) {
                return false;
            }
            return true;
        }
        if (i12 < i10 && i12 > i11) {
            return false;
        }
        return true;
    }

    public void e(CPushMessage cPushMessage) {
        if (cPushMessage != null && !TextUtils.isEmpty(cPushMessage.c())) {
            if (this.f٦٨٩٢a == null) {
                ALog.e("MPS:CloudPushService", "context is null", new Object[0]);
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction(l.f٦٨٩٩b);
                intent.setClassName(this.f٦٨٩٢a.getPackageName(), MsgService.class.getName());
                intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, "message_delete");
                intent.putExtra("msgId", cPushMessage.c());
                intent.putExtra("extData", cPushMessage.e());
                this.f٦٨٩٢a.startService(intent);
                return;
            } catch (Throwable th) {
                ALog.e("MPS:CloudPushService", "Dismiss message event upload failed.", th, new Object[0]);
                return;
            }
        }
        ALog.e("MPS:CloudPushService", "message is null", new Object[0]);
    }
}
