package com.taobao.accs.net;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.net.ConnectException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class m implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, Message message) {
        this.b = jVar;
        this.a = message;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012b A[Catch: all -> 0x0064, TryCatch #1 {all -> 0x0064, blocks: (B:8:0x002d, B:11:0x0050, B:13:0x0056, B:35:0x0069, B:39:0x012b, B:42:0x014e, B:60:0x014d, B:72:0x00a0, B:74:0x00aa, B:75:0x00c2, B:77:0x00d5, B:69:0x00e8, B:81:0x00ff, B:79:0x0116, B:37:0x0082), top: B:7:0x002d, inners: #2, #3, #5, #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0252 A[Catch: all -> 0x01b6, TRY_LEAVE, TryCatch #4 {all -> 0x01b6, blocks: (B:44:0x015a, B:46:0x019d, B:48:0x01a9, B:49:0x01b9, B:51:0x01c8, B:52:0x01da, B:54:0x01e0, B:55:0x01ed, B:57:0x020b, B:58:0x0214, B:59:0x01d2, B:61:0x0252, B:64:0x0262, B:66:0x0283, B:82:0x029d), top: B:9:0x004e }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ILog iLog;
        ILog iLog2;
        ILog iLog3;
        ILog iLog4;
        Object obj;
        ILog iLog5;
        boolean z;
        ILog iLog6;
        Session session;
        ILog iLog7;
        ILog iLog8;
        ILog iLog9;
        int length;
        int a;
        Message message = this.a;
        if (message != null) {
            if (message.e() != null) {
                this.a.e().onTakeFromQueue();
            }
            ErrorCode errorCode = AccsErrorCode.SUCCESS;
            int a2 = this.a.a();
            try {
                iLog4 = this.b.t;
                iLog4.d(new Object[]{"sendMessage start", Constants.KEY_DATA_ID, this.a.q, "type", Message.c.b(a2)});
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (a2 != 1) {
                    obj = "status";
                    iLog5 = this.b.t;
                    iLog5.w(new Object[]{"sendMessage skip", "type", Message.c.b(a2)});
                } else {
                    Message message2 = this.a;
                    if (message2.f == null) {
                        this.b.e.a(message2, AccsErrorCode.MESSAGE_HOST_NULL);
                        obj = "status";
                    } else {
                        SessionCenter sessionCenter = SessionCenter.getInstance(this.b.i.getAppKey());
                        this.b.a(sessionCenter, this.a.f.getHost(), false);
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            session = sessionCenter.getThrowsException(this.a.f.toString(), ConnType.TypeLevel.SPDY, 60000L);
                                        } catch (ConnectException e) {
                                            errorCode = AccsErrorCode.NETWORK_INAPP_CONNECT_FAIL.copy().detail(AccsErrorCode.getAllDetails(e.getMessage())).build();
                                            session = null;
                                            if (session != null) {
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        if (UtilityImpl.g(this.b.d)) {
                                            errorCode = AccsErrorCode.NETWORK_INAPP_EXCEPTION.copy().detail(AccsErrorCode.getAllDetails(AccsErrorCode.getExceptionInfo(th2))).build();
                                        } else {
                                            errorCode = AccsErrorCode.NO_NETWORK.copy().detail(AccsErrorCode.getExceptionInfo(th2)).build();
                                        }
                                        session = null;
                                        if (session != null) {
                                        }
                                    }
                                } catch (NoAvailStrategyException e2) {
                                    errorCode = AccsErrorCode.NETWORK_INAPP_NO_STRATEGY.copy().detail(e2.getMessage()).build();
                                    session = null;
                                    if (session != null) {
                                    }
                                }
                            } catch (InvalidParameterException e3) {
                                errorCode = AccsErrorCode.NETWORK_INAPP_ARGS_INVALID.copy().detail(e3.getMessage()).build();
                                session = null;
                                if (session != null) {
                                }
                            }
                        } catch (TimeoutException e4) {
                            errorCode = AccsErrorCode.NETWORK_INAPP_TIMEOUT.copy().detail(AccsErrorCode.getAllDetails(e4.getMessage())).build();
                            session = null;
                            if (session != null) {
                            }
                        }
                        if (session != null) {
                            obj = "status";
                            if (errorCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
                                iLog8 = this.b.t;
                                iLog8.e(errorCode.toString());
                                AccsState.getInstance().b(this.b.m, AccsState.RECENT_ERRORS, Integer.valueOf(errorCode.getCodeInt()));
                            } else {
                                iLog7 = this.b.t;
                                iLog7.e("sendMessage session is null");
                                AccsState.getInstance().b(this.b.m, AccsState.RECENT_ERRORS, "send session null");
                            }
                            z = false;
                            if (!z) {
                                if (errorCode.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
                                    errorCode = AccsErrorCode.INAPP_CON_DISCONNECTED.copy().detail(AccsErrorCode.getAllDetails(null)).build();
                                }
                                if (a2 == 1) {
                                    if (this.a.g() || !this.b.a(this.a, HonorResultCode.ADVANCED_RECORD_SUCCESS)) {
                                        this.b.e.a(this.a, errorCode);
                                    }
                                    Message message3 = this.a;
                                    if (message3.R == 1 && message3.e() != null) {
                                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total_accs", 0.0d);
                                    }
                                } else {
                                    this.b.e.a(this.a, errorCode);
                                }
                            }
                            iLog6 = this.b.t;
                            iLog6.i(new Object[]{"sendMessage end", Constants.KEY_DATA_ID, this.a.b(), obj, Boolean.valueOf(z)});
                        }
                        Message message4 = this.a;
                        j jVar = this.b;
                        byte[] a3 = message4.a(jVar.d, jVar.c);
                        iLog9 = this.b.t;
                        String b = this.a.b();
                        Message message5 = this.a;
                        Integer num = message5.t;
                        URL url = message5.f;
                        if (a3 == null) {
                            length = 0;
                        } else {
                            length = a3.length;
                        }
                        obj = "status";
                        iLog9.i(new Object[]{TUIConstants.TUIChat.METHOD_SEND_MESSAGE, Constants.KEY_DATA_ID, b, "command", num, Constants.KEY_HOST, url, "len", Integer.valueOf(length), "utdid", this.b.j});
                        this.a.a(System.currentTimeMillis());
                        if (a3.length > 16384 && this.a.t.intValue() != 102) {
                            this.b.e.a(this.a, AccsErrorCode.MESSAGE_TOO_LARGE);
                        } else {
                            this.b.e.a(this.a);
                            Message message6 = this.a;
                            if (message6.c) {
                                a = -message6.d().a();
                            } else {
                                a = message6.d().a();
                            }
                            if (this.a.c) {
                                this.b.l.put(Integer.valueOf(a), this.a);
                            }
                            AccsState.getInstance().a(this.b.m, AccsState.LAST_MSG_SEND_TIME, Integer.valueOf(a));
                            session.sendCustomFrame(a, a3, 200);
                            if (this.a.e() != null) {
                                this.a.e().onSendData();
                            }
                            this.b.a(this.a.b(), this.b.i.isQuickReconnect(), this.a.S);
                            this.b.e.a(new TrafficsMonitor.a(this.a.H, GlobalAppRuntimeInfo.isAppBackground(), this.a.f.toString(), a3.length));
                        }
                    }
                }
                z = true;
                if (!z) {
                }
                iLog6 = this.b.t;
                iLog6.i(new Object[]{"sendMessage end", Constants.KEY_DATA_ID, this.a.b(), obj, Boolean.valueOf(z)});
            } catch (Throwable th3) {
                th = th3;
                try {
                    AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, this.a.H, "", this.b.c + th.toString());
                    iLog2 = this.b.t;
                    iLog2.e(TUIConstants.TUIChat.METHOD_SEND_MESSAGE, th);
                    iLog3 = this.b.t;
                    iLog3.i(new Object[]{"sendMessage end", Constants.KEY_DATA_ID, this.a.b(), "status", true});
                } catch (Throwable th4) {
                    iLog = this.b.t;
                    iLog.i(new Object[]{"sendMessage end", Constants.KEY_DATA_ID, this.a.b(), "status", true});
                    throw th4;
                }
            }
        }
    }
}
