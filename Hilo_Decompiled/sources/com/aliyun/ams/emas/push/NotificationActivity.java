package com.aliyun.ams.emas.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NotificationActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    b4.f f٦٨٧٥a = new b4.f();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            ALog.d("MPS:NotificationActivity", " onCreate begin...action=" + action, new Object[0]);
            if (TextUtils.equals(action, l.f٦٨٩٩b)) {
                this.f٦٨٧٥a.b(intent, getApplicationContext(), 1);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String action = intent.getAction();
            ALog.d("MPS:NotificationActivity", " onNewIntent begin...action=" + action, new Object[0]);
            if (TextUtils.equals(action, l.f٦٨٩٩b)) {
                this.f٦٨٧٥a.b(intent, getApplicationContext(), 1);
            }
        }
        finish();
    }
}
