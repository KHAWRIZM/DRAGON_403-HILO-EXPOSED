package anet.channel.a;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.fulltrace.IFullTraceAnalysis;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.qiahao.base_common.network.interceptors.LoggingInterceptor;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.analysis.fulltrace.FullTraceAnalysis;
import com.taobao.analysis.fulltrace.RequestInfo;
import com.taobao.analysis.scene.SceneIdentifier;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements IFullTraceAnalysis {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٤٦٧٣a;

    public a() {
        try {
            Class.forName("com.taobao.analysis.fulltrace.FullTraceAnalysis");
            SceneIdentifier.setContext(GlobalAppRuntimeInfo.getContext());
            this.f٤٦٧٣a = true;
        } catch (Exception unused) {
            this.f٤٦٧٣a = false;
            ALog.e("awcn.DefaultFullTraceAnalysis", "not supoort FullTraceAnalysis", null, new Object[0]);
        }
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public void commitRequest(String str, RequestStatistic requestStatistic) {
        if (this.f٤٦٧٣a && requestStatistic != null && !TextUtils.isEmpty(str)) {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.host = requestStatistic.host;
            requestInfo.bizId = requestStatistic.bizId;
            requestInfo.url = requestStatistic.url;
            requestInfo.retryTimes = requestStatistic.retryTimes;
            requestInfo.netType = requestStatistic.netType;
            requestInfo.protocolType = requestStatistic.protocolType;
            requestInfo.ret = requestStatistic.ret;
            requestInfo.isCbMain = false;
            requestInfo.isReqMain = requestStatistic.isReqMain;
            requestInfo.isReqSync = requestStatistic.isReqSync;
            requestInfo.netErrorCode = String.valueOf(requestStatistic.statusCode);
            requestInfo.pTraceId = requestStatistic.pTraceId;
            requestInfo.netReqStart = requestStatistic.netReqStart;
            requestInfo.netReqServiceBindEnd = requestStatistic.reqServiceTransmissionEnd;
            requestInfo.netReqProcessStart = requestStatistic.reqStart;
            requestInfo.netReqSendStart = requestStatistic.sendStart;
            requestInfo.netRspRecvEnd = requestStatistic.rspEnd;
            requestInfo.netRspCbDispatch = requestStatistic.rspCbDispatch;
            requestInfo.netRspCbStart = requestStatistic.rspCbStart;
            requestInfo.netRspCbEnd = requestStatistic.rspCbEnd;
            requestInfo.reqDeflateSize = requestStatistic.reqHeadDeflateSize + requestStatistic.reqBodyDeflateSize;
            requestInfo.reqInflateSize = requestStatistic.reqHeadInflateSize + requestStatistic.reqBodyInflateSize;
            requestInfo.rspDeflateSize = requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize;
            requestInfo.rspInflateSize = requestStatistic.rspHeadInflateSize + requestStatistic.rspBodyInflateSize;
            requestInfo.serverRT = requestStatistic.serverRT;
            requestInfo.sendDataTime = requestStatistic.sendDataTime;
            requestInfo.firstDataTime = requestStatistic.firstDataTime;
            requestInfo.recvDataTime = requestStatistic.recDataTime;
            FullTraceAnalysis.getInstance().commitRequest(str, LoggingInterceptor.TAG, requestInfo);
        }
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public String createRequest() {
        if (this.f٤٦٧٣a) {
            return FullTraceAnalysis.getInstance().createRequest(LoggingInterceptor.TAG);
        }
        return null;
    }

    @Override // anet.channel.fulltrace.IFullTraceAnalysis
    public anet.channel.fulltrace.b getSceneInfo() {
        if (this.f٤٦٧٣a) {
            anet.channel.fulltrace.b bVar = new anet.channel.fulltrace.b();
            bVar.f٤٧٨١b = SceneIdentifier.isUrlLaunch();
            bVar.f٤٧٨٢c = SceneIdentifier.getAppLaunchTime();
            bVar.f٤٧٨٣d = SceneIdentifier.getLastLaunchTime();
            bVar.f٤٧٨٤e = SceneIdentifier.getDeviceLevel();
            bVar.f٤٧٨٠a = SceneIdentifier.getStartType();
            bVar.f٤٧٨٥f = SceneIdentifier.getBucketInfo();
            bVar.f٤٧٨٦g = ABTestCenter.getUTABTestBucketId("networksdk");
            return bVar;
        }
        return null;
    }
}
