package com.aliyun.ams.emas.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.TaobaoBaseIntentService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AgooInnerService extends TaobaoBaseIntentService {
    private static final String a(Bundle bundle, int i10) {
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            for (int i11 = 0; i11 < i10; i11++) {
                sb.append('\t');
            }
            if (obj instanceof String) {
                sb.append("String\t");
                sb.append(str);
                sb.append('\t');
                sb.append(obj);
                sb.append('\n');
            } else if (obj instanceof Integer) {
                sb.append("int\t");
                sb.append(str);
                sb.append('\t');
                sb.append(obj);
                sb.append('\n');
            } else if (obj instanceof Long) {
                sb.append("long\t");
                sb.append(str);
                sb.append('\t');
                sb.append(obj);
                sb.append('\n');
            } else if (obj instanceof Boolean) {
                sb.append("boolean\t");
                sb.append(str);
                sb.append('\t');
                sb.append(obj);
                sb.append('\n');
            } else if (obj instanceof Bundle) {
                sb.append("Bundle\t");
                sb.append(str);
                sb.append('\t');
                sb.append('\n');
                sb.append(a((Bundle) obj, i10 + 1));
            } else {
                sb.append("unknown\t");
                sb.append(str);
                sb.append('\t');
                sb.append(obj);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    protected void onError(Context context, String str) {
        ALog.i("AgooInnerService", "onError:" + str, new Object[0]);
    }

    protected void onMessage(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("body");
        ALog.i("AgooInnerService", "onMessage:id:" + intent.getStringExtra("id") + ", task_id:" + intent.getStringExtra("task_id") + ", body:" + stringExtra, new Object[0]);
        ALog.i("AgooInnerService", a(intent.getExtras(), 1), new Object[0]);
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        intent2.setAction("com.alibaba.sdk.android.push.RECEIVE");
        intent2.setPackage(context.getPackageName());
        try {
            Class<?> a10 = l.a();
            if (a10 == null) {
                ALog.d("AgooInnerService", "Send broadcast", new Object[0]);
                context.sendBroadcast(intent2, context.getPackageName() + ".AGOO");
            } else {
                ALog.d("AgooInnerService", "Start service:" + a10.getName(), new Object[0]);
                intent2.setClass(context, a10);
                IntentDispatch.dispatchIntent(context, intent2, a10.getName());
            }
        } catch (Throwable th) {
            ALog.e("AgooInnerService", "Send message failed.", th, new Object[0]);
        }
    }

    protected void onRegistered(Context context, String str) {
        ALog.i("AgooInnerService", "onRegistered:" + str, new Object[0]);
    }

    protected void onUnregistered(Context context, String str) {
        ALog.i("AgooInnerService", "onUnregistered:" + str, new Object[0]);
    }
}
