package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.push.impl.HuaweiMsgParseImpl;
import com.alibaba.sdk.android.push.impl.MeizuMsgParseImpl;
import com.alibaba.sdk.android.push.impl.OppoMsgParseImpl;
import com.alibaba.sdk.android.push.impl.VivoMsgParseImpl;
import com.alibaba.sdk.android.push.impl.XiaoMiMsgParseImpl;
import com.alibaba.sdk.android.push.register.ReporterFactory;
import com.alibaba.sdk.android.push.utils.ThreadUtil;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.agoo.BaseNotifyClickActivity;
import java.util.Iterator;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class BaseNotifyClick {
    private static final String TAG = "MPS.BaseNotifyClick";
    private Context context;
    private String msgSource;

    private void buildMessage(final Intent intent) {
        ThreadUtil.getExecutor().execute(new Runnable() { // from class: com.taobao.agoo.BaseNotifyClick.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                Intent intent2 = null;
                try {
                    Intent intent3 = intent;
                    if (intent3 != null) {
                        try {
                            str = BaseNotifyClick.this.parseMsgByThirdPush(intent3);
                        } catch (Throwable unused) {
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(BaseNotifyClick.this.msgSource)) {
                            try {
                                intent2 = ReporterFactory.getPushParser().parseMsg(BaseNotifyClick.this.context, str, BaseNotifyClick.this.msgSource);
                            } catch (Throwable unused2) {
                            }
                            if (intent2 != null) {
                                BaseNotifyClick.this.reportClickNotifyMsg(intent2);
                            } else {
                                BaseNotifyClick.this.onParseFailed(intent);
                            }
                        } else {
                            BaseNotifyClick.this.onNotPushData(intent);
                            ALog.w(BaseNotifyClick.TAG, "parseMsgFromNotifyListener null!!", "source", BaseNotifyClick.this.msgSource);
                        }
                    }
                    if (intent2 != null) {
                        try {
                            BaseNotifyClick.this.onMessage(intent2);
                        } catch (Throwable th) {
                            ALog.e(BaseNotifyClick.TAG, "onMessage", th, new Object[0]);
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        ALog.e(BaseNotifyClick.TAG, "buildMessage", th2, new Object[0]);
                        if (0 != 0) {
                            try {
                                BaseNotifyClick.this.onMessage(null);
                            } catch (Throwable th3) {
                                ALog.e(BaseNotifyClick.TAG, "onMessage", th3, new Object[0]);
                            }
                        }
                    } catch (Throwable th4) {
                        if (0 != 0) {
                            try {
                                BaseNotifyClick.this.onMessage(null);
                            } catch (Throwable th5) {
                                ALog.e(BaseNotifyClick.TAG, "onMessage", th5, new Object[0]);
                            }
                        }
                        throw th4;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseMsgByThirdPush(Intent intent) {
        String parseMsgFromIntent;
        Set<BaseNotifyClickActivity.INotifyListener> set = BaseNotifyClickActivity.notifyListeners;
        if (set != null && set.size() > 0) {
            Iterator<BaseNotifyClickActivity.INotifyListener> it = BaseNotifyClickActivity.notifyListeners.iterator();
            parseMsgFromIntent = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseNotifyClickActivity.INotifyListener next = it.next();
                String parseMsgFromIntent2 = next.parseMsgFromIntent(intent);
                if (!TextUtils.isEmpty(parseMsgFromIntent2)) {
                    this.msgSource = next.getMsgSource();
                    parseMsgFromIntent = parseMsgFromIntent2;
                    break;
                }
                parseMsgFromIntent = parseMsgFromIntent2;
            }
        } else {
            ALog.w(TAG, "no impl, try use default impl to parse intent!", new Object[0]);
            XiaoMiMsgParseImpl huaweiMsgParseImpl = new HuaweiMsgParseImpl();
            parseMsgFromIntent = huaweiMsgParseImpl.parseMsgFromIntent(intent);
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                huaweiMsgParseImpl = new XiaoMiMsgParseImpl();
                parseMsgFromIntent = huaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                huaweiMsgParseImpl = new OppoMsgParseImpl();
                parseMsgFromIntent = huaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                huaweiMsgParseImpl = new VivoMsgParseImpl();
                huaweiMsgParseImpl.setContext(this.context);
                parseMsgFromIntent = huaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                huaweiMsgParseImpl = new MeizuMsgParseImpl();
                parseMsgFromIntent = huaweiMsgParseImpl.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent)) {
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_ERROR, "parse 3push error", 0.0d);
            } else {
                this.msgSource = huaweiMsgParseImpl.getMsgSource();
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_ERROR, "parse 3push default " + this.msgSource, 0.0d);
            }
        }
        ALog.i(TAG, "parseMsgByThirdPush", "result", parseMsgFromIntent, "msgSource", this.msgSource);
        return parseMsgFromIntent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickNotifyMsg(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra3 = intent.getStringExtra("report");
            String stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = stringExtra;
            msgDO.extData = stringExtra4;
            msgDO.messageSource = stringExtra2;
            msgDO.reportStr = stringExtra3;
            msgDO.msgStatus = MessageService.MSG_ACCS_NOTIFY_CLICK;
            ALog.i(TAG, "reportClickNotifyMsg messageId:" + stringExtra + " source:" + stringExtra2 + " reportStr:" + stringExtra3 + " status:" + msgDO.msgStatus, new Object[0]);
            ReporterFactory.getPushReporter().reportPushClick(this.context, msgDO);
        } catch (Exception e) {
            ALog.e(TAG, "reportClickNotifyMsg exception: " + e, new Object[0]);
        }
    }

    public void onCreate(Context context, Intent intent) {
        ALog.i(TAG, "onCreate", new Object[0]);
        this.context = context;
        buildMessage(intent);
    }

    public abstract void onMessage(Intent intent);

    public void onNewIntent(Intent intent) {
        ALog.i(TAG, "onNewIntent", new Object[0]);
        buildMessage(intent);
    }

    public void onNotPushData(Intent intent) {
    }

    public void onParseFailed(Intent intent) {
    }
}
