package b4;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.logger.ILog;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.aliyun.ams.emas.push.l;
import com.facebook.share.internal.ShareConstants;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.TaobaoRegister;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {
    public int a(Intent intent, Context context) {
        return b(intent, context, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r3v10, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v8, types: [int] */
    public int b(Intent intent, Context context, int i10) {
        String str;
        ILog iLog;
        StringBuilder sb;
        Context context2;
        String str2;
        String str3;
        String str4;
        String str5;
        Context context3;
        Context context4;
        ComponentName componentName;
        Class<?> a10 = l.a();
        if ("notification_open".equals(intent.getStringExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE))) {
            Intent intent2 = (Intent) intent.getExtras().get("realIntent");
            intent2.setFlags(335544320);
            String stringExtra = intent2.getStringExtra("msgId");
            String stringExtra2 = intent2.getStringExtra("title");
            ?? stringExtra3 = intent2.getStringExtra(AgooMessageReceiver.SUMMARY);
            String stringExtra4 = intent.getStringExtra("extData");
            String stringExtra5 = intent.getStringExtra("group");
            int intExtra = intent2.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1);
            ?? intExtra2 = intent2.getIntExtra(AgooMessageReceiver.NOTIFICATION_ID, 0);
            String stringExtra6 = intent2.getStringExtra(AgooMessageReceiver.EXTRA_MAP);
            try {
                ?? intent3 = new Intent();
                intent3.setPackage(context.getPackageName());
                intent3.setAction(AgooMessageReceiver.NOTIFICATION_OPENED_ACTION);
                intent3.putExtra(AgooMessageReceiver.MESSAGE_ID, stringExtra);
                intent3.putExtra("title", stringExtra2);
                intent3.putExtra(AgooMessageReceiver.SUMMARY, stringExtra3);
                intent3.putExtra(AgooMessageReceiver.EXTRA_MAP, stringExtra6);
                intent3.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, intExtra);
                intent3.putExtra(AgooMessageReceiver.NOTIFICATION_ID, intExtra2);
                if (!TextUtils.isEmpty(stringExtra5)) {
                    intent3.putExtra("group", stringExtra5);
                }
                intent3.setFlags(32);
                try {
                    if (a10 == null) {
                        ?? r32 = context;
                        r32.sendBroadcast(intent3, context.getPackageName() + ".AGOO");
                        stringExtra3 = r32;
                    } else {
                        Context context5 = context;
                        intent3.setClass(context5, a10);
                        IntentDispatch.dispatchIntent(context5, (Intent) intent3, a10.getName());
                        stringExtra3 = context5;
                    }
                    if (i10 == 0 && "android.intent.action.MAIN".equals(intent2.getAction()) && g.a(context)) {
                        l.f٦٨٩٨a.d("app is in front, action:" + intent2.getAction());
                    } else {
                        try {
                            if (intExtra != 4) {
                                intExtra2 = "MPS:CPushServiceListener";
                                if (intExtra == 1) {
                                    ALog.i((String) intExtra2, "open app", new Object[0]);
                                    if (i10 == 0) {
                                        if (androidx.core.content.a.checkSelfPermission(stringExtra3, "android.permission.GET_TASKS") == 0 && androidx.core.content.a.checkSelfPermission(stringExtra3, "android.permission.REORDER_TASKS") == 0) {
                                            ActivityManager activityManager = (ActivityManager) stringExtra3.getSystemService("activity");
                                            Iterator<ActivityManager.RunningTaskInfo> it = activityManager.getRunningTasks(Integer.MAX_VALUE).iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    ActivityManager.RunningTaskInfo next = it.next();
                                                    componentName = next.topActivity;
                                                    if (componentName.getPackageName().equals(context.getPackageName())) {
                                                        ALog.d((String) intExtra2, "move task to front", new Object[0]);
                                                        try {
                                                            activityManager.moveTaskToFront(next.id, 0);
                                                            break;
                                                        } catch (Throwable th) {
                                                            ALog.w((String) intExtra2, "move task to front fail", th, new Object[0]);
                                                        }
                                                    }
                                                } else {
                                                    ALog.w((String) intExtra2, "do not find corresponing running task, start app with launch activity", new Object[0]);
                                                    stringExtra3.startActivity(intent2);
                                                    break;
                                                }
                                            }
                                        } else {
                                            ALog.d((String) intExtra2, "no get tasks and reorder tasks permission, start app with launch activity", new Object[0]);
                                            stringExtra3.startActivity(intent2);
                                        }
                                    } else {
                                        ALog.w((String) intExtra2, "sdk version < 11 or start from activity, start app with launch activity", new Object[0]);
                                        stringExtra3.startActivity(intent2);
                                    }
                                } else {
                                    if (intExtra == 2) {
                                        ALog.d((String) intExtra2, "open activity", new Object[0]);
                                    } else if (intExtra == 3) {
                                        ALog.d((String) intExtra2, "open url", new Object[0]);
                                    }
                                    stringExtra3.startActivity(intent2);
                                }
                            } else {
                                try {
                                    ALog.i("MPS:CPushServiceListener", "open with no action", new Object[0]);
                                } catch (Throwable th2) {
                                    th = th2;
                                    intExtra2 = "MPS:CPushServiceListener";
                                    str2 = stringExtra4;
                                    str3 = ")";
                                    str4 = "Open msg(";
                                    context3 = stringExtra3;
                                    str5 = intExtra2;
                                    try {
                                        ALog.e(str5, "startActivity error", th, new Object[0]);
                                        l.f٦٨٩٨a.i(str4 + stringExtra + str3);
                                        context4 = context3;
                                        TaobaoRegister.clickMessage(context4, stringExtra, str2);
                                        return 0;
                                    } catch (Throwable th3) {
                                        l.f٦٨٩٨a.i(str4 + stringExtra + str3);
                                        TaobaoRegister.clickMessage(context3, stringExtra, str2);
                                        throw th3;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    l.f٦٨٩٨a.i("Open msg(" + stringExtra + ")");
                    str2 = stringExtra4;
                    context4 = stringExtra3;
                } catch (Throwable th5) {
                    th = th5;
                    context2 = stringExtra3;
                    str2 = stringExtra4;
                    str3 = ")";
                    str4 = "Open msg(";
                    str5 = "MPS:CPushServiceListener";
                    context3 = context2;
                    ALog.e(str5, "startActivity error", th, new Object[0]);
                    l.f٦٨٩٨a.i(str4 + stringExtra + str3);
                    context4 = context3;
                    TaobaoRegister.clickMessage(context4, stringExtra, str2);
                    return 0;
                }
            } catch (Throwable th6) {
                th = th6;
                context2 = context;
            }
            TaobaoRegister.clickMessage(context4, stringExtra, str2);
            return 0;
        }
        if ("notification_delete".equals(intent.getStringExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE))) {
            String stringExtra7 = intent.getStringExtra("msgId");
            intent.getStringExtra("task_id");
            String stringExtra8 = intent.getStringExtra("extData");
            try {
                Intent intent4 = new Intent();
                intent4.setPackage(context.getPackageName());
                intent4.setAction(AgooMessageReceiver.NOTIFICATION_REMOVED_ACTION);
                intent4.putExtra(AgooMessageReceiver.MESSAGE_ID, stringExtra7);
                intent4.putExtra("title", intent.getStringExtra("title"));
                intent4.putExtra(AgooMessageReceiver.SUMMARY, intent.getStringExtra(AgooMessageReceiver.SUMMARY));
                intent4.putExtra(AgooMessageReceiver.EXTRA_MAP, intent.getStringExtra(AgooMessageReceiver.EXTRA_MAP));
                intent4.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, intent.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1));
                intent4.putExtra("group", intent.getStringExtra("group"));
                intent4.setFlags(32);
                if (a10 == null) {
                    context.sendBroadcast(intent4, context.getPackageName() + ".AGOO");
                } else {
                    intent4.setClass(context, a10);
                    IntentDispatch.dispatchIntent(context, intent4, a10.getName());
                }
                iLog = l.f٦٨٩٨a;
                sb = new StringBuilder();
                str = "Delete msg(";
            } catch (Throwable th7) {
                str = "Delete msg(";
                try {
                    ALog.e("MPS:CPushServiceListener", "send intent failed.", th7, new Object[0]);
                    iLog = l.f٦٨٩٨a;
                    sb = new StringBuilder();
                } catch (Throwable th8) {
                    l.f٦٨٩٨a.i(str + stringExtra7 + ")");
                    TaobaoRegister.dismissMessage(context, stringExtra7, stringExtra8);
                    throw th8;
                }
            }
            sb.append(str);
            sb.append(stringExtra7);
            sb.append(")");
            iLog.i(sb.toString());
            TaobaoRegister.dismissMessage(context, stringExtra7, stringExtra8);
            return 0;
        }
        if ("message_open".equals(intent.getStringExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE))) {
            TaobaoRegister.clickMessage(context, intent.getStringExtra("msgId"), intent.getStringExtra("extData"));
            return 0;
        }
        if (!"message_delete".equals(intent.getStringExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE))) {
            return 0;
        }
        TaobaoRegister.dismissMessage(context, intent.getStringExtra("msgId"), intent.getStringExtra("extData"));
        return 0;
    }
}
