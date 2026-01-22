package com.taobao.accs.dispatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.taobao.accs.messenger.a;
import com.taobao.accs.messenger.e;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.Utils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class IntentDispatch {
    public static final String TAG = "IntentDispatch";
    private static e binderDispatcher;

    public static void dispatchIntent(Context context, Intent intent, String str) {
        if (context != null && intent != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (Utils.isTarget26(applicationContext)) {
                    if (binderDispatcher == null) {
                        binderDispatcher = new e(new a(applicationContext));
                    }
                    binderDispatcher.a(str, intent);
                    return;
                } else {
                    ALog.i(TAG, "dispatchIntent start service ", new Object[0]);
                    applicationContext.startService(intent);
                    return;
                }
            } catch (Exception e) {
                ALog.e(TAG, "dispatchIntent method call with exception ", e.toString());
                e.printStackTrace();
                return;
            }
        }
        ALog.e(TAG, "dispatchIntent context or intent is null", new Object[0]);
    }

    private static Intent filterExtras(Intent intent) {
        Intent intent2 = (Intent) intent.clone();
        intent2.replaceExtras(new Bundle());
        return intent2;
    }

    private static final String printBundle(Bundle bundle, int i) {
        StringBuilder sb2 = new StringBuilder();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            for (int i2 = 0; i2 < i; i2++) {
                sb2.append('\t');
            }
            if (obj instanceof String) {
                sb2.append("String\t");
                sb2.append(str);
                sb2.append('\t');
                sb2.append(obj);
                sb2.append('\n');
            } else if (obj instanceof Integer) {
                sb2.append("int\t");
                sb2.append(str);
                sb2.append('\t');
                sb2.append(obj);
                sb2.append('\n');
            } else if (obj instanceof Long) {
                sb2.append("long\t");
                sb2.append(str);
                sb2.append('\t');
                sb2.append(obj);
                sb2.append('\n');
            } else if (obj instanceof Boolean) {
                sb2.append("boolean\t");
                sb2.append(str);
                sb2.append('\t');
                sb2.append(obj);
                sb2.append('\n');
            } else if (obj instanceof Bundle) {
                sb2.append("Bundle\t");
                sb2.append(str);
                sb2.append('\t');
                sb2.append('\n');
                sb2.append(printBundle((Bundle) obj, i + 1));
            } else {
                sb2.append("unknown\t");
                sb2.append(str);
                sb2.append('\t');
                sb2.append(obj);
                sb2.append('\n');
            }
        }
        return sb2.toString();
    }
}
