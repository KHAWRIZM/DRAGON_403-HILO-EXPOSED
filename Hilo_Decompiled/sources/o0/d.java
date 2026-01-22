package o0;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.network.detection.NetworkDetectionStatus;
import tech.sud.gip.core.network.detection.NetworkDetectionStep;
import tech.sud.gip.core.network.detection.NetworkDetectionStepResult;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d extends WebSocketListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f١٦٤١٨a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f١٦٤١٩b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f١٦٤٢٠c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f١٦٤٢١d;

    public d(j jVar, String str, n nVar) {
        this.f١٦٤٢١d = jVar;
        this.f١٦٤١٩b = str;
        this.f١٦٤٢٠c = nVar;
    }

    public final /* synthetic */ void a() {
        if (this.f١٦٤١٨a) {
            return;
        }
        this.f١٦٤١٨a = true;
    }

    public final /* synthetic */ void b(String str, Throwable th, n nVar) {
        if (this.f١٦٤١٨a) {
            return;
        }
        this.f١٦٤١٨a = true;
        LogUtils.file("NetworkDetectionTask", "onFailure:" + str + " error:" + LogUtils.getErrorInfo(th));
        int a10 = d.a.a(th);
        String th2 = th.toString();
        NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
        networkDetectionStepResult.code = a10;
        networkDetectionStepResult.msg = th2;
        NetworkDetectionStep networkDetectionStep = nVar.f١٦٤٥٠a;
        networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
        networkDetectionStep.result = networkDetectionStepResult;
        this.f١٦٤٢١d.g(a10, th2);
    }

    public final void c(Response response, String str, n nVar) {
        String str2;
        if (!this.f١٦٤١٨a) {
            this.f١٦٤١٨a = true;
            if (response != null && response.body() != null) {
                str2 = response.body().toString();
            } else {
                str2 = null;
            }
            LogUtils.file("NetworkDetectionTask", "onOpen:" + str + " body:" + str2);
            NetworkDetectionStepResult networkDetectionStepResult = new NetworkDetectionStepResult();
            networkDetectionStepResult.code = 0;
            networkDetectionStepResult.msg = "success";
            NetworkDetectionStep networkDetectionStep = nVar.f١٦٤٥٠a;
            networkDetectionStep.status = NetworkDetectionStatus.COMPLETED;
            networkDetectionStep.result = networkDetectionStepResult;
            j jVar = this.f١٦٤٢١d;
            int i10 = jVar.f١٦٤٣٩g + 1;
            jVar.f١٦٤٣٩g = i10;
            if (i10 == jVar.f١٦٤٣٨f) {
                jVar.h();
            }
        }
    }

    public final void onClosed(WebSocket webSocket, int i10, String str) {
        super.onClosed(webSocket, i10, str);
        ThreadUtils.postUITask(new Runnable() { // from class: o0.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.a();
            }
        });
        LogUtils.file("NetworkDetectionTask", "onClosed:" + this.f١٦٤١٩b);
    }

    public final void onFailure(WebSocket webSocket, final Throwable th, Response response) {
        super.onFailure(webSocket, th, response);
        final String str = this.f١٦٤١٩b;
        final n nVar = this.f١٦٤٢٠c;
        ThreadUtils.postUITask(new Runnable() { // from class: o0.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(str, th, nVar);
            }
        });
    }

    public final void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
        LogUtils.file("NetworkDetectionTask", "onMessage:" + this.f١٦٤١٩b + " text:" + str);
    }

    public final void onOpen(WebSocket webSocket, final Response response) {
        super.onOpen(webSocket, response);
        final String str = this.f١٦٤١٩b;
        final n nVar = this.f١٦٤٢٠c;
        ThreadUtils.postUITask(new Runnable() { // from class: o0.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.c(response, str, nVar);
            }
        });
    }
}
