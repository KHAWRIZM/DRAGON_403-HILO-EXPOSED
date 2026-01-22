package com.taobao.accs.net;

import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.logger.ILog;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class r implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ILog iLog;
        ILog iLog2;
        ILog iLog3;
        ErrorCode errorCode = AccsErrorCode.SUCCESS;
        try {
            SessionCenter sessionCenter = SessionCenter.getInstance(this.a.i.getAppKey());
            j jVar = this.a;
            jVar.a(sessionCenter, jVar.i.getInappHost(), false);
            Session session = null;
            try {
                try {
                    try {
                        session = sessionCenter.getThrowsException(this.a.b((String) null), ConnType.TypeLevel.SPDY, 60000L);
                    } catch (Throwable th) {
                        if (UtilityImpl.g(this.a.d)) {
                            errorCode = AccsErrorCode.NETWORK_INAPP_EXCEPTION.copy().detail(AccsErrorCode.getAllDetails(AccsErrorCode.getExceptionInfo(th))).build();
                        } else {
                            errorCode = AccsErrorCode.NO_NETWORK.copy().detail(AccsErrorCode.getExceptionInfo(th)).build();
                        }
                    }
                } catch (NoAvailStrategyException e) {
                    errorCode = AccsErrorCode.NETWORK_INAPP_NO_STRATEGY.copy().detail(e.getMessage()).build();
                } catch (InvalidParameterException e2) {
                    errorCode = AccsErrorCode.NETWORK_INAPP_ARGS_INVALID.copy().detail(e2.getMessage()).build();
                }
            } catch (ConnectException e3) {
                errorCode = AccsErrorCode.NETWORK_INAPP_CONNECT_FAIL.copy().detail(AccsErrorCode.getAllDetails(e3.getMessage())).build();
            } catch (TimeoutException e4) {
                errorCode = AccsErrorCode.NETWORK_INAPP_TIMEOUT.copy().detail(AccsErrorCode.getAllDetails(e4.getMessage())).build();
            }
            if (session != null) {
                session.ping(true);
                return;
            }
            if (errorCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
                iLog3 = this.a.t;
                iLog3.e(errorCode.toString());
                AccsState.getInstance().b(this.a.m, AccsState.RECENT_ERRORS, Integer.valueOf(errorCode.getCodeInt()));
            } else {
                iLog2 = this.a.t;
                iLog2.e("reconnect fail");
                AccsState.getInstance().b(this.a.m, AccsState.RECENT_ERRORS, "reconnect session null");
            }
            this.a.r();
        } catch (Throwable th2) {
            iLog = this.a.t;
            iLog.e(TUIConstants.TUIChat.METHOD_SEND_MESSAGE, th2);
        }
    }
}
