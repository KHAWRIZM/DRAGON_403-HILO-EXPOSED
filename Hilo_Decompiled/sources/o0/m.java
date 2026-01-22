package o0;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.network.detection.NetworkDetectionDetail;
import tech.sud.gip.core.network.detection.NetworkDetectionDetailType;
import tech.sud.gip.core.network.detection.NetworkDetectionStatus;
import tech.sud.gip.core.network.detection.NetworkDetectionStep;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m extends vf.b {

    /* renamed from: c, reason: collision with root package name */
    public final NetworkDetectionStep f١٦٤٤٩c;

    public m(NetworkDetectionStep networkDetectionStep) {
        this.f١٦٤٤٩c = networkDetectionStep;
    }

    public final void c(final NetworkDetectionDetailType networkDetectionDetailType) {
        ThreadUtils.postUITask(new Runnable() { // from class: o0.l
            @Override // java.lang.Runnable
            public final void run() {
                m.this.d(networkDetectionDetailType);
            }
        });
    }

    public final void callEnd(Call call) {
        super.callEnd(call);
        NetworkDetectionStep networkDetectionStep = this.f١٦٤٤٩c;
        if (networkDetectionStep != null) {
            networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
        }
        c(NetworkDetectionDetailType.CALL_END);
    }

    public final void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        NetworkDetectionStep networkDetectionStep = this.f١٦٤٤٩c;
        if (networkDetectionStep != null) {
            networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
        }
        c(NetworkDetectionDetailType.CALL_FAILED);
    }

    public final void callStart(Call call) {
        super.callStart(call);
        NetworkDetectionStep networkDetectionStep = this.f١٦٤٤٩c;
        if (networkDetectionStep != null) {
            networkDetectionStep.status = NetworkDetectionStatus.CHECKING;
        }
        c(NetworkDetectionDetailType.CALL_START);
    }

    public final void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        c(NetworkDetectionDetailType.CONNECT_END);
    }

    public final void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        c(NetworkDetectionDetailType.CONNECT_START);
    }

    public final /* synthetic */ void d(NetworkDetectionDetailType networkDetectionDetailType) {
        if (this.f١٦٤٤٩c != null) {
            NetworkDetectionDetail networkDetectionDetail = new NetworkDetectionDetail();
            networkDetectionDetail.timestamp = System.currentTimeMillis();
            networkDetectionDetail.type = networkDetectionDetailType;
            this.f١٦٤٤٩c.detailList.add(networkDetectionDetail);
        }
    }

    public final void dnsEnd(Call call, String str, List list) {
        super.dnsEnd(call, str, list);
        c(NetworkDetectionDetailType.DNS_END);
    }

    public final void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        c(NetworkDetectionDetailType.DNS_START);
    }

    public final void requestBodyEnd(Call call, long j10) {
        super.requestBodyEnd(call, j10);
        c(NetworkDetectionDetailType.REQUEST_BODY_END);
    }

    public final void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        c(NetworkDetectionDetailType.REQUEST_BODY_START);
    }

    public final void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        c(NetworkDetectionDetailType.REQUEST_HEADERS_END);
    }

    public final void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        c(NetworkDetectionDetailType.REQUEST_HEADERS_START);
    }

    public final void responseBodyEnd(Call call, long j10) {
        super.responseBodyEnd(call, j10);
        c(NetworkDetectionDetailType.RESPONSE_BODY_END);
    }

    public final void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        c(NetworkDetectionDetailType.RESPONSE_BODY_START);
    }

    public final void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        c(NetworkDetectionDetailType.RESPONSE_HEADERS_END);
    }

    public final void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        c(NetworkDetectionDetailType.RESPONSE_HEADERS_START);
    }

    public final void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        c(NetworkDetectionDetailType.SECURE_CONNECT_END);
    }

    public final void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        c(NetworkDetectionDetailType.SECURE_CONNECT_START);
    }
}
